package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;

public final class ds
{
  private static final a a;
  private static final es<String, Typeface> b = new es(16);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26) {
      a = new dv();
    } else if ((Build.VERSION.SDK_INT >= 24) && (du.a())) {
      a = new du();
    } else if (Build.VERSION.SDK_INT >= 21) {
      a = new dt();
    } else {
      a = new dw();
    }
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = b(paramResources, paramInt1, paramInt2);
      b.a(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, dn.a parama, Resources paramResources, int paramInt1, int paramInt2, do.a parama1)
  {
    if ((parama instanceof dn.d))
    {
      parama = (dn.d)parama;
      boolean bool;
      if (parama.c == 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i = parama.b;
      paramContext = ek.a(paramContext, parama.a, parama1, bool, i, paramInt2);
    }
    else
    {
      parama = a.a(paramContext, (dn.b)parama, paramResources, paramInt2);
      paramContext = parama;
      if (parama1 != null) {
        if (parama != null)
        {
          parama1.a(parama, null);
          paramContext = parama;
        }
        else
        {
          parama1.a(-3, null);
          paramContext = parama;
        }
      }
    }
    if (paramContext != null) {
      b.a(b(paramResources, paramInt1, paramInt2), paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, ek.b[] paramArrayOfb, int paramInt)
  {
    return a.a(paramContext, paramArrayOfb, paramInt);
  }
  
  public static Typeface a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)b.a(b(paramResources, paramInt1, paramInt2));
  }
  
  private static String b(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  static abstract interface a
  {
    public abstract Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2);
    
    public abstract Typeface a(Context paramContext, dn.b paramb, Resources paramResources, int paramInt);
    
    public abstract Typeface a(Context paramContext, ek.b[] paramArrayOfb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ds
 * JD-Core Version:    0.7.0.1
 */