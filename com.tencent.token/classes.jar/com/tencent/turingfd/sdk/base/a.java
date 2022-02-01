package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public class a
{
  public static final cx<a> a = new a();
  
  public static a a()
  {
    return (a)a.b();
  }
  
  public ak a(Context paramContext, int paramInt)
  {
    try
    {
      Virgo localVirgo = new Virgo();
      localVirgo.a(new cy(cm.b(b(paramContext, paramInt))));
      paramContext = new ak(paramContext, localVirgo);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return null;
  }
  
  public void a(Context paramContext, int paramInt, ak paramak)
  {
    Virgo localVirgo = new Virgo();
    localVirgo.qb = paramInt;
    localVirgo.rb = paramak.j;
    localVirgo.sb = paramak.i;
    localVirgo.tb = paramak.h;
    localVirgo.ub = paramak.e;
    localVirgo.vb = paramak.f;
    paramak = paramak.c;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramak.b())
    {
      localArrayList.add((Long)paramak.a(i));
      i += 1;
    }
    localVirgo.wb = localArrayList;
    paramak = localVirgo.c();
    cm.a(b(paramContext, paramInt), paramak);
  }
  
  public final String b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(ci.a(localStringBuilder, File.separator, "11"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(49);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static final class a
    extends cx<a>
  {
    public Object a()
    {
      return new a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.a
 * JD-Core Version:    0.7.0.1
 */