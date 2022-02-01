import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;

public class assa
  extends BroadcastReceiver
{
  public assa(Login paramLogin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Login", 1, "mPuzzleVerifyCodeReceiver onReceive");
    paramContext = new Intent(paramIntent);
    paramContext.setClass(this.a, QQBrowserActivity.class);
    paramContext.setAction("android.intent.action.VIEW");
    paramContext.putExtra("process", "com.tencent.tim:openSdk");
    paramContext.setData(Uri.parse("mqqverifycode://puzzle_verify_code/PUZZLEVERIFYCODE?"));
    this.a.startActivity(paramContext);
    this.a.elD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assa
 * JD-Core Version:    0.7.0.1
 */