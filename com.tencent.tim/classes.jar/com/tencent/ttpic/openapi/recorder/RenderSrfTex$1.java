package com.tencent.ttpic.openapi.recorder;

import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.WindowSurface;
import com.tencent.ttpic.recorder.MyRecorder;

class RenderSrfTex$1
  implements Runnable
{
  RenderSrfTex$1(RenderSrfTex paramRenderSrfTex, int paramInt, long paramLong) {}
  
  public void run()
  {
    if (RenderSrfTex.access$000(this.this$0) == -1L)
    {
      RenderSrfTex.access$002(this.this$0, System.currentTimeMillis());
      RenderSrfTex.access$102(this.this$0, 0);
    }
    if ((RenderSrfTex.access$200(this.this$0) > 0L) && (System.currentTimeMillis() - RenderSrfTex.access$000(this.this$0) < RenderSrfTex.access$100(this.this$0) * RenderSrfTex.access$200(this.this$0))) {
      return;
    }
    RenderSrfTex.access$108(this.this$0);
    RenderSrfTex.access$700(this.this$0).RenderProcess(this.val$textureId, RenderSrfTex.access$300(this.this$0), RenderSrfTex.access$400(this.this$0), 0, RenderSrfTex.access$500(this.this$0), RenderSrfTex.access$600(this.this$0));
    if (RenderSrfTex.access$800(this.this$0) != null)
    {
      RenderSrfTex.access$800(this.this$0).setPresentationTime(this.val$timestamp);
      RenderSrfTex.access$800(this.this$0).swapBuffers();
    }
    RenderSrfTex.access$900(this.this$0).swapBuffers();
    GlUtil.checkGlError("draw_E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.RenderSrfTex.1
 * JD-Core Version:    0.7.0.1
 */