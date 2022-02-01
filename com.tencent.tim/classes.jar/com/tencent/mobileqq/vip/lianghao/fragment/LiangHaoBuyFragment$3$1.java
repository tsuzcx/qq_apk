package com.tencent.mobileqq.vip.lianghao.fragment;

import android.content.Intent;
import aqwo;

public class LiangHaoBuyFragment$3$1
  implements Runnable
{
  public LiangHaoBuyFragment$3$1(aqwo paramaqwo, boolean paramBoolean, Intent paramIntent, String paramString1, byte[] paramArrayOfByte, String paramString2) {}
  
  public void run()
  {
    LiangHaoBuyFragment.c(this.a.a);
    if (this.bgh)
    {
      LiangHaoBuyFragment.a(this.a.a, this.val$intent);
      LiangHaoBuyFragment.a(this.a.a, this.cyp, this.gJ);
      return;
    }
    LiangHaoBuyFragment.a(this.a.a, this.val$errorMsg);
    LiangHaoBuyFragment.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment.3.1
 * JD-Core Version:    0.7.0.1
 */