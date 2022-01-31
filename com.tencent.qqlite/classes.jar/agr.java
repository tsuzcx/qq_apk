import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;

public class agr
  extends BroadcastReceiver
{
  public agr(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.a.a.a(6, 2);
      this.a.a.d = paramIntent.getStringExtra("loginInfo");
      this.a.a.a(null);
      return;
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agr
 * JD-Core Version:    0.7.0.1
 */