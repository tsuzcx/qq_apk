import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public final class een
  implements Runnable
{
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    BaseApplicationImpl.a().getSharedPreferences("banner_and_splash", 0).edit().putLong("splashshowtime", l).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "显示了一个非默认闪屏时间是" + localCalendar.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     een
 * JD-Core Version:    0.7.0.1
 */