package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import aymk;
import aymu;

class DoodleTextureView$1
  implements Runnable
{
  DoodleTextureView$1(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    aymu localaymu = (aymu)this.this$0.a.b(102);
    if (localaymu != null)
    {
      localaymu.onInit();
      localaymu.onSurfaceChanged(this.this$0.mWindowWidth, this.this$0.mWindowHeight);
      this.this$0.a.buu();
      this.this$0.buf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView.1
 * JD-Core Version:    0.7.0.1
 */