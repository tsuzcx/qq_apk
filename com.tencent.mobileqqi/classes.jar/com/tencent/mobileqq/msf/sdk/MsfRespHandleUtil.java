package com.tencent.mobileqq.msf.sdk;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.mobileqq.msf.service.h;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MsfRespHandleUtil
{
  public static final String tag = "MSF.D.RespHandleUtil";
  IAuthHandler authHandler;
  IMsfMsgHandler msfMsgHandler;
  INotifyHandler notifyHandler;
  IPushHandler pushHandler;
  IRegisterUinHandler registerUinHandler;
  IServerInfoHandler serverInfoHandler;
  IServerMsgPushHandler serverMsgPushHandler;
  
  public MsfRespHandleUtil(IMsfHandler[] paramArrayOfIMsfHandler)
  {
    if (paramArrayOfIMsfHandler != null)
    {
      int j = paramArrayOfIMsfHandler.length;
      int i = 0;
      if (i < j)
      {
        IMsfHandler localIMsfHandler = paramArrayOfIMsfHandler[i];
        if ((localIMsfHandler instanceof IAuthHandler)) {
          this.authHandler = ((IAuthHandler)localIMsfHandler);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localIMsfHandler instanceof IMsfMsgHandler)) {
            this.msfMsgHandler = ((IMsfMsgHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof INotifyHandler)) {
            this.notifyHandler = ((INotifyHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerInfoHandler)) {
            this.serverInfoHandler = ((IServerInfoHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IPushHandler)) {
            this.pushHandler = ((IPushHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IRegisterUinHandler)) {
            this.registerUinHandler = ((IRegisterUinHandler)localIMsfHandler);
          } else if ((localIMsfHandler instanceof IServerMsgPushHandler)) {
            this.serverMsgPushHandler = ((IServerMsgPushHandler)localIMsfHandler);
          }
        }
      }
    }
  }
  
  public boolean handlePushMsg(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2;
    for (;;)
    {
      try
      {
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onConnOpened)
        {
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 2;
          if (this.serverMsgPushHandler == null) {
            break label349;
          }
          this.serverMsgPushHandler.onConnOpened(paramFromServiceMsg);
          bool1 = true;
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvConfigPush)
          {
            bool2 = bool1;
            if (this.serverMsgPushHandler != null)
            {
              this.serverMsgPushHandler.onRecvServerConfigPush(paramFromServiceMsg);
              bool2 = true;
            }
            if (bool2) {
              break;
            }
            if (this.pushHandler == null) {
              continue;
            }
            this.pushHandler.onRecvCmdPush(paramFromServiceMsg);
            return true;
          }
        }
        else
        {
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onReceFirstResp)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 4;
            if (this.serverMsgPushHandler == null) {
              break label349;
            }
            this.serverMsgPushHandler.onReceFirstResp(paramFromServiceMsg);
            bool1 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onOepnConnAllFailed)
          {
            com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 3;
            if (this.serverMsgPushHandler == null) {
              break label349;
            }
            this.serverMsgPushHandler.onOpenConnAllFailed(paramFromServiceMsg);
            bool1 = true;
            continue;
          }
          if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onConnClosed) {
            break label349;
          }
          com.tencent.mobileqq.msf.core.NetConnInfoCenter.socketConnState = 1;
          if (this.serverMsgPushHandler == null) {
            break label349;
          }
          this.serverMsgPushHandler.onConnClose(paramFromServiceMsg);
          bool1 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvNotifyMsg)
        {
          bool2 = bool1;
          if (this.notifyHandler == null) {
            continue;
          }
          long l = ((Long)paramFromServiceMsg.getAttributes().get("notifyId")).longValue();
          this.notifyHandler.onRecvNotify(l, paramFromServiceMsg);
          bool2 = true;
          continue;
        }
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerPush)
        {
          bool2 = bool1;
          if (this.pushHandler == null) {
            continue;
          }
          this.pushHandler.onRegisterPushResp(null, paramFromServiceMsg);
          bool2 = true;
          continue;
        }
        bool2 = bool1;
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.onTicketChanged) {
          continue;
        }
        bool2 = bool1;
        if (this.pushHandler == null) {
          continue;
        }
        this.pushHandler.onTicketChanged();
        bool2 = true;
        continue;
        return false;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.d("MSF.D.RespHandleUtil", 1, "handle push msg error " + paramFromServiceMsg, paramFromServiceMsg);
        return true;
      }
      label349:
      boolean bool1 = false;
    }
    return bool2;
  }
  
  public boolean handleRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject10;
    boolean bool;
    Object localObject7;
    for (;;)
    {
      Object localObject2;
      try
      {
        i = paramFromServiceMsg.getResultCode();
        j = paramFromServiceMsg.getBusinessFailCode();
        localObject10 = paramFromServiceMsg.getBusinessFailMsg();
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.RespHandleUtil", 2, "handle fmsg:" + paramFromServiceMsg);
        }
        if ((paramFromServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramFromServiceMsg.getMsfCommand() == MsfCommand.wt_loginAuth))
        {
          if (this.authHandler == null) {
            break label1667;
          }
          this.authHandler.onRecvLoginResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
          bool = true;
          if (bool) {
            break label1545;
          }
          if (this.msfMsgHandler == null) {
            break label1735;
          }
          this.msfMsgHandler.onRecvResp(paramToServiceMsg, paramFromServiceMsg);
          return true;
        }
        if ((paramFromServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramFromServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
        {
          if (this.authHandler == null) {
            break label1667;
          }
          this.authHandler.onRecvChangeUinLoginResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
          bool = true;
          continue;
        }
        if ((paramFromServiceMsg.getMsfCommand() == MsfCommand.changeToken) || (paramFromServiceMsg.getMsfCommand() == MsfCommand.wt_exchange))
        {
          if (this.authHandler == null) {
            break label1667;
          }
          localObject7 = null;
          bool = paramFromServiceMsg.isSuccess();
          Object localObject1 = localObject7;
          if (bool) {}
          try
          {
            localObject1 = paramFromServiceMsg.getWupBuffer();
            UniPacket localUniPacket = new UniPacket(true);
            localUniPacket.setEncodeName("UTF-8");
            localUniPacket.decode((byte[])localObject1);
            localObject1 = (RespondCustomSig)localUniPacket.getByClass("RespondCustomSig", new RespondCustomSig());
            this.authHandler.onRecvChangeTokenResp(i, j, (String)localObject10, (RespondCustomSig)localObject1, paramToServiceMsg, paramFromServiceMsg);
            bool = true;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localObject2 = localObject7;
            continue;
          }
        }
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.submitVerifyCode) {
          break label368;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.D.RespHandleUtil", 1, "handle resp msg error " + paramToServiceMsg, paramToServiceMsg);
        return true;
      }
      if (this.authHandler == null) {
        break label1667;
      }
      this.authHandler.onRecvLoginResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
      bool = true;
      continue;
      label368:
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand.refreVerifyCode)
      {
        if (this.authHandler == null) {
          break label1667;
        }
        this.authHandler.onRecvLoginResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.delLoginedAccount)
      {
        if (this.authHandler == null) {
          break label1667;
        }
        this.authHandler.onDelLoginedAccountResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.wt_name2uin)
      {
        if (this.authHandler == null) {
          break label1667;
        }
        this.authHandler.onRecvChangeUinResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.onRecvVerifyCode)
      {
        if (this.authHandler == null) {
          break label1667;
        }
        localObject2 = VerifyCodeInfo.getVerifyCodeInfo(paramFromServiceMsg);
        this.authHandler.onReceVerifyCode((VerifyCodeInfo)localObject2, paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.reportMsg)
      {
        if (this.serverInfoHandler == null) {
          break label1667;
        }
        this.serverInfoHandler.onReportResp(i, j, (String)localObject10, paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.getServerConfig)
      {
        bool = paramFromServiceMsg.isSuccess();
        if (bool) {}
        try
        {
          i = ((Integer)paramFromServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue();
          localObject2 = (String)paramFromServiceMsg.getAttributes().get("to_getServerConfig_content");
          MsfSdkUtils.writeServerConfig(h.b(paramToServiceMsg), i, (String)localObject2);
          bool = true;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("MSF.D.RespHandleUtil", 1, "write config error " + localException2);
          }
        }
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerPush)
      {
        if (this.pushHandler == null) {
          break label1667;
        }
        this.pushHandler.onRegisterPushResp(paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.unRegisterPush)
      {
        if (this.pushHandler == null) {
          break label1667;
        }
        this.pushHandler.onUnRegisterPushResp(paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand.registerCmdCallback)
      {
        if (this.pushHandler == null) {
          break label1667;
        }
        this.pushHandler.onRegisterCmdPushResp(paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
      else
      {
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.resetCmdCallback) {
          break;
        }
        if (this.pushHandler == null) {
          break label1667;
        }
        this.pushHandler.onResetCmdPushResp(paramToServiceMsg, paramFromServiceMsg);
        bool = true;
      }
    }
    Object localObject3;
    if (paramFromServiceMsg.getMsfCommand() == MsfCommand.regUin_queryMobile)
    {
      if (this.registerUinHandler == null) {
        break label1667;
      }
      localObject3 = new byte[0];
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    try
                    {
                      if (!paramFromServiceMsg.isSuccess()) {
                        continue;
                      }
                      i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
                    }
                    catch (Exception localException19)
                    {
                      int k;
                      Object localObject4;
                      Exception localException6;
                      Object localObject8;
                      Object localObject5;
                      Object localObject11;
                      Exception localException9;
                      Object localObject9;
                      Object localObject6;
                      Exception localException18;
                      i = 0;
                      continue;
                    }
                    try
                    {
                      localObject7 = (byte[])paramFromServiceMsg.attributes.get("resp_register_promptinfo");
                      localObject3 = localObject7;
                      this.registerUinHandler.onRegQueryAccountResp(i, (byte[])localObject3, paramToServiceMsg, paramFromServiceMsg);
                      bool = true;
                    }
                    catch (Exception localException17) {}
                  }
                  ((Exception)localObject7).printStackTrace();
                  continue;
                  if (paramFromServiceMsg.getMsfCommand() != MsfCommand.regUin_commitMobile) {
                    continue;
                  }
                  if (this.registerUinHandler == null) {
                    continue;
                  }
                  localObject10 = new byte[0];
                  localObject7 = new byte[0];
                  try
                  {
                    if (!paramFromServiceMsg.isSuccess()) {
                      continue;
                    }
                    i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
                  }
                  catch (Exception localException11)
                  {
                    i = 0;
                    continue;
                  }
                  try
                  {
                    localObject3 = (byte[])paramFromServiceMsg.attributes.get("resp_register_promptinfo");
                  }
                  catch (Exception localException10)
                  {
                    continue;
                  }
                  try
                  {
                    localObject7 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
                    this.registerUinHandler.onRegisterCommitMobileResp(i, (byte[])localObject3, (byte[])localObject7, paramToServiceMsg, paramFromServiceMsg);
                    bool = true;
                  }
                  catch (Exception localException23)
                  {
                    localObject9 = localException10;
                    localObject6 = localException23;
                  }
                }
                ((Exception)localObject3).printStackTrace();
                localObject3 = localObject7;
                localObject7 = localObject10;
                continue;
                if (paramFromServiceMsg.getMsfCommand() != MsfCommand.regUin_reSendSms) {
                  continue;
                }
                if (this.registerUinHandler == null) {
                  continue;
                }
                localObject7 = new byte[0];
                try
                {
                  if (!paramFromServiceMsg.isSuccess()) {
                    continue;
                  }
                  j = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
                }
                catch (Exception localException12)
                {
                  i = 0;
                  j = 0;
                  continue;
                  i = 0;
                  continue;
                }
                try
                {
                  localObject3 = (byte[])paramFromServiceMsg.attributes.get("resp_register_promptinfo");
                }
                catch (Exception localException8)
                {
                  i = 0;
                  continue;
                }
                try
                {
                  i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_shNextResendTime")).intValue();
                }
                catch (Exception localException16)
                {
                  i = 0;
                  localObject11 = localException8;
                  localException9 = localException16;
                  localObject9 = localObject11;
                  continue;
                }
                try
                {
                  k = ((Integer)paramFromServiceMsg.attributes.get("resp_register_shTotalTimeOver")).intValue();
                  this.registerUinHandler.onRegisterSendResendSmsreqResp(j, (byte[])localObject3, i, k, paramToServiceMsg, paramFromServiceMsg);
                  bool = true;
                }
                catch (Exception localException21)
                {
                  localObject9 = localException9;
                  localException9 = localException21;
                }
              }
              ((Exception)localObject3).printStackTrace();
              k = 0;
              localObject3 = localObject7;
              continue;
              if (paramFromServiceMsg.getMsfCommand() == MsfCommand.regUin_commitSmsCode)
              {
                localObject3 = this.registerUinHandler;
                if (localObject3 == null) {
                  continue;
                }
                try
                {
                  if (!paramFromServiceMsg.isSuccess()) {
                    break label1761;
                  }
                  i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
                  this.registerUinHandler.onRegisterCommitSmsCodeResp(i, paramToServiceMsg, paramFromServiceMsg);
                  bool = true;
                }
                catch (Exception localException3)
                {
                  localException3.printStackTrace();
                  break label1761;
                }
              }
            }
            if (paramFromServiceMsg.getMsfCommand() != MsfCommand.regUin_commitPass) {
              continue;
            }
            if (this.registerUinHandler == null) {
              continue;
            }
            localObject7 = "";
            localObject10 = new byte[0];
            try
            {
              if (!paramFromServiceMsg.isSuccess()) {
                continue;
              }
              i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
            }
            catch (Exception localException13)
            {
              i = 0;
              continue;
            }
            try
            {
              localObject4 = (String)paramFromServiceMsg.attributes.get("resp_register_uin");
            }
            catch (Exception localException7)
            {
              continue;
            }
            try
            {
              localObject7 = (byte[])paramFromServiceMsg.attributes.get("resp_register_contactssig");
              this.registerUinHandler.onRegisterCommitPassResp(i, (String)localObject4, (byte[])localObject7, paramToServiceMsg, paramFromServiceMsg);
              bool = true;
            }
            catch (Exception localException22)
            {
              localObject8 = localException7;
              localObject5 = localException22;
            }
          }
          ((Exception)localObject4).printStackTrace();
          localObject4 = localObject7;
          localObject7 = localObject10;
          continue;
          if (paramFromServiceMsg.getMsfCommand() != MsfCommand.regUin_querySmsStat) {
            continue;
          }
          if (this.registerUinHandler == null) {
            continue;
          }
          localObject7 = new byte[0];
          try
          {
            if (!paramFromServiceMsg.isSuccess()) {
              continue;
            }
            j = ((Integer)paramFromServiceMsg.attributes.get("resp_register_resultcode")).intValue();
          }
          catch (Exception localException14)
          {
            i = 0;
            j = 0;
            continue;
          }
          try
          {
            localObject4 = (byte[])paramFromServiceMsg.attributes.get("resp_register_promptinfo");
          }
          catch (Exception localException5)
          {
            i = 0;
            continue;
          }
          try
          {
            i = ((Integer)paramFromServiceMsg.attributes.get("resp_register_shNextResendTime")).intValue();
          }
          catch (Exception localException15)
          {
            i = 0;
            localObject10 = localException5;
            localException6 = localException15;
            localObject8 = localObject10;
            continue;
          }
          try
          {
            k = ((Integer)paramFromServiceMsg.attributes.get("resp_register_shTotalTimeOver")).intValue();
            this.registerUinHandler.onRegisterQuerySmsStatResp(j, (byte[])localObject4, i, k, paramToServiceMsg, paramFromServiceMsg);
            bool = true;
          }
          catch (Exception localException20)
          {
            localObject8 = localException6;
            localException6 = localException20;
          }
        }
        ((Exception)localObject4).printStackTrace();
        k = 0;
        localObject4 = localObject7;
        continue;
        if (paramFromServiceMsg.getMsfCommand() != MsfCommand.getKey) {
          continue;
        }
        localObject4 = this.authHandler;
        if (localObject4 == null) {
          continue;
        }
        try
        {
          this.authHandler.onGetKeyResp(paramToServiceMsg, paramFromServiceMsg);
          bool = true;
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
        }
      }
      label1545:
      return bool;
      label1667:
      bool = false;
      break;
      localObject6 = localException17;
      i = 0;
      j = 0;
      k = 0;
      continue;
      localObject6 = "";
      localException18 = localException21;
      i = 0;
      continue;
      localObject6 = localException18;
      i = 0;
      j = 0;
      k = 0;
      continue;
      localObject6 = localException18;
      localException18 = localException21;
      i = 0;
      continue;
      i = 0;
    }
    label1735:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil
 * JD-Core Version:    0.7.0.1
 */