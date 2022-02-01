package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import fzs;
import fzu;
import fzv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QQApiPlugin
  extends WebViewPlugin
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final String a = "QQApi";
  Context jdField_a_of_type_AndroidContentContext;
  public QQProgressDialog a;
  public WXShareHelper.WXShareListener a;
  public String b;
  public String c;
  
  public String a(String paramString)
  {
    String str = "";
    if ((this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity))
    {
      paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a(paramString);
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("gamecenter", 2, "<--getOpenidBatch result=" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public void a(String paramString)
  {
    Handler localHandler;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity)) {
      localHandler = ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a();
    }
    try
    {
      localHandler.sendMessage(localHandler.obtainMessage(0, Integer.parseInt(paramString, 10), 0));
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "launchAppWithTokens " + paramString3);
    }
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    Object localObject;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity)) {
      localObject = (AppInterface)((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    }
    for (;;)
    {
      int j;
      if (localObject == null)
      {
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).b;
        }
      }
      else
      {
        j = 268435456;
        try
        {
          int k = Integer.parseInt(paramString4);
          if ((0x4000000 & k) == 67108864) {
            j = 335544320;
          }
          int i = j;
          if ((0x20000000 & k) == 536870912) {
            i = j | 0x20000000;
          }
          j = i;
          if ((k & 0x400000) == 4194304) {
            j = i | 0x400000;
          }
        }
        catch (Exception paramString4)
        {
          for (;;)
          {
            j = 268435456;
          }
        }
        ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        localAppLaucherHelper.a((AppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, j);
        return;
      }
      localObject = null;
    }
  }
  
  public boolean a(String paramString)
  {
    return ((this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity)) && (((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).b(paramString));
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    JSONObject localJSONObject;
    Object localObject3;
    label309:
    label343:
    int i;
    long l;
    do
    {
      String str1;
      String str2;
      String str3;
      String str4;
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.b = null;
            try
            {
              localJSONObject = new JSONObject(paramString);
              localObject1 = this.mRuntime.a();
              localObject3 = localJSONObject.optString("share_type", "0");
              localObject2 = localJSONObject.getString("title");
              str1 = localJSONObject.getString("desc");
              str2 = localJSONObject.getString("share_url");
              paramString = localJSONObject.optString("image_url");
              str3 = localJSONObject.optString("shareElement");
              str4 = localJSONObject.optString("flash_url");
              this.b = localJSONObject.optString("callback");
              if (!"1".equals(localObject3)) {
                break label343;
              }
              if ((localObject1 instanceof QQBrowserActivity))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)localObject1).a().a();
                if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                }
              }
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("title", (String)localObject2);
              ((Bundle)localObject3).putString("desc", str1);
              ((Bundle)localObject3).putString("detail_url", str2);
              localObject2 = new ArrayList(1);
              ((ArrayList)localObject2).add(paramString);
              ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject2);
              ((Bundle)localObject3).putLong("req_share_id", 0L);
              if (!QZoneShareManager.a(this.mRuntime.a(), (Context)localObject1, (Bundle)localObject3, null)) {
                break label309;
              }
              if (!TextUtils.isEmpty(this.b))
              {
                callJs(this.b, new String[] { "true" });
                return;
              }
            }
            catch (JSONException paramString) {}
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQApi", 2, "shareMsg error: " + paramString.getMessage());
        return;
        QRUtils.a(1, 2131562037);
      } while (TextUtils.isEmpty(this.b));
      callJs(this.b, new String[] { "false" });
      return;
      if (("2".equals(localObject3)) || ("3".equals(localObject3)))
      {
        localObject1 = new HashMap(1);
        localObject2 = new fzs(this, (Map)localObject1, str3, (String)localObject2, str1, str2, (String)localObject3, str4);
        if (TextUtils.isEmpty(paramString))
        {
          ((Runnable)localObject2).run();
          return;
        }
        ThreadManager.a(new fzu(this, paramString, (Map)localObject1, (Runnable)localObject2));
        return;
      }
      localObject3 = new Intent();
      String str5 = localJSONObject.optString("toUin");
      i = localJSONObject.optInt("uinType", 0);
      ((Intent)localObject3).setAction("com.tencent.intent.QQI_FORWARD");
      if ((str5 != null) && (str5.length() >= 5))
      {
        ((Intent)localObject3).setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        ((Intent)localObject3).putExtra("toUin", str5);
        ((Intent)localObject3).putExtra("uinType", i);
      }
      ((Intent)localObject3).putExtra("pluginName", "web_share");
      ((Intent)localObject3).putExtra("title", (String)localObject2);
      ((Intent)localObject3).putExtra("desc", str1);
      ((Intent)localObject3).putExtra("detail_url", str2);
      ((Intent)localObject3).putExtra("forward_type", 1001);
      ((Intent)localObject3).putExtra("req_share_id", localJSONObject.optLong("appid", -1L));
      ((Intent)localObject3).putExtra("pkg_name", "com.tencent.mobileqqi");
      ((Intent)localObject3).putExtra("image_url_remote", paramString);
      if (!"audio".equals(str3)) {
        break;
      }
      i = 2;
      ((Intent)localObject3).putExtra("audio_url", str4);
      ((Intent)localObject3).putExtra("req_type", i);
      if (localJSONObject.has("report")) {
        ((Intent)localObject3).putExtra("report", localJSONObject.getString("report"));
      }
      ((Intent)localObject3).putExtra("openerProc", MobileQQ.getMobileQQ().getProcessNames());
      ((Intent)localObject3).putExtra("k_back", localJSONObject.optBoolean("back", false));
      l = localJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break label900;
      }
      paramString = this.mRuntime.a();
    } while (paramString == null);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      if (!(localObject1 instanceof QQBrowserActivity)) {
        break label873;
      }
    }
    label873:
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)localObject1).a().a();; this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject1, ((Activity)localObject1).getResources().getDimensionPixelSize(2131427376)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562663);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      ((Intent)localObject3).putExtra("struct_share_key_source_name", Long.toString(l));
      Share.a(paramString, this.jdField_a_of_type_AndroidContentContext, paramString.getAccount(), l, 3000L, new fzv(this, (Intent)localObject3));
      return;
      int j = localJSONObject.optInt("req_type", 1);
      i = j;
      if (j != 2) {
        break;
      }
      ((Intent)localObject3).putExtra("audio_url", localJSONObject.getString("audio_url"));
      i = j;
      break;
    }
    label900:
    if ((localObject1 instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)localObject1).a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    Object localObject1 = localJSONObject.optString("puin", null);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = localJSONObject.optString("oaUin");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = this.mRuntime.a().a(this.mRuntime.a().getAccount()).createEntityManager();
      localObject2 = (AccountDetail)((EntityManager)localObject1).a(AccountDetail.class, paramString);
      ((EntityManager)localObject1).a();
      if (localObject2 == null) {
        break label1269;
      }
    }
    label1248:
    label1269:
    for (Object localObject2 = ((AccountDetail)localObject2).name;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (localJSONObject.has("sourceName")) {
          localObject1 = localJSONObject.optString("sourceName");
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString });
      paramString = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString });
      ((Intent)localObject3).putExtra("struct_share_key_source_action", "plugin");
      ((Intent)localObject3).putExtra("struct_share_key_source_a_action_data", (String)localObject1);
      ((Intent)localObject3).putExtra("struct_share_key_source_i_action_data", paramString);
      ((Intent)localObject3).putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
      ((Intent)localObject3).putExtra("app_name", (String)localObject2);
      for (;;)
      {
        paramString = StructMsgFactory.a(((Intent)localObject3).getExtras());
        if (paramString != null) {
          break label1248;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "build struct msg fail");
        }
        if (TextUtils.isEmpty(this.b)) {
          break;
        }
        callJs(this.b, new String[] { "false" });
        return;
        ((Intent)localObject3).putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131560574));
      }
      ((Intent)localObject3).putExtra("stuctmsg_bytes", paramString.getBytes());
      startActivityForResult((Intent)localObject3, (byte)1);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!QQBrowserActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext))) {}
    do
    {
      return false;
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("title");
        String str1 = ((JSONObject)localObject).optString("desc");
        String str2 = ((JSONObject)localObject).optString("share_url");
        localObject = ((JSONObject)localObject).optString("image_url");
        return ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a(paramString, str1, str2, (String)localObject);
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "setShareInfo param error");
    return false;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.b = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        String str = paramString.optString("toUin");
        int i = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.b = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessNames());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareText error: " + paramString.getMessage());
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = null;
    if ("QQApi".equals(paramString2))
    {
      int i = paramVarArgs.length;
      if (("isAppInstalled".equals(paramString3)) && (i == 1)) {
        paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]));
      }
      for (;;)
      {
        paramJsBridgeListener.a(paramString1);
        return true;
        if (("checkAppInstalled".equals(paramString3)) && (i == 1))
        {
          paramString1 = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
        }
        else if (("checkAppInstalledBatch".equals(paramString3)) && (i == 1))
        {
          paramString1 = PackageUtil.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
        }
        else if (("isAppInstalledBatch".equals(paramString3)) && (i == 1))
        {
          paramString1 = PackageUtil.c(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
        }
        else if (("startAppWithPkgName".equals(paramString3)) && (i == 1))
        {
          paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], null));
        }
        else if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i == 2))
        {
          paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], paramVarArgs[1]));
        }
        else if (("getOpenidBatch".equals(paramString3)) && (i == 1))
        {
          paramString1 = a(paramVarArgs[0]);
        }
        else if (("launchAppWithTokens".equals(paramString3)) && (i == 4))
        {
          a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
        }
        else if (("getAppsVerionCodeBatch".equals(paramString3)) && (i == 1))
        {
          paramString1 = PackageUtil.d(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
        }
        else if (("setShareURL".equals(paramString3)) && (i == 1))
        {
          paramString1 = Boolean.valueOf(a(paramVarArgs[0]));
        }
        else if (("setShareInfo".equals(paramString3)) && (i == 1))
        {
          paramString1 = Boolean.valueOf(b(paramVarArgs[0]));
        }
        else if (("setToolHiddenFlags".equals(paramString3)) && (i == 1))
        {
          a(paramVarArgs[0]);
        }
        else if (("shareMsg".equals(paramString3)) && (i == 1))
        {
          b(paramVarArgs[0]);
        }
        else
        {
          if ((!"shareText".equals(paramString3)) || (i != 1)) {
            break;
          }
          c(paramVarArgs[0]);
        }
      }
      return false;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    String str;
    if ((paramByte == 1) && (!TextUtils.isEmpty(this.b)))
    {
      str = this.b;
      if (paramInt != -1) {
        break label51;
      }
    }
    label51:
    for (paramIntent = "true";; paramIntent = "false")
    {
      callJs(str, new String[] { paramIntent });
      return;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin
 * JD-Core Version:    0.7.0.1
 */