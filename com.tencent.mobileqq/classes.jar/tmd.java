import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class tmd
{
  public static int a(Bitmap.Config paramConfig)
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
  
  @TargetApi(19)
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (a()) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RuntimeException localRuntimeException = new RuntimeException("getStack");
      a(paramString1, paramString2 + " " + localRuntimeException.getStackTrace()[2].getMethodName());
      return;
    }
    a(paramString1, paramString2);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @TargetApi(19)
  public static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
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
        if ((b()) && (!a(paramOptions))) {
          break;
        }
      } while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1));
      return false;
    } while ((int)Math.ceil(paramOptions.outWidth * 1.0D / paramOptions.inSampleSize) * (int)Math.ceil(paramOptions.outHeight * 1.0D / paramOptions.inSampleSize) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount());
    return false;
  }
  
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.outWidth > 2048) || (paramOptions.outHeight > 2048);
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tmd
 * JD-Core Version:    0.7.0.1
 */