package com.tencent.token;

import java.io.IOException;

public final class ald
  extends RuntimeException
{
  public IOException a;
  public IOException b;
  
  public ald(IOException paramIOException)
  {
    super(paramIOException);
    this.a = paramIOException;
    this.b = paramIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ald
 * JD-Core Version:    0.7.0.1
 */