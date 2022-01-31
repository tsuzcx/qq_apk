package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public abstract class X5ProxyWebViewClient
  extends ProxyWebViewClient
{
  public X5ProxyWebViewClient(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebViewClient = ((IX5WebViewClient)paramWebViewWizardBase.newInstance(paramWebViewWizardBase.isDynamicMode(), "com.tencent.smtt.webkit.WebViewClient"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient
 * JD-Core Version:    0.7.0.1
 */