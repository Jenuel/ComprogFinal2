package prog2;


public class Citizen implements Comparable<Citizen> {
    private String fullName;
    private String email;
    private String address;
    private int age;
    private boolean isResident;
    private int district;
    private char gender;

    public Citizen(String firstName, String lastName, String email, String address, int age, boolean isResident, int district, char gender){
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.isResident = isResident;
        this.district = district;
        this.gender = gender;
    }

    @Override
    public int compareTo(Citizen o) {
        return fullName.compareTo(o.fullName);
    }

    @Override
    public String toString() {
        return String.format("%-10s\t%-20s\t%-30s\t%c\t%d\t%-15s\t%-10.2f\t%d",
                fullName, email, address, age, (isResident ? "Resident" : "Not Resident"), district, gender);
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isResident() {
        return isResident;
    }

    public char getGender() {
        return gender;
    }

    public int getDistrict() {
        return district;
    }

    public boolean equals(Object another){
        return (this.getEmail().equals(((Citizen)another).getEmail()));
    }
}

