import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.qphone.base.util.QLog;

public class aaut
{
  private static int frameHeight;
  private static int frameWidth;
  private static int thumbnailHeight;
  private static int thumbnailWidth;
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    thumbnailWidth = paramInt5;
    thumbnailHeight = paramInt6;
    try
    {
      paramInt1 = TrimNative.prepare(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return paramInt1;
    }
    catch (Throwable paramString)
    {
      QLog.e("ThumbnailUtils", 1, "init failed:" + Log.getStackTraceString(paramString));
    }
    return -444;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    frameWidth = paramInt1;
    frameHeight = paramInt2;
    if (paramBoolean)
    {
      if (frameWidth <= frameHeight) {
        break label55;
      }
      frameWidth = 480;
      frameHeight = (int)(frameHeight / (paramInt1 * 1.0D / 480.0D));
    }
    for (;;)
    {
      return TrimNative.initGetFrame(paramString, frameWidth, frameHeight);
      label55:
      frameHeight = 480;
      frameWidth = (int)(frameWidth / (paramInt2 * 1.0D / 480.0D));
    }
  }
  
  public static Bitmap a(long paramLong1, long paramLong2)
  {
    if ((frameWidth <= 0) || (frameHeight <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(frameWidth, frameHeight, Bitmap.Config.ARGB_8888);
      if (TrimNative.getFrame(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
  
  public static Bitmap b(long paramLong1, long paramLong2)
  {
    if ((thumbnailWidth <= 0) || (thumbnailHeight <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(thumbnailWidth, thumbnailHeight, Bitmap.Config.ARGB_8888);
      if (TrimNative.getThumbnail(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
  
  public static int g(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaut
 * JD-Core Version:    0.7.0.1
 */