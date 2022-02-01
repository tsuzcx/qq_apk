import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.qphone.base.util.QLog;

public class aank
  extends BroadcastReceiver
{
  public aank(LoginView paramLoginView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("LoginActivity.LoginView", 1, "AutoLoginReceiver onReceive");
    LoginView.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aank
 * JD-Core Version:    0.7.0.1
 */