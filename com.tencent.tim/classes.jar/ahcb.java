import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ahcb
{
  private static Calendar g = ;
  
  public static String bt(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(anaz.gQ() * 1000L);
    localCalendar2.setTimeInMillis(paramLong);
    int k = localCalendar1.get(1);
    int i = localCalendar1.get(6) - localCalendar2.get(6);
    int j = i;
    if (localCalendar2.get(1) != k)
    {
      localCalendar1 = (Calendar)localCalendar2.clone();
      do
      {
        j = i + localCalendar1.getActualMaximum(6);
        localCalendar1.add(1, 1);
        i = j;
      } while (localCalendar1.get(1) != k);
    }
    if (j <= 7) {
      return "7天内";
    }
    return j(paramLong, "yyyy年MM月");
  }
  
  public static String bu(long paramLong)
  {
    g.setTimeInMillis(System.currentTimeMillis());
    int i = g.get(1);
    int j = g.get(2);
    int k = g.get(5);
    g.setTimeInMillis(paramLong);
    int m = g.get(1);
    int n = g.get(2);
    int i1 = g.get(5);
    if (i != m) {
      return new SimpleDateFormat("yyyy-MM-dd ", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (j != n) {
      return new SimpleDateFormat("MM-dd ", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (k == i1) {
      return new SimpleDateFormat("HH:mm ", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (k - i1 <= 1) {
      return acfp.m(2131711126);
    }
    return new SimpleDateFormat("MM-dd ", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static String j(long paramLong, String paramString)
  {
    if (paramLong == 0L) {
      return "";
    }
    try
    {
      paramString = new SimpleDateFormat(paramString).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd");
      try
      {
        paramString = paramString.format(new Date(paramLong));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcb
 * JD-Core Version:    0.7.0.1
 */