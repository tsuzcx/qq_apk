import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qlink.QlinkStandardDialogActivity;

public class avii
  implements DialogInterface.OnClickListener
{
  public avii(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = AddFriendLogicActivity.a(this.a.app.getApp().getApplicationContext(), 1, this.val$uin, null, 3002, 14, this.val$nick, null, null, acfp.m(2131711439), null);
    localIntent.putExtra("_FROM_QLINK_", true);
    this.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avii
 * JD-Core Version:    0.7.0.1
 */