import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.ChatActivity;

public class bxe
  implements MessageQueue.IdleHandler
{
  public bxe(ChatActivity paramChatActivity) {}
  
  public boolean queueIdle()
  {
    ChatActivity.b(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxe
 * JD-Core Version:    0.7.0.1
 */