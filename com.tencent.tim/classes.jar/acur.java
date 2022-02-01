import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class acur
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  acur(acuq paramacuq, arhz paramarhz, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((this.K != null) && (this.K.isShowing())) {
      this.K.dismiss();
    }
    if ((paramAppPathInfo != null) && (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightAppOpenAction", 2, new Object[] { "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", paramAppPathInfo.path });
      }
      paramObject = this.val$view;
      if (!TextUtils.isEmpty(paramObject)) {
        break label426;
      }
      paramString = ArkAppCacheMgr.getApplicationLauncher(paramAppPathInfo.path);
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        paramAppPathInfo = paramObject;
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramObject = this.aWN;
      if (TextUtils.isEmpty(paramObject)) {
        paramObject = "{}";
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          adqu.a(null, this.val$appName, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
          if (this.a.context != null) {
            ArkFullScreenAppActivity.a(this.a.context, this.val$appName, paramAppPathInfo, "0.0.0.1", paramObject, adqr.getDensity(), null, 1);
          }
        }
        do
        {
          do
          {
            return;
            paramAppPathInfo = paramString;
            paramInt = 1;
            paramString = null;
            break;
            paramObject = new Intent();
            paramObject.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
            paramObject.putExtra("param_force_internal_browser", true);
            paramObject.putExtra("url", paramString);
            paramObject.putExtra("injectrecommend", false);
            paramObject.putExtra("browserType", 3);
            if (!TextUtils.isEmpty(this.val$appName))
            {
              paramObject.putExtra("h5_ark_app_name", this.val$appName);
              paramString = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.val$appName, paramAppPathInfo, null, false);
              if (!TextUtils.isEmpty(paramString))
              {
                paramObject.putExtra("h5_ark_app_path", paramString);
                paramString = ArkAppCacheMgr.getApplicationDesc(this.val$appName);
                if (!TextUtils.isEmpty(paramString)) {
                  paramObject.putExtra("h5_ark_app_des", paramString);
                }
              }
            }
            paramString = aeiy.b(186);
            if (paramString != null)
            {
              paramString = paramString.getContent();
              if (!TextUtils.isEmpty(paramString)) {
                paramObject.putExtra("h5_ark_check_config", paramString);
              }
            }
            paramObject.addFlags(603979776);
          } while (this.a.context == null);
          this.a.context.startActivity(paramObject);
          return;
          QQToast.a(this.a.context, 2131690467, 0).show();
        } while (!QLog.isColorLevel());
        QLog.d("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
        return;
      }
      label426:
      paramAppPathInfo = paramObject;
      paramString = null;
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acur
 * JD-Core Version:    0.7.0.1
 */