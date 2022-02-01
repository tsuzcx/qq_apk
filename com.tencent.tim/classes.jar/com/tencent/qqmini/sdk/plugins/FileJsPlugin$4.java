package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$4
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$4(FileJsPlugin paramFileJsPlugin, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = new JSONObject(this.val$req.jsonParams).optString("path");
      String str2 = ((MiniAppFileManager)FileJsPlugin.access$900(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(str1);
      if ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()))
      {
        FileJsPlugin.access$1000(this.this$0, this.val$req.event, false, this.val$startMS, l, str2);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null, "no such file or directory \"" + str1 + "\"");
      }
      FileJsPlugin.access$1000(this.this$0, this.val$req.event, true, this.val$startMS, l, str2);
      str1 = FileJsPlugin.access$1200(this.this$0, this.val$req, null);
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */