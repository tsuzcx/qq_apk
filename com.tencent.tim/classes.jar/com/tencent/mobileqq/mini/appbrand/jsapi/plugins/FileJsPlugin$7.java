package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$7
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$7(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath")))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$dirPath) == 2)
    {
      if (!TextUtils.isEmpty(MiniAppFileManager.getInstance().getAbsolutePath(this.val$dirPath)))
      {
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$dirPath);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "file already exists " + this.val$dirPath, this.val$callbackId);
      }
      String str = MiniAppFileManager.getInstance().getUsrPath(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new File(str).mkdirs()))
      {
        FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str);
        return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
    }
    FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$dirPath);
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */