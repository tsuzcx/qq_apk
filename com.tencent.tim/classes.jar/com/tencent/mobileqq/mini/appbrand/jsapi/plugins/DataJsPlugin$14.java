package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import Wallet.FocusMpIdRsp;
import acfp;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.BusinessObserver;

class DataJsPlugin$14
  implements BusinessObserver
{
  DataJsPlugin$14(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (FocusMpIdRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle == null) || (paramBundle.err_code != 0))
    {
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      QQToast.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, acfp.m(2131704609), 1).show(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    QQToast.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, 0, acfp.m(2131704613), 1).show(this.this$0.jsPluginEngine.appBrandRuntime.activity.getResources().getDimensionPixelSize(2131299627));
    this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */