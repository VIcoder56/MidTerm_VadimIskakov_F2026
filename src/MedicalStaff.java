public abstract class MedicalStaff<T> extends Person<T> {
    private final int staffId;
    private String department;
    private double monthlySalary;
    private static int staffCount = 0;

    public MedicalStaff(T personId, String name, String phoneNumber, int staffId, double monthlySalary, String department) {
        super(personId, name, phoneNumber);

        this.staffId = staffId;
        this.department = department;
        this.monthlySalary = monthlySalary;

        staffCount++;
    }

    public static int getStaffCount(){
        return staffCount;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public abstract double calculateMonthlyCompensation();

    public String displayStaffDetails() {
        return super.displayBasicDetails()
                + "\nStaff ID: " + staffId
                + "\nDepartment: " + department
                + "\nMonthly Salary: " + monthlySalary;
    }

    @Override
    public String getRoleDescription() {
        return "MedicalStuff";
    }
}
