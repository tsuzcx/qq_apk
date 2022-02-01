package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import taiji.ba;
import taiji.bg;
import taiji.bn;
import tmsdk.common.module.pgsdk.ExecuteHelperCallback;
import tmsdk.common.module.pgsdk.IPermissionChecker;
import tmsdk.common.module.pgsdk.PageCallback;
import tmsdk.common.module.pgsdk.PreviewCallback;
import tmsdk.common.module.pgsdk.RequestCallback;
import tmsdk.common.module.pgsdk.UpdateListener;
import tmsdk.common.module.pgsdk.WindowCallback;

public class g
{
  IPermissionChecker a;
  ExecuteHelperCallback b;
  PreviewCallback c;
  PageCallback d;
  WindowCallback e;
  ConcurrentHashMap<Integer, RequestCallback> f;
  private Context g;
  private Handler h;
  private ArrayList<UpdateListener> i;
  
  public static g a()
  {
    return a.a();
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Object localObject1 = new SparseIntArray();
      Object localObject2 = paramArrayList.iterator();
      int k;
      int j;
      int m;
      while (((Iterator)localObject2).hasNext())
      {
        int n = ((Integer)((Iterator)localObject2).next()).intValue();
        k = 6;
        j = k;
        if (n != 30007) {
          if (n != 30107)
          {
            m = 3;
            k = 25;
            j = k;
          }
        }
        switch (n)
        {
        default: 
          switch (n)
          {
          default: 
            switch (n)
            {
            default: 
              switch (n)
              {
              default: 
                break;
              case 30120: 
                ((SparseIntArray)localObject1).append(38, ((SparseIntArray)localObject1).get(38) | 0x2);
                paramArrayList = this.g;
                j = 38;
                break;
              case 30119: 
                ((SparseIntArray)localObject1).append(30, ((SparseIntArray)localObject1).get(30) | 0x2);
                paramArrayList = this.g;
                j = 30;
                break;
              case 30118: 
                ((SparseIntArray)localObject1).append(36, ((SparseIntArray)localObject1).get(36) | 0x2);
                e.a(this.g, 36);
                break;
              case 30117: 
                ((SparseIntArray)localObject1).append(4, ((SparseIntArray)localObject1).get(4) | 0x2);
                e.a(this.g, 4);
                break;
              case 30116: 
                ((SparseIntArray)localObject1).append(29, ((SparseIntArray)localObject1).get(29) | 0x2);
                e.a(this.g, 29);
                break;
              case 30115: 
                ((SparseIntArray)localObject1).append(27, ((SparseIntArray)localObject1).get(27) | 0x2);
                e.a(this.g, 27);
                break;
              case 30114: 
                ((SparseIntArray)localObject1).append(24, ((SparseIntArray)localObject1).get(24) | 0x2);
                e.a(this.g, 24);
                break;
              case 30113: 
                ((SparseIntArray)localObject1).append(21, ((SparseIntArray)localObject1).get(21) | 0x2);
                e.a(this.g, 21);
                break;
              case 30112: 
                ((SparseIntArray)localObject1).append(14, ((SparseIntArray)localObject1).get(14) | 0x2);
                e.a(this.g, 14);
                break;
              case 30111: 
                ((SparseIntArray)localObject1).append(11, ((SparseIntArray)localObject1).get(11) | 0x2);
                e.a(this.g, 11);
                break;
              case 30110: 
                ((SparseIntArray)localObject1).append(2, ((SparseIntArray)localObject1).get(2) | 0x2);
                e.a(this.g, 2);
                break;
              case 30109: 
                ((SparseIntArray)localObject1).append(5, ((SparseIntArray)localObject1).get(5) | 0x2);
                e.a(this.g, 5);
              }
              break;
            case 30104: 
              ((SparseIntArray)localObject1).append(3, ((SparseIntArray)localObject1).get(3) | 0x2);
              paramArrayList = this.g;
              j = m;
              e.a(paramArrayList, j);
              break;
            case 30103: 
              ((SparseIntArray)localObject1).append(k, ((SparseIntArray)localObject1).get(k) | 0x2);
              e.a(this.g, k);
              break;
            case 30102: 
              ((SparseIntArray)localObject1).append(8, ((SparseIntArray)localObject1).get(8) | 0x2);
              e.a(this.g, 8);
            }
            break;
          case 30020: 
            j = 38;
            k = 38;
            break;
          case 30019: 
            j = 30;
            k = 30;
            k = ((SparseIntArray)localObject1).get(k);
            break;
          case 30018: 
            ((SparseIntArray)localObject1).append(36, ((SparseIntArray)localObject1).get(36) | 0x1);
            break;
          case 30017: 
            ((SparseIntArray)localObject1).append(4, ((SparseIntArray)localObject1).get(4) | 0x1);
            break;
          case 30016: 
            ((SparseIntArray)localObject1).append(29, ((SparseIntArray)localObject1).get(29) | 0x1);
            break;
          case 30015: 
            ((SparseIntArray)localObject1).append(27, ((SparseIntArray)localObject1).get(27) | 0x1);
            break;
          case 30014: 
            ((SparseIntArray)localObject1).append(24, ((SparseIntArray)localObject1).get(24) | 0x1);
            break;
          case 30013: 
            ((SparseIntArray)localObject1).append(21, ((SparseIntArray)localObject1).get(21) | 0x1);
            break;
          case 30012: 
            ((SparseIntArray)localObject1).append(14, ((SparseIntArray)localObject1).get(14) | 0x1);
            break;
          case 30011: 
            ((SparseIntArray)localObject1).append(11, ((SparseIntArray)localObject1).get(11) | 0x1);
            break;
          case 30010: 
            ((SparseIntArray)localObject1).append(2, ((SparseIntArray)localObject1).get(2) | 0x1);
            break;
          case 30009: 
            ((SparseIntArray)localObject1).append(5, ((SparseIntArray)localObject1).get(5) | 0x1);
          }
          break;
        case 30004: 
          ((SparseIntArray)localObject1).append(3, ((SparseIntArray)localObject1).get(3) | 0x1);
          break;
        case 30003: 
          ((SparseIntArray)localObject1).append(j, ((SparseIntArray)localObject1).get(j) | 0x1);
          break;
        case 30002: 
          j = 8;
          k = ((SparseIntArray)localObject1).get(8);
          ((SparseIntArray)localObject1).append(j, k | 0x1);
        }
      }
      try
      {
        if ((this.i != null) && (!this.i.isEmpty()))
        {
          k = ((SparseIntArray)localObject1).size();
          paramArrayList = new int[k];
          localObject2 = new int[k];
          j = 0;
          while (j < k)
          {
            m = ((SparseIntArray)localObject1).keyAt(j);
            paramArrayList[j] = m;
            localObject2[j] = ((SparseIntArray)localObject1).get(m);
            j += 1;
          }
          localObject1 = this.i.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            UpdateListener localUpdateListener = (UpdateListener)((Iterator)localObject1).next();
            if (localUpdateListener != null) {
              localUpdateListener.onCallback(paramArrayList, (int[])localObject2);
            }
          }
        }
        return;
      }
      finally {}
    }
  }
  
  private void a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, RequestCallback paramRequestCallback)
  {
    Intent localIntent = new Intent(this.g, PermissionGuideActivity.class);
    int j = paramRequestCallback.hashCode();
    localIntent.setFlags(268500992);
    localIntent.putExtra("e_pms", paramArrayOfInt);
    localIntent.putExtra("e_src", paramInt2);
    localIntent.putExtra("e_uid", j);
    localIntent.putExtra("e_u_h", paramBoolean3);
    localIntent.putExtra("e_s_c", paramBoolean1);
    localIntent.putExtra("e_m", paramBoolean2);
    localIntent.putExtra("e_md", paramInt1);
    this.g.startActivity(localIntent);
    this.f.put(Integer.valueOf(paramRequestCallback.hashCode()), paramRequestCallback);
  }
  
  public int a(int paramInt)
  {
    int j;
    if (b.a(this.g, paramInt) != null) {
      j = 1;
    } else {
      j = 0;
    }
    int k = j;
    if (e.a(this.g, paramInt) != null) {
      k = j | 0x2;
    }
    return k;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Application paramApplication)
  {
    final Context localContext = paramApplication.getApplicationContext();
    this.a = ba.a(localContext, new IPermissionChecker()
    {
      public int checkPermission(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 37) {
          return f.a(localContext);
        }
        if (paramAnonymousInt == 5) {
          return f.b(localContext);
        }
        return 2;
      }
    });
    this.g = localContext;
    this.i = new ArrayList();
    this.f = new ConcurrentHashMap();
    HandlerThread localHandlerThread = new HandlerThread("ForegroundVisibleCheck");
    localHandlerThread.start();
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        f.a(g.a(g.this), false);
        this.a.removeCallbacksAndMessages(null);
        this.a.postDelayed(new Runnable()
        {
          public void run()
          {
            if (!f.d(g.a(g.this)))
            {
              h.a(g.a(g.this));
              h.b(g.a(g.this));
            }
          }
        }, 2000L);
      }
      
      public void onActivityResumed(Activity paramAnonymousActivity)
      {
        f.a(g.a(g.this), true);
      }
      
      public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public void onActivityStopped(Activity paramAnonymousActivity) {}
    });
    paramApplication = new HandlerThread("AdapterSolutionCheck");
    paramApplication.start();
    this.h = new Handler(paramApplication.getLooper());
    paramApplication = new IntentFilter();
    paramApplication.addAction("act_got_ads");
    localContext.registerReceiver(new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        g.a(g.this, paramAnonymousIntent.getIntegerArrayListExtra("up"));
      }
    }, paramApplication);
  }
  
  public void a(ExecuteHelperCallback paramExecuteHelperCallback)
  {
    this.b = paramExecuteHelperCallback;
  }
  
  public void a(PageCallback paramPageCallback)
  {
    this.d = paramPageCallback;
  }
  
  public void a(PreviewCallback paramPreviewCallback)
  {
    this.c = paramPreviewCallback;
  }
  
  public void a(UpdateListener paramUpdateListener)
  {
    if (this.i == null) {
      return;
    }
    try
    {
      this.i.add(paramUpdateListener);
      return;
    }
    finally {}
  }
  
  public void a(WindowCallback paramWindowCallback)
  {
    this.e = paramWindowCallback;
  }
  
  public void a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, RequestCallback paramRequestCallback)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 1, paramInt, true, paramRequestCallback);
  }
  
  public int[] a(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int[] arrayOfInt = new int[paramVarArgs.length];
      int j = 0;
      while (j < paramVarArgs.length)
      {
        arrayOfInt[j] = this.a.checkPermission(paramVarArgs[j]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("permission ");
        localStringBuilder.append(paramVarArgs[j]);
        localStringBuilder.append(" result ");
        localStringBuilder.append(arrayOfInt[j]);
        bn.b("PermissionCheckResultDetail", localStringBuilder.toString());
        if (arrayOfInt[j] != 0)
        {
          final int k = paramVarArgs[j];
          this.h.post(new Runnable()
          {
            public void run()
            {
              g.this.a(k);
            }
          });
        }
        j += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public long b(int paramInt)
  {
    paramInt = bg.b(paramInt);
    SolutionItem localSolutionItem = com.tencent.qqpimsecure.taiji.g.a(this.g).a(paramInt);
    if (localSolutionItem == null) {
      return -1L;
    }
    return localSolutionItem.commSoluId;
  }
  
  public void b()
  {
    com.tencent.qqpimsecure.taiji.g.a(this.g).a(null);
  }
  
  public void b(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, RequestCallback paramRequestCallback)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 3, paramInt, false, paramRequestCallback);
  }
  
  int[] b(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int[] arrayOfInt = new int[paramVarArgs.length];
      int j = 0;
      while (j < paramVarArgs.length)
      {
        arrayOfInt[j] = this.a.checkPermission(paramVarArgs[j]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("permission ");
        localStringBuilder.append(paramVarArgs[j]);
        localStringBuilder.append(" result ");
        localStringBuilder.append(arrayOfInt[j]);
        bn.b("PermissionCheckResultDetail", localStringBuilder.toString());
        j += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public long c(int paramInt)
  {
    paramInt = bg.a(paramInt);
    SolutionItem localSolutionItem = com.tencent.qqpimsecure.taiji.g.a(this.g).a(paramInt);
    if (localSolutionItem == null) {
      return -1L;
    }
    return localSolutionItem.commSoluId;
  }
  
  public void c(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, RequestCallback paramRequestCallback)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 2, paramInt, false, paramRequestCallback);
  }
  
  public boolean c()
  {
    return com.tencent.qqpimsecure.taiji.g.a(this.g).a();
  }
  
  public int d(int paramInt)
  {
    return bg.b(paramInt);
  }
  
  public boolean d()
  {
    return bg.a(this.g);
  }
  
  public int e(int paramInt)
  {
    return bg.a(paramInt);
  }
  
  public boolean f(int paramInt)
  {
    return bg.a(this.g, paramInt);
  }
  
  public MSolution g(int paramInt)
  {
    return e.a(this.g, paramInt);
  }
  
  public taiji.b h(int paramInt)
  {
    return b.a(this.g, paramInt);
  }
  
  public SolutionItem i(int paramInt)
  {
    return com.tencent.qqpimsecure.taiji.g.a(this.g).a(paramInt);
  }
  
  public String j(int paramInt)
  {
    return bg.b(this.g, paramInt);
  }
  
  private static class a
  {
    @SuppressLint({"StaticFieldLeak"})
    private static g a = new g(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.g
 * JD-Core Version:    0.7.0.1
 */