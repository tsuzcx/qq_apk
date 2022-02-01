package com.tencent.token;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public final class cn
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return cp.a(paramNotification);
    }
    return null;
  }
  
  public static final class a
  {
    final Bundle a;
    final cr[] b;
    final cr[] c;
    boolean d;
    public int e = 2131099914;
    public CharSequence f;
    public PendingIntent g;
    
    public a(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramCharSequence, paramPendingIntent, new Bundle());
    }
    
    private a(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
    {
      this.f = cn.b.c(paramCharSequence);
      this.g = paramPendingIntent;
      this.a = paramBundle;
      this.b = null;
      this.c = null;
      this.d = true;
    }
  }
  
  public static final class b
  {
    Bundle A;
    int B = 0;
    int C = 0;
    Notification D;
    RemoteViews E;
    RemoteViews F;
    RemoteViews G;
    String H;
    int I = 0;
    String J;
    long K;
    int L = 0;
    Notification M = new Notification();
    @Deprecated
    public ArrayList<String> N;
    public Context a;
    public ArrayList<cn.a> b = new ArrayList();
    CharSequence c;
    CharSequence d;
    public PendingIntent e;
    PendingIntent f;
    RemoteViews g;
    Bitmap h;
    CharSequence i;
    int j;
    int k;
    boolean l = true;
    boolean m;
    cn.c n;
    CharSequence o;
    CharSequence[] p;
    int q;
    int r;
    boolean s;
    String t;
    boolean u;
    String v;
    boolean w = false;
    boolean x;
    boolean y;
    String z;
    
    private b(Context paramContext)
    {
      this.a = paramContext;
      this.H = null;
      this.M.when = System.currentTimeMillis();
      this.M.audioStreamType = -1;
      this.k = 0;
      this.N = new ArrayList();
    }
    
    @Deprecated
    public b(Context paramContext, byte paramByte)
    {
      this(paramContext);
    }
    
    protected static CharSequence c(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {
        return paramCharSequence;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        localCharSequence = paramCharSequence.subSequence(0, 5120);
      }
      return localCharSequence;
    }
    
    public final b a()
    {
      this.M.icon = 2131099914;
      return this;
    }
    
    public final b a(CharSequence paramCharSequence)
    {
      this.c = c(paramCharSequence);
      return this;
    }
    
    public final b b()
    {
      Notification localNotification = this.M;
      localNotification.flags |= 0x10;
      return this;
    }
    
    public final b b(CharSequence paramCharSequence)
    {
      this.d = c(paramCharSequence);
      return this;
    }
    
    public final b c()
    {
      this.M.defaults = 1;
      return this;
    }
    
    public final Notification d()
    {
      co localco = new co(this);
      cn.c localc = localco.b.n;
      Object localObject;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = localco.a.build();
      }
      else
      {
        Notification localNotification;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localNotification = localco.a.build();
          localObject = localNotification;
          if (localco.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localco.g == 2)) {
              co.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localco.g == 1)
                {
                  co.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localco.a.setExtras(localco.f);
          localNotification = localco.a.build();
          if (localco.c != null) {
            localNotification.contentView = localco.c;
          }
          if (localco.d != null) {
            localNotification.bigContentView = localco.d;
          }
          if (localco.h != null) {
            localNotification.headsUpContentView = localco.h;
          }
          localObject = localNotification;
          if (localco.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localco.g == 2)) {
              co.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localco.g == 1)
                {
                  co.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localco.a.setExtras(localco.f);
          localNotification = localco.a.build();
          if (localco.c != null) {
            localNotification.contentView = localco.c;
          }
          if (localco.d != null) {
            localNotification.bigContentView = localco.d;
          }
          localObject = localNotification;
          if (localco.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localco.g == 2)) {
              co.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localco.g == 1)
                {
                  co.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = cp.a(localco.e);
          if (localObject != null) {
            localco.f.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          localco.a.setExtras(localco.f);
          localNotification = localco.a.build();
          if (localco.c != null) {
            localNotification.contentView = localco.c;
          }
          localObject = localNotification;
          if (localco.d != null)
          {
            localNotification.bigContentView = localco.d;
            localObject = localNotification;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localNotification = localco.a.build();
          localObject = cn.a(localNotification);
          Bundle localBundle = new Bundle(localco.f);
          Iterator localIterator = localco.f.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject).putAll(localBundle);
          localObject = cp.a(localco.e);
          if (localObject != null) {
            cn.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          if (localco.c != null) {
            localNotification.contentView = localco.c;
          }
          localObject = localNotification;
          if (localco.d != null)
          {
            localNotification.bigContentView = localco.d;
            localObject = localNotification;
          }
        }
        else
        {
          localObject = localco.a.getNotification();
        }
      }
      if (localco.b.E != null) {
        ((Notification)localObject).contentView = localco.b.E;
      }
      int i1 = Build.VERSION.SDK_INT;
      i1 = Build.VERSION.SDK_INT;
      if ((Build.VERSION.SDK_INT >= 16) && (localc != null)) {
        cn.a((Notification)localObject);
      }
      return localObject;
    }
  }
  
  public static abstract class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cn
 * JD-Core Version:    0.7.0.1
 */