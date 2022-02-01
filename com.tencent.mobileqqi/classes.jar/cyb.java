import android.app.Application;
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
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class cyb
  implements DialogInterface.OnClickListener
{
  public cyb(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.b.getApplication().getAllAccounts();
    String str;
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      str = this.a.b.getAccount();
      if ((str != null) && (str.length() > 0))
      {
        Iterator localIterator = paramDialogInterface.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramDialogInterface = (SimpleAccount)localIterator.next();
        } while (!str.equals(paramDialogInterface.getUin()));
      }
    }
    for (;;)
    {
      this.a.finish();
      this.a.b.setKickIntent(null);
      if (paramDialogInterface != null)
      {
        SharedPreUtils.a(this.a.getApplication().getApplicationContext(), paramDialogInterface.getUin(), true);
        this.a.b.login(paramDialogInterface);
        return;
      }
      paramDialogInterface = new Bundle();
      paramDialogInterface.putString("password", null);
      if (!PhoneNumLoginImpl.a().a(this.a.b, this.a.b.a()))
      {
        this.a.b.updateSubAccountLogin(this.a.b.a(), false);
        this.a.b.getApplication().refreAccountList();
      }
      str = SubAccountAssistantImpl.a().a(this.a.b);
      if ((!TextUtils.isEmpty(str)) && (!PhoneNumLoginImpl.a().a(this.a.b, str)))
      {
        this.a.b.updateSubAccountLogin(str, false);
        this.a.b.getApplication().refreAccountList();
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
      return;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyb
 * JD-Core Version:    0.7.0.1
 */