import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xmw
  implements BusinessObserver
{
  xmw(xmt paramxmt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    byte[] arrayOfByte;
    do
    {
      return;
      arrayOfByte = paramBundle.getByteArray("data");
    } while (arrayOfByte == null);
    paramBundle = new GetAppInfoProto.GetAppinfoResponse();
    try
    {
      paramBundle.mergeFrom(arrayOfByte);
      ThreadManager.post(new Share.7.1(this, paramBundle), 5, null, true);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(xmt.a, 2, localInvalidProtocolBufferMicroException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xmw
 * JD-Core Version:    0.7.0.1
 */