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
import java.lang.reflect.Method;
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
    //   3: invokestatic 69	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 75	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_2
    //   15: invokevirtual 78	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 75	java/io/File:exists	()Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: aload_0
    //   28: invokestatic 82	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isAccountFileExist	(Ljava/io/File;Ljava/lang/String;)Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +7 -> 40
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: new 71	java/io/File
    //   43: dup
    //   44: new 87	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 98
    //   60: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 100
    //   65: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 127
    //   74: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_2
    //   84: aload_2
    //   85: invokevirtual 109	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -56 -> 36
    //   95: ldc 13
    //   97: iconst_2
    //   98: new 87	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   105: ldc 130
    //   107: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -84 -> 36
    //   123: astore_2
    //   124: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -91 -> 36
    //   130: ldc 13
    //   132: iconst_2
    //   133: new 87	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   140: ldc 116
    //   142: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 118
    //   151: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
            break label292;
          }
          localObject1 = arrayOfString[i];
          try
          {
            if (!((String)localObject1).startsWith("u_")) {
              break label329;
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
              break label329;
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
        label292:
        return localObject3;
        QLog.d("MsfSdkUtils", 1, "load accountList " + ((ArrayList)localObject3).size());
      }
      label329:
      i += 1;
    }
  }
  
  /* Error */
  public static ArrayList getLoginedAccountList(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 232	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 233	java/util/ArrayList:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: ifnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 75	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifne +9 -> 31
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload 4
    //   30: areturn
    //   31: new 293	java/util/Properties
    //   34: dup
    //   35: invokespecial 294	java/util/Properties:<init>	()V
    //   38: astore_3
    //   39: new 296	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_3
    //   51: aload_2
    //   52: invokevirtual 303	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_2
    //   56: astore_0
    //   57: aload_3
    //   58: invokevirtual 307	java/util/Properties:keySet	()Ljava/util/Set;
    //   61: invokeinterface 313 1 0
    //   66: astore 5
    //   68: aload_2
    //   69: astore_0
    //   70: aload 5
    //   72: invokeinterface 318 1 0
    //   77: ifeq +143 -> 220
    //   80: aload_2
    //   81: astore_0
    //   82: aload 5
    //   84: invokeinterface 322 1 0
    //   89: checkcast 195	java/lang/String
    //   92: astore 6
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: aload 6
    //   99: invokevirtual 326	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull -38 -> 68
    //   109: aload_2
    //   110: astore_0
    //   111: aload 7
    //   113: invokestatic 330	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnull -52 -> 68
    //   123: aload_2
    //   124: astore_0
    //   125: aload 7
    //   127: invokevirtual 331	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   130: invokestatic 265	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   133: ifeq +34 -> 167
    //   136: aload_2
    //   137: astore_0
    //   138: aload 4
    //   140: aload 7
    //   142: invokevirtual 268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -78 -> 68
    //   149: astore_3
    //   150: aload_2
    //   151: astore_0
    //   152: aload_3
    //   153: invokevirtual 225	java/lang/Exception:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 334	java/io/FileInputStream:close	()V
    //   164: goto -139 -> 25
    //   167: aload_2
    //   168: astore_0
    //   169: ldc 13
    //   171: iconst_1
    //   172: new 87	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 270
    //   182: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 6
    //   187: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: goto -128 -> 68
    //   199: astore_3
    //   200: aload_0
    //   201: astore_2
    //   202: aload_3
    //   203: astore_0
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 334	java/io/FileInputStream:close	()V
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
    //   225: invokevirtual 334	java/io/FileInputStream:close	()V
    //   228: goto -64 -> 164
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   236: goto -72 -> 164
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   244: goto -80 -> 164
    //   247: astore_2
    //   248: aload_2
    //   249: invokevirtual 335	java/io/IOException:printStackTrace	()V
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
  public static String getServerConfig(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 425	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;I)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokevirtual 75	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: ldc_w 427
    //   20: areturn
    //   21: new 87	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aconst_null
    //   31: astore_0
    //   32: new 429	java/io/InputStreamReader
    //   35: dup
    //   36: new 296	java/io/FileInputStream
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: ldc_w 431
    //   47: invokespecial 434	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: sipush 4096
    //   56: newarray char
    //   58: astore_3
    //   59: aload_2
    //   60: astore_0
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 438	java/io/InputStreamReader:read	([C)I
    //   66: istore_1
    //   67: iconst_m1
    //   68: iload_1
    //   69: if_icmpeq +38 -> 107
    //   72: aload_2
    //   73: astore_0
    //   74: aload 4
    //   76: aload_3
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 441	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -24 -> 59
    //   86: astore_3
    //   87: aload_2
    //   88: astore_0
    //   89: aload_3
    //   90: invokevirtual 225	java/lang/Exception:printStackTrace	()V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 442	java/io/InputStreamReader:close	()V
    //   101: aload 4
    //   103: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: areturn
    //   107: aload_2
    //   108: ifnull -7 -> 101
    //   111: aload_2
    //   112: invokevirtual 442	java/io/InputStreamReader:close	()V
    //   115: goto -14 -> 101
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_3
    //   123: aload_0
    //   124: astore_2
    //   125: aload_3
    //   126: astore_0
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 442	java/io/InputStreamReader:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: goto -37 -> 101
    //   141: astore_2
    //   142: goto -7 -> 135
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: aload_3
    //   149: astore_0
    //   150: goto -23 -> 127
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -69 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   0	159	1	paramInt	int
    //   5	127	2	localObject1	Object
    //   141	1	2	localIOException	IOException
    //   147	9	2	str	String
    //   58	19	3	arrayOfChar	char[]
    //   86	4	3	localException1	Exception
    //   122	4	3	localObject2	Object
    //   145	4	3	localObject3	Object
    //   153	1	3	localException2	Exception
    //   28	74	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   53	59	86	java/lang/Exception
    //   61	67	86	java/lang/Exception
    //   74	83	86	java/lang/Exception
    //   111	115	118	java/io/IOException
    //   32	51	122	finally
    //   97	101	137	java/io/IOException
    //   131	135	141	java/io/IOException
    //   53	59	145	finally
    //   61	67	145	finally
    //   74	83	145	finally
    //   89	93	145	finally
    //   32	51	153	java/lang/Exception
  }
  
  public static File getServerConfigFile(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.replaceAll(":", "_");
      if (paramInt == 0) {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString + "_common");
      }
      if (paramInt == 1) {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString + "_user");
      }
    } while (paramInt != 2);
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + paramString + "_app");
  }
  
  public static String getShortUin(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return "*" + paramString.substring(paramString.length() - 4, paramString.length());
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
    String str = paramString2;
    int i;
    if (paramString1 != null)
    {
      i = paramString2.indexOf("?");
      if (i <= 0) {
        break label138;
      }
      if (paramString2.length() != i + 1) {
        break label62;
      }
      str = paramString2.substring(0, i + 1) + "mType=" + paramString1;
    }
    label62:
    do
    {
      return str;
      i = paramString2.indexOf("#");
      if (i > -1) {
        return paramString2.substring(0, i) + "&mType=" + paramString1 + paramString2.substring(i);
      }
      return paramString2 + "&mType=" + paramString1;
      str = paramString2;
    } while (paramString2.length() <= 0);
    label138:
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
    //   0: new 293	java/util/Properties
    //   3: dup
    //   4: invokespecial 294	java/util/Properties:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: new 296	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 581	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 303	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_1
    //   29: ifnull -17 -> 12
    //   32: aload_1
    //   33: invokevirtual 334	java/io/FileInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 334	java/io/FileInputStream:close	()V
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
    //   9: new 586	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 588	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: ldc_w 427
    //   24: invokevirtual 592	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: invokevirtual 593	java/io/FileOutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 593	java/io/FileOutputStream:close	()V
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
    //   3: invokestatic 69	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 75	java/io/File:exists	()Z
    //   13: ifeq +178 -> 191
    //   16: new 87	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   23: aload 5
    //   25: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 98
    //   33: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 100
    //   38: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: astore 6
    //   47: iload_1
    //   48: ifeq +147 -> 195
    //   51: ldc 102
    //   53: astore 4
    //   55: aload 6
    //   57: aload 4
    //   59: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore 4
    //   67: new 71	java/io/File
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: pop
    //   77: aload 5
    //   79: invokevirtual 605	java/io/File:listFiles	()[Ljava/io/File;
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
    //   108: invokevirtual 608	java/io/File:getName	()Ljava/lang/String;
    //   111: new 87	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   118: ldc 100
    //   120: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 102
    //   129: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne +38 -> 176
    //   141: aload 6
    //   143: invokevirtual 608	java/io/File:getName	()Ljava/lang/String;
    //   146: new 87	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   153: ldc 100
    //   155: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 127
    //   164: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +29 -> 202
    //   176: aload 6
    //   178: new 71	java/io/File
    //   181: dup
    //   182: aload 4
    //   184: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 612	java/io/File:renameTo	(Ljava/io/File;)Z
    //   190: pop
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: ldc 127
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
  public static void writeServerConfig(String paramString1, int paramInt, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 425	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;I)Ljava/io/File;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnonnull +14 -> 21
    //   10: new 291	java/io/IOException
    //   13: dup
    //   14: ldc_w 626
    //   17: invokespecial 627	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_3
    //   22: invokevirtual 75	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_3
    //   29: invokevirtual 109	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 75	java/io/File:exists	()Z
    //   37: ifeq +10 -> 47
    //   40: aload_3
    //   41: invokevirtual 630	java/io/File:canWrite	()Z
    //   44: ifne +34 -> 78
    //   47: new 291	java/io/IOException
    //   50: dup
    //   51: new 87	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 632
    //   61: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_3
    //   65: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 627	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: aconst_null
    //   79: astore_0
    //   80: new 634	java/io/OutputStreamWriter
    //   83: dup
    //   84: new 586	java/io/FileOutputStream
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 635	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   92: ldc_w 431
    //   95: invokespecial 637	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   98: astore_3
    //   99: aload_3
    //   100: astore_0
    //   101: aload_3
    //   102: aload_2
    //   103: invokevirtual 640	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   106: aload_3
    //   107: astore_0
    //   108: aload_3
    //   109: invokevirtual 643	java/io/OutputStreamWriter:flush	()V
    //   112: aload_3
    //   113: ifnull +7 -> 120
    //   116: aload_3
    //   117: invokevirtual 644	java/io/OutputStreamWriter:close	()V
    //   120: return
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 225	java/lang/Exception:printStackTrace	()V
    //   132: aload_2
    //   133: ifnull -13 -> 120
    //   136: aload_2
    //   137: invokevirtual 644	java/io/OutputStreamWriter:close	()V
    //   140: return
    //   141: astore_0
    //   142: return
    //   143: astore_3
    //   144: aload_0
    //   145: astore_2
    //   146: aload_3
    //   147: astore_0
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 644	java/io/OutputStreamWriter:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: return
    //   160: astore_2
    //   161: goto -5 -> 156
    //   164: astore_3
    //   165: aload_0
    //   166: astore_2
    //   167: aload_3
    //   168: astore_0
    //   169: goto -21 -> 148
    //   172: astore 4
    //   174: aload_3
    //   175: astore_2
    //   176: goto -51 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString1	String
    //   0	179	1	paramInt	int
    //   0	179	2	paramString2	String
    //   5	112	3	localObject1	Object
    //   143	4	3	localObject2	Object
    //   164	11	3	localObject3	Object
    //   121	7	4	localException1	Exception
    //   172	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   80	99	121	java/lang/Exception
    //   136	140	141	java/io/IOException
    //   80	99	143	finally
    //   116	120	158	java/io/IOException
    //   152	156	160	java/io/IOException
    //   101	106	164	finally
    //   108	112	164	finally
    //   127	132	164	finally
    //   101	106	172	java/lang/Exception
    //   108	112	172	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfSdkUtils
 * JD-Core Version:    0.7.0.1
 */