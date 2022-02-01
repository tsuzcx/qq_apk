import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class igc
  extends WebViewPlugin
  implements iga.a
{
  private aqyv a;
  private boolean isLoadFinish;
  
  public igc()
  {
    this.mPluginNameSpace = "aioShareMusic";
  }
  
  public void f(String paramString, JSONObject paramJSONObject)
  {
    if ((this.mRuntime == null) || (this.mRuntime.b() == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.AioShareMusicPlugin", 2, "onEvent（） actionType =" + paramString + " data = " + paramJSONObject.toString());
      }
      if (this.a == null) {
        this.a = new aqyv(this.mRuntime.b());
      }
      if ("checkAioShareMusic".equals(paramString))
      {
        this.a.bT(paramJSONObject);
        return;
      }
      if ("startListenAioShareMusic".equals(paramString))
      {
        this.a.bU(paramJSONObject);
        return;
      }
      if ("updateSongIdToAioShareMusic".equals(paramString)) {
        try
        {
          paramString = paramJSONObject.getString("current_song_id");
          this.a.cyG = paramString;
          if (QLog.isColorLevel())
          {
            QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "updateSongId() newSongId = " + paramString);
            return;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime == null) || (this.mRuntime.b() == null) || (this.mRuntime.getActivity() == null)) {
      return true;
    }
    if (this.a == null) {
      this.a = new aqyv(this.mRuntime.b());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicAioShareMusic.AioShareMusicPlugin", 2, "handleEvent() type = " + paramLong);
    }
    if (paramLong == 8589934594L)
    {
      if (!this.isLoadFinish)
      {
        this.isLoadFinish = true;
        this.a.dR(this.mRuntime.getActivity().getIntent());
        return true;
      }
    }
    else if (paramLong == 8589934622L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        paramString = (Intent)localObject;
        this.a.dS(paramString);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public void onCreate()
  {
    super.onCreate();
    iga.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.onDestroy();
      this.a = null;
    }
    iga.a().unregister();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igc
 * JD-Core Version:    0.7.0.1
 */