import models.*;
	import managers.*;
	import exceptions.*;
	import java.util.ArrayList;

public class UniversityInventorySystem {
	
	

	    public static void main(String[] args) {

	        ArrayList<Equipment> equipmentList = new ArrayList<>();
	        ArrayList<StaffMember> staffList = new ArrayList<>();

	        Equipment e1 = new Equipment("E001", "Laptop", 
	                "Dell", "Computer", 12, true);
	        StaffMember s1 = new StaffMember(1, "John", "john@uni.edu");

	        equipmentList.add(e1);
	        staffList.add(s1);

	        InventoryManager manager = new InventoryManager();

	        try {
	            manager.assignEquipment(s1, e1);
	            System.out.println("Equipment assigned successfully");
	        } catch (InventoryException ex) {
	            System.out.println(ex.getMessage());
	        }

	        InventoryReports reports =
	                new InventoryReports(equipmentList, staffList);

	        reports.generateInventoryReport();
	    }
	}


