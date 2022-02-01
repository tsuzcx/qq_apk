import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class wir<KEY, VALUE extends wiq>
{
  public int a;
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> a;
  
  public wir(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new wis(this, paramInt);
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
        yuk.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    wiq localwiq2 = (wiq)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramKEY);
    wiq localwiq1 = localwiq2;
    if (localwiq2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramKEY);
      localwiq1 = localwiq2;
      if (localWeakReference != null)
      {
        localwiq2 = (wiq)localWeakReference.get();
        localwiq1 = localwiq2;
        if (localwiq2 != null)
        {
          yuk.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localwiq2);
          localwiq1 = localwiq2;
        }
      }
    }
    return localwiq1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    wiq localwiq = a(paramKEY);
    if (localwiq == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localwiq.copy(paramVALUE);
    return localwiq;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.jdField_a_of_type_Int > 50)
    {
      b();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      yuk.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(KEY paramKEY)
  {
    wiq localwiq = (wiq)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramKEY);
    if (localwiq != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramKEY, new WeakReference(localwiq));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wir
 * JD-Core Version:    0.7.0.1
 */