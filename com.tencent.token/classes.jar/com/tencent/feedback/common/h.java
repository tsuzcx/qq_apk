package com.tencent.feedback.common;

import android.content.Context;
import android.os.Build;
import com.tencent.feedback.proguard.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  private static h b;
  private static Context c;
  private boolean a = false;
  
  protected h()
  {
    int i = 1;
    this.a = true;
    String str = Build.TAGS;
    if ((str != null) && (str.contains("test-keys"))) {
      e.b("rqdp{  test-keys}", new Object[0]);
    } else {
      i = 0;
    }
    if ((i == 0) && (!b()) && (!c())) {
      this.a = false;
    }
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        b = new h();
        c = paramContext;
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static boolean b()
  {
    try
    {
      if (new File("/system/app/Superuser.apk").exists())
      {
        e.b("rqdp{  super_apk}", new Object[0]);
        return true;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean c()
  {
    Object localObject = a.a(c, new String[] { "/system/bin/sh", "-c", "type su" });
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        e.b(str, new Object[0]);
        if (str.contains("not found")) {
          return false;
        }
      }
      e.b("rqdp{  sufile}", new Object[0]);
      return true;
    }
    e.b("rqdp{  no response}", new Object[0]);
    return false;
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.h
 * JD-Core Version:    0.7.0.1
 */