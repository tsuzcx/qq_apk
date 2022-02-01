package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;
import java.util.Timer;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ai
{
  public String a = "";
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static <T> T a(T paramT1, T paramT2)
  {
    a(paramT2);
    if (paramT1 == null) {
      return paramT2;
    }
    return paramT1;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = ac.a(b(paramString, paramString.length));
      return paramString;
    }
    catch (Throwable paramString)
    {
      a("Encrypt2Util", "enc aes base64 error.", paramString);
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance(paramString);
      ((MessageDigest)localObject).update(paramArrayOfByte);
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        localObject = Integer.toHexString(arrayOfByte[i] & 0xFF);
        paramArrayOfByte = (byte[])localObject;
        if (((String)localObject).length() != 2) {
          paramArrayOfByte = "0".concat(String.valueOf(localObject));
        }
        localStringBuilder.append(paramArrayOfByte).append("");
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (a()) {
        a("MessageDigestUtil", "getMessageDigest[" + paramString + "] error.", paramArrayOfByte);
      }
    }
    return "";
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, paramInt, paramString2, paramThrowable);
    if (u.a() != null) {
      u.a();
    }
  }
  
  static void a(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 18)
        {
          paramHandlerThread.quitSafely();
          return;
        }
        paramHandlerThread.quit();
        return;
      }
      catch (Throwable paramHandlerThread)
      {
        if (a()) {
          a("HandlerThreadUtil", "quit error.", paramHandlerThread);
        }
      }
    }
  }
  
  public static void a(HandlerThread paramHandlerThread, Handler paramHandler, long paramLong)
  {
    if ((paramHandlerThread == null) && (paramHandler == null)) {
      return;
    }
    if (paramLong <= 0L)
    {
      a(paramHandlerThread);
      return;
    }
    Timer localTimer = new Timer("th_loc_tmp");
    localTimer.schedule(new ai.1(paramHandlerThread, paramHandler, localTimer), paramLong);
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("object is null.");
    }
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (u.c()) {
      if (paramThrowable != null) {
        break label18;
      }
    }
    for (;;)
    {
      Log.println(paramInt, paramString1, paramString2);
      return;
      label18:
      paramString2 = paramString2 + ". exception: " + Log.getStackTraceString(paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        a(6, paramString1, paramString2, paramThrowable);
        return;
      }
      catch (Throwable paramThrowable)
      {
        if ((!(paramThrowable instanceof OutOfMemoryError)) && (a()))
        {
          paramString1 = "LogUtil";
          paramString2 = "";
        }
      }
    }
  }
  
  public static boolean a()
  {
    return (u.c()) || (u.a() != null);
  }
  
  private static boolean a(Handler paramHandler)
  {
    if (paramHandler == null) {}
    for (paramHandler = null; (paramHandler != null) && (paramHandler.getThread().isAlive()); paramHandler = paramHandler.getLooper()) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    if (paramHandler == null) {}
    for (Message localMessage = null;; localMessage = paramHandler.obtainMessage(paramInt)) {
      return a(paramHandler, localMessage, paramLong);
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    if ((paramMessage != null) && (a(paramHandler))) {
      return paramHandler.sendMessageDelayed(paramMessage, paramLong);
    }
    return false;
  }
  
  public static boolean a(Handler paramHandler, Runnable paramRunnable)
  {
    if ((paramRunnable != null) && (a(paramHandler))) {
      return paramHandler.postDelayed(paramRunnable, 0L);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 222	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: iload_2
    //   6: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   9: astore_3
    //   10: aload_3
    //   11: astore_0
    //   12: aload_3
    //   13: aload_1
    //   14: invokevirtual 228	java/io/FileOutputStream:write	([B)V
    //   17: aload_3
    //   18: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   21: iconst_1
    //   22: ireturn
    //   23: astore 4
    //   25: aconst_null
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: ldc 235
    //   31: ldc 237
    //   33: aload 4
    //   35: invokestatic 53	c/t/m/g/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   38: aload_1
    //   39: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   42: iconst_0
    //   43: ireturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_0
    //   47: aload_0
    //   48: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: goto -7 -> 47
    //   57: astore 4
    //   59: aload_3
    //   60: astore_1
    //   61: goto -34 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramFile	java.io.File
    //   0	64	1	paramArrayOfByte	byte[]
    //   0	64	2	paramBoolean	boolean
    //   9	51	3	localFileOutputStream	java.io.FileOutputStream
    //   23	11	4	localThrowable1	Throwable
    //   57	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	10	23	java/lang/Throwable
    //   0	10	44	finally
    //   12	17	53	finally
    //   29	38	53	finally
    //   12	17	57	java/lang/Throwable
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    int n = paramList1.size();
    int i1 = paramList2.size();
    if ((n == 0) && (i1 == 0)) {
      return true;
    }
    if ((n == 0) || (i1 == 0)) {
      return false;
    }
    int m;
    int j;
    int i;
    label79:
    Object localObject;
    label161:
    int k;
    if (paramList1.size() > paramList2.size())
    {
      paramList2 = paramList2.iterator();
      m = 1;
      j = 0;
      i = 0;
      if (!paramList2.hasNext()) {
        break label233;
      }
      localObject = (ScanResult)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
            if ((m == 1) && (((ScanResult)localObject).level > -50))
            {
              i += 1;
              k = i;
              if (m == 2)
              {
                k = i;
                if (((ScanResult)localObject).level > -60) {
                  k = i + 1;
                }
              }
              if ((m == 3) && (((ScanResult)localObject).level > -60))
              {
                i = k + 1;
                label209:
                j += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      m += 1;
      break label79;
      localObject = paramList1;
      paramList1 = paramList2;
      paramList2 = (List<ScanResult>)localObject;
      break;
      label233:
      if (i == 3) {
        return false;
      }
      i = n + i1;
      if ((j << 1 < i * 0.85D) || (j < 13)) {}
      for (boolean bool = true;; bool = false)
      {
        new StringBuilder("isDiffrent:c=").append(n).append(",k=").append(j).append(",f=").append(i).append(",r=0.85,s=").append(bool);
        return bool;
      }
      i = k;
      break label209;
      break label161;
    }
  }
  
  public static boolean a(Object... paramVarArgs)
  {
    int i = 0;
    while (i < 2)
    {
      if (paramVarArgs[i] == null) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 298	java/io/File:exists	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 301	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +7 -> 20
    //   16: getstatic 306	c/t/m/g/ab:a	[B
    //   19: areturn
    //   20: new 308	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 309	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: invokestatic 314	c/t/m/g/aa:a	()Lc/t/m/g/aa;
    //   32: sipush 2048
    //   35: invokevirtual 317	c/t/m/g/aa:a	(I)[B
    //   38: astore 5
    //   40: new 319	java/io/BufferedInputStream
    //   43: dup
    //   44: new 321	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 324	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 327	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_2
    //   56: aload_2
    //   57: astore_0
    //   58: aload_2
    //   59: aload 5
    //   61: invokevirtual 331	java/io/BufferedInputStream:read	([B)I
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_m1
    //   67: if_icmpeq +54 -> 121
    //   70: aload_2
    //   71: astore_0
    //   72: aload 4
    //   74: aload 5
    //   76: iconst_0
    //   77: iload_1
    //   78: invokevirtual 334	java/io/ByteArrayOutputStream:write	([BII)V
    //   81: goto -25 -> 56
    //   84: astore_3
    //   85: aload_2
    //   86: astore_0
    //   87: ldc 235
    //   89: ldc_w 336
    //   92: aload_3
    //   93: invokestatic 53	c/t/m/g/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_2
    //   97: astore_0
    //   98: getstatic 306	c/t/m/g/ab:a	[B
    //   101: astore_3
    //   102: invokestatic 314	c/t/m/g/aa:a	()Lc/t/m/g/aa;
    //   105: aload 5
    //   107: invokevirtual 338	c/t/m/g/aa:a	([B)V
    //   110: aload_2
    //   111: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   114: aload 4
    //   116: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   119: aload_3
    //   120: areturn
    //   121: aload_2
    //   122: astore_0
    //   123: aload 4
    //   125: invokevirtual 341	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   128: astore_3
    //   129: invokestatic 314	c/t/m/g/aa:a	()Lc/t/m/g/aa;
    //   132: aload 5
    //   134: invokevirtual 338	c/t/m/g/aa:a	([B)V
    //   137: aload_2
    //   138: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   141: aload 4
    //   143: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   146: aload_3
    //   147: areturn
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_0
    //   151: invokestatic 314	c/t/m/g/aa:a	()Lc/t/m/g/aa;
    //   154: aload 5
    //   156: invokevirtual 338	c/t/m/g/aa:a	([B)V
    //   159: aload_0
    //   160: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   163: aload 4
    //   165: invokestatic 233	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
    //   168: aload_2
    //   169: athrow
    //   170: astore_2
    //   171: goto -20 -> 151
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -92 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramFile	java.io.File
    //   64	14	1	i	int
    //   55	83	2	localBufferedInputStream	java.io.BufferedInputStream
    //   148	21	2	localObject1	Object
    //   170	1	2	localObject2	Object
    //   176	1	2	localObject3	Object
    //   84	9	3	localThrowable1	Throwable
    //   101	46	3	arrayOfByte1	byte[]
    //   174	1	3	localThrowable2	Throwable
    //   27	137	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   38	117	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	65	84	java/lang/Throwable
    //   72	81	84	java/lang/Throwable
    //   123	129	84	java/lang/Throwable
    //   40	56	148	finally
    //   58	65	170	finally
    //   72	81	170	finally
    //   87	96	170	finally
    //   98	102	170	finally
    //   123	129	170	finally
    //   40	56	174	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      a("CompressUtil", "compressGzip failed.", paramArrayOfByte);
    }
    return ab.a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 16);
    return a(paramArrayOfByte, 16, paramInt - 16, arrayOfByte, arrayOfByte, 2);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3)
  {
    if ((paramInt3 != 1) && (paramInt3 != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramInt1 < 0) || (paramInt2 <= 0)) {
      return ab.a;
    }
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt3, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
      if (localCipher == null) {
        return ab.a;
      }
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      a("Encrypt2Util", "en-de crypt error.", paramArrayOfByte1);
    }
    return ab.a;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = ac.a(paramString);
      paramString = new String(a(paramString, paramString.length), "UTF-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      a("Encrypt2Util", "dec aes base64 error.", paramString);
    }
    return "";
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, 3, paramString2, null);
    if (u.b() != null) {
      u.b();
    }
  }
  
  public static boolean b(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isNaN(0.0D))) {}
    while (Math.abs(paramDouble) >= 1.0E-008D) {
      return false;
    }
    return true;
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      byte[] arrayOfByte1 = ag.a();
      paramArrayOfByte = a(paramArrayOfByte, 0, paramInt, arrayOfByte1, arrayOfByte1, 1);
      if (b(paramArrayOfByte)) {
        return paramArrayOfByte;
      }
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length + 16];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 16);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 16, paramArrayOfByte.length);
      return arrayOfByte2;
    }
    catch (Throwable paramArrayOfByte)
    {
      a("Encrypt2Util", "encrypt error.", paramArrayOfByte);
    }
    return ab.a;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
      return a(paramString1, paramString2);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1 = localObject;
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String d(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  @Nullable
  public static byte[] d(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    paramArrayOfByte = new byte[0];
    byte[] arrayOfByte2 = new byte[1024];
    for (;;)
    {
      try
      {
        int j = localInflaterInputStream.read(arrayOfByte2);
        if (j > 0)
        {
          i += j;
          byte[] arrayOfByte1 = new byte[i];
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
          paramArrayOfByte = arrayOfByte1;
          if (j <= 0) {
            try
            {
              localByteArrayInputStream.close();
              localInflaterInputStream.close();
              return paramArrayOfByte;
            }
            catch (IOException paramArrayOfByte)
            {
              return null;
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static String e(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ai
 * JD-Core Version:    0.7.0.1
 */