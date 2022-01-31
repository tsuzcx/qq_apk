package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class ic
  extends Handler
{
  public ic(di paramdi, Looper paramLooper)
  {
    super(paramLooper);
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
      synchronized (di.d(this.a))
      {
        localObject12 = (id)di.e(this.a).poll();
        if ((localObject12 == null) || (((id)localObject12).c == null))
        {
          eh.g("TmsTcpManager", "[tcp_control]no task for send");
          return;
        }
      }
      j = 0;
      ??? = null;
      localObject11 = null;
      Object localObject2 = null;
      if (((id)localObject12).c.bP())
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
          ???.ml = String.valueOf(cd.e(di.m(this.a)));
          ???.mn = l1;
          ???.mo = di.g(this.a).cB();
          ???.errorCode = j;
          ???.g(di.l(this.a));
        }
        if ((j == 0) || (j == -11))
        {
          df.a(((id)localObject12).c, 14, j, 0);
          synchronized (di.d(this.a))
          {
            if (!di.e(this.a).isEmpty()) {
              di.a(this.a, 0, null, 0, 0L, true);
            }
            return;
          }
        }
      }
      else
      {
        if ((!((id)localObject12).c.bR()) && (!((id)localObject12).c.jM)) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            if (di.f(this.a) == 1)
            {
              if (!di.g(this.a).cH())
              {
                if (((id)localObject12).c.jL)
                {
                  eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] connection is broken, , ignore heartbeat");
                  return;
                  i = 0;
                  continue;
                }
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] connection is broken, wait and resend fp");
                di.a(this.a, ((id)localObject12).c);
                synchronized (di.d(this.a))
                {
                  di.h(this.a).add(localObject12);
                  di.a(this.a, 11, "conn_broken_didnt_monitored", 0, 0L, true);
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
          if (di.f(this.a) == 2)
          {
            if (((id)localObject12).c.jL)
            {
              eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] sending fp, ignore heartbeat");
              return;
            }
            eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] sending fp, enqueue this task and wait");
            di.b(this.a, ((id)localObject12).c);
            synchronized (di.d(this.a))
            {
              di.h(this.a).add(localObject12);
              return;
            }
          }
          i = j;
          if (di.f(this.a) == 0)
          {
            if (((id)localObject12).c.jL)
            {
              eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] fp not sent, ignore heartbeat");
              return;
            }
            eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] fp not sent, send fp & enqueue this task");
            di.a(this.a, ((id)localObject12).c);
            synchronized (di.d(this.a))
            {
              di.h(this.a).add(localObject12);
              di.a(this.a, 11, "others_depend_on_fp", 0, 0L, true);
              return;
            }
            if (di.i(this.a))
            {
              di.a(this.a, false);
              eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 1: reconnect");
              j = di.a(this.a, "disconnected_before_send");
              i = j;
              if (!((id)localObject12).c.jM)
              {
                di.a(this.a, (byte)0);
                eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 2: not fp, mark fp_not_send");
                i = j;
              }
            }
            else if (!di.g(this.a).cH())
            {
              eh.g("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] not connected, 1: connect");
              j = di.j(this.a);
              i = j;
              if (!((id)localObject12).c.jM)
              {
                di.a(this.a, (byte)0);
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
        if (((id)localObject12).c.jT != null)
        {
          localObject7 = localObject11;
          if (((id)localObject12).c.jT.size() > 0)
          {
            localObject11 = ((id)localObject12).c.jT.iterator();
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
      ??? = cd.a(((id)localObject12).c, true, di.k(this.a).getGuid(), di.l(this.a));
      if (??? == null)
      {
        eh.g("TmsTcpManager", "[tcp_control][http_control][shark_v4]handleMessage(), ConverterUtil.createSendBytes() return null!");
        i = -1500;
        l1 = 0L;
        ??? = (Message)localObject7;
        break label178;
      }
      l1 = System.currentTimeMillis();
      localObject11 = ((id)localObject12).b;
      if (localObject11 == null) {
        j = di.g(this.a).a(((id)localObject12).c, ???);
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
        if (((id)localObject12).c == null) {
          break;
        }
        ((id)localObject12).c.jW = true;
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
        j = di.g(this.a).a(((id)localObject12).c, ???);
        ((cw)localObject11).setState(2);
      }
      df.a(((id)localObject12).c, 14, j, 0);
      di.a(this.a, (id)localObject12, j);
      localObject7 = new LinkedList();
      synchronized (di.d(this.a))
      {
        localObject11 = (id)di.e(this.a).poll();
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
        id localid = (id)???.next();
        localObject11 = localid.b;
        if (localObject11 != null) {
          ((cw)localObject11).setState(2);
        }
        di.a(this.a, localid, j);
      }
      eh.e("TmsTcpManager", "[tcp_control][f_p] handle: MSG_ON_CHANGE_TO_CONNECTED");
      if (di.b(this.a).cg() <= 0)
      {
        eh.e("TmsTcpManager", "[tcp_control][f_p] handle connected msg: ref connt <= 0, no need to reconnect");
        return;
      }
      if (di.a(this.a) < 3)
      {
        eh.e("TmsTcpManager", "[tcp_control][f_p] handle connected msg, ref count: " + di.b(this.a).cg() + ", wait for network become stable and send fp in: " + di.b(this.a).aq().aT + "s");
        di.c(this.a);
        di.a(this.a, 11, "delay_fp_network_connected", 0, 1000L * di.b(this.a).aq().aT, true);
        return;
      }
      eh.g("TmsTcpManager", "[tcp_control][f_p] handle connected msg, ref count: " + di.b(this.a).cg() + ", mReconnectTimes over limit: " + di.a(this.a));
      return;
      i = ???.arg1;
      ??? = "" + ???.obj;
      eh.f("TmsTcpManager", "[tcp_control] handle msg: MSG_DELAY_SEND_FIRST_PKG, retryTimes: " + i + " reason: " + ???);
      di.a(this.a, i, ???);
      return;
      if (di.f(this.a) == 1)
      {
        i = ???.arg1;
        ??? = "" + ???.obj;
        eh.f("TmsTcpManager", "[tcp_control] handle msg: MSG_SEND_HB, retryTimes: " + i + " reason: " + ???);
        di.b(this.a, i, ???);
        return;
      }
      eh.g("TmsTcpManager", "[tcp_control][f_p][h_b]handle msg: MSG_SEND_HB, fp not sent, donnot send hb!");
      return;
      synchronized (di.d(this.a))
      {
        if ((di.h(this.a) == null) || (di.h(this.a).size() <= 0)) {
          return;
        }
      }
      ??? = (LinkedList)di.h(this.a).clone();
      di.h(this.a).clear();
      eh.g("TmsTcpManager", "[tcp_control][f_p]fp too frequency, waiting tasks count: " + ((LinkedList)???).size());
      ??? = ((LinkedList)???).iterator();
      while (???.hasNext())
      {
        ??? = (id)???.next();
        if ((??? != null) && (((id)???).c != null) && (((id)???).c.jT != null) && (((id)???).c.jT.size() > 0))
        {
          localObject11 = ((id)???).c.jT.iterator();
          while (((Iterator)localObject11).hasNext())
          {
            localObject12 = (as)((Iterator)localObject11).next();
            if (localObject12 != null) {
              cv.by().a("TmsTcpManager", ((as)localObject12).bM, ((as)localObject12).dc, (as)localObject12, 10, -40001300, null);
            }
          }
          di.a(this.a, (id)???, -40001300);
        }
      }
      di.a(this.a, 3);
      synchronized (di.d(this.a))
      {
        if ((di.h(this.a) == null) || (di.h(this.a).size() <= 0)) {
          return;
        }
      }
      localObject11 = (LinkedList)di.h(this.a).clone();
      di.h(this.a).clear();
      eh.f("TmsTcpManager", "fp failed, waiting tasks count: " + ((LinkedList)localObject11).size());
      i = ???.arg1;
      ??? = ((LinkedList)localObject11).iterator();
      while (???.hasNext())
      {
        ??? = (id)???.next();
        if ((??? != null) && (((id)???).c != null) && (((id)???).c.jT != null) && (((id)???).c.jT.size() > 0))
        {
          localObject11 = ((id)???).c.jT.iterator();
          while (((Iterator)localObject11).hasNext())
          {
            localObject12 = (as)((Iterator)localObject11).next();
            if (localObject12 != null) {
              cv.by().a("TmsTcpManager", ((as)localObject12).bM, ((as)localObject12).dc, (as)localObject12, 9, -700000000 + i, null);
            }
          }
          di.a(this.a, (id)???, -700000000 + i);
        }
      }
      ??? = null;
      localObject11 = di.d(this.a);
      ??? = (Message)???;
      try
      {
        if (di.h(this.a) != null)
        {
          ??? = (Message)???;
          if (di.h(this.a).size() > 0)
          {
            ??? = (LinkedList)di.h(this.a).clone();
            di.h(this.a).clear();
          }
        }
        if ((??? == null) || (???.size() <= 0)) {
          break label2454;
        }
        eh.f("TmsTcpManager", "[tcp_control]fp success. send waiting for fp tasks: " + ???.size());
        synchronized (di.d(this.a))
        {
          ??? = ???.iterator();
          while (???.hasNext())
          {
            localObject11 = (id)???.next();
            if (localObject11 != null) {
              di.e(this.a).add(localObject11);
            }
          }
        }
      }
      finally {}
      di.a(this.a, 0, null, 0, 0L, true);
      for (;;)
      {
        eh.f("TmsTcpManager", "[tcp_control][h_b]restartHeartBeat after fp success");
        di.n(this.a);
        return;
        eh.f("TmsTcpManager", "[tcp_control]fp success, no task waiting for fp");
      }
      di.o(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ic
 * JD-Core Version:    0.7.0.1
 */