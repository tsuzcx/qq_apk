package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$17
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$17(FileJsPlugin paramFileJsPlugin, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$req.jsonParams);
      long l = System.currentTimeMillis();
      localObject = ((JSONObject)localObject).optString("url");
      if (!URLUtil.isValidUrl((String)localObject))
      {
        this.val$req.fail("invalid url");
        return null;
      }
      String str = FileJsPlugin.access$2500(this.this$0).getTmpPathByUrl((String)localObject);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download((String)localObject, null, str, 60, new FileJsPlugin.17.1(this, l, (String)localObject, str));
      return null;
    }
    catch (JSONException localJSONException)
    {
      this.val$req.fail("downloadWithCache exception");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */