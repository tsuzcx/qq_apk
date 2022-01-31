package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ed
{
  public static Context a;
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {
      return 1 << paramInt2 | paramInt1;
    }
    return 0 << paramInt2 | paramInt1;
  }
  
  public static int a(SparseArray paramSparseArray)
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
  
  public static ew a(Context paramContext)
  {
    int i;
    if (!er.a)
    {
      i = -10001;
      if (i == 0) {
        break label46;
      }
    }
    label46:
    bg localbg;
    for (paramContext = bg.a(i);; paramContext = localbg)
    {
      return new ee(paramContext);
      if (!er.b)
      {
        i = -10002;
        break;
      }
      i = 0;
      break;
      bm localbm = bm.a();
      localbg = localbm.a(paramContext);
      localbm.f.a(paramContext, localbg.d);
    }
  }
  
  public static float a(byte[] paramArrayOfByte, float paramfloat, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramfloat == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramfloat = paramfloat.a();
        paramfloat.b();
        paramArrayOfByte = new dp(paramArrayOfByte);
        paramArrayOfByte.b = "UTF-8";
        paramfloat.a(paramArrayOfByte);
        return paramfloat;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static Object a(SparseArray paramSparseArray, int paramInt, Class paramClass)
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
    catch (Throwable localThrowable) {}
    return "";
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_2
    //   5: new 148	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 146	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 154	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   20: getfield 159	android/content/pm/ApplicationInfo:uid	I
    //   23: invokevirtual 163	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   26: iconst_0
    //   27: aaload
    //   28: bipush 64
    //   30: invokevirtual 167	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: getfield 173	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   36: iconst_0
    //   37: aaload
    //   38: invokevirtual 179	android/content/pm/Signature:toByteArray	()[B
    //   41: invokespecial 180	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore_0
    //   45: ldc 182
    //   47: invokestatic 188	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   50: aload_0
    //   51: invokevirtual 192	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   54: checkcast 194	java/security/cert/X509Certificate
    //   57: invokevirtual 197	java/security/cert/X509Certificate:getEncoded	()[B
    //   60: invokestatic 200	com/tencent/turingfd/sdk/base/ed:d	([B)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: invokevirtual 203	java/io/ByteArrayInputStream:close	()V
    //   68: aload_1
    //   69: areturn
    //   70: astore_1
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 203	java/io/ByteArrayInputStream:close	()V
    //   79: ldc 105
    //   81: areturn
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 203	java/io/ByteArrayInputStream:close	()V
    //   93: aload_1
    //   94: athrow
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: goto -27 -> 71
    //   101: astore_0
    //   102: aload_1
    //   103: areturn
    //   104: astore_0
    //   105: goto -12 -> 93
    //   108: astore_0
    //   109: goto -30 -> 79
    //   112: astore_1
    //   113: goto -28 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   0	116	1	paramString	String
    //   4	7	2	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   45	64	70	java/lang/Throwable
    //   0	45	82	finally
    //   0	45	95	java/lang/Throwable
    //   64	68	101	java/lang/Throwable
    //   89	93	104	java/lang/Throwable
    //   75	79	108	java/lang/Throwable
    //   45	64	112	finally
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: ldc 105
    //   2: astore_1
    //   3: new 206	java/io/BufferedReader
    //   6: dup
    //   7: new 208	java/io/FileReader
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 211	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   15: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 218	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +9 -> 36
    //   30: aload_0
    //   31: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   34: aload_1
    //   35: areturn
    //   36: aload_0
    //   37: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   40: aload_1
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +7 -> 53
    //   49: aload_0
    //   50: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   53: aload_1
    //   54: athrow
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull -25 -> 34
    //   62: aload_0
    //   63: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   66: ldc 105
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
    //   13: ldc_w 333
    //   16: astore 4
    //   18: ldc_w 335
    //   21: astore_3
    //   22: new 280	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   29: aload 4
    //   31: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: astore_1
    //   35: new 206	java/io/BufferedReader
    //   38: dup
    //   39: new 208	java/io/FileReader
    //   42: dup
    //   43: aload_1
    //   44: ldc_w 337
    //   47: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 338	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   56: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 218	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 8
    //   66: aload 7
    //   68: astore_2
    //   69: aload 8
    //   71: ifnull +143 -> 214
    //   74: aload 7
    //   76: astore_2
    //   77: aload 8
    //   79: invokevirtual 341	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   82: aload_3
    //   83: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +128 -> 214
    //   89: new 280	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   96: aload 4
    //   98: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: astore_2
    //   102: new 206	java/io/BufferedReader
    //   105: dup
    //   106: new 208	java/io/FileReader
    //   109: dup
    //   110: aload_2
    //   111: ldc_w 346
    //   114: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 338	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 218	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: ifnull +81 -> 214
    //   136: aload_3
    //   137: invokevirtual 272	java/lang/String:trim	()Ljava/lang/String;
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 347	java/io/BufferedReader:close	()V
    //   145: aload_2
    //   146: invokevirtual 347	java/io/BufferedReader:close	()V
    //   149: aload_3
    //   150: areturn
    //   151: ldc_w 349
    //   154: astore 4
    //   156: ldc_w 351
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
    //   175: invokevirtual 347	java/io/BufferedReader:close	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 347	java/io/BufferedReader:close	()V
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
    //   200: invokevirtual 347	java/io/BufferedReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 347	java/io/BufferedReader:close	()V
    //   211: ldc 105
    //   213: areturn
    //   214: aload_1
    //   215: invokevirtual 347	java/io/BufferedReader:close	()V
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
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("turingfd_protect_105678_32_baseFull", 0).edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.commit();
      return;
    }
    catch (Throwable paramContext) {}
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
  
  public static final boolean a()
  {
    try
    {
      localObject = Class.forName("android.app.ActivityThread");
      localObject = ((Class)localObject).getMethod("currentApplication", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (Context)((Method)localObject).invoke(null, new Object[0]);
    }
    catch (Exception localException)
    {
      Context localContext;
      for (;;)
      {
        Object localObject;
        Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + localException.toString());
        localContext = null;
      }
      return dn.a().a(localContext, false);
    }
    if (localObject == null) {
      return false;
    }
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 422	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 424	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 428	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 431	java/io/BufferedOutputStream:write	([B)V
    //   21: aload_0
    //   22: invokevirtual 434	java/io/BufferedOutputStream:flush	()V
    //   25: aload_0
    //   26: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   29: iconst_1
    //   30: ireturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: athrow
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 221	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/Closeable;)V
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
  
  public static byte[] a(float paramfloat)
  {
    dv localdv = new dv();
    localdv.b = "UTF-8";
    paramfloat.a(localdv);
    return localdv.a();
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 322	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 447	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 449	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 450	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   41: invokevirtual 454	java/io/FileInputStream:read	([BII)I
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
    //   71: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
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
    //   93: invokestatic 462	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   96: aload 6
    //   98: astore 5
    //   100: aload_0
    //   101: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   104: aload 5
    //   106: areturn
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: astore_0
    //   115: aload 5
    //   117: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
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
    //   133: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
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
    //   7: invokevirtual 492	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_2
    //   15: arraylength
    //   16: invokevirtual 495	java/io/InputStream:read	([BII)I
    //   19: iconst_m1
    //   20: if_icmpne -9 -> 11
    //   23: aload 4
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 501	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   34: astore_2
    //   35: aload_0
    //   36: invokevirtual 502	java/io/InputStream:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 502	java/io/InputStream:close	()V
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
    //   64: invokevirtual 502	java/io/InputStream:close	()V
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
  
  public static al b(int paramInt)
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
        return new al(paramInt, i, str2, k, null, j);
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
  public static java.util.List b(File paramFile)
  {
    // Byte code:
    //   0: new 549	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 550	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 488	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 551	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_0
    //   19: ldc_w 553
    //   22: invokevirtual 557	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   25: sipush 8192
    //   28: newarray byte
    //   30: invokestatic 559	com/tencent/turingfd/sdk/base/ed:a	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +47 -> 84
    //   40: aload 4
    //   42: arraylength
    //   43: istore_2
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: iload_2
    //   48: if_icmpge +36 -> 84
    //   51: aload_3
    //   52: aload 4
    //   54: iload_1
    //   55: aaload
    //   56: invokevirtual 562	java/security/cert/Certificate:getEncoded	()[B
    //   59: invokestatic 200	com/tencent/turingfd/sdk/base/ed:d	([B)Ljava/lang/String;
    //   62: invokeinterface 567 2 0
    //   67: pop
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -26 -> 46
    //   75: astore_3
    //   76: aload_0
    //   77: invokevirtual 568	java/util/jar/JarFile:close	()V
    //   80: aload_3
    //   81: athrow
    //   82: astore 4
    //   84: aload_0
    //   85: invokevirtual 568	java/util/jar/JarFile:close	()V
    //   88: aload_3
    //   89: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	File
    //   45	27	1	i	int
    //   43	6	2	j	int
    //   7	45	3	localArrayList	ArrayList
    //   75	14	3	localList	java.util.List
    //   33	20	4	arrayOfCertificate	java.security.cert.Certificate[]
    //   82	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   17	35	75	finally
    //   40	44	75	finally
    //   51	68	75	finally
    //   17	35	82	java/lang/Exception
    //   40	44	82	java/lang/Exception
    //   51	68	82	java/lang/Exception
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
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 505	com/tencent/turingfd/sdk/base/ed:a	Landroid/content/Context;
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
    //   28: invokevirtual 572	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +8 -> 41
    //   36: iconst_0
    //   37: istore_1
    //   38: goto -25 -> 13
    //   41: aload_0
    //   42: putstatic 505	com/tencent/turingfd/sdk/base/ed:a	Landroid/content/Context;
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
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: new 322	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_0
    //   12: new 574	java/io/RandomAccessFile
    //   15: dup
    //   16: aload 4
    //   18: ldc_w 576
    //   21: invokespecial 579	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore 4
    //   26: aload 4
    //   28: astore_0
    //   29: aload 4
    //   31: invokevirtual 583	java/io/RandomAccessFile:length	()J
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
    //   60: invokevirtual 586	java/io/RandomAccessFile:readFully	([B)V
    //   63: aload 5
    //   65: astore_0
    //   66: aload 4
    //   68: invokevirtual 587	java/io/RandomAccessFile:close	()V
    //   71: aload 5
    //   73: areturn
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: areturn
    //   83: aload 4
    //   85: astore_0
    //   86: new 262	java/io/IOException
    //   89: dup
    //   90: ldc 105
    //   92: invokespecial 591	java/io/IOException:<init>	(Ljava/lang/String;)V
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
    //   115: invokevirtual 587	java/io/RandomAccessFile:close	()V
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
    //   143: invokevirtual 587	java/io/RandomAccessFile:close	()V
    //   146: aload_0
    //   147: athrow
    //   148: astore 4
    //   150: aload 4
    //   152: invokevirtual 590	java/io/IOException:printStackTrace	()V
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
    //   0: new 593	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 594	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 596	java/util/zip/DeflaterOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 597	java/util/zip/DeflaterOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 598	java/util/zip/DeflaterOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 601	java/util/zip/DeflaterOutputStream:finish	()V
    //   26: aload_1
    //   27: invokevirtual 602	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 603	java/io/ByteArrayOutputStream:close	()V
    //   35: aload_2
    //   36: invokevirtual 604	java/util/zip/DeflaterOutputStream:close	()V
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 603	java/io/ByteArrayOutputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 604	java/util/zip/DeflaterOutputStream:close	()V
    //   57: aload_0
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   64: goto -7 -> 57
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 603	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 604	java/util/zip/DeflaterOutputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 590	java/io/IOException:printStackTrace	()V
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
  
  public static String c(Context paramContext)
  {
    int j = 0;
    Object localObject1 = new HashSet();
    try
    {
      localObject2 = new String(c(db.a(db.m)));
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
    catch (IOException paramContext)
    {
      localObject1 = m.a((Set)localObject1);
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
  
  public static byte[] c()
  {
    int i = 0;
    try
    {
      Object localObject = new StringBuffer();
      while (i < 21)
      {
        ((StringBuffer)localObject).append((char)("http://pmir.3g.qq.com".charAt(i) + new int[] { -36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49 }[i]));
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
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 449	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 672	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 593	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual 675	java/io/FileInputStream:available	()I
    //   21: invokespecial 678	java/io/ByteArrayOutputStream:<init>	(I)V
    //   24: astore_3
    //   25: sipush 4096
    //   28: newarray byte
    //   30: astore_2
    //   31: aload_0
    //   32: aload_2
    //   33: invokevirtual 681	java/io/InputStream:read	([B)I
    //   36: istore_1
    //   37: iconst_m1
    //   38: iload_1
    //   39: if_icmpeq +33 -> 72
    //   42: aload_3
    //   43: aload_2
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 685	java/io/OutputStream:write	([BII)V
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: new 262	java/io/IOException
    //   56: dup
    //   57: invokespecial 686	java/io/IOException:<init>	()V
    //   60: athrow
    //   61: astore_2
    //   62: aload_0
    //   63: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   66: aload_3
    //   67: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aload_3
    //   73: invokevirtual 602	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +13 -> 91
    //   81: aload_0
    //   82: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: invokestatic 456	com/tencent/turingfd/sdk/base/ed:b	(Ljava/io/Closeable;)V
    //   89: aload_2
    //   90: areturn
    //   91: ldc 105
    //   93: invokevirtual 688	java/lang/String:getBytes	()[B
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
  
  public static SparseArray d()
  {
    return new SparseArray();
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String d(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(d("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return e(paramArrayOfByte);
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = localObject;
      }
    }
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
  
  public static String e(Context paramContext)
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
      paramContext = paramContext.getContentResolver();
      paramContext = Settings.Secure.getString(paramContext, "android_id");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static int g(Context paramContext)
  {
    return paramContext.getSharedPreferences("turingfd_protect_105678_32_baseFull", 0).getInt("301", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ed
 * JD-Core Version:    0.7.0.1
 */