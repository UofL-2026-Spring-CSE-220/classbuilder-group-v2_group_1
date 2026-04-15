package edu.coolschool.students;

import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;


public record StudentRecord(
    PersonInfo studentInfo,
    String studentID,
    PersonInfo fatherInfo,
    PersonInfo motherInfo,
    DateRecord enrollmentDate
) {
    public StudentRecord {
        if (studentInfo == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_STUDENT_INFO.getMessage());
        }
        if (studentID == null || studentID.isBlank() || studentID.length() != 9) {
            throw new IllegalArgumentException(ErrorStrings.INVALID_STUDENT_ID.getMessage());
        }
        if (enrollmentDate == null) {
            throw new IllegalArgumentException(ErrorStrings.NULL_ENROLLMENT_DATE.getMessage());
        }
    }

    public static class Builder {
        private PersonInfo studentInfo;
        private String studentID;
        private PersonInfo fatherInfo;
        private PersonInfo motherInfo;
        private DateRecord enrollmentDate;

        public Builder setStudentInfo(PersonInfo studentInfo) {
            this.studentInfo = studentInfo;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setFatherInfo(PersonInfo fatherInfo) {
            this.fatherInfo = fatherInfo;
            return this;
        }

        public Builder setMotherInfo(PersonInfo motherInfo) {
            this.motherInfo = motherInfo;
            return this;
        }

        public Builder setEnrollmentDate(DateRecord enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentRecord build() {
            return new StudentRecord(studentInfo, studentID, fatherInfo, motherInfo, enrollmentDate);
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    // Generated toString with ChatGPT
    public String toString(int tabLevel) {
        String indent = "\t".repeat(tabLevel);
        StringBuilder sb = new StringBuilder();

        sb.append(indent).append("Student ID: ").append(studentID).append("\n");

        sb.append(indent).append("\t").append("Enrollment Date: ")
                .append(enrollmentDate.toString()).append("\n");

        sb.append(indent).append("\t").append("Student Information:").append("\n");
        sb.append(studentInfo.toString(tabLevel + 2));

        if (fatherInfo != null) {
            sb.append(indent).append("\t").append("Father Information:").append("\n");
            sb.append(fatherInfo.toString(tabLevel + 2));
        }

        if (motherInfo != null) {
            sb.append(indent).append("\t").append("Mother Information:").append("\n");
            sb.append(motherInfo.toString(tabLevel + 2));
        }

        sb.append("\n");

        return sb.toString();
    }
}
