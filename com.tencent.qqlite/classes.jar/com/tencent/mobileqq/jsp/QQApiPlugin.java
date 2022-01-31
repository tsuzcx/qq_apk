package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
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
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import dwt;
import dwv;
import dwx;
import dwy;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class QQApiPlugin
  extends WebViewPlugin
{
  static final byte jdField_a_of_type_Byte = 1;
  public static final String a = "QQApi";
  static final String b = "title";
  static final String c = "desc";
  static final String d = "share_url";
  static final String e = "image_url";
  static final String f = "shareElement";
  static final String g = "flash_url";
  static final String h = "callback";
  static final String i = "keepShareUrl";
  static final String j = "share_type";
  static final String k = "toUin";
  static final String l = "uinType";
  static final String m = "appid";
  static final String n = "back";
  static final String o = "report";
  static final String p = "sourceName";
  Context jdField_a_of_type_AndroidContentContext;
  public QQProgressDialog a;
  public WXShareHelper.WXShareListener a;
  public String q;
  public String r;
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramJSONObject = this.mRuntime.a();
    int i1 = -1;
    if (!WXShareHelper.a().a()) {
      i1 = 2131363697;
    }
    while (i1 != -1)
    {
      QRUtils.a(0, i1);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && ((paramJSONObject instanceof QQBrowserActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)paramJSONObject).a().a();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
      if (!WXShareHelper.a().b()) {
        i1 = 2131363698;
      }
    }
    HashMap localHashMap = new HashMap(1);
    paramString1 = new dwv(this, localHashMap, paramString6, paramString2, paramString3, paramString4, paramString1, paramString7);
    if (TextUtils.isEmpty(paramString5))
    {
      paramString1.run();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      if (!(paramJSONObject instanceof QQBrowserActivity)) {
        break label222;
      }
    }
    label222:
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)paramJSONObject).a().a();; this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramJSONObject, paramJSONObject.getResources().getDimensionPixelSize(2131492887)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363758);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      ThreadManager.a(new dwx(this, paramString5, localHashMap, paramString1));
      return;
    }
  }
  
  private void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.mRuntime.a();
    Intent localIntent = new Intent("com.tencent.intent.QQLite_FORWARD");
    String str = paramJSONObject.optString("toUin");
    int i1 = paramJSONObject.optInt("uinType", 0);
    label192:
    long l1;
    if ((str != null) && (str.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
      localIntent.putExtra("toUin", str);
      localIntent.putExtra("uinType", i1);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString2);
      localIntent.putExtra("desc", paramString3);
      localIntent.putExtra("detail_url", paramString4);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.qqlite");
      localIntent.putExtra("image_url_remote", paramString5);
      if (!"audio".equals(paramString6)) {
        break label395;
      }
      i1 = 2;
      localIntent.putExtra("audio_url", paramString7);
      localIntent.putExtra("req_type", i1);
      if (paramJSONObject.has("report")) {
        localIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
      localIntent.putExtra("k_back", paramJSONObject.optBoolean("back", false));
      l1 = paramJSONObject.optLong("appid", 0L);
      if (l1 <= 0L) {
        break label459;
      }
      paramJSONObject = this.mRuntime.a();
      if (paramJSONObject != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          if (!(paramString1 instanceof QQBrowserActivity)) {
            break label435;
          }
        }
      }
    }
    label395:
    label435:
    for (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)paramString1).a().a();; this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramString1, paramString1.getResources().getDimensionPixelSize(2131492887)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363758);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      localIntent.putExtra("struct_share_key_source_name", Long.toString(l1));
      Share.a(paramJSONObject, this.jdField_a_of_type_AndroidContentContext, paramJSONObject.getAccount(), l1, 3000L, new dwy(this, localIntent));
      return;
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      break;
      int i2 = paramJSONObject.optInt("req_type", 1);
      i1 = i2;
      if (i2 != 2) {
        break label192;
      }
      localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
      i1 = i2;
      break label192;
    }
    label459:
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && ((paramString1 instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)paramString1).a().a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.mRuntime.a().a(this.mRuntime.a().getAccount()).createEntityManager();
        paramString3 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        if (paramString3 == null) {
          break label817;
        }
      }
      label796:
      label817:
      for (paramString3 = paramString3.name;; paramString3 = null)
      {
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          paramString2 = paramString3;
          if (paramJSONObject.has("sourceName")) {
            paramString2 = paramJSONObject.optString("sourceName");
          }
        }
        paramJSONObject = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramJSONObject = paramString1;
        }
        paramString2 = String.format("mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        localIntent.putExtra("struct_share_key_source_action", "plugin");
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString2);
        localIntent.putExtra("struct_share_key_source_i_action_data", paramString1);
        localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
        localIntent.putExtra("app_name", paramJSONObject);
        for (;;)
        {
          paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
          if (paramJSONObject != null) {
            break label796;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "build struct msg fail");
          }
          if (TextUtils.isEmpty(this.q)) {
            break;
          }
          callJs(this.q, new String[] { "false" });
          return;
          localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131362467));
        }
        localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
    }
  }
  
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
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appID");
      String str1 = ((JSONObject)localObject).optString("paramsStr");
      String str2 = ((JSONObject)localObject).optString("packageName");
      String str3 = ((JSONObject)localObject).optString("flags");
      String str4 = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("subappid");
      a(paramString, str1, str2, str3, str4, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("launchAppWithTokens", 2, "parse params error");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
      if (localObject == null)
      {
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        }
      }
      else
      {
        int i2 = 268435456;
        try
        {
          i3 = Integer.parseInt(paramString4);
          if ((0x4000000 & i3) == 67108864) {
            i2 = 335544320;
          }
          i1 = i2;
          if ((0x20000000 & i3) == 536870912) {
            i1 = i2 | 0x20000000;
          }
          i2 = i1;
          if ((i3 & 0x400000) == 4194304) {
            i2 = i1 | 0x400000;
          }
          i1 = i2;
        }
        catch (Exception paramString4)
        {
          int i1;
          for (;;)
          {
            int i3;
            String str;
            i1 = 268435456;
            continue;
            paramString2 = paramString4;
            if (QLog.isColorLevel())
            {
              QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
              paramString2 = paramString4;
            }
          }
          localAppLaucherHelper.a((AppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, i1);
          return;
        }
        ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        i3 = 0;
        str = "tencentwtlogin" + paramString1 + "://";
        i2 = i3;
        if ("wtlogin".equals(paramString5))
        {
          paramString4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
          paramString5 = new Intent("android.intent.action.VIEW");
          paramString5.setData(Uri.parse(str));
          i2 = i3;
          if (paramString4 != null)
          {
            i2 = i3;
            if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
              i2 = 1;
            }
          }
        }
        if (i2 != 0)
        {
          paramString4 = "";
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            paramString2 = this.mRuntime.a().getUrl();
            localAppLaucherHelper.a(str, this.jdField_a_of_type_AndroidContentContext, paramString2, (AppInterface)localObject, paramString1, paramString3, i1, paramString6);
            return;
          }
        }
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.q = null;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    for (;;)
    {
      Activity localActivity;
      try
      {
        paramString = new JSONObject(paramString);
        localActivity = this.mRuntime.a();
        str1 = paramString.optString("share_type", "0");
        str2 = paramString.getString("title");
        str3 = paramString.getString("desc");
        str4 = paramString.getString("share_url");
        str5 = paramString.optString("image_url");
        str6 = paramString.optString("shareElement");
        str7 = paramString.optString("flash_url");
        this.q = paramString.optString("callback");
        boolean bool = paramString.optBoolean("keepShareUrl", false);
        HashMap localHashMap = new HashMap();
        if ((!bool) && (str4 != null) && (str4.length() > 180)) {
          localHashMap.put("share_url", str4);
        }
        if ((str5 != null) && (str5.length() > 30) && (!"2".equals(str1)) && (!"3".equals(str1))) {
          localHashMap.put("image_url", str5);
        }
        if ((str7 != null) && (str7.length() > 30)) {
          localHashMap.put("flash_url", str7);
        }
        if (localHashMap.isEmpty()) {
          break label370;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          if (!(localActivity instanceof QQBrowserActivity)) {
            break label346;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQBrowserActivity)localActivity).a().a();
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363758);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        ThreadManager.a(new dwt(this, localHashMap, str4, str5, str7, str1, paramString, str2, str3, str6));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      return;
      label346:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131492887));
    }
    label370:
    if (("2".equals(str1)) || ("3".equals(str1)))
    {
      a(paramString, str1, str2, str3, str4, str5, str6, str7);
      return;
    }
    b(paramString, str1, str2, str3, str4, str5, str6, str7);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.q = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        localIntent.putExtra("isFromShare", true);
        String str = paramString.optString("toUin");
        int i1 = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i1);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.q = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareText error: " + paramString.getMessage());
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        if (!"0".equals(((JSONObject)localObject).optString("share_type", "0"))) {
          break;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        paramString.setAction("com.tencent.intent.QQLite_FORWARD");
        paramString.putExtra("pluginName", "web_share");
        paramString.putExtra("forward_type", -4);
        paramString.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
        paramString.putExtra("req_type", 3);
        paramString.putExtra("k_back", false);
        paramString.putExtra("forward_text", ((JSONObject)localObject).optString("text"));
        paramString.putExtra("struct_share_key_source_name", ((JSONObject)localObject).optString("srcName"));
        paramString.putExtra("struct_share_key_source_icon", ((JSONObject)localObject).optString("srcIconUrl"));
        paramString.putExtra("struct_share_key_source_url", ((JSONObject)localObject).optString("srcUrl"));
        localObject = StructMsgFactory.a(paramString.getExtras());
        if (localObject != null) {
          break label236;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "build struct msg fail");
        }
        startActivityForResult(paramString, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareHyperText error: " + paramString.getMessage());
      return;
      label236:
      paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if ("QQApi".equals(paramString2))
    {
      i1 = paramVarArgs.length;
      if ((!"isAppInstalled".equals(paramString3)) || (i1 != 1)) {
        break label67;
      }
      paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]));
    }
    for (;;)
    {
      paramJsBridgeListener.a(paramString1);
      bool1 = true;
      label67:
      do
      {
        do
        {
          return bool1;
          if (("checkAppInstalled".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break;
          }
          if (("checkAppInstalledBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break;
          }
          if (("isAppInstalledBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.c(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break;
          }
          if (("startAppWithPkgName".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], null));
            break;
          }
          if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i1 == 2))
          {
            paramString1 = Boolean.valueOf(PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], paramVarArgs[1]));
            break;
          }
          if (("getOpenidBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = a(paramVarArgs[0]);
            break;
          }
          if (("launchAppWithTokens".equals(paramString3)) && ((i1 == 1) || (i1 == 4)))
          {
            if (i1 == 1)
            {
              a(paramVarArgs[0]);
              paramString1 = localObject;
              break;
            }
            paramString1 = localObject;
            if (i1 != 4) {
              break;
            }
            a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = localObject;
            break;
          }
          if (("getAppsVerionCodeBatch".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = PackageUtil.d(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break;
          }
          if (("setShareURL".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(a(paramVarArgs[0]));
            break;
          }
          if (("setShareInfo".equals(paramString3)) && (i1 == 1))
          {
            paramString1 = Boolean.valueOf(b(paramVarArgs[0]));
            break;
          }
          if (("setToolHiddenFlags".equals(paramString3)) && (i1 == 1))
          {
            b(paramVarArgs[0]);
            paramString1 = localObject;
            break;
          }
          if (("shareMsg".equals(paramString3)) && (i1 == 1))
          {
            c(paramVarArgs[0]);
            paramString1 = localObject;
            break;
          }
          if (("shareText".equals(paramString3)) && (i1 == 1))
          {
            d(paramVarArgs[0]);
            paramString1 = localObject;
            break;
          }
          bool1 = bool2;
        } while (!"shareHypertext".equals(paramString3));
        bool1 = bool2;
      } while (i1 != 1);
      e(paramVarArgs[0]);
      paramString1 = localObject;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    String str;
    if ((paramByte == 1) && (!TextUtils.isEmpty(this.q)))
    {
      str = this.q;
      if (paramInt != -1) {
        break label52;
      }
    }
    label52:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin
 * JD-Core Version:    0.7.0.1
 */