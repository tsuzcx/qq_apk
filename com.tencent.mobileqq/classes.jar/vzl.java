import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class vzl<KEY, VALUE extends vzk>
{
  public int a;
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> a;
  
  public vzl(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new vzm(this, paramInt);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if ((localWeakReference != null) && (localWeakReference.get() == null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        ykq.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    vzk localvzk2 = (vzk)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramKEY);
    vzk localvzk1 = localvzk2;
    if (localvzk2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramKEY);
      localvzk1 = localvzk2;
      if (localWeakReference != null)
      {
        localvzk2 = (vzk)localWeakReference.get();
        localvzk1 = localvzk2;
        if (localvzk2 != null)
        {
          ykq.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localvzk2);
          localvzk1 = localvzk2;
        }
      }
    }
    return localvzk1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    vzk localvzk = a(paramKEY);
    if (localvzk == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localvzk.copy(paramVALUE);
    return localvzk;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.jdField_a_of_type_Int > 50)
    {
      b();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      ykq.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(KEY paramKEY)
  {
    vzk localvzk = (vzk)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramKEY);
    if (localvzk != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramKEY, new WeakReference(localvzk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */