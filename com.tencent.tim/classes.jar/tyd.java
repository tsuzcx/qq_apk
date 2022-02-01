import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class tyd
{
  public static final String[] ci;
  private static String workDir = "";
  
  static
  {
    ci = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    String str = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (!str.endsWith("/")) {
        localObject = str + "/";
      }
      workDir = aqul.getSDKPrivatePath((String)localObject + "/Tencent/MobileQQ/log/");
      localObject = new File(workDir);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  private static void Y(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(aqhq.readFileContent(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPMDumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  private static String a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    String str1 = workDir + getProcFileName(paramRunningAppProcessInfo.processName) + paramString + ".meminfo";
    try
    {
      if (BaseApplicationImpl.sApplication.checkPermission("android.permission.DUMP", paramRunningAppProcessInfo.pid, paramRunningAppProcessInfo.uid) == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          String str2 = "dumpsys meminfo " + paramRunningAppProcessInfo.processName + " > " + str1;
          Runtime.getRuntime().exec(str2);
          Y(paramRunningAppProcessInfo.processName, str1, paramString);
        }
        return str1;
      }
      return "";
    }
    catch (IOException paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateMemInfo", paramRunningAppProcessInfo);
      }
    }
  }
  
  public static String aR(long paramLong)
  {
    String str1 = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = aqmu.getFormatTime(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  public static List<String> cD()
  {
    ArrayList localArrayList = new ArrayList(10);
    String str1 = aqmu.getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).processName.startsWith("com.tencent.tim"))
      {
        String str2 = generateDetailMemory((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
        localObject = a((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<String> cE()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(aR(l));
    localArrayList.add(aR(l - 3600000L));
    localArrayList.add(acbn.bma + "log.txt");
    return localArrayList;
  }
  
  private static String generateDetailMemory(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    try
    {
      String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
      ArrayList localArrayList1 = new ArrayList(12);
      ArrayList localArrayList2 = new ArrayList(12);
      int i = 0;
      while (i < 12)
      {
        tyd.a locala = new tyd.a();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(locala);
        localArrayList2.add(localHashMap);
        i += 1;
      }
      i = readMapinfo(str, localArrayList1, localArrayList2);
      if (i > 0) {
        return writeMapinfoToLog(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
      }
      return "";
    }
    catch (Throwable paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateDetailMemory", paramRunningAppProcessInfo);
      }
    }
    return null;
  }
  
  /* Error */
  public static String generateThreadTrace()
  {
    // Byte code:
    //   0: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   3: ldc_w 259
    //   6: invokestatic 233	aqmu:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 71	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 17	tyd:workDir	Ljava/lang/String;
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 341
    //   26: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 343
    //   36: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 349	java/lang/Thread:activeCount	()I
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +8 -> 57
    //   52: ldc 15
    //   54: astore_3
    //   55: aload_3
    //   56: areturn
    //   57: new 351	java/io/BufferedWriter
    //   60: dup
    //   61: new 353	java/io/FileWriter
    //   64: dup
    //   65: aload 6
    //   67: iconst_0
    //   68: invokespecial 356	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   71: invokespecial 359	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: iload_2
    //   80: anewarray 345	java/lang/Thread
    //   83: astore 5
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokestatic 363	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: new 71	java/lang/StringBuilder
    //   100: dup
    //   101: iload_2
    //   102: sipush 1024
    //   105: imul
    //   106: invokespecial 364	java/lang/StringBuilder:<init>	(I)V
    //   109: astore 7
    //   111: iconst_0
    //   112: istore_0
    //   113: goto +306 -> 419
    //   116: aload 4
    //   118: astore_3
    //   119: aload 8
    //   121: invokevirtual 367	java/lang/Thread:isAlive	()Z
    //   124: ifeq +115 -> 239
    //   127: aload 4
    //   129: astore_3
    //   130: aload 7
    //   132: ldc_w 369
    //   135: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_3
    //   142: aload 7
    //   144: aload 8
    //   146: invokevirtual 372	java/lang/Thread:getName	()Ljava/lang/String;
    //   149: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 4
    //   155: astore_3
    //   156: aload 7
    //   158: ldc_w 374
    //   161: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: astore_3
    //   168: aload 8
    //   170: invokevirtual 378	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +62 -> 239
    //   180: iconst_0
    //   181: istore_1
    //   182: aload 4
    //   184: astore_3
    //   185: iload_1
    //   186: aload 8
    //   188: arraylength
    //   189: if_icmpge +50 -> 239
    //   192: aload 4
    //   194: astore_3
    //   195: aload 7
    //   197: ldc_w 380
    //   200: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: astore_3
    //   207: aload 7
    //   209: aload 8
    //   211: iload_1
    //   212: aaload
    //   213: invokevirtual 383	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   216: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: astore_3
    //   223: aload 7
    //   225: ldc_w 374
    //   228: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: goto -54 -> 182
    //   239: aload 4
    //   241: astore_3
    //   242: aload 7
    //   244: ldc_w 374
    //   247: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_3
    //   254: aload 4
    //   256: aload 7
    //   258: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 386	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: astore_3
    //   267: aload 4
    //   269: invokevirtual 389	java/io/BufferedWriter:flush	()V
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: iconst_0
    //   278: invokevirtual 392	java/lang/StringBuilder:setLength	(I)V
    //   281: goto +154 -> 435
    //   284: astore 5
    //   286: aload 4
    //   288: astore_3
    //   289: aload 5
    //   291: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   294: aload 6
    //   296: astore_3
    //   297: aload 4
    //   299: ifnull -244 -> 55
    //   302: aload 4
    //   304: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   307: aload 6
    //   309: areturn
    //   310: astore_3
    //   311: aload 6
    //   313: areturn
    //   314: aload 6
    //   316: astore_3
    //   317: aload 4
    //   319: ifnull -264 -> 55
    //   322: aload 4
    //   324: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   327: aload 6
    //   329: areturn
    //   330: astore_3
    //   331: aload 6
    //   333: areturn
    //   334: astore 5
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: astore_3
    //   342: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +17 -> 362
    //   348: aload 4
    //   350: astore_3
    //   351: ldc 134
    //   353: iconst_2
    //   354: ldc_w 400
    //   357: aload 5
    //   359: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 6
    //   364: astore_3
    //   365: aload 4
    //   367: ifnull -312 -> 55
    //   370: aload 4
    //   372: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   375: aload 6
    //   377: areturn
    //   378: astore_3
    //   379: aload 6
    //   381: areturn
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +7 -> 394
    //   390: aload_3
    //   391: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   394: aload 4
    //   396: athrow
    //   397: astore_3
    //   398: goto -4 -> 394
    //   401: astore 4
    //   403: goto -17 -> 386
    //   406: astore 5
    //   408: goto -69 -> 339
    //   411: astore 5
    //   413: aconst_null
    //   414: astore 4
    //   416: goto -130 -> 286
    //   419: iload_0
    //   420: iload_2
    //   421: if_icmpge -107 -> 314
    //   424: aload 5
    //   426: iload_0
    //   427: aaload
    //   428: astore 8
    //   430: aload 8
    //   432: ifnonnull -316 -> 116
    //   435: iload_0
    //   436: iconst_1
    //   437: iadd
    //   438: istore_0
    //   439: goto -20 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   112	327	0	i	int
    //   181	55	1	j	int
    //   47	375	2	k	int
    //   9	288	3	localObject1	Object
    //   310	1	3	localIOException1	IOException
    //   316	1	3	localObject2	Object
    //   330	1	3	localIOException2	IOException
    //   341	24	3	localObject3	Object
    //   378	1	3	localIOException3	IOException
    //   385	6	3	localObject4	Object
    //   397	1	3	localIOException4	IOException
    //   74	297	4	localBufferedWriter	java.io.BufferedWriter
    //   382	13	4	localObject5	Object
    //   401	1	4	localObject6	Object
    //   414	1	4	localObject7	Object
    //   83	6	5	arrayOfThread	Thread[]
    //   284	6	5	localIOException5	IOException
    //   334	24	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   406	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   411	14	5	localIOException6	IOException
    //   42	338	6	str	String
    //   109	167	7	localStringBuilder	java.lang.StringBuilder
    //   119	312	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   79	85	284	java/io/IOException
    //   88	94	284	java/io/IOException
    //   97	111	284	java/io/IOException
    //   119	127	284	java/io/IOException
    //   130	139	284	java/io/IOException
    //   142	153	284	java/io/IOException
    //   156	165	284	java/io/IOException
    //   168	175	284	java/io/IOException
    //   185	192	284	java/io/IOException
    //   195	204	284	java/io/IOException
    //   207	220	284	java/io/IOException
    //   223	232	284	java/io/IOException
    //   242	251	284	java/io/IOException
    //   254	264	284	java/io/IOException
    //   267	272	284	java/io/IOException
    //   275	281	284	java/io/IOException
    //   302	307	310	java/io/IOException
    //   322	327	330	java/io/IOException
    //   57	76	334	java/lang/OutOfMemoryError
    //   370	375	378	java/io/IOException
    //   57	76	382	finally
    //   390	394	397	java/io/IOException
    //   79	85	401	finally
    //   88	94	401	finally
    //   97	111	401	finally
    //   119	127	401	finally
    //   130	139	401	finally
    //   142	153	401	finally
    //   156	165	401	finally
    //   168	175	401	finally
    //   185	192	401	finally
    //   195	204	401	finally
    //   207	220	401	finally
    //   223	232	401	finally
    //   242	251	401	finally
    //   254	264	401	finally
    //   267	272	401	finally
    //   275	281	401	finally
    //   289	294	401	finally
    //   342	348	401	finally
    //   351	362	401	finally
    //   79	85	406	java/lang/OutOfMemoryError
    //   88	94	406	java/lang/OutOfMemoryError
    //   97	111	406	java/lang/OutOfMemoryError
    //   119	127	406	java/lang/OutOfMemoryError
    //   130	139	406	java/lang/OutOfMemoryError
    //   142	153	406	java/lang/OutOfMemoryError
    //   156	165	406	java/lang/OutOfMemoryError
    //   168	175	406	java/lang/OutOfMemoryError
    //   185	192	406	java/lang/OutOfMemoryError
    //   195	204	406	java/lang/OutOfMemoryError
    //   207	220	406	java/lang/OutOfMemoryError
    //   223	232	406	java/lang/OutOfMemoryError
    //   242	251	406	java/lang/OutOfMemoryError
    //   254	264	406	java/lang/OutOfMemoryError
    //   267	272	406	java/lang/OutOfMemoryError
    //   275	281	406	java/lang/OutOfMemoryError
    //   57	76	411	java/io/IOException
  }
  
  public static String generateTraces()
  {
    String str1 = aqmu.getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int i = 0;
    for (int j = 0;; j = k)
    {
      if ((i >= 3) || (j != 0)) {
        break label139;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        k = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateTraces", localIOException);
            k = j;
          }
        }
      }
      i += 1;
    }
    label139:
    if (j != 0)
    {
      i = 0;
      boolean bool = false;
      for (;;)
      {
        if ((i < 3) && (!bool))
        {
          String str2 = aqhq.readFileContent(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = aqhq.z(workDir, str1, str2);
          }
          if (!bool) {}
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "InterruptedException", localInterruptedException);
              }
            }
          }
        }
      }
    }
    return workDir + str1;
  }
  
  private static String getProcFileName(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String[] arrayOfString;
    String str;
    do
    {
      return paramString;
      arrayOfString = paramString.split(":");
      paramString = arrayOfString[0].split("\\.");
      str = paramString[(paramString.length - 1)];
      paramString = str;
    } while (arrayOfString.length <= 1);
    return str + "_" + arrayOfString[1];
  }
  
  private static Map.Entry[] getSortedHashtableByValue(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new tye());
    return paramMap;
  }
  
  /* Error */
  public static String r(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 15
    //   2: astore 4
    //   4: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 134
    //   12: iconst_2
    //   13: new 71	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 473
    //   23: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   39: ldc_w 259
    //   42: invokestatic 233	aqmu:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   45: astore 5
    //   47: ldc_w 477
    //   50: invokestatic 480	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   53: invokevirtual 483	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +735 -> 791
    //   59: new 53	java/io/File
    //   62: dup
    //   63: new 71	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   70: invokestatic 51	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   73: invokevirtual 57	java/io/File:getPath	()Ljava/lang/String;
    //   76: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 83
    //   81: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 89	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 96	java/io/File:exists	()Z
    //   98: ifne +8 -> 106
    //   101: aload_3
    //   102: invokevirtual 102	java/io/File:mkdirs	()Z
    //   105: pop
    //   106: aload_3
    //   107: invokevirtual 486	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: astore 4
    //   112: aload 4
    //   114: astore_3
    //   115: aload 4
    //   117: ldc 65
    //   119: invokevirtual 69	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   122: ifne +24 -> 146
    //   125: new 71	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   132: aload 4
    //   134: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 65
    //   139: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_3
    //   146: new 71	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   153: aload_3
    //   154: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 488
    //   160: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 243
    //   169: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 490
    //   180: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 5
    //   188: new 492	java/io/FileOutputStream
    //   191: dup
    //   192: aload 5
    //   194: invokespecial 493	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   197: astore_3
    //   198: aload_3
    //   199: astore_0
    //   200: new 71	java/lang/StringBuilder
    //   203: dup
    //   204: sipush 1024
    //   207: invokespecial 364	java/lang/StringBuilder:<init>	(I)V
    //   210: astore 6
    //   212: aload_3
    //   213: astore_0
    //   214: aload 6
    //   216: ldc_w 495
    //   219: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_3
    //   224: astore_0
    //   225: aload 6
    //   227: invokestatic 501	com/tencent/mobileqq/app/BaseActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   230: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_3
    //   235: astore_0
    //   236: aload 6
    //   238: ldc_w 506
    //   241: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_3
    //   246: astore_0
    //   247: aload 6
    //   249: ldc_w 508
    //   252: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_3
    //   257: astore_0
    //   258: getstatic 512	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   261: ifnull +533 -> 794
    //   264: aload_3
    //   265: astore_0
    //   266: getstatic 512	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   269: invokevirtual 515	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   272: astore 4
    //   274: aload_3
    //   275: astore_0
    //   276: aload 6
    //   278: aload 4
    //   280: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_3
    //   285: astore_0
    //   286: aload 6
    //   288: ldc_w 506
    //   291: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_3
    //   296: astore_0
    //   297: aload 6
    //   299: ldc_w 517
    //   302: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: astore_0
    //   308: aload 6
    //   310: getstatic 522	android/os/Build:MODEL	Ljava/lang/String;
    //   313: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_3
    //   318: astore_0
    //   319: aload 6
    //   321: ldc_w 506
    //   324: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_3
    //   329: astore_0
    //   330: aload 6
    //   332: ldc_w 524
    //   335: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_3
    //   340: astore_0
    //   341: aload 6
    //   343: getstatic 529	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   346: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_3
    //   351: astore_0
    //   352: aload 6
    //   354: ldc_w 506
    //   357: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_3
    //   362: astore_0
    //   363: aload 6
    //   365: ldc_w 531
    //   368: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_3
    //   373: astore_0
    //   374: aload 6
    //   376: bipush 100
    //   378: invokestatic 536	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   381: invokevirtual 539	com/tencent/mfsdk/MagnifierSDK:a	()Ltxm;
    //   384: getfield 544	txm:bDb	I
    //   387: isub
    //   388: i2l
    //   389: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   392: invokevirtual 547	java/lang/Runtime:maxMemory	()J
    //   395: lmul
    //   396: ldc2_w 548
    //   399: ldiv
    //   400: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_3
    //   405: astore_0
    //   406: aload 6
    //   408: ldc_w 506
    //   411: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_3
    //   416: astore_0
    //   417: aload 6
    //   419: ldc_w 554
    //   422: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_3
    //   427: astore_0
    //   428: aload 6
    //   430: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   433: invokevirtual 557	java/lang/Runtime:totalMemory	()J
    //   436: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   439: invokevirtual 560	java/lang/Runtime:freeMemory	()J
    //   442: lsub
    //   443: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload_3
    //   448: astore_0
    //   449: aload 6
    //   451: ldc_w 506
    //   454: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_3
    //   459: astore_0
    //   460: aload 6
    //   462: ldc_w 562
    //   465: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_3
    //   470: astore_0
    //   471: aload 6
    //   473: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   476: invokevirtual 557	java/lang/Runtime:totalMemory	()J
    //   479: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_3
    //   484: astore_0
    //   485: aload 6
    //   487: ldc_w 506
    //   490: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: astore_0
    //   496: aload 6
    //   498: ldc_w 564
    //   501: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_3
    //   506: astore_0
    //   507: aload 6
    //   509: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   512: invokevirtual 560	java/lang/Runtime:freeMemory	()J
    //   515: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: astore_0
    //   521: aload 6
    //   523: ldc_w 506
    //   526: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_3
    //   531: astore_0
    //   532: aload 6
    //   534: ldc_w 566
    //   537: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_3
    //   542: astore_0
    //   543: aload 6
    //   545: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   548: invokevirtual 547	java/lang/Runtime:maxMemory	()J
    //   551: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_3
    //   556: astore_0
    //   557: aload 6
    //   559: ldc_w 506
    //   562: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_3
    //   567: astore_0
    //   568: aload 6
    //   570: ldc_w 568
    //   573: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_3
    //   578: astore_0
    //   579: aload 6
    //   581: getstatic 572	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   584: invokevirtual 575	android/support/v4/util/MQLruCache:size	()I
    //   587: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_3
    //   592: astore_0
    //   593: aload 6
    //   595: ldc_w 506
    //   598: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_3
    //   603: astore_0
    //   604: aload 6
    //   606: ldc_w 577
    //   609: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_3
    //   614: astore_0
    //   615: aload 6
    //   617: getstatic 583	tyf:aQG	Z
    //   620: invokevirtual 586	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload_3
    //   625: astore_0
    //   626: aload 6
    //   628: ldc_w 506
    //   631: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload_3
    //   636: astore_0
    //   637: aload 6
    //   639: ldc_w 588
    //   642: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload_3
    //   647: astore_0
    //   648: aload 6
    //   650: invokestatic 593	sxa:a	()Lsxa;
    //   653: getfield 596	sxa:bzS	I
    //   656: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload_3
    //   661: astore_0
    //   662: aload 6
    //   664: ldc_w 506
    //   667: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_3
    //   672: astore_0
    //   673: aload 6
    //   675: ldc_w 598
    //   678: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload_3
    //   683: astore_0
    //   684: aload 6
    //   686: invokestatic 603	aciz:rH	()Ljava/lang/String;
    //   689: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_3
    //   694: astore_0
    //   695: aload 6
    //   697: ldc_w 506
    //   700: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload_3
    //   705: astore_0
    //   706: aload 6
    //   708: ldc_w 605
    //   711: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_3
    //   716: astore_0
    //   717: aload 6
    //   719: lload_1
    //   720: invokevirtual 552	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_3
    //   725: astore_0
    //   726: aload_3
    //   727: aload 6
    //   729: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokevirtual 609	java/lang/String:getBytes	()[B
    //   735: invokevirtual 612	java/io/FileOutputStream:write	([B)V
    //   738: aload_3
    //   739: astore_0
    //   740: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   743: ifeq +32 -> 775
    //   746: aload_3
    //   747: astore_0
    //   748: ldc 134
    //   750: iconst_2
    //   751: new 71	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 614
    //   761: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 5
    //   766: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 475	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 5
    //   777: astore 4
    //   779: aload_3
    //   780: ifnull +11 -> 791
    //   783: aload_3
    //   784: invokevirtual 615	java/io/FileOutputStream:close	()V
    //   787: aload 5
    //   789: astore 4
    //   791: aload 4
    //   793: areturn
    //   794: ldc_w 617
    //   797: astore 4
    //   799: goto -525 -> 274
    //   802: astore_0
    //   803: aload_0
    //   804: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   807: aload 5
    //   809: areturn
    //   810: astore 4
    //   812: aconst_null
    //   813: astore_3
    //   814: aload_3
    //   815: astore_0
    //   816: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   819: ifeq +16 -> 835
    //   822: aload_3
    //   823: astore_0
    //   824: ldc 134
    //   826: iconst_2
    //   827: ldc_w 619
    //   830: aload 4
    //   832: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   835: aload 5
    //   837: astore 4
    //   839: aload_3
    //   840: ifnull -49 -> 791
    //   843: aload_3
    //   844: invokevirtual 615	java/io/FileOutputStream:close	()V
    //   847: aload 5
    //   849: areturn
    //   850: astore_0
    //   851: aload_0
    //   852: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   855: aload 5
    //   857: areturn
    //   858: astore_3
    //   859: aconst_null
    //   860: astore_0
    //   861: aload_0
    //   862: ifnull +7 -> 869
    //   865: aload_0
    //   866: invokevirtual 615	java/io/FileOutputStream:close	()V
    //   869: aload_3
    //   870: athrow
    //   871: astore_0
    //   872: aload_0
    //   873: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   876: goto -7 -> 869
    //   879: astore_3
    //   880: goto -19 -> 861
    //   883: astore 4
    //   885: goto -71 -> 814
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	888	0	paramString	String
    //   0	888	1	paramLong	long
    //   93	751	3	localObject1	Object
    //   858	12	3	localObject2	Object
    //   879	1	3	localObject3	Object
    //   2	796	4	localObject4	Object
    //   810	21	4	localIOException1	IOException
    //   837	1	4	localObject5	Object
    //   883	1	4	localIOException2	IOException
    //   45	811	5	str	String
    //   210	518	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   783	787	802	java/io/IOException
    //   188	198	810	java/io/IOException
    //   843	847	850	java/io/IOException
    //   188	198	858	finally
    //   865	869	871	java/io/IOException
    //   200	212	879	finally
    //   214	223	879	finally
    //   225	234	879	finally
    //   236	245	879	finally
    //   247	256	879	finally
    //   258	264	879	finally
    //   266	274	879	finally
    //   276	284	879	finally
    //   286	295	879	finally
    //   297	306	879	finally
    //   308	317	879	finally
    //   319	328	879	finally
    //   330	339	879	finally
    //   341	350	879	finally
    //   352	361	879	finally
    //   363	372	879	finally
    //   374	404	879	finally
    //   406	415	879	finally
    //   417	426	879	finally
    //   428	447	879	finally
    //   449	458	879	finally
    //   460	469	879	finally
    //   471	483	879	finally
    //   485	494	879	finally
    //   496	505	879	finally
    //   507	519	879	finally
    //   521	530	879	finally
    //   532	541	879	finally
    //   543	555	879	finally
    //   557	566	879	finally
    //   568	577	879	finally
    //   579	591	879	finally
    //   593	602	879	finally
    //   604	613	879	finally
    //   615	624	879	finally
    //   626	635	879	finally
    //   637	646	879	finally
    //   648	660	879	finally
    //   662	671	879	finally
    //   673	682	879	finally
    //   684	693	879	finally
    //   695	704	879	finally
    //   706	715	879	finally
    //   717	724	879	finally
    //   726	738	879	finally
    //   740	746	879	finally
    //   748	775	879	finally
    //   816	822	879	finally
    //   824	835	879	finally
    //   200	212	883	java/io/IOException
    //   214	223	883	java/io/IOException
    //   225	234	883	java/io/IOException
    //   236	245	883	java/io/IOException
    //   247	256	883	java/io/IOException
    //   258	264	883	java/io/IOException
    //   266	274	883	java/io/IOException
    //   276	284	883	java/io/IOException
    //   286	295	883	java/io/IOException
    //   297	306	883	java/io/IOException
    //   308	317	883	java/io/IOException
    //   319	328	883	java/io/IOException
    //   330	339	883	java/io/IOException
    //   341	350	883	java/io/IOException
    //   352	361	883	java/io/IOException
    //   363	372	883	java/io/IOException
    //   374	404	883	java/io/IOException
    //   406	415	883	java/io/IOException
    //   417	426	883	java/io/IOException
    //   428	447	883	java/io/IOException
    //   449	458	883	java/io/IOException
    //   460	469	883	java/io/IOException
    //   471	483	883	java/io/IOException
    //   485	494	883	java/io/IOException
    //   496	505	883	java/io/IOException
    //   507	519	883	java/io/IOException
    //   521	530	883	java/io/IOException
    //   532	541	883	java/io/IOException
    //   543	555	883	java/io/IOException
    //   557	566	883	java/io/IOException
    //   568	577	883	java/io/IOException
    //   579	591	883	java/io/IOException
    //   593	602	883	java/io/IOException
    //   604	613	883	java/io/IOException
    //   615	624	883	java/io/IOException
    //   626	635	883	java/io/IOException
    //   637	646	883	java/io/IOException
    //   648	660	883	java/io/IOException
    //   662	671	883	java/io/IOException
    //   673	682	883	java/io/IOException
    //   684	693	883	java/io/IOException
    //   695	704	883	java/io/IOException
    //   706	715	883	java/io/IOException
    //   717	724	883	java/io/IOException
    //   726	738	883	java/io/IOException
    //   740	746	883	java/io/IOException
    //   748	775	883	java/io/IOException
  }
  
  public static int readMapinfo(String paramString, List<tyd.a> paramList, List<Map<String, Integer>> paramList1)
    throws IOException
  {
    int i2 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    long l1 = 0L;
    String str = "";
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      if (new File(paramString).exists()) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          return 0;
        }
        try
        {
          Thread.sleep(500L);
          if (i >= 10)
          {
            i = 0;
            continue;
            BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
            Object localObject2 = localBufferedReader.readLine();
            if (localObject2 == null)
            {
              localBufferedReader.close();
              return 0;
              while (n == 0) {
                if (((String)localObject2).length() < 1)
                {
                  i = 11;
                }
                else
                {
                  long l3;
                  label241:
                  int i3;
                  if ((((String)localObject2).length() > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
                  {
                    paramString = ((String)localObject2).split(" ");
                    localObject2 = paramString[0].split("-");
                    l3 = Long.parseLong(localObject2[0], 16);
                    long l2 = Long.parseLong(localObject2[1], 16);
                    i1 = 5;
                    while ((i1 < paramString.length) && (paramString[i1].equals(""))) {
                      i1 += 1;
                    }
                    if (i1 < paramString.length)
                    {
                      paramString = paramString[i1];
                      i1 = paramString.length();
                      if (!paramString.equals("[heap]")) {
                        break label452;
                      }
                      i = 0;
                      label259:
                      l1 = l2;
                      i1 = i;
                      i3 = 0;
                      i = m;
                      label272:
                      localObject2 = localBufferedReader.readLine();
                      if (localObject2 != null) {
                        break label636;
                      }
                      m = 1;
                      label287:
                      if (i3 != 0) {
                        break label1025;
                      }
                      localObject1 = (Map)paramList1.get(i1);
                      if (!((Map)localObject1).containsKey(paramString)) {
                        break label987;
                      }
                      ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + i));
                    }
                  }
                  for (;;)
                  {
                    localObject1 = (tyd.a)paramList.get(i1);
                    ((tyd.a)localObject1).pss += i;
                    localObject1 = (tyd.a)paramList.get(i1);
                    ((tyd.a)localObject1).privateDirty += j;
                    localObject1 = (tyd.a)paramList.get(i1);
                    ((tyd.a)localObject1).sharedDirty += k;
                    i2 += i;
                    localObject1 = paramString;
                    n = m;
                    m = i;
                    i = i1;
                    break;
                    paramString = "";
                    break label241;
                    label452:
                    if (paramString.startsWith("/dev/ashmem/dalvik-"))
                    {
                      i = 1;
                      break label259;
                    }
                    if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                    {
                      i = 2;
                      break label259;
                    }
                    if (paramString.startsWith("/dev/ashmem/"))
                    {
                      i = 3;
                      break label259;
                    }
                    if (paramString.startsWith("/dev/"))
                    {
                      i = 4;
                      break label259;
                    }
                    if (paramString.endsWith(".so"))
                    {
                      i = 5;
                      break label259;
                    }
                    if (paramString.endsWith(".jar"))
                    {
                      i = 6;
                      break label259;
                    }
                    if (paramString.endsWith(".apk"))
                    {
                      i = 7;
                      break label259;
                    }
                    if (paramString.endsWith(".ttf"))
                    {
                      i = 8;
                      break label259;
                    }
                    if (paramString.endsWith(".dex"))
                    {
                      i = 9;
                      break label259;
                    }
                    if (i1 > 0)
                    {
                      i = 10;
                      break label259;
                    }
                    if ((l3 != l1) || (i != 5)) {
                      break label1055;
                    }
                    i = 5;
                    paramString = (String)localObject1;
                    break label259;
                    i3 = 1;
                    i1 = 11;
                    i = m;
                    break label272;
                    label636:
                    String[] arrayOfString = ((String)localObject2).split(" ");
                    str = arrayOfString[0];
                    i4 = 0;
                    m = 1;
                    try
                    {
                      while ((m < arrayOfString.length) && (arrayOfString[m].equals(""))) {
                        m += 1;
                      }
                      if (m >= arrayOfString.length) {
                        break label747;
                      }
                      m = Integer.parseInt(arrayOfString[m]);
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        label705:
                        m = i4;
                      }
                    }
                    if (str.equals("Size:"))
                    {
                      m = j;
                      j = k;
                      k = i;
                      i = m;
                    }
                    for (;;)
                    {
                      m = k;
                      k = j;
                      j = i;
                      i = m;
                      break;
                      label747:
                      m = 0;
                      break label705;
                      if (str.equals("Rss:"))
                      {
                        m = i;
                        i = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Pss:"))
                      {
                        i = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Shared_Clean:"))
                      {
                        m = i;
                        i = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Shared_Dirty:"))
                      {
                        k = i;
                        i = j;
                        j = m;
                      }
                      else if (str.equals("Private_Clean:"))
                      {
                        m = i;
                        i = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Private_Dirty:"))
                      {
                        j = k;
                        k = i;
                        i = m;
                      }
                      else
                      {
                        if (!str.equals("Referenced:")) {
                          break label938;
                        }
                        m = i;
                        i = j;
                        j = k;
                        k = m;
                      }
                    }
                    label938:
                    if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
                      break label1038;
                    }
                    System.out.println((String)localObject2);
                    m = n;
                    break label287;
                    label987:
                    ((Map)localObject1).put(paramString, Integer.valueOf(i));
                  }
                }
              }
              localBufferedReader.close();
              return i2;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            int i1;
            int i4;
            continue;
            label1025:
            n = m;
            m = i;
            i = i1;
            continue;
            label1038:
            m = i;
            i = j;
            j = k;
            k = m;
            continue;
            label1055:
            i = 11;
            continue;
            i = 11;
            paramString = str;
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static String writeMapinfoToLog(String paramString1, List<tyd.a> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 109	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 110	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 71	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   18: ldc 112
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 114
    //   29: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload 4
    //   34: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 735
    //   40: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   49: pop
    //   50: aload 6
    //   52: ldc_w 737
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: iload_3
    //   62: invokestatic 671	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: invokestatic 741	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: iconst_0
    //   74: istore_3
    //   75: iload_3
    //   76: aload_1
    //   77: invokeinterface 742 1 0
    //   82: if_icmpge +148 -> 230
    //   85: aload 6
    //   87: ldc_w 744
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: getstatic 45	tyd:ci	[Ljava/lang/String;
    //   99: iload_3
    //   100: aaload
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: aload_1
    //   105: iload_3
    //   106: invokeinterface 656 2 0
    //   111: checkcast 6	tyd$a
    //   114: getfield 679	tyd$a:pss	J
    //   117: invokestatic 747	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 741	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   127: pop
    //   128: aload_2
    //   129: iload_3
    //   130: invokeinterface 656 2 0
    //   135: checkcast 443	java/util/Map
    //   138: invokeinterface 748 1 0
    //   143: ifle +80 -> 223
    //   146: aload_2
    //   147: iload_3
    //   148: invokeinterface 656 2 0
    //   153: checkcast 443	java/util/Map
    //   156: invokestatic 750	tyd:getSortedHashtableByValue	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   159: astore 7
    //   161: iconst_0
    //   162: istore 5
    //   164: iload 5
    //   166: aload 7
    //   168: arraylength
    //   169: if_icmpge +54 -> 223
    //   172: aload 6
    //   174: ldc_w 752
    //   177: iconst_2
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload 7
    //   185: iload 5
    //   187: aaload
    //   188: invokeinterface 755 1 0
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: aload 7
    //   198: iload 5
    //   200: aaload
    //   201: invokeinterface 758 1 0
    //   206: aastore
    //   207: invokestatic 741	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   213: pop
    //   214: iload 5
    //   216: iconst_1
    //   217: iadd
    //   218: istore 5
    //   220: goto -56 -> 164
    //   223: iload_3
    //   224: iconst_1
    //   225: iadd
    //   226: istore_3
    //   227: goto -152 -> 75
    //   230: aload 6
    //   232: new 71	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   239: ldc 112
    //   241: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 760
    //   251: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 119	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   260: pop
    //   261: aload 6
    //   263: invokevirtual 135	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   266: astore_2
    //   267: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +10 -> 280
    //   273: ldc 134
    //   275: iconst_2
    //   276: aload_2
    //   277: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: new 71	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   287: getstatic 17	tyd:workDir	Ljava/lang/String;
    //   290: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 488
    //   296: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: invokestatic 149	tyd:getProcFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc 243
    //   308: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 4
    //   313: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 762
    //   319: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: astore 4
    //   327: new 353	java/io/FileWriter
    //   330: dup
    //   331: aload 4
    //   333: invokespecial 763	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   336: astore_0
    //   337: new 351	java/io/BufferedWriter
    //   340: dup
    //   341: aload_0
    //   342: invokespecial 359	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   345: astore_1
    //   346: aload_1
    //   347: aload_2
    //   348: invokevirtual 386	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   351: aload_1
    //   352: ifnull +7 -> 359
    //   355: aload_1
    //   356: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   359: aload_0
    //   360: ifnull +7 -> 367
    //   363: aload_0
    //   364: invokevirtual 764	java/io/FileWriter:close	()V
    //   367: aload 4
    //   369: areturn
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_2
    //   373: aconst_null
    //   374: astore_1
    //   375: aload_1
    //   376: ifnull +7 -> 383
    //   379: aload_1
    //   380: invokevirtual 398	java/io/BufferedWriter:close	()V
    //   383: aload_2
    //   384: ifnull +7 -> 391
    //   387: aload_2
    //   388: invokevirtual 764	java/io/FileWriter:close	()V
    //   391: aload_0
    //   392: athrow
    //   393: astore 4
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_0
    //   398: astore_2
    //   399: aload 4
    //   401: astore_0
    //   402: goto -27 -> 375
    //   405: astore 4
    //   407: aload_0
    //   408: astore_2
    //   409: aload 4
    //   411: astore_0
    //   412: goto -37 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	paramString1	String
    //   0	415	1	paramList	List<tyd.a>
    //   0	415	2	paramList1	List<Map<String, Integer>>
    //   0	415	3	paramInt	int
    //   0	415	4	paramString2	String
    //   162	57	5	i	int
    //   7	255	6	localStringBuffer	StringBuffer
    //   159	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   327	337	370	finally
    //   337	346	393	finally
    //   346	351	405	finally
  }
  
  public static class a
  {
    long privateDirty;
    long pss;
    long sharedDirty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyd
 * JD-Core Version:    0.7.0.1
 */