package mqq.manager;

import java.util.HashMap;
import mqq.observer.AccountObserver;

public abstract interface AccountManager
  extends Manager
{
  public abstract void changeToken(HashMap<String, Object> paramHashMap, AccountObserver paramAccountObserver);
  
  public abstract void deleteAccount(String paramString, AccountObserver paramAccountObserver);
  
  public abstract void getKey(AccountObserver paramAccountObserver);
  
  public abstract void queryUpSmsStat(AccountObserver paramAccountObserver);
  
  public abstract void sendRegistByPhoneNumber(byte paramByte, String paramString1, String paramString2, Long paramLong, AccountObserver paramAccountObserver);
  
  public abstract void sendRegistByResendSms(AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterByCommitSmsVerifycode(String paramString, AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterBySetPass(String paramString1, String paramString2, String paramString3, AccountObserver paramAccountObserver);
  
  public abstract void sendRegisterQueryMobile(String paramString1, String paramString2, AccountObserver paramAccountObserver);
  
  public abstract void updateSKey(AccountObserver paramAccountObserver);
  
  public abstract void updateSTwxWeb(AccountObserver paramAccountObserver);
  
  public abstract void updateSid(AccountObserver paramAccountObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.manager.AccountManager
 * JD-Core Version:    0.7.0.1
 */