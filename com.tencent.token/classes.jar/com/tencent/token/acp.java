package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public final class acp
{
  public static final afj<acp> a = new a();
  public Object b = new Object();
  
  private static String b(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(aeu.a(localStringBuilder, File.separator, "8"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    return aeu.a(localStringBuilder, File.separator, "2");
  }
  
  public final int a(Context paramContext)
  {
    try
    {
      synchronized (this.b)
      {
        String str = b(paramContext);
        if (!TextUtils.isEmpty(str)) {
          i = Integer.parseInt(new String(aey.b(str)));
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      label44:
      break label44;
    }
    i = 0;
    paramContext = b(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      aey.a(paramContext, "0".getBytes());
    }
    return i;
    throw paramContext;
  }
  
  public static final class a
    extends afj<acp>
  {
    public final Object a()
    {
      return new acp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acp
 * JD-Core Version:    0.7.0.1
 */