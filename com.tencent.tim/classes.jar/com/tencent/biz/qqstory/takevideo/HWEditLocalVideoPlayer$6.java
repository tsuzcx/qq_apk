package com.tencent.biz.qqstory.takevideo;

import rbl;
import rbw;

class HWEditLocalVideoPlayer$6
  implements Runnable
{
  HWEditLocalVideoPlayer$6(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    Object localObject = (rbl)this.this$0.a(rbl.class);
    if (localObject != null) {
      ((rbl)localObject).bsg();
    }
    localObject = (rbw)this.this$0.a(rbw.class);
    if (localObject != null) {
      ((rbw)localObject).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */