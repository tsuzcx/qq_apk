import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;

public class ambd
{
  private static String TAG = "MediaUtil";
  
  @TargetApi(10)
  public static long at(String paramString)
  {
    long l1 = 0L;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
    }
    catch (RuntimeException localRuntimeException)
    {
      long l2;
      ram.e(TAG, "getVideoDuration path=" + paramString + " exists=" + rox.exists(paramString), localRuntimeException);
      localMediaMetadataRetriever.release();
      return 0L;
    }
    catch (Error localError)
    {
      label32:
      ram.e(TAG, "getVideoDuration path=" + paramString + " exists=" + rox.exists(paramString), localError);
      localMediaMetadataRetriever.release();
      return 0L;
    }
    try
    {
      l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      break label32;
    }
    localMediaMetadataRetriever.release();
    return l1;
  }
  
  public static void hh(String paramString1, String paramString2)
  {
    paramString1 = l(paramString1, 0);
    if (paramString1 != null) {
      rop.a(paramString1, Bitmap.CompressFormat.JPEG, 80, paramString2);
    }
  }
  
  @TargetApi(10)
  public static Bitmap l(String paramString, int paramInt)
  {
    Object localObject = null;
    if (!rox.exists(paramString))
    {
      ram.e(TAG, "File note exist when getFrameAtTime(). videoPath = " + paramString + " millisecond = " + paramInt);
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = paramInt * 1000;
    try
    {
      paramString = localMediaMetadataRetriever.getFrameAtTime(l, 0);
      localMediaMetadataRetriever.release();
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        ram.e(TAG, "getFrameAtTime", paramString);
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambd
 * JD-Core Version:    0.7.0.1
 */