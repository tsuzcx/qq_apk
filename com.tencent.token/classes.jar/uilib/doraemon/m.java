package uilib.doraemon;

public class m
{
  private static boolean a = false;
  private static String[] b;
  private static long[] c;
  private static int d = 0;
  private static int e = 0;
  
  public static void a(String paramString)
  {
    if (!a) {
      return;
    }
    if (d == 20)
    {
      e += 1;
      return;
    }
    b[d] = paramString;
    c[d] = System.nanoTime();
    d += 1;
  }
  
  public static float b(String paramString)
  {
    if (e > 0) {
      e -= 1;
    }
    while (!a) {
      return 0.0F;
    }
    d -= 1;
    if (d == -1) {
      throw new IllegalStateException("Can't end trace section. There are none.");
    }
    if (!paramString.equals(b[d])) {
      throw new IllegalStateException("Unbalanced trace call " + paramString + ". Expected " + b[d] + ".");
    }
    return (float)(System.nanoTime() - c[d]) / 1000000.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.m
 * JD-Core Version:    0.7.0.1
 */