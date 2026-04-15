package UnitTests;

import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonthsEnumTests {

    @Test
    @DisplayName("All 12 months have correct month numbers")
    public void allMonthsHaveCorrectMonthNumbers() {
        assertEquals(1, MonthsEnum.JANUARY.getMonthNumber());
        assertEquals(2, MonthsEnum.FEBRUARY.getMonthNumber());
        assertEquals(3, MonthsEnum.MARCH.getMonthNumber());
        assertEquals(4, MonthsEnum.APRIL.getMonthNumber());
        assertEquals(5, MonthsEnum.MAY.getMonthNumber());
        assertEquals(6, MonthsEnum.JUNE.getMonthNumber());
        assertEquals(7, MonthsEnum.JULY.getMonthNumber());
        assertEquals(8, MonthsEnum.AUGUST.getMonthNumber());
        assertEquals(9, MonthsEnum.SEPTEMBER.getMonthNumber());
        assertEquals(10, MonthsEnum.OCTOBER.getMonthNumber());
        assertEquals(11, MonthsEnum.NOVEMBER.getMonthNumber());
        assertEquals(12, MonthsEnum.DECEMBER.getMonthNumber());
    }

    @Test
    @DisplayName("fromMonthNumber returns correct month for all valid numbers")
    public void fromMonthNumberReturnsCorrectMonth() {
        assertEquals(MonthsEnum.JANUARY, MonthsEnum.fromMonthNumber(1));
        assertEquals(MonthsEnum.JUNE, MonthsEnum.fromMonthNumber(6));
        assertEquals(MonthsEnum.DECEMBER, MonthsEnum.fromMonthNumber(12));
    }

    @Test
    @DisplayName("fromMonthNumber throws exception for invalid number")
    public void fromMonthNumberThrowsExceptionForInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                MonthsEnum.fromMonthNumber(0));
        assertThrows(IllegalArgumentException.class, () ->
                MonthsEnum.fromMonthNumber(13));
    }

    @Test
    @DisplayName("fromString returns correct month case insensitive")
    public void fromStringReturnCorrectMonth() {
        assertEquals(MonthsEnum.JANUARY, MonthsEnum.fromString("January"));
        assertEquals(MonthsEnum.MARCH, MonthsEnum.fromString("MARCH"));
        assertEquals(MonthsEnum.DECEMBER, MonthsEnum.fromString("December"));
    }

    @Test
    @DisplayName("fromString throws exception for invalid month name")
    public void fromStringThrowsExceptionForInvalidName() {
        assertThrows(IllegalArgumentException.class, () ->
                MonthsEnum.fromString("October"));
    }

    @Test
    @DisplayName("toString returns capitalized month name")
    public void toStringReturnsCapitalizedName() {
        assertEquals("January", MonthsEnum.JANUARY.toString());
        assertEquals("February", MonthsEnum.FEBRUARY.toString());
        assertEquals("December", MonthsEnum.DECEMBER.toString());
    }

    @Test
    @DisplayName("There are exactly 12 months in the enum")
    public void exactlyTwelveMonths() {
        assertEquals(12, MonthsEnum.values().length);
    }
}