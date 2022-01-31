package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Environment;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.e;
import com.tencent.token.utils.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class gb
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public static e a;
  private static gb c = null;
  protected com.tencent.token.utils.c b;
  private volatile boolean d = com.tencent.token.global.c.a;
  private volatile boolean e = com.tencent.token.global.c.b;
  private volatile boolean f = com.tencent.token.global.c.d;
  private volatile boolean g = com.tencent.token.global.c.e;
  
  static
  {
    int i = p.a("debug.file.blockcount", 24);
    long l = p.a("debug.file.keepperiod");
    a = new e(b(), i, "Sec.File.Tracer", ".sec.log", l);
  }
  
  public gb()
  {
    p.a(this);
    this.b = new com.tencent.token.utils.c(a);
  }
  
  public static gb a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new gb();
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
      i = com.tencent.token.global.c.h;
    }
    p.b("debug.file.tracelevel", i).commit();
  }
  
  private static void a(File paramFile)
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
      catch (FileNotFoundException localFileNotFoundException) {}
    }
    return null;
  }
  
  public static File b()
  {
    String str1 = com.tencent.token.global.c.g;
    String str2 = Environment.getExternalStorageState();
    if (("mounted".equals(str2)) || ("mounted_ro".equals(str2))) {}
    for (int i = 1; i != 0; i = 0) {
      return new File(Environment.getExternalStorageDirectory(), str1);
    }
    return new File(RqdApplication.i().getFilesDir(), str1);
  }
  
  public static void e()
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
  
  public static boolean f()
  {
    return p.a("debug.file.uploadfiledate", -1) >= 0;
  }
  
  public static int g()
  {
    return p.a("debug.file.uploadfiledate", -1);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.d) && (this.e) && (this.b != null)) {
      this.b.b(paramInt, Thread.currentThread(), ag.c().r(), paramString1, paramString2);
    }
  }
  
  public final boolean c()
  {
    return this.f;
  }
  
  public final boolean d()
  {
    return this.g;
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (("debug.file.tracelevel".equals(paramString)) || (paramString == null))
    {
      int i = p.a("debug.file.tracelevel", com.tencent.token.global.c.h);
      a(16, "SecTracer", "File Trace Level Changed = " + i);
      this.b.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gb
 * JD-Core Version:    0.7.0.1
 */