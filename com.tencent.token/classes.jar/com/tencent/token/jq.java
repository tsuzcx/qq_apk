package com.tencent.token;

import java.io.Serializable;

public final class jq
  implements Serializable
{
  public static final jq a = new jq(0, 0, "CT_NONE");
  public static final jq b = new jq(1, 1, "CT_GPRS");
  public static final jq c = new jq(2, 2, "CT_WIFI");
  public static final jq d = new jq(3, 3, "CT_GPRS_WAP");
  public static final jq e = new jq(4, 4, "CT_GPRS_NET");
  public static final jq f = new jq(5, 5, "CT_3G_NET");
  private static jq[] h = new jq[6];
  private int i;
  private String j = new String();
  
  private jq(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.jq
 * JD-Core Version:    0.7.0.1
 */