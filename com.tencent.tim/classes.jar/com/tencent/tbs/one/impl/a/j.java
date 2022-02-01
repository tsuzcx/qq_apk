package com.tencent.tbs.one.impl.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public final class j
{
  private final File a;
  private final FileOutputStream b;
  private final FileLock c;
  
  private j(File paramFile, FileOutputStream paramFileOutputStream, FileLock paramFileLock)
  {
    this.a = paramFile;
    this.b = paramFileOutputStream;
    this.c = paramFileLock;
  }
  
  /* Error */
  public static j a(File paramFile)
  {
    // Byte code:
    //   0: new 27	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 30	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 34	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: invokevirtual 40	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   16: astore_3
    //   17: aload_1
    //   18: astore_2
    //   19: aload_3
    //   20: ifnull +57 -> 77
    //   23: ldc 42
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 53	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: new 2	com/tencent/tbs/one/impl/a/j
    //   42: dup
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: invokespecial 55	com/tencent/tbs/one/impl/a/j:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   49: astore_2
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: ldc 57
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_2
    //   71: aastore
    //   72: invokestatic 59	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 64	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: goto -29 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramFile	File
    //   8	68	1	localFileOutputStream1	FileOutputStream
    //   18	33	2	localObject	Object
    //   52	19	2	localThrowable1	java.lang.Throwable
    //   76	2	2	localFileOutputStream2	FileOutputStream
    //   83	1	2	localThrowable2	java.lang.Throwable
    //   16	30	3	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   0	9	52	java/lang/Throwable
    //   9	17	83	java/lang/Throwable
    //   23	50	83	java/lang/Throwable
  }
  
  /* Error */
  static <T> T a(java.util.concurrent.Callable<T> paramCallable, File paramFile, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: i2l
    //   6: lload_2
    //   7: ldc2_w 70
    //   10: ldiv
    //   11: lcmp
    //   12: ifge +86 -> 98
    //   15: aload_0
    //   16: invokeinterface 77 1 0
    //   21: astore 5
    //   23: aload 5
    //   25: ifnull +27 -> 52
    //   28: iload 4
    //   30: ifle +100 -> 130
    //   33: ldc 79
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 53	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload 5
    //   51: areturn
    //   52: iload 4
    //   54: ifne +19 -> 73
    //   57: ldc 81
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 53	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: ldc2_w 70
    //   76: invokestatic 87	java/lang/Thread:sleep	(J)V
    //   79: iload 4
    //   81: iconst_1
    //   82: iadd
    //   83: istore 4
    //   85: goto -82 -> 3
    //   88: astore_0
    //   89: new 89	java/lang/RuntimeException
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 92	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: new 89	java/lang/RuntimeException
    //   101: dup
    //   102: new 94	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 96
    //   108: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 107	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: astore 5
    //   127: goto -48 -> 79
    //   130: aload 5
    //   132: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramCallable	java.util.concurrent.Callable<T>
    //   0	133	1	paramFile	File
    //   0	133	2	paramLong	long
    //   1	83	4	i	int
    //   21	29	5	localObject	Object
    //   125	6	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   15	23	88	java/lang/Exception
    //   33	49	88	java/lang/Exception
    //   57	73	88	java/lang/Exception
    //   73	79	125	java/lang/InterruptedException
  }
  
  public final void a()
  {
    try
    {
      f.a("Deleting lock file: %s", new Object[] { this.a.getAbsolutePath() });
      this.c.release();
      this.b.close();
      if (!this.a.delete()) {
        throw new IOException("Failed to delete lock file: " + this.a.getAbsolutePath());
      }
    }
    catch (IOException localIOException)
    {
      f.c("Failed to release process lock file %s", new Object[] { this.a.getAbsolutePath(), localIOException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.j
 * JD-Core Version:    0.7.0.1
 */