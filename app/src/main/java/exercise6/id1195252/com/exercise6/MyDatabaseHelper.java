package exercise6.id1195252.com.exercise6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Data access layer
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Subjects.db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_SUBJECTS_TABLE = "CREATE TABLE " + SubjectsTable.TABLE_NAME + "(" +
            SubjectsTable.Columns.ID + " PRIMARY KEY AUTOINCREMENT INTEGER, " +
            SubjectsTable.Columns.SUBJECT_NAME + " TEXT, " +
            SubjectsTable.Columns.SUBJECT_NUMBER + " TEXT, " +
            SubjectsTable.Columns.START_DATE + " INTEGER," +
            SubjectsTable.Columns.ISCORE + " INTEGER" + ")";

    public static String DROP_SUBJECTS_TABLE = "DROP_TABLE" + SubjectsTable.TABLE_NAME;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SUBJECTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newSubject = new ContentValues();
        newSubject.put(SubjectsTable.Columns.SUBJECT_NAME, subject.getName());
        newSubject.put(SubjectsTable.Columns.SUBJECT_NUMBER, subject.getNumber());
        newSubject.put(SubjectsTable.Columns.START_DATE, subject.getStartDate());
        newSubject.put(SubjectsTable.Columns.ISCORE, subject.getIsCore());

        db.insert(SubjectsTable.TABLE_NAME, null,newSubject);
        db.close();
    }

}
