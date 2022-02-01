package com.tencent.token;

import java.io.Serializable;

public final class ke
  implements Serializable
{
  public static final ke a = new ke(0, 0, "CT_NONE");
  public static final ke b = new ke(1, 1, "CT_GPRS");
  public static final ke c = new ke(2, 2, "CT_WIFI");
  public static final ke d = new ke(3, 3, "CT_GPRS_WAP");
  public static final ke e = new ke(4, 4, "CT_GPRS_NET");
  public static final ke f = new ke(5, 5, "CT_3G_NET");
  private static ke[] h = new ke[6];
  private int i;
  private String j = new String();
  
  private ke(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.ke
 * JD-Core Version:    0.7.0.1
 */