package com.tencent.token.global;

import android.content.Context;
import android.content.res.Resources;

public final class d
{
  public int a = -1;
  public String b = "";
  public String c = "";
  public Object d = null;
  
  public d()
  {
    this((byte)0);
    a(0, null, null);
  }
  
  public d(byte paramByte) {}
  
  public d(String paramString1, String paramString2)
  {
    this((byte)0);
    a(10000, paramString1, paramString2);
  }
  
  public static void a(Resources paramResources, d paramd)
  {
    if ((paramd.c != null) && (paramd.c.length() > 0)) {
      return;
    }
    String str1 = null;
    switch (paramd.a)
    {
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = paramResources.getString(2131361951) + "(" + paramd.a + ")";
      }
      paramd.c = str2;
      return;
      str1 = paramResources.getString(2131361943) + "(" + paramd.a + ")";
      continue;
      str1 = paramResources.getString(2131361945);
      continue;
      str1 = paramResources.getString(2131361944) + "(" + paramd.a + ")";
    }
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    if (paramString1 != null)
    {
      this.b = paramString1;
      if (paramString2 == null) {
        break label106;
      }
      paramString1 = paramString2;
      label20:
      this.c = paramString1;
      if ((this.c.indexOf("(") == -1) && (this.c.indexOf(")") == -1)) {
        if (paramString2 == null) {
          break label112;
        }
      }
    }
    label106:
    label112:
    for (paramString1 = paramString2 + "(" + paramInt + ")";; paramString1 = "")
    {
      this.c = paramString1;
      a(RqdApplication.i().getResources(), this);
      return;
      paramString1 = "";
      break;
      paramString1 = "";
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.d
 * JD-Core Version:    0.7.0.1
 */