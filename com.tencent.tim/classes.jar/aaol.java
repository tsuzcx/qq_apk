import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.qphone.base.util.QLog;

public class aaol
  extends BroadcastReceiver
{
  public aaol(TimLoginQQView paramTimLoginQQView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("LoginActivity.TimLoginQQView", 1, "AutoLoginReceiver onReceive");
    TimLoginQQView.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaol
 * JD-Core Version:    0.7.0.1
 */