import android.os.Bundle;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class jzn
  implements BusinessObserver
{
  public jzn(NativeAdUtils.3 param3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        if ((localWebSsoResponseBody.ret.has()) && (localWebSsoResponseBody.ret.get() == 0) && (QLog.isColorLevel())) {
          QLog.d("NativeAdUtils", 2, " new report success");
        }
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzn
 * JD-Core Version:    0.7.0.1
 */