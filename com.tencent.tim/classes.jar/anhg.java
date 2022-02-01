import android.os.Handler;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureCallback;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.a;
import java.nio.ByteBuffer;

public class anhg
  extends SCameraCaptureProcessor.CaptureCallback
{
  public anhg(Camera2Control paramCamera2Control, long paramLong) {}
  
  public void onError(int paramInt)
  {
    anhj.dH(1, "[Camera2]Samsung Capture onError:" + paramInt);
    Camera2Control.a(this.b, 0L);
  }
  
  public void onPictureAvailable(ByteBuffer paramByteBuffer)
  {
    anhj.dH(1, "[Camera2]Samsung Capture cost:" + (float)(System.currentTimeMillis() - this.ali) / 1000.0F);
    anhi.f(2, Camera2Control.a(this.b), System.currentTimeMillis() - this.ali);
    if ((Camera2Control.a(this.b) != null) && (Camera2Control.a(this.b) != null) && (paramByteBuffer != null))
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      Camera2Control.a(this.b).mCharacteristics = Camera2Control.a(this.b).a;
      Camera2Control.a(this.b).post(new Camera2Control.ImageSaveServer(arrayOfByte, Camera2Control.a(this.b)));
    }
    Camera2Control.a(this.b, 0L);
    Camera2Control.e(this.b, false);
    Camera2Control.a(this.b).setState(0);
    Camera2Control.b(this.b);
  }
  
  public void onShutter()
  {
    anhj.dH(1, "[Camera2]samsungCapture onShutter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhg
 * JD-Core Version:    0.7.0.1
 */