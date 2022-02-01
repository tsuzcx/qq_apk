package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import aylt;
import aymk;
import aymu;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class DoodleTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer, aylt
{
  aymk a;
  int mWindowHeight = 480;
  int mWindowWidth = 320;
  
  public DoodleTextureView(Context paramContext)
  {
    super(paramContext);
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setOpaque(false);
    super.setRenderer(this);
    super.setRenderMode(0);
  }
  
  public void M(Runnable paramRunnable)
  {
    queueEvent(paramRunnable);
  }
  
  public void buf()
  {
    requestRender();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy start");
    }
    queueEvent(new DoodleTextureView.2(this));
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.a != null) {
      this.a.bur();
    }
  }
  
  @TargetApi(17)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.mWindowWidth = paramInt1;
    this.mWindowHeight = paramInt2;
    if (this.a != null)
    {
      paramGL10 = (aymu)this.a.b(102);
      if (paramGL10 != null) {
        paramGL10.onSurfaceChanged(paramInt1, paramInt2);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.a != null) {
      this.a.buq();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void setOpController(aymk paramaymk)
  {
    this.a = paramaymk;
    this.a.a(this);
    super.queueEvent(new DoodleTextureView.1(this));
  }
  
  public void xx(int paramInt)
  {
    if (this.a != null) {
      this.a.xv(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView
 * JD-Core Version:    0.7.0.1
 */