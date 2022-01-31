import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import mqq.os.MqqHandler;

public class vqj
  implements Runnable
{
  public vqj(FriendChatPie paramFriendChatPie) {}
  
  public void run()
  {
    Message localMessage = FriendChatPie.c(this.a).obtainMessage(42);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showRedDot", false);
    localMessage.setData(localBundle);
    FriendChatPie.d(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vqj
 * JD-Core Version:    0.7.0.1
 */