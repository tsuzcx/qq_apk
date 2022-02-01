package com.tencent.ttpic.openapi.ttpicmodule.thread;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.view.RendererUtils;
import java.util.HashMap;
import java.util.Map;

class HumanSegmentGLThread$2
  implements Runnable
{
  HumanSegmentGLThread$2(HumanSegmentGLThread paramHumanSegmentGLThread, Frame paramFrame, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (HumanSegmentGLThread.access$1100(this.this$0) == null) {}
    SegmentDataPipe localSegmentDataPipe;
    Frame localFrame;
    long l1;
    do
    {
      do
      {
        return;
        localSegmentDataPipe = HumanSegmentGLThread.access$500(this.this$0).getFreeTexturePileMakeBusy();
      } while (localSegmentDataPipe == null);
      localFrame = FrameBufferCache.getInstance().get(this.val$inputFrame.width, this.val$inputFrame.height);
      if (this.val$rotation == 0) {
        break;
      }
      FrameUtil.rotateCorrect(this.val$inputFrame, this.val$inputFrame.width, this.val$inputFrame.height, this.val$rotation, HumanSegmentGLThread.access$400(this.this$0), localFrame);
      localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
      BenchUtil.benchStart("[showPreview][FABBY] segment");
      BenchUtil.benchStart("[showPreview][FABBY] segment preprocess");
      l1 = System.currentTimeMillis();
      HumanSegmentGLThread.access$200(this.this$0).RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, localSegmentDataPipe.mTexFrame);
      localFrame.unlock();
      HumanSegmentGLThread.access$802(this.this$0, localSegmentDataPipe.mTexFrame);
      GLES20.glFinish();
    } while (localSegmentDataPipe.mMaskFrame == null);
    if (this.val$cameraIdx != this.this$0.mHumanSegmentInitializer.getCameraId())
    {
      this.this$0.mHumanSegmentInitializer.setCameraId(this.val$cameraIdx);
      if (this.val$cameraIdx != 0) {
        break label566;
      }
      this.this$0.mHumanSegmentInitializer.setPostMode(2);
    }
    for (;;)
    {
      HumanSegmentGLThread.access$200(this.this$0).RenderProcess(HumanSegmentGLThread.access$800(this.this$0).getTextureId(), 256, 256, -1, 0.0D, HumanSegmentGLThread.access$700(this.this$0));
      Bitmap localBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
      RendererUtils.saveTextureToBitmap(HumanSegmentGLThread.access$700(this.this$0).getTextureId(), 256, 256, localBitmap);
      BenchUtil.benchEnd("[showPreview][FABBY] segment preprocess");
      BenchUtil.benchStart("[showPreview][FABBY] segment Detect");
      localBitmap = this.this$0.mHumanSegmentInitializer.forward(localBitmap, 0);
      BenchUtil.benchEnd("[showPreview][FABBY] segment Detect");
      BenchUtil.benchStart("[showPreview][FABBY] segment postprocess");
      localSegmentDataPipe.mMaskFrame.bindFrame(-1, localBitmap.getWidth(), localBitmap.getHeight(), 0.0D);
      GlUtil.loadTexture(localSegmentDataPipe.mMaskFrame.getTextureId(), localBitmap);
      if (this.val$rotation != 0)
      {
        FrameUtil.rotateCorrect(localSegmentDataPipe.mMaskFrame, localSegmentDataPipe.mMaskFrame.width, localSegmentDataPipe.mMaskFrame.height, -this.val$rotation, HumanSegmentGLThread.access$400(this.this$0), localFrame);
        HumanSegmentGLThread.access$200(this.this$0).RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
        localFrame.unlock();
      }
      localSegmentDataPipe.makeDataReady();
      HumanSegmentGLThread.access$500(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
      HumanSegmentGLThread.access$1100(this.this$0).onDataReady(localSegmentDataPipe);
      long l2 = System.currentTimeMillis();
      BenchUtil.benchEnd("[showPreview][FABBY] segment postprocess");
      BenchUtil.benchEnd("[showPreview][FABBY] segment");
      localSegmentDataPipe.detectTimes = new HashMap();
      localSegmentDataPipe.detectTimes.put("sdk_background_detect_time", Long.valueOf(l2 - l1));
      return;
      HumanSegmentGLThread.access$200(this.this$0).RenderProcess(this.val$inputFrame.getTextureId(), this.val$inputFrame.width, this.val$inputFrame.height, -1, 0.0D, localFrame);
      break;
      label566:
      if (this.this$0.mHumanSegmentInitializer.getModelLevel() > 1) {
        this.this$0.mHumanSegmentInitializer.setPostMode(0);
      } else {
        this.this$0.mHumanSegmentInitializer.setPostMode(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.thread.HumanSegmentGLThread.2
 * JD-Core Version:    0.7.0.1
 */