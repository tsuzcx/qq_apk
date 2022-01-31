import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

class vig
  implements Runnable
{
  vig(vif paramvif) {}
  
  public void run()
  {
    ChatFragment localChatFragment = ((FragmentActivity)this.a.a.a).getChatFragment();
    if (localChatFragment != null) {
      localChatFragment.a().R();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */