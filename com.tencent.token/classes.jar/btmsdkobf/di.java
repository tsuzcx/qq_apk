package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class di
  implements cz.a, de.a, do.b, do.c, ds.a
{
  private cy hF;
  private cl he;
  private boolean hi = false;
  protected df.a jv;
  private di.d mA;
  private de mB;
  private do mC;
  private Context mContext = null;
  private int mD = 0;
  private long mE = 15000L;
  private long mF = 0L;
  private boolean mG = false;
  private LinkedList mH = new LinkedList();
  private final Object mI = new Object();
  private byte mJ = 0;
  private HandlerThread mK = null;
  private Handler mL = null;
  private boolean mM = false;
  private dr mN = new dr(new hx(this));
  private dt mx = null;
  private co my;
  private cm mz;
  
  public di(cl paramcl, dp paramdp, df.a parama, di.d paramd, co paramco, cy.d paramd1, cy paramcy)
  {
    this.mx = new dt(this.mContext, this, paramdp);
    y(paramdp.ao());
    this.mK = ee.cT().L("sendHandlerThread");
    this.mK.start();
    this.mL = new ic(this, this.mK.getLooper());
    this.he = paramcl;
    this.jv = parama;
    this.my = paramco;
    this.mA = paramd;
    this.hF = paramcy;
    this.mC = new do(this.mContext, this, this);
    this.mB = new de(paramcl, this);
    b(paramd1);
    cz.bS().a(this);
  }
  
  private int C(String paramString)
  {
    eh.f("TmsTcpManager", "[tcp_control]reconnect(), reason: " + paramString);
    int i = this.mx.cN();
    eh.f("TmsTcpManager", "[tcp_control]reconnect(), ret: " + i);
    return i;
  }
  
  private final void K(int paramInt)
  {
    if (this.mL == null) {
      return;
    }
    this.mL.removeMessages(paramInt);
  }
  
  private dj a(long paramLong, v paramv)
  {
    if (paramv == null)
    {
      eh.g("TmsTcpManager", "[shark_push][shark_conf]handleSharkConfPush(), scSharkConf == null");
      return null;
    }
    eh.e("TmsTcpManager", "[shark_push][shark_conf]------------- handleSharkConfPush() ---------------------");
    eh.f("TmsTcpManager", "[shark_push][shark_conf] hash : " + paramv.ay);
    if (paramv.az != null) {
      eh.f("TmsTcpManager", "[shark_push][shark_conf] info.taskNo: " + paramv.az.aB + " info.seqNo: " + paramv.az.aC);
    }
    eh.f("TmsTcpManager", "[shark_push][shark_conf] hb interval: " + paramv.aM);
    eh.f("TmsTcpManager", "[shark_push][shark_conf] KeepAliveAfterSendInSeconds: " + paramv.aP);
    if (paramv.aO != null)
    {
      eh.f("TmsTcpManager", "[shark_push][shark_conf]scSharkConf.policy.size(): " + paramv.aO.size());
      localObject = paramv.aO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        t localt = (t)((Iterator)localObject).next();
        eh.f("TmsTcpManager", "[shark_push][shark_conf]start: " + localt.aD + " keepAlive: " + localt.aE + " connPan: " + localt.aF);
      }
    }
    eh.f("TmsTcpManager", "[shark_push][shark_conf] scSharkConf.connIfNotWifi: " + paramv.aQ);
    eh.f("TmsTcpManager", "[shark_push][shark_conf] scSharkConf.connIfScreenOff: " + paramv.aR);
    eh.f("TmsTcpManager", "[shark_push][shark_conf] scSharkConf.reconnectInterval: " + paramv.aS);
    eh.f("TmsTcpManager", "[shark_push][shark_conf] scSharkConf.delayOnNetworkChanging: " + paramv.aT);
    eh.e("TmsTcpManager", "[shark_push][shark_conf]-----------------------------------------------------------");
    this.mB.c(paramv);
    Object localObject = new r();
    ((r)localObject).ay = paramv.ay;
    ((r)localObject).az = paramv.az;
    return new dj(Long.valueOf(paramLong), Integer.valueOf(1101), localObject);
  }
  
  private final void a(int paramInt1, Object paramObject, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.mL == null) {
      return;
    }
    if (paramBoolean) {
      this.mL.removeMessages(paramInt1);
    }
    paramObject = Message.obtain(this.mL, paramInt1, paramInt2, 0, paramObject);
    this.mL.sendMessageDelayed(paramObject, paramLong);
  }
  
  private void a(id paramid, int paramInt)
  {
    if (paramid == null) {}
    do
    {
      return;
      eh.f("TmsTcpManager", "[send_control] tcp fail, notify up level: " + paramInt);
    } while (this.my == null);
    this.my.a(paramid.c, paramInt);
  }
  
  private void a(String paramString, bb parambb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServerShark seqNo|" + parambb.dc + "|refSeqNo|" + parambb.dd);
    if ((parambb.du != null) && (parambb.du.size() > 0))
    {
      parambb = parambb.du.iterator();
      while (parambb.hasNext())
      {
        ba localba = (ba)parambb.next();
        if (localba.dd != 0) {
          localStringBuilder.append(" || sashimi cmd|" + localba.bM + "|seqNo|" + localba.dc + "|refSeqNo|" + localba.dd + "|retCode|" + localba.df + "|dataRetCode|" + localba.dg);
        } else {
          localStringBuilder.append(" || push cmd|" + localba.bM + "|seqNo|" + localba.dc + "|refSeqNo|" + localba.dd + "|retCode|" + localba.df + "|dataRetCode|" + localba.dg + "|pushId|" + localba.ds.db);
        }
      }
    }
    eh.i(paramString, localStringBuilder.toString());
  }
  
  private void b(cy.d paramd)
  {
    this.mz = new hy(this);
    eh.f("TmsTcpManager", "[shark_push][shark_conf]registerSharkPush()");
    if (paramd != null) {
      paramd.a(0L, 11101, new v(), 0, this.mz, false);
    }
  }
  
  private int cs()
  {
    eh.f("TmsTcpManager", "[tcp_control]connectIfNeed()");
    int i = 0;
    if (!this.mx.cH()) {
      if (!this.mx.isNetworkConnected()) {
        i = -220000;
      }
    }
    for (;;)
    {
      eh.f("TmsTcpManager", "[tcp_control]connectIfNeed(), ret: " + i);
      return i;
      i = this.mx.cM();
      continue;
      eh.f("TmsTcpManager", "[tcp_control]connectIfNeed(), already connected");
    }
  }
  
  private void ct()
  {
    eh.f("TmsTcpManager", "[tcp_control]tryCloseConnectionSync()");
    if (this.mB.cg() > 0) {
      eg.e("TmsTcpManager", "[tcp_control]tryCloseConnectionSync(), not allow, ref connt: " + this.mB.cg());
    }
    for (;;)
    {
      return;
      this.mB.ch();
      eh.f("TmsTcpManager", "[tcp_control]tryCloseConnectionSync(), update: fp not send");
      this.mJ = 0;
      this.mD = 0;
      cx();
      synchronized (this.mI)
      {
        this.mN.clear();
        long l1 = System.currentTimeMillis();
        int i = this.mx.cL();
        long l2 = System.currentTimeMillis();
        Object localObject2 = this.mx.cq();
        if ((localObject2 == null) || (((dp)localObject2).l(true) == null)) {
          continue;
        }
        ??? = new dg();
        localObject2 = ((dp)localObject2).l(true);
        ((dg)???).mi = ((dq.b)localObject2).getIp();
        ((dg)???).mj = String.valueOf(((dq.b)localObject2).getPort());
        ((dg)???).ml = String.valueOf(cd.e(this.mContext));
        ((dg)???).mo = this.mx.cB();
        ((dg)???).errorCode = i;
        ((dg)???).mn = (l2 - l1);
        ((dg)???).e(this.he);
        return;
      }
    }
  }
  
  private void cv()
  {
    try
    {
      cx();
      cw();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cw()
  {
    try
    {
      eh.f("TmsTcpManager", "[h_b]startHeartBeat");
      if (this.mC != null) {
        this.mC.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cx()
  {
    try
    {
      eh.f("TmsTcpManager", "[h_b]stopHeartBeat");
      if (this.mC != null) {
        this.mC.stop();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void cy()
  {
    try
    {
      eh.f("TmsTcpManager", "[h_b]resetHeartBeat");
      if (this.mC != null) {
        this.mC.reset();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g(int paramInt, String paramString)
  {
    eh.f("TmsTcpManager", "[tcp_control][h_b][shark_conf]sendHeartBeat(), retryTimes: " + paramInt + " reason: " + paramString);
    Object localObject = new ArrayList();
    as localas = new as();
    localas.bM = 999;
    localas.dc = cu.bu().bm();
    ((ArrayList)localObject).add(localas);
    byte b = cu.bw().bx();
    if (paramInt < 1) {}
    for (long l = 30L;; l = 60L)
    {
      localObject = new cy.f(1024, false, true, false, 0L, (ArrayList)localObject, new ia(this, localas.dc, paramInt, paramString, b), 1000L * l);
      ((cy.f)localObject).jX = b;
      cv.by().a(localas.dc, 1000L * l, paramString);
      cv.by().a(b, ((cy.f)localObject).jQ);
      this.mA.a((cy.f)localObject);
      return;
    }
  }
  
  private void g(cy.f paramf)
  {
    if ((paramf == null) || (paramf.jT == null) || (paramf.jT.size() <= 0)) {}
    for (;;)
    {
      return;
      paramf = paramf.jT.iterator();
      while (paramf.hasNext())
      {
        as localas = (as)paramf.next();
        if (localas != null) {
          cv.by().a("TmsTcpManager", localas.bM, localas.dc, localas, 6);
        }
      }
    }
  }
  
  private void h(long paramLong)
  {
    eh.f("TmsTcpManager", "[tcp_control] checkKeepAliveAndResetHeartBeat()");
    cy();
    this.mB.g(paramLong);
  }
  
  private void h(cy.f paramf)
  {
    if ((paramf == null) || (paramf.jT == null) || (paramf.jT.size() <= 0)) {}
    for (;;)
    {
      return;
      paramf = paramf.jT.iterator();
      while (paramf.hasNext())
      {
        as localas = (as)paramf.next();
        if (localas != null) {
          cv.by().a("TmsTcpManager", localas.bM, localas.dc, localas, 8);
        }
      }
    }
  }
  
  private void i(int paramInt, String paramString)
  {
    if ((this.mJ == 1) || (this.mJ == 2))
    {
      paramString = new StringBuilder().append("[tcp_control][f_p]sending or received fp, no more send, is received ? ");
      if (this.mJ == 1) {}
      for (boolean bool = true;; bool = false)
      {
        eh.f("TmsTcpManager", bool);
        return;
      }
    }
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.mF) < this.mE)
    {
      eh.g("TmsTcpManager", "[tcp_control][f_p]first pkg too frequency, send delay");
      a(12, null, 0, 0L, true);
      a(11, "delay_too_freq:" + paramString, paramInt, this.mE, true);
      return;
    }
    int i = this.mB.aq().aT;
    if (cr.bq().e(1000L * i))
    {
      eh.g("TmsTcpManager", "[tcp_control][f_p]net state changing, send fp delay(s): " + i);
      a(11, "delay_waitfor_stable:" + paramString, paramInt, 1000L * i, true);
      return;
    }
    this.mF = l;
    this.mJ = 2;
    K(11);
    eh.g("TmsTcpManager", "[tcp_control][f_p]send first pkg, reason: " + paramString + " retryTimes: " + paramInt);
    as localas = new as();
    localas.bM = 997;
    localas.dc = cu.bu().bm();
    localas.data = cd.a(this.mContext, null, localas.bM, localas);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localas);
    cv.by().a(localas.dc, -1L, paramString);
    paramString = new cy.f(1024, false, false, true, 0L, localArrayList, new hz(this, localas.dc, paramInt, paramString), 0L);
    this.mA.a(paramString);
  }
  
  private void i(cy.f paramf)
  {
    if ((paramf == null) || (paramf.jT == null) || (paramf.jT.size() <= 0)) {}
    for (;;)
    {
      return;
      paramf = paramf.jT.iterator();
      while (paramf.hasNext())
      {
        as localas = (as)paramf.next();
        if (localas != null) {
          cv.by().a("TmsTcpManager", localas.bM, localas.dc, localas, 7);
        }
      }
    }
  }
  
  private void y(boolean paramBoolean)
  {
    this.hi = paramBoolean;
    if (paramBoolean) {
      this.mE = 15000L;
    }
  }
  
  public void L(int paramInt)
  {
    eh.e("TmsTcpManager", "[tcp_control]onTcpEvent(), eventCode: " + paramInt);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    eh.e("TmsTcpManager", "[tcp_control]onTcpError(), errCode: " + paramInt + " msg: " + paramObject);
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.mM = true;
      this.mJ = 0;
    } while (this.mB.cg() <= 0);
    if (this.mD < 3)
    {
      eh.g("TmsTcpManager", "[tcp_control][f_p]tcp_connect_broken, ref count: " + this.mB.cg() + ", delay send fp in " + this.mB.aq().aS + "s");
      this.mD += 1;
      a(11, "delay_fp_for_connect_broken" + paramInt, 0, 1000L * this.mB.aq().aS, true);
      return;
    }
    eh.g("TmsTcpManager", "[tcp_control][f_p]tcp_connect_broken, ref count: " + this.mB.cg() + ", mReconnectTimes over limit: " + this.mD);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      a(paramString, cp.g(paramArrayOfByte));
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      eh.h(paramString, paramArrayOfByte.getMessage());
    }
  }
  
  public void c(int paramInt, byte[] paramArrayOfByte)
  {
    eh.e("TmsTcpManager", "[tcp_control]onReceiveData()");
    this.mD = 0;
    if ((this.hi) && (paramArrayOfByte != null) && (!cx.i(paramArrayOfByte))) {
      a("TmsTcpManager", paramArrayOfByte);
    }
    this.jv.a(true, 0, paramArrayOfByte, null);
  }
  
  void cb()
  {
    try
    {
      eh.f("TmsTcpManager", "get couldNotConnect cmd");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cc()
  {
    this.mB.cc();
  }
  
  public void cd()
  {
    this.mB.cd();
  }
  
  public void cp()
  {
    h(0, "tcp_control");
  }
  
  boolean cu()
  {
    if (this.mJ == 1)
    {
      eh.f("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), fp succ, prefer tcp");
      return true;
    }
    if (this.mJ == 2)
    {
      l = Math.abs(System.currentTimeMillis() - this.mF);
      if ((this.mF > 0L) && (l < 10000L))
      {
        eh.f("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), fp sending within 10s, prefer tcp: " + l);
        return true;
      }
      eh.g("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), fp sending over 10s, prefer http: " + l);
      return false;
    }
    if (this.mF <= 0L)
    {
      eh.f("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), fp first time, prefer tcp");
      return true;
    }
    long l = Math.abs(System.currentTimeMillis() - this.mF);
    if (l > 1800000L)
    {
      eh.f("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), over 30 mins since last fp, try again, prefer tcp: " + l);
      return true;
    }
    if (this.mG)
    {
      eh.g("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), fp failed within 30 mins, network not reconnected, prefer http: " + l);
      return false;
    }
    eh.f("TmsTcpManager", "[tcp_control]guessTcpWillSucc(), no fp fail record or network reconnected within 30 mins, prefer tcp: " + l);
    return true;
  }
  
  void e(cy.f arg1)
  {
    eh.f("TmsTcpManager", "[tcp_control] sendCheckFirst()");
    if (!this.mx.isNetworkConnected())
    {
      eh.g("TmsTcpManager", "[tcp_control] sendCheckFirst(), no connect");
      this.jv.b(true, -40220000, ???);
    }
    do
    {
      return;
      id localid = new id(this, 32, null, ???);
      if (this.mJ == 1)
      {
        f(???);
        return;
      }
      if (this.mJ == 2)
      {
        if (???.jL)
        {
          eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]sendCheckFirst(),sending fp ignore heartbeat");
          return;
        }
        eh.f("TmsTcpManager", "[tcp_control] sending fp, enqueue this task");
        i(???);
        synchronized (this.mI)
        {
          this.mH.add(localid);
          return;
        }
      }
    } while (this.mJ != 0);
    if (???.jL)
    {
      eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]sendCheckFirst(),fp is not sent ignore heartbeat");
      return;
    }
    eh.f("TmsTcpManager", "[tcp_control] fp is not sent, send fp & enqueue this task");
    h(???);
    synchronized (this.mI)
    {
      this.mH.add(localObject1);
      a(11, "delay_send_for_others", 0, 0L, true);
      return;
    }
  }
  
  void f(cy.f arg1)
  {
    eh.f("TmsTcpManager", "[tcp_control] send(), isFP: " + ???.jM + ", isHB: " + ???.jL);
    if (!this.mx.isNetworkConnected())
    {
      eh.g("TmsTcpManager", "[tcp_control] send(), no connect");
      this.jv.b(true, -40220000, ???);
      return;
    }
    K(4);
    g(???);
    if (!???.jL) {
      h(???.jS);
    }
    id localid = new id(this, 32, null, ???);
    synchronized (this.mI)
    {
      this.mN.add(localid);
      a(0, null, 0, 0L, true);
      return;
    }
  }
  
  void h(int paramInt, String paramString)
  {
    a(11, "" + paramString, paramInt, 0L, true);
  }
  
  public void onClose()
  {
    a(4, null, 0, 0L, true);
  }
  
  public void onConnected()
  {
    this.mG = false;
    int i = this.mB.cg();
    if (i <= 0)
    {
      eh.f("TmsTcpManager", "[tcp_control]onConnected(), no tcp ref, ignore, refCount: " + i);
      return;
    }
    eh.f("TmsTcpManager", "[tcp_control]onConnected(), with tcp ref, send MSG_ON_CHANGE_TO_CONNECTED, refCount: " + i);
    a(9, null, 0, 0L, true);
  }
  
  public void onDisconnected()
  {
    int i = this.mB.cg();
    eh.f("TmsTcpManager", "[tcp_control]onDisconnected(), update: disconnected & fp not send, refCount: " + i);
    this.mM = true;
    this.mJ = 0;
    K(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.di
 * JD-Core Version:    0.7.0.1
 */