package mqq.manager;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract interface VerifyDevLockManager
  extends Manager
{
  public abstract void cancelVerify(VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract boolean checkVerifyDevLockSmsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void refreshDevLockSms(VerifyDevLockObserver paramVerifyDevLockObserver);
  
  public abstract void submitSms(VerifyDevLockObserver paramVerifyDevLockObserver, String paramString);
  
  public static enum NotifyType
  {
    NOTIFY_AUTH_RESULT,  NOTIFY_REFRESH_SMS_RESULT;
    
    private NotifyType() {}
  }
  
  public static class VerifyDevLockObserver
  {
    private int mSeq;
    
    public int getSeq()
    {
      return this.mSeq;
    }
    
    public void onRecvNotice(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo) {}
    
    public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg) {}
    
    public void setSeq(int paramInt)
    {
      this.mSeq = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.manager.VerifyDevLockManager
 * JD-Core Version:    0.7.0.1
 */