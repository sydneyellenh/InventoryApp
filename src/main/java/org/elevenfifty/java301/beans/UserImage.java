//package org.elevenfifty.java301.beans;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.util.Base64Utils;
//
//@Entity
//@Table(name="user_images")
//public class UserImage {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private long userId;
//	private byte[] image;
//	private String contentType;
//	
//	
//	public long getId() {
//		return id;
//	}
//	public long getUserId() {
//		return userId;
//	}
//	public byte[] getImage() {
//		return image;
//	}
//	public String getContentType() {
//		return contentType;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
//	public void setContentType(String contentType) {
//		this.contentType = contentType;
//	}
//	
//	
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
//		UserImage other = (UserImage) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//	
//	public String getHtmlSrc() {
//        return "data:" + this.contentType + ";base64," + Base64Utils.encodeToString(image);
//    }
//	
//	
//}
