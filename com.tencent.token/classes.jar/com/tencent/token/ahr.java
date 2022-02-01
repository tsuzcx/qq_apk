package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.qps.Ginkgo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ahr
{
  public static Context a;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return paramInt1 | i << paramInt2;
    }
  }
  
  public static int a(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Object localObject = null;
    try
    {
      paramContext = paramContext.registerReceiver(null, localIntentFilter);
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return 1;
      }
      i = paramContext.getIntExtra("plugged", -1);
      if (i == 2) {
        return 3;
      }
      if (i == 1) {
        return 2;
      }
      return 0;
    }
    finally
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static int a(SparseArray<Object> paramSparseArray)
  {
    paramSparseArray = (Integer)a(paramSparseArray, 0, Integer.class);
    if (paramSparseArray == null) {
      return -1;
    }
    return paramSparseArray.intValue();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt, char paramChar)
  {
    paramInt -= 1;
    int i;
    for (;;)
    {
      i = paramInt + 1;
      if (paramInt >= paramArrayOfByte.length) {
        break label36;
      }
      if (i == paramArrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] == paramChar) {
        return i;
      }
      paramInt = i;
    }
    return i;
    label36:
    return 0;
  }
  
  /* Error */
  public static com.tencent.turingfd.sdk.qps.Orion a(com.tencent.turingfd.sdk.qps.Orion paramOrion, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +295 -> 296
    //   4: aload_1
    //   5: arraylength
    //   6: ifeq +290 -> 296
    //   9: aload_1
    //   10: invokestatic 55	com/tencent/token/ahr:c	()[B
    //   13: invokestatic 59	com/tencent/token/ahr:b	([B[B)[B
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +276 -> 294
    //   21: aload_1
    //   22: arraylength
    //   23: ifeq +271 -> 294
    //   26: new 61	java/io/ByteArrayInputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 64	java/io/ByteArrayInputStream:<init>	([B)V
    //   34: astore_3
    //   35: new 66	java/util/zip/InflaterInputStream
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 69	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore 4
    //   45: new 71	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 74	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 5
    //   54: aload 4
    //   56: invokevirtual 77	java/util/zip/InflaterInputStream:read	()I
    //   59: istore_2
    //   60: iload_2
    //   61: iconst_m1
    //   62: if_icmpeq +12 -> 74
    //   65: aload 5
    //   67: iload_2
    //   68: invokevirtual 81	java/io/ByteArrayOutputStream:write	(I)V
    //   71: goto -17 -> 54
    //   74: aload 5
    //   76: invokevirtual 84	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   84: aload 4
    //   86: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   89: aload 5
    //   91: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   94: goto +60 -> 154
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   102: goto +52 -> 154
    //   105: astore_0
    //   106: aload_3
    //   107: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   110: aload 4
    //   112: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   115: aload 5
    //   117: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   120: goto +8 -> 128
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_3
    //   133: invokevirtual 87	java/io/ByteArrayInputStream:close	()V
    //   136: aload 4
    //   138: invokevirtual 88	java/util/zip/InflaterInputStream:close	()V
    //   141: aload 5
    //   143: invokevirtual 89	java/io/ByteArrayOutputStream:close	()V
    //   146: goto +8 -> 154
    //   149: astore_3
    //   150: aload_3
    //   151: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: ifnull +137 -> 292
    //   158: aload_1
    //   159: arraylength
    //   160: ifeq +132 -> 292
    //   163: new 94	com/tencent/token/adg
    //   166: dup
    //   167: invokespecial 95	com/tencent/token/adg:<init>	()V
    //   170: astore_3
    //   171: aload_1
    //   172: arraylength
    //   173: iconst_4
    //   174: if_icmplt +108 -> 282
    //   177: new 97	com/tencent/token/afb
    //   180: dup
    //   181: aload_1
    //   182: iconst_0
    //   183: invokespecial 100	com/tencent/token/afb:<init>	([BB)V
    //   186: astore_1
    //   187: aload_1
    //   188: ldc 102
    //   190: putfield 105	com/tencent/token/afb:b	Ljava/lang/String;
    //   193: aload_3
    //   194: getfield 108	com/tencent/token/adg:b	Lcom/tencent/turingfd/sdk/qps/Leo;
    //   197: aload_1
    //   198: invokevirtual 113	com/tencent/turingfd/sdk/qps/Leo:a	(Lcom/tencent/token/afb;)V
    //   201: aload_1
    //   202: aload_3
    //   203: getfield 108	com/tencent/token/adg:b	Lcom/tencent/turingfd/sdk/qps/Leo;
    //   206: getfield 117	com/tencent/turingfd/sdk/qps/Leo:j	[B
    //   209: invokestatic 123	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   212: putfield 126	com/tencent/token/afb:a	Ljava/nio/ByteBuffer;
    //   215: getstatic 129	com/tencent/token/adg:a	Ljava/util/HashMap;
    //   218: ifnonnull +28 -> 246
    //   221: new 131	java/util/HashMap
    //   224: dup
    //   225: invokespecial 132	java/util/HashMap:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: putstatic 129	com/tencent/token/adg:a	Ljava/util/HashMap;
    //   235: aload 4
    //   237: ldc 134
    //   239: iconst_0
    //   240: newarray byte
    //   242: invokevirtual 138	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: aload_3
    //   247: aload_1
    //   248: getstatic 129	com/tencent/token/adg:a	Ljava/util/HashMap;
    //   251: iconst_0
    //   252: iconst_0
    //   253: invokevirtual 141	com/tencent/token/afb:a	(Ljava/util/Map;IZ)Ljava/util/HashMap;
    //   256: putfield 143	com/tencent/token/adg:c	Ljava/util/HashMap;
    //   259: aload_3
    //   260: ldc 145
    //   262: aload_0
    //   263: invokevirtual 148	com/tencent/token/adg:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: checkcast 150	com/tencent/turingfd/sdk/qps/Orion
    //   269: astore_1
    //   270: aload_1
    //   271: areturn
    //   272: astore_0
    //   273: new 152	java/lang/RuntimeException
    //   276: dup
    //   277: aload_0
    //   278: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   281: athrow
    //   282: new 157	java/lang/IllegalArgumentException
    //   285: dup
    //   286: ldc 159
    //   288: invokespecial 160	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    //   292: aload_0
    //   293: areturn
    //   294: aload_0
    //   295: areturn
    //   296: aload_0
    //   297: areturn
    //   298: astore_1
    //   299: goto -169 -> 130
    //   302: astore_1
    //   303: aload_0
    //   304: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramOrion	com.tencent.turingfd.sdk.qps.Orion
    //   0	305	1	paramArrayOfByte	byte[]
    //   59	9	2	i	int
    //   34	47	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   97	36	3	localIOException1	IOException
    //   149	2	3	localIOException2	IOException
    //   170	90	3	localadg	adg
    //   43	193	4	localObject	Object
    //   52	90	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	94	97	java/io/IOException
    //   54	60	105	finally
    //   65	71	105	finally
    //   74	80	105	finally
    //   106	120	123	java/io/IOException
    //   132	146	149	java/io/IOException
    //   177	187	272	java/lang/Exception
    //   187	235	272	java/lang/Exception
    //   235	246	272	java/lang/Exception
    //   246	259	272	java/lang/Exception
    //   54	60	298	java/lang/Exception
    //   65	71	298	java/lang/Exception
    //   74	80	298	java/lang/Exception
    //   259	270	302	finally
  }
  
  public static <E> E a(SparseArray<Object> paramSparseArray, int paramInt, Class<E> paramClass)
  {
    if (paramSparseArray == null) {
      return null;
    }
    paramSparseArray = paramSparseArray.get(paramInt);
    if (paramClass.isInstance(paramSparseArray)) {
      return paramClass.cast(paramSparseArray);
    }
    return null;
  }
  
  public static <T> T a(T paramT)
  {
    paramT.getClass();
    return paramT;
  }
  
  private static String a(int paramInt)
  {
    String str = "";
    try
    {
      Object localObject3 = Locale.ENGLISH;
      Object localObject2 = acy.a(String.format((Locale)localObject3, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject2 != null) {
        str = new String((byte[])localObject2, 0, a((byte[])localObject2, 0, '\000'));
      }
      boolean bool = TextUtils.isEmpty(str);
      localObject2 = str;
      if (bool)
      {
        localObject3 = acy.a(String.format((Locale)localObject3, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject2 = str;
        if (localObject3 != null)
        {
          paramInt = a((byte[])localObject3, 7, '\n');
          if (paramInt == 0) {
            return "";
          }
          localObject2 = new String((byte[])localObject3, 6, paramInt - 6);
        }
      }
      return localObject2;
    }
    finally
    {
      localObject1.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 227	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: invokevirtual 231	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 237	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 242	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   30: astore_0
    //   31: goto +5 -> 36
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +5 -> 42
    //   40: aload_0
    //   41: areturn
    //   42: new 244	java/util/zip/ZipFile
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 245	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: ldc 247
    //   55: invokevirtual 251	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   58: invokevirtual 255	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 257	com/tencent/token/acq
    //   65: dup
    //   66: invokespecial 258	com/tencent/token/acq:<init>	()V
    //   69: aload_1
    //   70: invokevirtual 261	com/tencent/token/acq:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   73: invokeinterface 267 1 0
    //   78: iconst_0
    //   79: invokeinterface 273 2 0
    //   84: invokeinterface 279 1 0
    //   89: ldc_w 281
    //   92: invokeinterface 287 2 0
    //   97: invokeinterface 291 1 0
    //   102: astore 4
    //   104: aload_1
    //   105: invokestatic 294	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   108: aload 4
    //   110: astore_1
    //   111: invokestatic 298	com/tencent/token/acx:a	()I
    //   114: istore_2
    //   115: aload_3
    //   116: astore 6
    //   118: aload 4
    //   120: astore 5
    //   122: iload_2
    //   123: bipush 19
    //   125: if_icmplt +45 -> 170
    //   128: aload 4
    //   130: astore_0
    //   131: goto +31 -> 162
    //   134: goto +8 -> 142
    //   137: aconst_null
    //   138: astore_3
    //   139: aload 4
    //   141: astore_1
    //   142: aload_1
    //   143: invokestatic 294	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   146: aload_3
    //   147: astore 6
    //   149: aload_0
    //   150: astore 5
    //   152: aload_0
    //   153: astore_1
    //   154: invokestatic 298	com/tencent/token/acx:a	()I
    //   157: bipush 19
    //   159: if_icmplt +11 -> 170
    //   162: aload_0
    //   163: astore_1
    //   164: aload_3
    //   165: invokestatic 294	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   168: aload_0
    //   169: areturn
    //   170: aload 5
    //   172: astore_1
    //   173: aload 6
    //   175: invokevirtual 299	java/util/zip/ZipFile:close	()V
    //   178: aload 5
    //   180: areturn
    //   181: astore_0
    //   182: goto -148 -> 34
    //   185: astore_1
    //   186: goto -49 -> 137
    //   189: astore_1
    //   190: aload 4
    //   192: astore_1
    //   193: goto -51 -> 142
    //   196: astore 4
    //   198: goto -64 -> 134
    //   201: astore_0
    //   202: aload_1
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramContext	Context
    //   0	204	1	paramString	String
    //   114	12	2	i	int
    //   50	115	3	localZipFile1	java.util.zip.ZipFile
    //   1	190	4	str	String
    //   196	1	4	localObject1	Object
    //   120	59	5	localObject2	Object
    //   116	58	6	localZipFile2	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   3	11	181	finally
    //   15	22	181	finally
    //   26	31	181	finally
    //   42	51	185	finally
    //   51	62	189	finally
    //   62	104	196	finally
    //   111	115	201	finally
    //   154	162	201	finally
    //   164	168	201	finally
    //   173	178	201	finally
  }
  
  public static String a(String paramString)
  {
    paramString = paramString.getBytes();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(b("4D4435")));
      localMessageDigest.update(paramString);
      paramString = localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label35:
      break label35;
    }
    paramString = null;
    return b(paramString);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    int i = paramString1.indexOf('/');
    if (i == -1) {
      return null;
    }
    String str = paramString1.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return null;
    }
    paramString1 = new StringBuilder("/data/data/");
    paramString1.append(paramString2);
    paramString1.append("/");
    paramString1 = paramString1.toString();
    if (str.startsWith(paramString1)) {
      return null;
    }
    if (str.startsWith("/data/app/".concat(String.valueOf(paramString2)))) {
      return null;
    }
    if (Pattern.compile("^/data/user/\\d+/".concat(String.valueOf(paramString2))).matcher(str).find()) {
      return null;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return null;
    }
    if (bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("lib");
      paramString1 = new File(paramString2.toString());
    }
    try
    {
      paramString1 = paramString1.getCanonicalPath();
    }
    catch (IOException paramString1)
    {
      label217:
      break label217;
    }
    paramString1 = null;
    if ((paramString1 == null) || (str.startsWith(paramString1))) {
      return null;
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      str = paramString3.replace(paramString1, paramString2);
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(b("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label30:
      break label30;
    }
    paramArrayOfByte = null;
    return b(paramArrayOfByte);
  }
  
  public static DateFormat a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MMM d, yyyy");
    localStringBuilder.append(" ");
    localStringBuilder.append("h:mm:ss a");
    return new SimpleDateFormat(localStringBuilder.toString(), Locale.US);
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int k = paramArrayOfByte.length;
    int i = 0;
    int m;
    for (int j = 0; i < k >> 2; j = m + 1)
    {
      m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
    }
    if (j < paramArrayOfByte.length)
    {
      k = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      j = 8;
      while (k < paramArrayOfByte.length)
      {
        paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
        k += 1;
        j += 8;
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length >> 2;
    int j = i;
    if (i > paramInt) {
      j = paramInt;
    }
    i = 0;
    int k = 0;
    int m;
    for (;;)
    {
      m = 8;
      if (i >= j) {
        break;
      }
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 8 & 0xFF));
      m = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] >>> 16 & 0xFF));
      k = m + 1;
      paramArrayOfByte[m] = ((byte)(paramArrayOfInt[i] >>> 24 & 0xFF));
      i += 1;
    }
    if ((paramInt > j) && (k < paramArrayOfByte.length))
    {
      paramInt = k + 1;
      paramArrayOfByte[k] = ((byte)(paramArrayOfInt[i] & 0xFF));
      j = m;
      while ((j <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> j & 0xFF));
        j += 8;
        paramInt += 1;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = c(paramArrayOfByte2);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        paramArrayOfByte2 = paramArrayOfByte1;
        if (paramArrayOfByte1.length != 0)
        {
          int j;
          if (paramArrayOfByte1.length % 4 == 0) {
            j = (paramArrayOfByte1.length >>> 2) + 1;
          } else {
            j = (paramArrayOfByte1.length >>> 2) + 2;
          }
          int[] arrayOfInt = new int[j];
          a(paramArrayOfByte1, arrayOfInt);
          int i2 = j - 1;
          arrayOfInt[i2] = paramArrayOfByte1.length;
          if (arrayOfByte.length % 4 == 0) {
            i = arrayOfByte.length >>> 2;
          } else {
            i = (arrayOfByte.length >>> 2) + 1;
          }
          int k = i;
          if (i < 4) {
            k = 4;
          }
          paramArrayOfByte1 = new int[k];
          int i = 0;
          while (i < k)
          {
            paramArrayOfByte1[i] = 0;
            i += 1;
          }
          a(arrayOfByte, paramArrayOfByte1);
          i = arrayOfInt[i2];
          k = 52 / (i2 + 1) + 6;
          int n;
          for (int m = 0; k > 0; m = n)
          {
            n = m - 1640531527;
            int i3 = n >>> 2 & 0x3;
            m = i;
            for (i = 0; i < i2; i = i1)
            {
              i1 = i + 1;
              i4 = arrayOfInt[i1];
              int i5 = arrayOfInt[i];
              m = ((m >>> 5 ^ i4 << 2) + (i4 >>> 3 ^ m << 4) ^ (i4 ^ n) + (m ^ paramArrayOfByte1[(i & 0x3 ^ i3)])) + i5;
              arrayOfInt[i] = m;
            }
            int i1 = arrayOfInt[0];
            int i4 = arrayOfInt[i2];
            i = ((m >>> 5 ^ i1 << 2) + (i1 >>> 3 ^ m << 4) ^ (i1 ^ n) + (paramArrayOfByte1[(i & 0x3 ^ i3)] ^ m)) + i4;
            arrayOfInt[i2] = i;
            k -= 1;
          }
          paramArrayOfByte2 = new byte[j << 2];
          a(arrayOfInt, j, paramArrayOfByte2);
        }
      }
    }
    return paramArrayOfByte2;
  }
  
  /* Error */
  public static int b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 440	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: iload_2
    //   7: bipush 24
    //   9: if_icmplt +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 395	java/io/File
    //   17: dup
    //   18: getstatic 446	com/tencent/token/afz:an	[I
    //   21: invokestatic 449	com/tencent/token/afz:a	([I)Ljava/lang/String;
    //   24: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_3
    //   28: ldc 134
    //   30: astore 4
    //   32: new 451	java/io/BufferedReader
    //   35: dup
    //   36: new 453	java/io/FileReader
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 456	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   44: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 5
    //   49: aload 5
    //   51: invokevirtual 462	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: goto +19 -> 74
    //   58: aconst_null
    //   59: astore_3
    //   60: aload 4
    //   62: astore 5
    //   64: aload_3
    //   65: ifnull +17 -> 82
    //   68: aload_3
    //   69: astore 5
    //   71: aload 4
    //   73: astore_3
    //   74: aload 5
    //   76: invokestatic 463	com/tencent/token/acy:a	(Ljava/io/Closeable;)V
    //   79: aload_3
    //   80: astore 5
    //   82: aload 5
    //   84: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +5 -> 92
    //   90: iconst_0
    //   91: ireturn
    //   92: ldc_w 465
    //   95: aload 5
    //   97: invokevirtual 468	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq +32 -> 132
    //   103: aload_0
    //   104: invokevirtual 472	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   107: ldc_w 474
    //   110: iconst_0
    //   111: invokestatic 480	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   114: istore_2
    //   115: iload_2
    //   116: ifle +8 -> 124
    //   119: iconst_1
    //   120: istore_1
    //   121: goto +3 -> 124
    //   124: iload_1
    //   125: ifeq +5 -> 130
    //   128: iconst_1
    //   129: ireturn
    //   130: iconst_3
    //   131: ireturn
    //   132: ldc_w 482
    //   135: aload 5
    //   137: invokevirtual 468	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifeq +5 -> 145
    //   143: iconst_2
    //   144: ireturn
    //   145: ldc_w 484
    //   148: aload 5
    //   150: invokevirtual 468	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifeq +5 -> 158
    //   156: iconst_3
    //   157: ireturn
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_3
    //   161: goto -103 -> 58
    //   164: astore_3
    //   165: aload 5
    //   167: astore_3
    //   168: goto -108 -> 60
    //   171: astore_0
    //   172: goto -48 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramContext	Context
    //   5	120	1	i	int
    //   3	113	2	j	int
    //   27	53	3	localObject1	Object
    //   160	1	3	localObject2	Object
    //   164	1	3	localObject3	Object
    //   167	1	3	localObject4	Object
    //   30	42	4	str	String
    //   47	119	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   32	49	160	finally
    //   49	55	164	finally
    //   103	115	171	finally
  }
  
  public static Context b()
  {
    try
    {
      Context localContext = a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private static adf b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iload_0
    //   4: invokestatic 489	com/tencent/token/ahr:a	(I)Ljava/lang/String;
    //   7: astore 5
    //   9: iload_0
    //   10: iconst_m1
    //   11: if_icmpeq +41 -> 52
    //   14: getstatic 189	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   17: astore 6
    //   19: new 197	java/lang/String
    //   22: dup
    //   23: aload 6
    //   25: ldc 219
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_0
    //   34: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: invokestatic 201	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 490	com/tencent/token/acy:b	(Ljava/lang/String;)[B
    //   44: invokespecial 311	java/lang/String:<init>	([B)V
    //   47: astore 6
    //   49: goto +32 -> 81
    //   52: getstatic 189	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   55: astore 6
    //   57: new 197	java/lang/String
    //   60: dup
    //   61: aload 6
    //   63: ldc_w 492
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 201	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokestatic 490	com/tencent/token/acy:b	(Ljava/lang/String;)[B
    //   76: invokespecial 311	java/lang/String:<init>	([B)V
    //   79: astore 6
    //   81: new 131	java/util/HashMap
    //   84: dup
    //   85: invokespecial 132	java/util/HashMap:<init>	()V
    //   88: astore 8
    //   90: aload 6
    //   92: ldc_w 494
    //   95: invokevirtual 498	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   98: astore 6
    //   100: aload 6
    //   102: arraylength
    //   103: istore_2
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: iload_2
    //   108: if_icmpge +45 -> 153
    //   111: aload 6
    //   113: iload_1
    //   114: aaload
    //   115: ldc_w 500
    //   118: invokevirtual 498	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   121: astore 9
    //   123: aload 9
    //   125: arraylength
    //   126: iconst_2
    //   127: if_icmplt +171 -> 298
    //   130: aload 8
    //   132: aload 9
    //   134: iconst_0
    //   135: aaload
    //   136: invokevirtual 337	java/lang/String:trim	()Ljava/lang/String;
    //   139: aload 9
    //   141: iconst_1
    //   142: aaload
    //   143: invokevirtual 337	java/lang/String:trim	()Ljava/lang/String;
    //   146: invokevirtual 138	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: goto +148 -> 298
    //   153: aload 8
    //   155: ldc_w 502
    //   158: invokevirtual 504	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 197	java/lang/String
    //   164: invokestatic 508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: istore_1
    //   168: aload 8
    //   170: ldc_w 510
    //   173: invokevirtual 504	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 197	java/lang/String
    //   179: ldc_w 512
    //   182: invokevirtual 498	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   185: iconst_0
    //   186: aaload
    //   187: invokestatic 508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   190: istore_3
    //   191: aload 8
    //   193: ldc_w 514
    //   196: invokevirtual 504	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 197	java/lang/String
    //   202: invokestatic 508	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: istore_2
    //   206: iload_2
    //   207: istore 4
    //   209: goto +17 -> 226
    //   212: aconst_null
    //   213: astore 5
    //   215: iconst_m1
    //   216: istore_2
    //   217: iconst_m1
    //   218: istore_1
    //   219: iconst_m1
    //   220: istore 4
    //   222: iload_1
    //   223: istore_3
    //   224: iload_2
    //   225: istore_1
    //   226: aload 7
    //   228: astore 6
    //   230: aload 5
    //   232: ifnull +37 -> 269
    //   235: aload 7
    //   237: astore 6
    //   239: iload_1
    //   240: iconst_m1
    //   241: if_icmpeq +28 -> 269
    //   244: aload 7
    //   246: astore 6
    //   248: iload_3
    //   249: iconst_m1
    //   250: if_icmpeq +19 -> 269
    //   253: new 516	com/tencent/token/adf
    //   256: dup
    //   257: iload_0
    //   258: iload_1
    //   259: aload 5
    //   261: iload_3
    //   262: iload 4
    //   264: invokespecial 519	com/tencent/token/adf:<init>	(IILjava/lang/String;II)V
    //   267: astore 6
    //   269: aload 6
    //   271: areturn
    //   272: astore 5
    //   274: goto -62 -> 212
    //   277: astore 6
    //   279: goto -64 -> 215
    //   282: astore 6
    //   284: iload_1
    //   285: istore_2
    //   286: goto -69 -> 217
    //   289: astore 6
    //   291: iload_1
    //   292: istore_2
    //   293: iload_3
    //   294: istore_1
    //   295: goto -76 -> 219
    //   298: iload_1
    //   299: iconst_1
    //   300: iadd
    //   301: istore_1
    //   302: goto -196 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramInt	int
    //   105	197	1	i	int
    //   103	190	2	j	int
    //   190	104	3	k	int
    //   207	56	4	m	int
    //   7	253	5	str	String
    //   272	1	5	localObject1	Object
    //   17	253	6	localObject2	Object
    //   277	1	6	localObject3	Object
    //   282	1	6	localObject4	Object
    //   289	1	6	localObject5	Object
    //   1	244	7	localObject6	Object
    //   88	104	8	localHashMap	java.util.HashMap
    //   121	19	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	9	272	finally
    //   14	19	277	finally
    //   19	49	277	finally
    //   52	57	277	finally
    //   57	81	277	finally
    //   81	104	277	finally
    //   111	150	277	finally
    //   153	168	277	finally
    //   168	191	282	finally
    //   191	206	289	finally
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase(Locale.getDefault()));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] b(SparseArray<Object> paramSparseArray)
  {
    byte[] arrayOfByte = (byte[])a(paramSparseArray, 1, [B.class);
    paramSparseArray = arrayOfByte;
    if (arrayOfByte == null) {
      paramSparseArray = new byte[0];
    }
    return paramSparseArray;
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[i] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = c(paramArrayOfByte2);
    if ((arrayOfByte != null) && (paramArrayOfByte1.length != 0))
    {
      if ((paramArrayOfByte1.length % 4 == 0) && (paramArrayOfByte1.length >= 8))
      {
        int k = paramArrayOfByte1.length >>> 2;
        paramArrayOfByte2 = new int[k];
        a(paramArrayOfByte1, paramArrayOfByte2);
        if (arrayOfByte.length % 4 == 0) {
          i = arrayOfByte.length >>> 2;
        } else {
          i = (arrayOfByte.length >>> 2) + 1;
        }
        int j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte1 = new int[j];
        int i = 0;
        while (i < j)
        {
          paramArrayOfByte1[i] = 0;
          i += 1;
        }
        a(arrayOfByte, paramArrayOfByte1);
        int m = k - 1;
        i = paramArrayOfByte2[0];
        j = (52 / (m + 1) + 6) * -1640531527;
        while (j != 0)
        {
          int n = j >>> 2 & 0x3;
          k = i;
          i = m;
          while (i > 0)
          {
            i1 = paramArrayOfByte2[(i - 1)];
            k = paramArrayOfByte2[i] - ((k ^ j) + (i1 ^ paramArrayOfByte1[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
            paramArrayOfByte2[i] = k;
            i -= 1;
          }
          int i1 = paramArrayOfByte2[m];
          i = paramArrayOfByte2[0] - ((i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4) ^ (k ^ j) + (paramArrayOfByte1[(i & 0x3 ^ n)] ^ i1));
          paramArrayOfByte2[0] = i;
          j += 1640531527;
        }
        i = paramArrayOfByte2[m];
        if ((i >= 0) && (i <= m << 2))
        {
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, m, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = aci.a;
    localObject = new ArrayList();
    String str = paramContext.getPackageName();
    if (!TextUtils.isEmpty(str))
    {
      paramContext = ade.a(paramContext, str);
      Ginkgo localGinkgo = new Ginkgo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(agm.a);
      localStringBuilder.append(agm.b);
      localGinkgo.a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext);
      localGinkgo.b = localStringBuilder.toString();
      ((ArrayList)localObject).add(localGinkgo);
    }
    if (((ArrayList)localObject).size() != 0) {
      return ((Ginkgo)((ArrayList)localObject).get(0)).b;
    }
    return "";
  }
  
  public static byte[] c()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = afz.a(afz.aD);
      int i = 0;
      while (i < str.length())
      {
        ((StringBuffer)localObject).append((char)(str.charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte.length <= 16) {}
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      return paramArrayOfByte;
    }
    finally
    {
      label34:
      break label34;
    }
    localObject = null;
    return localObject;
  }
  
  public static int d(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i >= 17 ? Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    i = a(0, bool1, 0);
    boolean bool1 = bool2;
    if (Settings.Secure.getInt(paramContext.getContentResolver(), "development_settings_enabled", 0) > 0) {
      bool1 = true;
    }
    return a(i, bool1, 1);
  }
  
  public static String d()
  {
    Iterator localIterator = ((ArrayList)ach.a()).iterator();
    while (localIterator.hasNext())
    {
      Ginkgo localGinkgo = (Ginkgo)localIterator.next();
      if (localGinkgo.a.contains(agm.c)) {
        return localGinkgo.b;
      }
    }
    return "";
  }
  
  public static String e()
  {
    Iterator localIterator = ((ArrayList)ach.a()).iterator();
    while (localIterator.hasNext())
    {
      Ginkgo localGinkgo = (Ginkgo)localIterator.next();
      if (localGinkgo.a.contains(agm.d)) {
        return localGinkgo.b;
      }
    }
    return "";
  }
  
  public static boolean e(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 14) {
      return (!TextUtils.isEmpty(Proxy.getHost(paramContext))) && (Proxy.getPort(paramContext) != -1);
    }
    if ((!TextUtils.isEmpty(System.getProperty("http.proxyHost"))) && (!TextUtils.equals(System.getProperty("http.proxyPort"), "-1"))) {
      return true;
    }
    Object localObject2 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) {
      return false;
    }
    try
    {
      localObject1 = ((WifiManager)localObject2).getConnectionInfo();
      if ((localObject1 == null) || (((WifiInfo)localObject1).getNetworkId() == -1)) {}
    }
    finally
    {
      Object localObject1;
      label118:
      return false;
    }
    try
    {
      paramContext = ((WifiManager)localObject2).getConfiguredNetworks();
    }
    finally
    {
      break label118;
    }
    paramContext = null;
    if (paramContext == null) {
      return false;
    }
    localObject1 = ((WifiInfo)localObject1).getSSID();
    localObject2 = paramContext.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramContext = (WifiConfiguration)((Iterator)localObject2).next();
      if (!TextUtils.equals(paramContext.SSID, (CharSequence)localObject1))
      {
        String str = paramContext.SSID;
        StringBuilder localStringBuilder = new StringBuilder("\"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\"");
        if (!TextUtils.equals(str, localStringBuilder.toString())) {
          break;
        }
      }
      else
      {
        if (i < 21)
        {
          paramContext = act.a(WifiConfiguration.class, "proxySettings", paramContext);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          localObject1 = act.a;
          try
          {
            localObject1 = act.a(WifiConfiguration.class, "getProxySettings", new Class[0]);
            if (localObject1 == null) {
              paramContext = null;
            } else {
              paramContext = ((Method)localObject1).invoke(paramContext, new Object[0]);
            }
          }
          finally
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = act.a((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = act.a((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static String f(Context paramContext)
  {
    System.currentTimeMillis();
    Object localObject1 = new HashSet();
    int j = 0;
    try
    {
      localObject2 = new String(acy.b(afz.a(afz.n))).split("\\n");
      paramContext = paramContext.getPackageName();
      int k = localObject2.length;
      i = 0;
      if (i < k)
      {
        String str = a(localObject2[i], paramContext);
        if (str != null) {
          ((HashSet)localObject1).add(str);
        }
        i += 1;
      }
    }
    finally
    {
      Object localObject2;
      int i;
      label85:
      break label85;
    }
    localObject1 = acr.a((Set)localObject1);
    if (((Set)localObject1).size() > 0)
    {
      paramContext = new StringBuilder();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      localObject1 = ((ArrayList)localObject2).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        j = i + 1;
        paramContext.append((String)((Iterator)localObject1).next());
        if (j >= 8) {
          break;
        }
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          paramContext.append("_");
          i = j;
        }
      }
      return paramContext.toString();
    }
    return "";
  }
  
  public static boolean f()
  {
    try
    {
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      if (localObject1 != null)
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)((Iterator)localObject1).next();
          if ((localNetworkInterface.isUp()) && (localNetworkInterface.getInterfaceAddresses().size() != 0))
          {
            boolean bool = localNetworkInterface.getName().matches("tun\\d+");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    finally
    {
      label71:
      break label71;
    }
    return false;
  }
  
  public static int g(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && ((localNetworkInfo.getState() == NetworkInfo.State.CONNECTING) || (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED)))
      {
        if (localNetworkInfo.getType() == 1) {
          return 0;
        }
        if (localNetworkInfo.getType() == 0)
        {
          if (Proxy.getDefaultHost() == null)
          {
            paramContext = Proxy.getHost(paramContext);
            if (paramContext == null) {
              return 1;
            }
          }
          return 2;
        }
      }
      return -1;
    }
    finally
    {
      paramContext = paramContext.getMessage();
      int j = -3;
      int i = j;
      if (paramContext != null)
      {
        i = j;
        if (paramContext.contains("ACCESS_NETWORK_STATE")) {
          i = -2;
        }
      }
      return i;
    }
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = Process.myPid();
    Object localObject = b(-1);
    if (localObject == null) {
      return localStringBuilder.toString();
    }
    int j = ((adf)localObject).e;
    if (j == 0) {
      return localStringBuilder.toString();
    }
    if (j == i) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    localStringBuilder.append(((adf)localObject).b);
    localStringBuilder.append(",");
    localStringBuilder.append(((adf)localObject).c);
    localStringBuilder.append(",");
    localStringBuilder.append(j);
    localStringBuilder.append(",");
    localObject = ((ArrayList)j()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      adf localadf = (adf)((Iterator)localObject).next();
      if (localadf.a == j)
      {
        localStringBuilder.append(localadf.d);
        localStringBuilder.append(",");
        localStringBuilder.append(localadf.c);
        localStringBuilder.append(",");
        localStringBuilder.append(localadf.b);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String h()
  {
    try
    {
      Object localObject1 = new File("/system/lib");
      if (((File)localObject1).canRead())
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject1[i];
          if (localObject3.getName().contains("rockchip"))
          {
            localObject1 = localObject3.getAbsolutePath();
            return localObject1;
          }
          i += 1;
        }
      }
      return "";
    }
    finally {}
    return "";
  }
  
  public static boolean h(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      paramContext = paramContext.getMessage();
      if ((paramContext != null) && (paramContext.contains("ACCESS_NETWORK_STATE"))) {
        return true;
      }
    }
    return false;
  }
  
  public static String i()
  {
    System.currentTimeMillis();
    Object localObject4 = new HashSet();
    try
    {
      localObject5 = new String(acy.b(afz.a(afz.n))).split("\\n");
      j = localObject5.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject5;
        int j;
        int i;
        String str;
        String[] arrayOfString;
        int k;
        Object localObject1;
        continue;
        if (i < j)
        {
          str = localObject5[i];
          Object localObject3 = null;
          if (str != null) {}
        }
      }
    }
    arrayOfString = str.split(" ");
    if ((arrayOfString.length > 2) && (arrayOfString[1].contains("x")))
    {
      k = str.indexOf('/');
      if (k != -1)
      {
        str = str.substring(k).trim();
        if (!str.startsWith("/data/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(arrayOfString[1]);
          ((StringBuilder)localObject1).append(";");
          ((StringBuilder)localObject1).append(str);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    if (localObject1 != null) {
      ((HashSet)localObject4).add(localObject1);
    }
    i += 1;
    break label285;
    localObject4 = acr.a((Set)localObject4);
    if (((Set)localObject4).size() > 0)
    {
      localObject1 = new StringBuilder();
      localObject5 = new ArrayList();
      ((ArrayList)localObject5).addAll((Collection)localObject4);
      localObject4 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject4).next());
        if (((Iterator)localObject4).hasNext()) {
          ((StringBuilder)localObject1).append(",");
        }
      }
      return ((StringBuilder)localObject1).toString();
    }
    return "";
  }
  
  public static List<adf> j()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = new File("/proc").list();
    if (arrayOfString == null) {
      return localArrayList;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        int k = ((String)localObject).charAt(0);
        if ((k <= 57) && (k >= 48))
        {
          localObject = b(Integer.parseInt((String)localObject));
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      catch (Exception localException)
      {
        label96:
        break label96;
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahr
 * JD-Core Version:    0.7.0.1
 */