package org.elevenfifty.java301.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(max = 100)
	private String productName;
	
	@Size(max = 45)
	private String productCondition;
	
	
	private int productPrice;
	
	
	private int productYear;
	
	//generated for ID

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public int getProductYear() {
		return productYear;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductYear(int productYear) {
		this.productYear = productYear;
	}
	
	
}
