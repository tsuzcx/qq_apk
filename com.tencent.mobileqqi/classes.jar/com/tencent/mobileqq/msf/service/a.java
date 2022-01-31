package com.tencent.mobileqq.msf.service;

import android.os.DeadObjectException;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.c;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class a
  extends Thread
{
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  
  private boolean a(String paramString, b paramb)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (!paramb.g.isEmpty())
      {
        if (i <= 10) {
          break label31;
        }
        bool1 = true;
      }
      label31:
      MsfMessagePair localMsfMessagePair;
      do
      {
        return bool1;
        localMsfMessagePair = (MsfMessagePair)paramb.g.peek();
        bool1 = bool2;
      } while (localMsfMessagePair == null);
      if (localMsfMessagePair.fromServiceMsg.getAttribute("resp_needBootApp") != null) {}
      for (int j = 1;; j = 0)
      {
        Object localObject;
        if ((paramb.c() == null) && (j != 0))
        {
          bool1 = bool2;
          if (localMsfMessagePair.fromServiceMsg == null) {
            break;
          }
          localObject = BaseConstants.CMD_NeedBootPushCmdHeads;
          j = localObject.length;
          i = 0;
          label104:
          if (i >= j) {
            break label1098;
          }
          String str = localObject[i];
          if (!localMsfMessagePair.fromServiceMsg.getServiceCmd().startsWith(str)) {}
        }
        label968:
        label1098:
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if (i != 0)
            {
              paramb.a = false;
              paramb.c = false;
              i = d.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
              h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)d.c.get(paramString)).b(), i);
              if (QLog.isColorLevel()) {
                QLog.d(d.a, 2, "need boot app " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
              }
              MsfService.getCore().pushManager.h.a();
              paramb.d += 1L;
              bool1 = bool2;
              if (paramb.d <= 100L) {
                break;
              }
              localMsfMessagePair = (MsfMessagePair)paramb.g.poll();
              localObject = new HashMap();
              d.a((HashMap)localObject);
              ((HashMap)localObject).put("MsgType", localMsfMessagePair.fromServiceMsg.toString());
              ((HashMap)localObject).put("ProcName", paramString);
              ((HashMap)localObject).put("uin", localMsfMessagePair.fromServiceMsg.getUin());
              ((HashMap)localObject).put("appid", String.valueOf(localMsfMessagePair.fromServiceMsg.getAppId()));
              ((HashMap)localObject).put("MsgLeft", String.valueOf(paramb.g.size()));
              d.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject, true, false);
              paramb.d = 0L;
              return false;
              i += 1;
              break label104;
            }
            paramb.g.poll();
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(d.a, 2, "need boot app but not in CMD_NeedBootPushCmdHeads " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
            return false;
            if ((paramb.c == true) && (localMsfMessagePair.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
            {
              bool1 = bool2;
              if (SystemClock.elapsedRealtime() - paramb.b < 2000L) {
                break;
              }
              paramb.c = false;
              if (QLog.isColorLevel()) {
                QLog.d(d.a, 2, "half close timeout " + paramString + " isAppConnected " + paramb.a);
              }
            }
            if (!paramb.a) {
              break label968;
            }
            try
            {
              if (localMsfMessagePair.toServiceMsg == null)
              {
                paramb.c().onRecvPushResp(localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d(d.a, 2, "send push " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
              for (;;)
              {
                paramb.g.poll();
                break;
                paramb.c().onResponse(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d(d.a, 2, "send resp " + paramString + " to:" + localMsfMessagePair.toServiceMsg + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
            }
            catch (DeadObjectException localDeadObjectException)
            {
              paramb.d();
              if (j != 0)
              {
                i = d.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
                h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)d.c.get(paramString)).b(), i);
                MsfService.getCore().pushManager.h.a();
              }
              for (;;)
              {
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(d.a, 2, "found DeadObjectException " + localDeadObjectException.toString());
                return false;
                paramb.g.poll();
                if (QLog.isColorLevel()) {
                  QLog.d(d.a, 2, "found not NeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
                }
              }
            }
            catch (Throwable localThrowable)
            {
              paramb.g.poll();
              localThrowable.printStackTrace();
              if (!QLog.isColorLevel()) {
                break label1109;
              }
            }
          }
          QLog.d(d.a, 2, "handle error " + localMsfMessagePair.toString() + " " + localMsfMessagePair.fromServiceMsg + " ", localThrowable);
          break label1109;
          if (j != 0)
          {
            i = d.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
            h.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)d.c.get(paramString)).b(), i);
            MsfService.getCore().pushManager.h.a();
            return false;
          }
          paramb.g.poll();
          if (!QLog.isColorLevel()) {
            break label1109;
          }
          QLog.d(d.a, 2, "found " + paramb.e + " notNeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
          break label1109;
        }
      }
      label1109:
      i += 1;
    }
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.c = true;
      this.b = false;
      this.a.notify();
      return;
    }
  }
  
  public void run()
  {
    for (;;)
    {
      if (this.c)
      {
        this.c = false;
        this.d = 0;
        ??? = d.c.keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          String str = (String)((Iterator)???).next();
          b localb = (b)d.c.get(str);
          if (localb != null)
          {
            if (a(str, localb)) {
              this.c = true;
            }
            this.d += localb.g.size();
          }
        }
      }
      this.b = true;
      synchronized (this.a)
      {
        boolean bool = this.b;
        if (!bool) {}
      }
      try
      {
        if (this.d == 0) {
          this.a.wait();
        }
        for (;;)
        {
          break;
          localObject2 = finally;
          throw localObject2;
          this.a.wait(600L);
          this.c = true;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a
 * JD-Core Version:    0.7.0.1
 */