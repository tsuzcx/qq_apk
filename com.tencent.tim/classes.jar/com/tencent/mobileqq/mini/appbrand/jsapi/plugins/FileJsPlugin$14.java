package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class FileJsPlugin$14
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$14(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, String paramString3) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    if ((MiniAppFileManager.getInstance().getWxFileType(this.val$srcPath) == 9999) && (!MiniAppFileManager.getInstance().isPackageRelativePath(this.val$srcPath)))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$srcPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$srcPath, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$destPath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$destPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$destPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$srcPath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$destPath);
    long l2 = FileUtils.getFileSizes(str1);
    if (!MiniAppFileManager.getInstance().isFolderCanWrite(2, l2))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, str1);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      boolean bool = FileUtils.copyFile(str1, str2);
      FileJsPlugin.access$100(this.this$0, this.val$event, bool, this.val$startMS, l1, str1);
      if (bool)
      {
        MiniAppFileManager.getInstance().updateFolderSize(2, l2);
        return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open ", this.val$callbackId);
    }
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */