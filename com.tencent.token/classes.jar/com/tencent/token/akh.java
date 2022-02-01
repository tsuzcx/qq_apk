package com.tencent.token;

public final class akh
{
  private static aki a;
  
  public static aki a()
  {
    if (a == null)
    {
      aki localaki = new aki();
      a = localaki;
      int i;
      if ((!localaki.d) && (!localaki.c))
      {
        localaki.c = true;
        i = 0;
      }
      while (i < localaki.b)
      {
        localaki.a[i].start();
        i += 1;
        continue;
        throw new IllegalStateException("HttpCommunicator already in using or disposed!");
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akh
 * JD-Core Version:    0.7.0.1
 */