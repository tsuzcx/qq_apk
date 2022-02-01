package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class DemuxInputStream
  extends InputStream
{
  private final InheritableThreadLocal<InputStream> m_streams = new InheritableThreadLocal();
  
  public InputStream bindStream(InputStream paramInputStream)
  {
    InputStream localInputStream = (InputStream)this.m_streams.get();
    this.m_streams.set(paramInputStream);
    return localInputStream;
  }
  
  public void close()
    throws IOException
  {
    InputStream localInputStream = (InputStream)this.m_streams.get();
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public int read()
    throws IOException
  {
    InputStream localInputStream = (InputStream)this.m_streams.get();
    if (localInputStream != null) {
      return localInputStream.read();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.DemuxInputStream
 * JD-Core Version:    0.7.0.1
 */