import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class wjf
  implements MessageQueue.IdleHandler
{
  public wjf(ZhituManager paramZhituManager) {}
  
  public boolean queueIdle()
  {
    ZhituManager.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjf
 * JD-Core Version:    0.7.0.1
 */