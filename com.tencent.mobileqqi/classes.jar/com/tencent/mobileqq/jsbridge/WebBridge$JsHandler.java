package com.tencent.mobileqq.jsbridge;

import com.tencent.mobileqq.app.JavaScriptInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class WebBridge$JsHandler
  implements JavaScriptInterface
{
  public void call(String paramString1, String paramString2, WebBridge.JsBridgeListener paramJsBridgeListener)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    JSONObject localJSONObject = null;
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      Object localObject = localJSONObject;
      if (i < j)
      {
        localObject = arrayOfMethod[i];
        if (!((Method)localObject).getName().equals(paramString1)) {}
      }
      else
      {
        if (localObject != null)
        {
          if (paramString2 != null) {}
          try
          {
            if (paramString2.length() > 0) {}
            for (localJSONObject = new JSONObject(paramString2);; localJSONObject = new JSONObject())
            {
              if (QLog.isColorLevel()) {
                QLog.i("BaseWebActivity.WebBridge", 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + localJSONObject);
              }
              ((Method)localObject).invoke(this, new Object[] { localJSONObject, paramJsBridgeListener });
              return;
            }
            paramJsBridgeListener.a();
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BaseWebActivity.WebBridge", 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
            }
            if (paramJsBridgeListener == null) {
              break label536;
            }
            paramJsBridgeListener.a("args is not json string");
            return;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BaseWebActivity.WebBridge", 2, "Web Bridge call method IllegalAccessException:" + localIllegalAccessException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
            }
            if (paramJsBridgeListener == null) {
              break label536;
            }
            paramJsBridgeListener.a();
            return;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BaseWebActivity.WebBridge", 2, "Web Bridge call method InvocationTargetException:" + localInvocationTargetException.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
            }
            if (paramJsBridgeListener == null) {
              break label536;
            }
            paramJsBridgeListener.a();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BaseWebActivity.WebBridge", 2, "Web Bridge call method Exception:" + localException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
            }
            if (paramJsBridgeListener == null) {
              break label536;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("BaseWebActivity.WebBridge", 2, "not found method;class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
          }
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.a();
          }
        }
        label536:
        return;
      }
      i += 1;
    }
  }
  
  public boolean customCallback()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.WebBridge.JsHandler
 * JD-Core Version:    0.7.0.1
 */