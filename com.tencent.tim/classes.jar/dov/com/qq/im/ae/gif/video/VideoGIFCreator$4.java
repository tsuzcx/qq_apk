package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import axfl;
import axfw;
import axfx;
import axfx.b;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(axfx paramaxfx) {}
  
  public void run()
  {
    axfx.a(this.this$0).release();
    if (axfx.a(this.this$0) != null) {
      axfx.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = axfx.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (axfx.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = axfx.a(this.this$0).eED;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    axfx.a(this.this$0).clearGLSLSelf();
    axfx.b(this.this$0).clearGLSLSelf();
    axfx.c(this.this$0).clearGLSLSelf();
    axfx.a(this.this$0).clear();
    axfx.a(this.this$0).clear();
    axfx.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */