import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class aicb
  extends WtloginListener
{
  aicb(aica paramaica, String paramString) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    if (QLog.isColorLevel()) {
      QLog.i("XProxy", 2, "获取Now结合版A1票据返回异常，cmd = " + paramInt + " errmsg = " + paramErrMsg.getMessage());
    }
    aica.a(this.a, this.bMN, false, paramInt);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      this.a.a.ac = this.a.c.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
      this.a.abi = System.currentTimeMillis();
      aica.a(this.a, this.bMN, true, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("XProxy", 2, "获取Now结合版A1票据返回失败，retCode = " + paramInt2);
    }
    aica.a(this.a, this.bMN, false, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicb
 * JD-Core Version:    0.7.0.1
 */