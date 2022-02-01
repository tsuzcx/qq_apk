package com.tencent.mobileqq.nearby;

import acig;
import ajra;
import ajra.a;
import aure;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(ajra paramajra, aure paramaure, acig paramacig, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.l.size())
    {
      localArrayList.add((ajra.a)this.l.valueAt(i));
      i += 1;
    }
    this.b.ak(localArrayList, this.cpS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */