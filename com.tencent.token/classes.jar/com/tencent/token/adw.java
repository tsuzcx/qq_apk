package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.io.File;

public final class adw
{
  public static final String a = afg.a(afg.ay);
  public static final String b = afg.a(afg.az);
  public static boolean c = false;
  
  public static void a(Context paramContext, adj paramadj)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = adj.c(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramadj.a(paramContext, "101", "", true);
        paramContext = paramContext.getDir(a, 0);
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          paramadj = new StringBuilder();
          paramadj.append(paramContext.getAbsolutePath());
          paramContext = new File(aev.a(paramadj, File.separator, "1"));
          if ((!paramContext.exists()) && (!paramContext.mkdirs()))
          {
            paramContext = "";
          }
          else
          {
            paramadj = new StringBuilder();
            paramadj.append(paramContext.getAbsolutePath());
            paramadj.append(File.separator);
            paramadj.append(b);
            paramContext = paramadj.toString();
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
  
  public static void b(Context paramContext, adj paramadj)
  {
    long l = adj.c(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramadj.c(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramadj.c(paramContext, -1L);
      return;
    }
    paramadj.c(paramContext, 1L);
  }
  
  public static void c(Context paramContext, adj paramadj)
  {
    long l1 = adj.c(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2) {
      paramadj.a(paramContext, "502", String.valueOf(l2), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adw
 * JD-Core Version:    0.7.0.1
 */