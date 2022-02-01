package tmsdk.common.c.a;

import java.util.ArrayList;

public final class f
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
        long l1 = System.currentTimeMillis();
        long l2 = f - l1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" couldNotConnect() diff: ");
        localStringBuilder.append(l2);
        localStringBuilder.toString();
        if (l2 > 5184000L)
        {
          i = 1;
          if (f - l1 < 0L) {
            break label110;
          }
          j = 1;
          return (i == 0) && (j != 0);
        }
      }
      int i = 0;
      continue;
      label110:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.f
 * JD-Core Version:    0.7.0.1
 */