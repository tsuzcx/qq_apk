package com.tencent.qidian;

import aqhv;
import aqik;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class QidianWebViewFragment
  extends WebViewFragment
{
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("mqqwpa://")) && (paramString.contains("request=videochat"))) {
      try
      {
        aqhv localaqhv = aqik.c(null, getActivity(), paramString);
        if (localaqhv != null)
        {
          boolean bool = localaqhv.ace();
          return bool;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianWebViewFragment", 2, "shouldOverrideUrlLoading " + localException.getMessage());
        }
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianWebViewFragment
 * JD-Core Version:    0.7.0.1
 */