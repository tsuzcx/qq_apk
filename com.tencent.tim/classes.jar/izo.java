import com.tencent.av.ui.GamePlayView;
import com.tencent.mobileqq.armap.ARGLSurfaceView.SurfaceStateListener;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class izo
  implements ARGLSurfaceView.SurfaceStateListener
{
  boolean FJ = false;
  
  public izo(GamePlayView paramGamePlayView) {}
  
  public void onDestroy() {}
  
  public void onEGLConfigCreated(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, long paramLong) {}
  
  public void onEGLContextDestroyed(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext) {}
  
  public void onInit(long paramLong)
  {
    GamePlayView.a(this.this$0, paramLong);
  }
  
  public void onPause()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "surfaceListener onPause");
  }
  
  public void onResume()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "surfaceListener onResume");
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izo
 * JD-Core Version:    0.7.0.1
 */