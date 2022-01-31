import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.ChatActivity;

public class bxf
  implements MessageQueue.IdleHandler
{
  public bxf(ChatActivity paramChatActivity) {}
  
  public boolean queueIdle()
  {
    ChatActivity.b(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxf
 * JD-Core Version:    0.7.0.1
 */