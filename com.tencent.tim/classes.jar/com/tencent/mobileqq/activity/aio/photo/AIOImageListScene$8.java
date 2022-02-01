package com.tencent.mobileqq.activity.aio.photo;

import xsi;
import xto;
import xtp;
import xuf;

public class AIOImageListScene$8
  implements Runnable
{
  public AIOImageListScene$8(xtp paramxtp, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.c != null)
    {
      xuf localxuf = this.this$0.c.c();
      if (this.this$0.c.a(this.kQ) != null) {
        this.this$0.notifyDataSetChanged();
      }
      if ((this.bjl) && (localxuf != null) && (this.kQ == localxuf.e.id)) {
        xsi.bC(xtp.p(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8
 * JD-Core Version:    0.7.0.1
 */