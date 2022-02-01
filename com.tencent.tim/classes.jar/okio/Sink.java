package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface Sink
  extends Closeable, Flushable
{
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract Timeout timeout();
  
  public abstract void write(Buffer paramBuffer, long paramLong)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Sink
 * JD-Core Version:    0.7.0.1
 */