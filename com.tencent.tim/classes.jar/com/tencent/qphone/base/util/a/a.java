package com.tencent.qphone.base.util.a;

import java.io.IOException;

public abstract interface a
{
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract void write(int paramInt)
    throws IOException;
  
  public abstract void write(String paramString)
    throws IOException;
  
  public abstract void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.a
 * JD-Core Version:    0.7.0.1
 */