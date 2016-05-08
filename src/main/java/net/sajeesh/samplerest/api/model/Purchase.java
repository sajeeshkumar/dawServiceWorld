/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class for Company domain data.
 * 
 * @author Sajeesh
 *
 */
public class Purchase {

	private int id;
	private int productId;
	private String username;
	private Date date;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
