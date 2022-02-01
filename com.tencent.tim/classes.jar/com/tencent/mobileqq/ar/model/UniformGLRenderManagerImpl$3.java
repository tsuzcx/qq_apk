package com.tencent.mobileqq.ar.model;

import adcy;
import adky;
import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Map;

public class UniformGLRenderManagerImpl$3
  implements Runnable
{
  public UniformGLRenderManagerImpl$3(adky paramadky) {}
  
  public void run()
  {
    if (adky.a(this.this$0)) {
      QLog.i("AREngine_UniformGLRenderManagerImpl", 1, "stopModelRender. has been refused");
    }
    do
    {
      return;
      if (this.this$0.d != null)
      {
        this.this$0.jF.remove(this.this$0.d.getUniqueKey());
        this.this$0.d.onDestroy();
        this.this$0.d = null;
      }
      if (adky.a(this.this$0) != null)
      {
        GLES20.glDeleteTextures(1, new int[] { adky.a(this.this$0).getTexId() }, 0);
        adky.a(this.this$0).destroy();
        adky.a(this.this$0, null);
      }
      if (adky.a(this.this$0) != null)
      {
        adky.a(this.this$0).release();
        adky.a(this.this$0, null);
      }
    } while (adky.a(this.this$0) == null);
    adky.a(this.this$0).czb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */