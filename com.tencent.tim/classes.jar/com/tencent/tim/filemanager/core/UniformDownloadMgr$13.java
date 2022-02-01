package com.tencent.tim.filemanager.core;

import ahcj;
import atur;
import atur.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniformDownloadMgr$13
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (atur.a(this.this$0))
    {
      if (atur.a(this.this$0).size() > 0)
      {
        Iterator localIterator = atur.a(this.this$0).entrySet().iterator();
        while (localIterator.hasNext())
        {
          atur.a locala = (atur.a)((Map.Entry)localIterator.next()).getValue();
          if ((locala != null) && (locala.a != null) && (locala.a.amN()) && (2 == locala.a.getType())) {
            localArrayList.add(locala);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((atur.a)((Iterator)???).next()).a.EO();
    }
    atur.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.13
 * JD-Core Version:    0.7.0.1
 */