/**
 * 
 */
package net.sajeesh.samplerest.api.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kuttan
 *
 */
public class PurchaseVO {

	private int id;
	private String face;
	private int price;
	private int size;
	private Set<String> recent;
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
	 * @return the face
	 */
	public String getFace() {
		return face;
	}
	/**
	 * @param face the face to set
	 */
	public void setFace(String face) {
		this.face = face;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the recent
	 */
	public Set<String> getRecent() {
		if(recent == null){
			recent = new HashSet<String>();
		}
		return recent;
	}
	/**
	 * @param recent the recent to set
	 */
	public void setRecent(Set<String> recent) {
		this.recent = recent;
	}
	
}
