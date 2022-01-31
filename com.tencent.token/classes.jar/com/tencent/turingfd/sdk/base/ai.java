package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class ai
{
  public static final dj a = new ah();
  
  public static ai a()
  {
    return (ai)a.b();
  }
  
  public eg a(Context paramContext, int paramInt)
  {
    try
    {
      Centaurus localCentaurus = new Centaurus();
      localCentaurus.a(new dp(ed.b(b(paramContext, paramInt))));
      paramContext = new eg(paramContext, localCentaurus);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public void a(Context paramContext, int paramInt, eg parameg)
  {
    Centaurus localCentaurus = new Centaurus();
    localCentaurus.pb = paramInt;
    localCentaurus.qb = parameg.j;
    localCentaurus.rb = parameg.i;
    localCentaurus.sb = parameg.h;
    localCentaurus.tb = parameg.e;
    localCentaurus.ub = parameg.f;
    parameg = parameg.c;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parameg.b())
    {
      localArrayList.add((Long)parameg.b.get(i));
      i += 1;
    }
    localCentaurus.vb = localArrayList;
    parameg = localCentaurus.c();
    ed.a(b(paramContext, paramInt), parameg);
  }
  
  public final String b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + "11");
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    return paramContext.getAbsolutePath() + File.separator + 32 + "_" + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ai
 * JD-Core Version:    0.7.0.1
 */