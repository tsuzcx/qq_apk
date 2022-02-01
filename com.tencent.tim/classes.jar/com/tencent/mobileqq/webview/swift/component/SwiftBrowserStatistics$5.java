package com.tencent.mobileqq.webview.swift.component;

import arbz;
import arcw;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import jqc;

public class SwiftBrowserStatistics$5
  implements Runnable
{
  public SwiftBrowserStatistics$5(arbz paramarbz, TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString) {}
  
  public void run()
  {
    int m = 1;
    int i;
    int n;
    int i1;
    int j;
    label38:
    label48:
    String str;
    if (this.k.getX5WebViewExtension() != null)
    {
      i = 1;
      n = QbSdk.getTbsVersion(BaseApplicationImpl.getContext());
      i1 = WebView.getTbsSDKVersion(BaseApplicationImpl.getContext());
      if (!WebProcessManager.aFR()) {
        break label138;
      }
      j = 1;
      if (!this.this$0.isWebViewCache) {
        break label143;
      }
      switch (jqc.getNetWorkType())
      {
      case 0: 
      default: 
        str = "";
      }
    }
    for (;;)
    {
      arcw.a(i, n, i1, j, m, str, this.val$url, this.eej, this.eek, this.eel, this.eem, this.een, this.ii);
      return;
      i = 0;
      break;
      label138:
      j = 0;
      break label38;
      label143:
      m = 0;
      break label48;
      str = " UNKNOWN";
      continue;
      str = "WIFI";
      continue;
      str = "2G";
      continue;
      str = "3G";
      continue;
      str = "4G";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.5
 * JD-Core Version:    0.7.0.1
 */