package com.tencent.token.utils.encrypt.random;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Provider;
import java.security.SecureRandomSpi;

public final class PRNGFixes
{
  private static final byte[] a = ;
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (Build.VERSION.SDK_INT > 18) {
        return;
      }
      try
      {
        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] { [B.class }).invoke(null, new Object[] { c() });
        int i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "/dev/urandom", Integer.valueOf(1024) })).intValue();
        if (i == 1024) {
          return;
        }
        throw new IOException("Unexpected number of bytes read from Linux PRNG: ".concat(String.valueOf(i)));
      }
      catch (Exception localException)
      {
        throw new SecurityException("Failed to seed OpenSSL PRNG", localException);
      }
    }
  }
  
  private static byte[] c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(System.currentTimeMillis());
      localDataOutputStream.writeLong(System.nanoTime());
      localDataOutputStream.writeInt(Process.myPid());
      localDataOutputStream.writeInt(Process.myUid());
      localDataOutputStream.write(a);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new SecurityException("Failed to generate seed", localIOException);
    }
  }
  
  private static String d()
  {
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static byte[] e()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = d();
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    try
    {
      localObject = ((StringBuilder)localObject).toString().getBytes("UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label48:
      break label48;
    }
    throw new RuntimeException("UTF-8 encoding not supported");
  }
  
  public static class LinuxPRNGSecureRandom
    extends SecureRandomSpi
  {
    private static final File URANDOM_FILE = new File("/dev/urandom");
    private static final Object sLock = new Object();
    private static DataInputStream sUrandomIn;
    private static OutputStream sUrandomOut;
    private boolean mSeeded;
    
    private static DataInputStream a()
    {
      synchronized (sLock)
      {
        DataInputStream localDataInputStream1 = sUrandomIn;
        if (localDataInputStream1 == null) {
          try
          {
            sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
          }
          catch (IOException localIOException)
          {
            StringBuilder localStringBuilder = new StringBuilder("Failed to open ");
            localStringBuilder.append(URANDOM_FILE);
            localStringBuilder.append(" for reading");
            throw new SecurityException(localStringBuilder.toString(), localIOException);
          }
        }
        DataInputStream localDataInputStream2 = sUrandomIn;
        return localDataInputStream2;
      }
    }
    
    private static OutputStream b()
    {
      synchronized (sLock)
      {
        OutputStream localOutputStream1 = sUrandomOut;
        if (localOutputStream1 == null) {
          try
          {
            sUrandomOut = new FileOutputStream(URANDOM_FILE);
          }
          catch (IOException localIOException)
          {
            StringBuilder localStringBuilder = new StringBuilder("Failed to open ");
            localStringBuilder.append(URANDOM_FILE);
            localStringBuilder.append(" for writing");
            throw new SecurityException(localStringBuilder.toString(), localIOException);
          }
        }
        OutputStream localOutputStream2 = sUrandomOut;
        return localOutputStream2;
      }
    }
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      engineNextBytes(arrayOfByte);
      return arrayOfByte;
    }
    
    /* Error */
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 93	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
      //   4: ifne +10 -> 14
      //   7: aload_0
      //   8: invokestatic 96	com/tencent/token/utils/encrypt/random/PRNGFixes:b	()[B
      //   11: invokevirtual 99	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:engineSetSeed	([B)V
      //   14: getstatic 35	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
      //   17: astore_2
      //   18: aload_2
      //   19: monitorenter
      //   20: invokestatic 101	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:a	()Ljava/io/DataInputStream;
      //   23: astore_3
      //   24: aload_2
      //   25: monitorexit
      //   26: aload_3
      //   27: monitorenter
      //   28: aload_3
      //   29: aload_1
      //   30: invokevirtual 104	java/io/DataInputStream:readFully	([B)V
      //   33: aload_3
      //   34: monitorexit
      //   35: return
      //   36: astore_1
      //   37: aload_3
      //   38: monitorexit
      //   39: aload_1
      //   40: athrow
      //   41: astore_1
      //   42: aload_2
      //   43: monitorexit
      //   44: aload_1
      //   45: athrow
      //   46: astore_1
      //   47: new 55	java/lang/StringBuilder
      //   50: dup
      //   51: ldc 106
      //   53: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   56: astore_2
      //   57: aload_2
      //   58: getstatic 29	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
      //   61: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   64: pop
      //   65: new 69	java/lang/SecurityException
      //   68: dup
      //   69: aload_2
      //   70: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: aload_1
      //   74: invokespecial 76	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	LinuxPRNGSecureRandom
      //   0	78	1	paramArrayOfByte	byte[]
      //   23	15	3	localDataInputStream	DataInputStream
      // Exception table:
      //   from	to	target	type
      //   28	35	36	finally
      //   37	39	36	finally
      //   20	26	41	finally
      //   42	44	41	finally
      //   14	20	46	java/io/IOException
      //   26	28	46	java/io/IOException
      //   39	41	46	java/io/IOException
      //   44	46	46	java/io/IOException
    }
    
    /* Error */
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: getstatic 35	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
      //   3: astore_2
      //   4: aload_2
      //   5: monitorenter
      //   6: invokestatic 108	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:b	()Ljava/io/OutputStream;
      //   9: astore_3
      //   10: aload_2
      //   11: monitorexit
      //   12: aload_3
      //   13: aload_1
      //   14: invokevirtual 113	java/io/OutputStream:write	([B)V
      //   17: aload_3
      //   18: invokevirtual 116	java/io/OutputStream:flush	()V
      //   21: aload_0
      //   22: iconst_1
      //   23: putfield 93	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
      //   26: return
      //   27: astore_1
      //   28: aload_2
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      //   32: astore_1
      //   33: new 55	java/lang/StringBuilder
      //   36: dup
      //   37: ldc 118
      //   39: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   42: astore_2
      //   43: aload_2
      //   44: getstatic 29	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
      //   47: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   50: pop
      //   51: new 69	java/lang/SecurityException
      //   54: dup
      //   55: aload_2
      //   56: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   59: aload_1
      //   60: invokespecial 76	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   63: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	64	0	this	LinuxPRNGSecureRandom
      //   0	64	1	paramArrayOfByte	byte[]
      //   9	9	3	localOutputStream	OutputStream
      // Exception table:
      //   from	to	target	type
      //   6	12	27	finally
      //   28	30	27	finally
      //   0	6	32	java/io/IOException
      //   12	26	32	java/io/IOException
      //   30	32	32	java/io/IOException
    }
  }
  
  static class LinuxPRNGSecureRandomProvider
    extends Provider
  {
    public LinuxPRNGSecureRandomProvider()
    {
      super(1.0D, "A Linux-specific random number provider that uses /dev/urandom");
      put("SecureRandom.SHA1PRNG", PRNGFixes.LinuxPRNGSecureRandom.class.getName());
      put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.PRNGFixes
 * JD-Core Version:    0.7.0.1
 */