package com.tencent.token;

import java.io.IOException;

public final class amg
  extends IOException
{
  public final alu a;
  
  public amg(alu paramalu)
  {
    super("stream was reset: ".concat(String.valueOf(paramalu)));
    this.a = paramalu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amg
 * JD-Core Version:    0.7.0.1
 */