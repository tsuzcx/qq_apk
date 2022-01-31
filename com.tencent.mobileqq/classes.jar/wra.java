import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class wra
  extends LruCache<wrb, Drawable>
{
  wra(wqy paramwqy, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(wrb paramwrb, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        wrk.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramwrb, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wra
 * JD-Core Version:    0.7.0.1
 */