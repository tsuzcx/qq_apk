import android.os.Handler;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import org.json.JSONException;
import org.json.JSONObject;

public class tht
  implements TVK_SDKMgr.InstallListener
{
  private Handler a;
  
  public tht(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onInstallProgress(float paramFloat)
  {
    if (this.a != null) {
      this.a.sendEmptyMessage(2);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.3.5");
      localJSONObject.put("error_code", paramInt);
      if (this.a != null) {
        this.a.sendEmptyMessage(1);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        tlo.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] JSONException: " + localException.getLocalizedMessage());
      }
    }
  }
  
  public void onInstalledSuccessed()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.3.5");
      if (this.a != null) {
        this.a.sendEmptyMessage(0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        tlo.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: " + localJSONException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tht
 * JD-Core Version:    0.7.0.1
 */