package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, String paramString3) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = MiniAppFileManager.getInstance().getAbsolutePath(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$tempFilePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "tempFilePath file not exist", this.val$callbackId);
    }
    long l2 = FileUtils.getFileSizes((String)localObject);
    if (TextUtils.isEmpty(this.val$filePath))
    {
      if (!MiniAppFileManager.getInstance().isFolderCanWrite(1, l2))
      {
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, (String)localObject);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
      }
      str = MiniAppFileManager.getInstance().savePath(this.val$tempFilePath);
      if (!TextUtils.isEmpty(str))
      {
        MiniAppFileManager.getInstance().updateFolderSize(1, l2);
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("savedFilePath", str);
          FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l1, str);
          return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, null, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    if (!MiniAppFileManager.getInstance().isFolderCanWrite(2, l2))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l1, (String)localObject);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    FileUtils.copyFile((String)localObject, str);
    localObject = new JSONObject();
    try
    {
      MiniAppFileManager.getInstance().updateFolderSize(2, l2);
      ((JSONObject)localObject).put("savedFilePath", this.val$filePath);
      FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l1, str);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */