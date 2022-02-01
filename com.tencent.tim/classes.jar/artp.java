import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.img.ImageCache;

public class artp
{
  protected static artp a;
  protected static byte[] hm = new byte[1];
  protected LruCache<String, Bitmap> mLruCache = new LruCache(50);
  
  public static artp a()
  {
    if (a == null) {}
    synchronized (hm)
    {
      if (a == null) {
        a = new artp();
      }
      return a;
    }
  }
  
  public Bitmap Q(String arg1)
  {
    Object localObject1 = arwv.encodeHexStr(???);
    synchronized (hm)
    {
      localObject1 = (Bitmap)this.mLruCache.get(localObject1);
      return localObject1;
    }
  }
  
  public void Xb(String paramString)
  {
    String str = arwv.encodeHexStr(paramString);
    synchronized (hm)
    {
      this.mLruCache.remove(str);
      ImageCache.Xo(paramString);
      return;
    }
  }
  
  public void a(String paramString, artp.a parama)
  {
    ImageCache.a("app", paramString, new artq(this, parama, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, Bitmap paramBitmap, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artp
 * JD-Core Version:    0.7.0.1
 */