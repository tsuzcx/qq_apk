import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class csb
  implements BusinessObserver
{
  public csb(ForwardOperations paramForwardOperations) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localGetAppinfoResponse.mergeFrom(paramBundle);
          if ((localGetAppinfoResponse.has()) && (localGetAppinfoResponse.ret.get() == 0))
          {
            try
            {
              this.a.a = localGetAppinfoResponse;
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOperations", 2, "get appinfo time = " + (System.currentTimeMillis() - this.a.b));
              }
              return;
            }
            finally {}
            if (!QLog.isColorLevel()) {}
          }
        }
      }
      catch (Exception paramBundle) {}
    }
    QLog.d("ForwardOperations", 2, paramBundle.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     csb
 * JD-Core Version:    0.7.0.1
 */