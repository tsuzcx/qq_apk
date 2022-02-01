import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;

public class usy
  extends BroadcastReceiver
{
  public usy(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.this$0.a.gm(27, 2);
      this.this$0.a.bdb = paramIntent.getStringExtra("loginInfo");
      this.this$0.a.LT = paramIntent.getLongExtra("subappid", 1L);
      this.this$0.a.d(-1, null);
      return;
    }
    this.this$0.a.cus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usy
 * JD-Core Version:    0.7.0.1
 */