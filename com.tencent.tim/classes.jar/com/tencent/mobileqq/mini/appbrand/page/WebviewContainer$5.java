package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;

class WebviewContainer$5
  implements Runnable
{
  WebviewContainer$5(WebviewContainer paramWebviewContainer, String paramString) {}
  
  public void run()
  {
    this.this$0.appBrandRuntime.pageContainer.getCurrentPage().showToastView(1, "loading", null, this.val$title, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.5
 * JD-Core Version:    0.7.0.1
 */