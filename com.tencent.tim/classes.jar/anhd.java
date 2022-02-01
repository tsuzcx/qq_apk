import android.hardware.Camera.PreviewCallback;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import java.nio.ByteBuffer;

public class anhd
  implements ImageReader.OnImageAvailableListener
{
  public anhd(Camera2Control paramCamera2Control) {}
  
  public void onImageAvailable(ImageReader paramImageReader)
  {
    try
    {
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null)
      {
        Camera.PreviewCallback localPreviewCallback = Camera2Control.a(this.b);
        if (localPreviewCallback != null)
        {
          ByteBuffer localByteBuffer = paramImageReader.getPlanes()[0].getBuffer();
          byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
          localByteBuffer.get(arrayOfByte);
          localPreviewCallback.onPreviewFrame(arrayOfByte, null);
        }
        paramImageReader.close();
      }
      return;
    }
    catch (Exception paramImageReader)
    {
      anhj.dH(1, "[Camera2] onImageAvailable mPreviewReader exception:" + paramImageReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhd
 * JD-Core Version:    0.7.0.1
 */