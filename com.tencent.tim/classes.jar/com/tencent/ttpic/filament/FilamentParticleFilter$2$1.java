package com.tencent.ttpic.filament;

import android.graphics.SurfaceTexture;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.util.FrameUtil;

class FilamentParticleFilter$2$1
  implements Runnable
{
  FilamentParticleFilter$2$1(FilamentParticleFilter.2 param2) {}
  
  public void run()
  {
    FilamentParticleFilter.access$000(this.this$1.this$0).updateTexImage();
    FilamentParticleFilter.access$400(this.this$1.this$0).setRotationAndFlip(-FilamentParticleFilter.access$300(this.this$1.this$0), 0, 0);
    FrameUtil.clearFrame(FilamentParticleFilter.access$500(this.this$1.this$0), 0.0F, 0.0F, 0.0F, 0.0F, FilamentParticleFilter.access$600(this.this$1.this$0), FilamentParticleFilter.access$700(this.this$1.this$0));
    FilamentParticleFilter.access$400(this.this$1.this$0).RenderProcess(FilamentParticleFilter.access$100(this.this$1.this$0)[0], FilamentParticleFilter.access$600(this.this$1.this$0), FilamentParticleFilter.access$700(this.this$1.this$0), -1, 0.0D, FilamentParticleFilter.access$500(this.this$1.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentParticleFilter.2.1
 * JD-Core Version:    0.7.0.1
 */