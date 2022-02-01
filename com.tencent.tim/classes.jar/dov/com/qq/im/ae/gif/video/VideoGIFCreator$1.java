package dov.com.qq.im.ae.gif.video;

import amac;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import awtn.c.b;
import axfl;
import axfw;
import axfx;
import axfy;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(axfx paramaxfx, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(awtn.c.b.cSP);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      axfx.a(this.this$0).U(axfx.a(this.this$0), axfx.b(this.this$0), (String)localObject1);
      Object localObject2 = new amac(null, 1);
      ((amac)localObject2).makeCurrent(((amac)localObject2).createOffscreenSurface(axfx.a(this.this$0), axfx.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      axfx.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, axfx.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      axfx.a(this.this$0).apply();
      axfx.b(this.this$0).apply();
      axfx.c(this.this$0).apply();
      axfx.a(this.this$0).onSurfaceChanged(axfx.a(this.this$0), axfx.b(this.this$0));
      axfx.a(this.this$0).initial();
      axfx.a(this.this$0, new SurfaceTexture(localObject2[0]));
      axfx.a(this.this$0).setOnFrameAvailableListener(new axfy(this, (String)localObject1));
      axfx.a(this.this$0, new axfw());
      axfx.a(this.this$0).a(this.val$videoPath, 0L, 2147483647L, new Surface(axfx.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(axfx.access$300(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */