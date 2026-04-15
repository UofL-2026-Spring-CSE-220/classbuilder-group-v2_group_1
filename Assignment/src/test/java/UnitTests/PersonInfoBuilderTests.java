package UnitTests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonInfoBuilderTests {

    @Test
    @DisplayName("Builder sets all fields correctly")
    public void builderSetsAllFieldsCorrectly() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Alice")
                .setMiddleName("Marie")
                .setLastName("Smith")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.CA)
                .build();

        assertEquals("Alice", person.firstName());
        assertEquals("Marie", person.middleName());
        assertEquals("Smith", person.lastName());
        assertEquals(dob, person.dateOfBirth());
        assertEquals(CountriesEnum.US, person.countryOfResidence());
        assertEquals(CountriesEnum.CA, person.countryOfBirth());
    }

    @Test
    @DisplayName("Builder throws exception when first name is blank")
    public void builderThrowsExceptionWhenFirstNameIsBlank() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo.Builder()
                        .setFirstName("   ")
                        .setLastName("Smith")
                        .setDateOfBirth(dob)
                        .setCountryOfResidence(CountriesEnum.US)
                        .setCountryOfBirth(CountriesEnum.US)
                        .build());
        assertEquals(ErrorStrings.FIRST_NAME_BLANK.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("Builder throws exception when last name is null")
    public void builderThrowsExceptionWhenLastNameIsNull() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo.Builder()
                        .setFirstName("Alice")
                        .setLastName(null)
                        .setDateOfBirth(dob)
                        .setCountryOfResidence(CountriesEnum.US)
                        .setCountryOfBirth(CountriesEnum.US)
                        .build());
        assertEquals(ErrorStrings.LAST_NAME_BLANK.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("Builder throws exception when country of residence is null")
    public void builderThrowsExceptionWhenCountryOfResidenceIsNull() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo.Builder()
                        .setFirstName("Alice")
                        .setLastName("Smith")
                        .setDateOfBirth(dob)
                        .setCountryOfResidence(null)
                        .setCountryOfBirth(CountriesEnum.US)
                        .build());
        assertEquals(ErrorStrings.NULL_COUNTRY.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("Builder throws exception when country of birth is null")
    public void builderThrowsExceptionWhenCountryOfBirthIsNull() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new PersonInfo.Builder()
                        .setFirstName("Alice")
                        .setLastName("Smith")
                        .setDateOfBirth(dob)
                        .setCountryOfResidence(CountriesEnum.US)
                        .setCountryOfBirth(null)
                        .build());
        assertEquals(ErrorStrings.NULL_COUNTRY_OF_BIRTH.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("toString omits middle name when not set")
    public void toStringOmitsMiddleNameWhenNotSet() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Alice")
                .setLastName("Smith")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        assertFalse(person.toString().contains("Middle Name"));
    }

    @Test
    @DisplayName("toString includes middle name when set")
    public void toStringIncludesMiddleNameWhenSet() {
        DateRecord dob = new DateRecord(10, MonthsEnum.JUNE, 1995);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Alice")
                .setMiddleName("Marie")
                .setLastName("Smith")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        assertTrue(person.toString().contains("Middle Name: Marie"));
    }
}