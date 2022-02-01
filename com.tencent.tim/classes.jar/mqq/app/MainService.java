package mqq.app;

import PushNotifyPack.RequestPushForceOffline;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqRegulatorCallback;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.IServiceCmdCallback;

public class MainService
{
  public static final String CMD_PRE_AUTH = "QQConnectLogin.pre_auth";
  public static final String MSFPROCESSNAMETAG = ":MSF";
  public static final String QQPROCESSNAME = "com.tencent.tim";
  public static final String SERVICE_CMD = "serviceCmd";
  private static final String TAG = MainService.class.getSimpleName();
  public static boolean isDebugVersion = false;
  public static boolean isGrayVersion = false;
  public static final String msfServiceName = "com.tencent.mobileqq.msf.service.MsfService";
  private static IServiceCmdCallback sCmdCallback;
  public static int sNativeTidOfReceiver = -1;
  public static long sPwdPacketTime = 0L;
  public static long sReceiverCpuTime = 0L;
  public static MqqRegulatorCallback sRegulatorCallback;
  public static final String uinNotMatchTag = "uinNotMatch";
  private static AbstractUnifiedMonitor um;
  private final Runnable MSFReceiver = new MainService.2(this);
  private IAuthHandler authHandler = new MainService.7(this);
  public int cbExceedCount;
  public int cbIncreaseCount;
  public long cbIncreaseTime;
  public long cbLastUpdateSPTime;
  private IErrorHandler errorHandler = new MyErrorHandler(null);
  private MobileQQ mApplicaiton;
  private volatile AppRuntime.InterceptKickListener mInterceptKickListener;
  private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
  private IMsfMsgHandler msfMsgHandler = new MainService.3(this);
  private Thread msfRecvThread;
  private final MsfRespHandleUtil msfRespHandleUtil;
  public final MsfServiceSdk msfSub;
  INotifyHandler notifyHandler = new MainService.5(this);
  private IPushHandler pushHandler = new MainService.4(this);
  private boolean recvThreadRegulatoring;
  private IRegisterUinHandler registerUinHandler = new MainService.6(this);
  private int reportThreshold = -1;
  private IServerInfoHandler serverInfoHandler = new MainService.8(this);
  private IServerMsgPushHandler serverMsgPushHandler = new MainService.9(this);
  private int umNotReported;
  
  MainService(MobileQQ paramMobileQQ, int paramInt, String paramString, boolean paramBoolean)
  {
    this.mApplicaiton = paramMobileQQ;
    this.msfSub = MsfServiceSdk.get();
    this.msfSub.init(paramMobileQQ, paramInt, paramString, "com.tencent.mobileqq.msf.service.MsfService", this.errorHandler, MobileQQ.processName);
    this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[] { this.msfMsgHandler, this.pushHandler, this.notifyHandler, this.authHandler, this.registerUinHandler, this.serverMsgPushHandler, this.serverInfoHandler });
    if (paramBoolean) {
      start();
    }
  }
  
  private void receiveMessageFromMSF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str1 = null;
    String str2 = null;
    AppRuntime localAppRuntime = this.mApplicaiton.waitAppRuntime(null);
    if (paramToServiceMsg != null) {
      localAppRuntime = localAppRuntime.getAppRuntime(paramToServiceMsg.extraData.getString("moduleId"));
    }
    for (;;)
    {
      long l1 = 0L;
      if (QLog.isColorLevel()) {
        l1 = SystemClock.currentThreadTimeMillis();
      }
      Object localObject;
      long l2;
      int i;
      if (paramToServiceMsg != null)
      {
        localObject = (Class)this.mRequestServlets.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
        l2 = paramToServiceMsg.extraData.getLong("sendTime");
        l2 = System.currentTimeMillis() - l2;
        paramFromServiceMsg.addAttribute("msf_receive", Long.valueOf(System.currentTimeMillis()));
        if (paramFromServiceMsg.isSuccess())
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localAppRuntime.getClass().getSimpleName() + "@" + localAppRuntime.hashCode() + "  cost=" + l2 + "ms.");
          }
          if (sCmdCallback != null) {
            sCmdCallback.onCmdResponse(paramFromServiceMsg.getServiceCmd());
          }
          recordKeyTimestamp(paramToServiceMsg, paramFromServiceMsg);
          str1 = (String)paramToServiceMsg.getAttribute("from_where");
          str2 = (String)paramToServiceMsg.getAttribute("mainaccount");
          i = 0;
          label263:
          int j = 0;
          if ("0".equals(paramFromServiceMsg.getUin()))
          {
            paramFromServiceMsg.setUin(localAppRuntime.getAccount());
            j = 1;
          }
          String str3 = paramFromServiceMsg.getUin();
          if ((str1 != null) && (str1.length() > 0)) {
            paramFromServiceMsg.addAttribute("from_where", str1);
          }
          if ((str2 != null) && (str2.length() > 0)) {
            paramFromServiceMsg.addAttribute("mainaccount", str2);
          }
          if ((j != 0) || (str3.equals(localAppRuntime.getAccount())) || ("login.auth".equals(paramFromServiceMsg.getServiceCmd())) || ("wtlogin.login".equals(paramFromServiceMsg.getServiceCmd())) || (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_name2uin.equals(paramFromServiceMsg.getMsfCommand())) || ("login.chguin".equals(paramFromServiceMsg.getServiceCmd())) || ((str1 != null) && (str1.equals("subaccount"))) || ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("uinNotMatch"))))
          {
            if ((this.reportThreshold == -1) && (um != null))
            {
              if (!um.whetherReportDuringThisStartup(7)) {
                break label1150;
              }
              this.reportThreshold = um.getThreshold(7);
              um.setMonitoredThread(7, Thread.currentThread(), null);
            }
            label521:
            if ((um != null) && (um.whetherStackEnabled(7))) {
              um.reportStackIfTimeout(7);
            }
            l2 = SystemClock.uptimeMillis();
            localAppRuntime.getServletContainer().notifyMSFServlet((Class)localObject, paramFromServiceMsg);
            if (i != 0) {
              try
              {
                paramToServiceMsg = localAppRuntime.subRuntimeMap.values().iterator();
                while (paramToServiceMsg.hasNext()) {
                  ((AppRuntime)paramToServiceMsg.next()).getServletContainer().notifyMSFServlet((Class)localObject, paramFromServiceMsg);
                }
                l2 = SystemClock.uptimeMillis() - l2;
              }
              catch (Exception paramToServiceMsg)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(TAG, 2, "", paramToServiceMsg);
                }
              }
            }
            if (this.reportThreshold > 0)
            {
              if (l2 <= this.reportThreshold) {
                break label1159;
              }
              if (um.whetherReportThisTime(7)) {
                um.addEvent(7, paramFromServiceMsg.getServiceCmd(), (int)l2, this.umNotReported, null);
              }
            }
          }
        }
      }
      for (this.umNotReported = 0;; this.umNotReported += 1)
      {
        long l3 = SystemClock.currentThreadTimeMillis();
        sReceiverCpuTime = l3;
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, new Object[] { "[MSF End][notifyMSFServlet]", paramFromServiceMsg.getServiceCmd(), ",ssoseq=", Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), ",cost=", Long.valueOf(l2), "ms, cpucost=", Long.valueOf(l3 - l1), "(", Long.valueOf(l3), ")." });
        }
        if (l2 >= 2000L)
        {
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("cmd", paramFromServiceMsg.getServiceCmd());
          localObject = new RdmReq();
          ((RdmReq)localObject).eventName = "longTimeCallback";
          ((RdmReq)localObject).elapse = l2;
          ((RdmReq)localObject).size = 0L;
          ((RdmReq)localObject).isSucceed = true;
          ((RdmReq)localObject).isRealTime = false;
          ((RdmReq)localObject).params = paramToServiceMsg;
          paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject);
          paramToServiceMsg.setNeedCallback(false);
          paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
          this.msfSub.sendMsg(paramToServiceMsg);
        }
        reportMSFCallBackCost(l2, false);
        if ((isDebugVersion) && (l2 >= 5000L) && (localAppRuntime != null)) {
          localAppRuntime.runOnUiThread(new MainService.1(this, paramFromServiceMsg, l2));
        }
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localAppRuntime.getClass().getSimpleName() + "@" + localAppRuntime.hashCode() + "  code=" + paramFromServiceMsg.getResultCode() + ",cost=" + l2 + "ms.");
        break;
        if ((this.mApplicaiton.getQQProcessName().endsWith(":video")) || (QLog.isColorLevel())) {
          QLog.d("mqq", 1, "[MSF Push]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq());
        }
        i = 1;
        localObject = null;
        break label263;
        label1150:
        this.reportThreshold = -2;
        break label521;
        label1159:
        if (um.whetherStackEnabled(7)) {
          um.notifyNotTimeout(7);
        }
      }
    }
  }
  
  private void recordKeyTimestamp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("sendTime", 0L);
    long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf", Long.valueOf(0L))).longValue();
    long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", Long.valueOf(0L))).longValue();
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", Long.valueOf(0L))).longValue();
    long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2app", Long.valueOf(0L))).longValue();
    long l6 = System.currentTimeMillis();
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atAppSite", l1);
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atMsfSite", l2);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2net_atMsfSite", l3);
    paramFromServiceMsg.extraData.putLong("timestamp_net2msf_atMsfSite", l4);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atMsfSite", l5);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atAppSite", l6);
  }
  
  public static void setServiceCmdCallback(IServiceCmdCallback paramIServiceCmdCallback)
  {
    sCmdCallback = paramIServiceCmdCallback;
  }
  
  public static void setUnifiedMonitorInstance(AbstractUnifiedMonitor paramAbstractUnifiedMonitor)
  {
    um = paramAbstractUnifiedMonitor;
  }
  
  public void clearServlets()
  {
    this.mRequestServlets.clear();
  }
  
  public void kick(AppRuntime.KickParams paramKickParams)
  {
    if ((paramKickParams != null) && ((this.errorHandler instanceof MyErrorHandler))) {
      ((MyErrorHandler)this.errorHandler).onKickedInternal((ToServiceMsg)paramKickParams.toServiceMsg, (FromServiceMsg)paramKickParams.fromServiceMsg, paramKickParams.isTokenExpired, paramKickParams.isSameDevice);
    }
  }
  
  public void onRecvVerifyManagerCallback(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    this.msfRespHandleUtil.handleRespMsg(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void reportMSFCallBackCost(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.cbIncreaseTime += paramLong;
      this.cbIncreaseCount += 1;
      if (paramLong >= 2000L) {
        this.cbExceedCount += 1;
      }
    }
    paramLong = SystemClock.elapsedRealtime();
    Object localObject1;
    long l2;
    long l1;
    int i;
    int j;
    if (this.cbLastUpdateSPTime > 0L)
    {
      if (paramLong - this.cbLastUpdateSPTime > 600000L) {
        paramBoolean = true;
      }
      if ((paramBoolean) && (this.cbIncreaseTime > 0L))
      {
        paramLong = System.currentTimeMillis();
        localObject1 = this.mApplicaiton.getSharedPreferences("msf_cb_report", 0);
        l2 = ((SharedPreferences)localObject1).getLong("cbLastReportTime", paramLong);
        l1 = ((SharedPreferences)localObject1).getLong("cbTotalTime", 0L);
        l1 = this.cbIncreaseTime + l1;
        i = ((SharedPreferences)localObject1).getInt("cbTotalCount", 0);
        j = this.cbIncreaseCount + i;
        i = ((SharedPreferences)localObject1).getInt("cbExceedCount", 0) + this.cbExceedCount;
        if (paramLong - l2 < 86400000L) {
          break label512;
        }
        l2 = 0L;
        if (j > 0) {
          l2 = l1 / j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "reportMSFCallBackCost-->cbTotalTime:" + l1 + " ,cbTotalCount:" + j + " ,cbAverageTime:" + l2);
        }
        Object localObject2 = new RdmReq();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cbAverageTime", String.valueOf(l2));
        localHashMap.put("cbTotalCount", String.valueOf(j));
        localHashMap.put("cbExceedCount", String.valueOf(i));
        ((RdmReq)localObject2).eventName = "MSFCallBackAvgCost";
        ((RdmReq)localObject2).elapse = l2;
        ((RdmReq)localObject2).size = 0L;
        ((RdmReq)localObject2).isSucceed = true;
        ((RdmReq)localObject2).isRealTime = false;
        ((RdmReq)localObject2).params = localHashMap;
        localObject2 = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject2);
        ((ToServiceMsg)localObject2).extraData.putLong("sendTime", System.currentTimeMillis());
        this.msfSub.sendMsg((ToServiceMsg)localObject2);
        l2 = 0L;
        j = 0;
        i = 0;
        l1 = paramLong;
        paramLong = l2;
      }
    }
    for (;;)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("cbLastReportTime", l1);
      ((SharedPreferences.Editor)localObject1).putLong("cbTotalTime", paramLong);
      ((SharedPreferences.Editor)localObject1).putInt("cbTotalCount", j);
      ((SharedPreferences.Editor)localObject1).putInt("cbExceedCount", i);
      ((SharedPreferences.Editor)localObject1).commit();
      this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
      this.cbIncreaseTime = 0L;
      this.cbIncreaseCount = 0;
      this.cbExceedCount = 0;
      return;
      this.cbLastUpdateSPTime = paramLong;
      break;
      label512:
      if (l2 > paramLong)
      {
        l2 = paramLong;
        paramLong = l1;
        l1 = l2;
      }
      else
      {
        paramLong = l1;
        l1 = l2;
      }
    }
  }
  
  void sendMessageToMSF(ToServiceMsg paramToServiceMsg, MSFServlet paramMSFServlet)
  {
    if (paramToServiceMsg.getServiceName() == null) {
      paramToServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
    }
    this.mRequestServlets.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramMSFServlet.getClass());
    paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
    paramToServiceMsg.extraData.putString("moduleId", paramMSFServlet.getAppRuntime().getModuleId());
    this.msfSub.sendMsg(paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "[MSF Send]" + paramToServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + paramMSFServlet.getAppRuntime().getClass().getSimpleName() + "@" + paramMSFServlet.getAppRuntime().hashCode() + "  from " + paramMSFServlet.getClass().getSimpleName());
    }
    if (sCmdCallback != null) {
      sCmdCallback.onCmdRequest(paramToServiceMsg.getServiceCmd());
    }
  }
  
  public void setInterceptKickListener(AppRuntime.InterceptKickListener paramInterceptKickListener)
  {
    this.mInterceptKickListener = paramInterceptKickListener;
  }
  
  public void start()
  {
    if (this.msfRecvThread == null)
    {
      this.msfRecvThread = new Thread(this.MSFReceiver, "MSF-Receiver");
      QLog.d(TAG, 1, "start MSF-Receiver " + this.msfRecvThread.getId());
      if ((this.mApplicaiton == null) || (this.mApplicaiton.getQQProcessName() == null) || (!this.mApplicaiton.getQQProcessName().endsWith(":video"))) {
        break label130;
      }
      this.msfRecvThread.setPriority(10);
    }
    for (;;)
    {
      this.msfRecvThread.start();
      if (sRegulatorCallback != null) {
        this.recvThreadRegulatoring = sRegulatorCallback.regulatorThread(this.msfRecvThread);
      }
      return;
      label130:
      this.msfRecvThread.setPriority(5);
    }
  }
  
  class MyErrorHandler
    implements IErrorHandler
  {
    private static final String SEC_TAG = "sec_sig_tag";
    
    private MyErrorHandler() {}
    
    private void onInterceptKicked(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppRuntime.InterceptKickListener localInterceptKickListener = MainService.this.mInterceptKickListener;
      if (localInterceptKickListener != null)
      {
        localInterceptKickListener.onInterceptKicked(new AppRuntime.KickParams(paramToServiceMsg, paramFromServiceMsg, paramBoolean2, paramBoolean1));
        return;
      }
      onKickedInternal(paramToServiceMsg, paramFromServiceMsg, paramBoolean2, paramBoolean1);
    }
    
    private void popupNotification(String paramString1, String paramString2, String paramString3, String paramString4, Constants.LogoutReason paramLogoutReason, boolean paramBoolean)
    {
      popupNotification(paramString1, paramString2, paramString3, paramString4, paramLogoutReason, paramBoolean, "");
    }
    
    private void popupNotification(String paramString1, String paramString2, String paramString3, String paramString4, Constants.LogoutReason paramLogoutReason, boolean paramBoolean, String paramString5)
    {
      AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if ((localAppRuntime != null) && (QLog.isColorLevel())) {
        QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification isSameDevice = " + paramBoolean + "; runnbackGroud = " + localAppRuntime.isBackground_Stop + ";action = " + paramString1 + "; mApplicaiton.getProcessName() = " + MainService.this.mApplicaiton.getQQProcessName());
      }
      localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.3(this, paramString2, localAppRuntime, paramLogoutReason, paramString1, paramString3, paramString4, paramBoolean, paramString5));
    }
    
    private void popupNotificationEx(String paramString1, String paramString2, String paramString3, String paramString4, Constants.LogoutReason paramLogoutReason, byte[] paramArrayOfByte)
    {
      AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "popupNotificationEx");
      }
      localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.2(this, paramString2, localAppRuntime, paramLogoutReason, paramString1, paramString3, paramString4, paramArrayOfByte));
    }
    
    public void onGrayError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError start");
      }
      if ((MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "onGrayError:" + paramFromServiceMsg);
        }
        MainService.this.receiveMessageFromMSF(paramToServiceMsg, paramFromServiceMsg);
      }
      MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramToServiceMsg = (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd(), "false");
      new Handler(Looper.getMainLooper()).postDelayed(new MainService.MyErrorHandler.4(this, paramFromServiceMsg, paramToServiceMsg, paramBoolean), 500L);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError end");
      }
    }
    
    public void onInvalidSign(boolean paramBoolean)
    {
      AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (localAppRuntime != null) {
        localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.1(this));
      }
    }
    
    public void onKicked(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked start");
      }
      onInterceptKicked(paramToServiceMsg, paramFromServiceMsg, paramBoolean, false);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked end");
      }
    }
    
    public void onKickedAndClearToken(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken start");
      }
      onInterceptKicked(paramToServiceMsg, paramFromServiceMsg, paramBoolean, true);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken end");
      }
    }
    
    void onKickedInternal(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean1, boolean paramBoolean2)
    {
      boolean bool = false;
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired start");
        }
        MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
        MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        paramToServiceMsg = (RequestMSFForceOffline)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "RequestMSFForceOffline", new RequestMSFForceOffline());
        if (paramToServiceMsg.bSigKick == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick == 1");
          }
          popupNotificationEx("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), paramToServiceMsg.strTitle, paramToServiceMsg.strInfo, Constants.LogoutReason.secKicked, paramToServiceMsg.vecSigKickData);
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired end");
          }
        }
      }
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick != 1");
        }
        popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), paramToServiceMsg.strTitle, paramToServiceMsg.strInfo, Constants.LogoutReason.kicked, paramBoolean2);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start");
        }
        MainService.this.mApplicaiton.setAutoLogin(false);
        paramToServiceMsg = (RequestPushForceOffline)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "req_PushForceOffline", new RequestPushForceOffline());
        if (paramToServiceMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start req != null");
          }
          paramFromServiceMsg = paramFromServiceMsg.getUin();
          String str1 = paramToServiceMsg.strTitle;
          String str2 = paramToServiceMsg.strTips;
          Constants.LogoutReason localLogoutReason = Constants.LogoutReason.forceLogout;
          paramBoolean1 = bool;
          if (paramToServiceMsg.bSameDevice == 1) {
            paramBoolean1 = true;
          }
          popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg, str1, str2, localLogoutReason, paramBoolean1);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired end");
          return;
          popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), null, null, Constants.LogoutReason.forceLogout, false);
        }
      }
    }
    
    public void onRecvServerTip(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      String str = paramFromServiceMsg.getBusinessFailMsg();
      String[] arrayOfString = str.split("\\n");
      int i = str.indexOf("\n");
      paramToServiceMsg = str;
      if (i != -1) {
        paramToServiceMsg = str.substring(i + 1);
      }
      popupNotification("mqq.intent.action.ACCOUNT_TIPS", paramFromServiceMsg.getUin(), arrayOfString[0], paramToServiceMsg, Constants.LogoutReason.tips, paramBoolean);
    }
    
    public void onServerSuspended(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended start");
      }
      if (paramToServiceMsg == null) {
        popupNotification("mqq.intent.action.SUSPEND", paramFromServiceMsg.getUin(), null, paramFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.suspend, paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended end");
      }
    }
    
    public void onUserTokenExpired(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked...onUserTokenExpired start");
      }
      MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      popupNotification("mqq.intent.action.ACCOUNT_EXPIRED", paramFromServiceMsg.getUin(), null, paramFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.expired, paramBoolean, paramFromServiceMsg.getServiceCmd());
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked....onUserTokenExpired end ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MainService
 * JD-Core Version:    0.7.0.1
 */