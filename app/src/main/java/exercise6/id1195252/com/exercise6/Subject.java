package exercise6.id1195252.com.exercise6;

/**
 * Created by Harold on 5/4/16.
 */
public class Subject {

    private String mName;
    private String mNumber;
    private long mStartDate;
    private int mIsCore;
    private int mId;

    public int getId() {
        return mId;
    }

    public Subject(String mName, String mNumber, long mStartDate, int mIsCore) {
        this.mId = 0;
        this.mName = mName;
        this.mNumber = mNumber;
        this.mStartDate = mStartDate;
        this.mIsCore = mIsCore;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String Number) {
        this.mNumber = Number;
    }

    public long getStartDate() {
        return mStartDate;
    }

    public void setStartDate(long StartDate) {
        this.mStartDate = StartDate;
    }

    public int getIsCore() {
        return mIsCore;
    }

    public void setIsCore(int Type) {
        this.mIsCore = Type;
    }
}
