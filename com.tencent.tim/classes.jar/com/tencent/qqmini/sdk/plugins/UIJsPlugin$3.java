package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$3
  implements Runnable
{
  UIJsPlugin$3(UIJsPlugin paramUIJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      Activity localActivity = UIJsPlugin.access$600(this.this$0).getAttachedActivity();
      if ((localActivity == null) || (localActivity.isFinishing()))
      {
        QMLog.w("UIJsPlugin", "showLoading(). Do nothing, activity is null or finishing");
        return;
      }
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
      String str = localJSONObject.optString("title", "");
      boolean bool = localJSONObject.optBoolean("mask", false);
      if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0))) {
        UIJsPlugin.access$300(this.this$0);
      }
      UIJsPlugin.access$102(this.this$0, PageAction.obtain(UIJsPlugin.access$700(this.this$0)).getPageUrl());
      if (UIJsPlugin.access$200(this.this$0, UIJsPlugin.access$100(this.this$0)))
      {
        UIJsPlugin.access$502(this.this$0, new ToastView(localActivity, (ViewGroup)localActivity.findViewById(16908290)));
        UIJsPlugin.access$500(this.this$0).show(1, "loading", null, str, -1, bool);
        this.val$req.ok();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.e("UIJsPlugin", localJSONException.getMessage(), localJSONException);
      return;
    }
    QMLog.w("UIJsPlugin", "showLoading event=" + this.val$req.event + "， top page not found");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */