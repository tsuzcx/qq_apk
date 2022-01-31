package com.tencent.halley.downloader.c;

import java.io.File;
import java.io.RandomAccessFile;

final class i
  extends RandomAccessFile
{
  public i(File paramFile, String paramString)
  {
    super(paramFile, paramString);
  }
  
  protected final void finalize()
  {
    try
    {
      super.finalize();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.i
 * JD-Core Version:    0.7.0.1
 */