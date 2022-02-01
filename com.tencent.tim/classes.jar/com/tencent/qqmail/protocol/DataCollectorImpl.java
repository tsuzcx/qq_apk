package com.tencent.qqmail.protocol;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protocol.UMA.DataReport;
import com.tencent.qqmail.uma.QMUmaManager;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.ReportFileHandler;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataCollectorImpl
{
  private static final String TAG = "DataCollectorImpl";
  private static final String TMP_SUFFIX = "umatmp";
  private static ReportFileHandler sFileHandler;
  private static String sFilePath = LogPathManager.getInstance().getQMLogUmaFilePath();
  private static Map<String, PerformanceTracking> sPerformanceMap;
  
  static
  {
    sFileHandler = new ReportFileHandler(sFilePath);
    sPerformanceMap = new ConcurrentHashMap();
    deleteOldFile();
  }
  
  private static String acquire(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      String str2 = String.valueOf(paramVarArgs[i]);
      String str1 = str2;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() > 1024) {
          str1 = str2.substring(0, 1024);
        }
      }
      localStringBuilder.append(str1);
      if (i != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void deleteOldFile()
  {
    new File(QMApplicationContext.sharedInstance().getCacheDir() + File.separator + "remotelog").delete();
  }
  
  public static void flush()
  {
    sFileHandler.flush();
  }
  
  private static void log(String paramString)
  {
    sFileHandler.log(paramString.replace("\r\n", "|").replace("\n", "|"));
  }
  
  static void logClickStream(String paramString)
  {
    logEvent(paramString);
  }
  
  public static void logDetailEvent(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    log(acquire(new Object[] { Integer.valueOf(8), Long.valueOf(now()), paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString2 }));
  }
  
  static void logDetailEventWithDetailMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    logDetailEvent(paramString1 + "_" + paramString2, paramLong1, paramLong2, paramString3);
  }
  
  public static void logEvent(String paramString)
  {
    log(acquire(new Object[] { Integer.valueOf(7), Long.valueOf(now()), paramString, Integer.valueOf(0), "" }));
  }
  
  public static void logException(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (AppStatusUtil.isAppOnForeground()) {}
    for (String str = "f";; str = "b")
    {
      log(acquire(new Object[] { Integer.valueOf(7), Long.valueOf(now()), paramString1, Long.valueOf(makeErrorNumber(paramInt1, paramInt2)), paramString2 + ";" + str }));
      return;
    }
  }
  
  public static void logException(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (AppStatusUtil.isAppOnForeground()) {}
    for (String str = "f";; str = "b")
    {
      log(acquire(new Object[] { Integer.valueOf(7), Long.valueOf(now()), paramString2, Long.valueOf(makeCgiErrorNumber(paramString1, paramInt)), paramString3 + ";" + str }));
      return;
    }
  }
  
  public static void logPerformanceBegin(String paramString1, long paramLong, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      ValidateHelper.assertInDebug("key is null", bool);
      sPerformanceMap.put(paramString2, new PerformanceTracking(paramString1, paramLong));
      return;
    }
  }
  
  public static void logPerformanceEnd(String paramString1, String paramString2)
  {
    paramString1 = (PerformanceTracking)sPerformanceMap.remove(paramString1);
    if (paramString1 == null) {
      return;
    }
    logPerformanceRaw(paramString1.itemName, paramString1.accountId, SystemClock.elapsedRealtime() - paramString1.begin);
  }
  
  static void logPerformanceRaw(String paramString, long paramLong1, long paramLong2)
  {
    log(acquire(new Object[] { Integer.valueOf(6), Long.valueOf(now()), paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  static void logStatus(String paramString1, String paramString2)
  {
    log(acquire(new Object[] { Integer.valueOf(9), Long.valueOf(now()), paramString1, "", paramString2 }));
  }
  
  private static long makeCgiErrorNumber(String paramString, int paramInt)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i + 4];
    System.arraycopy(paramString.getBytes(), 0, arrayOfByte, 0, i);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    arrayOfByte[(i + 1)] = ((byte)(paramInt >> 8 & 0xFF));
    arrayOfByte[(i + 2)] = ((byte)(paramInt >> 16 & 0xFF));
    arrayOfByte[(i + 3)] = ((byte)(paramInt >> 24 & 0xFF));
    return makeErrorNumber(3, murMurHash2(arrayOfByte));
  }
  
  private static long makeErrorNumber(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0xFFFFFFFF) << 32 | paramInt2 & 0xFFFFFFFF;
  }
  
  private static int murMurHash2(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int k = i;
    int j = 0;
    for (i = 0x7FFFFD9 ^ i; k >= 4; i = (m ^ m >>> 24) * 1540483477 ^ i * 1540483477)
    {
      m = ((paramArrayOfByte[(j + 3)] & 0xFF) << 24 | (paramArrayOfByte[(j + 2)] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 8 | paramArrayOfByte[j] & 0xFF) * 1540483477;
      k -= 4;
      j += 4;
    }
    int m = i;
    int n = i;
    switch (k)
    {
    }
    for (;;)
    {
      i = (i ^ i >>> 13) * 1540483477;
      return i ^ i >>> 15;
      m = i ^ paramArrayOfByte[(j + 2)] << 16;
      n = m ^ paramArrayOfByte[(j + 1)] << 8;
      i = (n ^ paramArrayOfByte[j]) * 1540483477;
    }
  }
  
  private static long now()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  /* Error */
  private static DataReport[] prepareUploadData(List<File> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 268 1 0
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_0
    //   10: aconst_null
    //   11: astore_3
    //   12: aload 5
    //   14: invokeinterface 273 1 0
    //   19: ifeq +214 -> 233
    //   22: aload 5
    //   24: invokeinterface 277 1 0
    //   29: checkcast 91	java/io/File
    //   32: astore_2
    //   33: new 279	java/io/BufferedReader
    //   36: dup
    //   37: new 281	java/io/FileReader
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 284	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   45: invokespecial 287	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_2
    //   49: aload_3
    //   50: astore_0
    //   51: aload_2
    //   52: invokevirtual 290	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +146 -> 203
    //   60: aload_3
    //   61: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne -13 -> 51
    //   67: new 292	com/tencent/qqmail/protocol/UMA/DataReport
    //   70: dup
    //   71: invokespecial 293	com/tencent/qqmail/protocol/UMA/DataReport:<init>	()V
    //   74: astore 4
    //   76: aload_3
    //   77: ldc 86
    //   79: invokevirtual 297	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   82: istore_1
    //   83: aload 4
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: putfield 304	com/tencent/qqmail/protocol/UMA/DataReport:type	I
    //   97: aload 4
    //   99: new 306	com/tencent/qqmail/protobuf/ByteString
    //   102: dup
    //   103: aload_3
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: invokevirtual 309	java/lang/String:substring	(I)Ljava/lang/String;
    //   110: invokevirtual 239	java/lang/String:getBytes	()[B
    //   113: invokespecial 312	com/tencent/qqmail/protobuf/ByteString:<init>	([B)V
    //   116: putfield 316	com/tencent/qqmail/protocol/UMA/DataReport:data	Lcom/tencent/qqmail/protobuf/ByteString;
    //   119: aload_0
    //   120: ifnonnull +193 -> 313
    //   123: new 318	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 319	java/util/ArrayList:<init>	()V
    //   130: astore_3
    //   131: aload_3
    //   132: astore_0
    //   133: aload_0
    //   134: aload 4
    //   136: invokeinterface 323 2 0
    //   141: pop
    //   142: goto -91 -> 51
    //   145: astore 4
    //   147: ldc 11
    //   149: new 63	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 325
    //   159: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_3
    //   163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: aload 4
    //   171: invokestatic 331	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: goto -124 -> 51
    //   178: astore_3
    //   179: aload_2
    //   180: astore 4
    //   182: aload_0
    //   183: astore_2
    //   184: aload 4
    //   186: astore_0
    //   187: ldc 11
    //   189: aload_3
    //   190: invokestatic 334	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   193: pop
    //   194: aload_0
    //   195: invokevirtual 337	java/io/BufferedReader:close	()V
    //   198: aload_2
    //   199: astore_3
    //   200: goto -188 -> 12
    //   203: aload_2
    //   204: invokevirtual 337	java/io/BufferedReader:close	()V
    //   207: aload_0
    //   208: astore_3
    //   209: aload_2
    //   210: astore_0
    //   211: aload_3
    //   212: astore_2
    //   213: goto -15 -> 198
    //   216: astore_3
    //   217: aload_0
    //   218: astore_3
    //   219: aload_2
    //   220: astore_0
    //   221: aload_3
    //   222: astore_2
    //   223: goto -25 -> 198
    //   226: astore_0
    //   227: aload_2
    //   228: invokevirtual 337	java/io/BufferedReader:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: aload_3
    //   234: ifnull +31 -> 265
    //   237: aload_3
    //   238: invokeinterface 340 1 0
    //   243: ifle +22 -> 265
    //   246: aload_3
    //   247: aload_3
    //   248: invokeinterface 340 1 0
    //   253: anewarray 292	com/tencent/qqmail/protocol/UMA/DataReport
    //   256: invokeinterface 344 2 0
    //   261: checkcast 346	[Lcom/tencent/qqmail/protocol/UMA/DataReport;
    //   264: areturn
    //   265: aconst_null
    //   266: areturn
    //   267: astore_3
    //   268: goto -70 -> 198
    //   271: astore_2
    //   272: goto -41 -> 231
    //   275: astore_3
    //   276: aload_0
    //   277: astore_2
    //   278: aload_3
    //   279: astore_0
    //   280: goto -53 -> 227
    //   283: astore_3
    //   284: aload_0
    //   285: astore_2
    //   286: aload_3
    //   287: astore_0
    //   288: goto -61 -> 227
    //   291: astore_3
    //   292: aload_0
    //   293: astore 4
    //   295: aload_2
    //   296: astore_0
    //   297: aload 4
    //   299: astore_2
    //   300: goto -113 -> 187
    //   303: astore 4
    //   305: aload_3
    //   306: astore_2
    //   307: aload 4
    //   309: astore_3
    //   310: goto -123 -> 187
    //   313: goto -180 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramList	List<File>
    //   82	25	1	i	int
    //   32	196	2	localObject1	Object
    //   271	1	2	localException1	java.lang.Exception
    //   277	30	2	localObject2	Object
    //   11	152	3	localObject3	Object
    //   178	12	3	localException2	java.lang.Exception
    //   199	13	3	localObject4	Object
    //   216	1	3	localException3	java.lang.Exception
    //   218	30	3	localList	List<File>
    //   267	1	3	localException4	java.lang.Exception
    //   275	4	3	localObject5	Object
    //   283	4	3	localObject6	Object
    //   291	15	3	localException5	java.lang.Exception
    //   309	1	3	localObject7	Object
    //   74	61	4	localDataReport	DataReport
    //   145	25	4	localException6	java.lang.Exception
    //   180	118	4	localObject8	Object
    //   303	5	4	localException7	java.lang.Exception
    //   6	17	5	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   83	97	145	java/lang/Exception
    //   51	56	178	java/lang/Exception
    //   60	83	178	java/lang/Exception
    //   97	119	178	java/lang/Exception
    //   123	131	178	java/lang/Exception
    //   147	175	178	java/lang/Exception
    //   203	207	216	java/lang/Exception
    //   51	56	226	finally
    //   60	83	226	finally
    //   83	97	226	finally
    //   97	119	226	finally
    //   123	131	226	finally
    //   133	142	226	finally
    //   147	175	226	finally
    //   194	198	267	java/lang/Exception
    //   227	231	271	java/lang/Exception
    //   187	194	275	finally
    //   33	49	283	finally
    //   133	142	291	java/lang/Exception
    //   33	49	303	java/lang/Exception
  }
  
  public static void submit()
  {
    Threads.runInBackground(new DataCollectorImpl.2());
  }
  
  public static void updatePath()
  {
    String str = sFilePath;
    if (sFileHandler != null) {
      sFileHandler.close();
    }
    sFilePath = LogPathManager.getInstance().getQMLogUmaFilePath();
    sFileHandler = new ReportFileHandler(sFilePath);
    QMLog.log(4, "DataCollectorImpl", "update uma log, new path: " + sFilePath + ", old path: " + str);
  }
  
  private static void upload()
  {
    if (!sFileHandler.acquireUpload()) {
      return;
    }
    sFileHandler.flush();
    sFileHandler.rename("umatmp");
    List localList = sFileHandler.getFileListBySuffixes(new String[] { "umatmp" });
    QMLog.log(4, "DataCollectorImpl", "submit, file: " + localList.size());
    if (localList.size() == 0)
    {
      sFileHandler.finishUpload();
      return;
    }
    DataReport[] arrayOfDataReport = prepareUploadData(localList);
    Object localObject1 = new StringBuilder().append("submit, dataSize: ");
    if (arrayOfDataReport != null) {}
    for (int i = arrayOfDataReport.length;; i = -1)
    {
      QMLog.log(4, "DataCollectorImpl", i);
      if ((arrayOfDataReport != null) && (arrayOfDataReport.length != 0)) {
        break;
      }
      sFileHandler.finishUpload();
      return;
    }
    localObject1 = CloudProtocolHelper.getCommonInfo();
    if (localObject1 == null)
    {
      sFileHandler.finishUpload();
      return;
    }
    Object localObject2 = DeviceUtil.getScreenWidthHeight(QMApplicationContext.sharedInstance());
    localObject2 = localObject2[0] + "*" + localObject2[1] + ":1";
    ((CloudProtocolInfo)localObject1).phone_type_ = (((CloudProtocolInfo)localObject1).phone_type_ + ",android " + DeviceUtil.getDeviceInfos().releaseVersion + "," + ((CloudProtocolInfo)localObject1).device_id_);
    ((CloudProtocolInfo)localObject1).sys_version_ = (AppConfig.getPatchVersionCode() + ";" + (String)localObject2 + ";1");
    ((CloudProtocolInfo)localObject1).use_gzip_ = true;
    ((CloudProtocolInfo)localObject1).data_report_list_ = arrayOfDataReport;
    QMUmaManager.sharedInstance().dataReport((CloudProtocolInfo)localObject1, new DataCollectorImpl.1(localList));
  }
  
  static class PerformanceTracking
  {
    long accountId;
    long begin = SystemClock.elapsedRealtime();
    String itemName;
    
    PerformanceTracking(String paramString, long paramLong)
    {
      this.itemName = paramString;
      this.accountId = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.DataCollectorImpl
 * JD-Core Version:    0.7.0.1
 */