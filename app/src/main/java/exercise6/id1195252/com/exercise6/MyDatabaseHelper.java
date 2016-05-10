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
    public static final String CREATE_SUBJECTS_TABLE = "CREATE TABLE " + SubjectManager.TABLE_NAME + "(" +
            SubjectManager.ColumnNames.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SubjectManager.ColumnNames.SUBJECT_NAME + " TEXT, " +
            SubjectManager.ColumnNames.SUBJECT_NUMBER + " TEXT, " +
            SubjectManager.ColumnNames.START_DATE + " INTEGER," +
            SubjectManager.ColumnNames.ISCORE + " INTEGER" + ")";

    public static String DROP_SUBJECTS_TABLE = "DROP_TABLE" + SubjectManager.TABLE_NAME;

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



}
