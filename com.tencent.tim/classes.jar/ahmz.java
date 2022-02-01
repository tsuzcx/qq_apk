import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.HotChatFragment.HotChatWebView;

public class ahmz
  extends BroadcastReceiver
{
  public ahmz(HotChatFragment paramHotChatFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.refresh_hot_chat_list".equals(paramIntent.getAction())) && (this.b.a != null) && (this.b.a.mWebview != null)) {
      this.b.a.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmz
 * JD-Core Version:    0.7.0.1
 */