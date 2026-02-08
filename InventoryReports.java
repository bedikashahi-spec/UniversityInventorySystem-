package managers;

import java.util.ArrayList;
import models.Equipment;
import models.StaffMember;

public class InventoryReports {

    private ArrayList<Equipment> equipmentList;
    private ArrayList<StaffMember> staffList;

    public InventoryReports(ArrayList<Equipment> equipmentList,
                            ArrayList<StaffMember> staffList) {
        this.equipmentList = equipmentList;
        this.staffList = staffList;
    }

    public void generateInventoryReport() {
        for (int i = 0; i < equipmentList.size(); i++) {
            System.out.println(equipmentList.get(i));
        }
    }

    public void findExpiredWarranties() {
        int i = 0;
        while (i < equipmentList.size()) {
            Equipment e = equipmentList.get(i);
            if (e.getWarrantyMonths() == 0) {
                System.out.println("Expired: " + e.getName());
            }
            i++;
        }
    }

    public void displayAssignmentsByDepartment() {
        for (StaffMember s : staffList) {
            System.out.println("Staff: " + s.getName());
        }
    }

    public void calculateUtilisationRate() {
        for (StaffMember s : staffList) {
            for (int i = 0; i < s.getAssignedEquipmentCount(); i++) {
                System.out.println("Utilised equipment");
            }
        }
    }

    public void generateMaintenanceSchedule() {
        int i = 0;
        do {
            if (i < equipmentList.size()) {
                System.out.println("Maintenance check: " +
                        equipmentList.get(i).getName());
            }
            i++;
        } while (i < equipmentList.size());
    }
}




