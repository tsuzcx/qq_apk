package com.google.common.io;

import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$2
  extends ByteSource
{
  FileBackedOutputStream$2(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  public InputStream openStream()
    throws IOException
  {
    return FileBackedOutputStream.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.FileBackedOutputStream.2
 * JD-Core Version:    0.7.0.1
 */