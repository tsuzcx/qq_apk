package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import aqzv;
import ardm.n;
import arhz;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

class MQPSecJsPlugin$2
  implements Runnable
{
  MQPSecJsPlugin$2(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) == null) && (!this.this$0.activity.isFinishing()))
      {
        aqzv localaqzv = this.this$0.mRuntime.a(this.this$0.mRuntime.getActivity());
        if ((localaqzv != null) && ((localaqzv instanceof ardm.n)))
        {
          MQPSecJsPlugin.access$102(this.this$0, new arhz(this.this$0.activity, ((ardm.n)localaqzv).getTitleBarHeight()));
          MQPSecJsPlugin.access$100(this.this$0).setCancelable(false);
          MQPSecJsPlugin.access$100(this.this$0).setMessage(2131696693);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (!MQPSecJsPlugin.access$100(this.this$0).isShowing())) {
      MQPSecJsPlugin.access$100(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */