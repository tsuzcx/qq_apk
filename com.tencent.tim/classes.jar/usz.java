import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.45.1;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class usz
  extends BroadcastReceiver
{
  public usz(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("wording");
    int i = paramIntent.getIntExtra("timetowait", 360000);
    this.this$0.a.cgH = i;
    this.this$0.a.bda = paramContext;
    this.this$0.a.gm(19, 2);
    this.this$0.a.d(-1, null);
    this.this$0.app.getHandler(Conversation.class).postDelayed(new Conversation.45.1(this), i);
    anot.a(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_PushBanner", "showBanner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usz
 * JD-Core Version:    0.7.0.1
 */