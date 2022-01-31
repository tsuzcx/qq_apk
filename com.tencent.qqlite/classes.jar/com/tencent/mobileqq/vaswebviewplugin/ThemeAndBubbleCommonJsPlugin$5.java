package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.File;

class ThemeAndBubbleCommonJsPlugin$5
  implements Runnable
{
  ThemeAndBubbleCommonJsPlugin$5(ThemeAndBubbleCommonJsPlugin paramThemeAndBubbleCommonJsPlugin, String paramString, File paramFile) {}
  
  public void run()
  {
    int i = HttpDownloadUtil.a(this.this$0.mRuntime.a(), this.val$joinUrl, this.val$f);
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("downResult", i);
    localMessage.setData(localBundle);
    this.this$0.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */