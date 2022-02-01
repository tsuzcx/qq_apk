import android.graphics.Bitmap;
import com.tencent.component.media.utils.LruCache;

class vjc
  extends LruCache<Integer, Bitmap>
{
  vjc(vjb paramvjb, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjc
 * JD-Core Version:    0.7.0.1
 */