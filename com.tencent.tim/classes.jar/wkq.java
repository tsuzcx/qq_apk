import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class wkq
  extends QQLruCache<String, xwc>
{
  public wkq(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, xwc paramxwc1, xwc paramxwc2)
  {
    super.entryRemoved(paramBoolean, paramString, paramxwc1, paramxwc2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */