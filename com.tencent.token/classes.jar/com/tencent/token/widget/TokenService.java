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
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.cz;
import com.tencent.token.global.h;
import com.tencent.token.ui.WidgetTransitionActivity;
import com.tencent.token.utils.x;

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
    cx localcx = cx.c();
    if (!localcx.g())
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
      int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(this.e);
      this.c.setImageViewResource(2131559337, 2130838055);
      if (!this.f)
      {
        localcx.m();
        this.b = localcx.l();
        if (this.g) {
          this.c.setImageViewResource(2131559337, 2130838052);
        }
        this.c.setViewVisibility(2131559336, 4);
        this.c.setViewVisibility(2131559335, 4);
        this.c.setViewVisibility(2131559334, 0);
        this.c.setViewVisibility(2131559338, 0);
        this.c.setOnClickPendingIntent(2131559334, this.j);
        int m = 0;
        for (;;)
        {
          n = i1;
          if (m >= this.b.length) {
            break;
          }
          this.c.setImageViewResource(2131559339 + m, this.h[this.b[m]]);
          m += 1;
        }
      }
      this.c.setViewVisibility(2131559334, 4);
      this.c.setViewVisibility(2131559338, 4);
      this.c.setViewVisibility(2131559336, 0);
      this.c.setViewVisibility(2131559335, 0);
      this.c.setOnClickPendingIntent(2131559336, this.i);
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
        h.d("TokenService " + localException.toString());
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
      this.c.setOnClickPendingIntent(2131559338, this.i);
      this.c.setOnClickPendingIntent(2131559336, this.i);
      this.j = PendingIntent.getBroadcast(this, 0, new Intent("com.tencent.token.widget.SPEECH"), 0);
      this.c.setOnClickPendingIntent(2131559334, this.j);
      cz.a(this);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    h.a("onCreate");
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
    cz.a(this).b();
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
        if (!cx.c().g())
        {
          if ((!cy.a().c()) && (x.e() == 0L)) {
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
      l1 = cx.c().r();
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