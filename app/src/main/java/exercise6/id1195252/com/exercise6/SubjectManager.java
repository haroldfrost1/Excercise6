package exercise6.id1195252.com.exercise6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * SubjectManager table info
 */
public class SubjectManager {

    private static MyDatabaseHelper mMyDatabaseHelper;
    public static final String TABLE_NAME = "subjects_info";

    public SubjectManager(Context context) {
        mMyDatabaseHelper = new MyDatabaseHelper(context);
    }

    public static abstract class ColumnNames implements BaseColumns{
        public static final String ID = "_id";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String SUBJECT_NUMBER = "subject_number";
        public static final String START_DATE = "start_date";
        public static final String ISCORE = "is_core";
    }

    public void addSubject(Subject subject) {
        SQLiteDatabase db = mMyDatabaseHelper.getWritableDatabase();
        ContentValues newSubject = new ContentValues();
        newSubject.put(SubjectManager.ColumnNames.SUBJECT_NAME, subject.getName());
        newSubject.put(SubjectManager.ColumnNames.SUBJECT_NUMBER, subject.getNumber());
        newSubject.put(SubjectManager.ColumnNames.START_DATE, subject.getStartDate());
        newSubject.put(SubjectManager.ColumnNames.ISCORE, subject.getIsCore());

        db.insert(SubjectManager.TABLE_NAME, null,newSubject);
        db.close();
    }
}
