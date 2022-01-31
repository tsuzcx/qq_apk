import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;

public class yjk
  implements SurfaceHolder.Callback
{
  public yjk(AVCameraCaptureModel paramAVCameraCaptureModel) {}
  
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
      AVManager.a(AVCameraCaptureModel.a(this.a)).a().setRenderMgrAndHolder(GraphicRendererMgr.getInstance(), paramSurfaceHolder);
      AVManager.a(AVCameraCaptureModel.a(this.a)).a().getVideoCtrl().setLocalVideoPreviewCallback(new yjl(this));
      AVManager.a(AVCameraCaptureModel.a(this.a)).a().getVideoCtrl().setRemoteVideoPreviewCallback(new yjn(this));
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
    paramSurfaceHolder.enableCamera(0, false, new yjp(this));
    QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yjk
 * JD-Core Version:    0.7.0.1
 */