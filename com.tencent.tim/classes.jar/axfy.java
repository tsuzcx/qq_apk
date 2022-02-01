import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.1;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;

public class axfy
  implements SurfaceTexture.OnFrameAvailableListener
{
  public axfy(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(axfx.access$300(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    axfx.a(this.a.this$0).RenderProcess(axfx.c(this.a.this$0), 960, 480, -1, 0.0D, axfx.a(this.a.this$0));
    axfx.a(this.a.this$0).setNeedComposeAlpha(true);
    paramSurfaceTexture = axfx.a(this.a.this$0).a(axfx.a(this.a.this$0), 480, 480);
    if (axfx.a(this.a.this$0) != null)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = axfx.a(this.a.this$0).x * 2.0F - 1.0F;
      float f2 = axfx.a(this.a.this$0).y * 2.0F - 1.0F;
      float f3 = axfx.a(this.a.this$0).width * 2.0F + f1;
      float f4 = axfx.a(this.a.this$0).height * 2.0F + f2;
      axfx.b(this.a.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      axfx.b(this.a.this$0).RenderProcess(axfx.a(this.a.this$0).eED, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
      GLES20.glDisable(3042);
    }
    paramSurfaceTexture = axfx.c(this.a.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), axfx.a(this.a.this$0), axfx.b(this.a.this$0));
    Bitmap localBitmap = RendererUtils.saveTexture(paramSurfaceTexture);
    paramSurfaceTexture.unlock();
    axfx.a(this.a.this$0).a(localBitmap, 55);
    localBitmap.recycle();
    QLog.d(axfx.access$300(), 4, "gif creator decodeToSurface()");
    if (!axfx.a(this.a.this$0).aOw())
    {
      QLog.d(axfx.access$300(), 4, "gifEncoder.close() start");
      axfx.a(this.a.this$0).close();
      QLog.d(axfx.access$300(), 4, "gifEncoder.close() end");
      QLog.d(axfx.access$300(), 4, "gif encode complete");
      paramSurfaceTexture = awtn.c.b.cSP + File.separator + System.currentTimeMillis() + "_compressed.gif";
      ahbj.deleteFile(paramSurfaceTexture);
      QLog.d(axfx.access$300(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.val$gifPath, paramSurfaceTexture, 30);
      QLog.d(axfx.access$300(), 4, "gif compress end, ret = " + i);
      ahbj.deleteFile(this.val$gifPath);
      if (i <= 0) {
        break label563;
      }
      axfx.a(this.a.this$0).HS(paramSurfaceTexture);
    }
    for (;;)
    {
      this.a.this$0.release();
      return;
      label563:
      axfx.a(this.a.this$0).cZr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfy
 * JD-Core Version:    0.7.0.1
 */