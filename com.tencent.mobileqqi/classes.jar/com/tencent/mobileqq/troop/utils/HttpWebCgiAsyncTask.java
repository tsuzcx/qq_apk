package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.base.http.HttpAsyncTask;
import hbo;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpWebCgiAsyncTask
  extends HttpAsyncTask
{
  public static final int a = 0;
  public static final String a = "retcode";
  public static final String b = "result";
  public static final String c = "CONTEXT";
  public static final String d = "BUNDLE";
  public static final String e = "Cookie";
  public static final String f = "Referer";
  public Bundle a;
  protected Handler a;
  public HttpWebCgiAsyncTask.Callback a;
  public int b;
  
  public HttpWebCgiAsyncTask(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = paramCallback;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  protected JSONObject a(HashMap... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        localObject = new JSONObject(HttpUtil.a(paramVarArgs, this.h, this.i, (Bundle)localObject, localBundle));
        paramVarArgs = (HashMap[])localObject;
        if (((JSONObject)localObject).getInt("retcode") == 0) {
          paramVarArgs = ((JSONObject)localObject).getJSONObject("result");
        }
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs = null;
        continue;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs = null;
        continue;
      }
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (isCancelled()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new hbo(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask
 * JD-Core Version:    0.7.0.1
 */