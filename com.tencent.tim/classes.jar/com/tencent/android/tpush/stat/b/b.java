package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.base.util.Util;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpHost;
import org.json.JSONArray;

public class b
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  private static Random d = null;
  private static Map<Long, String> e = new HashMap(10);
  private static String f = "";
  private static c g = null;
  private static String h = null;
  private static long i = -1L;
  private static int j = 0;
  private static String k = "__MTA_FIRST_ACTIVATE__";
  private static int l = -1;
  
  public static int a()
  {
    return d().nextInt(2147483647);
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      j = g(paramContext);
    }
    return j;
  }
  
  public static Long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return paramLong;
      String str;
      if (!paramString2.equalsIgnoreCase("."))
      {
        str = paramString2;
        if (!paramString2.equalsIgnoreCase("|")) {}
      }
      else
      {
        str = String.format("\\%s", new Object[] { paramString2 });
      }
      paramString2 = paramString1.split(str);
    } while (paramString2.length != paramInt2);
    try
    {
      paramString1 = Long.valueOf(0L);
      paramInt2 = 0;
      while (paramInt2 < paramString2.length)
      {
        long l1 = paramInt1;
        long l2 = paramString1.longValue();
        long l3 = Long.valueOf(paramString2[paramInt2]).longValue();
        paramInt2 += 1;
        paramString1 = Long.valueOf(l1 * (l2 + l3));
      }
      return paramString1;
    }
    catch (NumberFormatException paramString1) {}
    return paramLong;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = String.valueOf("1.2.7.3");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
    }
    return "0";
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    try
    {
      if (e.containsKey(Long.valueOf(paramLong))) {
        return (String)e.get(Long.valueOf(paramLong));
      }
      if (paramContext != null)
      {
        paramContext = f.a(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            Object localObject = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
            if (localObject != null)
            {
              localObject = CacheManager.getRegisterInfoByPkgName((String)localObject);
              if ((localObject != null) && (((RegisterEntity)localObject).accessId == paramLong))
              {
                paramContext = ((RegisterEntity)localObject).xgSDKVersion + "";
                e.put(Long.valueOf(((RegisterEntity)localObject).accessId), paramContext);
                return paramContext;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
    }
    return "0";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (com.tencent.android.tpush.stat.d.d())
    {
      if (h == null) {
        h = d(paramContext);
      }
      str = paramString;
      if (h != null) {
        str = paramString + "_" + h;
      }
    }
    return Util.getKey(str);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int m = 0;
      while (m < paramString.length)
      {
        int n = paramString[m] & 0xFF;
        if (n < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(n));
        m += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      g.b(paramString);
    }
    return "0";
  }
  
  public static JSONArray a(Throwable paramThrowable)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramThrowable != null)
    {
      localJSONArray.put(paramThrowable.toString());
      a(localJSONArray, paramThrowable.getStackTrace());
    }
    return localJSONArray;
  }
  
  public static JSONArray a(JSONArray paramJSONArray, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement != null)
    {
      int n = paramArrayOfStackTraceElement.length;
      int m = 0;
      while (m < n)
      {
        paramJSONArray.put(paramArrayOfStackTraceElement[m].toString());
        m += 1;
      }
    }
    return paramJSONArray;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    j = paramInt;
    d.b(paramContext, "mta.qq.com.difftime", paramInt);
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 279	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 281	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore 6
    //   13: new 283	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: invokespecial 284	java/io/ByteArrayOutputStream:<init>	()V
    //   20: astore 5
    //   22: new 286	java/util/zip/GZIPInputStream
    //   25: dup
    //   26: aload 6
    //   28: invokespecial 289	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_0
    //   34: sipush 1024
    //   37: newarray byte
    //   39: astore_3
    //   40: aload_2
    //   41: astore_0
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 293	java/util/zip/GZIPInputStream:read	([B)I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpeq +62 -> 112
    //   53: aload_2
    //   54: astore_0
    //   55: aload 5
    //   57: aload_3
    //   58: iconst_0
    //   59: iload_1
    //   60: invokevirtual 297	java/io/ByteArrayOutputStream:write	([BII)V
    //   63: goto -23 -> 40
    //   66: astore_3
    //   67: aload_2
    //   68: astore_0
    //   69: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   72: aload_3
    //   73: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   76: aload 6
    //   78: ifnull +8 -> 86
    //   81: aload 6
    //   83: invokevirtual 300	java/io/ByteArrayInputStream:close	()V
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 301	java/util/zip/GZIPInputStream:close	()V
    //   94: aload 4
    //   96: astore_2
    //   97: aload 5
    //   99: ifnull +11 -> 110
    //   102: aload 5
    //   104: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   107: aload 4
    //   109: astore_2
    //   110: aload_2
    //   111: areturn
    //   112: aload_2
    //   113: astore_0
    //   114: aload 5
    //   116: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: astore_3
    //   120: aload_3
    //   121: astore_0
    //   122: aload 6
    //   124: ifnull +8 -> 132
    //   127: aload 6
    //   129: invokevirtual 300	java/io/ByteArrayInputStream:close	()V
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 301	java/util/zip/GZIPInputStream:close	()V
    //   140: aload_0
    //   141: astore_2
    //   142: aload 5
    //   144: ifnull -34 -> 110
    //   147: aload 5
    //   149: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   152: aload_0
    //   153: areturn
    //   154: astore_2
    //   155: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   158: aload_2
    //   159: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   162: aload_0
    //   163: areturn
    //   164: astore_3
    //   165: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   168: aload_3
    //   169: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   172: goto -40 -> 132
    //   175: astore_2
    //   176: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   179: aload_2
    //   180: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   183: goto -43 -> 140
    //   186: astore_0
    //   187: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   190: aload_0
    //   191: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   194: goto -108 -> 86
    //   197: astore_0
    //   198: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   201: aload_0
    //   202: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   205: goto -111 -> 94
    //   208: astore_0
    //   209: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   212: aload_0
    //   213: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_0
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 300	java/io/ByteArrayInputStream:close	()V
    //   231: aload_0
    //   232: ifnull +7 -> 239
    //   235: aload_0
    //   236: invokevirtual 301	java/util/zip/GZIPInputStream:close	()V
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   249: aload_2
    //   250: athrow
    //   251: astore_3
    //   252: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   255: aload_3
    //   256: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   259: goto -28 -> 231
    //   262: astore_0
    //   263: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   266: aload_0
    //   267: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   270: goto -31 -> 239
    //   273: astore_0
    //   274: getstatic 47	com/tencent/android/tpush/stat/b/b:g	Lcom/tencent/android/tpush/stat/b/c;
    //   277: aload_0
    //   278: invokevirtual 126	com/tencent/android/tpush/stat/b/c:b	(Ljava/lang/Throwable;)V
    //   281: goto -32 -> 249
    //   284: astore_2
    //   285: goto -64 -> 221
    //   288: astore_3
    //   289: aconst_null
    //   290: astore_2
    //   291: goto -224 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramArrayOfByte	byte[]
    //   47	13	1	m	int
    //   31	111	2	localObject1	Object
    //   154	5	2	localIOException1	java.io.IOException
    //   175	5	2	localIOException2	java.io.IOException
    //   218	32	2	localObject2	Object
    //   284	1	2	localObject3	Object
    //   290	1	2	localObject4	Object
    //   39	19	3	arrayOfByte1	byte[]
    //   66	7	3	localThrowable1	Throwable
    //   119	2	3	arrayOfByte2	byte[]
    //   164	5	3	localIOException3	java.io.IOException
    //   251	5	3	localIOException4	java.io.IOException
    //   288	1	3	localThrowable2	Throwable
    //   1	107	4	localObject5	Object
    //   20	225	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   11	216	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   34	40	66	java/lang/Throwable
    //   42	48	66	java/lang/Throwable
    //   55	63	66	java/lang/Throwable
    //   114	120	66	java/lang/Throwable
    //   147	152	154	java/io/IOException
    //   127	132	164	java/io/IOException
    //   136	140	175	java/io/IOException
    //   81	86	186	java/io/IOException
    //   90	94	197	java/io/IOException
    //   102	107	208	java/io/IOException
    //   22	32	218	finally
    //   226	231	251	java/io/IOException
    //   235	239	262	java/io/IOException
    //   244	249	273	java/io/IOException
    //   34	40	284	finally
    //   42	48	284	finally
    //   55	63	284	finally
    //   69	76	284	finally
    //   114	120	284	finally
    //   22	32	288	java/lang/Throwable
  }
  
  public static long b(String paramString)
  {
    return a(paramString, ".", 100, 3, Long.valueOf(0L)).longValue();
  }
  
  public static c b()
  {
    try
    {
      if (g == null)
      {
        g = new c("XgStat");
        g.a(true);
      }
      c localc = g;
      return localc;
    }
    finally {}
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    return com.tencent.android.tpush.service.util.c.a(paramContext).a(paramLong);
  }
  
  public static HttpHost b(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
        return null;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return null;
      }
      if ((paramContext.getTypeName() != null) && (paramContext.getTypeName().equalsIgnoreCase("WIFI"))) {
        return null;
      }
      if (paramContext.getExtraInfo() == null) {
        return null;
      }
      paramContext = Proxy.getDefaultHost();
      if ((paramContext != null) && (paramContext.trim().length() > 0))
      {
        paramContext = new HttpHost(paramContext, Proxy.getDefaultPort());
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
    }
    return null;
  }
  
  public static long c()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      return l1 + 86400000L;
    }
    catch (Throwable localThrowable)
    {
      g.b(localThrowable);
    }
    return System.currentTimeMillis() + 86400000L;
  }
  
  public static String c(Context paramContext)
  {
    if (c(f)) {
      return f;
    }
    try
    {
      f = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if ((f == null) || (f.length() == 0)) {
        return "unknown";
      }
    }
    catch (Throwable paramContext)
    {
      g.b(paramContext);
    }
    return f;
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static String d(Context paramContext)
  {
    return Util.getCurProcessName(paramContext);
  }
  
  private static Random d()
  {
    try
    {
      if (d == null) {
        d = new Random();
      }
      Random localRandom = d;
      return localRandom;
    }
    finally {}
  }
  
  public static boolean e(Context paramContext)
  {
    if (i < 0L) {
      i = d.a(paramContext, "mta.qq.com.checktime", 0L);
    }
    return Math.abs(System.currentTimeMillis() - i) > 86400000L;
  }
  
  public static void f(Context paramContext)
  {
    i = System.currentTimeMillis();
    d.b(paramContext, "mta.qq.com.checktime", i);
  }
  
  public static int g(Context paramContext)
  {
    return d.a(paramContext, "mta.qq.com.difftime", 0);
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getClass().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.b
 * JD-Core Version:    0.7.0.1
 */