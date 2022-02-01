package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
public final class FileBackedOutputStream
  extends OutputStream
{
  private File file;
  private final int fileThreshold;
  private MemoryOutput memory;
  private OutputStream out;
  private final boolean resetOnFinalize;
  private final ByteSource source;
  
  public FileBackedOutputStream(int paramInt)
  {
    this(paramInt, false);
  }
  
  public FileBackedOutputStream(int paramInt, boolean paramBoolean)
  {
    this.fileThreshold = paramInt;
    this.resetOnFinalize = paramBoolean;
    this.memory = new MemoryOutput(null);
    this.out = this.memory;
    if (paramBoolean)
    {
      this.source = new FileBackedOutputStream.1(this);
      return;
    }
    this.source = new FileBackedOutputStream.2(this);
  }
  
  /* Error */
  private java.io.InputStream openInputStream()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   6: ifnull +19 -> 25
    //   9: new 64	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 62	com/google/common/io/FileBackedOutputStream:file	Ljava/io/File;
    //   17: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: new 69	java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 39	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   33: invokevirtual 73	com/google/common/io/FileBackedOutputStream$MemoryOutput:getBuffer	()[B
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield 39	com/google/common/io/FileBackedOutputStream:memory	Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   41: invokevirtual 77	com/google/common/io/FileBackedOutputStream$MemoryOutput:getCount	()I
    //   44: invokespecial 80	java/io/ByteArrayInputStream:<init>	([BII)V
    //   47: astore_1
    //   48: goto -27 -> 21
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	FileBackedOutputStream
    //   20	28	1	localObject1	Object
    //   51	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	51	finally
    //   25	48	51	finally
  }
  
  private void update(int paramInt)
    throws IOException
  {
    if ((this.file == null) && (this.memory.getCount() + paramInt > this.fileThreshold))
    {
      File localFile = File.createTempFile("FileBackedOutputStream", null);
      if (this.resetOnFinalize) {
        localFile.deleteOnExit();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
      localFileOutputStream.flush();
      this.out = localFileOutputStream;
      this.file = localFile;
      this.memory = null;
    }
  }
  
  public ByteSource asByteSource()
  {
    return this.source;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.out.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      this.out.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @VisibleForTesting
  File getFile()
  {
    try
    {
      File localFile = this.file;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      File localFile1;
      File localFile2;
      return;
    }
    finally
    {
      if (this.memory == null) {
        this.memory = new MemoryOutput(null);
      }
      for (;;)
      {
        this.out = this.memory;
        if (this.file == null) {
          break;
        }
        localFile2 = this.file;
        this.file = null;
        if (localFile2.delete()) {
          break;
        }
        throw new IOException("Could not delete: " + localFile2);
        this.memory.reset();
      }
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      update(1);
      this.out.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      write(paramArrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      update(paramInt2);
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  static class MemoryOutput
    extends ByteArrayOutputStream
  {
    byte[] getBuffer()
    {
      return this.buf;
    }
    
    int getCount()
    {
      return this.count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.FileBackedOutputStream
 * JD-Core Version:    0.7.0.1
 */