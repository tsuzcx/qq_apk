package b;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public static final a a;
  public static final a b;
  public static final a c;
  public static final a d;
  public static final a e;
  public static final a f;
  private static a[] h;
  private int i;
  private String j = new String();
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      h = new a[6];
      a = new a(0, 0, "CT_NONE");
      b = new a(1, 1, "CT_GPRS");
      c = new a(2, 2, "CT_WIFI");
      d = new a(3, 3, "CT_GPRS_WAP");
      e = new a(4, 4, "CT_GPRS_NET");
      f = new a(5, 5, "CT_3G_NET");
      return;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.7.0.1
 */