package common.qzone.component.cache.common;

import fjh;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class FastLruCache
{
  private final int jdField_a_of_type_Int;
  private ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private final HashMap b = new HashMap();
  
  public FastLruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = new FastLruCache.1(this, 16, 0.75F, true, paramInt);
  }
  
  private void a()
  {
    for (fjh localfjh = (fjh)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll(); localfjh != null; localfjh = (fjh)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll()) {
      this.b.remove(localfjh.a);
    }
  }
  
  /* Error */
  public final Object a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 57	common/qzone/component/cache/common/FastLruCache:a	()V
    //   6: aload_0
    //   7: getfield 41	common/qzone/component/cache/common/FastLruCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 60	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +9 -> 25
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 19	common/qzone/component/cache/common/FastLruCache:b	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 60	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 48	fjh
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +8 -> 46
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -22 -> 21
    //   46: aload_1
    //   47: invokevirtual 63	fjh:get	()Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FastLruCache
    //   0	59	1	paramObject	Object
    //   14	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	54	finally
    //   25	37	54	finally
    //   46	51	54	finally
  }
  
  /* Error */
  public final Object a(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 57	common/qzone/component/cache/common/FastLruCache:a	()V
    //   6: aload_0
    //   7: getfield 41	common/qzone/component/cache/common/FastLruCache:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 67	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: getfield 19	common/qzone/component/cache/common/FastLruCache:b	Ljava/util/HashMap;
    //   20: aload_1
    //   21: new 48	fjh
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 24	common/qzone/component/cache/common/FastLruCache:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   31: invokespecial 70	fjh:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   34: invokevirtual 67	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 48	fjh
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +9 -> 51
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_1
    //   52: invokevirtual 63	fjh:get	()Ljava/lang/Object;
    //   55: astore_1
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	FastLruCache
    //   0	64	1	paramObject1	Object
    //   0	64	2	paramObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	59	finally
    //   51	56	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.cache.common.FastLruCache
 * JD-Core Version:    0.7.0.1
 */