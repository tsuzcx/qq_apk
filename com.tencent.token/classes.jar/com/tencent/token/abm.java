package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.base.Virgo;
import com.tencent.turingfd.sdk.base.break;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public final class abm
{
  public static final afj<abm> a = new a();
  
  public static abm a()
  {
    return (abm)a.b();
  }
  
  public static acw a(Context paramContext, int paramInt)
  {
    try
    {
      Virgo localVirgo = new Virgo();
      localVirgo.a(new afk(aey.b(b(paramContext, paramInt))));
      paramContext = new acw(paramContext, localVirgo);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label39:
      break label39;
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt, acw paramacw)
  {
    Virgo localVirgo = new Virgo();
    localVirgo.qb = paramInt;
    localVirgo.rb = paramacw.j;
    localVirgo.sb = paramacw.i;
    localVirgo.tb = paramacw.h;
    localVirgo.ub = paramacw.e;
    localVirgo.vb = paramacw.f;
    paramacw = paramacw.c;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramacw.b.size())
    {
      localArrayList.add((Long)paramacw.a(i));
      i += 1;
    }
    localVirgo.wb = localArrayList;
    paramacw = localVirgo.a();
    aey.a(b(paramContext, paramInt), paramacw);
  }
  
  private static String b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(aeu.a(localStringBuilder, File.separator, "11"));
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
    extends afj<abm>
  {
    public final Object a()
    {
      return new abm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abm
 * JD-Core Version:    0.7.0.1
 */