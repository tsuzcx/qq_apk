import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;

public class cfb
  extends BroadcastReceiver
{
  public cfb(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.a.a.a(7, 2);
      this.a.a.e = paramIntent.getStringExtra("loginInfo");
      this.a.a.a(null);
      return;
    }
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfb
 * JD-Core Version:    0.7.0.1
 */