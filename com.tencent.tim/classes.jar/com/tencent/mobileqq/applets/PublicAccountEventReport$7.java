package com.tencent.mobileqq.applets;

import abcx;
import adak;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import xki;

public final class PublicAccountEventReport$7
  implements Runnable
{
  public PublicAccountEventReport$7(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.val$uin;
    String str2 = this.brx;
    if ((this.val$flag != 0) || (this.cBp > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      adak.b(str1, 138, str2, bool);
      anot.a(this.val$app, "dc00898", "", this.val$uin, "0X8009EB4", "0X8009EB4", 2, 0, this.val$flag + "", this.cBp + "", this.val$message, "");
      if (xki.hN(this.val$uin)) {
        abcx.a().bS(this.val$app);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.7
 * JD-Core Version:    0.7.0.1
 */