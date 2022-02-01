package com.tencent.token;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqpimsecure.pg.PermissionGuideActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class rg
{
  Context a;
  ArrayList<Object> b;
  public auq c;
  public aup d;
  public auu e;
  public aur f;
  public auw g;
  public ConcurrentHashMap<Integer, auv> h;
  private Handler i;
  
  private void a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, auv paramauv)
  {
    Intent localIntent = new Intent(this.a, PermissionGuideActivity.class);
    int j = paramauv.hashCode();
    localIntent.setFlags(268500992);
    localIntent.putExtra("e_pms", paramArrayOfInt);
    localIntent.putExtra("e_src", paramInt2);
    localIntent.putExtra("e_uid", j);
    localIntent.putExtra("e_u_h", paramBoolean3);
    localIntent.putExtra("e_s_c", paramBoolean1);
    localIntent.putExtra("e_m", paramBoolean2);
    localIntent.putExtra("e_md", paramInt1);
    this.a.startActivity(localIntent);
    this.h.put(Integer.valueOf(paramauv.hashCode()), paramauv);
  }
  
  public final int a(int paramInt)
  {
    Context localContext = this.a;
    int k = Build.VERSION.SDK_INT;
    int j = 1;
    Object localObject2 = null;
    Object localObject1;
    if (k < 8)
    {
      localObject1 = localObject2;
    }
    else
    {
      k = aqq.a(paramInt);
      Object localObject3 = ro.a(localContext).a(k);
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (((k)localObject3).e == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject3 = (apa)aqt.a(((k)localObject3).e, new apa());
          localObject1 = localObject2;
          if (localObject3 != null) {
            if (((apa)localObject3).c == null)
            {
              localObject1 = localObject2;
            }
            else if (!rb.a(localContext, (apa)localObject3))
            {
              ra.a(localContext, k, 1, 0);
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = rb.b(localContext, (apa)localObject3);
              if (!((Boolean)((Pair)localObject1).first).booleanValue())
              {
                ra.a(localContext, k, 1, ((Integer)((Pair)localObject1).second).intValue());
                localObject1 = localObject2;
              }
              else
              {
                ra.a(localContext, k, 0, ((Integer)((Pair)localObject1).second).intValue());
                localObject1 = localObject3;
              }
            }
          }
        }
      }
    }
    if (localObject1 == null) {
      j = 0;
    }
    k = j;
    if (re.a(this.a, paramInt) != null) {
      k = j | 0x2;
    }
    return k;
  }
  
  public final void a()
  {
    rp localrp = ro.a(this.a).a;
    aqx.b();
    if (localrp.a != null)
    {
      localrp.b.sendMessage(localrp.b.obtainMessage(0, 1, 0, null));
      localrp.c = System.currentTimeMillis();
      new StringBuilder("pullTime:").append(localrp.c);
      aqx.b();
      return;
    }
    throw new RuntimeException("host was not set shark before pull solutions!");
  }
  
  public final void a(Application paramApplication)
  {
    final Context localContext = paramApplication.getApplicationContext();
    aqk.a = new auq()
    {
      public final int a(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 37) {
          return rf.a();
        }
        if (paramAnonymousInt == 5) {
          return rk.a.a().a("pgd_sp").a("f_w_c", 2);
        }
        return 2;
      }
    };
    Object localObject = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
    if (((String)localObject).contains("huawei")) {
      localObject = new aqm(localContext);
    } else if (((String)localObject).contains("oppo")) {
      localObject = new aqo(localContext);
    } else if (((String)localObject).contains("vivo")) {
      localObject = new aqp(localContext);
    } else if (((String)localObject).contains("xiaomi")) {
      localObject = new aqn(localContext);
    } else {
      localObject = new aql(localContext);
    }
    this.c = ((auq)localObject);
    this.a = localContext;
    this.b = new ArrayList();
    this.h = new ConcurrentHashMap();
    localObject = new HandlerThread("ForegroundVisibleCheck");
    ((HandlerThread)localObject).start();
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        rf.a(false);
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(new Runnable()
        {
          public final void run()
          {
            if (!rf.c())
            {
              Context localContext = rg.this.a;
              long l = rk.a.a().a("pgd_sp").a("f_w_m_t", 0L);
              int i = rg.a.a().c.a(5);
              Object localObject;
              if (System.currentTimeMillis() - l > 5000L)
              {
                rf.b(i);
                if (l > 0L)
                {
                  rf.a(0L);
                  localObject = re.a(localContext, 5);
                  int j;
                  if (i == 0)
                  {
                    if ((localObject == null) || (((e)localObject).a == null)) {
                      break label147;
                    }
                    j = 30109;
                    i = 1;
                  }
                  else
                  {
                    if ((localObject == null) || (((e)localObject).a == null)) {
                      break label147;
                    }
                    j = aqq.b(5);
                    i = 0;
                  }
                  ra.a(localContext, j, i, rf.b(), 0, ((e)localObject).a.d);
                }
              }
              label147:
              localContext = rg.this.a;
              if (Build.VERSION.SDK_INT > 24)
              {
                rf.a(-1);
                return;
              }
              if ((!rf.c()) && (rf.a() == 2))
              {
                localObject = (WindowManager)localContext.getSystemService("window");
                WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
                localLayoutParams.width = 0;
                localLayoutParams.height = 0;
                localLayoutParams.type = 2005;
                rh.1 local1 = new rh.1(localContext, localContext);
                Handler localHandler = new Handler(Looper.getMainLooper());
                localHandler.post(new rh.2(local1, (WindowManager)localObject, localLayoutParams, localContext));
                localHandler.postDelayed(new rh.3(local1, (WindowManager)localObject), 1000L);
              }
            }
          }
        }, 2000L);
      }
      
      public final void onActivityResumed(Activity paramAnonymousActivity)
      {
        rf.a(true);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    paramApplication = new HandlerThread("AdapterSolutionCheck");
    paramApplication.start();
    this.i = new Handler(paramApplication.getLooper());
    paramApplication = new IntentFilter();
    paramApplication.addAction("act_got_ads");
    localContext.registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        rg localrg = rg.this;
        paramAnonymousContext = paramAnonymousIntent.getIntegerArrayListExtra("up");
        if (paramAnonymousContext != null)
        {
          if (paramAnonymousContext.isEmpty()) {
            return;
          }
          paramAnonymousIntent = new SparseIntArray();
          Object localObject = paramAnonymousContext.iterator();
          int j;
          int i;
          int k;
          while (((Iterator)localObject).hasNext())
          {
            int m = ((Integer)((Iterator)localObject).next()).intValue();
            j = 6;
            i = j;
            if (m != 30007)
            {
              if (m != 30107)
              {
                k = 3;
                switch (m)
                {
                default: 
                  j = 5;
                  i = j;
                  switch (m)
                  {
                  default: 
                    switch (m)
                    {
                    default: 
                      switch (m)
                      {
                      default: 
                        break;
                      case 30120: 
                        paramAnonymousIntent.append(38, paramAnonymousIntent.get(38) | 0x2);
                        paramAnonymousContext = localrg.a;
                        i = 38;
                        break;
                      case 30119: 
                        paramAnonymousIntent.append(30, paramAnonymousIntent.get(30) | 0x2);
                        paramAnonymousContext = localrg.a;
                        i = 30;
                        break;
                      case 30118: 
                        paramAnonymousIntent.append(36, paramAnonymousIntent.get(36) | 0x2);
                        re.a(localrg.a, 36);
                        break;
                      case 30117: 
                        paramAnonymousIntent.append(4, paramAnonymousIntent.get(4) | 0x2);
                        re.a(localrg.a, 4);
                        break;
                      case 30116: 
                        paramAnonymousIntent.append(29, paramAnonymousIntent.get(29) | 0x2);
                        re.a(localrg.a, 29);
                        break;
                      case 30115: 
                        paramAnonymousIntent.append(27, paramAnonymousIntent.get(27) | 0x2);
                        re.a(localrg.a, 27);
                        break;
                      case 30114: 
                        paramAnonymousIntent.append(24, paramAnonymousIntent.get(24) | 0x2);
                        re.a(localrg.a, 24);
                        break;
                      case 30113: 
                        paramAnonymousIntent.append(21, paramAnonymousIntent.get(21) | 0x2);
                        re.a(localrg.a, 21);
                        break;
                      case 30112: 
                        paramAnonymousIntent.append(14, paramAnonymousIntent.get(14) | 0x2);
                        re.a(localrg.a, 14);
                        break;
                      case 30111: 
                        paramAnonymousIntent.append(11, paramAnonymousIntent.get(11) | 0x2);
                        re.a(localrg.a, 11);
                        break;
                      case 30110: 
                        paramAnonymousIntent.append(2, paramAnonymousIntent.get(2) | 0x2);
                        re.a(localrg.a, 2);
                      }
                      break;
                    case 30104: 
                      paramAnonymousIntent.append(3, paramAnonymousIntent.get(3) | 0x2);
                      paramAnonymousContext = localrg.a;
                      i = k;
                      re.a(paramAnonymousContext, i);
                      break;
                    case 30103: 
                      i = 25;
                      break;
                    case 30102: 
                      i = 8;
                      paramAnonymousIntent.append(i, paramAnonymousIntent.get(i) | 0x2);
                      re.a(localrg.a, i);
                    }
                    break;
                  case 30020: 
                    i = 38;
                    j = 38;
                    break;
                  case 30019: 
                    i = 30;
                    j = 30;
                    j = paramAnonymousIntent.get(j);
                    break;
                  case 30018: 
                    paramAnonymousIntent.append(36, paramAnonymousIntent.get(36) | 0x1);
                    break;
                  case 30017: 
                    paramAnonymousIntent.append(4, paramAnonymousIntent.get(4) | 0x1);
                    break;
                  case 30016: 
                    paramAnonymousIntent.append(29, paramAnonymousIntent.get(29) | 0x1);
                    break;
                  case 30015: 
                    paramAnonymousIntent.append(27, paramAnonymousIntent.get(27) | 0x1);
                    break;
                  case 30014: 
                    paramAnonymousIntent.append(24, paramAnonymousIntent.get(24) | 0x1);
                    break;
                  case 30013: 
                    paramAnonymousIntent.append(21, paramAnonymousIntent.get(21) | 0x1);
                    break;
                  case 30012: 
                    paramAnonymousIntent.append(14, paramAnonymousIntent.get(14) | 0x1);
                    break;
                  case 30011: 
                    paramAnonymousIntent.append(11, paramAnonymousIntent.get(11) | 0x1);
                    break;
                  case 30010: 
                    paramAnonymousIntent.append(2, paramAnonymousIntent.get(2) | 0x1);
                  }
                  break;
                case 30004: 
                  paramAnonymousIntent.append(3, paramAnonymousIntent.get(3) | 0x1);
                  break;
                case 30003: 
                  i = 25;
                  break;
                case 30002: 
                  i = 8;
                  j = paramAnonymousIntent.get(i);
                  paramAnonymousIntent.append(i, j | 0x1);
                  break;
                }
              }
              else
              {
                paramAnonymousIntent.append(j, paramAnonymousIntent.get(j) | 0x2);
                re.a(localrg.a, j);
              }
            }
            else {
              paramAnonymousIntent.append(i, paramAnonymousIntent.get(i) | 0x1);
            }
          }
          try
          {
            if ((localrg.b != null) && (!localrg.b.isEmpty()))
            {
              j = paramAnonymousIntent.size();
              paramAnonymousContext = new int[j];
              localObject = new int[j];
              i = 0;
              while (i < j)
              {
                k = paramAnonymousIntent.keyAt(i);
                paramAnonymousContext[i] = k;
                localObject[i] = paramAnonymousIntent.get(k);
                i += 1;
              }
              paramAnonymousContext = localrg.b.iterator();
              while (paramAnonymousContext.hasNext()) {
                paramAnonymousContext.next();
              }
            }
            return;
          }
          finally {}
        }
      }
    }, paramApplication);
  }
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, auv paramauv)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 1, paramInt, true, paramauv);
  }
  
  public final int[] a(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int[] arrayOfInt = new int[paramVarArgs.length];
      int j = 0;
      while (j < paramVarArgs.length)
      {
        arrayOfInt[j] = this.c.a(paramVarArgs[j]);
        StringBuilder localStringBuilder = new StringBuilder("permission ");
        localStringBuilder.append(paramVarArgs[j]);
        localStringBuilder.append(" result ");
        localStringBuilder.append(arrayOfInt[j]);
        aqx.b();
        if (arrayOfInt[j] != 0)
        {
          final int k = paramVarArgs[j];
          this.i.post(new Runnable()
          {
            public final void run()
            {
              rg.this.a(k);
            }
          });
        }
        j += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public final void b(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, auv paramauv)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 3, paramInt, false, paramauv);
  }
  
  public final int[] b(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int[] arrayOfInt = new int[paramVarArgs.length];
      int j = 0;
      while (j < paramVarArgs.length)
      {
        arrayOfInt[j] = this.c.a(paramVarArgs[j]);
        StringBuilder localStringBuilder = new StringBuilder("permission ");
        localStringBuilder.append(paramVarArgs[j]);
        localStringBuilder.append(" result ");
        localStringBuilder.append(arrayOfInt[j]);
        aqx.b();
        j += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public final void c(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, auv paramauv)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 2, paramInt, false, paramauv);
  }
  
  public static final class a
  {
    @SuppressLint({"StaticFieldLeak"})
    private static rg a = new rg((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.rg
 * JD-Core Version:    0.7.0.1
 */