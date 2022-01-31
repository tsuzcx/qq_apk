import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public final class zfw
  extends Handler
{
  public zfw(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (paramMessage.obj != null))
    {
      paramMessage = new WeakReference((Thread)paramMessage.obj);
      JobReporter.access$000().add(paramMessage);
    }
    do
    {
      int i;
      do
      {
        return;
        if (paramMessage.what != 2) {
          break;
        }
        JobReporter.access$100();
        long l = System.currentTimeMillis();
        if ((l - JobReporter.access$200() > 86400000L) && (JobReporter.access$300() > 0L) && (JobReporter.ramdomReport(10)))
        {
          paramMessage = (String)paramMessage.obj;
          StatisticCollector.a(BaseApplicationImpl.getApplication()).a(paramMessage, "thread_monitor_peak_count", true, JobReporter.access$300(), 1L, null, "", false);
          if (QLog.isColorLevel()) {
            QLog.d("JobReporter", 2, "reportThreadPeakCount Yes " + JobReporter.access$300());
          }
          JobReporter.access$202(l);
          SharedPreUtils.b(l);
          JobReporter.access$302(0L);
          SharedPreUtils.a(JobReporter.access$300());
          return;
        }
        i = JobReporter.access$400();
        if (QLog.isColorLevel()) {
          QLog.d("JobReporter", 2, "saveThreadPeakCount count" + i + " sThreadPeakCount " + JobReporter.access$300());
        }
      } while (i <= JobReporter.access$300());
      JobReporter.access$302(i);
      SharedPreUtils.a(JobReporter.access$300());
      return;
    } while (paramMessage.what == 3);
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfw
 * JD-Core Version:    0.7.0.1
 */