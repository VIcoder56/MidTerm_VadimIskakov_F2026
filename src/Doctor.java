public class Doctor<T> extends MedicalStaff<T>{
    private final double consultationFee;
    private int patientsSeen;

    public Doctor(T personId, String name, String phoneNumber,
                  int staffId, double monthlySalary, String department,
                  double consultationFee, int patientsSeen) {

        super(personId, name, phoneNumber, staffId, monthlySalary, department);

        if (consultationFee < 0 || !Double.isFinite(consultationFee)) {
            throw new IllegalArgumentException("Invalid consultation fee");
        }

        if (patientsSeen < 0) {
            throw new IllegalArgumentException("Invalid patients count");
        }

        this.consultationFee = consultationFee;
        this.patientsSeen = patientsSeen;
    }

    @Override
    public double calculateMonthlyCompensation() {
        double bonusPerPatient = 10.0;
        return getMonthlySalary() + patientsSeen * bonusPerPatient;
    }

    public double calculateConsultationFee() {
        return consultationFee;
    }

    public double calculateConsultationFee(double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("Invalid discount");
        }

        return consultationFee * (1 - discount);
    }

    public double calculateConsultationFee(
            double discount, double additionalCharge) {

        if (additionalCharge < 0 || !Double.isFinite(additionalCharge)) {
            throw new IllegalArgumentException("Invalid additional charge");
        }

        return calculateConsultationFee(discount) + additionalCharge;
    }
}
