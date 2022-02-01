package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;

class VideoJsPlugin$8
  implements Runnable
{
  VideoJsPlugin$8(VideoJsPlugin paramVideoJsPlugin, AppBrandRuntime paramAppBrandRuntime, String paramString) {}
  
  public void run()
  {
    this.val$runtime.pageContainer.getCurrentPage().updateToastMsg(this.val$title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VideoJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */