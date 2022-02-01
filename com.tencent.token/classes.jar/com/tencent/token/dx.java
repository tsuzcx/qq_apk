package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Environment;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c.a;
import com.tencent.token.utils.c;
import com.tencent.token.utils.d;
import com.tencent.token.utils.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class dx
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public static d a;
  private static dx c = null;
  protected c b;
  private volatile boolean d = c.a.a;
  private volatile boolean e = c.a.b;
  private volatile boolean f = c.a.d;
  private volatile boolean g = c.a.e;
  
  static
  {
    int i = i.a("debug.file.blockcount", 24);
    long l = i.a("debug.file.keepperiod", 604800000L);
    a = new d(b(), i, 262144, 8192, "Sec.File.Tracer", 10000L, 10, ".sec.log", l);
  }
  
  public dx()
  {
    i.a(this);
    this.b = new c(a);
  }
  
  public static dx a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new dx();
      }
      return c;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    int i;
    if (paramInt <= 63)
    {
      i = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      i = c.a.h;
    }
    i.b("debug.file.tracelevel", i).commit();
  }
  
  public static void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        a(paramFile[i]);
        i += 1;
      }
    }
  }
  
  public static BufferedReader b(int paramInt)
  {
    Object localObject = a.a(System.currentTimeMillis());
    if ((localObject == null) || (!((File)localObject).isDirectory())) {
      return null;
    }
    localObject = a.b((File)localObject);
    localObject = a.a((File[])localObject);
    if ((paramInt >= 0) && (paramInt < localObject.length))
    {
      localObject = localObject[(localObject.length - paramInt - 1)];
      try
      {
        localObject = new BufferedReader(new FileReader((File)localObject));
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        return null;
      }
    }
    return null;
  }
  
  public static File b()
  {
    String str = c.a.g;
    if (c()) {
      return new File(Environment.getExternalStorageDirectory(), str);
    }
    return new File(RqdApplication.l().getFilesDir(), str);
  }
  
  public static boolean c()
  {
    String str = Environment.getExternalStorageState();
    return ("mounted".equals(str)) || ("mounted_ro".equals(str));
  }
  
  public static void h()
  {
    Object localObject = a.a(System.currentTimeMillis());
    localObject = a.b((File)localObject);
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        a(localObject[i]);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((d()) && (e()) && (this.b != null)) {
      this.b.b(paramInt, Thread.currentThread(), cc.c().s(), paramString1, paramString2, paramThrowable);
    }
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public final boolean g()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return i.a("debug.file.uploadfiledate", -1) >= 0;
  }
  
  public int j()
  {
    return i.a("debug.file.uploadfiledate", -1);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (("debug.file.tracelevel".equals(paramString)) || (paramString == null))
    {
      int i = i.a("debug.file.tracelevel", c.a.h);
      a(16, "SecTracer", "File Trace Level Changed = " + i, null);
      this.b.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dx
 * JD-Core Version:    0.7.0.1
 */