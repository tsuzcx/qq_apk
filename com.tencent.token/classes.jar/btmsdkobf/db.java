package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class db
  implements cy.c, cy.d, cy.e
{
  private static volatile db li;
  private static int lj;
  private static final long[] lk = { 100L, 60000L, 120000L };
  private final String TAG = "SharkProtocolQueue";
  private cy hF;
  private cl he;
  private ExecutorService jn;
  private Handler jy = new Handler(cx.getLooper())
  {
    public void handleMessage(Message arg1)
    {
      int j = ???.what;
      final int i = 0;
      Object localObject6;
      db.e locale;
      switch (j)
      {
      default: 
        return;
      case 7: 
        eh.f("SharkProtocolQueue", "[cu_guid]handle: MSG_REQUEST_REG_GUID");
        cf.f(bc.n());
        return;
      case 6: 
        ??? = new StringBuilder();
        ???.append("[shark_vip] handle: MSG_RESET_VIP_RULE, expired VipRule: ");
        ???.append(db.q(db.this));
        eh.f("SharkProtocolQueue", ???.toString());
        db.a(db.this, null);
        eh.f("SharkProtocolQueue", "[shark_vip] triggle MSG_SEND_SHARK on VipRule expired ");
        if (cx.iT)
        {
          db.b(db.this).sendEmptyMessage(1);
          return;
        }
        break;
      case 5: 
        i = ???.arg1;
        ??? = new StringBuilder();
        ???.append("[shark_push]handle MSG_CHECK_CACHED_PUSH for cmd: ");
        ???.append(i);
        eh.e("SharkProtocolQueue", ???.toString());
        synchronized (db.t(db.this))
        {
          ??? = (dj)db.t(db.this).get(Integer.valueOf(i));
          ??? = new ArrayList();
          ??? = new ArrayList();
          synchronized (db.s(db.this))
          {
            if (db.s(db.this).size() > 0)
            {
              localObject6 = db.s(db.this).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                db.b localb = (db.b)((Iterator)localObject6).next();
                if (localb.c.bM == i) {
                  ((List)???).add(localb);
                } else {
                  ((List)???).add(localb);
                }
              }
              db.s(db.this).clear();
              db.s(db.this).addAll((Collection)???);
            }
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[shark_push]handle MSG_CHECK_CACHED_PUSH, fixed: ");
            ((StringBuilder)???).append(((List)???).size());
            ((StringBuilder)???).append(" remain: ");
            ((StringBuilder)???).append(((List)???).size());
            eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
            if ((??? != null) && (((List)???).size() > 0))
            {
              ee.cT().addTask(new Runnable()
              {
                public void run()
                {
                  Iterator localIterator = this.a.iterator();
                  while (localIterator.hasNext())
                  {
                    db.b localb = (db.b)localIterator.next();
                    StringBuilder localStringBuilder;
                    if (localb.e == 0)
                    {
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append("[shark_push]handle cached push, cmd: ");
                      localStringBuilder.append(i);
                      localStringBuilder.append(" pushId: ");
                      localStringBuilder.append(localb.b);
                      eh.e("SharkProtocolQueue", localStringBuilder.toString());
                      db.a(db.this, localb.b, localb.c, localb.d, paramAnonymousMessage);
                    }
                    else
                    {
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append("[shark_push]handle cached gift, cmd: ");
                      localStringBuilder.append(i);
                      localStringBuilder.append(" pushId: ");
                      localStringBuilder.append(localb.b);
                      eh.e("SharkProtocolQueue", localStringBuilder.toString());
                      db.b(db.this, localb.b, localb.c, localb.d, paramAnonymousMessage);
                    }
                  }
                }
              }, "shark callback: check cached push");
              return;
            }
          }
        }
      case 4: 
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE");
        ??? = new ArrayList();
        synchronized (db.s(db.this))
        {
          if (db.s(db.this).size() > 0)
          {
            ???.addAll(db.s(db.this));
            db.s(db.this).clear();
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[shark_push]handle MSG_CLEAR_PUSH_CACHE, ");
          ((StringBuilder)???).append(???.size());
          ((StringBuilder)???).append(" -> 0");
          eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
          if (???.size() > 0)
          {
            ??? = ???.iterator();
            while (???.hasNext())
            {
              ??? = (db.b)???.next();
              if (((db.b)???).e == 0)
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("[shark_push]sendPushResp() on push cleared, cmd: ");
                ((StringBuilder)???).append(((db.b)???).c.bM);
                ((StringBuilder)???).append(" pushId: ");
                ((StringBuilder)???).append(((db.b)???).b);
                eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
                db.this.a(((db.b)???).c.dc, ((db.b)???).b, ((db.b)???).c.bM, null, null, -2, -1000000001);
              }
              else
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("[shark_push]no need to sendPushResp() on gift cleared, cmd: ");
                ((StringBuilder)???).append(((db.b)???).c.bM);
                ((StringBuilder)???).append(" pushId: ");
                ((StringBuilder)???).append(((db.b)???).b);
                eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
              }
            }
          }
        }
      case 3: 
        eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH");
        ??? = new ArrayList();
        ??? = new ArrayList();
        synchronized (db.s(db.this))
        {
          if (db.s(db.this).size() > 0)
          {
            long l = System.currentTimeMillis();
            ??? = db.s(db.this).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject6 = (db.b)((Iterator)???).next();
              if (l - ((db.b)localObject6).a >= 600000L) {
                ???.add(localObject6);
              } else {
                ((List)???).add(localObject6);
              }
            }
            db.s(db.this).clear();
            db.s(db.this).addAll((Collection)???);
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[shark_push]handle MSG_CLEAR_EXPIRED_PUSH, expired: ");
          ((StringBuilder)???).append(???.size());
          ((StringBuilder)???).append(" remain: ");
          ((StringBuilder)???).append(((List)???).size());
          eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
          if (???.size() > 0)
          {
            ??? = ???.iterator();
            while (???.hasNext())
            {
              ??? = (db.b)???.next();
              if (((db.b)???).e == 0)
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("[shark_push]sendPushResp() for expired push, cmd: ");
                ((StringBuilder)???).append(((db.b)???).c.bM);
                ((StringBuilder)???).append(" pushId: ");
                ((StringBuilder)???).append(((db.b)???).b);
                eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
                db.this.a(((db.b)???).c.dc, ((db.b)???).b, ((db.b)???).c.bM, null, null, -2, -1000000001);
              }
              else
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("[shark_push]no need to sendPushResp() for expired gift, cmd: ");
                ((StringBuilder)???).append(((db.b)???).c.bM);
                ((StringBuilder)???).append(" pushId: ");
                ((StringBuilder)???).append(((db.b)???).b);
                eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
              }
            }
          }
        }
      case 2: 
        cx.iT = true;
        eh.e("SharkProtocolQueue", "[shark_init]=========== MSG_INIT_FINISH ==========");
        synchronized (db.a(db.this))
        {
          i = db.a(db.this).size();
          if (i > 0) {
            db.b(db.this).sendEmptyMessage(1);
          }
          if (db.c(db.this)) {
            db.this.x(false);
          }
          if (db.d(db.this)) {
            db.this.x(true);
          }
          if (db.e(db.this)) {
            db.this.ca();
          }
          if (db.f(db.this)) {
            db.this.bH();
          }
          if (db.g(db.this)) {
            db.this.onReady();
          }
          if (db.h(db.this)) {
            db.this.cb();
          }
          if (db.i(db.this)) {
            db.this.bM();
          }
          if (db.j(db.this)) {
            db.this.bN();
          }
          if (db.k(db.this)) {
            db.this.av();
          }
          if (db.l(db.this)) {
            db.this.bY();
          }
          if (db.m(db.this) != null)
          {
            ??? = db.m(db.this).iterator();
            while (???.hasNext())
            {
              ??? = (cq)???.next();
              if (??? != null) {
                db.this.b(((cq)???).a, ((cq)???).b, ((cq)???).c);
              }
            }
            db.a(db.this, null);
          }
          if (db.n(db.this))
          {
            db.a(db.this, false);
            ??? = db.this.getGuid();
            if (!TextUtils.isEmpty(???))
            {
              eh.f("SharkProtocolQueue", "[cu_guid] notifyGuidGot on init finished");
              db.a(db.this, 0, ???);
            }
          }
          if (db.o(db.this)) {
            db.this.cc();
          }
          if (db.p(db.this))
          {
            db.this.cd();
            return;
          }
        }
      case 1: 
        db.b(db.this).removeMessages(1);
        locale = new db.e(db.this, null);
        ??? = new ArrayList();
      }
      for (;;)
      {
        synchronized (db.a(db.this))
        {
          ??? = db.a(db.this).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject6 = (db.d)((Iterator)???).next();
            if (db.q(db.this) == null) {
              break label1887;
            }
            bool = db.q(db.this).b(((db.d)localObject6).d, ((db.d)localObject6).c);
            if ((((db.d)localObject6).i & 0x40000000) == 0)
            {
              if (!((db.d)localObject6).o.bA())
              {
                if (bool)
                {
                  locale.a(Integer.valueOf(((db.d)localObject6).l), (db.d)localObject6);
                  break label1893;
                }
                ((ArrayList)???).add(localObject6);
                continue;
              }
              cv.by().w(((db.d)localObject6).l);
              continue;
            }
            if (!bool) {
              continue;
            }
            db.e.a(locale).add(localObject6);
            break label1893;
          }
          db.a(db.this).clear();
          if (((ArrayList)???).size() > 0) {
            db.a(db.this).addAll((Collection)???);
          }
          if (i > 0)
          {
            db.r(db.this).submit(locale);
            return;
          }
        }
        return;
        label1887:
        boolean bool = true;
        continue;
        label1893:
        i += 1;
      }
    }
  };
  private List<b> kP = new ArrayList();
  private ArrayList<d> kQ = new ArrayList();
  private dn<Long> kR = new dn(1000);
  private dl kS;
  private boolean kT = false;
  private boolean kU = false;
  private boolean kV = false;
  private boolean kW = false;
  private boolean kX = false;
  private boolean kY = false;
  private boolean kZ = false;
  private TreeMap<Integer, dj<JceStruct, cm, c>> kq = new TreeMap();
  private Handler kr = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 11) {
        return;
      }
      paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
      db.d locald = (db.d)paramAnonymousMessage[0];
      if (locald.b > 0)
      {
        if (locald.k != null) {
          locald.k.a(locald.a, locald.b, locald.l, ((Integer)paramAnonymousMessage[1]).intValue(), ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locald.h);
        }
      }
      else {
        locald.j.onFinish(locald.l, ((Integer)paramAnonymousMessage[1]).intValue(), ((Integer)paramAnonymousMessage[2]).intValue(), ((Integer)paramAnonymousMessage[3]).intValue(), locald.g);
      }
    }
  };
  private boolean la = false;
  private boolean lb = false;
  private LinkedList<cq> ld = null;
  private boolean le = false;
  private boolean lf = false;
  private boolean lg = false;
  private boolean lh = false;
  private List<ch> ll = new ArrayList();
  private List<ch> lm = new ArrayList();
  private List<cy.a> ln = new ArrayList();
  private a lo = null;
  private Context mContext = bc.n();
  
  private void a(long paramLong, ba paramba, byte[] paramArrayOfByte, dj<JceStruct, cm, c> paramdj)
  {
    Object localObject1 = paramba.data;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      String str;
      if (((c)paramdj.mU).lE) {
        try
        {
          localObject1 = cd.a(this.mContext, paramArrayOfByte, paramba.data, paramba.di);
          paramArrayOfByte = null;
        }
        catch (Exception paramArrayOfByte)
        {
          localObject1 = new StringBuilder();
          str = "[shark_push]handleCallbackForPush(), dataForReceive2JceBytes exception: ";
        }
      } else {
        for (;;)
        {
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(paramArrayOfByte);
          eh.a("SharkProtocolQueue", ((StringBuilder)localObject1).toString(), paramArrayOfByte);
          a(paramba.dc, paramLong, paramba.bM, null, null, -1);
          break;
          if (paramdj.first == null) {
            break;
          }
          try
          {
            paramArrayOfByte = cd.a(this.mContext, paramArrayOfByte, paramba.data, (JceStruct)paramdj.first, true, paramba.di);
            localObject1 = localObject2;
          }
          catch (Exception paramArrayOfByte)
          {
            localObject1 = new StringBuilder();
            str = "[shark_push]handleCallbackForPush(), dataForReceive2JceStruct exception: ";
          }
        }
      }
    }
    else
    {
      paramArrayOfByte = null;
      localObject1 = localObject2;
    }
    try
    {
      if (((c)paramdj.mU).lE) {
        paramArrayOfByte = ((cn)paramdj.second).a(paramba.dc, paramLong, paramba.bM, (byte[])localObject1);
      } else {
        paramArrayOfByte = ((cm)paramdj.second).a(paramba.dc, paramLong, paramba.bM, paramArrayOfByte);
      }
      if (paramArrayOfByte != null)
      {
        paramdj = new StringBuilder();
        paramdj.append("[shark_push]handleCallbackForPush(), send PushStatus for user: |pushId|");
        paramdj.append(paramLong);
        paramdj.append("|cmd|");
        paramdj.append(paramArrayOfByte.second);
        paramdj.append("|JceStruct|");
        paramdj.append(paramArrayOfByte.mU);
        eh.f("SharkProtocolQueue", paramdj.toString());
        a(paramba.dc, paramLong, ((Integer)paramArrayOfByte.second).intValue(), (JceStruct)paramArrayOfByte.mU, null, 1);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[shark_push]handleCallbackForPush(), donot send PushStatus for user: |pushId|");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append("|cmd|");
      paramArrayOfByte.append(paramba.bM);
      eh.f("SharkProtocolQueue", paramArrayOfByte.toString());
      return;
    }
    catch (Exception paramba)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[shark_push]handleCallbackForPush(), callback exception: ");
      paramArrayOfByte.append(paramba);
      eh.a("SharkProtocolQueue", paramArrayOfByte.toString(), paramba);
    }
  }
  
  public static boolean a(ba paramba)
  {
    boolean bool = false;
    if (paramba == null) {
      return false;
    }
    if (paramba.dd != 0) {
      bool = true;
    }
    return bool;
  }
  
  private void b(int paramInt, cs.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.ln)
    {
      if (this.ln.size() > 0) {
        localArrayList.addAll(this.ln);
      }
      if (localArrayList.size() > 0)
      {
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((cy.a)((Iterator)???).next()).a(paramInt, paramb);
        }
      }
      return;
    }
  }
  
  private void b(long paramLong, ba paramba, byte[] paramArrayOfByte, dj<JceStruct, cm, c> paramdj)
  {
    Object localObject;
    if (paramba.data != null)
    {
      if (((c)paramdj.mU).lE) {
        try
        {
          paramArrayOfByte = cd.a(this.mContext, this.hF.ai().is.getBytes(), paramba.data, paramba.di);
          localObject = null;
        }
        catch (Exception localException1)
        {
          paramArrayOfByte = new StringBuilder();
          localObject = "[shark_push]handleCallbackForGift(), dataForReceive2JceBytes exception: ";
        }
      } else {
        for (;;)
        {
          paramArrayOfByte.append((String)localObject);
          paramArrayOfByte.append(localException1);
          eh.a("SharkProtocolQueue", paramArrayOfByte.toString(), localException1);
          break;
          if (paramdj.first == null) {
            break;
          }
          try
          {
            localObject = cd.a(this.mContext, this.hF.ai().is.getBytes(), paramba.data, (JceStruct)paramdj.first, true, paramba.di);
            paramArrayOfByte = null;
          }
          catch (Exception localException2)
          {
            paramArrayOfByte = new StringBuilder();
            localObject = "[shark_push]handleCallbackForGift(), dataForReceive2JceStruct exception: ";
          }
        }
      }
    }
    else
    {
      paramArrayOfByte = null;
      localObject = paramArrayOfByte;
    }
    try
    {
      if (((c)paramdj.mU).lE) {
        paramArrayOfByte = ((cn)paramdj.second).a(paramba.dc, paramLong, paramba.bM, paramArrayOfByte);
      } else {
        paramArrayOfByte = ((cm)paramdj.second).a(paramba.dc, paramLong, paramba.bM, (JceStruct)localObject);
      }
      if (paramArrayOfByte != null)
      {
        a(paramba.dc, ((Integer)paramArrayOfByte.second).intValue(), (JceStruct)paramArrayOfByte.mU);
        return;
      }
    }
    catch (Exception paramba)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[shark_push]handleCallbackForGift(), callback exception: ");
      paramArrayOfByte.append(paramba);
      eh.a("SharkProtocolQueue", paramArrayOfByte.toString(), paramba);
    }
  }
  
  public static boolean b(ba paramba)
  {
    if (paramba == null) {
      return false;
    }
    if (paramba.dd != 0) {
      return false;
    }
    return (paramba.ds != null) && (paramba.ds.db != 0L);
  }
  
  public static db bZ()
  {
    if (li == null) {
      try
      {
        if (li == null) {
          li = new db();
        }
      }
      finally {}
    }
    return li;
  }
  
  public static boolean c(ba paramba)
  {
    boolean bool2 = false;
    if (paramba == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (!a(paramba))
    {
      bool1 = bool2;
      if (!b(paramba)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void f(int paramInt, String paramString)
  {
    Object localObject = new ArrayList();
    synchronized (this.ll)
    {
      if (this.ll.size() > 0)
      {
        ((List)localObject).addAll(this.ll);
        this.ll.clear();
      }
      synchronized (this.lm)
      {
        if (this.lm.size() > 0) {
          ((List)localObject).addAll(this.lm);
        }
        if (((List)localObject).size() > 0)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((ch)((Iterator)localObject).next()).e(paramInt, paramString);
          }
        }
        return;
      }
    }
  }
  
  public long a(boolean paramBoolean, int paramInt, ba paramba)
  {
    if ((paramba != null) && (b(paramba)))
    {
      long l1 = 0L;
      if (paramba.ds != null) {
        l1 = paramba.ds.db;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[shark_push]onPush(), ECmd: ");
      ((StringBuilder)???).append(paramba.bM);
      ((StringBuilder)???).append(" seqNo: ");
      ((StringBuilder)???).append(paramba.dc);
      ((StringBuilder)???).append(" pushId: ");
      ((StringBuilder)???).append(l1);
      ((StringBuilder)???).append(" isTcpChannel: ");
      ((StringBuilder)???).append(paramBoolean);
      eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
      a(l1, paramba.bM, paramInt, paramba.dc, -1000000001);
      if (paramba.df != 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[shark_push]onPush(), push with error, drop it, ECmd: ");
        ((StringBuilder)???).append(paramba.bM);
        ((StringBuilder)???).append(" seqNo: ");
        ((StringBuilder)???).append(paramba.dc);
        ((StringBuilder)???).append(" pushId: ");
        ((StringBuilder)???).append(l1);
        ((StringBuilder)???).append(" isTcpChannel: ");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append(" retCode: ");
        ((StringBuilder)???).append(paramba.df);
        eh.h("SharkProtocolQueue", ((StringBuilder)???).toString());
        return -1L;
      }
      if (this.kR.b(Long.valueOf(l1)))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[shark_push]onPush(), push duplicate, drop it, ECmd: ");
        ((StringBuilder)???).append(paramba.bM);
        ((StringBuilder)???).append(" seqNo: ");
        ((StringBuilder)???).append(paramba.dc);
        ((StringBuilder)???).append(" pushId: ");
        ((StringBuilder)???).append(l1);
        eh.g("SharkProtocolQueue", ((StringBuilder)???).toString());
        return -1L;
      }
      this.kR.push(Long.valueOf(l1));
      synchronized (this.kq)
      {
        Object localObject2 = (dj)this.kq.get(Integer.valueOf(paramba.bM));
        if (localObject2 == null)
        {
          ??? = this.kP;
          try
          {
            List localList = this.kP;
            long l2 = System.currentTimeMillis();
            byte[] arrayOfByte = this.hF.ai().is.getBytes();
            localObject2 = ???;
            ??? = localObject2;
            ??? = paramba;
          }
          finally
          {
            try
            {
              localList.add(new b(0, l2, l1, paramba, arrayOfByte));
              ??? = localObject2;
              paramInt = this.kP.size();
              ??? = localObject2;
              ??? = new StringBuilder();
              ((StringBuilder)???).append("[shark_push]onPush(), nobody listen to it, ECmd: ");
              ((StringBuilder)???).append(paramba.bM);
              ((StringBuilder)???).append(" seqNo: ");
              ((StringBuilder)???).append(paramba.dc);
              ((StringBuilder)???).append(" pushId: ");
              ((StringBuilder)???).append(l1);
              ((StringBuilder)???).append(" cache for ");
              ((StringBuilder)???).append(600);
              ((StringBuilder)???).append("s");
              ((StringBuilder)???).append(" pushSize: ");
              ((StringBuilder)???).append(paramInt);
              eh.g("SharkProtocolQueue", ((StringBuilder)???).toString());
              this.jy.removeMessages(3);
              if (paramInt >= 20) {
                this.jy.sendEmptyMessageDelayed(3, 2000L);
              }
              this.jy.sendEmptyMessageDelayed(3, 600000L);
              return -1L;
            }
            finally
            {
              for (;;)
              {
                paramba = (ba)???;
              }
            }
            localObject3 = finally;
            paramba = (ba)???;
          }
          throw localObject3;
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[shark_push]onPush(), someone listen to it, callback now, ECmd: ");
        ((StringBuilder)???).append(paramba.bM);
        ((StringBuilder)???).append(" seqNo: ");
        ((StringBuilder)???).append(paramba.dc);
        ((StringBuilder)???).append(" pushId: ");
        ((StringBuilder)???).append(l1);
        eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
        a(l1, paramba, this.hF.ai().is.getBytes(), localdj);
        if (localdj.mU != null) {
          return ((c)localdj.mU).t;
        }
        return -1L;
      }
    }
    return -1L;
  }
  
  public WeakReference<cw> a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, int paramInt4, JceStruct arg9, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt5, cj paramcj, ck paramck, long paramLong3, long paramLong4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendShark() cmdId: ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(" pushSeqNo: ");
    localStringBuilder.append(paramInt3);
    eh.e("SharkProtocolQueue", localStringBuilder.toString());
    if (paramInt3 > 0) {
      return a(paramInt3, paramLong1, paramInt4, ???, paramArrayOfByte, 1);
    }
    paramArrayOfByte = new d(paramInt1, paramInt2, paramLong2, paramInt4, ???, paramArrayOfByte, paramJceStruct2, paramInt5, paramcj, paramck);
    paramArrayOfByte.l = cu.bu().bm();
    paramArrayOfByte.p = paramLong3;
    paramArrayOfByte.q = paramLong4;
    synchronized (this.kQ)
    {
      this.kQ.add(paramArrayOfByte);
      cv.by().a(paramArrayOfByte.l, paramLong3, null);
      if (cx.iT) {
        this.jy.sendEmptyMessage(1);
      }
      return new WeakReference(paramArrayOfByte.o);
    }
  }
  
  public WeakReference<cw> a(int paramInt1, final int paramInt2, JceStruct paramJceStruct)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shark_push]sendGiftResp(): giftSeqNo: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" acmdId: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" respStruct: ");
    localStringBuilder.append(paramJceStruct);
    eh.f("SharkProtocolQueue", localStringBuilder.toString());
    if (paramInt2 == 156)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ip_list]sendGiftResp(): giftSeqNo: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" acmdId: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" respStruct: ");
      localStringBuilder.append(paramJceStruct);
      eh.i("SharkProtocolQueue", localStringBuilder.toString());
    }
    cx.bE().a(paramInt2, paramJceStruct, null, 0, new cj()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[shark_push]sendGiftResp()-onFinish() seqNo: ");
        localStringBuilder.append(paramAnonymousInt1);
        localStringBuilder.append(" cmdId: ");
        localStringBuilder.append(paramAnonymousInt2);
        localStringBuilder.append(" retCode: ");
        localStringBuilder.append(paramAnonymousInt3);
        localStringBuilder.append(" dataRetCode: ");
        localStringBuilder.append(paramAnonymousInt4);
        eh.f("SharkProtocolQueue", localStringBuilder.toString());
        if (paramInt2 == 156)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[ip_list]sendGiftResp()-onFinish() seqNo: ");
          localStringBuilder.append(paramAnonymousInt1);
          localStringBuilder.append(" cmdId: ");
          localStringBuilder.append(paramAnonymousInt2);
          localStringBuilder.append(" retCode: ");
          localStringBuilder.append(paramAnonymousInt3);
          localStringBuilder.append(" dataRetCode: ");
          localStringBuilder.append(paramAnonymousInt4);
          localStringBuilder.append(" resp: ");
          localStringBuilder.append(paramAnonymousJceStruct);
          eh.i("SharkProtocolQueue", localStringBuilder.toString());
        }
      }
    });
  }
  
  public WeakReference<cw> a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct, byte[] paramArrayOfByte, int paramInt3)
  {
    return a(paramInt1, paramLong, paramInt2, paramJceStruct, paramArrayOfByte, paramInt3, 0);
  }
  
  public WeakReference<cw> a(int paramInt1, long paramLong, int paramInt2, JceStruct arg5, byte[] paramArrayOfByte, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[shark_push]sendPushResp(), pushSeqNo: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" pushId: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" cmdId: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" result: ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" retCode: ");
    ((StringBuilder)localObject).append(paramInt4);
    eh.e("SharkProtocolQueue", ((StringBuilder)localObject).toString());
    localObject = new ak();
    ((ak)localObject).bM = paramInt2;
    ((ak)localObject).status = paramInt3;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((ak)localObject).bN = paramArrayOfByte;
    } else if (??? != null) {
      ((ak)localObject).bN = cp.b(???);
    }
    paramArrayOfByte = new d(0, 0, -1L, 1103, ???, cd.a((JceStruct)localObject), null, 1073741824, null, null);
    paramArrayOfByte.l = paramInt1;
    paramArrayOfByte.r = paramLong;
    paramArrayOfByte.m = paramInt4;
    synchronized (this.kQ)
    {
      this.kQ.add(paramArrayOfByte);
      if (cx.iT) {
        this.jy.sendEmptyMessage(1);
      }
      return new WeakReference(paramArrayOfByte.o);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("autoReplyPush()  pushId: ");
    ((StringBuilder)???).append(paramLong);
    ((StringBuilder)???).append(" cmdId: ");
    ((StringBuilder)???).append(paramInt1);
    ((StringBuilder)???).append(" serverSharkSeqNo: ");
    ((StringBuilder)???).append(paramInt2);
    ((StringBuilder)???).append(" serverSashimiSeqNo: ");
    ((StringBuilder)???).append(paramInt3);
    ((StringBuilder)???).append(" errCode: ");
    ((StringBuilder)???).append(paramInt4);
    eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
    d locald = new d(Process.myPid(), 0, 0L, paramInt1, null, new byte[0], null, 1073741824, null, null);
    locald.m = paramInt4;
    locald.l = paramInt3;
    locald.r = paramLong;
    synchronized (this.kQ)
    {
      this.kQ.add(locald);
      if (cx.iT) {
        this.jy.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, JceStruct paramJceStruct, int paramInt2, cm paramcm, boolean paramBoolean)
  {
    if (paramcm == null) {
      return;
    }
    synchronized (this.kq)
    {
      this.kq.put(Integer.valueOf(paramInt1), new dj(paramJceStruct, paramcm, new c(paramBoolean, paramLong)));
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("[shark_push]registerSharkPush(), for cmd: ");
      paramJceStruct.append(paramInt1);
      eh.e("SharkProtocolQueue", paramJceStruct.toString());
      if (cx.iT) {
        this.jy.obtainMessage(5, paramInt1, 0).sendToTarget();
      }
      return;
    }
  }
  
  public void a(ch paramch)
  {
    if (paramch == null) {
      return;
    }
    synchronized (this.lm)
    {
      if (!this.lm.contains(paramch)) {
        this.lm.add(paramch);
      }
      return;
    }
  }
  
  public void a(cy.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (!this.ln.contains(parama)) {
        this.ln.add(parama);
      }
      return;
    }
  }
  
  public void a(dl paramdl, long paramLong)
  {
    if (paramdl == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shark_vip] setVipRule(): ");
    localStringBuilder.append(paramdl);
    localStringBuilder.append(", valid time(ms): ");
    localStringBuilder.append(paramLong);
    eh.f("SharkProtocolQueue", localStringBuilder.toString());
    this.kS = paramdl;
    this.jy.removeMessages(6);
    if (paramLong > 0L) {
      this.jy.sendEmptyMessageDelayed(6, paramLong);
    }
  }
  
  public void at()
  {
    eh.f("SharkProtocolQueue", "[shark_init]initAsync()");
    this.hF = new cy(bc.n(), this.he, this, this, this, cx.bB(), cx.bC());
    this.jn = Executors.newSingleThreadExecutor();
    cv.by().b(this.he);
    this.jy.sendEmptyMessage(2);
  }
  
  public void av()
  {
    if (cx.iT)
    {
      this.hF.bO();
      return;
    }
    this.lb = true;
  }
  
  public long b(boolean paramBoolean, int paramInt, ba paramba)
  {
    if (paramba != null)
    {
      if (!c(paramba)) {
        return -1L;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[shark_push]onGotGift(), ECmd: ");
      ((StringBuilder)???).append(paramba.bM);
      ((StringBuilder)???).append(" seqNo: ");
      ((StringBuilder)???).append(paramba.dc);
      ((StringBuilder)???).append(" pushId: ");
      ((StringBuilder)???).append(0L);
      ((StringBuilder)???).append(" isTcpChannel: ");
      ((StringBuilder)???).append(paramBoolean);
      eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
      if (paramba.df != 0)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[shark_push]onGotGift(), gift with error, drop it, ECmd: ");
        ((StringBuilder)???).append(paramba.bM);
        ((StringBuilder)???).append(" seqNo: ");
        ((StringBuilder)???).append(paramba.dc);
        ((StringBuilder)???).append(" pushId: ");
        ((StringBuilder)???).append(0L);
        ((StringBuilder)???).append(" isTcpChannel: ");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append(" retCode: ");
        ((StringBuilder)???).append(paramba.df);
        eh.h("SharkProtocolQueue", ((StringBuilder)???).toString());
        return -1L;
      }
      synchronized (this.kq)
      {
        dj localdj = (dj)this.kq.get(Integer.valueOf(paramba.bM));
        if (localdj == null) {
          synchronized (this.kP)
          {
            this.kP.add(new b(1, System.currentTimeMillis(), 0L, paramba, this.hF.ai().is.getBytes()));
            paramInt = this.kP.size();
            ??? = new StringBuilder();
            ((StringBuilder)???).append("[shark_push]onGotGift(), nobody listen to it, ECmd: ");
            ((StringBuilder)???).append(paramba.bM);
            ((StringBuilder)???).append(" seqNo: ");
            ((StringBuilder)???).append(paramba.dc);
            ((StringBuilder)???).append(" cache for ");
            ((StringBuilder)???).append(600);
            ((StringBuilder)???).append("s");
            ((StringBuilder)???).append(" pushSize: ");
            ((StringBuilder)???).append(paramInt);
            eh.g("SharkProtocolQueue", ((StringBuilder)???).toString());
            this.jy.removeMessages(3);
            if (paramInt >= 20) {
              this.jy.sendEmptyMessageDelayed(3, 2000L);
            }
            this.jy.sendEmptyMessageDelayed(3, 600000L);
            return -1L;
          }
        }
        ??? = new StringBuilder();
        ((StringBuilder)???).append("[shark_push]onGotGift(), someone listen to it, callback now, ECmd: ");
        ((StringBuilder)???).append(paramba.bM);
        ((StringBuilder)???).append(" seqNo: ");
        ((StringBuilder)???).append(paramba.dc);
        eh.e("SharkProtocolQueue", ((StringBuilder)???).toString());
        b(0L, paramba, this.hF.ai().is.getBytes(), localdj);
        if (localdj.mU != null) {
          return ((c)localdj.mU).t;
        }
        return -1L;
      }
    }
    return -1L;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (cx.iT)
    {
      this.hF.b(paramInt1, paramInt2, paramInt3);
      return;
    }
    if (this.ld == null) {
      this.ld = new LinkedList();
    }
    this.ld.add(new cq(paramInt1, paramInt2, paramInt3));
  }
  
  public void b(ch paramch)
  {
    if (paramch == null) {
      return;
    }
    synchronized (this.lm)
    {
      if (this.lm.contains(paramch)) {
        this.lm.remove(paramch);
      }
      return;
    }
  }
  
  public void b(cy.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.ln)
    {
      if (this.ln.contains(parama)) {
        this.ln.remove(parama);
      }
      return;
    }
  }
  
  public void bH()
  {
    if (cx.iT)
    {
      this.hF.bH();
      return;
    }
    this.kW = true;
  }
  
  public cl bL()
  {
    return this.he;
  }
  
  public void bM()
  {
    if (cx.iT)
    {
      this.hF.bM();
      return;
    }
    this.kZ = true;
  }
  
  public void bN()
  {
    if (cx.iT)
    {
      this.hF.bN();
      return;
    }
    this.la = true;
  }
  
  void bY()
  {
    if (cx.iT)
    {
      this.jy.removeMessages(4);
      this.jy.sendEmptyMessage(4);
      return;
    }
    this.le = true;
  }
  
  public void c(cl paramcl)
  {
    eh.e("SharkProtocolQueue", "[shark_init]initSync()");
    this.he = paramcl;
    try
    {
      if (this.lo == null)
      {
        this.lo = new a(null);
        a.a(this.lo, this.mContext);
        eh.e("SharkProtocolQueue", "[shark_init][cu_guid][rsa_key] initSync(), register guid & rsakey event");
      }
      return;
    }
    finally {}
  }
  
  public void ca()
  {
    if (cx.iT)
    {
      this.hF.f(1000L);
      return;
    }
    this.kV = true;
  }
  
  public void cb()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cb();
      return;
    }
    this.kY = true;
  }
  
  public void cc()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cc();
      return;
    }
    this.lg = true;
  }
  
  public void cd()
  {
    if (!cx.ax()) {
      return;
    }
    if (cx.iT)
    {
      this.hF.bJ().cd();
      return;
    }
    this.lh = true;
  }
  
  public cm e(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.kq)
      {
        if (this.kq.containsKey(Integer.valueOf(paramInt1)))
        {
          cm localcm = (cm)((dj)this.kq.remove(Integer.valueOf(paramInt1))).second;
          return localcm;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public String getGuid()
  {
    cy localcy = this.hF;
    if (localcy == null) {
      return "";
    }
    return localcy.getGuid();
  }
  
  public void onReady()
  {
    if (cx.iT)
    {
      cy localcy = this.hF;
      if (localcy == null) {
        return;
      }
      localcy.onReady();
      return;
    }
    this.kX = true;
  }
  
  public void x(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (cx.iT)
      {
        this.hF.ba();
        return;
      }
      this.kU = true;
      return;
    }
    if (cx.iT)
    {
      this.hF.bK();
      return;
    }
    this.kT = true;
  }
  
  private final class a
    extends BroadcastReceiver
  {
    private boolean b;
    
    private a() {}
    
    private void a(Context paramContext)
    {
      if (!this.b) {
        try
        {
          localObject = paramContext.getPackageName();
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction(String.format("action.guid.got:%s", new Object[] { localObject }));
          localIntentFilter.addAction(String.format("action.rsa.got:%s", new Object[] { localObject }));
          localIntentFilter.addAction(String.format("action.reg.guid:%s", new Object[] { localObject }));
          localIntentFilter.addAction(String.format("action.up.rsa:%s", new Object[] { localObject }));
          localIntentFilter.addAction(String.format("action.d.a:%s", new Object[] { localObject }));
          paramContext.registerReceiver(this, localIntentFilter);
          this.b = true;
          return;
        }
        catch (Throwable paramContext)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[cu_guid] register: ");
          ((StringBuilder)localObject).append(paramContext);
          eh.a("SharkProtocolQueue", ((StringBuilder)localObject).toString(), paramContext);
          paramContext.printStackTrace();
        }
      }
    }
    
    public void onReceive(final Context paramContext, final Intent paramIntent)
    {
      final String str = paramIntent.getAction();
      if (paramIntent.getPackage().compareToIgnoreCase(bc.n().getPackageName()) != 0) {
        return;
      }
      ee.cT().addTask(new Runnable()
      {
        public void run()
        {
          String str3 = paramContext.getPackageName();
          Object localObject1 = String.format("action.guid.got:%s", new Object[] { str3 });
          Object localObject2 = String.format("action.rsa.got:%s", new Object[] { str3 });
          String str1 = String.format("action.reg.guid:%s", new Object[] { str3 });
          String str2 = String.format("action.up.rsa:%s", new Object[] { str3 });
          str3 = String.format("action.d.a:%s", new Object[] { str3 });
          int i;
          if (((String)localObject1).equals(str))
          {
            db.b(db.this).removeMessages(7);
            i = paramIntent.getIntExtra("k.rc", -1);
            localObject1 = paramIntent.getStringExtra("k.g");
            if ((i == 0) && (!cx.ax()))
            {
              eh.f("SharkProtocolQueue", "[cu_guid] doOnRecv(), !sendProcess, refreshGuid on recv broadcast");
              db.this.x(true);
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[cu_guid] doOnRecv(), notifyGuidGot on recv broadcast: ");
            ((StringBuilder)localObject2).append(str);
            eh.f("SharkProtocolQueue", ((StringBuilder)localObject2).toString());
            db.a(db.this, i, (String)localObject1);
            return;
          }
          if (((String)localObject2).equals(str))
          {
            i = paramIntent.getIntExtra("k.rc", -1);
            localObject1 = null;
            if (i == 0)
            {
              localObject2 = new cs.b();
              ((cs.b)localObject2).is = paramIntent.getStringExtra("k.r.k");
              ((cs.b)localObject2).ir = paramIntent.getStringExtra("k.r.s");
              localObject1 = localObject2;
              if (!cx.ax())
              {
                eh.f("SharkProtocolQueue", "[rsa_key] doOnRecv(), !sendProcess, refreshRsaKey on recv broadcast");
                db.this.x(false);
                localObject1 = localObject2;
              }
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[rsa_key] doOnRecv(), notifyRsaKeyGot on recv broadcast: ");
            ((StringBuilder)localObject2).append(str);
            eh.f("SharkProtocolQueue", ((StringBuilder)localObject2).toString());
            db.a(db.this, i, (cs.b)localObject1);
            return;
          }
          if (str1.equals(str))
          {
            if (cx.ax())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[rsa_key] doOnRecv(), triggerRegGuid on recv broadcast: ");
              ((StringBuilder)localObject1).append(str);
              eh.f("SharkProtocolQueue", ((StringBuilder)localObject1).toString());
              db.this.bH();
            }
          }
          else if (str2.equals(str))
          {
            if (cx.ax())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[rsa_key] doOnRecv(), triggerUpdateRsaKey on recv broadcast: ");
              ((StringBuilder)localObject1).append(str);
              eh.f("SharkProtocolQueue", ((StringBuilder)localObject1).toString());
              db.this.ca();
            }
          }
          else if ((str3.equals(str)) && (cx.ax())) {
            try
            {
              i = paramIntent.getIntExtra("k.sa", 0);
              if (i == 1)
              {
                localObject1 = paramIntent.getExtras();
                localObject2 = (dl)((Bundle)localObject1).getSerializable("v.r");
                long l = ((Bundle)localObject1).getLong("vt.m", 35000L);
                db.this.a((dl)localObject2, l);
                return;
              }
              if (i == 2)
              {
                db.this.bY();
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[shark_vip] doOnRecv(), setVipRule: ");
              ((StringBuilder)localObject2).append(localThrowable);
              eh.a("SharkProtocolQueue", ((StringBuilder)localObject2).toString(), localThrowable);
            }
          }
        }
      }, "GuidOrRsaKeyGotReceiver onRecv");
    }
  }
  
  private class b
  {
    long a;
    long b;
    ba c;
    byte[] d;
    int e = 0;
    
    public b(int paramInt, long paramLong1, long paramLong2, ba paramba, byte[] paramArrayOfByte)
    {
      this.e = paramInt;
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramba;
      this.d = paramArrayOfByte;
    }
  }
  
  public static class c
  {
    public boolean lE;
    public long t;
    
    public c(boolean paramBoolean, long paramLong)
    {
      this.lE = paramBoolean;
      this.t = paramLong;
    }
  }
  
  private class d
  {
    public int a;
    public int b;
    public long c;
    public int d;
    public JceStruct e;
    public byte[] f;
    public JceStruct g;
    public byte[] h;
    public int i;
    public cj j;
    public ck k;
    public int l;
    public int m;
    public int n;
    public cw o;
    public long p = -1L;
    public long q = 0L;
    public long r;
    public long s = System.currentTimeMillis();
    
    d(int paramInt1, int paramInt2, long paramLong, int paramInt3, JceStruct paramJceStruct1, byte[] paramArrayOfByte, JceStruct paramJceStruct2, int paramInt4, cj paramcj, ck paramck)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramLong;
      this.d = paramInt3;
      this.e = paramJceStruct1;
      this.f = paramArrayOfByte;
      this.g = paramJceStruct2;
      this.i = paramInt4;
      this.j = paramcj;
      this.k = paramck;
      this.o = new cw();
    }
    
    public boolean a()
    {
      long l2 = Math.abs(System.currentTimeMillis() - this.s);
      long l1 = this.p;
      if (l1 <= 0L) {
        l1 = 30000L;
      }
      boolean bool;
      if (l2 >= l1) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("cmdId|");
        localStringBuilder1.append(this.d);
        localStringBuilder1.append("|mIpcSeqNo|");
        localStringBuilder1.append(this.b);
        localStringBuilder1.append("|mSeqNo|");
        localStringBuilder1.append(this.l);
        localStringBuilder1.append("|pushId|");
        localStringBuilder1.append(this.r);
        localStringBuilder1.append("|mCallerIdent|");
        localStringBuilder1.append(this.c);
        localStringBuilder1.append("|callBackTimeout|");
        localStringBuilder1.append(this.p);
        localStringBuilder1.append("|time(s)|");
        localStringBuilder1.append(l2 / 1000L);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[ocean][time_out]SharkProtocolQueue.SharkSendTask.isTimeOut(), ");
        localStringBuilder2.append(localStringBuilder1.toString());
        eh.h("ocean", localStringBuilder2.toString());
      }
      return bool;
    }
  }
  
  private class e
    implements Runnable
  {
    private TreeMap<Integer, db.d> b = new TreeMap();
    private ArrayList<db.d> c = new ArrayList();
    private Handler d = new Handler(cx.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        dh localdh = (dh)paramAnonymousMessage.obj;
        ba localba = new ba();
        localba.df = -11050000;
        localba.dd = paramAnonymousMessage.what;
        if (localdh != null) {
          localba.bM = localdh.a;
        }
        paramAnonymousMessage = new StringBuilder();
        paramAnonymousMessage.append("接收超时：seq: ");
        paramAnonymousMessage.append(localba.dd);
        paramAnonymousMessage.append(" cmdId: ");
        paramAnonymousMessage.append(localba.bM);
        eh.h("SharkProtocolQueue", paramAnonymousMessage.toString());
        db.e.a(db.e.this, localba);
      }
    };
    private Handler e = new Handler(cx.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what != 1) {
          return;
        }
        ba localba = new ba();
        localba.df = -10000017;
        localba.dd = paramAnonymousMessage.arg1;
        localba.bM = paramAnonymousMessage.arg2;
        paramAnonymousMessage = new StringBuilder();
        paramAnonymousMessage.append("[time_out]发送请求超时： seq: ");
        paramAnonymousMessage.append(localba.dd);
        paramAnonymousMessage.append(" cmdId: ");
        paramAnonymousMessage.append(localba.bM);
        eh.h("SharkProtocolQueue", paramAnonymousMessage.toString());
        db.e.a(db.e.this, localba);
      }
    };
    
    private e() {}
    
    private void a(ba paramba)
    {
      this.d.removeMessages(paramba.dd);
      synchronized (this.b)
      {
        db.d locald = (db.d)this.b.get(Integer.valueOf(paramba.dd));
        if (locald == null) {
          return;
        }
        this.b.remove(Integer.valueOf(paramba.dd));
        Object localObject2 = paramba.data;
        ??? = null;
        Object localObject5 = null;
        Object localObject3 = null;
        Object localObject4;
        if ((localObject2 != null) && (paramba.df == 0))
        {
          try
          {
            if ((locald.k != null) && (locald.b > 0))
            {
              localObject2 = cd.a(db.u(db.this), db.v(db.this).ai().is.getBytes(), paramba.data, paramba.di);
              ??? = localObject3;
            }
            else
            {
              localObject2 = cd.a(db.u(db.this), db.v(db.this).ai().is.getBytes(), paramba.data, locald.g, false, paramba.di);
              ??? = localObject2;
              localObject2 = null;
            }
            localObject3 = localObject2;
            localObject5 = ???;
            if (??? != null) {
              break label279;
            }
            localObject3 = localObject2;
            localObject5 = ???;
            if (localObject2 != null) {
              break label279;
            }
            localObject3 = localObject2;
            localObject5 = ???;
            try
            {
              if (locald.g == null) {
                break label279;
              }
              paramba.df = bz.p(-11000300);
              localObject3 = localObject2;
              localObject5 = ???;
            }
            catch (Throwable localThrowable1) {}
            eh.b("SharkProtocolQueue", "sashimi decode fail", localThrowable2);
          }
          catch (Throwable localThrowable2)
          {
            localObject2 = null;
          }
          paramba.df = bz.p(-11000900);
          localObject4 = localObject2;
          localObject5 = ???;
        }
        else
        {
          localObject4 = null;
        }
        label279:
        if (locald.h != localObject4) {
          locald.h = localObject4;
        }
        if (locald.g != localObject5) {
          locald.g = localObject5;
        }
        try
        {
          a(paramba, locald, Integer.valueOf(paramba.bM), Integer.valueOf(paramba.df), Integer.valueOf(paramba.dg));
          return;
        }
        catch (Exception paramba)
        {
          eh.a("SharkProtocolQueue", "callback crash", paramba);
          return;
        }
      }
    }
    
    private void a(ba paramba, final db.d paramd, final Integer paramInteger1, Integer paramInteger2, final Integer paramInteger3)
    {
      paramd.o.setState(2);
      final int i = bz.p(paramInteger2.intValue());
      if (paramba == null)
      {
        cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramd.l, paramba, 30, i);
        cv.by().x(paramd.l);
      }
      else
      {
        cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramba.dd, paramba, 30, i);
        cv.by().x(paramba.dd);
      }
      if ((paramd.j == null) && (paramd.k == null)) {
        return;
      }
      int j = bv.k(paramd.i);
      if (j != 8)
      {
        if (j != 16)
        {
          paramba = new Runnable()
          {
            public void run()
            {
              if ((paramd.k != null) && (paramd.b > 0))
              {
                paramd.k.a(paramd.a, paramd.b, paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.h);
                return;
              }
              paramd.j.onFinish(paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.g);
            }
          };
          if ((paramInteger1.intValue() != 2016) && (paramInteger1.intValue() != 12016))
          {
            ee.cT().addTask(paramba, "shark callback");
            return;
          }
          ee.cT().addUrgentTask(paramba, "shark callback(urgent)");
          return;
        }
        if ((paramd.k != null) && (paramd.b > 0))
        {
          paramd.k.a(paramd.a, paramd.b, paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.h);
          return;
        }
        paramd.j.onFinish(paramd.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramd.g);
        return;
      }
      paramba = db.w(db.this).obtainMessage(11, new Object[] { paramd, paramInteger1, Integer.valueOf(i), paramInteger3 });
      db.w(db.this).sendMessage(paramba);
    }
    
    private void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ba> paramArrayList)
    {
      if (paramInt1 == 0)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          ba localba = (ba)paramArrayList.next();
          if (a(localba.dd))
          {
            a(localba);
          }
          else if (db.b(localba))
          {
            db.this.a(paramBoolean, paramInt2, localba);
          }
          else if (db.c(localba))
          {
            db.this.b(paramBoolean, paramInt2, localba);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("No callback xx: cmd : ");
            localStringBuilder.append(localba.bM);
            localStringBuilder.append(" seqNo : ");
            localStringBuilder.append(localba.dc);
            localStringBuilder.append(" refSeqNo : ");
            localStringBuilder.append(localba.dd);
            eh.g("SharkProtocolQueue", localStringBuilder.toString());
          }
        }
      }
      b(paramInt1);
    }
    
    private void b(int paramInt)
    {
      Object localObject2 = a();
      synchronized (this.b)
      {
        this.b.clear();
        ??? = ((Set)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          try
          {
            a(null, (db.d)((Map.Entry)localObject2).getValue(), Integer.valueOf(((db.d)((Map.Entry)localObject2).getValue()).d), Integer.valueOf(paramInt), Integer.valueOf(-1));
          }
          catch (Throwable localThrowable)
          {
            eh.b("SharkProtocolQueue", "callback crash", localThrowable);
          }
        }
        return;
      }
    }
    
    public Set<Map.Entry<Integer, db.d>> a()
    {
      synchronized (this.b)
      {
        TreeMap localTreeMap2 = (TreeMap)this.b.clone();
        return localTreeMap2.entrySet();
      }
    }
    
    public void a(Integer paramInteger, db.d paramd)
    {
      this.b.put(paramInteger, paramd);
    }
    
    public boolean a(int paramInt)
    {
      synchronized (this.b)
      {
        boolean bool = this.b.containsKey(Integer.valueOf(paramInt));
        return bool;
      }
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          localObject2 = new ArrayList();
          Iterator localIterator = a().iterator();
          l1 = 0L;
          if (localIterator.hasNext())
          {
            localObject3 = (Map.Entry)localIterator.next();
            if (((db.d)((Map.Entry)localObject3).getValue()).o.bA()) {
              continue;
            }
            if (((db.d)((Map.Entry)localObject3).getValue()).a())
            {
              this.e.obtainMessage(1, ((db.d)((Map.Entry)localObject3).getValue()).l, ((db.d)((Map.Entry)localObject3).getValue()).d).sendToTarget();
              continue;
            }
            ((db.d)((Map.Entry)localObject3).getValue()).o.setState(1);
            localas = new as();
            localas.bM = ((db.d)((Map.Entry)localObject3).getValue()).d;
            localas.dc = ((db.d)((Map.Entry)localObject3).getValue()).l;
            localas.de = ((db.d)((Map.Entry)localObject3).getValue()).c;
            localas.dd = 0;
            localas.data = null;
            if (((db.d)((Map.Entry)localObject3).getValue()).f != null)
            {
              localObject1 = ((db.d)((Map.Entry)localObject3).getValue()).f;
              localObject1 = cd.a(db.u(db.this), (byte[])localObject1, localas.bM, localas);
              localas.data = ((byte[])localObject1);
            }
            else
            {
              localObject1 = ((db.d)((Map.Entry)localObject3).getValue()).e;
              localObject1 = cd.a(db.u(db.this), (JceStruct)localObject1, localas.bM, localas);
              continue;
            }
            long l3 = ((db.d)((Map.Entry)localObject3).getValue()).p;
            long l2 = l3;
            if (l3 <= 0L) {
              l2 = 30000L;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[shark_timer]对seq: ");
            ((StringBuilder)localObject1).append(localas.dc);
            ((StringBuilder)localObject1).append("计时(ms): ");
            ((StringBuilder)localObject1).append(l2);
            eh.i("SharkProtocolQueue", ((StringBuilder)localObject1).toString());
            localObject1 = new dh(localas.bM);
            localObject1 = Message.obtain(this.d, localas.dc, localObject1);
            this.d.sendMessageDelayed((Message)localObject1, l2);
            if ((((db.d)((Map.Entry)localObject3).getValue()).i & 0x800) != 0) {
              localArrayList1.add(localas);
            } else if ((((db.d)((Map.Entry)localObject3).getValue()).i & 0x200) != 0) {
              localArrayList2.add(localas);
            } else if ((((db.d)((Map.Entry)localObject3).getValue()).i & 0x400) != 0) {
              localArrayList3.add(localas);
            } else {
              ((ArrayList)localObject2).add(localas);
            }
            cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
            if (((db.d)((Map.Entry)localObject3).getValue()).q <= l1) {
              continue;
            }
            l1 = ((db.d)((Map.Entry)localObject3).getValue()).q;
            continue;
          }
          localIterator = this.c.iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (db.d)localIterator.next();
            if (((db.d)localObject3).a())
            {
              if (((db.d)localObject3).d == 1103)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[time_out]发送push的业务回包超时： mSeqNo: ");
                ((StringBuilder)localObject1).append(((db.d)localObject3).l);
                ((StringBuilder)localObject1).append(" pushId: ");
                ((StringBuilder)localObject1).append(((db.d)localObject3).r);
                localObject1 = ((StringBuilder)localObject1).toString();
                eh.h("SharkProtocolQueue", (String)localObject1);
                continue;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[time_out]发送push的自动回包超时： mSeqNo: ");
              ((StringBuilder)localObject1).append(((db.d)localObject3).l);
              ((StringBuilder)localObject1).append(" pushId: ");
              ((StringBuilder)localObject1).append(((db.d)localObject3).r);
              ((StringBuilder)localObject1).append(" mCmdId: ");
              ((StringBuilder)localObject1).append(((db.d)localObject3).d);
              localObject1 = ((StringBuilder)localObject1).toString();
              continue;
            }
            localas = new as();
            localas.bM = ((db.d)localObject3).d;
            localas.dc = cu.bu().bm();
            localas.dd = ((db.d)localObject3).l;
            localas.data = null;
            localas.df = ((db.d)localObject3).m;
            localas.dg = ((db.d)localObject3).n;
            localObject1 = new ar();
            ((ar)localObject1).db = ((db.d)localObject3).r;
            localas.dh = ((ar)localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("resp push, seqNo: ");
            ((StringBuilder)localObject1).append(localas.dc);
            ((StringBuilder)localObject1).append(" pushId: ");
            ((StringBuilder)localObject1).append(((db.d)localObject3).r);
            eh.f("SharkProtocolQueue", ((StringBuilder)localObject1).toString());
          }
        }
        catch (Exception localException1)
        {
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          ArrayList localArrayList3;
          long l1;
          Object localObject3;
          as localas;
          Object localObject1;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("run shark task e: ");
          ((StringBuilder)localObject2).append(localException1.toString());
          eh.b("SharkProtocolQueue", ((StringBuilder)localObject2).toString(), localException1);
          b(-10001200);
        }
        try
        {
          if (((db.d)localObject3).f != null)
          {
            localObject1 = ((db.d)localObject3).f;
            localObject1 = cd.a(db.u(db.this), (byte[])localObject1, localas.bM, localas);
            localas.data = ((byte[])localObject1);
          }
          else
          {
            localObject1 = ((db.d)localObject3).e;
            localObject1 = cd.a(db.u(db.this), (JceStruct)localObject1, localas.bM, localas);
            continue;
          }
        }
        catch (Exception localException2)
        {
          continue;
          continue;
        }
        if ((((db.d)localObject3).i & 0x800) != 0) {
          localArrayList1.add(localas);
        } else if ((((db.d)localObject3).i & 0x200) != 0) {
          localArrayList2.add(localas);
        } else if ((((db.d)localObject3).i & 0x400) != 0) {
          localArrayList3.add(localas);
        } else {
          ((ArrayList)localObject2).add(localas);
        }
        cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
        continue;
        if (localArrayList1.size() > 0) {
          db.v(db.this).a(2048, l1, true, localArrayList1, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
        }
        if (localArrayList2.size() > 0) {
          db.v(db.this).a(512, l1, true, localArrayList2, new cy.b()
          {
            public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
            {
              db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
            }
          });
        }
        if (localArrayList3.size() <= 0) {
          break label1337;
        }
        db.v(db.this).a(1024, l1, true, localArrayList3, new cy.b()
        {
          public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
          {
            db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
          }
        });
        if (((ArrayList)localObject2).size() <= 0) {
          break label1331;
        }
        db.v(db.this).a(0, l1, true, (ArrayList)localObject2, new cy.b()
        {
          public void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
          {
            db.e.a(db.e.this, paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayList);
          }
        });
        return;
      }
      label1331:
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.db
 * JD-Core Version:    0.7.0.1
 */