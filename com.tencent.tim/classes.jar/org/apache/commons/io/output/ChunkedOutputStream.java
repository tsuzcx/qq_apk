package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ChunkedOutputStream
  extends FilterOutputStream
{
  private static final int DEFAULT_CHUNK_SIZE = 4096;
  private final int chunkSize;
  
  public ChunkedOutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 4096);
  }
  
  public ChunkedOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.chunkSize = paramInt;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    while (paramInt2 > 0)
    {
      int i = Math.min(paramInt2, this.chunkSize);
      this.out.write(paramArrayOfByte, paramInt1, i);
      paramInt2 -= i;
      paramInt1 += i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.ChunkedOutputStream
 * JD-Core Version:    0.7.0.1
 */