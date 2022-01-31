import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.qphone.base.util.QLog;

public class dcf
  extends Thread
{
  public dcf(QQLSUnlockActivity paramQQLSUnlockActivity) {}
  
  public void run()
  {
    try
    {
      wait(1500L);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " QQLSUnlockActivity finish");
      }
      this.a.finish();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcf
 * JD-Core Version:    0.7.0.1
 */