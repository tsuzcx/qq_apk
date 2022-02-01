package com.tencent.biz.videostory.video;

import android.opengl.EGLContext;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import sqw;

public class SimpleGLThread$1
  implements Runnable
{
  public SimpleGLThread$1(sqw paramsqw, EGLContext paramEGLContext) {}
  
  public void run()
  {
    sqw.a(this.this$0, new EglCore(this.val$shareContext, 0));
    sqw.a(this.this$0, new OffscreenSurface(sqw.a(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    sqw.a(this.this$0).makeCurrent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.1
 * JD-Core Version:    0.7.0.1
 */