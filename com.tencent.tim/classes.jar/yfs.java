import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class yfs
  extends WtloginObserver
{
  yfs(yfq paramyfq, long paramLong, int[] paramArrayOfInt, DevlockInfo[] paramArrayOfDevlockInfo) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    long l;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      paramWUserSigInfo = new StringBuilder().append("CheckDevLockStatus ret: ").append(paramInt).append(", has devinfo: ");
      if (paramDevlockInfo != null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("C2CMsgRoamProxy", 2, bool + ", cost: " + (l - this.val$begin) + "ms");
      this.iG[0] = paramInt;
      this.jdField_a_of_type_ArrayOfOicqWlogin_sdkDevicelockDevlockInfo[0] = paramDevlockInfo;
      yfq.b(this.jdField_a_of_type_Yfq).chT();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfs
 * JD-Core Version:    0.7.0.1
 */