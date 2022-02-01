import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.QLog;

public class vjf
  implements DialogInterface.OnClickListener
{
  public vjf(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("NotificationActivity", 1, "setNegativeButton.onClick: invoked.  isDialogShow: " + NotificationActivity.a(this.this$0));
    paramDialogInterface = new Intent("qqplayer_exit_action");
    this.this$0.sendBroadcast(paramDialogInterface);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.this$0.startActivity(new Intent(this.this$0, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vjf
 * JD-Core Version:    0.7.0.1
 */