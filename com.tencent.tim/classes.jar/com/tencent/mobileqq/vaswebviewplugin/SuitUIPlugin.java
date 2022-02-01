package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class SuitUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (localWebViewFragment != null) {
      localWebViewFragment.mUrl = super.decodeUrl(localWebViewFragment.mUrl);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 262144L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin
 * JD-Core Version:    0.7.0.1
 */