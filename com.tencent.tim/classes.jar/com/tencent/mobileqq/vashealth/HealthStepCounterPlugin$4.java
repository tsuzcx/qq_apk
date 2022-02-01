package com.tencent.mobileqq.vashealth;

import acfp;
import aqtm;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;

public class HealthStepCounterPlugin$4
  implements Runnable
{
  public HealthStepCounterPlugin$4(aqtm paramaqtm) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.this$0.mRuntime.getWebView().getContext());
    QQToast.a(this.this$0.mRuntime.getWebView().getContext(), acfp.m(2131707133), 0).show((int)(localQQToast.getStatusBarHeight() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.4
 * JD-Core Version:    0.7.0.1
 */