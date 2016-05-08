/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import java.util.List;

/**
 * @author Sajeesh
 * 
 * Entity class for Purchase Response;
 *
 */
public class ExternalPurchasesResponse {
	private List<Purchase> purchases;

	/**
	 * @return the purchases
	 */
	public List<Purchase> getPurchases() {
		return purchases;
	}

	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
}
