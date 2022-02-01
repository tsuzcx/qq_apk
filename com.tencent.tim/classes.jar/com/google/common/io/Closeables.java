package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class Closeables
{
  @VisibleForTesting
  static final Logger logger = Logger.getLogger(Closeables.class.getName());
  
  public static void close(@Nullable Closeable paramCloseable, boolean paramBoolean)
    throws IOException
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", paramCloseable);
        return;
      }
      throw paramCloseable;
    }
  }
  
  public static void closeQuietly(@Nullable InputStream paramInputStream)
  {
    try
    {
      close(paramInputStream, true);
      return;
    }
    catch (IOException paramInputStream)
    {
      throw new AssertionError(paramInputStream);
    }
  }
  
  public static void closeQuietly(@Nullable Reader paramReader)
  {
    try
    {
      close(paramReader, true);
      return;
    }
    catch (IOException paramReader)
    {
      throw new AssertionError(paramReader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Closeables
 * JD-Core Version:    0.7.0.1
 */