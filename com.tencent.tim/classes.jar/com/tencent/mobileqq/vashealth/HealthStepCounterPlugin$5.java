package com.tencent.mobileqq.vashealth;

import acfp;
import aqtm;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;

public class HealthStepCounterPlugin$5
  implements Runnable
{
  public HealthStepCounterPlugin$5(aqtm paramaqtm) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.this$0.mRuntime.getWebView().getContext());
    QQToast.a(this.this$0.mRuntime.getWebView().getContext(), acfp.m(2131707130), 0).show((int)(localQQToast.getStatusBarHeight() * 2.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.5
 * JD-Core Version:    0.7.0.1
 */