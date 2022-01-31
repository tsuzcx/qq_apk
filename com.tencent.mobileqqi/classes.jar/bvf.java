import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bvf
  implements BusinessObserver
{
  public bvf(Share paramShare) {}
  
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
      ThreadManager.a(new bvg(this, paramBundle));
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(Share.b(), 2, localInvalidProtocolBufferMicroException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bvf
 * JD-Core Version:    0.7.0.1
 */