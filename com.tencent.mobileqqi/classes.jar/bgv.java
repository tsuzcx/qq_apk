import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;
import com.tencent.qphone.base.util.QLog;

public class bgv
  extends Thread
{
  public bgv(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1600L);
      QAVNotification localQAVNotification = QAVNotification.a(null);
      if (localQAVNotification != null) {
        localQAVNotification.d();
      }
      this.a.g();
      if (QLog.isColorLevel()) {
        QLog.d(VideoAppInterface.a, 2, "force exit video process ...");
      }
      System.exit(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        System.exit(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgv
 * JD-Core Version:    0.7.0.1
 */