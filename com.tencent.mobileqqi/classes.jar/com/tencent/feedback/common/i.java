package com.tencent.feedback.common;

import android.os.Build;
import com.tencent.feedback.proguard.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
{
  private static i b = null;
  private boolean a = false;
  
  protected i()
  {
    String str = Build.TAGS;
    if ((str != null) && (str.contains("test-keys"))) {
      e.b("rqdp{  test-keys}", new Object[0]);
    }
    for (;;)
    {
      if ((i == 0) && (!c()) && (!d())) {
        this.a = false;
      }
      return;
      i = 0;
    }
  }
  
  public static i a()
  {
    try
    {
      if (b == null) {
        b = new i();
      }
      i locali = b;
      return locali;
    }
    finally {}
  }
  
  private static boolean c()
  {
    boolean bool = false;
    try
    {
      if (new File("/system/app/Superuser.apk").exists())
      {
        e.b("rqdp{  super_apk}", new Object[0]);
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean d()
  {
    Object localObject = a.a(new String[] { "/system/bin/sh", "-c", "type su" });
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
  
  public final boolean b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.common.i
 * JD-Core Version:    0.7.0.1
 */