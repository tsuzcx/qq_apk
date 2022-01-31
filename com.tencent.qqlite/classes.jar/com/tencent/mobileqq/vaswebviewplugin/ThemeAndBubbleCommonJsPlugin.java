package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeAndBubbleCommonJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "common";
  private static final int SAVEIMG = 1;
  public static final String TAG = "CommonJsHandler";
  public Handler handler = new ThemeAndBubbleCommonJsPlugin.6(this);
  String saveCallbackId;
  
  public void closePage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      this.mRuntime.a().finish();
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void getNetwork(JSONObject paramJSONObject, String paramString)
  {
    int i = NetworkUtil.a(this.mRuntime.a());
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("status", i);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("message", "ok");
      localJSONObject.put("data", paramJSONObject);
      super.callJs(paramString + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramVarArgs = null;
    if (QLog.isColorLevel()) {
      QLog.d("CommonJsHandler", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"common".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString1 = paramString1.substring(i + 1);
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString1, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CommonJsHandler", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CommonJsHandler", 2, "Failed to parse json str,json=" + null);
          }
          paramJsBridgeListener = null;
        }
        paramString1 = paramVarArgs;
        try
        {
          if (paramJsBridgeListener.has("callback")) {
            paramString1 = paramJsBridgeListener.getString("callback");
          }
          if (paramString1 == null) {
            return false;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            paramString1 = paramVarArgs;
            if (QLog.isColorLevel())
            {
              QLog.i("CommonJsHandler", 2, "Failed to parse callbackid,json=" + paramJsBridgeListener);
              paramString1 = paramVarArgs;
            }
          }
          if ("getNetwork".equals(paramString3)) {
            getNetwork(paramJsBridgeListener, paramString1);
          }
          for (;;)
          {
            return true;
            if ("showMsgBox".equals(paramString3))
            {
              showMsgBox(paramJsBridgeListener, paramString1);
            }
            else if ("closePage".equals(paramString3))
            {
              closePage(paramJsBridgeListener, paramString1);
            }
            else if ("openPage".equals(paramString3))
            {
              openPage(paramJsBridgeListener, paramString1);
            }
            else if ("openWebView".equals(paramString3))
            {
              openWebView(paramJsBridgeListener, paramString1);
            }
            else
            {
              if (!"saveImage".equals(paramString3)) {
                break;
              }
              saveImage(paramJsBridgeListener, paramString1);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("CommonJsHandler", 2, "NOT support method " + paramString3 + " yet!!");
          }
        }
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "common");
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = paramJSONObject.getString("pageUrl");
      paramJSONObject = paramJSONObject.getString("pageTitle");
      if (QLog.isColorLevel()) {
        QLog.i("CommonJsHandler", 2, "CommonJsHandler openWebView pageUrl=" + str + ",pageTitle=" + paramJSONObject);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("pageTitle", paramJSONObject);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.a(this.mRuntime.a(), str, this.mRuntime.a().getIntent().getIntExtra("business", 0), localIntent, false, -1);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void openWebView(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str1 = paramJSONObject.getString("pageUrl");
      String str2 = paramJSONObject.getString("pageTitle");
      paramJSONObject = paramJSONObject.getString("pageType");
      if (QLog.isColorLevel()) {
        QLog.i("CommonJsHandler", 2, "CommonJsHandler openWebView pageUrl=" + str1 + ",pageTitle=" + str2 + ",pageType=" + paramJSONObject);
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("pageUrl", str1);
      paramJSONObject.putExtra("pageTitle", str2);
      paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramJSONObject.setClass(this.mRuntime.a(), QQBrowserActivity.class);
      this.mRuntime.a().startActivity(paramJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    catch (ActivityNotFoundException paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("url");
      this.saveCallbackId = paramString;
      paramString = new StringBuilder();
      paramString.append(paramJSONObject);
      paramString.append("?client=androidQQ");
      paramString.append("&version=3.3.0.544");
      paramString.append("&system=" + Build.VERSION.RELEASE);
      paramString.append("&device=" + Build.DEVICE);
      paramString.append("&uin=" + ((AppActivity)this.mRuntime.a()).getAppRuntime().getAccount());
      paramString.append("&sid=" + ((AppActivity)this.mRuntime.a()).getAppRuntime().getSid());
      paramJSONObject = EmosmUtils.insertMtype("VIP_xingying", paramString.toString());
      if (QLog.isColorLevel()) {
        QLog.i("CommonJsHandler", 2, "CommonJsHandler saveImage imageUrl=" + paramJSONObject);
      }
      paramString = System.currentTimeMillis() + ".jpg";
      ThreadManager.a(new ThemeAndBubbleCommonJsPlugin.5(this, paramJSONObject, new File(AppConstants.au, paramString)));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str1 = paramJSONObject.getString("prompt");
      String str2 = paramJSONObject.getString("title");
      Object localObject = paramJSONObject.getString("button");
      paramJSONObject = ((String)localObject).split("\t");
      if (QLog.isColorLevel()) {
        QLog.i("CommonJsHandler", 2, "CommonJsHandler showMsgBox prompt=" + str1 + ",title=" + str2 + ",button=" + (String)localObject);
      }
      if (paramJSONObject.length >= 1)
      {
        localObject = DialogUtil.a(this.mRuntime.a(), 230);
        ((QQCustomDialogThreeBtns)localObject).a(str2);
        ((QQCustomDialogThreeBtns)localObject).b(str1);
        ((QQCustomDialogThreeBtns)localObject).a(paramJSONObject[0], new ThemeAndBubbleCommonJsPlugin.1(this, paramString));
        if (paramJSONObject.length >= 2) {
          ((QQCustomDialogThreeBtns)localObject).b(paramJSONObject[1], new ThemeAndBubbleCommonJsPlugin.2(this, paramString));
        }
        if (paramJSONObject.length >= 3) {
          ((QQCustomDialogThreeBtns)localObject).c(paramJSONObject[2], new ThemeAndBubbleCommonJsPlugin.3(this, paramString));
        }
        ((QQCustomDialogThreeBtns)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialogThreeBtns)localObject).setOnKeyListener(new ThemeAndBubbleCommonJsPlugin.4(this, (QQCustomDialogThreeBtns)localObject, paramString));
        ((QQCustomDialogThreeBtns)localObject).show();
        return;
      }
      super.callJsOnError(paramString, "Button no found - " + (String)localObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */