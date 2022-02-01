package com.tencent.biz.qqstory.takevideo;

import ram;
import rdc;
import req;

public class HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1
  implements Runnable
{
  public HWEditLocalVideoPlayer$ConvertIFramesRunnable$1$1(req paramreq) {}
  
  public void run()
  {
    HWEditLocalVideoPlayer.a(this.a.b.this$0, null);
    if (!HWEditLocalVideoPlayer.a(this.a.b.this$0))
    {
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
      return;
    }
    if ((this.a.b.this$0.b.b != null) && (this.a.b.this$0.b.b.td() == 3) && (this.a.b.bqF == this.a.b.this$0.bqD)) {
      HWEditLocalVideoPlayer.a(this.a.b.this$0, this.a.a);
    }
    HWEditLocalVideoPlayer.a(this.a.b.this$0);
    HWEditLocalVideoPlayer.a(this.a.b.this$0, this.a.b.this$0.bqD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1
 * JD-Core Version:    0.7.0.1
 */