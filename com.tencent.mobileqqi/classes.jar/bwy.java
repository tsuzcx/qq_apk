import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.servlet.ReduFriendObserver;

public class bwy
  extends ReduFriendObserver
{
  public bwy(ChatActivity paramChatActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ChatActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bwy
 * JD-Core Version:    0.7.0.1
 */