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

public final class ck
{
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return cm.a(paramNotification);
    }
    return null;
  }
  
  public static final class a
  {
    final Bundle a;
    final co[] b;
    final co[] c;
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
      this.f = ck.b.c(paramCharSequence);
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
    public ArrayList<ck.a> b = new ArrayList();
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
    ck.c n;
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
      cl localcl = new cl(this);
      ck.c localc = localcl.b.n;
      Object localObject;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = localcl.a.build();
      }
      else
      {
        Notification localNotification;
        if (Build.VERSION.SDK_INT >= 24)
        {
          localNotification = localcl.a.build();
          localObject = localNotification;
          if (localcl.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localcl.g == 2)) {
              cl.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localcl.g == 1)
                {
                  cl.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 21)
        {
          localcl.a.setExtras(localcl.f);
          localNotification = localcl.a.build();
          if (localcl.c != null) {
            localNotification.contentView = localcl.c;
          }
          if (localcl.d != null) {
            localNotification.bigContentView = localcl.d;
          }
          if (localcl.h != null) {
            localNotification.headsUpContentView = localcl.h;
          }
          localObject = localNotification;
          if (localcl.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localcl.g == 2)) {
              cl.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localcl.g == 1)
                {
                  cl.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 20)
        {
          localcl.a.setExtras(localcl.f);
          localNotification = localcl.a.build();
          if (localcl.c != null) {
            localNotification.contentView = localcl.c;
          }
          if (localcl.d != null) {
            localNotification.bigContentView = localcl.d;
          }
          localObject = localNotification;
          if (localcl.g != 0)
          {
            if ((localNotification.getGroup() != null) && ((localNotification.flags & 0x200) != 0) && (localcl.g == 2)) {
              cl.a(localNotification);
            }
            localObject = localNotification;
            if (localNotification.getGroup() != null)
            {
              localObject = localNotification;
              if ((localNotification.flags & 0x200) == 0)
              {
                localObject = localNotification;
                if (localcl.g == 1)
                {
                  cl.a(localNotification);
                  localObject = localNotification;
                }
              }
            }
          }
        }
        else if (Build.VERSION.SDK_INT >= 19)
        {
          localObject = cm.a(localcl.e);
          if (localObject != null) {
            localcl.f.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          localcl.a.setExtras(localcl.f);
          localNotification = localcl.a.build();
          if (localcl.c != null) {
            localNotification.contentView = localcl.c;
          }
          localObject = localNotification;
          if (localcl.d != null)
          {
            localNotification.bigContentView = localcl.d;
            localObject = localNotification;
          }
        }
        else if (Build.VERSION.SDK_INT >= 16)
        {
          localNotification = localcl.a.build();
          localObject = ck.a(localNotification);
          Bundle localBundle = new Bundle(localcl.f);
          Iterator localIterator = localcl.f.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((Bundle)localObject).containsKey(str)) {
              localBundle.remove(str);
            }
          }
          ((Bundle)localObject).putAll(localBundle);
          localObject = cm.a(localcl.e);
          if (localObject != null) {
            ck.a(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
          }
          if (localcl.c != null) {
            localNotification.contentView = localcl.c;
          }
          localObject = localNotification;
          if (localcl.d != null)
          {
            localNotification.bigContentView = localcl.d;
            localObject = localNotification;
          }
        }
        else
        {
          localObject = localcl.a.getNotification();
        }
      }
      if (localcl.b.E != null) {
        ((Notification)localObject).contentView = localcl.b.E;
      }
      int i1 = Build.VERSION.SDK_INT;
      i1 = Build.VERSION.SDK_INT;
      if ((Build.VERSION.SDK_INT >= 16) && (localc != null)) {
        ck.a((Notification)localObject);
      }
      return localObject;
    }
  }
  
  public static abstract class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ck
 * JD-Core Version:    0.7.0.1
 */