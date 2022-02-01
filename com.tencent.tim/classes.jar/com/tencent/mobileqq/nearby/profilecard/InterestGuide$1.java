package com.tencent.mobileqq.nearby.profilecard;

import ajrb;
import akbv;
import java.lang.ref.WeakReference;

public final class InterestGuide$1
  implements Runnable
{
  public void run()
  {
    if (((Boolean)ajrb.c(this.val$account, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      akbv.hu = new WeakReference(new akbv(this.val$account, this.val$layout, this.aJf));
      akbv.aA = Boolean.TRUE;
      return;
    }
    akbv.aA = Boolean.FALSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.1
 * JD-Core Version:    0.7.0.1
 */