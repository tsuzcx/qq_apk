package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt) {}
  
  public String run()
  {
    int i = 0;
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath")))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$dirPath);
    if (TextUtils.isEmpty(str))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$dirPath, this.val$callbackId);
    }
    if (!new File(str).isDirectory())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "not a directory " + this.val$dirPath, this.val$callbackId);
    }
    File[] arrayOfFile = new File(str).listFiles();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile != null) {
          localJSONArray.put(localFile.getName());
        }
        i += 1;
      }
    }
    try
    {
      localJSONObject.put("files", localJSONArray);
      label316:
      FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
    }
    catch (JSONException localJSONException)
    {
      break label316;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */