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
//public class UserRole {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private int userId;
//	private String role;
//	
//	
//	public long getId() {
//		return id;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public void setRole(String role) {
//		this.role = role;
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
//		UserRole other = (UserRole) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//	
//	
//	
//}
