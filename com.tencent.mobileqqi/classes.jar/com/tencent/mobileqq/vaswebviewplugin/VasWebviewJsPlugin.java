package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VasWebviewJsPlugin
  extends VasBasePlugin
{
  private static final String TAG = VasWebviewJsPlugin.class.getSimpleName();
  AuthorizeConfig authCfg;
  protected Client.onRemoteRespObserver mOnRemoteResp = new VasWebviewJsPlugin.1(this);
  
  private Method getMethod(Class paramClass, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramClass == null) {
      return localObject2;
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    label26:
    if (i < j)
    {
      localObject2 = arrayOfMethod[i];
      if (!((Method)localObject2).getName().equals(paramString)) {
        break label80;
      }
      localObject1 = localObject2;
    }
    label80:
    for (;;)
    {
      i += 1;
      break label26;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return getMethod(paramClass.getSuperclass(), paramString);
    }
  }
  
  protected void OnActivityCreate() {}
  
  public boolean call(String paramString1, String paramString2, String paramString3)
  {
    Method localMethod = getMethod(getClass(), paramString1);
    if (localMethod != null)
    {
      if (paramString2 != null) {}
      try
      {
        if (paramString2.length() > 0) {}
        for (JSONObject localJSONObject = new JSONObject(paramString2);; localJSONObject = new JSONObject())
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + localJSONObject);
          }
          localMethod.invoke(this, new Object[] { localJSONObject, paramString3 });
          return true;
        }
        if (!QLog.isColorLevel()) {
          break label497;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, localJSONException.getMessage());
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "Web Bridge call method IllegalAccessException:" + localIllegalAccessException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "Web Bridge call method InvocationTargetException:" + localInvocationTargetException.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "Web Bridge call method Exception:" + localException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
    }
    else
    {
      QLog.i(TAG, 2, "not found method;class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
    }
    label497:
    callJsOnError(paramString3, "No such method.");
    return false;
  }
  
  public boolean call(String paramString, List paramList)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    Object localObject2 = null;
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfMethod[i];
        if ((!((Method)localObject1).getName().equals(paramString)) || (((Method)localObject1).getParameterTypes().length != paramList.size())) {}
      }
      else
      {
        j = paramList.size();
        i = 0;
        label72:
        if (i >= j) {
          break label165;
        }
      }
      try
      {
        paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
        i += 1;
        break label72;
        i += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          if (QLog.isDevelopLevel()) {
            QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
          }
        }
      }
    }
    label165:
    if (localObject1 != null) {}
    try
    {
      switch (paramList.size())
      {
      }
      for (;;)
      {
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4), paramList.get(5) });
        break;
        ((Method)localObject1).invoke(this, new Object[0]);
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4) });
        break;
        if (QLog.isDevelopLevel()) {
          QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
        }
        return false;
      }
      return true;
    }
    catch (IllegalAccessException paramString)
    {
      return false;
    }
    catch (InvocationTargetException paramString)
    {
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void callJsOnError(String paramString1, String paramString2)
  {
    callJs(paramString1 + "({'result':-1,'message':'" + paramString2 + "'})");
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    return false;
  }
  
  public void getVipType(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getVipType: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("uin");
      if (!paramJSONObject.equals(this.mRuntime.a().getAccount())) {
        throw new Exception("uin illegal");
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "getVipType failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramJSONObject);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("getUserVipType", paramString, this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  protected boolean handleEmojiSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramString1 == null) {
      bool = false;
    }
    do
    {
      return bool;
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "handleSchemaRequest:" + paramString1);
      }
    } while (paramString1.startsWith("qqvip:") == true);
    if (!Uri.parse(paramString1).getScheme().equals("qqjsbridge"))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "can no do with this url");
      }
      return false;
    }
    Object localObject = new ArrayList(Arrays.asList((paramString1 + "/#").split("/")));
    paramString1 = (String)((ArrayList)localObject).get(2);
    paramString2 = (String)((ArrayList)localObject).get(3);
    if (!"_qqJSBridge_".equals(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "can not handle objectname:" + paramString1);
      }
      return false;
    }
    localObject = ((ArrayList)localObject).subList(4, ((ArrayList)localObject).size() - 1);
    if (QLog.isDevelopLevel()) {
      QLog.d(TAG, 4, "calling " + paramString1 + "." + paramString2 + " args:" + localObject);
    }
    String str = this.mRuntime.a().getUrl();
    if (!this.authCfg.a(str, paramString1 + "." + paramString2)) {
      return false;
    }
    return call(paramString2, (List)localObject);
  }
  
  public boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        return excuteEvent(paramString, paramInt, paramMap);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      OnActivityCreate();
      continue;
      this.onPageStartedTime = System.currentTimeMillis();
      continue;
      this.onPageFinishedTime = System.currentTimeMillis();
    }
  }
  
  protected boolean handleThemeAndBubbleSchemaRequest(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.trim();
      if (!Uri.parse(paramString1).getScheme().equals("qqjsbridge"))
      {
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "can no do with this url:" + paramString1);
          return false;
        }
      }
      else
      {
        Object localObject = paramString1.split("/");
        if (localObject.length < 6)
        {
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, "url params error:url=" + paramString1 + ",params num=" + localObject.length);
            return false;
          }
        }
        else
        {
          paramString1 = localObject[2];
          paramString2 = localObject[3];
          String str = localObject[4];
          localObject = localObject[5];
          if (!paramString3.equals(paramString1))
          {
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "can not handle objectname:" + paramString1);
              return false;
            }
          }
          else {
            try
            {
              paramString3 = URLDecoder.decode((String)localObject, "UTF-8");
              if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "HandleUrl params objectName=" + paramString1 + ",methodName=" + paramString2 + ",callbackId=" + str + ",jsonParams=" + paramString3);
              }
              localObject = this.mRuntime.a().getUrl();
              if (this.authCfg.a((String)localObject, paramString1 + "." + paramString2)) {
                return call(paramString2, paramString3, str);
              }
            }
            catch (UnsupportedEncodingException paramString1)
            {
              if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "jsonParams UnsupportedEncodingException,jsonParams=" + (String)localObject);
              }
              paramString1.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  void onBindedToClient() {}
  
  public void onCreate()
  {
    super.onCreate();
    if (this.authCfg == null) {
      this.authCfg = AuthorizeConfig.a();
    }
    WebIPCOperator.getInstance().registerObserver(this.mOnRemoteResp);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.getInstance().unRegisterObserver(this.mOnRemoteResp);
  }
  
  void onDisconnectWithService() {}
  
  void onPushMsg(Bundle paramBundle) {}
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "response:" + (String)localObject);
      }
      if ((localObject == null) || (!"getUserVipType".equals(localObject))) {}
    }
    try
    {
      localObject = new JSONObject();
      int i = paramBundle.getInt("type");
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("type", i);
      ((JSONObject)localObject).put("data", localJSONObject);
      callJs(str, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException paramBundle) {}
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!WebIPCOperator.getInstance().isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a(), this.mRuntime.a().getString(2131559336), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      WebIPCOperator.getInstance().sendServiceIpcReqWithoutTimeout(paramBundle);
      return;
    }
    WebIPCOperator.getInstance().sendServiceIpcReq(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
 * JD-Core Version:    0.7.0.1
 */