package com.tencent.mobileqq.applets;

import adak;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$3
  implements Runnable
{
  public PublicAccountEventReport$3(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.val$uin;
    String str2 = this.val$r5;
    if ((this.val$flag != 0) || (this.cBp > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      adak.b(str1, 101, str2, bool);
      anot.a(this.val$app, "dc00898", "", this.val$uin, "0X8009EB3", "0X8009EB3", 1, 0, this.val$flag + "", this.cBp + "", this.val$message, "");
      if (!TextUtils.isEmpty(this.val$r5)) {
        anot.a(this.val$app, "dc05007", "", this.val$uin, "0X8009EB3", "0X8009EB3", 1, 0, this.val$flag + "", this.cBp + "", this.val$message, this.val$r5);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.3
 * JD-Core Version:    0.7.0.1
 */