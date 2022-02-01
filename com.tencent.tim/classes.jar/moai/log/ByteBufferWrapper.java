package moai.log;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

class ByteBufferWrapper
{
  private final ByteBuffer buffer;
  private boolean notFull = true;
  private int position = 0;
  
  public ByteBufferWrapper(int paramInt)
  {
    this.buffer = ByteBuffer.allocate(paramInt);
  }
  
  public ByteBufferWrapper append(char paramChar)
  {
    if (this.notFull)
    {
      if (paramChar < '') {}
      try
      {
        this.buffer.put((byte)paramChar);
        return this;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        this.notFull = false;
      }
      this.buffer.put(Character.toString(paramChar).getBytes());
      return this;
    }
    return this;
  }
  
  public ByteBufferWrapper append(int paramInt)
  {
    if (this.notFull) {
      append(Integer.toString(paramInt));
    }
    return this;
  }
  
  public ByteBufferWrapper append(long paramLong)
  {
    if (this.notFull) {
      append(Long.toString(paramLong));
    }
    return this;
  }
  
  public ByteBufferWrapper append(String paramString)
  {
    if (this.notFull)
    {
      String str = paramString;
      if (paramString == null) {
        str = "null";
      }
      int i = 0;
      int j = str.length();
      while (i < j)
      {
        append(str.charAt(i));
        i += 1;
      }
    }
    return this;
  }
  
  public ByteBufferWrapper append(ByteBufferWrapper paramByteBufferWrapper)
  {
    if (this.notFull) {}
    try
    {
      this.buffer.put(paramByteBufferWrapper.buffer.array(), 0, paramByteBufferWrapper.length());
      return this;
    }
    catch (BufferOverflowException paramByteBufferWrapper)
    {
      this.notFull = false;
    }
    return this;
  }
  
  public int capacity()
  {
    return this.buffer.capacity();
  }
  
  public void clear()
  {
    this.buffer.clear();
    this.position = 0;
    this.notFull = true;
  }
  
  public ByteBufferWrapper flip()
  {
    this.buffer.flip();
    return this;
  }
  
  public int length()
  {
    return this.buffer.position();
  }
  
  public int position()
  {
    return this.position;
  }
  
  public void setLength(int paramInt)
  {
    this.buffer.position(paramInt);
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public ByteBuffer toBuffer()
  {
    return this.buffer;
  }
  
  public String toString()
  {
    return new String(this.buffer.array(), 0, length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.ByteBufferWrapper
 * JD-Core Version:    0.7.0.1
 */