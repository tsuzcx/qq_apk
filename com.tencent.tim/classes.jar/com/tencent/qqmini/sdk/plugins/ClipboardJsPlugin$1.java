package com.tencent.qqmini.sdk.plugins;

import alkw;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ClipboardJsPlugin$1
  implements Runnable
{
  ClipboardJsPlugin$1(ClipboardJsPlugin paramClipboardJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject = (ClipboardManager)ClipboardJsPlugin.access$000(this.this$0).getSystemService("clipboard");
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        alkw.a((ClipboardManager)localObject);
        if (!((ClipboardManager)localObject).hasPrimaryClip()) {
          break label119;
        }
        alkw.a((ClipboardManager)localObject);
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
        if (localObject != null)
        {
          localObject = ((ClipData)localObject).getItemAt(0);
          if (localObject != null)
          {
            localJSONObject.put("data", ((ClipData.Item)localObject).getText());
            this.val$req.ok(localJSONObject);
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
        this.val$req.fail();
        return;
      }
      continue;
      label119:
      localThrowable.put("data", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */