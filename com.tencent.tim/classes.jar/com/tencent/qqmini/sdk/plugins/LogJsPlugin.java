package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class LogJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
  public static final String TAG = "LogJsPlugin";
  private static final String TAG_MINI_LOG = "miniAppLog";
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if ((!this.mIsMiniGame) && ("setEnableDebug".equals(paramRequestEvent)))
    {
      this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 3));
      return true;
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"setEnableDebug"})
  public String setEnableDebug(RequestEvent paramRequestEvent)
  {
    try
    {
      boolean bool = new JSONObject(paramRequestEvent.jsonParams).optBoolean("enableDebug");
      if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mMiniAppContext.getMiniAppInfo().appId + "_debug", false)).booleanValue()) {
        this.mMiniAppContext.getAttachedActivity().runOnUiThread(new LogJsPlugin.1(this, bool));
      }
      for (;;)
      {
        return "";
        paramRequestEvent.ok();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        paramRequestEvent.fail();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */