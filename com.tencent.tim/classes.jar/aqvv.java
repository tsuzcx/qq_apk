import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aqvv
  extends awlp
{
  private MQLruCache<String, Object> mMemoryCache;
  
  public aqvv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public MQLruCache<String, Object> a()
  {
    return this.mMemoryCache;
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mMemoryCache != null)
    {
      Iterator localIterator = this.mMemoryCache.getLargeCache().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mMemoryCache.get(str);
        if ((localObject != null) && ((localObject instanceof Bitmap)))
        {
          ((Bitmap)localObject).recycle();
          QZLog.i("DIYProfileTemplate.DIYLottieLoader", 4, "recycle bitmap key = " + str);
        }
      }
      this.mMemoryCache.releaseLargeCache();
    }
  }
  
  public void hx(int paramInt)
  {
    this.mMemoryCache = new aqvw(this, paramInt);
    this.mMemoryCache.setLargeSize(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvv
 * JD-Core Version:    0.7.0.1
 */