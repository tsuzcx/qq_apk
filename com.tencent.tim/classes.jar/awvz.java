import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;

public class awvz
  extends axbf
{
  public awvz(AECameraGLSurfaceView paramAECameraGLSurfaceView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void o(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (AECameraGLSurfaceView.a(this.this$0) != null) {
      AECameraGLSurfaceView.a(this.this$0).br(paramFloat3);
    }
  }
  
  public void onOrientationChanged(int paramInt)
  {
    int i = 0;
    AECameraGLSurfaceView.a(this.this$0, paramInt);
    AECameraGLSurfaceView.a(this.this$0).adr(paramInt);
    if (paramInt == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AECameraGLSurfaceView", 2, "OrientationEventListener unknown");
      }
    }
    for (int j = 90;; j = 0)
    {
      if ((paramInt > 315) || (paramInt < 45)) {
        i = 90;
      }
      for (;;)
      {
        AECameraGLSurfaceView.b(this.this$0, i);
        return;
        if ((paramInt > 45) && (paramInt < 135)) {
          i = 180;
        } else if ((paramInt > 135) && (paramInt < 225)) {
          i = 270;
        } else if ((paramInt <= 225) || (paramInt >= 315)) {
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvz
 * JD-Core Version:    0.7.0.1
 */