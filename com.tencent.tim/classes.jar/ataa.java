import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier;
import com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier.SignatureNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipException;

public final class ataa
{
  private static final ataf a = new ataf(84298576L);
  private static final ataf b = new ataf(50613072L);
  private static final ataf c = new ataf(101010256L);
  private static int eox;
  
  private static String H(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(paramArrayOfByte[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "empty";
  }
  
  private static byte[] N(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return localObject;
        localObject = ByteBuffer.wrap(paramArrayOfByte);
        arrayOfByte = new byte[a.getBytes().length];
        ((ByteBuffer)localObject).get(arrayOfByte);
        localObject = paramArrayOfByte;
      } while (a.equals(new ataf(arrayOfByte)));
      localObject = paramArrayOfByte;
    } while (b.equals(new ataf(arrayOfByte)));
    Object localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(b.getBytes());
    ((ByteArrayOutputStream)localObject).write(new atag(paramArrayOfByte.length).getBytes());
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static Pair<ByteBuffer, Long> a(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfByte)
    throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException, UnsupportedEncodingException
  {
    ApkSignatureSchemeV2Verifier.b(paramByteBuffer);
    ByteBuffer localByteBuffer1 = ApkSignatureSchemeV2Verifier.b(paramByteBuffer, 8, paramByteBuffer.capacity() - 24);
    int j = paramArrayOfByte.length + 12;
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(paramByteBuffer.capacity() + j);
    localByteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer2.position(8);
    int i = 0;
    long l1;
    int k;
    int m;
    int n;
    if (localByteBuffer1.hasRemaining())
    {
      i += 1;
      if (localByteBuffer1.remaining() < 8) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      l1 = localByteBuffer1.getLong();
      if ((l1 < 4L) || (l1 > 2147483647L)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + l1);
      }
      k = (int)l1;
      m = localByteBuffer1.position() + k;
      if (k > localByteBuffer1.remaining()) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + k + ", available: " + localByteBuffer1.remaining());
      }
      n = localByteBuffer1.getInt();
      if (n == paramInt)
      {
        l1 = paramArrayOfByte.length + 4 - k;
        localByteBuffer2.putLong(paramArrayOfByte.length + 4);
        localByteBuffer2.putInt(n);
        localByteBuffer2.put(paramArrayOfByte);
        localByteBuffer1.position(m);
        localByteBuffer2.put(localByteBuffer1.array(), localByteBuffer1.arrayOffset(), localByteBuffer1.remaining());
        localByteBuffer1.position(localByteBuffer1.limit());
      }
    }
    for (;;)
    {
      long l2 = l1;
      if (l1 == 0L)
      {
        localByteBuffer2.putLong(paramArrayOfByte.length + 4);
        localByteBuffer2.putInt(paramInt);
        localByteBuffer2.put(paramArrayOfByte);
        l2 = j;
      }
      l1 = paramByteBuffer.getLong() + l2;
      localByteBuffer2.putLong(l1);
      localByteBuffer2.put(paramByteBuffer.array(), paramByteBuffer.array().length - 16, 16);
      localByteBuffer2.position(0);
      localByteBuffer2.putLong(l1);
      localByteBuffer2.position(0);
      localByteBuffer2.limit((int)l1 + 8);
      return Pair.create(localByteBuffer2, Long.valueOf(l2));
      localByteBuffer2.putLong(l1);
      localByteBuffer2.putInt(n);
      localByteBuffer2.put(ApkSignatureSchemeV2Verifier.c(localByteBuffer1, k - 4));
      localByteBuffer1.position(m);
      break;
      l1 = 0L;
    }
  }
  
  private static ByteBuffer a(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    return localByteBuffer;
  }
  
  public static byte[] b(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    int k = 0;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = c.getBytes();
    for (int i = paramRandomAccessFile.read();; i = paramRandomAccessFile.read())
    {
      int j = k;
      if (i != -1)
      {
        if ((i == arrayOfByte[0]) && (paramRandomAccessFile.read() == arrayOfByte[1]) && (paramRandomAccessFile.read() == arrayOfByte[2]) && (paramRandomAccessFile.read() == arrayOfByte[3])) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.e("ApkExternalInfoTool", 1, "archive is not a ZIP archive");
        throw new ZipException("archive is not a ZIP archive");
      }
      l -= 1L;
      paramRandomAccessFile.seek(l);
    }
    paramRandomAccessFile.seek(l + 16L + 4L);
    if (eox != l + 16L + 4L) {
      eox = (int)(l + 16L + 4L);
    }
    arrayOfByte = new byte[2];
    paramRandomAccessFile.readFully(arrayOfByte);
    QLog.d("ApkExternalInfoTool", 1, "readComment:length bytes data = " + H(arrayOfByte));
    i = new atag(arrayOfByte).getValue();
    if (i == 0) {
      return null;
    }
    arrayOfByte = new byte[i];
    paramRandomAccessFile.read(arrayOfByte);
    return arrayOfByte;
  }
  
  private static byte[] c(String paramString, int paramInt)
    throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    ByteBuffer localByteBuffer;
    long l;
    try
    {
      paramString = new RandomAccessFile(paramString, "r");
      localObject = ApkSignatureSchemeV2Verifier.a(paramString);
      localByteBuffer = (ByteBuffer)((Pair)localObject).first;
      l = ((Long)((Pair)localObject).second).longValue();
      if (atah.b(paramString, l)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    paramString = ApkSignatureSchemeV2Verifier.d((ByteBuffer)ApkSignatureSchemeV2Verifier.a(paramString, ApkSignatureSchemeV2Verifier.b(localByteBuffer, l)).first, paramInt);
    Object localObject = new byte[paramString.remaining()];
    paramString.get((byte[])localObject, 0, localObject.length);
    return localObject;
  }
  
  private static void d(String paramString, int paramInt, byte[] paramArrayOfByte)
    throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException
  {
    try
    {
      paramString = new RandomAccessFile(paramString, "rw");
      localObject1 = ApkSignatureSchemeV2Verifier.a(paramString);
      localByteBuffer1 = (ByteBuffer)((Pair)localObject1).first;
      l2 = ((Long)((Pair)localObject1).second).longValue();
      if (atah.b(paramString, l2)) {
        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
      }
    }
    catch (FileNotFoundException paramString)
    {
      Object localObject1;
      ByteBuffer localByteBuffer1;
      long l2;
      paramString.printStackTrace();
      long l3;
      do
      {
        return;
        long l1 = ApkSignatureSchemeV2Verifier.b(localByteBuffer1, l2);
        localObject1 = a(paramString, l1, (int)(l2 - l1));
        Object localObject2 = ApkSignatureSchemeV2Verifier.a(paramString, l1);
        ByteBuffer localByteBuffer2 = (ByteBuffer)((Pair)localObject2).first;
        l2 = ((Long)((Pair)localObject2).second).longValue();
        paramArrayOfByte = a(localByteBuffer2, paramInt, paramArrayOfByte);
        localObject2 = (ByteBuffer)paramArrayOfByte.first;
        l3 = ((Long)paramArrayOfByte.second).longValue();
        atah.d(localByteBuffer1, l1 + l3);
        paramString.seek(l2);
        paramString.write(((ByteBuffer)localObject2).array(), ((ByteBuffer)localObject2).arrayOffset() + ((ByteBuffer)localObject2).position(), ((ByteBuffer)localObject2).remaining());
        paramString.write(((ByteBuffer)localObject1).array(), ((ByteBuffer)localObject1).arrayOffset() + ((ByteBuffer)localObject1).position(), ((ByteBuffer)localObject1).remaining());
        paramString.write(localByteBuffer1.array(), localByteBuffer1.arrayOffset() + localByteBuffer1.position(), localByteBuffer1.remaining());
      } while (l3 >= 0L);
      paramString.setLength(paramString.length() + l3);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void h(File paramFile, String paramString)
    throws IOException
  {
    if (ApkSignatureSchemeV2Verifier.sT(paramFile.getAbsolutePath()))
    {
      j(paramFile, paramString);
      return;
    }
    i(paramFile, paramString);
  }
  
  private static void i(File paramFile, String paramString)
    throws IOException
  {
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      ataa.a locala;
      int i;
      if (paramString == null) {
        break label157;
      }
    }
    finally
    {
      try
      {
        paramFile = N(b(localRandomAccessFile));
        locala = new ataa.a(null);
        locala.decode(paramFile);
        locala.d.setProperty("apkSecurityCode", paramString);
        paramFile = locala.encode();
        localRandomAccessFile.seek(eox);
        localRandomAccessFile.write(new atag(paramFile.length).getBytes());
        localRandomAccessFile.write(paramFile);
        i = eox;
        localRandomAccessFile.setLength(paramFile.length + i + 2);
        QLog.d("ApkExternalInfoTool", 1, "file length is = " + localRandomAccessFile.length());
        if (localRandomAccessFile != null) {
          localRandomAccessFile.close();
        }
        QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
        return;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        paramString = localRandomAccessFile;
      }
      paramFile = finally;
      paramString = null;
    }
    paramString.close();
    label157:
    QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
    throw paramFile;
  }
  
  private static void j(File paramFile, String paramString)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = N(c(paramFile.getAbsolutePath(), 2036624993));
      ataa.a locala = new ataa.a(null);
      locala.decode(arrayOfByte);
      locala.d.setProperty("apkSecurityCode", paramString);
      paramString = locala.encode();
      d(paramFile.getAbsolutePath(), 2036624993, paramString);
      return;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  /* Error */
  public static String z(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: ldc 229
    //   2: iconst_1
    //   3: ldc_w 384
    //   6: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 229
    //   17: iconst_1
    //   18: new 37	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 386
    //   28: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokevirtual 389	java/io/File:getName	()Ljava/lang/String;
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 329	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokestatic 333	com/tencent/securitysdk/utils/ApkSignatureSchemeV2Verifier:sT	(Ljava/lang/String;)Z
    //   51: ifeq +218 -> 269
    //   54: aload_0
    //   55: invokevirtual 329	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: ldc_w 376
    //   61: invokestatic 378	ataa:c	(Ljava/lang/String;I)[B
    //   64: astore_1
    //   65: aload_1
    //   66: ifnonnull +194 -> 260
    //   69: new 211	java/io/RandomAccessFile
    //   72: dup
    //   73: aload_0
    //   74: ldc_w 265
    //   77: invokespecial 341	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: aload_1
    //   84: astore_2
    //   85: aload_1
    //   86: invokestatic 343	ataa:b	(Ljava/io/RandomAccessFile;)[B
    //   89: astore_3
    //   90: aload_3
    //   91: ifnonnull +48 -> 139
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: astore_2
    //   98: ldc 229
    //   100: iconst_1
    //   101: ldc_w 391
    //   104: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_1
    //   108: astore_0
    //   109: aload_1
    //   110: astore_2
    //   111: ldc 229
    //   113: iconst_1
    //   114: ldc_w 393
    //   117: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 371	java/io/RandomAccessFile:close	()V
    //   128: ldc 229
    //   130: iconst_1
    //   131: ldc_w 395
    //   134: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aconst_null
    //   138: areturn
    //   139: aload_1
    //   140: astore_0
    //   141: aload_1
    //   142: astore_2
    //   143: new 6	ataa$a
    //   146: dup
    //   147: aconst_null
    //   148: invokespecial 348	ataa$a:<init>	(Latab;)V
    //   151: astore 4
    //   153: aload_1
    //   154: astore_0
    //   155: aload_1
    //   156: astore_2
    //   157: aload 4
    //   159: aload_3
    //   160: invokevirtual 351	ataa$a:decode	([B)V
    //   163: aload_1
    //   164: astore_0
    //   165: aload_1
    //   166: astore_2
    //   167: aload 4
    //   169: getfield 354	ataa$a:d	Ljava/util/Properties;
    //   172: ldc_w 356
    //   175: invokevirtual 399	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 371	java/io/RandomAccessFile:close	()V
    //   187: ldc 229
    //   189: iconst_1
    //   190: ldc_w 395
    //   193: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_3
    //   197: areturn
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_2
    //   201: aload_2
    //   202: astore_0
    //   203: aload_1
    //   204: invokevirtual 291	java/lang/Throwable:printStackTrace	()V
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 371	java/io/RandomAccessFile:close	()V
    //   215: ldc 229
    //   217: iconst_1
    //   218: ldc_w 395
    //   221: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_2
    //   229: aload_0
    //   230: astore_1
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 371	java/io/RandomAccessFile:close	()V
    //   239: ldc 229
    //   241: iconst_1
    //   242: ldc_w 395
    //   245: invokestatic 375	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: aload_1
    //   249: athrow
    //   250: astore_1
    //   251: aload_0
    //   252: astore_2
    //   253: goto -22 -> 231
    //   256: astore_1
    //   257: goto -56 -> 201
    //   260: aconst_null
    //   261: astore_0
    //   262: aload_1
    //   263: astore_3
    //   264: aload_0
    //   265: astore_1
    //   266: goto -176 -> 90
    //   269: aconst_null
    //   270: astore_1
    //   271: goto -206 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramFile	File
    //   64	120	1	localObject1	Object
    //   198	6	1	localThrowable1	Throwable
    //   230	19	1	localFile1	File
    //   250	1	1	localObject2	Object
    //   256	7	1	localThrowable2	Throwable
    //   265	6	1	localFile2	File
    //   84	169	2	localObject3	Object
    //   89	175	3	localObject4	Object
    //   151	17	4	locala	ataa.a
    // Exception table:
    //   from	to	target	type
    //   44	65	198	java/lang/Throwable
    //   69	81	198	java/lang/Throwable
    //   44	65	226	finally
    //   69	81	226	finally
    //   85	90	250	finally
    //   98	107	250	finally
    //   111	120	250	finally
    //   143	153	250	finally
    //   157	163	250	finally
    //   167	179	250	finally
    //   203	207	250	finally
    //   85	90	256	java/lang/Throwable
    //   98	107	256	java/lang/Throwable
    //   111	120	256	java/lang/Throwable
    //   143	153	256	java/lang/Throwable
    //   157	163	256	java/lang/Throwable
    //   167	179	256	java/lang/Throwable
  }
  
  static class a
  {
    Properties d = new Properties();
    byte[] hC;
    
    void decode(byte[] paramArrayOfByte)
      throws IOException
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
      ByteBuffer localByteBuffer;
      int i;
      byte[] arrayOfByte;
      int j;
      do
      {
        do
        {
          return;
          localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
          i = ataa.a().getBytes().length;
          arrayOfByte = new byte[i];
          localByteBuffer.get(arrayOfByte);
          if (!ataa.a().equals(new ataf(arrayOfByte))) {
            break;
          }
          if (paramArrayOfByte.length - i <= 2)
          {
            QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength <= 2");
            return;
          }
          arrayOfByte = new byte[2];
          localByteBuffer.get(arrayOfByte);
          j = new atag(arrayOfByte).getValue();
          if (paramArrayOfByte.length - i - 2 < j)
          {
            QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength - 2 < len");
            QLog.i("ApkExternalInfoTool", 1, "exit");
            return;
          }
          arrayOfByte = new byte[j];
          localByteBuffer.get(arrayOfByte);
          this.d.load(new ByteArrayInputStream(arrayOfByte));
          i = paramArrayOfByte.length - i - j - 2;
        } while (i <= 0);
        j = ataa.b().getBytes().length;
        paramArrayOfByte = new byte[j];
        localByteBuffer.get(paramArrayOfByte);
      } while (!ataa.b().equals(new ataf(paramArrayOfByte)));
      if (i - j <= 2)
      {
        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
        return;
      }
      paramArrayOfByte = new byte[2];
      localByteBuffer.get(paramArrayOfByte);
      int k = new atag(paramArrayOfByte).getValue();
      if (i - j - 2 < k)
      {
        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
        QLog.i("ApkExternalInfoTool", 1, "exit");
        return;
      }
      this.hC = new byte[k];
      localByteBuffer.get(this.hC);
      return;
      if (ataa.b().equals(new ataf(arrayOfByte)))
      {
        j = ataa.b().getBytes().length;
        if (paramArrayOfByte.length - i <= 2)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
          return;
        }
        arrayOfByte = new byte[2];
        localByteBuffer.get(arrayOfByte);
        i = new atag(arrayOfByte).getValue();
        if (paramArrayOfByte.length - j - 2 < i)
        {
          QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
          QLog.i("ApkExternalInfoTool", 1, "exit");
          return;
        }
        this.hC = new byte[i];
        localByteBuffer.get(this.hC);
        return;
      }
      throw new ProtocolException("unknow protocl [" + Arrays.toString(paramArrayOfByte) + "]");
    }
    
    byte[] encode()
      throws IOException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      if (this.d.size() > 0)
      {
        localByteArrayOutputStream.write(ataa.a().getBytes());
        Iterator localIterator = this.d.keySet().iterator();
        Object localObject2;
        for (Object localObject1 = ""; localIterator.hasNext(); localObject1 = (String)localObject1 + localObject2 + "=" + this.d.getProperty((String)localObject2) + "\r\n") {
          localObject2 = localIterator.next();
        }
        localObject1 = ((String)localObject1).getBytes();
        localByteArrayOutputStream.write(new atag(localObject1.length).getBytes());
        localByteArrayOutputStream.write((byte[])localObject1);
      }
      if ((this.hC != null) && (this.hC.length > 0))
      {
        localByteArrayOutputStream.write(ataa.b().getBytes());
        localByteArrayOutputStream.write(new atag(this.hC.length).getBytes());
        localByteArrayOutputStream.write(this.hC);
      }
      return localByteArrayOutputStream.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ataa
 * JD-Core Version:    0.7.0.1
 */