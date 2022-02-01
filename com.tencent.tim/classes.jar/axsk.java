import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.image.NativeApngDecoder;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axsk
  implements GifDecoder
{
  private NativeApngDecoder a;
  private String path;
  
  public axsk(String paramString)
  {
    this.path = paramString;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    if (this.a != null) {
      return this.a.getNextFrameBitmap(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    if (TextUtils.isEmpty(this.path)) {}
    File localFile;
    do
    {
      do
      {
        return;
        if (aqqv.a().aF()) {
          break;
        }
        aqqv.a().download();
      } while (!QLog.isColorLevel());
      QLog.d("ApngDecodeWrapper", 2, "so not loaded");
      return;
      localFile = new File(this.path);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    try
    {
      this.a = new NativeApngDecoder(localFile);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void release()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsk
 * JD-Core Version:    0.7.0.1
 */