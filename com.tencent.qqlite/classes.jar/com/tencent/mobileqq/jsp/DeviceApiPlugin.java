package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceApiPlugin
  extends WebViewPlugin
{
  public static PowerManager.WakeLock a;
  public static final String a = "DeviceApiPlugin";
  public static boolean a = false;
  private static final String b = "device";
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(10, "VasWakeLock");
      }
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      if ((jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
    } while (paramBoolean2);
    jdField_a_of_type_Boolean = false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"device".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString2 = paramString1.substring(i + 1);
    if (paramString2 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString2, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DeviceApiPlugin", 2, "Failed to decode json str, josn=" + paramString2);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramString2 = new JSONObject(paramJsBridgeListener);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DeviceApiPlugin", 2, "Failed to parse json str,json=" + null);
          }
          paramString2 = null;
        }
        try
        {
          if (paramString2.has("callback"))
          {
            paramJsBridgeListener = paramString2.getString("callback");
          }
          else
          {
            i = paramString1.indexOf("#");
            if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
              break label519;
            }
            paramJsBridgeListener = paramString1.substring(i + 1);
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DeviceApiPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
          }
          paramJsBridgeListener = null;
        }
      }
    }
    if ("setScreenStatus".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        if (!paramString2.has("status")) {
          break label507;
        }
        i = paramString2.getInt("status");
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceApiPlugin", 2, "Failed to setScreenStatus:" + paramString1.getMessage());
        callJs(paramJsBridgeListener, new String[] { "{'result':-1,'message':" + paramString1.getMessage() + "}" });
        break label533;
      }
      a(bool, this.mRuntime.a().getApplicationContext(), false);
      if (jdField_a_of_type_Boolean)
      {
        paramString1 = "{'result':1,'message':'light'}";
        callJs(paramJsBridgeListener, new String[] { paramString1 });
      }
      else
      {
        paramString1 = "{'result':0,'message':'dim'}";
        continue;
        if (QLog.isColorLevel()) {
          QLog.w("DeviceApiPlugin", 2, "NOT support method " + paramString3 + " yet!!");
        }
        return false;
        label507:
        i = 0;
        break label521;
        if (paramJsBridgeListener != null) {
          break;
        }
        return false;
        label519:
        return false;
        label521:
        if (i != 1) {
          break label535;
        }
        bool = true;
        continue;
      }
      label533:
      return true;
      label535:
      boolean bool = false;
    }
  }
  
  protected void onDestroy()
  {
    if (jdField_a_of_type_Boolean) {
      a(false, null, false);
    }
    if (jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DeviceApiPlugin
 * JD-Core Version:    0.7.0.1
 */