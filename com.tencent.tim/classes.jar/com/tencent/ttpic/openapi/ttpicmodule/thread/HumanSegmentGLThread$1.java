package com.tencent.ttpic.openapi.ttpicmodule.thread;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.ExpFilter;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;

class HumanSegmentGLThread$1
  implements Runnable
{
  HumanSegmentGLThread$1(HumanSegmentGLThread paramHumanSegmentGLThread, EGLContext paramEGLContext, HumanSegmentInitializer paramHumanSegmentInitializer) {}
  
  public void run()
  {
    HumanSegmentGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
    HumanSegmentGLThread.access$102(this.this$0, new OffscreenSurface(HumanSegmentGLThread.access$000(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    HumanSegmentGLThread.access$100(this.this$0).makeCurrent();
    HumanSegmentGLThread.access$200(this.this$0).apply();
    HumanSegmentGLThread.access$300(this.this$0).apply();
    HumanSegmentGLThread.access$400(this.this$0).apply();
    HumanSegmentGLThread.access$502(this.this$0, new GLSegSharedData());
    HumanSegmentGLThread.access$602(this.this$0, new Frame());
    HumanSegmentGLThread.access$702(this.this$0, new Frame());
    HumanSegmentGLThread.access$802(this.this$0, new Frame());
    HumanSegmentGLThread.access$900(this.this$0)[0] = new Frame();
    HumanSegmentGLThread.access$900(this.this$0)[1] = new Frame();
    GLES20.glGenTextures(HumanSegmentGLThread.access$1000(this.this$0).length, HumanSegmentGLThread.access$1000(this.this$0), 0);
    this.this$0.mHumanSegmentInitializer = this.val$humanSegmentInitializer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.thread.HumanSegmentGLThread.1
 * JD-Core Version:    0.7.0.1
 */