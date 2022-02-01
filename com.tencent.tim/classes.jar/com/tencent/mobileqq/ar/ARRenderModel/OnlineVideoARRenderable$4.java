package com.tencent.mobileqq.ar.ARRenderModel;

import addw;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

public class OnlineVideoARRenderable$4
  implements Runnable
{
  public void run()
  {
    if (addw.e(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { addw.e(this.this$0) }, 0);
    }
    if (addw.f(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { addw.f(this.this$0) }, 0);
    }
    if (addw.g(this.this$0) != -1) {
      GLES20.glDeleteTextures(1, new int[] { addw.g(this.this$0) }, 0);
    }
    try
    {
      addw.b(this.this$0, addw.a(this.this$0, 1, this.cY, this.val$width, this.val$height));
      addw.c(this.this$0, addw.a(this.this$0, 2, this.cZ, this.val$width / 2, (this.val$height + 1) / 2));
      addw.d(this.this$0, addw.a(this.this$0, 3, this.da, this.val$width / 2, (this.val$height + 1) / 2));
      addw.a(this.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "drawFrame_soft exception=" + localException.getMessage());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.4
 * JD-Core Version:    0.7.0.1
 */