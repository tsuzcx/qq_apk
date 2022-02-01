package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$19
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$19(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$path) == 9999)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$path);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$path, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$path);
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str1);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$path, this.val$callbackId);
    }
    boolean bool = this.this$0.jsPluginEngine instanceof GameJsPluginEngine;
    String str2;
    if ((this.val$recursive) && (((File)localObject).isDirectory()))
    {
      try
      {
        JSONObject localJSONObject1 = FileUtils.getStatsByDir(str1);
        if (localJSONObject1 == null) {
          break label544;
        }
        if ("statSync".equals(this.val$event))
        {
          FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str1);
          return localJSONObject1.toString();
        }
        if (bool)
        {
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("stats", localJSONObject1);
            FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str1);
            return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              GameLog.getInstance().e("[mini] FileJsPlugin", "stat error:", localJSONException1);
            }
          }
        }
        str2 = FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, localJSONException1, this.val$callbackId);
      }
      catch (Exception localException)
      {
        QLog.e("[mini] FileJsPlugin", 1, " API_STAT error : " + localException);
        return "";
      }
      return str2;
    }
    else
    {
      JSONObject localJSONObject2 = FileUtils.getStats(str2);
      if (localJSONObject2 != null)
      {
        if ("statSync".equals(this.val$event))
        {
          FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str2);
          return localJSONObject2.toString();
        }
        if (bool)
        {
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("stats", localJSONObject2);
            FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str2);
            return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              GameLog.getInstance().e("[mini] FileJsPlugin", "stat error:", localJSONException2);
            }
          }
        }
        return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, localJSONException2, this.val$callbackId);
      }
    }
    label544:
    FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str2);
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */