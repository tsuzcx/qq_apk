import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class uhb<KEY, VALUE extends uha>
{
  public int a;
  public LruCache<KEY, VALUE> a;
  public ConcurrentHashMap<KEY, WeakReference<VALUE>> a;
  
  public uhb(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(50);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new uhc(this, paramInt);
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
        wsv.b("OneObjectCacheList", String.format("key :%s had been remove by jvm", new Object[] { localObject }));
      }
    }
  }
  
  public VALUE a(KEY paramKEY)
  {
    uha localuha2 = (uha)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramKEY);
    uha localuha1 = localuha2;
    if (localuha2 == null)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramKEY);
      localuha1 = localuha2;
      if (localWeakReference != null)
      {
        localuha2 = (uha)localWeakReference.get();
        localuha1 = localuha2;
        if (localuha2 != null)
        {
          wsv.b("OneObjectCacheList", String.format("revert key %s from second cache", new Object[] { paramKEY }));
          a(paramKEY, localuha2);
          localuha1 = localuha2;
        }
      }
    }
    return localuha1;
  }
  
  public VALUE a(KEY paramKEY, VALUE paramVALUE)
  {
    uha localuha = a(paramKEY);
    if (localuha == null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramKEY, paramVALUE);
      return paramVALUE;
    }
    localuha.copy(paramVALUE);
    return localuha;
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    if (i - this.jdField_a_of_type_Int > 50)
    {
      b();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      wsv.a("OneObjectCacheList", "evict second cache data count:%d", Integer.valueOf(i - this.jdField_a_of_type_Int));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.trimToSize(paramInt);
  }
  
  public void a(KEY paramKEY)
  {
    uha localuha = (uha)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramKEY);
    if (localuha != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramKEY, new WeakReference(localuha));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */