package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasCommonJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String TAG = "VasCommonJsPlugin";
  private VasCommonJsPlugin.JsDebugDialog deBugDialog;
  private List logInfo = Collections.synchronizedList(new ArrayList());
  private boolean logShowTag = true;
  private boolean logStop = false;
  protected String mCallback;
  protected VasCommonJsPlugin.ChooseFriendReceiver mChoFriReceiver;
  
  private void chooseFriends(String paramString)
  {
    Object localObject1;
    if (this.mRuntime != null) {
      localObject1 = this.mRuntime.a();
    }
    for (;;)
    {
      if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
      {
        doChooseFriendResult(null, null, null);
        return;
      }
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).optString("title", "选择我的好友");
        int i = ((JSONObject)localObject2).optInt("type", 0);
        this.mCallback = ((JSONObject)localObject2).optString("callback");
        boolean bool1;
        if ((i & 0x1) == 0)
        {
          bool1 = false;
          if ((i & 0x2) != 0) {
            break label234;
          }
        }
        label234:
        for (boolean bool2 = false;; bool2 = true)
        {
          if (this.mChoFriReceiver == null) {
            this.mChoFriReceiver = new VasCommonJsPlugin.ChooseFriendReceiver(this, new Handler());
          }
          Parcel localParcel = Parcel.obtain();
          this.mChoFriReceiver.writeToParcel(localParcel, 0);
          localParcel.setDataPosition(0);
          localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
          localParcel.recycle();
          localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
          ((Intent)localObject1).putExtra("forward_type", 15);
          ((Intent)localObject1).putExtra("choose_friend_title", paramString);
          ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
          ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
          ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
          super.startActivityForResult((Intent)localObject1, (byte)0);
          return;
          bool1 = true;
          break;
        }
        localObject1 = null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        doChooseFriendResult(null, null, null);
        return;
      }
    }
  }
  
  public static void debug(String paramString, WebView paramWebView)
  {
    try
    {
      paramString = URLEncoder.encode("{\"msg\":\"nativeinfo==" + paramString + "\"}", "utf-8");
      paramString = "location.href=\"jsbridge://qw_debug/log?p=" + paramString + "\"";
      Looper localLooper1 = Looper.myLooper();
      Looper localLooper2 = Looper.getMainLooper();
      if (localLooper1 == localLooper2) {
        try
        {
          paramWebView.loadUrl("javascript:" + paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      paramWebView.post(new VasCommonJsPlugin.5(paramWebView, paramString));
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  protected void doChooseFriendResult(List paramList1, List paramList2, List paramList3)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
        {
          int i = 0;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
          {
            String str1 = "";
            String str2 = "";
            if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
              str1 = (String)paramList1.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
              str2 = (String)paramList2.get(i);
            }
            if (TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              break label251;
            }
            str3 = (String)paramList3.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", str1);
            localJSONObject2.put("phone", str2);
            localJSONObject2.put("name", str3);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        doCallback(this.mCallback, localJSONObject1.toString());
        return;
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      label251:
      String str3 = "";
    }
  }
  
  public void getPerformance(JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickStart", this.startOpenPageTime);
      localJSONObject.put("pageStart", this.onPageStartedTime);
      localJSONObject.put("pageFinish", this.onPageFinishedTime);
      paramJsBridgeListener.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      paramJsBridgeListener.a("JSONException:" + localJSONException.getMessage());
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      paramJsBridgeListener.a("Exception:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.startsWith("qw_debug")) && (!paramString2.startsWith("qw_data")))) {
      bool1 = false;
    }
    int i;
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          if (TextUtils.isEmpty(paramString3))
          {
            paramJsBridgeListener.a("method empty");
            return true;
          }
          try
          {
            if ("log".equals(paramString3))
            {
              bool1 = bool2;
              if (this.logStop) {
                continue;
              }
              bool1 = bool2;
              if (!this.logShowTag) {
                continue;
              }
              paramString1 = new JSONObject(paramVarArgs[0]);
              this.logInfo.add(paramString1.getString("msg"));
              bool1 = bool2;
              if (this.deBugDialog == null) {
                continue;
              }
              bool1 = bool2;
              if (!this.deBugDialog.isShowing()) {
                continue;
              }
              this.deBugDialog.log(this.logInfo);
              return true;
            }
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
            return true;
          }
        }
        if ("show".equals(paramString3))
        {
          if (this.logStop)
          {
            paramJsBridgeListener.a("erro:please start log first");
            return true;
          }
          if (this.deBugDialog == null) {
            this.deBugDialog = new VasCommonJsPlugin.JsDebugDialog(this, this.mRuntime.a());
          }
          if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {}
          for (this.logShowTag = true;; this.logShowTag = false)
          {
            this.deBugDialog.show();
            this.deBugDialog.log(this.logInfo);
            return true;
          }
        }
        if ("hide".equals(paramString3))
        {
          if (this.deBugDialog != null) {
            this.deBugDialog.dismiss();
          }
          if (new JSONObject(paramVarArgs[0]).getBoolean("flag"))
          {
            this.logShowTag = true;
            return true;
          }
          this.logShowTag = false;
          return true;
        }
        if ("start".equals(paramString3))
        {
          this.logStop = false;
          return true;
        }
        if (!"stop".equals(paramString3)) {
          break;
        }
        this.logStop = true;
        this.logInfo.clear();
        bool1 = bool2;
      } while (this.deBugDialog == null);
      this.deBugDialog.log(this.logInfo);
      return true;
      if ("getPerformance".equals(paramString3))
      {
        getPerformance(paramJsBridgeListener);
        return true;
      }
      if ("getVipType".equals(paramString3))
      {
        i = paramString1.indexOf("=");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          throw new Exception("url illegal");
        }
        paramString1 = paramString1.substring(i + 1);
        if (paramString1 == null) {
          throw new Exception("json para illegal");
        }
        paramString1 = new JSONObject(URLDecoder.decode(paramString1, "UTF-8"));
        getVipType(paramString1, paramString1.getString("callback"));
        return true;
      }
      if (!"startIpcService".equals(paramString3)) {
        break;
      }
      bool1 = bool2;
    } while (WebIPCOperator.getInstance().isServiceClientBinded());
    WebIPCOperator.getInstance().getClient().doBindService(this.mRuntime.a().getApplicationContext());
    return true;
    if ("stopIpcService".equals(paramString3))
    {
      WebIPCOperator.getInstance().getClient().doUnbindService(this.mRuntime.a().getApplicationContext());
      return true;
    }
    if ("isIpcStarted".equals(paramString3))
    {
      paramString1 = new JSONObject();
      paramString1.put("isIpcStarted", WebIPCOperator.getInstance().isServiceClientBinded());
      paramJsBridgeListener.a(paramString1);
      return true;
    }
    if ("getFriendInfo".equals(paramString3))
    {
      if (paramVarArgs.length <= 0)
      {
        chooseFriends(null);
        return true;
      }
      chooseFriends(paramVarArgs[0]);
      return true;
    }
    if ("getDomainIpList".equals(paramString3))
    {
      i = paramString1.indexOf("=");
      if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
        throw new Exception("url illegal");
      }
      paramString1 = paramString1.substring(i + 1);
      if (paramString1 == null) {
        throw new Exception("json para illegal");
      }
      paramString1 = new JSONObject(URLDecoder.decode(paramString1, "UTF-8"));
      super.getDomainIpList(paramString1, paramString1.getString("callback"));
      return true;
    }
    paramJsBridgeListener.a("no such method");
    return true;
  }
  
  public void showMsgBox(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      String str1 = paramJSONObject.getString("prompt");
      String str2 = paramJSONObject.getString("title");
      Object localObject = paramJSONObject.getString("button");
      paramJSONObject = ((String)localObject).split("\t");
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "CommonJsHandler showMsgBox prompt=" + str1 + ",title=" + str2 + ",button=" + (String)localObject);
      }
      if (paramJSONObject.length >= 1)
      {
        localObject = DialogUtil.a(this.mRuntime.a(), 230);
        ((QQCustomDialogThreeBtns)localObject).a(str2);
        ((QQCustomDialogThreeBtns)localObject).b(str1);
        ((QQCustomDialogThreeBtns)localObject).a(paramJSONObject[0], new VasCommonJsPlugin.1(this, paramJsBridgeListener));
        if (paramJSONObject.length >= 2) {
          ((QQCustomDialogThreeBtns)localObject).b(paramJSONObject[1], new VasCommonJsPlugin.2(this, paramJsBridgeListener));
        }
        if (paramJSONObject.length >= 3) {
          ((QQCustomDialogThreeBtns)localObject).c(paramJSONObject[2], new VasCommonJsPlugin.3(this, paramJsBridgeListener));
        }
        ((QQCustomDialogThreeBtns)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialogThreeBtns)localObject).setOnKeyListener(new VasCommonJsPlugin.4(this, (QQCustomDialogThreeBtns)localObject, paramJsBridgeListener));
        ((QQCustomDialogThreeBtns)localObject).show();
        return;
      }
      paramJsBridgeListener.a("not find buttons" + (String)localObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJsBridgeListener.a("JSONException params error:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJsBridgeListener.a("Exception:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */