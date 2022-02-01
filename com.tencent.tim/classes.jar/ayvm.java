import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.maxvideo.trim.TrimNative;

public class ayvm
{
  private static int thumbnailHeight;
  private static int thumbnailWidth;
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvm
 * JD-Core Version:    0.7.0.1
 */