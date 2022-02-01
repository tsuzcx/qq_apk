package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$2$1
  implements Runnable
{
  LivePlayerEmbeddedWidgetClient$2$1(LivePlayerEmbeddedWidgetClient.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      LivePlayerEmbeddedWidgetClient.access$400(this.val$bitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.val$bitmap.getWidth());
      localJSONObject2.put("height", this.val$bitmap.getHeight());
      localObject = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject2);
      this.this$1.val$serviceWebView.evaluateCallbackJs(this.this$1.val$callbackId, ((JSONObject)localObject).toString());
      QMLog.e("miniapp-embedded-live-player", "takePhoto - evaluateCallbackJs：" + ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
      this.this$1.val$serviceWebView.evaluateCallbackJs(this.this$1.val$callbackId, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.2.1
 * JD-Core Version:    0.7.0.1
 */