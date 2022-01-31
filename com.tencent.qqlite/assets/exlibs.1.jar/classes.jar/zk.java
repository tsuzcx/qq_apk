import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.BaseChatPie;

public class zk
  implements MessageQueue.IdleHandler
{
  public zk(BaseChatPie paramBaseChatPie) {}
  
  public boolean queueIdle()
  {
    this.a.N();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     zk
 * JD-Core Version:    0.7.0.1
 */