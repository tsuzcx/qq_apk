import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class uxy
  extends LruCache<uya, Drawable>
{
  uxy(uxx paramuxx, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(uya paramuya, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        uyj.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramuya, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxy
 * JD-Core Version:    0.7.0.1
 */