import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ayw
  implements DialogInterface.OnClickListener
{
  public ayw(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.app.getApplication().getAllAccounts();
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      String str = this.a.app.getAccount();
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
      this.a.app.setKickIntent(null);
      if (paramDialogInterface != null)
      {
        SharedPreUtils.a(this.a.getApplication().getApplicationContext(), paramDialogInterface.getUin(), true);
        this.a.app.login(paramDialogInterface);
        return;
      }
      paramDialogInterface = new Bundle();
      paramDialogInterface.putString("password", null);
      if (!PhoneNumLoginImpl.a().a(this.a.app, this.a.app.a()))
      {
        this.a.app.updateSubAccountLogin(this.a.app.a(), false);
        this.a.app.getApplication().refreAccountList();
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
      return;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ayw
 * JD-Core Version:    0.7.0.1
 */