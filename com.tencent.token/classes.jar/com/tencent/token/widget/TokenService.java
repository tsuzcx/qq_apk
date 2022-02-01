package com.tencent.token.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.tencent.token.cc;
import com.tencent.token.ce;
import com.tencent.token.global.g;
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
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 2131100186;
    arrayOfInt[1] = 2131100187;
    arrayOfInt[2] = 2131100188;
    arrayOfInt[3] = 2131100189;
    arrayOfInt[4] = 2131100190;
    arrayOfInt[5] = 2131100191;
    arrayOfInt[6] = 2131100192;
    arrayOfInt[7] = 2131100193;
    arrayOfInt[8] = 2131100194;
    arrayOfInt[9] = 2131100195;
  }
  
  private void a()
  {
    Object localObject2 = cc.c();
    if (!((cc)localObject2).g())
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
      Object localObject1 = localAppWidgetManager.getAppWidgetIds(this.e);
      this.c.setImageViewResource(2131166271, 2131100204);
      boolean bool = this.f;
      int i1 = 0;
      if (!bool)
      {
        ((cc)localObject2).m();
        this.b = ((cc)localObject2).l();
        if (this.g) {
          this.c.setImageViewResource(2131166271, 2131100201);
        }
        this.c.setViewVisibility(2131166270, 4);
        this.c.setViewVisibility(2131166121, 4);
        this.c.setViewVisibility(2131166130, 0);
        this.c.setViewVisibility(2131166128, 0);
        this.c.setOnClickPendingIntent(2131166130, this.j);
        int m = 0;
        for (;;)
        {
          localObject2 = this.b;
          n = i1;
          if (m >= localObject2.length) {
            break;
          }
          this.c.setImageViewResource(2131166122 + m, this.h[localObject2[m]]);
          m += 1;
        }
      }
      this.c.setViewVisibility(2131166130, 4);
      this.c.setViewVisibility(2131166128, 4);
      this.c.setViewVisibility(2131166270, 0);
      this.c.setViewVisibility(2131166121, 0);
      this.c.setOnClickPendingIntent(2131166270, this.i);
      int n = i1;
      try
      {
        while (n < localObject1.length)
        {
          localAppWidgetManager.updateAppWidget(localObject1[n], this.c);
          n += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TokenService ");
        ((StringBuilder)localObject1).append(localException.toString());
        g.d(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void b()
  {
    if (this.c == null)
    {
      this.i = PendingIntent.getActivity(this, 0, new Intent(this, WidgetTransitionActivity.class), 0);
      this.d = new Intent(this, TokenService.class);
      this.c = new RemoteViews(getPackageName(), 2131296466);
      this.e = new ComponentName(this, TokenWidgetProvider.class);
      this.c.setOnClickPendingIntent(2131166128, this.i);
      this.c.setOnClickPendingIntent(2131166270, this.i);
      this.j = PendingIntent.getBroadcast(this, 0, new Intent("com.tencent.token.widget.SPEECH"), 0);
      this.c.setOnClickPendingIntent(2131166130, this.j);
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
  
  /* Error */
  public void onStart(Intent paramIntent, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 211	com/tencent/token/widget/TokenService:b	()V
    //   4: invokestatic 217	java/lang/System:currentTimeMillis	()J
    //   7: lstore 5
    //   9: aload_0
    //   10: getfield 32	com/tencent/token/widget/TokenService:a	Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: ldc2_w 218
    //   19: lstore_3
    //   20: invokestatic 73	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
    //   23: invokevirtual 76	com/tencent/token/cc:g	()Z
    //   26: ifne +78 -> 104
    //   29: invokestatic 224	com/tencent/token/cd:a	()Lcom/tencent/token/cd;
    //   32: invokevirtual 226	com/tencent/token/cd:c	()Z
    //   35: ifne +56 -> 91
    //   38: invokestatic 230	com/tencent/token/utils/m:e	()J
    //   41: lconst_0
    //   42: lcmp
    //   43: ifeq +6 -> 49
    //   46: goto +45 -> 91
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 42	com/tencent/token/widget/TokenService:f	Z
    //   54: invokestatic 73	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
    //   57: invokevirtual 233	com/tencent/token/cc:r	()J
    //   60: lstore_3
    //   61: lload_3
    //   62: ldc2_w 234
    //   65: lcmp
    //   66: ifle +17 -> 83
    //   69: lload_3
    //   70: ldc2_w 234
    //   73: lsub
    //   74: lstore_3
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 44	com/tencent/token/widget/TokenService:g	Z
    //   80: goto +20 -> 100
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 44	com/tencent/token/widget/TokenService:g	Z
    //   88: goto +12 -> 100
    //   91: aload_0
    //   92: iconst_1
    //   93: putfield 42	com/tencent/token/widget/TokenService:f	Z
    //   96: ldc2_w 236
    //   99: lstore_3
    //   100: aload_0
    //   101: invokespecial 239	com/tencent/token/widget/TokenService:a	()V
    //   104: aload_0
    //   105: ldc 241
    //   107: invokevirtual 245	com/tencent/token/widget/TokenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   110: checkcast 247	android/app/AlarmManager
    //   113: iconst_1
    //   114: lload 5
    //   116: lload_3
    //   117: ladd
    //   118: aload_0
    //   119: iconst_0
    //   120: aload_0
    //   121: getfield 38	com/tencent/token/widget/TokenService:d	Landroid/content/Intent;
    //   124: iconst_0
    //   125: invokestatic 250	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   128: invokevirtual 254	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   131: goto +15 -> 146
    //   134: astore 7
    //   136: goto +13 -> 149
    //   139: astore 7
    //   141: aload 7
    //   143: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   146: aload_1
    //   147: monitorexit
    //   148: return
    //   149: aload_1
    //   150: monitorexit
    //   151: aload 7
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	TokenService
    //   0	154	1	paramIntent	Intent
    //   0	154	2	paramInt	int
    //   19	98	3	l1	long
    //   7	108	5	l2	long
    //   134	1	7	localObject	Object
    //   139	13	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	46	134	finally
    //   49	61	134	finally
    //   75	80	134	finally
    //   83	88	134	finally
    //   91	96	134	finally
    //   100	104	134	finally
    //   104	131	134	finally
    //   141	146	134	finally
    //   146	148	134	finally
    //   149	151	134	finally
    //   20	46	139	java/lang/Exception
    //   49	61	139	java/lang/Exception
    //   75	80	139	java/lang/Exception
    //   83	88	139	java/lang/Exception
    //   91	96	139	java/lang/Exception
    //   100	104	139	java/lang/Exception
    //   104	131	139	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.TokenService
 * JD-Core Version:    0.7.0.1
 */