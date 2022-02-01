package com.tencent.token;

import java.io.Serializable;

public final class aor
  implements Serializable
{
  public static final aor b = new aor(0, 0, "CT_NONE");
  public static final aor c = new aor(1, 1, "CT_GPRS");
  public static final aor d = new aor(2, 2, "CT_WIFI");
  public static final aor e = new aor(3, 3, "CT_GPRS_WAP");
  public static final aor f = new aor(4, 4, "CT_GPRS_NET");
  public static final aor g = new aor(5, 5, "CT_3G_NET");
  private static aor[] i = new aor[6];
  public int a;
  private String j = new String();
  
  private aor(int paramInt1, int paramInt2, String paramString)
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
 * Qualified Name:     com.tencent.token.aor
 * JD-Core Version:    0.7.0.1
 */