package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportPlugin
  extends WebViewPlugin
{
  private static final String jdField_a_of_type_JavaLangString = ReportPlugin.class.getName();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  
  protected static String a(BaseActivity paramBaseActivity, String paramString)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      MessageRecord localMessageRecord;
      try
      {
        paramBaseActivity = paramBaseActivity.b.a().a(paramString, 0, 10);
        if ((paramBaseActivity != null) && (paramBaseActivity.size() > 0))
        {
          paramString = new JSONArray();
          localJSONObject = new JSONObject();
          i = 0;
          if ((i >= paramBaseActivity.size()) || (i >= 10)) {
            break;
          }
          localObject1 = new JSONObject();
          localMessageRecord = (MessageRecord)paramBaseActivity.get(i);
          Object localObject2;
          if ((localMessageRecord instanceof MessageForPtt))
          {
            localObject2 = (MessageForPtt)localMessageRecord;
            ((MessageForPtt)localObject2).parse();
            ((JSONObject)localObject1).put("content", localMessageRecord.msg + ",urlAtServer:" + ((MessageForPtt)localObject2).urlAtServer);
            ((JSONObject)localObject1).put("contentType", "" + localMessageRecord.msgtype);
            ((JSONObject)localObject1).put("time", "" + localMessageRecord.time);
            paramString.put(i, localObject1);
            i += 1;
            continue;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject2).parse();
            ((JSONObject)localObject1).put("content", ((MessageForPic)localObject2).msg + ",uuid:" + ((MessageForPic)localObject2).uuid);
            continue;
          }
        }
        else
        {
          return "0";
        }
      }
      catch (Exception paramBaseActivity) {}
      ((JSONObject)localObject1).put("content", localMessageRecord.msg);
    }
    Object localObject1 = new StringBuilder().append("");
    if (paramBaseActivity.size() <= 10) {}
    for (int i = paramBaseActivity.size();; i = 10)
    {
      localJSONObject.put("msgnum", i);
      localJSONObject.put("contentlist", paramString);
      paramBaseActivity = localJSONObject.toString();
      return paramBaseActivity;
    }
  }
  
  private void a()
  {
    String str1 = "en";
    switch (LocaleUtil.a(BaseApplicationImpl.getContext()))
    {
    }
    for (;;)
    {
      String str2 = "&lan=" + str1;
      try
      {
        str1 = new String(this.jdField_a_of_type_ArrayOfByte, "utf-8");
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str1);
        localStringBuffer.append(str2);
        try
        {
          this.jdField_a_of_type_ArrayOfByte = localStringBuffer.toString().getBytes("utf-8");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          Object localObject;
          QLog.d("ReportPlugin", 2, "safetyReport exception" + localUnsupportedEncodingException2.getMessage());
        }
        str1 = "en";
        continue;
        str1 = "ja";
        continue;
        str1 = "ko";
        continue;
        str1 = "de";
        continue;
        str1 = "fr";
        continue;
        str1 = "es";
        continue;
        str1 = "tw";
        continue;
        str1 = "cn";
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        for (;;)
        {
          QLog.d("ReportPlugin", 2, "safetyReport exception" + localUnsupportedEncodingException1.getMessage());
          localObject = null;
        }
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport param null");
      }
      label27:
      return;
    }
    String str3 = "impeachuin=" + paramString3;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (String str2 = "groupuin=" + paramString1;; str2 = "groupuin=0")
    {
      paramString1 = (FriendManager)paramBaseActivity.b.getManager(8);
      if (paramString1 == null) {}
      for (boolean bool = false;; bool = paramString1.b(paramString2)) {
        switch (paramInt)
        {
        default: 
          str1 = "subapp=BusinessCard";
          if (!bool) {
            break label667;
          }
          paramString1 = "uin_source=friend";
          label144:
          paramString3 = "msglist=" + a(paramBaseActivity, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label673;
          }
          if (!QLog.isColorLevel()) {
            break label27;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
          return;
        }
      }
      String str1 = "subapp=BusinessCard";
      if (bool) {}
      for (paramString1 = "uin_source=friend";; paramString1 = "uin_source=unfriend")
      {
        paramString3 = "msglist=" + a(paramBaseActivity, paramString2);
        if (!TextUtils.isEmpty(paramString2)) {
          break label270;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
        return;
      }
      label270:
      Object localObject = "eviluin=" + paramString2;
      paramString2 = paramString3;
      paramString3 = paramString1;
      paramString1 = (String)localObject;
      for (;;)
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("appname=KQQ&jubaotype=uin&system=android");
        ((StringBuffer)localObject).append("&" + str1);
        ((StringBuffer)localObject).append("&" + str2 + "&" + paramString1 + "&" + str3 + "&" + paramString2);
        if (!TextUtils.isEmpty(paramString3)) {
          ((StringBuffer)localObject).append("&" + paramString3);
        }
        try
        {
          paramString1 = new Intent(paramBaseActivity, QQBrowserActivity.class);
          paramString1.putExtra("BSafeReportPost", true);
          paramString1.putExtra("SafeReportData", ((StringBuffer)localObject).toString().getBytes("utf-8"));
          paramString1.putExtra("hide_more_button", true);
          paramString1.putExtra("ishiderefresh", true);
          paramString1.putExtra("ishidebackforward", true);
          paramBaseActivity.startActivity(paramString1.putExtra("url", "http://jubao.qq.com/cn/jubao"));
          return;
        }
        catch (Exception paramBaseActivity) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport exception" + paramBaseActivity.getMessage());
        return;
        str1 = "subapp=BusinessCard";
        if (bool) {}
        for (paramString1 = "uin_source=hot_group_friend";; paramString1 = "uin_source=hot_group_unfriend")
        {
          paramString3 = "msglist=" + a(paramBaseActivity, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label614;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
          return;
        }
        label614:
        localObject = "eviluin=" + paramString2;
        paramString2 = paramString3;
        paramString3 = paramString1;
        paramString1 = (String)localObject;
        continue;
        str1 = "subapp=group";
        paramString3 = "";
        paramString2 = "msglist=0";
        paramString1 = "eviluin=0";
        continue;
        label667:
        paramString1 = "uin_source=unfriend";
        break label144;
        label673:
        localObject = "eviluin=" + paramString2;
        paramString2 = paramString3;
        paramString3 = paramString1;
        paramString1 = (String)localObject;
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    WebView localWebView = this.mRuntime.a();
    if (localWebView == null) {
      return;
    }
    try
    {
      localWebView.postUrl(paramString, paramArrayOfByte);
      localWebView.requestFocus();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if ((paramInt == WebViewPlugin.EVENT_BEFORE_LOAD) && (this.jdField_a_of_type_Boolean))
    {
      a(paramString, this.jdField_a_of_type_ArrayOfByte);
      ((QQBrowserActivity)this.mRuntime.a()).h();
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    Intent localIntent = this.mRuntime.a().getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("BSafeReportPost", false);
    this.jdField_a_of_type_ArrayOfByte = localIntent.getExtras().getByteArray("SafeReportData");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */