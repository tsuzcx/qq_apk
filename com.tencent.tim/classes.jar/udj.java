import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.qphone.base.util.QLog;

public class udj
  extends BroadcastReceiver
{
  public udj(AddAccountActivity paramAddAccountActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AddAccountActivity", 1, "AutoLoginReceiver onReceive");
    AddAccountActivity.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udj
 * JD-Core Version:    0.7.0.1
 */