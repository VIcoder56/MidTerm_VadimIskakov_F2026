import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       CAREPOINT HOSPITAL");
        System.out.println("       MANAGEMENT SYSTEM");
        System.out.println("========================================");

        // Patient registration
        System.out.println("\nPATIENT REGISTRATION");

        Patient<String> patient1 = new Patient<>(
                "P001", "John Smith", "123456789",
                1001, 25, "Cardiology", 150.0
        );

        Patient<String> patient2 = new Patient<>(
                "P002", "Alex Brown", "987654321",
                1002, 30, "General Medicine", 100.0
        );

        System.out.println(patient1.displayPatientDetails());
        System.out.println("\n" + patient2.displayPatientDetails());

        // Method overloading
        patient1.registerPatient("John Smith", 26);
        patient2.registerPatient("Alex Brown", 31, "Neurology");

        System.out.println("\nUPDATED PATIENT DETAILS");
        System.out.println(patient1.displayPatientDetails());
        System.out.println(patient2.displayPatientDetails());

        // Doctor
        Doctor<String> doctor = new Doctor<>(
                "D001", "Dr. Michael", "111222333",
                2001, 9000.0, "Cardiology",
                150.0, 100
        );

        // Specialist Doctor
        SpecialistDoctor<String> specialist = new SpecialistDoctor<>(
                "D002", "Dr. Sarah", "444555666",
                2002, 10000.0, "Neurology",
                200.0, 80, "Neurologist", 50.0
        );

        // Nurse
        Nurse<String> nurse = new Nurse<>(
                "N001", "Emily Wilson", "777888999",
                3001, 4500.0, "Emergency",
                "Night", 1000.0
        );

        // Staff details
        System.out.println("\nDOCTOR DETAILS");
        System.out.println(doctor.displayStaffDetails());

        System.out.println("\nSPECIALIST DETAILS");
        System.out.println(specialist.displayStaffDetails());

        System.out.println("\nNURSE DETAILS");
        System.out.println(nurse.displayStaffDetails());

        // Method overloading
        System.out.println("\nCONSULTATION FEE CALCULATIONS");

        System.out.println("Standard Fee: "
                + doctor.calculateConsultationFee());

        System.out.println("Fee with 10% Discount: "
                + doctor.calculateConsultationFee(0.10));

        System.out.println("Fee with Discount and Extra Charge: "
                + doctor.calculateConsultationFee(0.10, 25.0));

        System.out.println("Specialist Fee: "
                + specialist.calculateConsultationFee());

        // Runtime polymorphism
        System.out.println("\nMONTHLY COMPENSATION");

        List<MedicalStaff<String>> staffMembers = List.of(
                doctor, specialist, nurse
        );

        for (MedicalStaff<String> staff : staffMembers) {
            System.out.println(staff.getRoleDescription());
            System.out.println("Compensation: $"
                    + staff.calculateMonthlyCompensation());
        }

        // Interfaces
        System.out.println("\nINTERFACE DEMONSTRATION");

        Reportable report = specialist;
        report.generateReport();

        Schedulable scheduler = specialist;
        scheduler.scheduleAppointment("2026-11-10");

        // Static counters
        System.out.println("\nREGISTRATION SUMMARY");

        System.out.println("Total People: "
                + Person.getPersonCount());

        System.out.println("Total Patients: "
                + Patient.getPatientCount());

        System.out.println("Total Medical Staff: "
                + MedicalStaff.getStaffCount());

        // Test cases
        System.out.println("\nTEST CASES");

        // Test 1: Patient count
        System.out.println("Test 1 - Patient Count: "
                + (Patient.getPatientCount() == 2 ? "PASS" : "FAIL"));

        // Test 2: Staff count
        System.out.println("Test 2 - Staff Count: "
                + (MedicalStaff.getStaffCount() == 3 ? "PASS" : "FAIL"));

        // Test 3: Consultation discount
        System.out.println("Test 3 - Discount Calculation: "
                + (doctor.calculateConsultationFee(0.10) == 135.0
                ? "PASS" : "FAIL"));

        // Test 4: Nurse compensation
        System.out.println("Test 4 - Nurse Compensation: "
                + (nurse.calculateMonthlyCompensation() == 5500.0
                ? "PASS" : "FAIL"));

        // Test 5: Invalid patient age
        boolean invalidAgeRejected = false;

        try {
            patient1.registerPatient("Invalid Patient", -10);
        } catch (IllegalArgumentException e) {
            invalidAgeRejected = true;
        }

        System.out.println("Test 5 - Invalid Age: "
                + (invalidAgeRejected ? "PASS" : "FAIL"));

        System.out.println("\n========================================");
        System.out.println("             END OF REPORT");
        System.out.println("========================================");
    }
}
