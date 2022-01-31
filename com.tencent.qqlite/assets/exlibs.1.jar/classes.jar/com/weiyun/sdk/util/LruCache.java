package com.weiyun.sdk.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LruCache<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMapForCache<K, V> map;
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
    this.map = new LinkedHashMapForCache(0, 0.75F, true);
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  /* Error */
  private void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/weiyun/sdk/util/LruCache:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 39	com/weiyun/sdk/util/LruCache:map	Lcom/weiyun/sdk/util/LruCache$LinkedHashMapForCache;
    //   13: invokevirtual 75	com/weiyun/sdk/util/LruCache$LinkedHashMapForCache:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 71	com/weiyun/sdk/util/LruCache:size	I
    //   23: ifeq +41 -> 64
    //   26: new 47	java/lang/IllegalStateException
    //   29: dup
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 79	java/lang/Object:getClass	()Ljava/lang/Class;
    //   38: invokevirtual 84	java/lang/Class:getName	()Ljava/lang/String;
    //   41: invokestatic 90	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: ldc 92
    //   49: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 66	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 71	com/weiyun/sdk/util/LruCache:size	I
    //   68: iload_1
    //   69: if_icmpgt +6 -> 75
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload_0
    //   76: getfield 39	com/weiyun/sdk/util/LruCache:map	Lcom/weiyun/sdk/util/LruCache$LinkedHashMapForCache;
    //   79: invokevirtual 96	com/weiyun/sdk/util/LruCache$LinkedHashMapForCache:eldest	()Ljava/util/Map$Entry;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +6 -> 90
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: aload_3
    //   91: invokeinterface 102 1 0
    //   96: astore_2
    //   97: aload_3
    //   98: invokeinterface 105 1 0
    //   103: astore_3
    //   104: aload_0
    //   105: getfield 39	com/weiyun/sdk/util/LruCache:map	Lcom/weiyun/sdk/util/LruCache$LinkedHashMapForCache;
    //   108: aload_2
    //   109: invokevirtual 109	com/weiyun/sdk/util/LruCache$LinkedHashMapForCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 71	com/weiyun/sdk/util/LruCache:size	I
    //   118: aload_0
    //   119: aload_2
    //   120: aload_3
    //   121: invokespecial 111	com/weiyun/sdk/util/LruCache:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   124: isub
    //   125: putfield 71	com/weiyun/sdk/util/LruCache:size	I
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 113	com/weiyun/sdk/util/LruCache:evictionCount	I
    //   133: iconst_1
    //   134: iadd
    //   135: putfield 113	com/weiyun/sdk/util/LruCache:evictionCount	I
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_0
    //   141: iconst_1
    //   142: aload_2
    //   143: aload_3
    //   144: aconst_null
    //   145: invokevirtual 117	com/weiyun/sdk/util/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   148: goto -148 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	LruCache
    //   0	151	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   96	47	2	localObject2	Object
    //   82	62	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	74	59	finally
    //   75	83	59	finally
    //   87	89	59	finally
    //   90	140	59	finally
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
  
  public static class LinkedHashMapForCache<K, V>
    extends LinkedHashMap<K, V>
  {
    private static final long serialVersionUID = 1L;
    
    public LinkedHashMapForCache() {}
    
    public LinkedHashMapForCache(int paramInt)
    {
      super();
    }
    
    public LinkedHashMapForCache(int paramInt, float paramFloat)
    {
      super(paramFloat);
    }
    
    public LinkedHashMapForCache(int paramInt, float paramFloat, boolean paramBoolean)
    {
      super(paramFloat, paramBoolean);
    }
    
    public LinkedHashMapForCache(Map<? extends K, ? extends V> paramMap)
    {
      super();
    }
    
    public Map.Entry<K, V> eldest()
    {
      Iterator localIterator = entrySet().iterator();
      if (localIterator.hasNext()) {
        return (Map.Entry)localIterator.next();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.LruCache
 * JD-Core Version:    0.7.0.1
 */