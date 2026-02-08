package exceptions;

public class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}

class EquipmentNotAvailableException extends InventoryException {
    public EquipmentNotAvailableException(String msg) {
        super(msg);
    }
}

class StaffMemberNotFoundException extends InventoryException {
    public StaffMemberNotFoundException(String msg) {
        super(msg);
    }
}

class AssignmentLimitExceededException extends InventoryException {
    public AssignmentLimitExceededException(String msg) {
        super(msg);
    }
}

