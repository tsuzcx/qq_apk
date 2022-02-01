package com.tencent.mobileqq.applets;

import adak;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PublicAccountEventReport$6
  implements Runnable
{
  public PublicAccountEventReport$6(String paramString1, String paramString2, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    String str1 = this.val$UIN;
    String str2 = this.brx;
    if ((this.val$flag != 0) || (this.cBq > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      adak.b(str1, 102, str2, bool);
      anot.a(this.val$app, "dc00898", "", this.val$UIN, "0X8009EB4", "0X8009EB4", 1, 0, this.val$flag + "", this.cBq + "", this.val$message, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.6
 * JD-Core Version:    0.7.0.1
 */