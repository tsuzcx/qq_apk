package com.tencent.token.global;

import android.content.Context;
import android.content.res.Resources;

public class e
{
  public int a;
  public String b;
  public String c;
  public Object d;
  
  public e()
  {
    a();
  }
  
  public e(int paramInt)
  {
    this();
    b(paramInt);
  }
  
  public e(int paramInt, String paramString1, String paramString2)
  {
    this();
    a(paramInt, paramString1, paramString2);
  }
  
  public static void a(Resources paramResources, e parame)
  {
    if ((parame.c != null) && (parame.c.length() > 0)) {
      return;
    }
    String str1 = null;
    switch (parame.a)
    {
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = paramResources.getString(2131230963) + "(" + parame.a + ")";
      }
      parame.c = str2;
      return;
      str1 = paramResources.getString(2131230960) + "(" + parame.a + ")";
      continue;
      str1 = paramResources.getString(2131230963) + "(" + parame.a + ")";
      continue;
      str1 = paramResources.getString(2131230962);
      continue;
      str1 = paramResources.getString(2131230961) + "(" + parame.a + ")";
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void a()
  {
    this.a = -1;
    this.b = "";
    this.c = "";
    this.d = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
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
      a(RqdApplication.l().getResources(), this);
      return;
      paramString1 = "";
      break;
      paramString1 = "";
      break label20;
    }
  }
  
  public void a(e parame)
  {
    a(parame.a, parame.b, parame.c);
  }
  
  public void a(String paramString)
  {
    c();
    this.c = paramString;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, null, null);
  }
  
  public boolean b()
  {
    return this.a == 0;
  }
  
  public void c()
  {
    this.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.e
 * JD-Core Version:    0.7.0.1
 */