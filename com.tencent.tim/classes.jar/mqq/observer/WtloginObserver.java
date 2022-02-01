package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Constants.Action;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class WtloginObserver
  implements Constants.Action, BusinessObserver
{
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSAndGetStExt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnException(String paramString, int paramInt) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void OnRefreshPictureData(String paramString, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void OnRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void OnRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg) {}
  
  public void OnVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2100: 
      OnGetStWithPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getString("userPasswd"), paramBundle.getByteArray("pictureData"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2101: 
      OnGetStWithoutPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getLong("dwDstAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2102: 
      OnCheckPictureAndGetSt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), paramBundle.getByteArray("pictureData"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2103: 
      OnRefreshPictureData(paramBundle.getString("userAccount"), paramBundle.getByteArray("pictureData"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2104: 
      OnVerifyCode(paramBundle.getString("userAccount"), paramBundle.getByteArray("appName"), paramBundle.getLong("time"), paramBundle.getStringArrayList("data"), paramBundle.getByteArray("errMsg"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2105: 
      OnCloseCode(paramBundle.getString("userAccount"), paramBundle.getByteArray("appName"), paramBundle.getLong("time"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getByteArray("errMsg"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2106: 
      onGetA1WithA1(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubSrcAppid"), paramBundle.getByteArray("dstAppName"), paramBundle.getLong("dwDstSsoVer"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getByteArray("dstAppVer"), paramBundle.getByteArray("dstAppSign"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), (WFastLoginInfo)paramBundle.getParcelable("fastLoginInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2108: 
      OnCheckDevLockStatus((WUserSigInfo)paramBundle.getParcelable("sigInfo"), (DevlockInfo)paramBundle.getParcelable("devLockInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2109: 
      OnAskDevLockSms((WUserSigInfo)paramBundle.getParcelable("sigInfo"), (DevlockInfo)paramBundle.getParcelable("devLockInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2110: 
      OnCheckDevLockSms((WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2111: 
      OnCloseDevLock((WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2112: 
      OnRefreshSMSData(paramBundle.getString("userAccount"), paramBundle.getLong("smsAppid"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("remainMsgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2113: 
      OnCheckSMSAndGetSt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2114: 
      OnCheckSMSAndGetStExt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), (byte[][])null, paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2117: 
      if (paramBundle.getBoolean("reg_LiangHao"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "OnRegGetSMSVerifyLoginAccountWithLhSig");
        }
        OnRegGetSMSVerifyLoginAccountWithLhSig(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"), paramBundle.getByteArray("lhsig"));
      }
      for (;;)
      {
        OnRegGetSMSVerifyLoginAccount(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"));
        return;
        OnRegGetSMSVerifyLoginAccount(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"));
      }
    case 2118: 
      OnCheckSMSVerifyLoginAccount(paramBundle.getLong("appid"), paramBundle.getLong("subAppid"), paramBundle.getString("countryCode"), paramBundle.getString("mobile"), paramBundle.getString("msg"), paramBundle.getInt("msgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2119: 
      OnRefreshSMSVerifyLoginAccount(paramBundle.getString("mobile"), paramBundle.getString("msg"), paramBundle.getInt("msgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2120: 
      OnVerifySMSVerifyLoginAccount(paramBundle.getString("mobile"), paramBundle.getString("msgCode"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2121: 
      byte[] arrayOfByte = paramBundle.getByteArray("lhsig");
      paramInt = paramBundle.getInt("ret");
      String str2 = paramBundle.getString("userAccount");
      String str1 = str2;
      if (paramInt != 0)
      {
        str1 = str2;
        if (arrayOfByte != null)
        {
          str2 = paramBundle.getString("uin");
          str1 = str2;
          if (QLog.isColorLevel())
          {
            QLog.d("wtlogin_Lianghao", 2, "SMSVerifyLogin|phone=" + paramBundle.getString("userAccount") + "|" + str2);
            str1 = str2;
          }
        }
      }
      OnGetStViaSMSVerifyLogin(str1, paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), paramInt, arrayOfByte, (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2122: 
      OnGetSubaccountStViaSMSVerifyLogin(paramBundle.getString("submainaccount"), paramBundle.getString("userAccount"), paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2208: 
      OnGetOpenKeyWithoutPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getLong("dwDstAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getByteArray("openid"), paramBundle.getByteArray("accessToken"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    }
    OnException(paramBundle.getString("error"), paramBundle.getInt("cmd"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.observer.WtloginObserver
 * JD-Core Version:    0.7.0.1
 */