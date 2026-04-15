package edu.coolschool.utilities.dateutils;


public class DateValidator {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }

    public static int getDaysInMonth(MonthsEnum month, int year) {
        return getDaysInMonth(month.getMonthNumber(), year);
    }
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month number: " + month);
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > getDaysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(int day, MonthsEnum month, int year) {
        return isValidDate(day, month.getMonthNumber(), year);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(isValidDate(29, MonthsEnum.FEBRUARY, 2020)); // true
        System.out.println(isValidDate(29, MonthsEnum.FEBRUARY, 2021)); // false
/**/        System.out.println(isValidDate(31, 4, 2021)); // false
        System.out.println(isValidDate(31, 12, 2021)); // true
    }


}
