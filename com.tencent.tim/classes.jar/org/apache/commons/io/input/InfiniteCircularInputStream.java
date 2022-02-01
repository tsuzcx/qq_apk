package org.apache.commons.io.input;

import java.io.InputStream;

public class InfiniteCircularInputStream
  extends InputStream
{
  private int position = -1;
  private final byte[] repeatedContent;
  
  public InfiniteCircularInputStream(byte[] paramArrayOfByte)
  {
    this.repeatedContent = paramArrayOfByte;
  }
  
  public int read()
  {
    this.position = ((this.position + 1) % this.repeatedContent.length);
    return this.repeatedContent[this.position] & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.InfiniteCircularInputStream
 * JD-Core Version:    0.7.0.1
 */