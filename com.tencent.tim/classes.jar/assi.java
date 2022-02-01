import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

public class assi
{
  public static void K(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      QLog.e("LoginHelper", 1, "hideLoginDialog null == mAp");
    }
    MqqHandler localMqqHandler = paramAppInterface.getHandler(LoginActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(20140107);
    }
    localMqqHandler = paramAppInterface.getHandler(SubLoginActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(20140107);
    }
    localMqqHandler = paramAppInterface.getHandler(AddAccountActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(20140107);
    }
    paramAppInterface = paramAppInterface.getHandler(Login.class);
    if (paramAppInterface != null) {
      paramAppInterface.sendEmptyMessage(7);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk appId=", paramString1, ", uin=", artw.qx(paramString2), ", observer=", paramSSOAccountObserver });
    if (!a(paramString1, paramString2, paramString3, paramSSOAccountObserver)) {
      return;
    }
    AppRuntime localAppRuntime;
    try
    {
      localAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
      QLog.d("LoginHelper", 1, new Object[] { "doWtLoginOnOpenSdk app = ", localAppRuntime });
      if (localAppRuntime == null)
      {
        paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("LoginHelper", 1, "Exception ", paramString2);
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("connect_data", artw.ah(paramString1));
    localAppRuntime.ssoLogin(paramString2, paramString3, 4096, paramSSOAccountObserver, localBundle);
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, SSOAccountObserver paramSSOAccountObserver)
  {
    if (paramSSOAccountObserver == null)
    {
      QLog.d("LoginHelper", 1, "checkParamsValid null == observer");
      return false;
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1)))
    {
      QLog.d("LoginHelper", 1, "checkParamsValid invalid params");
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    if (!"com.tencent.tim:openSdk".equals(BaseApplicationImpl.getApplication().getQQProcessName()))
    {
      QLog.d("LoginHelper", 1, new Object[] { "checkParamsValid process = ", BaseApplicationImpl.getApplication().getQQProcessName() });
      paramSSOAccountObserver.onFailed(paramString1, 1100, -1012, null);
      return false;
    }
    return true;
  }
  
  public static String n(AppInterface paramAppInterface)
    throws InterruptedException
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assi
 * JD-Core Version:    0.7.0.1
 */