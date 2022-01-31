package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

class hb
  extends Handler
{
  hb(db paramdb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    int i;
    label358:
    hi localhi;
    ArrayList localArrayList2;
    switch (???.what)
    {
    default: 
    case 2: 
      do
      {
        return;
        cx.iT = true;
        eh.e("SharkProtocolQueue", "[shark_init]=========== MSG_INIT_FINISH ==========");
        synchronized (db.a(this.a))
        {
          i = db.a(this.a).size();
          if (i > 0) {
            db.b(this.a).sendEmptyMessage(1);
          }
          if (db.c(this.a)) {
            this.a.x(false);
          }
          if (db.d(this.a)) {
            this.a.x(true);
          }
          if (db.e(this.a)) {
            this.a.ca();
          }
          if (db.f(this.a)) {
            this.a.bH();
          }
          if (db.g(this.a)) {
            this.a.onReady();
          }
          if (db.h(this.a)) {
            this.a.cb();
          }
          if (db.i(this.a)) {
            this.a.bM();
          }
          if (db.j(this.a)) {
            this.a.bN();
          }
          if (db.k(this.a)) {
            this.a.av();
          }
          if (db.l(this.a)) {
            this.a.bY();
          }
          if (db.m(this.a) == null) {
            break label358;
          }
          ??? = db.m(this.a).iterator();
          while (???.hasNext())
          {
            fr localfr = (fr)???.next();
            if (localfr != null) {
              this.a.b(localfr.a, localfr.b, localfr.c);
            }
          }
        }
        db.a(this.a, null);
        if (db.n(this.a))
        {
          db.a(this.a, false);
          ??? = this.a.getGuid();
          if (!TextUtils.isEmpty(???))
          {
            eh.f("SharkProtocolQueue", "[cu_guid] notifyGuidGot on init finished");
            db.a(this.a, 0, ???);
          }
        }
        if (db.o(this.a)) {
          this.a.cc();
        }
      } while (!db.p(this.a));
      this.a.cd();
      return;
    case 1: 
      db.b(this.a).removeMessages(1);
      i = 0;
      localhi = new hi(this.a, null);
      localArrayList2 = new ArrayList();
    }
    label1807:
    for (;;)
    {
      Object localObject7;
      Object localObject8;
      synchronized (db.a(this.a))
      {
        localObject7 = db.a(this.a).iterator();
        if (((Iterator)localObject7).hasNext())
        {
          localObject8 = (hh)((Iterator)localObject7).next();
          boolean bool = true;
          if (db.q(this.a) != null) {
            bool = db.q(this.a).b(((hh)localObject8).d, ((hh)localObject8).c);
          }
          if ((((hh)localObject8).i & 0x40000000) == 0)
          {
            if (!((hh)localObject8).o.bA())
            {
              if (bool)
              {
                localhi.a(Integer.valueOf(((hh)localObject8).l), (hh)localObject8);
                i += 1;
                break label1807;
              }
              localArrayList2.add(localObject8);
              break label1807;
            }
            cv.by().w(((hh)localObject8).l);
            break label1807;
          }
          if (bool)
          {
            hi.a(localhi).add(localObject8);
            i += 1;
            break label1807;
          }
          localArrayList2.add(localObject8);
          break label1807;
        }
        db.a(this.a).clear();
        if (localArrayList2.size() > 0) {
          db.a(this.a).addAll(localArrayList2);
        }
        if (i <= 0) {
          break;
        }
        db.r(this.a).submit(localhi);
        return;
      }
      eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH");
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      for (;;)
      {
        synchronized (db.s(this.a))
        {
          if (db.s(this.a).size() <= 0) {
            break label889;
          }
          long l = System.currentTimeMillis();
          localObject7 = db.s(this.a).iterator();
          if (!((Iterator)localObject7).hasNext()) {
            break;
          }
          localObject8 = (hg)((Iterator)localObject7).next();
          if (l - ((hg)localObject8).a >= 600000L) {
            localArrayList1.add(localObject8);
          }
        }
        localArrayList2.add(localObject8);
      }
      db.s(this.a).clear();
      db.s(this.a).addAll(localArrayList2);
      label889:
      eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_EXPIRED_PUSH, expired: " + localObject3.size() + " remain: " + localArrayList2.size());
      if (localObject3.size() <= 0) {
        break;
      }
      ??? = localObject3.iterator();
      while (???.hasNext())
      {
        localObject4 = (hg)???.next();
        if (((hg)localObject4).e == 0)
        {
          eh.e("SharkProtocolQueue", "[shark_push]sendPushResp() for expired push, cmd: " + ((hg)localObject4).c.bM + " pushId: " + ((hg)localObject4).b);
          this.a.a(((hg)localObject4).c.dc, ((hg)localObject4).b, ((hg)localObject4).c.bM, null, null, -2, -1000000001);
        }
        else
        {
          eh.e("SharkProtocolQueue", "[shark_push]no need to sendPushResp() for expired gift, cmd: " + ((hg)localObject4).c.bM + " pushId: " + ((hg)localObject4).b);
        }
      }
      eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE");
      Object localObject4 = new ArrayList();
      for (;;)
      {
        synchronized (db.s(this.a))
        {
          if (db.s(this.a).size() > 0)
          {
            ((List)localObject4).addAll(db.s(this.a));
            db.s(this.a).clear();
          }
          eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CLEAR_PUSH_CACHE, " + ((List)localObject4).size() + " -> 0");
          if (((List)localObject4).size() <= 0) {
            break;
          }
          ??? = ((List)localObject4).iterator();
          if (!???.hasNext()) {
            break;
          }
          localObject4 = (hg)???.next();
          if (((hg)localObject4).e == 0)
          {
            eh.e("SharkProtocolQueue", "[shark_push]sendPushResp() on push cleared, cmd: " + ((hg)localObject4).c.bM + " pushId: " + ((hg)localObject4).b);
            this.a.a(((hg)localObject4).c.dc, ((hg)localObject4).b, ((hg)localObject4).c.bM, null, null, -2, -1000000001);
          }
        }
        eh.e("SharkProtocolQueue", "[shark_push]no need to sendPushResp() on gift cleared, cmd: " + localObject5.c.bM + " pushId: " + localObject5.b);
      }
      i = ???.arg1;
      eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CHECK_CACHED_PUSH for cmd: " + i);
      for (;;)
      {
        hg localhg;
        synchronized (db.t(this.a))
        {
          ??? = (dj)db.t(this.a).get(Integer.valueOf(i));
          localArrayList2 = new ArrayList();
          localObject7 = new ArrayList();
          synchronized (db.s(this.a))
          {
            if (db.s(this.a).size() <= 0) {
              break label1634;
            }
            localObject8 = db.s(this.a).iterator();
            if (!((Iterator)localObject8).hasNext()) {
              break;
            }
            localhg = (hg)((Iterator)localObject8).next();
            if (localhg.c.bM == i) {
              localArrayList2.add(localhg);
            }
          }
        }
        ((List)localObject7).add(localhg);
      }
      db.s(this.a).clear();
      db.s(this.a).addAll((Collection)localObject7);
      label1634:
      eh.e("SharkProtocolQueue", "[shark_push]handle MSG_CHECK_CACHED_PUSH, fixed: " + localArrayList2.size() + " remain: " + ((List)localObject7).size());
      if ((??? == null) || (localArrayList2 == null) || (localArrayList2.size() <= 0)) {
        break;
      }
      ee.cT().addTask(new hc(this, localArrayList2, i, ???), "shark callback: check cached push");
      return;
      eh.f("SharkProtocolQueue", "[shark_vip] handle: MSG_RESET_VIP_RULE, expired VipRule: " + db.q(this.a));
      db.a(this.a, null);
      eh.f("SharkProtocolQueue", "[shark_vip] triggle MSG_SEND_SHARK on VipRule expired ");
      if (!cx.iT) {
        break;
      }
      db.b(this.a).sendEmptyMessage(1);
      return;
      eh.f("SharkProtocolQueue", "[cu_guid]handle: MSG_REQUEST_REG_GUID");
      cf.f(bc.n());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hb
 * JD-Core Version:    0.7.0.1
 */