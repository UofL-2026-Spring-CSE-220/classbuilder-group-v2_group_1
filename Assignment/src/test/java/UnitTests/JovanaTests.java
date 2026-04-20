package UnitTests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JovanaTests {

    // ─────────────────────────────────────────────
    // DateRecord Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("DateRecord rejects February 29 on a non-leap year")
    public void dateRecordRejectsNonLeapFeb29() {
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(29, MonthsEnum.FEBRUARY, 2019));
    }

    @Test
    @DisplayName("DateRecord MONTH_DD_YYYY format pads single-digit day with leading zero")
    public void dateRecordMonthFormatPadsSingleDigitDay() {
        DateRecord date = new DateRecord(3, MonthsEnum.JUNE, 2000);
        assertEquals("June 03, 2000", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }

    @Test
    @DisplayName("DateRecord builder with MonthsEnum produces correct MM/DD/YYYY string")
    public void dateRecordBuilderWithMonthsEnumFormatsCorrectly() {
        DateRecord date = new DateRecord.Builder()
                .setDay(12)
                .setMonth(MonthsEnum.NOVEMBER)
                .setYear(1999)
                .build();
        assertEquals("11/12/1999", date.toString());
    }

    @Test
    @DisplayName("DateRecord rejects day 0 as invalid")
    public void dateRecordRejectsDayZero() {
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(0, MonthsEnum.JANUARY, 2020));
    }

    // ─────────────────────────────────────────────
    // PersonInfo Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("PersonInfo with middle name includes it in toString")
    public void personInfoWithMiddleNameIncludesItInToString() {
        DateRecord dob = new DateRecord(10, MonthsEnum.APRIL, 1995);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Maria")
                .setMiddleName("Elena")
                .setLastName("Garcia")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.MEXICO)
                .build();
        assertTrue(person.toString().contains("Middle Name"));
        assertTrue(person.toString().contains("Elena"));
    }

    @Test
    @DisplayName("PersonInfo country of residence and birth can be different")
    public void personInfoDifferentCountriesAreAllowed() {
        DateRecord dob = new DateRecord(1, MonthsEnum.MARCH, 1990);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Ana")
                .setLastName("Lopez")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.MEXICO)
                .build();
        assertNotEquals(person.countryOfResidence(), person.countryOfBirth());
    }

    @Test
    @DisplayName("PersonInfo throws exception for null date of birth")
    public void personInfoThrowsForNullDateOfBirth() {
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo("Jane", null, "Doe", null, CountriesEnum.US, CountriesEnum.US));
    }

    // ─────────────────────────────────────────────
    // StudentRecord Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("StudentRecord toString with tab level 1 indents correctly")
    public void studentRecordToStringWithTabLevelOne() {
        DateRecord dob = new DateRecord(5, MonthsEnum.MAY, 2002);
        DateRecord enrollment = new DateRecord(1, MonthsEnum.SEPTEMBER, 2021);
        PersonInfo student = new PersonInfo("Jovana", null, "Hernandez", dob, CountriesEnum.US, CountriesEnum.US);
        StudentRecord record = new StudentRecord(student, "JH1234567", null, null, enrollment);
        String result = record.toString(1);
        assertTrue(result.startsWith("\tStudent ID:"));
    }

    @Test
    @DisplayName("StudentRecord father and mother appear in toString when set")
    public void studentRecordParentsAppearInToString() {
        DateRecord dob = new DateRecord(1, MonthsEnum.JANUARY, 2000);
        DateRecord parentDob = new DateRecord(1, MonthsEnum.JANUARY, 1975);
        DateRecord enrollment = new DateRecord(1, MonthsEnum.SEPTEMBER, 2018);
        PersonInfo student = new PersonInfo("Jovana", null, "Hernandez", dob, CountriesEnum.US, CountriesEnum.US);
        PersonInfo father = new PersonInfo("David", null, "Hernandez", parentDob, CountriesEnum.US, CountriesEnum.US);
        PersonInfo mother = new PersonInfo("Laura", null, "Hernandez", parentDob, CountriesEnum.US, CountriesEnum.US);
        StudentRecord record = new StudentRecord(student, "JH1234567", father, mother, enrollment);
        String result = record.toString();
        assertTrue(result.contains("Father Information:"));
        assertTrue(result.contains("Mother Information:"));
    }

    @Test
    @DisplayName("StudentRecord with exactly 9-character ID does not throw")
    public void studentRecordExactlyNineCharIDIsValid() {
        DateRecord dob = new DateRecord(1, MonthsEnum.JUNE, 2001);
        DateRecord enrollment = new DateRecord(15, MonthsEnum.AUGUST, 2020);
        PersonInfo student = new PersonInfo("Jovana", null, "Hernandez", dob, CountriesEnum.US, CountriesEnum.US);
        assertDoesNotThrow(() -> new StudentRecord(student, "123456789", null, null, enrollment));
    }
}
