import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class npe
{
  public static boolean FU()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.outWidth > 2048) || (paramOptions.outHeight > 2048);
  }
  
  @TargetApi(19)
  public static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool = true;
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (!paramBitmap.isMutable())) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if ((hasKitKat()) && (!a(paramOptions))) {
          break;
        }
      } while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1));
      return false;
    } while ((int)Math.ceil(paramOptions.outWidth * 1.0D / paramOptions.inSampleSize) * (int)Math.ceil(paramOptions.outHeight * 1.0D / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount());
    return false;
  }
  
  @TargetApi(19)
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (FU()) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RuntimeException localRuntimeException = new RuntimeException("getStack");
      log(paramString1, paramString2 + " " + localRuntimeException.getStackTrace()[2].getMethodName());
      return;
    }
    log(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     npe
 * JD-Core Version:    0.7.0.1
 */