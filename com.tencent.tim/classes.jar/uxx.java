import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qphone.base.util.QLog;

public class uxx
  extends BroadcastReceiver
{
  public uxx(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.this$0.isFinishing())
    {
      this.this$0.finish();
      QLog.i("ForwardOption.ForwardEntranceActivity", 1, "ForwardRecentActivity has finished by broadcastReceiver.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */