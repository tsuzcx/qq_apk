package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.AppUtil;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class AppUpdate$GetUpdateAppCallback
  implements HttpCgiAsyncTask.Callback
{
  protected Context a;
  protected final WebView a;
  protected final String a;
  protected boolean a;
  protected final String b;
  protected final String c;
  
  public AppUpdate$GetUpdateAppCallback(Context paramContext, WebView paramWebView, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.b = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.c = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(Exception paramException)
  {
    LogUtility.c("AppUpdate", "AppUpdate onException >>> " + paramException.toString());
    if ((!this.jdField_a_of_type_Boolean) && (AppUtil.a(this.jdField_a_of_type_AndroidContentContext))) {
      AppReport.b(this.jdField_a_of_type_AndroidContentContext);
    }
    if (TextUtils.isEmpty(this.b)) {}
    for (paramException = "javascript:QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});void(0);";; paramException = "javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"" + "\"});void(0);") {
      try
      {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramException);
        return;
      }
      catch (Exception paramException) {}
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    LogUtility.c("AppUpdate", "AppUpdate onResult >>> " + localJSONObject.toString());
    paramJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramJSONObject.put("guid", this.c);
        paramJSONObject.put("content", localJSONObject.toString());
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject = "javascript:QzoneApp.fire('httpSuccess'," + paramJSONObject.toString() + ");void(0);";
          paramJSONObject = (JSONObject)localObject;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramJSONObject = (JSONObject)localObject;
            if (AppUtil.a(this.jdField_a_of_type_AndroidContentContext))
            {
              if (localJSONObject.optInt("code", -1) != 0) {
                continue;
              }
              AppReport.a(this.jdField_a_of_type_AndroidContentContext);
              paramJSONObject = (JSONObject)localObject;
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject;
        if (TextUtils.isEmpty(this.b))
        {
          paramJSONObject = "javascript:QzoneApp.fire('httpError',{\"guid\":\"" + this.c + "\"});void(0);";
          continue;
        }
        paramJSONObject = "javascript:" + this.b + "({\"guid\":\"" + this.c + "\",\"err\":\"json format error\"});void(0);";
        continue;
      }
      try
      {
        localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView;
        if (localObject == null) {}
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramJSONObject);
        return;
      }
      catch (Exception paramJSONObject) {}
      localObject = "javascript:" + this.jdField_a_of_type_JavaLangString + "(" + paramJSONObject.toString() + ");void(0);";
      continue;
      AppReport.b(this.jdField_a_of_type_AndroidContentContext);
      paramJSONObject = (JSONObject)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppUpdate.GetUpdateAppCallback
 * JD-Core Version:    0.7.0.1
 */