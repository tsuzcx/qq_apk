package com.tencent.token.widget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.SoundPool;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.tencent.token.rf;
import com.tencent.token.sl;
import com.tencent.token.xj;

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
    arrayOfInt[0] = 2131100190;
    arrayOfInt[1] = 2131100191;
    arrayOfInt[2] = 2131100192;
    arrayOfInt[3] = 2131100193;
    arrayOfInt[4] = 2131100194;
    arrayOfInt[5] = 2131100195;
    arrayOfInt[6] = 2131100196;
    arrayOfInt[7] = 2131100197;
    arrayOfInt[8] = 2131100198;
    arrayOfInt[9] = 2131100199;
  }
  
  private void a()
  {
    Object localObject2 = rf.a();
    if (!((rf)localObject2).d())
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this);
      Object localObject1 = localAppWidgetManager.getAppWidgetIds(this.e);
      this.c.setImageViewResource(2131166288, 2131100208);
      boolean bool = this.f;
      int i1 = 0;
      if (!bool)
      {
        this.b = ((rf)localObject2).f();
        if (this.g) {
          this.c.setImageViewResource(2131166288, 2131100205);
        }
        this.c.setViewVisibility(2131166287, 4);
        this.c.setViewVisibility(2131166131, 4);
        this.c.setViewVisibility(2131166140, 0);
        this.c.setViewVisibility(2131166138, 0);
        this.c.setOnClickPendingIntent(2131166140, this.j);
        int m = 0;
        for (;;)
        {
          localObject2 = this.b;
          n = i1;
          if (m >= localObject2.length) {
            break;
          }
          this.c.setImageViewResource(2131166132 + m, this.h[localObject2[m]]);
          m += 1;
        }
      }
      this.c.setViewVisibility(2131166140, 4);
      this.c.setViewVisibility(2131166138, 4);
      this.c.setViewVisibility(2131166287, 0);
      this.c.setViewVisibility(2131166131, 0);
      this.c.setOnClickPendingIntent(2131166287, this.i);
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
        localObject1 = new StringBuilder("TokenService ");
        ((StringBuilder)localObject1).append(localException.toString());
        xj.c(((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    xj.a("onCreate");
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
    sl.a(this).a.release();
    unregisterReceiver(this.k);
  }
  
  /* Error */
  public void onStart(Intent paramIntent, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/token/widget/TokenService:c	Landroid/widget/RemoteViews;
    //   4: ifnonnull +131 -> 135
    //   7: aload_0
    //   8: aload_0
    //   9: iconst_0
    //   10: new 185	android/content/Intent
    //   13: dup
    //   14: aload_0
    //   15: ldc 187
    //   17: invokespecial 190	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   20: iconst_0
    //   21: invokestatic 196	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   24: putfield 48	com/tencent/token/widget/TokenService:i	Landroid/app/PendingIntent;
    //   27: aload_0
    //   28: new 185	android/content/Intent
    //   31: dup
    //   32: aload_0
    //   33: ldc 2
    //   35: invokespecial 190	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   38: putfield 38	com/tencent/token/widget/TokenService:d	Landroid/content/Intent;
    //   41: aload_0
    //   42: new 90	android/widget/RemoteViews
    //   45: dup
    //   46: aload_0
    //   47: invokevirtual 199	com/tencent/token/widget/TokenService:getPackageName	()Ljava/lang/String;
    //   50: ldc 200
    //   52: invokespecial 203	android/widget/RemoteViews:<init>	(Ljava/lang/String;I)V
    //   55: putfield 36	com/tencent/token/widget/TokenService:c	Landroid/widget/RemoteViews;
    //   58: aload_0
    //   59: new 205	android/content/ComponentName
    //   62: dup
    //   63: aload_0
    //   64: ldc 207
    //   66: invokespecial 208	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: putfield 40	com/tencent/token/widget/TokenService:e	Landroid/content/ComponentName;
    //   72: aload_0
    //   73: getfield 36	com/tencent/token/widget/TokenService:c	Landroid/widget/RemoteViews;
    //   76: ldc 105
    //   78: aload_0
    //   79: getfield 48	com/tencent/token/widget/TokenService:i	Landroid/app/PendingIntent;
    //   82: invokevirtual 109	android/widget/RemoteViews:setOnClickPendingIntent	(ILandroid/app/PendingIntent;)V
    //   85: aload_0
    //   86: getfield 36	com/tencent/token/widget/TokenService:c	Landroid/widget/RemoteViews;
    //   89: ldc 99
    //   91: aload_0
    //   92: getfield 48	com/tencent/token/widget/TokenService:i	Landroid/app/PendingIntent;
    //   95: invokevirtual 109	android/widget/RemoteViews:setOnClickPendingIntent	(ILandroid/app/PendingIntent;)V
    //   98: aload_0
    //   99: aload_0
    //   100: iconst_0
    //   101: new 185	android/content/Intent
    //   104: dup
    //   105: ldc 155
    //   107: invokespecial 209	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: invokestatic 212	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   114: putfield 50	com/tencent/token/widget/TokenService:j	Landroid/app/PendingIntent;
    //   117: aload_0
    //   118: getfield 36	com/tencent/token/widget/TokenService:c	Landroid/widget/RemoteViews;
    //   121: ldc 104
    //   123: aload_0
    //   124: getfield 50	com/tencent/token/widget/TokenService:j	Landroid/app/PendingIntent;
    //   127: invokevirtual 109	android/widget/RemoteViews:setOnClickPendingIntent	(ILandroid/app/PendingIntent;)V
    //   130: aload_0
    //   131: invokestatic 169	com/tencent/token/sl:a	(Landroid/content/Context;)Lcom/tencent/token/sl;
    //   134: pop
    //   135: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   138: lstore 5
    //   140: aload_0
    //   141: getfield 32	com/tencent/token/widget/TokenService:a	Ljava/lang/Object;
    //   144: astore_1
    //   145: aload_1
    //   146: monitorenter
    //   147: ldc2_w 219
    //   150: lstore_3
    //   151: invokestatic 73	com/tencent/token/rf:a	()Lcom/tencent/token/rf;
    //   154: invokevirtual 76	com/tencent/token/rf:d	()Z
    //   157: ifne +75 -> 232
    //   160: invokestatic 225	com/tencent/token/sk:a	()Lcom/tencent/token/sk;
    //   163: invokevirtual 227	com/tencent/token/sk:c	()Z
    //   166: ifne +53 -> 219
    //   169: invokestatic 231	com/tencent/token/aap:e	()J
    //   172: lconst_0
    //   173: lcmp
    //   174: ifeq +6 -> 180
    //   177: goto +42 -> 219
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 42	com/tencent/token/widget/TokenService:f	Z
    //   185: invokestatic 235	com/tencent/token/sj:h	()J
    //   188: lstore_3
    //   189: lload_3
    //   190: ldc2_w 236
    //   193: lcmp
    //   194: ifle +17 -> 211
    //   197: lload_3
    //   198: ldc2_w 236
    //   201: lsub
    //   202: lstore_3
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 44	com/tencent/token/widget/TokenService:g	Z
    //   208: goto +20 -> 228
    //   211: aload_0
    //   212: iconst_1
    //   213: putfield 44	com/tencent/token/widget/TokenService:g	Z
    //   216: goto +12 -> 228
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 42	com/tencent/token/widget/TokenService:f	Z
    //   224: ldc2_w 238
    //   227: lstore_3
    //   228: aload_0
    //   229: invokespecial 241	com/tencent/token/widget/TokenService:a	()V
    //   232: aload_0
    //   233: ldc 243
    //   235: invokevirtual 247	com/tencent/token/widget/TokenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   238: checkcast 249	android/app/AlarmManager
    //   241: iconst_1
    //   242: lload 5
    //   244: lload_3
    //   245: ladd
    //   246: aload_0
    //   247: iconst_0
    //   248: aload_0
    //   249: getfield 38	com/tencent/token/widget/TokenService:d	Landroid/content/Intent;
    //   252: iconst_0
    //   253: invokestatic 252	android/app/PendingIntent:getService	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   256: invokevirtual 256	android/app/AlarmManager:set	(IJLandroid/app/PendingIntent;)V
    //   259: goto +15 -> 274
    //   262: astore 7
    //   264: goto +13 -> 277
    //   267: astore 7
    //   269: aload 7
    //   271: invokevirtual 117	java/lang/Exception:printStackTrace	()V
    //   274: aload_1
    //   275: monitorexit
    //   276: return
    //   277: aload_1
    //   278: monitorexit
    //   279: aload 7
    //   281: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	TokenService
    //   0	282	1	paramIntent	Intent
    //   0	282	2	paramInt	int
    //   150	95	3	l1	long
    //   138	105	5	l2	long
    //   262	1	7	localObject	Object
    //   267	13	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   151	177	262	finally
    //   180	189	262	finally
    //   203	208	262	finally
    //   211	216	262	finally
    //   219	224	262	finally
    //   228	232	262	finally
    //   232	259	262	finally
    //   269	274	262	finally
    //   274	276	262	finally
    //   277	279	262	finally
    //   151	177	267	java/lang/Exception
    //   180	189	267	java/lang/Exception
    //   203	208	267	java/lang/Exception
    //   211	216	267	java/lang/Exception
    //   219	224	267	java/lang/Exception
    //   228	232	267	java/lang/Exception
    //   232	259	267	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.TokenService
 * JD-Core Version:    0.7.0.1
 */