package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.io.File;

public final class adv
{
  public static final String a = aff.a(aff.ay);
  public static final String b = aff.a(aff.az);
  public static boolean c = false;
  
  public static void a(Context paramContext, adi paramadi)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = adi.c(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramadi.a(paramContext, "101", "", true);
        paramContext = paramContext.getDir(a, 0);
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          paramadi = new StringBuilder();
          paramadi.append(paramContext.getAbsolutePath());
          paramContext = new File(aeu.a(paramadi, File.separator, "1"));
          if ((!paramContext.exists()) && (!paramContext.mkdirs()))
          {
            paramContext = "";
          }
          else
          {
            paramadi = new StringBuilder();
            paramadi.append(paramContext.getAbsolutePath());
            paramadi.append(File.separator);
            paramadi.append(b);
            paramContext = paramadi.toString();
          }
        }
        new File(paramContext).delete();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Context paramContext, adi paramadi)
  {
    long l = adi.c(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramadi.c(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramadi.c(paramContext, -1L);
      return;
    }
    paramadi.c(paramContext, 1L);
  }
  
  public static void c(Context paramContext, adi paramadi)
  {
    long l1 = adi.c(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2) {
      paramadi.a(paramContext, "502", String.valueOf(l2), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adv
 * JD-Core Version:    0.7.0.1
 */