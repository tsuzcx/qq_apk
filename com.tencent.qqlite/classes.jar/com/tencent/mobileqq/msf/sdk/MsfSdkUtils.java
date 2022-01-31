package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfSdkUtils
{
  public static final String TAG_COREUTIL_TOMSGE_UID = "__CoreUtil_toMsg_Uid";
  public static final boolean isPublicVersion = false;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MsfSdkUtils";
  public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  
  public static void addFromMsgProcessName(String paramString, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    paramFromServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static void addLoginSimpleAccount(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = getNewAppUinStoreFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        if (((File)localObject).exists())
        {
          if (isAccountFileExist((File)localObject, paramString)) {
            updateSimpleAccountNotCreate(paramString, true);
          }
        }
        else {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder().append(((File)localObject).getAbsolutePath()).append("/").append("u_").append(paramString);
        if (paramBoolean)
        {
          localObject = "_t";
          localObject = new File((String)localObject);
          try
          {
            ((File)localObject).createNewFile();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "add user failed " + paramString + " " + localException);
          }
        }
        else
        {
          String str = "_f";
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void addSimpleAccount(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 72	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 78	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_2
    //   15: invokevirtual 81	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 78	java/io/File:exists	()Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: aload_0
    //   28: invokestatic 85	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isAccountFileExist	(Ljava/io/File;Ljava/lang/String;)Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +7 -> 40
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: new 74	java/io/File
    //   43: dup
    //   44: new 90	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 101
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 103
    //   65: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 130
    //   74: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 112	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -56 -> 36
    //   95: ldc 16
    //   97: iconst_2
    //   98: new 90	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   105: ldc 133
    //   107: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -84 -> 36
    //   123: astore_2
    //   124: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -91 -> 36
    //   130: ldc 16
    //   132: iconst_2
    //   133: new 90	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   140: ldc 119
    //   142: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 121
    //   151: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto -128 -> 36
    //   167: astore_0
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   31	2	1	bool	boolean
    //   6	79	2	localFile	File
    //   123	32	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   84	120	123	java/lang/Exception
    //   3	19	167	finally
    //   19	32	167	finally
    //   40	84	167	finally
    //   84	120	167	finally
    //   124	164	167	finally
  }
  
  public static void addToMsgProcessName(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static FromServiceMsg constructResponse(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      return new FromServiceMsg();
    }
    paramString = constructResponse(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd(), paramToServiceMsg.getAppId(), paramInt, paramString, paramObject, paramToServiceMsg.getRequestSsoSeq());
    paramString.setAppSeq(paramToServiceMsg.getAppSeq());
    return paramString;
  }
  
  public static FromServiceMsg constructResponse(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Object paramObject, int paramInt3)
  {
    paramString1 = new FromServiceMsg(paramString1, paramString2);
    paramString1.setAppId(paramInt1);
    if (paramInt2 != 1000) {
      paramString1.setBusinessFail(paramInt2, paramString3);
    }
    for (;;)
    {
      if (paramObject != null) {
        paramString1.addAttribute(paramString2, paramObject);
      }
      paramString1.setRequestSsoSeq(paramInt3);
      return paramString1;
      paramString1.setMsgSuccess();
    }
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] << 0 & 0xFF;
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF;
  }
  
  public static byte[] convertInt2Bytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void delSimpleAccount(String paramString)
  {
    try
    {
      File localFile = getNewAppUinStoreFile();
      if (localFile.exists())
      {
        String[] arrayOfString = localFile.list();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if ((str.equals("u_" + paramString + "_f")) || (str.equals("u_" + paramString + "_t")))
          {
            new File(localFile.getPath(), str).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "del user succ " + paramString);
            }
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public static File getAppUinBackStoreFile()
  {
    try
    {
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/simpleback.user");
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static File getAppUinStoreFile()
  {
    try
    {
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/simple.user");
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static ArrayList getLoginedAccountList()
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject1 = getNewAppUinStoreFile();
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          String[] arrayOfString = ((File)localObject1).list();
          localArrayList = new ArrayList();
          int j = arrayOfString.length;
          i = 0;
          localObject1 = localArrayList;
          if (i >= j) {
            break label293;
          }
          localObject1 = arrayOfString[i];
          try
          {
            if (!((String)localObject1).startsWith("u_")) {
              break label330;
            }
            String str = ((String)localObject1).substring(2, ((String)localObject1).length() - 2);
            boolean bool = ((String)localObject1).endsWith("_t");
            SimpleAccount localSimpleAccount = new SimpleAccount();
            localSimpleAccount.setUin(str);
            localSimpleAccount.setAttribute("_isLogined", String.valueOf(bool));
            if (isUinLong(str)) {
              localArrayList.add(localSimpleAccount);
            } else {
              QLog.d("MsfSdkUtils", 1, "found invalid uin: " + str);
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label330;
            }
          }
          QLog.d("MsfSdkUtils", 2, "parse user failed " + localException + " " + (String)localObject1);
        }
      }
      finally {}
      Object localObject3 = getLoginedAccountList(getAppUinStoreFile());
      if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
      {
        localArrayList = getLoginedAccountList(getAppUinBackStoreFile());
        localObject3 = localArrayList;
        if (localArrayList != null)
        {
          localObject3 = localArrayList;
          if (QLog.isColorLevel())
          {
            QLog.d("MsfSdkUtils", 2, "load accountList " + localArrayList.size() + " from backFile");
            localObject3 = localArrayList;
          }
        }
      }
      for (;;)
      {
        label293:
        return localObject3;
        QLog.d("MsfSdkUtils", 1, "load accountList " + ((ArrayList)localObject3).size());
      }
      label330:
      i += 1;
    }
  }
  
  /* Error */
  public static ArrayList getLoginedAccountList(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 235	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 236	java/util/ArrayList:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: ifnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 78	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifne +9 -> 31
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload 4
    //   30: areturn
    //   31: new 296	java/util/Properties
    //   34: dup
    //   35: invokespecial 297	java/util/Properties:<init>	()V
    //   38: astore_3
    //   39: new 299	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_3
    //   51: aload_2
    //   52: invokevirtual 306	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_2
    //   56: astore_0
    //   57: aload_3
    //   58: invokevirtual 310	java/util/Properties:keySet	()Ljava/util/Set;
    //   61: invokeinterface 316 1 0
    //   66: astore 5
    //   68: aload_2
    //   69: astore_0
    //   70: aload 5
    //   72: invokeinterface 321 1 0
    //   77: ifeq +143 -> 220
    //   80: aload_2
    //   81: astore_0
    //   82: aload 5
    //   84: invokeinterface 325 1 0
    //   89: checkcast 198	java/lang/String
    //   92: astore 6
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: aload 6
    //   99: invokevirtual 329	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull -38 -> 68
    //   109: aload_2
    //   110: astore_0
    //   111: aload 7
    //   113: invokestatic 333	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnull -52 -> 68
    //   123: aload_2
    //   124: astore_0
    //   125: aload 7
    //   127: invokevirtual 334	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   130: invokestatic 268	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   133: ifeq +34 -> 167
    //   136: aload_2
    //   137: astore_0
    //   138: aload 4
    //   140: aload 7
    //   142: invokevirtual 271	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -78 -> 68
    //   149: astore_3
    //   150: aload_2
    //   151: astore_0
    //   152: aload_3
    //   153: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 337	java/io/FileInputStream:close	()V
    //   164: goto -139 -> 25
    //   167: aload_2
    //   168: astore_0
    //   169: ldc 16
    //   171: iconst_1
    //   172: new 90	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 273
    //   182: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 6
    //   187: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: goto -128 -> 68
    //   199: astore_3
    //   200: aload_0
    //   201: astore_2
    //   202: aload_3
    //   203: astore_0
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 337	java/io/FileInputStream:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_0
    //   219: athrow
    //   220: aload_2
    //   221: ifnull -57 -> 164
    //   224: aload_2
    //   225: invokevirtual 337	java/io/FileInputStream:close	()V
    //   228: goto -64 -> 164
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   236: goto -72 -> 164
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   244: goto -80 -> 164
    //   247: astore_2
    //   248: aload_2
    //   249: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   252: goto -40 -> 212
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -54 -> 204
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -114 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramFile	File
    //   20	2	1	bool	boolean
    //   47	178	2	localObject1	Object
    //   247	2	2	localIOException	IOException
    //   257	7	2	localObject2	Object
    //   38	59	3	localProperties	java.util.Properties
    //   149	4	3	localException1	Exception
    //   199	4	3	localObject3	Object
    //   261	1	3	localException2	Exception
    //   10	129	4	localArrayList	ArrayList
    //   66	17	5	localIterator	Iterator
    //   92	94	6	str	String
    //   102	39	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   50	55	149	java/lang/Exception
    //   57	68	149	java/lang/Exception
    //   70	80	149	java/lang/Exception
    //   82	94	149	java/lang/Exception
    //   96	104	149	java/lang/Exception
    //   111	118	149	java/lang/Exception
    //   125	136	149	java/lang/Exception
    //   138	146	149	java/lang/Exception
    //   169	196	149	java/lang/Exception
    //   50	55	199	finally
    //   57	68	199	finally
    //   70	80	199	finally
    //   82	94	199	finally
    //   96	104	199	finally
    //   111	118	199	finally
    //   125	136	199	finally
    //   138	146	199	finally
    //   152	156	199	finally
    //   169	196	199	finally
    //   3	12	214	finally
    //   16	21	214	finally
    //   31	39	214	finally
    //   160	164	214	finally
    //   208	212	214	finally
    //   212	214	214	finally
    //   224	228	214	finally
    //   232	236	214	finally
    //   240	244	214	finally
    //   248	252	214	finally
    //   224	228	231	java/io/IOException
    //   160	164	239	java/io/IOException
    //   208	212	247	java/io/IOException
    //   39	48	255	finally
    //   39	48	261	java/lang/Exception
  }
  
  public static File getNewAppUinStoreFile()
  {
    try
    {
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/user/");
      return localFile;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsfSdkUtils", 2, "get user file error " + BaseApplication.getContext().getFilesDir() + " " + localException);
      }
    }
    return null;
  }
  
  public static int getNextAppSeq()
  {
    try
    {
      int j = seqFactory.incrementAndGet();
      if (j > 1000000) {
        seqFactory.set(new Random().nextInt(100000));
      }
      int i = j;
      if (j == 50000) {
        i = j + 10000;
      }
      return i;
    }
    finally {}
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    Context localContext = null;
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      localContext = paramContext;
      Iterator localIterator = paramContext.iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        do
        {
          localContext = paramContext;
          if (!localIterator.hasNext()) {
            break;
          }
          localContext = paramContext;
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        } while (localRunningAppProcessInfo == null);
        localContext = paramContext;
      } while (localRunningAppProcessInfo.pid != Process.myPid());
      localContext = paramContext;
      paramContext = localRunningAppProcessInfo.processName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.d("MsfSdkUtils", 1, "getProcessName error " + localContext, paramContext);
    }
    return "unknown";
  }
  
  public static String getResolutionString(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    int k;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      return k + "X" + j;
      k = i;
    }
  }
  
  /* Error */
  public static String getServerConfig(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokestatic 428	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +10 -> 18
    //   11: aload_2
    //   12: invokevirtual 78	java/io/File:exists	()Z
    //   15: ifne +7 -> 22
    //   18: ldc_w 430
    //   21: areturn
    //   22: new 90	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_0
    //   33: new 432	java/io/InputStreamReader
    //   36: dup
    //   37: new 299	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: ldc_w 434
    //   48: invokespecial 437	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: sipush 4096
    //   57: newarray char
    //   59: astore_3
    //   60: aload_2
    //   61: astore_0
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual 441	java/io/InputStreamReader:read	([C)I
    //   67: istore_1
    //   68: iconst_m1
    //   69: iload_1
    //   70: if_icmpeq +38 -> 108
    //   73: aload_2
    //   74: astore_0
    //   75: aload 4
    //   77: aload_3
    //   78: iconst_0
    //   79: iload_1
    //   80: invokevirtual 444	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: goto -24 -> 60
    //   87: astore_3
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 445	java/io/InputStreamReader:close	()V
    //   102: aload 4
    //   104: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: areturn
    //   108: aload_2
    //   109: ifnull -7 -> 102
    //   112: aload_2
    //   113: invokevirtual 445	java/io/InputStreamReader:close	()V
    //   116: goto -14 -> 102
    //   119: astore_0
    //   120: goto -18 -> 102
    //   123: astore_3
    //   124: aload_0
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 445	java/io/InputStreamReader:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: astore_0
    //   139: goto -37 -> 102
    //   142: astore_2
    //   143: goto -7 -> 136
    //   146: astore_3
    //   147: aload_0
    //   148: astore_2
    //   149: aload_3
    //   150: astore_0
    //   151: goto -23 -> 128
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -69 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString1	String
    //   0	160	1	paramInt	int
    //   0	160	2	paramString2	String
    //   59	19	3	arrayOfChar	char[]
    //   87	4	3	localException1	Exception
    //   123	4	3	localObject1	Object
    //   146	4	3	localObject2	Object
    //   154	1	3	localException2	Exception
    //   29	74	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	60	87	java/lang/Exception
    //   62	68	87	java/lang/Exception
    //   75	84	87	java/lang/Exception
    //   112	116	119	java/io/IOException
    //   33	52	123	finally
    //   98	102	138	java/io/IOException
    //   132	136	142	java/io/IOException
    //   54	60	146	finally
    //   62	68	146	finally
    //   75	84	146	finally
    //   90	94	146	finally
    //   33	52	154	java/lang/Exception
  }
  
  public static File getServerConfigFile(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      return null;
      paramString1 = paramString1.replaceAll(":", "_");
      if (paramInt == 0) {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString1 + "_common");
      }
      if (paramInt == 1) {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString1 + "_" + paramString2.hashCode() + "_user");
      }
    } while (paramInt != 2);
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString1 + "_app");
  }
  
  public static String getShortUin(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return "*" + paramString.substring(paramString.length() - 4, paramString.length());
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public static int getToServiceMsgUid(ToServiceMsg paramToServiceMsg)
  {
    return ((Integer)paramToServiceMsg.getAttribute("__CoreUtil_toMsg_Uid", Integer.valueOf(-1))).intValue();
  }
  
  public static String getTotalMemory()
  {
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        String str = localBufferedReader.readLine();
        if (str != null) {
          str = str.trim();
        }
        str = "";
      }
      catch (IOException localIOException1)
      {
        try
        {
          localBufferedReader.close();
          return str;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        localIOException1 = localIOException1;
        str = "";
        localIOException1.printStackTrace();
        return str;
      }
    }
  }
  
  public static String insertMtype(String paramString1, String paramString2)
  {
    if (paramString2.contains("mType=")) {}
    do
    {
      do
      {
        return paramString2;
      } while (paramString1 == null);
      int i = paramString2.indexOf("?");
      if (i > 0)
      {
        if (paramString2.length() == i + 1) {
          return paramString2.substring(0, i + 1) + "mType=" + paramString1;
        }
        i = paramString2.indexOf("#", i);
        if (i > -1) {}
        for (paramString1 = paramString2.substring(0, i) + "&mType=" + paramString1 + paramString2.substring(i);; paramString1 = paramString2 + "&mType=" + paramString1) {
          return paramString1;
        }
      }
    } while (paramString2.length() <= 0);
    return paramString2 + "?mType=" + paramString1;
  }
  
  private static boolean isAccountFileExist(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = paramFile.list();
    boolean bool1 = bool2;
    int i;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.length > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramFile.length)
      {
        if ((paramFile[i] != null) && ((paramFile[i].equals("u_" + paramString + "_f")) || (paramFile[i].equals("u_" + paramString + "_t")))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      boolean bool = ((Boolean)paramContext.getClass().getMethod("isScreenOn", new Class[0]).invoke(paramContext, (Object[])null)).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      QLog.d("MsfSdkUtils", 1, "e = " + paramContext.toString());
    }
    return true;
  }
  
  public static boolean isTopActivity(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      String str = paramContext.getPackageName();
      boolean bool = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName().equals(str);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean isUinLong(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static java.util.Properties loadConfig(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: new 296	java/util/Properties
    //   3: dup
    //   4: invokespecial 297	java/util/Properties:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: new 299	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 618	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 306	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_1
    //   29: ifnull -17 -> 12
    //   32: aload_1
    //   33: invokevirtual 337	java/io/FileInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 337	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: goto -11 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   22	24	1	localFileInputStream	java.io.FileInputStream
    //   7	30	2	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   14	23	38	finally
    //   23	28	51	finally
  }
  
  /* Error */
  public static void saveConfig(String paramString, java.util.Properties paramProperties)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 623	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 625	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: ldc_w 430
    //   24: invokevirtual 629	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: invokevirtual 630	java/io/FileOutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 630	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: athrow
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto -13 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   0	55	1	paramProperties	java.util.Properties
    //   18	33	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	19	36	finally
    //   19	27	49	finally
  }
  
  public static void setToServiceMsgUid(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.getAttributes().put("__CoreUtil_toMsg_Uid", Integer.valueOf(paramInt));
  }
  
  public static void updateSimpleAccount(String paramString, boolean paramBoolean)
  {
    label404:
    for (;;)
    {
      try
      {
        Object localObject2 = getNewAppUinStoreFile();
        int i;
        if (((File)localObject2).exists())
        {
          Object localObject3 = new StringBuilder().append(((File)localObject2).getAbsolutePath()).append("/").append("u_").append(paramString);
          if (!paramBoolean) {
            continue;
          }
          localObject1 = "_t";
          localObject1 = (String)localObject1;
          localObject3 = new File((String)localObject1);
          if (((File)localObject3).exists())
          {
            ((File)localObject3).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "found want update user exists,del " + paramString + " " + paramBoolean);
            }
          }
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 == null) {
            continue;
          }
          int j = localObject2.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject3 = localObject2[i];
          if ((!((File)localObject3).getName().equals("u_" + paramString + "_t")) && (!((File)localObject3).getName().equals("u_" + paramString + "_f"))) {
            break label404;
          }
          ((File)localObject3).renameTo(new File((String)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "update user succ " + paramString + " " + paramBoolean);
          }
        }
        return;
        Object localObject1 = "_f";
        continue;
        localObject1 = new File((String)localObject1);
        try
        {
          ((File)localObject1).createNewFile();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MsfSdkUtils", 2, "update add user succ " + MD5.toMD5(paramString));
        }
        catch (Exception localException)
        {
          QLog.d("MsfSdkUtils", 1, "update add user failed " + MD5.toMD5(paramString) + " " + localException);
        }
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public static void updateSimpleAccountNotCreate(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 72	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 78	java/io/File:exists	()Z
    //   13: ifeq +178 -> 191
    //   16: new 90	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   23: aload 5
    //   25: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 101
    //   33: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 103
    //   38: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: iload_1
    //   48: ifeq +147 -> 195
    //   51: ldc 105
    //   53: astore 4
    //   55: aload 6
    //   57: aload 4
    //   59: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 4
    //   67: new 74	java/io/File
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: pop
    //   77: aload 5
    //   79: invokevirtual 642	java/io/File:listFiles	()[Ljava/io/File;
    //   82: astore 5
    //   84: aload 5
    //   86: ifnull +105 -> 191
    //   89: aload 5
    //   91: arraylength
    //   92: istore_3
    //   93: iconst_0
    //   94: istore_2
    //   95: iload_2
    //   96: iload_3
    //   97: if_icmpge +94 -> 191
    //   100: aload 5
    //   102: iload_2
    //   103: aaload
    //   104: astore 6
    //   106: aload 6
    //   108: invokevirtual 645	java/io/File:getName	()Ljava/lang/String;
    //   111: new 90	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   118: ldc 103
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 105
    //   129: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne +38 -> 176
    //   141: aload 6
    //   143: invokevirtual 645	java/io/File:getName	()Ljava/lang/String;
    //   146: new 90	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   153: ldc 103
    //   155: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 130
    //   164: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +29 -> 202
    //   176: aload 6
    //   178: new 74	java/io/File
    //   181: dup
    //   182: aload 4
    //   184: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 649	java/io/File:renameTo	(Ljava/io/File;)Z
    //   190: pop
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: ldc 130
    //   197: astore 4
    //   199: goto -144 -> 55
    //   202: iload_2
    //   203: iconst_1
    //   204: iadd
    //   205: istore_2
    //   206: goto -111 -> 95
    //   209: astore_0
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   0	215	1	paramBoolean	boolean
    //   94	112	2	i	int
    //   92	6	3	j	int
    //   53	145	4	str	String
    //   6	95	5	localObject	Object
    //   45	132	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	47	209	finally
    //   55	84	209	finally
    //   89	93	209	finally
    //   106	176	209	finally
    //   176	191	209	finally
  }
  
  /* Error */
  public static void writeServerConfig(String paramString1, int paramInt, String paramString2, String paramString3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_3
    //   3: invokestatic 428	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +14 -> 22
    //   11: new 294	java/io/IOException
    //   14: dup
    //   15: ldc_w 664
    //   18: invokespecial 665	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_3
    //   23: invokevirtual 78	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_3
    //   30: invokevirtual 112	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 78	java/io/File:exists	()Z
    //   38: ifeq +10 -> 48
    //   41: aload_3
    //   42: invokevirtual 668	java/io/File:canWrite	()Z
    //   45: ifne +34 -> 79
    //   48: new 294	java/io/IOException
    //   51: dup
    //   52: new 90	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 670
    //   62: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 665	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: aconst_null
    //   80: astore_0
    //   81: new 672	java/io/OutputStreamWriter
    //   84: dup
    //   85: new 623	java/io/FileOutputStream
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 673	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: ldc_w 434
    //   96: invokespecial 675	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_3
    //   101: astore_0
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 678	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: astore_0
    //   109: aload_3
    //   110: invokevirtual 679	java/io/OutputStreamWriter:flush	()V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 680	java/io/OutputStreamWriter:close	()V
    //   121: return
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_0
    //   128: aload 4
    //   130: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   133: aload_2
    //   134: ifnull -13 -> 121
    //   137: aload_2
    //   138: invokevirtual 680	java/io/OutputStreamWriter:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: astore_3
    //   145: aload_0
    //   146: astore_2
    //   147: aload_3
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 680	java/io/OutputStreamWriter:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: return
    //   161: astore_2
    //   162: goto -5 -> 157
    //   165: astore_3
    //   166: aload_0
    //   167: astore_2
    //   168: aload_3
    //   169: astore_0
    //   170: goto -21 -> 149
    //   173: astore 4
    //   175: aload_3
    //   176: astore_2
    //   177: goto -51 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramInt	int
    //   0	180	2	paramString2	String
    //   0	180	3	paramString3	String
    //   122	7	4	localException1	Exception
    //   173	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   81	100	122	java/lang/Exception
    //   137	141	142	java/io/IOException
    //   81	100	144	finally
    //   117	121	159	java/io/IOException
    //   153	157	161	java/io/IOException
    //   102	107	165	finally
    //   109	113	165	finally
    //   128	133	165	finally
    //   102	107	173	java/lang/Exception
    //   109	113	173	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfSdkUtils
 * JD-Core Version:    0.7.0.1
 */