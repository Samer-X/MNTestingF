package tests;


import com.github.javafaker.Faker;
import data.ExcelReader;
import data.JsonDataReader;
import data.LoadProperties;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTest extends TestBase {

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;

    // to load form properties file
    String firstName = LoadProperties.useData.getProperty("firstName");
    String lastName = LoadProperties.useData.getProperty("lastName");


// using data provider to pass more than one parameter to the same test case like the scenario outline
/*    @DataProvider(name = "testData")
    public static Object[][] userData() {
        return new Object[][]{
                {"firstName", "lastName", "test@automation.com", "Test1234"},
                {"firstName2", "lastName2", "test2@automation.com", "Test1234"}
        };
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
    public void userRegisterSuccessfullyUsingDataProvider(String fName, String lName, String email, String password) {
        homePage = new HomePage(driver);
        homePage.openRegisterPage(fName);
        homePage.openRegisterPage(lName);
        homePage.openRegisterPage(email);
        homePage.openRegisterPage(password);
    }*/

    //----------------------------------------------------------------------------------

/*    // using data provider to pass more than one parameter from excel to the same test case like the scenario outline
    @DataProvider(name = "ExcelData")
    public Object[][] userRegistrationData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelData();
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void userRegisterSuccessfullyUsingDataProvider(String fName, String lName, String email, String password) {
        homePage = new HomePage(driver);
        homePage.openRegisterPage(fName);
        homePage.openRegisterPage(lName);
        homePage.openRegisterPage(email);
        homePage.openRegisterPage(password);
    }*/

    @Test(priority = 1, alwaysRun = true)
    public void userRegisterSuccessfully() throws IOException, ParseException {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        System.out.println(firstName);
        System.out.println(lastName);
        ExcelReader excelReader = new ExcelReader();
        System.out.println(excelReader.getExcelData()[0][0]);

        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.jsonReader();

        Faker fakeData = new Faker();
        System.out.println(fakeData.leagueOfLegends().champion());

    }
}
