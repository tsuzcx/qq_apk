import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import mqq.os.MqqHandler;

class zoa
  implements RejectedExecutionHandler
{
  private long jdField_a_of_type_Long = -1L;
  
  public zoa(znz paramznz) {}
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 5000L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramThreadPoolExecutor instanceof znz))
      {
        String str1 = ((znz)paramThreadPoolExecutor).a();
        String str2 = str1 + "_RejectedExecution";
        com.tencent.mobileqq.app.ThreadExcutor.a = true;
        StringBuilder localStringBuilder = znz.a(this.jdField_a_of_type_Znz, str2);
        localStringBuilder.append("\n" + str2 + paramThreadPoolExecutor.toString());
        QLog.e("ThreadManager", 1, str2 + localStringBuilder.toString());
        if (ThreadManager.OPEN_RDM_REPORT) {
          QQCatchedExceptionReporter.reportQQCatchedException(new Exception(str2), str2, localStringBuilder.toString());
        }
        paramThreadPoolExecutor = new HashMap();
        paramThreadPoolExecutor.put("executor", str1);
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a("", "sp_reject_exception_report", true, 0L, 0L, paramThreadPoolExecutor, "", false);
      }
    }
    znz.a(znz.a());
    if (znz.b() != null) {
      znz.b().post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zoa
 * JD-Core Version:    0.7.0.1
 */