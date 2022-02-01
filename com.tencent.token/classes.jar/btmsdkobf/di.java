package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class di
  implements cz.a, de.a, do.b, do.c, ds.a
{
  private cy hF;
  private cl he;
  private boolean hi = false;
  protected df.a jv;
  private d mA;
  private de mB;
  private do mC;
  private Context mContext = null;
  private int mD = 0;
  private long mE = 15000L;
  private long mF = 0L;
  private boolean mG = false;
  private LinkedList<f> mH = new LinkedList();
  private final Object mI = new Object();
  private byte mJ = 0;
  private HandlerThread mK = null;
  private Handler mL = null;
  private boolean mM = false;
  private dr<f> mN = new dr(new Comparator()
  {
    public int a(di.f paramAnonymousf1, di.f paramAnonymousf2)
    {
      return bv.l(paramAnonymousf2.a) - bv.l(paramAnonymousf1.a);
    }
  });
  private dt mx = null;
  private co my;
  private cm mz;
  
  public di(cl paramcl, dp paramdp, df.a parama, d paramd, co paramco, cy.d paramd1, cy paramcy)
  {
    this.mx = new dt(this.mContext, this, paramdp);
    y(paramdp.ao());
    this.mK = ee.cT().L("sendHandlerThread");
    this.mK.start();
    this.mL = new e(this.mK.getLooper());
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
  
  private dj<Long, Integer, JceStruct> a(long paramLong, v paramv)
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
  
  private void a(f paramf, int paramInt)
  {
    if (paramf == null) {}
    do
    {
      return;
      eh.f("TmsTcpManager", "[send_control] tcp fail, notify up level: " + paramInt);
    } while (this.my == null);
    this.my.a(paramf.c, paramInt);
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
    this.mz = new cm()
    {
      public dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousJceStruct == null)
        {
          eh.g("TmsTcpManager", "[shark_push][shark_conf]onRecvPush() null == push");
          return null;
        }
        switch (paramAnonymousInt2)
        {
        default: 
          return null;
        }
        paramAnonymousJceStruct = (v)paramAnonymousJceStruct;
        return di.a(di.this, paramAnonymousLong, paramAnonymousJceStruct);
      }
    };
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
      localObject = new cy.f(1024, false, true, false, 0L, (ArrayList)localObject, new b(localas.dc, paramInt, paramString, b), 1000L * l);
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
    paramString = new cy.f(1024, false, false, true, 0L, localArrayList, new a(localas.dc, paramInt, paramString), 0L);
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
      f localf = new f(32, null, ???);
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
          this.mH.add(localf);
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
    f localf = new f(32, null, ???);
    synchronized (this.mI)
    {
      this.mN.add(localf);
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
  
  private class a
    extends di.c
  {
    private int e = 0;
    private String f = "";
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(10997, paramInt1);
      this.e = paramInt2;
      this.f = paramString;
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      paramInt1 = bz.p(paramInt1);
      if ((this.e < 1) && (bz.q(paramInt1)) && (di.a(di.this) < 3) && (di.b(di.this).cg() > 0)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        eh.g("TmsTcpManager", "[tcp_control][f_p]fp fail, retCode: " + paramInt1 + " dataRetCode: " + paramInt2 + " mRetryTimes: " + this.e + " need retry? " + bool1);
        di.a(di.this, true);
        di.a(di.this, (byte)0);
        di.b(di.this, true);
        cv.by().a("TmsTcpManager", 997, this.c, (ba)null, 30, paramInt1);
        Object localObject = cv.by();
        paramInt2 = this.c;
        if (!bool1) {
          bool2 = true;
        }
        ((cv)localObject).a(paramInt2, bool2);
        di.a(di.this, 3, null, paramInt1, 0L, true);
        if (!bool1) {
          break;
        }
        eh.f("TmsTcpManager", "[tcp_control][f_p]fp fail, ref count: " + di.b(di.this).cg() + ", retry send fp in " + di.b(di.this).aq().aS + "s");
        di.c(di.this);
        localObject = di.this;
        String str = "delay_fp_retry:" + this.f + ":" + paramInt1;
        paramInt1 = this.e + 1;
        this.e = paramInt1;
        di.a((di)localObject, 11, str, paramInt1, 1000L * di.b(di.this).aq().aS, true);
        return;
      }
      eh.f("TmsTcpManager", "[tcp_control][f_p]fp fail, should not retry, retCode: " + paramInt1);
    }
    
    protected void a(ba paramba)
    {
      eh.f("TmsTcpManager", "[tcp_control][f_p]fp success, mRetryTimes: " + this.e);
      di.a(di.this, false);
      di.a(di.this, (byte)1);
      di.b(di.this, false);
      cv.by().a("TmsTcpManager", 997, this.c, paramba, 30, 0);
      cv.by().x(this.c);
      di.a(di.this, 2, null, 0, 0L, true);
    }
  }
  
  private class b
    extends di.c
  {
    private int e = 0;
    private String f = "";
    private byte g = 0;
    
    public b(int paramInt1, int paramInt2, String paramString, byte paramByte)
    {
      super(10999, paramInt1);
      this.e = paramInt2;
      this.f = paramString;
      this.g = paramByte;
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      boolean bool = false;
      eh.f("TmsTcpManager", "[tcp_control][h_b]hb fail, retCode: " + paramInt1 + " dataRetCode: " + paramInt2 + " helloSeq: " + this.g + " mRetryTimes: " + this.e + " reason: " + this.f);
      if (this.e >= 1)
      {
        eh.i("TmsTcpManager", "[tcp_control][h_b]hb fail again, mark disconnect not handled for reconnect");
        di.a(di.this, true);
        di.a(di.this, (byte)0);
      }
      if ((this.e < 1) && (bz.q(paramInt1)) && (di.a(di.this) < 3) && (di.b(di.this).cg() > 0)) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        cv.by().a("TmsTcpManager", 999, this.c, (ba)null, 30, paramInt1);
        Object localObject = cv.by();
        int i = this.c;
        if (paramInt2 == 0) {
          bool = true;
        }
        ((cv)localObject).a(i, bool);
        cv.by().a(this.g);
        if (paramInt2 != 0)
        {
          eh.f("TmsTcpManager", "[tcp_control][h_b]hb fail, retry");
          localObject = di.this;
          String str = "hb_retry:" + this.f + ":" + paramInt1;
          paramInt1 = this.e + 1;
          this.e = paramInt1;
          di.a((di)localObject, 13, str, paramInt1, 2000L, true);
        }
        return;
      }
    }
    
    protected void a(ba paramba)
    {
      eh.f("TmsTcpManager", "[tcp_control][h_b]hb success, helloSeq: " + this.g + " mRetryTimes: " + this.e + " reason: " + this.f);
      cv.by().a("TmsTcpManager", 999, this.c, paramba, 30, 0);
      cv.by().x(this.c);
      cv.by().a(this.g);
    }
  }
  
  private abstract class c
    implements cy.b
  {
    int b = 0;
    int c = 0;
    
    public c(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    protected abstract void a(int paramInt1, int paramInt2);
    
    protected abstract void a(ba paramba);
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
    {
      if (paramInt1 != 0)
      {
        a(paramInt1, -1);
        return;
      }
      if ((this.b == 10999) && (paramInt1 == 0))
      {
        a(null);
        return;
      }
      if ((paramArrayList == null) || (paramArrayList.size() == 0))
      {
        a(-41250000, -1);
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ba localba = (ba)paramArrayList.next();
        if ((localba != null) && (localba.bM == this.b))
        {
          if ((localba.df == 0) && (localba.dg == 0))
          {
            a(localba);
            return;
          }
          a(localba.df, localba.dg);
          return;
        }
      }
      a(-41250000, -1);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(cy.f paramf);
  }
  
  private class e
    extends Handler
  {
    public e(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message arg1)
    {
      Object localObject12;
      int j;
      Object localObject11;
      int i;
      long l1;
      label178:
      label856:
      Object localObject7;
      switch (???.what)
      {
      case 1: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      default: 
        return;
      case 0: 
        eh.f("TmsTcpManager", "[tcp_control]handle MSG_SEND_TASK");
        synchronized (di.d(di.this))
        {
          localObject12 = (di.f)di.e(di.this).poll();
          if ((localObject12 == null) || (((di.f)localObject12).c == null))
          {
            eh.g("TmsTcpManager", "[tcp_control]no task for send");
            return;
          }
        }
        j = 0;
        ??? = null;
        localObject11 = null;
        Object localObject2 = null;
        if (((di.f)localObject12).c.bP())
        {
          eh.g("TmsTcpManager", "[tcp_control][time_out]MSG_SEND_TASK, send time out");
          i = -17;
          l1 = 0L;
          ??? = localObject2;
          j = i;
          if (i != 0)
          {
            j = i;
            if (i != -11)
            {
              j = i - 40000000;
              eh.g("TmsTcpManager", "[tcp_control]handleMessage(), tcp send failed: " + j);
            }
          }
          if (??? != null)
          {
            ???.ml = String.valueOf(cd.e(di.m(di.this)));
            ???.mn = l1;
            ???.mo = di.g(di.this).cB();
            ???.errorCode = j;
            ???.g(di.l(di.this));
          }
          if ((j == 0) || (j == -11))
          {
            df.a(((di.f)localObject12).c, 14, j, 0);
            synchronized (di.d(di.this))
            {
              if (!di.e(di.this).isEmpty()) {
                di.a(di.this, 0, null, 0, 0L, true);
              }
              return;
            }
          }
        }
        else
        {
          if ((!((di.f)localObject12).c.bR()) && (!((di.f)localObject12).c.jM)) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              if (di.f(di.this) == 1)
              {
                if (!di.g(di.this).cH())
                {
                  if (((di.f)localObject12).c.jL)
                  {
                    eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] connection is broken, , ignore heartbeat");
                    return;
                    i = 0;
                    continue;
                  }
                  eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] connection is broken, wait and resend fp");
                  di.a(di.this, ((di.f)localObject12).c);
                  synchronized (di.d(di.this))
                  {
                    di.h(di.this).add(localObject12);
                    di.a(di.this, 11, "conn_broken_didnt_monitored", 0, 0L, true);
                    return;
                  }
                }
                eh.f("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] connection is ok");
                i = j;
              }
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label856;
            }
            eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), connect failed: " + i);
            l1 = 0L;
            ??? = localObject4;
            break;
            if (di.f(di.this) == 2)
            {
              if (((di.f)localObject12).c.jL)
              {
                eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] sending fp, ignore heartbeat");
                return;
              }
              eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] sending fp, enqueue this task and wait");
              di.b(di.this, ((di.f)localObject12).c);
              synchronized (di.d(di.this))
              {
                di.h(di.this).add(localObject12);
                return;
              }
            }
            i = j;
            if (di.f(di.this) == 0)
            {
              if (((di.f)localObject12).c.jL)
              {
                eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] fp not sent, ignore heartbeat");
                return;
              }
              eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] fp not sent, send fp & enqueue this task");
              di.a(di.this, ((di.f)localObject12).c);
              synchronized (di.d(di.this))
              {
                di.h(di.this).add(localObject12);
                di.a(di.this, 11, "others_depend_on_fp", 0, 0L, true);
                return;
              }
              if (di.i(di.this))
              {
                di.a(di.this, false);
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 1: reconnect");
                j = di.a(di.this, "disconnected_before_send");
                i = j;
                if (!((di.f)localObject12).c.jM)
                {
                  di.a(di.this, (byte)0);
                  eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 2: not fp, mark fp_not_send");
                  i = j;
                }
              }
              else if (!di.g(di.this).cH())
              {
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] not connected, 1: connect");
                j = di.j(di.this);
                i = j;
                if (!((di.f)localObject12).c.jM)
                {
                  di.a(di.this, (byte)0);
                  eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] not connected, 2: not fp, mark fp_not_send");
                  i = j;
                }
              }
              else
              {
                eh.f("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] connection is ok");
                i = j;
              }
            }
          }
          localObject7 = localObject11;
          if (((di.f)localObject12).c.jT != null)
          {
            localObject7 = localObject11;
            if (((di.f)localObject12).c.jT.size() > 0)
            {
              localObject11 = ((di.f)localObject12).c.jT.iterator();
              label902:
              do
              {
                do
                {
                  localObject7 = ???;
                  if (!((Iterator)localObject11).hasNext()) {
                    break;
                  }
                  localObject7 = (as)((Iterator)localObject11).next();
                } while (localObject7 == null);
                cv.by().a("TmsTcpManager", ((as)localObject7).bM, ((as)localObject7).dc, (as)localObject7, 11);
              } while (((as)localObject7).dd != 0);
              if (??? != null) {
                break label2473;
              }
              ??? = new dg();
            }
          }
        }
        break;
      }
      label2454:
      label2473:
      for (;;)
      {
        ???.I(((as)localObject7).bM);
        break label902;
        ??? = cd.a(((di.f)localObject12).c, true, di.k(di.this).getGuid(), di.l(di.this));
        if (??? == null)
        {
          eh.g("TmsTcpManager", "[tcp_control][http_control][shark_v4]handleMessage(), ConverterUtil.createSendBytes() return null!");
          i = -1500;
          l1 = 0L;
          ??? = (Message)localObject7;
          break label178;
        }
        l1 = System.currentTimeMillis();
        localObject11 = ((di.f)localObject12).b;
        if (localObject11 == null) {
          j = di.g(di.this).a(((di.f)localObject12).c, ???);
        }
        for (;;)
        {
          long l2 = System.currentTimeMillis() - l1;
          i = j;
          l1 = l2;
          ??? = (Message)localObject7;
          if (j != 0) {
            break;
          }
          i = j;
          l1 = l2;
          ??? = (Message)localObject7;
          if (((di.f)localObject12).c == null) {
            break;
          }
          ((di.f)localObject12).c.jW = true;
          i = j;
          l1 = l2;
          ??? = (Message)localObject7;
          break;
          ((cw)localObject11).setState(1);
          if (((cw)localObject11).bA())
          {
            i = -11;
            ??? = null;
            l1 = 0L;
            break;
          }
          j = di.g(di.this).a(((di.f)localObject12).c, ???);
          ((cw)localObject11).setState(2);
        }
        df.a(((di.f)localObject12).c, 14, j, 0);
        di.a(di.this, (di.f)localObject12, j);
        localObject7 = new LinkedList();
        synchronized (di.d(di.this))
        {
          localObject11 = (di.f)di.e(di.this).poll();
          if (localObject11 != null) {
            ((LinkedList)localObject7).add(localObject11);
          }
        }
        if (localObject8.size() <= 0) {
          break;
        }
        eh.g("TmsTcpManager", "[tcp_control]handleMessage(), tcp send fail: " + j + ", notify tcp failed for other tasks: " + localObject8.size());
        ??? = localObject8.iterator();
        while (???.hasNext())
        {
          di.f localf = (di.f)???.next();
          localObject11 = localf.b;
          if (localObject11 != null) {
            ((cw)localObject11).setState(2);
          }
          di.a(di.this, localf, j);
        }
        eh.e("TmsTcpManager", "[tcp_control][f_p] handle: MSG_ON_CHANGE_TO_CONNECTED");
        if (di.b(di.this).cg() <= 0)
        {
          eh.e("TmsTcpManager", "[tcp_control][f_p] handle connected msg: ref connt <= 0, no need to reconnect");
          return;
        }
        if (di.a(di.this) < 3)
        {
          eh.e("TmsTcpManager", "[tcp_control][f_p] handle connected msg, ref count: " + di.b(di.this).cg() + ", wait for network become stable and send fp in: " + di.b(di.this).aq().aT + "s");
          di.c(di.this);
          di.a(di.this, 11, "delay_fp_network_connected", 0, 1000L * di.b(di.this).aq().aT, true);
          return;
        }
        eh.g("TmsTcpManager", "[tcp_control][f_p] handle connected msg, ref count: " + di.b(di.this).cg() + ", mReconnectTimes over limit: " + di.a(di.this));
        return;
        i = ???.arg1;
        ??? = "" + ???.obj;
        eh.f("TmsTcpManager", "[tcp_control] handle msg: MSG_DELAY_SEND_FIRST_PKG, retryTimes: " + i + " reason: " + ???);
        di.a(di.this, i, ???);
        return;
        if (di.f(di.this) == 1)
        {
          i = ???.arg1;
          ??? = "" + ???.obj;
          eh.f("TmsTcpManager", "[tcp_control] handle msg: MSG_SEND_HB, retryTimes: " + i + " reason: " + ???);
          di.b(di.this, i, ???);
          return;
        }
        eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handle msg: MSG_SEND_HB, fp not sent, donnot send hb!");
        return;
        synchronized (di.d(di.this))
        {
          if ((di.h(di.this) == null) || (di.h(di.this).size() <= 0)) {
            return;
          }
        }
        ??? = (LinkedList)di.h(di.this).clone();
        di.h(di.this).clear();
        eh.g("TmsTcpManager", "[tcp_control][f_p]fp too frequency, waiting tasks count: " + ((LinkedList)???).size());
        ??? = ((LinkedList)???).iterator();
        while (???.hasNext())
        {
          ??? = (di.f)???.next();
          if ((??? != null) && (((di.f)???).c != null) && (((di.f)???).c.jT != null) && (((di.f)???).c.jT.size() > 0))
          {
            localObject11 = ((di.f)???).c.jT.iterator();
            while (((Iterator)localObject11).hasNext())
            {
              localObject12 = (as)((Iterator)localObject11).next();
              if (localObject12 != null) {
                cv.by().a("TmsTcpManager", ((as)localObject12).bM, ((as)localObject12).dc, (as)localObject12, 10, -40001300, null);
              }
            }
            di.a(di.this, (di.f)???, -40001300);
          }
        }
        di.a(di.this, 3);
        synchronized (di.d(di.this))
        {
          if ((di.h(di.this) == null) || (di.h(di.this).size() <= 0)) {
            return;
          }
        }
        localObject11 = (LinkedList)di.h(di.this).clone();
        di.h(di.this).clear();
        eh.f("TmsTcpManager", "fp failed, waiting tasks count: " + ((LinkedList)localObject11).size());
        i = ???.arg1;
        ??? = ((LinkedList)localObject11).iterator();
        while (???.hasNext())
        {
          ??? = (di.f)???.next();
          if ((??? != null) && (((di.f)???).c != null) && (((di.f)???).c.jT != null) && (((di.f)???).c.jT.size() > 0))
          {
            localObject11 = ((di.f)???).c.jT.iterator();
            while (((Iterator)localObject11).hasNext())
            {
              localObject12 = (as)((Iterator)localObject11).next();
              if (localObject12 != null) {
                cv.by().a("TmsTcpManager", ((as)localObject12).bM, ((as)localObject12).dc, (as)localObject12, 9, -700000000 + i, null);
              }
            }
            di.a(di.this, (di.f)???, -700000000 + i);
          }
        }
        ??? = null;
        localObject11 = di.d(di.this);
        ??? = (Message)???;
        try
        {
          if (di.h(di.this) != null)
          {
            ??? = (Message)???;
            if (di.h(di.this).size() > 0)
            {
              ??? = (LinkedList)di.h(di.this).clone();
              di.h(di.this).clear();
            }
          }
          if ((??? == null) || (???.size() <= 0)) {
            break label2454;
          }
          eh.f("TmsTcpManager", "[tcp_control]fp success. send waiting for fp tasks: " + ???.size());
          synchronized (di.d(di.this))
          {
            ??? = ???.iterator();
            while (???.hasNext())
            {
              localObject11 = (di.f)???.next();
              if (localObject11 != null) {
                di.e(di.this).add(localObject11);
              }
            }
          }
        }
        finally {}
        di.a(di.this, 0, null, 0, 0L, true);
        for (;;)
        {
          eh.f("TmsTcpManager", "[tcp_control][h_b]restartHeartBeat after fp success");
          di.n(di.this);
          return;
          eh.f("TmsTcpManager", "[tcp_control]fp success, no task waiting for fp");
        }
        di.o(di.this);
        return;
      }
    }
  }
  
  private class f
  {
    public int a = 0;
    public cw b = null;
    public cy.f c = null;
    
    public f(int paramInt, cw paramcw, cy.f paramf)
    {
      this.a = paramInt;
      this.b = paramcw;
      this.c = paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.di
 * JD-Core Version:    0.7.0.1
 */