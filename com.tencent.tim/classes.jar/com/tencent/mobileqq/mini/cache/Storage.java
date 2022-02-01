package com.tencent.mobileqq.mini.cache;

import android.content.Context;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class Storage
{
  public static final int CACHE_VERSION = 1;
  private static final String TAG = "RequestHandler";
  public static final Object lock = new Object();
  private static final ConcurrentHashMap<String, Storage> mMapList = new ConcurrentHashMap();
  private String mApkname;
  private WeakReference<Context> mContextRef;
  private DiskLruCache mDiskCache;
  private LruCache<String, String> mLruCache;
  private String mUin;
  
  private Storage(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = getCacheDir(paramContext.getCacheDir().getAbsolutePath(), paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        this.mContextRef = new WeakReference(paramContext);
        this.mUin = paramString1;
        this.mApkname = paramString2;
        this.mDiskCache = DiskLruCache.open(new File(str), 1, 1, 10485760L);
        this.mLruCache = new Storage.1(this, 10485760);
        return;
      }
      QLog.e("RequestHandler", 1, "[Storage] can not create dir");
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("RequestHandler", 1, paramContext, new Object[0]);
    }
  }
  
  public static void destroy()
  {
    synchronized (mMapList)
    {
      Iterator localIterator = mMapList.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (Storage)mMapList.get(localObject2);
        if (localObject2 != null)
        {
          QLog.e("StoragePlugin", 1, "------destroy mDiskCache.closed-----");
          ((Storage)localObject2).close();
        }
      }
    }
    mMapList.clear();
  }
  
  public static String getCacheDir(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString1 + "/mini";
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append("/");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "default";
      }
      paramString1 = paramString1;
      paramString1 = paramString1 + "/" + paramString3;
      paramString2 = new File(paramString1);
      if ((paramString2.exists()) || (paramString2.mkdirs())) {}
    }
    else
    {
      return null;
    }
    QLog.i("StoragePlugin", 1, "[Storage] getCacheDir: " + paramString1);
    return paramString1;
  }
  
  public static long getCurrentStorageSize(String paramString)
  {
    try
    {
      paramString = getToken(String.valueOf(BaseApplicationImpl.getApplication().waitAppRuntime(null).getLongAccountUin()), paramString);
      paramString = (Storage)mMapList.get(paramString);
      if (paramString == null) {
        return -1L;
      }
      long l = paramString.getCurrentSizeBytes();
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("RequestHandler", 2, "getCurrentStorageSize failed:", paramString);
    }
    return -1L;
  }
  
  private static String getToken(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  /* Error */
  public static Storage open(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: astore 5
    //   7: aload 5
    //   9: monitorenter
    //   10: aload_0
    //   11: ifnull +87 -> 98
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 212	com/tencent/mobileqq/mini/cache/Storage:getToken	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 6
    //   21: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload 6
    //   26: invokevirtual 147	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 2	com/tencent/mobileqq/mini/cache/Storage
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: ifnonnull +59 -> 98
    //   42: getstatic 41	com/tencent/mobileqq/mini/cache/Storage:lock	Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 7
    //   49: monitorenter
    //   50: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: aload_1
    //   54: aload_2
    //   55: invokestatic 212	com/tencent/mobileqq/mini/cache/Storage:getToken	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 147	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 2	com/tencent/mobileqq/mini/cache/Storage
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: ifnonnull +24 -> 95
    //   74: new 2	com/tencent/mobileqq/mini/cache/Storage
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: aload_2
    //   81: invokespecial 227	com/tencent/mobileqq/mini/cache/Storage:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore_3
    //   85: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload 6
    //   90: aload_3
    //   91: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 5
    //   100: monitorexit
    //   101: aload_3
    //   102: areturn
    //   103: astore_0
    //   104: aload 7
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 5
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   1	101	3	localObject1	Object
    //   32	38	4	localStorage	Storage
    //   5	106	5	localConcurrentHashMap	ConcurrentHashMap
    //   19	70	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	66	103	finally
    //   74	95	103	finally
    //   95	98	103	finally
    //   104	107	103	finally
    //   14	34	109	finally
    //   42	50	109	finally
    //   98	101	109	finally
    //   107	109	109	finally
    //   110	113	109	finally
  }
  
  private void reCreateCache()
  {
    String str;
    if ((this.mContextRef != null) && (this.mContextRef.get() != null))
    {
      str = getCacheDir(((Context)this.mContextRef.get()).getCacheDir().getAbsolutePath(), this.mUin, this.mApkname);
      if (!TextUtils.isEmpty(str)) {
        this.mContextRef = new WeakReference(this.mContextRef.get());
      }
    }
    try
    {
      this.mDiskCache = DiskLruCache.open(new File(str), 1, 1, 10485760L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean clearStorage()
  {
    if (this.mLruCache != null) {
      this.mLruCache.trimToSize(0);
    }
    if (this.mDiskCache != null) {}
    try
    {
      this.mDiskCache.delete();
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  public void close()
  {
    if (this.mDiskCache != null) {}
    try
    {
      QLog.e("StoragePlugin", 1, "------mDiskCache.closed-----");
      this.mDiskCache.close();
      if (this.mLruCache != null) {
        this.mLruCache.evictAll();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public long getCurrentSize()
  {
    if (this.mDiskCache != null) {
      return (int)Math.ceil(this.mDiskCache.size() / 1000.0D);
    }
    return -1L;
  }
  
  public long getCurrentSizeBytes()
  {
    if (this.mDiskCache != null) {
      return this.mDiskCache.size();
    }
    return -1L;
  }
  
  public int getLimitSize()
  {
    if (this.mDiskCache != null) {
      return (int)Math.ceil(this.mDiskCache.getMaxSize() / 1000L);
    }
    return -1;
  }
  
  public Set<String> keys()
  {
    if ((this.mDiskCache != null) && (!this.mDiskCache.isClosed())) {
      return this.mDiskCache.getKeys();
    }
    return null;
  }
  
  /* Error */
  public String[] read(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   4: ifnull +238 -> 242
    //   7: aload_0
    //   8: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   11: aload_1
    //   12: invokevirtual 280	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 143	java/lang/String
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +113 -> 141
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   38: ifnull +103 -> 141
    //   41: aload_0
    //   42: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   45: invokevirtual 272	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   48: ifeq +7 -> 55
    //   51: aload_0
    //   52: invokespecial 116	com/tencent/mobileqq/mini/cache/Storage:reCreateCache	()V
    //   55: aload_0
    //   56: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   59: aload_1
    //   60: invokevirtual 283	com/tencent/mobileqq/mini/cache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot;
    //   63: astore_2
    //   64: aload 4
    //   66: astore 5
    //   68: aload_2
    //   69: ifnull +58 -> 127
    //   72: aload_2
    //   73: astore_3
    //   74: aload_2
    //   75: iconst_0
    //   76: invokevirtual 289	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   79: astore 5
    //   81: aload_2
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   87: aload_1
    //   88: aload 5
    //   90: invokevirtual 290	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_2
    //   95: astore_3
    //   96: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   108: ldc 93
    //   110: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   116: invokeinterface 292 1 0
    //   121: idiv
    //   122: invokevirtual 240	android/support/v4/util/LruCache:trimToSize	(I)V
    //   125: aload_1
    //   126: monitorexit
    //   127: aload 5
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +10 -> 141
    //   134: aload_2
    //   135: invokevirtual 293	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:close	()V
    //   138: aload 5
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +97 -> 242
    //   148: aload_3
    //   149: invokestatic 298	com/tencent/mobileqq/mini/cache/Util:decode	(Ljava/lang/String;)[Ljava/lang/String;
    //   152: areturn
    //   153: astore 4
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: athrow
    //   162: astore_1
    //   163: aload 5
    //   165: astore 4
    //   167: aload_2
    //   168: astore_3
    //   169: ldc 14
    //   171: iconst_1
    //   172: aload_1
    //   173: iconst_0
    //   174: anewarray 4	java/lang/Object
    //   177: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   180: aload 4
    //   182: astore_3
    //   183: aload_2
    //   184: ifnull -43 -> 141
    //   187: aload_2
    //   188: invokevirtual 293	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:close	()V
    //   191: aload 4
    //   193: astore_3
    //   194: goto -53 -> 141
    //   197: astore_1
    //   198: aload 4
    //   200: astore_3
    //   201: goto -60 -> 141
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_3
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 293	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:close	()V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: aload 5
    //   220: astore_3
    //   221: goto -80 -> 141
    //   224: astore_2
    //   225: goto -10 -> 215
    //   228: astore_1
    //   229: goto -22 -> 207
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_2
    //   235: goto -68 -> 167
    //   238: astore_1
    //   239: goto -72 -> 167
    //   242: aconst_null
    //   243: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	Storage
    //   0	244	1	paramString	String
    //   63	125	2	localSnapshot	DiskLruCache.Snapshot
    //   224	1	2	localThrowable	Throwable
    //   234	1	2	localObject1	Object
    //   22	199	3	localObject2	Object
    //   18	47	4	str1	String
    //   153	7	4	localObject3	Object
    //   165	34	4	localObject4	Object
    //   66	153	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   104	127	153	finally
    //   155	157	153	finally
    //   83	94	162	java/lang/Throwable
    //   96	100	162	java/lang/Throwable
    //   102	104	162	java/lang/Throwable
    //   159	162	162	java/lang/Throwable
    //   187	191	197	java/lang/Throwable
    //   41	55	204	finally
    //   55	64	204	finally
    //   134	138	217	java/lang/Throwable
    //   211	215	224	java/lang/Throwable
    //   74	81	228	finally
    //   83	94	228	finally
    //   96	100	228	finally
    //   102	104	228	finally
    //   159	162	228	finally
    //   169	180	228	finally
    //   41	55	232	java/lang/Throwable
    //   55	64	232	java/lang/Throwable
    //   74	81	238	java/lang/Throwable
  }
  
  public boolean removeStorage(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mLruCache != null) {
        this.mLruCache.remove(paramString);
      }
      if (this.mDiskCache != null) {
        if (this.mDiskCache.isClosed()) {
          reCreateCache();
        }
      }
    }
    try
    {
      this.mDiskCache.remove(paramString);
      bool = true;
      return bool;
    }
    catch (Throwable paramString)
    {
      QLog.e("RequestHandler", 1, paramString, new Object[0]);
    }
    return false;
  }
  
  public void write(String paramString1, String paramString2, String paramString3, StorageCallback paramStorageCallback)
  {
    ThreadManagerV2.executeOnSubThread(new Storage.2(this, paramString2, paramString3, paramStorageCallback, paramString1));
  }
  
  /* Error */
  public boolean writeSync(String arg1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 328	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: invokevirtual 331	java/lang/Thread:getName	()Ljava/lang/String;
    //   6: invokestatic 337	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 340	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: invokevirtual 331	java/lang/Thread:getName	()Ljava/lang/String;
    //   15: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +14 -> 32
    //   21: new 346	java/lang/IllegalStateException
    //   24: dup
    //   25: ldc_w 348
    //   28: invokespecial 349	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_3
    //   33: aload_2
    //   34: invokestatic 352	com/tencent/mobileqq/mini/cache/Util:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +37 -> 76
    //   42: aload_2
    //   43: invokevirtual 355	java/lang/String:length	()I
    //   46: ldc_w 356
    //   49: if_icmplt +27 -> 76
    //   52: ldc 14
    //   54: iconst_1
    //   55: ldc_w 358
    //   58: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_1
    //   64: ldc 14
    //   66: iconst_1
    //   67: ldc_w 360
    //   70: aload_1
    //   71: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_0
    //   77: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   80: ifnull +160 -> 240
    //   83: aload_0
    //   84: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   87: invokevirtual 272	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   90: ifeq +7 -> 97
    //   93: aload_0
    //   94: invokespecial 116	com/tencent/mobileqq/mini/cache/Storage:reCreateCache	()V
    //   97: aload_2
    //   98: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +125 -> 226
    //   104: aload_0
    //   105: invokevirtual 362	com/tencent/mobileqq/mini/cache/Storage:getCurrentSize	()J
    //   108: ldc2_w 267
    //   111: lmul
    //   112: aload_2
    //   113: invokevirtual 355	java/lang/String:length	()I
    //   116: i2l
    //   117: ladd
    //   118: ldc2_w 81
    //   121: lcmp
    //   122: ifle +35 -> 157
    //   125: ldc 14
    //   127: iconst_1
    //   128: ldc_w 358
    //   131: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_0
    //   135: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   138: ifnull -77 -> 61
    //   141: aload_0
    //   142: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   145: invokevirtual 365	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 368	java/io/IOException:printStackTrace	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: aload_0
    //   158: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   161: aload_1
    //   162: invokevirtual 372	com/tencent/mobileqq/mini/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Editor;
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull +13 -> 180
    //   170: aload_3
    //   171: iconst_0
    //   172: aload_2
    //   173: invokevirtual 378	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   176: aload_3
    //   177: invokevirtual 381	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:commit	()V
    //   180: aload_0
    //   181: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   184: ifnull +42 -> 226
    //   187: aload_0
    //   188: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual 290	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   200: astore_1
    //   201: aload_1
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 98	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   207: ldc 93
    //   209: getstatic 38	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   212: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   215: invokeinterface 292 1 0
    //   220: idiv
    //   221: invokevirtual 240	android/support/v4/util/LruCache:trimToSize	(I)V
    //   224: aload_1
    //   225: monitorexit
    //   226: aload_0
    //   227: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   230: ifnull +10 -> 240
    //   233: aload_0
    //   234: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   237: invokevirtual 365	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   240: iconst_1
    //   241: ireturn
    //   242: astore_2
    //   243: aload_1
    //   244: monitorexit
    //   245: aload_2
    //   246: athrow
    //   247: astore_1
    //   248: ldc 14
    //   250: iconst_1
    //   251: aload_1
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   263: ifnull -202 -> 61
    //   266: aload_0
    //   267: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   270: invokevirtual 365	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 368	java/io/IOException:printStackTrace	()V
    //   280: iconst_0
    //   281: ireturn
    //   282: astore_1
    //   283: aload_1
    //   284: invokevirtual 368	java/io/IOException:printStackTrace	()V
    //   287: goto -47 -> 240
    //   290: astore_1
    //   291: aload_0
    //   292: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   295: ifnull +10 -> 305
    //   298: aload_0
    //   299: getfield 90	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   302: invokevirtual 365	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_2
    //   308: aload_2
    //   309: invokevirtual 368	java/io/IOException:printStackTrace	()V
    //   312: goto -7 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	Storage
    //   0	315	2	paramString2	String
    //   0	315	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   32	38	63	java/lang/Throwable
    //   141	148	150	java/io/IOException
    //   203	226	242	finally
    //   243	245	242	finally
    //   97	134	247	java/lang/Throwable
    //   157	166	247	java/lang/Throwable
    //   170	180	247	java/lang/Throwable
    //   180	203	247	java/lang/Throwable
    //   245	247	247	java/lang/Throwable
    //   266	273	275	java/io/IOException
    //   233	240	282	java/io/IOException
    //   97	134	290	finally
    //   157	166	290	finally
    //   170	180	290	finally
    //   180	203	290	finally
    //   245	247	290	finally
    //   248	259	290	finally
    //   298	305	307	java/io/IOException
  }
  
  public static abstract interface StorageCallback
  {
    public abstract void onFailed(String paramString1, String paramString2);
    
    public abstract void onSuccess(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Storage
 * JD-Core Version:    0.7.0.1
 */