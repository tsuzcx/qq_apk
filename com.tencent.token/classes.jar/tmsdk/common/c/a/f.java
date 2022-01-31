package tmsdk.common.c.a;

import java.util.ArrayList;

public final class f
{
  private static volatile boolean a = false;
  private static volatile String b = null;
  private static volatile boolean c = false;
  private static volatile boolean d = false;
  private static volatile long e = 0L;
  private static volatile long f = 0L;
  private static Object g = new Object();
  private static ArrayList h = new ArrayList();
  
  public static boolean a()
  {
    synchronized (g)
    {
      long l1 = System.currentTimeMillis();
      long l2 = f - l1;
      new StringBuilder().append(" couldNotConnect() diff: ").append(l2).toString();
      int i;
      if (l2 > 5184000L)
      {
        i = 1;
        if (f - l1 < 0L) {
          break label81;
        }
      }
      label81:
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j == 0)) {
          break label86;
        }
        return true;
        i = 0;
        break;
      }
      label86:
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.f
 * JD-Core Version:    0.7.0.1
 */