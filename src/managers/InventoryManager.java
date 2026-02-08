package managers;

import models.Equipment;
import models.StaffMember;
import exceptions.*;

public class InventoryManager {

	    public void assignEquipment(StaffMember staff, Equipment equipment)
	            throws InventoryException {

	        if (!equipment.isAvailable()) {
	            throw new EquipmentNotAvailableException("Equipment not available");
	        }

	        if (staff.getAssignedEquipmentCount() >= 5) {
	            throw new AssignmentLimitExceededException("Assignment limit exceeded");
	        }

	        staff.addAssignedEquipment(equipment);
	        equipment.setAvailable(false);
	    }

	    public void returnEquipment(StaffMember staff, String assetId) {
	        staff.removeAssignedEquipment(assetId);
	    }

	    public double calculateMaintenanceFee(Equipment equipment, int daysOverdue) {
	        switch (equipment.getCategory()) {
	            case "Computer":
	                return daysOverdue * 5.0;
	            case "Lab":
	                return daysOverdue * 10.0;
	            default:
	                return daysOverdue * 3.0;
	        }
	    }

	    public void searchEquipment(String name) {
	        System.out.println("Searching by name: " + name);
	    }

	    public void searchEquipment(String category, boolean availableOnly) {
	        System.out.println("Searching by category: " + category);
	    }

	    public void searchEquipment(int minWarranty, int maxWarranty) {
	        System.out.println("Searching by warranty range");
	    }
	}
