package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jqg;
import kxm;
import mso;

public class TopicShareHelper$6
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina download image:" + this.akc);
    }
    String str = jqg.a(mso.a(this.this$0), this.akc, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina path:" + str);
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(268435456);
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.TEXT", this.akd + this.ake);
    if (!TextUtils.isEmpty(str)) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
    }
    localIntent.setPackage(this.a.packageName);
    if (mso.a(this.this$0) != null) {}
    for (int i = mso.a(this.this$0).mChannelID;; i = 0)
    {
      localIntent.putExtra("big_brother_source_key", kxm.bg(i));
      FileProvider7Helper.intentCompatForN(this.val$activity, localIntent);
      this.val$activity.startActivity(localIntent);
      this.val$activity.runOnUiThread(new TopicShareHelper.6.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina start weibo!");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.6
 * JD-Core Version:    0.7.0.1
 */