public abstract class Person<T> {
    private final T personId;
    private String name;
    private String phoneNumber;
    private static int personCount = 0;

    public Person(T personId, String name, String phoneNumber) {
        if (personId == null || name == null || name.isBlank()
                || phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid person details");
        }

        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;

        personCount++;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public T getPersonId() {
        return personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String displayBasicDetails() {
        return "Person ID: " + personId
                + "\nName: " + name
                + "\nPhone Number: " + phoneNumber;
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return displayBasicDetails()
                + "\nRole: " + getRoleDescription();
    }
}
