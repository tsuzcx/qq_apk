package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.Set;
import mye;
import mye.c;
import myf;
import myi;
import mza;

public class VideoPlayManager$1$4
  implements Runnable
{
  public VideoPlayManager$1$4(myf parammyf) {}
  
  public void run()
  {
    mye.a(this.a.this$0, mye.a(this.a.this$0), mye.a(this.a.this$0), 7, null);
    if (mye.a(this.a.this$0) != null)
    {
      Iterator localIterator = mye.a(this.a.this$0).iterator();
      while (localIterator.hasNext())
      {
        mye.c localc = (mye.c)localIterator.next();
        if (localc != null) {
          localc.a(mye.a(this.a.this$0), mye.a(this.a.this$0).EV());
        }
      }
    }
    if (mye.a(this.a.this$0) != null)
    {
      mye.a(this.a.this$0).aVT = -1;
      mye.a(this.a.this$0).xb = 0L;
      mye.c(this.a.this$0, null);
    }
    if (mye.a(this.a.this$0) != null)
    {
      mye.a(this.a.this$0).destory();
      mye.a(this.a.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.1.4
 * JD-Core Version:    0.7.0.1
 */