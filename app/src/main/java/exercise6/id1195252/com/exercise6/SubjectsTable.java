package exercise6.id1195252.com.exercise6;

import android.provider.BaseColumns;

/**
 * SubjectsTable table info
 */
public class SubjectsTable {


    public static final String TABLE_NAME = "subjects_info";

    public SubjectsTable() {

    }

    public static abstract class Columns implements BaseColumns{
        public static final String ID = "_id";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String SUBJECT_NUMBER = "subject_number";
        public static final String START_DATE = "start_date";
        public static final String ISCORE = "is_core";
    }

}
