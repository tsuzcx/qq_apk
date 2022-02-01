import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.support.annotation.NonNull;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.b;
import java.util.concurrent.Semaphore;

public class anhb
  extends CameraCaptureSession.StateCallback
{
  public anhb(Camera2Control paramCamera2Control) {}
  
  public void onConfigureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    anhj.dH(2, "[Camera2]startPreview onConfigureFailed!");
    Camera2Control.c(this.b, false);
    Camera2Control.a(this.b).release();
    if (this.b.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b != null) {
      this.b.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$b.UT(-202);
    }
  }
  
  public void onConfigured(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    anhj.dH(1, "[Camera2]startPreview onConfigured!");
    Camera2Control.c(this.b, true);
    Camera2Control.a(this.b, paramCameraCaptureSession);
    Camera2Control.a(this.b).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
    Camera2Control.a(this.b).set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
    Camera2Control.a(this.b).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Camera2Control.a(this.b));
    if (this.b.cGd)
    {
      Camera2Control.a(this.b, Camera2Control.a(this.b).buildCaptureRequest(Camera2Control.a(this.b)));
      this.b.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = Camera2Control.a(this.b).createCaptureCallback(Camera2Control.a(this.b), Camera2Control.a(this.b));
    }
    for (;;)
    {
      Camera2Control.a(this.b);
      Camera2Control.a(this.b).release();
      return;
      Camera2Control.b(this.b, Camera2Control.a(this.b).build());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhb
 * JD-Core Version:    0.7.0.1
 */