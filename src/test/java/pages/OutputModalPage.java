package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.text;

public class OutputModalPage {

    public void elementShouldHaveText(String row, String value){
        $x(String.format("//div[@class=\"modal-content\"]//tbody//tr[.//td[1][text()=\"%s\"]]/td[2]",row)).shouldHave(text(value));
    }

    public void elementShouldHaveTextInModalWindow(String address, String state, String city, String firstName, String lastName, String userNumber,
                                                   String studentEmail, String gender, String dayOfBirth, String monthOfBirth, String yearOfBirth,
                                                   String subject1, String hobby1, String picture){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        elementShouldHaveText("Student Name",firstName + " " + lastName);
        elementShouldHaveText("Mobile",userNumber);
        elementShouldHaveText("Student Email",studentEmail);
        elementShouldHaveText("Gender",gender);
        elementShouldHaveText("Date of Birth",dayOfBirth +"  " + monthOfBirth + "," + yearOfBirth);
        elementShouldHaveText("Subjects",subject1);
        elementShouldHaveText("Hobbies",hobby1);
        elementShouldHaveText("Picture",picture);
        elementShouldHaveText("Address",address);
        elementShouldHaveText("State and City",state + " " + city);
    }
}



