import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.ChatActivity;

public class cda
  implements MessageQueue.IdleHandler
{
  public cda(ChatActivity paramChatActivity) {}
  
  public boolean queueIdle()
  {
    ChatActivity.b(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cda
 * JD-Core Version:    0.7.0.1
 */