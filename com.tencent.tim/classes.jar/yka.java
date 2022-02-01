import java.util.Calendar;
import java.util.Date;

public class yka
{
  public static String b(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1)
    {
      str = localCalendar.get(1) + "-";
      localStringBuilder = localStringBuilder.append(str);
      if (!paramBoolean2) {
        break label143;
      }
      str = String.format("%02d-", new Object[] { Integer.valueOf(localCalendar.get(2) + 1) });
      label88:
      localStringBuilder = localStringBuilder.append(str);
      if (!paramBoolean3) {
        break label150;
      }
    }
    label143:
    label150:
    for (String str = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });; str = "")
    {
      return str;
      str = "";
      break;
      str = "";
      break label88;
    }
  }
  
  public static String ba(long paramLong)
  {
    long l = System.currentTimeMillis();
    String str1 = bb(paramLong);
    if (!l(paramLong, l)) {}
    for (boolean bool = true;; bool = false)
    {
      String str2 = b(paramLong, bool, true, true);
      return str2 + " " + str1;
    }
  }
  
  public static String bb(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(localDate.getHours()), Integer.valueOf(localDate.getMinutes()) });
  }
  
  public static int fp(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt);
    return localCalendar.getActualMaximum(6);
  }
  
  public static String getWeekString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "周日";
    case 2: 
      return "周一";
    case 3: 
      return "周二";
    case 4: 
      return "周三";
    case 5: 
      return "周四";
    case 6: 
      return "周五";
    }
    return "周六";
  }
  
  public static boolean l(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yka
 * JD-Core Version:    0.7.0.1
 */