package dov.com.qq.im.ae.gif.video;

import amac;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import axdh;
import axft;
import axft.b;
import axfv;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(axft paramaxft, String paramString) {}
  
  public void run()
  {
    Object localObject = new amac(null, 1);
    ((amac)localObject).makeCurrent(((amac)localObject).createOffscreenSurface(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    axft.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, axft.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    axft.a(this.this$0).apply();
    axft.a(this.this$0).onSurfaceChanged(320, 320);
    axft.a(this.this$0).initial();
    axft.a(this.this$0, new SurfaceTexture(axft.a(this.this$0)));
    axft.a(this.this$0).setOnFrameAvailableListener(new axft.b(this.this$0));
    axft.a(this.this$0, new axfv());
    axft.a(this.this$0).a(this.val$videoPath, new Surface(axft.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */