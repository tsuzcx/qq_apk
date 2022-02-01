package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.f;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.core.x;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class q
  extends ab
  implements IMsfProxy
{
  private static final String t = "MSF.D.ProxyNew";
  private static final int u = 20000;
  protected boolean a = false;
  private volatile Handler v;
  private ConcurrentHashMap w = new ConcurrentHashMap();
  private ConcurrentHashMap x = new ConcurrentHashMap();
  private final a y = new a();
  private IMsfServiceCallbacker z = new r(this);
  
  public q(String paramString)
  {
    super(paramString);
    paramString = new HandlerThread("Transport-Timeout-Checker", 5);
    paramString.start();
    this.v = new Handler(paramString.getLooper());
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.ProxyNew", 1, "onRecvServicePushResp fromServiceMsg = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
    if (!b(null, paramFromServiceMsg)) {
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig)
      {
        QLog.setUIN_REPORTLOG_LEVEL(((Integer)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd())).intValue());
        NetConnInfoCenter.socketConnState = ((Integer)paramFromServiceMsg.getAttribute("_attr_socket_connstate")).intValue();
        NetConnInfoCenter.servetTimeSecondInterv = ((Long)paramFromServiceMsg.getAttribute("_attr_server")).longValue();
        NetConnInfoCenter.GUID = (byte[])paramFromServiceMsg.getAttribute("_attr_deviceGUID");
        NetConnInfoCenter.sAppTimeoutConfig = ((Integer)paramFromServiceMsg.getAttribute("_attr_app_timeout")).intValue();
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
          f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 17);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.a)
          {
            this.r.addServicePushMsg(paramFromServiceMsg);
            return;
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
            f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 16);
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.ProxyNew", 2, " close msfServiceConn. push msg is droped." + paramFromServiceMsg);
        return;
        if (paramFromServiceMsg.getBusinessFailCode() != -2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MSF.D.ProxyNew", 2, "receive service ipc test push, length = " + paramFromServiceMsg.getWupBuffer().length);
      return;
    } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null) || (!paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")));
    f.a().a(f.a.c, paramFromServiceMsg.getWupBuffer(), 15);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp fromServiceMsg = " + paramFromServiceMsg.getServiceCmd() + ", ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq() + ", length = " + paramFromServiceMsg.getWupBuffer().length);
    ToServiceMsg localToServiceMsg = (ToServiceMsg)e.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
    if (localToServiceMsg != null) {
      if (("LongConn.OffPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localToServiceMsg.getServiceCmd()))) {
        QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp." + localToServiceMsg.getStringForLog() + " isConnectedMsf:" + this.a);
      }
    }
    label216:
    do
    {
      do
      {
        do
        {
          break label216;
          for (;;)
          {
            if (!b(paramToServiceMsg, paramFromServiceMsg))
            {
              if (!this.a) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.D.ProxyNew", 2, "add queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
              }
              this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.D.ProxyNew", 2, " onResponse " + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MSF.D.ProxyNew", 2, " close msfServiceConn. msg is droped." + paramToServiceMsg.getRequestSsoSeq() + " " + paramFromServiceMsg);
        return;
        if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          break;
        }
        QLog.d("MSF.D.ProxyNew", 1, "onReceiveResp." + paramFromServiceMsg.getStringForLog() + " waiteTemp is null.");
      } while (!paramFromServiceMsg.isSuccess());
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("appSeq", String.valueOf(paramFromServiceMsg.getAppSeq()));
      paramToServiceMsg.put("ssoSeq", String.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      paramFromServiceMsg = new RdmReq();
      paramFromServiceMsg.eventName = "PicUpMsgErroCase1";
      paramFromServiceMsg.isRealTime = true;
      paramFromServiceMsg.params = paramToServiceMsg;
      try
      {
        paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramFromServiceMsg);
        paramToServiceMsg.setTimeout(30000L);
        MsfServiceSdk.get().sendMsg(paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.ProxyNew", 2, " found timeout resp to:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
  }
  
  private int e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    for (;;)
    {
      return -1;
      try
      {
        if (m()) {
          return a(paramToServiceMsg);
        }
        b(paramToServiceMsg);
        return -1;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        b(paramToServiceMsg);
        if (localDeadObjectException != null)
        {
          QLog.w("MSF.D.ProxyNew", 1, localDeadObjectException.getMessage(), localDeadObjectException);
          return -1;
        }
      }
      catch (Exception localException)
      {
        if (this.b == null)
        {
          b(paramToServiceMsg);
          return -1;
        }
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException, NullPointerException
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    paramToServiceMsg.setAppId(this.r.appid);
    paramToServiceMsg.getAttributes().put("to_SendTime", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", this.r.processName);
    if ((QLog.isColorLevel()) && ((paramToServiceMsg.getServiceCmd() == null) || (!"socketnetflow".equals(paramToServiceMsg.getServiceCmd())))) {
      QLog.d("MSF.D.ProxyNew", 2, " send req to msfService:" + paramToServiceMsg);
    }
    return super.a(paramToServiceMsg);
  }
  
  void a()
  {
    if (!x.a())
    {
      QLog.d("MSF.D.ProxyNew", 1, "startBaseService no allow");
      return;
    }
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
      BaseApplication.getContext().startService(localIntent);
      QLog.d("MSF.D.ProxyNew", 1, "start service finish");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.D.ProxyNew", 1, " " + localException, localException);
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  boolean b()
  {
    boolean bool1 = false;
    if (!x.a())
    {
      QLog.d("MSF.D.ProxyNew", 1, "bindBaseService no allow");
      return false;
    }
    c.a().onBindStart();
    for (;;)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
        localIntent = new Intent();
        localIntent.putExtra("to_SenderProcessName", this.r.processName);
        localIntent.setComponent(localComponentName);
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool2 = BaseApplication.getContext().bindService(localIntent, this.s, 3);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        Intent localIntent;
        boolean bool2;
        QLog.w("MSF.D.ProxyNew", 1, " " + localException, localException);
        continue;
      }
      c.a().onBindEnd(bool1);
      QLog.d("MSF.D.ProxyNew", 1, "bind service finished " + bool1);
      return bool1;
      bool2 = BaseApplication.getContext().bindService(localIntent, this.s, 1);
      bool1 = bool2;
    }
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getBusinessFailCode();
    if (paramFromServiceMsg.getAttributes().containsKey("_attr_sameDevice")) {}
    for (boolean bool = ((Boolean)paramFromServiceMsg.getAttribute("_attr_sameDevice")).booleanValue();; bool = false)
    {
      switch (i)
      {
      default: 
        return false;
      case 2001: 
        QLog.d("MSF.D.ProxyNew", 1, "BaseConstants.CODE_NO_LOGIN " + paramFromServiceMsg.hashCode());
        this.r.errorHandler.onUserTokenExpired(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2011: 
        this.r.errorHandler.onRecvServerTip(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2012: 
        this.r.errorHandler.onKickedAndClearToken(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2013: 
        this.r.errorHandler.onKicked(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2009: 
        this.r.errorHandler.onServerSuspended(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2008: 
        this.r.errorHandler.onGrayError(paramToServiceMsg, paramFromServiceMsg, bool);
        return true;
      case 2014: 
        this.r.errorHandler.onInvalidSign(bool);
        return true;
      }
      return true;
    }
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "add fail queue req:" + paramToServiceMsg + " from:" + paramFromServiceMsg);
    }
    this.r.addServiceRespMsg(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.r.msfServiceName);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      localIntent.putExtra("to_SenderProcessName", this.r.processName);
      boolean bool2 = BaseApplication.getContext().stopService(localIntent);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("MSF.D.ProxyNew", 1, " " + localException, localException);
        localException.printStackTrace();
      }
    }
    QLog.d("MSF.D.ProxyNew", 1, "stopService service finished " + bool1);
    return bool1;
  }
  
  protected void d()
  {
    s locals = new s(this);
    locals.setName("handleWaitSendProxyMsgThread");
    locals.start();
  }
  
  protected void e()
  {
    c.a().onServiceDisconnected();
  }
  
  void f()
  {
    if ((!m()) && (this.y.h.compareAndSet(false, true)))
    {
      this.y.g = 3;
      a locala1 = this.y;
      a locala2 = this.y;
      long l = System.currentTimeMillis();
      locala2.n = l;
      locala1.j = l;
      this.v.postAtFrontOfQueue(this.y);
      c.a().onReqServiceConn();
      if (QLog.isColorLevel()) {
        QLog.i("MSF.D.ProxyNew", 2, "MSF_Alive_Log requestServiceConn");
      }
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  public void h()
  {
    while (!d.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)d.poll();
      if (localToServiceMsg != null) {
        try
        {
          a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          c(localToServiceMsg, a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString()));
        }
      }
    }
  }
  
  String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    this.v.dump(localStringBuilderPrinter, "");
    if (QLog.isColorLevel()) {
      QLog.i("MSF.D.ProxyNew", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void init(MsfServiceSdk paramMsfServiceSdk)
  {
    this.r = paramMsfServiceSdk;
    paramMsfServiceSdk.msfServiceName = this.n;
    if (this.v == null)
    {
      paramMsfServiceSdk = new HandlerThread("MsfServiceTimeoutChecker", 5);
      paramMsfServiceSdk.start();
      this.v = new Handler(paramMsfServiceSdk.getLooper());
      if (this.q != null)
      {
        if (!this.o) {
          break label81;
        }
        this.v.postDelayed(this.q, 10000L);
      }
    }
    return;
    label81:
    this.v.postDelayed(this.q, 2000L);
  }
  
  public void initMsfService()
  {
    f();
  }
  
  public int registerMsfService(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    if ((QLog.isColorLevel()) && (this.z != null)) {
      if (this.z != null)
      {
        localObject1 = Integer.toHexString(this.z.hashCode());
        if (this.z == null) {
          break label220;
        }
        localObject2 = this.z.asBinder();
        label49:
        if (localObject2 == null) {
          break label226;
        }
        paramBoolean1 = ((IBinder)localObject2).isBinderAlive();
        label62:
        QLog.d("MSF.D.ProxyNew", 2, "registerMsfService processName=" + this.r.processName + " callback=" + (String)localObject1 + " isBindAlive=" + paramBoolean1);
      }
    }
    for (;;)
    {
      localObject1 = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_RegisterMsfService");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.registerMsfService);
      localObject2 = new MsfServiceBindInfo(this.r.appid, this.r.processName, this.r.getBootBroadcastName(), this.z);
      a(this.z);
      ((ToServiceMsg)localObject1).getAttributes().put("intent_bindServiceInfo", localObject2);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      this.a = true;
      return sendMsg((ToServiceMsg)localObject1);
      localObject1 = "null";
      break;
      label220:
      localObject2 = null;
      break label49;
      label226:
      paramBoolean1 = false;
      break label62;
      QLog.d("MSF.D.ProxyNew", 1, "registerMsfService processName=" + this.r.processName + " callback=" + this.z);
    }
  }
  
  public void registerProxyDone()
  {
    if ((this.o) && (this.p) && (this.q != null))
    {
      this.v.removeCallbacks(this.q);
      this.v.post(this.q);
    }
  }
  
  public int sendMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return -1;
      if (!d(paramToServiceMsg)) {
        break;
      }
      c(paramToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.D.ProxyNew", 2, "add delaySendQueue sCmd:" + paramToServiceMsg.getServiceCmd() + " ssoSeq:" + paramToServiceMsg.getRequestSsoSeq() + " appSeq:" + paramToServiceMsg.getAppSeq());
    return -1;
    c.a().onSendMsg(paramToServiceMsg, m());
    if (paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg")) {
      paramToServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
    }
    if (paramToServiceMsg.getAppSeq() < 0) {
      paramToServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
    }
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    ab.b localb;
    if (paramToServiceMsg.isNeedCallback())
    {
      paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.l.incrementAndGet()));
      e.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
      localb = new ab.b(this, paramToServiceMsg);
      if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
        break label299;
      }
      this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + 20000L);
      QLog.d("MSF.D.ProxyNew", 1, "PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + 20000L));
    }
    while (m())
    {
      return e(paramToServiceMsg);
      label299:
      if ("login.auth".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
      {
        this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
        QLog.d("MSF.D.ProxyNew", 1, "login timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + String.valueOf(paramToServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
      }
      else
      {
        this.v.postDelayed(localb, paramToServiceMsg.getTimeout() + 2000L);
      }
    }
    b(paramToServiceMsg);
    if (m()) {
      return e(paramToServiceMsg);
    }
    QLog.i("MSF.D.ProxyNew", 1, "MSF_Alive_Log requestServiceConn in MsfServiceProxyNew sendMsg");
    f();
    return -1;
  }
  
  public boolean serviceConnected()
  {
    boolean bool4 = false;
    try
    {
      IBinder localIBinder;
      boolean bool1;
      if (this.z != null)
      {
        localIBinder = this.z.asBinder();
        if (localIBinder == null) {
          break label85;
        }
        bool1 = localIBinder.isBinderAlive();
        label34:
        if (localIBinder == null) {
          break label90;
        }
      }
      label85:
      label90:
      for (boolean bool2 = localIBinder.pingBinder();; bool2 = false)
      {
        boolean bool5 = m();
        boolean bool3 = bool4;
        if (bool5)
        {
          bool3 = bool4;
          if (bool1)
          {
            bool3 = bool4;
            if (bool2) {
              bool3 = true;
            }
          }
        }
        return bool3;
        localIBinder = null;
        break;
        bool1 = false;
        break label34;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startMsfService()
  {
    a();
  }
  
  public void stopMsfService()
  {
    c();
  }
  
  public int unRegisterMsfService(Boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(this.r.msfServiceName, "0", "cmd_UnRegisterMsfService");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
    localToServiceMsg.extraData.putBoolean("to_stop_wake_process", paramBoolean.booleanValue());
    this.a = false;
    b(this.z);
    return sendMsg(localToServiceMsg);
  }
  
  public void unbindMsfService()
  {
    h();
    g();
  }
  
  class a
    implements Runnable
  {
    static final String a = "BindService";
    static final int b = 1;
    static final int c = 2;
    static final int d = 4;
    static final int e = 8;
    static final int f = 16;
    int g = 0;
    final AtomicBoolean h = new AtomicBoolean(false);
    boolean i = false;
    long j = 0L;
    long k = 0L;
    long l = 0L;
    long m = 0L;
    long n = 0L;
    short o = 0;
    short p = 0;
    short q = 0;
    short r = 0;
    short s = 0;
    boolean t = false;
    boolean u = false;
    boolean v = false;
    boolean w = false;
    
    public a() {}
    
    String a()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("control=").append(Integer.toBinaryString(this.g)).append(" conned=").append(q.this.m()).append(" start=[").append(this.o).append(",").append(this.j).append("]").append(" bindSucc=[").append(this.p).append(",").append(this.k).append("]").append(" bindFail=[").append(this.q).append(",").append(this.l).append("]").append(" unbind=[").append(this.r).append(",").append(this.m).append("]").append(" stop=[").append(this.s).append(",").append(this.n).append("]");
      if (QLog.isColorLevel()) {
        QLog.i("BindService", 2, localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    
    public void run()
    {
      int i1 = 1;
      int i2 = this.g;
      if (QLog.isColorLevel()) {
        QLog.d("BindService", 2, "execute cmd: " + Integer.toBinaryString(i2));
      }
      long l1;
      if ((i2 & 0x8) == 8)
      {
        l1 = System.currentTimeMillis();
        if (q.this.m()) {
          q.this.h();
        }
        this.u = q.this.c();
        this.s = ((short)(this.s + 1));
        this.n = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BindService", 2, "stop service cost=" + (this.n - l1));
        }
      }
      if ((i2 & 0x4) == 4)
      {
        l1 = System.currentTimeMillis();
        if (q.this.m()) {
          q.this.h();
        }
        q.this.g();
        if (q.this.m()) {
          break label463;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.w = bool;
        if (!this.w) {
          QLog.i("BindService", 1, "unbind service failed");
        }
        this.r = ((short)(this.r + 1));
        this.m = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("BindService", 2, "unbind service cost=" + (this.m - l1));
        }
        if ((i2 & 0x1) == 1)
        {
          l1 = System.currentTimeMillis();
          q.this.a();
          this.o = ((short)(this.o + 1));
          this.j = System.currentTimeMillis();
          this.t = true;
          if (QLog.isColorLevel()) {
            QLog.d("BindService", 2, "start service cost=" + (System.currentTimeMillis() - l1));
          }
        }
        if (((i2 & 0x10) == 16) && (Build.VERSION.SDK_INT >= 21))
        {
          Intent localIntent = new Intent("com.tencent.tim.msf.startmsf");
          localIntent.setPackage(BaseApplication.getContext().getPackageName());
          BaseApplication.getContext().sendBroadcast(localIntent);
        }
        if ((i2 & 0x2) != 2) {
          break label746;
        }
        long l2 = System.currentTimeMillis();
        if (q.this.m()) {
          break label681;
        }
        this.v = q.this.b();
        i2 = 50;
        for (;;)
        {
          if ((q.this.m()) || (Thread.interrupted()) || (i2 > 2000)) {
            break label469;
          }
          l1 = i2;
          label463:
          try
          {
            Thread.sleep(l1);
            i2 = i1 * 50 + i2;
            i1 += 1;
          }
          catch (Exception localException) {}
        }
      }
      label469:
      if (!q.this.m())
      {
        this.q = ((short)(this.q + 1));
        this.l = System.currentTimeMillis();
        i2 = 6;
        if (System.currentTimeMillis() - this.j > 10000L) {
          i2 = 23;
        }
        i1 = i2;
        if (System.currentTimeMillis() - this.n > 30000L) {
          i1 = i2 | 0x1D;
        }
        i2 = i1;
        if (QLog.isColorLevel())
        {
          if (!q.this.m()) {
            break label686;
          }
          l1 = this.k;
          QLog.d("BindService", 2, "bind service bindSucc=" + this.v + " conned=" + q.this.m() + " cost=" + (l1 - l2));
        }
      }
      label563:
      label746:
      for (i2 = i1;; i2 = 0)
      {
        if (q.this.m()) {
          this.h.set(false);
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            a();
            QLog.d("BindService", 2, "execute cmd finished");
          }
          return;
          this.p = ((short)(this.p + 1));
          this.q = 0;
          this.k = System.currentTimeMillis();
          i1 = 0;
          break;
          l1 = this.l;
          break label563;
          if (i2 > 0)
          {
            q.d(q.this).g = i2;
            q.b(q.this).post(q.d(q.this));
          }
          else
          {
            this.h.set(false);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */