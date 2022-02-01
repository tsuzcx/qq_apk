package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class SettingsJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SettingsJsPlugin";
  private ChannelProxy mProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
  
  private void callbackSettingEvent(AuthState paramAuthState, RequestEvent paramRequestEvent)
  {
    if (paramAuthState == null) {
      return;
    }
    Object localObject = paramAuthState.getAuthStateList(6);
    JSONArray localJSONArray;
    for (;;)
    {
      try
      {
        paramAuthState = new JSONObject();
        localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        AuthStateItem localAuthStateItem = (AuthStateItem)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("scope", localAuthStateItem.scopeName);
        int i;
        if (localAuthStateItem.authFlag == 2)
        {
          i = 1;
          localJSONObject.put("state", i);
          localJSONArray.put(localJSONObject);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramAuthState)
      {
        QMLog.e("SettingsJsPlugin", paramRequestEvent.event + " error.", paramAuthState);
        paramRequestEvent.fail();
        return;
      }
    }
    paramAuthState.put("authSetting", localJSONArray);
    paramRequestEvent.ok(paramAuthState);
  }
  
  private void callbackSettingEvent(RequestEvent paramRequestEvent)
  {
    callbackSettingEvent(MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId), paramRequestEvent);
  }
  
  private void openSettingActivity(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null)
    {
      QMLog.e("SettingsJsPlugin", "openSettingActivity, appInfo:" + paramApkgInfo);
      return;
    }
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(paramActivity, paramApkgInfo.appId, paramApkgInfo.apkgName);
  }
  
  @JsEvent({"getSetting"})
  public void getSetting(RequestEvent paramRequestEvent)
  {
    String str = this.mApkgInfo.appId;
    AuthState localAuthState = MiniAppEnv.g().getAuthSate(str);
    if (localAuthState == null)
    {
      QMLog.e("SettingsJsPlugin", "getSetting, but authorizeCenter is null?!");
      return;
    }
    if (localAuthState.isSynchronized())
    {
      callbackSettingEvent(localAuthState, paramRequestEvent);
      return;
    }
    this.mProxy.getAuthList(str, new SettingsJsPlugin.2(this, localAuthState, paramRequestEvent));
  }
  
  @JsEvent({"openSetting"})
  public void openSetting(RequestEvent paramRequestEvent)
  {
    ActivityResultManager.g().addActivityResultListener(new SettingsJsPlugin.1(this, paramRequestEvent));
    openSettingActivity(this.mMiniAppContext.getAttachedActivity(), this.mApkgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin
 * JD-Core Version:    0.7.0.1
 */