package com.tencent.beacon.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.c;
import com.tencent.beacon.event.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class e
{
  private static e a;
  
  private e(Context paramContext)
  {
    paramContext.getApplicationContext();
  }
  
  public static int a(Context paramContext, com.tencent.beacon.a.a.d[] paramArrayOfd)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfd == null) || (paramArrayOfd.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfd.length);
      int k = paramArrayOfd.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.a.a.d locald = paramArrayOfd[i];
        Object localObject = com.tencent.beacon.b.a.a(locald);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(6, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a)localObject).a(locald.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" deleteRecordList() have null args!", new Object[0]);
      return -1;
    }
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() end", new Object[0]);
    return com.tencent.beacon.a.a.a.a(paramContext, paramArrayOfLong);
  }
  
  public static long a(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  /* Error */
  public static com.tencent.beacon.a.b.h a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +14 -> 18
    //   7: ldc 87
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 90	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 95	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 99	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull +37 -> 66
    //   32: ldc 101
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 90	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_2
    //   42: ifnull +14 -> 56
    //   45: aload_2
    //   46: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   49: ifeq +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_2
    //   67: ldc 113
    //   69: aconst_null
    //   70: getstatic 119	java/util/Locale:US	Ljava/util/Locale;
    //   73: ldc 121
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc 123
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: bipush 101
    //   88: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: invokestatic 135	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 139	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +261 -> 365
    //   107: aload_3
    //   108: invokeinterface 144 1 0
    //   113: ifeq +252 -> 365
    //   116: aload_3
    //   117: ifnull +429 -> 546
    //   120: aload_3
    //   121: invokeinterface 147 1 0
    //   126: ifne +420 -> 546
    //   129: aload_3
    //   130: invokeinterface 150 1 0
    //   135: ifeq +76 -> 211
    //   138: goto +408 -> 546
    //   141: aload 4
    //   143: ifnull +222 -> 365
    //   146: ldc 152
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 156	com/tencent/beacon/a/b/h:b	()I
    //   159: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 159	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_3
    //   167: ifnull +18 -> 185
    //   170: aload_3
    //   171: invokeinterface 162 1 0
    //   176: ifne +9 -> 185
    //   179: aload_3
    //   180: invokeinterface 163 1 0
    //   185: aload_2
    //   186: ifnull +14 -> 200
    //   189: aload_2
    //   190: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   193: ifeq +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   208: aload 4
    //   210: areturn
    //   211: ldc 165
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 167	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: new 154	com/tencent/beacon/a/b/h
    //   223: dup
    //   224: invokespecial 168	com/tencent/beacon/a/b/h:<init>	()V
    //   227: astore 4
    //   229: aload 4
    //   231: aload_3
    //   232: aload_3
    //   233: ldc 170
    //   235: invokeinterface 174 2 0
    //   240: invokeinterface 178 2 0
    //   245: invokevirtual 181	com/tencent/beacon/a/b/h:a	(J)V
    //   248: aload 4
    //   250: aload_3
    //   251: aload_3
    //   252: ldc 123
    //   254: invokeinterface 174 2 0
    //   259: invokeinterface 185 2 0
    //   264: invokevirtual 187	com/tencent/beacon/a/b/h:a	(I)V
    //   267: aload 4
    //   269: aload_3
    //   270: aload_3
    //   271: ldc 189
    //   273: invokeinterface 174 2 0
    //   278: invokeinterface 193 2 0
    //   283: invokevirtual 196	com/tencent/beacon/a/b/h:a	([B)V
    //   286: goto -145 -> 141
    //   289: astore 4
    //   291: aload_3
    //   292: astore 5
    //   294: aload_0
    //   295: astore_3
    //   296: aload 5
    //   298: astore_0
    //   299: aload 4
    //   301: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   304: ldc 199
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 4
    //   314: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_0
    //   322: ifnull +18 -> 340
    //   325: aload_0
    //   326: invokeinterface 162 1 0
    //   331: ifne +9 -> 340
    //   334: aload_0
    //   335: invokeinterface 163 1 0
    //   340: aload_2
    //   341: ifnull +14 -> 355
    //   344: aload_2
    //   345: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   348: ifeq +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   363: aconst_null
    //   364: areturn
    //   365: aload_3
    //   366: ifnull +18 -> 384
    //   369: aload_3
    //   370: invokeinterface 162 1 0
    //   375: ifne +9 -> 384
    //   378: aload_3
    //   379: invokeinterface 163 1 0
    //   384: aload_2
    //   385: ifnull +14 -> 399
    //   388: aload_2
    //   389: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   392: ifeq +7 -> 399
    //   395: aload_2
    //   396: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   399: aload_0
    //   400: ifnull -37 -> 363
    //   403: aload_0
    //   404: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   407: goto -44 -> 363
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_3
    //   413: aconst_null
    //   414: astore_0
    //   415: aload_3
    //   416: ifnull +18 -> 434
    //   419: aload_3
    //   420: invokeinterface 162 1 0
    //   425: ifne +9 -> 434
    //   428: aload_3
    //   429: invokeinterface 163 1 0
    //   434: aload 4
    //   436: ifnull +16 -> 452
    //   439: aload 4
    //   441: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   444: ifeq +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   452: aload_0
    //   453: ifnull +7 -> 460
    //   456: aload_0
    //   457: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   460: aload_2
    //   461: athrow
    //   462: astore_2
    //   463: aconst_null
    //   464: astore_3
    //   465: goto -50 -> 415
    //   468: astore 5
    //   470: aconst_null
    //   471: astore_3
    //   472: aload_2
    //   473: astore 4
    //   475: aload 5
    //   477: astore_2
    //   478: goto -63 -> 415
    //   481: astore 5
    //   483: aload_2
    //   484: astore 4
    //   486: aload 5
    //   488: astore_2
    //   489: goto -74 -> 415
    //   492: astore 6
    //   494: aload_2
    //   495: astore 4
    //   497: aload_3
    //   498: astore 5
    //   500: aload 6
    //   502: astore_2
    //   503: aload_0
    //   504: astore_3
    //   505: aload 5
    //   507: astore_0
    //   508: goto -93 -> 415
    //   511: astore 4
    //   513: aconst_null
    //   514: astore_0
    //   515: aconst_null
    //   516: astore_2
    //   517: aconst_null
    //   518: astore_3
    //   519: goto -220 -> 299
    //   522: astore 4
    //   524: aconst_null
    //   525: astore 5
    //   527: aconst_null
    //   528: astore_2
    //   529: aload_0
    //   530: astore_3
    //   531: aload 5
    //   533: astore_0
    //   534: goto -235 -> 299
    //   537: astore 4
    //   539: aload_0
    //   540: astore_3
    //   541: aconst_null
    //   542: astore_0
    //   543: goto -244 -> 299
    //   546: aconst_null
    //   547: astore 4
    //   549: goto -408 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	paramContext	Context
    //   0	552	1	paramInt	int
    //   27	369	2	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   410	51	2	localObject1	Object
    //   462	11	2	localObject2	Object
    //   477	52	2	localObject3	Object
    //   102	439	3	localObject4	Object
    //   1	267	4	localh	com.tencent.beacon.a.b.h
    //   289	159	4	localThrowable1	Throwable
    //   473	23	4	localObject5	Object
    //   511	1	4	localThrowable2	Throwable
    //   522	1	4	localThrowable3	Throwable
    //   537	1	4	localThrowable4	Throwable
    //   547	1	4	localObject6	Object
    //   292	5	5	localObject7	Object
    //   468	8	5	localObject8	Object
    //   481	6	5	localObject9	Object
    //   498	34	5	localObject10	Object
    //   492	9	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   107	116	289	java/lang/Throwable
    //   120	138	289	java/lang/Throwable
    //   146	166	289	java/lang/Throwable
    //   211	286	289	java/lang/Throwable
    //   18	23	410	finally
    //   23	28	462	finally
    //   32	41	468	finally
    //   66	103	468	finally
    //   107	116	481	finally
    //   120	138	481	finally
    //   146	166	481	finally
    //   211	286	481	finally
    //   299	321	492	finally
    //   18	23	511	java/lang/Throwable
    //   23	28	522	java/lang/Throwable
    //   32	41	537	java/lang/Throwable
    //   66	103	537	java/lang/Throwable
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new e(paramContext.getApplicationContext());
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.beacon.c.d.b a(h paramh)
  {
    if ((paramh == null) || (!"IP".equals(paramh.b()))) {
      return null;
    }
    Map localMap = paramh.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.b localb = new com.tencent.beacon.c.d.b();
      localb.a = ((String)localMap.get("A19"));
      String str = (String)localMap.get("A26");
      Object localObject = str;
      if (str == null) {
        localObject = "-1";
      }
      localb.e = Long.parseLong((String)localObject);
      localObject = paramh.d().split(":");
      localb.c = localObject[0];
      localb.d = Integer.parseInt(localObject[1]);
      localb.b = ((String)localMap.get("A28"));
      localb.f = paramh.c();
      paramh = new HashMap();
      paramh.put("A33", localMap.get("A33"));
      paramh.put("A3", localMap.get("A3"));
      localb.g = a(paramh);
      return localb;
    }
    catch (Throwable paramh)
    {
      paramh.printStackTrace();
      com.tencent.beacon.d.a.d(paramh.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static h a(Context paramContext, String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    if (paramString == null) {
      return null;
    }
    d locald = d.m();
    if (locald == null)
    {
      com.tencent.beacon.d.a.d("  CommonInfo have not been Created return null!", new Object[0]);
      return null;
    }
    String str1 = UserAction.getUserID();
    long l1 = locald.h();
    long l2 = new Date().getTime();
    String str2 = locald.g();
    Object localObject2 = com.tencent.beacon.d.b.c(paramContext);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    if (paramMap != null) {
      ((Map)localObject2).putAll(paramMap);
    }
    ((Map)localObject2).put("A1", str1);
    ((Map)localObject2).put("QQ", UserAction.getQQ());
    ((Map)localObject2).put("A19", (String)localObject1);
    ((Map)localObject2).put("A28", str2);
    ((Map)localObject2).put("A25", paramBoolean);
    ((Map)localObject2).put("A26", paramLong1);
    ((Map)localObject2).put("A27", paramLong2);
    ((Map)localObject2).put("A2", locald.i());
    paramMap = c.a(paramContext);
    ((Map)localObject2).put("A4", paramMap.b());
    ((Map)localObject2).put("A6", paramMap.a());
    ((Map)localObject2).put("A7", paramMap.c());
    ((Map)localObject2).put("A3", com.tencent.beacon.b.a.a(paramContext).a());
    ((Map)localObject2).put("A23", paramMap.d());
    ((Map)localObject2).put("A67", a.h(paramContext));
    paramContext = new h();
    paramContext.b(paramString);
    paramContext.b(l1 + l2);
    paramContext.a("UA");
    paramContext.a((Map)localObject2);
    paramContext.c(1L);
    int i = 0;
    if (paramLong1 >= 1200000L) {
      i = 1;
    }
    int j = i;
    if (paramLong2 >= 50000000L) {
      j = i + 1;
    }
    if (j > 0)
    {
      paramContext.d(j);
      paramContext.b(true);
      return paramContext;
    }
    paramContext.d(0L);
    paramContext.b(false);
    return paramContext;
  }
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDeviceName error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "null";
  }
  
  public static String a(Map<String, String> paramMap)
  {
    com.tencent.beacon.d.a.b("  map 2 str", new Object[0]);
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append("&");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)paramMap.get(str));
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static List<h> a(Context paramContext, String[] paramArrayOfString, long paramLong)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" queryRecentRecord() have null args!", new Object[0]);
      return null;
    }
    paramArrayOfString = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 1, 2, 3, 4 }, 1, 2, paramLong, -1, -1, -1, -1, -1, -1L, -1L);
    if ((paramArrayOfString == null) || (paramArrayOfString.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramArrayOfString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = com.tencent.beacon.b.a.a(locala.b());
        if ((localObject2 != null) && (h.class.isInstance(localObject2)))
        {
          localObject2 = (h)h.class.cast(localObject2);
          ((h)localObject2).a(locala.a());
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d(" query have error!", new Object[0]);
      }
    }
    if (paramArrayOfString.size() > 0)
    {
      com.tencent.beacon.d.a.a(" there are error datas ,should be remove " + paramArrayOfString.size(), new Object[0]);
      localObject1 = new Long[paramArrayOfString.size()];
      int i = 0;
      while (i < paramArrayOfString.size())
      {
        localObject1[i] = Long.valueOf(((com.tencent.beacon.a.a.a)paramArrayOfString.get(i)).a());
        i += 1;
      }
      com.tencent.beacon.a.a.a.a(paramContext, (Long[])localObject1);
    }
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
    return localArrayList;
  }
  
  public static void a(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if ((paramMap == null) || (paramString == null))
    {
      com.tencent.beacon.d.a.c(" err addVMap, pls check!}", new Object[0]);
      return;
    }
    paramMap.put(paramString, Long.toString(a((String)paramMap.get(paramString)) + paramLong));
  }
  
  /* Error */
  public static boolean a(Context paramContext, com.tencent.beacon.a.b.h paramh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +15 -> 23
    //   11: ldc_w 519
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 90	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: invokestatic 95	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   27: invokevirtual 99	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +36 -> 70
    //   37: aload 4
    //   39: astore_0
    //   40: ldc_w 521
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload 4
    //   52: ifnull -31 -> 21
    //   55: aload 4
    //   57: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   60: ifeq -39 -> 21
    //   63: aload 4
    //   65: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: ifnonnull +62 -> 133
    //   74: aload 5
    //   76: ifnull +231 -> 307
    //   79: aload 4
    //   81: astore_0
    //   82: aload 4
    //   84: ldc 113
    //   86: ldc 170
    //   88: aload 5
    //   90: invokevirtual 525	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   93: lstore_2
    //   94: lload_2
    //   95: lconst_0
    //   96: lcmp
    //   97: ifge +159 -> 256
    //   100: aload 4
    //   102: astore_0
    //   103: ldc_w 527
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 90	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload 4
    //   115: ifnull -94 -> 21
    //   118: aload 4
    //   120: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   123: ifeq -102 -> 21
    //   126: aload 4
    //   128: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload 4
    //   135: astore_0
    //   136: new 529	android/content/ContentValues
    //   139: dup
    //   140: invokespecial 530	android/content/ContentValues:<init>	()V
    //   143: astore 5
    //   145: aload 4
    //   147: astore_0
    //   148: aload_1
    //   149: invokevirtual 531	com/tencent/beacon/a/b/h:a	()J
    //   152: lconst_0
    //   153: lcmp
    //   154: iflt +20 -> 174
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: ldc 170
    //   164: aload_1
    //   165: invokevirtual 531	com/tencent/beacon/a/b/h:a	()J
    //   168: invokestatic 504	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokevirtual 534	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   174: aload 4
    //   176: astore_0
    //   177: aload 5
    //   179: ldc 123
    //   181: aload_1
    //   182: invokevirtual 156	com/tencent/beacon/a/b/h:b	()I
    //   185: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: invokevirtual 537	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   191: aload 4
    //   193: astore_0
    //   194: aload 5
    //   196: ldc 189
    //   198: aload_1
    //   199: invokevirtual 539	com/tencent/beacon/a/b/h:c	()[B
    //   202: invokevirtual 542	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   205: goto -131 -> 74
    //   208: astore_1
    //   209: aload 4
    //   211: astore_0
    //   212: ldc_w 544
    //   215: iconst_1
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_1
    //   222: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload 4
    //   231: astore_0
    //   232: aload_1
    //   233: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   236: aload 4
    //   238: ifnull -217 -> 21
    //   241: aload 4
    //   243: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   246: ifeq -225 -> 21
    //   249: aload 4
    //   251: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: aload 4
    //   258: astore_0
    //   259: aload_1
    //   260: lload_2
    //   261: invokevirtual 181	com/tencent/beacon/a/b/h:a	(J)V
    //   264: aload 4
    //   266: astore_0
    //   267: ldc_w 546
    //   270: iconst_1
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_1
    //   277: invokevirtual 156	com/tencent/beacon/a/b/h:b	()I
    //   280: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: invokestatic 548	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 4
    //   289: ifnull +16 -> 305
    //   292: aload 4
    //   294: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   297: ifeq +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   305: iconst_1
    //   306: ireturn
    //   307: aload 4
    //   309: ifnull -288 -> 21
    //   312: aload 4
    //   314: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   317: ifeq -296 -> 21
    //   320: aload 4
    //   322: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: iconst_0
    //   326: ireturn
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_0
    //   330: aload_0
    //   331: ifnull +14 -> 345
    //   334: aload_0
    //   335: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   338: ifeq +7 -> 345
    //   341: aload_0
    //   342: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   345: aload_1
    //   346: athrow
    //   347: astore_1
    //   348: goto -18 -> 330
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 4
    //   355: goto -146 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramContext	Context
    //   0	358	1	paramh	com.tencent.beacon.a.b.h
    //   93	168	2	l	long
    //   30	324	4	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   1	194	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   40	50	208	java/lang/Throwable
    //   82	94	208	java/lang/Throwable
    //   103	113	208	java/lang/Throwable
    //   136	145	208	java/lang/Throwable
    //   148	157	208	java/lang/Throwable
    //   160	174	208	java/lang/Throwable
    //   177	191	208	java/lang/Throwable
    //   194	205	208	java/lang/Throwable
    //   259	264	208	java/lang/Throwable
    //   267	287	208	java/lang/Throwable
    //   23	32	327	finally
    //   40	50	347	finally
    //   82	94	347	finally
    //   103	113	347	finally
    //   136	145	347	finally
    //   148	157	347	finally
    //   160	174	347	finally
    //   177	191	347	finally
    //   194	205	347	finally
    //   212	229	347	finally
    //   232	236	347	finally
    //   259	264	347	finally
    //   267	287	347	finally
    //   23	32	351	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, h paramh)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: ldc_w 551
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 62	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnull +14 -> 27
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 215	com/tencent/beacon/event/h:b	()Ljava/lang/String;
    //   24: ifnonnull +15 -> 39
    //   27: ldc_w 553
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: invokevirtual 215	com/tencent/beacon/event/h:b	()Ljava/lang/String;
    //   43: ldc_w 390
    //   46: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +73 -> 122
    //   52: iconst_1
    //   53: istore_2
    //   54: new 31	com/tencent/beacon/a/a/a
    //   57: dup
    //   58: iload_2
    //   59: iload_3
    //   60: aload_1
    //   61: invokevirtual 265	com/tencent/beacon/event/h:c	()J
    //   64: aload_1
    //   65: invokestatic 29	com/tencent/beacon/b/a:a	(Ljava/lang/Object;)[B
    //   68: invokespecial 34	com/tencent/beacon/a/a/a:<init>	(IIJ[B)V
    //   71: astore 5
    //   73: aload_0
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: ifnonnull +114 -> 193
    //   82: ldc_w 555
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 62	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: iconst_0
    //   93: istore 4
    //   95: iload 4
    //   97: ifeq +12 -> 109
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 485	com/tencent/beacon/a/a/a:a	()J
    //   106: invokevirtual 486	com/tencent/beacon/event/h:a	(J)V
    //   109: ldc_w 557
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 62	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: iload 4
    //   121: ireturn
    //   122: aload_1
    //   123: invokevirtual 215	com/tencent/beacon/event/h:b	()Ljava/lang/String;
    //   126: ldc 211
    //   128: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifeq +10 -> 141
    //   134: iconst_2
    //   135: istore_2
    //   136: iconst_0
    //   137: istore_3
    //   138: goto -84 -> 54
    //   141: aload_1
    //   142: invokevirtual 215	com/tencent/beacon/event/h:b	()Ljava/lang/String;
    //   145: ldc_w 559
    //   148: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +10 -> 161
    //   154: iconst_3
    //   155: istore_2
    //   156: iconst_0
    //   157: istore_3
    //   158: goto -104 -> 54
    //   161: aload_1
    //   162: invokevirtual 215	com/tencent/beacon/event/h:b	()Ljava/lang/String;
    //   165: ldc_w 561
    //   168: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +10 -> 181
    //   174: iconst_4
    //   175: istore_2
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -124 -> 54
    //   181: ldc_w 563
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: ireturn
    //   193: new 21	java/util/ArrayList
    //   196: dup
    //   197: invokespecial 469	java/util/ArrayList:<init>	()V
    //   200: astore 6
    //   202: aload 6
    //   204: aload 5
    //   206: invokevirtual 46	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload_0
    //   211: aload 6
    //   213: invokestatic 565	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;Ljava/util/List;)Z
    //   216: istore 4
    //   218: goto -123 -> 95
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   226: ldc_w 567
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: ldc_w 557
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 62	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_0
    //   249: ldc_w 557
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 62	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramh	h
    //   53	123	2	i	int
    //   1	177	3	j	int
    //   93	124	4	bool	boolean
    //   71	134	5	locala	com.tencent.beacon.a.a.a
    //   200	12	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   54	73	221	java/lang/Throwable
    //   82	92	221	java/lang/Throwable
    //   100	109	221	java/lang/Throwable
    //   193	218	221	java/lang/Throwable
    //   54	73	248	finally
    //   82	92	248	finally
    //   100	109	248	finally
    //   193	218	248	finally
    //   222	236	248	finally
  }
  
  public static boolean a(Context paramContext, List<h> paramList)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.insertList() start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.d.a.d(" insertList() have null args!", new Object[0]);
      return false;
    }
    if (paramList.size() <= 0)
    {
      com.tencent.beacon.d.a.b(" list siez == 0 , return true!", new Object[0]);
      return true;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    for (;;)
    {
      if (k < paramList.size())
      {
        h localh = (h)paramList.get(k);
        int j;
        int i;
        if (localh.b().equals("UA"))
        {
          j = 3;
          i = 1;
        }
        try
        {
          label105:
          localArrayList.add(new com.tencent.beacon.a.a.a(i, j, localh.c(), com.tencent.beacon.b.a.a(localh)));
          for (;;)
          {
            k += 1;
            break;
            if (localh.b().equals("IP"))
            {
              i = 2;
              j = 0;
              break label105;
            }
            if (localh.b().equals("DN"))
            {
              j = 0;
              i = 3;
              break label105;
            }
            if (localh.b().equals("HO"))
            {
              i = 4;
              j = 0;
              break label105;
            }
            com.tencent.beacon.d.a.d(" bean's type is error!", new Object[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
    return com.tencent.beacon.a.a.a.a(paramContext, localArrayList);
  }
  
  public static byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return a(paramString, paramArrayOfByte);
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject;
    if (paramInt == 1)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new ZipOutputStream(localByteArrayOutputStream);
      ZipEntry localZipEntry = new ZipEntry("zip");
      localZipEntry.setSize(paramArrayOfByte.length);
      ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
      ((ZipOutputStream)localObject).write(paramArrayOfByte);
      ((ZipOutputStream)localObject).closeEntry();
      ((ZipOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    if (paramInt == 2)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    return null;
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    int j = 0;
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      paramString = null;
      return paramString;
    }
    int i = paramString.length();
    label19:
    Object localObject;
    int k;
    if (i >= 16)
    {
      paramString = paramString.substring(0, 16);
      localObject = new StringBuffer();
      k = paramArrayOfByte.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= k)
      {
        localObject = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, (Key)localObject, new IvParameterSpec(paramString.getBytes()));
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        localObject = new StringBuffer();
        k = paramArrayOfByte.length;
        i = j;
        for (;;)
        {
          paramString = paramArrayOfByte;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
          i += 1;
        }
        paramString = paramString + "0";
        i += 1;
        break label19;
      }
      ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
      {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localGZIPInputStream.close();
        paramArrayOfByte.close();
        return arrayOfByte;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  public static int b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: ifnonnull +15 -> 26
    //   14: ldc_w 709
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 90	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 95	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   30: astore_0
    //   31: aload_0
    //   32: astore_3
    //   33: aload_2
    //   34: astore_0
    //   35: aload_3
    //   36: astore_2
    //   37: aload 5
    //   39: astore 4
    //   41: aload_3
    //   42: invokevirtual 99	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnonnull +50 -> 99
    //   52: aload 5
    //   54: astore_0
    //   55: aload_3
    //   56: astore_2
    //   57: aload 5
    //   59: astore 4
    //   61: ldc_w 711
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload 5
    //   73: ifnull +16 -> 89
    //   76: aload 5
    //   78: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   81: ifeq +8 -> 89
    //   84: aload 5
    //   86: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   89: aload_3
    //   90: ifnull -66 -> 24
    //   93: aload_3
    //   94: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: aload 5
    //   101: astore_0
    //   102: aload_3
    //   103: astore_2
    //   104: aload 5
    //   106: astore 4
    //   108: aload 5
    //   110: ldc 113
    //   112: ldc_w 713
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc 123
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: bipush 101
    //   128: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 716	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   135: aconst_null
    //   136: invokevirtual 720	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: istore_1
    //   140: aload 5
    //   142: astore_0
    //   143: aload_3
    //   144: astore_2
    //   145: aload 5
    //   147: astore 4
    //   149: ldc_w 722
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: bipush 101
    //   160: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: iload_1
    //   167: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 159	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: ifnull +16 -> 192
    //   179: aload 5
    //   181: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   184: ifeq +8 -> 192
    //   187: aload 5
    //   189: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   200: iload_1
    //   201: ireturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_3
    //   206: aload 4
    //   208: astore_0
    //   209: aload_3
    //   210: astore_2
    //   211: aload 5
    //   213: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   216: aload 4
    //   218: astore_0
    //   219: aload_3
    //   220: astore_2
    //   221: ldc_w 724
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload 5
    //   232: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload 4
    //   241: ifnull +16 -> 257
    //   244: aload 4
    //   246: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   249: ifeq +8 -> 257
    //   252: aload 4
    //   254: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   257: aload_3
    //   258: ifnull -234 -> 24
    //   261: aload_3
    //   262: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_3
    //   272: astore_0
    //   273: aload 4
    //   275: astore_3
    //   276: aload_0
    //   277: ifnull +14 -> 291
    //   280: aload_0
    //   281: invokevirtual 107	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   284: ifeq +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 111	com/tencent/beacon/a/a/c:close	()V
    //   299: aload_3
    //   300: athrow
    //   301: astore_3
    //   302: goto -26 -> 276
    //   305: astore 5
    //   307: goto -101 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramContext	Context
    //   0	310	1	paramInt	int
    //   3	293	2	localObject1	Object
    //   1	299	3	localObject2	Object
    //   301	1	3	localObject3	Object
    //   8	245	4	localSQLiteDatabase1	android.database.sqlite.SQLiteDatabase
    //   267	7	4	localObject4	Object
    //   5	183	5	localSQLiteDatabase2	android.database.sqlite.SQLiteDatabase
    //   202	29	5	localThrowable1	Throwable
    //   305	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	31	202	java/lang/Throwable
    //   26	31	267	finally
    //   41	47	301	finally
    //   61	71	301	finally
    //   108	140	301	finally
    //   149	174	301	finally
    //   211	216	301	finally
    //   221	239	301	finally
    //   41	47	305	java/lang/Throwable
    //   61	71	305	java/lang/Throwable
    //   108	140	305	java/lang/Throwable
    //   149	174	305	java/lang/Throwable
  }
  
  public static int b(Context paramContext, com.tencent.beacon.a.a.d[] paramArrayOfd)
  {
    int j = 0;
    int i;
    if (paramContext == null) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      if (paramArrayOfd == null) {
        return com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 }, -1L, 9223372036854775807L);
      }
      localArrayList = new ArrayList();
      int k = paramArrayOfd.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.a.a.d locald = paramArrayOfd[i];
        if (locald.a() >= 0L) {
          localArrayList.add(Long.valueOf(locald.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return com.tencent.beacon.a.a.a.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
  }
  
  public static com.tencent.beacon.c.d.a b(h paramh)
  {
    if ((paramh == null) || (!"DN".equals(paramh.b()))) {
      return null;
    }
    Map localMap = paramh.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.a locala = new com.tencent.beacon.c.d.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = paramh.d();
      locala.j = ((String)localMap.get("A34"));
      locala.d = Long.parseLong((String)localMap.get("A35"));
      locala.f = Long.parseLong((String)localMap.get("A36"));
      locala.g = Long.parseLong((String)localMap.get("A37"));
      locala.h = Long.parseLong((String)localMap.get("A38"));
      locala.b = ((String)localMap.get("A28"));
      locala.i = ((String)localMap.get("A39"));
      locala.e = Long.parseLong((String)localMap.get("A40"));
      locala.k = paramh.c();
      paramh = new HashMap();
      paramh.put("A33", localMap.get("A33"));
      paramh.put("A3", localMap.get("A3"));
      locala.l = a(paramh);
      return locala;
    }
    catch (Throwable paramh)
    {
      paramh.printStackTrace();
      com.tencent.beacon.d.a.d(paramh.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getVersion error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "null";
  }
  
  public static String b(Context paramContext)
  {
    String str = "null";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImei but context == null!", new Object[0]);
      return "null";
    }
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "null";
        try
        {
          com.tencent.beacon.d.a.a("IMEI:" + paramContext, new Object[0]);
          return paramContext;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject;
        Object localObject = localThrowable2;
        continue;
      }
      com.tencent.beacon.d.a.d("getImei error!", new Object[0]);
      localThrowable1.printStackTrace();
      return paramContext;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static byte[] b(int paramInt, String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return b(paramString, paramArrayOfByte);
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayInputStream localByteArrayInputStream = null;
    Object localObject = null;
    ZipInputStream localZipInputStream;
    if (paramInt == 1)
    {
      localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localZipInputStream = new ZipInputStream(localByteArrayInputStream);
      paramArrayOfByte = (byte[])localObject;
      if (localZipInputStream.getNextEntry() == null)
      {
        localZipInputStream.close();
        localByteArrayInputStream.close();
        localObject = paramArrayOfByte;
      }
    }
    do
    {
      return localObject;
      paramArrayOfByte = new byte[1024];
      localObject = new ByteArrayOutputStream();
      for (;;)
      {
        paramInt = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (paramInt == -1)
        {
          paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          ((ByteArrayOutputStream)localObject).flush();
          ((ByteArrayOutputStream)localObject).close();
          break;
        }
        ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, paramInt);
      }
      localObject = localByteArrayInputStream;
    } while (paramInt != 2);
    return a(paramArrayOfByte);
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    int j = 0;
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      paramString = null;
      return paramString;
    }
    int i = paramString.length();
    label19:
    Object localObject;
    int k;
    if (i >= 16)
    {
      paramString = paramString.substring(0, 16);
      localObject = new StringBuffer();
      k = paramArrayOfByte.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= k)
      {
        localObject = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(1, (Key)localObject, new IvParameterSpec(paramString.getBytes()));
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        localObject = new StringBuffer();
        k = paramArrayOfByte.length;
        i = j;
        for (;;)
        {
          paramString = paramArrayOfByte;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
          i += 1;
        }
        paramString = paramString + "0";
        i += 1;
        break label19;
      }
      ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
  
  public static com.tencent.beacon.c.d.d c(h paramh)
  {
    if ((paramh == null) || (!"HO".equals(paramh.b()))) {
      return null;
    }
    Map localMap = paramh.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.d.d locald = new com.tencent.beacon.c.d.d();
      locald.a = ((String)localMap.get("A19"));
      String[] arrayOfString = ((String)localMap.get("hostip")).split(":");
      locald.m = Integer.parseInt(arrayOfString[1]);
      locald.b = ((String)localMap.get("A28"));
      locald.c = ((String)localMap.get("A34"));
      locald.k = arrayOfString[0];
      locald.l = paramh.d();
      locald.d = Long.parseLong((String)localMap.get("A35"));
      locald.e = Long.parseLong((String)localMap.get("A40"));
      locald.f = Long.parseLong((String)localMap.get("A36"));
      locald.g = Long.parseLong((String)localMap.get("A37"));
      locald.h = Long.parseLong((String)localMap.get("A38"));
      locald.j = paramh.c();
      locald.i = ((String)localMap.get("A39"));
      paramh = new HashMap();
      paramh.put("A33", localMap.get("A33"));
      paramh.put("A3", localMap.get("A3"));
      locald.n = a(paramh);
      return locald;
    }
    catch (Throwable paramh)
    {
      paramh.printStackTrace();
      com.tencent.beacon.d.a.d(paramh.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getApiLevel error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "null";
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = "null";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImsi but context == null!", new Object[0]);
      return "null";
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getImsi error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  public static com.tencent.beacon.c.b.a d(h paramh)
  {
    if ((paramh == null) || (!"UA".equals(paramh.b()))) {
      return null;
    }
    Map localMap = paramh.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.c.b.a locala = new com.tencent.beacon.c.b.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = paramh.d();
      locala.h = paramh.c();
      locala.b = ((String)localMap.get("A28"));
      locala.f = Long.parseLong((String)localMap.get("A26"));
      locala.d = Boolean.parseBoolean((String)localMap.get("A25"));
      locala.e = Long.parseLong((String)localMap.get("A27"));
      if (paramh.h()) {
        localMap.put("C9", paramh.i());
      }
      if (paramh.f()) {
        localMap.put("C2", paramh.g());
      }
      locala.g = a(localMap);
      if (paramh.f()) {}
      for (int i = 1;; i = 0)
      {
        locala.i = i;
        com.tencent.beacon.d.a.b("new event record:\neventName:%s\neventResult:%b\neventValue:%s", new Object[] { locala.c, Boolean.valueOf(locala.d), locala.g });
        return locala;
      }
      return null;
    }
    catch (Throwable paramh)
    {
      paramh.printStackTrace();
      com.tencent.beacon.d.a.d(paramh.getMessage(), new Object[0]);
    }
  }
  
  public static String d()
  {
    String str = null;
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.c("getCpuProductorName error!", new Object[0]);
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "null";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getAndroidId but context == null!", new Object[0]);
      return "null";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      String str1;
      com.tencent.beacon.d.a.d("getAndroidId error!", new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        str1 = paramContext.toLowerCase();
        return str1;
      }
      catch (Throwable localThrowable2)
      {
        break label51;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label51:
    localThrowable1.printStackTrace();
    return paramContext;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = "null";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "null";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
    }
    return localObject;
  }
  
  /* Error */
  public static String f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 964	java/io/FileReader
    //   6: dup
    //   7: ldc_w 966
    //   10: invokespecial 967	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 969	java/io/BufferedReader
    //   17: dup
    //   18: aload_3
    //   19: sipush 8192
    //   22: invokespecial 972	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 975	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 977
    //   39: iconst_2
    //   40: invokevirtual 980	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 802	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 982
    //   51: ldc_w 418
    //   54: invokevirtual 985	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: invokevirtual 988	java/lang/String:trim	()Ljava/lang/String;
    //   60: invokestatic 79	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: ldc2_w 942
    //   66: ldiv
    //   67: lstore_0
    //   68: aload_2
    //   69: astore 5
    //   71: aload_3
    //   72: astore 4
    //   74: new 327	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   81: lload_0
    //   82: invokevirtual 346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 6
    //   90: aload 6
    //   92: astore 4
    //   94: aload_2
    //   95: invokevirtual 989	java/io/BufferedReader:close	()V
    //   98: aload_3
    //   99: invokevirtual 990	java/io/FileReader:close	()V
    //   102: aload 4
    //   104: areturn
    //   105: astore_2
    //   106: ldc_w 992
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_2
    //   117: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   120: aload 4
    //   122: areturn
    //   123: astore 6
    //   125: aconst_null
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_3
    //   129: aload_2
    //   130: astore 5
    //   132: aload_3
    //   133: astore 4
    //   135: ldc_w 992
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: astore 5
    //   148: aload_3
    //   149: astore 4
    //   151: aload 6
    //   153: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 989	java/io/BufferedReader:close	()V
    //   164: aload 7
    //   166: astore 4
    //   168: aload_3
    //   169: ifnull -67 -> 102
    //   172: aload_3
    //   173: invokevirtual 990	java/io/FileReader:close	()V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_2
    //   179: ldc_w 992
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_2
    //   190: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_2
    //   196: aconst_null
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_3
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 989	java/io/BufferedReader:close	()V
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 990	java/io/FileReader:close	()V
    //   219: aload_2
    //   220: athrow
    //   221: astore_3
    //   222: ldc_w 992
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 67	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_3
    //   233: invokevirtual 197	java/lang/Throwable:printStackTrace	()V
    //   236: goto -17 -> 219
    //   239: astore_2
    //   240: aconst_null
    //   241: astore 5
    //   243: goto -42 -> 201
    //   246: astore_2
    //   247: aload 4
    //   249: astore_3
    //   250: goto -49 -> 201
    //   253: astore 6
    //   255: aconst_null
    //   256: astore_2
    //   257: goto -128 -> 129
    //   260: astore 6
    //   262: goto -133 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	15	0	l	long
    //   25	70	2	localBufferedReader	java.io.BufferedReader
    //   105	12	2	localThrowable1	Throwable
    //   126	35	2	localObject1	Object
    //   178	12	2	localThrowable2	Throwable
    //   195	25	2	localObject2	Object
    //   239	1	2	localObject3	Object
    //   246	1	2	localObject4	Object
    //   256	1	2	localObject5	Object
    //   13	203	3	localFileReader	java.io.FileReader
    //   221	12	3	localThrowable3	Throwable
    //   249	1	3	localObject6	Object
    //   30	218	4	localObject7	Object
    //   27	215	5	localObject8	Object
    //   88	3	6	str	String
    //   123	29	6	localThrowable4	Throwable
    //   253	1	6	localThrowable5	Throwable
    //   260	1	6	localThrowable6	Throwable
    //   1	164	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   94	102	105	java/lang/Throwable
    //   3	14	123	java/lang/Throwable
    //   160	164	178	java/lang/Throwable
    //   172	176	178	java/lang/Throwable
    //   3	14	195	finally
    //   206	211	221	java/lang/Throwable
    //   215	219	221	java/lang/Throwable
    //   14	26	239	finally
    //   32	68	246	finally
    //   74	90	246	finally
    //   135	145	246	finally
    //   151	156	246	finally
    //   14	26	253	java/lang/Throwable
    //   32	68	260	java/lang/Throwable
    //   74	90	260	java/lang/Throwable
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return null;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
    }
    return null;
  }
  
  public static DisplayMetrics g(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics but context == null!", new Object[0]);
      return null;
    }
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String g()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getCountry error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static long h(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getFreeMem but context == null!", new Object[0]);
      return -1L;
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getFreeMem error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return -1L;
  }
  
  public static String h()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getLanguage error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String i()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getBrand error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String i(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getSensor but context == null!", new Object[0]);
      return null;
    }
    com.tencent.beacon.d.a.a("getSensor start", new Object[0]);
    Object localObject2 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i;
      try
      {
        localClass = Class.forName("android.hardware.Camera");
        j = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject2 = "N";
        }
      }
      catch (Throwable localThrowable1)
      {
        Class localClass;
        int j;
        Object localObject3;
        Object localObject6;
        Object localObject7;
        int k;
        Field localField1;
        Field localField2;
        Field localField3;
        int m;
        int n;
        localObject1 = "X";
        paramContext = "X";
        com.tencent.beacon.d.a.d("getSensor error!", new Object[0]);
        localThrowable1.printStackTrace();
        Object localObject5 = localObject1;
        localObject1 = "X";
        Context localContext = paramContext;
        continue;
        continue;
        localObject1 = "X";
        localObject2 = "X";
        continue;
      }
      try
      {
        localObject3 = (SensorManager)paramContext.getSystemService("sensor");
        if (((SensorManager)localObject3).getDefaultSensor(9) != null) {
          paramContext = "Y";
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject5 = "X";
        paramContext = (Context)localObject1;
        localObject1 = localObject5;
        continue;
      }
      try
      {
        if (((SensorManager)localObject3).getDefaultSensor(4) != null)
        {
          localObject6 = "Y";
          localObject3 = localObject1;
          localObject5 = paramContext;
          localObject1 = localObject6;
          localStringBuffer.append((String)localObject3).append((String)localObject2).append((String)localObject5).append((String)localObject1);
          return localStringBuffer.toString();
          localObject3 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject7 = ((Class)localObject3).newInstance();
          localObject6 = localClass.getMethods();
          localObject1 = null;
          k = localObject6.length;
          i = 0;
          localObject5 = localObject1;
          if (i < k)
          {
            localObject5 = localObject6[i];
            if (!((Method)localObject5).getName().equals("getCameraInfo")) {
              break label581;
            }
          }
          localField1 = ((Class)localObject3).getField("facing");
          localField2 = ((Class)localObject3).getField("CAMERA_FACING_BACK");
          localField3 = ((Class)localObject3).getField("CAMERA_FACING_FRONT");
          if (localObject5 == null) {
            continue;
          }
          localObject2 = "X";
          localObject1 = "X";
          i = 0;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        localObject4 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject4;
        localObject4 = localThrowable4;
        continue;
      }
      try
      {
        ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i), localObject7 });
        k = localField1.getInt(localObject7);
        m = localField2.getInt(localObject7);
        n = localField3.getInt(localObject7);
        if (k == m)
        {
          localObject1 = "Y";
          localObject3 = localObject1;
          if (j == 1)
          {
            localObject2 = "N";
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (k == n)
          {
            localObject6 = "Y";
            localObject2 = localObject6;
            localObject3 = localObject1;
            if (j == 1)
            {
              localObject3 = "N";
              localObject2 = localObject6;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject1;
        localObject1 = "X";
        continue;
      }
      paramContext = "N";
      continue;
      localObject5 = "N";
      localObject3 = localObject1;
      Object localObject1 = localObject5;
      localObject5 = paramContext;
      continue;
      localObject1 = "X";
      localObject2 = "X";
      String str = "X";
      Object localObject4 = "X";
      continue;
      i += 1;
      localObject1 = localObject4;
      continue;
      label581:
      i += 1;
    }
  }
  
  public static String j()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String j(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
  }
  
  public static List<com.tencent.beacon.a.a.d> k(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 }, -1, -1, 9223372036854775807L, 5, -1, -1, -1, -1, -1L, 9223372036854775807L);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    paramContext = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject).next();
      try
      {
        com.tencent.beacon.a.a.d locald = (com.tencent.beacon.a.a.d)com.tencent.beacon.a.a.d.class.cast(com.tencent.beacon.b.a.a(locala.b()));
        locald.a(locala.a());
        paramContext.add(locald);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d("netconsume error %s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static com.tencent.beacon.a.a.e l(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    com.tencent.beacon.a.a.a locala;
    com.tencent.beacon.a.a.e locale;
    do
    {
      return paramContext;
      paramContext = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 8 }, -1, -1, -1L, 1, -1, -1, -1, -1, -1L, -1L);
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        return null;
      }
      locala = (com.tencent.beacon.a.a.a)paramContext.get(0);
      if (locala == null) {
        break;
      }
      paramContext = com.tencent.beacon.b.a.a(locala.b());
      if ((paramContext == null) || (!com.tencent.beacon.a.a.e.class.isInstance(paramContext))) {
        break;
      }
      locale = (com.tencent.beacon.a.a.e)com.tencent.beacon.a.a.e.class.cast(paramContext);
      paramContext = locale;
    } while (locale == null);
    locale.e(locala.a());
    return locale;
    return null;
  }
  
  public static int m(Context paramContext)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.countRecordNum() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" countRecordNum() have null args!", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.a.a.a.b(paramContext, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e
 * JD-Core Version:    0.7.0.1
 */