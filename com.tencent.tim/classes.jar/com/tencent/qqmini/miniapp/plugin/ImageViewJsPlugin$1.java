package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ImageViewJsPlugin$1
  implements Runnable
{
  ImageViewJsPlugin$1(ImageViewJsPlugin paramImageViewJsPlugin, RequestEvent paramRequestEvent, JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, boolean paramBoolean1) {}
  
  public void run()
  {
    if (ImageViewJsPlugin.access$000(this.this$0, this.val$req, this.val$postionObj, this.val$data, this.val$parentId, this.val$viewId, this.val$iconPath, this.val$clickable, this.val$style, this.val$fixed))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */