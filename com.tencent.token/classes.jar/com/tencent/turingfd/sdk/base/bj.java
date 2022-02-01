package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Process;
import java.io.File;

public class bj
{
  public static final String a = ct.a(ct.ay);
  public static final String b = ct.a(ct.az);
  public static boolean c = false;
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir(a, 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(ci.a(localStringBuilder, File.separator, "1"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, aw paramaw)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = paramaw.c(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramaw.a(paramContext, "101", "", true);
        new File(a(paramContext)).delete();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Context paramContext, aw paramaw)
  {
    long l = paramaw.c(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramaw.d(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramaw.d(paramContext, -1L);
      return;
    }
    paramaw.d(paramContext, 1L);
  }
  
  public static void c(Context paramContext, aw paramaw)
  {
    long l1 = paramaw.c(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l2);
      paramaw.a(paramContext, "502", localStringBuilder.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bj
 * JD-Core Version:    0.7.0.1
 */