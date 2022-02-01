package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import aqzv;
import ardm.n;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    aqzv localaqzv = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.n))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131693404), 0).show(((ardm.n)localaqzv).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */