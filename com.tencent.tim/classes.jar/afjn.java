import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class afjn
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public afjn(MessengerService.a parama, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    Bundle localBundle;
    if (paramBundle != null) {
      localBundle = new Bundle();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramBundle.getLong("retCode", 0L));
      if (!paramBoolean) {
        localJSONObject.put("msg", paramBundle.getString("errMsg"));
      }
      localBundle.putString("result", localJSONObject.toString());
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.cp(this.val$reqbundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("launchMiniAppById", 1, "launchMiniAppById error,", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjn
 * JD-Core Version:    0.7.0.1
 */