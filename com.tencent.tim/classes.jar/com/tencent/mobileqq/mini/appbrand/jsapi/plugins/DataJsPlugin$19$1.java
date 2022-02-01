package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

class DataJsPlugin$19$1
  implements InternalJSPlugin.openUrlCallback
{
  DataJsPlugin$19$1(DataJsPlugin.19 param19) {}
  
  public void openResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, null, this.this$1.val$callbackId);
      return;
    }
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$event, null, paramString, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.19.1
 * JD-Core Version:    0.7.0.1
 */