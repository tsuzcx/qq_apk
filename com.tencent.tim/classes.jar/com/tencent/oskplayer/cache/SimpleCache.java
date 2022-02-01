package com.tencent.oskplayer.cache;

import android.os.ConditionVariable;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleCache
  implements Cache
{
  private static final String LOG_TAG = "SimpleCache";
  private final File cacheDir;
  private final HashMap<String, TreeSet<CacheSpan>> cachedSpans;
  private final CacheEvictor evictor;
  private final HashMap<String, ArrayList<Cache.Listener>> listeners;
  private final HashMap<String, CacheSpan> lockedSpans;
  private long totalSpace;
  
  public SimpleCache(File paramFile, CacheEvictor paramCacheEvictor)
  {
    this.cacheDir = paramFile;
    this.evictor = paramCacheEvictor;
    this.lockedSpans = new HashMap();
    this.cachedSpans = new HashMap();
    this.listeners = new HashMap();
    paramFile = new ConditionVariable();
    new SimpleCache.1(this, paramFile).start();
    paramFile.block();
  }
  
  private boolean addSpan(CacheSpan paramCacheSpan)
  {
    TreeSet localTreeSet2 = (TreeSet)this.cachedSpans.get(paramCacheSpan.key);
    TreeSet localTreeSet1 = localTreeSet2;
    if (localTreeSet2 == null)
    {
      localTreeSet1 = new TreeSet();
      this.cachedSpans.put(paramCacheSpan.key, localTreeSet1);
    }
    boolean bool = localTreeSet1.add(paramCacheSpan);
    this.totalSpace += paramCacheSpan.length;
    notifySpanAdded(paramCacheSpan);
    return bool;
  }
  
  private void deleteDir(File paramFile)
  {
    if (!paramFile.exists()) {}
    for (;;)
    {
      return;
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int i = 0;
        while (i < paramFile.length)
        {
          File localFile = paramFile[i];
          if (localFile.isDirectory()) {
            deleteDir(localFile);
          }
          localFile.delete();
          i += 1;
        }
      }
    }
  }
  
  private CacheSpan getSpan(CacheSpan paramCacheSpan)
  {
    Object localObject = paramCacheSpan.key;
    long l = paramCacheSpan.position;
    TreeSet localTreeSet = (TreeSet)this.cachedSpans.get(localObject);
    if (localTreeSet == null) {
      localObject = CacheSpan.createOpenHole((String)localObject, paramCacheSpan.position);
    }
    do
    {
      return localObject;
      localCacheSpan = (CacheSpan)localTreeSet.floor(paramCacheSpan);
      if ((localCacheSpan == null) || (localCacheSpan.position > l) || (l >= localCacheSpan.position + localCacheSpan.length)) {
        break;
      }
      localObject = localCacheSpan;
    } while (localCacheSpan.file.exists());
    removeStaleSpans();
    return getSpan(paramCacheSpan);
    CacheSpan localCacheSpan = (CacheSpan)localTreeSet.ceiling(paramCacheSpan);
    if (localCacheSpan == null) {}
    for (paramCacheSpan = CacheSpan.createOpenHole((String)localObject, paramCacheSpan.position);; paramCacheSpan = CacheSpan.createClosedHole((String)localObject, paramCacheSpan.position, localCacheSpan.position - paramCacheSpan.position)) {
      return paramCacheSpan;
    }
  }
  
  private void initialize()
  {
    if (!this.cacheDir.exists()) {
      this.cacheDir.mkdirs();
    }
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i = 0;
    label33:
    File localFile;
    if (i < arrayOfFile.length)
    {
      localFile = arrayOfFile[i];
      if (localFile.length() != 0L) {
        break label64;
      }
      localFile.delete();
    }
    for (;;)
    {
      i += 1;
      break label33;
      break;
      label64:
      CacheSpan localCacheSpan = CacheSpan.createCacheEntry(localFile);
      if (localCacheSpan == null)
      {
        localFile.delete();
      }
      else if (!addSpan(localCacheSpan))
      {
        PlayerUtils.log(3, "SimpleCache", "remove duplicated span " + localCacheSpan.file);
        removeSpan(localCacheSpan);
      }
    }
  }
  
  private void notifySpanAdded(CacheSpan paramCacheSpan)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanAdded(this, paramCacheSpan);
        i -= 1;
      }
    }
    this.evictor.onSpanAdded(this, paramCacheSpan);
  }
  
  private void notifySpanRemoved(CacheSpan paramCacheSpan)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanRemoved(this, paramCacheSpan);
        i -= 1;
      }
    }
    this.evictor.onSpanRemoved(this, paramCacheSpan);
  }
  
  private void notifySpanTouched(CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2)
  {
    ArrayList localArrayList = (ArrayList)this.listeners.get(paramCacheSpan1.key);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Cache.Listener)localArrayList.get(i)).onSpanTouched(this, paramCacheSpan1, paramCacheSpan2);
        i -= 1;
      }
    }
    this.evictor.onSpanTouched(this, paramCacheSpan1, paramCacheSpan2);
  }
  
  private void removeStaleSpans()
  {
    Iterator localIterator1 = this.cachedSpans.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
      int i = 1;
      if (localIterator2.hasNext())
      {
        CacheSpan localCacheSpan = (CacheSpan)localIterator2.next();
        if (!localCacheSpan.file.exists())
        {
          localIterator2.remove();
          if (localCacheSpan.isCached) {
            this.totalSpace -= localCacheSpan.length;
          }
          notifySpanRemoved(localCacheSpan);
        }
        for (;;)
        {
          break;
          i = 0;
        }
      }
      if (i != 0) {
        localIterator1.remove();
      }
    }
  }
  
  private CacheSpan startReadWriteNonBlocking(CacheSpan paramCacheSpan)
  {
    for (;;)
    {
      try
      {
        CacheSpan localCacheSpan = getSpan(paramCacheSpan);
        boolean bool = localCacheSpan.isCached;
        if (bool)
        {
          paramCacheSpan = localCacheSpan;
          return paramCacheSpan;
        }
        if (!this.lockedSpans.containsKey(paramCacheSpan.key))
        {
          this.lockedSpans.put(paramCacheSpan.key, localCacheSpan);
          paramCacheSpan = localCacheSpan;
        }
        else
        {
          paramCacheSpan = null;
        }
      }
      finally {}
    }
  }
  
  public NavigableSet<CacheSpan> addListener(String paramString, Cache.Listener paramListener)
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)this.listeners.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.listeners.put(paramString, localArrayList1);
      }
      localArrayList1.add(paramListener);
      paramString = getCachedSpans(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void commitFile(File paramFile)
  {
    for (;;)
    {
      try
      {
        CacheSpan localCacheSpan = CacheSpan.createCacheEntry(paramFile);
        boolean bool;
        if (localCacheSpan != null)
        {
          bool = true;
          Assertions.checkState(bool);
          Assertions.checkState(this.lockedSpans.containsKey(localCacheSpan.key));
          bool = paramFile.exists();
          if (bool) {}
        }
        else
        {
          bool = false;
          continue;
        }
        if (paramFile.length() == 0L)
        {
          paramFile.delete();
          continue;
        }
        addSpan(localCacheSpan);
      }
      finally {}
      notifyAll();
    }
  }
  
  public void evictOneSpan()
  {
    try
    {
      if (this.evictor != null) {
        this.evictor.evictOne(this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCacheSpace()
  {
    try
    {
      long l = this.totalSpace;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getCachedBytesFromEnd(String paramString)
  {
    long l1 = 0L;
    paramString = getCachedSpans(paramString);
    long l2 = l1;
    CacheSpan localCacheSpan;
    if (paramString != null)
    {
      localCacheSpan = (CacheSpan)paramString.last();
      if ((localCacheSpan == null) || (!localCacheSpan.isCached) || (localCacheSpan.totalLength < 0L) || (localCacheSpan.position + localCacheSpan.length >= localCacheSpan.totalLength)) {
        break label75;
      }
      l2 = l1;
    }
    label75:
    do
    {
      do
      {
        return l2;
        l2 = l1;
      } while (localCacheSpan == null);
      l2 = l1;
    } while (localCacheSpan.totalLength < 0L);
    paramString = paramString.descendingSet().iterator();
    for (;;)
    {
      l2 = l1;
      if (!paramString.hasNext()) {
        break;
      }
      localCacheSpan = (CacheSpan)paramString.next();
      l2 = l1;
      if (!localCacheSpan.isCached) {
        break;
      }
      l1 = localCacheSpan.length + l1;
    }
  }
  
  /* Error */
  public long getCachedBytesFromStart(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 252	com/tencent/oskplayer/cache/SimpleCache:getCachedSpans	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   9: astore_1
    //   10: lload_2
    //   11: lstore 4
    //   13: aload_1
    //   14: ifnull +136 -> 150
    //   17: aload_1
    //   18: invokeinterface 289 1 0
    //   23: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +43 -> 73
    //   33: aload 6
    //   35: getfield 238	com/tencent/oskplayer/cache/CacheSpan:isCached	Z
    //   38: ifeq +35 -> 73
    //   41: aload 6
    //   43: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   46: lconst_0
    //   47: lcmp
    //   48: iflt +25 -> 73
    //   51: aload 6
    //   53: getfield 117	com/tencent/oskplayer/cache/CacheSpan:position	J
    //   56: lstore 4
    //   58: lload 4
    //   60: lconst_0
    //   61: lcmp
    //   62: ifeq +11 -> 73
    //   65: lload_2
    //   66: lstore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: lload 4
    //   72: lreturn
    //   73: lload_2
    //   74: lstore 4
    //   76: aload 6
    //   78: ifnull +72 -> 150
    //   81: lload_2
    //   82: lstore 4
    //   84: aload 6
    //   86: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   89: lconst_0
    //   90: lcmp
    //   91: iflt +59 -> 150
    //   94: aload_1
    //   95: invokeinterface 285 1 0
    //   100: astore_1
    //   101: lload_2
    //   102: lstore 4
    //   104: aload_1
    //   105: invokeinterface 221 1 0
    //   110: ifeq +40 -> 150
    //   113: aload_1
    //   114: invokeinterface 225 1 0
    //   119: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   122: astore 6
    //   124: lload_2
    //   125: lstore 4
    //   127: aload 6
    //   129: getfield 238	com/tencent/oskplayer/cache/CacheSpan:isCached	Z
    //   132: ifeq -64 -> 68
    //   135: aload 6
    //   137: getfield 88	com/tencent/oskplayer/cache/CacheSpan:length	J
    //   140: lstore 4
    //   142: lload_2
    //   143: lload 4
    //   145: ladd
    //   146: lstore_2
    //   147: goto -46 -> 101
    //   150: goto -82 -> 68
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	SimpleCache
    //   0	158	1	paramString	String
    //   1	146	2	l1	long
    //   11	133	4	l2	long
    //   26	110	6	localCacheSpan	CacheSpan
    // Exception table:
    //   from	to	target	type
    //   4	10	153	finally
    //   17	28	153	finally
    //   33	58	153	finally
    //   84	101	153	finally
    //   104	124	153	finally
    //   127	142	153	finally
  }
  
  public double getCachedSizeRate(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = getCachedSpans(paramString);
        if (paramString != null)
        {
          CacheSpan localCacheSpan = (CacheSpan)paramString.first();
          if ((localCacheSpan != null) && (localCacheSpan.totalLength > 0L))
          {
            long l2 = localCacheSpan.totalLength;
            paramString = paramString.iterator();
            long l1 = 0L;
            if (paramString.hasNext())
            {
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool)
              {
                d = l1;
                return d;
              }
              long l3 = localCacheSpan.length;
              l1 = l3 + l1;
              continue;
            }
            d = l1 / l2;
            continue;
          }
        }
        double d = 0.0D;
      }
      finally {}
    }
  }
  
  /* Error */
  public NavigableSet<CacheSpan> getCachedSpans(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/oskplayer/cache/SimpleCache:cachedSpans	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 72	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 74	java/util/TreeSet
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: new 74	java/util/TreeSet
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 294	java/util/TreeSet:<init>	(Ljava/util/SortedSet;)V
    //   32: astore_1
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	SimpleCache
    //   0	41	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
    //   24	33	36	finally
  }
  
  /* Error */
  public FileType getContentType(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 252	com/tencent/oskplayer/cache/SimpleCache:getCachedSpans	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +35 -> 44
    //   12: aload_1
    //   13: invokeinterface 289 1 0
    //   18: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +21 -> 44
    //   26: aload_1
    //   27: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   30: lconst_0
    //   31: lcmp
    //   32: iflt +12 -> 44
    //   35: aload_1
    //   36: getfield 301	com/tencent/oskplayer/cache/CacheSpan:fileType	Lcom/tencent/oskplayer/proxy/FileType;
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: areturn
    //   44: getstatic 306	com/tencent/oskplayer/proxy/FileType:UNKNOWN	Lcom/tencent/oskplayer/proxy/FileType;
    //   47: astore_1
    //   48: goto -8 -> 40
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SimpleCache
    //   0	56	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	8	51	finally
    //   12	22	51	finally
    //   26	40	51	finally
    //   44	48	51	finally
  }
  
  public Set<String> getKeys()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.cachedSpans.keySet());
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRemainUnCachedBytes(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = getCachedSpans(paramString);
        if (paramString != null)
        {
          CacheSpan localCacheSpan = (CacheSpan)paramString.first();
          if ((localCacheSpan != null) && (localCacheSpan.totalLength > 0L))
          {
            long l2 = localCacheSpan.totalLength;
            paramString = paramString.iterator();
            l1 = 0L;
            if (paramString.hasNext())
            {
              localCacheSpan = (CacheSpan)paramString.next();
              boolean bool = localCacheSpan.isCached;
              if (!bool) {
                return l1;
              }
              long l3 = localCacheSpan.length;
              l1 += l3;
              continue;
            }
            l1 = l2 - l1;
            continue;
          }
        }
        long l1 = -1L;
      }
      finally {}
    }
  }
  
  /* Error */
  public long getTotalLength(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 252	com/tencent/oskplayer/cache/SimpleCache:getCachedSpans	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +35 -> 44
    //   12: aload_1
    //   13: invokeinterface 289 1 0
    //   18: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +21 -> 44
    //   26: aload_1
    //   27: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   30: lconst_0
    //   31: lcmp
    //   32: iflt +12 -> 44
    //   35: aload_1
    //   36: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   39: lstore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: lload_2
    //   43: lreturn
    //   44: ldc2_w 318
    //   47: lstore_2
    //   48: goto -8 -> 40
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SimpleCache
    //   0	56	1	paramString	String
    //   39	9	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	8	51	finally
    //   12	22	51	finally
    //   26	40	51	finally
  }
  
  /* Error */
  public boolean isCached(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 252	com/tencent/oskplayer/cache/SimpleCache:getCachedSpans	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +111 -> 122
    //   14: aload_1
    //   15: invokeinterface 289 1 0
    //   20: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   23: astore 9
    //   25: aload 9
    //   27: ifnull +95 -> 122
    //   30: aload 9
    //   32: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   35: lconst_0
    //   36: lcmp
    //   37: iflt +85 -> 122
    //   40: aload 9
    //   42: getfield 280	com/tencent/oskplayer/cache/CacheSpan:totalLength	J
    //   45: lstore 4
    //   47: aload_1
    //   48: invokeinterface 285 1 0
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 221 1 0
    //   60: ifeq +49 -> 109
    //   63: aload_1
    //   64: invokeinterface 225 1 0
    //   69: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   72: astore 9
    //   74: aload 9
    //   76: getfield 238	com/tencent/oskplayer/cache/CacheSpan:isCached	Z
    //   79: istore 8
    //   81: iload 8
    //   83: ifne +11 -> 94
    //   86: iconst_0
    //   87: istore 8
    //   89: aload_0
    //   90: monitorexit
    //   91: iload 8
    //   93: ireturn
    //   94: aload 9
    //   96: getfield 88	com/tencent/oskplayer/cache/CacheSpan:length	J
    //   99: lstore 6
    //   101: lload_2
    //   102: lload 6
    //   104: ladd
    //   105: lstore_2
    //   106: goto -52 -> 54
    //   109: lload_2
    //   110: lload 4
    //   112: lcmp
    //   113: iflt +9 -> 122
    //   116: iconst_1
    //   117: istore 8
    //   119: goto -30 -> 89
    //   122: iconst_0
    //   123: istore 8
    //   125: goto -36 -> 89
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	SimpleCache
    //   0	133	1	paramString	String
    //   1	109	2	l1	long
    //   45	66	4	l2	long
    //   99	4	6	l3	long
    //   79	45	8	bool	boolean
    //   23	72	9	localCacheSpan	CacheSpan
    // Exception table:
    //   from	to	target	type
    //   4	10	128	finally
    //   14	25	128	finally
    //   30	54	128	finally
    //   54	81	128	finally
    //   94	101	128	finally
  }
  
  public boolean isCached(String paramString, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Object localObject = (TreeSet)this.cachedSpans.get(paramString);
        boolean bool;
        if (localObject == null)
        {
          bool = false;
          return bool;
        }
        paramString = (CacheSpan)((TreeSet)localObject).floor(CacheSpan.createLookup(paramString, paramLong1));
        if ((paramString != null) && (paramString.position + paramString.length > paramLong1))
        {
          paramLong2 = paramLong1 + paramLong2;
          paramLong1 = paramString.position + paramString.length;
          if (paramLong1 >= paramLong2)
          {
            bool = true;
          }
          else
          {
            paramString = ((TreeSet)localObject).tailSet(paramString, false).iterator();
            if (paramString.hasNext())
            {
              localObject = (CacheSpan)paramString.next();
              if (((CacheSpan)localObject).position > paramLong1)
              {
                bool = false;
              }
              else
              {
                long l = ((CacheSpan)localObject).position;
                paramLong1 = Math.max(paramLong1, ((CacheSpan)localObject).length + l);
                if (paramLong1 >= paramLong2) {
                  bool = true;
                } else {}
              }
            }
            else
            {
              bool = false;
            }
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void releaseHoleSpan(CacheSpan paramCacheSpan)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 37	com/tencent/oskplayer/cache/SimpleCache:lockedSpans	Ljava/util/HashMap;
    //   7: aload_1
    //   8: getfield 68	com/tencent/oskplayer/cache/CacheSpan:key	Ljava/lang/String;
    //   11: invokevirtual 338	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: if_acmpne +16 -> 30
    //   17: iconst_1
    //   18: istore_2
    //   19: iload_2
    //   20: invokestatic 261	com/tencent/oskplayer/util/Assertions:checkState	(Z)V
    //   23: aload_0
    //   24: invokevirtual 264	java/lang/Object:notifyAll	()V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -13 -> 19
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	SimpleCache
    //   0	40	1	paramCacheSpan	CacheSpan
    //   18	14	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	35	finally
    //   19	27	35	finally
  }
  
  public void removeAll()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator1 = this.cachedSpans.entrySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        Iterator localIterator2 = ((TreeSet)((Map.Entry)localIterator1.next()).getValue()).iterator();
        if (localIterator2.hasNext())
        {
          CacheSpan localCacheSpan = (CacheSpan)localIterator2.next();
          localIterator2.remove();
          if (localCacheSpan.isCached) {
            this.totalSpace -= localCacheSpan.length;
          }
          notifySpanRemoved(localCacheSpan);
        }
        else
        {
          localObject.remove();
        }
      }
      finally {}
    }
    deleteDir(this.cacheDir);
  }
  
  /* Error */
  public void removeByKey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 252	com/tencent/oskplayer/cache/SimpleCache:getCachedSpans	(Ljava/lang/String;)Ljava/util/NavigableSet;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull -10 -> 11
    //   24: aload_1
    //   25: invokeinterface 285 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 221 1 0
    //   37: ifeq -26 -> 11
    //   40: aload_0
    //   41: aload_1
    //   42: invokeinterface 225 1 0
    //   47: checkcast 65	com/tencent/oskplayer/cache/CacheSpan
    //   50: invokevirtual 176	com/tencent/oskplayer/cache/SimpleCache:removeSpan	(Lcom/tencent/oskplayer/cache/CacheSpan;)V
    //   53: goto -22 -> 31
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	SimpleCache
    //   0	61	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	20	56	finally
    //   24	31	56	finally
    //   31	53	56	finally
  }
  
  public void removeListener(String paramString, Cache.Listener paramListener)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.listeners.get(paramString);
      if (localArrayList != null)
      {
        localArrayList.remove(paramListener);
        if (localArrayList.isEmpty()) {
          this.listeners.remove(paramString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void removeSpan(CacheSpan paramCacheSpan)
  {
    try
    {
      TreeSet localTreeSet = (TreeSet)this.cachedSpans.get(paramCacheSpan.key);
      this.totalSpace -= paramCacheSpan.length;
      paramCacheSpan.file.delete();
      if ((localTreeSet == null) || (localTreeSet.isEmpty())) {
        this.cachedSpans.remove(paramCacheSpan.key);
      }
      notifySpanRemoved(paramCacheSpan);
      return;
    }
    finally {}
  }
  
  public File startFile(String paramString, long paramLong1, long paramLong2, FileType paramFileType, long paramLong3)
  {
    try
    {
      Assertions.checkState(this.lockedSpans.containsKey(paramString));
      if (!this.cacheDir.exists())
      {
        removeStaleSpans();
        this.cacheDir.mkdirs();
      }
      this.evictor.onStartFile(this, paramString, paramLong1, paramLong3);
      paramString = CacheSpan.getCacheFileName(this.cacheDir, paramString, paramLong1, paramLong2, paramFileType, System.currentTimeMillis());
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public CacheSpan startReadWrite(String paramString, long paramLong)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: lload_2
    //   4: invokestatic 325	com/tencent/oskplayer/cache/CacheSpan:createLookup	(Ljava/lang/String;J)Lcom/tencent/oskplayer/cache/CacheSpan;
    //   7: astore_1
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 374	com/tencent/oskplayer/cache/SimpleCache:startReadWriteNonBlocking	(Lcom/tencent/oskplayer/cache/CacheSpan;)Lcom/tencent/oskplayer/cache/CacheSpan;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +8 -> 25
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 377	java/lang/Object:wait	()V
    //   29: goto -21 -> 8
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	SimpleCache
    //   0	37	1	paramString	String
    //   0	37	2	paramLong	long
    //   13	10	4	localCacheSpan	CacheSpan
    // Exception table:
    //   from	to	target	type
    //   2	8	32	finally
    //   8	15	32	finally
    //   25	29	32	finally
  }
  
  public CacheSpan startReadWriteNonBlocking(String paramString, long paramLong)
  {
    try
    {
      paramString = startReadWriteNonBlocking(CacheSpan.createLookup(paramString, paramLong));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.SimpleCache
 * JD-Core Version:    0.7.0.1
 */