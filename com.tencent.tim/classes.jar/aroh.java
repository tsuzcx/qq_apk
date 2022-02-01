import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class aroh
  extends QIPCModule
{
  private static volatile aroh a;
  
  private aroh(String paramString)
  {
    super(paramString);
  }
  
  public static aroh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aroh("open_sdk_qipc_module");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.i("Q.quicklogin.OpenSdkQIPCModule", 1, "onCall main proc action : " + paramString);
    if ("action_get_accountInfo".equals(paramString))
    {
      paramString = new Bundle();
      EIPCResult localEIPCResult = EIPCResult.createResult(0, paramString);
      paramBundle = paramBundle.getString("key_uin");
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((!TextUtils.isEmpty(paramBundle)) && ((localAppRuntime instanceof QQAppInterface))) {
        paramString.putString("key_nickname", aqgv.o((QQAppInterface)localAppRuntime, paramBundle));
      }
      callbackResult(paramInt, localEIPCResult);
    }
    for (;;)
    {
      return null;
      if ("action_ptlogin_cancel".equals(paramString))
      {
        paramString = BaseActivity.sTopActivity;
        QLog.i("Q.quicklogin.OpenSdkQIPCModule", 1, "onCall ptlogin cancel activity=" + paramString);
        if ((paramString instanceof SplashActivity)) {
          paramString.doOnBackPressed();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aroh
 * JD-Core Version:    0.7.0.1
 */