package com.tencent.qqmini.sdk.plugins;

import alkw;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ClipboardJsPlugin$2
  implements Runnable
{
  ClipboardJsPlugin$2(ClipboardJsPlugin paramClipboardJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$req.jsonParams);
      ClipboardManager localClipboardManager = (ClipboardManager)ClipboardJsPlugin.access$100(this.this$0).getSystemService("clipboard");
      localObject = ClipData.newPlainText(null, ((JSONObject)localObject).optString("data"));
      alkw.a(localClipboardManager, (ClipData)localObject);
      localClipboardManager.setPrimaryClip((ClipData)localObject);
      this.val$req.ok();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject = new JSONObject();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */