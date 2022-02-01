import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.b;
import java.util.concurrent.Semaphore;

public class anha
  extends CameraDevice.StateCallback
{
  public anha(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    anhj.dH(2, "[Camera2]openCamera2 onDisconnected!");
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.a != null) {
      this.b.a.UT(-105);
    }
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    anhj.dH(2, "[Camera2]openCamera2 onError, error:" + paramInt);
    Camera2Control.a(this.b, false);
    Camera2Control.b(this.b, false);
    paramCameraDevice.close();
    Camera2Control.a(this.b, null);
    Camera2Control.a(this.b).release();
    if (this.b.a != null) {
      this.b.a.UT(-102);
    }
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    anhj.dH(1, "[Camera2]openCamera2 onOpen, cost:" + (System.currentTimeMillis() - this.alh));
    Camera2Control.a(this.b, paramCameraDevice);
    Camera2Control.a(this.b, true);
    Camera2Control.b(this.b, false);
    Camera2Control.a(this.b).release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anha
 * JD-Core Version:    0.7.0.1
 */