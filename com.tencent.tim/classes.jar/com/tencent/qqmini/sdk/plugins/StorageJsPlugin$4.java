package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.DiskLruCacheUtil;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

class StorageJsPlugin$4
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$4(StorageJsPlugin paramStorageJsPlugin, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("limitSize", StorageJsPlugin.access$000(this.this$0).getLimitSize());
      localJSONObject.put("currentSize", StorageJsPlugin.access$000(this.this$0).getCurrentSize());
      Object localObject = StorageJsPlugin.access$000(this.this$0).keys();
      HashSet localHashSet = new HashSet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add(URLUtil.decodeUrl((String)((Iterator)localObject).next()));
        }
      }
      localException.put("keys", DiskLruCacheUtil.setToJSONArray(localHashSet));
    }
    catch (Exception localException)
    {
      QMLog.e("StorageJsPlugin", this.val$req.event + " result error." + localException);
      return this.val$req.fail("json error");
    }
    String str = this.val$req.ok(localException);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */