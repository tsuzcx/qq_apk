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
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.ai;
import com.tencent.token.global.e;
import com.tencent.token.ui.WidgetTransitionActivity;

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
    this.h[0] = 2130837987;
    this.h[1] = 2130837988;
    this.h[2] = 2130837989;
    this.h[3] = 2130837990;
    this.h[4] = 2130837991;
    this.h[5] = 2130837992;
    this.h[6] = 2130837993;
    this.h[7] = 2130837994;
    this.h[8] = 2130837995;
    this.h[9] = 2130837996;
  }
  
  private void a()
  {
    int i1 = 0;
    ag localag = ag.c();
    if (!localag.g())
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
      int[] arrayOfInt = localAppWidgetManager.getAppWidgetIds(this.e);
      this.c.setImageViewResource(2131297176, 2130838013);
      if (!this.f)
      {
        localag.m();
        this.b = localag.l();
        if (this.g) {
          this.c.setImageViewResource(2131297176, 2130838010);
        }
        this.c.setViewVisibility(2131297175, 4);
        this.c.setViewVisibility(2131297174, 4);
        this.c.setViewVisibility(2131297173, 0);
        this.c.setViewVisibility(2131297177, 0);
        this.c.setOnClickPendingIntent(2131297173, this.j);
        int m = 0;
        for (;;)
        {
          n = i1;
          if (m >= this.b.length) {
            break;
          }
          this.c.setImageViewResource(2131297178 + m, this.h[this.b[m]]);
          m += 1;
        }
      }
      this.c.setViewVisibility(2131297173, 4);
      this.c.setViewVisibility(2131297177, 4);
      this.c.setViewVisibility(2131297175, 0);
      this.c.setViewVisibility(2131297174, 0);
      this.c.setOnClickPendingIntent(2131297175, this.i);
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
        e.d("TokenService " + localException.toString());
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    e.a("onCreate");
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
    ai.a(this).b();
    unregisterReceiver(this.k);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (this.c == null)
    {
      this.i = PendingIntent.getActivity(this, 0, new Intent(this, WidgetTransitionActivity.class), 0);
      this.d = new Intent(this, TokenService.class);
      this.c = new RemoteViews(getPackageName(), 2130903223);
      this.e = new ComponentName(this, TokenWidgetProvider.class);
      this.c.setOnClickPendingIntent(2131297177, this.i);
      this.c.setOnClickPendingIntent(2131297175, this.i);
      this.j = PendingIntent.getBroadcast(this, 0, new Intent("com.tencent.token.widget.SPEECH"), 0);
      this.c.setOnClickPendingIntent(2131297173, this.j);
      ai.a(this);
    }
    long l2 = System.currentTimeMillis();
    paramIntent = this.a;
    long l1 = 120000L;
    for (;;)
    {
      try
      {
        if (!ag.c().g())
        {
          if (ah.a().c())
          {
            this.f = true;
            l1 = 30000L;
            a();
          }
        }
        else
        {
          ((AlarmManager)getSystemService("alarm")).set(1, l2 + l1, PendingIntent.getService(this, 0, this.d, 0));
          return;
        }
        this.f = false;
        l1 = ag.c().q();
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
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.TokenService
 * JD-Core Version:    0.7.0.1
 */