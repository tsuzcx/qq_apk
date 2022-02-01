import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;

public class aeyl<T>
{
  private LruCache<String, T> mCache = new aeym(this, (int)Runtime.getRuntime().maxMemory() / 32);
  
  private static int d(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private int j(T paramT)
  {
    if ((paramT instanceof Bitmap)) {
      return d((Bitmap)paramT);
    }
    if ((paramT instanceof BitmapDrawable)) {
      return d(((BitmapDrawable)paramT).getBitmap());
    }
    return 0;
  }
  
  protected int k(T paramT)
  {
    return 0;
  }
  
  public void trimToSize(int paramInt)
  {
    try
    {
      this.mCache.trimToSize(paramInt);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyl
 * JD-Core Version:    0.7.0.1
 */