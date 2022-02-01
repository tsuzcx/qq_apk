package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class StoragePlugin$5
  implements StoragePlugin.StorageTask
{
  StoragePlugin$5(StoragePlugin paramStoragePlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    if (StoragePlugin.access$200(this.this$0).removeStorage(this.val$key_real)) {
      return StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "remove failed", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.5
 * JD-Core Version:    0.7.0.1
 */