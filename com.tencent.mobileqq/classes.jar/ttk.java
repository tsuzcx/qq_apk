import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class ttk
  extends BroadcastReceiver
{
  ttk(ttj paramttj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "onReceive:before_account_change");
    }
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ttk
 * JD-Core Version:    0.7.0.1
 */