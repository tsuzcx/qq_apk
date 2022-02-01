package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import aqha;
import aqju;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.this$0.jsPluginEngine.getActivityContext(), 230, acfp.m(2131707385), acfp.m(2131707384), acfp.m(2131707386), acfp.m(2131707383), new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */