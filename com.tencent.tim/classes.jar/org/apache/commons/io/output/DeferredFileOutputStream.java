package org.apache.commons.io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class DeferredFileOutputStream
  extends ThresholdingOutputStream
{
  private boolean closed = false;
  private OutputStream currentOutputStream;
  private final File directory;
  private ByteArrayOutputStream memoryOutputStream;
  private File outputFile;
  private final String prefix;
  private final String suffix;
  
  public DeferredFileOutputStream(int paramInt1, int paramInt2, File paramFile)
  {
    this(paramInt1, paramFile, null, null, null, paramInt2);
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
    }
  }
  
  public DeferredFileOutputStream(int paramInt1, int paramInt2, String paramString1, String paramString2, File paramFile)
  {
    this(paramInt1, null, paramString1, paramString2, paramFile, paramInt2);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Temporary file prefix is missing");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
    }
  }
  
  public DeferredFileOutputStream(int paramInt, File paramFile)
  {
    this(paramInt, paramFile, null, null, null, 1024);
  }
  
  private DeferredFileOutputStream(int paramInt1, File paramFile1, String paramString1, String paramString2, File paramFile2, int paramInt2)
  {
    super(paramInt1);
    this.outputFile = paramFile1;
    this.prefix = paramString1;
    this.suffix = paramString2;
    this.directory = paramFile2;
    this.memoryOutputStream = new ByteArrayOutputStream(paramInt2);
    this.currentOutputStream = this.memoryOutputStream;
  }
  
  public DeferredFileOutputStream(int paramInt, String paramString1, String paramString2, File paramFile)
  {
    this(paramInt, null, paramString1, paramString2, paramFile, 1024);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Temporary file prefix is missing");
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this.closed = true;
  }
  
  public byte[] getData()
  {
    if (this.memoryOutputStream != null) {
      return this.memoryOutputStream.toByteArray();
    }
    return null;
  }
  
  public File getFile()
  {
    return this.outputFile;
  }
  
  protected OutputStream getStream()
    throws IOException
  {
    return this.currentOutputStream;
  }
  
  public boolean isInMemory()
  {
    return !isThresholdExceeded();
  }
  
  protected void thresholdReached()
    throws IOException
  {
    if (this.prefix != null) {
      this.outputFile = File.createTempFile(this.prefix, this.suffix, this.directory);
    }
    FileUtils.forceMkdirParent(this.outputFile);
    FileOutputStream localFileOutputStream = new FileOutputStream(this.outputFile);
    try
    {
      this.memoryOutputStream.writeTo(localFileOutputStream);
      this.currentOutputStream = localFileOutputStream;
      this.memoryOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      localFileOutputStream.close();
      throw localIOException;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (!this.closed) {
      throw new IOException("Stream not closed");
    }
    if (isInMemory()) {
      this.memoryOutputStream.writeTo(paramOutputStream);
    }
    FileInputStream localFileInputStream;
    OutputStream localOutputStream;
    for (;;)
    {
      return;
      localFileInputStream = new FileInputStream(this.outputFile);
      localOutputStream = null;
      try
      {
        IOUtils.copy(localFileInputStream, paramOutputStream);
        if (localFileInputStream != null)
        {
          if (0 != 0) {
            try
            {
              localFileInputStream.close();
              return;
            }
            catch (Throwable paramOutputStream)
            {
              throw new NullPointerException();
            }
          }
          localFileInputStream.close();
          return;
        }
      }
      catch (Throwable paramOutputStream)
      {
        localOutputStream = paramOutputStream;
        throw paramOutputStream;
      }
      finally
      {
        if (localFileInputStream != null) {
          if (localOutputStream == null) {
            break label109;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localFileInputStream.close();
        throw paramOutputStream;
      }
      catch (Throwable localThrowable)
      {
        localOutputStream.addSuppressed(localThrowable);
        continue;
      }
      label109:
      localThrowable.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.DeferredFileOutputStream
 * JD-Core Version:    0.7.0.1
 */