package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$10
  implements Runnable
{
  public PublicAccountEventReport$10(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2) {}
  
  public void run()
  {
    anot.a(this.val$app, "dc00898", "", this.val$uin, "0X8009EB6", "0X8009EB6", this.val$from, 0, "" + this.val$type, "", this.ad + "", "");
    if (!TextUtils.isEmpty(this.brx)) {
      anot.a(this.val$app, "dc05007", "", this.val$uin, "0X8009EB6", "0X8009EB6", this.val$from, 0, "" + this.val$type, "", this.ad + "", this.brx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.10
 * JD-Core Version:    0.7.0.1
 */