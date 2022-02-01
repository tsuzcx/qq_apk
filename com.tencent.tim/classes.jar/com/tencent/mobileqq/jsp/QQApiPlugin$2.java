package com.tencent.mobileqq.jsp;

import aiju;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jqg;

public class QQApiPlugin$2
  implements Runnable
{
  public QQApiPlugin$2(aiju paramaiju, String paramString1, String paramString2, String paramString3, Activity paramActivity, ApplicationInfo paramApplicationInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina download image:" + this.akc);
    }
    String str = jqg.a(BaseApplication.getContext(), this.akc, null);
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.val$title + this.ake);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    FileProvider7Helper.intentCompatForN(this.val$activity, localIntent);
    localIntent.setPackage(this.a.packageName);
    this.val$activity.startActivity(localIntent);
    this.val$activity.runOnUiThread(new QQApiPlugin.2.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina start weibo!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */