import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;

public class assh
  extends BroadcastReceiver
{
  public assh(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Login", 1, "AutoLoginReceiver onReceive");
    Login.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assh
 * JD-Core Version:    0.7.0.1
 */