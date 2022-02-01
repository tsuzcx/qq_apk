package com.tencent.manager.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.manager.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class f
{
  protected static int b = 0;
  protected static int c = 1;
  protected static int d = 2;
  protected int a = 0;
  b e = null;
  b f = null;
  protected d g = new d();
  protected int h = 1;
  int i = 3;
  Map<String, a> j = new HashMap();
  protected Handler k = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramAnonymousMessage.arg1 != 0);
            f.a(f.this, System.currentTimeMillis());
          } while (f.this.e == null);
          String str = paramAnonymousMessage.getData().getString("path");
          paramAnonymousMessage = paramAnonymousMessage.getData().getString("hash");
          f.this.e.a(str, paramAnonymousMessage);
          return;
          f.this.e.a(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
          return;
        } while (f.this.e == null);
        long l1 = paramAnonymousMessage.getData().getLong("download_size");
        int i = paramAnonymousMessage.getData().getInt("progress");
        long l2 = paramAnonymousMessage.getData().getLong("total_size");
        f.this.e.a(l1, l2, i);
        return;
      } while (f.this.e == null);
      paramAnonymousMessage.getData();
    }
  };
  private int l = 200;
  private int m = 0;
  private String n;
  private long o = 0L;
  
  public static f a(Context paramContext, c paramc)
  {
    a locala = new a(paramContext, paramc);
    locala.g.a(paramContext, paramc);
    return locala;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.k.sendMessage(localMessage);
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (paramInt <= 25) {}
    for (paramInt = paramInt * 75 / 25;; paramInt = (paramInt - 25) * 25 / 75 + 75)
    {
      b(paramLong1, paramLong2, paramInt);
      return;
    }
  }
  
  protected abstract void a(g paramg, int paramInt, String paramString, c paramc);
  
  protected void a(String paramString)
  {
    this.n = paramString;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = 0;
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString1);
    localBundle.putString("hash", paramString2);
    localMessage.setData(localBundle);
    this.k.sendMessage(localMessage);
  }
  
  public boolean a(b paramb, int paramInt1, g paramg, int paramInt2, int paramInt3, String paramString, c paramc)
  {
    this.a = paramInt1;
    if (paramb != null) {
      this.e = paramb;
    }
    Log.i("NowPluginManager|PluginUpdater", "插件开始下载");
    a(paramg, paramInt2, paramString, paramc);
    return true;
  }
  
  protected void b(long paramLong1, long paramLong2, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    Bundle localBundle = new Bundle();
    localBundle.putLong("download_size", paramLong1);
    localBundle.putLong("total_size", paramLong2);
    localBundle.putInt("progress", paramInt);
    localMessage.setData(localBundle);
    this.k.sendMessage(localMessage);
  }
  
  protected boolean b(String paramString1, String paramString2)
  {
    try
    {
      Log.i("NowPluginManager|PluginUpdater", "服务器md5值 = " + paramString2 + " file = " + paramString1);
      String str = b.a(new File(paramString1));
      Log.i("NowPluginManager|PluginUpdater", "当前下载文件的md5值 = " + str + "file = " + paramString1);
      if ((str != null) && (!TextUtils.isEmpty(str)))
      {
        boolean bool = str.equalsIgnoreCase(paramString2);
        if (bool) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramString1)
    {
      Log.i("NowPluginManager|PluginUpdater", "checkMd5  crash happen e = " + paramString1.getMessage());
      return false;
    }
    return true;
  }
  
  public static class a
  {
    public int a = f.b;
    public String b;
    public String c;
    public String d;
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt);
    
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.f
 * JD-Core Version:    0.7.0.1
 */