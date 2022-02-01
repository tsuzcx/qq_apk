package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.global.g;
import com.tencent.token.ui.WidgetTransitionActivity;
import com.tencent.token.utils.m;

public class TokenService
  extends Service
{
  private Object a = new Object();
  private int[] b = null;
  private RemoteViews c = null;
  private Intent d = null;
  private ComponentName e = null;
  private boolean f = false;
  private boolean g = false;
  private int[] h = new int[10];
  private PendingIntent i = null;
  private PendingIntent j = null;
  private final WidgetReceiver k = new WidgetReceiver();
  
  public TokenService()
  {
    this.h[0] = 2130838037;
    this.h[1] = 2130838038;
    this.h[2] = 2130838039;
    this.h[3] = 2130838040;
    this.h[4] = 2130838041;
    this.h[5] = 2130838042;
    this.h[6] = 2130838043;
    this.h[7] = 2130838044;
    this.h[8] = 2130838045;
    this.h[9] = 2130838046;
  }
  
  private void a()
  {
    int i1 = 0;
    cc localcc = cc.c();
    if (!localcc.g())
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
      int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(this.e);
      this.c.setImageViewResource(2131559338, 2130838055);
      if (!this.f)
      {
        localcc.m();
        this.b = localcc.l();
        if (this.g) {
          this.c.setImageViewResource(2131559338, 2130838052);
        }
        this.c.setViewVisibility(2131559337, 4);
        this.c.setViewVisibility(2131559336, 4);
        this.c.setViewVisibility(2131559335, 0);
        this.c.setViewVisibility(2131559339, 0);
        this.c.setOnClickPendingIntent(2131559335, this.j);
        int m = 0;
        for (;;)
        {
          n = i1;
          if (m >= this.b.length) {
            break;
          }
          this.c.setImageViewResource(2131559340 + m, this.h[this.b[m]]);
          m += 1;
        }
      }
      this.c.setViewVisibility(2131559335, 4);
      this.c.setViewVisibility(2131559339, 4);
      this.c.setViewVisibility(2131559337, 0);
      this.c.setViewVisibility(2131559336, 0);
      this.c.setOnClickPendingIntent(2131559337, this.i);
      int n = i1;
      try
      {
        while (n < arrayOfInt.length)
        {
          localAppWidgetManager.updateAppWidget(arrayOfInt[n], this.c);
          n += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        g.d("TokenService " + localException.toString());
      }
    }
  }
  
  private void b()
  {
    if (this.c == null)
    {
      this.i = PendingIntent.getActivity(this, 0, new Intent(this, WidgetTransitionActivity.class), 0);
      this.d = new Intent(this, TokenService.class);
      this.c = new RemoteViews(getPackageName(), 2130968785);
      this.e = new ComponentName(this, TokenWidgetProvider.class);
      this.c.setOnClickPendingIntent(2131559339, this.i);
      this.c.setOnClickPendingIntent(2131559337, this.i);
      this.j = PendingIntent.getBroadcast(this, 0, new Intent("com.tencent.token.widget.SPEECH"), 0);
      this.c.setOnClickPendingIntent(2131559335, this.j);
      ce.a(this);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    g.a("onCreate");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("com.tencent.token.widget.SPEECH");
    registerReceiver(this.k, localIntentFilter);
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ce.a(this).b();
    unregisterReceiver(this.k);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    b();
    long l2 = System.currentTimeMillis();
    paramIntent = this.a;
    long l1 = 120000L;
    for (;;)
    {
      try
      {
        if (!cc.c().g())
        {
          if ((!cd.a().c()) && (m.e() == 0L)) {
            continue;
          }
          this.f = true;
          l1 = 30000L;
          a();
        }
        ((AlarmManager)getSystemService("alarm")).set(1, l2 + l1, PendingIntent.getService(this, 0, this.d, 0));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      finally {}
      return;
      this.f = false;
      l1 = cc.c().r();
      if (l1 > 5000L)
      {
        l1 -= 5000L;
        this.g = false;
      }
      else
      {
        this.g = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.TokenService
 * JD-Core Version:    0.7.0.1
 */