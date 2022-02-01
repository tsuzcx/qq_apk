package com.tencent.token;

import java.util.concurrent.TimeUnit;

public final class afg
{
  public static final long a;
  public static final long b;
  public static final int c;
  
  static
  {
    long l1 = TimeUnit.SECONDS.toMillis(1L);
    a = l1;
    long l2 = TimeUnit.MILLISECONDS.toMillis(50L);
    b = l2;
    c = (int)(l1 / l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afg
 * JD-Core Version:    0.7.0.1
 */