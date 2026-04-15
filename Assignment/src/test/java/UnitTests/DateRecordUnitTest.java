package UnitTests;

import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import edu.coolschool.utilities.ErrorStrings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DateRecordUnitTest {

    @Test
    @DisplayName("Verify Builder returns same instance for method chaining")
    public void testBuilderMethodChainingIdentity() {
        DateRecord.Builder builder = new DateRecord.Builder();
        assertSame(builder, builder.setDay(10), "Builder should return own instance for chaining");

    }
    @Test
    @DisplayName("Verify specific ErrorStrings Enum is used in exception message")
    public void testExceptionMessageFromEnum() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setDay(32)
                    .setMonth(1)
                    .setYear(2026)
                    .build();
        });
        assertTrue(exception.getMessage().contains("Invalid date"),
                "The error message should match the project requirements");
    }
    @Test
    @DisplayName("Verify year-end boundary date construction")
    public void testYearEndBoundary() {
        DateRecord endOfYear = new DateRecord.Builder()
                .setYear(2025)
                .setMonth(MonthsEnum.DECEMBER)
                .setDay(31)
                .build();
        assertEquals(31, endOfYear.dayInteger());
        assertEquals(12, endOfYear.monthInteger());
    }

}