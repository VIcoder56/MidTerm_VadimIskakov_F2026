public class Nurse<T> extends MedicalStaff<T> {

    private final String shiftType;
    private final double shiftAllowance;

    public Nurse(
            T personId,
            String name,
            String phoneNumber,
            int staffId,
            double monthlySalary,
            String department,
            String shiftType,
            double shiftAllowance) {

        super(personId, name, phoneNumber, staffId,
                monthlySalary, department);

        if (shiftType == null || shiftType.isBlank()) {
            throw new IllegalArgumentException("Invalid shift type");
        }

        if (shiftAllowance < 0 || !Double.isFinite(shiftAllowance)) {
            throw new IllegalArgumentException("Invalid shift allowance");
        }

        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + shiftAllowance;
    }

    @Override
    public String displayStaffDetails() {
        return super.displayStaffDetails()
                + "\nShift Type: " + shiftType
                + "\nShift Allowance: " + shiftAllowance
                + "\nMonthly Compensation: " + calculateMonthlyCompensation();
    }

    @Override
    public String getRoleDescription() {
        return "Nurse";
    }

    public String getShiftType() {
        return shiftType;
    }

    public double getShiftAllowance() {
        return shiftAllowance;
    }
}