package com.tencent.token;

import java.io.Serializable;

public final class aqo
  implements Serializable
{
  public static final aqo b = new aqo(0, 0, "CT_NONE");
  public static final aqo c = new aqo(1, 1, "CT_GPRS");
  public static final aqo d = new aqo(2, 2, "CT_WIFI");
  public static final aqo e = new aqo(3, 3, "CT_GPRS_WAP");
  public static final aqo f = new aqo(4, 4, "CT_GPRS_NET");
  public static final aqo g = new aqo(5, 5, "CT_3G_NET");
  private static aqo[] i = new aqo[6];
  public int a;
  private String j = new String();
  
  private aqo(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.aqo
 * JD-Core Version:    0.7.0.1
 */