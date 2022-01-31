import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class bmp
  extends WtloginObserver
{
  public bmp(QRLoginActivity paramQRLoginActivity) {}
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnCloseCode userAccount=" + paramString + " ret=" + paramInt);
    }
    paramString = new Message();
    paramArrayOfByte1 = new Bundle();
    paramArrayOfByte1.putInt("ret", paramInt);
    paramArrayOfByte1.putByteArray("errMsg", paramArrayOfByte2);
    paramString.setData(paramArrayOfByte1);
    paramString.what = 2;
    this.a.a.sendMessage(paramString);
  }
  
  public void OnException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnException e=" + paramString);
    }
    paramString = new Message();
    paramString.what = 3;
    this.a.a.sendMessage(paramString);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginActivity", 2, "OnVerifyCode userAccount=" + paramString + " ret=" + paramInt);
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.b = paramString;
    paramErrMsg = null;
    paramString = paramErrMsg;
    if (paramArrayList != null)
    {
      paramString = paramErrMsg;
      if (paramArrayList.size() > 0) {
        paramString = HexUtil.hexStr2Bytes((String)paramArrayList.get(0));
      }
    }
    paramArrayList = new Message();
    paramErrMsg = new Bundle();
    paramErrMsg.putInt("ret", paramInt);
    paramErrMsg.putByteArray("tlv", paramString);
    paramErrMsg.putByteArray("appName", paramArrayOfByte1);
    paramErrMsg.putByteArray("errMsg", paramArrayOfByte2);
    paramArrayList.setData(paramErrMsg);
    paramArrayList.what = 1;
    this.a.a.sendMessage(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmp
 * JD-Core Version:    0.7.0.1
 */