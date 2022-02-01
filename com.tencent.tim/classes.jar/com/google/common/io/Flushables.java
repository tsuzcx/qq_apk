package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
public final class Flushables
{
  private static final Logger logger = Logger.getLogger(Flushables.class.getName());
  
  public static void flush(Flushable paramFlushable, boolean paramBoolean)
    throws IOException
  {
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException paramFlushable)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", paramFlushable);
        return;
      }
      throw paramFlushable;
    }
  }
  
  public static void flushQuietly(Flushable paramFlushable)
  {
    try
    {
      flush(paramFlushable, true);
      return;
    }
    catch (IOException paramFlushable)
    {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", paramFlushable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Flushables
 * JD-Core Version:    0.7.0.1
 */