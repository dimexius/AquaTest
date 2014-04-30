package autoTests.Instruments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dims on 21.04.14.
 */
public class Generators {

        protected static DateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //dd/MM/yyyy HH:mm

        // Generate Random String with parameter of characters quantity
        public static String getRandomText(int quantity) {
            StringBuilder name = new StringBuilder();
            //Add uppercase letter as first
            name.append((char) (Math.random() * 25 + (byte)'A'));
            for (int i = 1; i < quantity; i++) {
                //Add
                name.append((char) (Math.random() * 25 + (byte)'a'));
            }
            return name.toString();
        }

        public static Integer getRandomIntNumber() {
            return (int) Math.round(Math.random()*100);
        }

        // get Current Date (Activity Start Date,...)
        public static String getCurrentDate(){
            Date currentDate = new Date();
            return dateTime.format(currentDate);

        }

        // get Next Date(Activity End Date )
        public static String getNextDate(int n){
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, n);
            return dateTime.format(cal.getTime());

        }



}
