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
import android.util.SparseArray;
import android.view.accessibility.AccessibilityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class bb
{
  public static final cx<bb> a = new a();
  public static int b = -1;
  public static final int[] c = { 1, 5, 4, 8, 9, 2 };
  public Context d;
  public final Handler e;
  public AtomicBoolean f = new AtomicBoolean(false);
  public at g;
  
  public bb()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public static bb a()
  {
    return (bb)a.b();
  }
  
  public final Dew a(Context paramContext, String paramString, Dew paramDew)
  {
    int m = 1;
    paramDew.Jb = System.currentTimeMillis();
    paramDew.Kb = paramString;
    paramString = paramContext.getPackageName();
    for (;;)
    {
      Object localObject1;
      try
      {
        paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        localObject1 = paramString.versionName;
        i = paramString.versionCode;
        paramDew.Mb = i;
        paramDew.S = "09AEBC42447E1917";
        paramDew.Nb = cv.a;
        paramDew.Ob = 0;
        localObject1 = paramContext.getPackageName();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.Pb = paramString;
        localObject1 = cm.e(paramContext);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.H = paramString;
        localObject1 = cm.f(paramContext);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.I = paramString;
        localObject1 = Build.BRAND;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.Qb = paramString;
        localObject1 = Build.MODEL;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.Rb = paramString;
        localObject1 = Build.FINGERPRINT;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramDew.Sb = paramString;
        paramDew.Ub = Build.VERSION.SDK_INT;
        paramDew.W = 2;
        if (b == -1)
        {
          paramString = (SensorManager)paramContext.getSystemService("sensor");
          if (paramString == null)
          {
            i = b;
            paramDew.Tb = i;
            localObject2 = new StringBuilder();
            localObject1 = cm.a(true);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramString).append("_");
            localObject1 = cm.a(false);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            localObject2 = ((StringBuilder)localObject2).append(paramString).append("_");
            localObject1 = cm.g(paramContext);
            paramString = (String)localObject1;
            if (localObject1 == null) {
              paramString = "";
            }
            paramDew.Xb = paramString;
            paramDew.Yb = 49;
            paramDew._b = af.c();
            paramDew.bc = af.b();
            if (paramDew.cc == null) {
              paramDew.cc = new ArrayList();
            }
            paramDew.cc.addAll(cp.b(paramContext));
            paramDew.cc.addAll(cp.a(paramContext));
            paramDew.cc.addAll(cj.a(paramContext));
            localObject1 = paramDew.cc;
            paramString = cq.a;
            if (paramString == null) {
              continue;
            }
            ((ArrayList)localObject1).addAll(paramString);
            paramString = paramDew.cc;
            localObject1 = new ArrayList();
            localObject2 = cm.d(paramContext);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            paramString.addAll((Collection)localObject1);
            paramDew.cc.addAll(cl.a());
            paramString = paramDew.cc;
            localObject1 = new ArrayList();
            if (Build.VERSION.SDK_INT >= 14) {
              continue;
            }
            paramString.addAll((Collection)localObject1);
            paramString = paramDew.cc;
            localObject1 = new ArrayList();
            if (Settings.Secure.getInt(paramContext.getContentResolver(), "mock_location", 0) == 0) {
              break label1236;
            }
            i = m;
            if (i != 0)
            {
              localObject2 = new Flat();
              ((Flat)localObject2).sc = (da.c + da.k);
              ((Flat)localObject2).tc = "1";
              ((ArrayList)localObject1).add(localObject2);
            }
            paramString.addAll((Collection)localObject1);
            paramString = paramDew.cc;
            localObject1 = new ArrayList();
            i = ch.a(paramContext);
            localObject2 = new Flat();
            ((Flat)localObject2).sc = (da.c + da.m);
            ((Flat)localObject2).tc = ci.a("", i);
            ((ArrayList)localObject1).add(localObject2);
            paramString.addAll((Collection)localObject1);
            paramDew.cc.addAll(((ad)ad.a.b()).a(paramContext));
            localObject1 = paramDew.cc;
            localObject2 = new ArrayList();
            localObject3 = new Flat();
            ((Flat)localObject3).sc = ci.a(new StringBuilder(), da.c, "vpn");
            if (!cm.c()) {
              break label1242;
            }
            paramString = "1";
            ((Flat)localObject3).tc = paramString;
            ((ArrayList)localObject2).add(localObject3);
            ((Flat)localObject3).sc = ci.a(new StringBuilder(), da.c, "proxy");
            if (!cm.c(paramContext)) {
              break label1249;
            }
            paramString = "1";
            ((Flat)localObject3).tc = paramString;
            ((ArrayList)localObject2).add(localObject3);
            ((ArrayList)localObject1).addAll((Collection)localObject2);
            paramDew.fc = co.a(paramContext);
            return paramDew;
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
        paramString = cq.a(paramContext);
        continue;
        localObject3 = new Flat();
        ((Flat)localObject3).sc = (da.c + da.f);
        ((Flat)localObject3).tc = ((String)localObject2);
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
        str = cm.d(localAccessibilityServiceInfo.getId().getBytes()).toUpperCase();
      } while (((cb)cb.b.b()).c.contains(str));
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
        localObject3 = new Flat();
        ((Flat)localObject3).sc = (da.c + da.j);
        ((Flat)localObject3).tc = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        ((List)localObject1).add(localObject3);
        continue;
        label1236:
        i = 0;
        continue;
        label1242:
        paramString = "0";
        continue;
        label1249:
        paramString = "0";
      }
    }
  }
  
  /* Error */
  public void a(final Context paramContext, final int paramInt, final String paramString, final am paramam)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 447	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: putfield 94	com/tencent/turingfd/sdk/base/bb:d	Landroid/content/Context;
    //   10: aload_0
    //   11: getfield 94	com/tencent/turingfd/sdk/base/bb:d	Landroid/content/Context;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 70	com/tencent/turingfd/sdk/base/bb:e	Landroid/os/Handler;
    //   28: new 10	com/tencent/turingfd/sdk/base/bb$c
    //   31: dup
    //   32: aload_0
    //   33: ldc_w 449
    //   36: iload_2
    //   37: aload 4
    //   39: aload_1
    //   40: aload_3
    //   41: invokespecial 452	com/tencent/turingfd/sdk/base/bb$c:<init>	(Lcom/tencent/turingfd/sdk/base/bb;Ljava/lang/String;ILcom/tencent/turingfd/sdk/base/am;Landroid/content/Context;Ljava/lang/String;)V
    //   44: invokevirtual 456	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   47: pop
    //   48: goto -27 -> 21
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	bb
    //   0	56	1	paramContext	Context
    //   0	56	2	paramInt	int
    //   0	56	3	paramString	String
    //   0	56	4	paramam	am
    //   14	3	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	16	51	finally
    //   24	48	51	finally
  }
  
  public final void a(Collection<String> paramCollection)
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
  
  public final boolean a(am paramam, Dew paramDew)
  {
    String str1 = da.a;
    String str2 = da.b;
    paramam = ((ah)paramam).a(4103, 14103, str1, str2, paramDew);
    return (paramam != null) && (paramam.hc == 0);
  }
  
  /* Error */
  public boolean a(at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: getfield 486	com/tencent/turingfd/sdk/base/at:c	Landroid/content/Context;
    //   7: putfield 94	com/tencent/turingfd/sdk/base/bb:d	Landroid/content/Context;
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 98	com/tencent/turingfd/sdk/base/bb:g	Lcom/tencent/turingfd/sdk/base/at;
    //   15: new 12	com/tencent/turingfd/sdk/base/bb$d
    //   18: dup
    //   19: aload_0
    //   20: aconst_null
    //   21: invokespecial 489	com/tencent/turingfd/sdk/base/bb$d:<init>	(Lcom/tencent/turingfd/sdk/base/bb;Lcom/tencent/turingfd/sdk/base/bb$a;)V
    //   24: astore_3
    //   25: getstatic 492	com/tencent/turingfd/sdk/base/y:a	Lcom/tencent/turingfd/sdk/base/cx;
    //   28: invokevirtual 81	com/tencent/turingfd/sdk/base/cx:b	()Ljava/lang/Object;
    //   31: checkcast 491	com/tencent/turingfd/sdk/base/y
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 70	com/tencent/turingfd/sdk/base/bb:e	Landroid/os/Handler;
    //   40: astore 5
    //   42: aload 4
    //   44: aload_3
    //   45: putfield 496	com/tencent/turingfd/sdk/base/y:h	Lcom/tencent/turingfd/sdk/base/s;
    //   48: aload 4
    //   50: getfield 499	com/tencent/turingfd/sdk/base/y:b	Z
    //   53: ifeq +11 -> 64
    //   56: aload 4
    //   58: aload 5
    //   60: aload_3
    //   61: invokevirtual 502	com/tencent/turingfd/sdk/base/y:a	(Landroid/os/Handler;Lcom/tencent/turingfd/sdk/base/s;)V
    //   64: aload 4
    //   66: aload_1
    //   67: putfield 503	com/tencent/turingfd/sdk/base/y:g	Lcom/tencent/turingfd/sdk/base/at;
    //   70: aload 4
    //   72: iconst_1
    //   73: putfield 499	com/tencent/turingfd/sdk/base/y:b	Z
    //   76: aload 4
    //   78: getfield 506	com/tencent/turingfd/sdk/base/y:c	Lcom/tencent/turingfd/sdk/base/t;
    //   81: ifnonnull +19 -> 100
    //   84: aload 4
    //   86: new 508	com/tencent/turingfd/sdk/base/t
    //   89: dup
    //   90: aload_1
    //   91: getfield 486	com/tencent/turingfd/sdk/base/at:c	Landroid/content/Context;
    //   94: invokespecial 511	com/tencent/turingfd/sdk/base/t:<init>	(Landroid/content/Context;)V
    //   97: putfield 506	com/tencent/turingfd/sdk/base/y:c	Lcom/tencent/turingfd/sdk/base/t;
    //   100: aload 4
    //   102: invokevirtual 513	com/tencent/turingfd/sdk/base/y:a	()V
    //   105: aload 4
    //   107: aload 5
    //   109: putfield 515	com/tencent/turingfd/sdk/base/y:d	Landroid/os/Handler;
    //   112: aload 5
    //   114: aload 4
    //   116: getfield 518	com/tencent/turingfd/sdk/base/y:j	Ljava/lang/Runnable;
    //   119: invokevirtual 456	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   122: pop
    //   123: aload_0
    //   124: getfield 49	com/tencent/turingfd/sdk/base/bb:f	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   127: invokevirtual 521	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +7 -> 139
    //   135: aload_0
    //   136: monitorexit
    //   137: iconst_1
    //   138: ireturn
    //   139: getstatic 524	com/tencent/turingfd/sdk/base/aa:a	Lcom/tencent/turingfd/sdk/base/cx;
    //   142: invokevirtual 81	com/tencent/turingfd/sdk/base/cx:b	()Ljava/lang/Object;
    //   145: checkcast 523	com/tencent/turingfd/sdk/base/aa
    //   148: astore_1
    //   149: new 8	com/tencent/turingfd/sdk/base/bb$b
    //   152: dup
    //   153: aload_0
    //   154: ldc_w 526
    //   157: invokespecial 529	com/tencent/turingfd/sdk/base/bb$b:<init>	(Lcom/tencent/turingfd/sdk/base/bb;Ljava/lang/String;)V
    //   160: astore_3
    //   161: aload_1
    //   162: getfield 531	com/tencent/turingfd/sdk/base/aa:b	Landroid/os/Handler;
    //   165: aload_3
    //   166: iconst_0
    //   167: i2l
    //   168: invokevirtual 535	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   171: pop
    //   172: goto -37 -> 135
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	bb
    //   0	180	1	paramat	at
    //   130	2	2	bool	boolean
    //   24	142	3	localObject	Object
    //   34	81	4	localy	y
    //   40	73	5	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   2	64	175	finally
    //   64	100	175	finally
    //   100	131	175	finally
    //   139	172	175	finally
  }
  
  public static final class a
    extends cx<bb>
  {
    public Object a()
    {
      return new bb(null);
    }
  }
  
  public class b
    extends x
  {
    public b(String paramString)
    {
      super();
    }
    
    public void a()
    {
      bb.a(bb.this).set(true);
      if (cl.b == null) {
        cl.b = cl.b();
      }
      Context localContext = bb.b(bb.this);
      if (cq.a == null) {
        cq.a = cq.a(localContext);
      }
      af.a();
      cl.a();
      bb.a(bb.this).set(false);
    }
  }
  
  public class c
    extends x
  {
    public c(String paramString1, int paramInt, am paramam, Context paramContext, String paramString2)
    {
      super();
    }
    
    public void a()
    {
      az localaz = ((bn)bn.a.b()).a(bb.b(bb.this), paramInt);
      if (localaz == null) {
        ((ah)paramam).a(-1);
      }
      Dew localDew;
      do
      {
        return;
        localDew = localaz.a;
        localDew = bb.a(bb.this, paramContext, paramString, localDew);
      } while (!bb.a(bb.this, paramam, localDew));
      bb.a(bb.this, localaz.b);
    }
  }
  
  private final class d
    implements s
  {
    public void a(int paramInt)
    {
      Object localObject = bb.d(this.a).f;
      if (localObject != null) {
        localObject = (ag.b)localObject;
      }
    }
    
    public void a(final at paramat, final List<ac> paramList, final SparseArray<z> paramSparseArray)
    {
      final int i = paramat.a;
      bb.a(this.a, false);
      bb.c(this.a).post(new a("saveSensorFile", i, paramSparseArray, paramList, paramat));
    }
    
    public class a
      extends x
    {
      public a(String paramString, int paramInt, SparseArray paramSparseArray, List paramList, at paramat)
      {
        super();
      }
      
      public void a()
      {
        int k = i;
        at localat = paramat;
        SparseArray localSparseArray = paramSparseArray;
        List localList = paramList;
        Dew localDew = new Dew();
        Lemon localLemon = localat.e;
        Object localObject1 = new ArrayList();
        int i = 0;
        Object localObject2;
        if (i < localSparseArray.size())
        {
          localObject2 = ((z)localSparseArray.valueAt(i)).a(localList);
          if (((ArrayList)localObject1).size() == 0) {}
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            break;
            int j = 0;
            while (j < ((ArrayList)localObject2).size())
            {
              ((Herbaceous)((ArrayList)localObject2).get(j)).Uc.putAll(((Herbaceous)((ArrayList)localObject1).get(j)).Uc);
              j += 1;
            }
          }
        }
        if ((((ArrayList)localObject1).size() > 0) && (((ArrayList)localObject1).get(0) != null))
        {
          localObject2 = new Guava();
          ((Guava)localObject2).Mc = ((Herbaceous)((ArrayList)localObject1).get(0)).Tc;
          ((Guava)localObject2).Nc = ((ArrayList)localObject1);
          ((Guava)localObject2).oc = k;
          ((Guava)localObject2).action = 1;
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localLemon);
          ((Guava)localObject2).Qc = ((ArrayList)localObject1);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject2);
          localDew.Lb = ((ArrayList)localObject1);
          long l = localat.e.od;
          i = localat.d;
          localObject2 = new Fig();
          ((Fig)localObject2).nc = l;
          ((Fig)localObject2).oc = k;
          ((Fig)localObject2).mc = i;
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(localObject2);
          localObject2 = new Date();
          ((Date)localObject2).zb = ((ArrayList)localObject1);
          localDew.ac = ((Date)localObject2);
          localDew.cc = new ArrayList();
          ((bn)bn.a.b()).a(paramat.c, i, 0, localDew);
          localObject1 = paramat.f;
          if (localObject1 != null) {
            ag.a(i, ((ag.b)localObject1).a);
          }
          return;
        }
        throw new IllegalArgumentException("invalid stateUnits");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bb
 * JD-Core Version:    0.7.0.1
 */