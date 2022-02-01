package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qgy.e;
import qhi;

public class SimpleDataProvider$5
  implements Runnable
{
  public SimpleDataProvider$5(qhi paramqhi) {}
  
  public void run()
  {
    Iterator localIterator = qhi.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((qgy.e)localIterator.next()).bok();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5
 * JD-Core Version:    0.7.0.1
 */