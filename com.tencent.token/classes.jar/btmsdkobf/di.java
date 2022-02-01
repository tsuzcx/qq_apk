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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]reconnect(), reason: ");
    localStringBuilder.append(paramString);
    eh.f("TmsTcpManager", localStringBuilder.toString());
    int i = this.mx.cN();
    paramString = new StringBuilder();
    paramString.append("[tcp_control]reconnect(), ret: ");
    paramString.append(i);
    eh.f("TmsTcpManager", paramString.toString());
    return i;
  }
  
  private final void K(int paramInt)
  {
    Handler localHandler = this.mL;
    if (localHandler == null) {
      return;
    }
    localHandler.removeMessages(paramInt);
  }
  
  private dj<Long, Integer, JceStruct> a(long paramLong, v paramv)
  {
    if (paramv == null)
    {
      eh.g("TmsTcpManager", "[shark_push][shark_conf]handleSharkConfPush(), scSharkConf == null");
      return null;
    }
    eh.e("TmsTcpManager", "[shark_push][shark_conf]------------- handleSharkConfPush() ---------------------");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] hash : ");
    ((StringBuilder)localObject).append(paramv.ay);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    if (paramv.az != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[shark_push][shark_conf] info.taskNo: ");
      ((StringBuilder)localObject).append(paramv.az.aB);
      ((StringBuilder)localObject).append(" info.seqNo: ");
      ((StringBuilder)localObject).append(paramv.az.aC);
      eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] hb interval: ");
    ((StringBuilder)localObject).append(paramv.aM);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] KeepAliveAfterSendInSeconds: ");
    ((StringBuilder)localObject).append(paramv.aP);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    if (paramv.aO != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[shark_push][shark_conf]scSharkConf.policy.size(): ");
      ((StringBuilder)localObject).append(paramv.aO.size());
      eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
      localObject = paramv.aO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        t localt = (t)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[shark_push][shark_conf]start: ");
        localStringBuilder.append(localt.aD);
        localStringBuilder.append(" keepAlive: ");
        localStringBuilder.append(localt.aE);
        localStringBuilder.append(" connPan: ");
        localStringBuilder.append(localt.aF);
        eh.f("TmsTcpManager", localStringBuilder.toString());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] scSharkConf.connIfNotWifi: ");
    ((StringBuilder)localObject).append(paramv.aQ);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] scSharkConf.connIfScreenOff: ");
    ((StringBuilder)localObject).append(paramv.aR);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] scSharkConf.reconnectInterval: ");
    ((StringBuilder)localObject).append(paramv.aS);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push][shark_conf] scSharkConf.delayOnNetworkChanging: ");
    ((StringBuilder)localObject).append(paramv.aT);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    eh.e("TmsTcpManager", "[shark_push][shark_conf]-----------------------------------------------------------");
    this.mB.c(paramv);
    localObject = new r();
    ((r)localObject).ay = paramv.ay;
    ((r)localObject).az = paramv.az;
    return new dj(Long.valueOf(paramLong), Integer.valueOf(1101), localObject);
  }
  
  private final void a(int paramInt1, Object paramObject, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Handler localHandler = this.mL;
    if (localHandler == null) {
      return;
    }
    if (paramBoolean) {
      localHandler.removeMessages(paramInt1);
    }
    paramObject = Message.obtain(this.mL, paramInt1, paramInt2, 0, paramObject);
    this.mL.sendMessageDelayed(paramObject, paramLong);
  }
  
  private void a(f paramf, int paramInt)
  {
    if (paramf == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[send_control] tcp fail, notify up level: ");
    ((StringBuilder)localObject).append(paramInt);
    eh.f("TmsTcpManager", ((StringBuilder)localObject).toString());
    localObject = this.my;
    if (localObject != null) {
      ((co)localObject).a(paramf.c, paramInt);
    }
  }
  
  private void a(String paramString, bb parambb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ServerShark seqNo|");
    ((StringBuilder)localObject).append(parambb.dc);
    ((StringBuilder)localObject).append("|refSeqNo|");
    ((StringBuilder)localObject).append(parambb.dd);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    if ((parambb.du != null) && (parambb.du.size() > 0))
    {
      localObject = parambb.du.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ba localba = (ba)((Iterator)localObject).next();
        if (localba.dd != 0)
        {
          parambb = new StringBuilder();
          parambb.append(" || sashimi cmd|");
          parambb.append(localba.bM);
          parambb.append("|seqNo|");
          parambb.append(localba.dc);
          parambb.append("|refSeqNo|");
          parambb.append(localba.dd);
          parambb.append("|retCode|");
          parambb.append(localba.df);
          parambb.append("|dataRetCode|");
          parambb.append(localba.dg);
        }
        else
        {
          parambb = new StringBuilder();
          parambb.append(" || push cmd|");
          parambb.append(localba.bM);
          parambb.append("|seqNo|");
          parambb.append(localba.dc);
          parambb.append("|refSeqNo|");
          parambb.append(localba.dd);
          parambb.append("|retCode|");
          parambb.append(localba.df);
          parambb.append("|dataRetCode|");
          parambb.append(localba.dg);
          parambb.append("|pushId|");
          parambb.append(localba.ds.db);
        }
        localStringBuilder.append(parambb.toString());
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
        if (paramAnonymousInt2 != 11101) {
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
    int i;
    if (!this.mx.cH())
    {
      if (!this.mx.isNetworkConnected()) {
        i = -220000;
      } else {
        i = this.mx.cM();
      }
    }
    else
    {
      eh.f("TmsTcpManager", "[tcp_control]connectIfNeed(), already connected");
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]connectIfNeed(), ret: ");
    localStringBuilder.append(i);
    eh.f("TmsTcpManager", localStringBuilder.toString());
    return i;
  }
  
  private void ct()
  {
    eh.f("TmsTcpManager", "[tcp_control]tryCloseConnectionSync()");
    if (this.mB.cg() > 0)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[tcp_control]tryCloseConnectionSync(), not allow, ref connt: ");
      ((StringBuilder)???).append(this.mB.cg());
      eg.e("TmsTcpManager", ((StringBuilder)???).toString());
      return;
    }
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
      if ((localObject2 != null) && (((dp)localObject2).l(true) != null))
      {
        ??? = new dg();
        localObject2 = ((dp)localObject2).l(true);
        ((dg)???).mi = ((dq.b)localObject2).getIp();
        ((dg)???).mj = String.valueOf(((dq.b)localObject2).getPort());
        ((dg)???).ml = String.valueOf(cd.e(this.mContext));
        ((dg)???).mo = this.mx.cB();
        ((dg)???).errorCode = i;
        ((dg)???).mn = (l2 - l1);
        ((dg)???).e(this.he);
      }
      return;
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[tcp_control][h_b][shark_conf]sendHeartBeat(), retryTimes: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" reason: ");
    ((StringBuilder)localObject1).append(paramString);
    eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
    Object localObject2 = new ArrayList();
    localObject1 = new as();
    ((as)localObject1).bM = 999;
    ((as)localObject1).dc = cu.bu().bm();
    ((ArrayList)localObject2).add(localObject1);
    byte b = cu.bw().bx();
    if (paramInt < 1) {
      l = 30L;
    } else {
      l = 60L;
    }
    b localb = new b(((as)localObject1).dc, paramInt, paramString, b);
    long l = 1000L * l;
    localObject2 = new cy.f(1024, false, true, false, 0L, (ArrayList)localObject2, localb, l);
    ((cy.f)localObject2).jX = b;
    cv.by().a(((as)localObject1).dc, l, paramString);
    cv.by().a(b, ((cy.f)localObject2).jQ);
    this.mA.a((cy.f)localObject2);
  }
  
  private void g(cy.f paramf)
  {
    if ((paramf != null) && (paramf.jT != null))
    {
      if (paramf.jT.size() <= 0) {
        return;
      }
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
    if ((paramf != null) && (paramf.jT != null))
    {
      if (paramf.jT.size() <= 0) {
        return;
      }
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
    int i = this.mJ;
    boolean bool = true;
    if ((i != 1) && (i != 2))
    {
      long l1 = System.currentTimeMillis();
      if (Math.abs(l1 - this.mF) < this.mE)
      {
        eh.g("TmsTcpManager", "[tcp_control][f_p]first pkg too frequency, send delay");
        a(12, null, 0, 0L, true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delay_too_freq:");
        ((StringBuilder)localObject).append(paramString);
        a(11, ((StringBuilder)localObject).toString(), paramInt, this.mE, true);
        return;
      }
      i = this.mB.aq().aT;
      Object localObject = cr.bq();
      long l2 = 1000L * i;
      if (((cr)localObject).e(l2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control][f_p]net state changing, send fp delay(s): ");
        ((StringBuilder)localObject).append(i);
        eh.g("TmsTcpManager", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delay_waitfor_stable:");
        ((StringBuilder)localObject).append(paramString);
        a(11, ((StringBuilder)localObject).toString(), paramInt, l2, true);
        return;
      }
      this.mF = l1;
      this.mJ = 2;
      K(11);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[tcp_control][f_p]send first pkg, reason: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" retryTimes: ");
      ((StringBuilder)localObject).append(paramInt);
      eh.g("TmsTcpManager", ((StringBuilder)localObject).toString());
      localObject = new as();
      ((as)localObject).bM = 997;
      ((as)localObject).dc = cu.bu().bm();
      ((as)localObject).data = cd.a(this.mContext, null, ((as)localObject).bM, (as)localObject);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      cv.by().a(((as)localObject).dc, -1L, paramString);
      paramString = new cy.f(1024, false, false, true, 0L, localArrayList, new a(((as)localObject).dc, paramInt, paramString), 0L);
      this.mA.a(paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("[tcp_control][f_p]sending or received fp, no more send, is received ? ");
    if (this.mJ != 1) {
      bool = false;
    }
    paramString.append(bool);
    eh.f("TmsTcpManager", paramString.toString());
  }
  
  private void i(cy.f paramf)
  {
    if ((paramf != null) && (paramf.jT != null))
    {
      if (paramf.jT.size() <= 0) {
        return;
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]onTcpEvent(), eventCode: ");
    localStringBuilder.append(paramInt);
    eh.e("TmsTcpManager", localStringBuilder.toString());
  }
  
  public void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]onTcpError(), errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramObject);
    eh.e("TmsTcpManager", localStringBuilder.toString());
    switch (paramInt)
    {
    default: 
      return;
    }
    this.mM = true;
    this.mJ = 0;
    if (this.mB.cg() > 0)
    {
      if (this.mD < 3)
      {
        paramObject = new StringBuilder();
        paramObject.append("[tcp_control][f_p]tcp_connect_broken, ref count: ");
        paramObject.append(this.mB.cg());
        paramObject.append(", delay send fp in ");
        paramObject.append(this.mB.aq().aS);
        paramObject.append("s");
        eh.g("TmsTcpManager", paramObject.toString());
        this.mD += 1;
        paramObject = new StringBuilder();
        paramObject.append("delay_fp_for_connect_broken");
        paramObject.append(paramInt);
        a(11, paramObject.toString(), 0, this.mB.aq().aS * 1000L, true);
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("[tcp_control][f_p]tcp_connect_broken, ref count: ");
      paramObject.append(this.mB.cg());
      paramObject.append(", mReconnectTimes over limit: ");
      paramObject.append(this.mD);
      eh.g("TmsTcpManager", paramObject.toString());
    }
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
    int i = this.mJ;
    Object localObject;
    if (i == 1) {
      localObject = "[tcp_control]guessTcpWillSucc(), fp succ, prefer tcp";
    }
    for (;;)
    {
      eh.f("TmsTcpManager", (String)localObject);
      return true;
      if (i == 2)
      {
        l = Math.abs(System.currentTimeMillis() - this.mF);
        if ((this.mF > 0L) && (l < 10000L))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[tcp_control]guessTcpWillSucc(), fp sending within 10s, prefer tcp: ");
          ((StringBuilder)localObject).append(l);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[tcp_control]guessTcpWillSucc(), fp sending over 10s, prefer http: ");
          ((StringBuilder)localObject).append(l);
          label118:
          eh.g("TmsTcpManager", ((StringBuilder)localObject).toString());
          return false;
        }
      }
      else
      {
        if (this.mF > 0L) {
          break;
        }
        localObject = "[tcp_control]guessTcpWillSucc(), fp first time, prefer tcp";
      }
    }
    long l = Math.abs(System.currentTimeMillis() - this.mF);
    if (l > 1800000L) {
      localObject = new StringBuilder();
    }
    for (String str = "[tcp_control]guessTcpWillSucc(), over 30 mins since last fp, try again, prefer tcp: ";; str = "[tcp_control]guessTcpWillSucc(), no fp fail record or network reconnected within 30 mins, prefer tcp: ")
    {
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(l);
      break;
      if (this.mG)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control]guessTcpWillSucc(), fp failed within 30 mins, network not reconnected, prefer http: ");
        ((StringBuilder)localObject).append(l);
        break label118;
      }
      localObject = new StringBuilder();
    }
  }
  
  void e(cy.f arg1)
  {
    eh.f("TmsTcpManager", "[tcp_control] sendCheckFirst()");
    if (!this.mx.isNetworkConnected())
    {
      eh.g("TmsTcpManager", "[tcp_control] sendCheckFirst(), no connect");
      this.jv.b(true, -40220000, ???);
      return;
    }
    f localf = new f(32, null, ???);
    int i = this.mJ;
    if (i == 1)
    {
      f(???);
      return;
    }
    if (i == 2)
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
    if (i == 0)
    {
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
  }
  
  void f(cy.f arg1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[tcp_control] send(), isFP: ");
    ((StringBuilder)localObject1).append(???.jM);
    ((StringBuilder)localObject1).append(", isHB: ");
    ((StringBuilder)localObject1).append(???.jL);
    eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
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
    localObject1 = new f(32, null, ???);
    synchronized (this.mI)
    {
      this.mN.add(localObject1);
      a(0, null, 0, 0L, true);
      return;
    }
  }
  
  void h(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    a(11, localStringBuilder.toString(), paramInt, 0L, true);
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tcp_control]onConnected(), no tcp ref, ignore, refCount: ");
      localStringBuilder.append(i);
      eh.f("TmsTcpManager", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]onConnected(), with tcp ref, send MSG_ON_CHANGE_TO_CONNECTED, refCount: ");
    localStringBuilder.append(i);
    eh.f("TmsTcpManager", localStringBuilder.toString());
    a(9, null, 0, 0L, true);
  }
  
  public void onDisconnected()
  {
    int i = this.mB.cg();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[tcp_control]onDisconnected(), update: disconnected & fp not send, refCount: ");
    localStringBuilder.append(i);
    eh.f("TmsTcpManager", localStringBuilder.toString());
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
      paramInt1 = bz.p(paramInt1);
      boolean bool;
      if ((this.e < 1) && (bz.q(paramInt1)) && (di.a(di.this) < 3) && (di.b(di.this).cg() > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[tcp_control][f_p]fp fail, retCode: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" dataRetCode: ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" mRetryTimes: ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" need retry? ");
      ((StringBuilder)localObject1).append(bool);
      eh.g("TmsTcpManager", ((StringBuilder)localObject1).toString());
      di.a(di.this, true);
      di.a(di.this, (byte)0);
      di.b(di.this, true);
      cv.by().a("TmsTcpManager", 997, this.c, (ba)null, 30, paramInt1);
      cv.by().a(this.c, bool ^ true);
      di.a(di.this, 3, null, paramInt1, 0L, true);
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[tcp_control][f_p]fp fail, ref count: ");
        ((StringBuilder)localObject1).append(di.b(di.this).cg());
        ((StringBuilder)localObject1).append(", retry send fp in ");
        ((StringBuilder)localObject1).append(di.b(di.this).aq().aS);
        ((StringBuilder)localObject1).append("s");
        eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
        di.c(di.this);
        localObject1 = di.this;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("delay_fp_retry:");
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(paramInt1);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramInt1 = this.e + 1;
        this.e = paramInt1;
        di.a((di)localObject1, 11, localObject2, paramInt1, di.b(di.this).aq().aS * 1000L, true);
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[tcp_control][f_p]fp fail, should not retry, retCode: ");
      ((StringBuilder)localObject1).append(paramInt1);
      eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
    }
    
    protected void a(ba paramba)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tcp_control][f_p]fp success, mRetryTimes: ");
      localStringBuilder.append(this.e);
      eh.f("TmsTcpManager", localStringBuilder.toString());
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[tcp_control][h_b]hb fail, retCode: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" dataRetCode: ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" helloSeq: ");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(" mRetryTimes: ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" reason: ");
      ((StringBuilder)localObject1).append(this.f);
      eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
      paramInt2 = this.e;
      int i = 0;
      if (paramInt2 >= 1)
      {
        eh.i("TmsTcpManager", "[tcp_control][h_b]hb fail again, mark disconnect not handled for reconnect");
        di.a(di.this, true);
        di.a(di.this, (byte)0);
      }
      paramInt2 = i;
      if (this.e < 1)
      {
        paramInt2 = i;
        if (bz.q(paramInt1))
        {
          paramInt2 = i;
          if (di.a(di.this) < 3)
          {
            paramInt2 = i;
            if (di.b(di.this).cg() > 0) {
              paramInt2 = 1;
            }
          }
        }
      }
      cv.by().a("TmsTcpManager", 999, this.c, (ba)null, 30, paramInt1);
      cv.by().a(this.c, paramInt2 ^ 0x1);
      cv.by().a(this.g);
      if (paramInt2 != 0)
      {
        eh.f("TmsTcpManager", "[tcp_control][h_b]hb fail, retry");
        localObject1 = di.this;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("hb_retry:");
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(paramInt1);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramInt1 = this.e + 1;
        this.e = paramInt1;
        di.a((di)localObject1, 13, localObject2, paramInt1, 2000L, true);
      }
    }
    
    protected void a(ba paramba)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tcp_control][h_b]hb success, helloSeq: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" mRetryTimes: ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" reason: ");
      localStringBuilder.append(this.f);
      eh.f("TmsTcpManager", localStringBuilder.toString());
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
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
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
        return;
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
      int i = ???.what;
      Object localObject10 = null;
      Object localObject1 = null;
      Object localObject11;
      if (i != 0)
      {
        if (i != 9) {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 13: 
              if (di.f(di.this) == 1)
              {
                i = ???.arg1;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(???.obj);
                ??? = ((StringBuilder)localObject1).toString();
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[tcp_control] handle msg: MSG_SEND_HB, retryTimes: ");
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append(" reason: ");
                ((StringBuilder)localObject1).append(???);
                eh.f("TmsTcpManager", ((StringBuilder)localObject1).toString());
                di.b(di.this, i, ???);
                return;
              }
              break;
            }
            break;
          }
        }
        for (??? = "[tcp_control][f_p][h_b]handle msg: MSG_SEND_HB, fp not sent, donnot send hb!";; ??? = ???.toString())
        {
          eh.g("TmsTcpManager", ???);
          return;
          synchronized (di.d(di.this))
          {
            if ((di.h(di.this) != null) && (di.h(di.this).size() > 0))
            {
              localObject1 = (LinkedList)di.h(di.this).clone();
              di.h(di.this).clear();
              ??? = new StringBuilder();
              ???.append("[tcp_control][f_p]fp too frequency, waiting tasks count: ");
              ???.append(((LinkedList)localObject1).size());
              eh.g("TmsTcpManager", ???.toString());
              ??? = ((LinkedList)localObject1).iterator();
              while (???.hasNext())
              {
                localObject1 = (di.f)???.next();
                if ((localObject1 != null) && (((di.f)localObject1).c != null) && (((di.f)localObject1).c.jT != null) && (((di.f)localObject1).c.jT.size() > 0))
                {
                  localObject10 = ((di.f)localObject1).c.jT.iterator();
                  while (((Iterator)localObject10).hasNext())
                  {
                    localObject11 = (as)((Iterator)localObject10).next();
                    if (localObject11 != null) {
                      cv.by().a("TmsTcpManager", ((as)localObject11).bM, ((as)localObject11).dc, (as)localObject11, 10, -40001300, null);
                    }
                  }
                  di.a(di.this, (di.f)localObject1, -40001300);
                }
              }
            }
            return;
          }
          i = ???.arg1;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("");
          ((StringBuilder)???).append(???.obj);
          ??? = ((StringBuilder)???).toString();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[tcp_control] handle msg: MSG_DELAY_SEND_FIRST_PKG, retryTimes: ");
          ((StringBuilder)???).append(i);
          ((StringBuilder)???).append(" reason: ");
          ((StringBuilder)???).append(???);
          eh.f("TmsTcpManager", ((StringBuilder)???).toString());
          di.a(di.this, i, ???);
          return;
          di.o(di.this);
          return;
          di.a(di.this, 3);
          synchronized (di.d(di.this))
          {
            if ((di.h(di.this) != null) && (di.h(di.this).size() > 0))
            {
              localObject10 = (LinkedList)di.h(di.this).clone();
              di.h(di.this).clear();
              ??? = new StringBuilder();
              ((StringBuilder)???).append("fp failed, waiting tasks count: ");
              ((StringBuilder)???).append(((LinkedList)localObject10).size());
              eh.f("TmsTcpManager", ((StringBuilder)???).toString());
              i = ???.arg1;
              ??? = ((LinkedList)localObject10).iterator();
              while (???.hasNext())
              {
                ??? = (di.f)???.next();
                if ((??? != null) && (((di.f)???).c != null) && (((di.f)???).c.jT != null) && (((di.f)???).c.jT.size() > 0))
                {
                  localObject10 = ((di.f)???).c.jT.iterator();
                  while (((Iterator)localObject10).hasNext())
                  {
                    localObject11 = (as)((Iterator)localObject10).next();
                    if (localObject11 != null) {
                      cv.by().a("TmsTcpManager", ((as)localObject11).bM, ((as)localObject11).dc, (as)localObject11, 9, i - 700000000, null);
                    }
                  }
                  di.a(di.this, (di.f)???, -700000000 + i);
                }
              }
            }
            return;
          }
          localObject10 = di.d(di.this);
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
            if ((??? != null) && (???.size() > 0))
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("[tcp_control]fp success. send waiting for fp tasks: ");
              ((StringBuilder)???).append(???.size());
              eh.f("TmsTcpManager", ((StringBuilder)???).toString());
              synchronized (di.d(di.this))
              {
                ??? = ???.iterator();
                while (???.hasNext())
                {
                  localObject10 = (di.f)???.next();
                  if (localObject10 != null) {
                    di.e(di.this).add(localObject10);
                  }
                }
                di.a(di.this, 0, null, 0, 0L, true);
              }
            }
            eh.f("TmsTcpManager", "[tcp_control]fp success, no task waiting for fp");
            eh.f("TmsTcpManager", "[tcp_control][h_b]restartHeartBeat after fp success");
            di.n(di.this);
            return;
          }
          finally {}
          eh.e("TmsTcpManager", "[tcp_control][f_p] handle: MSG_ON_CHANGE_TO_CONNECTED");
          if (di.b(di.this).cg() <= 0)
          {
            eh.e("TmsTcpManager", "[tcp_control][f_p] handle connected msg: ref connt <= 0, no need to reconnect");
            return;
          }
          if (di.a(di.this) < 3)
          {
            ??? = new StringBuilder();
            ???.append("[tcp_control][f_p] handle connected msg, ref count: ");
            ???.append(di.b(di.this).cg());
            ???.append(", wait for network become stable and send fp in: ");
            ???.append(di.b(di.this).aq().aT);
            ???.append("s");
            eh.e("TmsTcpManager", ???.toString());
            di.c(di.this);
            ??? = di.this;
            di.a(???, 11, "delay_fp_network_connected", 0, 1000L * di.b(???).aq().aT, true);
            return;
          }
          ??? = new StringBuilder();
          ???.append("[tcp_control][f_p] handle connected msg, ref count: ");
          ???.append(di.b(di.this).cg());
          ???.append(", mReconnectTimes over limit: ");
          ???.append(di.a(di.this));
        }
      }
      eh.f("TmsTcpManager", "[tcp_control]handle MSG_SEND_TASK");
      synchronized (di.d(di.this))
      {
        localObject11 = (di.f)di.e(di.this).poll();
        if ((localObject11 != null) && (((di.f)localObject11).c != null))
        {
          long l1 = 0L;
          if (((di.f)localObject11).c.bP())
          {
            eh.g("TmsTcpManager", "[tcp_control][time_out]MSG_SEND_TASK, send time out");
            i = -17;
            ??? = (Message)localObject10;
          }
          else
          {
            if ((!((di.f)localObject11).c.bR()) && (!((di.f)localObject11).c.jM)) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              if (di.f(di.this) == 1)
              {
                if (!di.g(di.this).cH())
                {
                  if (((di.f)localObject11).c.jL)
                  {
                    eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] connection is broken, , ignore heartbeat");
                    return;
                  }
                  eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] connection is broken, wait and resend fp");
                  di.a(di.this, ((di.f)localObject11).c);
                  synchronized (di.d(di.this))
                  {
                    di.h(di.this).add(localObject11);
                    di.a(di.this, 11, "conn_broken_didnt_monitored", 0, 0L, true);
                    return;
                  }
                }
                ??? = "[tcp_control][f_p]handleMessage(), [others] connection is ok";
              }
              else
              {
                if (di.f(di.this) == 2)
                {
                  if (((di.f)localObject11).c.jL)
                  {
                    eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] sending fp, ignore heartbeat");
                    return;
                  }
                  eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] sending fp, enqueue this task and wait");
                  di.b(di.this, ((di.f)localObject11).c);
                  synchronized (di.d(di.this))
                  {
                    di.h(di.this).add(localObject11);
                    return;
                  }
                }
                if (di.f(di.this) != 0) {
                  break label1832;
                }
                if (((di.f)localObject11).c.jL)
                {
                  eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] fp not sent, ignore heartbeat");
                  return;
                }
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] fp not sent, send fp & enqueue this task");
                di.a(di.this, ((di.f)localObject11).c);
                synchronized (di.d(di.this))
                {
                  di.h(di.this).add(localObject11);
                  di.a(di.this, 11, "others_depend_on_fp", 0, 0L, true);
                  return;
                }
              }
            }
            else
            {
              if (di.i(di.this))
              {
                di.a(di.this, false);
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 1: reconnect");
                j = di.a(di.this, "disconnected_before_send");
                i = j;
                if (((di.f)localObject11).c.jM) {
                  break label1834;
                }
                di.a(di.this, (byte)0);
                ??? = "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 2: not fp, mark fp_not_send";
              }
              for (i = j;; i = j)
              {
                eh.g("TmsTcpManager", ???);
                break label1834;
                if (di.g(di.this).cH()) {
                  break;
                }
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] not connected, 1: connect");
                j = di.j(di.this);
                i = j;
                if (((di.f)localObject11).c.jM) {
                  break label1834;
                }
                di.a(di.this, (byte)0);
                ??? = "[tcp_control][f_p]handleMessage(), [vip] not connected, 2: not fp, mark fp_not_send";
              }
              ??? = "[tcp_control][f_p]handleMessage(), [vip] connection is ok";
            }
            eh.f("TmsTcpManager", ???);
            label1832:
            i = 0;
            label1834:
            if (i != 0)
            {
              ??? = new StringBuilder();
              ???.append("[tcp_control][f_p]handleMessage(), connect failed: ");
              ???.append(i);
              eh.g("TmsTcpManager", ???.toString());
              ??? = (Message)localObject10;
            }
            else
            {
              Object localObject12;
              if ((((di.f)localObject11).c.jT != null) && (((di.f)localObject11).c.jT.size() > 0))
              {
                localObject12 = ((di.f)localObject11).c.jT.iterator();
                ??? = null;
                for (;;)
                {
                  ??? = ???;
                  if (!((Iterator)localObject12).hasNext()) {
                    break;
                  }
                  as localas = (as)((Iterator)localObject12).next();
                  if (localas != null)
                  {
                    cv.by().a("TmsTcpManager", localas.bM, localas.dc, localas, 11);
                    if (localas.dd == 0)
                    {
                      ??? = ???;
                      if (??? == null) {
                        ??? = new dg();
                      }
                      ((dg)???).I(localas.bM);
                      ??? = (Message)???;
                    }
                  }
                }
              }
              ??? = null;
              ??? = cd.a(((di.f)localObject11).c, true, di.k(di.this).getGuid(), di.l(di.this));
              if (??? == null)
              {
                eh.g("TmsTcpManager", "[tcp_control][http_control][shark_v4]handleMessage(), ConverterUtil.createSendBytes() return null!");
                i = -1500;
              }
              for (;;)
              {
                ??? = (Message)???;
                break;
                long l2 = System.currentTimeMillis();
                localObject12 = ((di.f)localObject11).b;
                if (localObject12 == null)
                {
                  j = di.g(di.this).a(((di.f)localObject11).c, ???);
                }
                else
                {
                  ((cw)localObject12).setState(1);
                  if (((cw)localObject12).bA())
                  {
                    i = -11;
                    ??? = (Message)localObject10;
                    break;
                  }
                  j = di.g(di.this).a(((di.f)localObject11).c, ???);
                  ((cw)localObject12).setState(2);
                }
                l2 = System.currentTimeMillis() - l2;
                i = j;
                l1 = l2;
                if (j == 0)
                {
                  i = j;
                  l1 = l2;
                  if (((di.f)localObject11).c != null)
                  {
                    ((di.f)localObject11).c.jW = true;
                    i = j;
                    l1 = l2;
                  }
                }
              }
            }
          }
          int j = i;
          if (i != 0)
          {
            j = i;
            if (i != -11)
            {
              j = i - 40000000;
              ??? = new StringBuilder();
              ((StringBuilder)???).append("[tcp_control]handleMessage(), tcp send failed: ");
              ((StringBuilder)???).append(j);
              eh.g("TmsTcpManager", ((StringBuilder)???).toString());
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
          if ((j != 0) && (j != -11))
          {
            df.a(((di.f)localObject11).c, 14, j, 0);
            di.a(di.this, (di.f)localObject11, j);
            ??? = new LinkedList();
            synchronized (di.d(di.this))
            {
              for (;;)
              {
                localObject10 = (di.f)di.e(di.this).poll();
                if (localObject10 == null) {
                  break;
                }
                ???.add(localObject10);
              }
              if (???.size() <= 0) {
                return;
              }
              ??? = new StringBuilder();
              ((StringBuilder)???).append("[tcp_control]handleMessage(), tcp send fail: ");
              ((StringBuilder)???).append(j);
              ((StringBuilder)???).append(", notify tcp failed for other tasks: ");
              ((StringBuilder)???).append(???.size());
              eh.g("TmsTcpManager", ((StringBuilder)???).toString());
              ??? = ???.iterator();
              if (!???.hasNext()) {
                return;
              }
              ??? = (di.f)???.next();
              localObject10 = ((di.f)???).b;
              if (localObject10 != null) {
                ((cw)localObject10).setState(2);
              }
              di.a(di.this, (di.f)???, j);
            }
          }
          df.a(((di.f)localObject11).c, 14, j, 0);
          synchronized (di.d(di.this))
          {
            if (!di.e(di.this).isEmpty()) {
              di.a(di.this, 0, null, 0, 0L, true);
            }
            return;
          }
        }
        eh.g("TmsTcpManager", "[tcp_control]no task for send");
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