/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import java.util.List;

/**
 * @author Sajeesh
 * 
 * User response entity object to return as response.
 *
 */
public class UserResponse {

	private String error;
	private List<PurchaseVO> recentPurchase;
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the recentPurchase
	 */
	public List<PurchaseVO> getRecentPurchase() {
		return recentPurchase;
	}
	/**
	 * @param recentPurchase the recentPurchase to set
	 */
	public void setRecentPurchase(List<PurchaseVO> recentPurchase) {
		this.recentPurchase = recentPurchase;
	}
	
}
