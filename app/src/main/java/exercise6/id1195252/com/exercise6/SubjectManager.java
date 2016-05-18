package exercise6.id1195252.com.exercise6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by harold on 16/5/16.
 */
public class SubjectManager {

    public static final String TABLE_NAME = "Subjects";
    private MyDatabaseHelper mMyDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;

    public SubjectManager(Context context) {
        mMyDatabaseHelper = new MyDatabaseHelper(context);
    }

    /**
     * Abstract class holds table information
     */
    public abstract class ColumnsNames implements BaseColumns {

        public static final String ID = "_id";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String SUBJECT_NUMBER = "subject_number";
        public static final String ISCORE = "iscore";
        public static final String START_DATE = "start_date";
    }

    /**
     * Insert a subject into the database
     * and returns the id of the subject
     *
     * @param subject from Subject
     * @return the row id of the subject
     */
    public long add(Subject subject) {

        mSqLiteDatabase = mMyDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColumnsNames.SUBJECT_NAME, subject.getName());
        values.put(ColumnsNames.SUBJECT_NUMBER, subject.getNumber());
        values.put(ColumnsNames.ISCORE, subject.getIsCore());
        values.put(ColumnsNames.START_DATE, subject.getStartDate());
        return mSqLiteDatabase.insert(TABLE_NAME, null, values);
    }

    /**
     * List of subject from the database
     *
     * @return an ArrayList<Subject>
     */
    public ArrayList<Subject> getSubjectsList() {
        mSqLiteDatabase = mMyDatabaseHelper.getReadableDatabase();
        ArrayList<Subject> subjectsList = new ArrayList<>();

        Cursor cursor = mMyDatabaseHelper.getSubjectsTableCursor(mSqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {
                String subjectName = cursor.getString(cursor.getColumnIndex(ColumnsNames.SUBJECT_NAME));
                String subejctNumber = cursor.getString(cursor.getColumnIndex(ColumnsNames.SUBJECT_NUMBER));
                long startDate = cursor.getLong(cursor.getColumnIndex(ColumnsNames.START_DATE));
                int iscore = cursor.getInt(cursor.getColumnIndex(ColumnsNames.ISCORE));

                subjectsList.add(new Subject(subjectName, subejctNumber, startDate, iscore));
            } while (cursor.moveToNext());
        }

        return subjectsList;
    }

}
