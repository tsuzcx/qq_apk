package com.tencent.mobileqq.nearby.profilecard.moment;

import akio;
import akio.c;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$10
  implements Runnable
{
  public NearbyMomentManager$10(akio paramakio, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = akio.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((akio.c)localIterator.next()).No(this.dL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.10
 * JD-Core Version:    0.7.0.1
 */