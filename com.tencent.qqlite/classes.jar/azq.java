import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.PBStringField;

public class azq
  implements DialogInterface.OnClickListener
{
  public azq(NotificationActivity paramNotificationActivity, signature.SignatureKickData paramSignatureKickData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_ComTencentImsSignature$SignatureKickData.str_url.get()));
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(paramDialogInterface);
      label75:
      paramDialogInterface = new Intent("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.sendBroadcast(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azq
 * JD-Core Version:    0.7.0.1
 */