package com.tencent.turingfd.sdk.base;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  public static final dj a = new ep();
  public static int b = -1;
  public static final int[] c = { 1, 5, 4, 8, 9, 2 };
  public Context d;
  public final Handler e;
  public AtomicBoolean f = new AtomicBoolean(false);
  public et g;
  
  public i()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public static i a()
  {
    return (i)a.b();
  }
  
  public final Damson a(Context paramContext, String paramString, Damson paramDamson)
  {
    int m = 1;
    paramDamson.Mb = System.currentTimeMillis();
    paramDamson.Nb = paramString;
    paramString = paramContext.getPackageName();
    for (;;)
    {
      Object localObject1;
      try
      {
        paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        localObject1 = paramString.versionName;
        i = paramString.versionCode;
        paramDamson.Pb = i;
        paramDamson.aa = "21916EDD69455490";
        paramDamson.Qb = 105678;
        paramDamson.Rb = 0;
        localObject1 = paramContext.getPackageName();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.Sb = paramString;
        localObject1 = ed.d(paramContext);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.K = paramString;
        localObject1 = ed.e(paramContext);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.Q = paramString;
        localObject1 = Build.BRAND;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.Tb = paramString;
        localObject1 = Build.MODEL;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.Ub = paramString;
        localObject1 = Build.FINGERPRINT;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDamson.Vb = paramString;
        paramDamson.Xb = Build.VERSION.SDK_INT;
        paramDamson.ca = 2;
        if (b == -1)
        {
          paramString = (SensorManager)paramContext.getSystemService("sensor");
          if (paramString == null)
          {
            i = b;
            paramDamson.Wb = i;
            localObject2 = new StringBuilder();
            localObject1 = ed.a(true);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramString).append("_");
            localObject1 = ed.a(false);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramString).append("_");
            localObject1 = ed.f(paramContext);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            paramDamson._b = paramString;
            paramDamson.ac = 32;
            paramDamson.cc = eo.c();
            paramDamson.ec = eo.b();
            if (paramDamson.fc == null) {
              paramDamson.fc = new ArrayList();
            }
            paramDamson.fc.addAll(k.b(paramContext));
            paramDamson.fc.addAll(k.a(paramContext));
            paramDamson.fc.addAll(d.a(paramContext));
            localObject1 = paramDamson.fc;
            paramString = l.a;
            if (paramString == null) {
              continue;
            }
            ((ArrayList)localObject1).addAll(paramString);
            paramString = paramDamson.fc;
            localObject1 = new ArrayList();
            localObject2 = ed.c(paramContext);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            paramString.addAll((Collection)localObject1);
            paramDamson.fc.addAll(h.a());
            paramString = paramDamson.fc;
            localObject1 = new ArrayList();
            if (Build.VERSION.SDK_INT >= 14) {
              continue;
            }
            paramString.addAll((Collection)localObject1);
            paramString = paramDamson.fc;
            localObject1 = new ArrayList();
            if (Settings.Secure.getInt(paramContext.getContentResolver(), "mock_location", 0) == 0) {
              break label1112;
            }
            i = m;
            if (i != 0)
            {
              localObject2 = new Fig();
              ((Fig)localObject2).vc = (dk.c + dk.k);
              ((Fig)localObject2).wc = "1";
              ((ArrayList)localObject1).add(localObject2);
            }
            paramString.addAll((Collection)localObject1);
            paramString = paramDamson.fc;
            localObject1 = new ArrayList();
            i = c.a(paramContext);
            localObject2 = new Fig();
            ((Fig)localObject2).vc = (dk.c + dk.o);
            ((Fig)localObject2).wc = dt.a("", i);
            ((ArrayList)localObject1).add(localObject2);
            paramString.addAll((Collection)localObject1);
            paramDamson.fc.addAll(((cz)cz.a.b()).a(paramContext));
            paramDamson.ic = n.a(paramContext);
            return paramDamson;
          }
        }
      }
      catch (Throwable paramString)
      {
        i = 0;
        continue;
        i = 0;
        int j = 1;
        localObject1 = c;
        if (i < localObject1.length)
        {
          if (paramString.getDefaultSensor(localObject1[i]) == null)
          {
            k = 0;
            j |= k << i;
            i += 1;
            continue;
          }
          int k = 1;
          continue;
        }
        b = j;
        i = b;
        continue;
        paramString = l.a(paramContext);
        continue;
        localObject3 = new Fig();
        ((Fig)localObject3).vc = (dk.c + dk.f);
        ((Fig)localObject3).wc = ((String)localObject2);
        ((ArrayList)localObject1).add(localObject3);
        continue;
        localObject2 = new HashSet();
      }
      do
      {
        try
        {
          localObject3 = ((AccessibilityManager)paramContext.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1);
          localObject3 = ((List)localObject3).iterator();
          i = 0;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            AccessibilityServiceInfo localAccessibilityServiceInfo;
            String str;
            continue;
            i += 1;
          }
        }
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localAccessibilityServiceInfo = (AccessibilityServiceInfo)((Iterator)localObject3).next();
        str = ed.d(localAccessibilityServiceInfo.getId().getBytes()).toUpperCase();
      } while (((ag)ag.b.b()).c.contains(str));
      ((Set)localObject2).add(localAccessibilityServiceInfo.getId());
      if (i < 5) {
        break;
      }
      Object localObject3 = new StringBuilder();
      Object localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject3).append((String)((Iterator)localObject2).next());
        ((StringBuilder)localObject3).append("_");
      }
      localObject2 = ((StringBuilder)localObject3).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = new Fig();
        ((Fig)localObject3).vc = (dk.c + dk.j);
        ((Fig)localObject3).wc = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        ((List)localObject1).add(localObject3);
        continue;
        label1112:
        i = 0;
      }
    }
  }
  
  /* Error */
  public void a(Context paramContext, int paramInt, String paramString, ev paramev)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 422	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: putfield 85	com/tencent/turingfd/sdk/base/i:d	Landroid/content/Context;
    //   10: aload_0
    //   11: getfield 85	com/tencent/turingfd/sdk/base/i:d	Landroid/content/Context;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 61	com/tencent/turingfd/sdk/base/i:e	Landroid/os/Handler;
    //   28: new 424	com/tencent/turingfd/sdk/base/f
    //   31: dup
    //   32: aload_0
    //   33: ldc_w 426
    //   36: iload_2
    //   37: aload 4
    //   39: aload_1
    //   40: aload_3
    //   41: invokespecial 429	com/tencent/turingfd/sdk/base/f:<init>	(Lcom/tencent/turingfd/sdk/base/i;Ljava/lang/String;ILcom/tencent/turingfd/sdk/base/ev;Landroid/content/Context;Ljava/lang/String;)V
    //   44: invokevirtual 433	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   47: pop
    //   48: goto -27 -> 21
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	i
    //   0	56	1	paramContext	Context
    //   0	56	2	paramInt	int
    //   0	56	3	paramString	String
    //   0	56	4	paramev	ev
    //   14	3	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	16	51	finally
    //   24	48	51	finally
  }
  
  public final void a(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      try
      {
        new File(str).delete();
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  /* Error */
  public boolean a(et paramet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: getfield 447	com/tencent/turingfd/sdk/base/et:c	Landroid/content/Context;
    //   7: putfield 85	com/tencent/turingfd/sdk/base/i:d	Landroid/content/Context;
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 89	com/tencent/turingfd/sdk/base/i:g	Lcom/tencent/turingfd/sdk/base/et;
    //   15: new 449	com/tencent/turingfd/sdk/base/j
    //   18: dup
    //   19: aload_0
    //   20: aconst_null
    //   21: invokespecial 452	com/tencent/turingfd/sdk/base/j:<init>	(Lcom/tencent/turingfd/sdk/base/i;Lcom/tencent/turingfd/sdk/base/ep;)V
    //   24: astore_3
    //   25: getstatic 455	com/tencent/turingfd/sdk/base/cr:a	Lcom/tencent/turingfd/sdk/base/dj;
    //   28: invokevirtual 72	com/tencent/turingfd/sdk/base/dj:b	()Ljava/lang/Object;
    //   31: checkcast 454	com/tencent/turingfd/sdk/base/cr
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 61	com/tencent/turingfd/sdk/base/i:e	Landroid/os/Handler;
    //   40: astore 5
    //   42: aload 4
    //   44: aload_3
    //   45: putfield 459	com/tencent/turingfd/sdk/base/cr:h	Lcom/tencent/turingfd/sdk/base/by;
    //   48: aload 4
    //   50: getfield 462	com/tencent/turingfd/sdk/base/cr:b	Z
    //   53: ifeq +11 -> 64
    //   56: aload 4
    //   58: aload 5
    //   60: aload_3
    //   61: invokevirtual 465	com/tencent/turingfd/sdk/base/cr:a	(Landroid/os/Handler;Lcom/tencent/turingfd/sdk/base/by;)V
    //   64: aload 4
    //   66: aload_1
    //   67: putfield 466	com/tencent/turingfd/sdk/base/cr:g	Lcom/tencent/turingfd/sdk/base/et;
    //   70: aload 4
    //   72: iconst_1
    //   73: putfield 462	com/tencent/turingfd/sdk/base/cr:b	Z
    //   76: aload 4
    //   78: getfield 469	com/tencent/turingfd/sdk/base/cr:c	Lcom/tencent/turingfd/sdk/base/ce;
    //   81: ifnonnull +19 -> 100
    //   84: aload 4
    //   86: new 471	com/tencent/turingfd/sdk/base/ce
    //   89: dup
    //   90: aload_1
    //   91: getfield 447	com/tencent/turingfd/sdk/base/et:c	Landroid/content/Context;
    //   94: invokespecial 474	com/tencent/turingfd/sdk/base/ce:<init>	(Landroid/content/Context;)V
    //   97: putfield 469	com/tencent/turingfd/sdk/base/cr:c	Lcom/tencent/turingfd/sdk/base/ce;
    //   100: aload 4
    //   102: invokevirtual 476	com/tencent/turingfd/sdk/base/cr:a	()V
    //   105: aload 4
    //   107: aload 5
    //   109: putfield 478	com/tencent/turingfd/sdk/base/cr:d	Landroid/os/Handler;
    //   112: aload 5
    //   114: aload 4
    //   116: getfield 481	com/tencent/turingfd/sdk/base/cr:j	Ljava/lang/Runnable;
    //   119: invokevirtual 433	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   122: pop
    //   123: aload_0
    //   124: getfield 40	com/tencent/turingfd/sdk/base/i:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   127: invokevirtual 484	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +7 -> 139
    //   135: aload_0
    //   136: monitorexit
    //   137: iconst_1
    //   138: ireturn
    //   139: getstatic 487	com/tencent/turingfd/sdk/base/ap:a	Lcom/tencent/turingfd/sdk/base/dj;
    //   142: invokevirtual 72	com/tencent/turingfd/sdk/base/dj:b	()Ljava/lang/Object;
    //   145: checkcast 486	com/tencent/turingfd/sdk/base/ap
    //   148: astore_1
    //   149: new 489	com/tencent/turingfd/sdk/base/b
    //   152: dup
    //   153: aload_0
    //   154: ldc_w 491
    //   157: invokespecial 494	com/tencent/turingfd/sdk/base/b:<init>	(Lcom/tencent/turingfd/sdk/base/i;Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_1
    //   162: getfield 496	com/tencent/turingfd/sdk/base/ap:b	Landroid/os/Handler;
    //   165: aload_3
    //   166: iconst_0
    //   167: i2l
    //   168: invokevirtual 500	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   171: pop
    //   172: goto -37 -> 135
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	i
    //   0	180	1	paramet	et
    //   130	2	2	bool	boolean
    //   24	142	3	localObject	Object
    //   34	81	4	localcr	cr
    //   40	73	5	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   2	64	175	finally
    //   64	100	175	finally
    //   100	131	175	finally
    //   139	172	175	finally
  }
  
  public final boolean a(ev paramev, Damson paramDamson)
  {
    String str1 = dk.a;
    String str2 = dk.b;
    paramev = ((du)paramev).a(4103, 14103, str1, str2, paramDamson);
    return (paramev != null) && (paramev.kc == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.i
 * JD-Core Version:    0.7.0.1
 */