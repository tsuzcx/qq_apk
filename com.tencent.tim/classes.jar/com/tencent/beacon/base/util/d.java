package com.tencent.beacon.base.util;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

public class d
{
  private static boolean a;
  
  public static boolean a()
  {
    Object localObject = e();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        c.a(str, new Object[0]);
        if (str.contains("not found")) {
          return false;
        }
      }
      c.a("[core] sufile}", new Object[0]);
      return true;
    }
    c.a("[core] no response}", new Object[0]);
    return false;
  }
  
  public static boolean b()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = new File("/system/app/Superuser.apk").exists();
      if (bool2)
      {
        c.a("[core] super_apk", new Object[0]);
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    return false;
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    String str = Build.TAGS;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (str.contains("test-keys"))
      {
        c.a("[core] test-keys", new Object[0]);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean d()
  {
    boolean bool2 = true;
    if (a) {
      return true;
    }
    boolean bool1 = bool2;
    if (!c())
    {
      bool1 = bool2;
      if (!b()) {
        if (!a()) {
          break label40;
        }
      }
    }
    label40:
    for (bool1 = bool2;; bool1 = false)
    {
      a = bool1;
      return bool1;
    }
  }
  
  private static ArrayList<String> e()
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    try
    {
      Object localObject1 = Runtime.getRuntime();
      localObject1 = ((Runtime)localObject1).exec(new String[] { "/system/bin/sh", "-c", "type su" });
      localObject3 = ((Process)localObject1).getInputStream();
      localObject3 = new BufferedReader(new InputStreamReader((InputStream)localObject3, Charset.forName("UTF-8")));
      for (;;)
      {
        str = ((BufferedReader)localObject3).readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
      localObject2 = null;
    }
    Object localObject2 = ((Process)localObject2).getErrorStream();
    Object localObject3 = new BufferedReader(new InputStreamReader((InputStream)localObject2, Charset.forName("UTF-8")));
    for (;;)
    {
      str = ((BufferedReader)localObject3).readLine();
      localObject2 = localArrayList;
      if (str == null) {
        break;
      }
      localArrayList.add(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.util.d
 * JD-Core Version:    0.7.0.1
 */