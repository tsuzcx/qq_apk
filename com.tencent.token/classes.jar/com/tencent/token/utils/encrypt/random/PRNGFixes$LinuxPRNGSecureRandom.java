package com.tencent.token.utils.encrypt.random;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

public class PRNGFixes$LinuxPRNGSecureRandom
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
      DataInputStream localDataInputStream = sUrandomIn;
      if (localDataInputStream == null) {}
      try
      {
        sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
        localDataInputStream = sUrandomIn;
        return localDataInputStream;
      }
      catch (IOException localIOException)
      {
        throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", localIOException);
      }
    }
  }
  
  private OutputStream b()
  {
    synchronized (sLock)
    {
      OutputStream localOutputStream = sUrandomOut;
      if (localOutputStream == null) {}
      try
      {
        sUrandomOut = new FileOutputStream(URANDOM_FILE);
        localOutputStream = sUrandomOut;
        return localOutputStream;
      }
      catch (IOException localIOException)
      {
        throw new SecurityException("Failed to open " + URANDOM_FILE + " for writing", localIOException);
      }
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
    //   1: getfield 90	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: invokestatic 95	com/tencent/token/utils/encrypt/random/PRNGFixes:b	()[B
    //   11: invokevirtual 98	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:engineSetSeed	([B)V
    //   14: getstatic 32	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: monitorenter
    //   20: aload_0
    //   21: invokespecial 100	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:a	()Ljava/io/DataInputStream;
    //   24: astore_3
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 103	java/io/DataInputStream:readFully	([B)V
    //   34: aload_3
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: new 52	java/lang/SecurityException
    //   46: dup
    //   47: new 54	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   54: ldc 105
    //   56: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: getstatic 26	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   62: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aload_1
    //   69: invokespecial 73	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_1
    //   74: aload_3
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	LinuxPRNGSecureRandom
    //   0	78	1	paramArrayOfByte	byte[]
    //   24	51	3	localDataInputStream	DataInputStream
    // Exception table:
    //   from	to	target	type
    //   20	27	37	finally
    //   38	40	37	finally
    //   14	20	42	java/io/IOException
    //   27	29	42	java/io/IOException
    //   40	42	42	java/io/IOException
    //   76	78	42	java/io/IOException
    //   29	36	73	finally
    //   74	76	73	finally
  }
  
  /* Error */
  protected void engineSetSeed(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: invokespecial 107	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:b	()Ljava/io/OutputStream;
    //   10: astore_3
    //   11: aload_2
    //   12: monitorexit
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 112	java/io/OutputStream:write	([B)V
    //   18: aload_3
    //   19: invokevirtual 115	java/io/OutputStream:flush	()V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 90	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
    //   27: return
    //   28: astore_1
    //   29: aload_2
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: new 52	java/lang/SecurityException
    //   37: dup
    //   38: new 54	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   45: ldc 117
    //   47: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: getstatic 26	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   53: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 73	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	LinuxPRNGSecureRandom
    //   0	64	1	paramArrayOfByte	byte[]
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.PRNGFixes.LinuxPRNGSecureRandom
 * JD-Core Version:    0.7.0.1
 */