package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.LinkedBlockingDeque;

class FilamentJavaFilter$2
  implements SurfaceTexture.OnFrameAvailableListener
{
  FilamentJavaFilter$2(FilamentJavaFilter paramFilamentJavaFilter) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      FilamentJavaFilter.access$800(this.this$0).put(new FilamentJavaFilter.2.1(this));
      LogUtils.d(FilamentJavaFilter.access$900(this.this$0), "test for filament render: update finish");
      return;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      for (;;)
      {
        paramSurfaceTexture.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentJavaFilter.2
 * JD-Core Version:    0.7.0.1
 */