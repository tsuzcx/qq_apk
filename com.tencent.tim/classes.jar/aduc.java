import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aduc
{
  static SimpleDateFormat B;
  static SimpleDateFormat y;
  
  public static long ah(String paramString)
  {
    if (y == null)
    {
      y = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
      y.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = y.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
  
  public static long aj(String paramString)
  {
    if (B == null)
    {
      B = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      B.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = B.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis1, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
  
  public static SharedPreferences b(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime.getApplication().getSharedPreferences(paramAppRuntime.getAccount() + "sp_ar_map", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aduc
 * JD-Core Version:    0.7.0.1
 */