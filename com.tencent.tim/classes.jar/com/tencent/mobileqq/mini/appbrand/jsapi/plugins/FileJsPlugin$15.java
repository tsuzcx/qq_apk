package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.IOException;

class FileJsPlugin$15
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$15(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, String paramString3, JsRuntime paramJsRuntime, int paramInt, String paramString4, byte[] paramArrayOfByte) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (!FileJsPlugin.access$400(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str1))
    {
      if (str1.contains("miniprogramLog"))
      {
        MiniLog.writeMiniLog(this.this$0.jsPluginEngine.appBrandRuntime.appId, this.val$data);
        FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str1);
        return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      try
      {
        if (FileJsPlugin.access$500(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str1, true))
        {
          FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str1);
          String str2 = FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
          return str2;
        }
      }
      catch (IOException localIOException)
      {
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str1);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, localIOException.getMessage(), this.val$callbackId);
      }
    }
    FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$filePath);
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */