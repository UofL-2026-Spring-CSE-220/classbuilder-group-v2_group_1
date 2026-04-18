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

public class TjTests {

    // ─────────────────────────────────────────────
    // DateRecord Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("DateRecord default toString uses MM/DD/YYYY format")
    public void dateRecordDefaultToStringIsMMDDYYYY() {
        DateRecord date = new DateRecord(5, 3, 2020);
        assertEquals("03/05/2020", date.toString());
    }

    @Test
    @DisplayName("DateRecord DD_MM_YYYY format is correct")
    public void dateRecordDDMMYYYYFormatIsCorrect() {
        DateRecord date = new DateRecord(5, 3, 2020);
        assertEquals("05/03/2020", date.toString(DateFormatOptionsEnum.DD_MM_YYYY));
    }

    @Test
    @DisplayName("DateRecord YYYY_MM_DD format is correct")
    public void dateRecordYYYYMMDDFormatIsCorrect() {
        DateRecord date = new DateRecord(5, 3, 2020);
        assertEquals("2020/03/05", date.toString(DateFormatOptionsEnum.YYYY_MM_DD));
    }

    @Test
    @DisplayName("DateRecord MONTH_DD_YYYY format is correct")
    public void dateRecordMonthDDYYYYFormatIsCorrect() {
        DateRecord date = new DateRecord(5, 3, 2020);
        assertEquals("March 05, 2020", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }

    @Test
    @DisplayName("DateRecord throws exception for invalid date")
    public void dateRecordThrowsForInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(31, 2, 2020));
    }

    @Test
    @DisplayName("DateRecord builder creates correct date")
    public void dateRecordBuilderCreatesCorrectDate() {
        DateRecord date = new DateRecord.Builder()
                .setDay(10)
                .setMonth(6)
                .setYear(1999)
                .build();
        assertEquals("06/10/1999", date.toString());
    }

    @Test
    @DisplayName("DateRecord constructor with MonthsEnum works correctly")
    public void dateRecordWithMonthsEnumIsCorrect() {
        DateRecord date = new DateRecord(29, MonthsEnum.FEBRUARY, 2020);
        assertEquals("02/29/2020", date.toString());
    }

    // ─────────────────────────────────────────────
    // PersonInfo Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("PersonInfo throws exception for null first name")
    public void personInfoThrowsForNullFirstName() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo(null, null, "Smith", dob, CountriesEnum.US, CountriesEnum.US));
    }

    @Test
    @DisplayName("PersonInfo throws exception for blank first name")
    public void personInfoThrowsForBlankFirstName() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo("  ", null, "Smith", dob, CountriesEnum.US, CountriesEnum.US));
    }

    @Test
    @DisplayName("PersonInfo throws exception for null last name")
    public void personInfoThrowsForNullLastName() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo("John", null, null, dob, CountriesEnum.US, CountriesEnum.US));
    }

    @Test
    @DisplayName("PersonInfo throws exception for null country of residence")
    public void personInfoThrowsForNullCountryOfResidence() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo("John", null, "Smith", dob, null, CountriesEnum.US));
    }

    @Test
    @DisplayName("PersonInfo throws exception for null country of birth")
    public void personInfoThrowsForNullCountryOfBirth() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo("John", null, "Smith", dob, CountriesEnum.US, null));
    }

    @Test
    @DisplayName("PersonInfo builder creates correct record")
    public void personInfoBuilderCreatesCorrectRecord() {
        DateRecord dob = new DateRecord(15, 3, 2000);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();
        assertEquals("John", person.firstName());
        assertEquals("Doe", person.lastName());
    }

    @Test
    @DisplayName("PersonInfo without middle name does not print middle name")
    public void personInfoWithoutMiddleNameOmitsIt() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        PersonInfo person = new PersonInfo("John", null, "Doe", dob, CountriesEnum.US, CountriesEnum.US);
        assertFalse(person.toString().contains("Middle Name"));
    }

    // ─────────────────────────────────────────────
    // StudentRecord Tests
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("StudentRecord throws exception for null student info")
    public void studentRecordThrowsForNullStudentInfo() {
        DateRecord enrollment = new DateRecord(1, 9, 2023);
        assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord(null, "123456789", null, null, enrollment));
    }

    @Test
    @DisplayName("StudentRecord throws exception for student ID not 9 characters")
    public void studentRecordThrowsForShortStudentID() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        DateRecord enrollment = new DateRecord(1, 9, 2023);
        PersonInfo student = new PersonInfo("John", null, "Doe", dob, CountriesEnum.US, CountriesEnum.US);
        assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord(student, "12345", null, null, enrollment));
    }

    @Test
    @DisplayName("StudentRecord throws exception for null enrollment date")
    public void studentRecordThrowsForNullEnrollmentDate() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        PersonInfo student = new PersonInfo("John", null, "Doe", dob, CountriesEnum.US, CountriesEnum.US);
        assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord(student, "123456789", null, null, null));
    }

    @Test
    @DisplayName("StudentRecord builder creates correct record")
    public void studentRecordBuilderCreatesCorrectRecord() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        DateRecord enrollment = new DateRecord(1, 9, 2023);
        PersonInfo student = new PersonInfo("John", null, "Doe", dob, CountriesEnum.US, CountriesEnum.US);
        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(student)
                .setStudentID("123456789")
                .setEnrollmentDate(enrollment)
                .build();
        assertEquals("123456789", record.studentID());
    }

    @Test
    @DisplayName("StudentRecord toString contains student ID")
    public void studentRecordToStringContainsStudentID() {
        DateRecord dob = new DateRecord(1, 1, 2000);
        DateRecord enrollment = new DateRecord(1, 9, 2023);
        PersonInfo student = new PersonInfo("John", null, "Doe", dob, CountriesEnum.US, CountriesEnum.US);
        StudentRecord record = new StudentRecord(student, "123456789", null, null, enrollment);
        assertTrue(record.toString().contains("123456789"));
    }
}