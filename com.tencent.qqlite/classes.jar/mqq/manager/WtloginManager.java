package mqq.manager;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public abstract interface WtloginManager
  extends Manager
{
  public abstract int AskDevLockSms(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckDevLockSms(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckDevLockStatus(String paramString, long paramLong, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckSMSAndGetStExt(String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver);
  
  public abstract int CheckSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract Boolean ClearUserFastLoginData(String paramString, long paramLong);
  
  public abstract int CloseCode(String paramString, long paramLong, byte[] paramArrayOfByte, int paramInt, ArrayList<String> paramArrayList, WtloginObserver paramWtloginObserver);
  
  public abstract int CloseDevLock(String paramString, long paramLong, WtloginObserver paramWtloginObserver);
  
  public abstract int GetA1WithA1(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WFastLoginInfo paramWFastLoginInfo, WtloginObserver paramWtloginObserver);
  
  public abstract List<WloginLoginInfo> GetAllLoginInfo();
  
  public abstract Boolean GetBasicUserInfo(String paramString, WloginSimpleInfo paramWloginSimpleInfo);
  
  public abstract WUserSigInfo GetLocalSig(String paramString, long paramLong);
  
  public abstract Ticket GetLocalTicket(String paramString, long paramLong, int paramInt);
  
  public abstract int GetStViaSMSVerifyLogin(String paramString1, String paramString2, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract int GetStWithPasswd(String paramString1, long paramLong, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract int GetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, WtloginObserver paramWtloginObserver);
  
  public abstract int GetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, String paramString3, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract boolean IsNeedLoginWithPasswd(String paramString, int paramInt);
  
  public abstract boolean IsUserHaveA1(String paramString, long paramLong);
  
  public abstract boolean IsWtLoginUrl(String paramString);
  
  public abstract int RefreshPictureData(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int RefreshSMSData(String paramString, WtloginObserver paramWtloginObserver);
  
  public abstract int RefreshSMSVerifyLoginCode(String paramString1, String paramString2, WtloginObserver paramWtloginObserver);
  
  public abstract int RegGetSMSVerifyLoginAccount(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginObserver paramWtloginObserver);
  
  public abstract int VerifyCode(String paramString, long paramLong, boolean paramBoolean, byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt, WtloginObserver paramWtloginObserver);
  
  public abstract int VerifySMSVerifyLoginCode(String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver);
  
  public abstract boolean getHasPwd(String paramString);
  
  public abstract byte[] getPkgSigFromApkName(Context paramContext, String paramString);
  
  public abstract void refreLocalHelper(Context paramContext);
  
  public abstract void setHasPwd(String paramString, boolean paramBoolean);
  
  public abstract void setRegDevLockFlag(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.manager.WtloginManager
 * JD-Core Version:    0.7.0.1
 */