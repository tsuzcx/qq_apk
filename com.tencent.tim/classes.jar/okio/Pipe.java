package okio;

import java.io.IOException;

public final class Pipe
{
  final Buffer buffer = new Buffer();
  final long maxBufferSize;
  private final Sink sink = new PipeSink();
  boolean sinkClosed;
  private final Source source = new PipeSource();
  boolean sourceClosed;
  
  public Pipe(long paramLong)
  {
    if (paramLong < 1L) {
      throw new IllegalArgumentException("maxBufferSize < 1: " + paramLong);
    }
    this.maxBufferSize = paramLong;
  }
  
  public final Sink sink()
  {
    return this.sink;
  }
  
  public final Source source()
  {
    return this.source;
  }
  
  final class PipeSink
    implements Sink
  {
    final Timeout timeout = new Timeout();
    
    PipeSink() {}
    
    public void close()
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (Pipe.this.sinkClosed) {
          return;
        }
        if ((Pipe.this.sourceClosed) && (Pipe.this.buffer.size() > 0L)) {
          throw new IOException("source is closed");
        }
      }
      Pipe.this.sinkClosed = true;
      Pipe.this.buffer.notifyAll();
    }
    
    public void flush()
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (Pipe.this.sinkClosed) {
          throw new IllegalStateException("closed");
        }
      }
      if ((Pipe.this.sourceClosed) && (Pipe.this.buffer.size() > 0L)) {
        throw new IOException("source is closed");
      }
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (!Pipe.this.sinkClosed) {
          break label79;
        }
        throw new IllegalStateException("closed");
      }
      long l = Pipe.this.maxBufferSize - Pipe.this.buffer.size();
      if (l == 0L) {
        this.timeout.waitUntilNotified(Pipe.this.buffer);
      }
      for (;;)
      {
        label79:
        if (paramLong <= 0L) {
          break label144;
        }
        if (!Pipe.this.sourceClosed) {
          break;
        }
        throw new IOException("source is closed");
        l = Math.min(l, paramLong);
        Pipe.this.buffer.write(paramBuffer, l);
        paramLong -= l;
        Pipe.this.buffer.notifyAll();
      }
      label144:
    }
  }
  
  final class PipeSource
    implements Source
  {
    final Timeout timeout = new Timeout();
    
    PipeSource() {}
    
    public void close()
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        Pipe.this.sourceClosed = true;
        Pipe.this.buffer.notifyAll();
        return;
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      synchronized (Pipe.this.buffer)
      {
        if (Pipe.this.sourceClosed) {
          throw new IllegalStateException("closed");
        }
      }
      do
      {
        this.timeout.waitUntilNotified(Pipe.this.buffer);
        if (Pipe.this.buffer.size() != 0L) {
          break;
        }
      } while (!Pipe.this.sinkClosed);
      return -1L;
      paramLong = Pipe.this.buffer.read(paramBuffer, paramLong);
      Pipe.this.buffer.notifyAll();
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Pipe
 * JD-Core Version:    0.7.0.1
 */