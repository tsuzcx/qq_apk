package com.tencent.token;

import java.io.Serializable;

public final class aos
  implements Serializable
{
  public static final aos b = new aos(0, 0, "CT_NONE");
  public static final aos c = new aos(1, 1, "CT_GPRS");
  public static final aos d = new aos(2, 2, "CT_WIFI");
  public static final aos e = new aos(3, 3, "CT_GPRS_WAP");
  public static final aos f = new aos(4, 4, "CT_GPRS_NET");
  public static final aos g = new aos(5, 5, "CT_3G_NET");
  private static aos[] i = new aos[6];
  public int a;
  private String j = new String();
  
  private aos(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.a = paramInt2;
    i[paramInt1] = this;
  }
  
  public final String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aos
 * JD-Core Version:    0.7.0.1
 */