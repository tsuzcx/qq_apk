import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.MainFragment.25;
import com.tencent.qphone.base.util.QLog;

public class vho
  implements MessageQueue.IdleHandler
{
  public vho(MainFragment.25 param25) {}
  
  public boolean queueIdle()
  {
    try
    {
      this.a.this$0.startActivity(this.a.K);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MainFragment", 1, "keep alive guide start error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vho
 * JD-Core Version:    0.7.0.1
 */