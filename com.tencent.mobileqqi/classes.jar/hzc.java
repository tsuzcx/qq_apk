import android.support.v4.util.LruCache;
import common.qzone.component.cache.common.ExtendLruCache;

public class hzc
  extends LruCache
{
  public hzc(ExtendLruCache paramExtendLruCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected Object create(Object paramObject)
  {
    return this.a.c(paramObject);
  }
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    this.a.a(paramBoolean, paramObject1, paramObject2, paramObject3);
  }
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return this.a.a(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hzc
 * JD-Core Version:    0.7.0.1
 */