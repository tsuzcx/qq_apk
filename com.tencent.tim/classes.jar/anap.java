import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class anap
  extends WtloginListener
{
  anap(anan paramanan, String paramString, WtloginHelper paramWtloginHelper, int paramInt, Context paramContext) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "geta1 OnException " + paramErrMsg);
    }
    anan.cEB = false;
    this.jdField_a_of_type_Anan.dp.removeMessages(0);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_Anan.dp.removeMessages(0);
    anan.cEB = false;
    if (paramInt2 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "geta1 failed " + paramInt2);
      }
      return;
    }
    paramArrayOfByte1 = new Intent("android.intent.action.VIEW", Uri.parse(this.val$scheme));
    paramArrayOfByte1.putExtras(this.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo));
    paramArrayOfByte1.setFlags(this.val$flags);
    this.val$context.startActivity(paramArrayOfByte1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anap
 * JD-Core Version:    0.7.0.1
 */