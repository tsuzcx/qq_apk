package okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;
  
  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    if (paramBufferedSink == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.sink = paramBufferedSink;
    this.deflater = paramDeflater;
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  private void deflate(boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = this.sink.buffer();
    Segment localSegment;
    do
    {
      for (;;)
      {
        localSegment = localBuffer.writableSegment(1);
        int i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit);
        if (i <= 0) {
          break;
        }
        localSegment.limit += i;
        localBuffer.size += i;
        this.sink.emitCompleteSegments();
      }
    } while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        finishDeflate();
        try
        {
          label14:
          this.deflater.end();
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            label34:
            localObject1 = localThrowable1;
            if (localThrowable1 == null) {
              localObject1 = localThrowable2;
            }
          }
        }
        try
        {
          this.sink.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          Object localObject3 = localObject1;
          if (localObject1 != null) {
            break label34;
          }
          localObject3 = localThrowable3;
          break label34;
        }
        this.closed = true;
        if (localObject2 == null) {
          continue;
        }
        Util.sneakyRethrow(localObject2);
        return;
      }
      catch (Throwable localThrowable1)
      {
        break label14;
      }
    }
  }
  
  void finishDeflate()
    throws IOException
  {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush()
    throws IOException
  {
    deflate(true);
    this.sink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    return "DeflaterSink(" + this.sink + ")";
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    for (;;)
    {
      if (paramLong <= 0L) {
        return;
      }
      Segment localSegment = paramBuffer.head;
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      paramBuffer.size -= i;
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      paramLong -= i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     okio.DeflaterSink
 * JD-Core Version:    0.7.0.1
 */