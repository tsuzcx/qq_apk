import com.tencent.av.VideoRecoveryReporter.1;
import com.tencent.av.VideoRecoveryReporter.2;
import com.tencent.av.VideoRecoveryReporter.3;
import com.tencent.av.VideoRecoveryReporter.4;
import com.tencent.av.VideoRecoveryReporter.5;
import com.tencent.av.VideoRecoveryReporter.6;
import com.tencent.av.VideoRecoveryReporter.7;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ihn
{
  private static boolean PE;
  
  public static void amp()
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationRequest");
      PE = true;
      ThreadManager.post(new VideoRecoveryReporter.4(), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", localThrowable);
    }
  }
  
  public static void amq()
  {
    try
    {
      if (PE) {
        PE = false;
      }
      QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationResult");
      ThreadManager.post(new VideoRecoveryReporter.5(), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", localException);
    }
  }
  
  public static void amr()
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, "reportNodeReportFail");
      ThreadManager.post(new VideoRecoveryReporter.6(), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", localThrowable);
    }
  }
  
  public static void d(int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryRequest source=%s interval=%s result=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
      ThreadManager.post(new VideoRecoveryReporter.1(paramInt, paramBoolean, paramLong), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", localThrowable);
    }
  }
  
  public static void hV(boolean paramBoolean)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportNodeReportRetry success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
      ThreadManager.post(new VideoRecoveryReporter.7(paramBoolean), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", localThrowable);
    }
  }
  
  public static void n(boolean paramBoolean, long paramLong)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryResult result=%s timeCost=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
      ThreadManager.post(new VideoRecoveryReporter.2(paramBoolean, paramLong), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", localException);
    }
  }
  
  public static void q(int paramInt, long paramLong)
  {
    try
    {
      QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryClose reason=%s duration=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
      ThreadManager.post(new VideoRecoveryReporter.3(paramInt, paramLong), 5, null, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryClose fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihn
 * JD-Core Version:    0.7.0.1
 */