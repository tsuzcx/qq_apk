package com.tencent.moai.mailsdk.util.stream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SharedByteArrayInputStream
  extends ByteArrayInputStream
  implements SharedInputStream
{
  protected int start = 0;
  
  public SharedByteArrayInputStream(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public SharedByteArrayInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
    this.start = paramInt1;
  }
  
  public long getPosition()
  {
    return this.pos - this.start;
  }
  
  public InputStream newStream(long paramLong1, long paramLong2)
  {
    if (paramLong1 < 0L) {
      throw new IllegalArgumentException("start < 0");
    }
    long l = paramLong2;
    if (paramLong2 == -1L) {
      l = this.count - this.start;
    }
    return new SharedByteArrayInputStream(this.buf, this.start + (int)paramLong1, (int)(l - paramLong1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.SharedByteArrayInputStream
 * JD-Core Version:    0.7.0.1
 */