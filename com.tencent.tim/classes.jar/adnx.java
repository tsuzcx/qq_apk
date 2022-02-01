import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.25.1;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

public class adnx
  extends WtloginObserver
{
  adnx(adnq.c paramc, long paramLong) {}
  
  public void OnGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "OnGetOpenKeyWithoutPasswd userAccount=" + paramString + ", dwSrcAppid=" + paramLong1 + ", dwDstAppid=" + paramLong2 + ", dwMainSigMap=" + paramInt1 + ", ret=" + paramInt2);
    }
    ArkDispatchTask.getInstance().post(this.this$0.mAppName, new ArkAppModuleReg.ModuleQQ.25.1(this, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramLong2, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnx
 * JD-Core Version:    0.7.0.1
 */