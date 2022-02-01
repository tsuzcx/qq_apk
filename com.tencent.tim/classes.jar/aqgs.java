import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;

public class aqgs
{
  public static Sizeable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Sizeable))) {
        return (Sizeable)paramString;
      }
    }
    return null;
  }
  
  public static nov a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString instanceof nov)) {
        return (nov)paramString;
      }
    }
    return null;
  }
  
  public static void a(String paramString, Sizeable paramSizeable)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramSizeable == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramSizeable);
  }
  
  public static void a(String paramString, nov paramnov)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramnov == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramnov);
  }
  
  public static void e(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    while (BaseApplicationImpl.sImageCache == null) {
      return;
    }
    BaseApplicationImpl.sImageCache.put(paramString, paramBitmap);
  }
  
  public static Bitmap getBitmapFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramString = BaseApplicationImpl.sImageCache.get(paramString);
      if ((paramString != null) && ((paramString instanceof Bitmap))) {
        return (Bitmap)paramString;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgs
 * JD-Core Version:    0.7.0.1
 */