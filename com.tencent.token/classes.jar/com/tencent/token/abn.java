package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.base.Virgo;
import com.tencent.turingfd.sdk.base.break;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public final class abn
{
  public static final afk<abn> a = new a();
  
  public static abn a()
  {
    return (abn)a.b();
  }
  
  public static acx a(Context paramContext, int paramInt)
  {
    try
    {
      Virgo localVirgo = new Virgo();
      localVirgo.a(new afl(aez.b(b(paramContext, paramInt))));
      paramContext = new acx(paramContext, localVirgo);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label39:
      break label39;
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt, acx paramacx)
  {
    Virgo localVirgo = new Virgo();
    localVirgo.qb = paramInt;
    localVirgo.rb = paramacx.j;
    localVirgo.sb = paramacx.i;
    localVirgo.tb = paramacx.h;
    localVirgo.ub = paramacx.e;
    localVirgo.vb = paramacx.f;
    paramacx = paramacx.c;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramacx.b.size())
    {
      localArrayList.add((Long)paramacx.a(i));
      i += 1;
    }
    localVirgo.wb = localArrayList;
    paramacx = localVirgo.a();
    aez.a(b(paramContext, paramInt), paramacx);
  }
  
  private static String b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(aev.a(localStringBuilder, File.separator, "11"));
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
    extends afk<abn>
  {
    public final Object a()
    {
      return new abn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abn
 * JD-Core Version:    0.7.0.1
 */