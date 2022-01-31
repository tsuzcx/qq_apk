package com.tencent.wcdb.support;

import android.annotation.SuppressLint;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap map;
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
  
  private int safeSizeOf(Object paramObject1, Object paramObject2)
  {
    int i = sizeOf(paramObject1, paramObject2);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramObject1 + "=" + paramObject2);
    }
    return i;
  }
  
  protected Object create(Object paramObject)
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
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
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
  
  public final Object get(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.map.get(paramObject);
      if (localObject1 != null)
      {
        this.hitCount += 1;
        return localObject1;
      }
      this.missCount += 1;
      localObject1 = create(paramObject);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.createCount += 1;
      Object localObject2 = this.map.put(paramObject, localObject1);
      if (localObject2 != null) {
        this.map.put(paramObject, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramObject, localObject1, localObject2);
        return localObject2;
        this.size += safeSizeOf(paramObject, localObject1);
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
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.putCount += 1;
      this.size += safeSizeOf(paramObject1, paramObject2);
      Object localObject = this.map.put(paramObject1, paramObject2);
      if (localObject != null) {
        this.size -= safeSizeOf(paramObject1, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramObject1, localObject, paramObject2);
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
  
  public final Object remove(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.map.remove(paramObject);
      if (localObject != null) {
        this.size -= safeSizeOf(paramObject, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramObject, localObject, null);
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
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Map snapshot()
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
  
  @SuppressLint({"DefaultLocale"})
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
    //   3: getfield 98	com/tencent/wcdb/support/LruCache:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 36	com/tencent/wcdb/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 135	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 98	com/tencent/wcdb/support/LruCache:size	I
    //   23: ifeq +41 -> 64
    //   26: new 44	java/lang/IllegalStateException
    //   29: dup
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 139	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 144	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 146
    //   49: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 63	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 98	com/tencent/wcdb/support/LruCache:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 36	com/tencent/wcdb/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 135	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 36	com/tencent/wcdb/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 150	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 156 1 0
    //   97: invokeinterface 161 1 0
    //   102: ifeq +92 -> 194
    //   105: aload_0
    //   106: getfield 36	com/tencent/wcdb/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   109: invokevirtual 150	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   112: invokeinterface 156 1 0
    //   117: invokeinterface 165 1 0
    //   122: checkcast 167	java/util/Map$Entry
    //   125: astore_2
    //   126: aload_2
    //   127: ifnonnull +6 -> 133
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: aload_2
    //   134: invokeinterface 170 1 0
    //   139: astore_3
    //   140: aload_2
    //   141: invokeinterface 173 1 0
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 36	com/tencent/wcdb/support/LruCache:map	Ljava/util/LinkedHashMap;
    //   151: aload_3
    //   152: invokevirtual 107	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 98	com/tencent/wcdb/support/LruCache:size	I
    //   161: aload_0
    //   162: aload_3
    //   163: aload_2
    //   164: invokespecial 100	com/tencent/wcdb/support/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   167: isub
    //   168: putfield 98	com/tencent/wcdb/support/LruCache:size	I
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 76	com/tencent/wcdb/support/LruCache:evictionCount	I
    //   176: iconst_1
    //   177: iadd
    //   178: putfield 76	com/tencent/wcdb/support/LruCache:evictionCount	I
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_0
    //   184: iconst_1
    //   185: aload_3
    //   186: aload_2
    //   187: aconst_null
    //   188: invokevirtual 96	com/tencent/wcdb/support/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   191: goto -191 -> 0
    //   194: aconst_null
    //   195: astore_2
    //   196: goto -70 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	LruCache
    //   0	199	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   125	71	2	localObject2	Object
    //   139	47	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	126	59	finally
    //   130	132	59	finally
    //   133	183	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.LruCache
 * JD-Core Version:    0.7.0.1
 */