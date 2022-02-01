import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.ThreadWrapContext;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class acmp
  implements ThreadWrapContext
{
  private static boolean bJs;
  private static volatile boolean bJt;
  
  public static void hQ(long paramLong)
  {
    if ((!bJs) && (BaseApplicationImpl.sProcessId == 1))
    {
      bJs = true;
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|chance " + paramLong);
      }
      if (paramLong > 0L)
      {
        bJt = JobReporter.ramdomReport((int)paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.config", 2, "initShotChanceForPublicVersion|sShotChanceForPublicVersion " + bJt);
        }
      }
    }
  }
  
  public void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public long getMainProccessThreadMonitorTime()
  {
    return aqmj.getMainProccessThreadMonitorTime();
  }
  
  public long getMainProccessThreadPeakCounts()
  {
    return aqmj.getMainProccessThreadPeakCounts();
  }
  
  public boolean isColorLevel()
  {
    return QLog.isColorLevel();
  }
  
  public boolean isShotReportRejectedError()
  {
    return bJt;
  }
  
  public void reportDengTaException(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
  
  public void reportRDMException(Throwable paramThrowable, String paramString1, String paramString2) {}
  
  public void setMainProccessThreadMonitorTime(long paramLong)
  {
    aqmj.setMainProccessThreadMonitorTime(paramLong);
  }
  
  public void setMainProccessThreadPeakCounts(long paramLong)
  {
    aqmj.setMainProccessThreadPeakCounts(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acmp
 * JD-Core Version:    0.7.0.1
 */