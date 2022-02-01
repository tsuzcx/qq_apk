package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import sst;

public class BusinessReportPlugin$1
  implements Runnable
{
  public BusinessReportPlugin$1(sst paramsst, String paramString) {}
  
  public void run()
  {
    String str1 = this.val$url;
    String str2 = this.this$0.mRuntime.getWebView().getUrl();
    this.this$0.postPluginAsyncTask(new BusinessReportPlugin.1.1(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */