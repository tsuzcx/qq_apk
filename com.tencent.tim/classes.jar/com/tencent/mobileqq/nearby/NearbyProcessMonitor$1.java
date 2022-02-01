package com.tencent.mobileqq.nearby;

import ajqo;
import ajrb;

public final class NearbyProcessMonitor$1
  implements Runnable
{
  public NearbyProcessMonitor$1(String paramString) {}
  
  public void run()
  {
    ajqo.MK(this.val$account);
    ajqo.MJ(this.val$account);
    ajqo.dkF += 1;
    ajrb.MP(this.val$account);
    ajqo.dyK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProcessMonitor.1
 * JD-Core Version:    0.7.0.1
 */