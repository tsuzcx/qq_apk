import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class bll
  implements SurfaceHolder.Callback
{
  public bll(VideoLayerUI paramVideoLayerUI) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "surfaceChanged");
    }
    if (paramSurfaceHolder.getSurface() == null) {
      return;
    }
    paramSurfaceHolder.setFixedSize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "surfaceCreated");
    }
    this.a.h();
    this.a.i = true;
    if (this.a.d) {
      this.a.a(false, null);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "surfaceDestroyed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bll
 * JD-Core Version:    0.7.0.1
 */