package com.tencent.tim.cloudfile;

import atik;
import java.io.InputStream;

public class CloudUploadFileOption$1
  implements Runnable
{
  public CloudUploadFileOption$1(atik paramatik, String paramString1, InputStream paramInputStream, long paramLong, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 11
    //   15: new 36	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 21	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$path	Ljava/lang/String;
    //   23: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 12
    //   28: aload 12
    //   30: invokevirtual 43	java/io/File:exists	()Z
    //   33: ifne +38 -> 71
    //   36: aload 12
    //   38: invokevirtual 46	java/io/File:createNewFile	()Z
    //   41: istore 8
    //   43: iload 8
    //   45: ifne +26 -> 71
    //   48: iconst_0
    //   49: ifeq +10 -> 59
    //   52: invokestatic 52	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   55: aconst_null
    //   56: invokevirtual 56	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   59: aload_0
    //   60: getfield 23	com/tencent/tim/cloudfile/CloudUploadFileOption$1:b	Ljava/io/InputStream;
    //   63: invokestatic 62	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   66: aconst_null
    //   67: invokestatic 65	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   70: return
    //   71: new 67	java/io/FileOutputStream
    //   74: dup
    //   75: aload_0
    //   76: getfield 21	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$path	Ljava/lang/String;
    //   79: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 12
    //   84: aload 10
    //   86: astore 9
    //   88: aload 12
    //   90: astore 10
    //   92: aload 13
    //   94: astore 11
    //   96: invokestatic 52	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   99: sipush 8192
    //   102: invokevirtual 72	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   105: astore 13
    //   107: lconst_0
    //   108: lstore_2
    //   109: aload 13
    //   111: astore 9
    //   113: aload 12
    //   115: astore 10
    //   117: aload 13
    //   119: astore 11
    //   121: aload_0
    //   122: getfield 23	com/tencent/tim/cloudfile/CloudUploadFileOption$1:b	Ljava/io/InputStream;
    //   125: aload 13
    //   127: invokevirtual 78	java/io/InputStream:read	([B)I
    //   130: istore_1
    //   131: iload_1
    //   132: iconst_m1
    //   133: if_icmpeq +74 -> 207
    //   136: lload_2
    //   137: iload_1
    //   138: i2l
    //   139: ladd
    //   140: lstore 4
    //   142: aload 13
    //   144: astore 9
    //   146: aload 12
    //   148: astore 10
    //   150: aload 13
    //   152: astore 11
    //   154: aload 12
    //   156: aload 13
    //   158: iconst_0
    //   159: iload_1
    //   160: invokevirtual 82	java/io/FileOutputStream:write	([BII)V
    //   163: lload 4
    //   165: lstore_2
    //   166: aload 13
    //   168: astore 9
    //   170: aload 12
    //   172: astore 10
    //   174: aload 13
    //   176: astore 11
    //   178: lload 4
    //   180: lload 6
    //   182: lsub
    //   183: l2d
    //   184: aload_0
    //   185: getfield 25	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$fileSize	J
    //   188: l2d
    //   189: ddiv
    //   190: ldc2_w 83
    //   193: dcmpl
    //   194: ifle -85 -> 109
    //   197: lload 4
    //   199: lstore 6
    //   201: lload 4
    //   203: lstore_2
    //   204: goto -95 -> 109
    //   207: aload 13
    //   209: astore 9
    //   211: aload 12
    //   213: astore 10
    //   215: aload 13
    //   217: astore 11
    //   219: aload_0
    //   220: getfield 19	com/tencent/tim/cloudfile/CloudUploadFileOption$1:this$0	Latik;
    //   223: aload_0
    //   224: getfield 27	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$fileName	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 21	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$path	Ljava/lang/String;
    //   231: aload_0
    //   232: getfield 25	com/tencent/tim/cloudfile/CloudUploadFileOption$1:val$fileSize	J
    //   235: invokestatic 90	atik:a	(Latik;Ljava/lang/String;Ljava/lang/String;J)V
    //   238: aload 13
    //   240: ifnull +11 -> 251
    //   243: invokestatic 52	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   246: aload 13
    //   248: invokevirtual 56	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   251: aload_0
    //   252: getfield 23	com/tencent/tim/cloudfile/CloudUploadFileOption$1:b	Ljava/io/InputStream;
    //   255: invokestatic 62	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   258: aload 12
    //   260: invokestatic 65	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   263: return
    //   264: astore 13
    //   266: aconst_null
    //   267: astore 12
    //   269: aload 11
    //   271: astore 9
    //   273: aload 12
    //   275: astore 10
    //   277: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +21 -> 301
    //   283: aload 11
    //   285: astore 9
    //   287: aload 12
    //   289: astore 10
    //   291: ldc 97
    //   293: iconst_2
    //   294: ldc 99
    //   296: aload 13
    //   298: invokestatic 103	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload 11
    //   303: ifnull +11 -> 314
    //   306: invokestatic 52	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   309: aload 11
    //   311: invokevirtual 56	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   314: aload_0
    //   315: getfield 23	com/tencent/tim/cloudfile/CloudUploadFileOption$1:b	Ljava/io/InputStream;
    //   318: invokestatic 62	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   321: aload 12
    //   323: invokestatic 65	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   326: return
    //   327: astore 11
    //   329: aconst_null
    //   330: astore 10
    //   332: aload 9
    //   334: ifnull +11 -> 345
    //   337: invokestatic 52	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   340: aload 9
    //   342: invokevirtual 56	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   345: aload_0
    //   346: getfield 23	com/tencent/tim/cloudfile/CloudUploadFileOption$1:b	Ljava/io/InputStream;
    //   349: invokestatic 62	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   352: aload 10
    //   354: invokestatic 65	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   357: aload 11
    //   359: athrow
    //   360: astore 11
    //   362: goto -30 -> 332
    //   365: astore 13
    //   367: goto -98 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	1
    //   130	30	1	i	int
    //   108	96	2	l1	long
    //   140	62	4	l2	long
    //   1	199	6	l3	long
    //   41	3	8	bool	boolean
    //   4	337	9	localObject1	Object
    //   7	346	10	localObject2	Object
    //   13	297	11	arrayOfByte1	byte[]
    //   327	31	11	localObject3	Object
    //   360	1	11	localObject4	Object
    //   26	296	12	localObject5	Object
    //   10	237	13	arrayOfByte2	byte[]
    //   264	33	13	localException1	java.lang.Exception
    //   365	1	13	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	43	264	java/lang/Exception
    //   71	84	264	java/lang/Exception
    //   15	43	327	finally
    //   71	84	327	finally
    //   96	107	360	finally
    //   121	131	360	finally
    //   154	163	360	finally
    //   178	197	360	finally
    //   219	238	360	finally
    //   277	283	360	finally
    //   291	301	360	finally
    //   96	107	365	java/lang/Exception
    //   121	131	365	java/lang/Exception
    //   154	163	365	java/lang/Exception
    //   178	197	365	java/lang/Exception
    //   219	238	365	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudUploadFileOption.1
 * JD-Core Version:    0.7.0.1
 */