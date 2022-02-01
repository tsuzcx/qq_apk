package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import sqq;
import sqr;
import sqv;

public class MediaCodecGLFrameFetcher$3
  implements Runnable
{
  public MediaCodecGLFrameFetcher$3(sqr paramsqr) {}
  
  public void run()
  {
    if (sqr.a(this.this$0) == null) {
      return;
    }
    sqr.a(this.this$0).updateTexImage();
    GLES20.glViewport(0, 0, sqr.a(this.this$0), sqr.b(this.this$0));
    sqr.a(this.this$0).drawFrame(sqr.a(this.this$0), sqr.c(this.this$0));
    if ((sqr.a(this.this$0) != null) && (!sqr.a(this.this$0).isRecycled())) {
      sqr.a(this.this$0).recycle();
    }
    sqr.a(this.this$0, sqq.a(sqr.c(this.this$0), sqr.a(this.this$0), sqr.b(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
 * JD-Core Version:    0.7.0.1
 */