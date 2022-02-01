package com.tencent.mobileqq.msf.core;

import alkz;
import android.content.Context;
import android.content.ContextWrapper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;

public class w
{
  public static final String a = "MSF.C.Util";
  public static final String b = "sp_imei";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static long h = 0L;
  public static String i = "";
  public static String j = "";
  public static int k = 0;
  private static final int l = 60000;
  private static final int m = 1000000;
  private static final AtomicInteger n = new AtomicInteger(60000 + new Random().nextInt(100000));
  private static String o = "";
  private static String p = "";
  private static int q;
  private static int r = 0;
  private static String s = "";
  private static String t = "";
  private static String u = "";
  private static String v = "";
  private static String w = "";
  
  public static int a()
  {
    try
    {
      int i1 = n.incrementAndGet();
      if (i1 > 1000000) {
        n.set(60000 + new Random().nextInt(100000));
      }
      return i1;
    }
    finally {}
  }
  
  public static long a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    paramContext = new File(paramContext + paramString);
    if (paramContext.exists()) {
      return a(paramContext);
    }
    return 0L;
  }
  
  /* Error */
  public static long a(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 130
    //   3: lstore_1
    //   4: lload_1
    //   5: lstore_3
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 122	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: lload_1
    //   18: lstore_3
    //   19: lload_3
    //   20: lreturn
    //   21: new 133	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore_0
    //   34: aload 5
    //   36: invokestatic 139	com/tencent/mobileqq/msf/core/w:a	(Ljava/io/InputStream;)J
    //   39: lstore_3
    //   40: lload_3
    //   41: lstore_1
    //   42: lload_1
    //   43: lstore_3
    //   44: aload 5
    //   46: ifnull -27 -> 19
    //   49: aload 5
    //   51: invokevirtual 142	java/io/FileInputStream:close	()V
    //   54: lload_1
    //   55: lreturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   61: lload_1
    //   62: lreturn
    //   63: astore 6
    //   65: aconst_null
    //   66: astore 5
    //   68: aload 5
    //   70: astore_0
    //   71: aload 6
    //   73: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   76: lload_1
    //   77: lstore_3
    //   78: aload 5
    //   80: ifnull -61 -> 19
    //   83: aload 5
    //   85: invokevirtual 142	java/io/FileInputStream:close	()V
    //   88: ldc2_w 130
    //   91: lreturn
    //   92: astore_0
    //   93: goto -36 -> 57
    //   96: astore 5
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 142	java/io/FileInputStream:close	()V
    //   108: aload 5
    //   110: athrow
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   116: goto -8 -> 108
    //   119: astore 5
    //   121: goto -21 -> 100
    //   124: astore 6
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramFile	File
    //   3	74	1	l1	long
    //   5	73	3	l2	long
    //   29	55	5	localFileInputStream	java.io.FileInputStream
    //   96	13	5	localObject1	Object
    //   119	1	5	localObject2	Object
    //   63	9	6	localException1	Exception
    //   124	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   49	54	56	java/io/IOException
    //   21	31	63	java/lang/Exception
    //   83	88	92	java/io/IOException
    //   21	31	96	finally
    //   104	108	111	java/io/IOException
    //   34	40	119	finally
    //   71	76	119	finally
    //   34	40	124	java/lang/Exception
  }
  
  public static long a(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i1);
    }
    return localCRC32.getValue();
  }
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.addAttribute("to_SenderProcessName", paramToServiceMsg.getAttribute("to_SenderProcessName"));
    localFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
    return localFromServiceMsg;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = paramContext.getFilesDir().getParent();
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 285	java/util/Properties
    //   3: dup
    //   4: invokespecial 286	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 122	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 289	java/io/File:createNewFile	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 295 1 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface 300 1 0
    //   33: ifeq +103 -> 136
    //   36: aload_1
    //   37: invokeinterface 304 1 0
    //   42: checkcast 306	com/tencent/qphone/base/remote/SimpleAccount
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 307	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   51: aload_2
    //   52: invokevirtual 310	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   55: invokevirtual 314	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -32 -> 27
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +45 -> 115
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 8
    //   77: iconst_2
    //   78: new 106	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 321
    //   88: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 324	java/io/File:getName	()Ljava/lang/String;
    //   95: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 326
    //   101: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_3
    //   112: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 334	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 335	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 338	java/io/FileOutputStream:close	()V
    //   135: return
    //   136: new 337	java/io/FileOutputStream
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 339	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: astore_2
    //   145: aload_2
    //   146: astore_1
    //   147: aload_3
    //   148: aload_2
    //   149: ldc 67
    //   151: invokevirtual 343	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: invokevirtual 338	java/io/FileOutputStream:close	()V
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 8
    //   164: iconst_1
    //   165: new 106	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 345
    //   175: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 324	java/io/File:getName	()Ljava/lang/String;
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iconst_0
    //   192: ifeq +11 -> 203
    //   195: new 334	java/lang/NullPointerException
    //   198: dup
    //   199: invokespecial 335	java/lang/NullPointerException:<init>	()V
    //   202: athrow
    //   203: aload_2
    //   204: ifnull -69 -> 135
    //   207: aload_2
    //   208: invokevirtual 338	java/io/FileOutputStream:close	()V
    //   211: return
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_1
    //   221: iconst_0
    //   222: ifeq +11 -> 233
    //   225: new 334	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 335	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 338	java/io/FileOutputStream:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   248: goto -15 -> 233
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   256: goto -15 -> 241
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   264: goto -137 -> 127
    //   267: astore_0
    //   268: goto -55 -> 213
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   276: goto -73 -> 203
    //   279: astore_0
    //   280: goto -59 -> 221
    //   283: astore_3
    //   284: goto -219 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramFile	File
    //   0	287	1	paramList	List
    //   45	163	2	localObject	Object
    //   243	2	2	localIOException	java.io.IOException
    //   7	40	3	localProperties	Properties
    //   62	86	3	localException1	Exception
    //   283	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	20	62	java/lang/Exception
    //   20	27	62	java/lang/Exception
    //   27	59	62	java/lang/Exception
    //   136	145	62	java/lang/Exception
    //   207	211	212	java/io/IOException
    //   8	20	218	finally
    //   20	27	218	finally
    //   27	59	218	finally
    //   136	145	218	finally
    //   225	233	243	java/io/IOException
    //   237	241	251	java/io/IOException
    //   119	127	259	java/io/IOException
    //   131	135	267	java/io/IOException
    //   195	203	271	java/io/IOException
    //   67	73	279	finally
    //   75	115	279	finally
    //   147	154	279	finally
    //   156	160	279	finally
    //   162	191	279	finally
    //   147	154	283	java/lang/Exception
    //   156	160	283	java/lang/Exception
    //   162	191	283	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    Object localObject = new File(MsfCore.getIMEIPath());
    try
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        localObject = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
        ((Properties)localObject).put("imei", paramString);
        MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), (Properties)localObject);
        return;
      }
      QLog.d("MSF.C.Util", 1, "can not create imei file");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.Util", 1, "save sys imei error", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    h = paramLong;
    i = paramString1;
    j = paramString2;
  }
  
  private static void a(String paramString, List paramList)
  {
    int i1 = 1;
    for (;;)
    {
      if (i1 != 0)
      {
        Iterator localIterator = paramList.iterator();
        i1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label64;
          }
          if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
          {
            paramList.remove(i1);
            i1 = 1;
            break;
          }
          i1 += 1;
        }
      }
      return;
      label64:
      i1 = 0;
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i1 += 1;
    }
    return str;
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  /* Error */
  public static void c()
  {
    // Byte code:
    //   0: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc_w 407
    //   6: invokevirtual 410	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 412	android/telephony/TelephonyManager
    //   12: astore_1
    //   13: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: invokestatic 417	com/tencent/mobileqq/Pandora/Pandora:getImsi	(Landroid/content/Context;)Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +11 -> 32
    //   24: aload_2
    //   25: putstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   28: aload_2
    //   29: putstatic 85	com/tencent/mobileqq/msf/core/w:u	Ljava/lang/String;
    //   32: aload_1
    //   33: invokevirtual 420	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: putstatic 89	com/tencent/mobileqq/msf/core/w:w	Ljava/lang/String;
    //   45: aload_1
    //   46: invokevirtual 423	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   49: putstatic 75	com/tencent/mobileqq/msf/core/w:o	Ljava/lang/String;
    //   52: aload_1
    //   53: invokevirtual 426	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   56: putstatic 77	com/tencent/mobileqq/msf/core/w:p	Ljava/lang/String;
    //   59: aload_1
    //   60: astore_3
    //   61: getstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   64: ifnonnull +520 -> 584
    //   67: ldc 67
    //   69: putstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   72: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +43 -> 118
    //   78: ldc 8
    //   80: iconst_2
    //   81: new 106	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 428
    //   91: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: getstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   97: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 430
    //   103: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 89	com/tencent/mobileqq/msf/core/w:w	Ljava/lang/String;
    //   109: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iconst_0
    //   119: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   122: new 104	java/io/File
    //   125: dup
    //   126: invokestatic 353	com/tencent/mobileqq/msf/core/MsfCore:getIMEIPath	()Ljava/lang/String;
    //   129: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: invokevirtual 122	java/io/File:exists	()Z
    //   135: ifeq +679 -> 814
    //   138: invokestatic 353	com/tencent/mobileqq/msf/core/MsfCore:getIMEIPath	()Ljava/lang/String;
    //   141: invokestatic 359	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:loadConfig	(Ljava/lang/String;)Ljava/util/Properties;
    //   144: ldc_w 361
    //   147: invokevirtual 434	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +12 -> 164
    //   155: aload_2
    //   156: astore_1
    //   157: aload_2
    //   158: invokevirtual 437	java/lang/String:length	()I
    //   161: ifne +23 -> 184
    //   164: ldc2_w 438
    //   167: invokestatic 444	java/lang/Thread:sleep	(J)V
    //   170: invokestatic 353	com/tencent/mobileqq/msf/core/MsfCore:getIMEIPath	()Ljava/lang/String;
    //   173: invokestatic 359	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:loadConfig	(Ljava/lang/String;)Ljava/util/Properties;
    //   176: ldc_w 361
    //   179: aconst_null
    //   180: invokevirtual 447	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   183: astore_1
    //   184: iconst_1
    //   185: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   188: aload_1
    //   189: astore_2
    //   190: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +43 -> 236
    //   196: ldc 8
    //   198: iconst_2
    //   199: new 106	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 449
    //   209: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokestatic 353	com/tencent/mobileqq/msf/core/MsfCore:getIMEIPath	()Ljava/lang/String;
    //   215: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 451
    //   221: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_1
    //   235: astore_2
    //   236: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   239: ldc 8
    //   241: iconst_0
    //   242: invokevirtual 455	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   245: astore 4
    //   247: aload_2
    //   248: ifnull +10 -> 258
    //   251: aload_2
    //   252: invokevirtual 437	java/lang/String:length	()I
    //   255: ifne +486 -> 741
    //   258: aload 4
    //   260: ldc 11
    //   262: aconst_null
    //   263: invokeinterface 460 3 0
    //   268: astore_2
    //   269: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +29 -> 301
    //   275: ldc 8
    //   277: iconst_2
    //   278: new 106	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 462
    //   288: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_2
    //   292: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_2
    //   302: ifnull +12 -> 314
    //   305: aload_2
    //   306: invokevirtual 437	java/lang/String:length	()I
    //   309: istore_0
    //   310: iload_0
    //   311: ifne +423 -> 734
    //   314: aload_3
    //   315: ifnull +419 -> 734
    //   318: getstatic 467	android/os/Build$VERSION:SDK_INT	I
    //   321: bipush 28
    //   323: if_icmple +285 -> 608
    //   326: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   329: invokestatic 470	com/tencent/mobileqq/Pandora/Pandora:getAndroidID	(Landroid/content/Context;)Ljava/lang/String;
    //   332: astore_1
    //   333: aload_1
    //   334: ifnull +322 -> 656
    //   337: aload_1
    //   338: invokevirtual 437	java/lang/String:length	()I
    //   341: ifle +315 -> 656
    //   344: iconst_3
    //   345: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   348: aload_1
    //   349: astore_2
    //   350: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +31 -> 384
    //   356: ldc 8
    //   358: iconst_2
    //   359: new 106	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 472
    //   369: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_1
    //   373: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload_1
    //   383: astore_2
    //   384: aload_2
    //   385: invokestatic 474	com/tencent/mobileqq/msf/core/w:a	(Ljava/lang/String;)V
    //   388: aload 4
    //   390: invokeinterface 478 1 0
    //   395: astore_1
    //   396: aload_1
    //   397: ldc 11
    //   399: aload_2
    //   400: invokeinterface 484 3 0
    //   405: pop
    //   406: aload_1
    //   407: invokeinterface 487 1 0
    //   412: pop
    //   413: aload_2
    //   414: putstatic 81	com/tencent/mobileqq/msf/core/w:s	Ljava/lang/String;
    //   417: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +43 -> 463
    //   423: ldc 8
    //   425: iconst_1
    //   426: new 106	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 489
    //   436: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: getstatic 81	com/tencent/mobileqq/msf/core/w:s	Ljava/lang/String;
    //   442: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 491
    //   448: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: getstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   454: invokevirtual 494	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: ldc_w 496
    //   466: putstatic 87	com/tencent/mobileqq/msf/core/w:v	Ljava/lang/String;
    //   469: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   472: invokevirtual 500	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   475: ldc_w 502
    //   478: invokevirtual 508	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   481: astore_1
    //   482: bipush 64
    //   484: newarray byte
    //   486: astore_2
    //   487: aload_1
    //   488: aload_2
    //   489: iconst_0
    //   490: bipush 64
    //   492: invokevirtual 511	java/io/InputStream:read	([BII)I
    //   495: istore_0
    //   496: iload_0
    //   497: iconst_m1
    //   498: if_icmpeq +50 -> 548
    //   501: new 373	java/lang/String
    //   504: dup
    //   505: aload_2
    //   506: iconst_0
    //   507: iload_0
    //   508: invokespecial 513	java/lang/String:<init>	([BII)V
    //   511: putstatic 87	com/tencent/mobileqq/msf/core/w:v	Ljava/lang/String;
    //   514: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +31 -> 548
    //   520: ldc 8
    //   522: iconst_2
    //   523: new 106	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 515
    //   533: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: getstatic 87	com/tencent/mobileqq/msf/core/w:v	Ljava/lang/String;
    //   539: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: return
    //   549: astore_2
    //   550: aconst_null
    //   551: astore_1
    //   552: ldc 8
    //   554: iconst_1
    //   555: new 106	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 517
    //   565: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: aload_2
    //   576: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: aload_1
    //   580: astore_3
    //   581: goto -520 -> 61
    //   584: getstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   587: invokevirtual 437	java/lang/String:length	()I
    //   590: iconst_5
    //   591: if_icmple -519 -> 72
    //   594: getstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   597: iconst_0
    //   598: iconst_5
    //   599: invokevirtual 521	java/lang/String:substring	(II)Ljava/lang/String;
    //   602: putstatic 83	com/tencent/mobileqq/msf/core/w:t	Ljava/lang/String;
    //   605: goto -533 -> 72
    //   608: getstatic 467	android/os/Build$VERSION:SDK_INT	I
    //   611: bipush 26
    //   613: if_icmpge +13 -> 626
    //   616: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   619: invokestatic 524	com/tencent/mobileqq/Pandora/Pandora:getDeviceID	(Landroid/content/Context;)Ljava/lang/String;
    //   622: astore_1
    //   623: goto -290 -> 333
    //   626: invokestatic 405	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   629: invokestatic 527	com/tencent/mobileqq/Pandora/Pandora:getImei	(Landroid/content/Context;)Ljava/lang/String;
    //   632: astore_1
    //   633: goto -300 -> 333
    //   636: astore_1
    //   637: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +179 -> 819
    //   643: ldc 8
    //   645: iconst_2
    //   646: ldc_w 529
    //   649: aload_1
    //   650: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: goto +166 -> 819
    //   656: invokestatic 531	com/tencent/mobileqq/msf/core/w:m	()Ljava/lang/String;
    //   659: astore_1
    //   660: iconst_4
    //   661: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   664: aload_1
    //   665: astore_2
    //   666: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq -285 -> 384
    //   672: ldc 8
    //   674: iconst_2
    //   675: new 106	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 533
    //   685: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_1
    //   689: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aload_1
    //   699: astore_2
    //   700: goto -316 -> 384
    //   703: astore_1
    //   704: ldc 8
    //   706: iconst_1
    //   707: new 106	java/lang/StringBuilder
    //   710: dup
    //   711: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   714: ldc_w 535
    //   717: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_1
    //   721: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: aload_1
    //   728: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   731: goto -268 -> 463
    //   734: iconst_2
    //   735: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   738: goto -354 -> 384
    //   741: iconst_1
    //   742: putstatic 73	com/tencent/mobileqq/msf/core/w:k	I
    //   745: goto -357 -> 388
    //   748: astore_1
    //   749: ldc 8
    //   751: iconst_1
    //   752: new 106	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   759: ldc_w 537
    //   762: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload_1
    //   766: invokevirtual 540	java/io/IOException:getMessage	()Ljava/lang/String;
    //   769: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: return
    //   779: astore_1
    //   780: ldc 8
    //   782: iconst_1
    //   783: new 106	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   790: ldc_w 542
    //   793: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_1
    //   797: invokevirtual 543	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   800: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: return
    //   810: astore_2
    //   811: goto -259 -> 552
    //   814: aconst_null
    //   815: astore_2
    //   816: goto -580 -> 236
    //   819: aconst_null
    //   820: astore_1
    //   821: goto -488 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   309	199	0	i1	int
    //   12	621	1	localObject1	Object
    //   636	14	1	localSecurityException	java.lang.SecurityException
    //   659	40	1	str1	String
    //   703	25	1	localException1	Exception
    //   748	18	1	localIOException	java.io.IOException
    //   779	18	1	localException2	Exception
    //   820	1	1	localObject2	Object
    //   19	487	2	localObject3	Object
    //   549	27	2	localException3	Exception
    //   665	35	2	str2	String
    //   810	1	2	localException4	Exception
    //   815	1	2	localObject4	Object
    //   60	521	3	localObject5	Object
    //   245	144	4	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   0	13	549	java/lang/Exception
    //   318	333	636	java/lang/SecurityException
    //   608	623	636	java/lang/SecurityException
    //   626	633	636	java/lang/SecurityException
    //   118	151	703	java/lang/Exception
    //   157	164	703	java/lang/Exception
    //   164	184	703	java/lang/Exception
    //   184	188	703	java/lang/Exception
    //   190	234	703	java/lang/Exception
    //   236	247	703	java/lang/Exception
    //   251	258	703	java/lang/Exception
    //   258	301	703	java/lang/Exception
    //   305	310	703	java/lang/Exception
    //   318	333	703	java/lang/Exception
    //   337	348	703	java/lang/Exception
    //   350	382	703	java/lang/Exception
    //   384	388	703	java/lang/Exception
    //   388	463	703	java/lang/Exception
    //   608	623	703	java/lang/Exception
    //   626	633	703	java/lang/Exception
    //   637	653	703	java/lang/Exception
    //   656	664	703	java/lang/Exception
    //   666	698	703	java/lang/Exception
    //   734	738	703	java/lang/Exception
    //   741	745	703	java/lang/Exception
    //   482	496	748	java/io/IOException
    //   501	548	748	java/io/IOException
    //   469	482	779	java/lang/Exception
    //   482	496	779	java/lang/Exception
    //   501	548	779	java/lang/Exception
    //   749	778	779	java/lang/Exception
    //   13	20	810	java/lang/Exception
    //   24	32	810	java/lang/Exception
    //   32	37	810	java/lang/Exception
    //   41	45	810	java/lang/Exception
    //   45	59	810	java/lang/Exception
  }
  
  public static String d()
  {
    return s;
  }
  
  public static String e()
  {
    return t;
  }
  
  public static String f()
  {
    return u;
  }
  
  public static String g()
  {
    return v;
  }
  
  public static int h()
  {
    return r;
  }
  
  public static String i()
  {
    return o;
  }
  
  public static String j()
  {
    return p;
  }
  
  public static int k()
  {
    return q;
  }
  
  public static String l()
  {
    return w;
  }
  
  public static String m()
  {
    String str1 = null;
    Object localObject = new File(MsfCore.getIMEIPath());
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      if (((File)localObject).exists()) {
        str1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
      }
      if (str1 != null)
      {
        i1 = str1.length();
        if (i1 > 0) {
          return str1;
        }
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < 15)
      {
        localStringBuffer.append(new Random().nextInt(10));
        i1 += 1;
      }
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        if (!((File)localObject).exists()) {
          continue;
        }
        localObject = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
        ((Properties)localObject).put("imei", str2);
        MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), (Properties)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "write imei " + str2);
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.Util", 1, "load imei error", localException2);
        continue;
      }
      return localStringBuffer.toString();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "can not create imei file");
      }
    }
  }
  
  public static String n()
  {
    try
    {
      NetworkInterface localNetworkInterface;
      InetAddress localInetAddress;
      do
      {
        localObject = alkz.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          do
          {
            if ((localObject == null) || (!((Enumeration)localObject).hasMoreElements())) {
              break;
            }
            localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
          } while (localNetworkInterface == null);
          localEnumeration = localNetworkInterface.getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLinkLocalAddress()));
      Object localObject = localNetworkInterface.getName() + ":" + localInetAddress.getHostAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.C.Util", 2, "getDeviceIp error " + localException.toString(), localException);
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.w
 * JD-Core Version:    0.7.0.1
 */