import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;

public class bxw
  extends Handler
{
  public bxw(ChatActivity paramChatActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 101)
    {
      ChatActivity.a(this.a, 2);
      ChatActivity.a(this.a);
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what == 102) {
        ChatActivity.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxw
 * JD-Core Version:    0.7.0.1
 */