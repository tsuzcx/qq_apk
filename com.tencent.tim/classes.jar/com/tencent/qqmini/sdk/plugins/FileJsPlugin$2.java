package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import java.util.Map;
import org.json.JSONObject;

class FileJsPlugin$2
  implements Runnable
{
  FileJsPlugin$2(FileJsPlugin paramFileJsPlugin, String paramString1, Map paramMap, String paramString2, String paramString3, RequestEvent paramRequestEvent, long paramLong, MiniAppFileManager paramMiniAppFileManager, int paramInt, JSONObject paramJSONObject, String paramString4) {}
  
  public void run()
  {
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(this.val$downloadUrl, this.val$header, this.val$filePath, 60, new FileJsPlugin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */