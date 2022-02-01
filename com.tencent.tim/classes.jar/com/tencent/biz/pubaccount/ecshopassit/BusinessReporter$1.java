package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import kdl;
import sst;

public final class BusinessReporter$1
  implements Runnable
{
  public BusinessReporter$1(String paramString, WebViewPluginEngine paramWebViewPluginEngine) {}
  
  public void run()
  {
    
    if ((kdl.dq(this.Yk)) && (this.a != null))
    {
      this.a.aa(new String[] { "JD_REPORT" });
      WebViewPlugin localWebViewPlugin = this.a.b("JD_REPORT");
      if (localWebViewPlugin != null) {
        ((sst)localWebViewPlugin).tF(this.Yk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessReporter.1
 * JD-Core Version:    0.7.0.1
 */