import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.support.annotation.NonNull;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.b;

public class anhe
  extends CameraCaptureSession.CaptureCallback
{
  public anhe(Camera2Control paramCamera2Control) {}
  
  private void a(CaptureResult paramCaptureResult, CaptureRequest paramCaptureRequest)
  {
    paramCaptureRequest = paramCaptureRequest.getTag();
    if ((!(paramCaptureRequest instanceof anim.e)) || (((anim.e)paramCaptureRequest).cGU))
    {
      anhj.dH(1, "[Camera2] mAfCaptureCallback handled!");
      Camera2Control.d(this.b, false);
    }
    do
    {
      return;
      paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      anhj.dH(1, "[Camera2] mAfCaptureCallback:" + paramCaptureResult);
    } while ((paramCaptureResult == null) || ((4 != paramCaptureResult.intValue()) && (5 != paramCaptureResult.intValue())));
    a(true, (anim.e)paramCaptureRequest);
  }
  
  private void a(boolean paramBoolean, anim.e parame)
  {
    Camera2Control.d(this.b, false);
    Camera2Control.a(this.b).set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try
    {
      anhj.dH(1, "[Camera2] mAfCaptureCallback run, success:" + paramBoolean);
      Camera2Control.a(this.b).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      CameraCaptureSession localCameraCaptureSession = Camera2Control.a(this.b);
      if (this.b.cGd) {}
      for (CaptureRequest localCaptureRequest = Camera2Control.a(this.b).buildCaptureRequest(Camera2Control.a(this.b));; localCaptureRequest = Camera2Control.a(this.b).build())
      {
        localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
        if ((parame.a.b == null) || (parame.cGU)) {
          break;
        }
        parame.cGU = true;
        parame.a.b.bU(1, paramBoolean);
        return;
      }
      return;
    }
    catch (Exception parame)
    {
      anhj.dH(2, "[Camera2] mAfCaptureCallback e:" + parame);
    }
  }
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult, paramCaptureRequest);
  }
  
  public void onCaptureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureFailure paramCaptureFailure)
  {
    anhj.dH(2, "[Camera2] mAfCaptureCallback failure reason:" + paramCaptureFailure.getReason());
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if ((!(paramCameraCaptureSession instanceof anim.e)) || (((anim.e)paramCameraCaptureSession).cGU))
    {
      anhj.dH(1, "[Camera2] mAfCaptureCallback handled!");
      Camera2Control.d(this.b, false);
      return;
    }
    a(false, (anim.e)paramCameraCaptureSession);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult, paramCaptureRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhe
 * JD-Core Version:    0.7.0.1
 */