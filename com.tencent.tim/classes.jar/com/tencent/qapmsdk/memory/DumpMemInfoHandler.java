package com.tencent.qapmsdk.memory;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DumpMemInfoHandler
{
  private static final int APK_MMAP = 7;
  private static final int ASHMEM = 3;
  private static final int COUNT = 12;
  private static final int CURSOR = 2;
  private static final int DALVIK = 1;
  private static final int DEX_MMAP = 9;
  private static final String[] HEAP_NAME;
  private static final int JAR_MMAP = 6;
  private static final String LOG_PATH = FileUtil.getRootPath() + "/Log/";
  private static final int NATIVE = 0;
  private static final int OTHER_DEV = 4;
  private static final int OTHER_MMAP = 10;
  private static final int SO_MMAP = 5;
  private static final String TAG = "QAPM_memory_DumpMemInfoHandler";
  private static final int TTF_MMAP = 8;
  private static final int UNKNOWN = 11;
  
  static
  {
    HEAP_NAME = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    File localFile = new File(LOG_PATH);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
  }
  
  public static String generateDetailMemory(@NonNull ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    Object localObject = null;
    String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
    ArrayList localArrayList1 = new ArrayList(12);
    ArrayList localArrayList2 = new ArrayList(12);
    int i = 0;
    while (i < 12)
    {
      StatFields localStatFields = new StatFields(null);
      HashMap localHashMap = new HashMap();
      localArrayList1.add(localStatFields);
      localArrayList2.add(localHashMap);
      i += 1;
    }
    i = readMapinfo(str, localArrayList1, localArrayList2);
    if (i > 0) {
      paramRunningAppProcessInfo = writeMapinfoToLog(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
    }
    do
    {
      return paramRunningAppProcessInfo;
      paramRunningAppProcessInfo = localObject;
    } while (i < 0);
    return "";
  }
  
  public static Object[] generateHprof(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    Object localObject = "";
    for (;;)
    {
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "ReportLog dumpHprof: ", paramString });
        String str2 = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
        if (!"mounted".equals(Environment.getExternalStorageState())) {
          break label293;
        }
        localObject = new File(LOG_PATH);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        String str1 = ((File)localObject).getAbsolutePath();
        localObject = str1;
        if (!str1.endsWith("/")) {
          localObject = str1 + "/";
        }
        localObject = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";
        try
        {
          long l = System.currentTimeMillis();
          if ((getSDCardAvailableSize() * 1024L > Runtime.getRuntime().totalMemory()) && ("mounted".equals(Environment.getExternalStorageState())))
          {
            Debug.dumpHprofData((String)localObject);
            Logger.INSTANCE.d(new String[] { "QAPM_memory_DumpMemInfoHandler", "dump used " + (System.currentTimeMillis() - l) + " ms" });
            return new Object[] { Boolean.valueOf(bool1), localObject };
          }
        }
        catch (Throwable paramString)
        {
          Logger.INSTANCE.exception("QAPM_memory_DumpMemInfoHandler", paramString);
        }
        bool1 = false;
      }
      finally {}
      continue;
      label293:
      bool1 = bool2;
    }
  }
  
  /* Error */
  @NonNull
  public static String generateThreadTrace()
  {
    // Byte code:
    //   0: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   3: ldc 168
    //   5: invokestatic 172	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getFormatTime	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 45	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 65	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   19: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 240
    //   24: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 242
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 248	java/lang/Thread:activeCount	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +6 -> 52
    //   49: ldc 143
    //   51: areturn
    //   52: iload_2
    //   53: anewarray 244	java/lang/Thread
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 252	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   61: pop
    //   62: new 45	java/lang/StringBuilder
    //   65: dup
    //   66: iload_2
    //   67: sipush 1024
    //   70: imul
    //   71: invokespecial 253	java/lang/StringBuilder:<init>	(I)V
    //   74: astore 5
    //   76: iconst_0
    //   77: istore_0
    //   78: iload_0
    //   79: iload_2
    //   80: if_icmpge +128 -> 208
    //   83: aload_3
    //   84: iload_0
    //   85: aaload
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +10 -> 100
    //   93: iload_0
    //   94: iconst_1
    //   95: iadd
    //   96: istore_0
    //   97: goto -19 -> 78
    //   100: aload 4
    //   102: invokevirtual 256	java/lang/Thread:isAlive	()Z
    //   105: ifeq +91 -> 196
    //   108: aload 5
    //   110: ldc_w 258
    //   113: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 5
    //   119: aload 4
    //   121: invokevirtual 261	java/lang/Thread:getName	()Ljava/lang/String;
    //   124: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc_w 263
    //   133: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: invokevirtual 267	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   142: astore 4
    //   144: aload 4
    //   146: ifnull +50 -> 196
    //   149: iconst_0
    //   150: istore_1
    //   151: iload_1
    //   152: aload 4
    //   154: arraylength
    //   155: if_icmpge +41 -> 196
    //   158: aload 5
    //   160: ldc_w 269
    //   163: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 5
    //   169: aload 4
    //   171: iload_1
    //   172: aaload
    //   173: invokevirtual 272	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   176: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 5
    //   182: ldc_w 263
    //   185: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: goto -42 -> 151
    //   196: aload 5
    //   198: ldc_w 263
    //   201: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: goto -112 -> 93
    //   208: new 274	java/io/FileWriter
    //   211: dup
    //   212: aload 6
    //   214: iconst_0
    //   215: invokespecial 277	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   218: astore 4
    //   220: aload 4
    //   222: astore_3
    //   223: aload 4
    //   225: aload 5
    //   227: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 280	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   233: aload 4
    //   235: astore_3
    //   236: aload 4
    //   238: invokevirtual 283	java/io/FileWriter:close	()V
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 283	java/io/FileWriter:close	()V
    //   251: aload 6
    //   253: areturn
    //   254: astore_3
    //   255: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   258: ldc 37
    //   260: aload_3
    //   261: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -13 -> 251
    //   267: astore 5
    //   269: aconst_null
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   278: ldc 37
    //   280: aload 5
    //   282: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload 4
    //   287: ifnull -36 -> 251
    //   290: aload 4
    //   292: invokevirtual 283	java/io/FileWriter:close	()V
    //   295: goto -44 -> 251
    //   298: astore_3
    //   299: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   302: ldc 37
    //   304: aload_3
    //   305: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: goto -57 -> 251
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_3
    //   315: aload_3
    //   316: ifnull +7 -> 323
    //   319: aload_3
    //   320: invokevirtual 283	java/io/FileWriter:close	()V
    //   323: aload 4
    //   325: athrow
    //   326: astore_3
    //   327: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   330: ldc 37
    //   332: aload_3
    //   333: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: goto -13 -> 323
    //   339: astore 4
    //   341: goto -26 -> 315
    //   344: astore 5
    //   346: goto -74 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	20	0	i	int
    //   150	43	1	j	int
    //   44	37	2	k	int
    //   8	228	3	localObject1	Object
    //   254	7	3	localException1	Exception
    //   274	1	3	localObject2	Object
    //   298	7	3	localException2	Exception
    //   314	6	3	localObject3	Object
    //   326	7	3	localException3	Exception
    //   86	205	4	localObject4	Object
    //   311	13	4	localObject5	Object
    //   339	1	4	localObject6	Object
    //   74	152	5	localStringBuilder	java.lang.StringBuilder
    //   267	14	5	localIOException1	IOException
    //   344	1	5	localIOException2	IOException
    //   39	213	6	str	String
    // Exception table:
    //   from	to	target	type
    //   246	251	254	java/lang/Exception
    //   208	220	267	java/io/IOException
    //   290	295	298	java/lang/Exception
    //   208	220	311	finally
    //   319	323	326	java/lang/Exception
    //   223	233	339	finally
    //   236	241	339	finally
    //   275	285	339	finally
    //   223	233	344	java/io/IOException
    //   236	241	344	java/io/IOException
  }
  
  public static String generateTraces()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((i >= 3) || (j != 0)) {
        break label103;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        j = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_DumpMemInfoHandler", "generateTraces exception: ", localIOException.toString() });
        }
      }
      i += 1;
    }
    label103:
    return "/data/anr/traces.txt";
  }
  
  private static String getFormatTime(long paramLong, @NonNull String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString, Locale.US).format(localDate);
  }
  
  private static String getProcFileName(@Nullable String paramString)
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
  
  public static long getSDCardAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  @NonNull
  private static Map.Entry<?, ?>[] getSortedHashtableByValue(Map<?, ?> paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new DumpMemInfoHandler.1());
    return paramMap;
  }
  
  /* Error */
  private static int readMapinfo(@NonNull String paramString, @NonNull List<StatFields> paramList, @NonNull List<Map<String, java.lang.Integer>> paramList1)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc 143
    //   11: astore 20
    //   13: ldc 143
    //   15: astore 17
    //   17: iconst_0
    //   18: istore_3
    //   19: new 83	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 90	java/io/File:exists	()Z
    //   30: ifeq +13 -> 43
    //   33: iconst_1
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +39 -> 75
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: ireturn
    //   43: ldc2_w 390
    //   46: invokestatic 394	java/lang/Thread:sleep	(J)V
    //   49: iload_3
    //   50: bipush 10
    //   52: if_icmplt +1077 -> 1129
    //   55: iconst_0
    //   56: istore_3
    //   57: goto -22 -> 35
    //   60: astore 18
    //   62: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   65: ldc 37
    //   67: aload 18
    //   69: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: goto -23 -> 49
    //   75: new 396	java/io/BufferedReader
    //   78: dup
    //   79: new 398	java/io/FileReader
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 399	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 402	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore 19
    //   92: aload 19
    //   94: invokevirtual 405	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   97: astore 18
    //   99: bipush 11
    //   101: istore 7
    //   103: lconst_0
    //   104: lstore 11
    //   106: iconst_0
    //   107: istore 4
    //   109: iconst_0
    //   110: istore 6
    //   112: aload 20
    //   114: astore_0
    //   115: goto +1021 -> 1136
    //   118: aload 18
    //   120: invokevirtual 408	java/lang/String:length	()I
    //   123: iconst_1
    //   124: if_icmpge +10 -> 134
    //   127: bipush 11
    //   129: istore 7
    //   131: goto +1005 -> 1136
    //   134: aload 18
    //   136: invokevirtual 408	java/lang/String:length	()I
    //   139: bipush 30
    //   141: if_icmple +1092 -> 1233
    //   144: aload 18
    //   146: bipush 8
    //   148: invokevirtual 412	java/lang/String:charAt	(I)C
    //   151: bipush 45
    //   153: if_icmpne +1080 -> 1233
    //   156: aload 18
    //   158: bipush 17
    //   160: invokevirtual 412	java/lang/String:charAt	(I)C
    //   163: bipush 32
    //   165: if_icmpne +1068 -> 1233
    //   168: aload 18
    //   170: ldc_w 414
    //   173: invokevirtual 337	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   176: astore_0
    //   177: aload_0
    //   178: iconst_0
    //   179: aaload
    //   180: ldc_w 416
    //   183: invokevirtual 337	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   186: astore 18
    //   188: aload 18
    //   190: iconst_0
    //   191: aaload
    //   192: bipush 16
    //   194: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   197: lstore 15
    //   199: aload 18
    //   201: iconst_1
    //   202: aaload
    //   203: bipush 16
    //   205: invokestatic 422	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   208: lstore 13
    //   210: iconst_5
    //   211: istore_3
    //   212: iload_3
    //   213: aload_0
    //   214: arraylength
    //   215: if_icmpge +21 -> 236
    //   218: aload_0
    //   219: iload_3
    //   220: aaload
    //   221: ldc 143
    //   223: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +10 -> 236
    //   229: iload_3
    //   230: iconst_1
    //   231: iadd
    //   232: istore_3
    //   233: goto -21 -> 212
    //   236: iload_3
    //   237: aload_0
    //   238: arraylength
    //   239: if_icmpge +940 -> 1179
    //   242: aload_0
    //   243: iload_3
    //   244: aaload
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 408	java/lang/String:length	()I
    //   250: istore_3
    //   251: aload_0
    //   252: ldc_w 424
    //   255: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +179 -> 437
    //   261: iconst_0
    //   262: istore_3
    //   263: aload_0
    //   264: astore 18
    //   266: goto +894 -> 1160
    //   269: aload 19
    //   271: invokevirtual 405	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   274: astore 18
    //   276: aload 18
    //   278: ifnonnull +325 -> 603
    //   281: iconst_1
    //   282: istore 8
    //   284: iload 10
    //   286: ifne +824 -> 1110
    //   289: aload_2
    //   290: iload 7
    //   292: invokeinterface 428 2 0
    //   297: checkcast 359	java/util/Map
    //   300: astore 17
    //   302: aload 17
    //   304: aload_0
    //   305: invokeinterface 431 2 0
    //   310: ifeq +677 -> 987
    //   313: aload 17
    //   315: aload_0
    //   316: aload 17
    //   318: aload_0
    //   319: invokeinterface 434 2 0
    //   324: checkcast 436	java/lang/Integer
    //   327: invokevirtual 439	java/lang/Integer:intValue	()I
    //   330: iload_3
    //   331: iadd
    //   332: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokeinterface 446 3 0
    //   340: pop
    //   341: aload_1
    //   342: iload 7
    //   344: invokeinterface 428 2 0
    //   349: checkcast 6	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   352: astore 17
    //   354: aload 17
    //   356: aload 17
    //   358: invokestatic 450	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   361: iload_3
    //   362: i2l
    //   363: ladd
    //   364: invokestatic 454	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$102	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;J)J
    //   367: pop2
    //   368: aload_1
    //   369: iload 7
    //   371: invokeinterface 428 2 0
    //   376: checkcast 6	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   379: astore 17
    //   381: aload 17
    //   383: aload 17
    //   385: getfield 458	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   388: iload 5
    //   390: i2l
    //   391: ladd
    //   392: putfield 458	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:privateDirty	J
    //   395: aload_1
    //   396: iload 7
    //   398: invokeinterface 428 2 0
    //   403: checkcast 6	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   406: astore 17
    //   408: aload 17
    //   410: aload 17
    //   412: getfield 461	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   415: iload 4
    //   417: i2l
    //   418: ladd
    //   419: putfield 461	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:sharedDirty	J
    //   422: iload 9
    //   424: iload_3
    //   425: iadd
    //   426: istore 9
    //   428: aload_0
    //   429: astore 17
    //   431: iload_3
    //   432: istore 6
    //   434: goto +702 -> 1136
    //   437: aload_0
    //   438: ldc_w 463
    //   441: invokevirtual 466	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   444: ifeq +11 -> 455
    //   447: iconst_1
    //   448: istore_3
    //   449: aload_0
    //   450: astore 18
    //   452: goto +708 -> 1160
    //   455: aload_0
    //   456: ldc_w 468
    //   459: invokevirtual 466	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   462: ifeq +11 -> 473
    //   465: iconst_2
    //   466: istore_3
    //   467: aload_0
    //   468: astore 18
    //   470: goto +690 -> 1160
    //   473: aload_0
    //   474: ldc_w 470
    //   477: invokevirtual 466	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   480: ifeq +11 -> 491
    //   483: iconst_3
    //   484: istore_3
    //   485: aload_0
    //   486: astore 18
    //   488: goto +672 -> 1160
    //   491: aload_0
    //   492: ldc_w 472
    //   495: invokevirtual 466	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   498: ifeq +11 -> 509
    //   501: iconst_4
    //   502: istore_3
    //   503: aload_0
    //   504: astore 18
    //   506: goto +654 -> 1160
    //   509: aload_0
    //   510: ldc_w 474
    //   513: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   516: ifeq +11 -> 527
    //   519: iconst_5
    //   520: istore_3
    //   521: aload_0
    //   522: astore 18
    //   524: goto +636 -> 1160
    //   527: aload_0
    //   528: ldc_w 476
    //   531: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   534: ifeq +12 -> 546
    //   537: bipush 6
    //   539: istore_3
    //   540: aload_0
    //   541: astore 18
    //   543: goto +617 -> 1160
    //   546: aload_0
    //   547: ldc_w 478
    //   550: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   553: ifeq +12 -> 565
    //   556: bipush 7
    //   558: istore_3
    //   559: aload_0
    //   560: astore 18
    //   562: goto +598 -> 1160
    //   565: aload_0
    //   566: ldc_w 480
    //   569: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   572: ifeq +12 -> 584
    //   575: bipush 8
    //   577: istore_3
    //   578: aload_0
    //   579: astore 18
    //   581: goto +579 -> 1160
    //   584: aload_0
    //   585: ldc_w 482
    //   588: invokevirtual 191	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   591: ifeq +594 -> 1185
    //   594: bipush 9
    //   596: istore_3
    //   597: aload_0
    //   598: astore 18
    //   600: goto +560 -> 1160
    //   603: aload 18
    //   605: ldc_w 414
    //   608: invokevirtual 337	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   611: astore 21
    //   613: aload 21
    //   615: iconst_0
    //   616: aaload
    //   617: astore 20
    //   619: iconst_1
    //   620: istore 6
    //   622: iload 6
    //   624: aload 21
    //   626: arraylength
    //   627: if_icmpge +25 -> 652
    //   630: aload 21
    //   632: iload 6
    //   634: aaload
    //   635: ldc 143
    //   637: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +12 -> 652
    //   643: iload 6
    //   645: iconst_1
    //   646: iadd
    //   647: istore 6
    //   649: goto -27 -> 622
    //   652: iload 6
    //   654: aload 21
    //   656: arraylength
    //   657: if_icmpge +602 -> 1259
    //   660: aload 21
    //   662: iload 6
    //   664: aaload
    //   665: invokestatic 486	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   668: istore 6
    //   670: aload 20
    //   672: ldc_w 488
    //   675: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   678: ifeq +53 -> 731
    //   681: iload_3
    //   682: istore 6
    //   684: iload 5
    //   686: istore_3
    //   687: iload 6
    //   689: istore 5
    //   691: goto +555 -> 1246
    //   694: astore 21
    //   696: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   699: iconst_3
    //   700: anewarray 67	java/lang/String
    //   703: dup
    //   704: iconst_0
    //   705: ldc 37
    //   707: aastore
    //   708: dup
    //   709: iconst_1
    //   710: ldc_w 490
    //   713: aastore
    //   714: dup
    //   715: iconst_2
    //   716: aload 21
    //   718: invokevirtual 493	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   721: aastore
    //   722: invokevirtual 496	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   725: iconst_0
    //   726: istore 6
    //   728: goto -58 -> 670
    //   731: aload 20
    //   733: ldc_w 498
    //   736: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   739: ifeq +16 -> 755
    //   742: iload_3
    //   743: istore 6
    //   745: iload 5
    //   747: istore_3
    //   748: iload 6
    //   750: istore 5
    //   752: goto +494 -> 1246
    //   755: aload 20
    //   757: ldc_w 500
    //   760: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   763: ifeq +13 -> 776
    //   766: iload 5
    //   768: istore_3
    //   769: iload 6
    //   771: istore 5
    //   773: goto +473 -> 1246
    //   776: aload 20
    //   778: ldc_w 502
    //   781: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   784: ifeq +16 -> 800
    //   787: iload_3
    //   788: istore 6
    //   790: iload 5
    //   792: istore_3
    //   793: iload 6
    //   795: istore 5
    //   797: goto +449 -> 1246
    //   800: aload 20
    //   802: ldc_w 504
    //   805: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   808: ifeq +20 -> 828
    //   811: iload 6
    //   813: istore 4
    //   815: iload 5
    //   817: istore 6
    //   819: iload_3
    //   820: istore 5
    //   822: iload 6
    //   824: istore_3
    //   825: goto +421 -> 1246
    //   828: aload 20
    //   830: ldc_w 506
    //   833: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   836: ifeq +16 -> 852
    //   839: iload_3
    //   840: istore 6
    //   842: iload 5
    //   844: istore_3
    //   845: iload 6
    //   847: istore 5
    //   849: goto +397 -> 1246
    //   852: aload 20
    //   854: ldc_w 508
    //   857: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   860: ifeq +12 -> 872
    //   863: iload_3
    //   864: istore 5
    //   866: iload 6
    //   868: istore_3
    //   869: goto +377 -> 1246
    //   872: aload 20
    //   874: ldc_w 510
    //   877: invokevirtual 182	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   880: ifeq +16 -> 896
    //   883: iload_3
    //   884: istore 6
    //   886: iload 5
    //   888: istore_3
    //   889: iload 6
    //   891: istore 5
    //   893: goto +353 -> 1246
    //   896: aload 18
    //   898: invokevirtual 408	java/lang/String:length	()I
    //   901: bipush 30
    //   903: if_icmple +213 -> 1116
    //   906: aload 18
    //   908: bipush 8
    //   910: invokevirtual 412	java/lang/String:charAt	(I)C
    //   913: bipush 45
    //   915: if_icmpne +201 -> 1116
    //   918: aload 18
    //   920: bipush 17
    //   922: invokevirtual 412	java/lang/String:charAt	(I)C
    //   925: bipush 32
    //   927: if_icmpne +189 -> 1116
    //   930: getstatic 514	java/lang/System:out	Ljava/io/PrintStream;
    //   933: aload 18
    //   935: invokevirtual 519	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   938: goto -654 -> 284
    //   941: astore_0
    //   942: iconst_m1
    //   943: istore_3
    //   944: aload 19
    //   946: ifnull -905 -> 41
    //   949: aload 19
    //   951: invokevirtual 520	java/io/BufferedReader:close	()V
    //   954: iconst_m1
    //   955: ireturn
    //   956: astore_0
    //   957: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   960: iconst_3
    //   961: anewarray 67	java/lang/String
    //   964: dup
    //   965: iconst_0
    //   966: ldc 37
    //   968: aastore
    //   969: dup
    //   970: iconst_1
    //   971: ldc_w 522
    //   974: aastore
    //   975: dup
    //   976: iconst_2
    //   977: aload_0
    //   978: invokevirtual 493	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   981: aastore
    //   982: invokevirtual 496	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   985: iconst_m1
    //   986: ireturn
    //   987: aload 17
    //   989: aload_0
    //   990: iload_3
    //   991: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   994: invokeinterface 446 3 0
    //   999: pop
    //   1000: goto -659 -> 341
    //   1003: astore_0
    //   1004: aload 19
    //   1006: ifnull +8 -> 1014
    //   1009: aload 19
    //   1011: invokevirtual 520	java/io/BufferedReader:close	()V
    //   1014: aload_0
    //   1015: athrow
    //   1016: aload 19
    //   1018: ifnull +89 -> 1107
    //   1021: aload 19
    //   1023: invokevirtual 520	java/io/BufferedReader:close	()V
    //   1026: iload 9
    //   1028: ireturn
    //   1029: astore_0
    //   1030: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1033: iconst_3
    //   1034: anewarray 67	java/lang/String
    //   1037: dup
    //   1038: iconst_0
    //   1039: ldc 37
    //   1041: aastore
    //   1042: dup
    //   1043: iconst_1
    //   1044: ldc_w 522
    //   1047: aastore
    //   1048: dup
    //   1049: iconst_2
    //   1050: aload_0
    //   1051: invokevirtual 493	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1054: aastore
    //   1055: invokevirtual 496	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1058: iload 9
    //   1060: ireturn
    //   1061: astore_1
    //   1062: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1065: iconst_3
    //   1066: anewarray 67	java/lang/String
    //   1069: dup
    //   1070: iconst_0
    //   1071: ldc 37
    //   1073: aastore
    //   1074: dup
    //   1075: iconst_1
    //   1076: ldc_w 522
    //   1079: aastore
    //   1080: dup
    //   1081: iconst_2
    //   1082: aload_1
    //   1083: invokevirtual 493	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1086: aastore
    //   1087: invokevirtual 496	com/tencent/qapmsdk/common/logger/Logger:w	([Ljava/lang/String;)V
    //   1090: goto -76 -> 1014
    //   1093: astore_0
    //   1094: aconst_null
    //   1095: astore 19
    //   1097: goto -93 -> 1004
    //   1100: astore_0
    //   1101: aconst_null
    //   1102: astore 19
    //   1104: goto -162 -> 942
    //   1107: iload 9
    //   1109: ireturn
    //   1110: iload_3
    //   1111: istore 6
    //   1113: goto +23 -> 1136
    //   1116: iload_3
    //   1117: istore 6
    //   1119: iload 5
    //   1121: istore_3
    //   1122: iload 6
    //   1124: istore 5
    //   1126: goto +120 -> 1246
    //   1129: iload_3
    //   1130: iconst_1
    //   1131: iadd
    //   1132: istore_3
    //   1133: goto -1114 -> 19
    //   1136: iload 8
    //   1138: ifne -122 -> 1016
    //   1141: bipush 11
    //   1143: istore 10
    //   1145: aload 18
    //   1147: ifnonnull -1029 -> 118
    //   1150: iconst_1
    //   1151: istore 8
    //   1153: bipush 11
    //   1155: istore 7
    //   1157: goto -21 -> 1136
    //   1160: iload_3
    //   1161: istore 7
    //   1163: aload 18
    //   1165: astore_0
    //   1166: iconst_0
    //   1167: istore 10
    //   1169: iload 6
    //   1171: istore_3
    //   1172: lload 13
    //   1174: lstore 11
    //   1176: goto -907 -> 269
    //   1179: ldc 143
    //   1181: astore_0
    //   1182: goto -936 -> 246
    //   1185: iload_3
    //   1186: ifle +12 -> 1198
    //   1189: bipush 10
    //   1191: istore_3
    //   1192: aload_0
    //   1193: astore 18
    //   1195: goto -35 -> 1160
    //   1198: iload 10
    //   1200: istore_3
    //   1201: aload_0
    //   1202: astore 18
    //   1204: lload 15
    //   1206: lload 11
    //   1208: lcmp
    //   1209: ifne -49 -> 1160
    //   1212: iload 10
    //   1214: istore_3
    //   1215: aload_0
    //   1216: astore 18
    //   1218: iload 7
    //   1220: iconst_5
    //   1221: if_icmpne -61 -> 1160
    //   1224: iconst_5
    //   1225: istore_3
    //   1226: aload 17
    //   1228: astore 18
    //   1230: goto -70 -> 1160
    //   1233: iload 6
    //   1235: istore_3
    //   1236: iconst_1
    //   1237: istore 10
    //   1239: bipush 11
    //   1241: istore 7
    //   1243: goto -974 -> 269
    //   1246: iload 5
    //   1248: istore 6
    //   1250: iload_3
    //   1251: istore 5
    //   1253: iload 6
    //   1255: istore_3
    //   1256: goto -987 -> 269
    //   1259: iconst_0
    //   1260: istore 6
    //   1262: goto -592 -> 670
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1265	0	paramString	String
    //   0	1265	1	paramList	List<StatFields>
    //   0	1265	2	paramList1	List<Map<String, java.lang.Integer>>
    //   18	1238	3	i	int
    //   107	707	4	j	int
    //   7	1245	5	k	int
    //   110	1151	6	m	int
    //   101	1141	7	n	int
    //   4	1148	8	i1	int
    //   1	1107	9	i2	int
    //   284	954	10	i3	int
    //   104	1103	11	l1	long
    //   208	965	13	l2	long
    //   197	1008	15	l3	long
    //   15	1212	17	localObject1	Object
    //   60	8	18	localInterruptedException	java.lang.InterruptedException
    //   97	1132	18	localObject2	Object
    //   90	1013	19	localBufferedReader	java.io.BufferedReader
    //   11	862	20	str	String
    //   611	50	21	arrayOfString	String[]
    //   694	23	21	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   43	49	60	java/lang/InterruptedException
    //   622	643	694	java/lang/Exception
    //   652	670	694	java/lang/Exception
    //   92	99	941	java/lang/Exception
    //   118	127	941	java/lang/Exception
    //   134	210	941	java/lang/Exception
    //   212	229	941	java/lang/Exception
    //   236	242	941	java/lang/Exception
    //   246	261	941	java/lang/Exception
    //   269	276	941	java/lang/Exception
    //   289	341	941	java/lang/Exception
    //   341	422	941	java/lang/Exception
    //   437	447	941	java/lang/Exception
    //   455	465	941	java/lang/Exception
    //   473	483	941	java/lang/Exception
    //   491	501	941	java/lang/Exception
    //   509	519	941	java/lang/Exception
    //   527	537	941	java/lang/Exception
    //   546	556	941	java/lang/Exception
    //   565	575	941	java/lang/Exception
    //   584	594	941	java/lang/Exception
    //   603	613	941	java/lang/Exception
    //   670	681	941	java/lang/Exception
    //   696	725	941	java/lang/Exception
    //   731	742	941	java/lang/Exception
    //   755	766	941	java/lang/Exception
    //   776	787	941	java/lang/Exception
    //   800	811	941	java/lang/Exception
    //   828	839	941	java/lang/Exception
    //   852	863	941	java/lang/Exception
    //   872	883	941	java/lang/Exception
    //   896	938	941	java/lang/Exception
    //   987	1000	941	java/lang/Exception
    //   949	954	956	java/lang/Exception
    //   92	99	1003	finally
    //   118	127	1003	finally
    //   134	210	1003	finally
    //   212	229	1003	finally
    //   236	242	1003	finally
    //   246	261	1003	finally
    //   269	276	1003	finally
    //   289	341	1003	finally
    //   341	422	1003	finally
    //   437	447	1003	finally
    //   455	465	1003	finally
    //   473	483	1003	finally
    //   491	501	1003	finally
    //   509	519	1003	finally
    //   527	537	1003	finally
    //   546	556	1003	finally
    //   565	575	1003	finally
    //   584	594	1003	finally
    //   603	613	1003	finally
    //   622	643	1003	finally
    //   652	670	1003	finally
    //   670	681	1003	finally
    //   696	725	1003	finally
    //   731	742	1003	finally
    //   755	766	1003	finally
    //   776	787	1003	finally
    //   800	811	1003	finally
    //   828	839	1003	finally
    //   852	863	1003	finally
    //   872	883	1003	finally
    //   896	938	1003	finally
    //   987	1000	1003	finally
    //   1021	1026	1029	java/lang/Exception
    //   1009	1014	1061	java/lang/Exception
    //   75	92	1093	finally
    //   75	92	1100	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String writeMapinfoToLog(String paramString1, List<StatFields> paramList, @NonNull List<Map<String, java.lang.Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 525	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 526	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 45	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 528
    //   21: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 414
    //   31: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload 4
    //   36: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 530
    //   42: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 533	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload 6
    //   54: ldc_w 535
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_3
    //   64: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 538	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   71: invokevirtual 533	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   74: pop
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: aload_1
    //   79: invokeinterface 539 1 0
    //   84: if_icmpge +148 -> 232
    //   87: aload 6
    //   89: ldc_w 541
    //   92: iconst_2
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: getstatic 81	com/tencent/qapmsdk/memory/DumpMemInfoHandler:HEAP_NAME	[Ljava/lang/String;
    //   101: iload_3
    //   102: aaload
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: iload_3
    //   108: invokeinterface 428 2 0
    //   113: checkcast 6	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields
    //   116: invokestatic 450	com/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields:access$100	(Lcom/tencent/qapmsdk/memory/DumpMemInfoHandler$StatFields;)J
    //   119: invokestatic 544	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: invokestatic 538	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 533	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: aload_2
    //   131: iload_3
    //   132: invokeinterface 428 2 0
    //   137: checkcast 359	java/util/Map
    //   140: invokeinterface 545 1 0
    //   145: ifle +80 -> 225
    //   148: aload_2
    //   149: iload_3
    //   150: invokeinterface 428 2 0
    //   155: checkcast 359	java/util/Map
    //   158: invokestatic 547	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getSortedHashtableByValue	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   161: astore 7
    //   163: iconst_0
    //   164: istore 5
    //   166: iload 5
    //   168: aload 7
    //   170: arraylength
    //   171: if_icmpge +54 -> 225
    //   174: aload 6
    //   176: ldc_w 549
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 7
    //   187: iload 5
    //   189: aaload
    //   190: invokeinterface 553 1 0
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 7
    //   200: iload 5
    //   202: aaload
    //   203: invokeinterface 556 1 0
    //   208: aastore
    //   209: invokestatic 538	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokevirtual 533	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   215: pop
    //   216: iload 5
    //   218: iconst_1
    //   219: iadd
    //   220: istore 5
    //   222: goto -56 -> 166
    //   225: iload_3
    //   226: iconst_1
    //   227: iadd
    //   228: istore_3
    //   229: goto -152 -> 77
    //   232: aload 6
    //   234: new 45	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 528
    //   244: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 558
    //   254: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 533	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: pop
    //   264: aload 6
    //   266: invokevirtual 559	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   269: astore 6
    //   271: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   274: iconst_2
    //   275: anewarray 67	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc 37
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: aload 6
    //   287: aastore
    //   288: invokevirtual 562	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   291: new 45	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   298: getstatic 65	com/tencent/qapmsdk/memory/DumpMemInfoHandler:LOG_PATH	Ljava/lang/String;
    //   301: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 193
    //   306: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: invokestatic 564	com/tencent/qapmsdk/memory/DumpMemInfoHandler:getProcFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   313: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 195
    //   318: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 4
    //   323: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 566
    //   329: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_0
    //   338: aconst_null
    //   339: astore 4
    //   341: new 568	java/io/BufferedWriter
    //   344: dup
    //   345: new 274	java/io/FileWriter
    //   348: dup
    //   349: aload_2
    //   350: invokespecial 569	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   353: invokespecial 572	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   356: astore_1
    //   357: aload_1
    //   358: aload 6
    //   360: invokevirtual 573	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 574	java/io/BufferedWriter:close	()V
    //   367: aload_2
    //   368: astore_0
    //   369: aload_1
    //   370: ifnull +9 -> 379
    //   373: aload_1
    //   374: invokevirtual 574	java/io/BufferedWriter:close	()V
    //   377: aload_2
    //   378: astore_0
    //   379: aload_0
    //   380: areturn
    //   381: astore_0
    //   382: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   385: ldc 37
    //   387: aload_0
    //   388: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_2
    //   392: areturn
    //   393: astore_2
    //   394: aload 4
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 4
    //   400: aload_1
    //   401: astore_0
    //   402: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   405: ldc 37
    //   407: aload_2
    //   408: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload 4
    //   413: astore_0
    //   414: aload_1
    //   415: ifnull -36 -> 379
    //   418: aload_1
    //   419: invokevirtual 574	java/io/BufferedWriter:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   428: ldc 37
    //   430: aload_0
    //   431: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   434: aconst_null
    //   435: areturn
    //   436: astore_2
    //   437: aload_0
    //   438: astore_1
    //   439: aload_2
    //   440: astore_0
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 574	java/io/BufferedWriter:close	()V
    //   449: aload_0
    //   450: athrow
    //   451: astore_1
    //   452: getstatic 154	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   455: ldc 37
    //   457: aload_1
    //   458: invokevirtual 233	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   461: goto -12 -> 449
    //   464: astore_0
    //   465: goto -24 -> 441
    //   468: astore_2
    //   469: goto -72 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramString1	String
    //   0	472	1	paramList	List<StatFields>
    //   0	472	2	paramList1	List<Map<String, java.lang.Integer>>
    //   0	472	3	paramInt	int
    //   0	472	4	paramString2	String
    //   164	57	5	i	int
    //   7	352	6	localObject	Object
    //   161	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   373	377	381	java/io/IOException
    //   341	357	393	java/io/IOException
    //   418	422	424	java/io/IOException
    //   341	357	436	finally
    //   402	411	436	finally
    //   445	449	451	java/io/IOException
    //   357	367	464	finally
    //   357	367	468	java/io/IOException
  }
  
  public static Object[] zipFiles(@NonNull List<String> paramList, String paramString)
  {
    String str = getFormatTime(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    paramString = LOG_PATH + "dump_" + paramString + "_" + str + ".zip";
    return new Object[] { Boolean.valueOf(FileUtil.zipFiles(paramList, paramString)), paramString };
  }
  
  static class StatFields
  {
    long privateDirty;
    private long pss;
    long sharedDirty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */