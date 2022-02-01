package com.tencent.mobileqq.nearby.profilecard.moment;

import akio;
import akio.c;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$9
  implements Runnable
{
  public NearbyMomentManager$9(akio paramakio, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = akio.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((akio.c)localIterator.next()).au(this.dL, this.val$totalCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.9
 * JD-Core Version:    0.7.0.1
 */