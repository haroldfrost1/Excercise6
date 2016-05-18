package exercise6.id1195252.com.exercise6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harold on 16/5/16.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Subject.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_SUBJECT_TABLE = "CREATE TABLE " + SubjectManager.TABLE_NAME + "("
            + SubjectManager.ColumnsNames._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SubjectManager.ColumnsNames.SUBJECT_NAME + " TEXT, "
            + SubjectManager.ColumnsNames.SUBJECT_NUMBER + " INTEGER, "
            + SubjectManager.ColumnsNames.START_DATE + " INTEGER, "
            + SubjectManager.ColumnsNames.ISCORE + " INTEGER)";

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     */
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SUBJECT_TABLE);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getSubjectsTableCursor(SQLiteDatabase db) {
        return db.query(SubjectManager.TABLE_NAME, null, null, null, null, null, null);
    }
}
