package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.base.Longan;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afa
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
      paramContext = new File(aeu.a((StringBuilder)???, File.separator, "3"));
      if ((paramContext.exists()) || (paramContext.mkdirs()))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(paramContext.getAbsolutePath());
        paramContext = aeu.a((StringBuilder)???, File.separator, "0");
        break label96;
      }
    }
    paramContext = "";
    label96:
    if (TextUtils.isEmpty(paramContext)) {
      return b;
    }
    try
    {
      synchronized (a)
      {
        paramContext = aey.c(paramContext);
        paramContext = new String(aey.b(aey.b(paramContext, aey.b())));
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
 * Qualified Name:     com.tencent.token.afa
 * JD-Core Version:    0.7.0.1
 */