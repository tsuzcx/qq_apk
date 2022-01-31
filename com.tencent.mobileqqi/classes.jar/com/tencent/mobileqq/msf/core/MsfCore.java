package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.auth.h;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.d.f;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.m;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfCore
{
  public static final String KEY_MOBILEQQAPPID = "key_mobileQQAppid";
  public static final String MOBILEQQSDROOT_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent";
  private static final String OLDKSID_PATH = Environment.getExternalStorageDirectory().getPath() + "/msf";
  static String SAVEPATH_IMEI = MOBILEQQSDROOT_PATH + "/imei";
  public static final int SysVerSion = Build.VERSION.SDK_INT;
  public static int mobileQQAppid = -1;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MSF.C.MsfCore";
  private b accountCenter;
  public a configManager;
  AtomicBoolean coreInitFinished = new AtomicBoolean();
  public AtomicBoolean isReconnectSso = new AtomicBoolean();
  public AtomicBoolean mbIsInfoLoginGetted = new AtomicBoolean();
  i msfAlarmer;
  private int msfAppid = -1;
  LinkedBlockingQueue msfMessagePairs = new LinkedBlockingQueue();
  public com.tencent.mobileqq.msf.core.d.c netFlowStore;
  public volatile String nowSocketConnAdd;
  public e pushManager;
  public l sender;
  com.tencent.mobileqq.msf.core.a.d ssoListManager;
  private n ssoRespHandler;
  public com.tencent.mobileqq.msf.core.d.j statReporter;
  k store;
  AtomicBoolean suspended = new AtomicBoolean(false);
  public SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
  private h wtLoginCenter;
  
  public static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(new Random().nextInt(100000) + 60000);
      }
      return i;
    }
    finally {}
  }
  
  public static void initAppProMsg(String paramString, int paramInt)
  {
    int i = com.tencent.mobileqq.msf.sdk.n.d();
    FromServiceMsg localFromServiceMsg = new FromServiceMsg("0", "cmd_pushSetConfig");
    localFromServiceMsg.setAppId(paramInt);
    localFromServiceMsg.setMsfCommand(MsfCommand.pushSetConfig);
    MsfSdkUtils.addFromMsgProcessName(paramString, localFromServiceMsg);
    localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), Integer.valueOf(i));
    localFromServiceMsg.addAttribute("_attr_socket_connstate", Integer.valueOf(NetConnInfoCenter.socketConnState));
    localFromServiceMsg.addAttribute("_attr_server", Long.valueOf(NetConnInfoCenter.servetTimeSecondInterv));
    localFromServiceMsg.addAttribute("_attr_deviceGUID", h.a());
    localFromServiceMsg.setMsgSuccess();
    com.tencent.mobileqq.msf.service.d.a("*", null, localFromServiceMsg);
  }
  
  public int ChangeUinLogin(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg, true);
    }
    return this.accountCenter.c(paramToServiceMsg);
  }
  
  public void addRespToQuque(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l2;
    long l3;
    Object localObject;
    String str;
    boolean bool;
    if (paramToServiceMsg != null)
    {
      long l1;
      if (paramFromServiceMsg.isSuccess())
      {
        if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
        {
          l1 = System.currentTimeMillis();
          l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
          l3 = com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
          localObject = "0";
          str = "0";
          if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
            localObject = (String)paramToServiceMsg.getAttribute("_tag_socket");
          }
          if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
            str = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
          }
          getStatReporter().a(true, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str, paramFromServiceMsg.getServiceCmd().equals("login.chguin"), 0L);
          if (paramFromServiceMsg.getServiceCmd().equals("login.chguin"))
          {
            paramToServiceMsg.setUin((String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
            localObject = new byte[0];
            if (paramFromServiceMsg.getAttribute("__base_tag_sigSession") != null) {
              localObject = (byte[])paramFromServiceMsg.getAttribute("__base_tag_sigSession");
            }
            paramToServiceMsg.setRequestSsoSeq(getNextSeq());
            paramToServiceMsg.setServiceCmd("login.auth");
            this.accountCenter.a(paramToServiceMsg, 16, 0, (byte[])localObject);
          }
        }
      }
      else if (paramFromServiceMsg.getResultCode() == 1012)
      {
        if (paramToServiceMsg.getAttribute("to_login_alsoCheckTime") == null)
        {
          paramToServiceMsg.addAttribute("to_login_alsoCheckTime", Integer.valueOf(1));
          if (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin)
          {
            ChangeUinLogin(paramToServiceMsg);
            return;
          }
          if (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth)
          {
            login(paramToServiceMsg);
            return;
          }
          if (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin) {
            wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
          }
        }
      }
      else if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) && (paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")))
      {
        l2 = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        l3 = com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
        localObject = "0";
        str = "0";
        if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
          localObject = (String)paramToServiceMsg.getAttribute("_tag_socket");
        }
        if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
          str = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
        }
        bool = paramFromServiceMsg.getServiceCmd().equals("login.chguin");
        if (paramFromServiceMsg.getBusinessFailCode() != 1002) {
          break label738;
        }
        l1 = 0L;
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {
          break label712;
        }
        if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        }
        getStatReporter().a(false, l2, 1014, l3, (String)localObject, str, bool, l1);
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.getAttributes().containsKey("to_login_changeuin"))
      {
        localObject = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
        paramFromServiceMsg.addAttribute("to_login_changeuin", paramFromServiceMsg.getUin());
        paramToServiceMsg.setUin((String)localObject);
      }
      if (paramToServiceMsg.getAttributes().containsKey("to_srcCmd"))
      {
        localObject = (String)paramToServiceMsg.getAttribute("to_srcCmd");
        paramToServiceMsg.setServiceCmd((String)localObject);
        paramFromServiceMsg.setServiceCmd((String)localObject);
      }
      if ((paramToServiceMsg == null) && (paramFromServiceMsg.isSuccess()) && (!paramFromServiceMsg.getUin().equals("0")))
      {
        localObject = getAccountCenter().h(paramFromServiceMsg.getUin());
        if (localObject != null) {
          paramFromServiceMsg.addAttribute("__attribute_tag_sid", localObject);
        }
      }
      if (paramToServiceMsg != null) {
        paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      }
      paramFromServiceMsg.addAttribute("__timestamp_msf2app", Long.valueOf(System.currentTimeMillis()));
      this.msfMessagePairs.add(new MsfMessagePair(paramToServiceMsg, paramFromServiceMsg));
      return;
      label712:
      getStatReporter().a(false, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str, bool, 0L);
      continue;
      label738:
      if (paramFromServiceMsg.getBusinessFailCode() == 2008) {
        getStatReporter().a(paramToServiceMsg.getUin(), false, l2, paramFromServiceMsg.getBusinessFailCode(), l3);
      } else {
        getStatReporter().a(true, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str, bool, 0L);
      }
    }
  }
  
  public int changeTokenAfterLogin(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.b(paramToServiceMsg, paramBoolean);
    }
    return this.accountCenter.a(paramToServiceMsg, paramBoolean);
  }
  
  public b getAccountCenter()
  {
    return this.accountCenter;
  }
  
  public i getMsfAlarmer()
  {
    return this.msfAlarmer;
  }
  
  public int getMsfAppid()
  {
    return this.msfAppid;
  }
  
  public LinkedBlockingQueue getMsfMessagePairs()
  {
    return this.msfMessagePairs;
  }
  
  public com.tencent.mobileqq.msf.core.d.c getNetFlowStore()
  {
    return this.netFlowStore;
  }
  
  public void getPluginConfig(ToServiceMsg paramToServiceMsg)
  {
    this.configManager.a(paramToServiceMsg);
  }
  
  public com.tencent.mobileqq.msf.core.a.d getSsoListManager()
  {
    return this.ssoListManager;
  }
  
  public n getSsoRespHandler()
  {
    return this.ssoRespHandler;
  }
  
  public com.tencent.mobileqq.msf.core.d.j getStatReporter()
  {
    return this.statReporter;
  }
  
  public int getUinPushStatus(String paramString)
  {
    return this.pushManager.a(paramString);
  }
  
  public h getWtLoginCenter()
  {
    return this.wtLoginCenter;
  }
  
  public void handleAccountSyncRequest(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    paramContext = paramContext.getPackageName();
    this.accountCenter.c.a(paramToServiceMsg, arrayOfString, paramContext, paramInt);
  }
  
  public String handleGetAccountKey(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), new String[] { BaseApplication.getContext().getPackageName() });
    int i;
    int j;
    int k;
    if (paramToServiceMsg != null)
    {
      paramContext = new String[paramToServiceMsg.length];
      i = 0;
      while (i < paramContext.length)
      {
        paramContext[i] = MD5.toMD5(paramToServiceMsg[i].toCharsString()).toLowerCase();
        i += 1;
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), paramInt);
      if (paramToServiceMsg == null) {
        break label189;
      }
      j = 0;
      paramInt = 0;
      i = paramInt;
      if (j < paramToServiceMsg.length)
      {
        String str = MD5.toMD5(paramToServiceMsg[j].toCharsString()).toLowerCase();
        int m = paramContext.length;
        k = 0;
        label121:
        i = paramInt;
        if (k < m)
        {
          if (!paramContext[k].equals(str)) {
            break label164;
          }
          i = 1;
        }
        if (i == 0) {
          break label173;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return this.accountCenter.h();
        label164:
        k += 1;
        break label121;
        label173:
        j += 1;
        paramInt = i;
        break;
      }
      return "";
      label189:
      i = 0;
    }
  }
  
  public boolean init(Context paramContext, boolean paramBoolean)
  {
    int i = -1;
    QLog.d("MSF.C.MsfCore", 1, "MsfCore init begin.");
    this.mbIsInfoLoginGetted.set(false);
    for (;;)
    {
      try
      {
        int k = c.g(paramContext);
        int j = c.e(paramContext);
        if ((k != -1) && (j != -1) && (j == k)) {
          break label895;
        }
        bool = true;
        i = j;
      }
      catch (Exception localException2)
      {
        try
        {
          localFile = new File(MOBILEQQSDROOT_PATH);
          if (localFile.exists()) {
            continue;
          }
          localFile.mkdirs();
          localFile = new File(OLDKSID_PATH);
          if ((!localFile.exists()) || (!localFile.isDirectory())) {
            continue;
          }
          localFile.delete();
        }
        catch (Exception localException2)
        {
          try
          {
            c.a(paramContext, c.c(paramContext), bool, i, new String[] { "libcodecwrapperV2.so", "libmsfbootV2.so", "libNativeRQD.so", "libwtecdh.so" });
            try
            {
              this.store = new k(this);
              if (this.store.a(paramContext)) {
                break label352;
              }
              QLog.e("MSF.C.MsfCore", 1, "MsfStore init fail");
              return false;
            }
            catch (Exception paramContext)
            {
              QLog.e("MSF.C.MsfCore", 1, "MsfStore init error " + paramContext);
              return false;
            }
            localException1 = localException1;
            QLog.e("MSF.C.MsfCore", 1, "checkAppVersionCode error " + localException1, localException1);
            bool = true;
            continue;
            localException2 = localException2;
            QLog.e("MSF.C.MsfCore", 1, "File operation error " + localException2);
            continue;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.d("MSF.C.MsfCore", 1, "cp txlib error " + localException3);
            continue;
          }
        }
      }
      SAVEPATH_IMEI = paramContext.getFilesDir() + "/imei";
      j.c();
      try
      {
        File localFile;
        label352:
        String str = k.a().getConfig("key_mobileQQAppid");
        if ((str != null) && (str.length() > 0))
        {
          mobileQQAppid = Integer.parseInt(str);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.MsfCore", 2, "load mobileQQAppid " + mobileQQAppid);
          }
        }
        f.a();
      }
      catch (Exception localException7)
      {
        try
        {
          this.msfAlarmer = new i(this);
          this.msfAlarmer.a();
        }
        catch (Exception localException7)
        {
          try
          {
            this.configManager = new a(this);
            this.configManager.a();
          }
          catch (Exception localException7)
          {
            try
            {
              this.ssoListManager = new com.tencent.mobileqq.msf.core.a.d(this);
              this.ssoListManager.a();
              this.statReporter = new com.tencent.mobileqq.msf.core.d.j(this);
              this.statReporter.a();
            }
            catch (Exception localException7)
            {
              try
              {
                for (;;)
                {
                  NetConnInfoCenter.init(this);
                  NetConnInfoCenter.checkConnInfo(paramContext, true);
                  try
                  {
                    this.sender = new l(this);
                    if (this.sender.a(paramContext)) {
                      break;
                    }
                    QLog.e("MSF.C.MsfCore", 1, "Sender init fail");
                    return false;
                  }
                  catch (Exception paramContext)
                  {
                    QLog.e("MSF.C.MsfCore", 1, "Sender init failed " + paramContext);
                    return false;
                  }
                  localException4 = localException4;
                  QLog.e("MSF.C.MsfCore", 1, "load mobileQQAppid failed " + localException4);
                  continue;
                  localException5 = localException5;
                  QLog.e("MSF.C.MsfCore", 1, "msfAlarmer init failed " + localException5);
                  continue;
                  localException6 = localException6;
                  QLog.e("MSF.C.MsfCore", 1, "configManager init failed " + localException6);
                }
                localException7 = localException7;
                QLog.e("MSF.C.MsfCore", 1, "SsoListManager init failed " + localException7);
              }
              catch (Exception localException8)
              {
                for (;;)
                {
                  QLog.e("MSF.C.MsfCore", 1, "MsfCore init netConnInfoCenter error " + localException8, localException8);
                }
                this.accountCenter.a();
              }
            }
          }
        }
      }
      this.wtLoginCenter = new h();
      this.wtLoginCenter.a(this);
      this.accountCenter = new b(this);
      this.accountCenter.a(true);
      this.ssoRespHandler = new n(this);
      try
      {
        this.pushManager = new e(this);
        this.pushManager.a(paramContext, paramBoolean);
        if (!bool) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          this.configManager.a("0", 60000);
          this.coreInitFinished.set(true);
          QLog.d("MSF.C.MsfCore", 1, "MsfCore init finished.");
          return true;
          paramContext = paramContext;
          QLog.e("MSF.C.MsfCore", 1, "PushManager init failed " + paramContext);
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.MsfCore", 2, paramContext.toString(), paramContext);
            }
          }
        }
      }
      label895:
      boolean bool = false;
    }
  }
  
  public boolean isSuspended()
  {
    return this.suspended.get();
  }
  
  public boolean isUseWtlogin()
  {
    return a.g();
  }
  
  public int login(ToServiceMsg paramToServiceMsg)
  {
    return login(paramToServiceMsg, 16, 0, new byte[0]);
  }
  
  public int login(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MsfCore", 2, "recv " + paramToServiceMsg.getUin() + " login req");
    }
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg, false);
    }
    return this.accountCenter.a(paramToServiceMsg, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void proxyRegister(com.tencent.mobileqq.msf.sdk.l paraml, ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paraml, paramToServiceMsg);
  }
  
  public void proxyUnRegister(String paramString, ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramString, paramToServiceMsg);
  }
  
  public void reSendMsg(ToServiceMsg paramToServiceMsg)
  {
    this.sender.b(paramToServiceMsg);
  }
  
  public int refreVerifycode(ToServiceMsg paramToServiceMsg)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg);
    }
    return this.accountCenter.b(paramToServiceMsg);
  }
  
  public void refreshWebviewTickets(String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg("", paramString1, "login.chgTok_WEBVIEW_KEY");
    paramString1.setMsfCommand(MsfCommand._msf_refreToken);
    paramString1.setRequestSsoSeq(getNextSeq());
    paramString1.setAppId(getMsfAppid());
    paramString1.setTimeout(30000L);
    paramString1.getAttributes().put("refresh_token_src", paramString2);
    changeTokenAfterLogin(paramString1, true);
  }
  
  public void registerCmdCall(ToServiceMsg paramToServiceMsg)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = m.a(paramToServiceMsg);
    this.pushManager.a(localCommandCallbackerInfo, paramToServiceMsg);
  }
  
  public void registerPush(ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramToServiceMsg, com.tencent.mobileqq.msf.core.c.j.b);
  }
  
  public int report(ToServiceMsg paramToServiceMsg)
  {
    return this.configManager.b(paramToServiceMsg);
  }
  
  public void resume()
  {
    this.suspended.set(false);
  }
  
  public int sendSsoMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    this.sender.b(paramToServiceMsg);
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public void setMsfAppid(int paramInt)
  {
    this.msfAppid = paramInt;
  }
  
  public int submitVerifycode(ToServiceMsg paramToServiceMsg)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.b(paramToServiceMsg);
    }
    return this.accountCenter.a(paramToServiceMsg);
  }
  
  public void suspend()
  {
    this.suspended.set(true);
  }
  
  public boolean syncDelAccount(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd());
    this.accountCenter.c(paramToServiceMsg);
    return true;
  }
  
  public ArrayList syncGetLoginedAccountList()
  {
    return this.accountCenter.d();
  }
  
  public String syncGetServerConfig(ToServiceMsg paramToServiceMsg)
  {
    return this.configManager.c(paramToServiceMsg);
  }
  
  public void unRegisterCmdCall(ToServiceMsg paramToServiceMsg)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = m.a(paramToServiceMsg);
    this.pushManager.b(localCommandCallbackerInfo, paramToServiceMsg);
  }
  
  public void unRegisterPush(ToServiceMsg paramToServiceMsg)
  {
    PushRegisterInfo localPushRegisterInfo = m.b(paramToServiceMsg);
    this.pushManager.a(localPushRegisterInfo, paramToServiceMsg);
  }
  
  public void wt_AskDevLockSms(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.q(paramToServiceMsg);
  }
  
  public void wt_CheckDevLockSms(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.r(paramToServiceMsg);
  }
  
  public void wt_CheckDevLockStatus(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.p(paramToServiceMsg);
  }
  
  public void wt_CheckPictureAndGetSt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.k(paramToServiceMsg);
  }
  
  public void wt_CheckSMSAndGetSt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.v(paramToServiceMsg);
  }
  
  public void wt_CheckSMSAndGetStExt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.w(paramToServiceMsg);
  }
  
  public void wt_CheckSMSVerifyLoginAccount(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.y(paramToServiceMsg);
  }
  
  public void wt_CloseCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.n(paramToServiceMsg);
  }
  
  public void wt_CloseDevLock(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.s(paramToServiceMsg);
  }
  
  public void wt_GetA1WithA1(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.o(paramToServiceMsg);
  }
  
  public void wt_GetStViaSMSVerifyLogin(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.B(paramToServiceMsg);
  }
  
  public void wt_GetStWithPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.i(paramToServiceMsg);
  }
  
  public void wt_GetStWithoutPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.j(paramToServiceMsg);
  }
  
  public void wt_RefreshPictureData(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.l(paramToServiceMsg);
  }
  
  public void wt_RefreshSMSData(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.u(paramToServiceMsg);
  }
  
  public void wt_RefreshSMSVerifyLoginCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.z(paramToServiceMsg);
  }
  
  public void wt_RegGetSMSVerifyLoginAccount(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.x(paramToServiceMsg);
  }
  
  public void wt_VerifyCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.m(paramToServiceMsg);
  }
  
  public void wt_VerifySMSVerifyLoginCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.A(paramToServiceMsg);
  }
  
  public void wt_setRegDevLockFlag(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.t(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfCore
 * JD-Core Version:    0.7.0.1
 */