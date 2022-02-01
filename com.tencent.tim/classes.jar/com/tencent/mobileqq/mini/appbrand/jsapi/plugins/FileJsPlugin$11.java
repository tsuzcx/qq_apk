package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$path);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory \"" + this.val$path + "\"", this.val$callbackId);
    }
    FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str);
    return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */