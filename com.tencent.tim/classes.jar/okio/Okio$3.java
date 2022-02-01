package okio;

import java.io.IOException;

final class Okio$3
  implements Sink
{
  public void close()
    throws IOException
  {}
  
  public void flush()
    throws IOException
  {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    paramBuffer.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Okio.3
 * JD-Core Version:    0.7.0.1
 */