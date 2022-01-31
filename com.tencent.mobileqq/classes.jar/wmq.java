import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class wmq
  extends LruCache<wms, Drawable>
{
  wmq(wmp paramwmp, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(wms paramwms, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        wnb.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramwms, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmq
 * JD-Core Version:    0.7.0.1
 */