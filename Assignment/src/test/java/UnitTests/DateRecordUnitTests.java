package UnitTests;

import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateRecordUnitTests {
    @Test
    @DisplayName("Testing year 1900 is not a leap year")
    public void nonLeapYearCheck() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setYear(1900)
                    .setMonth(MonthsEnum.FEBRUARY)
                    .setDay(29)
                    .build();
        });
    }

    @Test
    @DisplayName("Testing if toString match")
    public void toStringFormat() {
        DateRecord aprilDate = new DateRecord.Builder()
                .setYear(2025)
                .setMonth(MonthsEnum.APRIL)
                .setDay(7)
                .build();
        assertEquals("April 07, 2025", aprilDate.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
        assertEquals("07/04/2025", aprilDate.toString(DateFormatOptionsEnum.DD_MM_YYYY));
        assertEquals("2025/04/07", aprilDate.toString(DateFormatOptionsEnum.YYYY_MM_DD));
        assertEquals("2025/04/07", aprilDate.toString(DateFormatOptionsEnum.YYYY_MM_DD));
    }

    @Test
    @DisplayName("Builder and construct should match")
    public void builderAndConstructMatches() {
        DateRecord builder = new DateRecord.Builder()
                .setDay(11)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2025)
                .build();

        DateRecord construct = new DateRecord(11, 9, 2025);
        assertEquals(builder.toString(), construct.toString());
    }
}
