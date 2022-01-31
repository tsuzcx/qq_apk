package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchWebviewHandler
  extends VasWebviewJsPlugin
{
  public static String TAG = "RedTouchWebviewHandler";
  
  public void getAppInfo(String paramString)
  {
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).getString("callback");
        try
        {
          localObject2 = ((JSONObject)localObject2).getString("path");
          localObject2 = new RedTouchManager(this.mRuntime.a()).a((String)localObject2);
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get() == -1)
          {
            localJSONObject.put("code", -3);
            localJSONObject.put("errorMessage", "appInfo not found");
            localObject1 = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getAppInfo:" + localJSONObject.toString());
              localObject1 = paramString;
            }
            callJs((String)localObject1, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          ((JSONObject)localObject1).put("appID", ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.get());
          ((JSONObject)localObject1).put("iNewFlag", ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
          JSONArray localJSONArray = new JSONArray();
          int i = 0;
          if (i < ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.size())
          {
            localJSONArray.put(((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.get(i));
            i += 1;
            continue;
          }
          ((JSONObject)localObject1).put("missions", localJSONArray);
          ((JSONObject)localObject1).put("type", ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.get());
          ((JSONObject)localObject1).put("buffer", ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get());
          ((JSONObject)localObject1).put("path", ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
          ((JSONObject)localObject1).put("appset", ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.get());
          ((JSONObject)localObject1).put("modify_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.get());
          ((JSONObject)localObject1).put("num", ((BusinessInfoCheckUpdate.AppInfo)localObject2).num.get());
          localJSONObject.put("data", localObject1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void getRedPointShowInfo(String paramString)
  {
    j = 2;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localRedTouchManager = new RedTouchManager(this.mRuntime.a());
          if (!((JSONObject)localObject).isNull("set"))
          {
            localObject = ((JSONObject)localObject).getString("set");
            try
            {
              i = Integer.parseInt((String)localObject);
              if ((i == 0) || (i == 1) || (i == 2)) {
                continue;
              }
              localJSONObject2.put("code", -3);
              localJSONObject2.put("errorMessage", "redPoint showInfo not found");
              callJs(paramString, new String[] { localJSONObject2.toString() });
              return;
            }
            catch (Exception localException1)
            {
              localJSONObject2.put("code", -3);
              localJSONObject2.put("errorMessage", "redPoint showInfo not found");
              callJs(paramString, new String[] { localJSONObject2.toString() });
              return;
            }
            localException2.printStackTrace();
          }
        }
        catch (Exception localException2) {}
      }
      catch (Exception localException3)
      {
        Object localObject;
        RedTouchManager localRedTouchManager;
        String str1;
        String str2;
        paramString = "callback";
        continue;
        int i = 0;
        j = -1;
        continue;
      }
      try
      {
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
        continue;
      }
      callJs(str1, new String[] { localJSONObject2.toString() });
      return;
      localObject = localRedTouchManager.a(Integer.parseInt((String)localObject));
      localJSONObject2.put("code", 0);
      if (((RedTouchInfo)localObject).i > 0)
      {
        i = 1;
        str1.put("hintType", j);
        str1.put("number", ((RedTouchInfo)localObject).i);
        str1.put("isShow", i);
        localJSONObject2.put("data", str1);
        str1 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject2.toString());
          str1 = paramString;
        }
      }
      else if (((RedTouchInfo)localObject).h > 0)
      {
        i = 1;
        j = 1;
      }
      else if (((RedTouchInfo)localObject).g > 0)
      {
        i = 1;
        j = 0;
      }
      else
      {
        if (((RedTouchInfo)localObject).j <= 0) {
          continue;
        }
        j = 3;
        i = 1;
        continue;
        if (!((JSONObject)localObject).isNull("path"))
        {
          localObject = localRedTouchManager.a(((JSONObject)localObject).getString("path"));
          if (localObject == null)
          {
            localJSONObject2.put("code", -1);
            localJSONObject2.put("errorMessage", "missing path");
            str1 = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject2.toString());
              str1 = paramString;
            }
          }
          else if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() == -1)
          {
            localJSONObject2.put("code", -3);
            localJSONObject2.put("errorMessage", "appInfo not found");
          }
          else
          {
            localJSONObject2.put("code", 0);
            str1.put("hintType", ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
            str1.put("number", ((BusinessInfoCheckUpdate.AppInfo)localObject).num.get());
            str1.put("isShow", ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get());
            localJSONObject2.put("data", str1);
          }
        }
        else
        {
          localJSONObject2.put("code", -1);
          localJSONObject2.put("errorMessage", "missing set and path");
          str1 = paramString;
        }
      }
    }
  }
  
  public void getServerTime(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getString("callback");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject1.put("time", NetConnInfoCenter.getServerTimeMillis());
          localJSONObject2.put("data", localJSONObject1);
          localJSONObject2.put("code", 0);
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception localException2)
        {
          break label77;
        }
        localException1 = localException1;
        paramString = "callback";
      }
      try
      {
        label77:
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return super.handleEvent(paramString, paramInt, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("redpoint"))) {
      return false;
    }
    paramJsBridgeListener = new ArrayList();
    while (i < paramVarArgs.length)
    {
      paramJsBridgeListener.add(paramVarArgs[i]);
      i += 1;
    }
    return call(paramString3, paramJsBridgeListener);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      Object localObject4 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject4).getString("callback");
      localObject1 = paramString;
      Object localObject3 = ((JSONObject)localObject4).getString("path");
      localObject1 = paramString;
      int i = ((JSONObject)localObject4).getInt("isWithRedPoint");
      localObject1 = paramString;
      localObject2 = (QQBrowserActivity)this.mRuntime.a();
      localObject1 = paramString;
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new RedTouchManager(this.mRuntime.a()).a((String)localObject3);
      localObject1 = paramString;
      localObject4 = new BusinessInfoCheckUpdate.ReportReqBody();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).uin.set(Long.parseLong(this.mRuntime.a().a()));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).clientver.set("3.5.0.660");
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).platid.set(109);
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).appid.set(RedTouchManager.a((String)localObject3));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).platver.set(Build.VERSION.SDK_INT + "");
      localObject1 = paramString;
      if ((localAppInfo.missions.has()) && (i == 1))
      {
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.ReportReqBody)localObject4).missionid.set(localAppInfo.missions.get());
      }
      localObject1 = paramString;
      localObject3 = new ToServiceMsg("mobileqq.service", this.mRuntime.a().a(), "RedTouchSvc.ClientReport");
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).putWupBuffer(((BusinessInfoCheckUpdate.ReportReqBody)localObject4).toByteArray());
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).extraData.putBoolean("req_pb_protocol_flag", true);
      localObject1 = paramString;
      long l = ((ToServiceMsg)localObject3).getWupBuffer().length;
      localObject1 = paramString;
      localObject4 = new byte[(int)l + 4];
      localObject1 = paramString;
      PkgTools.a((byte[])localObject4, 0, 4L + l);
      localObject1 = paramString;
      PkgTools.a((byte[])localObject4, 4, ((ToServiceMsg)localObject3).getWupBuffer(), (int)l);
      localObject1 = paramString;
      ((ToServiceMsg)localObject3).putWupBuffer((byte[])localObject4);
      localObject1 = paramString;
      localObject4 = new NewIntent(((QQBrowserActivity)localObject2).getApplication(), TempServlet.class);
      localObject1 = paramString;
      ((NewIntent)localObject4).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject3);
      localObject1 = paramString;
      ((QQBrowserActivity)localObject2).getAppRuntime().startServlet((NewIntent)localObject4);
      localObject1 = paramString;
      localJSONObject.put("code", 0);
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = paramString;
        QLog.i(TAG, 2, "reportRedTouch:" + localJSONObject.toString());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
          paramString = (String)localObject1;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          paramString = (String)localObject1;
        }
      }
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  public void setAppInfo(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getJSONObject("appInfo");
          RedTouchManager localRedTouchManager = new RedTouchManager(this.mRuntime.a());
          BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
          localAppInfo.uiAppId.set(((JSONObject)localObject).getInt("appID"));
          localAppInfo.iNewFlag.set(((JSONObject)localObject).getInt("iNewFlag"));
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("missions");
          int i = 0;
          if (i < localJSONArray.length())
          {
            localAppInfo.missions.add(localJSONArray.getString(i));
            i += 1;
            continue;
          }
          localAppInfo.type.set(((JSONObject)localObject).getInt("type"));
          localAppInfo.buffer.set(((JSONObject)localObject).getString("buffer"));
          localAppInfo.path.set(((JSONObject)localObject).getString("path"));
          localAppInfo.appset.set(((JSONObject)localObject).getInt("appset"));
          localAppInfo.modify_ts.set(((JSONObject)localObject).getInt("modify_ts"));
          localAppInfo.num.set(((JSONObject)localObject).getInt("num"));
          i = localRedTouchManager.a(localAppInfo);
          localJSONObject.put("code", i);
          if (i == -3)
          {
            localJSONObject.put("errorMessage", "appInfo not found");
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "setAppInfo:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          if (i != -4) {
            continue;
          }
          localJSONObject.put("errorMessage", "failed to set appInfo");
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */