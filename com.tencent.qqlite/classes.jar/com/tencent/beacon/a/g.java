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
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.a.e;
import com.tencent.beacon.event.i;
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

public class g
{
  private static g a;
  private Context b;
  
  private g(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static int a(Context paramContext, d[] paramArrayOfd)
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
        d locald = paramArrayOfd[i];
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
    //   7: ldc 84
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull +37 -> 66
    //   32: ldc 98
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_2
    //   42: ifnull +14 -> 56
    //   45: aload_2
    //   46: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   49: ifeq +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_2
    //   67: ldc 110
    //   69: aconst_null
    //   70: getstatic 116	java/util/Locale:US	Ljava/util/Locale;
    //   73: ldc 118
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc 120
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: bipush 101
    //   88: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: invokestatic 132	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 136	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +261 -> 365
    //   107: aload_3
    //   108: invokeinterface 141 1 0
    //   113: ifeq +252 -> 365
    //   116: aload_3
    //   117: ifnull +429 -> 546
    //   120: aload_3
    //   121: invokeinterface 144 1 0
    //   126: ifne +420 -> 546
    //   129: aload_3
    //   130: invokeinterface 147 1 0
    //   135: ifeq +76 -> 211
    //   138: goto +408 -> 546
    //   141: aload 4
    //   143: ifnull +222 -> 365
    //   146: ldc 149
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   159: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: invokestatic 156	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_3
    //   167: ifnull +18 -> 185
    //   170: aload_3
    //   171: invokeinterface 159 1 0
    //   176: ifne +9 -> 185
    //   179: aload_3
    //   180: invokeinterface 160 1 0
    //   185: aload_2
    //   186: ifnull +14 -> 200
    //   189: aload_2
    //   190: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   193: ifeq +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   208: aload 4
    //   210: areturn
    //   211: ldc 162
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 164	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: new 151	com/tencent/beacon/a/b/h
    //   223: dup
    //   224: invokespecial 165	com/tencent/beacon/a/b/h:<init>	()V
    //   227: astore 4
    //   229: aload 4
    //   231: aload_3
    //   232: aload_3
    //   233: ldc 167
    //   235: invokeinterface 171 2 0
    //   240: invokeinterface 175 2 0
    //   245: invokevirtual 178	com/tencent/beacon/a/b/h:a	(J)V
    //   248: aload 4
    //   250: aload_3
    //   251: aload_3
    //   252: ldc 120
    //   254: invokeinterface 171 2 0
    //   259: invokeinterface 182 2 0
    //   264: invokevirtual 184	com/tencent/beacon/a/b/h:a	(I)V
    //   267: aload 4
    //   269: aload_3
    //   270: aload_3
    //   271: ldc 186
    //   273: invokeinterface 171 2 0
    //   278: invokeinterface 190 2 0
    //   283: invokevirtual 193	com/tencent/beacon/a/b/h:a	([B)V
    //   286: goto -145 -> 141
    //   289: astore 4
    //   291: aload_3
    //   292: astore 5
    //   294: aload_0
    //   295: astore_3
    //   296: aload 5
    //   298: astore_0
    //   299: aload 4
    //   301: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   304: ldc 196
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 4
    //   314: invokevirtual 200	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_0
    //   322: ifnull +18 -> 340
    //   325: aload_0
    //   326: invokeinterface 159 1 0
    //   331: ifne +9 -> 340
    //   334: aload_0
    //   335: invokeinterface 160 1 0
    //   340: aload_2
    //   341: ifnull +14 -> 355
    //   344: aload_2
    //   345: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   348: ifeq +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   363: aconst_null
    //   364: areturn
    //   365: aload_3
    //   366: ifnull +18 -> 384
    //   369: aload_3
    //   370: invokeinterface 159 1 0
    //   375: ifne +9 -> 384
    //   378: aload_3
    //   379: invokeinterface 160 1 0
    //   384: aload_2
    //   385: ifnull +14 -> 399
    //   388: aload_2
    //   389: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   392: ifeq +7 -> 399
    //   395: aload_2
    //   396: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   399: aload_0
    //   400: ifnull -37 -> 363
    //   403: aload_0
    //   404: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   407: goto -44 -> 363
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_3
    //   413: aconst_null
    //   414: astore_0
    //   415: aload_3
    //   416: ifnull +18 -> 434
    //   419: aload_3
    //   420: invokeinterface 159 1 0
    //   425: ifne +9 -> 434
    //   428: aload_3
    //   429: invokeinterface 160 1 0
    //   434: aload 4
    //   436: ifnull +16 -> 452
    //   439: aload 4
    //   441: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   444: ifeq +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   452: aload_0
    //   453: ifnull +7 -> 460
    //   456: aload_0
    //   457: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
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
  
  public static g a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new g(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
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
    return "";
  }
  
  public static String a(Map<String, String> paramMap)
  {
    com.tencent.beacon.d.a.b("map 2 str", new Object[0]);
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    if (((Set)localObject).size() > 50) {
      com.tencent.beacon.d.a.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      int i = str2.trim().length();
      String str1;
      if ((i > 0) && (e(str2)))
      {
        str1 = str2.trim();
        localObject = str1;
        if (i > 64) {
          localObject = str1.substring(0, 64);
        }
        localStringBuffer.append("&");
        localStringBuffer.append(((String)localObject).replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        localStringBuffer.append("=");
        localObject = (String)paramMap.get(str2);
        if (localObject == null) {
          continue;
        }
        str1 = ((String)localObject).trim();
        if (!str1.contains(";")) {
          break label328;
        }
        localObject = str1;
        if (str1.length() > 10240)
        {
          localObject = str1.substring(0, 10240);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(";"));
        }
      }
      for (;;)
      {
        localStringBuffer.append(((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        break;
        com.tencent.beacon.d.a.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str2, new Object[0]);
        break;
        label328:
        localObject = str1;
        if (str1.length() > 1024) {
          localObject = str1.substring(0, 1024);
        }
      }
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static List<i> a(Context paramContext, String[] paramArrayOfString, long paramLong)
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
        if ((localObject2 != null) && (i.class.isInstance(localObject2)))
        {
          localObject2 = (i)i.class.cast(localObject2);
          ((i)localObject2).a(locala.a());
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
    //   11: ldc_w 382
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   27: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +36 -> 70
    //   37: aload 4
    //   39: astore_0
    //   40: ldc_w 384
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload 4
    //   52: ifnull -31 -> 21
    //   55: aload 4
    //   57: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   60: ifeq -39 -> 21
    //   63: aload 4
    //   65: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: ifnonnull +62 -> 133
    //   74: aload 5
    //   76: ifnull +231 -> 307
    //   79: aload 4
    //   81: astore_0
    //   82: aload 4
    //   84: ldc 110
    //   86: ldc 167
    //   88: aload 5
    //   90: invokevirtual 387	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   93: lstore_2
    //   94: lload_2
    //   95: lconst_0
    //   96: lcmp
    //   97: ifge +159 -> 256
    //   100: aload 4
    //   102: astore_0
    //   103: ldc_w 389
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload 4
    //   115: ifnull -94 -> 21
    //   118: aload 4
    //   120: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   123: ifeq -102 -> 21
    //   126: aload 4
    //   128: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload 4
    //   135: astore_0
    //   136: new 391	android/content/ContentValues
    //   139: dup
    //   140: invokespecial 392	android/content/ContentValues:<init>	()V
    //   143: astore 5
    //   145: aload 4
    //   147: astore_0
    //   148: aload_1
    //   149: invokevirtual 393	com/tencent/beacon/a/b/h:a	()J
    //   152: lconst_0
    //   153: lcmp
    //   154: iflt +20 -> 174
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: ldc 167
    //   164: aload_1
    //   165: invokevirtual 393	com/tencent/beacon/a/b/h:a	()J
    //   168: invokestatic 363	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   174: aload 4
    //   176: astore_0
    //   177: aload 5
    //   179: ldc 120
    //   181: aload_1
    //   182: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   185: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: invokevirtual 399	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   191: aload 4
    //   193: astore_0
    //   194: aload 5
    //   196: ldc 186
    //   198: aload_1
    //   199: invokevirtual 401	com/tencent/beacon/a/b/h:c	()[B
    //   202: invokevirtual 404	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   205: goto -131 -> 74
    //   208: astore_1
    //   209: aload 4
    //   211: astore_0
    //   212: ldc_w 406
    //   215: iconst_1
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_1
    //   222: invokevirtual 200	java/lang/Throwable:toString	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload 4
    //   231: astore_0
    //   232: aload_1
    //   233: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   236: aload 4
    //   238: ifnull -217 -> 21
    //   241: aload 4
    //   243: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   246: ifeq -225 -> 21
    //   249: aload 4
    //   251: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: aload 4
    //   258: astore_0
    //   259: aload_1
    //   260: lload_2
    //   261: invokevirtual 178	com/tencent/beacon/a/b/h:a	(J)V
    //   264: aload 4
    //   266: astore_0
    //   267: ldc_w 408
    //   270: iconst_1
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_1
    //   277: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   280: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: invokestatic 410	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 4
    //   289: ifnull +16 -> 305
    //   292: aload 4
    //   294: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   297: ifeq +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   305: iconst_1
    //   306: ireturn
    //   307: aload 4
    //   309: ifnull -288 -> 21
    //   312: aload 4
    //   314: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   317: ifeq -296 -> 21
    //   320: aload 4
    //   322: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: iconst_0
    //   326: ireturn
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_0
    //   330: aload_0
    //   331: ifnull +14 -> 345
    //   334: aload_0
    //   335: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   338: ifeq +7 -> 345
    //   341: aload_0
    //   342: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
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
  public static boolean a(Context paramContext, i parami)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: ldc_w 413
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnull +14 -> 27
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 415	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   24: ifnonnull +15 -> 39
    //   27: ldc_w 417
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: invokevirtual 415	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   43: ldc_w 419
    //   46: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +73 -> 122
    //   52: iconst_1
    //   53: istore_2
    //   54: new 29	com/tencent/beacon/a/a/a
    //   57: dup
    //   58: iload_2
    //   59: iload_3
    //   60: aload_1
    //   61: invokevirtual 424	com/tencent/beacon/event/i:c	()J
    //   64: aload_1
    //   65: invokestatic 27	com/tencent/beacon/b/a:a	(Ljava/lang/Object;)[B
    //   68: invokespecial 32	com/tencent/beacon/a/a/a:<init>	(IIJ[B)V
    //   71: astore 5
    //   73: aload_0
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: ifnonnull +115 -> 194
    //   82: ldc_w 426
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: iconst_0
    //   93: istore 4
    //   95: iload 4
    //   97: ifeq +12 -> 109
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 346	com/tencent/beacon/a/a/a:a	()J
    //   106: invokevirtual 347	com/tencent/beacon/event/i:a	(J)V
    //   109: ldc_w 428
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: iload 4
    //   121: ireturn
    //   122: aload_1
    //   123: invokevirtual 415	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   126: ldc_w 430
    //   129: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +10 -> 142
    //   135: iconst_2
    //   136: istore_2
    //   137: iconst_0
    //   138: istore_3
    //   139: goto -85 -> 54
    //   142: aload_1
    //   143: invokevirtual 415	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   146: ldc_w 432
    //   149: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +10 -> 162
    //   155: iconst_3
    //   156: istore_2
    //   157: iconst_0
    //   158: istore_3
    //   159: goto -105 -> 54
    //   162: aload_1
    //   163: invokevirtual 415	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   166: ldc_w 434
    //   169: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +10 -> 182
    //   175: iconst_4
    //   176: istore_2
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -125 -> 54
    //   182: ldc_w 436
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: new 19	java/util/ArrayList
    //   197: dup
    //   198: invokespecial 328	java/util/ArrayList:<init>	()V
    //   201: astore 6
    //   203: aload 6
    //   205: aload 5
    //   207: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: aload_0
    //   212: aload 6
    //   214: invokestatic 438	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;Ljava/util/List;)Z
    //   217: istore 4
    //   219: goto -124 -> 95
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   227: ldc_w 440
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 428
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: ldc_w 428
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_0
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   0	262	1	parami	i
    //   53	124	2	i	int
    //   1	178	3	j	int
    //   93	125	4	bool	boolean
    //   71	135	5	locala	com.tencent.beacon.a.a.a
    //   201	12	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   54	73	222	java/lang/Throwable
    //   82	92	222	java/lang/Throwable
    //   100	109	222	java/lang/Throwable
    //   194	219	222	java/lang/Throwable
    //   54	73	249	finally
    //   82	92	249	finally
    //   100	109	249	finally
    //   194	219	249	finally
    //   223	237	249	finally
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
  
  public static Long[] a(Context paramContext, List<i> paramList)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.insertList() start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.d.a.d(" insertList() have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      com.tencent.beacon.d.a.b(" list siez == 0 , return true!", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        i locali = (i)paramList.get(k);
        int j;
        if (locali.b().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        try
        {
          label112:
          localArrayList.add(new com.tencent.beacon.a.a.a(i, j, locali.c(), com.tencent.beacon.b.a.a(locali)));
          for (;;)
          {
            k += 1;
            break;
            if (locali.b().equals("IP"))
            {
              i = 2;
              j = 0;
              break label112;
            }
            if (locali.b().equals("DN"))
            {
              j = 0;
              i = 3;
              break label112;
            }
            if (locali.b().equals("HO"))
            {
              i = 4;
              j = 0;
              break label112;
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
    if (!com.tencent.beacon.a.a.a.a(paramContext, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramList = (com.tencent.beacon.a.a.a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramList.a());
      }
      i += 1;
    }
    return arrayOfLong;
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
    //   14: ldc_w 577
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
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
    //   42: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnonnull +50 -> 99
    //   52: aload 5
    //   54: astore_0
    //   55: aload_3
    //   56: astore_2
    //   57: aload 5
    //   59: astore 4
    //   61: ldc_w 579
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload 5
    //   73: ifnull +16 -> 89
    //   76: aload 5
    //   78: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   81: ifeq +8 -> 89
    //   84: aload 5
    //   86: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   89: aload_3
    //   90: ifnull -66 -> 24
    //   93: aload_3
    //   94: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: aload 5
    //   101: astore_0
    //   102: aload_3
    //   103: astore_2
    //   104: aload 5
    //   106: astore 4
    //   108: aload 5
    //   110: ldc 110
    //   112: ldc_w 581
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc 120
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: bipush 101
    //   128: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 584	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   135: aconst_null
    //   136: invokevirtual 588	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   139: istore_1
    //   140: aload 5
    //   142: astore_0
    //   143: aload_3
    //   144: astore_2
    //   145: aload 5
    //   147: astore 4
    //   149: ldc_w 590
    //   152: iconst_2
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: bipush 101
    //   160: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: iload_1
    //   167: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 156	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload 5
    //   176: ifnull +16 -> 192
    //   179: aload 5
    //   181: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   184: ifeq +8 -> 192
    //   187: aload 5
    //   189: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
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
    //   213: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   216: aload 4
    //   218: astore_0
    //   219: aload_3
    //   220: astore_2
    //   221: ldc_w 592
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload 5
    //   232: invokevirtual 200	java/lang/Throwable:toString	()Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload 4
    //   241: ifnull +16 -> 257
    //   244: aload 4
    //   246: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   249: ifeq +8 -> 257
    //   252: aload 4
    //   254: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   257: aload_3
    //   258: ifnull -234 -> 24
    //   261: aload_3
    //   262: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
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
    //   281: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   284: ifeq +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
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
  
  public static int b(Context paramContext, d[] paramArrayOfd)
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
        d locald = paramArrayOfd[i];
        if (locald.a() >= 0L) {
          localArrayList.add(Long.valueOf(locald.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return com.tencent.beacon.a.a.a.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
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
    return "";
  }
  
  public static String b(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImei but context == null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
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
  
  public static String b(String paramString)
  {
    String str2 = paramString.replace('|', '_').trim();
    String str1;
    if (str2.length() == 0)
    {
      com.tencent.beacon.d.a.c("eventName is invalid!! eventName length == 0!", new Object[0]);
      str1 = null;
    }
    do
    {
      return str1;
      if (!e(str2)) {
        break;
      }
      str1 = str2;
    } while (str2.length() <= 128);
    com.tencent.beacon.d.a.c("eventName is invalid!! eventName length should be less than 128! eventName:" + paramString, new Object[0]);
    return str2.substring(0, 128);
    com.tencent.beacon.d.a.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
    return null;
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
  
  public static int c(Context paramContext, d[] paramArrayOfd)
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
        d locald = paramArrayOfd[i];
        Object localObject = com.tencent.beacon.b.a.a(locald);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(7, 0, 0L, (byte[])localObject);
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
    return "";
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImsi but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if (paramContext == null) {
        return "";
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
  
  public static String c(String paramString)
  {
    String str = paramString.replace('|', '_').trim();
    if (e(str))
    {
      if (str.length() < 5) {
        com.tencent.beacon.d.a.c(" userID is invalid!! userID is too short, length < 5!", new Object[0]);
      }
      paramString = str;
      if (str.length() > 128) {
        paramString = str.substring(0, 128);
      }
      return paramString;
    }
    com.tencent.beacon.d.a.c("userID is invalid!! userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
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
    String str2 = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getAndroidId but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "";
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
        break label48;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label48:
    localThrowable1.printStackTrace();
    return paramContext;
  }
  
  public static String d(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        str1 = str2;
      }
    }
    else {
      return str1;
    }
    str1 = paramString.trim();
    int i = str1.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      j = str1.charAt(i);
    } while ((j >= 48) && (j <= 57));
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label98;
      }
      paramString = paramString.trim();
      str1 = paramString;
      if (paramString.length() <= 16) {
        break;
      }
      return paramString.substring(0, 16);
    }
    label98:
    com.tencent.beacon.d.a.c("channelID is invalid!! channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
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
    Object localObject = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (paramContext == null) {
        return "";
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
  
  public static boolean e(String paramString)
  {
    int i = paramString.length();
    boolean bool = true;
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static String g()
  {
    long l5 = 0L;
    for (;;)
    {
      try
      {
        Object localObject2 = new String[2];
        localObject2[0] = "cat";
        localObject2[1] = "/proc/stat";
        Object localObject1 = new String[2];
        localObject1[0] = "cat";
        localObject1[1] = ("/proc/" + a.a + "/stat");
        Object localObject3 = com.tencent.beacon.b.a.a((String[])localObject2);
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label826;
        }
        localObject3 = ((String)((List)localObject3).get(0)).split(" ");
        if (localObject3.length < 11) {
          break label826;
        }
        int i = Integer.valueOf(localObject3[2]).intValue();
        int j = Integer.valueOf(localObject3[3]).intValue();
        int k = Integer.valueOf(localObject3[4]).intValue();
        int m = Integer.valueOf(localObject3[5]).intValue();
        int n = Integer.valueOf(localObject3[6]).intValue();
        int i1 = Integer.valueOf(localObject3[7]).intValue();
        int i2 = Integer.valueOf(localObject3[8]).intValue();
        int i3 = Integer.valueOf(localObject3[9]).intValue();
        l1 = Integer.valueOf(localObject3[10]).intValue() + (i + j + k + m + n + i1 + i2 + i3);
        com.tencent.beacon.d.a.b("totalCpuTime1:" + l1, new Object[0]);
        localObject3 = com.tencent.beacon.b.a.a((String[])localObject1);
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label820;
        }
        localObject3 = ((String)((List)localObject3).get(0)).split(" ");
        if (localObject3.length < 18) {
          break label820;
        }
        i = Integer.valueOf(localObject3[13]).intValue();
        j = Integer.valueOf(localObject3[14]).intValue();
        k = Integer.valueOf(localObject3[15]).intValue();
        l2 = Integer.valueOf(localObject3[16]).intValue() + (i + j + k);
        com.tencent.beacon.d.a.b("proCpuTime1:" + l2, new Object[0]);
        try
        {
          Thread.sleep(500L);
          localObject2 = com.tencent.beacon.b.a.a((String[])localObject2);
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label814;
          }
          localObject2 = ((String)((List)localObject2).get(0)).split(" ");
          if (localObject2.length < 10) {
            break label814;
          }
          i = Integer.valueOf(localObject2[2]).intValue();
          j = Integer.valueOf(localObject2[3]).intValue();
          k = Integer.valueOf(localObject2[4]).intValue();
          m = Integer.valueOf(localObject2[5]).intValue();
          n = Integer.valueOf(localObject2[6]).intValue();
          i1 = Integer.valueOf(localObject2[7]).intValue();
          i2 = Integer.valueOf(localObject2[8]).intValue();
          i3 = Integer.valueOf(localObject2[9]).intValue();
          l3 = Integer.valueOf(localObject2[10]).intValue() + (i + j + k + m + n + i1 + i2 + i3);
          com.tencent.beacon.d.a.b("totalCpuTime2:" + l3, new Object[0]);
          localObject1 = com.tencent.beacon.b.a.a((String[])localObject1);
          long l4 = l5;
          if (localObject1 != null)
          {
            l4 = l5;
            if (((List)localObject1).size() > 0)
            {
              localObject1 = ((String)((List)localObject1).get(0)).split(" ");
              l4 = l5;
              if (localObject1.length >= 18)
              {
                i = Integer.valueOf(localObject1[13]).intValue();
                j = Integer.valueOf(localObject1[14]).intValue();
                k = Integer.valueOf(localObject1[15]).intValue();
                l4 = Integer.valueOf(localObject1[16]).intValue() + (i + j + k);
                com.tencent.beacon.d.a.b("proCpuTime2:" + l4, new Object[0]);
              }
            }
          }
          float f = (float)(l3 - l1);
          if (f > 0.0F) {
            return String.format("%.2f", new Object[] { Double.valueOf((float)(l4 - l2) / f) });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
        return "0";
      }
      catch (Exception localException)
      {
        return "0";
      }
      label814:
      long l3 = 0L;
      continue;
      label820:
      long l2 = 0L;
      continue;
      label826:
      long l1 = 0L;
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static DisplayMetrics h(Context paramContext)
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
  
  /* Error */
  public static String h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 839	java/io/FileReader
    //   6: dup
    //   7: ldc_w 841
    //   10: invokespecial 842	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 844	java/io/BufferedReader
    //   17: dup
    //   18: aload_3
    //   19: sipush 8192
    //   22: invokespecial 847	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 850	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 852
    //   39: iconst_2
    //   40: invokevirtual 855	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 633	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 857
    //   51: ldc 215
    //   53: invokevirtual 273	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: invokevirtual 248	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 76	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   62: ldc2_w 731
    //   65: ldiv
    //   66: lstore_0
    //   67: aload_2
    //   68: astore 5
    //   70: aload_3
    //   71: astore 4
    //   73: new 297	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 730	java/lang/StringBuilder:<init>	()V
    //   80: lload_0
    //   81: invokevirtual 735	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload 6
    //   91: astore 4
    //   93: aload_2
    //   94: invokevirtual 858	java/io/BufferedReader:close	()V
    //   97: aload_3
    //   98: invokevirtual 859	java/io/FileReader:close	()V
    //   101: aload 4
    //   103: areturn
    //   104: astore_2
    //   105: ldc_w 861
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_2
    //   116: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   119: aload 4
    //   121: areturn
    //   122: astore 6
    //   124: aconst_null
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_2
    //   129: astore 5
    //   131: aload_3
    //   132: astore 4
    //   134: ldc_w 861
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_2
    //   145: astore 5
    //   147: aload_3
    //   148: astore 4
    //   150: aload 6
    //   152: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 858	java/io/BufferedReader:close	()V
    //   163: aload 7
    //   165: astore 4
    //   167: aload_3
    //   168: ifnull -67 -> 101
    //   171: aload_3
    //   172: invokevirtual 859	java/io/FileReader:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: ldc_w 861
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_2
    //   189: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore_3
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 858	java/io/BufferedReader:close	()V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 859	java/io/FileReader:close	()V
    //   218: aload_2
    //   219: athrow
    //   220: astore_3
    //   221: ldc_w 861
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: aload_3
    //   232: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   235: goto -17 -> 218
    //   238: astore_2
    //   239: aconst_null
    //   240: astore 5
    //   242: goto -42 -> 200
    //   245: astore_2
    //   246: aload 4
    //   248: astore_3
    //   249: goto -49 -> 200
    //   252: astore 6
    //   254: aconst_null
    //   255: astore_2
    //   256: goto -128 -> 128
    //   259: astore 6
    //   261: goto -133 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	15	0	l	long
    //   25	69	2	localBufferedReader	java.io.BufferedReader
    //   104	12	2	localThrowable1	Throwable
    //   125	35	2	localObject1	Object
    //   177	12	2	localThrowable2	Throwable
    //   194	25	2	localObject2	Object
    //   238	1	2	localObject3	Object
    //   245	1	2	localObject4	Object
    //   255	1	2	localObject5	Object
    //   13	202	3	localFileReader	java.io.FileReader
    //   220	12	3	localThrowable3	Throwable
    //   248	1	3	localObject6	Object
    //   30	217	4	localObject7	Object
    //   27	214	5	localObject8	Object
    //   87	3	6	str	String
    //   122	29	6	localThrowable4	Throwable
    //   252	1	6	localThrowable5	Throwable
    //   259	1	6	localThrowable6	Throwable
    //   1	163	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   93	101	104	java/lang/Throwable
    //   3	14	122	java/lang/Throwable
    //   159	163	177	java/lang/Throwable
    //   171	175	177	java/lang/Throwable
    //   3	14	194	finally
    //   205	210	220	java/lang/Throwable
    //   214	218	220	java/lang/Throwable
    //   14	26	238	finally
    //   32	67	245	finally
    //   73	89	245	finally
    //   134	144	245	finally
    //   150	155	245	finally
    //   14	26	252	java/lang/Throwable
    //   32	67	259	java/lang/Throwable
    //   73	89	259	java/lang/Throwable
  }
  
  public static long i(Context paramContext)
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
  
  public static String j()
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
  
  public static String j(Context paramContext)
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
  
  public static String k()
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
  
  public static String k(Context paramContext)
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
  
  public static int l(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getWifiSignalLevel but context == null!", new Object[0]);
      return 0;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 5);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public static String l()
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
  
  public static String m()
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
  
  public static List<d> m(Context paramContext)
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
        d locald = (d)d.class.cast(com.tencent.beacon.b.a.a(locala.b()));
        if (locald != null)
        {
          locald.a(locala.a());
          paramContext.add(locald);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d("netconsume error %s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static List<d> n(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 7 }, -1, -1, 9223372036854775807L, 5, -1, -1, -1, -1, -1L, 9223372036854775807L);
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
        d locald = (d)d.class.cast(com.tencent.beacon.b.a.a(locala.b()));
        locald.a(locala.a());
        paramContext.add(locald);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d(" netconsume error:%s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static e o(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    com.tencent.beacon.a.a.a locala;
    e locale;
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
      if ((paramContext == null) || (!e.class.isInstance(paramContext))) {
        break;
      }
      locale = (e)e.class.cast(paramContext);
      paramContext = locale;
    } while (locale == null);
    locale.e(locala.a());
    return locale;
    return null;
  }
  
  public static int p(Context paramContext)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.countRecordNum() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" countRecordNum() have null args!", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.a.a.a.b(paramContext, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L);
  }
  
  public final String f()
  {
    if (this.b == null)
    {
      com.tencent.beacon.d.a.d("getFreeMem but context == null!", new Object[0]);
      return "";
    }
    try
    {
      localObject = (ActivityManager)this.b.getSystemService("activity");
      if (a.a == 0) {
        a.a = Process.myPid();
      }
      localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { a.a });
      if ((localObject == null) || (localObject.length != 1)) {
        break label216;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localObject[0].getTotalPrivateDirty()).append(",").append(localObject[0].dalvikPrivateDirty).append(",").append(localObject[0].nativePrivateDirty).append(",").append(localObject[0].otherPrivateDirty).append(",").append(localObject[0].getTotalPss()).append(",").append(localObject[0].dalvikPss).append(",").append(localObject[0].nativePss).append(",").append(localObject[0].otherPss);
      localObject = localStringBuffer.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.beacon.d.a.d("getFreeMem error!", new Object[0]);
        localThrowable.printStackTrace();
        String str = "";
      }
    }
    return localObject;
  }
  
  public final long i()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g
 * JD-Core Version:    0.7.0.1
 */