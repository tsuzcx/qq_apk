package com.tencent.av.video.effect.process;

import android.opengl.GLES20;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.Beauty25Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.TextureDataLoader;

class EffectProcessor$5
  implements Runnable
{
  EffectProcessor$5(EffectProcessor paramEffectProcessor) {}
  
  public void run()
  {
    if (EffectProcessor.access$000(this.this$0) != null)
    {
      EffectProcessor.access$000(this.this$0).destroy();
      EffectProcessor.access$002(this.this$0, null);
    }
    if (EffectProcessor.access$200(this.this$0) != null)
    {
      EffectProcessor.access$200(this.this$0).destroy();
      EffectProcessor.access$202(this.this$0, null);
    }
    if (EffectProcessor.access$300(this.this$0) != null)
    {
      EffectProcessor.access$300(this.this$0).destroy();
      EffectProcessor.access$302(this.this$0, null);
    }
    if (EffectProcessor.access$400(this.this$0) != null)
    {
      EffectProcessor.access$400(this.this$0).destroy();
      EffectProcessor.access$402(this.this$0, null);
    }
    if (EffectProcessor.access$500(this.this$0) != null)
    {
      EffectProcessor.access$500(this.this$0).destroy();
      EffectProcessor.access$502(this.this$0, null);
    }
    if (EffectProcessor.access$600(this.this$0) != null)
    {
      EffectProcessor.access$600(this.this$0).destroy();
      EffectProcessor.access$602(this.this$0, null);
    }
    if (EffectProcessor.access$700(this.this$0) != null)
    {
      EffectProcessor.access$700(this.this$0).destroy();
      EffectProcessor.access$702(this.this$0, null);
    }
    if (EffectProcessor.access$100(this.this$0) != null)
    {
      EffectProcessor.access$100(this.this$0).destroy();
      EffectProcessor.access$102(this.this$0, null);
    }
    EffectProcessor.access$902(this.this$0, null);
    if (EffectProcessor.access$1000(this.this$0) != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { EffectProcessor.access$1000(this.this$0) }, 0);
      EffectProcessor.access$1002(this.this$0, -1);
    }
    if (EffectProcessor.access$1100(this.this$0) != null)
    {
      EffectProcessor.access$1100(this.this$0).destroy();
      EffectProcessor.access$1102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.process.EffectProcessor.5
 * JD-Core Version:    0.7.0.1
 */