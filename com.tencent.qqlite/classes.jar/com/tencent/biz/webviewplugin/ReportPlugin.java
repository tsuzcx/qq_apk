package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLEncoder;
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
    try
    {
      paramBaseActivity = paramBaseActivity.app.a().a(paramString, 0, 10);
      if ((paramBaseActivity != null) && (paramBaseActivity.size() > 0))
      {
        paramString = new JSONArray();
        localJSONObject = new JSONObject();
        i = 0;
        if ((i < paramBaseActivity.size()) && (i < 10))
        {
          localObject = new JSONObject();
          MessageRecord localMessageRecord = (MessageRecord)paramBaseActivity.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            localMessageForPic.parse();
            ((JSONObject)localObject).put("content", localMessageForPic.msg.replace("&", URLEncoder.encode("&", "UTF-8")) + ",uuid:" + localMessageForPic.uuid);
          }
          for (;;)
          {
            ((JSONObject)localObject).put("contentType", "" + localMessageRecord.msgtype);
            ((JSONObject)localObject).put("time", "" + localMessageRecord.time);
            paramString.put(i, localObject);
            i += 1;
            break;
            if ((localMessageRecord instanceof MessageForText)) {
              ((JSONObject)localObject).put("content", localMessageRecord.msg.replace("&", URLEncoder.encode("&", "UTF-8")));
            }
          }
        }
      }
      else
      {
        return "0";
      }
    }
    catch (Exception paramBaseActivity) {}
    Object localObject = new StringBuilder().append("");
    if (paramBaseActivity.size() <= 10) {}
    for (int i = paramBaseActivity.size();; i = 10)
    {
      localJSONObject.put("msgnum", i);
      localJSONObject.put("contentlist", paramString);
      paramBaseActivity = localJSONObject.toString();
      return paramBaseActivity;
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject;
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          localObject = (MessageForPtt)paramMessageRecord;
          ((MessageForPtt)localObject).parse();
          localJSONObject2.put("content", paramMessageRecord.msg + ",urlAtServer:" + ((MessageForPtt)localObject).urlAtServer);
          localJSONObject2.put("contentType", "" + paramMessageRecord.msgtype);
          localJSONObject2.put("time", "" + paramMessageRecord.time);
          localJSONArray.put(0, localJSONObject2);
          localJSONObject1.put("msgnum", "1");
          localJSONObject1.put("contentlist", localJSONArray);
          return localJSONObject1.toString();
        }
        if ((paramMessageRecord instanceof MessageForPic))
        {
          localObject = (MessageForPic)paramMessageRecord;
          ((MessageForPic)localObject).parse();
          localJSONObject2.put("content", ((MessageForPic)localObject).msg + ",uuid:" + ((MessageForPic)localObject).uuid);
        }
        else
        {
          localJSONObject2.put("content", paramMessageRecord.msg);
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getReportMessage:" + paramMessageRecord.getMessage());
        }
        return "0";
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramBaseActivity, paramInt, paramString1, paramString2, paramString3, "0");
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport param null");
      }
      label27:
      return;
    }
    String str2 = "impeachuin=" + paramString3;
    if ((paramInt != 403) && (!TextUtils.isEmpty(paramString1))) {}
    for (String str1 = "groupuin=" + paramString1;; str1 = "groupuin=0")
    {
      paramString3 = (FriendManager)paramBaseActivity.app.getManager(8);
      if (paramString3 == null) {}
      for (boolean bool = false;; bool = paramString3.b(paramString2)) {
        switch (paramInt)
        {
        default: 
          localObject3 = "subapp=BusinessCard";
          if (!bool) {
            break label756;
          }
          paramString3 = "uin_source=friend";
          label157:
          localObject1 = "msglist=" + a(paramBaseActivity, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label763;
          }
          if (!QLog.isColorLevel()) {
            break label27;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
          return;
        }
      }
      Object localObject2 = "subapp=BusinessCard";
      if (bool) {}
      for (paramString3 = "uin_source=friend";; paramString3 = "uin_source=unfriend")
      {
        localObject1 = "msglist=" + a(paramBaseActivity, paramString2);
        if (!TextUtils.isEmpty(paramString2)) {
          break label286;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
        return;
      }
      label286:
      Object localObject3 = "eviluin=" + paramString2;
      paramString2 = (String)localObject1;
      Object localObject1 = paramString3;
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      for (;;)
      {
        localObject3 = new StringBuffer();
        ((StringBuffer)localObject3).append("appname=KQQ&jubaotype=uin&system=android");
        ((StringBuffer)localObject3).append("&" + (String)localObject2);
        ((StringBuffer)localObject3).append("&" + str1 + "&" + paramString2 + "&" + str2 + "&" + paramString3);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((StringBuffer)localObject3).append("&" + (String)localObject1);
        }
        if ((paramInt == 403) || (paramInt == 402))
        {
          ((StringBuffer)localObject3).append("&SourceID=").append(paramInt);
          ((StringBuffer)localObject3).append("&tinnyid=").append(paramString4);
          if (paramInt == 403) {
            ((StringBuffer)localObject3).append("&lid=").append(paramString1);
          }
        }
        try
        {
          paramString1 = new Intent(paramBaseActivity, QQBrowserActivity.class);
          paramString1.putExtra("BSafeReportPost", true);
          paramString1.putExtra("SafeReportData", ((StringBuffer)localObject3).toString().getBytes("utf-8"));
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
        localObject3 = "subapp=BusinessCard";
        if (bool) {}
        for (paramString3 = "uin_source=hot_group_friend";; paramString3 = "uin_source=hot_group_unfriend")
        {
          localObject1 = "msglist=" + a(paramBaseActivity, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label696;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "eviluinparm param null");
          return;
        }
        label696:
        paramString2 = "eviluin=" + paramString2;
        localObject2 = paramString3;
        paramString3 = (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject2 = "subapp=group";
        localObject1 = "";
        paramString3 = "msglist=0";
        paramString2 = "eviluin=0";
        continue;
        label756:
        paramString3 = "uin_source=unfriend";
        break label157;
        label763:
        paramString2 = "eviluin=" + paramString2;
        localObject2 = paramString3;
        paramString3 = (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      localCustomWebView.postUrl(paramString, paramArrayOfByte);
      localCustomWebView.requestFocus();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if ((paramInt == 21) && (this.jdField_a_of_type_Boolean))
    {
      a(paramString, this.jdField_a_of_type_ArrayOfByte);
      ((QQBrowserActivity)this.mRuntime.a()).i();
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    Intent localIntent = this.mRuntime.a().getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("BSafeReportPost", false);
    this.jdField_a_of_type_ArrayOfByte = localIntent.getExtras().getByteArray("SafeReportData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */