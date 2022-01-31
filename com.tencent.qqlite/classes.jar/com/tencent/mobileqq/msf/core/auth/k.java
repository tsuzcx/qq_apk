package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.g;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class k
{
  boolean a = false;
  boolean b = true;
  WtloginMsfListener c;
  ToServiceMsg d;
  MsfCore e;
  long f;
  boolean g = false;
  
  public k(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    this.e = paramMsfCore;
    this.d = paramToServiceMsg;
  }
  
  private String a(int paramInt)
  {
    if ((paramInt & 0x1A1020) == 1708064) {
      return "WebTicket";
    }
    if ((paramInt & 0x40040) == 262208) {
      return "BasicTicket";
    }
    return "OtherTicket";
  }
  
  private String a(ToServiceMsg paramToServiceMsg)
  {
    if ((this.d != null) && (this.d.getAttributes().get("refresh_token_src") != null)) {
      return (String)this.d.getAttributes().get("refresh_token_src");
    }
    return "OtherSrc";
  }
  
  private void a()
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg();
    localFromServiceMsg.setUin("0");
    localFromServiceMsg.setMsfCommand(MsfCommand.onTicketChanged);
    localFromServiceMsg.setAppId(this.e.getMsfAppid());
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    this.e.addRespToQuque(null, localFromServiceMsg);
  }
  
  public void a(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", Long.valueOf(paramLong));
      localFromServiceMsg.addAttribute("supersig", paramArrayOfByte1);
      localFromServiceMsg.addAttribute("contactssig", paramArrayOfByte2);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("msg", paramArrayOfByte3);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegGetSMSVerifyLoginAccount error " + paramArrayOfByte1, paramArrayOfByte1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("appid", Long.valueOf(paramLong1));
      localFromServiceMsg.addAttribute("subAppid", Long.valueOf(paramLong2));
      localFromServiceMsg.addAttribute("countryCode", paramString1);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
      localFromServiceMsg.addAttribute("mobile", paramString2);
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      localFromServiceMsg.addAttribute("msg", paramString3);
      localFromServiceMsg.addAttribute("msgCnt", Integer.valueOf(paramInt1));
      localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException " + paramString);
    if (this.g) {
      try
      {
        paramWUserSigInfo = g.a(this.d);
        paramWUserSigInfo.setBusinessFail(3002, paramString);
        paramWUserSigInfo.addAttribute("error", paramString);
        paramWUserSigInfo.addAttribute("cmd", Integer.valueOf(paramInt));
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException error " + paramString, paramString);
        return;
      }
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setBusinessFail(3001, paramString);
    MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", paramString);
      localFromServiceMsg.addAttribute("dwAppid", Long.valueOf(paramLong1));
      localFromServiceMsg.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt2));
      localFromServiceMsg.addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStViaSMSVerifyLogin error " + paramString, paramString);
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, this.d.getRequestSsoSeq() + " OnGetStWithPasswd " + paramErrMsg.getMessage() + " " + paramString1 + ", ret=" + paramInt2 + " " + this.d);
    }
    if (this.g) {}
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        localObject2 = new byte[0];
        localObject1 = localObject2;
        switch (paramInt2)
        {
        case 1: 
          localObject2 = g.a(this.d);
          ((FromServiceMsg)localObject2).setMsgSuccess();
          ((FromServiceMsg)localObject2).addAttribute("userAccount", paramString1);
          ((FromServiceMsg)localObject2).addAttribute("dwAppid", Long.valueOf(paramLong1));
          ((FromServiceMsg)localObject2).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
          ((FromServiceMsg)localObject2).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
          ((FromServiceMsg)localObject2).addAttribute("userPasswd", paramString2);
          ((FromServiceMsg)localObject2).addAttribute("pictureData", localObject1);
          ((FromServiceMsg)localObject2).addAttribute("userSigInfo", paramWUserSigInfo);
          ((FromServiceMsg)localObject2).addAttribute("wtTicket", a(paramWUserSigInfo));
          ((FromServiceMsg)localObject2).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
          ((FromServiceMsg)localObject2).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
          ((FromServiceMsg)localObject2).addAttribute("ret", Integer.valueOf(paramInt2));
          ((FromServiceMsg)localObject2).addAttribute("lastError", paramErrMsg);
          this.e.addRespToQuque(this.d, (FromServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception paramString1)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd error " + paramString1, paramString1);
        return;
      }
      if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
      {
        localObject1 = h.e.GetPictureData(paramString1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "puzzle CAPTCHA " + paramErrMsg.getOtherinfo());
          localObject1 = localObject2;
          continue;
          h.d.getAccountCenter().a(false);
          localObject1 = localObject2;
          continue;
          localObject1 = com.tencent.mobileqq.msf.core.k.a(this.d);
          ((FromServiceMsg)localObject1).setMsgSuccess();
          ((FromServiceMsg)localObject1).addAttribute("userAccount", paramString1);
          ((FromServiceMsg)localObject1).addAttribute("dwAppid", Long.valueOf(paramLong1));
          ((FromServiceMsg)localObject1).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
          ((FromServiceMsg)localObject1).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
          ((FromServiceMsg)localObject1).addAttribute("userPasswd", paramString2);
          ((FromServiceMsg)localObject1).addAttribute("userSigInfo", paramWUserSigInfo);
          ((FromServiceMsg)localObject1).addAttribute("wtTicket", a(paramWUserSigInfo));
          ((FromServiceMsg)localObject1).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
          for (;;)
          {
            try
            {
              ((FromServiceMsg)localObject1).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
              ((FromServiceMsg)localObject1).addAttribute("ret", Integer.valueOf(paramInt2));
              ((FromServiceMsg)localObject1).addAttribute("lastError", paramErrMsg);
              switch (paramInt2)
              {
              default: 
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd fail, " + paramErrMsg.getMessage());
                ((FromServiceMsg)localObject1).setBusinessFail(1001, paramErrMsg.getMessage());
                if ((paramInt2 != 0) && (paramErrMsg.getType() == 1)) {
                  ((FromServiceMsg)localObject1).addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
                }
                ((FromServiceMsg)localObject1).addAttribute("resp_logini_ret", Integer.valueOf(paramInt2));
                this.e.addRespToQuque(this.d, (FromServiceMsg)localObject1);
                return;
              }
            }
            catch (Exception paramString2)
            {
              paramString2.printStackTrace();
              continue;
              i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
              {
                i.b(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "appUseWt = false; puzzle CAPTCHA " + paramErrMsg.getOtherinfo());
              }
              i.a(this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getOtherinfo());
              return;
            }
            i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            i.a(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
            return;
            a();
            if ((paramWUserSigInfo != null) && (paramWUserSigInfo._login_bitmap == 0)) {
              try
              {
                i.a(this.e, h.e, this.d, (FromServiceMsg)localObject1, paramString1, paramWUserSigInfo);
                if (!this.a) {
                  break;
                }
                h.a(paramString1);
                return;
              }
              catch (Exception paramString1)
              {
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd succ exception " + paramString1.toString(), paramString1);
                return;
              }
            }
            ((FromServiceMsg)localObject1).setMsgSuccess();
            ((FromServiceMsg)localObject1).addAttribute("__attribute_tag_servertimediff", Long.valueOf(h.e.GetTimeDifference() * 1000L));
            continue;
            ((FromServiceMsg)localObject1).setBusinessFail(2005, paramErrMsg.getMessage());
            continue;
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd timeout");
            ((FromServiceMsg)localObject1).setBusinessFail(1002);
          }
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", paramString);
      localFromServiceMsg.addAttribute("dwSrcAppid", Long.valueOf(paramLong1));
      localFromServiceMsg.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
      localFromServiceMsg.addAttribute("dwSubSrcAppid", Long.valueOf(paramLong2));
      localFromServiceMsg.addAttribute("dstAppName", paramArrayOfByte1);
      localFromServiceMsg.addAttribute("dwDstSsoVer", Long.valueOf(paramLong3));
      localFromServiceMsg.addAttribute("dwDstAppid", Long.valueOf(paramLong4));
      localFromServiceMsg.addAttribute("dwSubDstAppid", Long.valueOf(paramLong5));
      localFromServiceMsg.addAttribute("dstAppVer", paramArrayOfByte2);
      localFromServiceMsg.addAttribute("dstAppSign", paramArrayOfByte3);
      localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("fastLoginInfo", paramWFastLoginInfo);
      localFromServiceMsg.addAttribute("wtTicket", paramWFastLoginInfo._outA1.clone());
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt2));
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onGetA1WithA1 error " + paramString, paramString);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, this.d.getRequestSsoSeq() + " found not need continue handle msg OnGetStWithoutPasswd.");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    label581:
    label895:
    do
    {
      try
      {
        paramArrayOfLong = g.a(this.d);
        paramArrayOfLong.setMsgSuccess();
        paramArrayOfLong.addAttribute("userAccount", paramString);
        paramArrayOfLong.addAttribute("dwSrcAppid", Long.valueOf(paramLong1));
        paramArrayOfLong.addAttribute("dwDstAppid", Long.valueOf(paramLong2));
        paramArrayOfLong.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
        paramArrayOfLong.addAttribute("dwSubDstAppid", Long.valueOf(paramLong3));
        paramArrayOfLong.addAttribute("userSigInfo", paramWUserSigInfo);
        paramArrayOfLong.addAttribute("wtTicket", a(paramWUserSigInfo));
        paramArrayOfLong.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        paramArrayOfLong.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        paramArrayOfLong.addAttribute("ret", Integer.valueOf(paramInt2));
        paramArrayOfLong.addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, paramArrayOfLong);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd error " + paramString, paramString);
        return;
      }
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.k.a(this.d);
      localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
      localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      try
      {
        localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        paramLong2 = 0L;
        paramLong1 = paramLong2;
        if (localFromServiceMsg.getAttributes().containsKey("__timestamp_net2msf"))
        {
          paramLong1 = paramLong2;
          if (localFromServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
            paramLong1 = ((Long)localFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)this.d.getAttribute("__timestamp_app2msf")).longValue();
          }
        }
        paramLong2 = m.a(this.d, localFromServiceMsg);
        switch (paramInt2)
        {
        default: 
          paramArrayOfLong = paramErrMsg.getMessage();
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 fail, " + paramInt2 + " " + paramArrayOfLong);
          this.e.getAccountCenter().m(localFromServiceMsg.getUin());
          localFromServiceMsg.setBusinessFail(2001, paramArrayOfLong);
          MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
          this.e.getStatReporter().a(false, paramString, paramLong1, paramInt2, paramLong2, a(paramInt1), a(this.d));
          if (paramInt2 == 15) {
            this.e.getStatReporter().a(paramLong1, localFromServiceMsg.getBusinessFailCode(), paramLong2);
          }
          if (this.b)
          {
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          if (QLog.isColorLevel())
          {
            paramErrMsg = new StringBuilder().append(this.d.getRequestSsoSeq()).append(" OnGetStWithoutPasswd2 succ, dwMainSigMap=").append(paramInt1).append(", dwDstSubAppid.length=");
            if (paramArrayOfLong != null) {
              break label895;
            }
            paramInt2 = 0;
            paramArrayOfLong = paramErrMsg.append(paramInt2).append(", st.length=");
            if (paramArrayOfByte != null) {
              break label903;
            }
          }
          CustomSigContent localCustomSigContent;
          for (paramInt2 = 0;; paramInt2 = paramArrayOfByte.length)
          {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, paramInt2);
            try
            {
              a();
              localFromServiceMsg.setMsgSuccess();
              paramArrayOfByte = new RespondCustomSig();
              paramArrayOfByte.reserved = new byte[0];
              paramArrayOfByte.SigList = new ArrayList();
              localCustomSigContent = new CustomSigContent();
              localCustomSigContent.sResult = 0;
              localCustomSigContent.SigContent = new byte[0];
              if (!this.d.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY")) {
                break label911;
              }
              paramArrayOfLong = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
              paramArrayOfByte = WtloginHelper.GetTicketSig(paramWUserSigInfo, 524288);
              paramErrMsg = WtloginHelper.GetTicketSig(paramWUserSigInfo, 131072);
              paramWUserSigInfo = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
              this.e.getAccountCenter().b(paramString, paramArrayOfLong);
              this.e.getAccountCenter().a(paramString, new String(paramArrayOfByte), System.currentTimeMillis());
              this.e.getAccountCenter().a(paramString, paramErrMsg);
              this.e.getAccountCenter().a(paramString, paramWUserSigInfo, System.currentTimeMillis());
              this.e.getAccountCenter().a(paramString, System.currentTimeMillis());
              this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
              this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "WebTicket", a(this.d));
              return;
            }
            catch (Exception paramString)
            {
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd2 error " + paramString.toString(), paramString);
            }
            break;
            paramInt2 = paramArrayOfLong.length;
            break label581;
          }
          if (this.d.getServiceCmd().equals("login.chgTok_A2D2"))
          {
            byte[] arrayOfByte1 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 262144);
            byte[] arrayOfByte2 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
            paramErrMsg = new byte[16];
            paramArrayOfLong = new byte[0];
            try
            {
              paramWUserSigInfo = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 262144);
              paramArrayOfLong = paramWUserSigInfo;
            }
            catch (Exception paramWUserSigInfo)
            {
              for (;;)
              {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error " + paramWUserSigInfo);
              }
            }
            f.a(paramErrMsg, 0, paramArrayOfLong, paramArrayOfLong.length);
            paramArrayOfLong = new CustomSigContent();
            paramArrayOfLong.sResult = 0;
            paramArrayOfLong.SigContent = new byte[0];
            paramArrayOfLong.ulSigType = 18L;
            paramArrayOfLong.SigContent = arrayOfByte1;
            paramArrayOfByte.SigList.add(paramArrayOfLong);
            localCustomSigContent.ulSigType = 0L;
            localCustomSigContent.SigContent = arrayOfByte2;
            paramArrayOfByte.SigList.add(localCustomSigContent);
            paramArrayOfLong = new CustomSigContent();
            paramArrayOfLong.ulSigType = 20L;
            paramArrayOfLong.SigContent = paramErrMsg;
            paramArrayOfByte.SigList.add(paramArrayOfLong);
            localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
            this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
            this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "BasicTicket", a(this.d));
            return;
          }
          if ((paramInt1 & 0x4000) == 16384)
          {
            localCustomSigContent.ulSigType = 16L;
            localCustomSigContent.SigContent = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 16384);
            paramArrayOfByte.SigList.add(localCustomSigContent);
          }
          paramArrayOfLong = new UniPacket(true);
          paramArrayOfLong.setEncodeName("UTF-8");
          paramArrayOfLong.put("RespondCustomSig", paramArrayOfByte);
          localFromServiceMsg.putWupBuffer(paramArrayOfLong.encode());
          localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
          if (this.a) {
            h.a(paramString);
          }
          this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "OtherTicket", a(this.d));
          continue;
          localFromServiceMsg.setBusinessFail(1002);
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd timeout");
          this.e.getStatReporter().a(false, paramString, paramLong1, -1000, paramLong2, a(paramInt1), a(this.d));
        }
      }
    } while (!QLog.isColorLevel());
    label903:
    label911:
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnGetStWithoutPasswd2 found not need contine handle msg.");
  }
  
  public void a(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt3);
    }
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = g.a(this.d);
        localFromServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSData);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("smsAppid", Long.valueOf(paramLong));
        localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("remainMsgCnt", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
        localFromServiceMsg.addAttribute("lastError", paramErrMsg);
        if (paramInt3 == 0)
        {
          i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          i.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSData error " + paramString, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
      localFromServiceMsg.addAttribute("mobile", paramString1);
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      localFromServiceMsg.addAttribute("msg", paramString2);
      localFromServiceMsg.addAttribute("msgCnt", Integer.valueOf(paramInt1));
      localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("mobile", paramString1);
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      localFromServiceMsg.addAttribute("msgCode", paramString2);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifySMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        paramWUserSigInfo = g.a(this.d);
        paramWUserSigInfo.setMsgSuccess();
        paramWUserSigInfo.addAttribute("userAccount", paramString);
        paramWUserSigInfo.addAttribute("pictureData", paramArrayOfByte);
        paramWUserSigInfo.addAttribute("ret", Integer.valueOf(paramInt));
        paramWUserSigInfo.addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error " + paramString, paramString);
        return;
      }
    }
    paramArrayOfByte = com.tencent.mobileqq.msf.core.k.a(this.d);
    if (paramInt == 0)
    {
      i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
      this.f = paramWUserSigInfo._seqence;
      i.b(paramString, this.e, this.f, this.d, paramArrayOfByte, paramErrMsg.getMessage());
      return;
    }
    paramArrayOfByte.setBusinessFail(1001, paramErrMsg.getMessage());
    this.e.addRespToQuque(this.d, paramArrayOfByte);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    FromServiceMsg localFromServiceMsg;
    if (this.g) {
      try
      {
        paramWUserSigInfo = new ErrMsg();
        paramWUserSigInfo.setMessage(new String(paramArrayOfByte2, "utf-8"));
        localFromServiceMsg = g.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("appName", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("time", Long.valueOf(paramLong));
        paramString = new ArrayList();
        if (paramList != null)
        {
          paramArrayOfByte1 = ((ArrayList)paramList).iterator();
          while (paramArrayOfByte1.hasNext())
          {
            paramString.add(HexUtil.bytes2HexStr((byte[])paramArrayOfByte1.next()));
            continue;
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifyCode error " + paramString, paramString);
      }
    }
    localFromServiceMsg.addAttribute("data", paramString);
    localFromServiceMsg.addAttribute("errMsg", paramArrayOfByte2);
    localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
    localFromServiceMsg.addAttribute("msg", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    if (this.g) {}
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      localErrMsg.setMessage(new String(paramArrayOfByte2, "utf-8"));
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", paramString);
      localFromServiceMsg.addAttribute("appName", paramArrayOfByte1);
      localFromServiceMsg.addAttribute("time", Long.valueOf(paramLong));
      localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("errMsg", paramArrayOfByte2);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("msg", localErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseCode error " + paramString, paramString);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckWebsigAndGetSt ret" + paramInt);
    }
    if (this.g)
    {
      if (paramInt == 0) {
        h.d.getAccountCenter().a(false);
      }
      localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", paramString);
      localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
      localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
      localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      try
      {
        localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.k.a(this.d);
    localFromServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.addAttribute("userAccount", paramString);
    localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
    localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
    localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
    localFromServiceMsg.addAttribute("lastError", paramErrMsg);
    localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
    localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
    for (;;)
    {
      for (;;)
      {
        try
        {
          localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
          switch (paramInt)
          {
          default: 
            localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt failed");
            if ((paramInt != 0) && (paramErrMsg.getType() == 1)) {
              localFromServiceMsg.addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
            }
            localFromServiceMsg.addAttribute("resp_logini_ret", Integer.valueOf(paramInt));
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          continue;
          i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          i.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        i.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          i.a(this.e, h.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          if (!this.a) {
            break;
          }
          h.a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt succ exception " + paramString.toString(), paramString);
          return;
        }
      }
      localFromServiceMsg.setBusinessFail(1002);
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt timeout");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt);
    }
    if (this.g) {
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = g.a(this.d);
          localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
          localFromServiceMsg.setMsgSuccess();
          localFromServiceMsg.addAttribute("userAccount", paramString);
          localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
          localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("st", paramArrayOfByte1);
          localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
          localFromServiceMsg.addAttribute("lastError", paramErrMsg);
          switch (paramInt)
          {
          case 2: 
            localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt failed");
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        i.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        i.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          i.a(this.e, h.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          if (!this.a) {
            break;
          }
          h.a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + paramString.toString(), paramString);
          return;
        }
        localFromServiceMsg.setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt timeout");
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt1));
    paramWUserSigInfo.attributes.put("resp_register_shNextResendTime", Integer.valueOf(paramInt2));
    paramWUserSigInfo.attributes.put("resp_register_shTotalTimeOver", Integer.valueOf(paramInt3));
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_uin", String.valueOf(paramLong));
    paramWUserSigInfo.attributes.put("resp_register_contactssig", paramArrayOfByte2);
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte3);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockSms);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockSms error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g)
    {
      paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("msg", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + paramInt + " on call " + this.d.getServiceCmd());
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + paramInt + " on call " + this.d.getServiceCmd());
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockStatus ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("devLockInfo", paramDevlockInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockStatus error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(3));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(2));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte2);
    paramWUserSigInfo.attributes.put("to_register_cr_mobile", paramArrayOfByte1);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  byte[] a(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = this.d.getAttribute("targetTicket");
    if ((localObject != null) && ((localObject instanceof Integer))) {}
    for (int i = ((Integer)localObject).intValue();; i = 4096) {
      return WtloginHelper.GetTicketSig(paramWUserSigInfo, i);
    }
  }
  
  /* Error */
  public void b(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    // Byte code:
    //   0: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 145
    //   8: iconst_2
    //   9: new 147	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 713
    //   19: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload 4
    //   24: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 27	com/tencent/mobileqq/msf/core/auth/k:g	Z
    //   37: ifeq +247 -> 284
    //   40: iconst_0
    //   41: newarray byte
    //   43: astore 7
    //   45: aload 7
    //   47: astore 6
    //   49: iload 4
    //   51: tableswitch	default:+665 -> 716, 0:+179->230, 1:+25->76, 2:+167->218
    //   77: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   80: invokestatic 118	com/tencent/mobileqq/msf/service/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   83: astore 7
    //   85: aload 7
    //   87: getstatic 716	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   90: invokevirtual 79	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   93: aload 7
    //   95: invokevirtual 92	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   98: aload 7
    //   100: ldc 120
    //   102: aload_1
    //   103: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: aload 7
    //   109: ldc_w 635
    //   112: aload_2
    //   113: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload 7
    //   119: ldc_w 718
    //   122: aload 6
    //   124: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload 7
    //   130: ldc 239
    //   132: aload_3
    //   133: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload 7
    //   139: ldc 136
    //   141: iload 4
    //   143: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: aload 7
    //   152: ldc_w 259
    //   155: aload 5
    //   157: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload 7
    //   163: ldc 241
    //   165: aload_0
    //   166: aload_3
    //   167: invokevirtual 244	com/tencent/mobileqq/msf/core/auth/k:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   170: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 7
    //   176: ldc 246
    //   178: aload_3
    //   179: sipush 128
    //   182: invokestatic 252	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   185: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 7
    //   191: ldc 254
    //   193: aload_3
    //   194: sipush 128
    //   197: invokestatic 257	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   200: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_0
    //   205: getfield 29	com/tencent/mobileqq/msf/core/auth/k:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   208: aload_0
    //   209: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   212: aload 7
    //   214: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   217: return
    //   218: getstatic 273	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   221: aload_1
    //   222: invokevirtual 277	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   225: astore 6
    //   227: goto -151 -> 76
    //   230: getstatic 283	com/tencent/mobileqq/msf/core/auth/h:d	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   233: invokevirtual 287	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   236: iconst_0
    //   237: invokevirtual 292	com/tencent/mobileqq/msf/core/auth/b:a	(Z)V
    //   240: aload 7
    //   242: astore 6
    //   244: goto -168 -> 76
    //   247: astore_1
    //   248: ldc 145
    //   250: iconst_1
    //   251: new 147	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 720
    //   261: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: aload_1
    //   272: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: return
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   281: goto -77 -> 204
    //   284: aload_0
    //   285: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   288: invokestatic 202	com/tencent/mobileqq/msf/core/k:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   291: astore 6
    //   293: aload 6
    //   295: getstatic 716	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   298: invokevirtual 79	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   301: aload 6
    //   303: invokevirtual 92	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   306: aload 6
    //   308: ldc 120
    //   310: aload_1
    //   311: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 635
    //   320: aload_2
    //   321: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: pop
    //   325: aload 6
    //   327: ldc_w 573
    //   330: aload_3
    //   331: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: pop
    //   335: aload 6
    //   337: ldc 136
    //   339: iload 4
    //   341: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: aload 6
    //   350: ldc_w 259
    //   353: aload 5
    //   355: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: aload 6
    //   361: ldc 241
    //   363: aload_0
    //   364: aload_3
    //   365: invokevirtual 244	com/tencent/mobileqq/msf/core/auth/k:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   368: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: pop
    //   372: aload 6
    //   374: ldc 246
    //   376: aload_3
    //   377: sipush 128
    //   380: invokestatic 252	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   383: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: aload 6
    //   389: ldc 254
    //   391: aload_3
    //   392: sipush 128
    //   395: invokestatic 257	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   398: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: pop
    //   402: iload 4
    //   404: lookupswitch	default:+44->448, -1000:+292->696, 0:+230->634, 2:+130->534, 160:+180->584
    //   449: iconst_3
    //   450: sipush 1001
    //   453: aload 5
    //   455: invokevirtual 229	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   458: invokevirtual 193	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   461: ldc 145
    //   463: iconst_1
    //   464: ldc_w 722
    //   467: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iload 4
    //   472: ifeq +26 -> 498
    //   475: aload 5
    //   477: invokevirtual 299	oicq/wlogin_sdk/tools/ErrMsg:getType	()I
    //   480: iconst_1
    //   481: if_icmpne +17 -> 498
    //   484: aload 6
    //   486: ldc_w 301
    //   489: aload 5
    //   491: invokevirtual 262	oicq/wlogin_sdk/tools/ErrMsg:getOtherinfo	()Ljava/lang/String;
    //   494: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload 6
    //   500: ldc_w 303
    //   503: iload 4
    //   505: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   508: invokevirtual 130	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   511: pop
    //   512: aload_0
    //   513: getfield 29	com/tencent/mobileqq/msf/core/auth/k:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   516: aload_0
    //   517: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   520: aload 6
    //   522: invokevirtual 110	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   525: return
    //   526: astore_2
    //   527: aload_2
    //   528: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   531: goto -129 -> 402
    //   534: getstatic 311	com/tencent/mobileqq/msf/core/auth/i:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   537: aload_0
    //   538: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   541: invokevirtual 219	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   544: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aload_0
    //   548: invokevirtual 317	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: aload_0
    //   553: aload_3
    //   554: getfield 322	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   557: putfield 324	com/tencent/mobileqq/msf/core/auth/k:f	J
    //   560: aload_1
    //   561: aload_0
    //   562: getfield 29	com/tencent/mobileqq/msf/core/auth/k:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   565: aload_0
    //   566: getfield 324	com/tencent/mobileqq/msf/core/auth/k:f	J
    //   569: aload_0
    //   570: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   573: aload 6
    //   575: aload 5
    //   577: invokevirtual 229	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   580: invokestatic 327	com/tencent/mobileqq/msf/core/auth/i:b	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   583: return
    //   584: getstatic 311	com/tencent/mobileqq/msf/core/auth/i:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   587: aload_0
    //   588: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   591: invokevirtual 219	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   594: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: aload_0
    //   598: invokevirtual 317	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   601: pop
    //   602: aload_0
    //   603: aload_3
    //   604: getfield 322	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   607: putfield 324	com/tencent/mobileqq/msf/core/auth/k:f	J
    //   610: aload_1
    //   611: aload_0
    //   612: getfield 29	com/tencent/mobileqq/msf/core/auth/k:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   615: aload_0
    //   616: getfield 324	com/tencent/mobileqq/msf/core/auth/k:f	J
    //   619: aload_0
    //   620: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   623: aload 6
    //   625: aload 5
    //   627: invokevirtual 229	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   630: invokestatic 334	com/tencent/mobileqq/msf/core/auth/i:a	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   633: return
    //   634: aload_0
    //   635: getfield 29	com/tencent/mobileqq/msf/core/auth/k:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   638: getstatic 273	com/tencent/mobileqq/msf/core/auth/h:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   641: aload_0
    //   642: getfield 31	com/tencent/mobileqq/msf/core/auth/k:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   645: aload 6
    //   647: aload_1
    //   648: aload_3
    //   649: invokestatic 343	com/tencent/mobileqq/msf/core/auth/i:a	(Lcom/tencent/mobileqq/msf/core/MsfCore;Loicq/wlogin_sdk/request/WtloginHelper;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;)V
    //   652: aload_0
    //   653: getfield 23	com/tencent/mobileqq/msf/core/auth/k:a	Z
    //   656: ifeq +67 -> 723
    //   659: aload_1
    //   660: invokestatic 345	com/tencent/mobileqq/msf/core/auth/h:a	(Ljava/lang/String;)V
    //   663: return
    //   664: astore_1
    //   665: ldc 145
    //   667: iconst_1
    //   668: new 147	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 653
    //   678: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_1
    //   682: invokevirtual 348	java/lang/Exception:toString	()Ljava/lang/String;
    //   685: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: aload_1
    //   692: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: return
    //   696: aload 6
    //   698: sipush 1002
    //   701: invokevirtual 362	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(I)V
    //   704: ldc 145
    //   706: iconst_1
    //   707: ldc_w 724
    //   710: invokestatic 296	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: goto -243 -> 470
    //   716: aload 7
    //   718: astore 6
    //   720: goto -644 -> 76
    //   723: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	k
    //   0	724	1	paramString	String
    //   0	724	2	paramArrayOfByte	byte[]
    //   0	724	3	paramWUserSigInfo	WUserSigInfo
    //   0	724	4	paramInt	int
    //   0	724	5	paramErrMsg	ErrMsg
    //   47	672	6	localObject1	Object
    //   43	674	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	247	java/lang/Exception
    //   76	189	247	java/lang/Exception
    //   204	217	247	java/lang/Exception
    //   218	227	247	java/lang/Exception
    //   230	240	247	java/lang/Exception
    //   277	281	247	java/lang/Exception
    //   189	204	276	java/lang/Exception
    //   387	402	526	java/lang/Exception
    //   634	663	664	java/lang/Exception
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g) {}
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt1));
    paramWUserSigInfo.attributes.put("resp_register_shNextResendTime", Integer.valueOf(paramInt2));
    paramWUserSigInfo.attributes.put("resp_register_shTotalTimeOver", Integer.valueOf(paramInt3));
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCloseDevLock ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CloseDevLock);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseDevLock error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WtProviderImpl.OnRegQueryAccount ret = " + paramInt + " appUseWt=" + this.g);
    }
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnAskDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = g.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_AskDevLockSms);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("devLockInfo", paramDevlockInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnAskDevLockSms error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt);
    }
    if (this.g) {
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = g.a(this.d);
          localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
          localFromServiceMsg.setMsgSuccess();
          localFromServiceMsg.addAttribute("userAccount", paramString);
          localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
          localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
          localFromServiceMsg.addAttribute("lastError", paramErrMsg);
          localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
          localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
          try
          {
            localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
            switch (paramInt)
            {
            default: 
              localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt failed");
              this.e.addRespToQuque(this.d, localFromServiceMsg);
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            continue;
          }
          i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        this.f = paramWUserSigInfo._seqence;
        i.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        i.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        i.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          i.a(this.e, h.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          if (!this.a) {
            break;
          }
          h.a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + paramString.toString(), paramString);
          return;
        }
        localFromServiceMsg.setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt timeout");
      }
    }
  }
  
  public void c(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(1));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void d(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {}
    paramWUserSigInfo = com.tencent.mobileqq.msf.core.k.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.k
 * JD-Core Version:    0.7.0.1
 */