package com.tencent.mobileqq.confess;

import aegy;
import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class ConfessPlugin$5$1
  implements Runnable
{
  ConfessPlugin$5$1(ConfessPlugin.5 param5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap) {}
  
  public void run()
  {
    ConfessPlugin.a(this.a.this$0);
    Activity localActivity = this.a.this$0.mRuntime.getActivity();
    AppInterface localAppInterface = this.a.this$0.mRuntime.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("processShare activity=").append(localActivity).append("  app=").append(localAppInterface).append(" finishing?");
      if ((localActivity == null) || (!localActivity.isFinishing())) {
        break label209;
      }
    }
    label209:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ConfessPlugin", 2, bool + " share_type=" + this.a.cMS + " share_url:" + this.a.ake + " new_share_url:" + this.bxn + " imageUrl:" + this.val$imageUrl + " new_srcUrl:" + this.bxo + " new_srcIconUrl:" + this.bxp);
      if ((localActivity != null) && (localAppInterface != null) && (!localActivity.isFinishing())) {
        break;
      }
      ConfessPlugin.a(this.a.this$0, false);
      return;
    }
    switch (this.a.cMS)
    {
    default: 
      return;
    case 0: 
      ConfessPlugin.a(this.a.this$0, this.val$imageUrl, this.a.val$title, this.bxn, this.a.aHs, String.valueOf(this.a.cMT), this.bxo, this.bxp, this.a.val$desc, this.a.bTO);
      return;
    case 1: 
      ConfessPlugin.a(this.a.this$0, localAppInterface, localActivity, this.val$filePath, this.a.val$title, this.a.ake, this.a.val$desc);
      return;
    }
    if (this.a.this$0.a == null)
    {
      this.a.this$0.a = new aegy(this);
      WXShareHelper.a().a(this.a.this$0.a);
    }
    if (this.a.cMS == 2)
    {
      WXShareHelper.a().b(this.val$filePath, this.ff, 0);
      return;
    }
    WXShareHelper.a().b(this.val$filePath, this.ff, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */