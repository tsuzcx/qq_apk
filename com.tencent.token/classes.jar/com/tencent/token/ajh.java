package com.tencent.token;

import java.io.IOException;

public final class ajh
  extends RuntimeException
{
  public IOException a;
  public IOException b;
  
  public ajh(IOException paramIOException)
  {
    super(paramIOException);
    this.a = paramIOException;
    this.b = paramIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajh
 * JD-Core Version:    0.7.0.1
 */