public class Patient<T> extends Person<T>{
    private final int patientNumber;
    private int age;
    private String medicalDepartment;
    private double consultationFee;
    private static int patientCount = 0;

    public Patient(T personId, String name, String phoneNumber, int patientNumber, int age, String medicalDepartment, double consultationFee) {
        super(personId, name, phoneNumber);

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }

        if (medicalDepartment == null || medicalDepartment.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        if (consultationFee < 0 || !Double.isFinite(consultationFee)) {
            throw new IllegalArgumentException("Invalid consultation fee");
        }

        this.patientNumber = patientNumber;
        this.age = age;
        this.medicalDepartment = medicalDepartment;
        this.consultationFee = consultationFee;

        patientCount++;
    }

    public static int getPatientCount() {
        return patientCount;
    }

    public String displayPatientDetails() {
        return "Patient number: " + patientNumber
                + "\nAge: " + age
                + "\nMedical Department: " + medicalDepartment
                + "\nConsultation Fee: " + consultationFee;
    }

    @Override
    public String getRoleDescription() {
        return "Patient";
    }

    public void registerPatient(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }

        setName(name);
        this.age = age;
    }

    public void registerPatient(String name, int age, String medicalDepartment) {
        if (medicalDepartment == null || medicalDepartment.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        registerPatient(name, age);
        this.medicalDepartment = medicalDepartment;
    }
}
