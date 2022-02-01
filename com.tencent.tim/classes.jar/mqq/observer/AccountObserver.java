package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Action;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class AccountObserver
  implements Constants.Action, BusinessObserver
{
  private static final List<Integer> LOGIN_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(1001), Integer.valueOf(2205), Integer.valueOf(2206), Integer.valueOf(2207), Integer.valueOf(2400) });
  private static final List<Integer> OTHER_ACCOUNT_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(2211), Integer.valueOf(1022), Integer.valueOf(1007), Integer.valueOf(1030), Integer.valueOf(1032), Integer.valueOf(1046) });
  private static final List<Integer> REGISTER_ACTIONS = Arrays.asList(new Integer[] { Integer.valueOf(1040), Integer.valueOf(1002), Integer.valueOf(1041), Integer.valueOf(1003), Integer.valueOf(1004), Integer.valueOf(1020), Integer.valueOf(1005), Integer.valueOf(1008), Integer.valueOf(1009) });
  
  private void onReceiveLoginActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject3;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      paramInt = paramBundle.getInt("code");
      localObject2 = paramBundle.getString("alias");
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("onRV  action login code = ").append(paramInt).append("; alias = ");
        if (localObject2 != null) {
          break label149;
        }
      }
      for (localObject1 = "is null";; localObject1 = localObject2)
      {
        QLog.d("AccountObserver", 2, (String)localObject1);
        if (!paramBoolean) {
          break;
        }
        localObject1 = paramBundle.getByteArray("tlv543In119");
        onLoginSuccess(paramBundle.getString("uin"), (String)localObject2, (byte[])localObject1);
        return;
      }
      if ((paramInt == 1002) || (paramInt == 1013))
      {
        onLoginTimeout((String)localObject2);
        return;
      }
      if (paramInt == 2006)
      {
        onUserCancel((String)localObject2);
        return;
      }
      localObject1 = paramBundle.getString("errorurl");
      paramInt = paramBundle.getInt("loginret");
      localObject3 = paramBundle.getByteArray("lhsig");
      i = paramBundle.getInt("errorver");
      onLoginFailed((String)localObject2, paramBundle.getString("error"), (String)localObject1, paramInt, (byte[])localObject3, i);
      return;
    case 2205: 
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      onVerifyPasswd((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, paramBundle.getInt("ret"), paramBundle.getString("notice"), paramBundle.getByteArray("image"));
      return;
    case 2206: 
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      localObject2 = paramBundle.getString("userAccount");
      localObject3 = paramBundle.getString("errorMsg");
      i = paramBundle.getInt("ret");
      ErrMsg localErrMsg = (ErrMsg)paramBundle.getParcelable("lastError");
      onVerifyPasswdImage((String)localObject1, paramBoolean, (String)localObject3, paramInt, (String)localObject2, paramBundle.getByteArray("userInput"), i, localErrMsg, paramBundle.getByteArray("image"));
      return;
    case 2207: 
      label149:
      localObject1 = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("resultCode");
      localObject2 = paramBundle.getString("userAccount");
      onVerifyPasswdRefreshImage((String)localObject1, paramBoolean, paramBundle.getString("errorMsg"), paramInt, (String)localObject2, paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"), paramBundle.getByteArray("pictureData"));
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (QLog.isColorLevel()) {
      QLog.d("AccountObserver", 2, "onRV  action login by wx code = " + paramInt + "; isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      localObject1 = paramBundle.getByteArray("tlv543In119");
      onLoginSuccess(paramBundle.getString("account"), null, (byte[])localObject1);
      return;
    }
    if ((paramInt == 1002) || (paramInt == 1013))
    {
      onLoginTimeout(null);
      return;
    }
    if (paramInt == 2006)
    {
      onUserCancel(null);
      return;
    }
    Object localObject1 = paramBundle.getString("errorurl");
    paramInt = paramBundle.getInt("loginret");
    Object localObject2 = paramBundle.getByteArray("lhsig");
    int i = paramBundle.getInt("errorver");
    onLoginFailed(null, paramBundle.getString("error"), (String)localObject1, paramInt, (byte[])localObject2, i);
  }
  
  private void onReceiveLoginRegisterActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1040: 
      onRegisterCmdCallback(paramBoolean);
      return;
    case 1002: 
      AppRuntime.Status localStatus = (AppRuntime.Status)paramBundle.getSerializable("onlineStatus");
      boolean bool1 = paramBundle.getBoolean("isChanged");
      long l = paramBundle.getLong("timeStamp");
      boolean bool2 = paramBundle.getBoolean("isLargeChanged");
      onOnlineStatusChanged(paramBoolean, localStatus, paramBundle.getBoolean("isUserSet", false), bool1, l, bool2);
      return;
    case 1041: 
      onRegQueryAccountResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"));
      return;
    case 1003: 
      onRegisterCommitMobileResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("mobile"), paramBundle.getString("inviteCode"));
      return;
    case 1004: 
      onRegisterCommitSmsCodeResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("bind_qq_uin"), paramBundle.getString("bind_qq_nick"), paramBundle.getString("bind_qq_face_url"), paramBundle.getByteArray("promptInfo"));
      return;
    case 1020: 
      onRegisterSendResendSmsreqResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"));
      return;
    case 1005: 
      if (paramBundle.getBoolean("reg_Lianghao", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassRespWithLhSig");
        }
        onRegisterCommitPassRespWithLhSig(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"), paramBundle.getByteArray("lhsig"));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "onRegisterCommitPassResp");
      }
      onRegisterCommitPassResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"));
      return;
    case 1008: 
      onCheckQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo_error"));
      return;
    }
    onGetQuickRegisterAccount(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getString("phone"), paramBundle.getByteArray("promptInfo_error"));
  }
  
  private void onReceiveOtherAccountActions(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2211: 
      AppRuntime.Status localStatus2 = (AppRuntime.Status)paramBundle.getSerializable("onlineStatus");
      AppRuntime.Status localStatus1 = localStatus2;
      if (localStatus2 == AppRuntime.Status.qme) {
        localStatus1 = AppRuntime.Status.online;
      }
      onOnlineStatusPush(localStatus1, paramBundle.getLong("extOnlineStatus"));
    case 1022: 
      onRegisterQuerySmsStatResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"), paramBundle.getString("uin"), paramBundle.getString("nick"), paramBundle.getString("faceUrl"), paramBundle.getString("errmsg"));
      return;
    case 1007: 
      onDeleteAccount(paramBoolean);
      return;
    case 1030: 
      onGetKeyResp(paramBundle.getString("key"));
      return;
    case 1032: 
      onChangeToken(paramBoolean, (HashMap)paramBundle.getSerializable("map"));
      return;
    }
    onRefreshDA2(paramBoolean, paramBundle.getString("account"), paramBundle.getString("da2"));
  }
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onDeleteAccount(boolean paramBoolean) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3) {}
  
  public void onGetKeyResp(String paramString) {}
  
  public void onGetQuickRegisterAccount(boolean paramBoolean, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  protected void onLoginTimeout(String paramString) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4) {}
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (REGISTER_ACTIONS.contains(Integer.valueOf(paramInt))) {
      onReceiveLoginRegisterActions(paramInt, paramBoolean, paramBundle);
    }
    do
    {
      return;
      if (LOGIN_ACTIONS.contains(Integer.valueOf(paramInt)))
      {
        onReceiveLoginActions(paramInt, paramBoolean, paramBundle);
        return;
      }
    } while (!OTHER_ACCOUNT_ACTIONS.contains(Integer.valueOf(paramInt)));
    onReceiveOtherAccountActions(paramInt, paramBoolean, paramBundle);
  }
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onRegisterCmdCallback(boolean paramBoolean) {}
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString) {}
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void onRegisterCommitPassRespWithLhSig(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {}
  
  public void onUpdateSKey(String paramString1, String paramString2) {}
  
  public void onUpdateSTwxWeb(String paramString) {}
  
  protected void onUserCancel(String paramString) {}
  
  public void onVerifyPasswd(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2, String paramString3, byte[] paramArrayOfByte) {}
  
  public void onVerifyPasswdImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, byte[] paramArrayOfByte1, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte2) {}
  
  public void onVerifyPasswdRefreshImage(String paramString1, boolean paramBoolean, String paramString2, int paramInt1, String paramString3, int paramInt2, ErrMsg paramErrMsg, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.observer.AccountObserver
 * JD-Core Version:    0.7.0.1
 */