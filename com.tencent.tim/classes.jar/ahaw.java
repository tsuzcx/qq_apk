import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

final class ahaw
  implements ahav.b
{
  ahaw(String paramString1, String paramString2) {}
  
  public void p(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      ahbj.f(paramBitmap, this.fe);
      paramBitmap.recycle();
      int i = dz.l(this.val$filePath);
      dz.e(this.fe, i);
      return;
    }
    catch (FileNotFoundException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramBitmap.getMessage());
      return;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramBitmap.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahaw
 * JD-Core Version:    0.7.0.1
 */