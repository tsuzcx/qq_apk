import android.text.TextUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class roq
{
  private static final DateFormat f = new SimpleDateFormat("MM月/dd");
  private static final DateFormat g = new SimpleDateFormat("yyyy");
  private static final DateFormat h = new SimpleDateFormat("HH:mm");
  private static final DateFormat i = new SimpleDateFormat("MM月dd日");
  private static final DateFormat j = new SimpleDateFormat("yyyy年MM月dd日");
  private static final ThreadLocal<DateFormat> p = new ror();
  private static final ThreadLocal<DateFormat> r = new ros();
  
  public static String aH(long paramLong)
  {
    return ((DateFormat)r.get()).format(Long.valueOf(TimeUnit.SECONDS.toMillis(paramLong)));
  }
  
  public static String aI(long paramLong)
  {
    long l = System.currentTimeMillis();
    int k = (int)((l - paramLong) / 86400000L);
    if (k == 0) {
      return acfp.m(2131704668);
    }
    if (k == 1) {
      return acfp.m(2131704664);
    }
    if (l(l, paramLong)) {
      return i.format(Long.valueOf(paramLong));
    }
    return j.format(Long.valueOf(paramLong));
  }
  
  public static String aJ(long paramLong)
  {
    return g.format(Long.valueOf(paramLong));
  }
  
  public static String aK(long paramLong)
  {
    return h.format(Long.valueOf(paramLong));
  }
  
  public static boolean aZ(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int k = localCalendar.get(1);
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    return localCalendar.get(1) == k;
  }
  
  public static String[] b(long paramLong)
  {
    String[] arrayOfString = new String[2];
    int k = (int)((System.currentTimeMillis() - paramLong) / 86400000L);
    if (k == 0)
    {
      arrayOfString[1] = acfp.m(2131704661);
      return arrayOfString;
    }
    if (k == 1)
    {
      arrayOfString[1] = acfp.m(2131704672);
      return arrayOfString;
    }
    return f.format(Long.valueOf(paramLong)).split("/");
  }
  
  public static boolean ba(long paramLong)
  {
    boolean bool2 = false;
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(11, 0);
    localGregorianCalendar.set(12, 0);
    localGregorianCalendar.set(13, 0);
    localGregorianCalendar.set(14, 0);
    long l = localGregorianCalendar.getTime().getTime();
    boolean bool1 = bool2;
    if (paramLong - l > 0L)
    {
      bool1 = bool2;
      if (paramLong - l < 86400000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean bb(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) / 86400000L) == 1;
  }
  
  public static long dW()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(localCalendar.get(1), 0, 1, 0, 0, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static final long dX()
  {
    Calendar localCalendar = Calendar.getInstance();
    return localCalendar.getTimeInMillis() - localCalendar.get(11) * 60 * 60 * 1000 - localCalendar.get(12) * 60 * 1000 - localCalendar.get(13) * 1000 - localCalendar.get(14);
  }
  
  public static boolean fo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Calendar localCalendar;
    do
    {
      return false;
      localCalendar = Calendar.getInstance();
      paramString = rpq.g(paramString);
    } while ((localCalendar.get(1) != paramString[0]) || (localCalendar.get(2) + 1 != paramString[1]) || (localCalendar.get(5) != paramString[2]));
    return true;
  }
  
  public static String getDateString()
  {
    long l = System.currentTimeMillis();
    return ((DateFormat)p.get()).format(Long.valueOf(l));
  }
  
  public static boolean isToday(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) / 86400000L) == 0;
  }
  
  public static boolean l(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    int k = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong2);
    return localCalendar.get(1) == k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     roq
 * JD-Core Version:    0.7.0.1
 */