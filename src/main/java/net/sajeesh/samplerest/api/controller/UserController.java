/**
 * 
 */
package net.sajeesh.samplerest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.sajeesh.samplerest.api.exception.ServiceException;
import net.sajeesh.samplerest.api.model.Purchase;
import net.sajeesh.samplerest.api.model.PurchaseVO;
import net.sajeesh.samplerest.api.model.UserResponse;
import net.sajeesh.samplerest.api.service.UserService;

/**
 * 
 * Front controller that handles all the REST API calls associated with model
 * Company.
 * 
 * @author Sajeesh
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Handler method to get list of popular purchases that were bought by other
	 * users.
	 * 
	 * @param id
	 *            username to search for.
	 * @return the list of popular purchases or not found.
	 */
	@RequestMapping(value = "/api/recent_purchases/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Cacheable("recentPurchasesCache")
	public ResponseEntity<UserResponse> getRecentPurchases(@PathVariable("username") String userName) {
		ResponseEntity<UserResponse> toRet = null;
		UserResponse response = new UserResponse();
		if (!userService.isValidUser(userName)) {
			response.setError("User with username of " + userName + " not found");
		} else {
			final List<PurchaseVO> purchases = userService.getRecentPurchases(userName);
			response.setRecentPurchase(purchases);
			toRet = new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		}
		toRet = new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		return toRet;
	}
}
