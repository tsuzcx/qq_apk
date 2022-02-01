package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class VerifyDevLockManagerImpl$1
  extends Handler
{
  VerifyDevLockManagerImpl$1(VerifyDevLockManagerImpl paramVerifyDevLockManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (Object[])paramMessage.obj;
      VerifyDevLockManager.VerifyDevLockObserver localVerifyDevLockObserver = (VerifyDevLockManager.VerifyDevLockObserver)paramMessage[0];
      localVerifyDevLockObserver.onRecvNotice((VerifyDevLockManager.NotifyType)paramMessage[1], ((Integer)paramMessage[2]).intValue(), (String)paramMessage[3], ((Integer)paramMessage[4]).intValue(), (ErrMsg)paramMessage[5], (DevlockInfo)paramMessage[6]);
      localVerifyDevLockObserver.onReceive((VerifyDevLockManager.NotifyType)paramMessage[1], ((Integer)paramMessage[4]).intValue(), paramMessage[7]);
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    ((VerifyDevLockManager.VerifyDevLockObserver)paramMessage[0]).onVerifyClose(((Integer)paramMessage[1]).intValue(), (String)paramMessage[2], ((Integer)paramMessage[3]).intValue(), (ErrMsg)paramMessage[4]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.VerifyDevLockManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */