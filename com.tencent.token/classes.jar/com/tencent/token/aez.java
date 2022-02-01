package com.tencent.token;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.base.break;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class aez
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
  
  public static acj a(int paramInt)
  {
    Object localObject2 = null;
    try
    {
      str = b(paramInt);
    }
    catch (Throwable localThrowable1)
    {
      String str;
      Object localObject1;
      Object localObject3;
      label68:
      int m;
      label184:
      break label184;
    }
    try
    {
      localObject1 = Locale.ENGLISH;
      localObject3 = new String(c(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
      localObject1 = new HashMap();
      localObject3 = ((String)localObject3).split("\n");
      j = localObject3.length;
      i = 0;
      if (i < j)
      {
        String[] arrayOfString = localObject3[i];
        arrayOfString = arrayOfString.split(":");
        if (arrayOfString.length >= 2) {
          ((HashMap)localObject1).put(arrayOfString[0].trim(), arrayOfString[1].trim());
        }
        i += 1;
        break label68;
      }
      i = Integer.parseInt((String)((HashMap)localObject1).get("PPid"));
    }
    catch (Throwable localThrowable2)
    {
      break label187;
    }
    try
    {
      localObject3 = (String)((HashMap)localObject1).get("Uid");
      k = Integer.parseInt(localObject3.split("\\s+")[0]);
    }
    catch (Throwable localThrowable3)
    {
      j = i;
      break label189;
    }
    try
    {
      m = Integer.parseInt((String)((HashMap)localObject1).get("TracerPid"));
      j = i;
      i = m;
    }
    catch (Throwable localThrowable4)
    {
      j = i;
      i = k;
      break label191;
    }
    str = null;
    label187:
    j = -1;
    label189:
    i = -1;
    label191:
    k = i;
    i = -1;
    localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (j != -1)
      {
        localObject1 = localObject2;
        if (k != -1) {
          localObject1 = new acj(paramInt, j, str, k, i);
        }
      }
    }
    return localObject1;
  }
  
  public static <T extends break> T a(byte[] paramArrayOfByte, T paramT)
  {
    if ((paramArrayOfByte != null) && (paramT != null)) {}
    try
    {
      paramArrayOfByte = new afl(paramArrayOfByte);
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
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aload_0
    //   12: invokevirtual 137	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokevirtual 141	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +22 -> 42
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_0
    //   26: invokevirtual 147	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: getfield 152	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   38: astore_0
    //   39: goto +5 -> 44
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +5 -> 50
    //   48: aload_0
    //   49: areturn
    //   50: new 154	java/util/zip/ZipFile
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 157	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload 6
    //   61: astore_1
    //   62: aload 5
    //   64: astore_2
    //   65: aload_3
    //   66: aload_3
    //   67: ldc 159
    //   69: invokevirtual 163	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   72: invokevirtual 167	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_1
    //   80: aload 4
    //   82: astore_2
    //   83: new 169	com/tencent/token/afj
    //   86: dup
    //   87: invokespecial 170	com/tencent/token/afj:<init>	()V
    //   90: aload 4
    //   92: invokevirtual 173	com/tencent/token/afj:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   95: invokeinterface 179 1 0
    //   100: iconst_0
    //   101: invokeinterface 185 2 0
    //   106: invokeinterface 191 1 0
    //   111: astore 5
    //   113: aload 4
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: aload 5
    //   121: ldc 193
    //   123: invokeinterface 199 2 0
    //   128: invokeinterface 202 1 0
    //   133: astore 5
    //   135: aload 4
    //   137: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   140: aload 5
    //   142: astore_1
    //   143: invokestatic 208	com/tencent/token/aez:d	()I
    //   146: bipush 19
    //   148: if_icmplt +13 -> 161
    //   151: aload 5
    //   153: astore_1
    //   154: aload_3
    //   155: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   158: aload 5
    //   160: areturn
    //   161: aload 5
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 211	java/util/zip/ZipFile:close	()V
    //   168: aload 5
    //   170: areturn
    //   171: astore_0
    //   172: goto +8 -> 180
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_2
    //   179: astore_1
    //   180: aload_1
    //   181: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   184: invokestatic 208	com/tencent/token/aez:d	()I
    //   187: bipush 19
    //   189: if_icmplt +10 -> 199
    //   192: aload_3
    //   193: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   196: goto +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 211	java/util/zip/ZipFile:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: aconst_null
    //   206: astore_3
    //   207: aload 4
    //   209: astore_2
    //   210: aload_2
    //   211: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   214: aload_0
    //   215: astore_1
    //   216: invokestatic 208	com/tencent/token/aez:d	()I
    //   219: bipush 19
    //   221: if_icmplt +11 -> 232
    //   224: aload_0
    //   225: astore_1
    //   226: aload_3
    //   227: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   230: aload_0
    //   231: areturn
    //   232: aload_0
    //   233: astore_1
    //   234: aload_3
    //   235: invokevirtual 211	java/util/zip/ZipFile:close	()V
    //   238: aload_0
    //   239: areturn
    //   240: astore_0
    //   241: goto -199 -> 42
    //   244: astore_1
    //   245: goto -40 -> 205
    //   248: astore_1
    //   249: goto -39 -> 210
    //   252: astore_0
    //   253: aload_1
    //   254: areturn
    //   255: astore_1
    //   256: goto -53 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	Context
    //   0	259	1	paramString	String
    //   1	210	2	localObject1	Object
    //   58	177	3	localZipFile	java.util.zip.ZipFile
    //   3	205	4	localInputStream	java.io.InputStream
    //   6	163	5	localObject2	Object
    //   9	51	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	77	171	finally
    //   83	113	171	finally
    //   119	135	171	finally
    //   50	59	175	finally
    //   11	19	240	java/lang/Throwable
    //   23	30	240	java/lang/Throwable
    //   34	39	240	java/lang/Throwable
    //   50	59	244	java/lang/Throwable
    //   65	77	248	java/lang/Throwable
    //   83	113	248	java/lang/Throwable
    //   119	135	248	java/lang/Throwable
    //   143	151	252	java/lang/Throwable
    //   154	158	252	java/lang/Throwable
    //   164	168	252	java/lang/Throwable
    //   216	224	252	java/lang/Throwable
    //   226	230	252	java/lang/Throwable
    //   234	238	252	java/lang/Throwable
    //   184	196	255	java/lang/Throwable
    //   199	203	255	java/lang/Throwable
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 214	java/io/BufferedReader
    //   7: dup
    //   8: new 216	java/io/FileReader
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 219	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   16: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +9 -> 35
    //   29: aload_0
    //   30: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: goto +9 -> 51
    //   45: goto +16 -> 61
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   59: aload_1
    //   60: athrow
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   69: ldc 229
    //   71: areturn
    //   72: astore_0
    //   73: aload_1
    //   74: astore_0
    //   75: goto -14 -> 61
    //   78: astore_1
    //   79: goto -34 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramFile	File
    //   1	39	1	str	String
    //   41	1	1	localObject1	Object
    //   48	26	1	localObject2	Object
    //   78	1	1	localThrowable	Throwable
    //   3	47	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	41	finally
    //   4	20	48	finally
    //   4	20	72	java/lang/Throwable
    //   20	25	78	java/lang/Throwable
  }
  
  public static String a(String paramString)
  {
    try
    {
      localCipher = Cipher.getInstance("DES");
      Object localObject = "MnKd0x$9".getBytes("UTF-8");
      localCipher.init(2, new SecretKeySpec((byte[])localObject, "DES"));
      if (TextUtils.isEmpty(paramString))
      {
        paramString = null;
      }
      else
      {
        localObject = paramString.toCharArray();
        int j = localObject.length / 2;
        paramString = new byte[j];
        int i = 0;
        while (i < j)
        {
          int k = i * 2;
          int m = Character.digit(localObject[k], 16);
          paramString[i] = ((byte)((Character.digit(localObject[(k + 1)], 16) | m << 4) & 0xFF));
          i += 1;
        }
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Cipher localCipher;
      }
    }
    paramString = localCipher.doFinal(paramString);
    paramString = new String(paramString, "UTF-8");
    return paramString;
    return "";
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
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +14 -> 15
    //   4: ldc_w 348
    //   7: astore_1
    //   8: ldc_w 350
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: ldc_w 352
    //   18: astore_1
    //   19: ldc_w 354
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 291	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 356
    //   44: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 214	java/io/BufferedReader
    //   51: dup
    //   52: new 216	java/io/FileReader
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 357	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +98 -> 173
    //   78: aload 5
    //   80: invokevirtual 360	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +86 -> 173
    //   90: new 291	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 365
    //   108: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 214	java/io/BufferedReader
    //   115: dup
    //   116: new 216	java/io/FileReader
    //   119: dup
    //   120: aload_2
    //   121: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 357	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: ifnull +34 -> 175
    //   144: aload 4
    //   146: invokevirtual 74	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore_2
    //   150: aload_3
    //   151: invokevirtual 366	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: invokevirtual 366	java/io/BufferedReader:close	()V
    //   158: aload_2
    //   159: areturn
    //   160: astore 4
    //   162: aload_1
    //   163: astore_2
    //   164: aload 4
    //   166: astore_1
    //   167: goto +37 -> 204
    //   170: goto +59 -> 229
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_3
    //   176: invokevirtual 366	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: ifnull +73 -> 253
    //   183: goto +66 -> 249
    //   186: astore_1
    //   187: aload 4
    //   189: astore_2
    //   190: goto +14 -> 204
    //   193: aconst_null
    //   194: astore_1
    //   195: goto +34 -> 229
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_3
    //   201: aload 4
    //   203: astore_2
    //   204: aload_3
    //   205: ifnull +10 -> 215
    //   208: aload_3
    //   209: invokevirtual 366	java/io/BufferedReader:close	()V
    //   212: goto +3 -> 215
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 366	java/io/BufferedReader:close	()V
    //   223: aload_1
    //   224: athrow
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: astore_3
    //   229: aload_3
    //   230: ifnull +10 -> 240
    //   233: aload_3
    //   234: invokevirtual 366	java/io/BufferedReader:close	()V
    //   237: goto +3 -> 240
    //   240: aload_1
    //   241: astore_2
    //   242: aload_1
    //   243: ifnonnull +6 -> 249
    //   246: goto +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 366	java/io/BufferedReader:close	()V
    //   253: ldc 229
    //   255: areturn
    //   256: astore_1
    //   257: goto -32 -> 225
    //   260: astore_1
    //   261: goto -68 -> 193
    //   264: astore_2
    //   265: goto -95 -> 170
    //   268: astore_3
    //   269: goto -115 -> 154
    //   272: astore_1
    //   273: aload_2
    //   274: areturn
    //   275: astore_1
    //   276: goto -97 -> 179
    //   279: astore_3
    //   280: goto -65 -> 215
    //   283: astore_2
    //   284: goto -61 -> 223
    //   287: astore_2
    //   288: goto -48 -> 240
    //   291: astore_1
    //   292: goto -39 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramBoolean	boolean
    //   7	160	1	localObject1	Object
    //   186	1	1	localObject2	Object
    //   194	1	1	localObject3	Object
    //   198	26	1	localObject4	Object
    //   226	17	1	localObject5	Object
    //   256	1	1	localThrowable1	Throwable
    //   260	1	1	localThrowable2	Throwable
    //   272	1	1	localIOException1	IOException
    //   275	1	1	localIOException2	IOException
    //   291	1	1	localIOException3	IOException
    //   11	239	2	localObject6	Object
    //   264	10	2	localThrowable3	Throwable
    //   283	1	2	localIOException4	IOException
    //   287	1	2	localIOException5	IOException
    //   33	201	3	localObject7	Object
    //   268	1	3	localIOException6	IOException
    //   279	1	3	localIOException7	IOException
    //   24	121	4	str1	String
    //   160	42	4	localObject8	Object
    //   71	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   131	137	160	finally
    //   144	150	160	finally
    //   67	73	186	finally
    //   78	104	186	finally
    //   104	131	186	finally
    //   26	40	198	finally
    //   40	67	198	finally
    //   26	40	256	java/lang/Throwable
    //   40	67	256	java/lang/Throwable
    //   67	73	260	java/lang/Throwable
    //   78	104	260	java/lang/Throwable
    //   104	131	260	java/lang/Throwable
    //   131	137	264	java/lang/Throwable
    //   144	150	264	java/lang/Throwable
    //   150	154	268	java/io/IOException
    //   154	158	272	java/io/IOException
    //   175	179	275	java/io/IOException
    //   208	212	279	java/io/IOException
    //   219	223	283	java/io/IOException
    //   233	237	287	java/io/IOException
    //   249	253	291	java/io/IOException
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
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
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 375	java/io/BufferedOutputStream
    //   7: dup
    //   8: new 377	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 378	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 381	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 384	java/io/BufferedOutputStream:write	([B)V
    //   25: aload_0
    //   26: invokevirtual 387	java/io/BufferedOutputStream:flush	()V
    //   29: aload_0
    //   30: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   33: iconst_1
    //   34: ireturn
    //   35: astore_1
    //   36: goto +9 -> 45
    //   39: goto +12 -> 51
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: aload_0
    //   46: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: invokestatic 227	com/tencent/token/aez:b	(Ljava/io/Closeable;)V
    //   55: iconst_0
    //   56: ireturn
    //   57: astore_0
    //   58: aload_3
    //   59: astore_0
    //   60: goto -9 -> 51
    //   63: astore_1
    //   64: goto -25 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString	String
    //   0	67	1	paramArrayOfByte	byte[]
    //   3	41	2	localObject1	Object
    //   1	58	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	35	finally
    //   4	20	42	finally
    //   4	20	57	java/lang/Throwable
    //   20	29	63	java/lang/Throwable
  }
  
  public static byte[] a(break parambreak)
  {
    afo localafo = new afo();
    localafo.b = "UTF-8";
    parambreak.a(localafo);
    return localafo.a();
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 341	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 402	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 404	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 405	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: iload_1
    //   28: newarray byte
    //   30: astore 5
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_0
    //   35: aload 5
    //   37: iload_2
    //   38: iload_1
    //   39: iload_2
    //   40: isub
    //   41: invokevirtual 409	java/io/FileInputStream:read	([BII)I
    //   44: istore 4
    //   46: iload_2
    //   47: istore_3
    //   48: iload 4
    //   50: iconst_m1
    //   51: if_icmpeq +15 -> 66
    //   54: iload_2
    //   55: iload 4
    //   57: iadd
    //   58: istore_3
    //   59: iload_3
    //   60: istore_2
    //   61: iload_3
    //   62: iload_1
    //   63: if_icmplt -29 -> 34
    //   66: iload_3
    //   67: ifne +9 -> 76
    //   70: aload_0
    //   71: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: iload_3
    //   77: iload_1
    //   78: if_icmpge +25 -> 103
    //   81: iload_3
    //   82: newarray byte
    //   84: astore 6
    //   86: aload 5
    //   88: iconst_0
    //   89: aload 6
    //   91: iconst_0
    //   92: iload_3
    //   93: invokestatic 415	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   96: aload 6
    //   98: astore 5
    //   100: goto +3 -> 103
    //   103: aload_0
    //   104: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   107: aload 5
    //   109: areturn
    //   110: astore 5
    //   112: goto +7 -> 119
    //   115: astore 5
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   123: aload 5
    //   125: athrow
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_0
    //   135: goto -9 -> 126
    //   138: astore 5
    //   140: goto -12 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramInt	int
    //   33	28	2	i	int
    //   47	46	3	j	int
    //   44	14	4	k	int
    //   30	78	5	localObject1	Object
    //   110	1	5	localObject2	Object
    //   115	9	5	localObject3	Object
    //   138	1	5	localThrowable	Throwable
    //   84	13	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	32	110	finally
    //   34	46	110	finally
    //   81	96	110	finally
    //   18	27	115	finally
    //   18	27	134	java/lang/Throwable
    //   27	32	138	java/lang/Throwable
    //   34	46	138	java/lang/Throwable
    //   81	96	138	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 417	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 418	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 420	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 421	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 422	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 425	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 428	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 430	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 430	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 430	java/util/zip/DeflaterOutputStream:close	()V
    //   75: goto +8 -> 83
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 433	java/io/IOException:printStackTrace	()V
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
    byte[] arrayOfByte = f(paramArrayOfByte2);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        paramArrayOfByte2 = paramArrayOfByte1;
        if (paramArrayOfByte1.length != 0)
        {
          if (paramArrayOfByte1.length % 4 == 0) {
            i = (paramArrayOfByte1.length >>> 2) + 1;
          } else {
            i = (paramArrayOfByte1.length >>> 2) + 2;
          }
          int[] arrayOfInt = new int[i];
          a(paramArrayOfByte1, arrayOfInt);
          arrayOfInt[(i - 1)] = paramArrayOfByte1.length;
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
          int i1 = arrayOfInt.length - 1;
          i = arrayOfInt[i1];
          j = 52 / (i1 + 1) + 6;
          int m;
          for (int k = 0; j > 0; k = m)
          {
            m = k - 1640531527;
            int i2 = m >>> 2 & 0x3;
            int n = 0;
            k = i;
            for (i = n; i < i1; i = n)
            {
              n = i + 1;
              i3 = arrayOfInt[n];
              int i4 = arrayOfInt[i];
              k = ((k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4) ^ (i3 ^ m) + (k ^ paramArrayOfByte1[(i & 0x3 ^ i2)])) + i4;
              arrayOfInt[i] = k;
            }
            n = arrayOfInt[0];
            int i3 = arrayOfInt[i1];
            i = ((k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4) ^ (n ^ m) + (paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k)) + i3;
            arrayOfInt[i1] = i;
            j -= 1;
          }
          paramArrayOfByte2 = new byte[arrayOfInt.length << 2];
          a(arrayOfInt, arrayOfInt.length, paramArrayOfByte2);
        }
      }
    }
    return paramArrayOfByte2;
  }
  
  /* Error */
  private static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 446	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_2
    //   10: iconst_0
    //   11: sipush 8192
    //   14: invokevirtual 449	java/io/InputStream:read	([BII)I
    //   17: iconst_m1
    //   18: if_icmpne -10 -> 8
    //   21: aload_3
    //   22: astore_2
    //   23: aload_1
    //   24: ifnull +8 -> 32
    //   27: aload_1
    //   28: invokevirtual 455	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 456	java/io/InputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: goto +6 -> 49
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 456	java/io/InputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokevirtual 456	java/io/InputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: goto -13 -> 59
    //   75: astore_1
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: aload_2
    //   81: areturn
    //   82: astore_1
    //   83: goto -26 -> 57
    //   86: astore_0
    //   87: aconst_null
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramJarFile	java.util.jar.JarFile
    //   0	89	1	paramJarEntry	java.util.jar.JarEntry
    //   0	89	2	paramArrayOfByte	byte[]
    //   1	21	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	21	38	finally
    //   27	32	38	finally
    //   2	8	46	finally
    //   2	8	71	java/io/IOException
    //   8	21	75	java/io/IOException
    //   27	32	75	java/io/IOException
    //   32	36	79	java/io/IOException
    //   53	57	82	java/io/IOException
    //   65	69	86	java/io/IOException
  }
  
  private static String b(int paramInt)
  {
    String str = "";
    try
    {
      Object localObject = Locale.ENGLISH;
      localObject = a(String.format((Locale)localObject, "/proc/%d/cmdline", new Object[] { Integer.valueOf(paramInt) }), 100);
      if (localObject != null) {
        str = new String((byte[])localObject, 0, a((byte[])localObject, 0, '\000'));
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = Locale.ENGLISH;
        byte[] arrayOfByte = a(String.format((Locale)localObject, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt == 0) {
            return "";
          }
          localObject = new String(arrayOfByte, 6, paramInt - 6);
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 229
    //   2: astore_2
    //   3: aload_0
    //   4: invokevirtual 141	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_3
    //   8: new 468	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 141	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 472	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   23: getfield 478	android/content/pm/ApplicationInfo:uid	I
    //   26: invokevirtual 482	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   29: iconst_0
    //   30: aaload
    //   31: bipush 64
    //   33: invokevirtual 485	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: getfield 489	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   39: iconst_0
    //   40: aaload
    //   41: invokevirtual 492	android/content/pm/Signature:toByteArray	()[B
    //   44: invokespecial 493	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: astore_0
    //   48: ldc_w 495
    //   51: invokestatic 500	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   54: aload_0
    //   55: invokevirtual 504	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   58: checkcast 506	java/security/cert/X509Certificate
    //   61: invokevirtual 509	java/security/cert/X509Certificate:getEncoded	()[B
    //   64: invokestatic 512	com/tencent/token/aez:c	([B)Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   74: aload_3
    //   75: areturn
    //   76: astore_1
    //   77: goto +6 -> 83
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   91: aload_1
    //   92: athrow
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   105: ldc 229
    //   107: areturn
    //   108: astore_0
    //   109: goto -16 -> 93
    //   112: astore_1
    //   113: goto -18 -> 95
    //   116: astore_0
    //   117: aload_1
    //   118: areturn
    //   119: astore_0
    //   120: goto -29 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramContext	Context
    //   0	123	1	paramString	String
    //   2	98	2	str	String
    //   7	68	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   48	68	76	finally
    //   3	48	80	finally
    //   3	48	108	java/lang/Throwable
    //   48	68	112	java/lang/Throwable
    //   70	74	116	java/lang/Throwable
    //   101	105	116	java/lang/Throwable
    //   87	91	119	java/lang/Throwable
  }
  
  private static void b(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean b(Context paramContext)
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
    catch (Throwable paramContext)
    {
      Object localObject1;
      label118:
      return false;
    }
    try
    {
      paramContext = ((WifiManager)localObject2).getConfiguredNetworks();
    }
    catch (Throwable paramContext)
    {
      break label118;
    }
    paramContext = null;
    if (paramContext == null) {
      return false;
    }
    localObject1 = ((WifiInfo)localObject1).getSSID();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      localObject2 = (WifiConfiguration)paramContext.next();
      if (!TextUtils.equals(((WifiConfiguration)localObject2).SSID, (CharSequence)localObject1))
      {
        String str = ((WifiConfiguration)localObject2).SSID;
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
          paramContext = afa.a(WifiConfiguration.class, "proxySettings", localObject2);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          paramContext = afa.b(WifiConfiguration.class, "getProxySettings", localObject2);
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = afa.a((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = afa.a((String)localObject1, "PAC");
          if ((localObject1 != null) && (localObject1 == paramContext)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean b(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (!paramFile.isDirectory()) {}
    try
    {
      bool = paramFile.delete();
      return bool;
    }
    catch (Throwable paramFile)
    {
      try
      {
        File[] arrayOfFile;
        int j;
        int i;
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Throwable paramFile) {}
      paramFile = paramFile;
      return false;
    }
    arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      j = arrayOfFile.length;
      i = 0;
      while (i < j)
      {
        b(arrayOfFile[i]);
        i += 1;
      }
    }
    return false;
  }
  
  public static byte[] b()
  {
    try
    {
      Object localObject = new StringBuffer();
      String str = afg.a(afg.aA);
      int i = 0;
      while (i < str.length())
      {
        ((StringBuffer)localObject).append((char)(str.charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
      localObject = ((String)localObject).getBytes("UTF-8");
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
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: new 341	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_0
    //   15: new 667	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 4
    //   21: ldc_w 669
    //   24: invokespecial 672	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 675	java/io/RandomAccessFile:length	()J
    //   34: lstore_2
    //   35: lload_2
    //   36: l2i
    //   37: istore_1
    //   38: iload_1
    //   39: i2l
    //   40: lload_2
    //   41: lcmp
    //   42: ifne +25 -> 67
    //   45: iload_1
    //   46: newarray byte
    //   48: astore_0
    //   49: aload 4
    //   51: aload_0
    //   52: invokevirtual 678	java/io/RandomAccessFile:readFully	([B)V
    //   55: aload 4
    //   57: invokevirtual 679	java/io/RandomAccessFile:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore 4
    //   64: goto +64 -> 128
    //   67: new 276	java/io/IOException
    //   70: dup
    //   71: ldc 229
    //   73: invokespecial 680	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: astore_0
    //   78: aload 4
    //   80: astore 5
    //   82: aload_0
    //   83: astore 4
    //   85: aload 5
    //   87: astore_0
    //   88: goto +47 -> 135
    //   91: goto +8 -> 99
    //   94: astore 4
    //   96: goto +39 -> 135
    //   99: aload 4
    //   101: astore_0
    //   102: iconst_0
    //   103: newarray byte
    //   105: astore 5
    //   107: aload 5
    //   109: astore_0
    //   110: aload 4
    //   112: ifnull +21 -> 133
    //   115: aload 4
    //   117: invokevirtual 679	java/io/RandomAccessFile:close	()V
    //   120: aload 5
    //   122: areturn
    //   123: astore 4
    //   125: aload 5
    //   127: astore_0
    //   128: aload 4
    //   130: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   133: aload_0
    //   134: areturn
    //   135: aload_0
    //   136: ifnull +15 -> 151
    //   139: aload_0
    //   140: invokevirtual 679	java/io/RandomAccessFile:close	()V
    //   143: goto +8 -> 151
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   151: aload 4
    //   153: athrow
    //   154: astore_0
    //   155: aload 5
    //   157: astore 4
    //   159: goto -60 -> 99
    //   162: astore_0
    //   163: goto -72 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   37	9	1	i	int
    //   34	7	2	l	long
    //   8	48	4	localObject1	Object
    //   62	17	4	localIOException1	IOException
    //   83	1	4	str	String
    //   94	22	4	localObject2	Object
    //   123	29	4	localIOException2	IOException
    //   157	1	4	localObject3	Object
    //   11	145	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   55	60	62	java/io/IOException
    //   29	35	77	finally
    //   45	55	77	finally
    //   67	77	77	finally
    //   15	29	94	finally
    //   102	107	94	finally
    //   115	120	123	java/io/IOException
    //   139	143	146	java/io/IOException
    //   15	29	154	java/lang/Throwable
    //   29	35	162	java/lang/Throwable
    //   45	55	162	java/lang/Throwable
    //   67	77	162	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 468	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 493	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 682	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 685	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 417	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 418	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 687	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 690	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 428	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 691	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 691	java/util/zip/InflaterInputStream:close	()V
    //   83: aload_3
    //   84: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 433	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: invokevirtual 513	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 691	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 429	java/io/ByteArrayOutputStream:close	()V
    //   110: goto +8 -> 118
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 433	java/io/IOException:printStackTrace	()V
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
    byte[] arrayOfByte = f(paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (arrayOfByte != null) && (paramArrayOfByte1.length != 0))
    {
      if ((paramArrayOfByte1.length % 4 == 0) && (paramArrayOfByte1.length >= 8))
      {
        paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
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
        int m = paramArrayOfByte2.length - 1;
        i = paramArrayOfByte2[0];
        j = (52 / (m + 1) + 6) * -1640531527;
        while (j != 0)
        {
          int n = j >>> 2 & 0x3;
          int k = i;
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
        if ((i >= 0) && (i <= paramArrayOfByte2.length - 1 << 2))
        {
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    return e(d(paramArrayOfByte));
  }
  
  /* Error */
  public static List<String> c(File paramFile)
  {
    // Byte code:
    //   0: new 700	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 701	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 445	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 702	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 159
    //   21: invokevirtual 706	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 708	com/tencent/token/aez:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +45 -> 81
    //   39: aload 4
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +34 -> 81
    //   50: aload_3
    //   51: aload 4
    //   53: iload_1
    //   54: aaload
    //   55: invokevirtual 711	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 512	com/tencent/token/aez:c	([B)Ljava/lang/String;
    //   61: invokeinterface 714 2 0
    //   66: pop
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 715	java/util/jar/JarFile:close	()V
    //   79: aload_3
    //   80: athrow
    //   81: aload_0
    //   82: invokevirtual 715	java/util/jar/JarFile:close	()V
    //   85: aload_3
    //   86: areturn
    //   87: astore 4
    //   89: goto -8 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramFile	File
    //   44	27	1	i	int
    //   42	6	2	j	int
    //   7	44	3	localArrayList	ArrayList
    //   74	12	3	localList	List<String>
    //   32	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   87	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	34	74	finally
    //   39	43	74	finally
    //   50	67	74	finally
    //   17	34	87	java/lang/Exception
    //   39	43	87	java/lang/Exception
    //   50	67	87	java/lang/Exception
  }
  
  public static boolean c()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if (!rp.a().b())
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = NetworkInterface.getNetworkInterfaces();
        if (localObject2 != null)
        {
          localObject2 = Collections.list((Enumeration)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject1).add(new ahm((NetworkInterface)((Iterator)localObject2).next()));
          }
        }
        localObject1 = Collections.enumeration((Collection)localObject1);
      }
      if (localObject1 != null)
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ahm)((Iterator)localObject1).next();
          if ((((ahm)localObject2).a.isUp()) && (((ahm)localObject2).a.getInterfaceAddresses().size() != 0))
          {
            localObject2 = ((ahm)localObject2).a.getName();
            boolean bool = ((String)localObject2).matches("tun\\d+");
            if (bool) {
              return true;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label156:
      break label156;
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      boolean bool = b(paramContext);
      return bool;
    }
    catch (Throwable paramContext)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 404	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 768	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 417	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokevirtual 771	java/io/FileInputStream:available	()I
    //   22: invokespecial 773	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_0
    //   26: sipush 4096
    //   29: newarray byte
    //   31: astore_2
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 776	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iconst_m1
    //   39: iload_1
    //   40: if_icmpeq +13 -> 53
    //   43: aload_0
    //   44: aload_2
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 780	java/io/OutputStream:write	([BII)V
    //   50: goto -18 -> 32
    //   53: aload_0
    //   54: invokevirtual 428	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore 4
    //   59: aload 4
    //   61: astore_2
    //   62: aload 4
    //   64: ifnonnull +9 -> 73
    //   67: ldc 229
    //   69: invokevirtual 782	java/lang/String:getBytes	()[B
    //   72: astore_2
    //   73: aload_3
    //   74: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   77: aload_0
    //   78: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   81: aload_2
    //   82: areturn
    //   83: astore 4
    //   85: aload_0
    //   86: astore_2
    //   87: aload 4
    //   89: astore_0
    //   90: goto +35 -> 125
    //   93: aload_0
    //   94: astore_2
    //   95: goto +21 -> 116
    //   98: astore_0
    //   99: aload 4
    //   101: astore_2
    //   102: goto +23 -> 125
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: goto +14 -> 125
    //   114: aconst_null
    //   115: astore_3
    //   116: new 276	java/io/IOException
    //   119: dup
    //   120: invokespecial 783	java/io/IOException:<init>	()V
    //   123: athrow
    //   124: astore_0
    //   125: aload_3
    //   126: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   129: aload_2
    //   130: invokestatic 205	com/tencent/token/aez:a	(Ljava/io/Closeable;)V
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -22 -> 114
    //   139: astore_0
    //   140: goto -24 -> 116
    //   143: astore_2
    //   144: goto -51 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   37	10	1	i	int
    //   4	126	2	localObject1	Object
    //   143	1	2	localThrowable	Throwable
    //   13	113	3	localFileInputStream	java.io.FileInputStream
    //   1	62	4	arrayOfByte	byte[]
    //   83	26	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	32	83	finally
    //   32	38	83	finally
    //   43	50	83	finally
    //   53	59	83	finally
    //   67	73	83	finally
    //   14	26	98	finally
    //   5	14	105	finally
    //   116	124	124	finally
    //   5	14	135	java/lang/Throwable
    //   14	26	139	java/lang/Throwable
    //   26	32	143	java/lang/Throwable
    //   32	38	143	java/lang/Throwable
    //   43	50	143	java/lang/Throwable
    //   53	59	143	java/lang/Throwable
    //   67	73	143	java/lang/Throwable
  }
  
  private static int d()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return 0;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject1 = new HashSet();
    int j = 0;
    try
    {
      localObject2 = new String(c(afg.a(afg.n)));
      localObject2 = ((String)localObject2).split("\\n");
      paramContext = paramContext.getPackageName();
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        String str = a(localObject2[i], paramContext);
        if (str != null) {
          ((Set)localObject1).add(str);
        }
        i += 1;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject2;
      int i;
      label87:
      break label87;
    }
    localObject1 = afp.a((Set)localObject1);
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
  
  public static byte[] d(String paramString)
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
  
  public static byte[] d(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(d("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String e(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String e(byte[] paramArrayOfByte)
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
  
  public static String f(Context paramContext)
  {
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label25:
      break label25;
    }
    return "";
  }
  
  private static byte[] f(byte[] paramArrayOfByte)
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
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label34:
      break label34;
    }
    localObject = null;
    return localObject;
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getContentResolver();
      paramContext = Settings.Secure.getString(paramContext, "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aez
 * JD-Core Version:    0.7.0.1
 */