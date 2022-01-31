package com.tencent.component.network.module.cache.a;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static Comparator<a> h = new c();
  private final Context a;
  private final String b;
  private final boolean c;
  private final a<String> d;
  private final a<String> e;
  private b f;
  private AtomicInteger g = new AtomicInteger(0);
  
  public b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file cache: name can NOT be empty!");
    }
    this.a = paramContext.getApplicationContext();
    this.b = ("file" + File.separator + paramString);
    this.c = false;
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.d = new a(paramInt1);
      this.e = new a(i);
      PriorityThreadPool.getDefault().submit(new d(this));
      return;
      paramInt1 = 2147483647;
    }
  }
  
  private static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile());
  }
  
  private boolean b(String paramString, boolean paramBoolean)
  {
    a locala = d(paramBoolean);
    Object localObject = a(paramString, paramBoolean);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = new File((String)localObject);
      if (((File)localObject).isDirectory()) {
        FileUtils.delete((File)localObject);
      }
    } while (!a((File)localObject));
    locala.put(paramString, ((File)localObject).getAbsolutePath());
    f(paramBoolean);
    return true;
  }
  
  private void c(boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        String str = e(paramBoolean);
        a locala = d(paramBoolean);
        paramBoolean = TextUtils.isEmpty(str);
        if (paramBoolean) {
          return;
        }
        String[] arrayOfString = new File(str).list();
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          a[] arrayOfa = new a[arrayOfString.length];
          int i = 0;
          if (i >= arrayOfa.length)
          {
            Arrays.sort(arrayOfa, h);
            int k = arrayOfa.length;
            i = j;
            if (i >= k) {
              continue;
            }
            str = arrayOfa[i];
            if (str != null) {
              locala.put(str.b, str.a);
            }
          }
          else
          {
            arrayOfa[i] = new a(str, arrayOfString[i]);
            i += 1;
            continue;
          }
          i += 1;
        }
      }
      finally {}
    }
  }
  
  private a<String> d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d;
    }
    return this.e;
  }
  
  private String e(boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.tencent.component.network.module.cache.a.a(this.a, this.b, false);
    }
    return com.tencent.component.network.module.cache.a.b(this.a, this.b, false);
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.g.getAndIncrement() < 3) {
      return;
    }
    this.g.set(0);
    for (Object localObject = new File(e(paramBoolean));; localObject = ((File)localObject).getParentFile()) {
      if (((File)localObject).exists())
      {
        localObject = new StatFs(((File)localObject).getAbsolutePath());
        long l1 = ((StatFs)localObject).getBlockCount();
        long l2 = ((StatFs)localObject).getBlockSize();
        long l3 = ((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize();
        localObject = this.f;
        if ((l3 >= 10485760L) || (localObject == null)) {
          break;
        }
        ((b)localObject).a(this, l1 * l2, l3, paramBoolean);
        return;
      }
    }
  }
  
  public final int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d.size();
    }
    return this.e.size();
  }
  
  public final Context a()
  {
    return this.a;
  }
  
  public final String a(String paramString)
  {
    return a(paramString, com.tencent.component.network.module.cache.a.a());
  }
  
  public final String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return null;
      str = e(paramBoolean);
    } while (str == null);
    return str + File.separator + paramString;
  }
  
  public final void a(b paramb)
  {
    this.f = paramb;
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    try
    {
      d(paramBoolean).trimToSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d.maxSize();
    }
    return this.e.maxSize();
  }
  
  public final File b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = com.tencent.component.network.module.cache.a.a();
      Object localObject1 = (String)d(bool).get(paramString);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (!a((File)localObject1))
        {
          localObject2 = localObject1;
          if (bool)
          {
            paramString = (String)d(false).get(paramString);
            if (paramString != null) {
              break label90;
            }
          }
        }
      }
      label90:
      for (Object localObject2 = null;; localObject2 = new File(paramString))
      {
        if (!a((File)localObject2)) {
          break label103;
        }
        return localObject2;
        localObject1 = new File((String)localObject1);
        break;
      }
    }
    label103:
    return null;
  }
  
  public final boolean c(String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    boolean bool3;
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool3 = com.tencent.component.network.module.cache.a.a();
        bool2 = b(paramString, bool3);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (!bool3);
    return b(paramString, false);
  }
  
  public final void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    d(false).remove(paramString);
    d(true).remove(paramString);
    String str = a(paramString, false);
    paramString = a(paramString, true);
    FileUtils.delete(str);
    FileUtils.delete(paramString);
  }
  
  public final String toString()
  {
    return "AlbumUtil#" + this.b + "#capacity=" + b(true) + "," + b(false) + "#size=" + a(true) + "," + a(false);
  }
  
  static final class a
  {
    public final String a;
    public final String b;
    public final long c;
    
    public a(String paramString1, String paramString2)
    {
      paramString1 = new File(paramString1, paramString2);
      this.a = paramString1.getPath();
      this.b = paramString2;
      this.c = paramString1.lastModified();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(b paramb, long paramLong1, long paramLong2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a.b
 * JD-Core Version:    0.7.0.1
 */