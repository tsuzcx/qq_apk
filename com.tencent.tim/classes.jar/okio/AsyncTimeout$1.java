package okio;

import java.io.IOException;

class AsyncTimeout$1
  implements Sink
{
  AsyncTimeout$1(AsyncTimeout paramAsyncTimeout, Sink paramSink) {}
  
  public void close()
    throws IOException
  {
    this.this$0.enter();
    try
    {
      this.val$sink.close();
      this.this$0.exit(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.this$0.exit(localIOException);
    }
    finally
    {
      this.this$0.exit(false);
    }
  }
  
  public void flush()
    throws IOException
  {
    this.this$0.enter();
    try
    {
      this.val$sink.flush();
      this.this$0.exit(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.this$0.exit(localIOException);
    }
    finally
    {
      this.this$0.exit(false);
    }
  }
  
  public Timeout timeout()
  {
    return this.this$0;
  }
  
  public String toString()
  {
    return "AsyncTimeout.sink(" + this.val$sink + ")";
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    if (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      long l1 = 0L;
      for (;;)
      {
        for (;;)
        {
          long l2 = l1;
          if (l1 < 65536L)
          {
            l1 = localSegment.limit - localSegment.pos + l1;
            if (l1 >= paramLong) {
              l2 = paramLong;
            }
          }
          else
          {
            this.this$0.enter();
          }
          try
          {
            this.val$sink.write(paramBuffer, l2);
            paramLong -= l2;
            this.this$0.exit(true);
            break;
          }
          catch (IOException paramBuffer)
          {
            throw this.this$0.exit(paramBuffer);
          }
          finally
          {
            this.this$0.exit(false);
          }
        }
        localSegment = localSegment.next;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.AsyncTimeout.1
 * JD-Core Version:    0.7.0.1
 */