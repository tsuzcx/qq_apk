import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqur
  extends WebViewPlugin
{
  public final String TAG = "VideoApiPlugin";
  protected Client.b mOnRemoteResp = new aqus(this);
  
  public aqur()
  {
    this.mPluginNameSpace = "video";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoApiPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"video".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (!paramJsBridgeListener.has("callback")) {
          break label207;
        }
        paramJsBridgeListener = paramJsBridgeListener.getString("callback");
        if ("isInstalled".equals(paramString3))
        {
          if (afjy.a().ajq())
          {
            paramString1 = new Bundle();
            paramJsBridgeListener = affz.a("ipc_video_isinstalled", paramJsBridgeListener, this.mOnRemoteResp.key, paramString1);
            afjy.a().cq(paramJsBridgeListener);
          }
        }
        else if ("installPlugin".equals(paramString3))
        {
          if (!afjy.a().ajq()) {
            break label205;
          }
          paramString1 = new Bundle();
          paramJsBridgeListener = affz.a("ipc_video_install_plugin", paramJsBridgeListener, this.mOnRemoteResp.key, paramString1);
          afjy.a().cq(paramJsBridgeListener);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      boolean bool = "playVideo".equals(paramString3);
      if (bool) {}
      label205:
      return true;
      label207:
      paramJsBridgeListener = "";
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoApiPlugin", 2, "vip video api plugin on activity result requestCode=" + paramByte + ",resultCode=" + paramInt);
    }
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    afjy.a().a(this.mOnRemoteResp);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    afjy.a().b(this.mOnRemoteResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqur
 * JD-Core Version:    0.7.0.1
 */