import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWySender;
import com.weiyun.sdk.IWySender.IWySenderCallback;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class awpr
  implements IWySender
{
  private static final awpr jdField_a_of_type_Awpr = new awpr();
  private IWySender.IWySenderCallback jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback;
  private long aBu = 1L;
  
  public static awpr a()
  {
    return jdField_a_of_type_Awpr;
  }
  
  public void cancelCallback()
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = null;
  }
  
  public void sendRequest(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.e("WySender", 1, "sendRequest : seq[" + paramInt + "], cmd is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WySender", 1, "sendRequest : seq[" + paramInt + "], cmd[" + paramString + "]");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    paramString = new ToServiceMsg("mobileqq.service", String.valueOf(localAppRuntime.getLongAccountUin()), paramString);
    paramString.setTimeout(Math.min(60000L, (30000.0D * Math.pow(this.aBu, 0.15D))));
    paramString.setEnableFastResend(true);
    paramString.putWupBuffer(paramArrayOfByte);
    paramString.extraData.putInt("sequence", paramInt);
    paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
    paramArrayOfByte = new NewIntent(localAppRuntime.getApplication(), awpu.class);
    paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
    localAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public void setCallback(IWySender.IWySenderCallback paramIWySenderCallback)
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = paramIWySenderCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpr
 * JD-Core Version:    0.7.0.1
 */