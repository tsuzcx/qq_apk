package com.tencent.ttpic.baseutils.device;

final class DeviceUtils$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 18	java/io/BufferedReader
    //   3: dup
    //   4: new 20	java/io/InputStreamReader
    //   7: dup
    //   8: new 22	java/io/FileInputStream
    //   11: dup
    //   12: ldc 24
    //   14: invokespecial 27	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 30	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: sipush 1000
    //   23: invokespecial 33	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 37	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 5
    //   37: invokevirtual 40	java/io/BufferedReader:close	()V
    //   40: aload 6
    //   42: ldc 42
    //   44: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: astore 5
    //   49: aload 5
    //   51: iconst_2
    //   52: aaload
    //   53: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   56: aload 5
    //   58: iconst_3
    //   59: aaload
    //   60: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: ladd
    //   64: aload 5
    //   66: iconst_4
    //   67: aaload
    //   68: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: ladd
    //   72: aload 5
    //   74: bipush 6
    //   76: aaload
    //   77: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   80: ladd
    //   81: aload 5
    //   83: iconst_5
    //   84: aaload
    //   85: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   88: ladd
    //   89: aload 5
    //   91: bipush 7
    //   93: aaload
    //   94: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   97: ladd
    //   98: aload 5
    //   100: bipush 8
    //   102: aaload
    //   103: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   106: ladd
    //   107: lstore_1
    //   108: aload 5
    //   110: iconst_5
    //   111: aaload
    //   112: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   115: lstore_3
    //   116: invokestatic 60	com/tencent/ttpic/baseutils/device/DeviceUtils:access$100	()J
    //   119: lconst_0
    //   120: lcmp
    //   121: ifle +40 -> 161
    //   124: invokestatic 63	com/tencent/ttpic/baseutils/device/DeviceUtils:access$200	()J
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle +32 -> 161
    //   132: lload_1
    //   133: invokestatic 63	com/tencent/ttpic/baseutils/device/DeviceUtils:access$200	()J
    //   136: lcmp
    //   137: ifeq +24 -> 161
    //   140: fconst_1
    //   141: lload_3
    //   142: invokestatic 60	com/tencent/ttpic/baseutils/device/DeviceUtils:access$100	()J
    //   145: lsub
    //   146: l2f
    //   147: fconst_1
    //   148: fmul
    //   149: lload_1
    //   150: invokestatic 63	com/tencent/ttpic/baseutils/device/DeviceUtils:access$200	()J
    //   153: lsub
    //   154: l2f
    //   155: fdiv
    //   156: fsub
    //   157: invokestatic 67	com/tencent/ttpic/baseutils/device/DeviceUtils:access$302	(F)F
    //   160: pop
    //   161: lload_3
    //   162: invokestatic 71	com/tencent/ttpic/baseutils/device/DeviceUtils:access$102	(J)J
    //   165: pop2
    //   166: lload_1
    //   167: invokestatic 74	com/tencent/ttpic/baseutils/device/DeviceUtils:access$202	(J)J
    //   170: pop2
    //   171: iconst_1
    //   172: invokestatic 78	com/tencent/ttpic/baseutils/device/DeviceUtils:access$402	(I)I
    //   175: pop
    //   176: return
    //   177: astore 5
    //   179: invokestatic 81	com/tencent/ttpic/baseutils/device/DeviceUtils:access$000	()Ljava/lang/String;
    //   182: new 83	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   189: ldc 86
    //   191: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 93	java/io/IOException:toString	()Ljava/lang/String;
    //   199: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 100	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: return
    //   209: astore 5
    //   211: invokestatic 81	com/tencent/ttpic/baseutils/device/DeviceUtils:access$000	()Ljava/lang/String;
    //   214: new 83	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   221: ldc 102
    //   223: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 5
    //   228: invokevirtual 103	java/lang/ArrayIndexOutOfBoundsException:toString	()Ljava/lang/String;
    //   231: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 100	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	1
    //   107	60	1	l1	long
    //   115	47	3	l2	long
    //   26	83	5	localObject	Object
    //   177	18	5	localIOException	java.io.IOException
    //   209	18	5	localArrayIndexOutOfBoundsException	java.lang.ArrayIndexOutOfBoundsException
    //   33	8	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   0	49	177	java/io/IOException
    //   49	116	209	java/lang/ArrayIndexOutOfBoundsException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.device.DeviceUtils.1
 * JD-Core Version:    0.7.0.1
 */