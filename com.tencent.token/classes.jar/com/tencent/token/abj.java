package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Environment;
import com.tencent.token.global.RqdApplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class abj
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public static zv a;
  private static abj e;
  protected zu b;
  public volatile boolean c = ww.a.d;
  public volatile boolean d = ww.a.e;
  private volatile boolean f = ww.a.a;
  private volatile boolean g = ww.a.b;
  
  static
  {
    int i = zz.a("debug.file.blockcount", 24);
    long l = zz.a("debug.file.keepperiod");
    a = new zv(b(), i, "Sec.File.Tracer", ".sec.log", l);
  }
  
  public abj()
  {
    zz.a(this);
    this.b = new zu(a);
  }
  
  public static abj a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new abj();
        }
      }
      finally {}
    }
    return e;
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
      i = ww.a.h;
    }
    zz.b("debug.file.tracelevel", i).commit();
  }
  
  private static void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
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
      return;
    }
  }
  
  public static BufferedReader b(int paramInt)
  {
    Object localObject = a.b(System.currentTimeMillis());
    if (!((File)localObject).isDirectory()) {
      return null;
    }
    localObject = a.b((File)localObject);
    localObject = a.a((File[])localObject);
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      localObject = localObject[(localObject.length - paramInt - 1)];
    }
    try
    {
      localObject = new BufferedReader(new FileReader((File)localObject));
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      label72:
      break label72;
    }
    return null;
  }
  
  public static File b()
  {
    String str1 = ww.a.g;
    String str2 = Environment.getExternalStorageState();
    int i;
    if ((!"mounted".equals(str2)) && (!"mounted_ro".equals(str2))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return new File(Environment.getExternalStorageDirectory(), str1);
    }
    return new File(RqdApplication.n().getFilesDir(), str1);
  }
  
  public static void c()
  {
    Object localObject = a.b(System.currentTimeMillis());
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
  
  public static boolean d()
  {
    return zz.a("debug.file.uploadfiledate", -1) >= 0;
  }
  
  public static int e()
  {
    return zz.a("debug.file.uploadfiledate", -1);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.f) && (this.g))
    {
      zu localzu = this.b;
      if (localzu != null) {
        localzu.b(paramInt, Thread.currentThread(), qy.a().h() * 1000L, paramString1, paramString2);
      }
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (("debug.file.tracelevel".equals(paramString)) || (paramString == null))
    {
      int i = zz.a("debug.file.tracelevel", ww.a.h);
      a(16, "SecTracer", "File Trace Level Changed = ".concat(String.valueOf(i)));
      this.b.b = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abj
 * JD-Core Version:    0.7.0.1
 */