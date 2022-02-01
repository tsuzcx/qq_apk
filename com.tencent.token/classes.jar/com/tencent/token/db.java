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

public final class db
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return dd.a(paramNotification);
    }
    return null;
  }
  
  public static final class a
  {
    final Bundle a;
    final df[] b;
    final df[] c;
    boolean d;
    public int e = 2131099917;
    public CharSequence f;
    public PendingIntent g;
    
    public a(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramCharSequence, paramPendingIntent, new Bundle());
    }
    
    private a(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
    {
      this.f = db.b.c(paramCharSequence);
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
    public ArrayList<db.a> b = new ArrayList();
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
    db.c n;
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
      this.M.icon = 2131099917;
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
      dc localdc = new dc(this);
      db.c localc = localdc.b.n;
      Object localObject;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = localdc.a.build();
      }
      else
      {
        Notification localNotification;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localNotification = localdc.a.build();
          localObject = localNotification;
          if (localdc.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localdc.g == 2)) {
              dc.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localdc.g == 1)
                {
                  dc.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localdc.a.setExtras(localdc.f);
          localNotification = localdc.a.build();
          if (localdc.c != null) {
            localNotification.contentView = localdc.c;
          }
          if (localdc.d != null) {
            localNotification.bigContentView = localdc.d;
          }
          if (localdc.h != null) {
            localNotification.headsUpContentView = localdc.h;
          }
          localObject = localNotification;
          if (localdc.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localdc.g == 2)) {
              dc.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localdc.g == 1)
                {
                  dc.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localdc.a.setExtras(localdc.f);
          localNotification = localdc.a.build();
          if (localdc.c != null) {
            localNotification.contentView = localdc.c;
          }
          if (localdc.d != null) {
            localNotification.bigContentView = localdc.d;
          }
          localObject = localNotification;
          if (localdc.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localdc.g == 2)) {
              dc.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localdc.g == 1)
                {
                  dc.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = dd.a(localdc.e);
          if (localObject != null) {
            localdc.f.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          localdc.a.setExtras(localdc.f);
          localNotification = localdc.a.build();
          if (localdc.c != null) {
            localNotification.contentView = localdc.c;
          }
          localObject = localNotification;
          if (localdc.d != null)
          {
            localNotification.bigContentView = localdc.d;
            localObject = localNotification;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localNotification = localdc.a.build();
          localObject = db.a(localNotification);
          Bundle localBundle = new Bundle(localdc.f);
          Iterator localIterator = localdc.f.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject).putAll(localBundle);
          localObject = dd.a(localdc.e);
          if (localObject != null) {
            db.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          if (localdc.c != null) {
            localNotification.contentView = localdc.c;
          }
          localObject = localNotification;
          if (localdc.d != null)
          {
            localNotification.bigContentView = localdc.d;
            localObject = localNotification;
          }
        }
        else
        {
          localObject = localdc.a.getNotification();
        }
      }
      if (localdc.b.E != null) {
        ((Notification)localObject).contentView = localdc.b.E;
      }
      int i1 = Build.VERSION.SDK_INT;
      i1 = Build.VERSION.SDK_INT;
      if ((Build.VERSION.SDK_INT >= 16) && (localc != null)) {
        db.a((Notification)localObject);
      }
      return localObject;
    }
  }
  
  public static abstract class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.db
 * JD-Core Version:    0.7.0.1
 */