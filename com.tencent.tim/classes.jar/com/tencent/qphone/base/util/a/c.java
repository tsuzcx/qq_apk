package com.tencent.qphone.base.util.a;

import java.io.IOException;
import java.io.Writer;

public abstract class c
  extends Writer
{
  protected c(Object paramObject)
  {
    super(paramObject);
  }
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.c
 * JD-Core Version:    0.7.0.1
 */