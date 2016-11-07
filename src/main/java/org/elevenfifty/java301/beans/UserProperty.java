//package org.elevenfifty.java301.beans;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="users")
//
//public class UserProperty {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private int userId;
//	private String propName;
//	private String propValue;
//	
//	
//	public long getId() {
//		return id;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public String getPropName() {
//		return propName;
//	}
//	public String getPropValue() {
//		return propValue;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public void setPropName(String propName) {
//		this.propName = propName;
//	}
//	public void setPropValue(String propValue) {
//		this.propValue = propValue;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserProperty other = (UserProperty) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//	
//	
//	
//	
//	
//	
//	
//}
