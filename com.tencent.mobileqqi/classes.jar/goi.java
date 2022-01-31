import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import android.util.Pair;

public class goi
  extends MQLruCache
{
  public goi(Integer paramInteger)
  {
    super(paramInteger.intValue());
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    if ((paramObject instanceof Bitmap))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    return 12;
  }
  
  public void a(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     goi
 * JD-Core Version:    0.7.0.1
 */