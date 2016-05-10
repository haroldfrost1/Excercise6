package exercise6.id1195252.com.exercise6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    public List<Subject> getAllSubjects(){
        List<Subject> subjectList = new ArrayList<Subject>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor subjectCursor = db.query(SubjectManager.TABLE_NAME, null, null,null,null,null,null);
        if (subjectCursor.moveToFirst()){
            do {
                String subejctName = subjectCursor.getString(1);
                String subjectNumber = subjectCursor.getString(2);
                long subjectStartDate = subjectCursor.getLong(3);
                int subjectIsCore = subjectCursor.getInt(4);

                subjectList.add(new Subject(subejctName,subjectNumber,subjectStartDate,subjectIsCore));
            }while(subjectCursor.moveToNext());
        }

        return subjectList;
    }

}
