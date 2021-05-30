package components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
    }
}