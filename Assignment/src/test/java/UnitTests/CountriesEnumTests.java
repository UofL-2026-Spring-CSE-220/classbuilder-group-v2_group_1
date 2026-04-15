package UnitTests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.ErrorStrings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountriesEnumTests {

    @Test
    @DisplayName("fromCode returns correct country for valid uppercase code")
    public void fromCodeReturnsCorrectCountryForValidCode() {
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("US"));
        assertEquals(CountriesEnum.GB, CountriesEnum.fromCode("GB"));
        assertEquals(CountriesEnum.CA, CountriesEnum.fromCode("CA"));
        assertEquals(CountriesEnum.DE, CountriesEnum.fromCode("DE"));
        assertEquals(CountriesEnum.JP, CountriesEnum.fromCode("JP"));
    }

    @Test
    @DisplayName("fromCode is case insensitive")
    public void fromCodeIsCaseInsensitive() {
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("us"));
        assertEquals(CountriesEnum.GB, CountriesEnum.fromCode("gb"));
        assertEquals(CountriesEnum.CA, CountriesEnum.fromCode("Ca"));
    }

    @Test
    @DisplayName("fromCode throws IllegalArgumentException for unknown code")
    public void fromCodeThrowsExceptionForUnknownCode() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                CountriesEnum.fromCode("XX"));
        assertEquals(ErrorStrings.UNKNOWN_COUNTRY.getMessage(), ex.getMessage());
    }

    @Test
    @DisplayName("fromCode returns null for null input")
    public void fromCodeReturnsNullForNullInput() {
        assertNull(CountriesEnum.fromCode(null));
    }

    @Test
    @DisplayName("toString returns display name not the code")
    public void toStringReturnsDisplayName() {
        assertEquals("United States of America", CountriesEnum.US.toString());
        assertEquals("United Kingdom", CountriesEnum.GB.toString());
        assertEquals("Germany", CountriesEnum.DE.toString());
        assertEquals("Japan", CountriesEnum.JP.toString());
        assertEquals("Brazil", CountriesEnum.BR.toString());
    }

    @Test
    @DisplayName("getCode returns the ISO code")
    public void getCodeReturnsISOCode() {
        assertEquals("US", CountriesEnum.US.getCode());
        assertEquals("GB", CountriesEnum.GB.getCode());
        assertEquals("FR", CountriesEnum.FR.getCode());
    }

    @Test
    @DisplayName("getDisplayName returns the full country name")
    public void getDisplayNameReturnsFullName() {
        assertEquals("United States of America", CountriesEnum.US.getDisplayName());
        assertEquals("United Kingdom", CountriesEnum.GB.getDisplayName());
        assertEquals("Canada", CountriesEnum.CA.getDisplayName());
    }
}