package com.tencent.mobileqq.util;

import aqfr;
import com.tencent.mobileqq.app.QQAppInterface;

public final class TroopReportor$1
  implements Runnable
{
  public TroopReportor$1(String paramString1, String paramString2, int paramInt1, int paramInt2, String[] paramArrayOfString, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void run()
  {
    aqfr.b("Grp_edu", this.bTz, this.azN, this.ben, this.bmS, new String[] { this.val$args[0], aqfr.j(this.val$app, this.Uf, this.val$app.getCurrentAccountUin()), this.val$args[2], this.val$args[3] });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.TroopReportor.1
 * JD-Core Version:    0.7.0.1
 */