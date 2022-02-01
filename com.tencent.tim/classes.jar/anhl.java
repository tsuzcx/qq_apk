import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;

@TargetApi(21)
public class anhl
  extends CameraCaptureSession.CaptureCallback
{
  private Camera2Control c;
  private int mState = 0;
  
  public anhl(Camera2Control paramCamera2Control)
  {
    this.c = paramCamera2Control;
  }
  
  private void a(CaptureResult paramCaptureResult)
  {
    switch (this.mState)
    {
    }
    do
    {
      do
      {
        Integer localInteger;
        do
        {
          do
          {
            return;
            localInteger = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            anhj.dH(1, "[Camera2]process afState:" + localInteger);
            if (localInteger != null) {
              break;
            }
          } while (this.c == null);
          this.c.dPI();
          return;
        } while ((4 != localInteger.intValue()) && (5 != localInteger.intValue()) && (localInteger.intValue() != 0) && (1 != localInteger.intValue()) && (2 != localInteger.intValue()));
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult != null) && (paramCaptureResult.intValue() != 2)) {
          break;
        }
        this.mState = 4;
        anhj.dH(1, "[Camera2]process aeState:" + paramCaptureResult);
      } while (this.c == null);
      this.c.dPI();
      return;
      anhj.dH(1, "[Camera2]process preCapture aeState:" + paramCaptureResult);
    } while (this.c == null);
    this.c.dPI();
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult);
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhl
 * JD-Core Version:    0.7.0.1
 */