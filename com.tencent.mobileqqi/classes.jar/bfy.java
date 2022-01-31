import android.support.v4.util.LruCache;
import com.rookery.translate.model.TransMemCache;

public class bfy
  extends LruCache
{
  public bfy(TransMemCache paramTransMemCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bfy
 * JD-Core Version:    0.7.0.1
 */