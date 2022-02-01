package com.tencent.mobileqq.app.automator.step;

import acbo;
import achq;
import acmq;
import anaz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import anpc;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;
import tzc;
import wir;
import wit;

public class RegisterProxy
  extends AsyncStep
{
  public static int cyK;
  long Rc = 0L;
  private long Rd;
  private a a;
  private boolean bJN;
  Handler cC;
  private int cyE = 0;
  private int cyF = 0;
  private int cyG = 0;
  private int cyH = 0;
  private int cyI = 0;
  private int cyJ = 0;
  private int cyL;
  achq j;
  private long mStartTime;
  
  private void FM(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().aaN())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.mName + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.cC = new c(ThreadManager.getSubThreadLooper());
        this.cC.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.bJN = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.mName + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
    }
    super.setResult(4);
  }
  
  private void a(Object paramObject, HashMap<String, Long> paramHashMap, String paramString)
  {
    if (paramObject != null)
    {
      long l = Long.parseLong(paramObject.toString());
      paramHashMap.put(paramString, Long.valueOf(l - this.Rd));
      this.Rd = l;
    }
  }
  
  private boolean abV()
  {
    return (this.cyF == 2) && (this.cyG == 2) && (this.cyH == 2) && (this.cyI == 2);
  }
  
  private void be(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (!(paramObject instanceof Bundle)) {
          continue;
        }
        k = 1;
        localObject1 = ((Bundle)paramObject).get("ToServiceMsg");
        localObject2 = ((Bundle)paramObject).get("FromServiceMsg");
        paramObject = new HashMap(4);
        bool = localObject1 instanceof ToServiceMsg;
        i = k;
        if (!bool) {}
      }
      catch (Throwable paramObject)
      {
        int k;
        Object localObject1;
        Object localObject2;
        boolean bool;
        int i = 0;
        continue;
        continue;
        i = 0;
        continue;
      }
      try
      {
        a(((ToServiceMsg)localObject1).getAttribute("to_SendTime"), paramObject, "app2msf");
        i = k;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2net"), paramObject, "msf2net");
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_net2msf"), paramObject, "net2msf");
          a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2app"), paramObject, "msf2app");
          a(((FromServiceMsg)localObject2).getAttribute("msf_receive"), paramObject, "msfReceive");
          if ((i == 0) || (paramObject.isEmpty())) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.putAll(paramObject);
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.put("netCost", Long.valueOf(1L));
          if (i != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.put("netCost", Long.valueOf(0L));
          return;
          localNumberFormatException1 = localNumberFormatException1;
          i = 0;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      bool = localObject2 instanceof FromServiceMsg;
      if (!bool) {}
    }
  }
  
  private void cNG()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    Object localObject;
    if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
    {
      MsgAutoMonitorUtil.getInstance().printMsgInfo();
      l2 = l1 + BaseApplicationImpl.sLaunchTime;
      l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA <= 9) {
          break label515;
        }
        localObject = ">9";
        label158:
        localHashMap.put("param_FailCount", localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA <= 0) {
          break label530;
        }
      }
      label515:
      label530:
      for (localObject = "CLIENT_TIMEOUT";; localObject = "")
      {
        localHashMap.put("param_FailCode", localObject);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.Rc));
        localHashMap.put("param_threadOpId", String.valueOf(acmq.a().AZ()));
        localHashMap.put("param_cacheConfig", String.valueOf(MsgLruCache.cacheConfig));
        localHashMap.put("param_hc_state", String.valueOf(tzc.a().getState()));
        localHashMap.put("param_model", Build.MODEL);
        localHashMap.put("param_PluginDelayTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.O.getLong("PREF_PLUGIN_DELAY_TIME", -1L)));
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.containsKey(str1))
          {
            try
            {
              localHashMap.put("param_" + str1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.get(str1)));
            }
            catch (Throwable localThrowable) {}
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "add param exception ", localThrowable);
            }
          }
        }
        Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA);
        Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA);
        break;
        localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA);
        break label158;
      }
      localHashMap.put("param_" + this.mName, String.valueOf(l1 - this.mStartTime));
      if (QLog.isColorLevel())
      {
        localObject = localHashMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          QLog.d("QQInitHandler", 2, new Object[] { str2, "=", localHashMap.get(str2) });
        }
      }
      if (cyK == 0)
      {
        anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginB", true, l2, 0L, localHashMap, null);
        anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.sLaunchTime = 0L;
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l1 -= BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label983;
        }
        localObject = "1";
        label748:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + (String)localObject);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", localObject);
        if (cyK != 0) {
          break label1031;
        }
        anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.appStartTime = 0L;
      cyK = 0;
      return;
      localHashMap.put("param_exceptionReason", String.valueOf(cyK));
      anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA + ",actBExcetpionReason=" + cyK);
      break;
      label983:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin))
      {
        localObject = "2";
        break label748;
      }
      if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin))
      {
        localObject = "3";
        break label748;
      }
      localObject = "4";
      break label748;
      label1031:
      anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + (String)localObject + ",actBExcetpionReason=" + cyK);
    }
  }
  
  boolean abW()
  {
    return ((this.cyE == 2) || (this.cyE == 1)) && ((this.cyF == 2) || (this.cyF == 1)) && ((this.cyI == 2) || (this.cyI == 1)) && ((this.cyG == 2) || (this.cyG == 1)) && ((this.cyH == 2) || (this.cyH == 1));
  }
  
  public int od()
  {
    boolean bool2 = true;
    this.cyL = tzc.a().a(0, 1, 1, MainService.sNativeTidOfReceiver, 5000, 201, 131072L, Process.myTid(), "pullMsg");
    this.mStartTime = SystemClock.uptimeMillis();
    Object localObject;
    int i;
    long l;
    if (this.bJN)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
      if (this.cyx == 18)
      {
        i = 2;
        ((MessageHandler)localObject).Jr(i);
        this.bJN = false;
      }
    }
    else
    {
      l = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
      this.Rd = System.currentTimeMillis();
      if (this.cyx != 18) {
        break label287;
      }
      MessageHandler.bIk = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(2, true, l, false);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.ew.put("SERP", Long.valueOf(SystemClock.uptimeMillis() - this.mStartTime));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.cyx).append(" , isGetPassword = ");
        if (this.cyx != 17) {
          break label373;
        }
      }
    }
    label287:
    label373:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("RegisterProxy", 2, bool1 + " ,isUseNewRegisterProxy = " + MessageHandler.bIl);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (SystemClock.uptimeMillis() - this.mStartTime));
      return 2;
      i = 1;
      break;
      if (MessageHandler.bIl)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
        if (this.cyx == 17) {}
        for (bool1 = true;; bool1 = false)
        {
          ((MessageHandler)localObject).aj(l, bool1);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
      if (this.cyx == 17) {}
      for (bool1 = true;; bool1 = false)
      {
        ((MessageHandler)localObject).a(1, true, l, bool1);
        break;
      }
    }
  }
  
  public void onCreate()
  {
    if (this.j == null)
    {
      this.j = new b(null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addDefaultObservers(this.j);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$a = new a(null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$a);
    }
    if ((this.cyx == 17) || (this.cyx == 19)) {
      MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumBegin(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.cyy = 3;
    this.bJN = false;
    MessageHandler.bIl = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().bl(true);
  }
  
  public void onDestroy()
  {
    if (this.j != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.j);
      this.j = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$a);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$a = null;
    }
    if ((this.mResult != 7) || (!abV()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "RegisterProxy result:" + this.mResult + " ,syncSucc:" + abV());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().PF(true);
    }
    MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumEnd(Thread.currentThread().getThreadGroup().activeCount());
    cNG();
    if (this.cyx == 17)
    {
      wir.z(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
      wit.a().f(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().Fe(abV());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().cKh();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.Ra > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.Ra;
      Log.i("AutoMonitor", "SyncData, cost=" + l);
      if (aqiw.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.O.getBoolean("isFirstQQInit", true)) {
          break label411;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.O.edit().putBoolean("isFirstQQInit", false).commit();
        anpc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).collectPerformance(null, (String)localObject, abV(), l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.cyA, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().aaK()) {}
    for (int i = 2;; i = 1)
    {
      ((Automator)localObject).cyz = i;
      MsfServiceSdk.get().registerProxyDone();
      if (this.cyL != 0)
      {
        tzc.a().stop(this.cyL);
        this.cyL = 0;
      }
      return;
      label411:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
  
  public void setResult(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.abU())
    {
      if (paramInt != 4) {
        break label26;
      }
      FM(true);
    }
    for (;;)
    {
      super.setResult(paramInt);
      return;
      label26:
      if (this.cC != null) {
        this.cC.removeMessages(100);
      }
    }
  }
  
  class a
    extends acbo
  {
    private a() {}
    
    public void cGW()
    {
      RegisterProxy.this.ic(10000L);
    }
  }
  
  class b
    extends achq
  {
    private b() {}
    
    private void bqG()
    {
      if (RegisterProxy.this.abW()) {
        RegisterProxy.this.setResult(7);
      }
    }
    
    private void cNH()
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler1", 2, "stateC2C=" + RegisterProxy.a(RegisterProxy.this) + " stateGroupFirstMsg=" + RegisterProxy.c(RegisterProxy.this));
      }
      long l1;
      long l2;
      Object localObject1;
      if ((RegisterProxy.a(RegisterProxy.this) == 2) && (RegisterProxy.c(RegisterProxy.this) == 2))
      {
        l1 = SystemClock.uptimeMillis();
        RegisterProxy.this.a.app.a().bIm = true;
        RegisterProxy.this.a.app.a().Fe(true);
        if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
        {
          l2 = BaseApplicationImpl.sLaunchTime + l1;
          if (!QLog.isColorLevel()) {
            break label470;
          }
          QLog.i("AutoMonitor", 2, "registerB, cost=" + l2);
          anpc.a(RegisterProxy.this.a.app.getApp()).collectPerformance(null, "prxyRegisterB", true, l2, 0L, null, null);
        }
        if (BaseApplicationImpl.appStartTime > 0L)
        {
          l2 = BaseApplicationImpl.appStartTime;
          if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
            break label498;
          }
          localObject1 = "1";
        }
      }
      for (;;)
      {
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("actLoginType", localObject1);
        anpc.a(RegisterProxy.this.a.app.getApp()).collectPerformance(null, "prxyRegisterT", true, l1 - l2, 0L, (HashMap)localObject2, null);
        if (RegisterProxy.this.a.Ra > 0L)
        {
          l1 = System.currentTimeMillis() - RegisterProxy.this.a.Ra;
          if (aqiw.isNetworkAvailable(RegisterProxy.this.a.app.getApp()))
          {
            boolean bool = RegisterProxy.this.a.O.getBoolean("isFirstQQInit", true);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("param_isFirstInit", String.valueOf(bool));
            anpc.a(RegisterProxy.this.a.app.getApp()).collectPerformance(null, "prxyRegisterM", RegisterProxy.a(RegisterProxy.this), l1, 0L, (HashMap)localObject1, null);
            if (QLog.isColorLevel()) {
              QLog.i("AutoMonitor", 2, "machineStartToStopCircle, cost=" + l1 + ", isfirstQQInit=" + bool);
            }
          }
        }
        if (GuardManager.a != null)
        {
          localObject1 = RegisterProxy.this.a.app.getApp();
          localObject2 = GuardManager.a;
          GuardManager.v((Context)localObject1, GuardManager.isForeground);
        }
        return;
        label470:
        Log.i("AutoMonitor", "registerB, cost=" + l2);
        break;
        label498:
        if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin)) {
          localObject1 = "2";
        } else if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin)) {
          localObject1 = "3";
        } else {
          localObject1 = "4";
        }
      }
    }
    
    public void Fl(boolean paramBoolean)
    {
      int i = 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetDiscussionMsg Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RPD", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      MsgAutoMonitorUtil.getInstance().markDisFinishCost();
      RegisterProxy localRegisterProxy = RegisterProxy.this;
      if (paramBoolean) {}
      for (;;)
      {
        RegisterProxy.c(localRegisterProxy, i);
        bqG();
        return;
        i = 1;
      }
    }
    
    public void Fm(boolean paramBoolean)
    {
      int i = 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetFirstGroup Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RPF", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      RegisterProxy localRegisterProxy = RegisterProxy.this;
      if (paramBoolean) {}
      for (;;)
      {
        RegisterProxy.f(localRegisterProxy, i);
        cNH();
        return;
        i = 1;
      }
    }
    
    public void a(boolean paramBoolean, String[] paramArrayOfString)
    {
      int i = 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetTroopMsg Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RPT", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
      paramArrayOfString = RegisterProxy.this;
      if (paramBoolean) {}
      for (;;)
      {
        RegisterProxy.d(paramArrayOfString, i);
        bqG();
        return;
        i = 1;
      }
    }
    
    public void ap(boolean paramBoolean, Object paramObject)
    {
      int i = 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      RegisterProxy localRegisterProxy = RegisterProxy.this;
      if (paramBoolean) {}
      for (;;)
      {
        RegisterProxy.a(localRegisterProxy, i);
        if (!paramBoolean) {
          break;
        }
        bqG();
        RegisterProxy.a(RegisterProxy.this, paramObject);
        return;
        i = 1;
      }
      RegisterProxy.this.setResult(6);
    }
    
    public void d(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      int j = 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
      }
      RegisterProxy.this.a.ew.put("RPA", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      RegisterProxy localRegisterProxy;
      if (paramLong2 == 0L)
      {
        localRegisterProxy = RegisterProxy.this;
        if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
          break label252;
        }
        i = 2;
        RegisterProxy.d(localRegisterProxy, i);
        localRegisterProxy = RegisterProxy.this;
        if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
          break label258;
        }
        i = 2;
        label178:
        RegisterProxy.c(localRegisterProxy, i);
        RegisterProxy.this.Rc = paramLong1;
        if (MessageHandler.bIk)
        {
          localRegisterProxy = RegisterProxy.this;
          if (!paramBoolean) {
            break label264;
          }
          i = 2;
          label213:
          RegisterProxy.b(localRegisterProxy, i);
          localRegisterProxy = RegisterProxy.this;
          if (!paramBoolean) {
            break label270;
          }
        }
      }
      label258:
      label264:
      label270:
      for (int i = j;; i = 1)
      {
        RegisterProxy.e(localRegisterProxy, i);
        MessageHandler.bIk = false;
        bqG();
        return;
        label252:
        i = 1;
        break;
        i = 1;
        break label178;
        i = 1;
        break label213;
      }
    }
    
    public void mV(boolean paramBoolean)
    {
      boolean bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetPAMsg Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RPP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      Object localObject = RegisterProxy.this;
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        RegisterProxy.e((RegisterProxy)localObject, i);
        if (!MessageHandler.bIk) {
          break;
        }
        RegisterProxy.this.a.bJL = true;
        bqG();
        return;
      }
      localObject = RegisterProxy.this.a;
      if (RegisterProxy.b(RegisterProxy.this) == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        ((Automator)localObject).bJL = paramBoolean;
        break;
      }
    }
    
    public void zF(boolean paramBoolean)
    {
      boolean bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetC2CMsg Fin:" + paramBoolean);
      }
      RegisterProxy.this.a.ew.put("RPC", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(RegisterProxy.this)));
      MsgAutoMonitorUtil.getInstance().markC2CFinishCost();
      Object localObject = RegisterProxy.this;
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        RegisterProxy.b((RegisterProxy)localObject, i);
        if (!MessageHandler.bIk) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, RegisterProxy.this.mName + " on GetDiscussionMsg Fin: Receive empty package set isC2CMsgSuccess true");
        }
        RegisterProxy.this.a.bJK = true;
        if (MessageHandler.bIl) {
          cNH();
        }
        bqG();
        return;
      }
      localObject = RegisterProxy.this.a;
      if (RegisterProxy.a(RegisterProxy.this) == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        ((Automator)localObject).bJK = paramBoolean;
        break;
      }
    }
  }
  
  class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      RegisterProxy.a(RegisterProxy.this, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */