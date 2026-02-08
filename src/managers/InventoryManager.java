import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Equipment> equipmentList = new ArrayList<>();

    public InventoryManager(ArrayList<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }


    public void assignEquipment(StaffMember staff, Equipment equipment)
            throws InventoryException {

        validateAssignment(staff, equipment);

        if (equipment.isAvailable()) {
            equipment.assignOne();
            staff.assignEquipment(equipment);
            System.out.println("Equipment assigned to " + staff.getName());
        } else {
            throw new EquipmentNotAvailableException(
                    "Equipment not available: " + equipment.getName());
        }
    }

    public void returnEquipment(StaffMember staff, String assetId)
            throws InventoryException {

        if (staff == null) {
            throw new StaffMemberNotFoundException("Staff not found.");
        }

        Equipment found = null;

        for (Equipment e : equipmentList) {
            if (e.getId().equals(assetId)) {
                found = e;
                break;
            }
        }

        if (found == null) {
            throw new EquipmentNotAvailableException("Equipment not found.");
        }

        found.returnOne();
        System.out.println("Equipment returned: " + found.getName());
    }


    public double calculateMaintenanceFee(Equipment equipment, int daysOverdue) {

        double feePerDay;

        switch (equipment.getCategory()) {
            case "Computer":
                feePerDay = 5.0;
                break;

            case "Furniture":
                feePerDay = 2.0;
                break;

            case "Electronics":
                feePerDay = 4.0;
                break;

            default:
                feePerDay = 3.0;
                break;
        }

        return feePerDay * daysOverdue;
    }




    public ArrayList<Equipment> searchEquipment(String name) {
        ArrayList<Equipment> result = new ArrayList<>();

        for (Equipment e : equipmentList) {
            if (e.getName().equalsIgnoreCase(name)) {
                result.add(e);
            }
        }
        return result;
    }

    public ArrayList<Equipment> searchEquipment(String category, boolean availableOnly) {
        ArrayList<Equipment> result = new ArrayList<>();

        for (Equipment e : equipmentList) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                if (!availableOnly || e.isAvailable()) {
                    result.add(e);
                }
            }
        }
        return result;
    }

    
    public ArrayList<Equipment> searchEquipment(int minWarranty, int maxWarranty) {
        ArrayList<Equipment> result = new ArrayList<>();

        for (Equipment e : equipmentList) {
            int warranty = e.getWarrantyYears();
            if (warranty >= minWarranty && warranty <= maxWarranty) {
                result.add(e);
            }
        }
        return result;
    }

    
    public void validateAssignment(StaffMember staff, Equipment equipment)
            throws InventoryException {

        if (staff == null) {
            throw new StaffMemberNotFoundException("Staff member not found.");
        } else {
            if (equipment == null) {
                throw new EquipmentNotAvailableException("Equipment does not exist.");
            } else {
                if (!equipment.isAvailable()) {
                    throw new EquipmentNotAvailableException(
                            "Equipment is not available.");
                } else {
                    if (staff.getAssignedCount() >= staff.getMaxEquipment()) {
                        throw new AssignmentLimitExceededException(
                                "Staff assignment limit exceeded.");
                    }
                }
            }
        }
    }
}
