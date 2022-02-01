package com.tencent.beacon.base.net.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class a
{
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramInt == 1) {
      return d(paramArrayOfByte);
    }
    if (paramInt == 2) {
      return a(paramArrayOfByte);
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.finish();
    localGZIPOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramInt == 1) {
      return c(paramArrayOfByte);
    }
    if (paramInt == 2) {
      return b(paramArrayOfByte);
    }
    return null;
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: new 50	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 52	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_2
    //   15: new 54	java/util/zip/GZIPInputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 57	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_3
    //   24: sipush 1024
    //   27: newarray byte
    //   29: astore 4
    //   31: new 18	java/io/ByteArrayOutputStream
    //   34: dup
    //   35: invokespecial 22	java/io/ByteArrayOutputStream:<init>	()V
    //   38: astore 5
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: aload 4
    //   46: arraylength
    //   47: invokevirtual 61	java/util/zip/GZIPInputStream:read	([BII)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +124 -> 177
    //   56: aload 5
    //   58: aload 4
    //   60: iconst_0
    //   61: iload_1
    //   62: invokevirtual 64	java/io/ByteArrayOutputStream:write	([BII)V
    //   65: goto -25 -> 40
    //   68: astore 6
    //   70: aconst_null
    //   71: astore 4
    //   73: invokestatic 69	com/tencent/beacon/a/b/d:b	()Lcom/tencent/beacon/a/b/d;
    //   76: astore 7
    //   78: new 71	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   85: astore 8
    //   87: aload 7
    //   89: ldc 74
    //   91: aload 8
    //   93: ldc 76
    //   95: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: arraylength
    //   100: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload 6
    //   108: invokevirtual 90	com/tencent/beacon/a/b/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload 6
    //   113: invokestatic 95	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   116: new 71	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   123: astore_0
    //   124: aload_0
    //   125: ldc 97
    //   127: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 6
    //   132: invokevirtual 98	java/lang/Exception:toString	()Ljava/lang/String;
    //   135: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: iconst_0
    //   142: anewarray 4	java/lang/Object
    //   145: invokestatic 101	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 102	java/util/zip/GZIPInputStream:close	()V
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   174: aload 4
    //   176: areturn
    //   177: aload 5
    //   179: invokevirtual 41	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   182: astore 4
    //   184: aload 5
    //   186: invokevirtual 106	java/io/ByteArrayOutputStream:flush	()V
    //   189: aload 5
    //   191: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   194: aload_3
    //   195: invokevirtual 102	java/util/zip/GZIPInputStream:close	()V
    //   198: aload_2
    //   199: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   202: aload 4
    //   204: areturn
    //   205: astore 6
    //   207: goto -134 -> 73
    //   210: astore_0
    //   211: aload_3
    //   212: astore 4
    //   214: aload_0
    //   215: astore_3
    //   216: aload 5
    //   218: astore_0
    //   219: aload_0
    //   220: ifnull +7 -> 227
    //   223: aload_0
    //   224: invokevirtual 42	java/io/ByteArrayOutputStream:close	()V
    //   227: aload 4
    //   229: ifnull +8 -> 237
    //   232: aload 4
    //   234: invokevirtual 102	java/util/zip/GZIPInputStream:close	()V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 103	java/io/ByteArrayInputStream:close	()V
    //   245: aload_3
    //   246: athrow
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_0
    //   251: aload_3
    //   252: astore 4
    //   254: aload 5
    //   256: astore_3
    //   257: goto -38 -> 219
    //   260: astore 6
    //   262: aconst_null
    //   263: astore 5
    //   265: aconst_null
    //   266: astore 4
    //   268: goto -195 -> 73
    //   271: astore_3
    //   272: aconst_null
    //   273: astore_0
    //   274: goto -55 -> 219
    //   277: astore 6
    //   279: aconst_null
    //   280: astore 5
    //   282: aconst_null
    //   283: astore 4
    //   285: aload 7
    //   287: astore_3
    //   288: goto -215 -> 73
    //   291: astore_3
    //   292: aconst_null
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_0
    //   296: goto -77 -> 219
    //   299: astore 6
    //   301: aconst_null
    //   302: astore 5
    //   304: aconst_null
    //   305: astore_2
    //   306: aconst_null
    //   307: astore 4
    //   309: aload 7
    //   311: astore_3
    //   312: goto -239 -> 73
    //   315: astore 6
    //   317: aload 5
    //   319: astore_0
    //   320: aload_3
    //   321: astore 4
    //   323: aload 6
    //   325: astore_3
    //   326: goto -107 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramArrayOfByte	byte[]
    //   50	12	1	i	int
    //   14	292	2	localByteArrayInputStream	ByteArrayInputStream
    //   23	234	3	localObject1	Object
    //   271	1	3	localObject2	Object
    //   287	1	3	locald1	com.tencent.beacon.a.b.d
    //   291	1	3	localObject3	Object
    //   311	15	3	localObject4	Object
    //   1	321	4	localObject5	Object
    //   38	179	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   247	8	5	localObject6	Object
    //   263	55	5	localObject7	Object
    //   68	63	6	localException1	Exception
    //   205	1	6	localException2	Exception
    //   260	1	6	localException3	Exception
    //   277	1	6	localException4	Exception
    //   299	1	6	localException5	Exception
    //   315	9	6	localObject8	Object
    //   4	306	7	locald2	com.tencent.beacon.a.b.d
    //   85	7	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   40	51	68	java/lang/Exception
    //   56	65	68	java/lang/Exception
    //   177	184	68	java/lang/Exception
    //   184	189	205	java/lang/Exception
    //   40	51	210	finally
    //   56	65	210	finally
    //   177	184	210	finally
    //   184	189	210	finally
    //   24	40	247	finally
    //   24	40	260	java/lang/Exception
    //   15	24	271	finally
    //   15	24	277	java/lang/Exception
    //   6	15	291	finally
    //   6	15	299	java/lang/Exception
    //   73	78	315	finally
    //   78	87	315	finally
    //   87	124	315	finally
    //   124	148	315	finally
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ZipInputStream localZipInputStream = new ZipInputStream(localByteArrayInputStream);
    paramArrayOfByte = localByteArrayOutputStream;
    while (localZipInputStream.getNextEntry() != null)
    {
      paramArrayOfByte = new byte[1024];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
    }
    localZipInputStream.close();
    localByteArrayInputStream.close();
    return paramArrayOfByte;
  }
  
  private static byte[] d(byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
    ZipEntry localZipEntry = new ZipEntry("zip");
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipOutputStream.putNextEntry(localZipEntry);
    localZipOutputStream.write(paramArrayOfByte);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.a
 * JD-Core Version:    0.7.0.1
 */