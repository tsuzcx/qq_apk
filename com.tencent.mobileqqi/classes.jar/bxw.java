import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import java.util.TimerTask;

public class bxw
  extends TimerTask
{
  public bxw(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    ChatActivity.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxw
 * JD-Core Version:    0.7.0.1
 */