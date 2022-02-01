package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONObject;

class MiniAppLivePusher$4$1
  implements Runnable
{
  MiniAppLivePusher$4$1(MiniAppLivePusher.4 param4, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      MiniAppLivePusher.access$100(this.val$bitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.val$bitmap.getWidth());
      localJSONObject2.put("height", this.val$bitmap.getHeight());
      localObject = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject2);
      this.this$1.this$0.serviceWebview.evaluateCallbackJs(this.this$1.val$callbackId, ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
      this.this$1.this$0.serviceWebview.evaluateCallbackJs(this.this$1.val$callbackId, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePusher.4.1
 * JD-Core Version:    0.7.0.1
 */