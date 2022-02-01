package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import rhy;
import rig;

class DoodleTextureView$1
  implements Runnable
{
  DoodleTextureView$1(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    rig localrig = (rig)this.this$0.a.b(102);
    if (localrig != null)
    {
      localrig.onInit();
      localrig.onSurfaceChanged(this.this$0.mWindowWidth, this.this$0.mWindowHeight);
      this.this$0.a.buu();
      this.this$0.buf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView.1
 * JD-Core Version:    0.7.0.1
 */