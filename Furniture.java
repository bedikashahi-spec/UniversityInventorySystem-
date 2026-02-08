package models;

public class Furniture  extends InventoryItem{
	
 private String roomNumber;
 private String material;
 
 public Furniture(String id, String name, boolean isAvailable, String roomNumber, String material) {
	 super(id, name, isAvailable);
	 this.roomNumber = roomNumber;
	 this.material = material;
 }
 
 public String getItemType() {
	 return "Furniture";
 }
  public String toString() {
	  return super.toString() +
			  ", Room Number: " + roomNumber +
			  ", Material: " + material;
  }
}
