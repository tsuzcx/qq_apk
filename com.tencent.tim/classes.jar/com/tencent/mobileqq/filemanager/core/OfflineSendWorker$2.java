package com.tencent.mobileqq.filemanager.core;

import agll;

public class OfflineSendWorker$2
  implements Runnable
{
  public OfflineSendWorker$2(agll paramagll, String paramString, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 52
    //   13: iconst_1
    //   14: new 54	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   21: ldc 57
    //   23: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokestatic 67	anaz:gQ	()J
    //   29: invokevirtual 70	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   42: invokevirtual 83	agll:dhG	()V
    //   45: new 85	agzw
    //   48: dup
    //   49: invokespecial 86	agzw:<init>	()V
    //   52: astore 5
    //   54: aload 5
    //   56: aload_0
    //   57: getfield 23	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:Lw	Ljava/lang/String;
    //   60: putfield 89	agzw:bJz	Ljava/lang/String;
    //   63: aload 5
    //   65: aload_0
    //   66: getfield 25	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:val$fileSize	J
    //   69: putfield 92	agzw:fileSize	J
    //   72: aload 5
    //   74: aload_0
    //   75: getfield 27	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:bg	[B
    //   78: putfield 95	agzw:md5	[B
    //   81: aload 5
    //   83: aload_0
    //   84: getfield 29	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:dV	[B
    //   87: putfield 98	agzw:el	[B
    //   90: aload 5
    //   92: aload_0
    //   93: getfield 31	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:dW	[B
    //   96: putfield 101	agzw:ej	[B
    //   99: aload 5
    //   101: aload_0
    //   102: getfield 33	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:dX	[B
    //   105: putfield 104	agzw:ei	[B
    //   108: new 106	java/io/BufferedInputStream
    //   111: dup
    //   112: new 108	java/io/FileInputStream
    //   115: dup
    //   116: new 110	java/lang/String
    //   119: dup
    //   120: aload_0
    //   121: getfield 33	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:dX	[B
    //   124: invokespecial 113	java/lang/String:<init>	([B)V
    //   127: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 119	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_2
    //   134: sipush 10240
    //   137: newarray byte
    //   139: astore 6
    //   141: ldc 121
    //   143: invokestatic 127	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   146: astore 4
    //   148: aload 4
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   155: invokestatic 131	agll:a	(Lagll;)Z
    //   158: ifne +57 -> 215
    //   161: aload_2
    //   162: aload 6
    //   164: invokevirtual 137	java/io/InputStream:read	([B)I
    //   167: istore_1
    //   168: iload_1
    //   169: ifle +46 -> 215
    //   172: aload_3
    //   173: aload 6
    //   175: iconst_0
    //   176: iload_1
    //   177: invokevirtual 141	java/security/MessageDigest:update	([BII)V
    //   180: goto -29 -> 151
    //   183: astore_3
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 144	java/io/InputStream:close	()V
    //   192: return
    //   193: astore 4
    //   195: aload 4
    //   197: invokevirtual 147	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   200: goto -49 -> 151
    //   203: astore_3
    //   204: aload_2
    //   205: ifnull -13 -> 192
    //   208: aload_2
    //   209: invokevirtual 144	java/io/InputStream:close	()V
    //   212: return
    //   213: astore_2
    //   214: return
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 144	java/io/InputStream:close	()V
    //   223: aload_0
    //   224: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   227: invokestatic 131	agll:a	(Lagll;)Z
    //   230: ifne +16 -> 246
    //   233: aload_3
    //   234: ifnull +12 -> 246
    //   237: aload 5
    //   239: aload_3
    //   240: invokevirtual 151	java/security/MessageDigest:digest	()[B
    //   243: putfield 154	agzw:sha1	[B
    //   246: aload_0
    //   247: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   250: invokestatic 131	agll:a	(Lagll;)Z
    //   253: ifne +57 -> 310
    //   256: aload_0
    //   257: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   260: aload 5
    //   262: getfield 154	agzw:sha1	[B
    //   265: invokevirtual 157	agll:bd	([B)V
    //   268: aload_0
    //   269: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   272: getfield 161	agll:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:a	()Lagib;
    //   278: aload 5
    //   280: aload_0
    //   281: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   284: invokestatic 169	agll:a	(Lagll;)Lagie;
    //   287: aload_0
    //   288: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   291: getfield 173	agll:c	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   294: invokevirtual 179	agib:b	(Lagzw;Lagie;Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   297: aload_0
    //   298: getfield 21	com/tencent/mobileqq/filemanager/core/OfflineSendWorker$2:this$0	Lagll;
    //   301: iconst_1
    //   302: aload 5
    //   304: getfield 154	agzw:sha1	[B
    //   307: invokevirtual 182	agll:b	(Z[B)V
    //   310: aload_2
    //   311: ifnull -119 -> 192
    //   314: aload_2
    //   315: invokevirtual 144	java/io/InputStream:close	()V
    //   318: return
    //   319: astore_2
    //   320: return
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_2
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 144	java/io/InputStream:close	()V
    //   332: aload_3
    //   333: athrow
    //   334: astore 4
    //   336: goto -113 -> 223
    //   339: astore_2
    //   340: return
    //   341: astore_2
    //   342: goto -10 -> 332
    //   345: astore_3
    //   346: goto -22 -> 324
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_2
    //   352: goto -148 -> 204
    //   355: astore_2
    //   356: aload 4
    //   358: astore_2
    //   359: goto -175 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	2
    //   167	10	1	i	int
    //   133	76	2	localBufferedInputStream	java.io.BufferedInputStream
    //   213	102	2	localIOException1	java.io.IOException
    //   319	1	2	localIOException2	java.io.IOException
    //   323	6	2	localObject1	Object
    //   339	1	2	localIOException3	java.io.IOException
    //   341	1	2	localIOException4	java.io.IOException
    //   349	1	2	localIOException5	java.io.IOException
    //   351	1	2	localObject2	Object
    //   355	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   358	1	2	localIOException6	java.io.IOException
    //   4	169	3	localMessageDigest1	java.security.MessageDigest
    //   183	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   203	37	3	localIOException7	java.io.IOException
    //   321	12	3	localObject3	Object
    //   345	1	3	localObject4	Object
    //   1	148	4	localMessageDigest2	java.security.MessageDigest
    //   193	3	4	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   334	23	4	localIOException8	java.io.IOException
    //   52	251	5	localagzw	agzw
    //   139	35	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	141	183	java/io/FileNotFoundException
    //   141	148	183	java/io/FileNotFoundException
    //   151	168	183	java/io/FileNotFoundException
    //   172	180	183	java/io/FileNotFoundException
    //   195	200	183	java/io/FileNotFoundException
    //   219	223	183	java/io/FileNotFoundException
    //   223	233	183	java/io/FileNotFoundException
    //   237	246	183	java/io/FileNotFoundException
    //   246	310	183	java/io/FileNotFoundException
    //   141	148	193	java/security/NoSuchAlgorithmException
    //   134	141	203	java/io/IOException
    //   141	148	203	java/io/IOException
    //   151	168	203	java/io/IOException
    //   172	180	203	java/io/IOException
    //   195	200	203	java/io/IOException
    //   223	233	203	java/io/IOException
    //   237	246	203	java/io/IOException
    //   246	310	203	java/io/IOException
    //   208	212	213	java/io/IOException
    //   314	318	319	java/io/IOException
    //   108	134	321	finally
    //   219	223	334	java/io/IOException
    //   188	192	339	java/io/IOException
    //   328	332	341	java/io/IOException
    //   134	141	345	finally
    //   141	148	345	finally
    //   151	168	345	finally
    //   172	180	345	finally
    //   195	200	345	finally
    //   219	223	345	finally
    //   223	233	345	finally
    //   237	246	345	finally
    //   246	310	345	finally
    //   108	134	349	java/io/IOException
    //   108	134	355	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.2
 * JD-Core Version:    0.7.0.1
 */