package testData;

public class SignupData {
    public String userName;
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String address;
    public String state;
    public String city;
    public String zipCode;
    public String mobileNumber;

    public SignupData() {
        this.userName = TestDataGenerator.randomName();
        this.email = TestDataGenerator.randomEmail();
        this.password = TestDataGenerator.randomPassword();
        this.firstName = TestDataGenerator.randomName();
        this.lastName = TestDataGenerator.randomName();
        this.address = TestDataGenerator.randomAddress();
        this.state = TestDataGenerator.randomCountry();
        this.city = TestDataGenerator.randomCity();
        this.zipCode = TestDataGenerator.randomZip();
        this.mobileNumber = TestDataGenerator.randomMobile();
    }
}
