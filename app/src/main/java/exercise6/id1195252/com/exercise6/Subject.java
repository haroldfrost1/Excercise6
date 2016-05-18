package exercise6.id1195252.com.exercise6;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by harold on 16/5/16.
 */
public class Subject {

    private String mName;
    private String mNumber;
    private long mStartDate;
    private int mIsCore;
    private int mId;

    public Subject(){

    }

    public Subject(String name, String number, long startDate, int isCore){
        this.mName = name;
        this.mNumber = number;
        this.mStartDate = startDate;
        this.mIsCore = isCore;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        this.mNumber = number;
    }

    public long getStartDate(){
        return mStartDate;
    }

    public String getStartDateToString() {
        String formattedDate = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy", Locale.US);
        formattedDate = simpleDateFormat.format(new Date(mStartDate));

        return formattedDate;
    }

    public void setStartDate(long startDate) {
        this.mStartDate = startDate;
    }

    public int getIsCore() {
        return mIsCore;
    }

    public void setIsCore(int isCore) {
        this.mIsCore = isCore;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getType(){
        return mIsCore == 1?"Core":"Elective";
    }
}
