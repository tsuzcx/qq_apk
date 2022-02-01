package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.Util;
import com.tencent.stat.event.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class af
{
  private static StatLogger h = ;
  private static Context i = null;
  private static int j = 307200;
  private static af k = null;
  volatile int a = 0;
  DeviceInfo b = null;
  private an c = null;
  private an d = null;
  private Handler e = null;
  private String f = "";
  private String g = "";
  private int l = 0;
  private ConcurrentHashMap<d, String> m = null;
  private boolean n = false;
  private HashMap<String, String> o = new HashMap();
  
  private af(Context paramContext)
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatStore");
      localHandlerThread.start();
      this.e = new Handler(localHandlerThread.getLooper());
      i = paramContext.getApplicationContext();
      this.m = new ConcurrentHashMap();
      this.f = StatCommonHelper.getDatabaseName(paramContext);
      this.g = ("pri_" + StatCommonHelper.getDatabaseName(paramContext));
      this.c = new an(i, this.f);
      this.d = new an(i, this.g);
      f();
      b(true);
      b(false);
      g();
      b(i);
      d();
      k();
      return;
    }
    catch (Throwable paramContext)
    {
      h.e(paramContext);
    }
  }
  
  public static af a(Context paramContext)
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new af(paramContext);
      }
      return k;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    return "tencent_mta_sp_" + paramString;
  }
  
  private String a(List<ao> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 3);
    localStringBuilder.append("event_id in (");
    int i2 = paramList.size();
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      localStringBuilder.append(((ao)paramList.next()).a);
      if (i1 != i2 - 1) {
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.a > 0) && (paramInt > 0))
        {
          boolean bool = StatServiceImpl.a();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ArrayList localArrayList;
        h.e(localThrowable);
        continue;
      }
      finally {}
      return;
      if (StatConfig.isDebugEnable()) {
        h.i("Load " + this.a + " unsent events");
      }
      localArrayList = new ArrayList(paramInt);
      b(localArrayList, paramInt, paramBoolean);
      if (localArrayList.size() > 0)
      {
        if (StatConfig.isDebugEnable()) {
          h.i("Peek " + localArrayList.size() + " unsent events.");
        }
        a(localArrayList, 2, paramBoolean);
        g.b(i).b(localArrayList, new al(this, localArrayList, paramBoolean));
      }
    }
  }
  
  private void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put(a("uid"), paramString);
    localHashMap.put(a("user_type"), Integer.valueOf(paramInt));
    localHashMap.put(a("app_ver"), StatCommonHelper.getAppVersion(paramContext));
    localHashMap.put(a("ts"), Long.valueOf(paramLong));
    StatPreferences.putObjectList(paramContext, localHashMap);
  }
  
  private void a(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      long l2;
      try
      {
        localSQLiteDatabase = d(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        if (!paramBoolean)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (this.a > StatConfig.getMaxStoreEventCount())
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            h.warn("Too many events stored in db.");
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
          }
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        String str = paramd.g();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          h.i("insert 1 event, content:" + str);
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        str = Util.encode(str);
        if (str == null) {
          break label538;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (str.length() >= j) {
          break label538;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", str);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(paramd.c()));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = localSQLiteDatabase.insert("events", null, localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        l2 = l1;
        if (localSQLiteDatabase == null) {
          break label531;
        }
      }
      catch (Throwable localThrowable3)
      {
        SQLiteDatabase localSQLiteDatabase;
        l2 = -1L;
        localObject2 = localThrowable1;
        h.e(localThrowable3);
        if (localThrowable1 == null) {
          break label531;
        }
        try
        {
          localThrowable1.endTransaction();
          l1 = -1L;
        }
        catch (Throwable localThrowable2)
        {
          h.e(localThrowable2);
          l1 = -1L;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          localObject2.endTransaction();
          throw paramd;
        }
        catch (Throwable paramStatDispatchCallback)
        {
          h.e(paramStatDispatchCallback);
          continue;
        }
        h.error("Failed to store event:" + paramd.g());
        return;
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        if (l1 > 0L)
        {
          this.a += 1;
          if (StatConfig.isDebugEnable()) {
            h.d("directStoreEvent insert event to db, event:" + paramd.g());
          }
          if (paramStatDispatchCallback != null) {
            paramStatDispatchCallback.onDispatchSuccess();
          }
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        h.e(localThrowable1);
        continue;
      }
      label531:
      long l1 = l2;
      continue;
      label538:
      l1 = 0L;
    }
  }
  
  /* Error */
  private void a(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 165 1 0
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iload_3
    //   26: invokespecial 398	com/tencent/stat/af:c	(Z)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_3
    //   33: invokespecial 303	com/tencent/stat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: iload_2
    //   39: iconst_2
    //   40: if_icmpne +201 -> 241
    //   43: aload 6
    //   45: astore 5
    //   47: new 117	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 400
    //   57: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_2
    //   61: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 402
    //   67: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: aload_1
    //   72: invokespecial 404	com/tencent/stat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   75: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 8
    //   83: aload 7
    //   85: astore_1
    //   86: aload 8
    //   88: astore 7
    //   90: aload 6
    //   92: astore 5
    //   94: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   97: ifeq +34 -> 131
    //   100: aload 6
    //   102: astore 5
    //   104: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   107: new 117	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 406
    //   117: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 7
    //   122: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   131: aload 6
    //   133: astore 5
    //   135: aload 6
    //   137: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   140: aload 6
    //   142: astore 5
    //   144: aload 6
    //   146: aload 7
    //   148: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: ifnull +51 -> 203
    //   155: aload 6
    //   157: astore 5
    //   159: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   162: new 117	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 411
    //   172: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_1
    //   176: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   185: aload 6
    //   187: astore 5
    //   189: aload 6
    //   191: aload_1
    //   192: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   195: aload 6
    //   197: astore 5
    //   199: aload_0
    //   200: invokespecial 140	com/tencent/stat/af:g	()V
    //   203: aload 6
    //   205: astore 5
    //   207: aload 6
    //   209: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   212: aload 6
    //   214: ifnull -193 -> 21
    //   217: aload 6
    //   219: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   222: goto -201 -> 21
    //   225: astore_1
    //   226: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   229: aload_1
    //   230: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   233: goto -212 -> 21
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    //   241: aload 6
    //   243: astore 5
    //   245: new 117	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 400
    //   255: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload_2
    //   259: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 413
    //   265: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: aload_1
    //   270: invokespecial 404	com/tencent/stat/af:a	(Ljava/util/List;)Ljava/lang/String;
    //   273: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: astore 7
    //   281: aload 8
    //   283: astore_1
    //   284: aload 6
    //   286: astore 5
    //   288: aload_0
    //   289: getfield 74	com/tencent/stat/af:l	I
    //   292: iconst_3
    //   293: irem
    //   294: ifne +29 -> 323
    //   297: aload 6
    //   299: astore 5
    //   301: new 117	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 415
    //   311: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: iload 4
    //   316: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore_1
    //   323: aload 6
    //   325: astore 5
    //   327: aload_0
    //   328: aload_0
    //   329: getfield 74	com/tencent/stat/af:l	I
    //   332: iconst_1
    //   333: iadd
    //   334: putfield 74	com/tencent/stat/af:l	I
    //   337: goto -247 -> 90
    //   340: astore_1
    //   341: aload 6
    //   343: astore 5
    //   345: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   348: aload_1
    //   349: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   352: aload 6
    //   354: ifnull -333 -> 21
    //   357: aload 6
    //   359: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   362: goto -341 -> 21
    //   365: astore_1
    //   366: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   369: aload_1
    //   370: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   373: goto -352 -> 21
    //   376: astore_1
    //   377: aconst_null
    //   378: astore 5
    //   380: aload 5
    //   382: ifnull +8 -> 390
    //   385: aload 5
    //   387: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   390: aload_1
    //   391: athrow
    //   392: astore 5
    //   394: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   397: aload 5
    //   399: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   402: goto -12 -> 390
    //   405: astore_1
    //   406: goto -26 -> 380
    //   409: astore_1
    //   410: aconst_null
    //   411: astore 6
    //   413: goto -72 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	af
    //   0	416	1	paramList	List<ao>
    //   0	416	2	paramInt	int
    //   0	416	3	paramBoolean	boolean
    //   14	301	4	i1	int
    //   45	341	5	localSQLiteDatabase1	SQLiteDatabase
    //   392	6	5	localThrowable	Throwable
    //   36	376	6	localSQLiteDatabase2	SQLiteDatabase
    //   4	276	7	str1	String
    //   1	281	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   217	222	225	java/lang/Throwable
    //   8	16	236	finally
    //   24	31	236	finally
    //   217	222	236	finally
    //   226	233	236	finally
    //   357	362	236	finally
    //   366	373	236	finally
    //   385	390	236	finally
    //   390	392	236	finally
    //   394	402	236	finally
    //   47	83	340	java/lang/Throwable
    //   94	100	340	java/lang/Throwable
    //   104	131	340	java/lang/Throwable
    //   135	140	340	java/lang/Throwable
    //   144	151	340	java/lang/Throwable
    //   159	185	340	java/lang/Throwable
    //   189	195	340	java/lang/Throwable
    //   199	203	340	java/lang/Throwable
    //   207	212	340	java/lang/Throwable
    //   245	281	340	java/lang/Throwable
    //   288	297	340	java/lang/Throwable
    //   301	323	340	java/lang/Throwable
    //   327	337	340	java/lang/Throwable
    //   357	362	365	java/lang/Throwable
    //   31	38	376	finally
    //   385	390	392	java/lang/Throwable
    //   47	83	405	finally
    //   94	100	405	finally
    //   104	131	405	finally
    //   135	140	405	finally
    //   144	151	405	finally
    //   159	185	405	finally
    //   189	195	405	finally
    //   199	203	405	finally
    //   207	212	405	finally
    //   245	281	405	finally
    //   288	297	405	finally
    //   301	323	405	finally
    //   327	337	405	finally
    //   345	352	405	finally
    //   31	38	409	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<ao> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 165 1 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   25: ifeq +44 -> 69
    //   28: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   31: new 117	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 418
    //   41: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokeinterface 165 1 0
    //   50: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc_w 420
    //   56: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_2
    //   60: invokevirtual 423	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   69: new 117	java/lang/StringBuilder
    //   72: dup
    //   73: aload_1
    //   74: invokeinterface 165 1 0
    //   79: iconst_3
    //   80: imul
    //   81: invokespecial 168	java/lang/StringBuilder:<init>	(I)V
    //   84: astore 7
    //   86: aload 7
    //   88: ldc 170
    //   90: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: invokeinterface 165 1 0
    //   100: istore 4
    //   102: aload_1
    //   103: invokeinterface 174 1 0
    //   108: astore_1
    //   109: iconst_0
    //   110: istore_3
    //   111: aload_1
    //   112: invokeinterface 180 1 0
    //   117: ifeq +40 -> 157
    //   120: aload 7
    //   122: aload_1
    //   123: invokeinterface 184 1 0
    //   128: checkcast 186	com/tencent/stat/ao
    //   131: getfield 189	com/tencent/stat/ao:a	J
    //   134: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: iload_3
    //   139: iload 4
    //   141: iconst_1
    //   142: isub
    //   143: if_icmpeq +267 -> 410
    //   146: aload 7
    //   148: ldc 194
    //   150: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: goto +256 -> 410
    //   157: aload 7
    //   159: ldc 196
    //   161: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: astore_1
    //   168: aload_0
    //   169: iload_2
    //   170: invokespecial 303	com/tencent/stat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   173: astore 6
    //   175: aload 6
    //   177: astore_1
    //   178: aload 6
    //   180: astore 5
    //   182: aload 6
    //   184: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   187: aload 6
    //   189: astore_1
    //   190: aload 6
    //   192: astore 5
    //   194: aload 6
    //   196: ldc_w 322
    //   199: aload 7
    //   201: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: aconst_null
    //   205: invokevirtual 328	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   208: istore_3
    //   209: aload 6
    //   211: astore_1
    //   212: aload 6
    //   214: astore 5
    //   216: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   219: ifeq +61 -> 280
    //   222: aload 6
    //   224: astore_1
    //   225: aload 6
    //   227: astore 5
    //   229: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   232: new 117	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 425
    //   242: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload 4
    //   247: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 427
    //   253: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 7
    //   258: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 429
    //   267: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload_3
    //   271: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   280: aload 6
    //   282: astore_1
    //   283: aload 6
    //   285: astore 5
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 70	com/tencent/stat/af:a	I
    //   292: iload_3
    //   293: isub
    //   294: putfield 70	com/tencent/stat/af:a	I
    //   297: aload 6
    //   299: astore_1
    //   300: aload 6
    //   302: astore 5
    //   304: aload 6
    //   306: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   309: aload 6
    //   311: astore_1
    //   312: aload 6
    //   314: astore 5
    //   316: aload_0
    //   317: invokespecial 140	com/tencent/stat/af:g	()V
    //   320: aload 6
    //   322: ifnull -303 -> 19
    //   325: aload 6
    //   327: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   330: goto -311 -> 19
    //   333: astore_1
    //   334: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   337: aload_1
    //   338: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   341: goto -322 -> 19
    //   344: astore_1
    //   345: aload_0
    //   346: monitorexit
    //   347: aload_1
    //   348: athrow
    //   349: astore 6
    //   351: aload_1
    //   352: astore 5
    //   354: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   357: aload 6
    //   359: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   362: aload_1
    //   363: ifnull -344 -> 19
    //   366: aload_1
    //   367: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   370: goto -351 -> 19
    //   373: astore_1
    //   374: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   377: aload_1
    //   378: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   381: goto -362 -> 19
    //   384: astore_1
    //   385: aload 5
    //   387: ifnull +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   395: aload_1
    //   396: athrow
    //   397: astore 5
    //   399: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   402: aload 5
    //   404: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   407: goto -12 -> 395
    //   410: iload_3
    //   411: iconst_1
    //   412: iadd
    //   413: istore_3
    //   414: goto -303 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	af
    //   0	417	1	paramList	List<ao>
    //   0	417	2	paramBoolean	boolean
    //   14	400	3	i1	int
    //   100	146	4	i2	int
    //   1	390	5	localObject	Object
    //   397	6	5	localThrowable1	Throwable
    //   4	322	6	localSQLiteDatabase	SQLiteDatabase
    //   349	9	6	localThrowable2	Throwable
    //   84	173	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   325	330	333	java/lang/Throwable
    //   8	15	344	finally
    //   22	69	344	finally
    //   69	109	344	finally
    //   111	138	344	finally
    //   146	154	344	finally
    //   157	165	344	finally
    //   325	330	344	finally
    //   334	341	344	finally
    //   366	370	344	finally
    //   374	381	344	finally
    //   390	395	344	finally
    //   395	397	344	finally
    //   399	407	344	finally
    //   168	175	349	java/lang/Throwable
    //   182	187	349	java/lang/Throwable
    //   194	209	349	java/lang/Throwable
    //   216	222	349	java/lang/Throwable
    //   229	280	349	java/lang/Throwable
    //   287	297	349	java/lang/Throwable
    //   304	309	349	java/lang/Throwable
    //   316	320	349	java/lang/Throwable
    //   366	370	373	java/lang/Throwable
    //   168	175	384	finally
    //   182	187	384	finally
    //   194	209	384	finally
    //   216	222	384	finally
    //   229	280	384	finally
    //   287	297	384	finally
    //   304	309	384	finally
    //   316	320	384	finally
    //   354	362	384	finally
    //   390	395	397	java/lang/Throwable
  }
  
  private boolean a(boolean paramBoolean)
  {
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        SQLiteDatabase localSQLiteDatabase = d(paramBoolean);
        localSQLiteDatabase.beginTransaction();
        Object localObject = new ContentValues();
        ((ContentValues)localObject).put("content", "test");
        ((ContentValues)localObject).put("send_count", "100");
        ((ContentValues)localObject).put("status", Integer.toString(1));
        ((ContentValues)localObject).put("timestamp", Long.valueOf(System.currentTimeMillis()));
        localSQLiteDatabase.insert("events", null, (ContentValues)localObject);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        i1 = localSQLiteDatabase.delete("events", "content = ?", new String[] { "test" });
        localObject = localSQLiteDatabase.query("events", null, "content=?", new String[] { "test" }, null, null, null, "1");
        i2 = ((Cursor)localObject).getCount();
        ((Cursor)localObject).close();
        if (!StatConfig.isDebugEnable()) {
          break label303;
        }
        h.i("delNum=" + i1 + ",queryNum=" + i2);
      }
      catch (SQLiteFullException localSQLiteFullException)
      {
        h.warn("db is full, change to INSTANT");
        StatConfig.setReportEventsByOrder(false);
        StatConfig.setStatSendStrategy(StatReportStrategy.INSTANT);
        return true;
        if (!StatConfig.isDebugEnable()) {
          continue;
        }
        String[] arrayOfString = localSQLiteFullException.getPath().split("/");
        h.i("test db passed, db name:" + arrayOfString[(arrayOfString.length - 1)]);
        return true;
      }
      catch (Throwable localThrowable)
      {
        h.e(localThrowable);
        return false;
      }
      throw new SQLException("test delete error.");
      label303:
      if (i1 != 0) {
        if (i2 <= 0) {}
      }
    }
  }
  
  public static af b()
  {
    return k;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (!paramBoolean) {
        paramInt = h();
      }
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        int i2 = StatConfig.getSendPeriodMinutes() * 60 * StatConfig.getNumEventsCommitPerSec();
        int i1 = paramInt;
        if (paramInt > i2)
        {
          i1 = paramInt;
          if (i2 > 0) {
            i1 = i2;
          }
        }
        int i3 = StatConfig.a();
        int i4 = i1 / i3;
        int i5 = i1 % i3;
        if (StatConfig.isDebugEnable()) {
          h.i("sentStoreEventsByDb sendNumbers=" + i1 + ",important=" + paramBoolean + ",maxSendNumPerFor1Period=" + i2 + ",maxCount=" + i4 + ",restNumbers=" + i5);
        }
        paramInt = 0;
        for (;;)
        {
          if (paramInt < i4)
          {
            a(i3, paramBoolean);
            paramInt += 1;
            continue;
            paramInt = i();
            break;
          }
        }
        if (i5 > 0) {
          a(i5, paramBoolean);
        }
      }
      return;
    }
  }
  
  /* Error */
  private void b(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 524	com/tencent/stat/e:a	()Ljava/lang/String;
    //   6: astore 7
    //   8: aload 7
    //   10: invokestatic 527	com/tencent/stat/common/StatCommonHelper:md5sum	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 5
    //   15: new 330	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 331	android/content/ContentValues:<init>	()V
    //   22: astore 8
    //   24: aload 8
    //   26: ldc_w 349
    //   29: aload_1
    //   30: getfield 530	com/tencent/stat/e:b	Lorg/json/JSONObject;
    //   33: invokevirtual 533	org/json/JSONObject:toString	()Ljava/lang/String;
    //   36: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 8
    //   41: ldc_w 534
    //   44: aload 5
    //   46: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: aload 5
    //   52: putfield 536	com/tencent/stat/e:c	Ljava/lang/String;
    //   55: aload 8
    //   57: ldc_w 538
    //   60: aload_1
    //   61: getfield 540	com/tencent/stat/e:d	I
    //   64: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   70: aload_0
    //   71: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   74: invokevirtual 546	com/tencent/stat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: ldc_w 548
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: invokeinterface 554 1 0
    //   102: ifeq +387 -> 489
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: iconst_0
    //   112: invokeinterface 558 2 0
    //   117: aload_1
    //   118: getfield 559	com/tencent/stat/e:a	I
    //   121: if_icmpne -30 -> 91
    //   124: iconst_1
    //   125: istore_2
    //   126: aload 6
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   134: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   137: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   140: iconst_1
    //   141: iload_2
    //   142: if_icmpne +119 -> 261
    //   145: aload 6
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   153: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   156: ldc_w 548
    //   159: aload 8
    //   161: ldc_w 561
    //   164: iconst_1
    //   165: anewarray 344	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: getfield 559	com/tencent/stat/e:a	I
    //   174: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: aastore
    //   178: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: i2l
    //   182: lstore_3
    //   183: lload_3
    //   184: ldc2_w 389
    //   187: lcmp
    //   188: ifne +116 -> 304
    //   191: aload 6
    //   193: astore 5
    //   195: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   198: new 117	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 567
    //   208: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 7
    //   213: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokevirtual 569	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Object;)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload_0
    //   227: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   230: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   233: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   236: aload 6
    //   238: ifnull +10 -> 248
    //   241: aload 6
    //   243: invokeinterface 460 1 0
    //   248: aload_0
    //   249: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   252: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   255: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   258: aload_0
    //   259: monitorexit
    //   260: return
    //   261: aload 6
    //   263: astore 5
    //   265: aload 8
    //   267: ldc_w 571
    //   270: aload_1
    //   271: getfield 559	com/tencent/stat/e:a	I
    //   274: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   280: aload 6
    //   282: astore 5
    //   284: aload_0
    //   285: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   288: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   291: ldc_w 548
    //   294: aconst_null
    //   295: aload 8
    //   297: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   300: lstore_3
    //   301: goto -118 -> 183
    //   304: aload 6
    //   306: astore 5
    //   308: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   311: new 117	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 573
    //   321: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 7
    //   326: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 383	com/tencent/stat/common/StatLogger:d	(Ljava/lang/Object;)V
    //   335: goto -113 -> 222
    //   338: astore_1
    //   339: aload 6
    //   341: astore 5
    //   343: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   346: aload_1
    //   347: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   350: aload 6
    //   352: ifnull +10 -> 362
    //   355: aload 6
    //   357: invokeinterface 460 1 0
    //   362: aload_0
    //   363: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   366: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   369: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   372: goto -114 -> 258
    //   375: astore_1
    //   376: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   379: aload_1
    //   380: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   383: goto -125 -> 258
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: astore_1
    //   392: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   395: aload_1
    //   396: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   399: goto -151 -> 248
    //   402: astore_1
    //   403: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   406: aload_1
    //   407: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   410: goto -152 -> 258
    //   413: astore_1
    //   414: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   417: aload_1
    //   418: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   421: goto -59 -> 362
    //   424: astore_1
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 5
    //   430: ifnull +10 -> 440
    //   433: aload 5
    //   435: invokeinterface 460 1 0
    //   440: aload_0
    //   441: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   444: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   447: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   450: aload_1
    //   451: athrow
    //   452: astore 5
    //   454: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   457: aload 5
    //   459: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   462: goto -22 -> 440
    //   465: astore 5
    //   467: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   470: aload 5
    //   472: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   475: goto -25 -> 450
    //   478: astore_1
    //   479: goto -51 -> 428
    //   482: astore_1
    //   483: aconst_null
    //   484: astore 6
    //   486: goto -147 -> 339
    //   489: iconst_0
    //   490: istore_2
    //   491: goto -365 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	af
    //   0	494	1	parame	e
    //   125	366	2	i1	int
    //   182	119	3	l1	long
    //   13	421	5	localObject	Object
    //   452	6	5	localThrowable1	Throwable
    //   465	6	5	localThrowable2	Throwable
    //   89	396	6	localCursor	Cursor
    //   6	319	7	str	String
    //   22	274	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   95	105	338	java/lang/Throwable
    //   109	124	338	java/lang/Throwable
    //   130	140	338	java/lang/Throwable
    //   149	183	338	java/lang/Throwable
    //   195	222	338	java/lang/Throwable
    //   226	236	338	java/lang/Throwable
    //   265	280	338	java/lang/Throwable
    //   284	301	338	java/lang/Throwable
    //   308	335	338	java/lang/Throwable
    //   362	372	375	java/lang/Throwable
    //   241	248	386	finally
    //   248	258	386	finally
    //   355	362	386	finally
    //   362	372	386	finally
    //   376	383	386	finally
    //   392	399	386	finally
    //   403	410	386	finally
    //   414	421	386	finally
    //   433	440	386	finally
    //   440	450	386	finally
    //   450	452	386	finally
    //   454	462	386	finally
    //   467	475	386	finally
    //   241	248	391	java/lang/Throwable
    //   248	258	402	java/lang/Throwable
    //   355	362	413	java/lang/Throwable
    //   2	91	424	finally
    //   433	440	452	java/lang/Throwable
    //   440	450	465	java/lang/Throwable
    //   95	105	478	finally
    //   109	124	478	finally
    //   130	140	478	finally
    //   149	183	478	finally
    //   195	222	478	finally
    //   226	236	478	finally
    //   265	280	478	finally
    //   284	301	478	finally
    //   308	335	478	finally
    //   343	350	478	finally
    //   2	91	482	java/lang/Throwable
  }
  
  /* Error */
  private void b(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 311	com/tencent/stat/StatConfig:getMaxStoreEventCount	()I
    //   5: ifle +25 -> 30
    //   8: getstatic 575	com/tencent/stat/StatConfig:m	I
    //   11: ifle +12 -> 23
    //   14: iload_3
    //   15: ifne +8 -> 23
    //   18: iload 4
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: iload_3
    //   27: invokespecial 577	com/tencent/stat/af:a	(Lcom/tencent/stat/event/d;Lcom/tencent/stat/StatDispatchCallback;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: getstatic 575	com/tencent/stat/StatConfig:m	I
    //   36: ifle -6 -> 30
    //   39: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   42: ifeq +89 -> 131
    //   45: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   48: new 117	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 579
    //   58: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 76	com/tencent/stat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   68: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 582
    //   74: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 575	com/tencent/stat/StatConfig:m	I
    //   80: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc_w 584
    //   86: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 70	com/tencent/stat/af:a	I
    //   93: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   102: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   105: new 117	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 586
    //   115: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 335	com/tencent/stat/event/d:g	()Ljava/lang/String;
    //   122: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   131: aload_0
    //   132: getfield 76	com/tencent/stat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   135: aload_1
    //   136: ldc 64
    //   138: invokevirtual 587	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: aload_0
    //   143: getfield 76	com/tencent/stat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   146: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   149: getstatic 575	com/tencent/stat/StatConfig:m	I
    //   152: if_icmplt +7 -> 159
    //   155: aload_0
    //   156: invokespecial 284	com/tencent/stat/af:j	()V
    //   159: aload_2
    //   160: ifnull -130 -> 30
    //   163: aload_0
    //   164: getfield 76	com/tencent/stat/af:m	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: invokevirtual 580	java/util/concurrent/ConcurrentHashMap:size	()I
    //   170: ifle +7 -> 177
    //   173: aload_0
    //   174: invokespecial 284	com/tencent/stat/af:j	()V
    //   177: aload_2
    //   178: invokeinterface 388 1 0
    //   183: goto -153 -> 30
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	af
    //   0	191	1	paramd	d
    //   0	191	2	paramStatDispatchCallback	StatDispatchCallback
    //   0	191	3	paramBoolean1	boolean
    //   0	191	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	186	finally
    //   23	30	186	finally
    //   33	131	186	finally
    //   131	159	186	finally
    //   163	177	186	finally
    //   177	183	186	finally
  }
  
  /* Error */
  private void b(List<ao> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: invokespecial 589	com/tencent/stat/af:e	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   5: astore 7
    //   7: iconst_1
    //   8: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   11: astore 8
    //   13: iload_2
    //   14: invokestatic 361	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   17: astore 9
    //   19: aload 7
    //   21: ldc_w 322
    //   24: aconst_null
    //   25: ldc_w 591
    //   28: iconst_1
    //   29: anewarray 344	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload 8
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aload 9
    //   42: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 7
    //   47: aload 7
    //   49: invokeinterface 554 1 0
    //   54: ifeq +176 -> 230
    //   57: aload 7
    //   59: iconst_0
    //   60: invokeinterface 595 2 0
    //   65: lstore 5
    //   67: aload 7
    //   69: iconst_1
    //   70: invokeinterface 598 2 0
    //   75: astore 9
    //   77: aload 9
    //   79: astore 8
    //   81: getstatic 600	com/tencent/stat/StatConfig:g	Z
    //   84: ifne +10 -> 94
    //   87: aload 9
    //   89: invokestatic 603	com/tencent/stat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 8
    //   94: aload 7
    //   96: iconst_2
    //   97: invokeinterface 558 2 0
    //   102: istore_2
    //   103: aload 7
    //   105: iconst_3
    //   106: invokeinterface 558 2 0
    //   111: istore 4
    //   113: new 186	com/tencent/stat/ao
    //   116: dup
    //   117: lload 5
    //   119: aload 8
    //   121: iload_2
    //   122: iload 4
    //   124: invokespecial 606	com/tencent/stat/ao:<init>	(JLjava/lang/String;II)V
    //   127: astore 8
    //   129: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   132: ifeq +58 -> 190
    //   135: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   138: new 117	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 608
    //   148: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: ldc_w 610
    //   159: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 4
    //   164: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 612
    //   170: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 7
    //   175: iconst_4
    //   176: invokeinterface 595 2 0
    //   181: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   190: aload_1
    //   191: aload 8
    //   193: invokeinterface 616 2 0
    //   198: pop
    //   199: goto -152 -> 47
    //   202: astore 8
    //   204: aload 7
    //   206: astore_1
    //   207: aload 8
    //   209: astore 7
    //   211: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   214: aload 7
    //   216: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   219: aload_1
    //   220: ifnull +9 -> 229
    //   223: aload_1
    //   224: invokeinterface 460 1 0
    //   229: return
    //   230: aload 7
    //   232: ifnull -3 -> 229
    //   235: aload 7
    //   237: invokeinterface 460 1 0
    //   242: return
    //   243: astore_1
    //   244: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   247: aload_1
    //   248: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   251: return
    //   252: astore_1
    //   253: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   256: aload_1
    //   257: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   260: return
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 7
    //   265: aload 7
    //   267: ifnull +10 -> 277
    //   270: aload 7
    //   272: invokeinterface 460 1 0
    //   277: aload_1
    //   278: athrow
    //   279: astore 7
    //   281: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   284: aload 7
    //   286: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   289: goto -12 -> 277
    //   292: astore_1
    //   293: goto -28 -> 265
    //   296: astore 8
    //   298: aload_1
    //   299: astore 7
    //   301: aload 8
    //   303: astore_1
    //   304: goto -39 -> 265
    //   307: astore 7
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -100 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	af
    //   0	314	1	paramList	List<ao>
    //   0	314	2	paramInt	int
    //   0	314	3	paramBoolean	boolean
    //   111	52	4	i1	int
    //   65	87	5	l1	long
    //   5	266	7	localObject1	Object
    //   279	6	7	localThrowable1	Throwable
    //   299	1	7	localList	List<ao>
    //   307	1	7	localThrowable2	Throwable
    //   11	181	8	localObject2	Object
    //   202	6	8	localThrowable3	Throwable
    //   296	6	8	localObject3	Object
    //   17	71	9	str	String
    // Exception table:
    //   from	to	target	type
    //   47	77	202	java/lang/Throwable
    //   81	94	202	java/lang/Throwable
    //   94	190	202	java/lang/Throwable
    //   190	199	202	java/lang/Throwable
    //   235	242	243	java/lang/Throwable
    //   223	229	252	java/lang/Throwable
    //   0	47	261	finally
    //   270	277	279	java/lang/Throwable
    //   47	77	292	finally
    //   81	94	292	finally
    //   94	190	292	finally
    //   190	199	292	finally
    //   211	219	296	finally
    //   0	47	307	java/lang/Throwable
  }
  
  /* Error */
  private void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: iload_1
    //   8: invokespecial 303	com/tencent/stat/af:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 7
    //   13: aload 7
    //   15: astore 5
    //   17: aload 7
    //   19: astore 6
    //   21: aload 7
    //   23: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   26: aload 7
    //   28: astore 5
    //   30: aload 7
    //   32: astore 6
    //   34: new 330	android/content/ContentValues
    //   37: dup
    //   38: invokespecial 331	android/content/ContentValues:<init>	()V
    //   41: astore 8
    //   43: aload 7
    //   45: astore 5
    //   47: aload 7
    //   49: astore 6
    //   51: aload 8
    //   53: ldc_w 358
    //   56: iconst_1
    //   57: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   63: aload 7
    //   65: astore 5
    //   67: aload 7
    //   69: astore 6
    //   71: aload 7
    //   73: ldc_w 322
    //   76: aload 8
    //   78: ldc_w 591
    //   81: iconst_1
    //   82: anewarray 344	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: ldc2_w 619
    //   90: invokestatic 623	java/lang/Long:toString	(J)Ljava/lang/String;
    //   93: aastore
    //   94: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload 7
    //   100: astore 5
    //   102: aload 7
    //   104: astore 6
    //   106: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   109: ifeq +42 -> 151
    //   112: aload 7
    //   114: astore 5
    //   116: aload 7
    //   118: astore 6
    //   120: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   123: new 117	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 625
    //   133: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc 228
    //   142: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   151: aload 7
    //   153: astore 5
    //   155: aload 7
    //   157: astore 6
    //   159: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   162: ldc2_w 626
    //   165: ldiv
    //   166: lstore_3
    //   167: aload 7
    //   169: astore 5
    //   171: aload 7
    //   173: astore 6
    //   175: aload 7
    //   177: new 117	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 629
    //   187: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: lload_3
    //   191: ldc2_w 630
    //   194: lsub
    //   195: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: ldc_w 633
    //   201: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: getstatic 47	com/tencent/stat/af:j	I
    //   207: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 409	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   216: aload 7
    //   218: ifnull +13 -> 231
    //   221: aload 7
    //   223: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   226: aload 7
    //   228: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   231: return
    //   232: astore 5
    //   234: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   237: aload 5
    //   239: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   242: return
    //   243: astore 7
    //   245: aload 5
    //   247: astore 6
    //   249: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   252: aload 7
    //   254: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   257: aload 5
    //   259: ifnull -28 -> 231
    //   262: aload 5
    //   264: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   267: aload 5
    //   269: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   272: return
    //   273: astore 5
    //   275: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   278: aload 5
    //   280: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   283: return
    //   284: astore 5
    //   286: aload 6
    //   288: ifnull +13 -> 301
    //   291: aload 6
    //   293: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   296: aload 6
    //   298: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   301: aload 5
    //   303: athrow
    //   304: astore 6
    //   306: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   309: aload 6
    //   311: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   314: goto -13 -> 301
    //   317: astore 5
    //   319: goto -93 -> 226
    //   322: astore 6
    //   324: goto -57 -> 267
    //   327: astore 7
    //   329: goto -33 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	af
    //   0	332	1	paramBoolean	boolean
    //   97	40	2	i1	int
    //   166	25	3	l1	long
    //   4	166	5	localObject1	Object
    //   232	36	5	localThrowable1	Throwable
    //   273	6	5	localThrowable2	Throwable
    //   284	18	5	localObject2	Object
    //   317	1	5	localException1	java.lang.Exception
    //   1	296	6	localObject3	Object
    //   304	6	6	localThrowable3	Throwable
    //   322	1	6	localException2	java.lang.Exception
    //   11	216	7	localSQLiteDatabase	SQLiteDatabase
    //   243	10	7	localThrowable4	Throwable
    //   327	1	7	localException3	java.lang.Exception
    //   41	36	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   221	226	232	java/lang/Throwable
    //   226	231	232	java/lang/Throwable
    //   6	13	243	java/lang/Throwable
    //   21	26	243	java/lang/Throwable
    //   34	43	243	java/lang/Throwable
    //   51	63	243	java/lang/Throwable
    //   71	98	243	java/lang/Throwable
    //   106	112	243	java/lang/Throwable
    //   120	151	243	java/lang/Throwable
    //   159	167	243	java/lang/Throwable
    //   175	216	243	java/lang/Throwable
    //   262	267	273	java/lang/Throwable
    //   267	272	273	java/lang/Throwable
    //   6	13	284	finally
    //   21	26	284	finally
    //   34	43	284	finally
    //   51	63	284	finally
    //   71	98	284	finally
    //   106	112	284	finally
    //   120	151	284	finally
    //   159	167	284	finally
    //   175	216	284	finally
    //   249	257	284	finally
    //   291	296	304	java/lang/Throwable
    //   296	301	304	java/lang/Throwable
    //   221	226	317	java/lang/Exception
    //   262	267	322	java/lang/Exception
    //   291	296	327	java/lang/Exception
  }
  
  private int c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return StatConfig.getMaxSendRetryCount();
    }
    return StatConfig.getMaxImportantDataSendRetryCount();
  }
  
  private boolean c(Context paramContext)
  {
    return (StatPreferences.contains(paramContext, a("uid"))) || (StatPreferences.contains(paramContext, a("user_type"))) || (StatPreferences.contains(paramContext, a("app_ver"))) || (StatPreferences.contains(paramContext, a("ts")));
  }
  
  private SQLiteDatabase d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getWritableDatabase();
    }
    return this.d.getWritableDatabase();
  }
  
  private SQLiteDatabase e(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getReadableDatabase();
    }
    return this.d.getReadableDatabase();
  }
  
  private void f()
  {
    try
    {
      if (!a(false))
      {
        h.warn("delete " + an.a(this.c) + ", and create new one");
        this.c.a();
        this.c = new an(i, this.f);
      }
      if (!a(true))
      {
        h.warn("delete " + an.a(this.d) + ", and create new one");
        this.d.a();
        this.d = new an(i, this.g);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
  }
  
  private void g()
  {
    this.a = (h() + i());
  }
  
  private int h()
  {
    try
    {
      long l1 = DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
      return (int)l1;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
    return 0;
  }
  
  private int i()
  {
    try
    {
      long l1 = DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
      return (int)l1;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
    return 0;
  }
  
  private void j()
  {
    localObject5 = null;
    Object localObject1 = null;
    if (this.n) {
      return;
    }
    synchronized (this.m)
    {
      if (this.m.size() == 0) {
        return;
      }
    }
    this.n = true;
    if (StatConfig.isDebugEnable()) {
      h.i("insert " + this.m.size() + " events ,numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
      Object localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      Iterator localIterator = this.m.entrySet().iterator();
      for (;;)
      {
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        d locald = (d)((Map.Entry)localIterator.next()).getKey();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        String str = locald.g();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (StatConfig.isDebugEnable())
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          h.i("insert content:" + str);
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        str = Util.encode(str);
        if (str != null)
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          if (str.length() < j)
          {
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("content", str);
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("send_count", "0");
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("status", Integer.toString(1));
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localContentValues.put("timestamp", Long.valueOf(locald.c()));
            localObject3 = localSQLiteDatabase;
            localObject5 = localSQLiteDatabase;
            localSQLiteDatabase.insert("events", null, localContentValues);
          }
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localIterator.remove();
      }
      try
      {
        localObject5.endTransaction();
        g();
        throw localObject4;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          h.e(localThrowable3);
        }
      }
    }
    catch (Throwable localThrowable4)
    {
      localObject5 = localObject3;
      h.e(localThrowable4);
      if (localObject3 != null) {}
      try
      {
        localObject3.endTransaction();
        g();
        for (;;)
        {
          this.n = false;
          if (StatConfig.isDebugEnable()) {
            h.i("after insert, cacheEventsInMemory.size():" + this.m.size() + ",numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
          }
          return;
          localObject3 = localThrowable4;
          localObject5 = localThrowable4;
          localThrowable4.setTransactionSuccessful();
          if (localThrowable4 != null) {
            try
            {
              localThrowable4.endTransaction();
              g();
            }
            catch (Throwable localThrowable1)
            {
              h.e(localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          h.e(localThrowable2);
        }
      }
    }
    finally
    {
      if (localObject5 == null) {}
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   4: invokevirtual 546	com/tencent/stat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 683
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 554 1 0
    //   28: ifeq +51 -> 79
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 83	com/tencent/stat/af:o	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 598 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 598 2 0
    //   51: invokevirtual 684	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -35 -> 20
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   64: aload_3
    //   65: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 460 1 0
    //   78: return
    //   79: aload_2
    //   80: ifnull -2 -> 78
    //   83: aload_2
    //   84: invokeinterface 460 1 0
    //   89: return
    //   90: astore_1
    //   91: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   94: aload_1
    //   95: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   98: return
    //   99: astore_1
    //   100: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   103: aload_1
    //   104: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   107: return
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 460 1 0
    //   121: aload_2
    //   122: athrow
    //   123: astore_1
    //   124: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   127: aload_1
    //   128: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   131: goto -10 -> 121
    //   134: astore_2
    //   135: goto -24 -> 111
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: goto -82 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	af
    //   21	40	1	localCursor1	Cursor
    //   90	5	1	localThrowable1	Throwable
    //   99	5	1	localThrowable2	Throwable
    //   110	6	1	localObject1	Object
    //   123	5	1	localThrowable3	Throwable
    //   19	65	2	localCursor2	Cursor
    //   108	14	2	localObject2	Object
    //   134	1	2	localObject3	Object
    //   140	1	2	localObject4	Object
    //   58	7	3	localThrowable4	Throwable
    //   138	1	3	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	58	java/lang/Throwable
    //   33	55	58	java/lang/Throwable
    //   83	89	90	java/lang/Throwable
    //   72	78	99	java/lang/Throwable
    //   0	20	108	finally
    //   115	121	123	java/lang/Throwable
    //   22	31	134	finally
    //   33	55	134	finally
    //   61	68	134	finally
    //   0	20	138	java/lang/Throwable
  }
  
  public int a()
  {
    return this.a;
  }
  
  void a(int paramInt)
  {
    this.e.post(new am(this, paramInt));
  }
  
  void a(e parame)
  {
    if (parame == null) {
      return;
    }
    this.e.post(new ak(this, parame));
  }
  
  void a(d paramd, StatDispatchCallback paramStatDispatchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new aj(this, paramd, paramStatDispatchCallback, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new ag(this, paramList, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ao> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.post(new ah(this, paramList, paramBoolean1, paramBoolean2));
    }
  }
  
  /* Error */
  public DeviceInfo b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 717	com/tencent/stat/af:c	(Landroid/content/Context;)Z
    //   23: ifeq +425 -> 448
    //   26: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   29: ifeq +12 -> 41
    //   32: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   35: ldc_w 719
    //   38: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   41: aload_1
    //   42: aload_0
    //   43: ldc 247
    //   45: invokespecial 249	com/tencent/stat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   48: ldc 64
    //   50: invokestatic 722	com/tencent/stat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 15
    //   55: aload 15
    //   57: invokestatic 603	com/tencent/stat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 11
    //   62: aload_1
    //   63: aload_0
    //   64: ldc_w 257
    //   67: invokespecial 249	com/tencent/stat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: iconst_1
    //   71: invokestatic 725	com/tencent/stat/common/StatPreferences:getInt	(Landroid/content/Context;Ljava/lang/String;I)I
    //   74: istore 5
    //   76: aload_1
    //   77: aload_0
    //   78: ldc_w 265
    //   81: invokespecial 249	com/tencent/stat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: ldc 64
    //   86: invokestatic 722	com/tencent/stat/common/StatPreferences:getString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 10
    //   91: aload_1
    //   92: aload_0
    //   93: ldc_w 270
    //   96: invokespecial 249	com/tencent/stat/af:a	(Ljava/lang/String;)Ljava/lang/String;
    //   99: lconst_0
    //   100: invokestatic 728	com/tencent/stat/common/StatPreferences:getLong	(Landroid/content/Context;Ljava/lang/String;J)J
    //   103: lstore 6
    //   105: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   108: ldc2_w 626
    //   111: ldiv
    //   112: lstore 8
    //   114: iload 5
    //   116: iconst_1
    //   117: if_icmpeq +1246 -> 1363
    //   120: lload 6
    //   122: ldc2_w 626
    //   125: lmul
    //   126: invokestatic 731	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   129: ldc2_w 626
    //   132: lload 8
    //   134: lmul
    //   135: invokestatic 731	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   138: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifne +1222 -> 1363
    //   144: iconst_1
    //   145: istore_2
    //   146: iload_2
    //   147: istore_3
    //   148: aload 10
    //   150: aload_1
    //   151: invokestatic 268	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   154: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +7 -> 164
    //   160: iload_2
    //   161: iconst_2
    //   162: ior
    //   163: istore_3
    //   164: aload 11
    //   166: ldc 194
    //   168: invokevirtual 493	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   171: astore 13
    //   173: aload 13
    //   175: ifnull +180 -> 355
    //   178: aload 13
    //   180: arraylength
    //   181: ifle +174 -> 355
    //   184: aload 13
    //   186: iconst_0
    //   187: aaload
    //   188: astore 10
    //   190: aload 10
    //   192: ifnull +13 -> 205
    //   195: aload 10
    //   197: invokevirtual 347	java/lang/String:length	()I
    //   200: bipush 11
    //   202: if_icmpge +1144 -> 1346
    //   205: aload_1
    //   206: invokestatic 737	com/tencent/stat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   209: astore 12
    //   211: aload 12
    //   213: ifnull +1128 -> 1341
    //   216: aload 12
    //   218: invokevirtual 347	java/lang/String:length	()I
    //   221: bipush 10
    //   223: if_icmple +1118 -> 1341
    //   226: iconst_1
    //   227: istore_2
    //   228: aload 12
    //   230: astore 10
    //   232: goto +1137 -> 1369
    //   235: aload 13
    //   237: ifnull +133 -> 370
    //   240: aload 13
    //   242: arraylength
    //   243: iconst_2
    //   244: if_icmplt +126 -> 370
    //   247: aload 13
    //   249: iconst_1
    //   250: aaload
    //   251: astore 13
    //   253: new 117	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   260: aload 11
    //   262: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 194
    //   267: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 13
    //   272: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore 12
    //   280: iload_2
    //   281: istore 4
    //   283: aload_0
    //   284: new 739	com/tencent/stat/common/DeviceInfo
    //   287: dup
    //   288: aload 11
    //   290: aload 13
    //   292: iload_3
    //   293: invokespecial 742	com/tencent/stat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   296: putfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   299: aload 12
    //   301: invokestatic 342	com/tencent/stat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore 10
    //   306: iload 4
    //   308: ifeq +23 -> 331
    //   311: aload 10
    //   313: aload 15
    //   315: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +13 -> 331
    //   321: aload_0
    //   322: aload_1
    //   323: aload 10
    //   325: iload_3
    //   326: lload 8
    //   328: invokespecial 744	com/tencent/stat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   331: iload_3
    //   332: iload 5
    //   334: if_icmpeq +13 -> 347
    //   337: aload_0
    //   338: aload_1
    //   339: aload 10
    //   341: iload_3
    //   342: lload 8
    //   344: invokespecial 744	com/tencent/stat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   347: aload_0
    //   348: getfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   351: astore_1
    //   352: goto -338 -> 14
    //   355: aload_1
    //   356: invokestatic 747	com/tencent/stat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   359: astore 10
    //   361: aload 10
    //   363: astore 11
    //   365: iconst_1
    //   366: istore_2
    //   367: goto -132 -> 235
    //   370: aload_1
    //   371: invokestatic 750	com/tencent/stat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   374: astore 14
    //   376: aload 14
    //   378: astore 13
    //   380: iload_2
    //   381: istore 4
    //   383: aload 10
    //   385: astore 12
    //   387: aload 14
    //   389: ifnull -106 -> 283
    //   392: aload 14
    //   394: astore 13
    //   396: iload_2
    //   397: istore 4
    //   399: aload 10
    //   401: astore 12
    //   403: aload 14
    //   405: invokevirtual 347	java/lang/String:length	()I
    //   408: ifle -125 -> 283
    //   411: new 117	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   418: aload 11
    //   420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc 194
    //   425: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload 14
    //   430: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: astore 12
    //   438: iconst_1
    //   439: istore 4
    //   441: aload 14
    //   443: astore 13
    //   445: goto -162 -> 283
    //   448: aload_0
    //   449: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   452: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   455: invokevirtual 308	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   458: invokestatic 208	com/tencent/stat/StatConfig:isDebugEnable	()Z
    //   461: ifeq +12 -> 473
    //   464: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   467: ldc_w 752
    //   470: invokevirtual 218	com/tencent/stat/common/StatLogger:i	(Ljava/lang/Object;)V
    //   473: aload_0
    //   474: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   477: invokevirtual 546	com/tencent/stat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   480: ldc_w 754
    //   483: aconst_null
    //   484: aconst_null
    //   485: aconst_null
    //   486: aconst_null
    //   487: aconst_null
    //   488: aconst_null
    //   489: aconst_null
    //   490: invokevirtual 452	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   493: astore 11
    //   495: iconst_0
    //   496: istore_2
    //   497: aload 11
    //   499: invokeinterface 554 1 0
    //   504: ifeq +374 -> 878
    //   507: aload 11
    //   509: iconst_0
    //   510: invokeinterface 598 2 0
    //   515: astore 16
    //   517: aload 16
    //   519: invokestatic 603	com/tencent/stat/common/Util:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   522: astore 12
    //   524: aload 11
    //   526: iconst_1
    //   527: invokeinterface 558 2 0
    //   532: istore 5
    //   534: aload 11
    //   536: iconst_2
    //   537: invokeinterface 598 2 0
    //   542: astore 10
    //   544: aload 11
    //   546: iconst_3
    //   547: invokeinterface 595 2 0
    //   552: lstore 6
    //   554: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   557: ldc2_w 626
    //   560: ldiv
    //   561: lstore 8
    //   563: iload 5
    //   565: iconst_1
    //   566: if_icmpeq +769 -> 1335
    //   569: lload 6
    //   571: ldc2_w 626
    //   574: lmul
    //   575: invokestatic 731	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   578: ldc2_w 626
    //   581: lload 8
    //   583: lmul
    //   584: invokestatic 731	com/tencent/stat/common/StatCommonHelper:getDateFormat	(J)Ljava/lang/String;
    //   587: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: ifne +745 -> 1335
    //   593: iconst_1
    //   594: istore_2
    //   595: iload_2
    //   596: istore_3
    //   597: aload 10
    //   599: aload_1
    //   600: invokestatic 268	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   603: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   606: ifne +7 -> 613
    //   609: iload_2
    //   610: iconst_2
    //   611: ior
    //   612: istore_3
    //   613: aload 12
    //   615: ldc 194
    //   617: invokevirtual 493	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   620: astore 14
    //   622: aload 14
    //   624: ifnull +479 -> 1103
    //   627: aload 14
    //   629: arraylength
    //   630: ifle +473 -> 1103
    //   633: aload 14
    //   635: iconst_0
    //   636: aaload
    //   637: astore 10
    //   639: aload 10
    //   641: ifnull +13 -> 654
    //   644: aload 10
    //   646: invokevirtual 347	java/lang/String:length	()I
    //   649: bipush 11
    //   651: if_icmpge +667 -> 1318
    //   654: aload_1
    //   655: invokestatic 737	com/tencent/stat/common/Util:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   658: astore 13
    //   660: aload 13
    //   662: ifnull +651 -> 1313
    //   665: aload 13
    //   667: invokevirtual 347	java/lang/String:length	()I
    //   670: bipush 10
    //   672: if_icmple +641 -> 1313
    //   675: iconst_1
    //   676: istore_2
    //   677: aload 13
    //   679: astore 10
    //   681: goto +703 -> 1384
    //   684: aload 14
    //   686: ifnull +432 -> 1118
    //   689: aload 14
    //   691: arraylength
    //   692: iconst_2
    //   693: if_icmplt +425 -> 1118
    //   696: aload 14
    //   698: iconst_1
    //   699: aaload
    //   700: astore 14
    //   702: new 117	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   709: aload 12
    //   711: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: ldc 194
    //   716: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload 14
    //   721: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: astore 13
    //   729: iload_2
    //   730: istore 4
    //   732: aload_0
    //   733: new 739	com/tencent/stat/common/DeviceInfo
    //   736: dup
    //   737: aload 12
    //   739: aload 14
    //   741: iload_3
    //   742: invokespecial 742	com/tencent/stat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   745: putfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   748: new 330	android/content/ContentValues
    //   751: dup
    //   752: invokespecial 331	android/content/ContentValues:<init>	()V
    //   755: astore 10
    //   757: aload 13
    //   759: invokestatic 342	com/tencent/stat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   762: astore 12
    //   764: aload 10
    //   766: ldc 247
    //   768: aload 12
    //   770: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: aload 10
    //   775: ldc_w 257
    //   778: iload_3
    //   779: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   782: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   785: aload 10
    //   787: ldc_w 265
    //   790: aload_1
    //   791: invokestatic 268	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   794: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   797: aload 10
    //   799: ldc_w 270
    //   802: lload 8
    //   804: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   807: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   810: iload 4
    //   812: ifeq +31 -> 843
    //   815: aload_0
    //   816: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   819: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   822: ldc_w 754
    //   825: aload 10
    //   827: ldc_w 756
    //   830: iconst_1
    //   831: anewarray 344	java/lang/String
    //   834: dup
    //   835: iconst_0
    //   836: aload 16
    //   838: aastore
    //   839: invokevirtual 565	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   842: pop
    //   843: iload_3
    //   844: iload 5
    //   846: if_icmpeq +20 -> 866
    //   849: aload_0
    //   850: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   853: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   856: ldc_w 754
    //   859: aconst_null
    //   860: aload 10
    //   862: invokevirtual 759	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   865: pop2
    //   866: aload_0
    //   867: aload_1
    //   868: aload 12
    //   870: iload_3
    //   871: lload 8
    //   873: invokespecial 744	com/tencent/stat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   876: iconst_1
    //   877: istore_2
    //   878: iload_2
    //   879: ifne +173 -> 1052
    //   882: aload_1
    //   883: invokestatic 747	com/tencent/stat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   886: astore 12
    //   888: aload_1
    //   889: invokestatic 750	com/tencent/stat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   892: astore 13
    //   894: aload 13
    //   896: ifnull +410 -> 1306
    //   899: aload 13
    //   901: invokevirtual 347	java/lang/String:length	()I
    //   904: ifle +402 -> 1306
    //   907: new 117	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   914: aload 12
    //   916: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: ldc 194
    //   921: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: aload 13
    //   926: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: astore 10
    //   934: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   937: ldc2_w 626
    //   940: ldiv
    //   941: lstore 6
    //   943: aload_1
    //   944: invokestatic 268	com/tencent/stat/common/StatCommonHelper:getAppVersion	(Landroid/content/Context;)Ljava/lang/String;
    //   947: astore 14
    //   949: new 330	android/content/ContentValues
    //   952: dup
    //   953: invokespecial 331	android/content/ContentValues:<init>	()V
    //   956: astore 15
    //   958: aload 10
    //   960: invokestatic 342	com/tencent/stat/common/Util:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   963: astore 10
    //   965: aload 15
    //   967: ldc 247
    //   969: aload 10
    //   971: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: aload 15
    //   976: ldc_w 257
    //   979: iconst_0
    //   980: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   983: invokevirtual 543	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   986: aload 15
    //   988: ldc_w 265
    //   991: aload 14
    //   993: invokevirtual 352	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: aload 15
    //   998: ldc_w 270
    //   1001: lload 6
    //   1003: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1006: invokevirtual 369	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1009: aload_0
    //   1010: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   1013: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1016: ldc_w 754
    //   1019: aconst_null
    //   1020: aload 15
    //   1022: invokevirtual 373	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   1025: pop2
    //   1026: aload_0
    //   1027: aload_1
    //   1028: aload 10
    //   1030: iconst_0
    //   1031: lload 6
    //   1033: invokespecial 744	com/tencent/stat/af:a	(Landroid/content/Context;Ljava/lang/String;IJ)V
    //   1036: aload_0
    //   1037: new 739	com/tencent/stat/common/DeviceInfo
    //   1040: dup
    //   1041: aload 12
    //   1043: aload 13
    //   1045: iconst_0
    //   1046: invokespecial 742	com/tencent/stat/common/DeviceInfo:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1049: putfield 72	com/tencent/stat/af:b	Lcom/tencent/stat/common/DeviceInfo;
    //   1052: aload_0
    //   1053: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   1056: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1059: invokevirtual 376	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   1062: aload 11
    //   1064: ifnull +10 -> 1074
    //   1067: aload 11
    //   1069: invokeinterface 460 1 0
    //   1074: aload_0
    //   1075: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   1078: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1081: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1084: goto -737 -> 347
    //   1087: astore_1
    //   1088: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   1091: aload_1
    //   1092: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1095: goto -748 -> 347
    //   1098: astore_1
    //   1099: aload_0
    //   1100: monitorexit
    //   1101: aload_1
    //   1102: athrow
    //   1103: aload_1
    //   1104: invokestatic 747	com/tencent/stat/common/StatCommonHelper:getUserID	(Landroid/content/Context;)Ljava/lang/String;
    //   1107: astore 10
    //   1109: aload 10
    //   1111: astore 12
    //   1113: iconst_1
    //   1114: istore_2
    //   1115: goto -431 -> 684
    //   1118: aload_1
    //   1119: invokestatic 750	com/tencent/stat/common/StatCommonHelper:getMacId	(Landroid/content/Context;)Ljava/lang/String;
    //   1122: astore 15
    //   1124: aload 15
    //   1126: astore 14
    //   1128: iload_2
    //   1129: istore 4
    //   1131: aload 10
    //   1133: astore 13
    //   1135: aload 15
    //   1137: ifnull -405 -> 732
    //   1140: aload 15
    //   1142: astore 14
    //   1144: iload_2
    //   1145: istore 4
    //   1147: aload 10
    //   1149: astore 13
    //   1151: aload 15
    //   1153: invokevirtual 347	java/lang/String:length	()I
    //   1156: ifle -424 -> 732
    //   1159: new 117	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1166: aload 12
    //   1168: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: ldc 194
    //   1173: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: aload 15
    //   1178: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: astore 13
    //   1186: iconst_1
    //   1187: istore 4
    //   1189: aload 15
    //   1191: astore 14
    //   1193: goto -461 -> 732
    //   1196: astore 10
    //   1198: aconst_null
    //   1199: astore_1
    //   1200: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   1203: aload 10
    //   1205: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1208: aload_1
    //   1209: ifnull +9 -> 1218
    //   1212: aload_1
    //   1213: invokeinterface 460 1 0
    //   1218: aload_0
    //   1219: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   1222: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1225: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1228: goto -881 -> 347
    //   1231: astore_1
    //   1232: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   1235: aload_1
    //   1236: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1239: goto -892 -> 347
    //   1242: astore_1
    //   1243: aconst_null
    //   1244: astore 11
    //   1246: aload 11
    //   1248: ifnull +10 -> 1258
    //   1251: aload 11
    //   1253: invokeinterface 460 1 0
    //   1258: aload_0
    //   1259: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   1262: invokevirtual 320	com/tencent/stat/an:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1265: invokevirtual 379	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1268: aload_1
    //   1269: athrow
    //   1270: astore 10
    //   1272: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   1275: aload 10
    //   1277: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   1280: goto -12 -> 1268
    //   1283: astore_1
    //   1284: goto -38 -> 1246
    //   1287: astore 10
    //   1289: aload_1
    //   1290: astore 11
    //   1292: aload 10
    //   1294: astore_1
    //   1295: goto -49 -> 1246
    //   1298: astore 10
    //   1300: aload 11
    //   1302: astore_1
    //   1303: goto -103 -> 1200
    //   1306: aload 12
    //   1308: astore 10
    //   1310: goto -376 -> 934
    //   1313: iconst_0
    //   1314: istore_2
    //   1315: goto +69 -> 1384
    //   1318: iconst_0
    //   1319: istore_2
    //   1320: aload 10
    //   1322: astore 13
    //   1324: aload 12
    //   1326: astore 10
    //   1328: aload 13
    //   1330: astore 12
    //   1332: goto -648 -> 684
    //   1335: iload 5
    //   1337: istore_2
    //   1338: goto -743 -> 595
    //   1341: iconst_0
    //   1342: istore_2
    //   1343: goto +26 -> 1369
    //   1346: iconst_0
    //   1347: istore_2
    //   1348: aload 10
    //   1350: astore 12
    //   1352: aload 11
    //   1354: astore 10
    //   1356: aload 12
    //   1358: astore 11
    //   1360: goto -1125 -> 235
    //   1363: iload 5
    //   1365: istore_2
    //   1366: goto -1220 -> 146
    //   1369: aload 10
    //   1371: astore 12
    //   1373: aload 11
    //   1375: astore 10
    //   1377: aload 12
    //   1379: astore 11
    //   1381: goto -1146 -> 235
    //   1384: aload 10
    //   1386: astore 13
    //   1388: aload 12
    //   1390: astore 10
    //   1392: aload 13
    //   1394: astore 12
    //   1396: goto -712 -> 684
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1399	0	this	af
    //   0	1399	1	paramContext	Context
    //   145	1221	2	i1	int
    //   147	724	3	i2	int
    //   281	907	4	i3	int
    //   74	1290	5	i4	int
    //   103	929	6	l1	long
    //   112	760	8	l2	long
    //   89	1059	10	localObject1	Object
    //   1196	8	10	localThrowable1	Throwable
    //   1270	6	10	localThrowable2	Throwable
    //   1287	6	10	localObject2	Object
    //   1298	1	10	localThrowable3	Throwable
    //   1308	83	10	localObject3	Object
    //   60	1320	11	localObject4	Object
    //   209	1186	12	localObject5	Object
    //   171	1222	13	localObject6	Object
    //   374	818	14	localObject7	Object
    //   53	1137	15	localObject8	Object
    //   515	322	16	str	String
    // Exception table:
    //   from	to	target	type
    //   1067	1074	1087	java/lang/Throwable
    //   1074	1084	1087	java/lang/Throwable
    //   2	14	1098	finally
    //   18	41	1098	finally
    //   41	114	1098	finally
    //   120	144	1098	finally
    //   148	160	1098	finally
    //   164	173	1098	finally
    //   178	184	1098	finally
    //   195	205	1098	finally
    //   205	211	1098	finally
    //   216	226	1098	finally
    //   240	247	1098	finally
    //   253	280	1098	finally
    //   283	306	1098	finally
    //   311	331	1098	finally
    //   337	347	1098	finally
    //   347	352	1098	finally
    //   355	361	1098	finally
    //   370	376	1098	finally
    //   403	438	1098	finally
    //   1067	1074	1098	finally
    //   1074	1084	1098	finally
    //   1088	1095	1098	finally
    //   1212	1218	1098	finally
    //   1218	1228	1098	finally
    //   1232	1239	1098	finally
    //   1251	1258	1098	finally
    //   1258	1268	1098	finally
    //   1268	1270	1098	finally
    //   1272	1280	1098	finally
    //   448	473	1196	java/lang/Throwable
    //   473	495	1196	java/lang/Throwable
    //   1212	1218	1231	java/lang/Throwable
    //   1218	1228	1231	java/lang/Throwable
    //   448	473	1242	finally
    //   473	495	1242	finally
    //   1251	1258	1270	java/lang/Throwable
    //   1258	1268	1270	java/lang/Throwable
    //   497	563	1283	finally
    //   569	593	1283	finally
    //   597	609	1283	finally
    //   613	622	1283	finally
    //   627	633	1283	finally
    //   644	654	1283	finally
    //   654	660	1283	finally
    //   665	675	1283	finally
    //   689	696	1283	finally
    //   702	729	1283	finally
    //   732	810	1283	finally
    //   815	843	1283	finally
    //   849	866	1283	finally
    //   866	876	1283	finally
    //   882	894	1283	finally
    //   899	934	1283	finally
    //   934	1052	1283	finally
    //   1052	1062	1283	finally
    //   1103	1109	1283	finally
    //   1118	1124	1283	finally
    //   1151	1186	1283	finally
    //   1200	1208	1287	finally
    //   497	563	1298	java/lang/Throwable
    //   569	593	1298	java/lang/Throwable
    //   597	609	1298	java/lang/Throwable
    //   613	622	1298	java/lang/Throwable
    //   627	633	1298	java/lang/Throwable
    //   644	654	1298	java/lang/Throwable
    //   654	660	1298	java/lang/Throwable
    //   665	675	1298	java/lang/Throwable
    //   689	696	1298	java/lang/Throwable
    //   702	729	1298	java/lang/Throwable
    //   732	810	1298	java/lang/Throwable
    //   815	843	1298	java/lang/Throwable
    //   849	866	1298	java/lang/Throwable
    //   866	876	1298	java/lang/Throwable
    //   882	894	1298	java/lang/Throwable
    //   899	934	1298	java/lang/Throwable
    //   934	1052	1298	java/lang/Throwable
    //   1052	1062	1298	java/lang/Throwable
    //   1103	1109	1298	java/lang/Throwable
    //   1118	1124	1298	java/lang/Throwable
    //   1151	1186	1298	java/lang/Throwable
  }
  
  void c()
  {
    if (!StatConfig.isEnableStatService()) {
      return;
    }
    try
    {
      this.e.post(new ai(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      h.e(localThrowable);
    }
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/stat/af:c	Lcom/tencent/stat/an;
    //   4: invokevirtual 546	com/tencent/stat/an:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 548
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 551	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 554 1 0
    //   31: ifeq +151 -> 182
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 558 2 0
    //   45: istore_1
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: iconst_1
    //   52: invokeinterface 598 2 0
    //   57: astore 5
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: iconst_2
    //   65: invokeinterface 598 2 0
    //   70: astore 6
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: iconst_3
    //   78: invokeinterface 558 2 0
    //   83: istore_2
    //   84: aload 4
    //   86: astore_3
    //   87: new 522	com/tencent/stat/e
    //   90: dup
    //   91: iload_1
    //   92: invokespecial 767	com/tencent/stat/e:<init>	(I)V
    //   95: astore 7
    //   97: aload 4
    //   99: astore_3
    //   100: aload 7
    //   102: iload_1
    //   103: putfield 559	com/tencent/stat/e:a	I
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: new 532	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 768	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: putfield 530	com/tencent/stat/e:b	Lorg/json/JSONObject;
    //   123: aload 4
    //   125: astore_3
    //   126: aload 7
    //   128: aload 6
    //   130: putfield 536	com/tencent/stat/e:c	Ljava/lang/String;
    //   133: aload 4
    //   135: astore_3
    //   136: aload 7
    //   138: iload_2
    //   139: putfield 540	com/tencent/stat/e:d	I
    //   142: aload 4
    //   144: astore_3
    //   145: getstatic 44	com/tencent/stat/af:i	Landroid/content/Context;
    //   148: aload 7
    //   150: invokestatic 771	com/tencent/stat/StatConfig:a	(Landroid/content/Context;Lcom/tencent/stat/e;)V
    //   153: goto -132 -> 21
    //   156: astore 5
    //   158: aload 4
    //   160: astore_3
    //   161: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   164: aload 5
    //   166: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 460 1 0
    //   181: return
    //   182: aload 4
    //   184: ifnull -3 -> 181
    //   187: aload 4
    //   189: invokeinterface 460 1 0
    //   194: return
    //   195: astore_3
    //   196: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   199: aload_3
    //   200: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   203: return
    //   204: astore_3
    //   205: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   208: aload_3
    //   209: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   212: return
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_3
    //   217: aload_3
    //   218: ifnull +9 -> 227
    //   221: aload_3
    //   222: invokeinterface 460 1 0
    //   227: aload 4
    //   229: athrow
    //   230: astore_3
    //   231: getstatic 42	com/tencent/stat/af:h	Lcom/tencent/stat/common/StatLogger;
    //   234: aload_3
    //   235: invokevirtual 152	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   238: goto -11 -> 227
    //   241: astore 4
    //   243: goto -26 -> 217
    //   246: astore 5
    //   248: aconst_null
    //   249: astore 4
    //   251: goto -93 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	af
    //   45	58	1	i1	int
    //   83	56	2	i2	int
    //   23	138	3	localCursor1	Cursor
    //   195	5	3	localThrowable1	Throwable
    //   204	5	3	localThrowable2	Throwable
    //   216	6	3	localObject1	Object
    //   230	5	3	localThrowable3	Throwable
    //   19	169	4	localCursor2	Cursor
    //   213	15	4	localObject2	Object
    //   241	1	4	localObject3	Object
    //   249	1	4	localObject4	Object
    //   57	59	5	str1	String
    //   156	9	5	localThrowable4	Throwable
    //   246	1	5	localThrowable5	Throwable
    //   70	59	6	str2	String
    //   95	54	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   24	34	156	java/lang/Throwable
    //   37	46	156	java/lang/Throwable
    //   49	59	156	java/lang/Throwable
    //   62	72	156	java/lang/Throwable
    //   75	84	156	java/lang/Throwable
    //   87	97	156	java/lang/Throwable
    //   100	106	156	java/lang/Throwable
    //   109	123	156	java/lang/Throwable
    //   126	133	156	java/lang/Throwable
    //   136	142	156	java/lang/Throwable
    //   145	153	156	java/lang/Throwable
    //   187	194	195	java/lang/Throwable
    //   174	181	204	java/lang/Throwable
    //   0	21	213	finally
    //   221	227	230	java/lang/Throwable
    //   24	34	241	finally
    //   37	46	241	finally
    //   49	59	241	finally
    //   62	72	241	finally
    //   75	84	241	finally
    //   87	97	241	finally
    //   100	106	241	finally
    //   109	123	241	finally
    //   126	133	241	finally
    //   136	142	241	finally
    //   145	153	241	finally
    //   161	169	241	finally
    //   0	21	246	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.af
 * JD-Core Version:    0.7.0.1
 */