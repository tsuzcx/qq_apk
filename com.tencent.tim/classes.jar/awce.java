import java.util.Calendar;

public class awce
{
  public static final String DAY = acfp.m(2131704670);
  public static final String MONTH;
  public static final String YEAR;
  public static final String sS = acfp.m(2131704673);
  public static final String sV;
  public static final String sW = acfp.m(2131704663);
  public static final String sX;
  
  static
  {
    sV = acfp.m(2131704656);
    sX = acfp.m(2131704669);
    YEAR = acfp.m(2131704662);
    MONTH = acfp.m(2131704660);
  }
  
  public static boolean g(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awce
 * JD-Core Version:    0.7.0.1
 */