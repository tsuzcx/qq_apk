import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aifh
  extends WebViewPlugin
{
  final skj.a b = new aifi(this);
  private int ddk;
  private int ddl;
  private skj i;
  
  public aifh()
  {
    this.mPluginNameSpace = "nowlive";
  }
  
  private void cH(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errcode", paramInt);
      localJSONObject.put("desc", paramString);
      callJs("window.__WEBVIEW_INSTALL && window.__WEBVIEW_INSTALL(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void it(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("progress", paramInt2);
      callJs("window.__WEBVIEW_GETPLUGININFO && window.__WEBVIEW_GETPLUGININFO(" + localJSONObject.toString() + ");");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("NowWebViewPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((this.i == null) || (paramString1 == null) || (!"nowlive".equals(paramString2)) || (paramString3 == null)) {}
    label318:
    do
    {
      return false;
      if ("getPluginInfo".equals(paramString3))
      {
        this.i.bzq();
        it(this.ddk, this.ddl);
      }
      for (;;)
      {
        return true;
        if ("openRoom".equals(paramString3))
        {
          if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NowWebViewPlugin", 2, "handleJsRequest arg = " + paramVarArgs[0]);
          }
          paramJsBridgeListener = paramVarArgs[0];
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            break;
          }
          this.i.fs(Long.valueOf(paramJsBridgeListener).longValue());
          continue;
        }
        if ("install".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowWebViewPlugin", 2, "handleJsRequest install arg = " + paramVarArgs[0]);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            paramJsBridgeListener = paramVarArgs[0];
          }
          for (;;)
          {
            try
            {
              j = Integer.valueOf(paramJsBridgeListener).intValue();
              paramJsBridgeListener = this.i;
              if (j == 1) {
                bool = true;
              }
              paramJsBridgeListener.uQ(bool);
            }
            catch (NumberFormatException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            int j = 0;
          }
        }
        if (!"preload".equals(paramString3)) {
          break label318;
        }
        this.i.bzo();
      }
    } while (!QLog.isColorLevel());
    QLog.w("NowWebViewPlugin", 2, "NOT support method " + paramString3 + " yet!!");
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.i = skj.a();
    this.i.bzj();
    this.i.k(this.b);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      this.i.bzk();
      this.i.bzp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifh
 * JD-Core Version:    0.7.0.1
 */