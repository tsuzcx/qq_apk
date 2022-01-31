import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class uyc
  extends LruCache<uyd, Drawable>
{
  uyc(uya paramuya, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(uyd paramuyd, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        uym.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramuyd, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyc
 * JD-Core Version:    0.7.0.1
 */