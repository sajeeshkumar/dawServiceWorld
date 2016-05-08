/**
 * 
 */
package net.sajeesh.samplerest.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import net.sajeesh.samplerest.api.model.ExternalProductResponse;
import net.sajeesh.samplerest.api.model.ExternalPurchasesResponse;
import net.sajeesh.samplerest.api.model.ExternalUserResponse;
import net.sajeesh.samplerest.api.model.Purchase;
import net.sajeesh.samplerest.api.model.PurchaseVO;

/**
 * Implementation of Company service.
 * 
 * @author Sajeesh
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	/** Base URL for the external API host. **/
	private static final String API_HOST_BASE_URL = new String("http://74.50.59.155:6000/api/");

	/** Thread pool. Size kept to start with 5 as limit size for fetch is 5. **/
	private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);
	
	/** Logger object .*/
	private static final Logger LOG = Logger.getLogger(UserService.class);

	/**
	 * There is a bug in this code as the data set returned from external data
	 * source has duplicates.
	 */
	@Override
	public List<PurchaseVO> getRecentPurchases(String userName) {
		List<PurchaseVO> toRet = new ArrayList<PurchaseVO>();
		final RestTemplate restTemplate = new RestTemplate();
		ExternalPurchasesResponse response = restTemplate.getForObject(
				API_HOST_BASE_URL + "purchases/by_user/" + userName + "?limit=5", ExternalPurchasesResponse.class);

		List<Future<PurchaseVO>> futures = new ArrayList<Future<PurchaseVO>>();
		for (Purchase purchase : response.getPurchases()) {

			futures.add(THREAD_POOL.submit(new Callable<PurchaseVO>() {

				@Override
				public PurchaseVO call() throws Exception {
					ExternalPurchasesResponse response2 = restTemplate.getForObject(
							API_HOST_BASE_URL + "purchases/by_product/" + purchase.getProductId(),
							ExternalPurchasesResponse.class);
					ExternalProductResponse response3 = restTemplate.getForObject(
							API_HOST_BASE_URL + "/products/" + purchase.getProductId(), ExternalProductResponse.class);

					PurchaseVO purchaseVO = new PurchaseVO();
					purchaseVO.setId(response3.getProduct().getId());
					purchaseVO.setFace(response3.getProduct().getFace());
					purchaseVO.setPrice(response3.getProduct().getPrice());
					purchaseVO.setSize(response3.getProduct().getSize());

					for (Purchase localPurchase : response2.getPurchases()) {
						purchaseVO.getRecent().add(localPurchase.getUsername());
					}
					return purchaseVO;
				}
			}));
		}
		
		for(Future<PurchaseVO> future : futures){
				try {
					toRet.add(future.get());
				} catch (InterruptedException e) {
					LOG.error(e);
				} catch (ExecutionException e) {
					LOG.error(e);
				}
			}

		Comparator<PurchaseVO> compare = (PurchaseVO a, PurchaseVO b) -> {
			if (a.getRecent().size() < b.getRecent().size()) {
				return 1;
			} else {
				return -1;
			}
		};

		Collections.sort(toRet, compare);

		return toRet;
	}

	@Override
	public boolean isValidUser(String username) {
		boolean toRet = false;
		final RestTemplate restTemplate = new RestTemplate();
		ExternalUserResponse response = restTemplate.getForObject(API_HOST_BASE_URL + "users/" + username,
				ExternalUserResponse.class);
		if (response.getUser() != null) {
			toRet = true;
		}
		return toRet;
	}

}
