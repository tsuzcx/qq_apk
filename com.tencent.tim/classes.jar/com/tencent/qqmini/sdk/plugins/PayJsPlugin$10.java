package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;

class PayJsPlugin$10
  implements Runnable
{
  PayJsPlugin$10(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, RequestEvent paramRequestEvent, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", this.val$callbackSn);
    localBundle.putString("payparmas_json", PayJsPlugin.access$1000(this.this$0, this.val$payJson));
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", System.currentTimeMillis());
    localBundle.putInt("payparmas_request_code", 6);
    localBundle.putString("payparmas_sdk_pf", PayJsPlugin.access$1100(this.this$0, this.val$payJson));
    PayProxy localPayProxy = (PayProxy)ProxyManager.get(PayProxy.class);
    if (localPayProxy == null) {
      PayJsPlugin.access$700(this.this$0, this.val$req, null, "not support pay");
    }
    for (;;)
    {
      return;
      localBundle = localPayProxy.midasPay(this.val$activity, PayJsPlugin.access$1000(this.this$0, this.val$payJson), new PayJsPlugin.10.1(this), localBundle);
      if (localBundle != null) {}
      for (int i = localBundle.getInt("retCode", 0); (localBundle != null) && (i != 0); i = 0)
      {
        PayJsPlugin.access$700(this.this$0, this.val$req, null, "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */