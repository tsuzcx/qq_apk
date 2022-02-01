package com.tencent.biz.pubaccount.readinjoy.common;

import kbp;
import nce;
import nce.a;

public final class ReadInJoyUtils$5
  implements Runnable
{
  public ReadInJoyUtils$5(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString1, boolean paramBoolean2, String paramString2) {}
  
  public void run()
  {
    String str = new nce.a(null, null, null, null).f(this.aiv).H(this.aMG).a(this.aMH).G(this.val$businessType).g(this.tc).i(this.adA).a().toJsonString();
    if (this.val$isSuccess) {}
    for (int i = 1;; i = 0)
    {
      kbp.a(null, "", "0X80094FD", "0X80094FD", 0, i, "", "", this.Vu, str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.5
 * JD-Core Version:    0.7.0.1
 */