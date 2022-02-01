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

public final class cj
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return cl.a(paramNotification);
    }
    return null;
  }
  
  public static final class a
  {
    final Bundle a;
    final cn[] b;
    final cn[] c;
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
      this.f = cj.b.c(paramCharSequence);
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
    public ArrayList<cj.a> b = new ArrayList();
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
    cj.c n;
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
      ck localck = new ck(this);
      cj.c localc = localck.b.n;
      Object localObject;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = localck.a.build();
      }
      else
      {
        Notification localNotification;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localNotification = localck.a.build();
          localObject = localNotification;
          if (localck.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localck.g == 2)) {
              ck.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localck.g == 1)
                {
                  ck.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localck.a.setExtras(localck.f);
          localNotification = localck.a.build();
          if (localck.c != null) {
            localNotification.contentView = localck.c;
          }
          if (localck.d != null) {
            localNotification.bigContentView = localck.d;
          }
          if (localck.h != null) {
            localNotification.headsUpContentView = localck.h;
          }
          localObject = localNotification;
          if (localck.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localck.g == 2)) {
              ck.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localck.g == 1)
                {
                  ck.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localck.a.setExtras(localck.f);
          localNotification = localck.a.build();
          if (localck.c != null) {
            localNotification.contentView = localck.c;
          }
          if (localck.d != null) {
            localNotification.bigContentView = localck.d;
          }
          localObject = localNotification;
          if (localck.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localck.g == 2)) {
              ck.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localck.g == 1)
                {
                  ck.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = cl.a(localck.e);
          if (localObject != null) {
            localck.f.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          localck.a.setExtras(localck.f);
          localNotification = localck.a.build();
          if (localck.c != null) {
            localNotification.contentView = localck.c;
          }
          localObject = localNotification;
          if (localck.d != null)
          {
            localNotification.bigContentView = localck.d;
            localObject = localNotification;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localNotification = localck.a.build();
          localObject = cj.a(localNotification);
          Bundle localBundle = new Bundle(localck.f);
          Iterator localIterator = localck.f.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject).putAll(localBundle);
          localObject = cl.a(localck.e);
          if (localObject != null) {
            cj.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          if (localck.c != null) {
            localNotification.contentView = localck.c;
          }
          localObject = localNotification;
          if (localck.d != null)
          {
            localNotification.bigContentView = localck.d;
            localObject = localNotification;
          }
        }
        else
        {
          localObject = localck.a.getNotification();
        }
      }
      if (localck.b.E != null) {
        ((Notification)localObject).contentView = localck.b.E;
      }
      int i1 = Build.VERSION.SDK_INT;
      i1 = Build.VERSION.SDK_INT;
      if ((Build.VERSION.SDK_INT >= 16) && (localc != null)) {
        cj.a((Notification)localObject);
      }
      return localObject;
    }
  }
  
  public static abstract class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cj
 * JD-Core Version:    0.7.0.1
 */