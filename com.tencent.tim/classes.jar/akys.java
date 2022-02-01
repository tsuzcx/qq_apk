import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegDataDest;
import java.io.File;

final class akys
  implements JpegDataDest
{
  akys(File paramFile, CompressInfo paramCompressInfo) {}
  
  /* Error */
  public void dataArrived(java.nio.ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 26	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 14	akys:aE	Ljava/io/File;
    //   10: iconst_1
    //   11: invokespecial 29	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: invokevirtual 33	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 39	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   27: pop
    //   28: aload_3
    //   29: ifnull +53 -> 82
    //   32: iload_2
    //   33: ifeq +45 -> 78
    //   36: aload_3
    //   37: iconst_1
    //   38: invokevirtual 43	java/nio/channels/FileChannel:force	(Z)V
    //   41: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +34 -> 78
    //   47: ldc 51
    //   49: iconst_2
    //   50: new 53	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   57: ldc 56
    //   59: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 14	akys:aE	Ljava/io/File;
    //   66: invokevirtual 66	java/io/File:length	()J
    //   69: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_3
    //   79: invokevirtual 80	java/nio/channels/FileChannel:close	()V
    //   82: return
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   88: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq -13 -> 78
    //   94: ldc 51
    //   96: iconst_2
    //   97: aload_1
    //   98: invokevirtual 84	java/io/IOException:toString	()Ljava/lang/String;
    //   101: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: goto -26 -> 78
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   112: return
    //   113: astore_1
    //   114: aload_3
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 16	akys:c	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   120: ifnull +11 -> 131
    //   123: aload_0
    //   124: getfield 16	akys:c	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   127: iconst_1
    //   128: invokevirtual 89	com/tencent/mobileqq/pic/CompressInfo:Ns	(Z)V
    //   131: aload_1
    //   132: ifnull -50 -> 82
    //   135: iload_2
    //   136: ifeq +45 -> 181
    //   139: aload_1
    //   140: iconst_1
    //   141: invokevirtual 43	java/nio/channels/FileChannel:force	(Z)V
    //   144: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +34 -> 181
    //   150: ldc 51
    //   152: iconst_2
    //   153: new 53	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   160: ldc 56
    //   162: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_0
    //   166: getfield 14	akys:aE	Ljava/io/File;
    //   169: invokevirtual 66	java/io/File:length	()J
    //   172: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: invokevirtual 80	java/nio/channels/FileChannel:close	()V
    //   185: return
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   197: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq -19 -> 181
    //   203: ldc 51
    //   205: iconst_2
    //   206: aload_3
    //   207: invokevirtual 84	java/io/IOException:toString	()Ljava/lang/String;
    //   210: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -32 -> 181
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_3
    //   219: aload_3
    //   220: ifnull +53 -> 273
    //   223: iload_2
    //   224: ifeq +45 -> 269
    //   227: aload_3
    //   228: iconst_1
    //   229: invokevirtual 43	java/nio/channels/FileChannel:force	(Z)V
    //   232: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +34 -> 269
    //   238: ldc 51
    //   240: iconst_2
    //   241: new 53	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   248: ldc 56
    //   250: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_0
    //   254: getfield 14	akys:aE	Ljava/io/File;
    //   257: invokevirtual 66	java/io/File:length	()J
    //   260: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_3
    //   270: invokevirtual 80	java/nio/channels/FileChannel:close	()V
    //   273: aload_1
    //   274: athrow
    //   275: astore 4
    //   277: aload 4
    //   279: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   282: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -16 -> 269
    //   288: ldc 51
    //   290: iconst_2
    //   291: aload 4
    //   293: invokevirtual 84	java/io/IOException:toString	()Ljava/lang/String;
    //   296: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: goto -30 -> 269
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 83	java/io/IOException:printStackTrace	()V
    //   307: goto -34 -> 273
    //   310: astore_1
    //   311: goto -92 -> 219
    //   314: astore 4
    //   316: aload_1
    //   317: astore_3
    //   318: aload 4
    //   320: astore_1
    //   321: goto -102 -> 219
    //   324: astore_1
    //   325: aload_3
    //   326: astore_1
    //   327: goto -211 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	akys
    //   0	330	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	330	2	paramBoolean	boolean
    //   0	330	3	paramObject	Object
    //   17	3	4	localFileChannel	java.nio.channels.FileChannel
    //   275	17	4	localIOException	java.io.IOException
    //   314	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	78	83	java/io/IOException
    //   78	82	107	java/io/IOException
    //   2	19	113	java/io/IOException
    //   181	185	186	java/io/IOException
    //   139	181	192	java/io/IOException
    //   2	19	216	finally
    //   227	269	275	java/io/IOException
    //   269	273	302	java/io/IOException
    //   22	28	310	finally
    //   116	131	314	finally
    //   22	28	324	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */