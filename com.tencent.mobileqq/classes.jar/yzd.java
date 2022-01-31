import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class yzd
  extends BroadcastReceiver
{
  public yzd(DataLineHandler paramDataLineHandler, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && ((paramContext.equals("com.tencent.mobileqq.intent.logout")) || (paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) || (paramContext.equals("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName())) || (paramContext.equals("mqq.intent.action.LOGOUT")))) {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yzd
 * JD-Core Version:    0.7.0.1
 */