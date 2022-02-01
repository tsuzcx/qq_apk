import android.os.Bundle;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.QZoneShareActivity;
import mqq.observer.BusinessObserver;

public class awaa
  implements BusinessObserver
{
  public awaa(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (QZoneShareActivity.dZ)
    {
      this.this$0.chl = false;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localGetAppinfoResponse.mergeFrom(paramBundle);
          this.this$0.a = localGetAppinfoResponse;
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, "get appinfo time = " + (System.currentTimeMillis() - this.this$0.aaE));
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, paramBundle.getMessage());
          }
        }
      }
      QZoneShareActivity.dZ.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awaa
 * JD-Core Version:    0.7.0.1
 */