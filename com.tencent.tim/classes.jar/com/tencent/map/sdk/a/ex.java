package com.tencent.map.sdk.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ex
  extends ee<Object>
{
  public static final ef a = new ex.1();
  private final dn b;
  
  private ex(dn paramdn)
  {
    this.b = paramdn;
  }
  
  public final Object a(fe paramfe)
    throws IOException
  {
    Object localObject = paramfe.f();
    switch (ex.2.a[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      localObject = new ArrayList();
      paramfe.a();
      while (paramfe.e()) {
        ((List)localObject).add(a(paramfe));
      }
      paramfe.b();
      return localObject;
    case 2: 
      localObject = new em();
      paramfe.c();
      while (paramfe.e()) {
        ((Map)localObject).put(paramfe.h(), a(paramfe));
      }
      paramfe.d();
      return localObject;
    case 3: 
      return paramfe.i();
    case 4: 
      return Double.valueOf(paramfe.l());
    case 5: 
      return Boolean.valueOf(paramfe.j());
    }
    paramfe.k();
    return null;
  }
  
  public final void a(fg paramfg, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramfg.e();
      return;
    }
    ee localee = this.b.a(paramObject.getClass());
    if ((localee instanceof ex))
    {
      paramfg.c();
      paramfg.d();
      return;
    }
    localee.a(paramfg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ex
 * JD-Core Version:    0.7.0.1
 */