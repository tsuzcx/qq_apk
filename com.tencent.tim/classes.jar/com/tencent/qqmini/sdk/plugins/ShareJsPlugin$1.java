package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ShareJsPlugin$1
  implements GetScreenshot.Callback
{
  ShareJsPlugin$1(ShareJsPlugin paramShareJsPlugin, InnerShareData.Builder paramBuilder) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.val$shareDataBuilder.setSharePicPath(ShareJsPlugin.access$000(this.this$0).iconUrl).build().shareAppMessage();
      QMLog.e("ShareJsPlugin", "getScreenshot for QzoneShare failed, savedScreenshotPath = null");
      return;
    }
    this.val$shareDataBuilder.setSharePicPath(paramString).setIsLocalPic(true).build().shareAppMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */