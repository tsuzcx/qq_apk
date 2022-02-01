package b;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public static final a a = new a(0, 0, "CT_NONE");
  public static final a b = new a(1, 1, "CT_GPRS");
  public static final a c = new a(2, 2, "CT_WIFI");
  public static final a d = new a(3, 3, "CT_GPRS_WAP");
  public static final a e = new a(4, 4, "CT_GPRS_NET");
  public static final a f = new a(5, 5, "CT_3G_NET");
  private static a[] h = new a[6];
  private int i;
  private String j = new String();
  
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