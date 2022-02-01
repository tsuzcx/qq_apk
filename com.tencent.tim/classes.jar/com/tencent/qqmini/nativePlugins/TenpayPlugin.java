package com.tencent.qqmini.nativePlugins;

import acfp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class TenpayPlugin
  extends BaseJsPlugin
{
  private TenpayRecevicer a;
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("TenpayPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"openTenpayView"})
  public void openTenpayView(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = a(paramRequestEvent);
    this.a = new TenpayRecevicer(paramRequestEvent, new Handler(Looper.getMainLooper()));
    QLog.e("TenpayPlugin", 1, "param: " + localJSONObject.toString());
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.getString("data"));
      localBundle.putString("callbackSn", "0");
      localBundle.putInt("payparmas_paytype", 1);
      if (!PayBridgeActivity.a(this.mMiniAppContext.getAttachedActivity(), 5, localBundle, this.a)) {
        paramRequestEvent.fail(acfp.m(2131715241));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      paramRequestEvent.fail(acfp.m(2131715240));
    }
  }
  
  final class TenpayRecevicer
    extends ResultReceiver
  {
    private RequestEvent req;
    
    TenpayRecevicer(RequestEvent paramRequestEvent, Handler paramHandler)
    {
      super();
      this.req = paramRequestEvent;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      QLog.d("TenpayPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
      if (paramInt != 0)
      {
        this.req.fail("error unkown!");
        return;
      }
      paramBundle = paramBundle.getString("result");
      String str;
      try
      {
        QLog.d("TenpayPlugin", 2, "json: " + paramBundle);
        paramBundle = new JSONObject(paramBundle);
        paramInt = paramBundle.optInt("resultCode", -1);
        str = paramBundle.optString("retmsg");
        if (paramInt == 0)
        {
          this.req.ok(paramBundle);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        this.req.fail("error unkown!");
        return;
      }
      this.req.fail(paramBundle, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin
 * JD-Core Version:    0.7.0.1
 */