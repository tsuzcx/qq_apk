package com.google.common.io;

import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$1
  extends ByteSource
{
  FileBackedOutputStream$1(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  protected void finalize()
  {
    try
    {
      this.this$0.reset();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace(System.err);
    }
  }
  
  public InputStream openStream()
    throws IOException
  {
    return FileBackedOutputStream.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.FileBackedOutputStream.1
 * JD-Core Version:    0.7.0.1
 */