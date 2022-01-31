package com.tencent.smtt.export.external.extension.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;

public abstract class X5ProxyWebViewClientExtension
  extends ProxyWebViewClientExtension
{
  public X5ProxyWebViewClientExtension(WebViewWizardBase paramWebViewWizardBase)
  {
    this.mWebViewClientExt = ((IX5WebViewClientExtension)paramWebViewWizardBase.newInstance(paramWebViewWizardBase.isDynamicMode(), "com.tencent.smtt.webkit.WebViewClientExtension"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */