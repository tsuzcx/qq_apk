import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Locale;
import org.json.JSONObject;

public class ainw
  extends WebViewPlugin
  implements aiow.b
{
  protected String bPj;
  protected String bPk;
  private EIPCResultCallback c = new ainx(this);
  private EIPCResultCallback d = new ainy(this);
  private String mCallbackId;
  
  public ainw()
  {
    this.mPluginNameSpace = "listenTogether";
  }
  
  public void bp(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "statusChanged isDestroy:" + this.isDestroy + " data:" + paramJSONObject + " mCheckJoinCallback:" + this.bPj + " mJoinListenCallback:" + this.bPk);
    }
    if ((paramJSONObject != null) && (TextUtils.equals(paramJSONObject.optString("type"), "checkJoin"))) {
      if (!TextUtils.isEmpty(this.bPj)) {
        localJSONObject = new JSONObject();
      }
    }
    do
    {
      try
      {
        localJSONObject.put("canJoin", paramJSONObject.optInt("canJoin"));
        localJSONObject.put("isOpener", paramJSONObject.optInt("isOpener"));
        localJSONObject.put("uinType", paramJSONObject.optInt("uinType"));
        callJs(this.bPj, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + paramJSONObject.getMessage());
        return;
      }
      if ((paramJSONObject == null) || (!TextUtils.equals(paramJSONObject.optString("type"), "joinListen"))) {
        break;
      }
    } while (TextUtils.isEmpty(this.bPk));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramJSONObject.optInt("retCode"));
      callJs(this.bPk, new String[] { localJSONObject.toString() });
      this.bPk = null;
      return;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + paramJSONObject.getMessage());
      }
    }
    dispatchJsEvent("musicStatusChange", paramJSONObject, null);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("listenTogether".equals(paramString2))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (QLog.isColorLevel()) {
                QLog.d("ListenTogetherPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
              }
              this.mCallbackId = paramJsBridgeListener.optString("callback");
            } while ("awakePlugin".equals(paramString3));
            if (!"statusChanged".equals(paramString3)) {
              break;
            }
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              aiow.br(paramJsBridgeListener);
              if (!"checkJoin".equals(paramJsBridgeListener.opt("type"))) {
                continue;
              }
              if (paramJsBridgeListener != null)
              {
                this.bPj = paramJsBridgeListener.optString("callback");
                return true;
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ListenTogetherPlugin", 1, "METHOD_STATUS_CHANGED exception e = ", paramJsBridgeListener);
              return true;
            }
            this.bPj = null;
            return true;
          } while (!"joinListen".equals(paramJsBridgeListener.opt("type")));
          if (paramJsBridgeListener != null)
          {
            this.bPk = paramJsBridgeListener.optString("callback");
            return true;
          }
          this.bPk = null;
          return true;
          if (!"isOpener".equals(paramString3)) {
            break;
          }
        } while (TextUtils.isEmpty(this.mCallbackId));
        aiow.a(paramJsBridgeListener, "isOpener", this.d);
        return true;
        if (!"isShowAtmosphere".equals(paramString3)) {
          break;
        }
      } while (TextUtils.isEmpty(this.mCallbackId));
      aiow.a(paramJsBridgeListener, "isShowAtmosphere", this.c);
      return true;
      if ("setPlayerId".equals(paramString3))
      {
        aiow.a(paramJsBridgeListener, "setPlayerId", null);
        return true;
      }
      if ("setThemeEnabled".equals(paramString3))
      {
        aiow.a(paramJsBridgeListener, "setThemeEnabled", null);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onCreate");
    }
    aiow.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onDestroy");
    }
    aiow.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainw
 * JD-Core Version:    0.7.0.1
 */