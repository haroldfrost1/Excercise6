package exercise6.id1195252.com.exercise6;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by harold on 16/5/16.
 */
public class Test {
    public static void main(String[] args) {
        long val = 1346524199000l;
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);
        System.out.println(dateText);
    }
}
