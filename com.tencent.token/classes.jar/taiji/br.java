package taiji;

import java.util.List;

public class br
{
  private final List a;
  private final char b;
  private final double c;
  private final String d;
  private final String e;
  
  public static int a(char paramChar, String paramString1, String paramString2)
  {
    return ((paramChar + '\000') * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List a()
  {
    return this.a;
  }
  
  public double b()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    return a(this.b, this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.br
 * JD-Core Version:    0.7.0.1
 */