
import components.CalendarComponent;
import org.junit.jupiter.api.Test;

import pages.OutputModalPage;
import pages.RegistrationPage;

public class FormTest {
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent birthDay = new CalendarComponent();
    OutputModalPage outputModalPage = new OutputModalPage();

    @Test
    void automationFormTest() {
        String URL = "https://demoqa.com/automation-practice-form";
        String firstName = "firstName";
        String lastName = "lastName";
        String studentEmail = "userEmail@gmail.com";
        String userNumber = "1234567890";
        String dayOfBirth = "01";
        String monthOfBirth = "April";
        String yearOfBirth = "2001";
        String picture = "TestPicture.png";
        String subject1 = "History";
        String hobby1 = "Music";
        String address = "Russia, Ufa.";
        String state = "NCR";
        String city = "Noida";
        String gender = "Female";

        registrationPage
                .openForm(URL)
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(studentEmail)
                .selectGender(gender)
                .fillPhone(userNumber);
        birthDay.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage
                .fillSubject(subject1)
                .selectHobby(hobby1)
                .uploadPicture(picture)
                .fillAddress(address, state, city)
                .submitEnter();

        outputModalPage.elementShouldHaveTextInModalWindow(address, state, city, firstName, lastName, userNumber,
                studentEmail, gender, dayOfBirth, monthOfBirth, yearOfBirth, subject1, hobby1, picture);

    }
}