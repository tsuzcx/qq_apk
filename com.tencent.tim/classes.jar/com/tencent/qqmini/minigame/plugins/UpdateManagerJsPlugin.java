package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class UpdateManagerJsPlugin
  extends BaseJsPlugin
{
  public static final String NATIVE_EVENT_NAME_GET_UPDATE_MANAGER = "getUpdateManager";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_CHECK_RESULT = "onUpdateCheckResult";
  public static final String NATIVE_EVENT_NAME_ON_UPDATE_DOWNLOAD_RESULT = "onUpdateDownloadResult";
  public static final String NATIVE_EVENT_NAME_UPDATE_APP = "updateApp";
  private static final String TAG = "UpdateManagerJsPlugin";
  
  @JsEvent({"getUpdateManager"})
  public void getUpdateManager(RequestEvent paramRequestEvent)
  {
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest do nothing for " + paramRequestEvent.event);
    paramRequestEvent.ok();
    try
    {
      QMLog.d("UpdateManagerJsPlugin", "handleUpdateCheckResult() called with:  hasUpdate = [false]");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hasUpdate", false);
      paramRequestEvent.jsService.evaluateSubscribeJS("onUpdateCheckResult", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("UpdateManagerJsPlugin", "handleNativeRequest", paramRequestEvent);
    }
  }
  
  @JsEvent({"onUpdateCheckResult"})
  public void onUpdateCheckResult(RequestEvent paramRequestEvent)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event + " should not send from JS");
  }
  
  @JsEvent({"onUpdateDownloadResult"})
  public void onUpdateDownloadResult(RequestEvent paramRequestEvent)
  {
    QMLog.w("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event + " should not send from JS");
  }
  
  @JsEvent({"updateApp"})
  public void updateApp(RequestEvent paramRequestEvent)
  {
    JsApiUpdateManager.handleUpdateApp();
    QMLog.d("UpdateManagerJsPlugin", "handleNativeRequest " + paramRequestEvent.event);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin
 * JD-Core Version:    0.7.0.1
 */