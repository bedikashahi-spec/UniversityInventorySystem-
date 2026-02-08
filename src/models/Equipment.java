package models;
import java.util.Objects;

public class Equipment {
 private String assetId;
 private String name;
 private String brand;
 private boolean isAvailable;
 private String category;
 
 public Equipment(String assetId, String name, String brand, boolean isAvailable, String category) {
	 this.assetId = assetId;
	 this.name = name;
	 this.brand = brand;
	 this.isAvailable = isAvailable;
	 this.category = category;
	 }
 public String getAssetId() {
	 return assetId;
 }
 
public void setAssetId(String assetId) {
	this.assetId = assetId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}
public String toString() {
	return "Asset ID: " +assetId +
			", Name: " + name +
			", Brand: " + brand +
			", Available: " + isAvailable +
			", Category: " + category;
}
 public boolean equals(Object obj) {
	 if (this == obj) return true;
	 if (obj == null || getClass() != obj.getClass()) return false;
	 
	 Equipment other = (Equipment) obj;
	 return assetId.equals(other.assetId);
 }
 public int hashCode() {
	return Objects.hash(assetId);
 } 
}
