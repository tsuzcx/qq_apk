package com.tencent.mobileqq.msf.core.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.StatSvcSimpleGet.RspBody;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  public static final String a = "StatSvc.register";
  public static final String b = "MSF.C.PushManager:PushCoder";
  public static long c = 0L;
  public static long d = 0L;
  public static boolean e = false;
  public static String j;
  public static String k;
  static boolean n = false;
  public static final String o = "com.tencent.mobileqq.msf.WatchdogForInfoLogin";
  private static String p = "SvcReqRegister";
  private static String q = "PushService";
  private static byte r = 0;
  private static boolean s = false;
  private static int t = -1;
  private static String v;
  private static String w;
  private static String x;
  private static String y;
  private static final BroadcastReceiver z;
  private int A = 0;
  private long B = 0L;
  private int C = 0;
  g f;
  volatile boolean g = false;
  long h = 0L;
  int i = 0;
  long l = 0L;
  int m = 0;
  private final String u = "unrtime";
  
  static
  {
    c = 0L;
    d = 0L;
    e = false;
    v = "PullUnreadMsgCount";
    w = "MessageSvc";
    x = "SvcReqGet";
    y = "PushService";
    j = "StatSvc.get";
    k = "StatSvc.SimpleGet";
    z = new f();
  }
  
  public e(g paramg)
  {
    this.f = paramg;
  }
  
  long a(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("unrtime", 0).getLong(paramString, 0L);
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (this.B == 0L) {
      this.B = l1;
    }
    if ((this.C >= 5) && (l1 - this.B < 600000L))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog mStartWatchdogForInfoLoginRetryCount:" + this.C + " time:" + (l1 - this.B));
        QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog launch QQ Process too much stop.");
      }
      return;
    }
    if (this.C == 5)
    {
      this.C = 0;
      this.B = l1;
    }
    this.C += 1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogForInfoLogin mnWatchdogForInfoLoginRetryCount:" + this.A);
    }
    Object localObject;
    if (!n)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      BaseApplication.getContext().registerReceiver(z, (IntentFilter)localObject);
      n = true;
    }
    MsfService.getCore().mbIsInfoLoginGetted.set(false);
    this.A = 0;
    try
    {
      localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
      localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
      ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogForInfoLogin excep!", localException);
    }
  }
  
  void a(a parama, ToServiceMsg paramToServiceMsg, boolean paramBoolean, RegPushReason paramRegPushReason)
  {
    if (parama.k == null) {}
    do
    {
      return;
      if ((!com.tencent.mobileqq.msf.core.a.a.am()) || (com.tencent.mobileqq.msf.core.a.a.a(parama.k.uin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, parama.k.uin + " is booting and can not autoRegisterPush,return.");
    return;
    boolean bool = a(paramRegPushReason);
    if ((!bool) && (!paramBoolean) && (this.g) && (System.currentTimeMillis() - parama.e < 30000L))
    {
      parama = new StringBuilder().append("also send pushRegister, return. ");
      if (!bool)
      {
        bool = true;
        parama = parama.append(bool).append(" ");
        if (paramBoolean) {
          break label180;
        }
      }
      label180:
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("MSF.C.PushManager:PushCoder", 1, paramBoolean + " " + this.g);
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
        QLog.d("MSF.C.PushManager:PushCoder", 2, "ConfigManager.isAutoStarting():" + com.tencent.mobileqq.msf.core.a.a.am());
      }
    }
    catch (Exception parama)
    {
      try
      {
        localObject2 = new UniPacket(true);
        ((UniPacket)localObject2).setServantName(q);
        ((UniPacket)localObject2).setFuncName(p);
        localObject1 = new SvcReqRegister();
        ((SvcReqRegister)localObject1).cConnType = r;
        ((SvcReqRegister)localObject1).lBid = parama.c;
        ((SvcReqRegister)localObject1).lUin = Long.parseLong(parama.k.uin);
        ((SvcReqRegister)localObject1).iStatus = parama.k.iStatus;
        ((SvcReqRegister)localObject1).bKikPC = parama.k.bKikPC;
        ((SvcReqRegister)localObject1).bKikWeak = parama.k.bKikWeak;
        ((SvcReqRegister)localObject1).timeStamp = parama.k.timeStamp;
        ((SvcReqRegister)localObject1).iLargeSeq = parama.k.iLargeSeq;
        if (a(paramRegPushReason))
        {
          i1 = 0;
          label373:
          ((SvcReqRegister)localObject1).bRegType = ((byte)i1);
          if (paramRegPushReason != RegPushReason.setOnlineStatus) {
            break label1225;
          }
          i1 = 1;
          label392:
          ((SvcReqRegister)localObject1).bIsSetStatus = ((byte)i1);
          ((SvcReqRegister)localObject1).uExtOnlineStatus = parama.k.extStatus;
          if (!MsfSdkUtils.isBatteryOnlineStatus(parama.k)) {
            break label1231;
          }
          ((SvcReqRegister)localObject1).iBatteryStatus = MsfSdkUtils.getSendBatteryStatus(parama.k.batteryCapacity, parama.k.powerConnect);
        }
      }
      catch (Exception parama)
      {
        try
        {
          Object localObject2;
          Object localObject1;
          label444:
          ((SvcReqRegister)localObject1).iOSVersion = Integer.parseInt(Build.VERSION.SDK);
          if (NetConnInfoCenter.isMobileConn())
          {
            ((SvcReqRegister)localObject1).cNetType = 0;
            ((SvcReqRegister)localObject1).vecGuid = NetConnInfoCenter.GUID;
            ((SvcReqRegister)localObject1).strDevName = Build.MODEL;
            ((SvcReqRegister)localObject1).strDevType = Build.MODEL;
            ((SvcReqRegister)localObject1).strOSVer = Build.VERSION.RELEASE;
            if (!paramBoolean)
            {
              ((SvcReqRegister)localObject1).uNewSSOIp = d;
              ((SvcReqRegister)localObject1).uOldSSOIp = c;
              ((SvcReqRegister)localObject1).strVendorName = ROMUtil.getRomName();
              ((SvcReqRegister)localObject1).strVendorOSName = ROMUtil.getRomVersion(20);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager:PushCoder", 2, "register online report " + ((SvcReqRegister)localObject1).strVendorName + " " + ((SvcReqRegister)localObject1).strVendorOSName);
              }
            }
            ((SvcReqRegister)localObject1).bytes_0x769_reqbody = MsfPullConfigUtil.pullConfigRequest(false);
            if (!SettingCloneUtil.readValue(BaseApplication.getContext(), parama.k.uin, null, "qqsetting_qrlogin_set_mute", false)) {
              break label1296;
            }
            ((SvcReqRegister)localObject1).bSetMute = 1;
            bool = b.b(BaseApplication.getContext(), parama.k.uin);
            if (!bool) {
              break label1484;
            }
            i1 = 1;
            ((SvcReqRegister)localObject1).cNotifySwitch = ((byte)i1);
            i1 = BaseApplication.getContext().getThirdPushType();
            if (i1 > 0)
            {
              localObject3 = new VendorPushInfo();
              ((VendorPushInfo)localObject3).uVendorType = i1;
              ((SvcReqRegister)localObject1).stVendorPushInfo = ((VendorPushInfo)localObject3);
            }
            QLog.d("MSF.C.PushManager:PushCoder", 1, "msf-pushCoder.vendor_push_type:" + i1 + " ,msgNotifyEnable:" + bool);
            ((UniPacket)localObject2).put(p, localObject1);
            localObject2 = ((UniPacket)localObject2).encode();
            Object localObject3 = new ToServiceMsg("", parama.k.uin, "StatSvc.register");
            ((ToServiceMsg)localObject3).setAppId(parama.a);
            if (paramToServiceMsg != null)
            {
              ((ToServiceMsg)localObject3).setAppSeq(paramToServiceMsg.getAppSeq());
              ((ToServiceMsg)localObject3).addAttribute("to_srcCmd", paramToServiceMsg.getServiceCmd());
              i1 = paramToServiceMsg.extraData.getInt("oldStatus", 0);
              ((ToServiceMsg)localObject3).extraData.putInt("oldStatus", i1);
            }
            ((ToServiceMsg)localObject3).setRequestSsoSeq(MsfCore.getNextSeq());
            ((ToServiceMsg)localObject3).putWupBuffer((byte[])localObject2);
            ((ToServiceMsg)localObject3).setTimeout(30000L);
            ((ToServiceMsg)localObject3).addAttribute("regPushReason", paramRegPushReason.toString());
            if (!paramBoolean) {
              break label1305;
            }
            ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand._msf_UnRegPush);
            MsfSdkUtils.addToMsgProcessName(parama.b, (ToServiceMsg)localObject3);
            g.u = true;
            this.h = System.currentTimeMillis();
            this.f.c.sendSsoMsg((ToServiceMsg)localObject3);
            parama.e = System.currentTimeMillis();
            if (!paramBoolean) {
              break label1316;
            }
            QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " unregister push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + ((SvcReqRegister)localObject1).bRegType + " extStatus:" + parama.k.extStatus + " batter:" + ((SvcReqRegister)localObject1).iBatteryStatus);
            for (;;)
            {
              this.f.a();
              return;
              if (paramToServiceMsg == null) {
                break;
              }
              long l1 = a(paramToServiceMsg.getUin());
              if (l1 == 0L) {
                break;
              }
              long l2 = System.currentTimeMillis();
              long l3 = l2 - l1;
              if (l3 > 0L)
              {
                l3 /= 1000L;
                localObject1 = new HashMap();
                ((HashMap)localObject1).put("unRegtime", String.valueOf(l1));
                ((HashMap)localObject1).put("now", String.valueOf(l2));
                ((HashMap)localObject1).put("uin", paramToServiceMsg.getUin());
                if (this.f.c.getStatReporter() != null) {
                  this.f.c.getStatReporter().a("Msf.RegInterTime", true, l3, 0L, (Map)localObject1, false, false);
                }
              }
              a(paramToServiceMsg.getUin(), 0L);
              break;
              localException1 = localException1;
              QLog.d("MSF.C.PushManager:PushCoder", 1, "get reginterv error " + localException1, localException1);
              break;
              i1 = 1;
              break label373;
              label1225:
              i1 = 0;
              break label392;
              label1231:
              localException1.iBatteryStatus = 0;
              break label444;
              parama = parama;
              QLog.d("MSF.C.PushManager:PushCoder", 1, "send registerPush error " + parama, parama);
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1;
            localException2.printStackTrace();
            continue;
            if (NetConnInfoCenter.isWifiConn())
            {
              localException1.cNetType = 1;
              continue;
              label1296:
              localException1.bSetMute = 0;
              continue;
              label1305:
              localException2.setMsfCommand(MsfCommand._msf_RegPush);
              continue;
              label1316:
              this.g = true;
              QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush send " + MD5.toMD5(parama.k.uin) + " register push id " + parama.c + " pushStatus:" + parama.k.iStatus + " bRegType:" + localException1.bRegType + " timeStamp:" + localException1.timeStamp + " newIP:" + d + " oldIP:" + c + ",regPushReason:" + paramRegPushReason.toString() + " extStatus:" + parama.k.extStatus + " battery:" + localException1.iBatteryStatus);
              continue;
              label1484:
              i1 = 0;
            }
          }
        }
      }
    }
  }
  
  void a(a parama, boolean paramBoolean)
  {
    if ((com.tencent.mobileqq.msf.core.a.a.u) && (!paramBoolean))
    {
      long l1 = this.f.g() + this.f.e();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "sendMsgPushQuery, check time now=" + g.h.format(Long.valueOf(System.currentTimeMillis())) + ", shouldSendQueryTime=" + g.h.format(Long.valueOf(l1)));
      }
      if (System.currentTimeMillis() < l1) {
        this.f.a(l1 - System.currentTimeMillis());
      }
    }
    label604:
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.f.h() > 0L) {
            g.l = SystemClock.elapsedRealtime() - this.f.h();
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "alarmTime: " + g.l + " ,lastRecvSsoPacketTimeForSimpleGet=" + this.f.h());
          }
          if ((com.tencent.mobileqq.msf.core.a.a.v) && (g.l > com.tencent.mobileqq.msf.core.a.a.bm()))
          {
            str = MsfService.getCore().getAccountCenter().i();
            if ((com.tencent.mobileqq.msf.core.a.a.w) && (Long.parseLong(str) % 2L != 0L)) {
              break label604;
            }
            QLog.d("MSF.C.PushManager:PushCoder", 1, "try closeConn closeByAlarmWakeUpTooLong by a exceeded time to wakeup alarm :" + g.l);
            this.f.c.sender.b.a(com.tencent.qphone.base.a.D);
            if (this.f.c.getStatReporter() != null) {
              this.f.c.getStatReporter().a("1", str, true, 0L);
            }
          }
          if ((com.tencent.mobileqq.msf.core.a.a.v) && (g.l > com.tencent.mobileqq.msf.core.a.a.bn()) && (g.l <= com.tencent.mobileqq.msf.core.a.a.bm())) {
            this.f.F = SystemClock.elapsedRealtime();
          }
          if (parama.k != null) {
            if ((parama.k.uin != null) && (parama.c > 0L))
            {
              str = this.f.d + "|" + NetConnInfoCenter.getSystemNetworkType() + "|" + NetConnInfoCenter.getCurrentAPN() + "|" + (System.currentTimeMillis() - this.l);
              localToServiceMsg = new ToServiceMsg("", parama.k.uin, k);
              localToServiceMsg.setAppId(parama.a);
              localToServiceMsg.setTimeout(30000L);
              localToServiceMsg.setMsfCommand(MsfCommand._msf_queryPush);
              localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
              if (g.l > 0L)
              {
                localToServiceMsg.addAttribute("_attr_alarm_elapsed_time", Long.valueOf(g.l));
                g.l = 0L;
              }
              MsfSdkUtils.addToMsgProcessName(parama.b, localToServiceMsg);
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              String str;
              ToServiceMsg localToServiceMsg;
              this.f.c.sendSsoMsg(localToServiceMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.C.PushManager:PushCoder", 2, "send " + parama.k.uin + " query push id " + parama.c + " model:" + str);
              return;
              this.f.D = SystemClock.elapsedRealtime();
              QLog.d("MSF.C.PushManager:PushCoder", 1, "wakeup too long, but not close conn:" + g.l);
            }
            localException1 = localException1;
            QLog.d("MSF.C.PushManager:PushCoder", 1, "do PreDetectionAlarmTimeAlpha error!", localException1);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + localException2, localException2);
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "pushUin is " + parama.k.uin + ", queryPushId is " + parama.c + ". no query");
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = u.c();
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
    long l6 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
    if (l6 > this.h) {
      this.g = false;
    }
    long l7 = System.currentTimeMillis() - l6;
    long l8 = k.a(paramToServiceMsg, paramFromServiceMsg);
    Object localObject2 = null;
    i4 = -1;
    l1 = -1L;
    int i5 = -1;
    i3 = -1;
    l4 = -1L;
    long l5 = -1L;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.isSuccess()) {
          continue;
        }
        l2 = -1L;
        l1 = -1L;
        i2 = 0;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        label511:
        long l3;
        label544:
        label569:
        int i1;
        Object localObject1 = "unknown";
        continue;
        localObject1 = "unknown";
        continue;
        long l2 = -1L;
        l1 = -1L;
        int i2 = 0;
        continue;
        boolean bool = false;
        continue;
      }
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.getAttributes().containsKey("regPushReason"))) {
        continue;
      }
      localObject1 = (String)paramToServiceMsg.getAttribute("regPushReason");
      if (i2 == 0) {
        continue;
      }
      try
      {
        e = true;
        this.i = 0;
        this.l = System.currentTimeMillis();
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush unregister push succ " + MD5.toMD5(paramFromServiceMsg.getUin()));
          localObject4 = u.b(paramToServiceMsg);
          localObject4 = (a)this.f.i.get(localObject4);
          if (localObject4 != null)
          {
            ((a)localObject4).i = this.f.c.nowSocketConnAdd;
            ((a)localObject4).f = System.currentTimeMillis();
            if (i3 <= 0) {
              continue;
            }
            if ((((a)localObject4).k != null) && (((a)localObject4).k.iStatus != i3))
            {
              QLog.d("MSF.C.PushManager:PushCoder", 1, String.format("update old status: %s to %s", new Object[] { Integer.valueOf(((a)localObject4).k.iStatus), Integer.valueOf(i3) }));
              ((a)localObject4).k.iStatus = i3;
            }
            if ((((a)localObject4).k != null) && (((a)localObject4).k.extStatus != l1))
            {
              QLog.d("MSF.C.PushManager:PushCoder", 1, String.format("update old status: %s to %s", new Object[] { Long.valueOf(((a)localObject4).k.extStatus), Long.valueOf(l1) }));
              ((a)localObject4).k.extStatus = l1;
            }
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.PushManager:PushCoder", 2, "recv register push resp.iInterval=" + ((SvcRespRegister)localObject2).iHelloInterval + ", queryIntervTime=" + this.f.e() + ", next query time is " + g.h.format(Long.valueOf(System.currentTimeMillis() + ((SvcRespRegister)localObject2).iHelloInterval * 1000)));
            }
            if ((!com.tencent.mobileqq.msf.core.a.a.aQ()) || (com.tencent.mobileqq.msf.core.net.a.b.e)) {
              this.f.C = (((SvcRespRegister)localObject2).iHelloInterval * 1000);
            }
            this.f.a(this.f.e());
          }
          paramFromServiceMsg.attributes.put("ext_status", Long.valueOf(l1));
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush) {
            continue;
          }
          paramFromServiceMsg.setMsfCommand(MsfCommand.registerPush);
          if (!paramToServiceMsg.getAttributes().containsKey("to_srcCmd")) {
            continue;
          }
          this.f.c.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          if (this.f.c.getStatReporter() != null)
          {
            localObject2 = this.f.c.getStatReporter();
            i2 = paramFromServiceMsg.getBusinessFailCode();
            if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
              continue;
            }
            bool = true;
            ((k)localObject2).a(true, l7, i2, l8, bool, (String)localObject1);
          }
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
              ak.c(((SvcRespRegister)localObject1).strClientIP);
              ak.d(((SvcRespRegister)localObject1).iClientPort);
              i4 = ((SvcRespRegister)localObject1).bUpdateFlag;
              l3 = l1;
            }
            catch (Exception localException2)
            {
              int i6;
              Object localObject3;
              i2 = -1;
              i3 = -1;
              i4 = -1;
              l2 = l4;
              continue;
            }
            try
            {
              l1 = ((SvcRespRegister)localObject1).timeStamp;
              l3 = l1;
              i1 = ((SvcRespRegister)localObject1).cReplyCode;
              i2 = i3;
              l2 = l4;
            }
            catch (Exception localException3)
            {
              i2 = -1;
              i3 = -1;
              l2 = l4;
              l1 = l3;
              continue;
            }
            try
            {
              i3 = ((SvcRespRegister)localObject1).iStatus;
              i2 = i3;
              l2 = l4;
              if (((SvcRespRegister)localObject1).lServerTime > 0L)
              {
                i2 = i3;
                l2 = l4;
                NetConnInfoCenter.handleGetServerTimeResp(((SvcRespRegister)localObject1).lServerTime);
              }
              i2 = i3;
              l2 = l4;
              l3 = ((SvcRespRegister)localObject1).uExtOnlineStatus;
              l4 = l5;
              if (i1 == 0)
              {
                i2 = i3;
                l2 = l3;
                l4 = ((SvcRespRegister)localObject1).uClientBatteryGetInterval;
              }
              i2 = i3;
              l2 = l3;
              if (QLog.isColorLevel())
              {
                i2 = i3;
                l2 = l3;
                QLog.d("MSF.C.PushManager:PushCoder", 2, new Object[] { "pushresp cReplyCode:", Byte.valueOf(i1), " sendBatteryInterval:", Long.valueOf(l4) });
              }
              i2 = i3;
              l2 = l3;
              if (QLog.isDevelopLevel())
              {
                i2 = i3;
                l2 = l3;
                QLog.d("MSF.C.PushManager:PushCoder", 4, "pushresp servertime is " + ((SvcRespRegister)localObject1).lServerTime + this.f.c.timeFormatter.format(Long.valueOf(((SvcRespRegister)localObject1).lServerTime * 1000L)));
              }
              i2 = i3;
              l2 = l3;
              MsfPullConfigUtil.parseConfigResponse(((SvcRespRegister)localObject1).bytes_0x769_rspbody, false);
              i2 = 1;
              l2 = l1;
              localObject2 = localObject1;
              i5 = i1;
              l1 = l3;
            }
            catch (Exception localException4)
            {
              i3 = i1;
              continue;
            }
            localException1 = localException1;
            i3 = -1;
            i4 = -1;
            localObject1 = null;
            i2 = -1;
            l2 = l4;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "decodeRegisterPushResp error", localException1);
          }
          l3 = l1;
          l1 = l2;
          i6 = 0;
          i5 = i3;
          localObject3 = localObject1;
          i3 = i2;
          i2 = i6;
          l2 = l3;
        }
        else
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "handlerPush register push succ " + MD5.toMD5(paramFromServiceMsg.getUin()) + " bUpdateFlag: " + i4 + ", timeStamp:  " + l2 + ", cReplyCode:" + i5 + " ,iStatus: " + i3 + ", regPushReason: " + (String)localObject1);
          b(u.b(paramToServiceMsg));
          continue;
          if (this.f.c.getStatReporter() == null) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1) {}
    }
    localObject4 = this.f.c.getStatReporter();
    i2 = paramFromServiceMsg.getBusinessFailCode();
    if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush) {}
    for (bool = true;; bool = false)
    {
      ((k)localObject4).a(false, l7, i2, l8, bool, (String)localObject1);
      this.f.a(this.f.e());
      localThrowable1.printStackTrace();
      return;
      if (paramToServiceMsg == null) {
        break;
      }
      i2 = paramToServiceMsg.extraData.getInt("oldStatus", 0);
      QLog.d("MSF.C.PushManager:PushCoder", 1, "iStatus is 0, use old status: " + i2);
      paramFromServiceMsg.attributes.put("attr_online_status", Integer.valueOf(i2));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, "recv null register push resp, use default intervTime " + this.f.e());
      }
      this.f.a(this.f.e());
      break label511;
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_UnRegPush)
      {
        paramFromServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
        break label544;
      }
      paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
      break label544;
      MsfSdkUtils.addFromMsgProcessName(u.b(paramToServiceMsg), paramFromServiceMsg);
      this.f.c.addRespToQuque(null, paramFromServiceMsg);
      break label569;
      label1529:
      k localk;
      if ((l6 > this.h) && (!this.g))
      {
        g.u = false;
        if (this.i > 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.i + ", set retry at " + g.h.format(Long.valueOf(this.f.e() + System.currentTimeMillis())));
          }
          this.i = 0;
          this.f.a(this.f.e());
        }
      }
      else
      {
        if (this.f.c.getStatReporter() == null) {
          break label1671;
        }
        localk = this.f.c.getStatReporter();
        i2 = paramFromServiceMsg.getBusinessFailCode();
        if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_UnRegPush) {
          break label1673;
        }
      }
      label1671:
      label1673:
      for (bool = true;; bool = false)
      {
        localk.a(false, l7, i2, l8, bool, (String)localObject1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "register push register error, retry count " + this.i + ",set retry at " + g.h.format(Long.valueOf(60000L + System.currentTimeMillis())));
        }
        this.i += 1;
        this.f.a(60000L);
        break label1529;
        break;
      }
    }
  }
  
  void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("unrtime", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  boolean a(RegPushReason paramRegPushReason)
  {
    return (paramRegPushReason == RegPushReason.appRegister) || (paramRegPushReason == RegPushReason.fillRegProxy) || (paramRegPushReason == RegPushReason.createDefaultRegInfo) || (paramRegPushReason == RegPushReason.setOnlineStatus);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback mnWatchdogForInfoLoginRetryCount:" + this.A);
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
    localObject = (a)this.f.i.get(localObject);
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
      if (!u.b()) {
        break;
      }
      if (this.A < 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.A);
        }
        this.A += 1;
        try
        {
          localObject = new Intent("com.tencent.mobileqq.msf.WatchdogForInfoLogin");
          localObject = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, (Intent)localObject, 0);
          ((AlarmManager)BaseApplication.getContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 10000L, (PendingIntent)localObject);
          return;
        }
        catch (Exception localException)
        {
          QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback excep!", localException);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager:PushCoder", 2, "watchdog startWatchdogCallback QQProcessRunning mnWatchdogForInfoLoginRetryCount:" + this.A);
    return;
    QLog.d("MSF.C.PushManager:PushCoder", 1, "watchdog startWatchdogCallback QQProcess killed restart now");
    c(u.c());
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = u.b(paramToServiceMsg);
    if ((a)this.f.i.get(str) != null)
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf")).longValue();
      long l3 = k.a(paramToServiceMsg, paramFromServiceMsg);
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          this.f.c(SystemClock.elapsedRealtime());
          paramToServiceMsg = new byte[paramFromServiceMsg.getWupBuffer().length - 4];
          System.arraycopy(paramFromServiceMsg.getWupBuffer(), 4, paramToServiceMsg, 0, paramToServiceMsg.length);
          paramFromServiceMsg = new StatSvcSimpleGet.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          this.m = 0;
          if ((!com.tencent.mobileqq.msf.core.a.a.aQ()) || (com.tencent.mobileqq.msf.core.net.a.b.e)) {
            this.f.C = (paramFromServiceMsg.uint32_hello_interval.get() * 1000);
          }
          this.f.a(this.f.e());
          ak.c(paramFromServiceMsg.str_clientip.get());
          return;
        }
        if (this.f.c.getStatReporter() != null) {
          this.f.c.getStatReporter().a(false, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3);
        }
        this.f.a(180000L);
        return;
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        this.f.a(this.f.e());
      }
    }
  }
  
  void b(String paramString)
  {
    if (com.tencent.mobileqq.msf.service.e.a()) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, paramString + " is running, no need send SvcRequestPullUnreadMsgCountReq");
      }
    }
    do
    {
      return;
      paramString = (a)this.f.i.get(paramString);
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
    localUniPacket.setServantName(w);
    localUniPacket.setFuncName(v);
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
      this.f.c.sendSsoMsg((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.w("MSF.C.PushManager:PushCoder", 1, "query push error " + paramString, paramString);
    }
  }
  
  void c(String paramString)
  {
    g.s = true;
    a();
    NetConnInfoCenter.callQQProcess(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.e
 * JD-Core Version:    0.7.0.1
 */