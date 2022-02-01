package com.tencent.token;

public final class ahm
{
  private static ahn a;
  
  public static ahn a()
  {
    if (a == null)
    {
      ahn localahn = new ahn();
      a = localahn;
      int i;
      if ((!localahn.d) && (!localahn.c))
      {
        localahn.c = true;
        i = 0;
      }
      while (i < localahn.b)
      {
        localahn.a[i].start();
        i += 1;
        continue;
        throw new IllegalStateException("HttpCommunicator already in using or disposed!");
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahm
 * JD-Core Version:    0.7.0.1
 */