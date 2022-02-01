package net.jarlehansen.protobuf.input;

import java.io.IOException;
import java.io.InputStream;

public class DelimitedInputStream
  extends InputStream
{
  private final InputStream input;
  private int limit;
  
  public DelimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    this.input = paramInputStream;
    this.limit = paramInt;
  }
  
  public int available()
    throws IOException
  {
    return Math.min(super.available(), this.limit);
  }
  
  public int read()
    throws IOException
  {
    int i;
    if (this.limit <= 0) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.input.read();
      i = j;
    } while (j < 0);
    this.limit -= 1;
    return j;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.limit <= 0) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.limit));
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    this.limit -= paramInt2;
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = super.skip(Math.min(paramLong, this.limit));
    if (paramLong >= 0L) {
      this.limit = ((int)(this.limit - paramLong));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.input.DelimitedInputStream
 * JD-Core Version:    0.7.0.1
 */