package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cy
  implements di.d
{
  private cl hS;
  private final Object hT = new Object();
  private Handler jA = new Handler(cx.getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      cy.a(cy.this, (cy.f)paramAnonymousMessage.obj);
    }
  };
  private df jd;
  private cs je;
  private cf jf;
  private dk jg;
  private e jh;
  private SparseArray<ce> ji = null;
  private f jj = null;
  private f jk = null;
  private ArrayList<f> jl = new ArrayList();
  private LinkedHashMap<Integer, f> jm = new LinkedHashMap();
  private ExecutorService jn;
  private boolean jo;
  private long jp = 0L;
  private boolean jq = false;
  private boolean jr = false;
  private long js = 0L;
  private long jt = 0L;
  private c ju;
  private df.a jv = new df.a()
  {
    public void a(boolean paramAnonymousBoolean, int paramAnonymousInt, byte[] arg3, cy.f paramAnonymousf)
    {
      eh.f("SharkNetwork", "onFinish(), retCode: " + paramAnonymousInt);
      if (paramAnonymousInt != 0) {
        cy.a(cy.this, paramAnonymousBoolean, paramAnonymousInt, paramAnonymousf);
      }
      for (;;)
      {
        return;
        if (??? == null)
        {
          eh.h("SharkNetwork", "onFinish() null == retData");
          cy.a(cy.this, paramAnonymousBoolean, -21000005, paramAnonymousf);
          return;
        }
        eh.e("SharkNetwork", "onFinish() retData.length: " + ???.length);
        if (cx.i(???))
        {
          byte b = ???[0];
          paramAnonymousInt = cv.by().b(b);
          if (paramAnonymousInt < 0) {
            continue;
          }
          synchronized (cy.a(cy.this))
          {
            paramAnonymousf = (cy.f)cy.a(cy.this).get(Integer.valueOf(paramAnonymousInt));
            if (paramAnonymousf != null)
            {
              cy.a(cy.this, paramAnonymousBoolean, paramAnonymousf, 0, 0, null);
              return;
            }
          }
        }
      }
      try
      {
        ??? = cp.g(???);
        if (??? == null)
        {
          eh.h("SharkNetwork", "onFinish() null == obj");
          cy.a(cy.this, paramAnonymousBoolean, -21000400, paramAnonymousf);
          return;
        }
      }
      catch (Exception ???)
      {
        eh.h("SharkNetwork", "onFinish() e: " + ???.toString());
        cy.a(cy.this, paramAnonymousBoolean, -21000400, paramAnonymousf);
        return;
      }
      bb localbb = (bb)???;
      ArrayList localArrayList = localbb.du;
      int j = localbb.dd;
      if ((cy.b(cy.this) != null) && (cy.b(cy.this).jQ == j)) {
        paramAnonymousf = cy.b(cy.this);
      }
      int i;
      while (localArrayList != null)
      {
        ??? = localArrayList.iterator();
        i = 0;
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            localObject2 = (ba)((Iterator)???).next();
            eh.f("SharkNetwork_CMDID", "[" + i + "]收包：cmd id:[" + ((ba)localObject2).bM + "]seqNo:[" + ((ba)localObject2).dc + "]refSeqNo:[" + ((ba)localObject2).dd + "]retCode:[" + ((ba)localObject2).df + "]dataRetCode:[" + ((ba)localObject2).dg + "]");
            i += 1;
            continue;
            if ((cy.c(cy.this) != null) && (cy.c(cy.this).jQ == j))
            {
              paramAnonymousf = cy.c(cy.this);
              break;
            }
            synchronized (cy.a(cy.this))
            {
              paramAnonymousf = (cy.f)cy.a(cy.this).get(Integer.valueOf(j));
            }
          }
        }
      }
      if (localArrayList == null)
      {
        eh.h("SharkNetwork", "onFinish() null == respSashimiList");
        cy.a(cy.this, paramAnonymousBoolean, paramAnonymousf, -21000005, localbb.dc, null);
        return;
      }
      cy.e(localArrayList);
      eh.e("SharkNetwork", "onFinish() sharkSeq: " + j + " ssTag: " + paramAnonymousf + " shark回包或push个数: " + localArrayList.size());
      boolean bool = cy.a(cy.this, localArrayList);
      Object localObject2 = new StringBuilder().append("[rsa_key]onFinish() 密钥是否过期：");
      if (bool) {}
      for (??? = "是";; ??? = "否")
      {
        eh.f("SharkNetwork", (String)???);
        if (!bool) {
          break;
        }
        cy.a(cy.this, true);
        cy.d(cy.this).removeMessages(1);
        cy.d(cy.this).sendEmptyMessageDelayed(1, 100L);
        return;
      }
      localObject2 = cy.a(cy.this, paramAnonymousf, paramAnonymousBoolean, localbb, localArrayList);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        while (localIterator.hasNext())
        {
          ba localba = (ba)localIterator.next();
          if (localba != null)
          {
            cv localcv = cv.by();
            i = localba.bM;
            j = localba.dd;
            if (??? != null) {}
            for (??? = String.format("%d/%d", new Object[] { Integer.valueOf(???.length + 4), Integer.valueOf(localArrayList.size()) });; ??? = null)
            {
              localcv.a("SharkNetwork", i, j, localba, 17, paramAnonymousInt, (String)???);
              ??? = dg.J(localba.dd);
              if (??? == null) {
                break;
              }
              ((dg)???).ml = String.valueOf(cd.e(cy.e(cy.this)));
              ((dg)???).errorCode = localba.df;
              ((dg)???).I(localba.bM);
              ((dg)???).f(cy.f(cy.this));
              break;
            }
          }
        }
      }
      cy.a(cy.this, paramAnonymousBoolean, paramAnonymousf, 0, localbb.dc, (ArrayList)localObject2);
      cy.g(cy.this);
    }
    
    public void b(boolean paramAnonymousBoolean, int paramAnonymousInt, cy.f paramAnonymousf)
    {
      if (paramAnonymousf != null) {
        eh.h("SharkNetwork", "onSendFailed(), isTcpChannel: " + paramAnonymousBoolean + " retCode: " + paramAnonymousInt + " seqNo: " + paramAnonymousf.jQ);
      }
      for (;;)
      {
        if (paramAnonymousInt != 0) {
          cy.a(cy.this, paramAnonymousBoolean, paramAnonymousInt, paramAnonymousf);
        }
        return;
        eh.h("SharkNetwork", "onSendFailed(), isTcpChannel: " + paramAnonymousBoolean + " retCode: " + paramAnonymousInt);
      }
    }
  };
  private boolean jw = true;
  private boolean jx = true;
  private Handler jy = new Handler(cx.getLooper())
  {
    private void a(final boolean paramAnonymousBoolean, final cy.f paramAnonymousf)
    {
      cy.j(cy.this).submit(new Runnable()
      {
        public void run()
        {
          if (cy.i(cy.this) != null)
          {
            if (!paramAnonymousf.jM) {}
            for (;;)
            {
              Object localObject3;
              synchronized (cy.i(cy.this))
              {
                localObject3 = (ce)cy.i(cy.this).get(997);
                if ((localObject3 != null) && (!((ce)localObject3).aW()))
                {
                  eh.g("SharkNetwork", "[network_control] cloud cmd: fp donot connect, use http channel");
                  paramAnonymousf.jO = true;
                }
                ??? = paramAnonymousf.jT;
                if ((??? == null) || (((ArrayList)???).size() <= 0)) {
                  break;
                }
                eh.f("SharkNetwork", "[network_control] before control, sashimis.size(): " + ((ArrayList)???).size());
                ??? = ((ArrayList)???).iterator();
                if (!((Iterator)???).hasNext()) {
                  break;
                }
                localObject3 = (as)((Iterator)???).next();
                if (localObject3 == null) {
                  continue;
                }
              }
              synchronized (cy.i(cy.this))
              {
                ce localce = (ce)cy.i(cy.this).get(((as)localObject3).bM);
                if (localce == null) {
                  continue;
                }
                if (localce.aW())
                {
                  localce.aX();
                  continue;
                  localObject4 = finally;
                  throw localObject4;
                }
              }
              localObject2.remove();
              eh.f("SharkNetwork", "network ctrl donot connect, cmdid : " + localObject4.bM);
              eh.g("SharkNetwork", "[network_control] cloud cmd: donot connect, cmdid : " + localObject4.bM);
              ??? = new ba();
              ((ba)???).bM = localObject4.bM;
              ((ba)???).df = -7;
              cy.a(cy.this, true, false, paramAnonymousf, -20000007, 0, (ba)???);
            }
          }
          ArrayList localArrayList = paramAnonymousf.jT;
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            eh.f("SharkNetwork", "[network_control] after control, sashimis.size(): " + localArrayList.size());
            try
            {
              cy.this.a(paramAnonymousBoolean, paramAnonymousf);
              return;
            }
            catch (Throwable localThrowable)
            {
              eh.h("SharkNetwork", localThrowable.toString());
              return;
            }
          }
          eh.g("SharkNetwork", "[network_control] no sashimi can connect, control by cloud cmd!");
        }
      });
    }
    
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return;
      case 0: 
        cy.d(cy.this).removeMessages(0);
        if ((cy.b(cy.this) != null) && (???.arg1 == 1))
        {
          eh.f("SharkNetwork", "MSG_SHARK_SEND_VIP mSharkSendRsa");
          a(false, cy.b(cy.this));
          return;
        }
        if ((cy.c(cy.this) != null) && (???.arg1 == 2))
        {
          eh.f("SharkNetwork", "MSG_SHARK_SEND_VIP mSharkSendGuid");
          a(true, cy.c(cy.this));
          return;
        }
        eh.h("SharkNetwork", "MSG_SHARK_SEND_VIP null");
        return;
      case 1: 
        eh.f("SharkNetwork", "MSG_SHARK_SEND");
        cy.d(cy.this).removeMessages(1);
        ??? = cy.k(cy.this).ai();
        if ((TextUtils.isEmpty(???.ir)) || (TextUtils.isEmpty(???.is)))
        {
          eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, without rsakey, handleOnNeedRsaKey()");
          cy.b(cy.this, false);
          return;
        }
        if (cy.l(cy.this))
        {
          eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired, handleOnNeedRsaKey()");
          cy.b(cy.this, true);
          return;
        }
        if (cy.m(cy.this).aZ())
        {
          eh.g("SharkNetwork", "[cu_guid] MSG_SHARK_SEND, without guid, handleOnNeedGuid()");
          cy.n(cy.this);
          return;
        }
        synchronized (cy.o(cy.this))
        {
          if (cy.o(cy.this).size() <= 0) {
            return;
          }
        }
        Object localObject2 = (ArrayList)cy.o(cy.this).clone();
        cy.o(cy.this).clear();
        ??? = ((ArrayList)localObject2).iterator();
        while (???.hasNext())
        {
          localObject2 = (cy.f)???.next();
          if (localObject2 != null)
          {
            if (cy.l(cy.this))
            {
              eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired suddenly, handleOnNeedRsaKey()");
              cy.b(cy.this, true);
              return;
            }
            if (((cy.f)localObject2).jL) {
              a(false, (cy.f)localObject2);
            } else {
              a(true, (cy.f)localObject2);
            }
          }
        }
      case 2: 
        cy.d(cy.this).removeMessages(2);
        eh.f("SharkNetwork", "[rsa_key]msg: MSG_SHARK_UPDATE_RSAKEY");
        cy.j(cy.this).submit(new Runnable()
        {
          public void run()
          {
            cy.d(cy.this).removeMessages(2);
            if ((cy.p(cy.this) > 0L) && (Math.abs(System.currentTimeMillis() - cy.p(cy.this)) <= 60000L))
            {
              eh.f("SharkNetwork", "[rsa_key]update rsa succ in 60s, no need to update now");
              synchronized (cy.q(cy.this))
              {
                cy.c(cy.this, false);
                cy.a(cy.this, false);
                cy.d(cy.this).sendEmptyMessage(1);
                eh.f("SharkNetwork", "[rsa_key]update rsa succ in 60s, no need to update now, broadcast after 5s");
                cy.d(cy.this).removeMessages(5);
                cy.d(cy.this).sendEmptyMessageDelayed(5, 5000L);
                return;
              }
            }
            try
            {
              cy.k(cy.this).a(new cs.a()
              {
                public void a(int paramAnonymous3Int1, int paramAnonymous3Int2, int paramAnonymous3Int3)
                {
                  paramAnonymous3Int3 = bz.p(paramAnonymous3Int3);
                  eh.e("SharkNetwork", "[rsa_key]onUpdateFinish(), ret: " + paramAnonymous3Int3);
                  for (;;)
                  {
                    synchronized (cy.q(cy.this))
                    {
                      cy.c(cy.this, false);
                      cv.by().a("SharkNetwork", paramAnonymous3Int2, paramAnonymous3Int1, (ba)null, 30, paramAnonymous3Int3);
                      cv.by().x(paramAnonymous3Int1);
                      if (paramAnonymous3Int3 == 0)
                      {
                        cs.a(cy.e(cy.this), paramAnonymous3Int3, cy.this.ai());
                        cy.b(cy.this, paramAnonymous3Int3);
                        return;
                      }
                    }
                    cs.a(cy.e(cy.this), paramAnonymous3Int3, null);
                  }
                }
              });
              return;
            }
            catch (Exception localException)
            {
              eh.h("SharkNetwork", "[rsa_key] MSG_SHARK_UPDATE_RSAKEY e: " + localException.toString());
              synchronized (cy.q(cy.this))
              {
                cy.c(cy.this, false);
                cy.b(cy.this, -20000014);
                return;
              }
            }
          }
        });
        return;
      case 3: 
        eh.f("SharkNetwork", "[cu_guid]MSG_SHARK_GET_GUID");
        cy.d(cy.this).removeMessages(3);
        cy.j(cy.this).submit(new Runnable()
        {
          public void run()
          {
            cy.d(cy.this).removeMessages(3);
            try
            {
              cy.m(cy.this).a(new cf.a()
              {
                public void a(int paramAnonymous3Int1, int paramAnonymous3Int2, int paramAnonymous3Int3, String paramAnonymous3String)
                {
                  paramAnonymous3Int3 = bz.p(paramAnonymous3Int3);
                  eh.e("SharkNetwork", "[cu_guid]onGuidFinish(), send broadcast, ret: " + paramAnonymous3Int3);
                  synchronized (cy.q(cy.this))
                  {
                    cy.d(cy.this, false);
                    cv.by().a("SharkNetwork", paramAnonymous3Int2, paramAnonymous3Int1, (ba)null, 30, paramAnonymous3Int3);
                    cv.by().x(paramAnonymous3Int1);
                    cf.b(cy.e(cy.this), paramAnonymous3Int3, paramAnonymous3String);
                    cy.a(cy.this, paramAnonymous3Int3);
                    return;
                  }
                }
              });
              return;
            }
            catch (Exception localException)
            {
              eh.h("SharkNetwork", "[cu_guid]register guid exception: " + localException.toString());
              synchronized (cy.q(cy.this))
              {
                cy.d(cy.this, false);
                cy.a(cy.this, -20000014);
                return;
              }
            }
          }
        });
        return;
      case 6: 
        eh.f("SharkNetwork", "[cu_guid]handle: MSG_REQUEST_SENDPROCESS_GET_GUID");
        cf.f(cy.e(cy.this));
        return;
      case 7: 
        eh.f("SharkNetwork", "[rsa_key]handle: MSG_REQUEST_SENDPROCESS_UPDATE_RSAKEY");
        cs.g(cy.e(cy.this));
        return;
      case 4: 
        cy.j(cy.this).submit(new Runnable()
        {
          public void run()
          {
            if (cy.m(cy.this) != null)
            {
              eh.i("SharkNetwork", "[cu_guid]deal msg: guid info changed, check update guid");
              cy.m(cy.this).a(true, null);
            }
          }
        });
        return;
      case 10: 
        cy.j(cy.this).submit(new Runnable()
        {
          public void run()
          {
            if (cy.m(cy.this) != null) {
              cy.m(cy.this).a(true, "yunzhiling_realinfo");
            }
          }
        });
        return;
      case 8: 
        eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_REGISTER_VID_IFNEED");
        cy.r(cy.this).av();
        return;
      case 9: 
        eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_UPDATE_VID_IFNEED");
        cy.r(cy.this).b(0, false);
        return;
      }
      cs.a(cy.e(cy.this), 0, cy.this.ai());
    }
  };
  private long jz = 0L;
  private Context mContext;
  
  public cy(Context paramContext, cl paramcl, e parame, c paramc, d paramd, boolean paramBoolean, String paramString)
  {
    eh.f("SharkNetwork", "[shark_init]SharkNetwork() isTest: " + paramBoolean + " serverAdd: " + paramString);
    this.mContext = paramContext;
    this.hS = paramcl;
    this.jh = parame;
    this.ju = paramc;
    this.je = new cs(paramContext, this);
    this.jf = new cf(paramContext, this, paramBoolean);
    this.jg = new dk(paramContext, this, paramBoolean);
    this.jn = Executors.newSingleThreadExecutor();
    this.jd = new df(this.hS.ax(), paramContext, paramcl, paramBoolean, this.jv, this, paramd, this, paramString);
    if (this.hS.ax())
    {
      a(paramd);
      this.jg.c(paramd);
    }
  }
  
  private void A(int paramInt)
  {
    synchronized (this.jl)
    {
      Object localObject2 = (ArrayList)this.jl.clone();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        as localas;
        do
        {
          ??? = ((ArrayList)localObject2).iterator();
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)???).hasNext()) {
                break;
              }
              localObject2 = (f)((Iterator)???).next();
            } while ((localObject2 == null) || (((f)localObject2).jT == null) || (((f)localObject2).jT.size() <= 0));
            localObject2 = ((f)localObject2).jT.iterator();
          }
          localas = (as)((Iterator)localObject2).next();
        } while (localas == null);
        cv.by().a("SharkNetwork", localas.bM, localas.dc, localas, paramInt);
      }
    }
  }
  
  private f B(int paramInt)
  {
    eh.e("SharkNetwork", "removeSendingBySeqNoTag() seqNoTag: " + paramInt);
    synchronized (this.jm)
    {
      f localf = (f)this.jm.remove(Integer.valueOf(paramInt));
      return localf;
    }
  }
  
  private void C(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jy.sendEmptyMessage(1);
      return;
    }
    if (paramInt > 0) {}
    for (paramInt = Math.abs(-800000000) + paramInt;; paramInt = -800000000 + paramInt)
    {
      eh.f("SharkNetwork", "[cu_guid] onGuidRegisterResult(), guid failed, call onSharkVipError(), " + paramInt);
      a(false, false, paramInt);
      return;
    }
  }
  
  private void D(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jp = System.currentTimeMillis();
      this.jo = false;
      for (;;)
      {
        f localf;
        synchronized (this.hT)
        {
          if (this.jr)
          {
            eh.g("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), update rsa succ, allow register guid!");
            this.jr = false;
          }
          ??? = new ArrayList();
          synchronized (this.jm)
          {
            if (this.jm.size() <= 0) {
              break label197;
            }
            Iterator localIterator = this.jm.values().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            localf = (f)localIterator.next();
            if ((!localf.jJ) && (!localf.jK)) {
              ((List)???).add(localf);
            }
          }
        }
        eh.f("SharkNetwork", "[cu_guid][cu_guid] onRsaKeyUpdateResult(), rsa or guid, should not revert and resend after rsa updated, rsa?" + localf.jJ + " guid?" + localf.jK);
      }
      this.jm.clear();
      label197:
      if (localCollection.size() > 0)
      {
        eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, revert and resend data, size: " + localCollection.size());
        ??? = localCollection.iterator();
        while (((Iterator)???).hasNext()) {
          c((f)((Iterator)???).next());
        }
      }
      for (;;)
      {
        synchronized (this.jl)
        {
          this.jl.addAll(localCollection);
          eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, send MSG_SHARK_SEND");
          this.jy.sendEmptyMessage(1);
          return;
        }
        eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, no need to revert and resend data");
      }
    }
    if (paramInt > 0) {}
    for (paramInt = Math.abs(-900000000) + paramInt;; paramInt = -900000000 + paramInt)
    {
      eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa failed, call onSharkVipError(), " + paramInt);
      a(false, true, paramInt);
      return;
    }
  }
  
  private dj<Long, Integer, JceStruct> a(long paramLong, int paramInt, au paramau)
  {
    if (paramau == null)
    {
      eh.g("SharkNetwork", "[cu_guid_p]handlePushRefreshGuid(), scPushRefreshGuid == null");
      return null;
    }
    eh.i("SharkNetwork", "[cu_guid_p]handlePushRefreshGuid(), |pushId=" + paramLong + "|serverShasimiSeqNo=" + paramInt);
    this.jf.a(true, paramau.cX);
    return null;
  }
  
  private dj<Long, Integer, JceStruct> a(long paramLong, int paramInt, u paramu)
  {
    if (paramu == null)
    {
      eh.g("SharkNetwork", "[ip_list]handleHIPList(), scHIPList == null");
      return null;
    }
    Object localObject = this.jd.cq();
    if (localObject != null) {
      ((dp)localObject).a(paramLong, paramInt, paramu);
    }
    eh.e("SharkNetwork", "[ip_list]report push status, |pushId=" + paramLong);
    localObject = new q();
    ((q)localObject).ay = paramu.ay;
    return new dj(Long.valueOf(paramLong), Integer.valueOf(156), localObject);
  }
  
  private final ArrayList<ba> a(f paramf, boolean paramBoolean, bb parambb, ArrayList<ba> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    paramf = new ArrayList();
    int k = paramArrayList.size();
    int i = 0;
    while (i < k)
    {
      ba localba = (ba)paramArrayList.get(i);
      if (localba == null)
      {
        i += 1;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder().append("checkFilterList(), rs.refSeqNo: ").append(localba.dd).append(" rs.cmd: ").append(localba.bM).append(" rs.retCode: ").append(localba.df).append(" rs.dataRetCode: ").append(localba.dg).append(" rs.data.length: ");
        if (localba.data != null) {}
        for (int j = localba.data.length;; j = 0)
        {
          eh.f("SharkNetwork", j);
          if (a(paramBoolean, parambb, localba)) {
            break;
          }
          paramf.add(localba);
          break;
        }
      }
    }
    return paramf;
  }
  
  private void a(d paramd)
  {
    cm local6 = new cm()
    {
      public dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousJceStruct == null)
        {
          eh.h("SharkNetwork", "[ip_list][cu_guid_p]onRecvPush() null == push");
          return null;
        }
        switch (paramAnonymousInt2)
        {
        default: 
          return null;
        case 10155: 
          return cy.a(cy.this, paramAnonymousLong, paramAnonymousInt1, (u)paramAnonymousJceStruct);
        }
        return cy.a(cy.this, paramAnonymousLong, paramAnonymousInt1, (au)paramAnonymousJceStruct);
      }
    };
    paramd.a(0L, 10155, new u(), 0, local6, false);
    paramd.a(0L, 15081, new au(), 0, local6, false);
    eh.f("SharkNetwork", "[ip_list][cu_guid_p]registerSharkPush, Cmd_SCHIPList,Cmd_SCPushRefreshGuid: 10155,15081");
  }
  
  private void a(boolean paramBoolean, int paramInt, f arg3)
  {
    eh.f("SharkNetwork", "runError(), ret = " + paramInt + " isTcpChannel: " + paramBoolean);
    if (??? == null)
    {
      eh.g("SharkNetwork", "runError(), failedSharkSend == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jj != null) && (this.jj.jQ == ???.jQ))
    {
      eh.f("SharkNetwork", "runError(), updating rsa, only callback rsa");
      localArrayList.add(this.jj);
      B(this.jj.jQ);
    }
    for (;;)
    {
      eh.f("SharkNetwork", "runError(), callback error, ret: " + paramInt + " values.size(): " + localArrayList.size());
      ??? = localArrayList.iterator();
      while (???.hasNext()) {
        a(paramBoolean, (f)???.next(), paramInt, 0, null);
      }
      break;
      if ((this.jk != null) && (this.jk.jQ == ???.jQ))
      {
        eh.f("SharkNetwork", "runError(), updating guid, only callback guid");
        localArrayList.add(this.jk);
        B(this.jk.jQ);
        continue;
      }
      eh.f("SharkNetwork", "runError(), call back failed for this seqNo: " + ???.jQ);
      localArrayList.add(???);
      B(???.jQ);
      synchronized (this.jl)
      {
        eh.e("SharkNetwork", "runError(), callback failed for mSharkQueueWaiting, size(): " + this.jl.size());
        localArrayList.addAll(this.jl);
        this.jl.clear();
      }
    }
  }
  
  private void a(boolean paramBoolean, f paramf, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
  {
    a(false, paramBoolean, paramf, paramInt1, paramInt2, paramArrayList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ??? = new StringBuilder().append("onSharkVipError(), retCode = ").append(paramInt).append(" 事件： ");
    Object localObject1;
    if (paramBoolean2) {
      localObject1 = "交换密钥";
    }
    for (;;)
    {
      eh.e("SharkNetwork", (String)localObject1);
      localObject1 = new ArrayList();
      synchronized (this.jm)
      {
        eh.e("SharkNetwork", "onSharkVipError(), callback failed for all sending: " + this.jm.keySet());
        ((ArrayList)localObject1).addAll(this.jm.values());
        this.jm.clear();
      }
      synchronized (this.jl)
      {
        eh.e("SharkNetwork", "onSharkVipError(), callback failed for mSharkQueueWaiting, size(): " + this.jl.size());
        ((ArrayList)localObject1).addAll(this.jl);
        this.jl.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            a(paramBoolean1, (f)((Iterator)localObject1).next(), paramInt, 0, null);
            continue;
            localObject1 = "注册guid";
            break;
            localObject2 = finally;
            throw localObject2;
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, f paramf, int paramInt1, int paramInt2, ba paramba)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramba);
    a(paramBoolean1, paramBoolean2, paramf, paramInt1, paramInt2, localArrayList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, f paramf, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
  {
    if ((paramf == null) || (paramBoolean1)) {}
    try
    {
      if ((paramf.jT == null) || (paramf.jT.size() <= 0)) {
        B(paramf.jQ);
      }
      paramf.jU.a(paramBoolean2, paramInt1, paramInt2, paramArrayList);
      return;
    }
    catch (Exception paramf)
    {
      eh.b("SharkNetwork", "runError() callback crash", paramf);
    }
  }
  
  private boolean a(boolean paramBoolean, bb parambb, ba paramba)
  {
    if (paramba == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    Object localObject;
    if (db.b(paramba))
    {
      this.ju.a(paramBoolean, parambb.dc, paramba);
      localStringBuilder = new StringBuilder().append("[ocean]guid|").append(this.jf.getGuid()).append("|push|").append("通道|");
      if (paramBoolean)
      {
        localObject = "tcp|";
        localObject = localStringBuilder.append((String)localObject).append("sharkSeqNo|").append(parambb.dc).append("|ECmd|").append(paramba.bM).append("|seqNo|").append(paramba.dc).append("|refSeqNo|").append(paramba.dd).append("|ret|").append(0);
        if (paramba.ds == null) {
          break label207;
        }
        parambb = "|pushId|" + paramba.ds.db;
        label180:
        eh.f("ocean", parambb);
        paramBoolean = true;
      }
    }
    for (;;)
    {
      return paramBoolean;
      localObject = "http|";
      break;
      label207:
      parambb = "";
      break label180;
      if (db.c(paramba))
      {
        this.ju.b(paramBoolean, parambb.dc, paramba);
        localStringBuilder = new StringBuilder().append("[ocean]guid|").append(this.jf.getGuid()).append("|gift|").append("通道|");
        if (paramBoolean)
        {
          localObject = "tcp|";
          label283:
          localObject = localStringBuilder.append((String)localObject).append("sharkSeqNo|").append(parambb.dc).append("|ECmd|").append(paramba.bM).append("|seqNo|").append(paramba.dc).append("|refSeqNo|").append(paramba.dd).append("|ret|").append(0);
          if (paramba.ds == null) {
            break label416;
          }
        }
        label416:
        for (parambb = "|pushId|" + paramba.ds.db;; parambb = "")
        {
          eh.f("ocean", parambb);
          paramBoolean = true;
          break;
          localObject = "http|";
          break label283;
        }
      }
      paramBoolean = false;
    }
  }
  
  private void b(final f paramf)
  {
    if (paramf == null) {
      return;
    }
    eh.e("SharkNetwork", "runTimeout(), will check timeout for sharkSend with seqNoTag: " + paramf.jQ);
    this.jA.removeMessages(1, paramf);
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        cy.f localf = cy.c(cy.this, paramf.jQ);
        if (localf == null) {
          return;
        }
        eh.f("SharkNetwork", "runTimeout(), sharkSend.seqNoTag: " + paramf.jQ + " isSent: " + paramf.jW);
        if (localf.jW) {}
        for (int i = -21050000;; i = -21000020)
        {
          cy.a(cy.this, paramf.jN, localf, i, 0, null);
          return;
        }
      }
    }, "runTimeout");
  }
  
  private void bG()
  {
    A(4);
    if (cx.ay())
    {
      eh.f("SharkNetwork", "[cu_guid] handleOnNeedGuid(), isSemiSendProcess, no guid, regGuidListener() & requestSendProcessRegisterGuid()");
      ch local2 = new ch()
      {
        public void e(int paramAnonymousInt, String paramAnonymousString)
        {
          eh.f("SharkNetwork", "[cu_guid] IGuidCallback.onCallback(), unregGuidListener(this) and call onGuidRegisterResult(errCode)");
          if (cy.h(cy.this) != null) {
            cy.h(cy.this).b(this);
          }
          cy.a(cy.this, paramAnonymousInt);
        }
      };
      if (this.jh != null) {
        this.jh.a(local2);
      }
      long l = 2000L;
      if (this.jw)
      {
        this.jw = false;
        l = 0L;
      }
      this.jy.removeMessages(6);
      this.jy.sendEmptyMessageDelayed(6, l);
      return;
    }
    bH();
  }
  
  /* Error */
  private void bI()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 187	btmsdkobf/cy:hS	Lbtmsdkobf/cl;
    //   6: invokevirtual 226	btmsdkobf/cl:ax	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 155	btmsdkobf/cy:jz	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifeq +18 -> 41
    //   26: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   29: aload_0
    //   30: getfield 155	btmsdkobf/cy:jz	J
    //   33: lsub
    //   34: ldc2_w 682
    //   37: lcmp
    //   38: ifle -24 -> 14
    //   41: aload_0
    //   42: invokestatic 325	java/lang/System:currentTimeMillis	()J
    //   45: putfield 155	btmsdkobf/cy:jz	J
    //   48: aload_0
    //   49: getfield 153	btmsdkobf/cy:jy	Landroid/os/Handler;
    //   52: bipush 8
    //   54: invokevirtual 673	android/os/Handler:removeMessages	(I)V
    //   57: aload_0
    //   58: getfield 153	btmsdkobf/cy:jy	Landroid/os/Handler;
    //   61: bipush 8
    //   63: invokevirtual 306	android/os/Handler:sendEmptyMessage	(I)Z
    //   66: pop
    //   67: ldc 160
    //   69: ldc_w 685
    //   72: invokestatic 183	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: goto -61 -> 14
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	cy
    //   9	2	1	bool	boolean
    //   78	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	78	finally
    //   17	41	78	finally
    //   41	75	78	finally
  }
  
  private void c(f paramf)
  {
    if ((paramf == null) || (paramf.jT == null) || (paramf.jR == null) || (paramf.jR.is == null))
    {
      eh.h("SharkNetwork", "[rsa_key]revertClientSashimiData() something null");
      return;
    }
    Iterator localIterator = paramf.jT.iterator();
    label45:
    as localas;
    while (localIterator.hasNext())
    {
      localas = (as)localIterator.next();
      if ((localas != null) && (localas.data != null))
      {
        if ((localas.di & 0x2) == 0) {
          localas.data = cd.decrypt(localas.data, paramf.jR.is.getBytes());
        }
        if (localas.data == null) {
          break label176;
        }
        eh.e("SharkNetwork", "[rsa_key]revertClientSashimiData(), revert succ, cmd: " + localas.bM + " len: " + localas.data.length);
      }
    }
    for (;;)
    {
      cv.by().a("SharkNetwork", localas.bM, localas.dc, localas, 13);
      break label45;
      break;
      label176:
      eh.h("SharkNetwork", "[rsa_key]revertClientSashimiData(), revert failed, cmd: " + localas.bM);
    }
  }
  
  private static void c(ArrayList<ba> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    ba localba;
    do
    {
      return;
      while (!paramArrayList.hasNext()) {
        paramArrayList = paramArrayList.iterator();
      }
      localba = (ba)paramArrayList.next();
    } while ((localba == null) || (localba.df != 3));
    eh.f("SharkNetwork", "[shark_v4][shark_fin]mazu said need sharkfin, cmdId: " + localba.bM + " ClientSashimi.seqNo: " + localba.dd + " ServerSashimi.seqNo: " + localba.dc);
    cd.aU();
  }
  
  private boolean d(ArrayList<ba> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() != 1)) {
      return false;
    }
    paramArrayList = (ba)paramArrayList.get(0);
    if (paramArrayList == null) {
      return false;
    }
    if (2 == paramArrayList.df) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
  
  private void w(boolean paramBoolean)
  {
    long l1 = 2000L;
    long l2 = 0L;
    int i = 0;
    Object localObject;
    if (paramBoolean)
    {
      A(3);
      if (!cx.ay()) {
        break label104;
      }
      eh.i("SharkNetwork", "[rsa_key] handleOnNeedRsaKey(), isSemiSendProcess, regRsaKeyListener() & requestSendProcessUpdateRsaKey()");
      localObject = new a()
      {
        public void a(int paramAnonymousInt, cs.b paramAnonymousb)
        {
          eh.f("SharkNetwork", "[rsa_key] IRsaKeyListener.onCallback(), isSemiSendProcess, unregRsaKeyListener(this) and call onRsaKeyUpdated(errCode)");
          if (cy.h(cy.this) != null) {
            cy.h(cy.this).b(this);
          }
          cy.b(cy.this, paramAnonymousInt);
        }
      };
      if (this.jh != null) {
        this.jh.a((a)localObject);
      }
      if (!this.jx) {
        break label156;
      }
      this.jx = false;
    }
    label156:
    for (l1 = l2;; l1 = 2000L)
    {
      this.jy.removeMessages(7);
      this.jy.sendEmptyMessageDelayed(7, l1);
      return;
      A(2);
      break;
      label104:
      localObject = new StringBuilder().append("[rsa_key] handleOnNeedRsaKey(), isSendProcess, triggerUpdateRsaKey() in(ms) ");
      if (paramBoolean) {
        i = 2000;
      }
      eh.i("SharkNetwork", i);
      if (paramBoolean) {}
      for (;;)
      {
        f(l1);
        return;
        l1 = 0L;
      }
    }
  }
  
  protected cs.b a(boolean paramBoolean, f paramf)
  {
    if (paramf == null) {
      return null;
    }
    cs.b localb;
    as localas;
    if (paramBoolean)
    {
      localb = this.je.ai();
      paramf.jR = localb;
      ??? = paramf.jT.iterator();
      while (((Iterator)???).hasNext())
      {
        localas = (as)((Iterator)???).next();
        if ((localas != null) && (localas.data != null) && (localas.data.length > 0) && ((localas.di & 0x2) == 0))
        {
          localas.data = cd.encrypt(localas.data, localb.is.getBytes());
          if (localas.data == null) {
            eh.h("SharkNetwork", "[ocean][rsa_key]encrypt failed, cmdId: " + localas.bM);
          }
        }
      }
    }
    for (;;)
    {
      if ((paramf.jT != null) && (paramf.jT.size() > 0))
      {
        ??? = paramf.jT.iterator();
        while (((Iterator)???).hasNext())
        {
          localas = (as)((Iterator)???).next();
          if (localas != null)
          {
            if (localas.dd == 0) {
              paramf.jP = true;
            }
            cv.by().a("SharkNetwork", localas.bM, localas.dc, localas, 5);
          }
        }
      }
      for (;;)
      {
        synchronized (this.jm)
        {
          eh.e("SharkNetwork", "spSend() sharkSend.seqNoTag: " + paramf.jQ);
          this.jm.put(Integer.valueOf(paramf.jQ), paramf);
          if (paramf.jY > 0L)
          {
            l = paramf.jY;
            ??? = Message.obtain(this.jA, 1, paramf);
            this.jA.sendMessageDelayed((Message)???, l);
            this.jd.d(paramf);
            return localb;
          }
        }
        long l = 30000L;
      }
      localb = null;
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean, ArrayList<as> paramArrayList, b paramb)
  {
    a(new f(paramInt, false, false, false, paramLong, paramArrayList, paramb, 0L));
    if (paramBoolean) {
      this.jf.a(false, null);
    }
  }
  
  public void a(f paramf)
  {
    if ((paramf == null) || (paramf.jU == null) || (paramf.jT == null) || (paramf.jT.size() <= 0)) {
      return;
    }
    synchronized (this.jl)
    {
      this.jl.add(paramf);
      eh.f("SharkNetwork", "asyncSendShark() mSharkQueueWaiting.size(): " + this.jl.size());
      paramf = paramf.jT.iterator();
      while (paramf.hasNext())
      {
        ??? = (as)paramf.next();
        if (??? != null)
        {
          eh.f("SharkNetwork_CMDID", "[" + 0 + "]发包请求：cmd id:[" + ((as)???).bM + "]seqNo:[" + ((as)???).dc + "]refSeqNo:[" + ((as)???).dd + "]retCode:[" + ((as)???).df + "]dataRetCode:[" + ((as)???).dg + "]");
          cv.by().a("SharkNetwork", ((as)???).bM, ((as)???).dc, (as)???, 1);
        }
      }
    }
    this.jy.sendEmptyMessage(1);
  }
  
  protected void a(ArrayList<as> paramArrayList, b paramb)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      eh.f("SharkNetwork_CMDID", "[" + i + "]Rsa发包请求：cmd id:[" + localas.bM + "]seqNo:[" + localas.dc + "]refSeqNo:[" + localas.dd + "]retCode:[" + localas.df + "]dataRetCode:[" + localas.dg + "]");
      i += 1;
    }
    this.jj = new f(0, true, false, false, 0L, paramArrayList, paramb, 0L);
    this.jj.jJ = true;
    this.jy.obtainMessage(0, 1, 0).sendToTarget();
  }
  
  protected cs.b ai()
  {
    return this.je.ai();
  }
  
  /* Error */
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifgt +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   9: ifnonnull +27 -> 36
    //   12: ldc 2
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   19: ifnonnull +14 -> 33
    //   22: aload_0
    //   23: new 851	android/util/SparseArray
    //   26: dup
    //   27: invokespecial 852	android/util/SparseArray:<init>	()V
    //   30: putfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   33: ldc 2
    //   35: monitorexit
    //   36: new 854	btmsdkobf/ce
    //   39: dup
    //   40: new 162	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 856
    //   50: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_1
    //   54: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: iload_2
    //   61: sipush 1000
    //   64: imul
    //   65: i2l
    //   66: iload_3
    //   67: invokespecial 859	btmsdkobf/ce:<init>	(Ljava/lang/String;JI)V
    //   70: astore 5
    //   72: aload_0
    //   73: getfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   76: astore 4
    //   78: aload 4
    //   80: monitorenter
    //   81: aload_0
    //   82: getfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   85: iload_1
    //   86: aload 5
    //   88: invokevirtual 861	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   91: ldc 160
    //   93: new 162	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 863
    //   103: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_1
    //   107: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc_w 865
    //   113: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_2
    //   117: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 867
    //   123: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload_3
    //   127: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 869
    //   133: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 107	btmsdkobf/cy:ji	Landroid/util/SparseArray;
    //   140: invokevirtual 870	android/util/SparseArray:size	()I
    //   143: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 289	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload 4
    //   154: monitorexit
    //   155: return
    //   156: astore 5
    //   158: aload 4
    //   160: monitorexit
    //   161: aload 5
    //   163: athrow
    //   164: astore 4
    //   166: ldc 2
    //   168: monitorexit
    //   169: aload 4
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	cy
    //   0	172	1	paramInt1	int
    //   0	172	2	paramInt2	int
    //   0	172	3	paramInt3	int
    //   164	6	4	localObject1	Object
    //   70	17	5	localce	ce
    //   156	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   81	155	156	finally
    //   158	161	156	finally
    //   15	33	164	finally
    //   33	36	164	finally
    //   166	169	164	finally
  }
  
  protected void b(ArrayList<as> paramArrayList, b paramb)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      eh.f("SharkNetwork_CMDID", "[" + i + "]Guid发包请求：cmd id:[" + localas.bM + "]seqNo:[" + localas.dc + "]refSeqNo:[" + localas.dd + "]retCode:[" + localas.df + "]dataRetCode:[" + localas.dg + "]");
      i += 1;
    }
    this.jk = new f(0, true, false, false, 0L, paramArrayList, paramb, 0L);
    this.jk.jK = true;
    this.jy.obtainMessage(0, 2, 0).sendToTarget();
  }
  
  void bH()
  {
    synchronized (this.hT)
    {
      if ((this.jr) && (!dy.a(System.currentTimeMillis(), this.jt, 3)))
      {
        eh.g("SharkNetwork", "[cu_guid]registering guid, ignore");
        return;
      }
      this.jr = true;
      this.jt = System.currentTimeMillis();
      this.jy.removeMessages(3);
      this.jy.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
  }
  
  public di bJ()
  {
    return this.jd.bJ();
  }
  
  void bK()
  {
    eh.f("SharkNetwork", "[rsa_key]refreshRsaKey()");
    this.je.refresh();
  }
  
  protected cl bL()
  {
    return this.hS;
  }
  
  public void bM()
  {
    if (this.jy != null)
    {
      eh.i("SharkNetwork", "[cu_guid]send msg: guid info changed, check update guid in 15s");
      this.jy.removeMessages(4);
      this.jy.sendEmptyMessage(4);
    }
  }
  
  public void bN()
  {
    if (this.jy != null)
    {
      eh.f("SharkNetwork", "[cu_vid] updateVidIfNeed(), send MSG_UPDATE_VID_IFNEED in 2s");
      this.jy.removeMessages(9);
      this.jy.sendEmptyMessageDelayed(9, 2000L);
    }
  }
  
  public void bO()
  {
    bI();
  }
  
  void ba()
  {
    eh.f("SharkNetwork", "[cu_guid]refreshGuid()");
    this.jf.ba();
  }
  
  void f(long paramLong)
  {
    synchronized (this.hT)
    {
      if ((this.jq) && (!dy.a(System.currentTimeMillis(), this.js, 3))) {
        return;
      }
      this.jq = true;
      this.js = System.currentTimeMillis();
      this.jy.removeMessages(2);
      this.jy.sendEmptyMessageDelayed(2, paramLong);
      return;
    }
  }
  
  public String getGuid()
  {
    return this.jf.getGuid();
  }
  
  public void onReady()
  {
    eh.i("SharkNetwork", "[cu_guid]onReady(), check update guid");
    this.jf.a(true, null);
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt, cs.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList);
  }
  
  public static abstract interface c
  {
    public abstract long a(boolean paramBoolean, int paramInt, ba paramba);
    
    public abstract long b(boolean paramBoolean, int paramInt, ba paramba);
  }
  
  public static abstract interface d
  {
    public abstract void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm, boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract void a(ch paramch);
    
    public abstract void a(cy.a parama);
    
    public abstract void b(ch paramch);
    
    public abstract void b(cy.a parama);
  }
  
  public static class f
  {
    public int jH = 0;
    public boolean jI = false;
    public boolean jJ = false;
    public boolean jK = false;
    public boolean jL = false;
    public boolean jM = false;
    public boolean jN = false;
    public boolean jO = false;
    public boolean jP = false;
    public int jQ;
    public cs.b jR;
    public long jS;
    public ArrayList<as> jT;
    public cy.b jU;
    public long jV = System.currentTimeMillis();
    public boolean jW = false;
    public byte jX = 0;
    public long jY = -1L;
    
    public f(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, ArrayList<as> paramArrayList, cy.b paramb, long paramLong2)
    {
      this.jH = paramInt;
      this.jI = paramBoolean1;
      this.jL = paramBoolean2;
      this.jM = paramBoolean3;
      this.jS = paramLong1;
      this.jT = paramArrayList;
      this.jU = paramb;
      this.jQ = cu.bv().bm();
      this.jY = paramLong2;
    }
    
    public boolean bP()
    {
      long l = Math.abs(System.currentTimeMillis() - this.jV);
      boolean bool;
      int i;
      label85:
      as localas;
      if (l >= 30000L)
      {
        bool = true;
        if (!bool) {
          break label165;
        }
        eh.h("ocean", "[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), SharkSend.seqNoTag: " + this.jQ + " time(s): " + l / 1000L);
        if (this.jT == null) {
          break label165;
        }
        int j = this.jT.size();
        i = 0;
        if (i >= j) {
          break label165;
        }
        localas = (as)this.jT.get(i);
        if (localas != null) {
          break label121;
        }
      }
      for (;;)
      {
        i += 1;
        break label85;
        bool = false;
        break;
        label121:
        eh.h("ocean", "[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), cmdId|" + localas.bM + "|seqNo|" + localas.dc);
      }
      label165:
      return bool;
    }
    
    public boolean bQ()
    {
      return (this.jL) || (this.jM);
    }
    
    public boolean bR()
    {
      return this.jI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cy
 * JD-Core Version:    0.7.0.1
 */