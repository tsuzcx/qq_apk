package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.concurrent.atomic.AtomicInteger;
import qhi;
import ram;

public class SimpleDataProvider$4
  implements Runnable
{
  public SimpleDataProvider$4(qhi paramqhi) {}
  
  public void run()
  {
    int i = qhi.a(this.this$0).getAndSet(1);
    if (i > 1)
    {
      ram.b("Q.qqstory.player.data.SimpleDataProvider", "post result combine count:%d", Integer.valueOf(i));
      qhi.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4
 * JD-Core Version:    0.7.0.1
 */