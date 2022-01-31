package com.tencent.smtt.sdk;

public class DeviceInfo
{
  public static int GPU_ENABLE_BOUNDS = 600;
  private static int totalRAM = 0;
  
  /* Error */
  public static int getTotalRAM()
  {
    // Byte code:
    //   0: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   3: ifle +7 -> 10
    //   6: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   9: ireturn
    //   10: iconst_0
    //   11: istore_1
    //   12: iconst_0
    //   13: istore_2
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 5
    //   22: new 25	java/io/BufferedReader
    //   25: dup
    //   26: new 27	java/io/FileReader
    //   29: dup
    //   30: ldc 29
    //   32: invokespecial 32	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   35: sipush 8192
    //   38: invokespecial 35	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 39	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: iload_2
    //   50: istore_0
    //   51: aload_3
    //   52: ifnull +78 -> 130
    //   55: aload_3
    //   56: ldc 41
    //   58: invokevirtual 47	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   61: istore_0
    //   62: iconst_m1
    //   63: iload_0
    //   64: if_icmpeq -21 -> 43
    //   67: aload_3
    //   68: ldc 41
    //   70: invokevirtual 50	java/lang/String:length	()I
    //   73: iload_0
    //   74: iadd
    //   75: invokevirtual 54	java/lang/String:substring	(I)Ljava/lang/String;
    //   78: invokevirtual 57	java/lang/String:trim	()Ljava/lang/String;
    //   81: astore_3
    //   82: iload_2
    //   83: istore_0
    //   84: aload_3
    //   85: ifnull +45 -> 130
    //   88: iload_2
    //   89: istore_0
    //   90: aload_3
    //   91: invokevirtual 50	java/lang/String:length	()I
    //   94: ifeq +36 -> 130
    //   97: iload_2
    //   98: istore_0
    //   99: aload_3
    //   100: ldc 59
    //   102: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +25 -> 130
    //   108: aload_3
    //   109: iconst_0
    //   110: aload_3
    //   111: ldc 59
    //   113: invokevirtual 47	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   116: invokevirtual 66	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: invokevirtual 57	java/lang/String:trim	()Ljava/lang/String;
    //   122: invokestatic 71	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: sipush 1024
    //   128: idiv
    //   129: istore_0
    //   130: aload 4
    //   132: ifnull +151 -> 283
    //   135: aload 4
    //   137: invokevirtual 74	java/io/BufferedReader:close	()V
    //   140: iload_0
    //   141: putstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   144: getstatic 11	com/tencent/smtt/sdk/DeviceInfo:totalRAM	I
    //   147: ireturn
    //   148: astore_3
    //   149: aload_3
    //   150: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   153: goto -13 -> 140
    //   156: astore_3
    //   157: aload 5
    //   159: astore 4
    //   161: aload_3
    //   162: astore 5
    //   164: aload 4
    //   166: astore_3
    //   167: aload 5
    //   169: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   172: iload_1
    //   173: istore_0
    //   174: aload 4
    //   176: ifnull -36 -> 140
    //   179: aload 4
    //   181: invokevirtual 74	java/io/BufferedReader:close	()V
    //   184: iload_1
    //   185: istore_0
    //   186: goto -46 -> 140
    //   189: astore_3
    //   190: aload_3
    //   191: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   194: iload_1
    //   195: istore_0
    //   196: goto -56 -> 140
    //   199: astore 5
    //   201: aload 6
    //   203: astore 4
    //   205: aload 4
    //   207: astore_3
    //   208: aload 5
    //   210: invokevirtual 78	java/lang/Throwable:printStackTrace	()V
    //   213: iload_1
    //   214: istore_0
    //   215: aload 4
    //   217: ifnull -77 -> 140
    //   220: aload 4
    //   222: invokevirtual 74	java/io/BufferedReader:close	()V
    //   225: iload_1
    //   226: istore_0
    //   227: goto -87 -> 140
    //   230: astore_3
    //   231: aload_3
    //   232: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   235: iload_1
    //   236: istore_0
    //   237: goto -97 -> 140
    //   240: astore 4
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 74	java/io/BufferedReader:close	()V
    //   250: aload 4
    //   252: athrow
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   258: goto -8 -> 250
    //   261: astore 5
    //   263: aload 4
    //   265: astore_3
    //   266: aload 5
    //   268: astore 4
    //   270: goto -28 -> 242
    //   273: astore 5
    //   275: goto -70 -> 205
    //   278: astore 5
    //   280: goto -116 -> 164
    //   283: goto -143 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	187	0	i	int
    //   11	225	1	j	int
    //   13	85	2	k	int
    //   18	93	3	str	java.lang.String
    //   148	2	3	localIOException1	java.io.IOException
    //   156	6	3	localIOException2	java.io.IOException
    //   166	1	3	localObject1	Object
    //   189	2	3	localIOException3	java.io.IOException
    //   207	1	3	localObject2	Object
    //   230	17	3	localIOException4	java.io.IOException
    //   253	2	3	localIOException5	java.io.IOException
    //   265	1	3	localObject3	Object
    //   41	180	4	localObject4	Object
    //   240	24	4	localObject5	Object
    //   268	1	4	localObject6	Object
    //   20	148	5	localIOException6	java.io.IOException
    //   199	10	5	localThrowable1	java.lang.Throwable
    //   261	6	5	localObject7	Object
    //   273	1	5	localThrowable2	java.lang.Throwable
    //   278	1	5	localIOException7	java.io.IOException
    //   15	187	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   135	140	148	java/io/IOException
    //   22	43	156	java/io/IOException
    //   179	184	189	java/io/IOException
    //   22	43	199	java/lang/Throwable
    //   220	225	230	java/io/IOException
    //   22	43	240	finally
    //   167	172	240	finally
    //   208	213	240	finally
    //   246	250	253	java/io/IOException
    //   43	49	261	finally
    //   55	62	261	finally
    //   67	82	261	finally
    //   90	97	261	finally
    //   99	130	261	finally
    //   43	49	273	java/lang/Throwable
    //   55	62	273	java/lang/Throwable
    //   67	82	273	java/lang/Throwable
    //   90	97	273	java/lang/Throwable
    //   99	130	273	java/lang/Throwable
    //   43	49	278	java/io/IOException
    //   55	62	278	java/io/IOException
    //   67	82	278	java/io/IOException
    //   90	97	278	java/io/IOException
    //   99	130	278	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */