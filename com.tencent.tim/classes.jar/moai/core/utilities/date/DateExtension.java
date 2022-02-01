package moai.core.utilities.date;

import java.util.Calendar;
import java.util.Date;

public class DateExtension
{
  private static final long INTERVAL_DAY = 86400000L;
  private static final long INTERVAL_HOUR = 3600000L;
  private static final long INTERVAL_MINUTE = 60000L;
  public static String TAG = DateExtension.class.getSimpleName();
  private static final Calendar mCalendar = Calendar.getInstance();
  
  public static String feedbackDateFormat(Date paramDate)
  {
    Date localDate2 = new Date();
    Date localDate1 = paramDate;
    if (paramDate == null) {
      localDate1 = localDate2;
    }
    mCalendar.setTime(localDate2);
    int i = mCalendar.get(13);
    int j = mCalendar.get(12);
    int k = mCalendar.get(11);
    mCalendar.get(5);
    mCalendar.get(2);
    int m = mCalendar.get(1);
    mCalendar.get(7);
    mCalendar.setTime(localDate1);
    int n = mCalendar.get(13);
    int i1 = mCalendar.get(12);
    int i2 = mCalendar.get(11);
    int i3 = mCalendar.get(5);
    int i4 = mCalendar.get(2) + 1;
    int i5 = mCalendar.get(1);
    int i6 = mCalendar.get(7);
    long l1 = localDate2.getTime() - localDate1.getTime();
    if (l1 >= 0L)
    {
      long l2 = l1 / 1000L - ((k * 60 + j) * 60 + i - (n + (i2 * 60 + i1) * 60));
      if (l2 < 1L) {
        return fillZero(i2) + ":" + fillZero(i1);
      }
      if (l2 < 86401L) {
        return "昨天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if ((i6 > 1) && (l1 / 1000L < lastWeekInterval(i6, k, j, i))) {
        return "周" + readableWeekDay(i6) + " " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 == m) {
        return fillZero(i4) + "月" + fillZero(i3) + "日 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 != m) {
        return i5 + "年" + fillZero(i4) + "月" + fillZero(i3) + "日 " + fillZero(i2) + ":" + fillZero(i1);
      }
    }
    return i5 + "年" + fillZero(i4) + "月" + fillZero(i3) + "日";
  }
  
  private static String fillZero(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt < 10) {}
    for (String str = "0";; str = "") {
      return str + paramInt;
    }
  }
  
  private static long lastWeekInterval(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 - 2) * 86400000L / 1000L + ((paramInt2 * 60 + paramInt3) * 60 + paramInt4);
  }
  
  private static String readableWeekDay(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "日";
    case 2: 
      return "一";
    case 3: 
      return "二";
    case 4: 
      return "三";
    case 5: 
      return "四";
    case 6: 
      return "五";
    }
    return "六";
  }
  
  public static Date timeToDate(long paramLong)
  {
    Date localDate = new Date();
    try
    {
      localDate.setTime(paramLong);
      return localDate;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localDate;
  }
  
  public static Date timeToDate(String paramString)
  {
    try
    {
      paramString = timeToDate(Long.parseLong(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return new Date();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.date.DateExtension
 * JD-Core Version:    0.7.0.1
 */