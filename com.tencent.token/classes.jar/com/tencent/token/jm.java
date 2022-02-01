package com.tencent.token;

import java.io.Serializable;

public final class jm
  implements Serializable
{
  public static final jm a = new jm(0, 0, "CT_NONE");
  public static final jm b = new jm(1, 1, "CT_GPRS");
  public static final jm c = new jm(2, 2, "CT_WIFI");
  public static final jm d = new jm(3, 3, "CT_GPRS_WAP");
  public static final jm e = new jm(4, 4, "CT_GPRS_NET");
  public static final jm f = new jm(5, 5, "CT_3G_NET");
  private static jm[] h = new jm[6];
  private int i;
  private String j = new String();
  
  private jm(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.jm
 * JD-Core Version:    0.7.0.1
 */