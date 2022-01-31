package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class j
{
  public static final String a = "MSF.C.Util";
  private static final int b = 60000;
  private static final int c = 1000000;
  private static final AtomicInteger d = new AtomicInteger(60000 + new Random().nextInt(100000));
  private static String e = "";
  private static String f = "";
  private static int g;
  private static int h = 0;
  private static String i = "";
  private static String j = "";
  private static String k = "";
  private static String l = "";
  private static String m = "";
  
  public static int a()
  {
    try
    {
      int n = d.incrementAndGet();
      if (n > 1000000) {
        d.set(60000 + new Random().nextInt(100000));
      }
      return n;
    }
    finally {}
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
  
  private static void a(File paramFile, SimpleAccount paramSimpleAccount)
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList(paramFile);
    a(paramSimpleAccount.getUin(), localArrayList);
    localArrayList.add(paramSimpleAccount);
    a(paramFile, localArrayList);
  }
  
  private static void a(File paramFile, String paramString)
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList(paramFile);
    a(paramString, localArrayList);
    a(paramFile, localArrayList);
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 164	java/util/Properties
    //   3: dup
    //   4: invokespecial 165	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 171	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 174	java/io/File:createNewFile	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 178 1 0
    //   26: astore_2
    //   27: aload_2
    //   28: invokeinterface 183 1 0
    //   33: ifeq +101 -> 134
    //   36: aload_2
    //   37: invokeinterface 187 1 0
    //   42: checkcast 144	com/tencent/qphone/base/remote/SimpleAccount
    //   45: astore_1
    //   46: aload_3
    //   47: aload_1
    //   48: invokevirtual 145	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokevirtual 190	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   55: invokevirtual 194	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -32 -> 27
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +43 -> 113
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 8
    //   77: iconst_2
    //   78: new 201	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   85: ldc 204
    //   87: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 211	java/io/File:getName	()Ljava/lang/String;
    //   94: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 213
    //   99: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aload_3
    //   110: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 224	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 225	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: new 227	java/io/FileOutputStream
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: aload_2
    //   147: ldc 45
    //   149: invokevirtual 237	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   152: aload_2
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   158: aload_2
    //   159: astore_1
    //   160: ldc 8
    //   162: iconst_1
    //   163: new 201	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   170: ldc 239
    //   172: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_0
    //   176: invokevirtual 211	java/io/File:getName	()Ljava/lang/String;
    //   179: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: ifeq +11 -> 200
    //   192: new 224	java/lang/NullPointerException
    //   195: dup
    //   196: invokespecial 225	java/lang/NullPointerException:<init>	()V
    //   199: athrow
    //   200: aload_2
    //   201: ifnull -68 -> 133
    //   204: aload_2
    //   205: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   208: return
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   214: return
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   220: goto -20 -> 200
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   228: goto -103 -> 125
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   236: return
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_1
    //   240: iconst_0
    //   241: ifeq +11 -> 252
    //   244: new 224	java/lang/NullPointerException
    //   247: dup
    //   248: invokespecial 225	java/lang/NullPointerException:<init>	()V
    //   251: athrow
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 230	java/io/FileOutputStream:close	()V
    //   260: aload_0
    //   261: athrow
    //   262: astore_2
    //   263: aload_2
    //   264: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   267: goto -15 -> 252
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   275: goto -15 -> 260
    //   278: astore_0
    //   279: goto -39 -> 240
    //   282: astore_3
    //   283: goto -218 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramFile	File
    //   0	286	1	paramList	List
    //   26	179	2	localObject	Object
    //   262	2	2	localIOException	IOException
    //   7	40	3	localProperties	Properties
    //   62	84	3	localException1	Exception
    //   282	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	20	62	java/lang/Exception
    //   20	27	62	java/lang/Exception
    //   27	59	62	java/lang/Exception
    //   134	143	62	java/lang/Exception
    //   204	208	209	java/io/IOException
    //   192	200	215	java/io/IOException
    //   117	125	223	java/io/IOException
    //   129	133	231	java/io/IOException
    //   8	20	237	finally
    //   20	27	237	finally
    //   27	59	237	finally
    //   134	143	237	finally
    //   244	252	262	java/io/IOException
    //   256	260	270	java/io/IOException
    //   67	73	278	finally
    //   75	113	278	finally
    //   145	152	278	finally
    //   154	158	278	finally
    //   160	188	278	finally
    //   145	152	282	java/lang/Exception
    //   154	158	282	java/lang/Exception
    //   160	188	282	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    try
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", paramString);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
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
  
  private static void a(String paramString, List paramList)
  {
    int n = 1;
    for (;;)
    {
      if (n != 0)
      {
        Iterator localIterator = paramList.iterator();
        n = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label64;
          }
          if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
          {
            paramList.remove(n);
            n = 1;
            break;
          }
          n += 1;
        }
      }
      return;
      label64:
      n = 0;
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int n = 0;
    while (n < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      n += 1;
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
  
  public static void c()
  {
    Object localObject1 = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    try
    {
      localObject2 = ((TelephonyManager)localObject1).getSubscriberId();
      if (localObject2 != null)
      {
        j = (String)localObject2;
        k = (String)localObject2;
      }
      localObject2 = ((TelephonyManager)localObject1).getNetworkOperatorName();
      if (localObject2 != null) {
        m = (String)localObject2;
      }
      e = ((TelephonyManager)localObject1).getNetworkCountryIso();
      f = ((TelephonyManager)localObject1).getSimCountryIso();
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          localObject1 = BaseApplication.getContext().getAssets().open("revision.txt");
          try
          {
            localObject2 = new byte[64];
            n = ((InputStream)localObject1).read((byte[])localObject2, 0, 64);
            if (n != -1)
            {
              l = new String((byte[])localObject2, 0, n);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.Util", 2, "revision:" + l);
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            QLog.d("MSF.C.Util", 1, "get revision IOException " + localIOException.getMessage());
            return;
          }
          localException3 = localException3;
          QLog.d("MSF.C.Util", 1, "get imsi error " + localException3, localException3);
        }
        catch (Exception localException2)
        {
          QLog.d("MSF.C.Util", 1, "get revision error " + localException2.getMessage());
        }
        if (j.length() > 5) {
          j = j.substring(0, 5);
        }
      }
    }
    if (j == null)
    {
      j = "";
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "imsi:" + j + " networkOperatorName:" + m);
      }
    }
    try
    {
      localObject1 = ((TelephonyManager)localObject1).getDeviceId();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        i = (String)localObject1;
        a((String)localObject1);
        QLog.d("MSF.C.Util", 2, "read sys imei:" + i);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int n;
        QLog.d("MSF.C.Util", 1, "read sys imei error " + localException1, localException1);
      }
    }
    if ((i == null) || (i.length() == 0))
    {
      i = m();
      QLog.d("MSF.C.Util", 2, "load imei:" + i);
    }
    l = "testrevision";
  }
  
  public static String d()
  {
    return i;
  }
  
  public static String e()
  {
    return j;
  }
  
  public static String f()
  {
    return k;
  }
  
  public static String g()
  {
    return l;
  }
  
  public static int h()
  {
    return h;
  }
  
  public static String i()
  {
    return e;
  }
  
  public static String j()
  {
    return f;
  }
  
  public static int k()
  {
    return g;
  }
  
  public static String l()
  {
    return m;
  }
  
  public static String m()
  {
    String str1 = null;
    Object localObject = new File(MsfCore.SAVEPATH_IMEI);
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      if (((File)localObject).exists()) {
        str1 = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI).getProperty("imei");
      }
      if (str1 != null)
      {
        n = str1.length();
        if (n > 0) {
          return str1;
        }
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
      localStringBuffer = new StringBuffer();
      int n = 0;
      while (n < 15)
      {
        localStringBuffer.append(new Random().nextInt(10));
        n += 1;
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
        localObject = MsfSdkUtils.loadConfig(MsfCore.SAVEPATH_IMEI);
        ((Properties)localObject).put("imei", str2);
        MsfSdkUtils.saveConfig(MsfCore.SAVEPATH_IMEI, (Properties)localObject);
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
        localObject = NetworkInterface.getNetworkInterfaces();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.j
 * JD-Core Version:    0.7.0.1
 */