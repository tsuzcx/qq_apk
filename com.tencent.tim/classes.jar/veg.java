import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;

public class veg
  extends BroadcastReceiver
{
  public veg(JumpActivity paramJumpActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.this$0.isFinishing())
    {
      this.this$0.finish();
      QLog.i("JumpAction", 1, "JumpActivity has finished by broadcastReceiver.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     veg
 * JD-Core Version:    0.7.0.1
 */