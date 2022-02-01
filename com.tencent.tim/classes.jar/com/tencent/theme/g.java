package com.tencent.theme;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class g
{
  Resources a = null;
  SkinEngine b;
  a c = null;
  int d = 0;
  HashMap<String, Integer> e = new HashMap();
  HashSet<String> f = new HashSet();
  
  public g(SkinEngine paramSkinEngine, Resources paramResources)
  {
    this.a = paramResources;
    this.d = 0;
    this.b = paramSkinEngine;
    this.c = new a(null);
  }
  
  public Integer a(String paramString)
  {
    return (Integer)this.e.get(paramString);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.c != null)
    {
      bool1 = bool2;
      if (this.c.getStatus() == AsyncTask.Status.RUNNING) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.c != null)
    {
      if (this.c.getStatus() == AsyncTask.Status.PENDING)
      {
        d();
        this.c.execute(new Void[0]);
      }
      do
      {
        return;
        if (this.c.getStatus() == AsyncTask.Status.RUNNING)
        {
          this.c.cancel(true);
          d();
          this.c = new a(null);
          this.c.execute(new Void[0]);
          return;
        }
      } while (this.c.getStatus() != AsyncTask.Status.FINISHED);
      this.c = new a(null);
      d();
      this.c.execute(new Void[0]);
      return;
    }
    this.c = new a(null);
    d();
    this.c.execute(new Void[0]);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.f.contains(paramString);
  }
  
  public void c()
  {
    new TypedValue();
    long l1 = SystemClock.uptimeMillis();
    h.d("SkinEngine", 2, "[record]start,  pid:" + Process.myPid(), null);
    this.d = 0;
    File localFile = this.b.getThemeDirFile();
    if ((localFile != null) && (localFile.exists()))
    {
      String[] arrayOfString = localFile.list();
      if ((arrayOfString != null) && (arrayOfString.length != 0))
      {
        int k = arrayOfString.length;
        int i = 0;
        while (i < k)
        {
          String str1 = arrayOfString[i];
          Object localObject = new File(localFile, str1 + "/");
          if (((File)localObject).exists())
          {
            localObject = ((File)localObject).list();
            if (localObject != null)
            {
              int m = localObject.length;
              int j = 0;
              if (j < m)
              {
                String str2 = localObject[j];
                str2 = str2.substring(str2.lastIndexOf("/") + 1);
                int n = this.b.getDrawableDpi(str1 + "/");
                if (-1 == n) {}
                for (;;)
                {
                  j += 1;
                  break;
                  if (-2 == n)
                  {
                    this.f.add(str2);
                    this.d += 1;
                  }
                  else
                  {
                    this.e.put(str2, Integer.valueOf(n));
                    this.d += 1;
                  }
                }
              }
            }
          }
          i += 1;
        }
      }
    }
    long l2 = SystemClock.uptimeMillis();
    h.d("SkinEngine", 2, "[record]end, mCacheEntry:" + this.d + " pid:" + Process.myPid() + " touchCacheDuration:" + (l2 - l1), null);
  }
  
  protected void d()
  {
    this.e.clear();
    this.d = 0;
  }
  
  class a
    extends AsyncTask<Void, Void, Void>
  {
    private a() {}
    
    protected Void a(Void... paramVarArgs)
    {
      g.this.c();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.g
 * JD-Core Version:    0.7.0.1
 */