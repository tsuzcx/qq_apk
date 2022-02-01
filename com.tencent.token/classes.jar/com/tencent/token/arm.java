package com.tencent.token;

import java.io.Serializable;

public final class arm
  implements Serializable
{
  public static final arm b = new arm(0, 0, "CT_NONE");
  public static final arm c = new arm(1, 1, "CT_GPRS");
  public static final arm d = new arm(2, 2, "CT_WIFI");
  public static final arm e = new arm(3, 3, "CT_GPRS_WAP");
  public static final arm f = new arm(4, 4, "CT_GPRS_NET");
  public static final arm g = new arm(5, 5, "CT_3G_NET");
  private static arm[] i = new arm[6];
  public int a;
  private String j = new String();
  
  private arm(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.arm
 * JD-Core Version:    0.7.0.1
 */