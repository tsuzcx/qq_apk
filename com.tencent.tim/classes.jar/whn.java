import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class whn
{
  public static String h(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private static boolean isThisTime(long paramLong, String paramString)
  {
    Date localDate = new Date(paramLong);
    paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE);
    return paramString.format(localDate).equals(paramString.format(new Date(NetConnInfoCenter.getServerTimeMillis())));
  }
  
  public static boolean isToday(long paramLong)
  {
    return isThisTime(paramLong, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     whn
 * JD-Core Version:    0.7.0.1
 */