package com.tencent.mobileqq.triton.render.c;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.render.RenderContext.a;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.nio.IntBuffer;

public class a
  implements RenderContext.a
{
  private TTEngine a;
  private long b = 0L;
  private long c = -1L;
  
  public a(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    RenderContext localRenderContext;
    if (l - this.b >= 2000L)
    {
      localRenderContext = this.a.m();
      if (localRenderContext != null) {}
    }
    else
    {
      return;
    }
    this.b = l;
    int i = localRenderContext.c() / 2 - 64;
    int j = localRenderContext.b() / 2 - 64;
    if ((i < 0) || (j < 0)) {
      try
      {
        TTLog.b("BlackScreenMonitor", "checkBlackScreen params error x=" + i + " y=" + j + " w=" + 128 + " h=" + 128);
        return;
      }
      catch (Exception localException)
      {
        TTLog.b("BlackScreenMonitor", "checkBlackScreen exception ", localException);
        return;
      }
    }
    int[] arrayOfInt = new int[16384];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt);
    localIntBuffer.position(0);
    GLES30.glReadPixels(i, j, 128, 128, 6408, 5121, localIntBuffer);
    this.a.l().postRunable(new a.a(this, arrayOfInt));
  }
  
  public void a()
  {
    c();
  }
  
  public long b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.a
 * JD-Core Version:    0.7.0.1
 */