import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.qphone.base.util.QLog;

public class dhw
  extends Thread
{
  public dhw(QQLSUnlockActivity paramQQLSUnlockActivity) {}
  
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
 * Qualified Name:     dhw
 * JD-Core Version:    0.7.0.1
 */