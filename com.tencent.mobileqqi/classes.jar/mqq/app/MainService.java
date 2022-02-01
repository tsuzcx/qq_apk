package mqq.app;

import PushNotifyPack.RequestPushForceOffline;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
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
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;
import mqq.manager.VerifyCodeManager;
import mqq.manager.VerifyDevLockManager;

public class MainService
{
  public static final String MSFPROCESSNAMETAG = ":MSF";
  public static final String QQPROCESSNAME = "com.tencent.mobileqqi";
  private static final String TAG = MainService.class.getSimpleName();
  public static boolean isDebugVersion = false;
  public static final String msfServiceName = "com.tencent.mobileqq.msf.service.MsfService";
  public static final String uinNotMatchTag = "uinNotMatch";
  private final Runnable MSFReceiver = new Runnable()
  {
    private void handleResp(MsfMessagePair paramAnonymousMsfMessagePair)
    {
      paramAnonymousMsfMessagePair.fromServiceMsg.setAppSeq(paramAnonymousMsfMessagePair.toServiceMsg.getAppSeq());
      MainService.this.msfRespHandleUtil.handleRespMsg(paramAnonymousMsfMessagePair.toServiceMsg, paramAnonymousMsfMessagePair.fromServiceMsg);
    }
    
    public void run()
    {
      Object localObject1 = null;
      VerifyDevLockManager localVerifyDevLockManager = null;
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        MsfMessagePair localMsfMessagePair;
        try
        {
          localObject2 = MainService.this.mApplicaiton.waitAppRuntime(null);
          if (localObject2 != null)
          {
            localObject1 = (VerifyCodeManager)((AppRuntime)localObject2).getManager(6);
            localVerifyDevLockManager = (VerifyDevLockManager)((AppRuntime)localObject2).getManager(7);
          }
          localObject3 = null;
          localMsfMessagePair = MainService.this.msfSub.getServiceRespMsg();
          localObject2 = localObject3;
          if (localMsfMessagePair != null)
          {
            if (localMsfMessagePair.toServiceMsg != null) {
              break label201;
            }
            localObject1 = localMsfMessagePair.fromServiceMsg;
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (!MainService.this.msfRespHandleUtil.handlePushMsg((FromServiceMsg)localObject1))
              {
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.w("mqq", 2, "[MSF Receive] No handler for " + ((FromServiceMsg)localObject1).getServiceCmd());
                  localObject2 = localObject1;
                }
              }
            }
          }
          if ((localObject2 != null) || (localMsfMessagePair != null)) {
            break;
          }
          MainService.this.msfSub.queueWait();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("mqq", 2, "[MSF Receive]" + localException.toString());
          }
          localException.printStackTrace();
        }
        break;
        label201:
        if ((localException != null) && (localVerifyDevLockManager != null))
        {
          localObject2 = localObject3;
          if (localException.checkVerifyCodeResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
          {
            localObject2 = localObject3;
            if (localVerifyDevLockManager.checkVerifyDevLockSmsResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
            {
              handleResp(localMsfMessagePair);
              localObject2 = localObject3;
            }
          }
        }
        else
        {
          handleResp(localMsfMessagePair);
          localObject2 = localObject3;
        }
      }
    }
  };
  private IAuthHandler authHandler = new IAuthHandler()
  {
    public void onDelLoginedAccountResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetKeyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetSidResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.attributes.put("sid", paramAnonymousString2);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetUinSignResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, byte[] paramAnonymousArrayOfByte)
    {
      paramAnonymousFromServiceMsg.attributes.put(paramAnonymousFromServiceMsg.getServiceCmd(), paramAnonymousArrayOfByte);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onReceVerifyCode(VerifyCodeInfo paramAnonymousVerifyCodeInfo, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.addAttribute("VerifyCodeInfo", paramAnonymousVerifyCodeInfo);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvChangeTokenResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, RespondCustomSig paramAnonymousRespondCustomSig, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      if (paramAnonymousRespondCustomSig != null)
      {
        paramAnonymousString = paramAnonymousRespondCustomSig.SigList.iterator();
        while (paramAnonymousString.hasNext())
        {
          paramAnonymousRespondCustomSig = (CustomSigContent)paramAnonymousString.next();
          if (paramAnonymousRespondCustomSig.ulSigType == 14L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = HexUtil.bytes2HexStr(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("vkey", paramAnonymousRespondCustomSig);
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 8L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = HexUtil.bytes2HexStr(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("STwxWeb", paramAnonymousRespondCustomSig);
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 13L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = paramAnonymousFromServiceMsg.getAttribute(paramAnonymousFromServiceMsg.getServiceCmd());
              if ((paramAnonymousRespondCustomSig != null) && ((paramAnonymousRespondCustomSig instanceof ArrayList)))
              {
                paramAnonymousRespondCustomSig = (ArrayList)paramAnonymousRespondCustomSig;
                paramAnonymousFromServiceMsg.attributes.put("arrD3", paramAnonymousRespondCustomSig);
              }
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 19L)
          {
            if ((paramAnonymousRespondCustomSig.sResult == 0) && (paramAnonymousRespondCustomSig.SigContent != null))
            {
              paramAnonymousRespondCustomSig = new String(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("skey", paramAnonymousRespondCustomSig);
            }
            else
            {
              try
              {
                paramAnonymousRespondCustomSig = new String(paramAnonymousRespondCustomSig.SigContent, "utf-8");
                paramAnonymousFromServiceMsg.attributes.put("skeyError", paramAnonymousRespondCustomSig);
              }
              catch (UnsupportedEncodingException paramAnonymousRespondCustomSig)
              {
                paramAnonymousRespondCustomSig.printStackTrace();
              }
            }
          }
          else if ((paramAnonymousRespondCustomSig.ulSigType == 21L) && (paramAnonymousRespondCustomSig.sResult == 0))
          {
            paramAnonymousRespondCustomSig = paramAnonymousRespondCustomSig.SigContent;
            paramAnonymousFromServiceMsg.attributes.put("superkey", paramAnonymousRespondCustomSig);
          }
        }
      }
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvChangeUinLoginResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      paramAnonymousString = (String)paramAnonymousToServiceMsg.getAttribute("from_where");
      paramAnonymousInt1 = 1;
      if (("subaccount".equals(paramAnonymousString)) || ("ssoAccountAction".equals(paramAnonymousString))) {
        paramAnonymousInt1 = 0;
      }
      if ((paramAnonymousFromServiceMsg.isSuccess()) && (paramAnonymousInt1 != 0))
      {
        paramAnonymousString = SimpleAccount.parseSimpleAccount((String)paramAnonymousFromServiceMsg.getAttribute("resp_simpleAccount"));
        MainService.this.mApplicaiton.createNewRuntime(paramAnonymousString, true, true, 4);
      }
    }
    
    public void onRecvChangeUinResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvLoginResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      paramAnonymousString = (String)paramAnonymousToServiceMsg.getAttribute("from_where");
      paramAnonymousInt1 = 1;
      if (("subaccount".equals(paramAnonymousString)) || ("ssoAccountAction".equals(paramAnonymousString))) {
        paramAnonymousInt1 = 0;
      }
      if ((paramAnonymousFromServiceMsg.isSuccess()) && (paramAnonymousInt1 != 0))
      {
        paramAnonymousString = SimpleAccount.parseSimpleAccount((String)paramAnonymousFromServiceMsg.getAttribute("resp_simpleAccount"));
        MainService.this.mApplicaiton.createNewRuntime(paramAnonymousString, true, true, 3);
      }
    }
    
    public void onRefreSidResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.attributes.put("sid", paramAnonymousString);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private IErrorHandler errorHandler = new IErrorHandler()
  {
    private static final String SEC_TAG = "sec_sig_tag";
    
    private void onKicked(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      boolean bool = false;
      if (paramAnonymousBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired start");
        }
        MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
        MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        paramAnonymousToServiceMsg = (RequestMSFForceOffline)Packet.decodePacket(paramAnonymousFromServiceMsg.getWupBuffer(), "RequestMSFForceOffline", new RequestMSFForceOffline());
        if (paramAnonymousToServiceMsg.bSigKick == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick == 1");
          }
          popupNotificationEx("mqq.i.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), paramAnonymousToServiceMsg.strTitle, paramAnonymousToServiceMsg.strInfo, Constants.LogoutReason.secKicked, paramAnonymousToServiceMsg.vecSigKickData);
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
        popupNotification("mqq.i.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), paramAnonymousToServiceMsg.strTitle, paramAnonymousToServiceMsg.strInfo, Constants.LogoutReason.kicked, paramAnonymousBoolean2);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start");
        }
        MainService.this.mApplicaiton.setAutoLogin(false);
        paramAnonymousToServiceMsg = (RequestPushForceOffline)Packet.decodePacket(paramAnonymousFromServiceMsg.getWupBuffer(), "req_PushForceOffline", new RequestPushForceOffline());
        if (paramAnonymousToServiceMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start req != null");
          }
          paramAnonymousFromServiceMsg = paramAnonymousFromServiceMsg.getUin();
          String str1 = paramAnonymousToServiceMsg.strTitle;
          String str2 = paramAnonymousToServiceMsg.strTips;
          Constants.LogoutReason localLogoutReason = Constants.LogoutReason.forceLogout;
          paramAnonymousBoolean1 = bool;
          if (paramAnonymousToServiceMsg.bSameDevice == 1) {
            paramAnonymousBoolean1 = true;
          }
          popupNotification("mqq.i.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg, str1, str2, localLogoutReason, paramAnonymousBoolean1);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired end");
          return;
          popupNotification("mqq.i.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), null, null, Constants.LogoutReason.forceLogout, false);
        }
      }
    }
    
    private void popupNotification(final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4, final Constants.LogoutReason paramAnonymousLogoutReason, final boolean paramAnonymousBoolean)
    {
      final AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if ((localAppRuntime != null) && (QLog.isColorLevel())) {
        QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification isSameDevice = " + paramAnonymousBoolean + "; runnbackGroud = " + localAppRuntime.isBackground_Stop + ";action = " + paramAnonymousString1 + "; mApplicaiton.getProcessName() = " + MainService.this.mApplicaiton.getProcessNames());
      }
      localAppRuntime.runOnUiThread(new Runnable()
      {
        public void run()
        {
          boolean bool;
          Intent localIntent;
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.equals(localAppRuntime.getAccount())))
          {
            bool = true;
            if (paramAnonymousLogoutReason != Constants.LogoutReason.expired) {
              break label387;
            }
            if (!localAppRuntime.isLogin()) {
              bool = false;
            }
            if ((paramAnonymousLogoutReason != Constants.LogoutReason.tips) && (localAppRuntime.isLogin()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
              }
              localAppRuntime.logout(paramAnonymousLogoutReason, true);
            }
            if ((bool) && (MainService.this.mApplicaiton != null) && (MainService.this.mApplicaiton.getProcessNames().equalsIgnoreCase(MainService.this.mApplicaiton.getPackageName())))
            {
              localIntent = new Intent(paramAnonymousString1);
              localIntent.putExtra("title", paramAnonymousString3);
              localIntent.putExtra("msg", paramAnonymousString4);
              localIntent.putExtra("reason", paramAnonymousLogoutReason);
              localIntent.putExtra("isSameDevice", paramAnonymousBoolean);
              localIntent.addFlags(268435456);
              if ((!localAppRuntime.isClearTaskBySystem) && ((!paramAnonymousBoolean) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equalsIgnoreCase("mqq.i.intent.action.ACCOUNT_KICKED")) || (!localAppRuntime.isBackground_Stop))) {
                break label392;
              }
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked samedevice and set kickIntent ");
              }
              localAppRuntime.setKickIntent(localIntent);
            }
          }
          for (;;)
          {
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("title", paramAnonymousString3);
            localIntent.putExtra("msg", paramAnonymousString4);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("isSameDevice", paramAnonymousBoolean);
            MainService.this.mApplicaiton.sendBroadcast(localIntent);
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification end isNeedNotify = " + bool);
            }
            return;
            label387:
            bool = true;
            break;
            try
            {
              label392:
              MainService.this.mApplicaiton.startActivity(localIntent);
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked start notification......");
              }
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              localAppRuntime.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(MainService.this.mApplicaiton, "[mqq]" + MainService.3.3.this.val$reason + "\n" + MainService.3.3.this.val$title + "\n" + MainService.3.3.this.val$msg, 0).show();
                }
              });
            }
          }
        }
      });
    }
    
    private void popupNotificationEx(final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4, final Constants.LogoutReason paramAnonymousLogoutReason, final byte[] paramAnonymousArrayOfByte)
    {
      final AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "popupNotificationEx");
      }
      localAppRuntime.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Intent localIntent;
          if (paramAnonymousString2.equals(localAppRuntime.getAccount()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification start");
            }
            if ((paramAnonymousLogoutReason != Constants.LogoutReason.tips) && (localAppRuntime.isLogin()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
              }
              localAppRuntime.logout(paramAnonymousLogoutReason, true);
            }
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("title", paramAnonymousString3);
            localIntent.putExtra("msg", paramAnonymousString4);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("data", paramAnonymousArrayOfByte);
            localIntent.addFlags(268435456);
          }
          try
          {
            MainService.this.mApplicaiton.startActivity(localIntent);
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            MainService.this.mApplicaiton.sendBroadcast(localIntent);
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            for (;;)
            {
              localAppRuntime.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(MainService.this.mApplicaiton, "[mqq]" + MainService.3.2.this.val$reason + "\n" + MainService.3.2.this.val$title + "\n" + MainService.3.2.this.val$msg, 0).show();
                }
              });
            }
          }
        }
      });
    }
    
    public void onGrayError(ToServiceMsg paramAnonymousToServiceMsg, final FromServiceMsg paramAnonymousFromServiceMsg, final boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError start");
      }
      if ((MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramAnonymousFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramAnonymousFromServiceMsg.getMsfCommand())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "onGrayError:" + paramAnonymousFromServiceMsg);
        }
        MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      }
      MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          MainService.3.this.popupNotification("mqq.i.intent.action.GRAY", paramAnonymousFromServiceMsg.getUin(), null, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.gray, paramAnonymousBoolean);
        }
      }, 500L);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError end");
      }
    }
    
    public void onInvalidSign(boolean paramAnonymousBoolean)
    {
      AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (localAppRuntime != null) {
        localAppRuntime.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast.makeText(MainService.this.mApplicaiton, "Appid is invalid!", 0).show();
          }
        });
      }
    }
    
    public void onKicked(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked start");
      }
      onKicked(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg, false, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked end");
      }
    }
    
    public void onKickedAndClearToken(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken start");
      }
      onKicked(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg, true, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken end");
      }
    }
    
    public void onRecvServerTip(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      String str = paramAnonymousFromServiceMsg.getBusinessFailMsg();
      String[] arrayOfString = str.split("\\n");
      paramAnonymousToServiceMsg = str;
      int i = str.indexOf("\n");
      if (i != -1) {
        paramAnonymousToServiceMsg = str.substring(i + 1);
      }
      popupNotification("mqq.i.intent.action.ACCOUNT_TIPS", paramAnonymousFromServiceMsg.getUin(), arrayOfString[0], paramAnonymousToServiceMsg, Constants.LogoutReason.tips, paramAnonymousBoolean);
    }
    
    public void onServerSuspended(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended start");
      }
      if (paramAnonymousToServiceMsg == null) {
        popupNotification("mqq.i.intent.action.SUSPEND", paramAnonymousFromServiceMsg.getUin(), null, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.suspend, paramAnonymousBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended end");
      }
    }
    
    public void onUserTokenExpired(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked...onUserTokenExpired start");
      }
      MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      popupNotification("mqq.i.intent.action.ACCOUNT_EXPIRED", paramAnonymousFromServiceMsg.getUin(), null, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.expired, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked....onUserTokenExpired end ");
      }
    }
  };
  private MobileQQ mApplicaiton;
  private final Map<String, Set<Class<? extends MSFServlet>>> mRegistServlets = new ConcurrentHashMap();
  private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
  private IMsfMsgHandler msfMsgHandler = new IMsfMsgHandler()
  {
    public void onRecvResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private Thread msfRecvThread;
  private final MsfRespHandleUtil msfRespHandleUtil;
  public final MsfServiceSdk msfSub;
  INotifyHandler notifyHandler = new INotifyHandler()
  {
    public void onRecvNotify(long paramAnonymousLong, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterNotifyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
    
    public void onUnRegisterNotifyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
  };
  private IPushHandler pushHandler = new IPushHandler()
  {
    public void onRecvCmdPush(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCmdPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onResetCmdPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
    
    public void onTicketChanged()
    {
      QLog.d("mqq", 1, "ticket changed");
      if (MainService.this.mApplicaiton != null)
      {
        AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
        if (localAppRuntime != null) {
          ((TicketManager)localAppRuntime.getManager(2)).reloadCache(MainService.this.mApplicaiton);
        }
      }
    }
    
    public void onUnRegisterPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private IRegisterUinHandler registerUinHandler = new IRegisterUinHandler()
  {
    public void onRegQueryAccountResp(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitMobileResp(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitPassResp(int paramAnonymousInt, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitSmsCodeResp(int paramAnonymousInt, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterQuerySmsStatResp(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterSendResendSmsreqResp(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private IServerInfoHandler serverInfoHandler = new IServerInfoHandler()
  {
    public void onReportResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private IServerMsgPushHandler serverMsgPushHandler = new IServerMsgPushHandler()
  {
    public void onConnClose(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onConnOpened(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onOpenConnAllFailed(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onReceFirstResp(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvServerConfigPush(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
  };
  
  MainService(MobileQQ paramMobileQQ, int paramInt, String paramString, boolean paramBoolean)
  {
    this.mApplicaiton = paramMobileQQ;
    this.msfSub = MsfServiceSdk.get();
    this.msfSub.init(paramMobileQQ, paramInt, paramString, "com.tencent.mobileqq.msf.service.MsfService", this.errorHandler);
    this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[] { this.msfMsgHandler, this.pushHandler, this.notifyHandler, this.authHandler, this.registerUinHandler, this.serverMsgPushHandler, this.serverInfoHandler });
    if (paramBoolean) {
      start();
    }
  }
  
  private void receiveMessageFromMSF(ToServiceMsg paramToServiceMsg, final FromServiceMsg paramFromServiceMsg)
  {
    AppRuntime localAppRuntime = null;
    String str2 = null;
    Object localObject3 = null;
    Object localObject2;
    final long l;
    String str1;
    Object localObject1;
    if (paramToServiceMsg != null)
    {
      localObject2 = (Class)this.mRequestServlets.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
      l = paramToServiceMsg.extraData.getLong("sendTime");
      l = System.currentTimeMillis() - l;
      if (paramFromServiceMsg.isSuccess())
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + ",cost=" + l + "ms.");
        }
        recordKeyTimestamp(paramToServiceMsg, paramFromServiceMsg);
        str1 = (String)paramToServiceMsg.getAttribute("from_where");
        localObject1 = (String)paramToServiceMsg.getAttribute("mainaccount");
      }
    }
    for (;;)
    {
      localAppRuntime = this.mApplicaiton.waitAppRuntime(null);
      int i = 0;
      if ("0".equals(paramFromServiceMsg.getUin()))
      {
        paramFromServiceMsg.setUin(localAppRuntime.getAccount());
        i = 1;
      }
      str2 = paramFromServiceMsg.getUin();
      if ((str1 != null) && (str1.length() > 0)) {
        paramFromServiceMsg.addAttribute("from_where", str1);
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        paramFromServiceMsg.addAttribute("mainaccount", localObject1);
      }
      if ((i != 0) || (str2.equals(localAppRuntime.getAccount())) || ("login.auth".equals(paramFromServiceMsg.getServiceCmd())) || ("wtlogin.login".equals(paramFromServiceMsg.getServiceCmd())) || (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_name2uin.equals(paramFromServiceMsg.getMsfCommand())) || ("login.chguin".equals(paramFromServiceMsg.getServiceCmd())) || ((str1 != null) && (str1.equals("subaccount"))) || ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("uinNotMatch"))))
      {
        l = SystemClock.uptimeMillis();
        localAppRuntime.getServletContainer().notifyMSFServlet((Class)localObject2, paramFromServiceMsg);
        l = SystemClock.uptimeMillis() - l;
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "[MSF End][notifyMSFServlet]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq() + ",cost=" + l + "ms.");
        }
        Log.d("MainService", "[MSF End]" + paramFromServiceMsg.getServiceCmd() + ",cost=" + l + "ms.");
        if ((isDebugVersion) && (l >= 2000L))
        {
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("cmd", paramFromServiceMsg.getServiceCmd());
          localObject1 = new RdmReq();
          ((RdmReq)localObject1).eventName = "longTimeCallback";
          ((RdmReq)localObject1).elapse = l;
          ((RdmReq)localObject1).size = 0L;
          ((RdmReq)localObject1).isSucceed = true;
          ((RdmReq)localObject1).isRealTime = false;
          ((RdmReq)localObject1).params = paramToServiceMsg;
          paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject1);
          paramToServiceMsg.setNeedCallback(false);
          paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
          this.msfSub.sendMsg(paramToServiceMsg);
        }
        if ((isDebugVersion) && (l >= 5000L) && (localAppRuntime != null)) {
          localAppRuntime.runOnUiThread(new Runnable()
          {
            public void run()
            {
              Toast.makeText(MainService.this.mApplicaiton, "Caution! running too long. cmd=" + paramFromServiceMsg.getServiceCmd() + " time=" + l + "ms.", 1).show();
            }
          });
        }
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + ",code=" + paramFromServiceMsg.getResultCode() + ",cost=" + l + "ms.");
      break;
      if (!this.mApplicaiton.getProcessNames().endsWith(":video"))
      {
        localObject2 = localAppRuntime;
        str1 = str2;
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {}
      }
      else
      {
        QLog.d("mqq", 1, "[MSF Push]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq());
        localObject2 = localAppRuntime;
        str1 = str2;
        localObject1 = localObject3;
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
  
  public void clearServlets()
  {
    this.mRequestServlets.clear();
  }
  
  public void onRecvVerifyManagerCallback(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    this.msfRespHandleUtil.handleRespMsg(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void registCommands(String paramString, Class<? extends MSFServlet> paramClass)
  {
    Set localSet = (Set)this.mRegistServlets.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.mRegistServlets.put(paramString, localObject);
    }
    ((Set)localObject).add(paramClass);
  }
  
  void sendMessageToMSF(ToServiceMsg paramToServiceMsg, MSFServlet paramMSFServlet)
  {
    if (paramToServiceMsg.getServiceName() == null) {
      paramToServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
    }
    this.mRequestServlets.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramMSFServlet.getClass());
    paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
    this.msfSub.sendMsg(paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "[MSF Send]" + paramToServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + " from " + paramMSFServlet.getClass().getSimpleName());
    }
  }
  
  public void start()
  {
    if (this.msfRecvThread == null)
    {
      this.msfRecvThread = new Thread(this.MSFReceiver, "MSF-Receiver");
      this.msfRecvThread.setPriority(5);
      this.msfRecvThread.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.MainService
 * JD-Core Version:    0.7.0.1
 */