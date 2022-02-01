import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class yfd
  extends BroadcastReceiver
{
  public yfd(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "Confess action! ");
      }
      if (TroopChatPie.a(this.this$0) != null)
      {
        TroopChatPie.b(this.this$0).abp(35);
        aehj.C(this.this$0.app, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfd
 * JD-Core Version:    0.7.0.1
 */