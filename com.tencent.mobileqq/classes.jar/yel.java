import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class yel
  extends LruCache<yen, Drawable>
{
  yel(yek paramyek, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(yen paramyen, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        yew.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramyen, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yel
 * JD-Core Version:    0.7.0.1
 */