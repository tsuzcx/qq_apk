package uilib.doraemon;

public class g
{
  private static boolean a = false;
  private static String[] b;
  private static long[] c;
  private static int d;
  private static int e;
  
  public static void a(String paramString)
  {
    if (!a) {
      return;
    }
    int i = d;
    if (i == 20)
    {
      e += 1;
      return;
    }
    b[i] = paramString;
    c[i] = System.nanoTime();
    d += 1;
  }
  
  public static float b(String paramString)
  {
    int i = e;
    if (i > 0)
    {
      e = i - 1;
      return 0.0F;
    }
    if (!a) {
      return 0.0F;
    }
    d -= 1;
    i = d;
    if (i != -1)
    {
      if (paramString.equals(b[i])) {
        return (float)(System.nanoTime() - c[d]) / 1000000.0F;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unbalanced trace call ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(". Expected ");
      localStringBuilder.append(b[d]);
      localStringBuilder.append(".");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Can't end trace section. There are none.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.g
 * JD-Core Version:    0.7.0.1
 */