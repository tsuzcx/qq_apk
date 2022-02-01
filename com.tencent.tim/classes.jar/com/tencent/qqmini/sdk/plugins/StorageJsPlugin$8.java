package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class StorageJsPlugin$8
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$8(StorageJsPlugin paramStorageJsPlugin, String paramString1, String paramString2, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    if (!TextUtils.isEmpty(this.val$key_real))
    {
      StorageJsPlugin.access$100(this.this$0).edit().putString(this.val$key_real, this.val$data).apply();
      return this.val$req.ok();
    }
    return this.val$req.fail("key is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */