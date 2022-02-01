package com.tencent.token;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class cl
{
  final Notification.Builder a;
  final ck.b b;
  RemoteViews c;
  RemoteViews d;
  final List<Bundle> e = new ArrayList();
  final Bundle f = new Bundle();
  int g;
  RemoteViews h;
  
  cl(ck.b paramb)
  {
    this.b = paramb;
    if (Build.VERSION.SDK_INT >= 26) {
      this.a = new Notification.Builder(paramb.a, paramb.H);
    } else {
      this.a = new Notification.Builder(paramb.a);
    }
    Object localObject1 = paramb.M;
    Object localObject2 = this.a.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramb.g).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
    boolean bool;
    if ((((Notification)localObject1).flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
    if ((((Notification)localObject1).flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
    if ((((Notification)localObject1).flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramb.c).setContentText(paramb.d).setContentInfo(paramb.i).setContentIntent(paramb.e).setDeleteIntent(((Notification)localObject1).deleteIntent);
    PendingIntent localPendingIntent = paramb.f;
    if ((((Notification)localObject1).flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramb.h).setNumber(paramb.j).setProgress(paramb.q, paramb.r, paramb.s);
    if (Build.VERSION.SDK_INT < 21) {
      this.a.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.setSubText(paramb.o).setUsesChronometer(paramb.m).setPriority(paramb.k);
      localObject2 = paramb.b.iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((ck.a)((Iterator)localObject2).next());
      }
      if (paramb.A != null) {
        this.f.putAll(paramb.A);
      }
      if (Build.VERSION.SDK_INT < 20)
      {
        if (paramb.w) {
          this.f.putBoolean("android.support.localOnly", true);
        }
        if (paramb.t != null)
        {
          this.f.putString("android.support.groupKey", paramb.t);
          if (paramb.u) {
            this.f.putBoolean("android.support.isGroupSummary", true);
          } else {
            this.f.putBoolean("android.support.useSideChannel", true);
          }
        }
        if (paramb.v != null) {
          this.f.putString("android.support.sortKey", paramb.v);
        }
      }
      this.c = paramb.E;
      this.d = paramb.F;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a.setShowWhen(paramb.l);
      if ((Build.VERSION.SDK_INT < 21) && (paramb.N != null) && (!paramb.N.isEmpty())) {
        this.f.putStringArray("android.people", (String[])paramb.N.toArray(new String[paramb.N.size()]));
      }
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.a.setLocalOnly(paramb.w).setGroup(paramb.t).setGroupSummary(paramb.u).setSortKey(paramb.v);
      this.g = paramb.L;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.a.setCategory(paramb.z).setColor(paramb.B).setVisibility(paramb.C).setPublicVersion(paramb.D).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramb.N.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.a.addPerson((String)localObject2);
      }
      this.h = paramb.G;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.a.setExtras(paramb.A).setRemoteInputHistory(paramb.p);
      if (paramb.E != null) {
        this.a.setCustomContentView(paramb.E);
      }
      if (paramb.F != null) {
        this.a.setCustomBigContentView(paramb.F);
      }
      if (paramb.G != null) {
        this.a.setCustomHeadsUpContentView(paramb.G);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.a.setBadgeIconType(paramb.I).setShortcutId(paramb.J).setTimeoutAfter(paramb.K).setGroupAlertBehavior(paramb.L);
      if (paramb.y) {
        this.a.setColorized(paramb.x);
      }
      if (!TextUtils.isEmpty(paramb.H)) {
        this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
  }
  
  static void a(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void a(ck.a parama)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      Notification.Action.Builder localBuilder = new Notification.Action.Builder(parama.e, parama.f, parama.g);
      Object localObject;
      if (parama.b != null)
      {
        localObject = co.a(parama.b);
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(localObject[i]);
          i += 1;
        }
      }
      if (parama.a != null) {
        localObject = new Bundle(parama.a);
      } else {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", parama.d);
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(parama.d);
      }
      localBuilder.addExtras((Bundle)localObject);
      this.a.addAction(localBuilder.build());
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.e.add(cm.a(this.a, parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cl
 * JD-Core Version:    0.7.0.1
 */