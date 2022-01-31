import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class yyo
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRelease", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if (!"accountRelease".equals(paramString2)) {
      return false;
    }
    if ("onReleaseSuccess".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setResult(-1, null);
        paramJsBridgeListener.finish();
      }
    }
    while (!"getToken".equals(paramString3)) {
      for (;;)
      {
        return false;
        QLog.d("AccountRelease", 1, "release success, activity == null");
      }
    }
    paramJsBridgeListener = this.mRuntime.a();
    paramString1 = this.mRuntime.a();
    boolean bool = false;
    if (paramString1 != null) {
      bool = paramString1.getIntent().getBooleanExtra("is_release_account", false);
    }
    for (;;)
    {
      if ((bool) && (paramJsBridgeListener != null))
      {
        paramString1 = (TicketManager)paramJsBridgeListener.getManager(2);
        paramJsBridgeListener = paramJsBridgeListener.getCurrentAccountUin();
        paramString1 = paramString1.getA2(paramJsBridgeListener);
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString1)))
        {
          paramString1 = bdcv.a(paramString1);
          long l = Long.valueOf(paramJsBridgeListener).longValue();
          paramJsBridgeListener = new byte[76];
          paramJsBridgeListener[3] = ((byte)(int)(0xFF & l));
          paramJsBridgeListener[2] = ((byte)(int)(l >>> 8 & 0xFF));
          paramJsBridgeListener[1] = ((byte)(int)(l >>> 16 & 0xFF));
          paramJsBridgeListener[0] = ((byte)(int)(l >>> 24 & 0xFF));
          int i = 0;
          for (;;)
          {
            if (i < paramString1.length)
            {
              paramJsBridgeListener[(i + 4)] = paramString1[i];
              i += 1;
              continue;
              QLog.d("AccountRelease", 1, "getToken, activity == null");
              break;
            }
          }
          paramJsBridgeListener = bfhi.a(paramJsBridgeListener);
          if (QLog.isColorLevel()) {
            QLog.d("AccountRelease", 2, String.format("getToken: %s", new Object[] { paramJsBridgeListener }));
          }
          paramString1 = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramJsBridgeListener)) {
          break label465;
        }
        paramString1.put("token", "");
        callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { paramString1.toString() });
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      break;
      QLog.d("AccountRelease", 1, "uin or a2 is empty, uin:" + paramJsBridgeListener + ",a2:" + paramString1);
      for (;;)
      {
        paramJsBridgeListener = "";
        break;
        QLog.d("AccountRelease", 1, "getToken, app == null or flag: " + bool);
      }
      label465:
      paramString1.put("token", paramJsBridgeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */