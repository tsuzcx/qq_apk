import com.tencent.mobileqq.activity.JumpActivity;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class vef
  extends WtloginObserver
{
  public vef(JumpActivity paramJumpActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (paramDevlockInfo != null) {
      afrz.a().update(paramDevlockInfo.TransferInfo);
    }
    paramWUserSigInfo = this.this$0;
    if (paramInt == 0) {}
    for (;;)
    {
      paramWUserSigInfo.c(paramDevlockInfo);
      return;
      paramDevlockInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vef
 * JD-Core Version:    0.7.0.1
 */