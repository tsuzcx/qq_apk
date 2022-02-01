package com.tencent.token;

public final class ahn
{
  private static aho a;
  
  public static aho a()
  {
    if (a == null)
    {
      aho localaho = new aho();
      a = localaho;
      int i;
      if ((!localaho.d) && (!localaho.c))
      {
        localaho.c = true;
        i = 0;
      }
      while (i < localaho.b)
      {
        localaho.a[i].start();
        i += 1;
        continue;
        throw new IllegalStateException("HttpCommunicator already in using or disposed!");
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahn
 * JD-Core Version:    0.7.0.1
 */