package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.token.global.RqdApplication;

public final class xh
{
  public int a;
  public String b;
  public String c;
  public Object d;
  public Object e;
  
  public xh()
  {
    a();
  }
  
  public xh(byte paramByte)
  {
    this();
    a(0, null, null);
  }
  
  public xh(String paramString1, String paramString2)
  {
    this();
    a(10000, paramString1, paramString2);
  }
  
  public static void a(Resources paramResources, xh paramxh)
  {
    Object localObject1 = paramxh.c;
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      return;
    }
    localObject1 = null;
    int i = paramxh.a;
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
            ((StringBuilder)localObject1).append(paramResources.getString(2131493104));
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(paramxh.a);
            ((StringBuilder)localObject1).append(")");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramResources.getString(2131493103));
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(paramxh.a);
          ((StringBuilder)localObject1).append(")");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramResources.getString(2131493106));
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramxh.a);
        ((StringBuilder)localObject1).append(")");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else {
      localObject1 = paramResources.getString(2131493105);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramResources.getString(2131493106));
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramxh.a);
      ((StringBuilder)localObject1).append(")");
      localObject2 = ((StringBuilder)localObject1).toString();
    }
    paramxh.c = ((String)localObject2);
  }
  
  public final void a()
  {
    this.a = -1;
    this.b = "";
    this.c = "";
    this.d = null;
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
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
    a(RqdApplication.p().getResources(), this);
  }
  
  public final void a(xh paramxh)
  {
    a(paramxh.a, paramxh.b, paramxh.c);
  }
  
  public final void a(String paramString)
  {
    this.a = 0;
    this.c = paramString;
  }
  
  public final boolean b()
  {
    return this.a == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xh
 * JD-Core Version:    0.7.0.1
 */