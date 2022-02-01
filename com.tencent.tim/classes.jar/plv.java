import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class plv<KEY, VALUE extends plu>
{
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> bQ = new ConcurrentHashMap(50);
  public int bjm;
  public LruCache<KEY, VALUE> e;
  
  public plv(int paramInt)
  {
    this.e = new plw(this, paramInt);
    this.e.evictAll();
  }
  
  private void blK()
  {
    Iterator localIterator = this.bQ.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.bQ.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.bQ.remove(localObject);
        ram.d("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    plu localplu2 = (plu)this.e.get(paramKEY);
    plu localplu1 = localplu2;
    if (localplu2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.bQ.remove(paramKEY);
      localplu1 = localplu2;
      if (localWeakReference != null)
      {
        localplu2 = (plu)localWeakReference.get();
        localplu1 = localplu2;
        if (localplu2 != null)
        {
          ram.d("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localplu2);
          localplu1 = localplu2;
        }
      }
    }
    return localplu1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    plu localplu = a(paramKEY);
    if (localplu == null)
    {
      this.e.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localplu.copy(paramVALUE);
    return localplu;
  }
  
  public void ag(KEY paramKEY)
  {
    plu localplu = (plu)this.e.remove(paramKEY);
    if (localplu != null) {
      this.bQ.put(paramKEY, new WeakReference(localplu));
    }
  }
  
  public void blJ()
  {
    int i = this.bQ.size();
    if (i - this.bjm > 50)
    {
      blK();
      this.bjm = this.bQ.size();
      ram.b("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.bjm));
    }
  }
  
  public void trimToSize(int paramInt)
  {
    this.e.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plv
 * JD-Core Version:    0.7.0.1
 */