package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ImageViewJsPlugin$2
  implements Runnable
{
  ImageViewJsPlugin$2(ImageViewJsPlugin paramImageViewJsPlugin, JSONObject paramJSONObject1, String paramString1, int paramInt, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (this.this$0.updateImageView(this.val$postionObj, this.val$data, this.val$viewId, this.val$iconPath, this.val$clickable, this.val$style))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */