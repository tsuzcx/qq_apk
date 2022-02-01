import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.ImageSaveServer;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.a;
import java.nio.ByteBuffer;

public class anhc
  implements ImageReader.OnImageAvailableListener
{
  public anhc(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      anhj.dH(1, "[Camera2]Image Capture cost:" + (float)(System.currentTimeMillis() - Camera2Control.a(this.b)) / 1000.0F);
      anhi.f(2, Camera2Control.a(this.b).width * Camera2Control.a(this.b).height, System.currentTimeMillis() - Camera2Control.a(this.b));
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        ByteBuffer localByteBuffer = paramImageReader.getPlanes()[0].getBuffer();
        byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
        localByteBuffer.get(arrayOfByte);
        if ((Camera2Control.a(this.b) != null) && (Camera2Control.a(this.b) != null))
        {
          Camera2Control.a(this.b).mCharacteristics = Camera2Control.a(this.b).a;
          Camera2Control.a(this.b).post(new Camera2Control.ImageSaveServer(arrayOfByte, Camera2Control.a(this.b)));
        }
        paramImageReader.close();
      }
      return;
    }
    catch (Exception paramImageReader)
    {
      anhj.dH(1, "[Camera2] onImageAvailable mImageReader exception:" + paramImageReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhc
 * JD-Core Version:    0.7.0.1
 */