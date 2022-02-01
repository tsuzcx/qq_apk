import android.os.Handler;
import org.json.JSONException;
import org.json.JSONObject;

public class usb
  implements usq
{
  private Handler a;
  
  public usb(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.4.8");
      if (this.a != null) {
        this.a.sendEmptyMessage(0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        uya.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: " + localJSONException.getLocalizedMessage());
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.a != null) {
      this.a.sendEmptyMessage(2);
    }
  }
  
  public void a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.4.8");
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
        uya.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] JSONException: " + localException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usb
 * JD-Core Version:    0.7.0.1
 */