import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class auem
{
  private static Calendar g = ;
  
  public static String bu(long paramLong)
  {
    g.setTimeInMillis(System.currentTimeMillis());
    int i = g.get(1);
    g.setTimeInMillis(paramLong);
    if (i != g.get(1)) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("MM-dd HH:mm", BaseApplicationImpl.getContext().getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static String cl(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(anaz.gQ() * 1000L);
    localCalendar2.setTimeInMillis(paramLong);
    int i = localCalendar1.get(6) - localCalendar2.get(6);
    int k = localCalendar1.get(1);
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
    if (j > 60) {
      return "两个月前";
    }
    if (j > 30) {
      return "一个月前";
    }
    if (j > 7) {
      return "一周前";
    }
    if (j > 1) {
      return "一周内";
    }
    if (j == 1) {
      return "昨天";
    }
    if (j == 0) {
      return "今天";
    }
    if (QLog.isDevelopLevel()) {
      throw new IllegalArgumentException("参数错误");
    }
    return "两个月前";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auem
 * JD-Core Version:    0.7.0.1
 */