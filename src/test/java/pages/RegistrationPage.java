package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            studentEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            pictureUpload = $("#uploadPicture"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper");


    public RegistrationPage fillFirstName(String firstName){
        firstNameInput.val(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName){
        lastNameInput.val(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String studentEmail){
        studentEmailInput.val(studentEmail);
        return this;
    }

    public RegistrationPage selectGender(String gender){
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage fillPhone(String userNumber){
        userNumberInput.val(userNumber);
        return this;
    }

    public RegistrationPage uploadPicture(String picture){
        pictureUpload.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage selectHobby (String hobby){
        hobbies.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage fillSubject(String subject1){
        subjectsInput.val(subject1).pressEnter();
        return this;
    }

    public RegistrationPage fillAddress(String address, String state, String city){
        $("#currentAddress").val(address);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        return this;
    }

    public void submitEnter(){
        $("#submit").pressEnter();
    }
}