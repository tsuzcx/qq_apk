package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jqg;
import odm;

public class ReadInjoyWebShareHelper$6
  implements Runnable
{
  public ReadInjoyWebShareHelper$6(odm paramodm, String paramString1, String paramString2, String paramString3, ApplicationInfo paramApplicationInfo, Activity paramActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina download image:" + this.akc);
    }
    String str = jqg.a(BaseApplication.getContext(), this.akc, null);
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.val$title + this.ake);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    localIntent.setPackage(this.a.packageName);
    this.val$activity.startActivity(localIntent);
    this.val$activity.runOnUiThread(new ReadInjoyWebShareHelper.6.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.6
 * JD-Core Version:    0.7.0.1
 */