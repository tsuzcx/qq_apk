import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class apla
  extends BroadcastReceiver
{
  apla(apky paramapky) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(paramContext)) {
      this.this$0.c(apky.a(this.this$0));
    }
    while (!"com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(paramContext)) {
      return;
    }
    this.this$0.c(apky.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apla
 * JD-Core Version:    0.7.0.1
 */