package c.t.m.g;

public final class g
{
  private static int[] a = { 0, 8, 10, 33, 65535, 50594049, 268435455, 2147483647 };
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramLong <= 0L) || (paramInt2 == 535) || (paramInt3 == 535) || (paramInt4 == 65535) || (paramLong == 65535L)) {}
    label79:
    label110:
    label117:
    label120:
    for (;;)
    {
      return false;
      paramInt2 = b.a.a;
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          if (paramInt4 == 25840) {
            continue;
          }
          int[] arrayOfInt = a;
          paramInt1 = 0;
          if (paramInt1 >= arrayOfInt.length) {
            break label117;
          }
          if (paramLong != arrayOfInt[paramInt1]) {
            break label110;
          }
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label120;
        }
        return true;
        paramInt1 = 0;
        break;
        paramInt1 += 1;
        break label79;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.g
 * JD-Core Version:    0.7.0.1
 */