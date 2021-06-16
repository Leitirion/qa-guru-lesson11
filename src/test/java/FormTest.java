
import com.github.javafaker.Faker;
import components.CalendarComponent;
import org.junit.jupiter.api.Test;

import pages.OutputModalPage;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class FormTest {
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent birthDay = new CalendarComponent();
    OutputModalPage outputModalPage = new OutputModalPage();
    Faker faker = new Faker();

    @Test
    void automationFormTest() {
        String URL = "https://demoqa.com/automation-practice-form",
        firstName = faker.name().firstName(),
         lastName = faker.name().lastName(),
         studentEmail = faker.internet().emailAddress(),
         userNumber = faker.number().digits(10),
         dayOfBirth = "01",
         monthOfBirth = "April",
         yearOfBirth = "2001",
         picture = "TestPicture.png",
         subject1 = "History",
         hobby1 = "Music",
         address = faker.address().fullAddress(),
         state = "NCR",
         city = "Noida",
         gender = "Female";

        step("Open page", () -> {
            registrationPage.openForm(URL);
        });

        step("Fill common data", () -> {
            registrationPage
                    .fillFirstName(firstName)
                    .fillLastName(lastName)
                    .fillEmail(studentEmail)
                    .selectGender(gender)
                    .fillPhone(userNumber);
        });

        step("Set birthday", () -> {
            birthDay.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        });

        step("Set subjects and hobby", () -> {
            registrationPage
                    .fillSubject(subject1)
                    .selectHobby(hobby1)
                    .uploadPicture(picture)
                    .fillAddress(address, state, city);
        });

        step("Submit form", () -> {
            registrationPage.submitEnter();
        });

        step("Verify successful form submit", () -> {
            outputModalPage.elementShouldHaveTextInModalWindow(address, state, city, firstName, lastName, userNumber,
                    studentEmail, gender, dayOfBirth, monthOfBirth, yearOfBirth, subject1, hobby1, picture);
        });
    }
}