package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class FileJsPlugin$9
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$9(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, String paramString2, long paramLong, String paramString3, JsRuntime paramJsRuntime, int paramInt, String paramString4) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid data ", this.val$callbackId);
    }
    if (!FileJsPlugin.access$400(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    Object localObject = MiniAppFileManager.getInstance();
    if (this.val$nativeBufferBytes != null) {}
    for (long l1 = this.val$nativeBufferBytes.length; !((MiniAppFileManager)localObject).isFolderCanWrite(2, l1); l1 = this.val$data.length())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        if (FileJsPlugin.access$500(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str2, false)) {
          break label606;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("writeFile failed! path:").append(str2).append(",encoding:").append(this.val$encoding).append(",nativeBufferBytes:");
        if (this.val$nativeBufferBytes == null) {
          break label646;
        }
        localObject = Integer.valueOf(this.val$nativeBufferBytes.length);
        localStringBuilder = localStringBuilder.append(localObject).append(",data:");
        if (this.val$data != null)
        {
          localObject = Integer.valueOf(this.val$data.length());
          QLog.e("[mini] FileJsPlugin", 1, localObject);
          FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, str2);
          return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "failed to  write file" + str2, this.val$callbackId);
        }
        localObject = "null";
        continue;
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, str2);
      }
      catch (IOException localIOException)
      {
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, str2);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, localIOException.getMessage(), this.val$callbackId);
      }
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
      label606:
      FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l2, str2);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      label646:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */