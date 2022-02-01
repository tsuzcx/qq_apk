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
  
  public static void a() {}
  
  private static void c()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (Build.VERSION.SDK_INT > 18) {
        return;
      }
      try
      {
        Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] { [B.class }).invoke(null, new Object[] { d() });
        int i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] { String.class, Long.TYPE }).invoke(null, new Object[] { "/dev/urandom", Integer.valueOf(1024) })).intValue();
        if (i == 1024) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected number of bytes read from Linux PRNG: ");
        localStringBuilder.append(i);
        throw new IOException(localStringBuilder.toString());
      }
      catch (Exception localException)
      {
        throw new SecurityException("Failed to seed OpenSSL PRNG", localException);
      }
    }
  }
  
  private static byte[] d()
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
  
  private static String e()
  {
    try
    {
      String str = (String)Build.class.getField("SERIAL").get(null);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static byte[] f()
  {
    Object localObject = new StringBuilder();
    String str = Build.FINGERPRINT;
    if (str != null) {
      ((StringBuilder)localObject).append(str);
    }
    str = e();
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
    
    private DataInputStream a()
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
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to open ");
            localStringBuilder.append(URANDOM_FILE);
            localStringBuilder.append(" for reading");
            throw new SecurityException(localStringBuilder.toString(), localIOException);
          }
        }
        DataInputStream localDataInputStream2 = sUrandomIn;
        return localDataInputStream2;
      }
    }
    
    private OutputStream b()
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
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to open ");
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
      //   20: aload_0
      //   21: invokespecial 101	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:a	()Ljava/io/DataInputStream;
      //   24: astore_3
      //   25: aload_2
      //   26: monitorexit
      //   27: aload_3
      //   28: monitorenter
      //   29: aload_3
      //   30: aload_1
      //   31: invokevirtual 104	java/io/DataInputStream:readFully	([B)V
      //   34: aload_3
      //   35: monitorexit
      //   36: return
      //   37: astore_1
      //   38: aload_3
      //   39: monitorexit
      //   40: aload_1
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: monitorexit
      //   45: aload_1
      //   46: athrow
      //   47: astore_1
      //   48: new 55	java/lang/StringBuilder
      //   51: dup
      //   52: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   55: astore_2
      //   56: aload_2
      //   57: ldc 106
      //   59: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: pop
      //   63: aload_2
      //   64: getstatic 29	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
      //   67: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   70: pop
      //   71: new 69	java/lang/SecurityException
      //   74: dup
      //   75: aload_2
      //   76: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   79: aload_1
      //   80: invokespecial 76	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   83: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	LinuxPRNGSecureRandom
      //   0	84	1	paramArrayOfByte	byte[]
      //   24	15	3	localDataInputStream	DataInputStream
      // Exception table:
      //   from	to	target	type
      //   29	36	37	finally
      //   38	40	37	finally
      //   20	27	42	finally
      //   43	45	42	finally
      //   14	20	47	java/io/IOException
      //   27	29	47	java/io/IOException
      //   40	42	47	java/io/IOException
      //   45	47	47	java/io/IOException
    }
    
    /* Error */
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: getstatic 35	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
      //   3: astore_2
      //   4: aload_2
      //   5: monitorenter
      //   6: aload_0
      //   7: invokespecial 108	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:b	()Ljava/io/OutputStream;
      //   10: astore_3
      //   11: aload_2
      //   12: monitorexit
      //   13: aload_3
      //   14: aload_1
      //   15: invokevirtual 113	java/io/OutputStream:write	([B)V
      //   18: aload_3
      //   19: invokevirtual 116	java/io/OutputStream:flush	()V
      //   22: aload_0
      //   23: iconst_1
      //   24: putfield 93	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
      //   27: return
      //   28: astore_1
      //   29: aload_2
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      //   33: astore_1
      //   34: new 55	java/lang/StringBuilder
      //   37: dup
      //   38: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   41: astore_2
      //   42: aload_2
      //   43: ldc 118
      //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: pop
      //   49: aload_2
      //   50: getstatic 29	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
      //   53: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   56: pop
      //   57: new 69	java/lang/SecurityException
      //   60: dup
      //   61: aload_2
      //   62: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   65: aload_1
      //   66: invokespecial 76	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   69: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	70	0	this	LinuxPRNGSecureRandom
      //   0	70	1	paramArrayOfByte	byte[]
      //   10	9	3	localOutputStream	OutputStream
      // Exception table:
      //   from	to	target	type
      //   6	13	28	finally
      //   29	31	28	finally
      //   0	6	33	java/io/IOException
      //   13	27	33	java/io/IOException
      //   31	33	33	java/io/IOException
    }
  }
  
  private static class LinuxPRNGSecureRandomProvider
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