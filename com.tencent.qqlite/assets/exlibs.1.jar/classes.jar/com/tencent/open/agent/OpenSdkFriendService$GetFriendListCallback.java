package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.settings.OpensdkPreference;
import fbs;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$GetFriendListCallback
  implements HttpCgiAsyncTask.Callback
{
  protected OpenSdkFriendService.GetFriendInfoListener a;
  
  public OpenSdkFriendService$GetFriendListCallback(OpenSdkFriendService paramOpenSdkFriendService, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener = null;
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener = paramGetFriendInfoListener;
  }
  
  public void a(Exception paramException)
  {
    LogUtility.c("OpenSdkFriendService", "GetFriendListCallback exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener != null) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener.a(localIntent);
      }
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
      else if ((paramException instanceof JSONException))
      {
        localIntent.putExtra("key_error_code", -4);
        localIntent.putExtra("key_error_msg", "服务器返回数据格式有误!");
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
    FriendResponseInfo localFriendResponseInfo = new FriendResponseInfo();
    for (;;)
    {
      String str;
      try
      {
        localFriendResponseInfo.d = paramJSONObject.getInt("ret");
        localFriendResponseInfo.jdField_a_of_type_JavaLangString = paramJSONObject.getString("msg");
        if (localFriendResponseInfo.d != 0) {
          break label468;
        }
        if (paramJSONObject.has("conc_max")) {
          localFriendResponseInfo.g = paramJSONObject.getInt("conc_max");
        }
        if ((paramJSONObject.has("inv_max")) && (paramJSONObject.has("inv_count")))
        {
          localFriendResponseInfo.e = paramJSONObject.getInt("inv_max");
          localFriendResponseInfo.f = paramJSONObject.getInt("inv_count");
        }
        if ((paramJSONObject.has("fgmax")) && (paramJSONObject.has("fgcur")))
        {
          localFriendResponseInfo.e = paramJSONObject.getInt("fgmax");
          localFriendResponseInfo.f = paramJSONObject.getInt("fgcur");
        }
        LogUtility.c("OpenSdkFriendService", "-->result = " + paramJSONObject);
        localFriendResponseInfo.h = paramJSONObject.optInt("app_rid", -1);
        localFriendResponseInfo.i = paramJSONObject.optInt("app_tid", -1);
        if ("action_invite".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.i))
        {
          if (!paramJSONObject.has("md5str")) {
            break label536;
          }
          str = paramJSONObject.getString("md5str");
          if (!OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").getString(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.g, "").equals(str))
          {
            paramJSONObject = (ArrayList)FriendGroup.c(paramJSONObject);
            localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = paramJSONObject;
            ThreadManager.b(new fbs(this, paramJSONObject, str));
            if (this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener == null) {
              break label535;
            }
            this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener.a(localFriendResponseInfo);
            return;
          }
          localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a();
          if (localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a.putString("md5str", "0");
          this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a("0");
          new HttpCgiAsyncTask(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.h, "GET", new GetFriendListCallback(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService, this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener)).a(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.a);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      if (("action_gift".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.i)) || ("action_ask".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.i)) || ("action_voice".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.i)) || ("action_reactive".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService.i)))
      {
        localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)FriendGroup.b(paramJSONObject));
      }
      else
      {
        localFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)FriendGroup.a(paramJSONObject));
        continue;
        label468:
        localFriendResponseInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("key_error_code", localFriendResponseInfo.d);
        paramJSONObject.putExtra("key_error_msg", localFriendResponseInfo.jdField_a_of_type_JavaLangString);
        paramJSONObject.putExtra("key_error_detail", localFriendResponseInfo.jdField_a_of_type_OrgJsonJSONObject.toString());
        if (this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener != null) {
          this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendInfoListener.a(paramJSONObject);
        }
        label535:
        return;
        label536:
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback
 * JD-Core Version:    0.7.0.1
 */