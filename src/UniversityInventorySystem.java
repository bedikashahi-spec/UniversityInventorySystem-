import models.*;
	import managers.*;
	import exceptions.*;
import java.util.Scanner;
	import java.util.ArrayList;

public class UniversityInventorySystem {
	




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Equipment> equipmentList = new ArrayList<>();
        ArrayList<StaffMember> staffList = new ArrayList<>();

        InventoryManager manager = new InventoryManager(equipmentList);
        InventoryReports reports = new InventoryReports(equipmentList, staffList);

        int choice;

        do {
            System.out.println("\n=== University Inventory System ===");
            System.out.println("1. Add New Equipment");
            System.out.println("2. Register New Staff Member");
            System.out.println("3. Assign Equipment");
            System.out.println("4. Return Equipment");
            System.out.println("5. Search Inventory");
            System.out.println("6. Generate Reports");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            try {
                switch (choice) {

                    
                    case 1:
                        System.out.print("Enter equipment ID: ");
                        String id = sc.nextLine();

                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        System.out.print("Enter warranty months: ");
                        int warranty = sc.nextInt();
                        sc.nextLine();

                        Equipment e = new Equipment(
                                id, name, category, qty, warranty);

                        equipmentList.add(e);
                        System.out.println("Equipment added.");
                        break;

                    
                    case 2:
                        System.out.print("Enter staff ID: ");
                        int staffId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter name: ");
                        String staffName = sc.nextLine();

                        System.out.print("Enter department: ");
                        String dept = sc.nextLine();

                        StaffMember staff =
                                new StaffMember(staffId, staffName, dept);

                        staffList.add(staff);
                        System.out.println("Staff registered.");
                        break;

    
                    case 3:
                        System.out.print("Enter staff ID: ");
                        int sId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter equipment ID: ");
                        String eqId = sc.nextLine();

                        StaffMember foundStaff = null;
                        Equipment foundEquip = null;

                        for (StaffMember s : staffList) {
                            if (s.getId() == sId) {
                                foundStaff = s;
                                break;
                            }
                        }

                        for (Equipment eq : equipmentList) {
                            if (eq.getId().equals(eqId)) {
                                foundEquip = eq;
                                break;
                            }
                        }

                        manager.assignEquipment(foundStaff, foundEquip);
                        break;

            
                    case 4:
                        System.out.print("Enter staff ID: ");
                        int rsId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter equipment ID: ");
                        String rEqId = sc.nextLine();

                        StaffMember returnStaff = null;

                        for (StaffMember s : staffList) {
                            if (s.getId() == rsId) {
                                returnStaff = s;
                                break;
                            }
                        }

                        manager.returnEquipment(returnStaff, rEqId);
                        break;

                
                    case 5:
                        System.out.print("Enter equipment name: ");
                        String searchName = sc.nextLine();

                        ArrayList<Equipment> results =
                                manager.searchEquipment(searchName);

                        if (results.isEmpty()) {
                            System.out.println("No equipment found.");
                        } else {
                            for (Equipment item : results) {
                                System.out.println(item);
                            }
                        }
                        break;

                    
                    case 6:
                        reports.generateInventoryReport();
                        reports.findExpiredWarranties();
                        reports.displayAssignmentsByDepartment();
                        reports.calculateUtilisationRate();
                        reports.generateMaintenanceSchedule();
                        break;

                    
                    case 7:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InventoryException e) {
                
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }

        } while (choice != 7);

        sc.close();
    }
}
