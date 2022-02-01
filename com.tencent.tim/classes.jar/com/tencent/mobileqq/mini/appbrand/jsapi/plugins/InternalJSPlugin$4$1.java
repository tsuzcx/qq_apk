package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class InternalJSPlugin$4$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$4$1(InternalJSPlugin.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(this.this$1.val$appParameter);
        if (!bool) {
          try
          {
            paramDialogInterface = new JSONObject(this.this$1.val$appParameter);
            if ((paramDialogInterface.has("path")) && (!TextUtils.isEmpty(paramDialogInterface.optString("path"))))
            {
              paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(paramDialogInterface.optString("path")));
              if (paramDialogInterface == null) {
                break label368;
              }
              paramDialogInterface.setPackage(this.this$1.val$packageName);
              paramDialogInterface.addFlags(67108864);
              paramDialogInterface.putExtra("big_brother_source_key", "biz_src_miniapp");
              if (paramDialogInterface.resolveActivity(this.this$1.val$activity.getPackageManager()) == null) {
                break;
              }
              this.this$1.val$activity.startActivity(paramDialogInterface);
              this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
              InnerAppReportDc4239.innerAppReport(this.this$1.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "openapp", null);
              return;
            }
            localIntent = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
            paramDialogInterface = localIntent;
            if (localIntent == null) {
              continue;
            }
            localIntent.putExtra("appParameter", this.this$1.val$appParameter);
            paramDialogInterface = localIntent;
            continue;
          }
          catch (Throwable paramDialogInterface)
          {
            QLog.e("InternalJSPlugin", 1, "parameter error,", paramDialogInterface);
            Intent localIntent = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
            paramDialogInterface = localIntent;
            if (localIntent == null) {
              continue;
            }
            localIntent.putExtra("appParameter", this.this$1.val$appParameter);
            paramDialogInterface = localIntent;
            continue;
          }
        }
        paramDialogInterface = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
      }
      catch (Throwable paramDialogInterface)
      {
        QLog.e("InternalJSPlugin", 1, "dialog click error,", paramDialogInterface);
        return;
      }
    }
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
    return;
    label368:
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$eventName, null, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */