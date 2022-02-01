package com.tencent.token;

import java.util.ArrayList;

public final class aqz
{
  private static volatile boolean a = false;
  private static volatile String b;
  private static volatile boolean c = false;
  private static volatile boolean d = false;
  private static volatile long e;
  private static volatile long f;
  private static Object g = new Object();
  private static ArrayList h = new ArrayList();
  
  public static boolean a()
  {
    for (;;)
    {
      synchronized (g)
      {
        long l = System.currentTimeMillis();
        if (f - l > 5184000L)
        {
          i = 1;
          if (f - l < 0L) {
            break label75;
          }
          j = 1;
          return (i == 0) && (j != 0);
        }
      }
      int i = 0;
      continue;
      label75:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqz
 * JD-Core Version:    0.7.0.1
 */