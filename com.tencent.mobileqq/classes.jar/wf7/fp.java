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
  private static final String TAG = "fp";
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
    this.qE.clear(paramBoolean ^ true);
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
  }
  
  @WorkerThread
  private void B(boolean paramBoolean)
  {
    this.qY.removeMessages(5);
    C(false);
    List localList = this.qP.c(paramBoolean);
    Context localContext = fq.cr();
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean) {
      str = "扫描超时，size：";
    } else {
      str = "扫描结束,size: ";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(hj.b(localList));
    dg.a(localContext, localStringBuilder.toString());
    q(localList);
    if (hj.a(localList))
    {
      dY();
      return;
    }
    b(hm.fw(), null);
  }
  
  private void C(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.qP.a(this.qT);
      break label35;
      this.qP.b(this.qT);
      label35:
      return;
    }
    finally {}
  }
  
  private void D(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.qQ.a(this.qU);
      this.qQ.a(this.qV);
      break label61;
      this.qQ.b(this.qU);
      this.qQ.b(this.qV);
      label61:
      return;
    }
    finally {}
  }
  
  private void E(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.qR.a(this.qW);
      break label35;
      this.qR.b(this.qW);
      label35:
      return;
    }
    finally {}
  }
  
  private void F(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.qS.a(this.qX);
      break label35;
      this.qS.b(this.qX);
      label35:
      return;
    }
    finally {}
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void b(int paramInt, @Nullable List<bn> paramList)
  {
    try
    {
      Iterator localIterator = this.qI.iterator();
      while (localIterator.hasNext()) {
        ((fr)localIterator.next()).onUpdateFinish(paramInt, paramList);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public static fp dX()
  {
    if (qZ == null) {
      try
      {
        if (qZ == null) {
          qZ = new fp();
        }
      }
      finally {}
    }
    return qZ;
  }
  
  @WorkerThread
  private void dZ()
  {
    if ((this.qE.get(0)) && (!this.qM.get())) {
      return;
    }
    int i = this.qN.get();
    if ((this.qE.get(0)) && (i > 0) && (this.qO.get() > i)) {
      return;
    }
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
      return;
    }
    try
    {
      i = paramCurrentSessionItem.eX;
      if (i == 3) {
        break label86;
      }
      if (i == 4) {
        break label81;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Iterator localIterator;
        for (;;)
        {
          throw paramCurrentSessionItem;
        }
        int i = 2;
        continue;
        i = 1;
      }
    }
    localIterator = this.qJ.iterator();
    while (localIterator.hasNext()) {
      ((fo)localIterator.next()).a(i, paramCurrentSessionItem);
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
    //   3: getfield 89	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 409	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: invokespecial 457	wf7/fp:D	(Z)V
    //   22: invokestatic 462	wf7/dk:bJ	()I
    //   25: bipush 23
    //   27: if_icmplt +43 -> 70
    //   30: aload_0
    //   31: new 464	wf7/fp$a
    //   34: dup
    //   35: aload_0
    //   36: aconst_null
    //   37: invokespecial 465	wf7/fp$a:<init>	(Lwf7/fp;Lwf7/fp$1;)V
    //   40: putfield 82	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   43: new 467	android/content/IntentFilter
    //   46: dup
    //   47: invokespecial 468	android/content/IntentFilter:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: ldc_w 470
    //   55: invokevirtual 474	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   58: invokestatic 219	wf7/fq:cr	()Landroid/content/Context;
    //   61: aload_0
    //   62: getfield 82	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   65: aload_2
    //   66: invokevirtual 480	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: getfield 89	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
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
    //   3: getfield 89	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 409	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_0
    //   19: invokespecial 457	wf7/fp:D	(Z)V
    //   22: aload_0
    //   23: getfield 82	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   26: ifnull +13 -> 39
    //   29: invokestatic 219	wf7/fq:cr	()Landroid/content/Context;
    //   32: aload_0
    //   33: getfield 82	wf7/fp:qK	Landroid/content/BroadcastReceiver;
    //   36: invokevirtual 484	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   39: aload_0
    //   40: getfield 89	wf7/fp:qL	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   43: iconst_0
    //   44: invokevirtual 187	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
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
    int i = localCurrentSessionItem.eW;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 4) {
          return;
        }
        ar(-9);
        return;
      }
      f(localCurrentSessionItem);
      return;
    }
    e(localCurrentSessionItem);
  }
  
  private void ee()
  {
    try
    {
      Iterator localIterator = this.qI.iterator();
      while (localIterator.hasNext()) {
        ((fr)localIterator.next()).onUpdateStart();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void eg()
  {
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onWifiDisabled();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void ei()
  {
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).onGPSDisabled();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void f(CurrentSessionItem paramCurrentSessionItem)
  {
    if (paramCurrentSessionItem == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).d(paramCurrentSessionItem);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramCurrentSessionItem;
    }
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
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void u(bn parambn)
  {
    if (parambn == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.qJ.iterator();
      while (localIterator.hasNext()) {
        ((fo)localIterator.next()).t(parambn);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw parambn;
    }
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
    else
    {
      hk.az(398561);
      this.qE.set(1);
    }
    if (!ha.isWifiEnabled())
    {
      b(-2, null);
      return;
    }
    List localList = this.qP.c(true);
    if (hj.a(localList)) {
      q(localList);
    }
    y(true);
  }
  
  public void a(@NonNull bn parambn, String paramString)
  {
    if (parambn == null) {
      return;
    }
    try
    {
      if (!ha.isWifiEnabled())
      {
        eg();
        return;
      }
      if (hl.fp())
      {
        hl.a(fq.cr(), parambn.Z(), parambn.ab(), paramString);
        hk.az(500108);
        return;
      }
      u(parambn);
      a(parambn, paramString, null);
      return;
    }
    finally {}
  }
  
  public void a(fo paramfo)
  {
    if (paramfo != null) {
      try
      {
        if (!this.qJ.contains(paramfo))
        {
          this.qJ.add(paramfo);
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(fr paramfr)
  {
    if (paramfr != null) {
      try
      {
        if (!this.qI.contains(paramfr))
        {
          this.qI.add(paramfr);
          List localList = this.qP.c(true);
          if ((localList != null) && (!localList.isEmpty())) {
            paramfr.onUpdateFinish(0, localList);
          }
          return;
        }
      }
      finally {}
    }
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
  
  public void destroy()
  {
    try
    {
      this.qH = false;
      ft.eJ().eP();
      this.qY.removeCallbacksAndMessages(null);
      this.qY = null;
      this.qJ.clear();
      this.qI.clear();
      E(false);
      F(false);
      if (this.qS.k()) {
        this.qS.a(new fp.2(this));
      } else {
        ao.c().e();
      }
      qZ = null;
      return;
    }
    finally {}
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
    if (paramBoolean)
    {
      this.qY.sendEmptyMessage(3);
      return;
    }
    if (this.qE.get(0))
    {
      this.qY.sendEmptyMessageDelayed(3, this.qF);
      return;
    }
    if (this.qE.get(1)) {
      this.qY.sendEmptyMessageDelayed(3, this.qG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fp
 * JD-Core Version:    0.7.0.1
 */