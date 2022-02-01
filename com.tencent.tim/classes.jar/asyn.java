import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.GGMM.3;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.MobileQQ;

public class asyn
{
  private static final Set<String> dq;
  private static final byte[] hA;
  private static final byte[] hz;
  private static final String[] iA = { "mc", "md", "mg", "wfm", "sno", "fg", "brd", "hw", "dv", "tm", "ts", "rs", "rc", "rc2" };
  
  static
  {
    dq = new HashSet();
    hz = new byte[] { 74, 39, 2, -61, -88, -75, -36, 105, -102, 39, 2, 69, -72, -11, -84, 50 };
    hA = new byte[] { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, -61, -88, -75, -68, 105 };
    dq.add("mg");
    dq.add("wfm");
  }
  
  private static String Eo()
  {
    String str2 = asxv.getDeviceId(1);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {
        str1 = ("A" + str2 + "123456789ABCDEF").substring(0, 15);
      }
    }
    return str1;
  }
  
  private static String Ep()
  {
    return "A" + gB(15);
  }
  
  private static String Eq()
  {
    return BaseApplication.getContext().getCacheDir().getAbsolutePath() + "/kf2.dat";
  }
  
  private static String Er()
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (localObject != null) {
        try
        {
          long l = Long.parseLong((String)localObject);
          localObject = Base64.encodeToString((aqgz.getQQVersion() + "_" + Long.toString(l ^ 0xADCD123)).getBytes(), 2);
          return localObject;
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  /* Error */
  private static Map<String, String> a(InputStream paramInputStream, asyn.a parama)
  {
    // Byte code:
    //   0: new 185	java/util/HashMap
    //   3: dup
    //   4: invokespecial 186	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 188	java/io/BufferedReader
    //   11: dup
    //   12: new 190	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: ldc 192
    //   19: invokespecial 195	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 201	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +61 -> 97
    //   39: aload_2
    //   40: astore_0
    //   41: aload_1
    //   42: aload 4
    //   44: invokeinterface 205 2 0
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull -27 -> 26
    //   56: aload_2
    //   57: astore_0
    //   58: aload_3
    //   59: aload 4
    //   61: getfield 211	android/util/Pair:first	Ljava/lang/Object;
    //   64: aload 4
    //   66: getfield 214	android/util/Pair:second	Ljava/lang/Object;
    //   69: invokevirtual 218	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: goto -47 -> 26
    //   76: astore_0
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 224	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: areturn
    //   97: aload_2
    //   98: ifnull -3 -> 95
    //   101: aload_2
    //   102: invokevirtual 224	java/io/BufferedReader:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   119: aload_3
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 224	java/io/BufferedReader:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_1
    //   143: goto -19 -> 124
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -68 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramInputStream	InputStream
    //   0	152	1	parama	asyn.a
    //   25	77	2	localObject1	Object
    //   146	1	2	localException	Exception
    //   7	113	3	localHashMap	HashMap
    //   32	33	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	76	java/lang/Exception
    //   41	51	76	java/lang/Exception
    //   58	73	76	java/lang/Exception
    //   101	105	107	java/lang/Exception
    //   91	95	114	java/lang/Exception
    //   8	26	121	finally
    //   128	132	134	java/lang/Exception
    //   28	34	142	finally
    //   41	51	142	finally
    //   58	73	142	finally
    //   83	87	142	finally
    //   8	26	146	java/lang/Exception
  }
  
  public static Map<String, String> aF()
  {
    try
    {
      Map localMap = a(new FileInputStream("/proc/cpuinfo"), new asyo());
      return localMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  private static Map<String, String> aG()
  {
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = e();
    if (localInputStream == null) {}
    do
    {
      return localHashMap;
      f(a(localInputStream, new asyp()), localHashMap);
    } while (localInputStream == null);
    try
    {
      localInputStream.close();
      return localHashMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static Map<String, String> aH()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    HashMap localHashMap = new HashMap();
    if (localSharedPreferences != null) {}
    try
    {
      f(localSharedPreferences.getAll(), localHashMap);
      return localHashMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static boolean aIN()
  {
    return !new File(Eq()).exists();
  }
  
  private static Map<String, String> b(String[] paramArrayOfString)
  {
    Map localMap = aH();
    Object localObject2 = null;
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    int i1 = paramArrayOfString.length;
    int n = 0;
    int i = 0;
    int j = 0;
    String str;
    Object localObject3;
    Object localObject1;
    if (n < i1)
    {
      str = paramArrayOfString[n];
      if (dq.contains(str))
      {
        localObject3 = e(localHashMap, str);
        localHashSet.add(str);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localHashMap.put(str, localObject3);
      n += 1;
      localObject2 = localObject1;
      break;
      localObject1 = (String)localMap.get(str);
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      int k = i;
      int m = j;
      if (localObject1 == null)
      {
        j += 1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = aG();
        }
        localObject2 = (String)((Map)localObject1).get(str);
        localObject3 = localObject2;
        localObject4 = localObject1;
        k = i;
        m = j;
        if (localObject2 == null)
        {
          i += 1;
          localObject2 = e(localHashMap, str);
          localObject3 = localObject2;
          localObject4 = localObject1;
          k = i;
          m = j;
          if (str.equals("md"))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localHashSet.add("md");
              j -= 1;
              i -= 1;
              localObject3 = localObject2;
              continue;
            }
            localObject3 = Ep();
            continue;
            if (j > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sp.");
              }
              d(localHashSet, localHashMap);
            }
            if ((i > 0) || (aIN()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sdcard.");
              }
              c(localHashSet, localHashMap);
            }
            return localHashMap;
          }
        }
      }
      j = m;
      localObject1 = localObject4;
      i = k;
    }
  }
  
  /* Error */
  private static void c(Set<String> paramSet, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 335	javax/crypto/spec/IvParameterSpec
    //   5: dup
    //   6: getstatic 77	asyn:hA	[B
    //   9: invokespecial 338	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   12: astore_2
    //   13: new 340	javax/crypto/spec/SecretKeySpec
    //   16: dup
    //   17: getstatic 72	asyn:hz	[B
    //   20: ldc_w 342
    //   23: invokespecial 345	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   26: astore 4
    //   28: ldc_w 347
    //   31: invokestatic 353	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   34: astore 5
    //   36: aload 5
    //   38: iconst_1
    //   39: aload 4
    //   41: aload_2
    //   42: invokevirtual 357	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   45: new 359	javax/crypto/CipherOutputStream
    //   48: dup
    //   49: new 361	java/io/FileOutputStream
    //   52: dup
    //   53: invokestatic 275	asyn:Eq	()Ljava/lang/String;
    //   56: invokespecial 362	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   59: aload 5
    //   61: invokespecial 365	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   64: astore_2
    //   65: aload_1
    //   66: invokeinterface 369 1 0
    //   71: invokeinterface 373 1 0
    //   76: astore_1
    //   77: aload_1
    //   78: invokeinterface 378 1 0
    //   83: ifeq +114 -> 197
    //   86: aload_1
    //   87: invokeinterface 382 1 0
    //   92: checkcast 384	java/util/Map$Entry
    //   95: astore_3
    //   96: aload_0
    //   97: aload_3
    //   98: invokeinterface 387 1 0
    //   103: invokeinterface 286 2 0
    //   108: ifne -31 -> 77
    //   111: aload_2
    //   112: new 98	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   119: aload_3
    //   120: invokeinterface 387 1 0
    //   125: checkcast 19	java/lang/String
    //   128: invokevirtual 176	java/lang/String:getBytes	()[B
    //   131: iconst_2
    //   132: invokestatic 182	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   135: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 389
    //   141: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_3
    //   145: invokeinterface 392 1 0
    //   150: checkcast 19	java/lang/String
    //   153: invokevirtual 176	java/lang/String:getBytes	()[B
    //   156: iconst_2
    //   157: invokestatic 182	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   160: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 394
    //   166: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokevirtual 176	java/lang/String:getBytes	()[B
    //   175: invokevirtual 399	java/io/OutputStream:write	([B)V
    //   178: goto -101 -> 77
    //   181: astore_1
    //   182: aload_2
    //   183: astore_0
    //   184: aload_1
    //   185: invokevirtual 221	java/lang/Exception:printStackTrace	()V
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 400	java/io/OutputStream:close	()V
    //   196: return
    //   197: aload_2
    //   198: ifnull -2 -> 196
    //   201: aload_2
    //   202: invokevirtual 400	java/io/OutputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: return
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 400	java/io/OutputStream:close	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_0
    //   222: return
    //   223: astore_1
    //   224: goto -5 -> 219
    //   227: astore_0
    //   228: aload_2
    //   229: astore_1
    //   230: goto -19 -> 211
    //   233: astore_2
    //   234: aload_0
    //   235: astore_1
    //   236: aload_2
    //   237: astore_0
    //   238: goto -27 -> 211
    //   241: astore_1
    //   242: aload_3
    //   243: astore_0
    //   244: goto -60 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramSet	Set<String>
    //   0	247	1	paramMap	Map<String, String>
    //   12	217	2	localObject1	Object
    //   233	4	2	localObject2	Object
    //   1	242	3	localEntry	Map.Entry
    //   26	14	4	localSecretKeySpec	SecretKeySpec
    //   34	26	5	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   65	77	181	java/lang/Exception
    //   77	178	181	java/lang/Exception
    //   201	205	206	java/io/IOException
    //   2	65	208	finally
    //   192	196	221	java/io/IOException
    //   215	219	223	java/io/IOException
    //   65	77	227	finally
    //   77	178	227	finally
    //   184	188	233	finally
    //   2	65	241	java/lang/Exception
  }
  
  private static String d(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  private static void d(Set<String> paramSet, Map<String, String> paramMap)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (!paramSet.contains(localEntry.getKey())) {
            ((SharedPreferences.Editor)localObject).putString(Base64.encodeToString(((String)localEntry.getKey()).getBytes(), 2), Base64.encodeToString(((String)localEntry.getValue()).getBytes(), 2));
          }
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private static InputStream e()
  {
    Object localObject = new File(Eq());
    if (!((File)localObject).exists()) {}
    while (((File)localObject).length() > 102400L) {
      return null;
    }
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(hA);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(hz, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
      localObject = new CipherInputStream(new BufferedInputStream(new FileInputStream((File)localObject)), localCipher);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String e(Map<String, String> paramMap, String paramString)
  {
    Object localObject = null;
    if (paramString.equals("wfm")) {
      paramMap = asxv.getDeviceId(2);
    }
    for (;;)
    {
      paramString = paramMap;
      if (paramMap == null) {
        paramString = "";
      }
      return paramString;
      if (paramString.equals("mc"))
      {
        paramMap = getCpuId();
      }
      else if (paramString.equals("md"))
      {
        paramMap = Eo();
      }
      else if (paramString.equals("mg"))
      {
        paramString = new StringBuilder();
        paramString.append(aqgz.getAndroidID());
        paramString.append((String)paramMap.get("md"));
        paramString.append(Build.MANUFACTURER + Build.MODEL + (String)paramMap.get("mc"));
        paramMap = "A" + aszr.getMD5String(paramString.toString()).substring(0, 15);
      }
      else if (paramString.equals("sno"))
      {
        paramMap = "";
      }
      else if (paramString.equals("fg"))
      {
        paramMap = Build.FINGERPRINT;
      }
      else if (paramString.equals("brd"))
      {
        paramMap = Build.BOARD;
      }
      else if (paramString.equals("tm"))
      {
        paramMap = Long.toString(aqgz.getSystemTotalMemory());
      }
      else if (paramString.equals("ts"))
      {
        paramMap = Long.toString(-1L);
      }
      else if (paramString.equals("rs"))
      {
        paramMap = aqgz.BZ();
      }
      else if (paramString.equals("hw"))
      {
        paramMap = Build.HARDWARE;
      }
      else if (paramString.equals("dv"))
      {
        paramMap = Build.DEVICE;
      }
      else if (paramString.equals("rc"))
      {
        paramMap = gB(16);
      }
      else
      {
        paramMap = localObject;
        if (paramString.equals("rc2")) {
          paramMap = gB(16);
        }
      }
    }
  }
  
  private static void esu()
  {
    Map localMap = b(iA);
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = iA;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = (String)localMap.get(arrayOfString[i]);
      localStringBuilder.append(",");
      localStringBuilder.append(str.replace(",", "&#44"));
      i += 1;
    }
    asxw.gL(localStringBuilder.toString().substring(1), 110);
  }
  
  public static void esv()
  {
    long l1 = 604800000L;
    if (!QSecFramework.a().c(1002).booleanValue()) {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "door closed.");
      }
    }
    Object localObject;
    String str;
    do
    {
      do
      {
        return;
        localObject = BaseApplication.getContext().getSharedPreferences("di_time", 0);
      } while (localObject == null);
      str = Er();
    } while (str == null);
    long l2 = ((SharedPreferences)localObject).getLong(str, 0L);
    long l3 = new Date().getTime();
    if (l3 - l2 > 604800000L)
    {
      esu();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(str, l3);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "rpt after: " + l1);
      }
      QSecFramework.C().postDelayed(new GGMM.3(), l1);
      return;
      l1 = 604800000L - l3 + l2;
    }
  }
  
  private static void f(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Object localObject = (Map.Entry)paramMap1.next();
        String str = rl((String)((Map.Entry)localObject).getKey());
        localObject = rl((String)((Map.Entry)localObject).getValue());
        if ((str != null) && (localObject != null)) {
          paramMap2.put(str, localObject);
        }
      }
    }
  }
  
  /* Error */
  private static String gB(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 98	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: new 559	java/security/SecureRandom
    //   14: dup
    //   15: invokespecial 560	java/security/SecureRandom:<init>	()V
    //   18: astore 5
    //   20: iconst_0
    //   21: istore_1
    //   22: aload 4
    //   24: astore_3
    //   25: iload_1
    //   26: iload_0
    //   27: if_icmpge +88 -> 115
    //   30: aload 4
    //   32: aload 5
    //   34: bipush 25
    //   36: invokevirtual 564	java/security/SecureRandom:nextInt	(I)I
    //   39: bipush 65
    //   41: iadd
    //   42: i2c
    //   43: invokevirtual 567	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -29 -> 22
    //   54: astore_3
    //   55: new 98	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: new 569	java/util/Random
    //   67: dup
    //   68: invokespecial 570	java/util/Random:<init>	()V
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 575	java/lang/System:currentTimeMillis	()J
    //   78: invokevirtual 579	java/util/Random:setSeed	(J)V
    //   81: iload_2
    //   82: istore_1
    //   83: aload 4
    //   85: astore_3
    //   86: iload_1
    //   87: iload_0
    //   88: if_icmpge +27 -> 115
    //   91: aload 4
    //   93: aload 5
    //   95: bipush 25
    //   97: invokevirtual 580	java/util/Random:nextInt	(I)I
    //   100: bipush 65
    //   102: iadd
    //   103: i2c
    //   104: invokevirtual 567	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_1
    //   109: iconst_1
    //   110: iadd
    //   111: istore_1
    //   112: goto -29 -> 83
    //   115: aload_3
    //   116: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramInt	int
    //   21	91	1	i	int
    //   1	81	2	j	int
    //   24	1	3	localStringBuilder1	StringBuilder
    //   54	1	3	localException	Exception
    //   85	31	3	localStringBuilder2	StringBuilder
    //   9	83	4	localStringBuilder3	StringBuilder
    //   18	76	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	54	java/lang/Exception
    //   30	47	54	java/lang/Exception
  }
  
  private static String getCpuId()
  {
    Map localMap = aF();
    if (localMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(d(localMap, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(d(localMap, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(d(localMap, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(d(localMap, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(d(localMap, "Serial"));
    return localStringBuilder.toString();
  }
  
  private static String rl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new String(Base64.decode(paramString.getBytes(), 2));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  static abstract interface a
  {
    public abstract Pair<String, String> j(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyn
 * JD-Core Version:    0.7.0.1
 */