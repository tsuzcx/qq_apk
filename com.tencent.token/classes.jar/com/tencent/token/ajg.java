package com.tencent.token;

import java.io.IOException;

public final class ajg
  extends RuntimeException
{
  public IOException a;
  public IOException b;
  
  public ajg(IOException paramIOException)
  {
    super(paramIOException);
    this.a = paramIOException;
    this.b = paramIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajg
 * JD-Core Version:    0.7.0.1
 */