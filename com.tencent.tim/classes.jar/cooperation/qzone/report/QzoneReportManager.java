package cooperation.qzone.report;

import avzn;
import awau;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QzoneReportManager
{
  public static String config;
  public static boolean dpw;
  private static final awau<QzoneReportManager, Void> sSingleton = new avzn();
  ConcurrentLinkedQueue<ProcessRunner> T = new ConcurrentLinkedQueue();
  volatile int mRunningTaskNum = 0;
  
  static boolean aLV()
  {
    return dpw;
  }
  
  static boolean nH(int paramInt)
  {
    return false;
  }
  
  static boolean nI(int paramInt)
  {
    return false;
  }
  
  private void runNext()
  {
    if (this.mRunningTaskNum < 3)
    {
      ProcessRunner localProcessRunner = (ProcessRunner)this.T.poll();
      if (localProcessRunner != null)
      {
        this.mRunningTaskNum += 1;
        ThreadManager.excute(localProcessRunner, 32, null, true);
      }
    }
  }
  
  class ProcessRunner
    implements Runnable
  {
    public void run()
    {
      QzoneReportManager localQzoneReportManager = this.this$0;
      localQzoneReportManager.mRunningTaskNum -= 1;
      QzoneReportManager.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager
 * JD-Core Version:    0.7.0.1
 */