import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import mqq.app.MobileQQ;

public class azw
  implements DialogInterface.OnClickListener
{
  public azw(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a.app.a()))
    {
      this.a.app.updateSubAccountLogin(this.a.app.a(), false);
      this.a.app.getApplication().refreAccountList();
    }
    this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     azw
 * JD-Core Version:    0.7.0.1
 */