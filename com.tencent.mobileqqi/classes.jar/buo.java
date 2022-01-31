import android.os.Bundle;
import com.tencent.biz.webviewplugin.AdWebviewPlugin;
import com.tencent.mobileqq.mp.SSOHttp.SSOHttpResponse;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class buo
  implements BusinessObserver
{
  public buo(AdWebviewPlugin paramAdWebviewPlugin, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    while (!paramBoolean) {
      return;
    }
    try
    {
      SSOHttp.SSOHttpResponse localSSOHttpResponse = new SSOHttp.SSOHttpResponse();
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localSSOHttpResponse.mergeFrom(paramBundle);
      }
      paramBundle = new JSONObject();
      paramBundle.put("header", localSSOHttpResponse.header.get());
      paramBundle.put("body", localSSOHttpResponse.body.get());
      paramBundle.put("retcode", localSSOHttpResponse.retcode.get());
      this.jdField_a_of_type_ComTencentBizWebviewpluginAdWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     buo
 * JD-Core Version:    0.7.0.1
 */