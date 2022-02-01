package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.aio.PokePanel.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import xbu;
import xks;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(xbu paramxbu) {}
  
  public void run()
  {
    Object localObject = xks.a(this.this$0.mApp, xbu.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PokePanel.a locala = (PokePanel.a)((Iterator)localObject).next();
        xbu.a(this.this$0).put(Integer.valueOf(locala.resId), Integer.valueOf(locala.feeType));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */