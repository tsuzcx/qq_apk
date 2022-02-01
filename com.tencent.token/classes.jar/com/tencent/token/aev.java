package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

public final class aev
{
  public static final String a = agg.a(agg.aA);
  public static final String b = agg.a(agg.aB);
  public static boolean c = false;
  
  public static void a(Context paramContext, aef paramaef)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = aef.b(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != 0) && (i != l))
      {
        paramaef.a(paramContext, "101", "", true);
        aef.c(paramContext, 0L);
        paramaef = new HashMap();
        paramaef.put("901", "");
        aef.a(paramContext, paramaef);
        paramContext = paramContext.getDir(a, 0);
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          paramaef = new StringBuilder();
          paramaef.append(paramContext.getAbsolutePath());
          paramContext = File.separator;
          paramaef.append(paramContext);
          paramaef.append("1");
          paramaef = new File(paramaef.toString());
          if ((!paramaef.exists()) && (!paramaef.mkdirs()))
          {
            paramContext = "";
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramaef.getAbsolutePath());
            localStringBuilder.append(paramContext);
            localStringBuilder.append(b);
            paramContext = localStringBuilder.toString();
          }
        }
        new File(paramContext).delete();
        return;
      }
    }
    finally
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aev
 * JD-Core Version:    0.7.0.1
 */