package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alkw;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class ClipboardJsPlugin$2
  implements Runnable
{
  ClipboardJsPlugin$2(ClipboardJsPlugin paramClipboardJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ("getClipboardData".equals(this.val$event))
    {
      localObject = (ClipboardManager)this.val$webview.getContextEx().getSystemService("clipboard");
      localJSONObject = new JSONObject();
    }
    label162:
    while (!"setClipboardData".equals(this.val$event)) {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject;
          alkw.a((ClipboardManager)localObject);
          if (!((ClipboardManager)localObject).hasPrimaryClip()) {
            break label162;
          }
          alkw.a((ClipboardManager)localObject);
          localObject = ((ClipboardManager)localObject).getPrimaryClip();
          if (localObject != null)
          {
            localObject = ((ClipData)localObject).getItemAt(0);
            if (localObject != null)
            {
              localJSONObject.put("data", ((ClipData.Item)localObject).getText());
              this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
              return;
            }
            localJSONObject.put("data", "");
            continue;
          }
          localThrowable.put("data", "");
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
          return;
        }
        continue;
        localThrowable.put("data", "");
      }
    }
    ClipboardManager localClipboardManager = (ClipboardManager)this.val$webview.getContextEx().getSystemService("clipboard");
    Object localObject = ClipData.newPlainText(null, this.val$finalParams.optString("data"));
    alkw.a(localClipboardManager, (ClipData)localObject);
    localClipboardManager.setPrimaryClip((ClipData)localObject);
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ClipboardJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */