import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class kxl
{
  public static String a(Calendar paramCalendar)
  {
    return new SimpleDateFormat("HH:mm").format(paramCalendar.getTime());
  }
  
  public static String ap(long paramLong)
  {
    paramLong *= 1000L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new Date(paramLong);
      localObject2 = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyTimeUtils", 2, "getDateTimeString() ERROR millisTime=" + paramLong);
    }
    return localObject1;
    return null;
  }
  
  public static String b(Calendar paramCalendar)
  {
    return new SimpleDateFormat("MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  public static String c(long paramLong, boolean paramBoolean)
  {
    return d(paramLong, paramBoolean);
  }
  
  public static String c(Calendar paramCalendar)
  {
    return new SimpleDateFormat("yy-MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  private static String d(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong * 1000L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    long l2;
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      paramLong = getServerTime() * 1000L;
      if (paramLong != localCalendar1.getTimeInMillis()) {
        localCalendar1.setTimeInMillis(paramLong);
      }
      localCalendar2.setTimeInMillis(l1);
      l2 = (paramLong - l1) / 1000L;
      localObject2 = c(localCalendar2);
      localObject1 = "";
      if (l2 < 0L) {
        localObject1 = localObject2;
      }
      if (!n(l1, paramLong)) {
        break label251;
      }
      if (l2 >= 60L) {
        break label175;
      }
      localObject1 = "";
      label102:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label312;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTimeUtils", 2, new Object[] { "getRelativeDisplayTimeString = ", localObject2, ", now = ", c(localCalendar1), ", publish = ", c(localCalendar2) });
      }
      return localObject2;
      paramLong = localCalendar1.getTimeInMillis();
      break;
      label175:
      if (l2 < 3600L)
      {
        localObject1 = l2 / 60L + "";
        break label102;
      }
      if (l2 >= 86400L) {
        break label102;
      }
      localObject1 = l2 / 3600L + "";
      break label102;
      label251:
      if (p(l1, paramLong))
      {
        localObject1 = " " + a(localCalendar2);
        break label102;
      }
      if (o(l1, paramLong))
      {
        localObject1 = b(localCalendar2);
        break label102;
      }
      localObject1 = localObject2;
      break label102;
      label312:
      localObject2 = localObject1;
    }
  }
  
  public static long getServerTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public static boolean n(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static boolean o(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static boolean p(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong2);
    localCalendar1.add(6, -1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong1);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxl
 * JD-Core Version:    0.7.0.1
 */