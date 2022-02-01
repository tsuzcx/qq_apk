import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SplashActivity.1;
import com.tencent.qphone.base.util.QLog;

public class vvr
  extends BroadcastReceiver
{
  public vvr(SplashActivity.1 param1) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "onReceive:before_account_change");
    }
    this.a.this$0.bVF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vvr
 * JD-Core Version:    0.7.0.1
 */