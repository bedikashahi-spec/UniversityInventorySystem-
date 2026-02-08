package models;

public class StaffMember {
 private int staffId;
 private String name;
 private String email;
 private Equipment[] assignedEquipment;
 private int equipmentCount;
 
  public StaffMember(int staffId, String name, String email) {
	  this.staffId = staffId;
	  this.name = name;
	  this.email = email;
	  this.assignedEquipment = new Equipment[5];
	  this.equipmentCount = 0;
  }
  public int getStaffId() {
	  return staffId;
  }
   public void setStaffId(int staffId) {
	   this.staffId = staffId;
   }
   public String getName() {
	   return name;
   }
    public void setName(String name) {
    	this.name = name;
    }
    public String getEmail() {
    	return email;
    }
     public void setEmail(String email) {
    	 this.email = email;
     }
      public Equipment[] getAssignedEquipment() {
    	  return assignedEquipment;
      }
      public boolean addAssignedEquipment(Equipment equipment) {
    	  if (equipmentCount < assignedEquipment.length) {
    		  assignedEquipment[equipmentCount] = equipment;
    		  equipmentCount++;
    		  return true;
    	  }
    	  return false;
      }
      public boolean removeAssignedEquipment(String assetId) {
    	  for(int i = 0; i< equipmentCount; i++) {
    		  if (assignedEquipment[i].getAssetId().equals(assetId)) {
    			  for (int j = i; j < equipmentCount - 1; j++) {
    				  assignedEquipment[j] = assignedEquipment[j + 1];
    			  }
    			  assignedEquipment[equipmentCount - 1] = null;
    			  equipmentCount--;
    			  return true;
    		  }
    	  }
    	  return false;
      }
      public int getAssignedEquipmentCount() {
    	  return equipmentCount;
      }
	  public String getDepartment() {

		return null;
	  }
}
