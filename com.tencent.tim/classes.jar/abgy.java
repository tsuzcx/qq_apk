import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.utils.QLog;

public class abgy
  implements SurfaceHolder.Callback
{
  abgy(abgx paramabgx) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSurfaceHolder.getSurface() == null) {
      return;
    }
    paramSurfaceHolder.setFixedSize(paramInt2, paramInt3);
    QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceChanged");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (GraphicRendererMgr.getInstance() != null)
    {
      abvy.a(abgx.a(this.a)).a().setRenderMgrAndHolder(GraphicRendererMgr.getInstance(), paramSurfaceHolder);
      abvy.a(abgx.a(this.a)).a().getVideoCtrl().setLocalVideoPreviewCallback(new abgz(this));
      abvy.a(abgx.a(this.a)).a().getVideoCtrl().setRemoteVideoPreviewCallback(new abha(this));
    }
    for (;;)
    {
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceCreated");
      return;
      QLog.e("AVCameraCaptureModel", 0, "GraphicRendererMgr is null, so can't load");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.a.a();
    if (paramSurfaceHolder == null)
    {
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceDestroyed avCtrl == null");
      return;
    }
    paramSurfaceHolder.enableCamera(0, false, new abhb(this));
    QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgy
 * JD-Core Version:    0.7.0.1
 */