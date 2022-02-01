package com.huawei.hms.utils;

import java.io.File;

final class FileUtil$1
  implements Runnable
{
  FileUtil$1(File paramFile, long paramLong, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   4: ifnonnull +11 -> 15
    //   7: ldc 29
    //   9: ldc 31
    //   11: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: aload_0
    //   16: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   19: invokevirtual 43	java/io/File:getParentFile	()Ljava/io/File;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +17 -> 41
    //   27: aload_3
    //   28: invokevirtual 47	java/io/File:mkdirs	()Z
    //   31: ifne +18 -> 49
    //   34: aload_3
    //   35: invokevirtual 50	java/io/File:isDirectory	()Z
    //   38: ifne +11 -> 49
    //   41: ldc 29
    //   43: ldc 52
    //   45: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: return
    //   49: aconst_null
    //   50: astore 6
    //   52: aconst_null
    //   53: astore 4
    //   55: aload 4
    //   57: astore 5
    //   59: aload 6
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   66: invokevirtual 56	java/io/File:length	()J
    //   69: lstore_1
    //   70: aload 4
    //   72: astore 5
    //   74: aload 6
    //   76: astore_3
    //   77: lload_1
    //   78: aload_0
    //   79: getfield 18	com/huawei/hms/utils/FileUtil$1:b	J
    //   82: lcmp
    //   83: ifle +120 -> 203
    //   86: aload 4
    //   88: astore 5
    //   90: aload 6
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   97: invokevirtual 60	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   100: astore 7
    //   102: aload 4
    //   104: astore 5
    //   106: aload 6
    //   108: astore_3
    //   109: aload_0
    //   110: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   113: invokevirtual 63	java/io/File:delete	()Z
    //   116: ifne +17 -> 133
    //   119: aload 4
    //   121: astore 5
    //   123: aload 6
    //   125: astore_3
    //   126: ldc 29
    //   128: ldc 65
    //   130: invokestatic 37	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: astore 5
    //   137: aload 6
    //   139: astore_3
    //   140: new 67	java/io/RandomAccessFile
    //   143: dup
    //   144: new 39	java/io/File
    //   147: dup
    //   148: aload 7
    //   150: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: ldc 72
    //   155: invokespecial 75	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   158: astore 4
    //   160: aload 4
    //   162: astore 5
    //   164: aload 4
    //   166: astore_3
    //   167: aload 4
    //   169: new 77	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   176: aload_0
    //   177: getfield 20	com/huawei/hms/utils/FileUtil$1:c	Ljava/lang/String;
    //   180: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 84
    //   185: invokestatic 90	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 96	java/io/RandomAccessFile:writeBytes	(Ljava/lang/String;)V
    //   197: aload 4
    //   199: invokestatic 102	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   202: return
    //   203: aload 4
    //   205: astore 5
    //   207: aload 6
    //   209: astore_3
    //   210: new 67	java/io/RandomAccessFile
    //   213: dup
    //   214: aload_0
    //   215: getfield 16	com/huawei/hms/utils/FileUtil$1:a	Ljava/io/File;
    //   218: ldc 72
    //   220: invokespecial 75	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   223: astore 4
    //   225: aload 4
    //   227: lload_1
    //   228: invokevirtual 106	java/io/RandomAccessFile:seek	(J)V
    //   231: goto -71 -> 160
    //   234: astore 4
    //   236: aload 5
    //   238: astore_3
    //   239: ldc 29
    //   241: ldc 108
    //   243: aload 4
    //   245: invokestatic 111	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload 5
    //   250: invokestatic 102	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   253: return
    //   254: astore 5
    //   256: aload_3
    //   257: astore 4
    //   259: aload 5
    //   261: astore_3
    //   262: aload 4
    //   264: invokestatic 102	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   267: aload_3
    //   268: athrow
    //   269: astore_3
    //   270: goto -8 -> 262
    //   273: astore_3
    //   274: aload 4
    //   276: astore 5
    //   278: aload_3
    //   279: astore 4
    //   281: goto -45 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	1
    //   69	159	1	l	long
    //   22	246	3	localObject1	Object
    //   269	1	3	localObject2	Object
    //   273	6	3	localIOException1	java.io.IOException
    //   53	173	4	localRandomAccessFile1	java.io.RandomAccessFile
    //   234	10	4	localIOException2	java.io.IOException
    //   257	23	4	localObject3	Object
    //   57	192	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   254	6	5	localObject4	Object
    //   276	1	5	localObject5	Object
    //   50	158	6	localObject6	Object
    //   100	49	7	str	String
    // Exception table:
    //   from	to	target	type
    //   62	70	234	java/io/IOException
    //   77	86	234	java/io/IOException
    //   93	102	234	java/io/IOException
    //   109	119	234	java/io/IOException
    //   126	133	234	java/io/IOException
    //   140	160	234	java/io/IOException
    //   167	197	234	java/io/IOException
    //   210	225	234	java/io/IOException
    //   62	70	254	finally
    //   77	86	254	finally
    //   93	102	254	finally
    //   109	119	254	finally
    //   126	133	254	finally
    //   140	160	254	finally
    //   167	197	254	finally
    //   210	225	254	finally
    //   239	248	254	finally
    //   225	231	269	finally
    //   225	231	273	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.FileUtil.1
 * JD-Core Version:    0.7.0.1
 */