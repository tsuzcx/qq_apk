package com.tencent.mobileqq.utils;

import aqgv;
import aqgv.b;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ContactUtils$1
  implements Runnable
{
  public ContactUtils$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, aqgv.b paramb) {}
  
  public void run()
  {
    String str = aqgv.c(this.val$app, this.Uf, this.aMs, true);
    if (this.a != null) {
      this.a.vt(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils.1
 * JD-Core Version:    0.7.0.1
 */