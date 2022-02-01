package com.tencent.av.ui;

import izm;

class VideoLayerUI$10
  implements Runnable
{
  long time = 0L;
  
  VideoLayerUI$10(VideoLayerUI paramVideoLayerUI, long paramLong, izm paramizm, float paramFloat) {}
  
  public void run()
  {
    long l = this.time;
    this.time = (1L + l);
    if (l < this.pc)
    {
      this.c.a(this.hW, VideoLayerUI.c(this.this$0), VideoLayerUI.d(this.this$0));
      this.c.postDelayed(this, 10L);
      return;
    }
    this.c.g(0, 0, true);
    VideoLayerUI.a(this.this$0, -1);
    VideoLayerUI.b(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.10
 * JD-Core Version:    0.7.0.1
 */