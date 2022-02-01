package com.tencent.mobileqq.filemanager.core;

import aglz;
import aglz.a;
import ahcj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$14
  implements Runnable
{
  public UniformDownloadMgr$14(aglz paramaglz) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (aglz.a(this.this$0))
    {
      if (aglz.a(this.this$0).size() > 0)
      {
        Iterator localIterator = aglz.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          aglz.a locala = (aglz.a)((Map.Entry)localIterator.next()).getValue();
          if ((locala != null) && (locala.a != null) && (locala.a.amN()) && (2 == locala.a.getType())) {
            localArrayList.add(locala);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((aglz.a)((Iterator)???).next()).a.EO();
    }
    aglz.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.14
 * JD-Core Version:    0.7.0.1
 */