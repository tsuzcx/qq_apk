package com.tencent.turingfd.sdk.base;

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

public class cm
{
  public static Context a;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    return paramInt1 | i << paramInt2;
  }
  
  public static int a(SparseArray<Object> paramSparseArray)
  {
    paramSparseArray = (Integer)a(paramSparseArray, 0, Integer.class);
    if (paramSparseArray == null) {
      return -1;
    }
    return paramSparseArray.intValue();
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt, char paramChar)
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
  
  public static <T extends break> T a(byte[] paramArrayOfByte, T paramT, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayOfByte != null)
    {
      if (paramT == null) {
        return null;
      }
      localObject = paramT;
      if (!paramBoolean) {}
    }
    try
    {
      localObject = paramT.a();
      ((break)localObject).b();
      paramArrayOfByte = new cy(paramArrayOfByte);
      paramArrayOfByte.b = "UTF-8";
      ((break)localObject).a(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return null;
  }
  
  public static <E> E a(SparseArray<Object> paramSparseArray, int paramInt, Class<E> paramClass)
  {
    Object localObject1 = null;
    if (paramSparseArray == null) {
      return null;
    }
    Object localObject2 = paramSparseArray.get(paramInt);
    paramSparseArray = localObject1;
    if (paramClass.isInstance(localObject2)) {
      paramSparseArray = paramClass.cast(localObject2);
    }
    return paramSparseArray;
  }
  
  public static String a(int paramInt)
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
    //   12: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   15: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +22 -> 42
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_0
    //   26: invokevirtual 126	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: getfield 131	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   38: astore_0
    //   39: goto +5 -> 44
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +5 -> 50
    //   48: aload_0
    //   49: areturn
    //   50: new 133	java/util/zip/ZipFile
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 136	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload 6
    //   61: astore_1
    //   62: aload 5
    //   64: astore_2
    //   65: aload_3
    //   66: aload_3
    //   67: ldc 138
    //   69: invokevirtual 142	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   72: invokevirtual 146	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_1
    //   80: aload 4
    //   82: astore_2
    //   83: new 148	com/tencent/turingfd/sdk/base/cw
    //   86: dup
    //   87: invokespecial 150	com/tencent/turingfd/sdk/base/cw:<init>	()V
    //   90: aload 4
    //   92: invokevirtual 153	com/tencent/turingfd/sdk/base/cw:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   95: invokeinterface 159 1 0
    //   100: iconst_0
    //   101: invokeinterface 165 2 0
    //   106: invokeinterface 171 1 0
    //   111: astore 5
    //   113: aload 4
    //   115: astore_1
    //   116: aload 4
    //   118: astore_2
    //   119: aload 5
    //   121: ldc 173
    //   123: invokeinterface 179 2 0
    //   128: invokeinterface 183 1 0
    //   133: astore 5
    //   135: aload 4
    //   137: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   140: aload 5
    //   142: astore_1
    //   143: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   146: bipush 19
    //   148: if_icmplt +13 -> 161
    //   151: aload 5
    //   153: astore_1
    //   154: aload_3
    //   155: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   158: aload 5
    //   160: areturn
    //   161: aload 5
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 192	java/util/zip/ZipFile:close	()V
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
    //   181: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   184: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   187: bipush 19
    //   189: if_icmplt +10 -> 199
    //   192: aload_3
    //   193: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   196: goto +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 192	java/util/zip/ZipFile:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: aconst_null
    //   206: astore_3
    //   207: aload 4
    //   209: astore_2
    //   210: aload_2
    //   211: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   214: aload_0
    //   215: astore_1
    //   216: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   219: bipush 19
    //   221: if_icmplt +11 -> 232
    //   224: aload_0
    //   225: astore_1
    //   226: aload_3
    //   227: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   230: aload_0
    //   231: areturn
    //   232: aload_0
    //   233: astore_1
    //   234: aload_3
    //   235: invokevirtual 192	java/util/zip/ZipFile:close	()V
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
    //   4: new 195	java/io/BufferedReader
    //   7: dup
    //   8: new 197	java/io/FileReader
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 200	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   16: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +9 -> 35
    //   29: aload_0
    //   30: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
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
    //   56: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   59: aload_1
    //   60: athrow
    //   61: aload_0
    //   62: ifnull +7 -> 69
    //   65: aload_0
    //   66: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   69: ldc 73
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
  
  public static String a(String paramString1, String paramString2)
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
    paramString1 = new StringBuilder();
    paramString1.append("/data/data/");
    paramString1.append(paramString2);
    paramString1.append("/");
    paramString1 = paramString1.toString();
    if (str.startsWith(paramString1)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/app/");
    localStringBuilder.append(paramString2);
    if (str.startsWith(localStringBuilder.toString())) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("^/data/user/\\d+/");
    localStringBuilder.append(paramString2);
    if (Pattern.compile(localStringBuilder.toString()).matcher(str).find()) {
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
      label262:
      break label262;
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
    //   4: ldc_w 318
    //   7: astore_1
    //   8: ldc_w 320
    //   11: astore_2
    //   12: goto +11 -> 23
    //   15: ldc_w 322
    //   18: astore_1
    //   19: ldc_w 324
    //   22: astore_2
    //   23: aconst_null
    //   24: astore 4
    //   26: new 268	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_1
    //   36: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: ldc_w 326
    //   44: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 195	java/io/BufferedReader
    //   51: dup
    //   52: new 197	java/io/FileReader
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 327	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   63: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore 5
    //   73: aload 5
    //   75: ifnull +98 -> 173
    //   78: aload 5
    //   80: invokevirtual 330	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   83: aload_2
    //   84: invokevirtual 333	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +86 -> 173
    //   90: new 268	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_2
    //   105: ldc_w 335
    //   108: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: new 195	java/io/BufferedReader
    //   115: dup
    //   116: new 197	java/io/FileReader
    //   119: dup
    //   120: aload_2
    //   121: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 327	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   127: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 4
    //   137: aload_1
    //   138: astore_2
    //   139: aload 4
    //   141: ifnull +34 -> 175
    //   144: aload 4
    //   146: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore_2
    //   150: aload_3
    //   151: invokevirtual 336	java/io/BufferedReader:close	()V
    //   154: aload_1
    //   155: invokevirtual 336	java/io/BufferedReader:close	()V
    //   158: aload_2
    //   159: areturn
    //   160: astore 4
    //   162: aload_1
    //   163: astore_2
    //   164: aload 4
    //   166: astore_1
    //   167: goto +39 -> 206
    //   170: goto +61 -> 231
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_3
    //   176: invokevirtual 336	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: ifnull +70 -> 250
    //   183: aload_2
    //   184: astore_1
    //   185: goto +61 -> 246
    //   188: astore_1
    //   189: aload 4
    //   191: astore_2
    //   192: goto +14 -> 206
    //   195: aconst_null
    //   196: astore_1
    //   197: goto +34 -> 231
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: aload 4
    //   205: astore_2
    //   206: aload_3
    //   207: ifnull +10 -> 217
    //   210: aload_3
    //   211: invokevirtual 336	java/io/BufferedReader:close	()V
    //   214: goto +3 -> 217
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 336	java/io/BufferedReader:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: aconst_null
    //   228: astore_1
    //   229: aload_1
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +10 -> 242
    //   235: aload_3
    //   236: invokevirtual 336	java/io/BufferedReader:close	()V
    //   239: goto +3 -> 242
    //   242: aload_1
    //   243: ifnull +7 -> 250
    //   246: aload_1
    //   247: invokevirtual 336	java/io/BufferedReader:close	()V
    //   250: ldc 73
    //   252: areturn
    //   253: astore_1
    //   254: goto -27 -> 227
    //   257: astore_1
    //   258: goto -63 -> 195
    //   261: astore_2
    //   262: goto -92 -> 170
    //   265: astore_3
    //   266: goto -112 -> 154
    //   269: astore_1
    //   270: aload_2
    //   271: areturn
    //   272: astore_1
    //   273: goto -94 -> 179
    //   276: astore_3
    //   277: goto -60 -> 217
    //   280: astore_2
    //   281: goto -56 -> 225
    //   284: astore_2
    //   285: goto -43 -> 242
    //   288: astore_1
    //   289: goto -39 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramBoolean	boolean
    //   7	178	1	localObject1	Object
    //   188	1	1	localObject2	Object
    //   196	1	1	localObject3	Object
    //   200	26	1	localObject4	Object
    //   228	19	1	localObject5	Object
    //   253	1	1	localThrowable1	Throwable
    //   257	1	1	localThrowable2	Throwable
    //   269	1	1	localIOException1	IOException
    //   272	1	1	localIOException2	IOException
    //   288	1	1	localIOException3	IOException
    //   11	211	2	localObject6	Object
    //   261	10	2	localThrowable3	Throwable
    //   280	1	2	localIOException4	IOException
    //   284	1	2	localIOException5	IOException
    //   33	203	3	localObject7	Object
    //   265	1	3	localIOException6	IOException
    //   276	1	3	localIOException7	IOException
    //   24	121	4	str1	String
    //   160	44	4	localObject8	Object
    //   71	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   131	137	160	finally
    //   144	150	160	finally
    //   67	73	188	finally
    //   78	104	188	finally
    //   104	131	188	finally
    //   26	40	200	finally
    //   40	67	200	finally
    //   26	40	253	java/lang/Throwable
    //   40	67	253	java/lang/Throwable
    //   67	73	257	java/lang/Throwable
    //   78	104	257	java/lang/Throwable
    //   104	131	257	java/lang/Throwable
    //   131	137	261	java/lang/Throwable
    //   144	150	261	java/lang/Throwable
    //   150	154	265	java/io/IOException
    //   154	158	269	java/io/IOException
    //   175	179	272	java/io/IOException
    //   210	214	276	java/io/IOException
    //   221	225	280	java/io/IOException
    //   235	239	284	java/io/IOException
    //   246	250	288	java/io/IOException
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
  
  public static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
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
  
  public static void a(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
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
    //   4: new 345	java/io/BufferedOutputStream
    //   7: dup
    //   8: new 347	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 348	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 351	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 354	java/io/BufferedOutputStream:write	([B)V
    //   25: aload_0
    //   26: invokevirtual 357	java/io/BufferedOutputStream:flush	()V
    //   29: aload_0
    //   30: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   33: iconst_1
    //   34: ireturn
    //   35: astore_1
    //   36: goto +9 -> 45
    //   39: goto +12 -> 51
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: aload_0
    //   46: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   49: aload_1
    //   50: athrow
    //   51: aload_0
    //   52: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
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
    db localdb = new db();
    localdb.b = "UTF-8";
    parambreak.a(localdb);
    return localdb.a();
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 311	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 371	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 373	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 374	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   41: invokevirtual 378	java/io/FileInputStream:read	([BII)I
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
    //   71: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
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
    //   93: invokestatic 384	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   96: aload 6
    //   98: astore 5
    //   100: goto +3 -> 103
    //   103: aload_0
    //   104: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   107: aload 5
    //   109: areturn
    //   110: astore 5
    //   112: goto +7 -> 119
    //   115: astore 5
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   123: aload 5
    //   125: athrow
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
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
  
  public static byte[] a(byte[] paramArrayOfByte)
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
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte2);
    paramArrayOfByte2 = paramArrayOfByte1;
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte2 = paramArrayOfByte1;
      if (arrayOfByte != null)
      {
        if (paramArrayOfByte1.length == 0) {
          return paramArrayOfByte1;
        }
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
        j = arrayOfInt[0];
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
    return paramArrayOfByte2;
  }
  
  /* Error */
  public static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 411	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aload_2
    //   10: iconst_0
    //   11: aload_2
    //   12: arraylength
    //   13: invokevirtual 414	java/io/InputStream:read	([BII)I
    //   16: iconst_m1
    //   17: if_icmpeq +6 -> 23
    //   20: goto -12 -> 8
    //   23: aload_3
    //   24: astore_2
    //   25: aload_1
    //   26: ifnull +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 420	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   33: astore_2
    //   34: aload_0
    //   35: invokevirtual 421	java/io/InputStream:close	()V
    //   38: aload_2
    //   39: areturn
    //   40: astore_2
    //   41: aload_0
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: goto +6 -> 51
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +7 -> 59
    //   55: aload_1
    //   56: invokevirtual 421	java/io/InputStream:close	()V
    //   59: aload_0
    //   60: athrow
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 421	java/io/InputStream:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_0
    //   74: goto -13 -> 61
    //   77: astore_1
    //   78: goto -15 -> 63
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: goto -26 -> 59
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramJarFile	java.util.jar.JarFile
    //   0	91	1	paramJarEntry	java.util.jar.JarEntry
    //   0	91	2	paramArrayOfByte	byte[]
    //   1	23	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	20	40	finally
    //   29	34	40	finally
    //   2	8	48	finally
    //   2	8	73	java/io/IOException
    //   8	20	77	java/io/IOException
    //   29	34	77	java/io/IOException
    //   34	38	81	java/io/IOException
    //   55	59	84	java/io/IOException
    //   67	71	88	java/io/IOException
  }
  
  public static w b(int paramInt)
  {
    Object localObject2 = null;
    try
    {
      str = a(paramInt);
    }
    catch (Throwable localThrowable1)
    {
      String str;
      Object localObject1;
      Object localObject3;
      label69:
      int m;
      label193:
      break label193;
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
        break label69;
      }
      i = Integer.parseInt((String)((HashMap)localObject1).get("PPid"));
    }
    catch (Throwable localThrowable2)
    {
      break label196;
    }
    try
    {
      localObject3 = (String)((HashMap)localObject1).get("Uid");
      k = Integer.parseInt(localObject3.split("\\s+")[0]);
    }
    catch (Throwable localThrowable3)
    {
      j = i;
      break label198;
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
      break label200;
    }
    str = null;
    label196:
    j = -1;
    label198:
    i = -1;
    label200:
    k = i;
    i = -1;
    localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (j != -1)
      {
        if (k == -1) {
          return null;
        }
        localObject1 = new w(paramInt, j, str, k, null, i);
      }
    }
    return localObject1;
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 73
    //   2: astore_2
    //   3: aload_0
    //   4: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: astore_3
    //   8: new 464	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 468	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   23: getfield 474	android/content/pm/ApplicationInfo:uid	I
    //   26: invokevirtual 478	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   29: iconst_0
    //   30: aaload
    //   31: bipush 64
    //   33: invokevirtual 481	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   36: getfield 485	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   39: iconst_0
    //   40: aaload
    //   41: invokevirtual 490	android/content/pm/Signature:toByteArray	()[B
    //   44: invokespecial 491	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: astore_0
    //   48: ldc_w 493
    //   51: invokestatic 498	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   54: aload_0
    //   55: invokevirtual 502	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   58: checkcast 504	java/security/cert/X509Certificate
    //   61: invokevirtual 507	java/security/cert/X509Certificate:getEncoded	()[B
    //   64: invokestatic 510	com/tencent/turingfd/sdk/base/cm:d	([B)Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
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
    //   88: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   91: aload_1
    //   92: athrow
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull +9 -> 105
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   105: ldc 73
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
  
  public static void b(Closeable paramCloseable)
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
    Object localObject1 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) {
      return false;
    }
    try
    {
      localObject2 = ((WifiManager)localObject1).getConnectionInfo();
      if (localObject2 != null)
      {
        if (((WifiInfo)localObject2).getNetworkId() == -1) {
          return false;
        }
        paramContext = null;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject2;
      label121:
      return false;
    }
    try
    {
      localObject1 = ((WifiManager)localObject1).getConfiguredNetworks();
      paramContext = (Context)localObject1;
    }
    catch (Throwable localThrowable)
    {
      break label121;
    }
    if (paramContext == null) {
      return false;
    }
    localObject1 = ((WifiInfo)localObject2).getSSID();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      localObject2 = (WifiConfiguration)paramContext.next();
      if (!TextUtils.equals(((WifiConfiguration)localObject2).SSID, (CharSequence)localObject1))
      {
        String str = ((WifiConfiguration)localObject2).SSID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\"");
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
          paramContext = cn.a(WifiConfiguration.class, "proxySettings", localObject2);
          localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
        }
        else
        {
          paramContext = cn.b(WifiConfiguration.class, "getProxySettings", localObject2);
          localObject1 = "android.net.IpConfiguration$ProxySettings";
        }
        localObject2 = cn.a((String)localObject1, "STATIC");
        if ((localObject2 != null) && (localObject2 == paramContext)) {
          return true;
        }
        if (i >= 19)
        {
          localObject1 = cn.a((String)localObject1, "PAC");
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
      String str = ct.a(ct.aA);
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
    //   0: new 311	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_0
    //   15: new 665	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 4
    //   21: ldc_w 667
    //   24: invokespecial 670	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: invokevirtual 673	java/io/RandomAccessFile:length	()J
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
    //   52: invokevirtual 676	java/io/RandomAccessFile:readFully	([B)V
    //   55: aload 4
    //   57: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore 4
    //   64: goto +64 -> 128
    //   67: new 250	java/io/IOException
    //   70: dup
    //   71: ldc 73
    //   73: invokespecial 678	java/io/IOException:<init>	(Ljava/lang/String;)V
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
    //   117: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   120: aload 5
    //   122: areturn
    //   123: astore 4
    //   125: aload 5
    //   127: astore_0
    //   128: aload 4
    //   130: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   133: aload_0
    //   134: areturn
    //   135: aload_0
    //   136: ifnull +15 -> 151
    //   139: aload_0
    //   140: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   143: goto +8 -> 151
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 679	java/io/IOException:printStackTrace	()V
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
    //   0: new 681	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 682	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 684	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 685	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 686	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 689	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 692	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 692	java/util/zip/DeflaterOutputStream:close	()V
    //   57: goto +8 -> 65
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: athrow
    //   67: aload_1
    //   68: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_2
    //   72: invokevirtual 692	java/util/zip/DeflaterOutputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: goto -18 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	9	1	localIOException1	IOException
    //   60	8	1	localIOException2	IOException
    //   16	56	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	60	java/io/IOException
    //   67	75	77	java/io/IOException
    //   17	31	84	java/lang/Exception
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte2);
    if ((paramArrayOfByte1 != null) && (arrayOfByte != null))
    {
      if (paramArrayOfByte1.length == 0) {
        return paramArrayOfByte1;
      }
      if (paramArrayOfByte1.length % 4 == 0)
      {
        if (paramArrayOfByte1.length < 8) {
          return null;
        }
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
        i = paramArrayOfByte2[m];
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
        i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
        if (i >= 0)
        {
          if (i > paramArrayOfByte2.length - 1 << 2) {
            return null;
          }
          paramArrayOfByte1 = new byte[i];
          a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
          return paramArrayOfByte1;
        }
      }
      return null;
    }
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static List<String> c(File paramFile)
  {
    // Byte code:
    //   0: new 696	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 697	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 410	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 698	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc 138
    //   21: invokevirtual 702	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   24: sipush 8192
    //   27: newarray byte
    //   29: invokestatic 704	com/tencent/turingfd/sdk/base/cm:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
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
    //   55: invokevirtual 707	java/security/cert/Certificate:getEncoded	()[B
    //   58: invokestatic 510	com/tencent/turingfd/sdk/base/cm:d	([B)Ljava/lang/String;
    //   61: invokeinterface 710 2 0
    //   66: pop
    //   67: iload_1
    //   68: iconst_1
    //   69: iadd
    //   70: istore_1
    //   71: goto -26 -> 45
    //   74: astore_3
    //   75: aload_0
    //   76: invokevirtual 711	java/util/jar/JarFile:close	()V
    //   79: aload_3
    //   80: athrow
    //   81: aload_0
    //   82: invokevirtual 711	java/util/jar/JarFile:close	()V
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
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      if (localObject1 != null)
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
          if ((((NetworkInterface)localObject2).isUp()) && (((NetworkInterface)localObject2).getInterfaceAddresses().size() != 0))
          {
            localObject2 = ((NetworkInterface)localObject2).getName();
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
      label76:
      break label76;
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
    //   5: new 373	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 745	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 681	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokevirtual 748	java/io/FileInputStream:available	()I
    //   22: invokespecial 751	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_0
    //   26: sipush 4096
    //   29: newarray byte
    //   31: astore_2
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 754	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iconst_m1
    //   39: iload_1
    //   40: if_icmpeq +13 -> 53
    //   43: aload_0
    //   44: aload_2
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 758	java/io/OutputStream:write	([BII)V
    //   50: goto -18 -> 32
    //   53: aload_0
    //   54: invokevirtual 690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +6 -> 65
    //   62: goto +9 -> 71
    //   65: ldc 73
    //   67: invokevirtual 760	java/lang/String:getBytes	()[B
    //   70: astore_2
    //   71: aload_3
    //   72: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   75: aload_0
    //   76: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   79: aload_2
    //   80: areturn
    //   81: astore 4
    //   83: aload_0
    //   84: astore_2
    //   85: aload 4
    //   87: astore_0
    //   88: goto +35 -> 123
    //   91: aload_0
    //   92: astore_2
    //   93: goto +21 -> 114
    //   96: astore_0
    //   97: aload 4
    //   99: astore_2
    //   100: goto +23 -> 123
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_3
    //   106: aload 4
    //   108: astore_2
    //   109: goto +14 -> 123
    //   112: aconst_null
    //   113: astore_3
    //   114: new 250	java/io/IOException
    //   117: dup
    //   118: invokespecial 761	java/io/IOException:<init>	()V
    //   121: athrow
    //   122: astore_0
    //   123: aload_3
    //   124: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   127: aload_2
    //   128: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   131: aload_0
    //   132: athrow
    //   133: astore_0
    //   134: goto -22 -> 112
    //   137: astore_0
    //   138: goto -24 -> 114
    //   141: astore_2
    //   142: goto -51 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   37	10	1	i	int
    //   4	124	2	localObject1	Object
    //   141	1	2	localThrowable	Throwable
    //   13	111	3	localFileInputStream	java.io.FileInputStream
    //   1	1	4	localObject2	Object
    //   81	26	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	32	81	finally
    //   32	38	81	finally
    //   43	50	81	finally
    //   53	58	81	finally
    //   65	71	81	finally
    //   14	26	96	finally
    //   5	14	103	finally
    //   114	122	122	finally
    //   5	14	133	java/lang/Throwable
    //   14	26	137	java/lang/Throwable
    //   26	32	141	java/lang/Throwable
    //   32	38	141	java/lang/Throwable
    //   43	50	141	java/lang/Throwable
    //   53	58	141	java/lang/Throwable
    //   65	71	141	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 464	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 491	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 763	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 766	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 681	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 682	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 768	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +11 -> 44
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 770	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: aload_3
    //   45: invokevirtual 690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: astore 4
    //   50: aload_0
    //   51: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: invokevirtual 771	java/util/zip/InflaterInputStream:close	()V
    //   58: aload_3
    //   59: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   62: aload 4
    //   64: areturn
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   70: aload 4
    //   72: areturn
    //   73: astore 4
    //   75: aload_0
    //   76: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   79: aload_2
    //   80: invokevirtual 771	java/util/zip/InflaterInputStream:close	()V
    //   83: aload_3
    //   84: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   87: goto +8 -> 95
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   95: aload 4
    //   97: athrow
    //   98: aload_0
    //   99: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   102: aload_2
    //   103: invokevirtual 771	java/util/zip/InflaterInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 679	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore 4
    //   121: goto -23 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	86	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	82	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   48	23	4	arrayOfByte	byte[]
    //   73	23	4	localObject	Object
    //   119	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   50	62	65	java/io/IOException
    //   26	31	73	finally
    //   36	41	73	finally
    //   44	50	73	finally
    //   75	87	90	java/io/IOException
    //   98	110	112	java/io/IOException
    //   26	31	119	java/lang/Exception
    //   36	41	119	java/lang/Exception
    //   44	50	119	java/lang/Exception
  }
  
  public static int d()
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
      localObject2 = new String(c(ct.a(ct.n)));
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
    localObject1 = dc.a((Set)localObject1);
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
  
  public static String d(byte[] paramArrayOfByte)
  {
    return f(e(paramArrayOfByte));
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
  
  public static SparseArray<Object> e()
  {
    return new SparseArray();
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
  
  public static byte[] e(byte[] paramArrayOfByte)
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
  
  public static String f(byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.cm
 * JD-Core Version:    0.7.0.1
 */