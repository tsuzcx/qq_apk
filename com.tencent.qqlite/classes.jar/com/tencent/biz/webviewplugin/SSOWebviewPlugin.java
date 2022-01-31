package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import sf;

public class SSOWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "SSOWebviewPlugin";
  public static final String b = "sso";
  public int a;
  long jdField_a_of_type_Long = 0L;
  protected Activity a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public int b = 204800;
  
  public SSOWebviewPlugin()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      String str1;
      String str3;
      String str2;
      int i;
      try
      {
        String[] arrayOfString = Uri.parse(paramString2).getHost().split("\\.");
        paramString1 = new JSONObject(paramString1);
        str1 = paramString1.getString("data");
        str3 = paramString1.getString("cmd");
        str2 = paramString1.getString("callback");
        if (this.jdField_a_of_type_Long != 0L)
        {
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_Int * 1000)
          {
            paramString2 = new JSONObject();
            paramString1.put("cret", 1);
            callJs(str2, new String[] { paramString2.toString() });
          }
        }
        else
        {
          i = arrayOfString.length;
          paramString1 = "";
          i -= 1;
          if (i < 0) {
            break label256;
          }
          paramString2 = paramString1 + arrayOfString[i];
          paramString1 = paramString2;
          if (i == 0) {
            break label374;
          }
          paramString1 = paramString2 + "_";
          break label374;
        }
        if (str1.getBytes().length <= this.b) {
          continue;
        }
        paramString2 = new JSONObject();
        paramString1.put("cret", 2);
        callJs(str2, new String[] { paramString2.toString() });
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString1) {}
      QLog.d("SSOWebviewPlugin", 2, "send request error!");
      return;
      label256:
      paramString2 = new NewIntent(this.mRuntime.a().getApplicationContext(), ProtoServlet.class);
      paramString2.putExtra("cmd", "MQUpdateSvc_" + paramString1 + ".web." + str3);
      paramString1 = new WebSsoBody.WebSsoRequestBody();
      paramString1.type.set(0);
      paramString1.data.set(str1);
      paramString2.putExtra("data", paramString1.toByteArray());
      paramString2.setObserver(new sf(this, str2));
      this.mRuntime.a().startServlet(paramString2);
      return;
      label374:
      i -= 1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"sso".equals(paramString2)) {}
    while ((!"sendRequest".equals(paramString3)) || (paramVarArgs.length <= 0)) {
      return false;
    }
    a(paramVarArgs[0], this.mRuntime.a().getUrl());
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */