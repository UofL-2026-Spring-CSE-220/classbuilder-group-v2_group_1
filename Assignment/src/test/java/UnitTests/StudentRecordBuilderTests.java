package UnitTests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRecordBuilderTests {

    private PersonInfo buildBasicStudent() {
        return new PersonInfo.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(new DateRecord(1, MonthsEnum.JANUARY, 2000))
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();
    }

    private DateRecord buildBasicEnrollment() {
        return new DateRecord(1, MonthsEnum.SEPTEMBER, 2020);
    }

    @Test
    @DisplayName("Builder creates valid StudentRecord with all fields")
    public void builderCreatesValidStudentRecordWithAllFields() {
        PersonInfo father = new PersonInfo.Builder()
                .setFirstName("James")
                .setLastName("Doe")
                .setDateOfBirth(new DateRecord(10, MonthsEnum.MARCH, 1970))
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        PersonInfo mother = new PersonInfo.Builder()
                .setFirstName("Linda")
                .setLastName("Doe")
                .setDateOfBirth(new DateRecord(5, MonthsEnum.JUNE, 1972))
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(buildBasicStudent())
                .setStudentID("ABC123456")
                .setFatherInfo(father)
                .setMotherInfo(mother)
                .setEnrollmentDate(buildBasicEnrollment())
                .build();

        assertEquals("ABC123456", record.studentID());
        assertNotNull(record.fatherInfo());
        assertNotNull(record.motherInfo());
        assertNotNull(record.enrollmentDate());
    }

    @Test
    @DisplayName("Builder creates valid StudentRecord without parents")
    public void builderCreatesValidStudentRecordWithoutParents() {
        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(buildBasicStudent())
                .setStudentID("ABC123456")
                .setEnrollmentDate(buildBasicEnrollment())
                .build();

        assertNull(record.fatherInfo());
        assertNull(record.motherInfo());
    }

    @Test
    @DisplayName("Builder throws exception for null student info")
    public void builderThrowsExceptionForNullStudentInfo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord.Builder()
                        .setStudentInfo(null)
                        .setStudentID("ABC123456")
                        .setEnrollmentDate(buildBasicEnrollment())
                        .build());
        assertEquals(ErrorStrings.NULL_STUDENT_INFO.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("Builder throws exception for student ID shorter than 9 characters")
    public void builderThrowsExceptionForShortStudentID() {
        assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord.Builder()
                        .setStudentInfo(buildBasicStudent())
                        .setStudentID("SHORT")
                        .setEnrollmentDate(buildBasicEnrollment())
                        .build());
    }

    @Test
    @DisplayName("Builder throws exception for student ID longer than 9 characters")
    public void builderThrowsExceptionForLongStudentID() {
        assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord.Builder()
                        .setStudentInfo(buildBasicStudent())
                        .setStudentID("TOOLONGID1")
                        .setEnrollmentDate(buildBasicEnrollment())
                        .build());
    }

    @Test
    @DisplayName("Builder throws exception for null enrollment date")
    public void builderThrowsExceptionForNullEnrollmentDate() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new StudentRecord.Builder()
                        .setStudentInfo(buildBasicStudent())
                        .setStudentID("ABC123456")
                        .setEnrollmentDate(null)
                        .build());
        assertEquals(ErrorStrings.NULL_ENROLLMENT_DATE.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("toString does not include Father or Mother when not set")
    public void toStringDoesNotIncludeParentsWhenNotSet() {
        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(buildBasicStudent())
                .setStudentID("ABC123456")
                .setEnrollmentDate(buildBasicEnrollment())
                .build();

        String result = record.toString();
        assertFalse(result.contains("Father Information:"));
        assertFalse(result.contains("Mother Information:"));
    }
}