package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class NativeViewContainer$16
  implements Runnable
{
  NativeViewContainer$16(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    try
    {
      int i = new JSONObject(this.val$req.jsonParams).optInt("htmlId");
      if (NativeViewContainer.access$700(this.this$0, i))
      {
        this.val$req.ok();
        return;
      }
      this.val$req.fail();
      return;
    }
    catch (Exception localException)
    {
      this.val$req.fail();
      QMLog.e("NativeViewContainer", "removeHtmlWebview error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.16
 * JD-Core Version:    0.7.0.1
 */