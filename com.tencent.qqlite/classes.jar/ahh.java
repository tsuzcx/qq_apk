import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.managers.LoadingStateManager;

public class ahh
  extends Handler
{
  public ahh(Conversation paramConversation) {}
  
  public void handleMessage(Message paramMessage)
  {
    LoadingStateManager.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      Conversation.a(this.a, 1134013, 0L, false);
      return;
    }
    Conversation.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ahh
 * JD-Core Version:    0.7.0.1
 */