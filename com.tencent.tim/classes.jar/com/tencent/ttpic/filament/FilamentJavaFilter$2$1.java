package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.util.FrameUtil;

class FilamentJavaFilter$2$1
  implements Runnable
{
  FilamentJavaFilter$2$1(FilamentJavaFilter.2 param2) {}
  
  public void run()
  {
    FilamentJavaFilter.access$000(this.this$1.this$0).updateTexImage();
    FilamentJavaFilter.access$400(this.this$1.this$0).setRotationAndFlip(-FilamentJavaFilter.access$300(this.this$1.this$0), 0, 0);
    FrameUtil.clearFrame(FilamentJavaFilter.access$500(this.this$1.this$0), 0.0F, 0.0F, 0.0F, 0.0F, FilamentJavaFilter.access$600(this.this$1.this$0), FilamentJavaFilter.access$700(this.this$1.this$0));
    FilamentJavaFilter.access$400(this.this$1.this$0).RenderProcess(FilamentJavaFilter.access$100(this.this$1.this$0)[0], FilamentJavaFilter.access$600(this.this$1.this$0), FilamentJavaFilter.access$700(this.this$1.this$0), -1, 0.0D, FilamentJavaFilter.access$500(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentJavaFilter.2.1
 * JD-Core Version:    0.7.0.1
 */