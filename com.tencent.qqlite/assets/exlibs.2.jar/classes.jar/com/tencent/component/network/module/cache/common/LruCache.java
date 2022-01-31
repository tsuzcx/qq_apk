package com.tencent.component.network.module.cache.common;

import java.util.LinkedHashMap;

public class LruCache<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public LruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.c = paramInt;
    this.a = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int a(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.a.get(paramK);
      if (localObject1 != null)
      {
        this.g += 1;
        return localObject1;
      }
      this.h += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.e += 1;
      Object localObject2 = this.a.put(paramK, localObject1);
      if (localObject2 != null) {
        this.a.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return localObject2;
        this.b += a(paramK, localObject1);
      }
      trimToSize(this.c);
    }
    finally {}
    return localObject1;
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.d += 1;
      this.b += a(paramK, paramV);
      Object localObject = this.a.put(paramK, paramV);
      if (localObject != null) {
        this.b -= a(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.c);
      return localObject;
    }
    finally {}
  }
  
  public final V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.a.remove(paramK);
      if (localObject != null) {
        this.b -= a(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.g + this.h;
      if (j != 0) {
        i = this.g * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	com/tencent/component/network/module/cache/common/LruCache:b	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	com/tencent/component/network/module/cache/common/LruCache:a	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 131	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 100	com/tencent/component/network/module/cache/common/LruCache:b	I
    //   23: ifeq +41 -> 64
    //   26: new 45	java/lang/IllegalStateException
    //   29: dup
    //   30: new 47	java/lang/StringBuilder
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 135	java/lang/Object:getClass	()Ljava/lang/Class;
    //   38: invokevirtual 140	java/lang/Class:getName	()Ljava/lang/String;
    //   41: invokestatic 143	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: ldc 145
    //   49: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 64	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 100	com/tencent/component/network/module/cache/common/LruCache:b	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	com/tencent/component/network/module/cache/common/LruCache:a	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 131	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	com/tencent/component/network/module/cache/common/LruCache:a	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 149	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 155 1 0
    //   97: invokeinterface 161 1 0
    //   102: checkcast 163	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 166 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 169 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	com/tencent/component/network/module/cache/common/LruCache:a	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 112	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 100	com/tencent/component/network/module/cache/common/LruCache:b	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 102	com/tencent/component/network/module/cache/common/LruCache:a	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 100	com/tencent/component/network/module/cache/common/LruCache:b	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 171	com/tencent/component/network/module/cache/common/LruCache:f	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 171	com/tencent/component/network/module/cache/common/LruCache:f	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 98	com/tencent/component/network/module/cache/common/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	LruCache
    //   0	167	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	47	2	localObject2	Object
    //   105	55	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.common.LruCache
 * JD-Core Version:    0.7.0.1
 */