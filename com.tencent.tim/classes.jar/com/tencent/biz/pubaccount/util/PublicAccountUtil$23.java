package com.tencent.biz.pubaccount.util;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import nyn;

public final class PublicAccountUtil$23
  implements Runnable
{
  public PublicAccountUtil$23(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    String str = "0X80067EA";
    nyn localnyn = nyn.a();
    int i = localnyn.rc();
    int j = localnyn.c(this.val$app);
    if (j == 1) {
      str = "0X80067E8";
    }
    for (;;)
    {
      long l = localnyn.dn();
      anot.a(this.val$app, "dc01160", "Pb_account_lifeservice", "", str, str, 0, 0, "" + l, "" + j, "" + i, String.valueOf(this.val$position + 1));
      anot.a(this.val$app, "dc00898", "", "", "auth_entry", "clk_msg", 0, 0, "", "", "", "");
      return;
      if (j == 2) {
        str = "0X80067E9";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.23
 * JD-Core Version:    0.7.0.1
 */