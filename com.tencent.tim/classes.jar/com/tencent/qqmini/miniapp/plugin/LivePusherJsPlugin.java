package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class LivePusherJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
  private static final String EVENT_OPERATE_LIVE_PUSHER = "operateLivePusher";
  private static final String EVENT_REMOVE_LIVE_PUSHER = "removeLivePusher";
  private static final String EVENT_UPDATE_LIVE_PUSHER = "updateLivePusher";
  public static final String TAG = "LivePusherJsPlugin";
  
  @JsEvent({"insertLivePusher"})
  public void insertLivePusher(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("livePusherId");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.1(this, localJSONObject1, i, paramRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"operateLivePusher"})
  public void operateLivePusher(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("type");
      AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.4(this, localJSONObject.optInt("livePusherId"), str, paramRequestEvent, localJSONObject));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  @JsEvent({"removeLivePusher"})
  public void removeLivePusher(RequestEvent paramRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.3(this, new JSONObject(paramRequestEvent.jsonParams).optInt("livePusherId"), paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"updateLivePusher"})
  public void updateLivePusher(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      AppBrandTask.runTaskOnUiThread(new LivePusherJsPlugin.2(this, localJSONObject.optInt("livePusherId"), localJSONObject, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("LivePusherJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin
 * JD-Core Version:    0.7.0.1
 */