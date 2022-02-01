import android.graphics.Bitmap;
import com.tencent.component.media.utils.LruCache;

class vgy
  extends LruCache<Integer, Bitmap>
{
  vgy(vgx paramvgx, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgy
 * JD-Core Version:    0.7.0.1
 */