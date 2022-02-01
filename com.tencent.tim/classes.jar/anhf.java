import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;

public class anhf
  extends CameraCaptureSession.CaptureCallback
{
  public anhf(Camera2Control paramCamera2Control) {}
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    anhj.dH(1, "[Camera2]captureStillPicture completed!");
    Camera2Control.a(this.b, 0L);
    Camera2Control.e(this.b, false);
    Camera2Control.a(this.b).setState(0);
    Camera2Control.b(this.b);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    anhj.dH(1, "[Camera2]captureStillPicture failed!");
    Camera2Control.a(this.b, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */