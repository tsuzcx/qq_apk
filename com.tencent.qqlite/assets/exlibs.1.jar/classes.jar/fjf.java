import android.support.v4.util.LruCache;
import common.qzone.component.cache.common.ExtendLruCache;

public class fjf
  extends LruCache
{
  public fjf(ExtendLruCache paramExtendLruCache, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjf
 * JD-Core Version:    0.7.0.1
 */