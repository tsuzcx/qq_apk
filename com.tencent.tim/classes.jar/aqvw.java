import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;

class aqvw
  extends MQLruCache<String, Object>
{
  aqvw(aqvv paramaqvv, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOfObj(String paramString, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bitmap)))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    return super.sizeOfObj(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvw
 * JD-Core Version:    0.7.0.1
 */