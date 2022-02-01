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
    Object localObject1 = parame.c;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      return;
    }
    localObject1 = null;
    int i = parame.a;
    if (i != 103)
    {
      if (i != 10005)
      {
        if (i != 100004)
        {
          switch (i)
          {
          default: 
            break;
          case 10001: 
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramResources.getString(2131493103));
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(parame.a);
            ((StringBuilder)localObject1).append(")");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramResources.getString(2131493102));
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(parame.a);
          ((StringBuilder)localObject1).append(")");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramResources.getString(2131493105));
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(parame.a);
        ((StringBuilder)localObject1).append(")");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else {
      localObject1 = paramResources.getString(2131493104);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResources.getString(2131493105));
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(parame.a);
      ((StringBuilder)localObject1).append(")");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    parame.c = ((String)localObject2);
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt != 10005) && (paramInt != 100004)) {
      switch (paramInt)
      {
      default: 
        return false;
      }
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
    if (paramString1 == null) {
      paramString1 = "";
    }
    this.b = paramString1;
    if (paramString2 != null) {
      paramString1 = paramString2;
    } else {
      paramString1 = "";
    }
    this.c = paramString1;
    if ((this.c.indexOf("(") == -1) && (this.c.indexOf(")") == -1))
    {
      if (paramString2 != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("(");
        paramString1.append(paramInt);
        paramString1.append(")");
        paramString1 = paramString1.toString();
      }
      else
      {
        paramString1 = "";
      }
      this.c = paramString1;
    }
    a(RqdApplication.l().getResources(), this);
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