package pageObjects;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Utils {

    public static long calculateDaysTillUser16(String day, String month, String year) throws ParseException {
        Date date = new Date();
        String userDate = day + "-" + month + "-" + year;
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date userParsedDate = formatter.parse(userDate);
        long diff = date.getTime() - userParsedDate.getTime();
        return 5844 - TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }
}
