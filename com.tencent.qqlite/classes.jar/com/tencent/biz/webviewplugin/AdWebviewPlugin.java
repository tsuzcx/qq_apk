package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mp.SSOHttp.SSOHttpRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import ry;

public class AdWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "AdWebviewPlugin";
  public static final String b = "app";
  protected Activity a;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("header");
        String str = ((JSONObject)localObject).getString("body");
        localObject = ((JSONObject)localObject).getString("callback");
        SSOHttp.SSOHttpRequest localSSOHttpRequest = new SSOHttp.SSOHttpRequest();
        localSSOHttpRequest.header.set(paramString);
        localSSOHttpRequest.body.set(str);
        if (this.jdField_a_of_type_MqqAppNewIntent == null)
        {
          this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, ProtoServlet.class);
          this.jdField_a_of_type_MqqObserverBusinessObserver = new ry(this, (String)localObject);
          this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        }
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "QQMobileGdtSvr.GdtReport");
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localSSOHttpRequest.toByteArray());
        this.mRuntime.a().startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("AdWebviewPlugin", 2, "send request error!");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"app".equals(paramString2)) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (!"sendRequest".equals(paramString3)) {
            break;
          }
        } while (paramVarArgs.length <= 0);
        a(paramVarArgs[0]);
        return true;
        if (!"getAdData".equals(paramString3)) {
          break;
        }
      } while (paramVarArgs.length <= 0);
      paramJsBridgeListener = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).c();
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
        if (paramJsBridgeListener == null) {
          callJs(paramString1, new String[] { "null" });
        } else {
          callJs(paramString1, new String[] { paramJsBridgeListener });
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      if ("expandAd".equals(paramString3))
      {
        ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).k();
        return true;
      }
    } while (!"onAdLoad".equals(paramString3));
    ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).f();
    return true;
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
 * Qualified Name:     com.tencent.biz.webviewplugin.AdWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */