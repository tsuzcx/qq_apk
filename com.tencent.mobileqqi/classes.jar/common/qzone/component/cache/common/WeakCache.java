package common.qzone.component.cache.common;

import hzn;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Set;

public class WeakCache
{
  private ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private void b()
  {
    for (hzn localhzn = (hzn)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll(); localhzn != null; localhzn = (hzn)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll()) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(localhzn.a);
    }
  }
  
  /* Error */
  public final Object a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 38	common/qzone/component/cache/common/WeakCache:b	()V
    //   6: aload_0
    //   7: getfield 16	common/qzone/component/cache/common/WeakCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 41	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 29	hzn
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_1
    //   29: invokevirtual 44	hzn:get	()Ljava/lang/Object;
    //   32: astore_1
    //   33: goto -9 -> 24
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	WeakCache
    //   0	41	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	36	finally
    //   28	33	36	finally
  }
  
  /* Error */
  public final Object a(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 38	common/qzone/component/cache/common/WeakCache:b	()V
    //   6: aload_0
    //   7: getfield 16	common/qzone/component/cache/common/WeakCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: new 29	hzn
    //   14: dup
    //   15: aload_1
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 21	common/qzone/component/cache/common/WeakCache:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   21: invokespecial 48	hzn:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   24: invokevirtual 51	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 29	hzn
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +9 -> 41
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_1
    //   42: invokevirtual 44	hzn:get	()Ljava/lang/Object;
    //   45: astore_1
    //   46: goto -9 -> 37
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	WeakCache
    //   0	54	1	paramObject1	Object
    //   0	54	2	paramObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	49	finally
    //   41	46	49	finally
  }
  
  public final Set a()
  {
    try
    {
      b();
      Set localSet = this.jdField_a_of_type_JavaUtilHashMap.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(Object paramObject)
  {
    try
    {
      b();
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  /* Error */
  public final Object b(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 38	common/qzone/component/cache/common/WeakCache:b	()V
    //   6: aload_0
    //   7: getfield 16	common/qzone/component/cache/common/WeakCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 36	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 29	hzn
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_1
    //   29: invokevirtual 44	hzn:get	()Ljava/lang/Object;
    //   32: astore_1
    //   33: goto -9 -> 24
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	WeakCache
    //   0	41	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	36	finally
    //   28	33	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.qzone.component.cache.common.WeakCache
 * JD-Core Version:    0.7.0.1
 */