import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class zxa
{
  String REPORT_TAG;
  String TAG;
  String mFilePath;
  
  public zxa(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public static zxa a(String paramString)
  {
    if (zxb.iD(paramString)) {
      return new zxb(paramString);
    }
    if (zwz.iA(paramString)) {
      return new zwz(paramString);
    }
    return null;
  }
  
  public static boolean iC(String paramString)
  {
    return a(paramString) != null;
  }
  
  boolean iB(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int j = aqhu.getExifOrientation(this.mFilePath);
    String str = "generate " + this.TAG;
    int i = 1;
    if (i <= 4) {}
    for (;;)
    {
      try
      {
        localOptions.inSampleSize = i;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, str + ",localPath:" + this.mFilePath + " sample:" + i + " path:" + paramString + " degree:" + j);
        }
        Bitmap localBitmap = SafeBitmapFactory.safeDecode(this.mFilePath, localOptions);
        Object localObject = localBitmap;
        if (j != 0)
        {
          localObject = new Matrix();
          int k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          ((Matrix)localObject).postRotate(j, k >> 1, m >> 1);
          localObject = Bitmap.createBitmap(localBitmap, 0, 0, k, m, (Matrix)localObject, true);
        }
        bool = akyr.b(paramString, (Bitmap)localObject, 80, "incompatible to jpg", null);
        if (bool)
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, str + ",result:" + bool + " sample:" + i + " path:" + paramString + " degree:" + j);
          }
          return bool;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, str + ",compressQuality fail");
        }
        i *= 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, str + ",oom localPath:" + this.mFilePath + " sample:" + i + " degree:" + j);
        }
        localOutOfMemoryError.printStackTrace();
        System.gc();
        i *= 2;
      }
      break;
      boolean bool = false;
    }
  }
  
  public String pZ()
  {
    Object localObject = null;
    String str = akyr.as(this.mFilePath, 2);
    if (!new File(str).exists())
    {
      boolean bool = iB(str);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, this.REPORT_TAG, bool, 0L, akyr.getFileSize(str), null, "");
      if (bool)
      {
        if (QLog.isColorLevel()) {
          akxe.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile suc", "outputPath" + str + " originFile" + this.mFilePath + " fileType:" + this.TAG);
        }
        localObject = str;
      }
      while (!QLog.isColorLevel()) {
        return localObject;
      }
      akxe.a("PIC_TAG_ERROR", "check file type,generateCompatibleFile fail", " originFile" + this.mFilePath + " fileType:" + this.TAG);
      return null;
    }
    if (QLog.isColorLevel()) {
      akxe.a("PIC_TAG_ERROR", "check file type,compatibleFile exists", "outputPath" + str + " originFile" + this.mFilePath + " fileType:" + this.TAG);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxa
 * JD-Core Version:    0.7.0.1
 */