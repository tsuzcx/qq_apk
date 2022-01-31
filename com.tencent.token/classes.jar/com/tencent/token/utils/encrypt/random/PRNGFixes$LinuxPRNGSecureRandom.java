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
  
  private static DataInputStream a()
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
  
  private static OutputStream b()
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
    //   20: invokestatic 100	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:a	()Ljava/io/DataInputStream;
    //   23: astore_3
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_3
    //   27: monitorenter
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 103	java/io/DataInputStream:readFully	([B)V
    //   33: aload_3
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: new 52	java/lang/SecurityException
    //   45: dup
    //   46: new 54	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   53: ldc 105
    //   55: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 26	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   61: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: aload_1
    //   68: invokespecial 73	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: athrow
    //   72: astore_1
    //   73: aload_3
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	LinuxPRNGSecureRandom
    //   0	77	1	paramArrayOfByte	byte[]
    //   23	51	3	localDataInputStream	DataInputStream
    // Exception table:
    //   from	to	target	type
    //   20	26	36	finally
    //   14	20	41	java/io/IOException
    //   26	28	41	java/io/IOException
    //   37	41	41	java/io/IOException
    //   73	77	41	java/io/IOException
    //   28	35	72	finally
  }
  
  /* Error */
  protected void engineSetSeed(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: invokestatic 107	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:b	()Ljava/io/OutputStream;
    //   9: astore_3
    //   10: aload_2
    //   11: monitorexit
    //   12: aload_3
    //   13: aload_1
    //   14: invokevirtual 112	java/io/OutputStream:write	([B)V
    //   17: aload_3
    //   18: invokevirtual 115	java/io/OutputStream:flush	()V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 90	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:mSeeded	Z
    //   26: return
    //   27: astore_1
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: new 52	java/lang/SecurityException
    //   36: dup
    //   37: new 54	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   44: ldc 117
    //   46: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 26	com/tencent/token/utils/encrypt/random/PRNGFixes$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   52: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: aload_1
    //   59: invokespecial 73	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	LinuxPRNGSecureRandom
    //   0	63	1	paramArrayOfByte	byte[]
    //   9	9	3	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   6	12	27	finally
    //   0	6	32	java/io/IOException
    //   12	26	32	java/io/IOException
    //   28	32	32	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.PRNGFixes.LinuxPRNGSecureRandom
 * JD-Core Version:    0.7.0.1
 */