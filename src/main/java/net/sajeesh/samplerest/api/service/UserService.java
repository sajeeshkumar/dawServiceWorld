/**
 * 
 */
package net.sajeesh.samplerest.api.service;

import java.util.List;

import net.sajeesh.samplerest.api.model.PurchaseVO;

/**
 * Interface file that defines all methods related to CRUD operations
 * on Company.
 * 
 * @author Sajeesh
 *
 */
public interface UserService {

	/**
	 * get all recent purchases and attach list of users who have
	 * bought the same product.
	 * @return list of all rec.ent purchases
	 **/
	public List<PurchaseVO> getRecentPurchases(final String userName);
	
	/**
	 * Return if valid user.
	 * @param username username to check
	 * @return true if found else not.
	 */
	public boolean isValidUser(String username);
}
