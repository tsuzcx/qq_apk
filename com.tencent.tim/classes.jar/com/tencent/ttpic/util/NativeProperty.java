package com.tencent.ttpic.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;

public class NativeProperty
{
  private static final int ARM_FEATURE_ARMv7 = 1;
  private static final int ARM_FEATURE_NEON = 4;
  private static final int FAMILY_ARM = 1;
  private static final int FAMILY_ARM64 = 4;
  private static String cpuABI = "";
  private static int cpuFamily = 1;
  private static int cpuFeature;
  
  public static int cpuFeature()
  {
    return cpuFeature;
  }
  
  public static String getCpuABI()
  {
    return cpuABI;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 38	java/io/BufferedReader
    //   5: dup
    //   6: new 40	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 46	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 48	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   20: ldc 51
    //   22: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 62	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 68	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 71	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: sipush 1024
    //   44: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_1
    //   58: invokevirtual 80	java/io/BufferedReader:close	()V
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 80	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   76: aload_2
    //   77: areturn
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 80	java/io/BufferedReader:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   102: goto -7 -> 95
    //   105: astore_0
    //   106: aload_2
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 80	java/io/BufferedReader:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokestatic 86	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   123: goto -7 -> 116
    //   126: astore_2
    //   127: aload_0
    //   128: astore_1
    //   129: aload_2
    //   130: astore_0
    //   131: goto -23 -> 108
    //   134: astore_2
    //   135: goto -54 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   47	66	1	localObject1	Object
    //   118	2	1	localIOException1	java.io.IOException
    //   128	1	1	str1	String
    //   1	76	2	str2	String
    //   78	29	2	localIOException2	java.io.IOException
    //   126	4	2	localObject2	Object
    //   134	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	69	71	java/io/IOException
    //   2	48	78	java/io/IOException
    //   91	95	97	java/io/IOException
    //   2	48	105	finally
    //   112	116	118	java/io/IOException
    //   50	55	126	finally
    //   57	61	126	finally
    //   83	87	126	finally
    //   50	55	134	java/io/IOException
    //   57	61	134	java/io/IOException
  }
  
  public static boolean hasNeonFeature()
  {
    return (1 == cpuFamily) && ((cpuFeature & 0x4) != 0);
  }
  
  public static void init()
  {
    cpuABI = getSystemProperty("ro.product.cpu.abi");
    if ((cpuABI == null) || (cpuABI.equals("x86")))
    {
      cpuFeature = 5;
      return;
    }
    try
    {
      cpuFeature = nGetCpuInfo();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(localUnsatisfiedLinkError);
      ReportUtil.report("NativeProperty init error! " + localUnsatisfiedLinkError);
    }
  }
  
  private static native int nGetCpuInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.NativeProperty
 * JD-Core Version:    0.7.0.1
 */