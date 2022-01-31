package com.tencent.mobileqq.msf.core.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.msf.service.protocol.a.b;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  public static final String a = "StatSvc.register";
  public static final String b = "MSF.C.PushManager:PushCoder";
  static String f;
  static boolean i = false;
  public static final String j = "com.tencent.mobileqq.msf.WatchdogForInfoLogin";
  private static String k = "SvcReqRegister";
  private static String l = "PushService";
  private static byte m = 0;
  private static String o = "PullUnreadMsgCount";
  private static String p = "MessageSvc";
  private static String q = "SvcReqGet";
  private static String r = "PushService";
  private static final BroadcastReceiver s;
  e c;
  volatile boolean d = false;
  int e = 0;
  long g = 0L;
  int h = 0;
  private final String n = "unrtime";
  private int t = 0;
  private long u = 0L;
  private int v = 0;
  
  static
  {
    f = "StatSvc.get";
    s = new d();
  }
  
  public c(e parame)
  {
    this.c = parame;
  }
  
  private void c(String paramString)
  {
    e.l = true;
    a();
    NetConnInfoCenterImpl.callQQProcess(paramString);
  }
  
  long a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("unrtime", 0).getLong(paramString, 0L);
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (this.u == 0L) {
      this.u = l1;
    }
    if ((this.v >= 5) && (l1 - this.u < 600000L))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog mStartWatchdogForInfoLoginRetryCount:" + this.v + " time:" + (l1 - this.u));
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog launch QQ Process too much stop.");
      }
      return;
    }
    if (this.v == 5)
    {
      this.v = 0;
      this.u = l1;
    }
    this.v += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:" + this.t);
    }
    if (!i)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      BaseApplication.getContext().registerReceiver(s, (IntentFilter)localObject);
      i = true;
    }
    MsfService.getCore().mbIsInfoLoginGetted.set(false);
    this.t = 0;
    Object localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
    localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
    ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
  }
  
  void a(a parama, ToServiceMsg paramToServiceMsg, boolean paramBoolean, j paramj)
  {
    if (parama.k == null) {}
    do
    {
      return;
      if ((!com.tencent.mobileqq.msf.core.a.a.v()) || (com.tencent.mobileqq.msf.core.a.a.a(parama.k.uin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, parama.k.uin + " is booting and can not autoRegisterPush,return.");
    return;
    boolean bool = a(paramj);
    if ((!bool) && (!paramBoolean) && (this.d) && (System.currentTimeMillis() - parama.e < 30000L))
    {
      parama = new StringBuilder().append("also send pushRegister, return. ");
      if (!bool)
      {
        bool = true;
        parama = parama.append(bool).append(" ");
        if (paramBoolean) {
          break label179;
        }
      }
      label179:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("MSF.C.PushManager:PushCoder", 1, paramBoolean + " " + this.d);
        return;
        bool = false;
        break;
      }
    }
    if (paramBoolean) {}
    try
    {
      a(paramToServiceMsg.getUin(), System.currentTimeMillis());
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "ConfigManager.isAutoStarting():" + com.tencent.mobileqq.msf.core.a.a.v());
      }
      try
      {
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setServantName(l);
        ((UniPacket)localObject2).setFuncName(k);
        localObject1 = new f();
        ((f)localObject1).c = m;
        ((f)localObject1).b = parama.c;
        ((f)localObject1).a = Long.parseLong(parama.k.uin);
        ((f)localObject1).e = parama.k.iStatus;
        ((f)localObject1).i = parama.k.bKikPC;
        ((f)localObject1).j = parama.k.bKikWeak;
        ((f)localObject1).k = parama.k.timeStamp;
        if ((paramj == j.b) || (paramj == j.g)) {
          break label1021;
        }
        if (paramj != j.h) {
          break label848;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1;
          int i1;
          ToServiceMsg localToServiceMsg;
          long l1;
          long l2;
          long l3;
          QLog.d("MSF.C.PushManager:PushCoder", 1, "send registerPush error " + parama, parama);
          continue;
          if (NetConnInfoCenterImpl.isWifiConn())
          {
            localException1.m = 1;
            continue;
            localException2.setMsfCommand(MsfCommand._msf_RegPush);
            continue;
            this.d = true;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " register push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + localException1.o + " timeStamp:" + localException1.k);
            continue;
            i1 = 0;
          }
        }
      }
      ((f)localObject1).o = ((byte)i1);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ((f)localObject1).l = Integer.parseInt(Build.VERSION.SDK);
          if (!NetConnInfoCenterImpl.isMobileConn()) {
            break;
          }
          ((f)localObject1).m = 0;
          ((f)localObject1).q = NetConnInfoCenter.GUID;
          ((f)localObject1).t = Build.MODEL;
          ((f)localObject1).u = Build.MODEL;
          ((f)localObject1).v = Build.VERSION.RELEASE;
          ((UniPacket)localObject2).put(k, localObject1);
          localObject2 = ((UniPacket)localObject2).encode();
          localToServiceMsg = new ToServiceMsg("", parama.k.uin, "StatSvc.register");
          localToServiceMsg.setAppId(parama.a);
          if (paramToServiceMsg != null)
          {
            localToServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
            localToServiceMsg.addAttribute("to_srcCmd", paramToServiceMsg.getServiceCmd());
          }
          localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
          localToServiceMsg.putWupBuffer((byte[])localObject2);
          localToServiceMsg.setTimeout(30000L);
          localToServiceMsg.addAttribute("regPushReason", paramj.toString());
          if (!paramBoolean) {
            break label910;
          }
          localToServiceMsg.setMsfCommand(MsfCommand._msf_UnRegPush);
          MsfSdkUtils.addToMsgProcessName(parama.b, localToServiceMsg);
          e.n = true;
          this.c.b.sendSsoMsg(localToServiceMsg);
          parama.e = System.currentTimeMillis();
          if (!paramBoolean) {
            break label921;
          }
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " unregister push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + ((f)localObject1).o);
          this.c.a();
          return;
          l1 = a(paramToServiceMsg.getUin());
          if (l1 != 0L)
          {
            l2 = System.currentTimeMillis();
            l3 = l2 - l1;
            if (l3 > 0L)
            {
              l3 /= 1000L;
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("unRegtime", String.valueOf(l1));
              ((HashMap)localObject1).put("now", String.valueOf(l2));
              ((HashMap)localObject1).put("uin", paramToServiceMsg.getUin());
              this.c.b.getStatReporter().a("Msf.RegInterTime", true, l3, 0L, (Map)localObject1, true, false);
            }
            a(paramToServiceMsg.getUin(), 0L);
            continue;
            localException1 = localException1;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "get reginterv error " + localException1, localException1);
          }
        }
        label848:
        i1 = 1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  void a(a parama, boolean paramBoolean)
  {
    if ((com.tencent.mobileqq.msf.core.a.a.t) && (!paramBoolean))
    {
      long l1 = this.c.g() + this.c.e();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "sendMsgPushQuery, check time now=" + e.f.format(Long.valueOf(System.currentTimeMillis())) + ", shouldSendQueryTime=" + e.f.format(Long.valueOf(l1)));
      }
      if (System.currentTimeMillis() < l1) {
        this.c.a(l1 - System.currentTimeMillis());
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (parama.k != null) {
          if ((parama.k.uin != null) && (parama.c > 0L))
          {
            UniPacket localUniPacket = new UniPacket(true);
            localUniPacket.setServantName(r);
            localUniPacket.setFuncName(q);
            Object localObject = new com.tencent.msf.service.protocol.push.d();
            ((com.tencent.msf.service.protocol.push.d)localObject).b = parama.c;
            ((com.tencent.msf.service.protocol.push.d)localObject).a = Long.parseLong(parama.k.uin);
            ((com.tencent.msf.service.protocol.push.d)localObject).d = parama.k.iStatus;
            String str = this.c.c + "|" + NetConnInfoCenterImpl.getSystemNetworkType() + "|" + NetConnInfoCenterImpl.getCurrentAPN() + "|" + (System.currentTimeMillis() - this.g);
            ((com.tencent.msf.service.protocol.push.d)localObject).c = str;
            ((com.tencent.msf.service.protocol.push.d)localObject).m = NetConnInfoCenter.GUID;
            ((com.tencent.msf.service.protocol.push.d)localObject).n = Build.MODEL;
            ((com.tencent.msf.service.protocol.push.d)localObject).o = Build.MODEL;
            ((com.tencent.msf.service.protocol.push.d)localObject).p = Build.VERSION.RELEASE;
            localUniPacket.put(q, localObject);
            localObject = new ToServiceMsg("", parama.k.uin, f);
            ((ToServiceMsg)localObject).setAppId(parama.a);
            ((ToServiceMsg)localObject).setTimeout(30000L);
            ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_queryPush);
            ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
            ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
            MsfSdkUtils.addToMsgProcessName(parama.b, (ToServiceMsg)localObject);
            try
            {
              this.c.b.sendSsoMsg((ToServiceMsg)localObject);
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.PushManager:PushCoder", 2, "send " + parama.k.uin + " query push id " + parama.c + " model:" + str);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + localException, localException);
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "pushUin is " + parama.k.uin + ", queryPushId is " + parama.c + ". no query");
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = com.tencent.mobileqq.msf.service.h.c();
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (b)localUniPacket.getByClass("resp_PullUnreadMsgCount", new b());
        if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.c > 0L) || (paramFromServiceMsg.d > 0L) || (paramFromServiceMsg.e > 0L)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg getted, call QQ process now resp.c2c_count:" + paramFromServiceMsg.c + " resp.group_count :" + paramFromServiceMsg.d + " resp.discuss_count" + paramFromServiceMsg.e);
          }
          c(paramToServiceMsg);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg getted,  resp.c2c_count:" + paramFromServiceMsg.c + " resp.group_count :" + paramFromServiceMsg.d + " resp.discuss_count" + paramFromServiceMsg.e);
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "handle unreadmsg error " + paramFromServiceMsg, paramFromServiceMsg);
      c(paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "UnreadMsg timeout, call QQ process now");
    }
    c(paramToServiceMsg);
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.d = false;
    long l3 = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
    long l4 = com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
    Object localObject2 = null;
    i3 = -1;
    l1 = -1L;
    i2 = -1;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.isSuccess()) {
          continue;
        }
        l1 = -1L;
        i1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        label334:
        label359:
        long l2;
        Object localObject1 = "unknown";
        continue;
        localObject1 = "unknown";
        continue;
        l1 = -1L;
        int i1 = 0;
        continue;
        boolean bool = false;
        continue;
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.getAttributes().containsKey("regPushReason"))) {
        continue;
      }
      localObject1 = (String)paramToServiceMsg.getAttribute("regPushReason");
      if (i1 == 0) {
        continue;
      }
      try
      {
        this.e = 0;
        this.g = System.currentTimeMillis();
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush unregister push succ " + MD5.toMD5(paramFromServiceMsg.getUin()));
          localObject4 = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
          localObject4 = (a)this.c.g.get(localObject4);
          if (localObject4 != null)
          {
            ((a)localObject4).i = this.c.b.nowSocketConnAdd;
            ((a)localObject4).f = System.currentTimeMillis();
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager:PushCoder", 2, "recv register push resp.iInterval=" + ((SvcRespRegister)localObject2).iHelloInterval + ", queryIntervTime=" + this.c.e() + ", next query time is " + e.f.format(Long.valueOf(System.currentTimeMillis() + ((SvcRespRegister)localObject2).iHelloInterval * 1000)));
            }
            this.c.v = (((SvcRespRegister)localObject2).iHelloInterval * 1000);
            this.c.a(this.c.e());
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush) {
            continue;
          }
          paramFromServiceMsg.setMsfCommand(MsfCommand.registerPush);
          if (!paramToServiceMsg.getAttributes().containsKey("to_srcCmd")) {
            continue;
          }
          this.c.b.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          localObject2 = this.c.b.getStatReporter();
          i1 = paramFromServiceMsg.getBusinessFailCode();
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
            continue;
          }
          bool = true;
          ((com.tencent.mobileqq.msf.core.d.j)localObject2).a(true, l3, i1, l4, bool, (String)localObject1);
          return;
          if ((paramFromServiceMsg.getWupBuffer() == null) || (paramFromServiceMsg.getWupBuffer().length < 5)) {
            continue;
          }
          localObject1 = new UniPacket(true);
          try
          {
            ((UniPacket)localObject1).decode(paramFromServiceMsg.getWupBuffer());
            localObject1 = (SvcRespRegister)((UniPacket)localObject1).getByClass("SvcRespRegister", new SvcRespRegister());
          }
          catch (Exception localException1)
          {
            try
            {
              l.b(((SvcRespRegister)localObject1).strClientIP);
              l.b(((SvcRespRegister)localObject1).iClientPort);
              i3 = ((SvcRespRegister)localObject1).bUpdateFlag;
              l2 = l1;
            }
            catch (Exception localException2)
            {
              int i4;
              Object localObject3;
              i1 = -1;
              i2 = -1;
              continue;
            }
            try
            {
              l1 = ((SvcRespRegister)localObject1).timeStamp;
              l2 = l1;
              i2 = ((SvcRespRegister)localObject1).cReplyCode;
            }
            catch (Exception localException3)
            {
              i1 = -1;
              i2 = i3;
              l1 = l2;
              continue;
            }
            try
            {
              NetConnInfoCenter.handleGetServerTimeResp(((SvcRespRegister)localObject1).lServerTime);
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.PushManager:PushCoder", 4, "pushresp servertime is " + ((SvcRespRegister)localObject1).lServerTime + this.c.b.timeFormatter.format(Long.valueOf(((SvcRespRegister)localObject1).lServerTime * 1000L)));
              }
              i1 = 1;
              localObject2 = localObject1;
            }
            catch (Exception localException4)
            {
              i1 = i2;
              i2 = i3;
              continue;
            }
            localException1 = localException1;
            i2 = -1;
            localObject1 = null;
            i1 = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "decodeRegisterPushResp error", localException1);
          }
          i4 = 0;
          i3 = i2;
          localObject3 = localObject1;
          i2 = i1;
          i1 = i4;
        }
        else
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush register push succ " + MD5.toMD5(paramFromServiceMsg.getUin()) + " bUpdateFlag:" + i3 + " timeStamp:" + l1 + " cReplyCode:" + i2);
          b(com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg));
          continue;
          localObject4 = this.c.b.getStatReporter();
        }
      }
      catch (Throwable localThrowable1) {}
    }
    i1 = paramFromServiceMsg.getBusinessFailCode();
    if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush) {}
    for (bool = true;; bool = false)
    {
      ((com.tencent.mobileqq.msf.core.d.j)localObject4).a(false, l3, i1, l4, bool, (String)localObject1);
      this.c.a(this.c.e());
      localThrowable1.printStackTrace();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "recv null register push resp, use default intervTime " + this.c.e());
      }
      this.c.a(this.c.e());
      break;
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
      {
        paramFromServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
        break label334;
      }
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      break label334;
      MsfSdkUtils.addFromMsgProcessName(com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg), paramFromServiceMsg);
      this.c.b.addRespToQuque(null, paramFromServiceMsg);
      break label359;
      e.n = false;
      com.tencent.mobileqq.msf.core.d.j localj;
      if (this.e > 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.e + ", set retry at " + e.f.format(Long.valueOf(this.c.e() + System.currentTimeMillis())));
        }
        this.e = 0;
        this.c.a(this.c.e());
        localj = this.c.b.getStatReporter();
        i1 = paramFromServiceMsg.getBusinessFailCode();
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
          break label1112;
        }
      }
      label1112:
      for (bool = true;; bool = false)
      {
        localj.a(false, l3, i1, l4, bool, (String)localObject1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.e + ",set retry at " + e.f.format(Long.valueOf(60000L + System.currentTimeMillis())));
        }
        this.e += 1;
        this.c.a(60000L);
        break;
      }
    }
  }
  
  void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  boolean a(j paramj)
  {
    return (paramj == j.b) || (paramj == j.g) || (paramj == j.h);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:" + this.t);
    }
    String str = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    Object localObject = str;
    if (str != null)
    {
      localObject = str;
      if (str.indexOf(":") > 0) {
        localObject = str.substring(0, str.indexOf(":"));
      }
    }
    localObject = (a)this.c.g.get(localObject);
    if ((localObject == null) || (((a)localObject).k == null) || (MsfService.getCore().getUinPushStatus(((a)localObject).k.uin) == 95)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback in 95 status do not start QQ Process");
      }
    }
    do
    {
      do
      {
        return;
        if (!MsfService.getCore().mbIsInfoLoginGetted.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mbIsInfoLoginGetted:" + MsfService.getCore().mbIsInfoLoginGetted + " ok");
      return;
      if (!com.tencent.mobileqq.msf.service.h.b()) {
        break;
      }
      if (this.t < 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.t);
        }
        this.t += 1;
        localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.t);
    return;
    QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback QQProcess killed restart now");
    c(com.tencent.mobileqq.msf.service.h.c());
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg);
    if ((a)this.c.g.get(str) != null)
    {
      System.currentTimeMillis();
      ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
      com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = new UniPacket(true);
          paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (com.tencent.msf.service.protocol.push.h)paramToServiceMsg.getByClass("SvcRespGet", new com.tencent.msf.service.protocol.push.h());
          this.h = 0;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "recv query push resp.iInterval=" + paramToServiceMsg.e + ", queryIntervTime=" + this.c.e() + ", next query time is " + e.f.format(Long.valueOf(System.currentTimeMillis() + paramToServiceMsg.e * 1000)));
          }
          this.c.v = (paramToServiceMsg.e * 1000);
          this.c.a(this.c.e());
          l.b(paramToServiceMsg.g);
          return;
        }
        this.c.a(180000L);
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        this.c.a(this.c.e());
      }
    }
  }
  
  void b(String paramString)
  {
    if (com.tencent.mobileqq.msf.service.h.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, paramString + " is running, no need send SvcRequestPullUnreadMsgCountReq");
      }
    }
    do
    {
      return;
      paramString = (a)this.c.g.get(paramString);
      if (MsfService.getCore().getUinPushStatus(paramString.k.uin) != 95) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "on recvOfflineMsg status don't start QQ");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "QQ not running, send SvcRequestPullUnreadMsgCountReq now");
    }
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName(p);
    localUniPacket.setFuncName(o);
    Object localObject = new com.tencent.msf.service.protocol.a.a();
    ((com.tencent.msf.service.protocol.a.a)localObject).a = true;
    ((com.tencent.msf.service.protocol.a.a)localObject).b = true;
    ((com.tencent.msf.service.protocol.a.a)localObject).c = true;
    localUniPacket.put("req_PullUnreadMsgCount", localObject);
    localObject = new ToServiceMsg("", paramString.k.uin, "MessageSvc.PullUnreadMsgCount");
    ((ToServiceMsg)localObject).setAppId(paramString.a);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).setNeedCallback(true);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    try
    {
      this.c.b.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + paramString, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.c
 * JD-Core Version:    0.7.0.1
 */