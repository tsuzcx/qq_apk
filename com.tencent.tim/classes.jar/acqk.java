import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.QLogReporter.1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class acqk
{
  private static volatile acqk a;
  public static final SimpleDateFormat logFileFormatter = new SimpleDateFormat("yy.MM.dd");
  
  public static acqk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acqk();
      }
      return a;
    }
    finally {}
  }
  
  public void cNS()
  {
    if (new GregorianCalendar().get(11) < 2) {}
    SharedPreferences localSharedPreferences;
    long l1;
    Calendar localCalendar;
    String str;
    do
    {
      return;
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qlog_reporter", 0);
      l1 = System.currentTimeMillis();
      long l2 = localSharedPreferences.getLong("LastLogSizeReportTime", 0L);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l2);
      str = logFileFormatter.format(localCalendar.getTime());
      localCalendar.setTimeInMillis(l1);
    } while (str.equals(logFileFormatter.format(localCalendar.getTime())));
    ThreadManager.executeOnSubThread(new QLogReporter.1(this, localSharedPreferences, l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acqk
 * JD-Core Version:    0.7.0.1
 */