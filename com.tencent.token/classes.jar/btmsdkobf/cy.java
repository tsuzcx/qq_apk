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
      if (paramAnonymousMessage.what != 1) {
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onFinish(), retCode: ");
      ((StringBuilder)???).append(paramAnonymousInt);
      eh.f("SharkNetwork", ((StringBuilder)???).toString());
      if (paramAnonymousInt != 0)
      {
        cy.a(cy.this, paramAnonymousBoolean, paramAnonymousInt, paramAnonymousf);
        return;
      }
      if (??? == null)
      {
        eh.h("SharkNetwork", "onFinish() null == retData");
        cy.a(cy.this, paramAnonymousBoolean, -21000005, paramAnonymousf);
        return;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onFinish() retData.length: ");
      ((StringBuilder)???).append(???.length);
      eh.e("SharkNetwork", ((StringBuilder)???).toString());
      if (cx.i(???))
      {
        byte b = ???[0];
        paramAnonymousInt = cv.by().b(b);
        if (paramAnonymousInt < 0) {
          break label989;
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
      try
      {
        ??? = cp.g(???);
        if (??? == null)
        {
          eh.h("SharkNetwork", "onFinish() null == obj");
          cy.a(cy.this, paramAnonymousBoolean, -21000400, paramAnonymousf);
          return;
        }
        bb localbb = (bb)???;
        ArrayList localArrayList = localbb.du;
        int j = localbb.dd;
        if ((cy.b(cy.this) != null) && (cy.b(cy.this).jQ == j)) {
          paramAnonymousf = cy.b(cy.this);
        }
        for (;;)
        {
          if ((cy.c(cy.this) != null) && (cy.c(cy.this).jQ == j)) {
            paramAnonymousf = cy.c(cy.this);
          } else {
            synchronized (cy.a(cy.this))
            {
              paramAnonymousf = (cy.f)cy.a(cy.this).get(Integer.valueOf(j));
              continue;
              int i;
              Object localObject3;
              if (localArrayList != null)
              {
                ??? = localArrayList.iterator();
                i = 0;
                while (((Iterator)???).hasNext())
                {
                  localObject2 = (ba)((Iterator)???).next();
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("[");
                  ((StringBuilder)localObject3).append(i);
                  ((StringBuilder)localObject3).append("]收包：cmd id:[");
                  ((StringBuilder)localObject3).append(((ba)localObject2).bM);
                  ((StringBuilder)localObject3).append("]seqNo:[");
                  ((StringBuilder)localObject3).append(((ba)localObject2).dc);
                  ((StringBuilder)localObject3).append("]refSeqNo:[");
                  ((StringBuilder)localObject3).append(((ba)localObject2).dd);
                  ((StringBuilder)localObject3).append("]retCode:[");
                  ((StringBuilder)localObject3).append(((ba)localObject2).df);
                  ((StringBuilder)localObject3).append("]dataRetCode:[");
                  ((StringBuilder)localObject3).append(((ba)localObject2).dg);
                  ((StringBuilder)localObject3).append("]");
                  eh.f("SharkNetwork_CMDID", ((StringBuilder)localObject3).toString());
                  i += 1;
                }
              }
              if (localArrayList == null)
              {
                eh.h("SharkNetwork", "onFinish() null == respSashimiList");
                cy.a(cy.this, paramAnonymousBoolean, paramAnonymousf, -21000005, localbb.dc, null);
                return;
              }
              cy.e(localArrayList);
              ??? = new StringBuilder();
              ((StringBuilder)???).append("onFinish() sharkSeq: ");
              ((StringBuilder)???).append(j);
              ((StringBuilder)???).append(" ssTag: ");
              ((StringBuilder)???).append(paramAnonymousf);
              ((StringBuilder)???).append(" shark回包或push个数: ");
              ((StringBuilder)???).append(localArrayList.size());
              eh.e("SharkNetwork", ((StringBuilder)???).toString());
              boolean bool = cy.a(cy.this, localArrayList);
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[rsa_key]onFinish() 密钥是否过期：");
              if (bool) {
                ??? = "是";
              } else {
                ??? = "否";
              }
              ((StringBuilder)localObject2).append((String)???);
              eh.f("SharkNetwork", ((StringBuilder)localObject2).toString());
              if (bool)
              {
                cy.a(cy.this, true);
                cy.d(cy.this).removeMessages(1);
                cy.d(cy.this).sendEmptyMessageDelayed(1, 100L);
                return;
              }
              localObject2 = cy.a(cy.this, paramAnonymousf, paramAnonymousBoolean, localbb, localArrayList);
              if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
              {
                localObject3 = ((ArrayList)localObject2).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  ba localba = (ba)((Iterator)localObject3).next();
                  if (localba != null)
                  {
                    cv localcv = cv.by();
                    i = localba.bM;
                    j = localba.dd;
                    if (??? != null) {
                      ??? = String.format("%d/%d", new Object[] { Integer.valueOf(???.length + 4), Integer.valueOf(localArrayList.size()) });
                    } else {
                      ??? = null;
                    }
                    localcv.a("SharkNetwork", i, j, localba, 17, paramAnonymousInt, (String)???);
                    ??? = dg.J(localba.dd);
                    if (??? != null)
                    {
                      ((dg)???).ml = String.valueOf(cd.e(cy.e(cy.this)));
                      ((dg)???).errorCode = localba.df;
                      ((dg)???).I(localba.bM);
                      ((dg)???).f(cy.f(cy.this));
                    }
                  }
                }
              }
              cy.a(cy.this, paramAnonymousBoolean, paramAnonymousf, 0, localbb.dc, (ArrayList)localObject2);
              cy.g(cy.this);
              label989:
              return;
            }
          }
        }
        return;
      }
      catch (Exception ???)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onFinish() e: ");
        ((StringBuilder)???).append(???.toString());
        eh.h("SharkNetwork", ((StringBuilder)???).toString());
        cy.a(cy.this, paramAnonymousBoolean, -21000400, paramAnonymousf);
      }
    }
    
    public void b(boolean paramAnonymousBoolean, int paramAnonymousInt, cy.f paramAnonymousf)
    {
      StringBuilder localStringBuilder;
      if (paramAnonymousf != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendFailed(), isTcpChannel: ");
        localStringBuilder.append(paramAnonymousBoolean);
        localStringBuilder.append(" retCode: ");
        localStringBuilder.append(paramAnonymousInt);
        localStringBuilder.append(" seqNo: ");
        localStringBuilder.append(paramAnonymousf.jQ);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendFailed(), isTcpChannel: ");
        localStringBuilder.append(paramAnonymousBoolean);
        localStringBuilder.append(" retCode: ");
        localStringBuilder.append(paramAnonymousInt);
      }
      eh.h("SharkNetwork", localStringBuilder.toString());
      if (paramAnonymousInt != 0) {
        cy.a(cy.this, paramAnonymousBoolean, paramAnonymousInt, paramAnonymousf);
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
          Object localObject4;
          if (cy.i(cy.this) != null)
          {
            if (!paramAnonymousf.jM) {
              synchronized (cy.i(cy.this))
              {
                ce localce1 = (ce)cy.i(cy.this).get(997);
                if ((localce1 != null) && (!localce1.aW()))
                {
                  eh.g("SharkNetwork", "[network_control] cloud cmd: fp donot connect, use http channel");
                  paramAnonymousf.jO = true;
                }
              }
            }
            ??? = paramAnonymousf.jT;
            if ((??? != null) && (((ArrayList)???).size() > 0))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("[network_control] before control, sashimis.size(): ");
              ((StringBuilder)localObject4).append(((ArrayList)???).size());
              eh.f("SharkNetwork", ((StringBuilder)localObject4).toString());
              ??? = ((ArrayList)???).iterator();
              while (((Iterator)???).hasNext())
              {
                localObject4 = (as)((Iterator)???).next();
                if (localObject4 != null) {
                  synchronized (cy.i(cy.this))
                  {
                    ce localce2 = (ce)cy.i(cy.this).get(((as)localObject4).bM);
                    if (localce2 != null) {
                      if (localce2.aW())
                      {
                        localce2.aX();
                      }
                      else
                      {
                        ((Iterator)???).remove();
                        ??? = new StringBuilder();
                        ((StringBuilder)???).append("network ctrl donot connect, cmdid : ");
                        ((StringBuilder)???).append(((as)localObject4).bM);
                        eh.f("SharkNetwork", ((StringBuilder)???).toString());
                        ??? = new StringBuilder();
                        ((StringBuilder)???).append("[network_control] cloud cmd: donot connect, cmdid : ");
                        ((StringBuilder)???).append(((as)localObject4).bM);
                        eh.g("SharkNetwork", ((StringBuilder)???).toString());
                        ??? = new ba();
                        ((ba)???).bM = ((as)localObject4).bM;
                        ((ba)???).df = -7;
                        cy.a(cy.this, true, false, paramAnonymousf, -20000007, 0, (ba)???);
                      }
                    }
                  }
                }
              }
            }
          }
          ArrayList localArrayList = paramAnonymousf.jT;
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("[network_control] after control, sashimis.size(): ");
            ((StringBuilder)localObject4).append(localArrayList.size());
            eh.f("SharkNetwork", ((StringBuilder)localObject4).toString());
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
      Object localObject1;
      switch (???.what)
      {
      default: 
        return;
      case 10: 
        localObject1 = cy.j(cy.this);
        ??? = new Runnable()
        {
          public void run()
          {
            if (cy.m(cy.this) != null) {
              cy.m(cy.this).a(true, "yunzhiling_realinfo");
            }
          }
        };
        break;
      case 9: 
        eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_UPDATE_VID_IFNEED");
        cy.r(cy.this).b(0, false);
        return;
      case 8: 
        eh.f("SharkNetwork", "[cu_vid]deal msg: MSG_REGISTER_VID_IFNEED");
        cy.r(cy.this).av();
        return;
      case 7: 
        eh.f("SharkNetwork", "[rsa_key]handle: MSG_REQUEST_SENDPROCESS_UPDATE_RSAKEY");
        cs.g(cy.e(cy.this));
        return;
      case 6: 
        eh.f("SharkNetwork", "[cu_guid]handle: MSG_REQUEST_SENDPROCESS_GET_GUID");
        cf.f(cy.e(cy.this));
        return;
      case 5: 
        cs.a(cy.e(cy.this), 0, cy.this.ai());
        return;
      case 4: 
        localObject1 = cy.j(cy.this);
        ??? = new Runnable()
        {
          public void run()
          {
            if (cy.m(cy.this) != null)
            {
              eh.i("SharkNetwork", "[cu_guid]deal msg: guid info changed, check update guid");
              cy.m(cy.this).a(true, null);
            }
          }
        };
        break;
      case 3: 
        eh.f("SharkNetwork", "[cu_guid]MSG_SHARK_GET_GUID");
        cy.d(cy.this).removeMessages(3);
        localObject1 = cy.j(cy.this);
        ??? = new Runnable()
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
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("[cu_guid]onGuidFinish(), send broadcast, ret: ");
                  ((StringBuilder)???).append(paramAnonymous3Int3);
                  eh.e("SharkNetwork", ((StringBuilder)???).toString());
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
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[cu_guid]register guid exception: ");
              localStringBuilder.append(localException.toString());
              eh.h("SharkNetwork", localStringBuilder.toString());
              synchronized (cy.q(cy.this))
              {
                cy.d(cy.this, false);
                cy.a(cy.this, -20000014);
                return;
              }
            }
          }
        };
        break;
      case 2: 
        cy.d(cy.this).removeMessages(2);
        eh.f("SharkNetwork", "[rsa_key]msg: MSG_SHARK_UPDATE_RSAKEY");
        localObject1 = cy.j(cy.this);
        ??? = new Runnable()
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
                  ??? = new StringBuilder();
                  ((StringBuilder)???).append("[rsa_key]onUpdateFinish(), ret: ");
                  ((StringBuilder)???).append(paramAnonymous3Int3);
                  eh.e("SharkNetwork", ((StringBuilder)???).toString());
                  synchronized (cy.q(cy.this))
                  {
                    cy.c(cy.this, false);
                    cv.by().a("SharkNetwork", paramAnonymous3Int2, paramAnonymous3Int1, (ba)null, 30, paramAnonymous3Int3);
                    cv.by().x(paramAnonymous3Int1);
                    if (paramAnonymous3Int3 == 0) {
                      cs.a(cy.e(cy.this), paramAnonymous3Int3, cy.this.ai());
                    } else {
                      cs.a(cy.e(cy.this), paramAnonymous3Int3, null);
                    }
                    cy.b(cy.this, paramAnonymous3Int3);
                    return;
                  }
                }
              });
              return;
            }
            catch (Exception localException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[rsa_key] MSG_SHARK_UPDATE_RSAKEY e: ");
              localStringBuilder.append(localException.toString());
              eh.h("SharkNetwork", localStringBuilder.toString());
              synchronized (cy.q(cy.this))
              {
                cy.c(cy.this, false);
                cy.b(cy.this, -20000014);
                return;
              }
            }
          }
        };
        ((ExecutorService)localObject1).submit(???);
        return;
      case 1: 
        eh.f("SharkNetwork", "MSG_SHARK_SEND");
        cy.d(cy.this).removeMessages(1);
        ??? = cy.k(cy.this).ai();
        if ((!TextUtils.isEmpty(???.ir)) && (!TextUtils.isEmpty(???.is)))
        {
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
            localObject1 = (ArrayList)cy.o(cy.this).clone();
            cy.o(cy.this).clear();
            ??? = ((ArrayList)localObject1).iterator();
            for (;;)
            {
              if (!???.hasNext()) {
                return;
              }
              localObject1 = (cy.f)???.next();
              if (localObject1 != null)
              {
                if (cy.l(cy.this))
                {
                  eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, rsakey expired suddenly, handleOnNeedRsaKey()");
                  cy.b(cy.this, true);
                  return;
                }
                if (!((cy.f)localObject1).jL) {
                  break;
                }
                a(false, (cy.f)localObject1);
              }
            }
            a(true, (cy.f)localObject1);
          }
        }
        eh.g("SharkNetwork", "[rsa_key] MSG_SHARK_SEND, without rsakey, handleOnNeedRsaKey()");
        cy.b(cy.this, false);
        return;
      }
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
    }
  };
  private long jz = 0L;
  private Context mContext;
  
  public cy(Context paramContext, cl paramcl, e parame, c paramc, d paramd, boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shark_init]SharkNetwork() isTest: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" serverAdd: ");
    localStringBuilder.append(paramString);
    eh.f("SharkNetwork", localStringBuilder.toString());
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
        ??? = ((ArrayList)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (f)((Iterator)???).next();
          if ((localObject2 != null) && (((f)localObject2).jT != null) && (((f)localObject2).jT.size() > 0))
          {
            localObject2 = ((f)localObject2).jT.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              as localas = (as)((Iterator)localObject2).next();
              if (localas != null) {
                cv.by().a("SharkNetwork", localas.bM, localas.dc, localas, paramInt);
              }
            }
          }
        }
      }
      return;
    }
  }
  
  private f B(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("removeSendingBySeqNoTag() seqNoTag: ");
    ((StringBuilder)???).append(paramInt);
    eh.e("SharkNetwork", ((StringBuilder)???).toString());
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
    if (paramInt > 0) {
      paramInt = Math.abs(-800000000) + paramInt;
    } else {
      paramInt = -800000000 + paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cu_guid] onGuidRegisterResult(), guid failed, call onSharkVipError(), ");
    localStringBuilder.append(paramInt);
    eh.f("SharkNetwork", localStringBuilder.toString());
    a(false, false, paramInt);
  }
  
  private void D(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jp = System.currentTimeMillis();
      this.jo = false;
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
          if (this.jm.size() > 0)
          {
            Iterator localIterator = this.jm.values().iterator();
            while (localIterator.hasNext())
            {
              f localf = (f)localIterator.next();
              if ((!localf.jJ) && (!localf.jK))
              {
                ((List)???).add(localf);
              }
              else
              {
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("[cu_guid][cu_guid] onRsaKeyUpdateResult(), rsa or guid, should not revert and resend after rsa updated, rsa?");
                localStringBuilder2.append(localf.jJ);
                localStringBuilder2.append(" guid?");
                localStringBuilder2.append(localf.jK);
                eh.f("SharkNetwork", localStringBuilder2.toString());
              }
            }
            this.jm.clear();
          }
          if (((List)???).size() > 0)
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[cu_guid] onRsaKeyUpdateResult(), rsa succ, revert and resend data, size: ");
            ((StringBuilder)???).append(((List)???).size());
            eh.f("SharkNetwork", ((StringBuilder)???).toString());
            ??? = ((List)???).iterator();
            while (((Iterator)???).hasNext()) {
              c((f)((Iterator)???).next());
            }
            synchronized (this.jl)
            {
              this.jl.addAll((Collection)???);
            }
          }
          eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, no need to revert and resend data");
          eh.f("SharkNetwork", "[cu_guid] onRsaKeyUpdateResult(), rsa succ, send MSG_SHARK_SEND");
          this.jy.sendEmptyMessage(1);
          return;
        }
      }
    }
    if (paramInt > 0) {
      paramInt = Math.abs(-900000000) + paramInt;
    } else {
      paramInt = -900000000 + paramInt;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[cu_guid] onRsaKeyUpdateResult(), rsa failed, call onSharkVipError(), ");
    localStringBuilder1.append(paramInt);
    eh.f("SharkNetwork", localStringBuilder1.toString());
    a(false, true, paramInt);
  }
  
  private dj<Long, Integer, JceStruct> a(long paramLong, int paramInt, au paramau)
  {
    if (paramau == null)
    {
      eh.g("SharkNetwork", "[cu_guid_p]handlePushRefreshGuid(), scPushRefreshGuid == null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cu_guid_p]handlePushRefreshGuid(), |pushId=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|serverShasimiSeqNo=");
    localStringBuilder.append(paramInt);
    eh.i("SharkNetwork", localStringBuilder.toString());
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[ip_list]report push status, |pushId=");
    ((StringBuilder)localObject).append(paramLong);
    eh.e("SharkNetwork", ((StringBuilder)localObject).toString());
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
      if (localba != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFilterList(), rs.refSeqNo: ");
        localStringBuilder.append(localba.dd);
        localStringBuilder.append(" rs.cmd: ");
        localStringBuilder.append(localba.bM);
        localStringBuilder.append(" rs.retCode: ");
        localStringBuilder.append(localba.df);
        localStringBuilder.append(" rs.dataRetCode: ");
        localStringBuilder.append(localba.dg);
        localStringBuilder.append(" rs.data.length: ");
        int j;
        if (localba.data != null) {
          j = localba.data.length;
        } else {
          j = 0;
        }
        localStringBuilder.append(j);
        eh.f("SharkNetwork", localStringBuilder.toString());
        if (!a(paramBoolean, parambb, localba)) {
          paramf.add(localba);
        }
      }
      i += 1;
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
        if (paramAnonymousInt2 != 10155)
        {
          if (paramAnonymousInt2 != 15081) {
            return null;
          }
          return cy.a(cy.this, paramAnonymousLong, paramAnonymousInt1, (au)paramAnonymousJceStruct);
        }
        return cy.a(cy.this, paramAnonymousLong, paramAnonymousInt1, (u)paramAnonymousJceStruct);
      }
    };
    paramd.a(0L, 10155, new u(), 0, local6, false);
    paramd.a(0L, 15081, new au(), 0, local6, false);
    eh.f("SharkNetwork", "[ip_list][cu_guid_p]registerSharkPush, Cmd_SCHIPList,Cmd_SCPushRefreshGuid: 10155,15081");
  }
  
  private void a(boolean paramBoolean, int paramInt, f arg3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("runError(), ret = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" isTcpChannel: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    eh.f("SharkNetwork", ((StringBuilder)localObject1).toString());
    if (??? == null)
    {
      eh.g("SharkNetwork", "runError(), failedSharkSend == null");
      return;
    }
    localObject1 = new ArrayList();
    Object localObject3 = this.jj;
    if ((localObject3 != null) && (((f)localObject3).jQ == ???.jQ))
    {
      eh.f("SharkNetwork", "runError(), updating rsa, only callback rsa");
      ((ArrayList)localObject1).add(this.jj);
    }
    for (??? = this.jj;; ??? = this.jk)
    {
      B(???.jQ);
      break label301;
      localObject3 = this.jk;
      if ((localObject3 == null) || (((f)localObject3).jQ != ???.jQ)) {
        break;
      }
      eh.f("SharkNetwork", "runError(), updating guid, only callback guid");
      ((ArrayList)localObject1).add(this.jk);
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("runError(), call back failed for this seqNo: ");
    ((StringBuilder)localObject3).append(???.jQ);
    eh.f("SharkNetwork", ((StringBuilder)localObject3).toString());
    ((ArrayList)localObject1).add(???);
    B(???.jQ);
    synchronized (this.jl)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("runError(), callback failed for mSharkQueueWaiting, size(): ");
      ((StringBuilder)localObject3).append(this.jl.size());
      eh.e("SharkNetwork", ((StringBuilder)localObject3).toString());
      ((ArrayList)localObject1).addAll(this.jl);
      this.jl.clear();
      label301:
      ??? = new StringBuilder();
      ???.append("runError(), callback error, ret: ");
      ???.append(paramInt);
      ???.append(" values.size(): ");
      ???.append(((ArrayList)localObject1).size());
      eh.f("SharkNetwork", ???.toString());
      ??? = ((ArrayList)localObject1).iterator();
      while (???.hasNext()) {
        a(paramBoolean, (f)???.next(), paramInt, 0, null);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, f paramf, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
  {
    a(false, paramBoolean, paramf, paramInt1, paramInt2, paramArrayList);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("onSharkVipError(), retCode = ");
    ((StringBuilder)???).append(paramInt);
    ((StringBuilder)???).append(" 事件： ");
    if (paramBoolean2) {
      localObject1 = "交换密钥";
    } else {
      localObject1 = "注册guid";
    }
    ((StringBuilder)???).append((String)localObject1);
    eh.e("SharkNetwork", ((StringBuilder)???).toString());
    Object localObject1 = new ArrayList();
    synchronized (this.jm)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSharkVipError(), callback failed for all sending: ");
      localStringBuilder.append(this.jm.keySet());
      eh.e("SharkNetwork", localStringBuilder.toString());
      ((ArrayList)localObject1).addAll(this.jm.values());
      this.jm.clear();
      synchronized (this.jl)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSharkVipError(), callback failed for mSharkQueueWaiting, size(): ");
        localStringBuilder.append(this.jl.size());
        eh.e("SharkNetwork", localStringBuilder.toString());
        ((ArrayList)localObject1).addAll(this.jl);
        this.jl.clear();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramBoolean1, (f)((Iterator)localObject1).next(), paramInt, 0, null);
        }
        return;
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
    if (paramf != null)
    {
      if (paramBoolean1) {}
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ocean]guid|");
      localStringBuilder.append(this.jf.getGuid());
      localStringBuilder.append("|push|");
      localStringBuilder.append("通道|");
      if (paramBoolean) {
        localObject = "tcp|";
      } else {
        localObject = "http|";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("sharkSeqNo|");
      localStringBuilder.append(parambb.dc);
      localStringBuilder.append("|ECmd|");
      localStringBuilder.append(paramba.bM);
      localStringBuilder.append("|seqNo|");
      localStringBuilder.append(paramba.dc);
      localStringBuilder.append("|refSeqNo|");
      localStringBuilder.append(paramba.dd);
      localStringBuilder.append("|ret|");
      localStringBuilder.append(0);
      parambb = localStringBuilder;
      if (paramba.ds != null) {
        localObject = new StringBuilder();
      }
    }
    for (parambb = localStringBuilder;; parambb = localStringBuilder)
    {
      ((StringBuilder)localObject).append("|pushId|");
      ((StringBuilder)localObject).append(paramba.ds.db);
      paramba = ((StringBuilder)localObject).toString();
      do
      {
        paramba = "";
        parambb.append(paramba);
        eh.f("ocean", parambb.toString());
        return true;
        if (!db.c(paramba)) {
          break;
        }
        this.ju.b(paramBoolean, parambb.dc, paramba);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ocean]guid|");
        localStringBuilder.append(this.jf.getGuid());
        localStringBuilder.append("|gift|");
        localStringBuilder.append("通道|");
        if (paramBoolean) {
          localObject = "tcp|";
        } else {
          localObject = "http|";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("sharkSeqNo|");
        localStringBuilder.append(parambb.dc);
        localStringBuilder.append("|ECmd|");
        localStringBuilder.append(paramba.bM);
        localStringBuilder.append("|seqNo|");
        localStringBuilder.append(paramba.dc);
        localStringBuilder.append("|refSeqNo|");
        localStringBuilder.append(paramba.dd);
        localStringBuilder.append("|ret|");
        localStringBuilder.append(0);
        parambb = localStringBuilder;
      } while (paramba.ds == null);
      localObject = new StringBuilder();
    }
    return false;
  }
  
  private void b(final f paramf)
  {
    if (paramf == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runTimeout(), will check timeout for sharkSend with seqNoTag: ");
    localStringBuilder.append(paramf.jQ);
    eh.e("SharkNetwork", localStringBuilder.toString());
    this.jA.removeMessages(1, paramf);
    ee.cT().addTask(new Runnable()
    {
      public void run()
      {
        cy.f localf = cy.c(cy.this, paramf.jQ);
        if (localf == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("runTimeout(), sharkSend.seqNoTag: ");
        localStringBuilder.append(paramf.jQ);
        localStringBuilder.append(" isSent: ");
        localStringBuilder.append(paramf.jW);
        eh.f("SharkNetwork", localStringBuilder.toString());
        int i;
        if (localf.jW) {
          i = -21050000;
        } else {
          i = -21000020;
        }
        cy.a(cy.this, paramf.jN, localf, i, 0, null);
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
      e locale = this.jh;
      if (locale != null) {
        locale.a(local2);
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
  
  private void bI()
  {
    try
    {
      boolean bool = this.hS.ax();
      if (!bool) {
        return;
      }
      if (this.jz != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jz;
        if (l1 - l2 <= 300000L) {
          return;
        }
      }
      this.jz = System.currentTimeMillis();
      this.jy.removeMessages(8);
      this.jy.sendEmptyMessage(8);
      eh.f("SharkNetwork", "[cu_vid]triggerRegVidIfNeed(), send msg: MSG_REGISTER_VID_IFNEED in 5s");
      return;
    }
    finally {}
  }
  
  private void c(f paramf)
  {
    if ((paramf != null) && (paramf.jT != null) && (paramf.jR != null) && (paramf.jR.is != null))
    {
      Iterator localIterator = paramf.jT.iterator();
      while (localIterator.hasNext())
      {
        as localas = (as)localIterator.next();
        if ((localas != null) && (localas.data != null))
        {
          if ((localas.di & 0x2) == 0) {
            localas.data = cd.decrypt(localas.data, paramf.jR.is.getBytes());
          }
          StringBuilder localStringBuilder;
          if (localas.data != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[rsa_key]revertClientSashimiData(), revert succ, cmd: ");
            localStringBuilder.append(localas.bM);
            localStringBuilder.append(" len: ");
            localStringBuilder.append(localas.data.length);
            eh.e("SharkNetwork", localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[rsa_key]revertClientSashimiData(), revert failed, cmd: ");
            localStringBuilder.append(localas.bM);
            eh.h("SharkNetwork", localStringBuilder.toString());
          }
          cv.by().a("SharkNetwork", localas.bM, localas.dc, localas, 13);
        }
      }
      return;
    }
    eh.h("SharkNetwork", "[rsa_key]revertClientSashimiData() something null");
  }
  
  private static void c(ArrayList<ba> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramArrayList = (ba)((Iterator)localObject).next();
        if ((paramArrayList != null) && (paramArrayList.df == 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[shark_v4][shark_fin]mazu said need sharkfin, cmdId: ");
          ((StringBuilder)localObject).append(paramArrayList.bM);
          ((StringBuilder)localObject).append(" ClientSashimi.seqNo: ");
          ((StringBuilder)localObject).append(paramArrayList.dd);
          ((StringBuilder)localObject).append(" ServerSashimi.seqNo: ");
          ((StringBuilder)localObject).append(paramArrayList.dc);
          eh.f("SharkNetwork", ((StringBuilder)localObject).toString());
          cd.aU();
        }
      }
    }
  }
  
  private boolean d(ArrayList<ba> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() != 1) {
        return false;
      }
      paramArrayList = (ba)paramArrayList.get(0);
      if (paramArrayList == null) {
        return false;
      }
      int i;
      if (2 == paramArrayList.df) {
        i = 1;
      } else {
        i = 0;
      }
      return i != 0;
    }
    return false;
  }
  
  private void w(boolean paramBoolean)
  {
    if (paramBoolean) {
      i = 3;
    } else {
      i = 2;
    }
    A(i);
    boolean bool = cx.ay();
    long l = 0L;
    int i = 0;
    if (bool)
    {
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
      e locale = this.jh;
      if (locale != null) {
        locale.a((a)localObject);
      }
      if (this.jx) {
        this.jx = false;
      } else {
        l = 2000L;
      }
      this.jy.removeMessages(7);
      this.jy.sendEmptyMessageDelayed(7, l);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[rsa_key] handleOnNeedRsaKey(), isSendProcess, triggerUpdateRsaKey() in(ms) ");
    if (paramBoolean) {
      i = 2000;
    }
    ((StringBuilder)localObject).append(i);
    eh.i("SharkNetwork", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      l = 2000L;
    }
    f(l);
  }
  
  protected cs.b a(boolean paramBoolean, f paramf)
  {
    Object localObject1 = null;
    if (paramf == null) {
      return null;
    }
    Object localObject3;
    if (paramBoolean)
    {
      ??? = this.je.ai();
      paramf.jR = ((cs.b)???);
      localObject3 = paramf.jT.iterator();
      for (;;)
      {
        localObject1 = ???;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (as)((Iterator)localObject3).next();
        if ((localObject1 != null) && (((as)localObject1).data != null) && (((as)localObject1).data.length > 0) && ((((as)localObject1).di & 0x2) == 0))
        {
          ((as)localObject1).data = cd.encrypt(((as)localObject1).data, ((cs.b)???).is.getBytes());
          if (((as)localObject1).data == null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[ocean][rsa_key]encrypt failed, cmdId: ");
            localStringBuilder.append(((as)localObject1).bM);
            eh.h("SharkNetwork", localStringBuilder.toString());
          }
        }
      }
    }
    if ((paramf.jT != null) && (paramf.jT.size() > 0))
    {
      ??? = paramf.jT.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject3 = (as)((Iterator)???).next();
        if (localObject3 != null)
        {
          if (((as)localObject3).dd == 0) {
            paramf.jP = true;
          }
          cv.by().a("SharkNetwork", ((as)localObject3).bM, ((as)localObject3).dc, (as)localObject3, 5);
        }
      }
    }
    synchronized (this.jm)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("spSend() sharkSend.seqNoTag: ");
      ((StringBuilder)localObject3).append(paramf.jQ);
      eh.e("SharkNetwork", ((StringBuilder)localObject3).toString());
      this.jm.put(Integer.valueOf(paramf.jQ), paramf);
      long l;
      if (paramf.jY > 0L) {
        l = paramf.jY;
      } else {
        l = 30000L;
      }
      ??? = Message.obtain(this.jA, 1, paramf);
      this.jA.sendMessageDelayed((Message)???, l);
      this.jd.d(paramf);
      return localObject1;
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
    if ((paramf != null) && (paramf.jU != null) && (paramf.jT != null))
    {
      if (paramf.jT.size() <= 0) {
        return;
      }
      synchronized (this.jl)
      {
        this.jl.add(paramf);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("asyncSendShark() mSharkQueueWaiting.size(): ");
        localStringBuilder.append(this.jl.size());
        eh.f("SharkNetwork", localStringBuilder.toString());
        paramf = paramf.jT.iterator();
        while (paramf.hasNext())
        {
          ??? = (as)paramf.next();
          if (??? != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(0);
            localStringBuilder.append("]发包请求：cmd id:[");
            localStringBuilder.append(((as)???).bM);
            localStringBuilder.append("]seqNo:[");
            localStringBuilder.append(((as)???).dc);
            localStringBuilder.append("]refSeqNo:[");
            localStringBuilder.append(((as)???).dd);
            localStringBuilder.append("]retCode:[");
            localStringBuilder.append(((as)???).df);
            localStringBuilder.append("]dataRetCode:[");
            localStringBuilder.append(((as)???).dg);
            localStringBuilder.append("]");
            eh.f("SharkNetwork_CMDID", localStringBuilder.toString());
            cv.by().a("SharkNetwork", ((as)???).bM, ((as)???).dc, (as)???, 1);
          }
        }
        this.jy.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  protected void a(ArrayList<as> paramArrayList, b paramb)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(i);
      localStringBuilder.append("]Rsa发包请求：cmd id:[");
      localStringBuilder.append(localas.bM);
      localStringBuilder.append("]seqNo:[");
      localStringBuilder.append(localas.dc);
      localStringBuilder.append("]refSeqNo:[");
      localStringBuilder.append(localas.dd);
      localStringBuilder.append("]retCode:[");
      localStringBuilder.append(localas.df);
      localStringBuilder.append("]dataRetCode:[");
      localStringBuilder.append(localas.dg);
      localStringBuilder.append("]");
      eh.f("SharkNetwork_CMDID", localStringBuilder.toString());
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
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 0) {
      return;
    }
    if (this.ji == null) {
      try
      {
        if (this.ji == null) {
          this.ji = new SparseArray();
        }
      }
      finally {}
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("network_control_");
    ((StringBuilder)???).append(paramInt1);
    Object localObject3 = new ce(((StringBuilder)???).toString(), paramInt2 * 1000, paramInt3);
    synchronized (this.ji)
    {
      this.ji.append(paramInt1, localObject3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[network_control]handleNetworkControl : cmdid|");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("|timeSpan|");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append("|maxTimes|");
      ((StringBuilder)localObject3).append(paramInt3);
      ((StringBuilder)localObject3).append(" size: ");
      ((StringBuilder)localObject3).append(this.ji.size());
      eh.e("SharkNetwork", ((StringBuilder)localObject3).toString());
      return;
    }
  }
  
  protected void b(ArrayList<as> paramArrayList, b paramb)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(i);
      localStringBuilder.append("]Guid发包请求：cmd id:[");
      localStringBuilder.append(localas.bM);
      localStringBuilder.append("]seqNo:[");
      localStringBuilder.append(localas.dc);
      localStringBuilder.append("]refSeqNo:[");
      localStringBuilder.append(localas.dd);
      localStringBuilder.append("]retCode:[");
      localStringBuilder.append(localas.df);
      localStringBuilder.append("]dataRetCode:[");
      localStringBuilder.append(localas.dg);
      localStringBuilder.append("]");
      eh.f("SharkNetwork_CMDID", localStringBuilder.toString());
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
      int i = 0;
      boolean bool;
      if (l >= 30000L) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), SharkSend.seqNoTag: ");
        ((StringBuilder)localObject).append(this.jQ);
        ((StringBuilder)localObject).append(" time(s): ");
        ((StringBuilder)localObject).append(l / 1000L);
        eh.h("ocean", ((StringBuilder)localObject).toString());
        localObject = this.jT;
        if (localObject != null)
        {
          int j = ((ArrayList)localObject).size();
          while (i < j)
          {
            localObject = (as)this.jT.get(i);
            if (localObject != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), cmdId|");
              localStringBuilder.append(((as)localObject).bM);
              localStringBuilder.append("|seqNo|");
              localStringBuilder.append(((as)localObject).dc);
              eh.h("ocean", localStringBuilder.toString());
            }
            i += 1;
          }
        }
      }
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