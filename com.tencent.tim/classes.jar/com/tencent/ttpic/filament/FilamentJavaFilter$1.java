package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import java.util.concurrent.CountDownLatch;

class FilamentJavaFilter$1
  implements Runnable
{
  FilamentJavaFilter$1(FilamentJavaFilter paramFilamentJavaFilter) {}
  
  public void run()
  {
    FilamentJavaFilter.access$002(this.this$0, new SurfaceTexture(FilamentJavaFilter.access$100(this.this$0)[0]));
    FilamentJavaFilter.access$200(this.this$0).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentJavaFilter.1
 * JD-Core Version:    0.7.0.1
 */