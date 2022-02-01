package com.tencent.token;

import java.io.Serializable;

public final class jn
  implements Serializable
{
  public static final jn a = new jn(0, 0, "CT_NONE");
  public static final jn b = new jn(1, 1, "CT_GPRS");
  public static final jn c = new jn(2, 2, "CT_WIFI");
  public static final jn d = new jn(3, 3, "CT_GPRS_WAP");
  public static final jn e = new jn(4, 4, "CT_GPRS_NET");
  public static final jn f = new jn(5, 5, "CT_3G_NET");
  private static jn[] h = new jn[6];
  private int i;
  private String j = new String();
  
  private jn(int paramInt1, int paramInt2, String paramString)
  {
    this.j = paramString;
    this.i = paramInt2;
    h[paramInt1] = this;
  }
  
  public final String toString()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jn
 * JD-Core Version:    0.7.0.1
 */