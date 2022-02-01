package com.tencent.token;

import android.content.Context;
import android.os.Process;
import com.tencent.turingfd.sdk.qps.Peach;
import java.io.File;
import java.util.HashMap;

public final class afs
{
  public static final String a = afz.a(afz.aA);
  public static final String b = afz.a(afz.aB);
  public static boolean c = false;
  
  public static void a(Context paramContext, Peach paramPeach)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = paramPeach.a(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != 0) && (i != l))
      {
        paramPeach.a(paramContext, "101", "", true);
        paramPeach.b(paramContext, 0L);
        paramPeach = new HashMap();
        paramPeach.put("901", "");
        Peach.a(paramContext, paramPeach);
        paramContext = paramContext.getDir(a, 0);
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          paramPeach = new StringBuilder();
          paramPeach.append(paramContext.getAbsolutePath());
          paramContext = File.separator;
          paramPeach.append(paramContext);
          paramPeach.append("1");
          paramPeach = new File(paramPeach.toString());
          if ((!paramPeach.exists()) && (!paramPeach.mkdirs()))
          {
            paramContext = "";
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramPeach.getAbsolutePath());
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
 * Qualified Name:     com.tencent.token.afs
 * JD-Core Version:    0.7.0.1
 */