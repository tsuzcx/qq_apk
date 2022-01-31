import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import mqq.app.MobileQQ;

public class dds
  implements DialogInterface.OnClickListener
{
  public dds(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    if (!PhoneNumLoginImpl.a().a(this.a.b, this.a.b.a()))
    {
      this.a.b.updateSubAccountLogin(this.a.b.a(), false);
      this.a.b.getApplication().refreAccountList();
    }
    String str = SubAccountAssistantImpl.a().a(this.a.b);
    if ((!TextUtils.isEmpty(str)) && (!PhoneNumLoginImpl.a().a(this.a.b, str)))
    {
      this.a.b.updateSubAccountLogin(str, false);
      this.a.b.getApplication().refreAccountList();
    }
    this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dds
 * JD-Core Version:    0.7.0.1
 */