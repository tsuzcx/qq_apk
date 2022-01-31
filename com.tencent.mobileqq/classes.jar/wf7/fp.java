package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.qqpimsecure.wificore.api.connect.WifiConfig;
import com.tencent.qqpimsecure.wificore.api.connect.c;
import com.tencent.qqpimsecure.wificore.api.connect.d;
import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.b;
import com.tencent.wifisdk.TMSDKWifiManager.IFreeWifiCheckCallback;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class fp
{
  private static final String TAG = fp.class.getSimpleName();
  private static fp qZ;
  private BitSet qE = new BitSet(2);
  private volatile long qF = 30000L;
  private volatile long qG = 120000L;
  private boolean qH = false;
  private List<fr> qI = new CopyOnWriteArrayList();
  private List<fo> qJ = new CopyOnWriteArrayList();
  private BroadcastReceiver qK = null;
  private AtomicBoolean qL = new AtomicBoolean(false);
  private AtomicBoolean qM = new AtomicBoolean(true);
  private AtomicInteger qN = new AtomicInteger(0);
  private AtomicInteger qO = new AtomicInteger(0);
  private bq qP = hm.fq();
  private b qQ = hm.fs();
  private bk qR = hm.fr();
  private d qS = hm.ft();
  private fp.d qT = new fp.d(this, null);
  private fp.e qU = new fp.e(this, null);
  private fp.f qV = new fp.f(this, null);
  private fp.b qW = new fp.b(this, null);
  private fp.c qX = new fp.c(this, null);
  private Handler qY = new fp.1(this, fq.getSubThreadLooper());
  
  private fp()
  {
    E(true);
    F(true);
    ao.c().d();
    this.qH = true;
  }
  
  @WorkerThread
  private void A(boolean paramBoolean)
  {
    BitSet localBitSet = this.qE;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localBitSet.clear(i);
      if (paramBoolean)
      {
        this.qM.set(false);
        ec();
        this.qO.set(0);
        this.qN.set(0);
      }
      if (this.qE.isEmpty()) {
        this.qY.removeCallbacksAndMessages(null);
      }
      return;
    }
  }
  
  @WorkerThread
  private void B(boolean paramBoolean)
  {
    this.qY.removeMessages(5);
    C(false);
    List localList = this.qP.c(paramBoolean);
    Context localContext = fq.cr();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "扫描超时，size：";; str = "扫描结束,size: ")
    {
      dg.a(localContext, str + hj.b(localList));
      q(localList);
      if (!hj.a(localList)) {
        break;
      }
      dY();
      return;
    }
    b(hm.fw(), null);
  }
  
  private void C(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.qP.a(this.qT);
        return;
      }
      finally {}
      this.qP.b(this.qT);
    }
  }
  
  private void D(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.qQ.a(this.qU);
        this.qQ.a(this.qV);
        return;
      }
      finally {}
      this.qQ.b(this.qU);
      this.qQ.b(this.qV);
    }
  }
  
  private void E(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.qR.a(this.qW);
        return;
      }
      finally {}
      this.qR.b(this.qW);
    }
  }
  
  private void F(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.qS.a(this.qX);
        return;
      }
      finally {}
      this.qS.b(this.qX);
    }
  }
  
  private void a(bn parambn, @Nullable String paramString, @Nullable c paramc)
  {
    parambn = cb.b(parambn.Z(), parambn.ab(), parambn.ad().L());
    if (!TextUtils.isEmpty(paramString)) {
      parambn.a(paramString, true, 0, 0);
    }
    hk.az(500109);
    this.qS.a(24, parambn, paramc);
  }
  
  private void ar(int paramInt)
  {
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onConnectionFailed(paramInt);
      }
    }
    finally {}
  }
  
  private void b(int paramInt, @Nullable List<bn> paramList)
  {
    try
    {
      Iterator localIterator = this.qI.iterator();
      while (localIterator.hasNext()) {
        ((fr)localIterator.next()).onUpdateFinish(paramInt, paramList);
      }
    }
    finally {}
  }
  
  public static fp dX()
  {
    if (qZ == null) {}
    try
    {
      if (qZ == null) {
        qZ = new fp();
      }
      return qZ;
    }
    finally {}
  }
  
  @WorkerThread
  private void dZ()
  {
    if ((this.qE.get(0)) && (!this.qM.get())) {}
    int i;
    do
    {
      return;
      i = this.qN.get();
    } while ((this.qE.get(0)) && (i > 0) && (this.qO.get() > i));
    y(false);
    if (ha.isWifiEnabled())
    {
      this.qO.incrementAndGet();
      C(true);
      this.qY.removeMessages(5);
      this.qY.sendEmptyMessageDelayed(5, 5000L);
      ha.startScan();
      return;
    }
    b(-2, null);
  }
  
  private void e(CurrentSessionItem paramCurrentSessionItem)
  {
    if (paramCurrentSessionItem == null) {
      label6:
      return;
    }
    for (;;)
    {
      try
      {
        switch (paramCurrentSessionItem.eX)
        {
        case 3: 
          Iterator localIterator = this.qJ.iterator();
          if (!localIterator.hasNext()) {
            break label6;
          }
          ((fo)localIterator.next()).a(i, paramCurrentSessionItem);
          continue;
          i = 1;
        }
      }
      finally {}
      continue;
      int i = 2;
      continue;
      i = 0;
    }
  }
  
  @WorkerThread
  private void ea()
  {
    this.qR.a(-1L, 2, new fp.3(this));
  }
  
  /* Error */
  private void eb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 414	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 462	wf7/fp:D	(Z)V
    //   22: invokestatic 467	wf7/dk:bJ	()I
    //   25: bipush 23
    //   27: if_icmplt +43 -> 70
    //   30: aload_0
    //   31: new 469	wf7/fp$a
    //   34: dup
    //   35: aload_0
    //   36: aconst_null
    //   37: invokespecial 470	wf7/fp$a:<init>	(Lwf7/fp;Lwf7/fp$1;)V
    //   40: putfield 88	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   43: new 472	android/content/IntentFilter
    //   46: dup
    //   47: invokespecial 473	android/content/IntentFilter:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: ldc_w 475
    //   55: invokevirtual 479	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   58: invokestatic 225	wf7/fq:cr	()Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 88	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   65: aload_2
    //   66: invokevirtual 485	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: getfield 95	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 193	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: goto -64 -> 14
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: goto -17 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	fp
    //   9	2	1	bool	boolean
    //   50	16	2	localIntentFilter	android.content.IntentFilter
    //   81	4	2	localObject	Object
    //   86	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	10	81	finally
    //   17	70	81	finally
    //   70	78	81	finally
    //   17	70	86	java/lang/Throwable
  }
  
  /* Error */
  private void ec()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 414	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_0
    //   19: invokespecial 462	wf7/fp:D	(Z)V
    //   22: aload_0
    //   23: getfield 88	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   26: ifnull +13 -> 39
    //   29: invokestatic 225	wf7/fq:cr	()Landroid/content/Context;
    //   32: aload_0
    //   33: getfield 88	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   36: invokevirtual 489	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   39: aload_0
    //   40: getfield 95	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   43: iconst_0
    //   44: invokevirtual 193	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   47: goto -33 -> 14
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    //   55: astore_2
    //   56: goto -17 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	fp
    //   9	2	1	bool	boolean
    //   50	4	2	localObject	Object
    //   55	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	10	50	finally
    //   17	39	50	finally
    //   39	47	50	finally
    //   17	39	55	java/lang/Throwable
  }
  
  private void ed()
  {
    CurrentSessionItem localCurrentSessionItem = this.qQ.n();
    if (localCurrentSessionItem == null) {
      return;
    }
    switch (localCurrentSessionItem.eW)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
      e(localCurrentSessionItem);
      return;
    case 1: 
      f(localCurrentSessionItem);
      return;
    }
    ar(-9);
  }
  
  private void ee()
  {
    try
    {
      Iterator localIterator = this.qI.iterator();
      while (localIterator.hasNext()) {
        ((fr)localIterator.next()).onUpdateStart();
      }
    }
    finally {}
  }
  
  private void ef()
  {
    try
    {
      y(true);
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onWifiEnabled();
      }
    }
    finally {}
  }
  
  private void eg()
  {
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onWifiDisabled();
      }
    }
    finally {}
  }
  
  private void eh()
  {
    try
    {
      y(true);
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onGPSEnabled();
      }
    }
    finally {}
  }
  
  private void ei()
  {
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onGPSDisabled();
      }
    }
    finally {}
  }
  
  /* Error */
  private void f(CurrentSessionItem paramCurrentSessionItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 86	wf7/fp:qJ	Ljava/util/List;
    //   13: invokeinterface 370 1 0
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 375 1 0
    //   25: ifeq -19 -> 6
    //   28: aload_2
    //   29: invokeinterface 379 1 0
    //   34: checkcast 381	wf7/fo
    //   37: aload_1
    //   38: invokeinterface 518 2 0
    //   43: goto -24 -> 19
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	fp
    //   0	51	1	paramCurrentSessionItem	CurrentSessionItem
    //   18	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   9	19	46	finally
    //   19	43	46	finally
  }
  
  private void q(List<bn> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = Collections.EMPTY_LIST;
      paramList = this.qI.iterator();
      while (paramList.hasNext()) {
        ((fr)paramList.next()).onScanResult((List)localObject);
      }
    }
    finally {}
  }
  
  /* Error */
  private void u(bn parambn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 86	wf7/fp:qJ	Ljava/util/List;
    //   13: invokeinterface 370 1 0
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 375 1 0
    //   25: ifeq -19 -> 6
    //   28: aload_2
    //   29: invokeinterface 379 1 0
    //   34: checkcast 381	wf7/fo
    //   37: aload_1
    //   38: invokeinterface 540 2 0
    //   43: goto -24 -> 19
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	fp
    //   0	51	1	parambn	bn
    //   18	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   9	19	46	finally
    //   19	43	46	finally
  }
  
  @WorkerThread
  private void z(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hk.az(398562);
      this.qE.set(0);
      this.qM.set(true);
      this.qO.set(0);
      eb();
      ed();
    }
    while (!ha.isWifiEnabled())
    {
      b(-2, null);
      return;
      hk.az(398561);
      this.qE.set(1);
    }
    List localList = this.qP.c(true);
    if (hj.a(localList)) {
      q(localList);
    }
    y(true);
  }
  
  public void a(@NonNull bn parambn, String paramString)
  {
    if (parambn == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!ha.isWifiEnabled())
        {
          eg();
          continue;
        }
      }
      finally {}
      if (hl.fp())
      {
        hl.a(fq.cr(), parambn.Z(), parambn.ab(), paramString);
        hk.az(500108);
      }
      else
      {
        u(parambn);
        a(parambn, paramString, null);
      }
    }
  }
  
  /* Error */
  public void a(fo paramfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +18 -> 21
    //   6: aload_0
    //   7: getfield 86	wf7/fp:qJ	Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface 567 2 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 86	wf7/fp:qJ	Ljava/util/List;
    //   28: aload_1
    //   29: invokeinterface 570 2 0
    //   34: pop
    //   35: goto -14 -> 21
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	fp
    //   0	43	1	paramfo	fo
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	17	38	finally
    //   24	35	38	finally
  }
  
  /* Error */
  public void a(fr paramfr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +18 -> 21
    //   6: aload_0
    //   7: getfield 84	wf7/fp:qI	Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface 567 2 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 84	wf7/fp:qI	Ljava/util/List;
    //   28: aload_1
    //   29: invokeinterface 570 2 0
    //   34: pop
    //   35: aload_0
    //   36: getfield 152	wf7/fp:qP	Lwf7/bq;
    //   39: iconst_1
    //   40: invokeinterface 221 2 0
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull -26 -> 21
    //   50: aload_3
    //   51: invokeinterface 572 1 0
    //   56: ifne -35 -> 21
    //   59: aload_1
    //   60: iconst_0
    //   61: aload_3
    //   62: invokeinterface 389 3 0
    //   67: goto -46 -> 21
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	fp
    //   0	75	1	paramfr	fr
    //   16	2	2	bool	boolean
    //   45	17	3	localList	List
    // Exception table:
    //   from	to	target	type
    //   6	17	70	finally
    //   24	46	70	finally
    //   50	67	70	finally
  }
  
  public void a(boolean paramBoolean, TMSDKWifiManager.IFreeWifiCheckCallback paramIFreeWifiCheckCallback) {}
  
  public void cancelWifi()
  {
    try
    {
      this.qS.j();
      ha.fk();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void dY()
  {
    this.qY.sendEmptyMessage(6);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 79	wf7/fp:qH	Z
    //   7: invokestatic 590	wf7/ft:eJ	()Lwf7/ft;
    //   10: invokevirtual 593	wf7/ft:eP	()V
    //   13: aload_0
    //   14: getfield 144	wf7/fp:qY	Landroid/os/Handler;
    //   17: aconst_null
    //   18: invokevirtual 208	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 144	wf7/fp:qY	Landroid/os/Handler;
    //   26: aload_0
    //   27: getfield 86	wf7/fp:qJ	Ljava/util/List;
    //   30: invokeinterface 595 1 0
    //   35: aload_0
    //   36: getfield 84	wf7/fp:qI	Ljava/util/List;
    //   39: invokeinterface 595 1 0
    //   44: aload_0
    //   45: iconst_0
    //   46: invokespecial 173	wf7/fp:E	(Z)V
    //   49: aload_0
    //   50: iconst_0
    //   51: invokespecial 176	wf7/fp:F	(Z)V
    //   54: aload_0
    //   55: getfield 170	wf7/fp:qS	Lcom/tencent/qqpimsecure/wificore/api/connect/d;
    //   58: invokeinterface 598 1 0
    //   63: ifeq +27 -> 90
    //   66: aload_0
    //   67: getfield 170	wf7/fp:qS	Lcom/tencent/qqpimsecure/wificore/api/connect/d;
    //   70: new 600	wf7/fp$2
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 601	wf7/fp$2:<init>	(Lwf7/fp;)V
    //   78: invokeinterface 301 2 0
    //   83: aconst_null
    //   84: putstatic 407	wf7/fp:qZ	Lwf7/fp;
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: invokestatic 182	wf7/ao:c	()Lwf7/ao;
    //   93: invokevirtual 603	wf7/ao:e	()V
    //   96: goto -13 -> 83
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	fp
    //   99	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	83	99	finally
    //   83	87	99	finally
    //   90	96	99	finally
  }
  
  public void g(long paramLong)
  {
    this.qF = paramLong;
  }
  
  public void h(long paramLong)
  {
    this.qG = paramLong;
  }
  
  public void setFgUpdateTaskSwitch(boolean paramBoolean)
  {
    this.qM.set(paramBoolean);
  }
  
  public void setUpdateTaskMaxLoopCount(int paramInt)
  {
    if (paramInt > 0)
    {
      this.qN.set(paramInt);
      return;
    }
    this.qN.set(0);
  }
  
  public void startUpdateTask(boolean paramBoolean)
  {
    ee();
    this.qY.obtainMessage(1, Boolean.valueOf(paramBoolean)).sendToTarget();
  }
  
  public void stopUpdateTask(boolean paramBoolean)
  {
    this.qY.obtainMessage(2, Boolean.valueOf(paramBoolean)).sendToTarget();
  }
  
  public void y(boolean paramBoolean)
  {
    this.qY.removeMessages(3);
    if (paramBoolean) {
      this.qY.sendEmptyMessage(3);
    }
    do
    {
      return;
      if (this.qE.get(0))
      {
        this.qY.sendEmptyMessageDelayed(3, this.qF);
        return;
      }
    } while (!this.qE.get(1));
    this.qY.sendEmptyMessageDelayed(3, this.qG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fp
 * JD-Core Version:    0.7.0.1
 */