package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class StoragePlugin$2
  implements Runnable
{
  StoragePlugin$2(StoragePlugin paramStoragePlugin, String paramString1, String paramString2, String paramString3, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    StoragePlugin.access$200(this.this$0).write(this.val$key_real, this.val$data, this.val$dataType, new StoragePlugin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.2
 * JD-Core Version:    0.7.0.1
 */