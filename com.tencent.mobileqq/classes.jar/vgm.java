import android.os.Handler;
import org.json.JSONException;
import org.json.JSONObject;

public class vgm
  implements vhb
{
  private Handler a;
  
  public vgm(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "8.4.10");
      if (this.a != null) {
        this.a.sendEmptyMessage(0);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        vmp.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledSuccess] JSONException: " + localJSONException.getLocalizedMessage());
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
      localJSONObject.put("version", "8.4.10");
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
        vmp.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][onInstalledFailed] JSONException: " + localException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */