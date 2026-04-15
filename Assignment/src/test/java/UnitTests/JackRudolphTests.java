package UnitTests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JackRudolphTests {
    @Test
    @DisplayName("Throws error for other fake dates")
    public void rejectsInvalidDateThrowsExceptionExpanded() {
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(-1, 1, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(1, -1, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(32, MonthsEnum.DECEMBER, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(31, MonthsEnum.NOVEMBER, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(32, MonthsEnum.DECEMBER, 2020));
    }

    @Test
    @DisplayName("Date format checks expanded with more complex checking")
    public void formatsSupportedDateFormatsExpanded() {
        DateRecord date = new DateRecord(00004, MonthsEnum.OCTOBER, 30000);
        assertEquals("04/10/30000", date.toString(DateFormatOptionsEnum.DD_MM_YYYY));
        assertEquals("10/04/30000", date.toString(DateFormatOptionsEnum.MM_DD_YYYY));
        assertEquals("30000/10/04", date.toString(DateFormatOptionsEnum.YYYY_MM_DD));
        assertEquals("October 04, 30000", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }


}
