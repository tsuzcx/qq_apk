package com.tencent.mobileqq.msf.core.push;

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
import com.tencent.mobileqq.msf.service.c;
import com.tencent.mobileqq.msf.service.g;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
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

public class d
{
  public static final String a = "StatSvc.register";
  public static final String b = "MSF.C.PushManager:PushCoder";
  public static String g;
  static boolean j = false;
  public static final String k = "com.tencent.qqlite.msf.WatchdogForInfoLogin";
  private static String l = "SvcReqRegister";
  private static String m = "PushService";
  private static byte n = 0;
  private static String p = "PullUnreadMsgCount";
  private static String q = "MessageSvc";
  private static String r = "SvcReqGet";
  private static String s = "PushService";
  private static final BroadcastReceiver t;
  f c;
  volatile boolean d = false;
  long e = 0L;
  int f = 0;
  long h = 0L;
  int i = 0;
  private final String o = "unrtime";
  private int u = 0;
  private long v = 0L;
  private int w = 0;
  
  static
  {
    g = "StatSvc.get";
    t = new e();
  }
  
  public d(f paramf)
  {
    this.c = paramf;
  }
  
  private void c(String paramString)
  {
    f.n = true;
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
    if (this.v == 0L) {
      this.v = l1;
    }
    if ((this.w >= 5) && (l1 - this.v < 600000L))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog mStartWatchdogForInfoLoginRetryCount:" + this.w + " time:" + (l1 - this.v));
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog launch QQ Process too much stop.");
      }
      return;
    }
    if (this.w == 5)
    {
      this.w = 0;
      this.v = l1;
    }
    this.w += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:" + this.u);
    }
    if (!j)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.qqlite.msf.WatchdogForInfoLogin");
      BaseApplication.getContext().registerReceiver(t, (IntentFilter)localObject);
      j = true;
    }
    MsfService.getCore().mbIsInfoLoginGetted.set(false);
    this.u = 0;
    Object localObject = new Intent("com.tencent.qqlite.msf.WatchdogForInfoLogin");
    localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
    ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
  }
  
  void a(a parama, ToServiceMsg paramToServiceMsg, boolean paramBoolean, m paramm)
  {
    if (parama.k == null) {}
    do
    {
      return;
      if ((!com.tencent.mobileqq.msf.core.a.a.D()) || (com.tencent.mobileqq.msf.core.a.a.a(parama.k.uin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, parama.k.uin + " is booting and can not autoRegisterPush,return.");
    return;
    boolean bool = a(paramm);
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
        QLog.d("MSF.C.PushManager:PushCoder", 2, "ConfigManager.isAutoStarting():" + com.tencent.mobileqq.msf.core.a.a.D());
      }
      try
      {
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setServantName(m);
        ((UniPacket)localObject2).setFuncName(l);
        localObject1 = new SvcReqRegister();
        ((SvcReqRegister)localObject1).cConnType = n;
        ((SvcReqRegister)localObject1).lBid = parama.c;
        ((SvcReqRegister)localObject1).lUin = Long.parseLong(parama.k.uin);
        ((SvcReqRegister)localObject1).iStatus = parama.k.iStatus;
        ((SvcReqRegister)localObject1).bKikPC = parama.k.bKikPC;
        ((SvcReqRegister)localObject1).bKikWeak = parama.k.bKikWeak;
        ((SvcReqRegister)localObject1).timeStamp = parama.k.timeStamp;
        if ((paramm == m.b) || (paramm == m.g)) {
          break label1032;
        }
        if (paramm != m.h) {
          break label859;
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
            localException1.cNetType = 1;
            continue;
            localException2.setMsfCommand(MsfCommand._msf_RegPush);
            continue;
            this.d = true;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " register push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + localException1.bRegType + " timeStamp:" + localException1.timeStamp);
            continue;
            i1 = 0;
          }
        }
      }
      ((SvcReqRegister)localObject1).bRegType = ((byte)i1);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ((SvcReqRegister)localObject1).iOSVersion = Integer.parseInt(Build.VERSION.SDK);
          if (!NetConnInfoCenterImpl.isMobileConn()) {
            break;
          }
          ((SvcReqRegister)localObject1).cNetType = 0;
          ((SvcReqRegister)localObject1).vecGuid = NetConnInfoCenter.GUID;
          ((SvcReqRegister)localObject1).strDevName = Build.MODEL;
          ((SvcReqRegister)localObject1).strDevType = Build.MODEL;
          ((SvcReqRegister)localObject1).strOSVer = Build.VERSION.RELEASE;
          ((UniPacket)localObject2).put(l, localObject1);
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
          localToServiceMsg.addAttribute("regPushReason", paramm.toString());
          if (!paramBoolean) {
            break label921;
          }
          localToServiceMsg.setMsfCommand(MsfCommand._msf_UnRegPush);
          MsfSdkUtils.addToMsgProcessName(parama.b, localToServiceMsg);
          f.p = true;
          this.e = System.currentTimeMillis();
          this.c.b.sendSsoMsg(localToServiceMsg);
          parama.e = System.currentTimeMillis();
          if (!paramBoolean) {
            break label932;
          }
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " unregister push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + ((SvcReqRegister)localObject1).bRegType);
          this.c.a();
          return;
          if (paramToServiceMsg != null)
          {
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
        }
        label859:
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
        QLog.d("MSF.C.PushManager:PushCoder", 2, "sendMsgPushQuery, check time now=" + f.g.format(Long.valueOf(System.currentTimeMillis())) + ", shouldSendQueryTime=" + f.g.format(Long.valueOf(l1)));
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
            localUniPacket.setServantName(s);
            localUniPacket.setFuncName(r);
            Object localObject = new com.tencent.msf.service.protocol.push.b();
            ((com.tencent.msf.service.protocol.push.b)localObject).b = parama.c;
            ((com.tencent.msf.service.protocol.push.b)localObject).a = Long.parseLong(parama.k.uin);
            ((com.tencent.msf.service.protocol.push.b)localObject).d = parama.k.iStatus;
            String str = this.c.c + "|" + NetConnInfoCenterImpl.getSystemNetworkType() + "|" + NetConnInfoCenterImpl.getCurrentAPN() + "|" + (System.currentTimeMillis() - this.h);
            ((com.tencent.msf.service.protocol.push.b)localObject).c = str;
            ((com.tencent.msf.service.protocol.push.b)localObject).m = NetConnInfoCenter.GUID;
            ((com.tencent.msf.service.protocol.push.b)localObject).n = Build.MODEL;
            ((com.tencent.msf.service.protocol.push.b)localObject).o = Build.MODEL;
            ((com.tencent.msf.service.protocol.push.b)localObject).p = Build.VERSION.RELEASE;
            localUniPacket.put(r, localObject);
            localObject = new ToServiceMsg("", parama.k.uin, g);
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
    paramToServiceMsg = g.c();
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (com.tencent.msf.service.protocol.a.b)localUniPacket.getByClass("resp_PullUnreadMsgCount", new com.tencent.msf.service.protocol.a.b());
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
    long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
    if (l3 > this.e) {
      this.d = false;
    }
    long l4 = System.currentTimeMillis() - l3;
    long l5 = com.tencent.mobileqq.msf.core.b.m.a(paramToServiceMsg, paramFromServiceMsg);
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
        label348:
        label373:
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
        this.f = 0;
        this.h = System.currentTimeMillis();
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush unregister push succ " + MD5.toMD5(paramFromServiceMsg.getUin()));
          localObject4 = g.b(paramToServiceMsg);
          localObject4 = (a)this.c.h.get(localObject4);
          if (localObject4 != null)
          {
            ((a)localObject4).i = this.c.b.nowSocketConnAdd;
            ((a)localObject4).f = System.currentTimeMillis();
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager:PushCoder", 2, "recv register push resp.iInterval=" + ((SvcRespRegister)localObject2).iHelloInterval + ", queryIntervTime=" + this.c.e() + ", next query time is " + f.g.format(Long.valueOf(System.currentTimeMillis() + ((SvcRespRegister)localObject2).iHelloInterval * 1000)));
            }
            this.c.x = (((SvcRespRegister)localObject2).iHelloInterval * 1000);
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
          ((com.tencent.mobileqq.msf.core.b.m)localObject2).a(true, l4, i1, l5, bool, (String)localObject1);
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
          b(g.b(paramToServiceMsg));
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
      ((com.tencent.mobileqq.msf.core.b.m)localObject4).a(false, l4, i1, l5, bool, (String)localObject1);
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
        break label348;
      }
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      break label348;
      MsfSdkUtils.addFromMsgProcessName(g.b(paramToServiceMsg), paramFromServiceMsg);
      this.c.b.addRespToQuque(null, paramFromServiceMsg);
      break label373;
      com.tencent.mobileqq.msf.core.b.m localm;
      if ((l3 > this.e) && (!this.d))
      {
        f.p = false;
        if (this.f > 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.f + ", set retry at " + f.g.format(Long.valueOf(this.c.e() + System.currentTimeMillis())));
          }
          this.f = 0;
          this.c.a(this.c.e());
        }
      }
      else
      {
        localm = this.c.b.getStatReporter();
        i1 = paramFromServiceMsg.getBusinessFailCode();
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
          break label1143;
        }
      }
      label1143:
      for (bool = true;; bool = false)
      {
        localm.a(false, l4, i1, l5, bool, (String)localObject1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.f + ",set retry at " + f.g.format(Long.valueOf(60000L + System.currentTimeMillis())));
        }
        this.f += 1;
        this.c.a(60000L);
        break;
      }
    }
  }
  
  void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  boolean a(m paramm)
  {
    return (paramm == m.b) || (paramm == m.g) || (paramm == m.h);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:" + this.u);
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
    localObject = (a)this.c.h.get(localObject);
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
      if (!g.b()) {
        break;
      }
      if (this.u < 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.u);
        }
        this.u += 1;
        localObject = new Intent("com.tencent.qqlite.msf.WatchdogForInfoLogin");
        localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
        ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.u);
    return;
    QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback QQProcess killed restart now");
    c(g.c());
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = g.b(paramToServiceMsg);
    if ((a)this.c.h.get(str) != null)
    {
      System.currentTimeMillis();
      ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
      com.tencent.mobileqq.msf.core.b.m.a(paramToServiceMsg, paramFromServiceMsg);
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = new UniPacket(true);
          paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (com.tencent.msf.service.protocol.push.e)paramToServiceMsg.getByClass("SvcRespGet", new com.tencent.msf.service.protocol.push.e());
          this.i = 0;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "recv query push resp.iInterval=" + paramToServiceMsg.e + ", queryIntervTime=" + this.c.e() + ", next query time is " + f.g.format(Long.valueOf(System.currentTimeMillis() + paramToServiceMsg.e * 1000)));
          }
          this.c.x = (paramToServiceMsg.e * 1000);
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
    if (c.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, paramString + " is running, no need send SvcRequestPullUnreadMsgCountReq");
      }
    }
    do
    {
      return;
      paramString = (a)this.c.h.get(paramString);
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
    localUniPacket.setServantName(q);
    localUniPacket.setFuncName(p);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.d
 * JD-Core Version:    0.7.0.1
 */