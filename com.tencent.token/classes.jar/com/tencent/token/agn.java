package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.qps.final;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

public class agn
{
  public static Context a;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return paramInt1 | i << paramInt2;
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
  
  public static Context a()
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
  public static adi a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iload_0
    //   4: invokestatic 29	com/tencent/token/agn:b	(I)Ljava/lang/String;
    //   7: astore 5
    //   9: iload_0
    //   10: iconst_m1
    //   11: if_icmpeq +41 -> 52
    //   14: getstatic 35	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   17: astore 6
    //   19: new 37	java/lang/String
    //   22: dup
    //   23: aload 6
    //   25: ldc 39
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_0
    //   34: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: invokestatic 47	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 52	com/tencent/token/adg:b	(Ljava/lang/String;)[B
    //   44: invokespecial 56	java/lang/String:<init>	([B)V
    //   47: astore 6
    //   49: goto +31 -> 80
    //   52: getstatic 35	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   55: astore 6
    //   57: new 37	java/lang/String
    //   60: dup
    //   61: aload 6
    //   63: ldc 58
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 47	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   72: invokestatic 52	com/tencent/token/adg:b	(Ljava/lang/String;)[B
    //   75: invokespecial 56	java/lang/String:<init>	([B)V
    //   78: astore 6
    //   80: new 60	java/util/HashMap
    //   83: dup
    //   84: invokespecial 63	java/util/HashMap:<init>	()V
    //   87: astore 8
    //   89: aload 6
    //   91: ldc 65
    //   93: invokevirtual 69	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   96: astore 6
    //   98: aload 6
    //   100: arraylength
    //   101: istore_2
    //   102: iconst_0
    //   103: istore_1
    //   104: iload_1
    //   105: iload_2
    //   106: if_icmpge +44 -> 150
    //   109: aload 6
    //   111: iload_1
    //   112: aaload
    //   113: ldc 71
    //   115: invokevirtual 69	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   118: astore 9
    //   120: aload 9
    //   122: arraylength
    //   123: iconst_2
    //   124: if_icmplt +167 -> 291
    //   127: aload 8
    //   129: aload 9
    //   131: iconst_0
    //   132: aaload
    //   133: invokevirtual 75	java/lang/String:trim	()Ljava/lang/String;
    //   136: aload 9
    //   138: iconst_1
    //   139: aaload
    //   140: invokevirtual 75	java/lang/String:trim	()Ljava/lang/String;
    //   143: invokevirtual 79	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: goto +144 -> 291
    //   150: aload 8
    //   152: ldc 81
    //   154: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast 37	java/lang/String
    //   160: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   163: istore_1
    //   164: aload 8
    //   166: ldc 91
    //   168: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 37	java/lang/String
    //   174: ldc 93
    //   176: invokevirtual 69	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   179: iconst_0
    //   180: aaload
    //   181: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   184: istore_3
    //   185: aload 8
    //   187: ldc 95
    //   189: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 37	java/lang/String
    //   195: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   198: istore_2
    //   199: iload_2
    //   200: istore 4
    //   202: goto +17 -> 219
    //   205: aconst_null
    //   206: astore 5
    //   208: iconst_m1
    //   209: istore_2
    //   210: iconst_m1
    //   211: istore_1
    //   212: iconst_m1
    //   213: istore 4
    //   215: iload_1
    //   216: istore_3
    //   217: iload_2
    //   218: istore_1
    //   219: aload 7
    //   221: astore 6
    //   223: aload 5
    //   225: ifnull +37 -> 262
    //   228: aload 7
    //   230: astore 6
    //   232: iload_1
    //   233: iconst_m1
    //   234: if_icmpeq +28 -> 262
    //   237: aload 7
    //   239: astore 6
    //   241: iload_3
    //   242: iconst_m1
    //   243: if_icmpeq +19 -> 262
    //   246: new 97	com/tencent/token/adi
    //   249: dup
    //   250: iload_0
    //   251: iload_1
    //   252: aload 5
    //   254: iload_3
    //   255: iload 4
    //   257: invokespecial 100	com/tencent/token/adi:<init>	(IILjava/lang/String;II)V
    //   260: astore 6
    //   262: aload 6
    //   264: areturn
    //   265: astore 5
    //   267: goto -62 -> 205
    //   270: astore 6
    //   272: goto -64 -> 208
    //   275: astore 6
    //   277: iload_1
    //   278: istore_2
    //   279: goto -69 -> 210
    //   282: astore 6
    //   284: iload_1
    //   285: istore_2
    //   286: iload_3
    //   287: istore_1
    //   288: goto -76 -> 212
    //   291: iload_1
    //   292: iconst_1
    //   293: iadd
    //   294: istore_1
    //   295: goto -191 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramInt	int
    //   103	192	1	i	int
    //   101	185	2	j	int
    //   184	103	3	k	int
    //   200	56	4	m	int
    //   7	246	5	str	String
    //   265	1	5	localObject1	Object
    //   17	246	6	localObject2	Object
    //   270	1	6	localObject3	Object
    //   275	1	6	localObject4	Object
    //   282	1	6	localObject5	Object
    //   1	237	7	localObject6	Object
    //   87	99	8	localHashMap	java.util.HashMap
    //   118	19	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	9	265	finally
    //   14	19	270	finally
    //   19	49	270	finally
    //   52	57	270	finally
    //   57	80	270	finally
    //   80	102	270	finally
    //   109	147	270	finally
    //   150	164	270	finally
    //   164	185	275	finally
    //   185	199	282	finally
  }
  
  public static <T extends final> T a(byte[] paramArrayOfByte, T paramT)
  {
    if ((paramArrayOfByte != null) && (paramT != null)) {}
    try
    {
      paramT.getClass();
      paramArrayOfByte = new agd(paramArrayOfByte);
      paramArrayOfByte.b = "UTF-8";
      paramT.a(paramArrayOfByte);
      return paramT;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return null;
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
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 142	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: invokevirtual 146	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 152	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 157	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   30: astore_0
    //   31: goto +5 -> 36
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +5 -> 42
    //   40: aload_0
    //   41: areturn
    //   42: new 159	java/util/zip/ZipFile
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 162	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: ldc 164
    //   55: invokevirtual 168	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   58: invokevirtual 172	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 174	com/tencent/token/aby
    //   65: dup
    //   66: invokespecial 175	com/tencent/token/aby:<init>	()V
    //   69: aload_1
    //   70: invokevirtual 178	com/tencent/token/aby:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   73: invokeinterface 184 1 0
    //   78: iconst_0
    //   79: invokeinterface 190 2 0
    //   84: invokeinterface 196 1 0
    //   89: ldc 198
    //   91: invokeinterface 204 2 0
    //   96: invokeinterface 207 1 0
    //   101: astore 4
    //   103: aload_1
    //   104: invokestatic 210	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   107: aload 4
    //   109: astore_1
    //   110: invokestatic 214	com/tencent/token/adf:a	()I
    //   113: istore_2
    //   114: aload_3
    //   115: astore 6
    //   117: aload 4
    //   119: astore 5
    //   121: iload_2
    //   122: bipush 19
    //   124: if_icmplt +45 -> 169
    //   127: aload 4
    //   129: astore_0
    //   130: goto +31 -> 161
    //   133: goto +8 -> 141
    //   136: aconst_null
    //   137: astore_3
    //   138: aload 4
    //   140: astore_1
    //   141: aload_1
    //   142: invokestatic 210	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   145: aload_3
    //   146: astore 6
    //   148: aload_0
    //   149: astore 5
    //   151: aload_0
    //   152: astore_1
    //   153: invokestatic 214	com/tencent/token/adf:a	()I
    //   156: bipush 19
    //   158: if_icmplt +11 -> 169
    //   161: aload_0
    //   162: astore_1
    //   163: aload_3
    //   164: invokestatic 210	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   167: aload_0
    //   168: areturn
    //   169: aload 5
    //   171: astore_1
    //   172: aload 6
    //   174: invokevirtual 217	java/util/zip/ZipFile:close	()V
    //   177: aload 5
    //   179: areturn
    //   180: astore_0
    //   181: goto -147 -> 34
    //   184: astore_1
    //   185: goto -49 -> 136
    //   188: astore_1
    //   189: aload 4
    //   191: astore_1
    //   192: goto -51 -> 141
    //   195: astore 4
    //   197: goto -64 -> 133
    //   200: astore_0
    //   201: aload_1
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramContext	Context
    //   0	203	1	paramString	String
    //   113	12	2	i	int
    //   50	114	3	localZipFile1	java.util.zip.ZipFile
    //   1	189	4	str	String
    //   195	1	4	localObject1	Object
    //   119	59	5	localObject2	Object
    //   115	58	6	localZipFile2	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   3	11	180	finally
    //   15	22	180	finally
    //   26	31	180	finally
    //   42	51	184	finally
    //   51	62	188	finally
    //   62	103	195	finally
    //   110	114	200	finally
    //   153	161	200	finally
    //   163	167	200	finally
    //   172	177	200	finally
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
      label213:
      break label213;
    }
    paramString1 = null;
    if ((paramString1 == null) || (str.startsWith(paramString1))) {
      return null;
    }
    return str;
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
  
  public static boolean a(Context paramContext)
  {
    try
    {
      Context localContext = a;
      if (localContext != null) {
        return true;
      }
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {
        return false;
      }
      a = paramContext;
      return true;
    }
    finally {}
  }
  
  public static byte[] a(String paramString)
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
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 312	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 313	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 315	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 318	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 321	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 324	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 330	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 330	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 330	java/util/zip/DeflaterOutputStream:close	()V
    //   75: goto +8 -> 83
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_0
    //   86: goto -19 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	9	1	localIOException1	IOException
    //   60	8	1	localIOException2	IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	60	java/io/IOException
    //   67	75	78	java/io/IOException
    //   17	31	85	java/lang/Exception
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = e(paramArrayOfByte2);
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
  
  private static String b(int paramInt)
  {
    String str = "";
    try
    {
      Object localObject3 = Locale.ENGLISH;
      Object localObject2 = adg.a(String.format((Locale)localObject3, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject2 != null) {
        str = new String((byte[])localObject2, 0, a((byte[])localObject2, 0, '\000'));
      }
      boolean bool = TextUtils.isEmpty(str);
      localObject2 = str;
      if (bool)
      {
        localObject3 = adg.a(String.format((Locale)localObject3, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
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
  
  public static boolean b(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 17 ? Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static byte[] b()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = agg.a(agg.aD);
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
  
  public static byte[] b(SparseArray<Object> paramSparseArray)
  {
    byte[] arrayOfByte = (byte[])a(paramSparseArray, 1, [B.class);
    paramSparseArray = arrayOfByte;
    if (arrayOfByte == null) {
      paramSparseArray = new byte[0];
    }
    return paramSparseArray;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 413	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 414	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 416	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 419	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 312	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 313	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 422	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 425	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 328	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 426	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 427	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 426	java/io/ByteArrayInputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 427	java/util/zip/InflaterInputStream:close	()V
    //   83: aload_3
    //   84: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: invokevirtual 426	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 427	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   110: goto +8 -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore 4
    //   122: goto -24 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	86	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	82	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	23	4	localObject	Object
    //   120	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   75	87	90	java/io/IOException
    //   98	110	113	java/io/IOException
    //   26	31	120	java/lang/Exception
    //   36	41	120	java/lang/Exception
    //   44	50	120	java/lang/Exception
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = e(paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (arrayOfByte != null) && (paramArrayOfByte1.length != 0))
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
  
  public static String c(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(a("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label30:
      break label30;
    }
    paramArrayOfByte = null;
    return d(paramArrayOfByte);
  }
  
  public static boolean c()
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
  
  public static boolean c(Context paramContext)
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
          paramContext = acr.a(WifiConfiguration.class, "proxySettings", paramContext);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          localObject1 = acr.a;
          try
          {
            localObject1 = acr.a(WifiConfiguration.class, "getProxySettings", new Class[0]);
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
        localObject2 = acr.a((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = acr.a((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static String d(Context paramContext)
  {
    System.currentTimeMillis();
    Object localObject1 = new HashSet();
    int j = 0;
    try
    {
      localObject2 = new String(adg.b(agg.a(agg.n))).split("\\n");
      paramContext = paramContext.getPackageName();
      k = localObject2.length;
      i = 0;
      if (i < k)
      {
        localObject3 = a(localObject2[i], paramContext);
        if (localObject3 != null) {
          ((HashSet)localObject1).add(localObject3);
        }
        i += 1;
      }
    }
    finally
    {
      Object localObject2;
      int k;
      int i;
      Object localObject3;
      label85:
      break label85;
    }
    paramContext = acb.a;
    paramContext = new HashSet();
    localObject2 = acb.a;
    localObject3 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      k = localObject2.length;
      i = 0;
      while (i < k)
      {
        if (Pattern.compile(localObject2[i]).matcher(str).find()) {
          paramContext.add(str);
        }
        i += 1;
      }
    }
    ((Set)localObject1).removeAll(paramContext);
    if (((HashSet)localObject1).size() > 0)
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
  
  public static String d(byte[] paramArrayOfByte)
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
  
  public static List<adi> d()
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
          localObject = a(Integer.parseInt((String)localObject));
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
  
  public static boolean e(Context paramContext)
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
  
  private static byte[] e(byte[] paramArrayOfByte)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agn
 * JD-Core Version:    0.7.0.1
 */