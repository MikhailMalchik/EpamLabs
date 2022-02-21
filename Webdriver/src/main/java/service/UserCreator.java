package service;
import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty() {
        return new User("misha.malchik2000@gmail.com",
                "f8g7e6b1f7q");
    }

    public static User withEmptyEmail() { return new User("",TestDataReader.getTestData(TESTDATA_USER_PASSWORD)); }

    public static User withEmptyPassword() { return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),""); }


}
