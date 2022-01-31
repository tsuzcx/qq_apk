package com.tencent.mobileqq.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.entity.FileEntity;

public class DataLineHttpFileEntity
  extends FileEntity
{
  public static final String a = "dlFileTransfer.Server";
  private long jdField_a_of_type_Long;
  private HttpNotify jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = null;
  private File jdField_a_of_type_JavaIoFile;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[102400];
  private long b;
  
  public DataLineHttpFileEntity(File paramFile, long paramLong1, long paramLong2, String paramString, HttpNotify paramHttpNotify)
  {
    super(paramFile, paramString);
    this.jdField_a_of_type_ComTencentMobileqqServiceHttpNotify = paramHttpNotify;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.b = paramLong1;
  }
  
  public InputStream getContent()
  {
    FileInputStream localFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaIoFile);
    try
    {
      localFileInputStream.skip(this.b);
      return localFileInputStream;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public long getContentLength()
  {
    return this.jdField_a_of_type_JavaIoFile.length() - this.b;
  }
  
  /* Error */
  public void writeTo(java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +66 -> 67
    //   4: ldc 8
    //   6: iconst_2
    //   7: new 58	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   14: ldc 63
    //   16: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 27	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   23: invokevirtual 71	java/io/File:getName	()Ljava/lang/String;
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   39: ifnull +18 -> 57
    //   42: aload_0
    //   43: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   46: aload_0
    //   47: getfield 25	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_Long	J
    //   50: iconst_0
    //   51: lconst_0
    //   52: invokeinterface 85 6 0
    //   57: new 87	java/lang/IllegalArgumentException
    //   60: dup
    //   61: ldc 89
    //   63: invokespecial 92	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: new 36	java/io/FileInputStream
    //   70: dup
    //   71: aload_0
    //   72: getfield 95	com/tencent/mobileqq/service/DataLineHttpFileEntity:file	Ljava/io/File;
    //   75: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: astore 14
    //   80: aload_0
    //   81: getfield 29	com/tencent/mobileqq/service/DataLineHttpFileEntity:b	J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifle +13 -> 99
    //   89: aload 14
    //   91: aload_0
    //   92: getfield 29	com/tencent/mobileqq/service/DataLineHttpFileEntity:b	J
    //   95: invokevirtual 45	java/io/InputStream:skip	(J)J
    //   98: pop2
    //   99: aload_0
    //   100: getfield 95	com/tencent/mobileqq/service/DataLineHttpFileEntity:file	Ljava/io/File;
    //   103: invokevirtual 52	java/io/File:length	()J
    //   106: lstore 12
    //   108: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   111: ldc2_w 101
    //   114: ldiv
    //   115: lstore 8
    //   117: iconst_0
    //   118: istore_2
    //   119: lload 8
    //   121: lstore 4
    //   123: aload 14
    //   125: aload_0
    //   126: getfield 23	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ArrayOfByte	[B
    //   129: invokevirtual 106	java/io/InputStream:read	([B)I
    //   132: istore_3
    //   133: iload_3
    //   134: iconst_m1
    //   135: if_icmpeq +213 -> 348
    //   138: aload_1
    //   139: aload_0
    //   140: getfield 23	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ArrayOfByte	[B
    //   143: iconst_0
    //   144: iload_3
    //   145: invokevirtual 112	java/io/OutputStream:write	([BII)V
    //   148: invokestatic 118	java/lang/Thread:interrupted	()Z
    //   151: ifeq +74 -> 225
    //   154: new 120	java/lang/InterruptedException
    //   157: dup
    //   158: ldc 122
    //   160: invokespecial 123	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   163: athrow
    //   164: astore_1
    //   165: ldc 8
    //   167: iconst_2
    //   168: new 58	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   175: ldc 63
    //   177: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 27	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   184: invokevirtual 71	java/io/File:getName	()Ljava/lang/String;
    //   187: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   200: ifnull +19 -> 219
    //   203: aload_0
    //   204: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   207: aload_0
    //   208: getfield 25	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_Long	J
    //   211: iconst_0
    //   212: iload_2
    //   213: i2l
    //   214: invokeinterface 85 6 0
    //   219: aload 14
    //   221: invokevirtual 126	java/io/InputStream:close	()V
    //   224: return
    //   225: iload_2
    //   226: iload_3
    //   227: iadd
    //   228: istore_2
    //   229: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   232: ldc2_w 101
    //   235: ldiv
    //   236: lstore 10
    //   238: lload 4
    //   240: lstore 6
    //   242: lload 10
    //   244: lload 4
    //   246: lsub
    //   247: lconst_1
    //   248: lcmp
    //   249: iflt +92 -> 341
    //   252: ldc 8
    //   254: iconst_2
    //   255: new 58	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   262: ldc 128
    //   264: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 27	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   271: invokevirtual 71	java/io/File:getName	()Ljava/lang/String;
    //   274: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc 130
    //   279: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload_2
    //   283: i2f
    //   284: lload 10
    //   286: lload 8
    //   288: lsub
    //   289: l2f
    //   290: fdiv
    //   291: ldc 131
    //   293: fdiv
    //   294: invokevirtual 134	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   297: ldc 136
    //   299: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload_0
    //   309: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   312: ifnull +25 -> 337
    //   315: aload_0
    //   316: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   319: aload_0
    //   320: getfield 25	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_Long	J
    //   323: iload_2
    //   324: i2l
    //   325: aload_0
    //   326: getfield 29	com/tencent/mobileqq/service/DataLineHttpFileEntity:b	J
    //   329: ladd
    //   330: lload 12
    //   332: invokeinterface 139 7 0
    //   337: lload 10
    //   339: lstore 6
    //   341: lload 6
    //   343: lstore 4
    //   345: goto -222 -> 123
    //   348: aload_1
    //   349: invokevirtual 142	java/io/OutputStream:flush	()V
    //   352: aload_0
    //   353: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   356: ifnull +19 -> 375
    //   359: aload_0
    //   360: getfield 20	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_ComTencentMobileqqServiceHttpNotify	Lcom/tencent/mobileqq/service/HttpNotify;
    //   363: aload_0
    //   364: getfield 25	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_Long	J
    //   367: iconst_1
    //   368: iload_2
    //   369: i2l
    //   370: invokeinterface 85 6 0
    //   375: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   378: ldc2_w 101
    //   381: ldiv
    //   382: lstore 4
    //   384: ldc 8
    //   386: iconst_2
    //   387: new 58	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   394: ldc 144
    //   396: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_0
    //   400: getfield 27	com/tencent/mobileqq/service/DataLineHttpFileEntity:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   403: invokevirtual 71	java/io/File:getName	()Ljava/lang/String;
    //   406: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 146
    //   411: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: lload 4
    //   416: lload 8
    //   418: lsub
    //   419: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc 151
    //   424: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload 14
    //   435: invokevirtual 126	java/io/InputStream:close	()V
    //   438: return
    //   439: astore_1
    //   440: aload 14
    //   442: invokevirtual 126	java/io/InputStream:close	()V
    //   445: aload_1
    //   446: athrow
    //   447: astore_1
    //   448: iconst_0
    //   449: istore_2
    //   450: goto -285 -> 165
    //   453: astore_1
    //   454: goto -289 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	DataLineHttpFileEntity
    //   0	457	1	paramOutputStream	java.io.OutputStream
    //   118	332	2	i	int
    //   132	96	3	j	int
    //   121	294	4	l1	long
    //   240	102	6	l2	long
    //   115	302	8	l3	long
    //   236	102	10	l4	long
    //   106	225	12	l5	long
    //   78	363	14	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   123	133	164	java/lang/Exception
    //   138	164	164	java/lang/Exception
    //   348	375	164	java/lang/Exception
    //   375	433	164	java/lang/Exception
    //   80	99	439	finally
    //   99	117	439	finally
    //   123	133	439	finally
    //   138	164	439	finally
    //   165	219	439	finally
    //   229	238	439	finally
    //   252	337	439	finally
    //   348	375	439	finally
    //   375	433	439	finally
    //   80	99	447	java/lang/Exception
    //   99	117	447	java/lang/Exception
    //   229	238	453	java/lang/Exception
    //   252	337	453	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.DataLineHttpFileEntity
 * JD-Core Version:    0.7.0.1
 */