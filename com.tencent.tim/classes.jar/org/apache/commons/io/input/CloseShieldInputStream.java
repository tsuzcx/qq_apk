package org.apache.commons.io.input;

import java.io.InputStream;

public class CloseShieldInputStream
  extends ProxyInputStream
{
  public CloseShieldInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public void close()
  {
    this.in = new ClosedInputStream();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.CloseShieldInputStream
 * JD-Core Version:    0.7.0.1
 */