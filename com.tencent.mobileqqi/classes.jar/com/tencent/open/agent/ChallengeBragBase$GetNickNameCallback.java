package com.tencent.open.agent;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChallengeBragBase$GetNickNameCallback
  implements HttpCgiAsyncTask.Callback
{
  protected ChallengeBragBase$GetNickNameCallback(ChallengeBragBase paramChallengeBragBase) {}
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(this.a, paramIntent.getStringExtra("key_error_msg"), 0).show();
      LogUtility.e("qqBaseActivity", "onGetNickNameError{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    this.a.setResult(-1, paramIntent);
    this.a.finish();
  }
  
  public void a(Exception paramException)
  {
    this.a.g();
    LogUtility.c("qqBaseActivity", "GetNickNameCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      a(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", "网络连接超时!");
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", "未知错误!");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      this.a.g();
      int i = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i != 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_error_code", i);
        localIntent.putExtra("key_error_msg", str);
        localIntent.putExtra("key_response", paramJSONObject.toString());
        a(localIntent);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("data");
      if (paramJSONObject.length() == 0)
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", -5);
        paramJSONObject.putExtra("key_error_msg", "传入参数有误!");
        paramJSONObject.putExtra("key_error_detail", "获取用户昵称出错，请检查传入的openid是否正确");
        a(paramJSONObject);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      LogUtility.c("qqBaseActivity", "GetNickNameCallback exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", "服务器返回数据格式有误!");
      a(paramJSONObject);
      return;
      paramJSONObject = StringAddition.a(StringAddition.a(paramJSONObject.getJSONObject(0).getString("nick")), 12, true, true);
      if ("action_brag".equals(this.a.q))
      {
        this.a.a.setText(this.a.getString(2131560052, new Object[] { paramJSONObject }));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    if ("action_challenge".equals(this.a.q)) {
      this.a.a.setText(this.a.getString(2131560051, new Object[] { paramJSONObject }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase.GetNickNameCallback
 * JD-Core Version:    0.7.0.1
 */