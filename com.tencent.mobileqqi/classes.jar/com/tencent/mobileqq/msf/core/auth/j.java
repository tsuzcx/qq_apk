package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class j
  extends WtloginListener
{
  MsfCore a;
  
  public j(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).b(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
  }
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramInt, paramErrMsg);
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
  }
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    try
    {
      i.b(paramWUserSigInfo).b(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
    }
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    try
    {
      i.b(paramWUserSigInfo).a(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, paramInt, paramErrMsg);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
    }
  }
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount ret =" + paramInt3 + " mobile=" + paramString1 + " msg=" + paramString2 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount errMsg =" + paramErrMsg.getMessage());
      }
    }
    i.b(paramWUserSigInfo).a(paramLong1, paramLong2, "", paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
  }
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    i.b(paramWUserSigInfo).a(paramString, paramArrayOfByte1, paramLong, paramWUserSigInfo, paramArrayOfByte2, paramInt);
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).b(paramWUserSigInfo, paramInt, paramErrMsg);
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    k localk = i.b(paramWUserSigInfo);
    if (localk != null)
    {
      localk.a(paramErrMsg.getMessage(), paramInt, paramWUserSigInfo);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnException found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin ret =" + paramInt2 + " userAccount=" + paramString);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin errMsg =" + paramErrMsg.getMessage());
      }
    }
    i.b(paramWUserSigInfo).a(paramString, paramLong1, paramInt1, paramLong2, "", paramWUserSigInfo, paramInt2, paramErrMsg);
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString1, paramLong1, paramInt1, paramLong2, paramString2, paramWUserSigInfo, paramInt2, paramErrMsg);
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramWUserSigInfo, paramInt2, paramErrMsg);
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte, paramInt2, paramErrMsg);
  }
  
  public void OnRefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    k localk = i.b(paramWUserSigInfo);
    if (localk != null)
    {
      localk.a(paramString, paramWUserSigInfo, paramArrayOfByte, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshPictureData found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString, paramLong, paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramErrMsg);
  }
  
  public void OnRefreshSMSVerifyLoginCode(String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode ret =" + paramInt3 + " mobile=" + paramString1 + " msg=" + paramString2 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode errMsg =" + paramErrMsg.getMessage());
      }
    }
    i.b(paramWUserSigInfo).a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
  }
  
  public void OnRegCheckDownloadMsg(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    i.b(paramWUserSigInfo).c(paramWUserSigInfo, paramInt, paramArrayOfByte);
  }
  
  public void OnRegCheckUploadMsg(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void OnRegCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramArrayOfByte);
  }
  
  public void OnRegError(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramInt, paramArrayOfByte);
  }
  
  public void OnRegGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("WtloginCenterCallback", 4, "OnRegGetSMSVerifyLoginAccount ret =" + paramInt + " uin=" + paramLong);
    }
    i.b(paramWUserSigInfo).a(paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public void OnRegQueryAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WTLoginCenter.OnRegQueryAccount ret = " + paramInt);
    }
    i.b(paramWUserSigInfo).b(paramWUserSigInfo, paramInt, paramArrayOfByte);
  }
  
  public void OnRegQueryClientSendedMsgStatus(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    i.b(paramWUserSigInfo).a(paramWUserSigInfo, paramInt1, paramInt2, paramInt3);
  }
  
  public void OnRegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    i.b(paramWUserSigInfo).b(paramWUserSigInfo, paramInt1, paramInt2, paramInt3);
  }
  
  public void OnRegSubmitMsgChk(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    i.b(paramWUserSigInfo).d(paramWUserSigInfo, paramInt, paramArrayOfByte);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    i.b(paramWUserSigInfo).a(paramString, paramArrayOfByte1, paramLong, paramList, paramWUserSigInfo, paramArrayOfByte2, paramInt);
  }
  
  public void OnVerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode ret =" + paramInt + " mobile=" + paramString1 + " msgCode=" + paramString2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode errMsg =" + paramErrMsg.getMessage());
      }
    }
    i.b(paramWUserSigInfo).a(paramString1, paramString2, paramInt, paramErrMsg);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    i.b(paramWUserSigInfo).a(paramString, paramLong1, paramInt1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, paramInt2, paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.j
 * JD-Core Version:    0.7.0.1
 */