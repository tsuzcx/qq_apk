import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class alve
{
  public static int dye = 25568;
  public static String[] gp = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
  public static String[] gq = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
  
  public static long Q(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1970, 0, 1, 0, 0, 0);
    long l3 = localCalendar.getTime().getTime();
    long l2 = (paramLong - l3) / 1000L / 86400L;
    long l1 = l2;
    if (l2 > 25568L) {
      l1 = 25568L;
    }
    l2 = l1;
    if (l1 < 0L) {
      l2 = 0L;
    }
    if (QLog.isDevelopLevel())
    {
      double d = (paramLong - l3) / 86400L;
      QLog.d("remind", 4, l3 + "|" + paramLong + "|" + d);
    }
    return l2;
  }
  
  public static int W(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(11);
  }
  
  public static int X(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(12);
  }
  
  public static long b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * (86400L * paramInt1));
    localCalendar.set(11, paramInt2);
    localCalendar.set(12, paramInt3);
    try
    {
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return new Date().getTime();
  }
  
  public static String bD(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm");
    try
    {
      localObject = ((Calendar)localObject).getTime();
      return localSimpleDateFormat.format((Date)localObject);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Date localDate = new Date();
      }
    }
  }
  
  public static String eQ(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localDate.setTime(1000L * (86400L * paramInt));
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 E");
    if (localSimpleDateFormat.format(localDate).equals(localSimpleDateFormat.format(localCalendar.getTime()))) {
      return acfp.m(2131715341);
    }
    return localSimpleDateFormat.format(localDate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alve
 * JD-Core Version:    0.7.0.1
 */