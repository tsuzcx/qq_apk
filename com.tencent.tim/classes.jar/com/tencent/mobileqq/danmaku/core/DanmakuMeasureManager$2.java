package com.tencent.mobileqq.danmaku.core;

import aexc;
import aexc.a;
import aexe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmakuMeasureManager$2
  implements Runnable
{
  public DanmakuMeasureManager$2(aexc paramaexc, List paramList, aexc.a parama) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.zh).iterator();
    while (localIterator.hasNext())
    {
      aexe localaexe = (aexe)localIterator.next();
      aexc.a(aexc.a(this.this$0), localaexe);
      if (this.a != null) {
        this.a.h(localaexe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */