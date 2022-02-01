package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.minigame.GameJsPluginEngine;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiUpdateManager
{
  private static final String KEY_APP_INFO = "key_app_info";
  private static final String TAG = "JsApiUpdateManager";
  private static MiniAppInfo newerMiniAppInfo = null;
  private static MiniAppInfo olderMiniAppInfo = null;
  
  public static void checkForUpdate(MiniAppInfo paramMiniAppInfo, GameJsPluginEngine paramGameJsPluginEngine)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      olderMiniAppInfo = paramMiniAppInfo;
      QMLog.d("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + paramGameJsPluginEngine + "]");
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.w("JsApiUpdateManager", "checkForUpdate skip check for not online version");
        handleUpdateCheckResult(paramGameJsPluginEngine, false);
        return;
      }
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAppInfoById(paramMiniAppInfo.appId, "", "", new JsApiUpdateManager.1(paramMiniAppInfo, paramGameJsPluginEngine));
      return;
    }
    QMLog.e("JsApiUpdateManager", "checkUpdate() called with: oldMiniAppConfig = [" + paramMiniAppInfo + "], gameJsPluginEngine = [" + paramGameJsPluginEngine + "]");
  }
  
  public static void handleUpdateApp()
  {
    QMLog.d("JsApiUpdateManager", "handleUpdateApp() called");
    if ((olderMiniAppInfo != null) && (newerMiniAppInfo != null) && (olderMiniAppInfo.launchParam != null) && (newerMiniAppInfo.launchParam != null))
    {
      newerMiniAppInfo.forceReroad = 3;
      newerMiniAppInfo.launchParam.scene = olderMiniAppInfo.launchParam.scene;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("key_app_info", newerMiniAppInfo);
      AppBrandCmdProxy.g().sendCmd("cmd_update_app_for_mini_game", localBundle, null);
      return;
    }
    QMLog.e("JsApiUpdateManager", "handleUpdateApp olderMiniAppInfo = " + olderMiniAppInfo + " newerMiniAppInfo = " + newerMiniAppInfo);
  }
  
  public static void handleUpdateCheckResult(GameJsPluginEngine paramGameJsPluginEngine, boolean paramBoolean)
  {
    try
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateCheckResult() called with: gameJsPluginEngine = [" + paramGameJsPluginEngine + "], hasUpdate = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", paramBoolean);
      if (paramGameJsPluginEngine != null) {
        paramGameJsPluginEngine.getJsRuntime(1).evaluateSubscribeJs("onUpdateCheckResult", localJSONObject.toString());
      }
      return;
    }
    catch (JSONException paramGameJsPluginEngine)
    {
      QMLog.e("JsApiUpdateManager", "handleNativeRequest", paramGameJsPluginEngine);
    }
  }
  
  private static void handleUpdateDownload(GameJsPluginEngine paramGameJsPluginEngine, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateDownload() called with: gameJsPluginEngine = [" + paramGameJsPluginEngine + "], miniAppConfig = [" + paramMiniAppInfo + "]");
      GpkgManager.getGpkgInfoByConfig(paramMiniAppInfo, new JsApiUpdateManager.2(paramGameJsPluginEngine));
    }
  }
  
  private static void handleUpdateDownloadResult(GameJsPluginEngine paramGameJsPluginEngine, boolean paramBoolean)
  {
    try
    {
      QMLog.d("JsApiUpdateManager", "handleUpdateDownloadResult() called with: gameJsPluginEngine = [" + paramGameJsPluginEngine + "], success = [" + paramBoolean + "]");
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {}
      for (String str = "success";; str = "failed")
      {
        localJSONObject.put("updateResult", str);
        if (paramGameJsPluginEngine == null) {
          break;
        }
        paramGameJsPluginEngine.getJsRuntime(1).evaluateSubscribeJs("onUpdateDownloadResult", localJSONObject.toString());
        return;
      }
      return;
    }
    catch (JSONException paramGameJsPluginEngine)
    {
      QMLog.e("JsApiUpdateManager", "handleUpdateDownloadResult", paramGameJsPluginEngine);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager
 * JD-Core Version:    0.7.0.1
 */