package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class co
{
  public static final Object a = new Object();
  public static Longan b = new Longan();
  
  static
  {
    new AtomicBoolean(false);
  }
  
  public static Longan a(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext != null)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramContext.getAbsolutePath());
      paramContext = new File(ci.a((StringBuilder)???, File.separator, "3"));
      if ((paramContext.exists()) || (paramContext.mkdirs())) {}
    }
    else
    {
      paramContext = "";
      break label96;
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramContext.getAbsolutePath());
    paramContext = ci.a((StringBuilder)???, File.separator, "0");
    label96:
    if (TextUtils.isEmpty(paramContext)) {
      return b;
    }
    try
    {
      synchronized (a)
      {
        paramContext = cm.c(paramContext);
        paramContext = new String(cm.c(cm.b(paramContext, cm.b())));
        paramContext = paramContext.split("_");
        ??? = new Longan();
        ((Longan)???).td = new ArrayList(Arrays.asList(paramContext));
        return ???;
      }
    }
    catch (Throwable paramContext)
    {
      label175:
      break label175;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.co
 * JD-Core Version:    0.7.0.1
 */