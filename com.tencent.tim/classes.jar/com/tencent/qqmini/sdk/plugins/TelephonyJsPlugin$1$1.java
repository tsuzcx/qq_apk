package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import org.json.JSONObject;

class TelephonyJsPlugin$1$1
  implements PhoneNumberAction.PhoneNumberActionCallback
{
  TelephonyJsPlugin$1$1(TelephonyJsPlugin.1 param1) {}
  
  public void onGetAuthDialogRet(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
      StorageUtil.getPreference().edit().putString(str + "_PhoneNumber", paramJSONObject.optString("purePhoneNumber")).commit();
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      QMLog.d("TelephonyJsPlugin", "getPhoneNumber ret : " + paramJSONObject);
      this.this$1.val$req.ok(paramJSONObject);
      return;
    }
    this.this$1.val$req.fail("auth deny, no permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */