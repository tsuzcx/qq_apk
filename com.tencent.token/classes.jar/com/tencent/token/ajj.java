package com.tencent.token;

public final class ajj
{
  private static ajk a;
  
  public static ajk a()
  {
    if (a == null)
    {
      ajk localajk = new ajk();
      a = localajk;
      int i;
      if ((!localajk.d) && (!localajk.c))
      {
        localajk.c = true;
        i = 0;
      }
      while (i < localajk.b)
      {
        localajk.a[i].start();
        i += 1;
        continue;
        throw new IllegalStateException("HttpCommunicator already in using or disposed!");
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajj
 * JD-Core Version:    0.7.0.1
 */