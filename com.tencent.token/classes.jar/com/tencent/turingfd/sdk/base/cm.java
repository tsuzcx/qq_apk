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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class cm
{
  public static Context a;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      return 1 << paramInt2 | paramInt1;
    }
    return 0 << paramInt2 | paramInt1;
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
    for (;;)
    {
      int i = paramInt + 1;
      if (paramInt < paramArrayOfByte.length)
      {
        if ((i == paramArrayOfByte.length) || (paramArrayOfByte[i] == paramChar)) {
          return i;
        }
      }
      else {
        return 0;
      }
      paramInt = i;
    }
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
    if ((paramArrayOfByte == null) || (paramT == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramT = paramT.a();
        paramT.b();
        paramArrayOfByte = new cy(paramArrayOfByte);
        paramArrayOfByte.b = "UTF-8";
        paramT.a(paramArrayOfByte);
        return paramT;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static <E> E a(SparseArray<Object> paramSparseArray, int paramInt, Class<E> paramClass)
  {
    if (paramSparseArray == null) {}
    do
    {
      return null;
      paramSparseArray = paramSparseArray.get(paramInt);
    } while (!paramClass.isInstance(paramSparseArray));
    return paramClass.cast(paramSparseArray);
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
      byte[] arrayOfByte;
      if (TextUtils.isEmpty(str))
      {
        localObject = Locale.ENGLISH;
        arrayOfByte = a(String.format((Locale)localObject, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) }), 150);
        localObject = str;
        if (arrayOfByte != null)
        {
          paramInt = a(arrayOfByte, 7, '\n');
          if (paramInt != 0) {
            break label111;
          }
          localObject = "";
        }
      }
      return localObject;
      label111:
      str = new String(arrayOfByte, 6, paramInt - 6);
      return str;
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
    //   2: aload_0
    //   3: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   6: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +26 -> 37
    //   14: aload_0
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 126	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +15 -> 37
    //   25: aload_0
    //   26: getfield 131	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +11 -> 42
    //   34: aload_0
    //   35: areturn
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_0
    //   39: goto -9 -> 30
    //   42: new 133	java/util/zip/ZipFile
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 136	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_3
    //   53: ldc 138
    //   55: invokevirtual 142	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   58: invokevirtual 146	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 148	com/tencent/turingfd/sdk/base/cw
    //   65: dup
    //   66: invokespecial 150	com/tencent/turingfd/sdk/base/cw:<init>	()V
    //   69: aload_1
    //   70: invokevirtual 153	com/tencent/turingfd/sdk/base/cw:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   73: invokeinterface 159 1 0
    //   78: iconst_0
    //   79: invokeinterface 165 2 0
    //   84: invokeinterface 171 1 0
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 173
    //   93: invokeinterface 179 2 0
    //   98: invokeinterface 183 1 0
    //   103: astore_2
    //   104: aload_1
    //   105: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   108: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   111: bipush 19
    //   113: if_icmplt +12 -> 125
    //   116: aload_3
    //   117: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   120: aload_2
    //   121: astore_0
    //   122: goto +107 -> 229
    //   125: aload_3
    //   126: invokevirtual 192	java/util/zip/ZipFile:close	()V
    //   129: aload_2
    //   130: astore_0
    //   131: goto +98 -> 229
    //   134: astore_0
    //   135: aload_2
    //   136: astore_0
    //   137: goto +92 -> 229
    //   140: astore_2
    //   141: aload_1
    //   142: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   145: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   148: bipush 19
    //   150: if_icmplt +58 -> 208
    //   153: aload_3
    //   154: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   157: goto +72 -> 229
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   167: invokestatic 189	com/tencent/turingfd/sdk/base/cm:d	()I
    //   170: bipush 19
    //   172: if_icmplt +17 -> 189
    //   175: aload_3
    //   176: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_3
    //   186: goto -23 -> 163
    //   189: aload_3
    //   190: invokevirtual 192	java/util/zip/ZipFile:close	()V
    //   193: goto -14 -> 179
    //   196: astore_1
    //   197: goto -18 -> 179
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_2
    //   204: astore_1
    //   205: goto -64 -> 141
    //   208: aload_3
    //   209: invokevirtual 192	java/util/zip/ZipFile:close	()V
    //   212: goto -55 -> 157
    //   215: astore_1
    //   216: goto -59 -> 157
    //   219: astore_1
    //   220: aload_2
    //   221: astore_1
    //   222: goto -81 -> 141
    //   225: astore_0
    //   226: goto -63 -> 163
    //   229: aload_0
    //   230: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   0	231	1	paramString	String
    //   1	135	2	localObject	Object
    //   140	81	2	localThrowable	Throwable
    //   50	159	3	localZipFile	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   2	10	36	java/lang/Throwable
    //   14	21	36	java/lang/Throwable
    //   25	30	36	java/lang/Throwable
    //   108	120	134	java/lang/Throwable
    //   125	129	134	java/lang/Throwable
    //   62	90	140	java/lang/Throwable
    //   90	104	140	java/lang/Throwable
    //   51	62	160	finally
    //   42	51	181	finally
    //   167	179	196	java/lang/Throwable
    //   189	193	196	java/lang/Throwable
    //   42	51	200	java/lang/Throwable
    //   145	157	215	java/lang/Throwable
    //   208	212	215	java/lang/Throwable
    //   51	62	219	java/lang/Throwable
    //   62	90	225	finally
    //   90	104	225	finally
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 73
    //   2: astore_1
    //   3: new 195	java/io/BufferedReader
    //   6: dup
    //   7: new 197	java/io/FileReader
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 200	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   15: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_0
    //   31: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   40: aload_1
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   53: aload_1
    //   54: athrow
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull -25 -> 34
    //   62: aload_0
    //   63: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   66: ldc 73
    //   68: areturn
    //   69: astore_2
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: goto -29 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramFile	File
    //   2	39	1	localObject1	Object
    //   42	12	1	localObject2	Object
    //   73	1	1	localObject3	Object
    //   23	2	2	str	String
    //   69	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	19	42	finally
    //   3	19	55	java/lang/Throwable
    //   19	24	69	java/lang/Throwable
    //   19	24	73	finally
  }
  
  public static String a(String paramString)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("DES");
      byte[] arrayOfByte = "MnKd0x$9".getBytes("UTF-8");
      localCipher.init(2, new SecretKeySpec(arrayOfByte, "DES"));
      if (TextUtils.isEmpty(paramString))
      {
        paramString = null;
        paramString = localCipher.doFinal(paramString);
        return new String(paramString, "UTF-8");
      }
      char[] arrayOfChar = paramString.toCharArray();
      int j = arrayOfChar.length / 2;
      arrayOfByte = new byte[j];
      int i = 0;
      for (;;)
      {
        paramString = arrayOfByte;
        if (i >= j) {
          break;
        }
        int k = i * 2;
        int m = Character.digit(arrayOfChar[k], 16);
        arrayOfByte[i] = ((byte)((Character.digit(arrayOfChar[(k + 1)], 16) | m << 4) & 0xFF));
        i += 1;
      }
      return "";
    }
    catch (Throwable paramString) {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return null;
      int i = paramString1.indexOf('/');
      if (i == -1) {
        continue;
      }
      String str = paramString1.substring(i).trim();
      if (!str.startsWith("/data/")) {
        continue;
      }
      paramString1 = "/data/data/" + paramString2 + "/";
      if ((str.startsWith(paramString1)) || (str.startsWith("/data/app/" + paramString2)) || (Pattern.compile("^/data/user/\\d+/" + paramString2).matcher(str).find())) {
        continue;
      }
      boolean bool = str.endsWith(".so");
      if ((!bool) && (str.endsWith(".jar")))
      {
        i = 1;
        if ((!bool) && (i == 0)) {
          continue;
        }
        if (bool) {
          paramString1 = new File(paramString1 + "lib");
        }
      }
      try
      {
        paramString1 = paramString1.getCanonicalPath();
        if ((paramString1 == null) || (str.startsWith(paramString1))) {
          continue;
        }
        return str;
        i = 0;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: iload_0
    //   10: ifeq +141 -> 151
    //   13: ldc_w 318
    //   16: astore 4
    //   18: ldc_w 320
    //   21: astore_3
    //   22: new 268	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   29: aload 4
    //   31: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: astore_1
    //   35: new 195	java/io/BufferedReader
    //   38: dup
    //   39: new 197	java/io/FileReader
    //   42: dup
    //   43: aload_1
    //   44: ldc_w 322
    //   47: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 323	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   56: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 8
    //   66: aload 7
    //   68: astore_2
    //   69: aload 8
    //   71: ifnull +143 -> 214
    //   74: aload 7
    //   76: astore_2
    //   77: aload 8
    //   79: invokevirtual 326	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   82: aload_3
    //   83: invokevirtual 329	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +128 -> 214
    //   89: new 268	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   96: aload 4
    //   98: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: astore_2
    //   102: new 195	java/io/BufferedReader
    //   105: dup
    //   106: new 197	java/io/FileReader
    //   109: dup
    //   110: aload_2
    //   111: ldc_w 331
    //   114: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 323	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: ifnull +81 -> 214
    //   136: aload_3
    //   137: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 332	java/io/BufferedReader:close	()V
    //   145: aload_2
    //   146: invokevirtual 332	java/io/BufferedReader:close	()V
    //   149: aload_3
    //   150: areturn
    //   151: ldc_w 334
    //   154: astore 4
    //   156: ldc_w 336
    //   159: astore_3
    //   160: goto -138 -> 22
    //   163: astore 4
    //   165: aload_2
    //   166: astore_3
    //   167: aload 4
    //   169: astore_2
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 332	java/io/BufferedReader:close	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 332	java/io/BufferedReader:close	()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_3
    //   189: aload_1
    //   190: astore_3
    //   191: aload_2
    //   192: astore_1
    //   193: aload_3
    //   194: astore_2
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 332	java/io/BufferedReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 332	java/io/BufferedReader:close	()V
    //   211: ldc 73
    //   213: areturn
    //   214: aload_1
    //   215: invokevirtual 332	java/io/BufferedReader:close	()V
    //   218: aload_2
    //   219: ifnull -8 -> 211
    //   222: aload_2
    //   223: astore_1
    //   224: goto -17 -> 207
    //   227: astore_2
    //   228: aload_1
    //   229: astore_2
    //   230: aload 6
    //   232: astore_1
    //   233: goto -38 -> 195
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_1
    //   239: aload 5
    //   241: astore_3
    //   242: goto -72 -> 170
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_2
    //   248: aload 6
    //   250: astore_1
    //   251: goto -56 -> 195
    //   254: astore_1
    //   255: goto -110 -> 145
    //   258: astore_1
    //   259: aload_3
    //   260: areturn
    //   261: astore_1
    //   262: goto -44 -> 218
    //   265: astore_1
    //   266: goto -55 -> 211
    //   269: astore_1
    //   270: goto -92 -> 178
    //   273: astore_1
    //   274: goto -88 -> 186
    //   277: astore_2
    //   278: goto -75 -> 203
    //   281: astore_2
    //   282: aload 5
    //   284: astore_3
    //   285: goto -115 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramBoolean	boolean
    //   34	205	1	localObject1	Object
    //   245	1	1	localThrowable1	Throwable
    //   250	1	1	localObject2	Object
    //   254	1	1	localIOException1	IOException
    //   258	1	1	localIOException2	IOException
    //   261	1	1	localIOException3	IOException
    //   265	1	1	localIOException4	IOException
    //   269	1	1	localIOException5	IOException
    //   273	1	1	localIOException6	IOException
    //   68	155	2	localObject3	Object
    //   227	1	2	localThrowable2	Throwable
    //   229	1	2	localObject4	Object
    //   236	1	2	localObject5	Object
    //   247	1	2	localObject6	Object
    //   277	1	2	localIOException7	IOException
    //   281	1	2	localObject7	Object
    //   21	162	3	localObject8	Object
    //   188	1	3	localThrowable3	Throwable
    //   190	95	3	localObject9	Object
    //   16	139	4	str1	String
    //   163	5	4	localObject10	Object
    //   7	276	5	localObject11	Object
    //   1	248	6	localObject12	Object
    //   4	71	7	localObject13	Object
    //   64	14	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   127	132	163	finally
    //   136	141	163	finally
    //   127	132	188	java/lang/Throwable
    //   136	141	188	java/lang/Throwable
    //   60	66	227	java/lang/Throwable
    //   77	102	227	java/lang/Throwable
    //   102	127	227	java/lang/Throwable
    //   22	35	236	finally
    //   35	60	236	finally
    //   22	35	245	java/lang/Throwable
    //   35	60	245	java/lang/Throwable
    //   141	145	254	java/io/IOException
    //   145	149	258	java/io/IOException
    //   214	218	261	java/io/IOException
    //   207	211	265	java/io/IOException
    //   174	178	269	java/io/IOException
    //   182	186	273	java/io/IOException
    //   199	203	277	java/io/IOException
    //   60	66	281	finally
    //   77	102	281	finally
    //   102	127	281	finally
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
    int j = 0;
    int k = paramArrayOfByte.length;
    int i = 0;
    while (i < k >> 2)
    {
      int m = j + 1;
      paramArrayOfByte[j] &= 0xFF;
      int n = paramArrayOfInt[i];
      j = m + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[m] & 0xFF) << 8);
      n = paramArrayOfInt[i];
      m = j + 1;
      paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
      paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
      i += 1;
      j = m + 1;
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
    while (i < j)
    {
      int m = k + 1;
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
      j = 8;
      while ((j <= 24) && (paramInt < paramArrayOfByte.length))
      {
        paramArrayOfByte[paramInt] = ((byte)(paramArrayOfInt[i] >>> j & 0xFF));
        j += 8;
        paramInt += 1;
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 24	com/tencent/turingfd/sdk/base/cm:a	Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +8 -> 18
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_1
    //   17: ireturn
    //   18: aload_0
    //   19: ifnonnull +8 -> 27
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: aload_0
    //   28: invokevirtual 116	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +8 -> 41
    //   36: iconst_0
    //   37: istore_1
    //   38: goto -25 -> 13
    //   41: aload_0
    //   42: putstatic 24	com/tencent/turingfd/sdk/base/cm:a	Landroid/content/Context;
    //   45: goto -32 -> 13
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   1	37	1	bool	boolean
    //   8	2	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   5	9	48	finally
    //   27	32	48	finally
    //   41	45	48	finally
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 345	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 347	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 348	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 351	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 354	java/io/BufferedOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 357	java/io/BufferedOutputStream:flush	()V
    //   25: aload_0
    //   26: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: athrow
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 208	com/tencent/turingfd/sdk/base/cm:a	(Ljava/io/Closeable;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_1
    //   50: goto -7 -> 43
    //   53: astore_1
    //   54: goto -20 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramString	String
    //   0	57	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	16	31	finally
    //   0	16	40	java/lang/Throwable
    //   16	25	49	java/lang/Throwable
    //   16	25	53	finally
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
    //   0: iconst_0
    //   1: istore_2
    //   2: new 309	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 371	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 373	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 374	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: iload_1
    //   30: newarray byte
    //   32: astore 5
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
    //   78: if_icmpge +65 -> 143
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
    //   100: aload_0
    //   101: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   104: aload 5
    //   106: areturn
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: astore_0
    //   115: aload 5
    //   117: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore 5
    //   126: goto -11 -> 115
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore 5
    //   140: goto -8 -> 132
    //   143: goto -43 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramInt	int
    //   1	60	2	i	int
    //   47	46	3	j	int
    //   44	14	4	k	int
    //   32	93	5	localObject1	Object
    //   138	1	5	localThrowable	Throwable
    //   84	13	6	arrayOfByte	byte[]
    //   107	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	107	finally
    //   34	46	107	finally
    //   81	96	107	finally
    //   20	29	122	finally
    //   20	29	129	java/lang/Throwable
    //   29	34	138	java/lang/Throwable
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
      localObject = ((MessageDigest)localObject).digest();
      return localObject;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    if (paramArrayOfByte1.length % 4 == 0)
    {
      i = (paramArrayOfByte1.length >>> 2) + 1;
      paramArrayOfByte2 = new int[i];
      a(paramArrayOfByte1, paramArrayOfByte2);
      paramArrayOfByte2[(i - 1)] = paramArrayOfByte1.length;
      if (arrayOfByte.length % 4 != 0) {
        break label107;
      }
    }
    label107:
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
      i = (paramArrayOfByte1.length >>> 2) + 2;
      break;
    }
    a(arrayOfByte, paramArrayOfByte1);
    int i1 = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[i1];
    int j = paramArrayOfByte2[0];
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
        int i3 = paramArrayOfByte2[n];
        int i4 = paramArrayOfByte2[i];
        k = ((k ^ paramArrayOfByte1[(i & 0x3 ^ i2)]) + (i3 ^ m) ^ (k >>> 5 ^ i3 << 2) + (i3 >>> 3 ^ k << 4)) + i4;
        paramArrayOfByte2[i] = k;
      }
      n = paramArrayOfByte2[0];
      i = paramArrayOfByte2[i1] + ((paramArrayOfByte1[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4));
      paramArrayOfByte2[i1] = i;
      j -= 1;
    }
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length << 2];
    a(paramArrayOfByte2, paramArrayOfByte2.length, paramArrayOfByte1);
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static java.security.cert.Certificate[] a(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 411	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_2
    //   15: arraylength
    //   16: invokevirtual 414	java/io/InputStream:read	([BII)I
    //   19: iconst_m1
    //   20: if_icmpne -9 -> 11
    //   23: aload 4
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 420	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 421	java/io/InputStream:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 421	java/io/InputStream:close	()V
    //   52: aload_1
    //   53: athrow
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_3
    //   58: astore_2
    //   59: aload_0
    //   60: ifnull -21 -> 39
    //   63: aload_0
    //   64: invokevirtual 421	java/io/InputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: aconst_null
    //   71: areturn
    //   72: astore_0
    //   73: aload_2
    //   74: areturn
    //   75: astore_0
    //   76: goto -24 -> 52
    //   79: astore_1
    //   80: goto -23 -> 57
    //   83: astore_1
    //   84: goto -40 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramJarFile	java.util.jar.JarFile
    //   0	87	1	paramJarEntry	java.util.jar.JarEntry
    //   0	87	2	paramArrayOfByte	byte[]
    //   1	57	3	localObject1	Object
    //   3	21	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	41	finally
    //   5	11	54	java/io/IOException
    //   63	67	69	java/io/IOException
    //   35	39	72	java/io/IOException
    //   48	52	75	java/io/IOException
    //   11	23	79	java/io/IOException
    //   30	35	79	java/io/IOException
    //   11	23	83	finally
    //   30	35	83	finally
  }
  
  public static w b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        str1 = a(paramInt);
      }
      catch (Throwable localThrowable1)
      {
        String str1;
        Object localObject1;
        Object localObject2;
        String[] arrayOfString;
        int m;
        int k;
        String str2 = null;
        int j = -1;
        i = -1;
        continue;
        return new w(paramInt, i, str2, k, null, j);
      }
      try
      {
        localObject1 = Locale.ENGLISH;
        localObject2 = new String(c(String.format((Locale)localObject1, "/proc/%d/status", new Object[] { Integer.valueOf(paramInt) })));
        localObject1 = new HashMap();
        localObject2 = ((String)localObject2).split("\n");
        j = localObject2.length;
        if (i >= j) {
          continue;
        }
        arrayOfString = localObject2[i];
        arrayOfString = arrayOfString.split(":");
        if (arrayOfString.length < 2) {
          break label252;
        }
        ((HashMap)localObject1).put(arrayOfString[0].trim(), arrayOfString[1].trim());
      }
      catch (Throwable localThrowable2)
      {
        i = -1;
        j = -1;
        m = -1;
        k = j;
        j = m;
        if (str1 == null) {
          continue;
        }
      }
      if ((i == -1) || (k == -1))
      {
        return null;
        i = Integer.parseInt((String)localThrowable2.get("PPid"));
        try
        {
          localObject2 = (String)localThrowable2.get("Uid");
          k = Integer.parseInt(localObject2.split("\\s+")[0]);
          try
          {
            j = Integer.parseInt((String)localThrowable2.get("TracerPid"));
          }
          catch (Throwable localThrowable3)
          {
            j = k;
          }
        }
        catch (Throwable localThrowable4)
        {
          j = -1;
        }
      }
      else
      {
        label252:
        i += 1;
      }
    }
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_2
    //   5: new 464	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 120	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 468	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: getfield 474	android/content/pm/ApplicationInfo:uid	I
    //   23: invokevirtual 478	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   26: iconst_0
    //   27: aaload
    //   28: bipush 64
    //   30: invokevirtual 481	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: getfield 485	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   36: iconst_0
    //   37: aaload
    //   38: invokevirtual 490	android/content/pm/Signature:toByteArray	()[B
    //   41: invokespecial 491	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore_0
    //   45: ldc_w 493
    //   48: invokestatic 498	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   51: aload_0
    //   52: invokevirtual 502	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   55: checkcast 504	java/security/cert/X509Certificate
    //   58: invokevirtual 507	java/security/cert/X509Certificate:getEncoded	()[B
    //   61: invokestatic 510	com/tencent/turingfd/sdk/base/cm:d	([B)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_0
    //   66: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: aload_0
    //   73: ifnull +7 -> 80
    //   76: aload_0
    //   77: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   80: ldc 73
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 511	java/io/ByteArrayInputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_0
    //   99: goto -27 -> 72
    //   102: astore_0
    //   103: aload_1
    //   104: areturn
    //   105: astore_0
    //   106: goto -12 -> 94
    //   109: astore_0
    //   110: goto -30 -> 80
    //   113: astore_1
    //   114: goto -28 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   0	117	1	paramString	String
    //   4	7	2	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   45	65	71	java/lang/Throwable
    //   0	45	83	finally
    //   0	45	96	java/lang/Throwable
    //   65	69	102	java/lang/Throwable
    //   90	94	105	java/lang/Throwable
    //   76	80	109	java/lang/Throwable
    //   45	65	113	finally
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
    boolean bool2 = false;
    int i = Build.VERSION.SDK_INT;
    boolean bool1;
    if (i < 14) {
      if ((!TextUtils.isEmpty(Proxy.getHost(paramContext))) && (Proxy.getPort(paramContext) != -1)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      continue;
      if ((!TextUtils.isEmpty(System.getProperty("http.proxyHost"))) && (!TextUtils.equals(System.getProperty("http.proxyPort"), "-1"))) {
        return true;
      }
      Object localObject2 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      bool1 = bool2;
      if (paramContext.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0) {
        try
        {
          Object localObject1 = ((WifiManager)localObject2).getConnectionInfo();
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (((WifiInfo)localObject1).getNetworkId() != -1)
            {
              try
              {
                paramContext = ((WifiManager)localObject2).getConfiguredNetworks();
                bool1 = bool2;
                if (paramContext == null) {
                  continue;
                }
                localObject1 = ((WifiInfo)localObject1).getSSID();
                paramContext = paramContext.iterator();
                do
                {
                  bool1 = bool2;
                  if (!paramContext.hasNext()) {
                    break;
                  }
                  localObject2 = (WifiConfiguration)paramContext.next();
                } while ((!TextUtils.equals(((WifiConfiguration)localObject2).SSID, (CharSequence)localObject1)) && (!TextUtils.equals(((WifiConfiguration)localObject2).SSID, "\"" + (String)localObject1 + "\"")));
                if (i < 21)
                {
                  paramContext = cn.a(WifiConfiguration.class, "proxySettings", localObject2);
                  localObject1 = "android.net.wifi.WifiConfiguration$ProxySettings";
                  localObject2 = cn.a((String)localObject1, "STATIC");
                  if ((localObject2 == null) || (localObject2 != paramContext)) {
                    break label297;
                  }
                  return true;
                }
              }
              catch (Throwable paramContext)
              {
                for (;;)
                {
                  paramContext = null;
                  continue;
                  paramContext = cn.b(WifiConfiguration.class, "getProxySettings", localObject2);
                  localObject1 = "android.net.IpConfiguration$ProxySettings";
                }
                label297:
                bool1 = bool2;
              }
              if (i >= 19)
              {
                localObject1 = cn.a((String)localObject1, "PAC");
                bool1 = bool2;
                if (localObject1 != null)
                {
                  bool1 = bool2;
                  if (localObject1 == paramContext) {
                    return true;
                  }
                }
              }
            }
          }
        }
        catch (Throwable paramContext) {}
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
    int i = 0;
    try
    {
      Object localObject = new StringBuffer();
      String str = ct.a(ct.aA);
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
    //   0: new 309	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_0
    //   12: new 665	java/io/RandomAccessFile
    //   15: dup
    //   16: aload 4
    //   18: ldc_w 667
    //   21: invokespecial 670	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore 4
    //   26: aload 4
    //   28: astore_0
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
    //   42: ifne +41 -> 83
    //   45: aload 4
    //   47: astore_0
    //   48: iload_1
    //   49: newarray byte
    //   51: astore 5
    //   53: aload 4
    //   55: astore_0
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 676	java/io/RandomAccessFile:readFully	([B)V
    //   63: aload 5
    //   65: astore_0
    //   66: aload 4
    //   68: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   71: aload 5
    //   73: areturn
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 678	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: areturn
    //   83: aload 4
    //   85: astore_0
    //   86: new 250	java/io/IOException
    //   89: dup
    //   90: ldc 73
    //   92: invokespecial 679	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   95: athrow
    //   96: astore_0
    //   97: aload 4
    //   99: astore_0
    //   100: iconst_0
    //   101: newarray byte
    //   103: astore 5
    //   105: aload 4
    //   107: ifnull +11 -> 118
    //   110: aload 5
    //   112: astore_0
    //   113: aload 4
    //   115: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   118: aload 5
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore 4
    //   125: goto -28 -> 97
    //   128: astore 5
    //   130: aload_0
    //   131: astore 4
    //   133: aload 5
    //   135: astore_0
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 677	java/io/RandomAccessFile:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore 4
    //   150: aload 4
    //   152: invokevirtual 678	java/io/IOException:printStackTrace	()V
    //   155: goto -9 -> 146
    //   158: astore 5
    //   160: aload_0
    //   161: astore 4
    //   163: aload 5
    //   165: astore_0
    //   166: goto -30 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString	String
    //   37	12	1	i	int
    //   34	7	2	l	long
    //   8	59	4	localObject1	Object
    //   74	40	4	localIOException1	IOException
    //   123	19	4	str1	String
    //   148	3	4	localIOException2	IOException
    //   161	1	4	str2	String
    //   51	68	5	arrayOfByte	byte[]
    //   128	6	5	localObject2	Object
    //   158	6	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   66	71	74	java/io/IOException
    //   113	118	74	java/io/IOException
    //   29	35	96	java/lang/Throwable
    //   48	53	96	java/lang/Throwable
    //   56	63	96	java/lang/Throwable
    //   86	96	96	java/lang/Throwable
    //   12	26	121	java/lang/Throwable
    //   12	26	128	finally
    //   141	146	148	java/io/IOException
    //   29	35	158	finally
    //   48	53	158	finally
    //   56	63	158	finally
    //   86	96	158	finally
    //   100	105	158	finally
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
    //   43: invokevirtual 678	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 692	java/util/zip/DeflaterOutputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 678	java/io/IOException:printStackTrace	()V
    //   64: goto -7 -> 57
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 691	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 692	java/util/zip/DeflaterOutputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 678	java/io/IOException:printStackTrace	()V
    //   83: aconst_null
    //   84: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramArrayOfByte	byte[]
    //   7	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	9	1	localIOException1	IOException
    //   59	10	1	localIOException2	IOException
    //   16	57	2	localDeflaterOutputStream	java.util.zip.DeflaterOutputStream
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   17	31	48	finally
    //   49	57	59	java/io/IOException
    //   17	31	67	java/lang/Exception
    //   68	76	78	java/io/IOException
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (arrayOfByte == null) || (paramArrayOfByte1.length == 0)) {
      return paramArrayOfByte1;
    }
    if ((paramArrayOfByte1.length % 4 != 0) || (paramArrayOfByte1.length < 8)) {
      return null;
    }
    paramArrayOfByte2 = new int[paramArrayOfByte1.length >>> 2];
    a(paramArrayOfByte1, paramArrayOfByte2);
    if (arrayOfByte.length % 4 == 0) {}
    for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
    {
      j = i;
      if (i < 4) {
        j = 4;
      }
      paramArrayOfByte1 = new int[j];
      i = 0;
      while (i < j)
      {
        paramArrayOfByte1[i] = 0;
        i += 1;
      }
    }
    a(arrayOfByte, paramArrayOfByte1);
    int m = paramArrayOfByte2.length - 1;
    i = paramArrayOfByte2[m];
    i = paramArrayOfByte2[0];
    int j = (52 / (m + 1) + 6) * -1640531527;
    while (j != 0)
    {
      int n = j >>> 2 & 0x3;
      int k = m;
      while (k > 0)
      {
        i1 = paramArrayOfByte2[(k - 1)];
        i = paramArrayOfByte2[k] - ((i ^ j) + (i1 ^ paramArrayOfByte1[(k & 0x3 ^ n)]) ^ (i1 >>> 5 ^ i << 2) + (i >>> 3 ^ i1 << 4));
        paramArrayOfByte2[k] = i;
        k -= 1;
      }
      int i1 = paramArrayOfByte2[m];
      i = paramArrayOfByte2[0] - ((i ^ j) + (paramArrayOfByte1[(k & 0x3 ^ n)] ^ i1) ^ (i1 >>> 5 ^ i << 2) + (i >>> 3 ^ i1 << 4));
      paramArrayOfByte2[0] = i;
      j += 1640531527;
    }
    i = paramArrayOfByte2[(paramArrayOfByte2.length - 1)];
    if ((i < 0) || (i > paramArrayOfByte2.length - 1 << 2)) {
      return null;
    }
    paramArrayOfByte1 = new byte[i];
    a(paramArrayOfByte2, paramArrayOfByte2.length - 1, paramArrayOfByte1);
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
    //   36: ifnull +47 -> 83
    //   39: aload 4
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +36 -> 83
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
    //   81: astore 4
    //   83: aload_0
    //   84: invokevirtual 711	java/util/jar/JarFile:close	()V
    //   87: aload_3
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramFile	File
    //   44	27	1	i	int
    //   42	6	2	j	int
    //   7	44	3	localArrayList	ArrayList
    //   74	14	3	localList	List<String>
    //   32	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   81	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	34	74	finally
    //   39	43	74	finally
    //   50	67	74	finally
    //   17	34	81	java/lang/Exception
    //   39	43	81	java/lang/Exception
    //   50	67	81	java/lang/Exception
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
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      boolean bool = b(paramContext);
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 373	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 745	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 681	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 748	java/io/FileInputStream:available	()I
    //   21: invokespecial 751	java/io/ByteArrayOutputStream:<init>	(I)V
    //   24: astore_3
    //   25: sipush 4096
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 754	java/io/InputStream:read	([B)I
    //   36: istore_1
    //   37: iconst_m1
    //   38: iload_1
    //   39: if_icmpeq +33 -> 72
    //   42: aload_3
    //   43: aload_2
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 758	java/io/OutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: new 250	java/io/IOException
    //   56: dup
    //   57: invokespecial 759	java/io/IOException:<init>	()V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   66: aload_3
    //   67: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aload_3
    //   73: invokevirtual 690	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +13 -> 91
    //   81: aload_0
    //   82: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: invokestatic 186	com/tencent/turingfd/sdk/base/cm:b	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: areturn
    //   91: ldc 73
    //   93: invokevirtual 761	java/lang/String:getBytes	()[B
    //   96: astore_2
    //   97: goto -16 -> 81
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -41 -> 62
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_3
    //   109: goto -56 -> 53
    //   112: astore_2
    //   113: aconst_null
    //   114: astore 4
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: astore_3
    //   121: goto -59 -> 62
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: goto -76 -> 53
    //   132: astore_2
    //   133: goto -71 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   36	10	1	i	int
    //   3	41	2	arrayOfByte1	byte[]
    //   52	1	2	localThrowable1	Throwable
    //   61	10	2	localObject1	Object
    //   76	21	2	arrayOfByte2	byte[]
    //   100	1	2	localObject2	Object
    //   106	1	2	localThrowable2	Throwable
    //   112	16	2	localObject3	Object
    //   132	1	2	localObject4	Object
    //   1	126	3	localObject5	Object
    //   114	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	52	java/lang/Throwable
    //   31	37	52	java/lang/Throwable
    //   42	49	52	java/lang/Throwable
    //   72	77	52	java/lang/Throwable
    //   91	97	52	java/lang/Throwable
    //   53	61	61	finally
    //   13	25	100	finally
    //   13	25	106	java/lang/Throwable
    //   4	13	112	finally
    //   4	13	124	java/lang/Throwable
    //   25	31	132	finally
    //   31	37	132	finally
    //   42	49	132	finally
    //   72	77	132	finally
    //   91	97	132	finally
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        int i = localInflaterInputStream.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      byte[] arrayOfByte;
      return null;
    }
    catch (Exception localException)
    {
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return null;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        return arrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return arrayOfByte;
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte.close();
        localInflaterInputStream.close();
        localByteArrayOutputStream.close();
        throw localObject;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
  
  public static int d()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static String d(Context paramContext)
  {
    int j = 0;
    Object localObject1 = new HashSet();
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
      paramContext = new StringBuilder();
    }
    catch (Throwable paramContext)
    {
      localObject1 = dc.a((Set)localObject1);
      if (((Set)localObject1).size() <= 0) {
        break label200;
      }
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    localObject1 = ((ArrayList)localObject2).iterator();
    int i = j;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        i += 1;
        paramContext.append((String)((Iterator)localObject1).next());
        if (i < 8) {}
      }
      else
      {
        return paramContext.toString();
      }
      if (((Iterator)localObject1).hasNext())
      {
        paramContext.append("_");
        continue;
        label200:
        return "";
      }
    }
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
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return null;
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = "";
      }
      return localObject;
    }
    catch (Exception paramContext) {}
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
    catch (Throwable paramContext) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cm
 * JD-Core Version:    0.7.0.1
 */