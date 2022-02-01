package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qgy.d;
import qgy.e;
import qhi;

public class SimpleDataProvider$6
  implements Runnable
{
  public SimpleDataProvider$6(qhi paramqhi, qgy.d paramd, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = qhi.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((qgy.e)localIterator.next()).a(this.b.d, this.val$vid, this.aDt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6
 * JD-Core Version:    0.7.0.1
 */