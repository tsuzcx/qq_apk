import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class vjl
  implements DialogInterface.OnClickListener
{
  public vjl(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    localBundle.putBoolean("is_from_account_another_login_exit", true);
    if (!akwp.a().N(this.this$0.app, this.this$0.app.getCurrentAccountUin()))
    {
      this.this$0.app.updateSubAccountLogin(this.this$0.app.getCurrentAccountUin(), false);
      this.this$0.app.getApplication().refreAccountList();
    }
    paramDialogInterface = (anxr)this.this$0.app.getManager(61);
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.dK();; paramDialogInterface = null)
    {
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          String str = (String)paramDialogInterface.next();
          if (!akwp.a().N(this.this$0.app, str))
          {
            this.this$0.app.updateSubAccountLogin(str, false);
            this.this$0.app.getApplication().refreAccountList();
          }
        }
      }
      this.this$0.startActivity(new Intent(this.this$0, LoginActivity.class).putExtras(localBundle).addFlags(67108864));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */