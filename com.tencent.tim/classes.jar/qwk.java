import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

class qwk
  extends LruCache<qwj.a, Drawable>
{
  qwk(qwj paramqwj, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(qwj.a parama, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes();
        i = paramDrawable.getHeight() * i;
        qwp.d("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", parama, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwk
 * JD-Core Version:    0.7.0.1
 */