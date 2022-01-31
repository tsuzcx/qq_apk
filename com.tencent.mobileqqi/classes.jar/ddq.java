import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.MobileQQ;

public class ddq
  implements DialogInterface.OnClickListener
{
  public ddq(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b.logout(true);
    SharedPreUtils.a(this.a.b.a(), this.a.b.a(), false);
    paramDialogInterface = SubAccountAssistantImpl.a().a(this.a.b);
    if ((!TextUtils.isEmpty(paramDialogInterface)) && (!PhoneNumLoginImpl.a().a(this.a.b, paramDialogInterface)))
    {
      this.a.b.updateSubAccountLogin(paramDialogInterface, false);
      this.a.b.getApplication().refreAccountList();
    }
    this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ddq
 * JD-Core Version:    0.7.0.1
 */