package com.tencent.mobileqq.ar.view;

import adcl;
import adec;
import adku;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import anot;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.BaseApplication;

class ARScanEntryView$23
  implements Runnable
{
  ARScanEntryView$23(ARScanEntryView paramARScanEntryView, adec paramadec, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.b.b.businessId != 1) && (this.b.b.a != null) && (this.b.b.a.bNZ) && (!TextUtils.isEmpty(this.b.b.a.but)) && (this.bLV == 0)) {
      if (this.b.b.a.bOa)
      {
        anot.a(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.b.b.picId, "1", "1", "");
        ARScanEntryView.a(this.this$0, true);
        if (ARScanEntryView.a(this.this$0) != null)
        {
          ARScanEntryView.a(this.this$0).iM(1L);
          ARScanEntryView.a(this.this$0).cSn();
        }
        this.this$0.bAH();
      }
    }
    do
    {
      return;
      anot.a(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, this.b.b.picId, "1", "0", "");
      if (this.b.b.aeh()) {
        anot.a(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.b.b.picId, "1", "0", "");
      }
      Object localObject = (Activity)this.this$0.mContext;
      String str = this.b.b.a.but;
      ((Activity)localObject).setResult(11);
      adcl.a().KB(2);
      if (this.this$0.kY(str))
      {
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(str));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject).setPackage(this.this$0.mAppInterface.getApp().getPackageName());
        this.this$0.mContext.startActivity((Intent)localObject);
      }
      for (;;)
      {
        if ((ARScanEntryView.a(this.this$0) != null) && (!ARScanEntryView.a(this.this$0).b.aei())) {
          this.this$0.mAppInterface.reportClickEvent("CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", this.this$0.mAppInterface.getCurrentAccountUin(), ARScanEntryView.a(this.this$0).b.picId, "2");
        }
        ARScanEntryView.b(this.this$0, true);
        return;
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
        localIntent.putExtra("url", this.this$0.jS(str));
        ((Activity)localObject).startActivity(localIntent);
      }
      ARScanEntryView.d(this.this$0);
    } while (!this.bPy);
    ARScanEntryView.h(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.23
 * JD-Core Version:    0.7.0.1
 */