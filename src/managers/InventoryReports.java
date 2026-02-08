import java.util.ArrayList;

public class InventoryReports {

    private ArrayList<Equipment> equipmentList;
    private ArrayList<StaffMember> staffList;

    public InventoryReports(ArrayList<Equipment> equipmentList,
                            ArrayList<StaffMember> staffList) {
        this.equipmentList = equipmentList;
        this.staffList = staffList;
    }

    
    public void generateInventoryReport() {
        System.out.println("=== Inventory Report ===");

        for (int i = 0; i < equipmentList.size(); i++) {
            Equipment e = equipmentList.get(i);
            String status = e.isAvailable() ? "Available" : "Assigned";

            System.out.println(
                    e.getId() + " | " +
                    e.getName() + " | " +
                    e.getCategory() + " | " +
                    status
            );
        }
    }


    public void findExpiredWarranties() {
        System.out.println("=== Expired Warranty Equipment ===");

        int i = 0;
        while (i < equipmentList.size()) {
            Equipment e = equipmentList.get(i);

            if (e.getWarrantyMonths() == 0) {
                System.out.println(
                        e.getName() + " (ID: " + e.getId() + ") - Warranty expired"
                );
            }
            i++;
        }
    }

    
    public void displayAssignmentsByDepartment() {
        System.out.println("=== Assignments by Department ===");

        for (StaffMember staff : staffList) {
            System.out.println("Department: " + staff.getDepartment());
            System.out.println("Staff: " + staff.getName());

            for (Equipment e : staff.getAssignedEquipment()) {
                System.out.println("  - " + e.getName());
            }
        }
    }


    public void calculateUtilisationRate() {
        System.out.println("=== Utilisation Rate ===");

        int totalEquipment = equipmentList.size();
        int assignedCount = 0;

        for (StaffMember staff : staffList) {
            for (Equipment e : staff.getAssignedEquipment()) {
                assignedCount++;
            }
        }

        double utilisationRate = 0;

        if (totalEquipment > 0) {
            utilisationRate =
                    ((double) assignedCount / totalEquipment) * 100;
        }

        System.out.println("Total Equipment: " + totalEquipment);
        System.out.println("Assigned Equipment: " + assignedCount);
        System.out.println("Utilisation Rate: " +
                String.format("%.2f", utilisationRate) + "%");
    }


    public void generateMaintenanceSchedule() {
        System.out.println("=== Maintenance Schedule ===");

        int i = 0;

        if (equipmentList.size() == 0) {
            System.out.println("No equipment available.");
            return;
        }

        do {
            Equipment e = equipmentList.get(i);

            if (e.getWarrantyMonths() <= 6) {
                System.out.println(
                        "Schedule maintenance for: " + e.getName() +
                        " (Warranty months left: " + e.getWarrantyMonths() + ")"
                );
            }

            i++;
        } while (i < equipmentList.size());
    }
}
