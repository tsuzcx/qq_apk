package com.tencent.mobileqq.msf.service;

import android.os.DeadObjectException;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.e;
import com.tencent.mobileqq.msf.core.b.e.a;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.core.push.d;
import com.tencent.mobileqq.msf.core.push.f;
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
  private static final int e = 10;
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  
  private static boolean a(String paramString, b paramb)
  {
    int i = 0;
    int j;
    MsfMessagePair localMsfMessagePair1;
    label43:
    Object localObject1;
    boolean bool1;
    label65:
    Object localObject2;
    label95:
    boolean bool2;
    if (!paramb.h.isEmpty())
    {
      i += 1;
      j = i;
      if (i <= 10)
      {
        localMsfMessagePair1 = (MsfMessagePair)paramb.h.peek();
        if (localMsfMessagePair1 == null) {
          j = i;
        }
      }
      else
      {
        if (j <= 10) {
          break label864;
        }
        return true;
      }
      localObject1 = paramb.c();
      if (localObject1 == null)
      {
        bool1 = true;
        if (!bool1) {
          break label222;
        }
        bool1 = false;
        localObject1 = localMsfMessagePair1.fromServiceMsg.getServiceCmd();
        localObject2 = BaseConstants.CMD_NeedBootPushCmdHeads;
        int k = localObject2.length;
        j = 0;
        bool2 = bool1;
        if (j < k)
        {
          String str = localObject2[j];
          if ((localObject1 == null) || (!((String)localObject1).startsWith(str))) {
            break label215;
          }
          bool2 = true;
          paramb.a = false;
          paramb.d = false;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.S.AppProcessManager", 2, paramString + "'s callBack is null; " + (String)localObject1 + " is cared: " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      label193:
      if (!bool1) {
        paramb.h.poll();
      }
      for (;;)
      {
        for (;;)
        {
          break;
          bool1 = false;
          break label65;
          label215:
          j += 1;
          break label95;
          label222:
          if ((paramb.d == true) && (localMsfMessagePair1.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
          {
            j = i;
            if (SystemClock.elapsedRealtime() - paramb.c < 2000L) {
              break label43;
            }
            paramb.d = false;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramb.a);
            }
          }
          try
          {
            if (localMsfMessagePair1.toServiceMsg == null)
            {
              ((IMsfServiceCallbacker)localObject1).onRecvPushResp(localMsfMessagePair1.fromServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + " from:" + localMsfMessagePair1.fromServiceMsg);
              }
            }
            else
            {
              ((IMsfServiceCallbacker)localObject1).onResponse(localMsfMessagePair1.toServiceMsg, localMsfMessagePair1.fromServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "send resp " + paramString + " to:" + localMsfMessagePair1.toServiceMsg + " from:" + localMsfMessagePair1.fromServiceMsg);
              }
            }
          }
          catch (DeadObjectException localDeadObjectException)
          {
            bool2 = true;
            paramb.d();
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break label193;
            }
            QLog.d("MSF.S.AppProcessManager", 2, "DeadObjectException");
            bool1 = bool2;
            break label193;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.S.AppProcessManager", 2, localMsfMessagePair1.toString() + " " + localMsfMessagePair1.fromServiceMsg, localException);
            }
          }
        }
        break label193;
        if (localMsfMessagePair1.fromServiceMsg.getAttribute("resp_needBootApp") != null) {}
        for (bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.AppProcessManager", 2, "need boot " + bool1 + " " + paramString + " from:" + localMsfMessagePair1.fromServiceMsg);
          }
          if (!bool1) {
            break;
          }
          paramb.a(false, localMsfMessagePair1.fromServiceMsg.getUin());
          paramb.e += 1L;
          if (paramb.e > 100L)
          {
            MsfMessagePair localMsfMessagePair2 = (MsfMessagePair)paramb.h.poll();
            localObject2 = new HashMap();
            c.a((HashMap)localObject2);
            ((HashMap)localObject2).put("MsgType", localMsfMessagePair2.fromServiceMsg.toString());
            ((HashMap)localObject2).put("ProcName", paramString);
            ((HashMap)localObject2).put("uin", localMsfMessagePair2.fromServiceMsg.getUin());
            ((HashMap)localObject2).put("appid", String.valueOf(localMsfMessagePair2.fromServiceMsg.getAppId()));
            ((HashMap)localObject2).put("MsgLeft", String.valueOf(paramb.h.size()));
            c.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject2, true, false);
            paramb.e = 0L;
            if ((localMsfMessagePair1.fromServiceMsg != null) && (localMsfMessagePair1.fromServiceMsg.getServiceCmd() != null) && (localMsfMessagePair1.fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
              e.a().a(e.a.c, localMsfMessagePair1.fromServiceMsg.getWupBuffer(), 14);
            }
          }
          return false;
        }
        paramb.h.poll();
        if (i == 1) {
          paramb.a(true, localMsfMessagePair1.fromServiceMsg.getUin());
        }
      }
      label864:
      return false;
      j = i;
      break label43;
    }
  }
  
  private static boolean b(String paramString, b paramb)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (!paramb.h.isEmpty())
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
        localMsfMessagePair = (MsfMessagePair)paramb.h.peek();
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
          label101:
          if (i >= j) {
            break label1090;
          }
          String str = localObject[i];
          if (!localMsfMessagePair.fromServiceMsg.getServiceCmd().startsWith(str)) {}
        }
        label1090:
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if (i != 0)
            {
              paramb.a = false;
              paramb.d = false;
              i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
              g.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
              MsfService.getCore().pushManager.i.a();
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "need boot app " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
              }
              paramb.e += 1L;
              bool1 = bool2;
              if (paramb.e <= 100L) {
                break;
              }
              localMsfMessagePair = (MsfMessagePair)paramb.h.poll();
              localObject = new HashMap();
              c.a((HashMap)localObject);
              ((HashMap)localObject).put("MsgType", localMsfMessagePair.fromServiceMsg.toString());
              ((HashMap)localObject).put("ProcName", paramString);
              ((HashMap)localObject).put("uin", localMsfMessagePair.fromServiceMsg.getUin());
              ((HashMap)localObject).put("appid", String.valueOf(localMsfMessagePair.fromServiceMsg.getAppId()));
              ((HashMap)localObject).put("MsgLeft", String.valueOf(paramb.h.size()));
              c.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject, true, false);
              paramb.e = 0L;
              return false;
              i += 1;
              break label101;
            }
            paramb.h.poll();
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.S.AppProcessManager", 2, "need boot app but not in CMD_NeedBootPushCmdHeads " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
            return false;
            if ((paramb.d == true) && (localMsfMessagePair.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
            {
              bool1 = bool2;
              if (SystemClock.elapsedRealtime() - paramb.c < 2000L) {
                break;
              }
              paramb.d = false;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramb.a);
              }
            }
            if (!paramb.a) {
              break label962;
            }
            try
            {
              if (localMsfMessagePair.toServiceMsg == null)
              {
                paramb.c().onRecvPushResp(localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
              for (;;)
              {
                paramb.h.poll();
                break;
                paramb.c().onResponse(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send resp " + paramString + " to:" + localMsfMessagePair.toServiceMsg + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
            }
            catch (DeadObjectException localDeadObjectException)
            {
              paramb.d();
              if (j != 0)
              {
                i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
                if (c.c.get(paramString) != null)
                {
                  g.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
                  MsfService.getCore().pushManager.i.a();
                }
              }
              for (;;)
              {
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("MSF.S.AppProcessManager", 2, "found DeadObjectException " + localDeadObjectException.toString());
                return false;
                paramb.h.poll();
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "found not NeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
                }
              }
            }
            catch (Throwable localThrowable)
            {
              paramb.h.poll();
              localThrowable.printStackTrace();
              if (!QLog.isColorLevel()) {
                break label1100;
              }
            }
          }
          QLog.d("MSF.S.AppProcessManager", 2, "handle error " + localMsfMessagePair.toString() + " " + localMsfMessagePair.fromServiceMsg + " ", localThrowable);
          break label1100;
          label962:
          if (j != 0)
          {
            i = c.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
            g.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((b)c.c.get(paramString)).b(), i);
            MsfService.getCore().pushManager.i.a();
            return false;
          }
          paramb.h.poll();
          if (!QLog.isColorLevel()) {
            break label1100;
          }
          QLog.d("MSF.S.AppProcessManager", 2, "found " + paramb.f + " notNeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
          break label1100;
        }
      }
      label1100:
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
    c.f.d = false;
    while (this.c)
    {
      this.c = false;
      this.d = 0;
      ??? = c.c.keySet().iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        b localb = (b)c.c.get(str);
        if (localb != null)
        {
          if (a(str, localb)) {
            this.c = true;
          }
          this.d += localb.h.size();
        }
      }
    }
    c.f.a(2);
    this.b = true;
    for (;;)
    {
      synchronized (this.a)
      {
        boolean bool = this.b;
        if (bool) {}
        try
        {
          if (this.d == 0)
          {
            this.a.wait(61440L);
            this.c = true;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
      }
      this.a.wait(600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.a
 * JD-Core Version:    0.7.0.1
 */