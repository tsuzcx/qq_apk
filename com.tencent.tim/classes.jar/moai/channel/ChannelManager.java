package moai.channel;

public class ChannelManager
{
  private static final int CHANNEL_MAGIC = 1297039689;
  private static final int EOCD_SIGN = 101010256;
  private static final String TAG = "ChannelManager";
  
  /* Error */
  public static int getChannel(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 23
    //   2: istore_1
    //   3: aload_0
    //   4: invokevirtual 29	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: aload_0
    //   8: invokevirtual 33	android/content/Context:getPackageName	()Ljava/lang/String;
    //   11: iconst_0
    //   12: invokevirtual 39	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   15: getfield 44	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   18: astore 8
    //   20: aload 8
    //   22: ifnonnull +21 -> 43
    //   25: ldc 23
    //   27: ireturn
    //   28: astore_0
    //   29: ldc 13
    //   31: ldc 46
    //   33: aload_0
    //   34: invokestatic 52	moai/channel/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   37: aconst_null
    //   38: astore 8
    //   40: goto -20 -> 20
    //   43: new 54	java/io/RandomAccessFile
    //   46: dup
    //   47: aload 8
    //   49: ldc 56
    //   51: invokespecial 59	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 7
    //   58: astore_0
    //   59: aload 7
    //   61: invokevirtual 63	java/io/RandomAccessFile:length	()J
    //   64: ldc2_w 64
    //   67: lsub
    //   68: lstore 4
    //   70: iload_1
    //   71: istore_2
    //   72: lload 4
    //   74: lconst_0
    //   75: lcmp
    //   76: iflt +84 -> 160
    //   79: aload 7
    //   81: astore_0
    //   82: aload 7
    //   84: lload 4
    //   86: invokevirtual 69	java/io/RandomAccessFile:seek	(J)V
    //   89: aload 7
    //   91: astore_0
    //   92: aload 7
    //   94: invokevirtual 73	java/io/RandomAccessFile:readInt	()I
    //   97: invokestatic 79	java/lang/Integer:reverseBytes	(I)I
    //   100: istore_3
    //   101: iload_3
    //   102: ldc 7
    //   104: if_icmpne +66 -> 170
    //   107: aload 7
    //   109: astore_0
    //   110: aload 7
    //   112: lload 4
    //   114: ldc2_w 80
    //   117: lsub
    //   118: invokevirtual 69	java/io/RandomAccessFile:seek	(J)V
    //   121: aload 7
    //   123: astore_0
    //   124: aload 7
    //   126: invokevirtual 85	java/io/RandomAccessFile:readShort	()S
    //   129: invokestatic 90	java/lang/Short:reverseBytes	(S)S
    //   132: istore_2
    //   133: aload 7
    //   135: astore_0
    //   136: ldc 13
    //   138: new 92	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   145: ldc 95
    //   147: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_2
    //   151: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 108	moai/channel/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 7
    //   162: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   165: iload_2
    //   166: ireturn
    //   167: astore_0
    //   168: iload_2
    //   169: ireturn
    //   170: iload_1
    //   171: istore_2
    //   172: iload_3
    //   173: ldc 9
    //   175: if_icmpeq -15 -> 160
    //   178: lload 4
    //   180: lconst_1
    //   181: lsub
    //   182: lstore 4
    //   184: goto -114 -> 70
    //   187: astore 6
    //   189: aconst_null
    //   190: astore 7
    //   192: aload 7
    //   194: astore_0
    //   195: ldc 13
    //   197: new 92	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   204: ldc 113
    //   206: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 8
    //   211: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 6
    //   219: invokestatic 52	moai/channel/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 7
    //   224: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   227: iload_1
    //   228: ireturn
    //   229: astore_0
    //   230: iload_1
    //   231: ireturn
    //   232: astore 6
    //   234: aconst_null
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   240: aload 6
    //   242: athrow
    //   243: astore_0
    //   244: goto -4 -> 240
    //   247: astore 6
    //   249: goto -13 -> 236
    //   252: astore 6
    //   254: goto -62 -> 192
    //   257: astore 6
    //   259: iload_2
    //   260: istore_1
    //   261: goto -69 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	android.content.Context
    //   2	259	1	i	int
    //   71	189	2	j	int
    //   100	76	3	k	int
    //   68	115	4	l	long
    //   187	31	6	localException1	java.lang.Exception
    //   232	9	6	localObject1	Object
    //   247	1	6	localObject2	Object
    //   252	1	6	localException2	java.lang.Exception
    //   257	1	6	localException3	java.lang.Exception
    //   54	169	7	localRandomAccessFile	java.io.RandomAccessFile
    //   18	192	8	str	String
    // Exception table:
    //   from	to	target	type
    //   3	20	28	java/lang/Exception
    //   160	165	167	java/lang/Exception
    //   43	56	187	java/lang/Exception
    //   222	227	229	java/lang/Exception
    //   43	56	232	finally
    //   236	240	243	java/lang/Exception
    //   59	70	247	finally
    //   82	89	247	finally
    //   92	101	247	finally
    //   110	121	247	finally
    //   124	133	247	finally
    //   136	160	247	finally
    //   195	222	247	finally
    //   59	70	252	java/lang/Exception
    //   82	89	252	java/lang/Exception
    //   92	101	252	java/lang/Exception
    //   110	121	252	java/lang/Exception
    //   124	133	252	java/lang/Exception
    //   136	160	257	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.channel.ChannelManager
 * JD-Core Version:    0.7.0.1
 */