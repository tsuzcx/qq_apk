import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class wjg
  implements MessageQueue.IdleHandler
{
  public wjg(ZhituManager paramZhituManager) {}
  
  public boolean queueIdle()
  {
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wjg
 * JD-Core Version:    0.7.0.1
 */