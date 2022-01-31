package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import com.tencent.qqpimsecure.taiji.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import taiji.b;
import taiji.bt;
import taiji.ca;
import taiji.cl;
import tmsdk.common.module.pgsdk.ExecuteHelperCallback;
import tmsdk.common.module.pgsdk.IPermissionChecker;
import tmsdk.common.module.pgsdk.PageCallback;
import tmsdk.common.module.pgsdk.PreviewCallback;
import tmsdk.common.module.pgsdk.RequestCallback;
import tmsdk.common.module.pgsdk.UpdateListener;
import tmsdk.common.module.pgsdk.WindowCallback;

public class r
{
  IPermissionChecker a;
  ExecuteHelperCallback b;
  PreviewCallback c;
  PageCallback d;
  WindowCallback e;
  ConcurrentHashMap f;
  private Context g;
  private Handler h;
  private ArrayList i;
  
  public static r a()
  {
    return x.a();
  }
  
  private void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Object localObject = new SparseIntArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      switch (((Integer)paramArrayList.next()).intValue())
      {
      default: 
        break;
      case 30002: 
        ((SparseIntArray)localObject).append(8, ((SparseIntArray)localObject).get(8) | 0x1);
        break;
      case 30010: 
        ((SparseIntArray)localObject).append(2, ((SparseIntArray)localObject).get(2) | 0x1);
        break;
      case 30004: 
        ((SparseIntArray)localObject).append(3, ((SparseIntArray)localObject).get(3) | 0x1);
        break;
      case 30017: 
        ((SparseIntArray)localObject).append(4, ((SparseIntArray)localObject).get(4) | 0x1);
        break;
      case 30009: 
        ((SparseIntArray)localObject).append(5, ((SparseIntArray)localObject).get(5) | 0x1);
        break;
      case 30007: 
        ((SparseIntArray)localObject).append(6, ((SparseIntArray)localObject).get(6) | 0x1);
        break;
      case 30011: 
        ((SparseIntArray)localObject).append(11, ((SparseIntArray)localObject).get(11) | 0x1);
        break;
      case 30012: 
        ((SparseIntArray)localObject).append(14, ((SparseIntArray)localObject).get(14) | 0x1);
        break;
      case 30013: 
        ((SparseIntArray)localObject).append(21, ((SparseIntArray)localObject).get(21) | 0x1);
        break;
      case 30014: 
        ((SparseIntArray)localObject).append(24, ((SparseIntArray)localObject).get(24) | 0x1);
        break;
      case 30003: 
        ((SparseIntArray)localObject).append(25, ((SparseIntArray)localObject).get(25) | 0x1);
        break;
      case 30015: 
        ((SparseIntArray)localObject).append(27, ((SparseIntArray)localObject).get(27) | 0x1);
        break;
      case 30016: 
        ((SparseIntArray)localObject).append(29, ((SparseIntArray)localObject).get(29) | 0x1);
        break;
      case 30019: 
        ((SparseIntArray)localObject).append(30, ((SparseIntArray)localObject).get(30) | 0x1);
        break;
      case 30018: 
        ((SparseIntArray)localObject).append(36, ((SparseIntArray)localObject).get(36) | 0x1);
        break;
      case 30020: 
        ((SparseIntArray)localObject).append(38, ((SparseIntArray)localObject).get(38) | 0x1);
        break;
      case 30110: 
        ((SparseIntArray)localObject).append(2, ((SparseIntArray)localObject).get(2) | 0x2);
        m.a(this.g, 2);
        break;
      case 30104: 
        ((SparseIntArray)localObject).append(3, ((SparseIntArray)localObject).get(3) | 0x2);
        m.a(this.g, 3);
        break;
      case 30117: 
        ((SparseIntArray)localObject).append(4, ((SparseIntArray)localObject).get(4) | 0x2);
        m.a(this.g, 4);
        break;
      case 30109: 
        ((SparseIntArray)localObject).append(5, ((SparseIntArray)localObject).get(5) | 0x2);
        m.a(this.g, 5);
        break;
      case 30107: 
        ((SparseIntArray)localObject).append(6, ((SparseIntArray)localObject).get(6) | 0x2);
        m.a(this.g, 6);
        break;
      case 30102: 
        ((SparseIntArray)localObject).append(8, ((SparseIntArray)localObject).get(8) | 0x2);
        m.a(this.g, 8);
        break;
      case 30111: 
        ((SparseIntArray)localObject).append(11, ((SparseIntArray)localObject).get(11) | 0x2);
        m.a(this.g, 11);
        break;
      case 30112: 
        ((SparseIntArray)localObject).append(14, ((SparseIntArray)localObject).get(14) | 0x2);
        m.a(this.g, 14);
        break;
      case 30113: 
        ((SparseIntArray)localObject).append(21, ((SparseIntArray)localObject).get(21) | 0x2);
        m.a(this.g, 21);
        break;
      case 30114: 
        ((SparseIntArray)localObject).append(24, ((SparseIntArray)localObject).get(24) | 0x2);
        m.a(this.g, 24);
        break;
      case 30103: 
        ((SparseIntArray)localObject).append(25, ((SparseIntArray)localObject).get(25) | 0x2);
        m.a(this.g, 25);
        break;
      case 30115: 
        ((SparseIntArray)localObject).append(27, ((SparseIntArray)localObject).get(27) | 0x2);
        m.a(this.g, 27);
        break;
      case 30116: 
        ((SparseIntArray)localObject).append(29, ((SparseIntArray)localObject).get(29) | 0x2);
        m.a(this.g, 29);
        break;
      case 30119: 
        ((SparseIntArray)localObject).append(30, ((SparseIntArray)localObject).get(30) | 0x2);
        m.a(this.g, 30);
        break;
      case 30118: 
        ((SparseIntArray)localObject).append(36, ((SparseIntArray)localObject).get(36) | 0x2);
        m.a(this.g, 36);
        break;
      case 30120: 
        ((SparseIntArray)localObject).append(38, ((SparseIntArray)localObject).get(38) | 0x2);
        m.a(this.g, 38);
      }
    }
    try
    {
      if ((this.i != null) && (!this.i.isEmpty()))
      {
        int k = ((SparseIntArray)localObject).size();
        paramArrayList = new int[k];
        int[] arrayOfInt = new int[k];
        int j = 0;
        while (j < k)
        {
          int m = ((SparseIntArray)localObject).keyAt(j);
          paramArrayList[j] = m;
          arrayOfInt[j] = ((SparseIntArray)localObject).get(m);
          j += 1;
        }
        localObject = this.i.iterator();
        while (((Iterator)localObject).hasNext())
        {
          UpdateListener localUpdateListener = (UpdateListener)((Iterator)localObject).next();
          if (localUpdateListener != null) {
            localUpdateListener.onCallback(paramArrayList, arrayOfInt);
          }
        }
      }
    }
    finally {}
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
    int j = 0;
    if (g.a(this.g, paramInt) != null) {
      j = 1;
    }
    int k = j;
    if (m.a(this.g, paramInt) != null) {
      k = j | 0x2;
    }
    return k;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Context localContext = null;
    MSolution localMSolution = m.a(this.g, paramInt);
    Object localObject = localContext;
    if (localMSolution != null)
    {
      localObject = localContext;
      if (localMSolution.mJumpIntent != null)
      {
        localObject = localContext;
        if (localMSolution.mJumpIntent.mPackage != null) {
          localObject = localMSolution.mJumpIntent.mPackage;
        }
      }
    }
    localContext = this.g;
    int k = ca.b(paramInt);
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      f.a(localContext, k, j, q.c(this.g, paramInt), 0, (String)localObject);
      return;
    }
  }
  
  public void a(Application paramApplication)
  {
    Context localContext = paramApplication.getApplicationContext();
    this.a = bt.a(localContext, new s(this, localContext));
    this.g = localContext;
    this.i = new ArrayList();
    this.f = new ConcurrentHashMap();
    HandlerThread localHandlerThread = new HandlerThread("ForegroundVisibleCheck");
    localHandlerThread.start();
    paramApplication.registerActivityLifecycleCallbacks(new t(this, new Handler(localHandlerThread.getLooper())));
    paramApplication = new HandlerThread("AdapterSolutionCheck");
    paramApplication.start();
    this.h = new Handler(paramApplication.getLooper());
    paramApplication = new IntentFilter();
    paramApplication.addAction("act_got_ads");
    localContext.registerReceiver(new v(this), paramApplication);
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
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return null;
    }
    int[] arrayOfInt = new int[paramVarArgs.length];
    int j = 0;
    while (j < paramVarArgs.length)
    {
      arrayOfInt[j] = this.a.checkPermission(paramVarArgs[j]);
      cl.b("PermissionCheckResultDetail", "permission " + paramVarArgs[j] + " result " + arrayOfInt[j]);
      if (arrayOfInt[j] != 0)
      {
        int k = paramVarArgs[j];
        this.h.post(new w(this, k));
      }
      j += 1;
    }
    return arrayOfInt;
  }
  
  public long b(int paramInt)
  {
    paramInt = ca.b(paramInt);
    SolutionItem localSolutionItem = n.a(this.g).a(paramInt);
    if (localSolutionItem == null) {
      return -1L;
    }
    return localSolutionItem.commSoluId;
  }
  
  public void b()
  {
    n.a(this.g).a(null);
  }
  
  public void b(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, int paramInt, RequestCallback paramRequestCallback)
  {
    a(paramArrayOfInt, paramBoolean1, paramBoolean2, 3, paramInt, false, paramRequestCallback);
  }
  
  int[] b(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return null;
    }
    int[] arrayOfInt = new int[paramVarArgs.length];
    int j = 0;
    while (j < paramVarArgs.length)
    {
      arrayOfInt[j] = this.a.checkPermission(paramVarArgs[j]);
      cl.b("PermissionCheckResultDetail", "permission " + paramVarArgs[j] + " result " + arrayOfInt[j]);
      j += 1;
    }
    return arrayOfInt;
  }
  
  public long c(int paramInt)
  {
    paramInt = ca.a(paramInt);
    SolutionItem localSolutionItem = n.a(this.g).a(paramInt);
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
    return n.a(this.g).a();
  }
  
  public int d(int paramInt)
  {
    return ca.b(paramInt);
  }
  
  public boolean d()
  {
    return ca.a(this.g);
  }
  
  public int e(int paramInt)
  {
    return ca.a(paramInt);
  }
  
  public boolean f(int paramInt)
  {
    return ca.a(this.g, paramInt);
  }
  
  public MSolution g(int paramInt)
  {
    return m.a(this.g, paramInt);
  }
  
  public b h(int paramInt)
  {
    return g.a(this.g, paramInt);
  }
  
  public SolutionItem i(int paramInt)
  {
    return n.a(this.g).a(paramInt);
  }
  
  public String j(int paramInt)
  {
    return ca.b(this.g, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.r
 * JD-Core Version:    0.7.0.1
 */