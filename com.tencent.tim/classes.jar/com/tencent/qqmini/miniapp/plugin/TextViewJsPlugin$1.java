package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class TextViewJsPlugin$1
  implements Runnable
{
  TextViewJsPlugin$1(TextViewJsPlugin paramTextViewJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (TextViewJsPlugin.access$000(this.this$0, this.val$jsonObject))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */