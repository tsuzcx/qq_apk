package com.tencent.av;

import igv;
import iiv;

class VideoController$36
  implements Runnable
{
  VideoController$36(VideoController paramVideoController, String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    iiv localiiv = this.this$0.b.c(this.val$sessionId);
    if ((!this.this$0.OB) && (localiiv != null) && (localiiv.uinType != 21) && (localiiv.uinType != 1011)) {
      this.this$0.a(this.val$sessionId, localiiv.amK, false, false, true);
    }
    this.this$0.a(this.kQ, this.val$sessionId, this.alR, this.My, this.Mz, this.Pd, false, this.Pe, this.alS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.36
 * JD-Core Version:    0.7.0.1
 */