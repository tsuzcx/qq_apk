import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class vjb
  implements DialogInterface.OnClickListener
{
  public vjb(NotificationActivity paramNotificationActivity, signature.SignatureKickData paramSignatureKickData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("NotificationActivity", 1, "setPositiveButton.onClick: invoked.  isDialogShow: " + NotificationActivity.a(this.this$0));
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.this$0.startActivity(new Intent(this.this$0, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.a.str_url.get()));
      this.this$0.startActivity(paramDialogInterface);
      label106:
      paramDialogInterface = new Intent("qqplayer_exit_action");
      this.this$0.sendBroadcast(paramDialogInterface);
      this.this$0.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */