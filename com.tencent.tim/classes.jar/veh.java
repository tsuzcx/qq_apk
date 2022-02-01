import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;

public class veh
  extends BroadcastReceiver
{
  public veh(JumpActivity paramJumpActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.this$0.isFinishing())
    {
      QLog.i("JumpAction", 1, "JumpActivity has finished by broadcastReceiver.");
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     veh
 * JD-Core Version:    0.7.0.1
 */