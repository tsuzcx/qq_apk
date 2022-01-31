package com.tencent.smtt.export.external.extension.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;

public abstract class X5ProxyWebChromeClientExtension
  extends ProxyWebChromeClientExtension
{
  public X5ProxyWebChromeClientExtension(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebChromeClient = ((IX5WebChromeClientExtension)paramWebViewWizardBase.newInstance(paramWebViewWizardBase.isDynamicMode(), "com.tencent.smtt.webkit.WebChromeClientExtension"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.X5ProxyWebChromeClientExtension
 * JD-Core Version:    0.7.0.1
 */