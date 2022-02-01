import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class xpr
  extends LruCache<xps, Drawable>
{
  xpr(xpp paramxpp, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(xps paramxps, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        xqb.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramxps, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpr
 * JD-Core Version:    0.7.0.1
 */