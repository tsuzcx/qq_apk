public class txh
{
  /* Error */
  public static java.lang.String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: ldc 12
    //   9: invokestatic 18	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 5
    //   14: aload_0
    //   15: ifnonnull +52 -> 67
    //   18: ldc 20
    //   20: astore_2
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 22	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 26	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: aload_2
    //   34: areturn
    //   35: astore_0
    //   36: ldc 28
    //   38: iconst_1
    //   39: new 30	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   46: ldc 33
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   55: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: ldc 20
    //   66: areturn
    //   67: aload_3
    //   68: astore_2
    //   69: aload_0
    //   70: invokevirtual 57	java/io/File:exists	()Z
    //   73: ifne +50 -> 123
    //   76: ldc 20
    //   78: astore_2
    //   79: iconst_0
    //   80: ifeq -47 -> 33
    //   83: new 22	java/lang/NullPointerException
    //   86: dup
    //   87: invokespecial 26	java/lang/NullPointerException:<init>	()V
    //   90: athrow
    //   91: astore_0
    //   92: ldc 28
    //   94: iconst_1
    //   95: new 30	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   102: ldc 33
    //   104: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   111: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: ldc 20
    //   122: areturn
    //   123: aload_3
    //   124: astore_2
    //   125: new 59	java/io/RandomAccessFile
    //   128: dup
    //   129: aload_0
    //   130: ldc 61
    //   132: invokespecial 64	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   135: astore_3
    //   136: ldc 65
    //   138: newarray byte
    //   140: astore_0
    //   141: aload_3
    //   142: aload_0
    //   143: invokevirtual 69	java/io/RandomAccessFile:read	([B)I
    //   146: istore_1
    //   147: iload_1
    //   148: iconst_m1
    //   149: if_icmpeq +60 -> 209
    //   152: aload 5
    //   154: aload_0
    //   155: iconst_0
    //   156: iload_1
    //   157: invokevirtual 73	java/security/MessageDigest:update	([BII)V
    //   160: goto -19 -> 141
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: aload_2
    //   167: astore_3
    //   168: aload_0
    //   169: astore_2
    //   170: ldc 28
    //   172: iconst_1
    //   173: new 30	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   180: ldc 75
    //   182: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_3
    //   186: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   189: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 78	java/io/RandomAccessFile:close	()V
    //   206: ldc 20
    //   208: areturn
    //   209: new 80	java/math/BigInteger
    //   212: dup
    //   213: iconst_1
    //   214: aload 5
    //   216: invokevirtual 84	java/security/MessageDigest:digest	()[B
    //   219: invokespecial 87	java/math/BigInteger:<init>	(I[B)V
    //   222: bipush 16
    //   224: invokevirtual 90	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 96	java/lang/String:length	()I
    //   232: bipush 32
    //   234: if_icmpge +26 -> 260
    //   237: new 30	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   244: ldc 98
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore_0
    //   257: goto -29 -> 228
    //   260: aload_0
    //   261: astore_2
    //   262: aload_3
    //   263: ifnull -230 -> 33
    //   266: aload_3
    //   267: invokevirtual 78	java/io/RandomAccessFile:close	()V
    //   270: aload_0
    //   271: areturn
    //   272: astore_2
    //   273: ldc 28
    //   275: iconst_1
    //   276: new 30	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   283: ldc 33
    //   285: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_2
    //   289: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   292: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_0
    //   302: areturn
    //   303: astore_0
    //   304: ldc 28
    //   306: iconst_1
    //   307: new 30	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   314: ldc 33
    //   316: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   323: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto -126 -> 206
    //   335: astore_0
    //   336: aload_2
    //   337: ifnull +7 -> 344
    //   340: aload_2
    //   341: invokevirtual 78	java/io/RandomAccessFile:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: astore_2
    //   347: ldc 28
    //   349: iconst_1
    //   350: new 30	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   357: ldc 33
    //   359: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_2
    //   363: invokestatic 43	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   366: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 51	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -31 -> 344
    //   378: astore_0
    //   379: aload_3
    //   380: astore_2
    //   381: goto -45 -> 336
    //   384: astore_3
    //   385: aload 4
    //   387: astore_0
    //   388: goto -220 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramFile	java.io.File
    //   146	11	1	i	int
    //   6	119	2	localObject1	Object
    //   163	4	2	localException1	java.lang.Exception
    //   169	93	2	localFile	java.io.File
    //   272	69	2	localIOException1	java.io.IOException
    //   346	17	2	localIOException2	java.io.IOException
    //   380	1	2	localObject2	Object
    //   1	379	3	localObject3	Object
    //   384	1	3	localException2	java.lang.Exception
    //   3	383	4	localObject4	Object
    //   12	203	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   25	33	35	java/io/IOException
    //   83	91	91	java/io/IOException
    //   136	141	163	java/lang/Exception
    //   141	147	163	java/lang/Exception
    //   152	160	163	java/lang/Exception
    //   209	228	163	java/lang/Exception
    //   228	257	163	java/lang/Exception
    //   266	270	272	java/io/IOException
    //   202	206	303	java/io/IOException
    //   7	14	335	finally
    //   69	76	335	finally
    //   125	136	335	finally
    //   170	198	335	finally
    //   340	344	346	java/io/IOException
    //   136	141	378	finally
    //   141	147	378	finally
    //   152	160	378	finally
    //   209	228	378	finally
    //   228	257	378	finally
    //   7	14	384	java/lang/Exception
    //   69	76	384	java/lang/Exception
    //   125	136	384	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */