package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData.Builder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ShareJsPlugin$3
  implements GetScreenshot.Callback
{
  ShareJsPlugin$3(ShareJsPlugin paramShareJsPlugin, InnerShareData.Builder paramBuilder) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("ShareJsPlugin", "getScreenshot failed, savedScreenshotPath = null");
      if (ShareJsPlugin.access$200(this.this$0) != null)
      {
        this.val$shareDataBuilder.setSharePicPath(ShareJsPlugin.access$400(this.this$0).iconUrl).setIsLocalPic(false).build().shareAppPictureMessage(ShareJsPlugin.access$300(this.this$0));
        return;
      }
      QMLog.e("ShareJsPlugin", "getScreenshot failed, apkgInfo is null");
      return;
    }
    this.val$shareDataBuilder.setSharePicPath(paramString).setIsLocalPic(true).build().shareAppPictureMessage(ShareJsPlugin.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */