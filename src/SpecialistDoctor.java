public class SpecialistDoctor<T> extends Doctor<T> implements Reportable, Schedulable {

    private final String specialization;
    private final double specialistSurcharge;

    public SpecialistDoctor(
            T personId,
            String name,
            String phoneNumber,
            int staffId,
            double monthlySalary,
            String department,
            double consultationFee,
            int patientsSeen,
            String specialization,
            double specialistSurcharge) {

        super(personId, name, phoneNumber, staffId,
                monthlySalary, department,
                consultationFee, patientsSeen);

        if (specialization == null || specialization.isBlank()) {
            throw new IllegalArgumentException("Invalid specialization");
        }

        if (specialistSurcharge < 0 || !Double.isFinite(specialistSurcharge)) {
            throw new IllegalArgumentException("Invalid specialist surcharge");
        }

        this.specialization = specialization;
        this.specialistSurcharge = specialistSurcharge;
    }

    @Override
    public double calculateConsultationFee() {
        return super.calculateConsultationFee() + specialistSurcharge;
    }

    @Override
    public String displayStaffDetails() {
        return super.displayStaffDetails()
                + "\nSpecialization: " + specialization
                + "\nSpecialist Surcharge: " + specialistSurcharge
                + "\nTotal Consultation Fee: " + calculateConsultationFee();
    }

    @Override
    public String getRoleDescription() {
        return "Specialist Doctor";
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSpecialistSurcharge() {
        return specialistSurcharge;
    }

    @Override
    public void generateReport() {
        System.out.println("SPECIALIST DOCTOR REPORT");
        System.out.println(displayStaffDetails());
    }

    @Override
    public void scheduleAppointment(String appointmentDate) {
        if (appointmentDate == null || appointmentDate.isBlank()) {
            System.out.println("Appointment scheduling failed: invalid date.");
            return;
        }

        System.out.println("Appointment scheduled for: " + appointmentDate);
        System.out.println("Specialist: " + getSpecialization());
    }
}
