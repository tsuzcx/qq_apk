package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;

class FileJsPlugin$12
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$12(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    int i = MiniAppFileManager.getInstance().getWxFileType(this.val$filePath);
    if (i == 9999)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid path" + this.val$filePath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
    if (TextUtils.isEmpty(str))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    if (new File(str).isDirectory())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "operation not permitted, unlink " + this.val$filePath, this.val$callbackId);
    }
    if (!new File(str).exists())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    long l2 = FileUtils.delete(str, false);
    MiniAppFileManager.getInstance().updateFolderSize(i, -l2);
    FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, str);
    return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */