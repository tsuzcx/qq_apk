package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mye;
import mye.a;
import mye.b;
import myi;

public class VideoPlayManager$2
  implements Runnable
{
  public VideoPlayManager$2(mye parammye, mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (mye.a(this.this$0) != null)
    {
      Iterator localIterator = mye.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mye.a locala = (mye.a)localIterator.next();
        if (locala != null) {
          locala.a(this.b, this.g, this.val$oldState, this.val$newState, this.val$extra);
        }
      }
    }
    mye.a(this.this$0, this.val$newState, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2
 * JD-Core Version:    0.7.0.1
 */