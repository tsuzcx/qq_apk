import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class yof
  extends LruCache<yoh, Drawable>
{
  yof(yoe paramyoe, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(yoh paramyoh, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        yoq.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramyoh, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */