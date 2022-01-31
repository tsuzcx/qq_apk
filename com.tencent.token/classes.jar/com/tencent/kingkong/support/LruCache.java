package com.tencent.kingkong.support;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public LruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int safeSizeOf(K paramK, V paramV)
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
  
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.map.get(paramK);
      if (localObject1 != null)
      {
        this.hitCount += 1;
        return localObject1;
      }
      this.missCount += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.createCount += 1;
      Object localObject2 = this.map.put(paramK, localObject1);
      if (localObject2 != null) {
        this.map.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return localObject2;
        this.size += safeSizeOf(paramK, localObject1);
      }
      trimToSize(this.maxSize);
    }
    finally {}
    return localObject1;
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
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
      this.putCount += 1;
      this.size += safeSizeOf(paramK, paramV);
      Object localObject = this.map.put(paramK, paramV);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.maxSize);
      return localObject;
    }
    finally {}
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.map.remove(paramK);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  public void resize(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    try
    {
      this.maxSize = paramInt;
      trimToSize(paramInt);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
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
  
  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = this.hitCount * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
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
    //   3: getfield 104	com/tencent/kingkong/support/LruCache:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	com/tencent/kingkong/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 139	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 104	com/tencent/kingkong/support/LruCache:size	I
    //   23: ifeq +41 -> 64
    //   26: new 46	java/lang/IllegalStateException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 143	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 148	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 150
    //   49: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 65	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 104	com/tencent/kingkong/support/LruCache:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	com/tencent/kingkong/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 139	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_0
    //   88: getfield 38	com/tencent/kingkong/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   91: invokevirtual 154	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   94: invokeinterface 160 1 0
    //   99: invokeinterface 165 1 0
    //   104: ifeq +24 -> 128
    //   107: aload_0
    //   108: getfield 38	com/tencent/kingkong/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   111: invokevirtual 154	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   114: invokeinterface 160 1 0
    //   119: invokeinterface 169 1 0
    //   124: checkcast 171	java/util/Map$Entry
    //   127: astore_2
    //   128: aload_2
    //   129: ifnonnull +6 -> 135
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: aload_2
    //   136: invokeinterface 174 1 0
    //   141: astore_3
    //   142: aload_2
    //   143: invokeinterface 177 1 0
    //   148: astore_2
    //   149: aload_0
    //   150: getfield 38	com/tencent/kingkong/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   153: aload_3
    //   154: invokevirtual 114	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 104	com/tencent/kingkong/support/LruCache:size	I
    //   163: aload_0
    //   164: aload_3
    //   165: aload_2
    //   166: invokespecial 106	com/tencent/kingkong/support/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   169: isub
    //   170: putfield 104	com/tencent/kingkong/support/LruCache:size	I
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 82	com/tencent/kingkong/support/LruCache:evictionCount	I
    //   178: iconst_1
    //   179: iadd
    //   180: putfield 82	com/tencent/kingkong/support/LruCache:evictionCount	I
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_0
    //   186: iconst_1
    //   187: aload_3
    //   188: aload_2
    //   189: aconst_null
    //   190: invokevirtual 102	com/tencent/kingkong/support/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   193: goto -193 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	LruCache
    //   0	196	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   86	103	2	localObject2	Object
    //   141	47	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   87	128	59	finally
    //   132	134	59	finally
    //   135	185	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.support.LruCache
 * JD-Core Version:    0.7.0.1
 */