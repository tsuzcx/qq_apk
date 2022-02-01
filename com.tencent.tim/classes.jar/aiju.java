import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.jsp.QQApiPlugin.1;
import com.tencent.mobileqq.jsp.QQApiPlugin.2;
import com.tencent.mobileqq.jsp.QQApiPlugin.3;
import com.tencent.mobileqq.jsp.QQApiPlugin.4;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class aiju
  extends WebViewPlugin
{
  public String Qt;
  ardm.c jdField_a_of_type_Ardm$c = null;
  ardm.i jdField_a_of_type_Ardm$i = null;
  ardm.l jdField_a_of_type_Ardm$l = null;
  ardm.o jdField_a_of_type_Ardm$o = null;
  public WxShareHelperFromReadInjoy.a a;
  public WXShareHelper.a a;
  ardm.k b = null;
  String bOl;
  String bxh;
  public skj c = null;
  public arhz m;
  public Context mContext;
  
  public aiju()
  {
    this.mPluginNameSpace = "QQApi";
  }
  
  public void LA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.bxh = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.mContext, ForwardRecentActivity.class);
        localIntent.putExtra("isFromShare", true);
        String str = paramString.optString("toUin");
        int i = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.mContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.bxh = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareText error: " + paramString.getMessage());
  }
  
  public void LB(String paramString)
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
        paramString = new Intent(this.mContext, ForwardRecentActivity.class);
        paramString.putExtra("pluginName", "web_share");
        paramString.putExtra("forward_type", -4);
        paramString.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        paramString.putExtra("req_type", 3);
        paramString.putExtra("k_back", false);
        paramString.putExtra("key_flag_from_plugin", true);
        paramString.putExtra("forward_text", ((JSONObject)localObject).optString("text"));
        paramString.putExtra("struct_share_key_source_name", ((JSONObject)localObject).optString("srcName"));
        paramString.putExtra("struct_share_key_source_icon", ((JSONObject)localObject).optString("srcIconUrl"));
        paramString.putExtra("struct_share_key_source_url", ((JSONObject)localObject).optString("srcUrl"));
        localObject = anre.a(paramString.getExtras());
        if (localObject != null) {
          break label223;
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
      label223:
      paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    }
  }
  
  public void LC(String paramString)
  {
    try
    {
      this.bxh = null;
      paramString = new JSONObject(paramString);
      Intent localIntent = new Intent();
      String str = paramString.optString("toUin");
      if ((str == null) || (str.length() < 5))
      {
        if (!TextUtils.isEmpty(this.bxh)) {
          callJs(this.bxh, new String[] { "{\"result\":0}" });
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "toUin invalide: " + str);
        }
      }
      else
      {
        this.bxh = paramString.optString("callback");
        localIntent.setClass(this.mContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", str);
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("forward_type", 30);
        localIntent.putExtra("k_back", true);
        startActivityForResult(localIntent, (byte)2);
        return;
      }
    }
    catch (JSONException paramString)
    {
      callJs(this.bxh, new String[] { "{\"result\":0}" });
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      }
    }
  }
  
  public void Lx(String paramString)
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
      k(paramString, str1, str2, str3, str4, (String)localObject);
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
  
  public void Ly(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      paramString = (arbi)super.getBrowserComponent(32);
      if (paramString != null)
      {
        Message localMessage = paramString.mJsHandler.obtainMessage(0, i, 0);
        paramString.mJsHandler.sendMessage(localMessage);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void Lz(String paramString)
  {
    this.bOl = null;
    for (;;)
    {
      Intent localIntent;
      try
      {
        if (this.b != null)
        {
          this.m = this.b.b().b();
          if ((this.m != null) && (this.m.isShowing())) {
            this.m.dismiss();
          }
        }
        localIntent = new Intent();
        Object localObject = new JSONObject(paramString);
        this.bOl = ((JSONObject)localObject).optString("callback");
        paramString = ((JSONObject)localObject).optString("appName");
        if (!jml.a().da(paramString))
        {
          if (TextUtils.isEmpty(this.bOl)) {
            break;
          }
          callJs(this.bOl, new String[] { "{\"result\":2}" });
          return;
        }
        String str1 = ((JSONObject)localObject).optString("toUin");
        int i = ((JSONObject)localObject).optInt("uinType", 0);
        String str2 = ((JSONObject)localObject).optString("toNickName");
        if ((str1 != null) && (str1.length() >= 5))
        {
          localIntent.setClass(this.mContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str1);
          localIntent.putExtra("uinType", i);
          localIntent.putExtra("nickName", str2);
          localIntent.putExtra("shareQQType", ((JSONObject)localObject).optInt("shareQQType", 13));
          localIntent.putExtra("forward_type", 27);
          localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          localIntent.putExtra("k_back", ((JSONObject)localObject).optBoolean("k_back", ((JSONObject)localObject).optBoolean("back", false)));
          str1 = ((JSONObject)localObject).optString("appDesc");
          str2 = ((JSONObject)localObject).optString("appMinVersion");
          String str3 = ((JSONObject)localObject).optString("appView");
          String str4 = ((JSONObject)localObject).optString("appConfig");
          String str5 = ((JSONObject)localObject).optString("metaData");
          String str6 = ((JSONObject)localObject).optString("promptText");
          localObject = ((JSONObject)localObject).optString("compatibleText");
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5)))
          {
            if (TextUtils.isEmpty(this.bOl)) {
              break label676;
            }
            callJs(this.bOl, new String[] { "{\"result\":1}" });
          }
          localIntent.putExtra("forward_ark_app_name", paramString);
          localIntent.putExtra("forward_ark_app_view", str3);
          localIntent.putExtra("forward_ark_app_desc", str1);
          localIntent.putExtra("forward_ark_app_ver", str2);
          localIntent.putExtra("forward_ark_app_prompt", str6);
          localIntent.putExtra("forward_ark_app_meta", str5);
          localIntent.putExtra("forward_ark_app_config", str4);
          localIntent.putExtra("forward_ark_app_compat", (String)localObject);
          localIntent.putExtra("is_ark_display_share", true);
          localIntent.putExtra("appName", paramString);
          localIntent.putExtra("appView", str3);
          localIntent.putExtra("appMinVersion", str2);
          localIntent.putExtra("metaData", str5);
          localIntent.putExtra("scale", this.mContext.getResources().getDisplayMetrics().scaledDensity);
          if (!(this.mContext instanceof QQBrowserActivity)) {
            break label690;
          }
          paramString = ((QQBrowserActivity)this.mContext).a();
          if (paramString != null)
          {
            paramString = paramString.getCurrentUrl();
            if (!TextUtils.isEmpty(paramString)) {
              localIntent.putExtra("forward_ark_h5_from_js", paramString);
            }
          }
          startActivityForResult(localIntent, (byte)3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (!TextUtils.isEmpty(this.bOl)) {
          callJs(this.bOl, new String[] { "{\"result\":3}" });
        }
        QLog.e("QQApi", 1, "shareArkMsg error: " + paramString.toString());
        return;
      }
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.mContext, ForwardRecentActivity.class);
      continue;
      label676:
      callJs4OpenApiIfNeeded("shareMsg", 0, "{\"result\":1}");
      continue;
      label690:
      if (this.mRuntime != null)
      {
        paramString = this.mRuntime.b();
        if (paramString != null)
        {
          paramString = paramString.mUrl;
          if (!TextUtils.isEmpty(paramString)) {
            localIntent.putExtra("forward_ark_h5_from_js", paramString);
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.mRuntime.getActivity();
    if (this.m == null) {
      bQ(paramString1);
    }
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
    paramString6 = new Bundle();
    paramString6.putString("title", paramString2);
    paramString6.putString("desc", paramString3);
    paramString6.putString("detail_url", paramString4);
    paramString6.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString6.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString6.putStringArrayList("image_url", paramJSONObject);
    paramString6.putLong("req_share_id", 0L);
    paramString6.putInt("iUrlInfoFrm", 1);
    paramString6.putLong("share_begin_time", arbt.In);
    if ((this.jdField_a_of_type_Ardm$l != null) && (this.jdField_a_of_type_Ardm$o != null))
    {
      paramString6.putString("strurt_msgid", this.jdField_a_of_type_Ardm$l.CF());
      paramString6.putString("struct_uin", this.jdField_a_of_type_Ardm$l.CG());
      paramString6.putString("struct_url", this.jdField_a_of_type_Ardm$o.getCurrentUrl());
      paramString6.putBoolean("from_web", true);
      if ((this.jdField_a_of_type_Ardm$l.CH() != null) && (!"".equals(this.jdField_a_of_type_Ardm$l.CH()))) {
        paramString6.putString("source_puin", this.jdField_a_of_type_Ardm$l.CH());
      }
    }
    if (this.jdField_a_of_type_Ardm$c != null) {}
    for (int i = this.jdField_a_of_type_Ardm$c.a(this, (byte)1, true);; i = 1)
    {
      if (paramString1.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
        i = 15001;
      }
      if (!avqq.a(this.mRuntime.a(), getCurrentContext(), paramString6, null, i)) {
        break;
      }
      return;
    }
    rwt.ez(1, 2131689537);
    if (!TextUtils.isEmpty(this.bxh))
    {
      callJs(this.bxh, new String[] { "false" });
      return;
    }
    callJs4OpenApiIfNeeded("shareMsg", 0, "false");
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramJSONObject = this.mRuntime.getActivity();
    int i = -1;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    while (i != -1)
    {
      rwt.ez(0, i);
      if (this.m == null) {
        bQ(paramJSONObject);
      }
      if ((this.m != null) && (this.m.isShowing())) {
        this.m.dismiss();
      }
      return;
      if (!WXShareHelper.a().isWXsupportApi()) {
        i = 2131721936;
      }
    }
    HashMap localHashMap = new HashMap(1);
    paramString2 = new QQApiPlugin.3(this, paramString1, paramString4, paramInt, localHashMap, paramString6, paramString2, paramString3, paramString7);
    if (TextUtils.isEmpty(paramString5))
    {
      paramString2.run();
      return;
    }
    if (this.m == null) {
      bQ(paramJSONObject);
    }
    if (!this.m.isShowing())
    {
      this.m.setMessage(2131695695);
      this.m.show();
    }
    ThreadManager.post(new QQApiPlugin.4(this, paramString5, localHashMap, paramString2, paramString1, paramString4), 8, null, false);
  }
  
  /* Error */
  public void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
    throws JSONException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 433	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   7: astore 19
    //   9: new 63	android/content/Intent
    //   12: dup
    //   13: invokespecial 224	android/content/Intent:<init>	()V
    //   16: astore 18
    //   18: aload_1
    //   19: ldc 78
    //   21: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_2
    //   25: aload_1
    //   26: ldc 84
    //   28: iconst_0
    //   29: invokevirtual 88	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   32: istore 10
    //   34: aload_2
    //   35: ifnull +990 -> 1025
    //   38: aload_2
    //   39: invokevirtual 94	java/lang/String:length	()I
    //   42: iconst_5
    //   43: if_icmplt +982 -> 1025
    //   46: aload 18
    //   48: aload_0
    //   49: getfield 65	aiju:mContext	Landroid/content/Context;
    //   52: ldc 96
    //   54: invokevirtual 100	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   57: pop
    //   58: aload 18
    //   60: ldc 78
    //   62: aload_2
    //   63: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   66: pop
    //   67: aload 18
    //   69: ldc 84
    //   71: iload 10
    //   73: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   76: pop
    //   77: aload 18
    //   79: ldc 186
    //   81: iconst_1
    //   82: invokevirtual 76	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   85: pop
    //   86: aload_3
    //   87: astore 6
    //   89: aload_3
    //   90: ifnull +43 -> 133
    //   93: aload_3
    //   94: astore 6
    //   96: aload_3
    //   97: invokevirtual 94	java/lang/String:length	()I
    //   100: bipush 45
    //   102: if_icmple +31 -> 133
    //   105: new 147	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   112: aload_3
    //   113: iconst_0
    //   114: bipush 45
    //   116: invokevirtual 608	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 610
    //   125: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 6
    //   133: iload 9
    //   135: istore 10
    //   137: iload 9
    //   139: ifgt +7 -> 146
    //   142: bipush 13
    //   144: istore 10
    //   146: ldc_w 518
    //   149: astore_3
    //   150: ldc_w 518
    //   153: astore 4
    //   155: ldc_w 518
    //   158: astore_2
    //   159: ldc_w 518
    //   162: astore 7
    //   164: ldc_w 518
    //   167: astore 8
    //   169: ldc_w 518
    //   172: astore 15
    //   174: ldc_w 518
    //   177: astore 17
    //   179: aload_1
    //   180: ldc_w 612
    //   183: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   186: ifeq +894 -> 1080
    //   189: aload_1
    //   190: ldc_w 612
    //   193: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   196: ldc_w 614
    //   199: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +878 -> 1080
    //   205: iconst_0
    //   206: istore 9
    //   208: iconst_0
    //   209: istore 11
    //   211: aload_1
    //   212: ldc_w 616
    //   215: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   218: ifeq +11 -> 229
    //   221: aload_1
    //   222: ldc_w 616
    //   225: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   228: astore_3
    //   229: aload_1
    //   230: ldc_w 618
    //   233: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   236: ifeq +12 -> 248
    //   239: aload_1
    //   240: ldc_w 618
    //   243: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 4
    //   248: aload_1
    //   249: ldc_w 620
    //   252: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   255: ifeq +12 -> 267
    //   258: aload_1
    //   259: ldc_w 620
    //   262: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   265: astore 7
    //   267: aload_1
    //   268: ldc_w 622
    //   271: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +11 -> 285
    //   277: aload_1
    //   278: ldc_w 622
    //   281: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_2
    //   285: aload_1
    //   286: ldc_w 624
    //   289: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   292: ifeq +12 -> 304
    //   295: aload_1
    //   296: ldc_w 624
    //   299: invokevirtual 628	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   302: istore 9
    //   304: aload_1
    //   305: ldc_w 630
    //   308: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   311: ifeq +12 -> 323
    //   314: aload_1
    //   315: ldc_w 630
    //   318: invokevirtual 628	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   321: istore 11
    //   323: aload_1
    //   324: ldc_w 632
    //   327: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   330: ifeq +12 -> 342
    //   333: aload_1
    //   334: ldc_w 632
    //   337: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: astore 8
    //   342: aload_1
    //   343: ldc_w 634
    //   346: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   349: ifeq +12 -> 361
    //   352: aload_1
    //   353: ldc_w 634
    //   356: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: astore 15
    //   361: aload_1
    //   362: ldc_w 636
    //   365: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   368: ifeq +12 -> 380
    //   371: aload_1
    //   372: ldc_w 636
    //   375: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: astore 17
    //   380: aload 18
    //   382: ldc 108
    //   384: bipush 36
    //   386: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   389: pop
    //   390: new 59	org/json/JSONObject
    //   393: dup
    //   394: invokespecial 637	org/json/JSONObject:<init>	()V
    //   397: astore 16
    //   399: aload 16
    //   401: ldc_w 612
    //   404: iconst_1
    //   405: invokevirtual 641	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload 16
    //   411: ldc_w 632
    //   414: aload 8
    //   416: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 16
    //   422: ldc_w 616
    //   425: aload_3
    //   426: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 16
    //   432: ldc_w 618
    //   435: aload 4
    //   437: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: aload 16
    //   443: ldc_w 620
    //   446: aload 7
    //   448: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   451: pop
    //   452: aload 16
    //   454: ldc_w 624
    //   457: iload 9
    //   459: invokevirtual 641	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   462: pop
    //   463: aload 16
    //   465: ldc_w 630
    //   468: iload 11
    //   470: invokevirtual 641	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 16
    //   476: ldc_w 634
    //   479: aload 15
    //   481: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload 16
    //   487: ldc_w 636
    //   490: aload 17
    //   492: invokevirtual 644	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   495: pop
    //   496: aload 18
    //   498: ldc_w 646
    //   501: aload 16
    //   503: invokevirtual 647	org/json/JSONObject:toString	()Ljava/lang/String;
    //   506: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   509: pop
    //   510: aload 16
    //   512: astore 4
    //   514: aload 4
    //   516: astore 7
    //   518: aload 18
    //   520: ldc 178
    //   522: ldc 180
    //   524: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   527: pop
    //   528: aload 18
    //   530: ldc_w 442
    //   533: aload 6
    //   535: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   538: pop
    //   539: aload 18
    //   541: ldc_w 328
    //   544: iload 10
    //   546: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   549: pop
    //   550: aload 18
    //   552: ldc 108
    //   554: bipush 36
    //   556: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   559: pop
    //   560: aload 18
    //   562: ldc_w 472
    //   565: aload_1
    //   566: ldc_w 649
    //   569: ldc2_w 650
    //   572: invokevirtual 655	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   575: invokevirtual 658	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   578: pop
    //   579: aload 18
    //   581: ldc_w 660
    //   584: ldc_w 662
    //   587: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   590: pop
    //   591: aload 18
    //   593: ldc_w 664
    //   596: aload_2
    //   597: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   600: pop
    //   601: aload 18
    //   603: ldc_w 666
    //   606: aload_1
    //   607: ldc_w 448
    //   610: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   616: pop
    //   617: aload 18
    //   619: ldc_w 668
    //   622: aload_1
    //   623: ldc_w 668
    //   626: iconst_0
    //   627: invokevirtual 88	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   630: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   633: pop
    //   634: aload 18
    //   636: ldc_w 450
    //   639: aload 5
    //   641: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   644: pop
    //   645: aload 18
    //   647: ldc 182
    //   649: bipush 118
    //   651: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   654: pop
    //   655: aload 18
    //   657: ldc 125
    //   659: invokestatic 131	mqq/app/MobileQQ:getMobileQQ	()Lmqq/app/MobileQQ;
    //   662: invokevirtual 135	mqq/app/MobileQQ:getQQProcessName	()Ljava/lang/String;
    //   665: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   668: pop
    //   669: aload_1
    //   670: ldc_w 330
    //   673: iconst_0
    //   674: invokevirtual 334	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   677: istore 12
    //   679: aload_1
    //   680: ldc 184
    //   682: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   685: ifeq +11 -> 696
    //   688: aload_1
    //   689: ldc 184
    //   691: invokevirtual 671	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   694: istore 12
    //   696: aload 18
    //   698: ldc 184
    //   700: iload 12
    //   702: invokevirtual 76	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   705: pop
    //   706: aload_0
    //   707: getfield 302	aiju:m	Larhz;
    //   710: ifnonnull +9 -> 719
    //   713: aload_0
    //   714: aload 19
    //   716: invokevirtual 437	aiju:bQ	(Landroid/app/Activity;)V
    //   719: aload_0
    //   720: getfield 302	aiju:m	Larhz;
    //   723: ifnull +58 -> 781
    //   726: aload_0
    //   727: getfield 302	aiju:m	Larhz;
    //   730: invokevirtual 307	arhz:isShowing	()Z
    //   733: ifeq +48 -> 781
    //   736: invokestatic 677	java/lang/System:currentTimeMillis	()J
    //   739: lstore 13
    //   741: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +30 -> 774
    //   747: ldc 41
    //   749: iconst_2
    //   750: new 147	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   757: ldc_w 679
    //   760: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: lload 13
    //   765: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   768: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aload_0
    //   775: getfield 302	aiju:m	Larhz;
    //   778: invokevirtual 310	arhz:dismiss	()V
    //   781: aload_1
    //   782: ldc_w 684
    //   785: aconst_null
    //   786: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   789: astore_2
    //   790: aload_2
    //   791: ifnonnull +378 -> 1169
    //   794: aload_1
    //   795: ldc_w 686
    //   798: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   801: astore_2
    //   802: aload_2
    //   803: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   806: ifne +218 -> 1024
    //   809: aload_0
    //   810: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   813: invokevirtual 539	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   816: aload_0
    //   817: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   820: invokevirtual 539	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:a	()Lcom/tencent/common/app/AppInterface;
    //   823: invokevirtual 691	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   826: invokevirtual 695	com/tencent/common/app/AppInterface:getEntityManagerFactory	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   829: invokevirtual 701	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   832: astore_3
    //   833: aload_3
    //   834: ldc_w 703
    //   837: aload_2
    //   838: invokevirtual 709	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   841: checkcast 703	com/tencent/mobileqq/data/AccountDetail
    //   844: astore 4
    //   846: aload_3
    //   847: invokevirtual 712	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   850: aload 4
    //   852: ifnull +311 -> 1163
    //   855: aload 4
    //   857: getfield 715	com/tencent/mobileqq/data/AccountDetail:name	Ljava/lang/String;
    //   860: astore 4
    //   862: aload 4
    //   864: astore_3
    //   865: aload 4
    //   867: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   870: ifeq +24 -> 894
    //   873: aload 4
    //   875: astore_3
    //   876: aload_1
    //   877: ldc_w 717
    //   880: invokevirtual 120	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   883: ifeq +11 -> 894
    //   886: aload_1
    //   887: ldc_w 717
    //   890: invokevirtual 82	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   893: astore_3
    //   894: aload_3
    //   895: astore 4
    //   897: aload_3
    //   898: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   901: ifeq +6 -> 907
    //   904: aload_2
    //   905: astore 4
    //   907: aload 18
    //   909: ldc_w 719
    //   912: aload_1
    //   913: ldc_w 719
    //   916: ldc_w 518
    //   919: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   922: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   925: pop
    //   926: aload 18
    //   928: ldc_w 721
    //   931: ldc_w 723
    //   934: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   937: pop
    //   938: aload 18
    //   940: ldc_w 520
    //   943: aload_2
    //   944: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   947: pop
    //   948: aload 18
    //   950: ldc_w 725
    //   953: aload 4
    //   955: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   958: pop
    //   959: aload 18
    //   961: ldc 182
    //   963: bipush 118
    //   965: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   968: pop
    //   969: aload 18
    //   971: invokevirtual 202	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   974: invokestatic 207	anre:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   977: astore_1
    //   978: aload_1
    //   979: ifnonnull +134 -> 1113
    //   982: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: ifeq +11 -> 996
    //   988: ldc 41
    //   990: iconst_2
    //   991: ldc 209
    //   993: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: aload_0
    //   997: getfield 57	aiju:bxh	Ljava/lang/String;
    //   1000: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1003: ifne +98 -> 1101
    //   1006: aload_0
    //   1007: aload_0
    //   1008: getfield 57	aiju:bxh	Ljava/lang/String;
    //   1011: iconst_1
    //   1012: anewarray 90	java/lang/String
    //   1015: dup
    //   1016: iconst_0
    //   1017: ldc_w 557
    //   1020: aastore
    //   1021: invokevirtual 230	aiju:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1024: return
    //   1025: aload 18
    //   1027: ldc_w 412
    //   1030: iconst_1
    //   1031: invokevirtual 76	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1034: pop
    //   1035: aload 18
    //   1037: aload_0
    //   1038: getfield 65	aiju:mContext	Landroid/content/Context;
    //   1041: ldc 67
    //   1043: invokevirtual 100	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1046: pop
    //   1047: goto -970 -> 77
    //   1050: astore 7
    //   1052: aconst_null
    //   1053: astore_3
    //   1054: aload_3
    //   1055: astore 4
    //   1057: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq -546 -> 514
    //   1063: ldc 41
    //   1065: iconst_2
    //   1066: aload 7
    //   1068: invokestatic 729	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1071: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload_3
    //   1075: astore 4
    //   1077: goto -563 -> 514
    //   1080: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1083: ifeq +12 -> 1095
    //   1086: ldc 41
    //   1088: iconst_2
    //   1089: ldc_w 731
    //   1092: invokestatic 734	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1095: aconst_null
    //   1096: astore 7
    //   1098: goto -580 -> 518
    //   1101: aload_0
    //   1102: ldc_w 414
    //   1105: iconst_0
    //   1106: ldc_w 557
    //   1109: invokevirtual 417	aiju:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: return
    //   1113: aload_1
    //   1114: bipush 118
    //   1116: putfield 738	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1119: aload_1
    //   1120: aload 7
    //   1122: invokevirtual 647	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1125: putfield 741	com/tencent/mobileqq/structmsg/AbsStructMsg:mTribeShortVideoExtra	Ljava/lang/String;
    //   1128: aload_1
    //   1129: invokestatic 746	com/tencent/mobileqq/data/MessageForTribeShortVideo:buildCompatibleText	()Ljava/lang/String;
    //   1132: putfield 749	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1135: aload 18
    //   1137: ldc 213
    //   1139: aload_1
    //   1140: invokevirtual 219	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1143: invokevirtual 222	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1146: pop
    //   1147: aload_0
    //   1148: aload 18
    //   1150: iconst_4
    //   1151: invokevirtual 139	aiju:startActivityForResult	(Landroid/content/Intent;B)V
    //   1154: return
    //   1155: astore 7
    //   1157: aload 16
    //   1159: astore_3
    //   1160: goto -106 -> 1054
    //   1163: aconst_null
    //   1164: astore 4
    //   1166: goto -304 -> 862
    //   1169: goto -367 -> 802
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1172	0	this	aiju
    //   0	1172	1	paramJSONObject	JSONObject
    //   0	1172	2	paramString1	String
    //   0	1172	3	paramString2	String
    //   0	1172	4	paramString3	String
    //   0	1172	5	paramString4	String
    //   0	1172	6	paramString5	String
    //   0	1172	7	paramString6	String
    //   0	1172	8	paramString7	String
    //   0	1172	9	paramInt	int
    //   32	513	10	i	int
    //   209	260	11	j	int
    //   677	24	12	bool	boolean
    //   739	25	13	l	long
    //   172	308	15	str1	String
    //   397	761	16	localJSONObject	JSONObject
    //   177	314	17	str2	String
    //   16	1133	18	localIntent	Intent
    //   7	708	19	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   390	399	1050	java/lang/Exception
    //   399	510	1155	java/lang/Exception
  }
  
  public void bQ(Activity paramActivity)
  {
    if (this.m == null)
    {
      if (this.b != null) {
        this.m = this.b.b().b();
      }
    }
    else {
      return;
    }
    aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      if ((paramActivity instanceof ardm.k))
      {
        this.m = ((ardm.k)paramActivity).b().b();
        return;
      }
      this.m = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if ((localaqzv instanceof ardm.k))
    {
      this.m = ((ardm.k)localaqzv).b().b();
      return;
    }
    this.m = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
  }
  
  /* Error */
  void bh(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   4: invokevirtual 784	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7: invokevirtual 790	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   15: invokevirtual 425	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   18: getfield 428	com/tencent/mobileqq/webview/swift/WebViewFragment:mUrl	Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: invokevirtual 794	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	()Ljml;
    //   26: aload_3
    //   27: ldc_w 796
    //   30: invokevirtual 800	jml:z	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: ifne +37 -> 70
    //   36: ldc 41
    //   38: iconst_1
    //   39: ldc_w 802
    //   42: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: getfield 302	aiju:m	Larhz;
    //   49: ifnull +232 -> 281
    //   52: aload_0
    //   53: getfield 302	aiju:m	Larhz;
    //   56: invokevirtual 307	arhz:isShowing	()Z
    //   59: ifeq +222 -> 281
    //   62: aload_0
    //   63: getfield 302	aiju:m	Larhz;
    //   66: invokevirtual 310	arhz:dismiss	()V
    //   69: return
    //   70: aload_1
    //   71: ldc_w 804
    //   74: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: aload_1
    //   79: ldc_w 806
    //   82: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_1
    //   87: ldc_w 808
    //   90: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 4
    //   95: aload_1
    //   96: ldc_w 448
    //   99: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 5
    //   104: aload_1
    //   105: ldc_w 810
    //   108: ldc_w 812
    //   111: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 6
    //   116: aload_1
    //   117: ldc_w 814
    //   120: ldc_w 518
    //   123: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_1
    //   127: new 59	org/json/JSONObject
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: ldc 246
    //   137: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore_1
    //   141: new 573	java/util/HashMap
    //   144: dup
    //   145: invokespecial 815	java/util/HashMap:<init>	()V
    //   148: astore 7
    //   150: aload 7
    //   152: ldc_w 810
    //   155: aload 6
    //   157: invokeinterface 820 3 0
    //   162: pop
    //   163: aload 7
    //   165: ldc 246
    //   167: aload_1
    //   168: invokeinterface 820 3 0
    //   173: pop
    //   174: aload 7
    //   176: ldc_w 448
    //   179: aload 5
    //   181: invokeinterface 820 3 0
    //   186: pop
    //   187: aload_0
    //   188: getfield 421	aiju:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   191: invokevirtual 433	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +36 -> 232
    //   199: aload_1
    //   200: aload_2
    //   201: aload_3
    //   202: aload 4
    //   204: ldc_w 518
    //   207: aload_1
    //   208: invokevirtual 770	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   211: invokevirtual 382	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   214: getfield 388	android/util/DisplayMetrics:scaledDensity	F
    //   217: aload 7
    //   219: invokestatic 825	com/tencent/mobileqq/activity/ArkFullScreenAppActivity:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/util/Map;)Landroid/content/Intent;
    //   222: astore_2
    //   223: aload_2
    //   224: ifnull +8 -> 232
    //   227: aload_1
    //   228: aload_2
    //   229: invokestatic 831	ahgq:P	(Landroid/content/Context;Landroid/content/Intent;)V
    //   232: aload_0
    //   233: getfield 302	aiju:m	Larhz;
    //   236: ifnull +45 -> 281
    //   239: aload_0
    //   240: getfield 302	aiju:m	Larhz;
    //   243: invokevirtual 307	arhz:isShowing	()Z
    //   246: ifeq +35 -> 281
    //   249: aload_0
    //   250: getfield 302	aiju:m	Larhz;
    //   253: invokevirtual 310	arhz:dismiss	()V
    //   256: return
    //   257: astore_1
    //   258: ldc 41
    //   260: iconst_1
    //   261: ldc_w 833
    //   264: aload_1
    //   265: invokestatic 836	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: return
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   274: ldc_w 518
    //   277: astore_1
    //   278: goto -137 -> 141
    //   281: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	aiju
    //   0	282	1	paramJSONObject	JSONObject
    //   10	219	2	localObject	Object
    //   21	181	3	str1	String
    //   93	110	4	str2	String
    //   102	78	5	str3	String
    //   114	42	6	str4	String
    //   148	70	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	69	257	java/lang/Exception
    //   70	127	257	java/lang/Exception
    //   127	141	257	java/lang/Exception
    //   141	195	257	java/lang/Exception
    //   199	223	257	java/lang/Exception
    //   227	232	257	java/lang/Exception
    //   232	256	257	java/lang/Exception
    //   270	274	257	java/lang/Exception
    //   127	141	269	org/json/JSONException
  }
  
  public void c(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
    throws JSONException
  {
    if ((paramJSONObject.has("isArkMessage")) && (paramJSONObject.getBoolean("isArkMessage")))
    {
      bh(paramJSONObject);
      return;
    }
    Activity localActivity = this.mRuntime.getActivity();
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    paramString1 = (arbt)this.mRuntime.b().b().q(4);
    Bundle localBundle = paramString1.u();
    localIntent.putExtra("forward_source_business_type", 100500);
    int j;
    if (TextUtils.isEmpty(paramString1.bQs))
    {
      paramString1 = "";
      localIntent.putExtra("forward_source_sub_business_type", paramString1);
      if ((!TextUtils.isEmpty(str)) || (i != 0) || (localBundle == null) || (localBundle.isEmpty())) {
        break label2400;
      }
      str = localBundle.getString("to_qq");
      j = localBundle.getInt("to_uin_type");
      i = j;
      paramString1 = str;
      if (QLog.isColorLevel())
      {
        QLog.d("QQApi", 2, "shareMsgToQQ() called : toUin = " + str + ", uinType = " + j);
        paramString1 = str;
        i = j;
      }
    }
    for (;;)
    {
      str = paramJSONObject.optString("toNickName");
      j = paramJSONObject.optInt("isEncryptUin", 0);
      if ((paramString1 != null) && (paramString1.length() >= 5))
      {
        localIntent.setClass(this.mContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", paramString1);
        localIntent.putExtra("uinType", i);
        if (j == 1)
        {
          localIntent.putExtra("isEncryptUin", j);
          localIntent.putExtra("vfwebqq", paramJSONObject.optString("vfwebqq"));
          localIntent.putExtra("tok", paramJSONObject.optString("tok"));
        }
        if ((TextUtils.isEmpty(str)) && (localBundle != null) && (!localBundle.isEmpty()))
        {
          paramString1 = localBundle.getString("to_uin_name");
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToQQ() called : nickName = " + paramString1);
          }
          localIntent.putExtra("nickName", paramString1);
        }
        label408:
        localIntent.putExtra("key_flag_from_plugin", true);
        paramString1 = this.mRuntime.b();
        if (paramString1 == null) {
          break label2392;
        }
        paramString1 = (arbt)paramString1.a.q(4);
        if ((paramString1 == null) || (paramString1.b == null) || (!paramString1.b.s(localIntent))) {
          break label2392;
        }
      }
      label1195:
      label2246:
      label2376:
      label2378:
      label2384:
      label2392:
      for (i = 38;; i = 1001)
      {
        paramString1 = paramString2;
        if (paramString2 != null)
        {
          paramString1 = paramString2;
          if (paramString2.length() > 45) {
            paramString1 = paramString2.substring(0, 45) + "…";
          }
        }
        paramString2 = paramString3;
        if (paramString3 != null)
        {
          paramString2 = paramString3;
          if (paramString3.length() > 60) {
            paramString2 = paramString3.substring(0, 60) + "…";
          }
        }
        j = paramInt;
        if (paramInt <= 0) {
          j = 13;
        }
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("title", paramString1);
        localIntent.putExtra("desc", paramString2);
        localIntent.putExtra("detail_url", paramString4);
        localIntent.putExtra("shareQQType", j);
        localIntent.putExtra("forward_type", i);
        localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
        localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
        localIntent.putExtra("image_url_remote", paramString5);
        localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { paramString1 }));
        localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
        if (paramJSONObject.has("contentAction")) {
          localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
        }
        if (paramJSONObject.has("actionData")) {
          localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
        }
        if (paramJSONObject.has("sourceAction")) {
          localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
        }
        if (paramJSONObject.has("isShareFlag")) {
          localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
        }
        if (paramJSONObject.has("srcActionData")) {
          localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
        }
        if (paramJSONObject.has("appName")) {
          localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
        }
        if ("audio".equals(paramString6))
        {
          paramInt = 2;
          localIntent.putExtra("audio_url", paramString7);
        }
        boolean bool;
        long l;
        for (;;)
        {
          localIntent.putExtra("req_type", paramInt);
          if (paramJSONObject.has("report")) {
            localIntent.putExtra("report", paramJSONObject.getString("report"));
          }
          localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          bool = paramJSONObject.optBoolean("back", false);
          if (paramJSONObject.has("k_back")) {
            bool = paramJSONObject.getBoolean("k_back");
          }
          localIntent.putExtra("k_back", bool);
          if (paramJSONObject.has("serviceID")) {
            localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
          }
          if (paramJSONObject.has("serviceID"))
          {
            paramInt = paramJSONObject.getInt("serviceID");
            if ((paramInt == 116) || (paramInt == 123)) {
              localIntent.putExtra("compatible_text", aegu.bxf);
            }
          }
          if (paramJSONObject.has("need_send_long_msg_when_failed")) {
            localIntent.putExtra("need_send_long_msg_when_failed", paramJSONObject.optBoolean("need_send_long_msg_when_failed"));
          }
          l = paramJSONObject.optLong("appid", 0L);
          if (l <= 0L) {
            break label1283;
          }
          paramJSONObject = this.mRuntime.a();
          if (paramJSONObject != null)
          {
            if (this.m == null) {
              bQ(localActivity);
            }
            if (!this.m.isShowing())
            {
              this.m.setMessage(2131695695);
              this.m.show();
            }
            localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
            svi.a(paramJSONObject, this.mContext, paramJSONObject.getAccount(), l, 3000L, new aijy(this, localIntent));
          }
          if (localBundle == null) {
            break label2376;
          }
          localBundle.clear();
          return;
          paramString1 = paramString1.bQs;
          break;
          localIntent.putExtra("isWebCompShare", true);
          localIntent.setClass(this.mContext, ForwardRecentActivity.class);
          break label408;
          i = paramJSONObject.optInt("req_type", 146);
          paramInt = i;
          if (i == 2)
          {
            localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
            paramInt = i;
          }
        }
        if (this.m == null) {
          bQ(localActivity);
        }
        if ((this.m != null) && (this.m.isShowing()))
        {
          l = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "dialog dimiss time :" + l);
          }
          this.m.dismiss();
        }
        paramString1 = paramJSONObject.optString("puin", null);
        if (paramString1 == null) {
          paramString1 = paramJSONObject.optString("oaUin");
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramString1))
          {
            paramString2 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
            paramString5 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
            paramString2.close();
            paramString4 = paramJSONObject.optString("src_action", "");
            paramString2 = null;
            if (TextUtils.isEmpty(paramString4)) {
              if (paramString5 == null) {
                break label2384;
              }
            }
          }
          for (paramString2 = paramString5.name;; paramString2 = null)
          {
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramJSONObject.has("sourceName")) {
                paramString3 = paramJSONObject.optString("sourceName");
              }
            }
            paramString2 = paramString3;
            if (TextUtils.isEmpty(paramString3)) {
              paramString2 = paramString1;
            }
            for (;;)
            {
              if (paramString2.equalsIgnoreCase(this.mContext.getString(2131701894)))
              {
                bool = paramString2.equalsIgnoreCase(this.mContext.getString(2131701894));
                if (bool)
                {
                  paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
                  if (!bool) {
                    break label1885;
                  }
                  paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
                  if (!bool) {
                    break label1893;
                  }
                  paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
                  localIntent.putExtra("source_puin", paramString1);
                  localIntent.putExtra("struct_share_key_source_action", "plugin");
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
                  localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
                  localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
                  localIntent.putExtra("struct_share_key_source_icon", paramString4);
                  localIntent.putExtra("app_name", paramString2);
                }
              }
              for (;;)
              {
                if ((this.jdField_a_of_type_Ardm$l != null) && (this.jdField_a_of_type_Ardm$o != null))
                {
                  localIntent.putExtra("strurt_msgid", this.jdField_a_of_type_Ardm$l.CF());
                  localIntent.putExtra("struct_uin", this.jdField_a_of_type_Ardm$l.CG());
                  localIntent.putExtra("struct_url", this.jdField_a_of_type_Ardm$o.getCurrentUrl());
                  localIntent.putExtra("from_web", true);
                  if ((this.jdField_a_of_type_Ardm$l.CH() != null) && (!"".equals(this.jdField_a_of_type_Ardm$l.CH()))) {
                    localIntent.putExtra("source_puin", this.jdField_a_of_type_Ardm$l.CH());
                  }
                }
                paramJSONObject = anre.a(localIntent.getExtras());
                if (paramJSONObject != null) {
                  break label2356;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQApi", 2, "build struct msg fail");
                }
                if (TextUtils.isEmpty(this.bxh)) {
                  break label2344;
                }
                callJs(this.bxh, new String[] { "false" });
                return;
                if (paramJSONObject.has("sourceName")) {
                  paramString2 = paramJSONObject.optString("sourceName");
                }
                paramString3 = paramString2;
                if (TextUtils.isEmpty(paramString2))
                {
                  paramString3 = paramString2;
                  if (paramString5 != null) {
                    paramString3 = paramString5.name;
                  }
                }
                if (!TextUtils.isEmpty(paramString3)) {
                  break label2378;
                }
                paramString2 = paramString1;
                break;
                paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
                break label1547;
                label1885:
                paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
                break label1557;
                label1893:
                paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
                break label1567;
                paramString3 = paramJSONObject.optString("src_webActionUrl", "");
                paramString5 = paramJSONObject.optString("src_actionData", "");
                paramString6 = paramJSONObject.optString("src_a_actionData", "");
                paramString7 = paramJSONObject.optString("src_i_actionData", "");
                if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString7)))))
                {
                  paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
                  paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
                  localIntent.putExtra("struct_share_key_source_action", "plugin");
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
                  localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
                }
                for (;;)
                {
                  localIntent.putExtra("source_puin", paramString1);
                  localIntent.putExtra("app_name", paramString2);
                  paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
                  if (!TextUtils.isEmpty(paramJSONObject)) {
                    break label2246;
                  }
                  localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
                  break;
                  localIntent.putExtra("struct_share_key_source_action", paramString4);
                  if ("web".equals(paramString4))
                  {
                    localIntent.putExtra("struct_share_key_source_url", paramString3);
                    localIntent.putExtra("source_url", paramString3);
                  }
                  else
                  {
                    if (!TextUtils.isEmpty(paramString5)) {
                      localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                    }
                    if (!TextUtils.isEmpty(paramString6)) {
                      localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                    }
                    if (!TextUtils.isEmpty(paramString7)) {
                      localIntent.putExtra("struct_share_key_source_i_action_data", paramString7);
                    }
                  }
                }
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
                continue;
                if (paramJSONObject.has("sourceName"))
                {
                  paramString1 = paramJSONObject.optString("sourceName");
                  localIntent.putExtra("app_name", paramString1);
                  if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                    localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
                  }
                }
                else
                {
                  localIntent.putExtra("app_name", this.mContext.getString(2131698649));
                }
              }
              callJs4OpenApiIfNeeded("shareMsg", 0, "false");
              return;
              localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
              startActivityForResult(localIntent, (byte)1);
              break label1195;
              break;
              paramString2 = paramString3;
            }
          }
        }
      }
      label1283:
      label1547:
      label1557:
      label1567:
      label2344:
      label2356:
      label2400:
      paramString1 = str;
    }
  }
  
  public void cp(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "dialog get web js time :" + l);
    }
    this.bxh = null;
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      String str9;
      int k;
      String str14;
      try
      {
        localJSONObject = new JSONObject(paramString);
        Activity localActivity = this.mRuntime.getActivity();
        if (!paramBoolean) {
          break label840;
        }
        paramString = "shareType";
        str1 = localJSONObject.optString(paramString, "0");
        str2 = localJSONObject.optString("title");
        str3 = localJSONObject.optString("desc");
        if (!paramBoolean) {
          break label1164;
        }
        paramString = "shareUrl";
        str4 = localJSONObject.optString(paramString);
        if (!paramBoolean) {
          break label1171;
        }
        paramString = "imageUrl";
        paramString = localJSONObject.optString(paramString);
        str5 = localJSONObject.optString("shareElement");
        str6 = localJSONObject.optString("flash_url");
        str7 = localJSONObject.optString("article_id");
        str8 = localJSONObject.optString("rowkey");
        str9 = localJSONObject.optString("isfan");
        k = localJSONObject.optInt("WXShareFromQQKandian");
        String str10 = localJSONObject.optString("short_video_vid");
        String str11 = localJSONObject.optString("short_video_url");
        String str12 = localJSONObject.optString("short_video_cover_url");
        String str13 = localJSONObject.optString("short_video_theme_name");
        str14 = localJSONObject.optString("is_tribe_short_video");
        i = 0;
        if (TextUtils.isEmpty(paramString)) {
          i = 1;
        }
        j = i;
        if (TextUtils.isEmpty(str3)) {
          j = i | 0x2;
        }
        if (!TextUtils.isEmpty(str2)) {
          break label1158;
        }
        i = j | 0x4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "94");
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (i != 0) {
          break label1178;
        }
        j = 0;
        ((Bundle)localObject).putString("intext_1", j);
        ((Bundle)localObject).putString("intext_2", "" + i);
        ((Bundle)localObject).putString("stringext_1", "" + str4);
        arts.a().a((Bundle)localObject, "", this.mRuntime.a().getAccount(), false);
        i = localJSONObject.optInt("shareQQType", 13);
        this.bxh = localJSONObject.optString("callback");
        paramBoolean = localJSONObject.optBoolean("keepShareUrl", false);
        localObject = new HashMap();
        if ((!paramBoolean) && (str4 != null) && (str4.length() > 140) && (!"3".equals(str1))) {
          ((HashMap)localObject).put("share_url", str4);
        }
        if ((paramString != null) && (paramString.length() > 80) && (!"2".equals(str1)) && (!"3".equals(str1)) && (!"4".equals(str1))) {
          ((HashMap)localObject).put("image_url", paramString);
        }
        if ((str6 != null) && (str6.length() > 30)) {
          ((HashMap)localObject).put("flash_url", str6);
        }
        if (!TextUtils.isEmpty(str10)) {
          ((HashMap)localObject).put("short_video_vid", str10);
        }
        if (!TextUtils.isEmpty(str12)) {
          ((HashMap)localObject).put("short_video_cover_url", str12);
        }
        if (!TextUtils.isEmpty(str11)) {
          ((HashMap)localObject).put("short_video_url", str11);
        }
        if (!TextUtils.isEmpty(str13)) {
          ((HashMap)localObject).put("short_video_theme_name", str11);
        }
        if (!TextUtils.isEmpty(str14)) {
          ((HashMap)localObject).put("is_tribe_short_video", str14);
        }
        if ((((HashMap)localObject).isEmpty()) || ("1".equals(str1))) {
          break label846;
        }
        if (this.m == null) {
          bQ(localActivity);
        }
        if (!this.m.isShowing())
        {
          this.m.setMessage(2131695695);
          this.m.show();
        }
        ThreadManager.post(new QQApiPlugin.1(this, (HashMap)localObject, str4, paramString, str6, str1, localJSONObject, str2, str3, str5, str7, str8, str9, k, str14, i, localActivity), 8, null, true);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQApi", 2, "shareMsg error: " + paramString.toString());
      return;
      label840:
      paramString = "share_type";
      continue;
      label846:
      if ("1".equals(str1))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6);
        ocp.c(1002, str4, str7, str8, str9);
        return;
      }
      if (("2".equals(str1)) || ("3".equals(str1)))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, k);
        if ("2".equals(str1)) {
          ocp.c(1003, str4, str7, str8, str9);
        }
        if (!"3".equals(str1)) {
          break;
        }
        ocp.c(1004, str4, str7, str8, str9);
        return;
      }
      if ("4".equals(str1))
      {
        k(str2, str3, str4, paramString);
        ocp.c(1005, str4, str7, str8, str9);
        return;
      }
      if ("5".equals(str1))
      {
        e(str2, str3, str4, paramString, 6);
        return;
      }
      if ("6".equals(str1))
      {
        e(str2, str3, str4, paramString, 7);
        return;
      }
      if ((!TextUtils.isEmpty(str14)) && (localJSONObject.has("is_tribe_short_video")) && (str14.equals("true")))
      {
        b(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
        return;
      }
      c(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
      ocp.c(1001, str4, str7, str8, str9);
      return;
      label1158:
      int i = j;
      continue;
      label1164:
      paramString = "share_url";
      continue;
      label1171:
      paramString = "image_url";
      continue;
      label1178:
      int j = 1;
    }
  }
  
  public void e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToQidianOrQiye start: " + paramInt);
    }
    Activity localActivity = this.mRuntime.getActivity();
    if (this.m == null) {
      bQ(localActivity);
    }
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
    asgx.a(localActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
  }
  
  Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public String getOpenidBatch(String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_Ardm$i != null)
    {
      paramString = this.jdField_a_of_type_Ardm$i.getOpenidBatch(paramString);
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("gamecenter", 2, "<--getOpenidBatch result=" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool1;
    int i;
    if ("QQApi".equals(paramString2))
    {
      if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.cXk)) {
        break label96;
      }
      bool1 = true;
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      i = paramVarArgs.length;
      if ((!"isAppInstalled".equals(paramString3)) || (i != 1)) {
        break label102;
      }
      paramString1 = Boolean.valueOf(aqiz.isAppInstalled(this.mContext, paramVarArgs[0]));
      label77:
      if (!bool1) {
        break label675;
      }
      callJs4OpenApiIfNeeded(paramString3, 0, paramString1);
    }
    for (;;)
    {
      bool2 = true;
      label96:
      label102:
      do
      {
        do
        {
          return bool2;
          bool1 = false;
          break;
          if (("checkAppInstalled".equals(paramString3)) && (i == 1))
          {
            paramString1 = aqiz.O(this.mContext, paramVarArgs[0]);
            break label77;
          }
          if (("checkAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = aqiz.P(this.mContext, paramVarArgs[0]);
            break label77;
          }
          if (("isAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = aqiz.Q(this.mContext, paramVarArgs[0]);
            break label77;
          }
          if (("startAppWithPkgName".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(aqiz.r(this.mContext, paramVarArgs[0], null));
            break label77;
          }
          if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i == 2))
          {
            paramString1 = Boolean.valueOf(aqiz.r(this.mContext, paramVarArgs[0], paramVarArgs[1]));
            break label77;
          }
          if (("getOpenidBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = getOpenidBatch(paramVarArgs[0]);
            break label77;
          }
          if (("launchAppWithTokens".equals(paramString3)) && ((i == 1) || (i == 4)))
          {
            if (i == 1)
            {
              Lx(paramVarArgs[0]);
              paramString1 = localObject;
              break label77;
            }
            paramString1 = localObject;
            if (i != 4) {
              break label77;
            }
            k(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = localObject;
            break label77;
          }
          if (("getAppsVerionCodeBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = aqiz.R(this.mContext, paramVarArgs[0]);
            break label77;
          }
          if (("setShareURL".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(mZ(paramVarArgs[0]));
            break label77;
          }
          if (("setShareInfo".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(na(paramVarArgs[0]));
            break label77;
          }
          if (("setToolHiddenFlags".equals(paramString3)) && (i == 1))
          {
            Ly(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareMsg".equals(paramString3)) && (i == 1))
          {
            cp(paramVarArgs[0], bool1);
            paramString1 = localObject;
            break label77;
          }
          if (("shareText".equals(paramString3)) && (i == 1))
          {
            LA(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareHypertext".equals(paramString3)) && (i == 1))
          {
            LB(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("sendPokeMsg".equals(paramString3)) && (i == 1))
          {
            LC(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          bool2 = bool3;
        } while (!"shareArkMessage".equals(paramString3));
        bool2 = bool3;
      } while (i != 1);
      Lz(paramVarArgs[0]);
      paramString1 = localObject;
      break label77;
      label675:
      paramJsBridgeListener.onComplete(paramString1);
    }
  }
  
  public void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "shareMsgToSina start!");
    }
    try
    {
      localObject = Uri.parse(paramString3);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject))))
        {
          m(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString2 = this.mRuntime.getActivity();
        if (this.m == null) {
          bQ(paramString2);
        }
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToSina empty title or share_url");
          }
          if ((this.m != null) && (this.m.isShowing())) {
            this.m.dismiss();
          }
          QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          return;
        }
        Object localObject = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new QQApiPlugin.2(this, paramString4, paramString1, paramString3, paramString2, (ApplicationInfo)localObject));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label262;
            }
            QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
              paramString3 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString3;
              paramString3 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString3;
              paramString1 = paramString1 + "&_wv=3";
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("url", paramString1);
              paramString2.startActivity(paramString3);
              if (!QLog.isColorLevel()) {
                break label426;
              }
              QLog.d("QQApi", 2, "shareMsgToSina start webview!");
              if ((this.m == null) || (!this.m.isShowing())) {
                continue;
              }
              this.m.dismiss();
            }
            catch (Exception paramString1)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
              paramString1.printStackTrace();
              if ((this.m == null) || (!this.m.isShowing())) {
                continue;
              }
              this.m.dismiss();
            }
            finally
            {
              if ((this.m == null) || (!this.m.isShowing())) {
                break label537;
              }
              this.m.dismiss();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQApi", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  public void k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "launchAppWithTokens " + paramString3);
    }
    anan localanan = new anan();
    Object localObject;
    if ((this.jdField_a_of_type_Ardm$c != null) || ((this.mContext instanceof PublicFragmentActivityForTool))) {
      localObject = this.mRuntime.a();
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if ((this.mContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.mContext).app;
        }
      }
      else
      {
        int j = 268435456;
        try
        {
          k = Integer.parseInt(paramString4);
          if ((0x4000000 & k) == 67108864) {
            j = 335544320;
          }
          i = j;
          if ((0x20000000 & k) == 536870912) {
            i = j | 0x20000000;
          }
          j = i;
          if ((k & 0x400000) == 4194304) {
            j = i | 0x400000;
          }
          i = j;
        }
        catch (Exception paramString4)
        {
          int i;
          for (;;)
          {
            int k;
            String str;
            i = 268435456;
            continue;
            paramString2 = paramString4;
            if (QLog.isColorLevel())
            {
              QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
              paramString2 = paramString4;
            }
          }
          localanan.a((AppInterface)localObject, this.mContext, paramString1, paramString2, paramString3, i);
          return;
        }
        anot.a(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        k = 0;
        str = "tencentwtlogin" + paramString1 + "://";
        j = k;
        if ("wtlogin".equals(paramString5))
        {
          paramString4 = this.mContext.getPackageManager();
          paramString5 = new Intent("android.intent.action.VIEW");
          paramString5.setData(Uri.parse(str));
          j = k;
          if (paramString4 != null)
          {
            j = k;
            if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
              j = 1;
            }
          }
        }
        if (j != 0)
        {
          paramString4 = "";
          if ((this.mRuntime != null) && (this.mRuntime.getWebView() != null))
          {
            paramString2 = this.mRuntime.getWebView().getUrl();
            localanan.a(str, this.mContext, paramString2, (AppInterface)localObject, paramString1, paramString3, i, paramString6);
            return;
          }
        }
      }
      localObject = null;
    }
  }
  
  void m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.mRuntime.getActivity();
    if (this.m == null) {
      bQ(paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.m != null) && (this.m.isShowing())) {
        this.m.dismiss();
      }
      QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          paramString1.printStackTrace();
          if ((this.m != null) && (this.m.isShowing())) {
            this.m.dismiss();
          }
        }
      }
      finally
      {
        if ((this.m == null) || (!this.m.isShowing())) {
          break;
        }
        this.m.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQApi", 2, "shareMsgToSina end!");
  }
  
  public boolean mZ(String paramString)
  {
    return (this.b != null) && (this.b.bw(paramString));
  }
  
  public boolean na(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQApi", 2, "setShareInfo been called");
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optString("title");
        String str1 = ((JSONObject)localObject1).optString("desc");
        String str2 = ((JSONObject)localObject1).optString("share_url");
        String str3 = ((JSONObject)localObject1).optString("image_url");
        localObject2 = ((JSONObject)localObject1).optString("type");
        String str4 = ((JSONObject)localObject1).optString("miniprogram_image_url");
        String str5 = ((JSONObject)localObject1).optString("cover_url");
        String str6 = ((JSONObject)localObject1).optString("source_name");
        String str7 = ((JSONObject)localObject1).optString("article_id");
        boolean bool1 = ((JSONObject)localObject1).optBoolean("editable", true);
        String str8 = ((JSONObject)localObject1).optString("policy");
        boolean bool2 = ((JSONObject)localObject1).optBoolean("isCreator", false);
        String str9 = ((JSONObject)localObject1).optString("singleLineTitle");
        boolean bool3 = ((JSONObject)localObject1).optBoolean("contentEdited");
        boolean bool4 = ((JSONObject)localObject1).optBoolean("isNewCreate");
        String str10 = ((JSONObject)localObject1).optString("groupCode");
        String str11 = ((JSONObject)localObject1).optString("domainId");
        String str12 = ((JSONObject)localObject1).optString("localPadId");
        if (!TextUtils.isEmpty(str5)) {
          localBundle.putString("cover_url", str5);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localBundle.putString("type", (String)localObject2);
        }
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("miniprogram_image_url", str4);
        }
        if (!TextUtils.isEmpty(str6)) {
          localBundle.putString("source_name", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
          localBundle.putString("article_id", str7);
        }
        if (!TextUtils.isEmpty(str9)) {
          localBundle.putString("singleLineTitle", str9);
        }
        localBundle.putBoolean("editable", bool1);
        localBundle.putBoolean("isCreator", bool2);
        if (!TextUtils.isEmpty(str8)) {
          localBundle.putString("policy", str8);
        }
        localBundle.putBoolean("contentEdited", bool3);
        localBundle.putBoolean("isNewCreate", bool4);
        if (!TextUtils.isEmpty(str10)) {
          localBundle.putString("groupCode", str10);
        }
        if (!TextUtils.isEmpty(str11)) {
          localBundle.putString("domainId", str11);
        }
        if (!TextUtils.isEmpty(str12)) {
          localBundle.putString("localPadId", str12);
        }
        localObject2 = this.mRuntime.getActivity();
        if ((localObject2 != null) && ((localObject2 instanceof TeamWorkDocEditBrowserActivity)))
        {
          localObject1 = ((JSONObject)localObject1).optString("type");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (!"docx".equals(localObject1)) {
              break label573;
            }
            ((TeamWorkDocEditBrowserActivity)localObject2).BF(1);
          }
        }
        localObject1 = this.mRuntime.a(this.mRuntime.getActivity());
        if ((localObject1 == null) || (!(localObject1 instanceof ardm.k))) {
          break;
        }
        localBundle.putInt("extra_url_info_from", 1);
        return ((ardm.k)localObject1).a(paramString, str1, str2, str3, localBundle);
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQApi", 2, "setShareInfo param error");
        }
        return false;
      }
      label573:
      if ("sheet".equals(localObject1)) {
        ((TeamWorkDocEditBrowserActivity)localObject2).BF(2);
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject;
    if (paramByte == 1) {
      if (!TextUtils.isEmpty(this.bxh))
      {
        localObject = this.bxh;
        if (paramInt == -1)
        {
          paramIntent = "true";
          callJs((String)localObject, new String[] { paramIntent });
        }
      }
    }
    do
    {
      do
      {
        return;
        paramIntent = "false";
        break;
        if (paramInt == -1) {}
        for (paramIntent = "true";; paramIntent = "false")
        {
          callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
          return;
        }
        if (paramByte == 2)
        {
          if (!TextUtils.isEmpty(this.bxh))
          {
            localObject = this.bxh;
            if (paramInt == -1) {}
            for (paramIntent = "{\"result\":1}";; paramIntent = "{\"result\":0}")
            {
              callJs((String)localObject, new String[] { paramIntent });
              return;
            }
          }
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":1}";; paramIntent = "{\"result\":0}")
          {
            callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
            return;
          }
        }
        if (paramByte == 3)
        {
          if (!TextUtils.isEmpty(this.bOl))
          {
            localObject = this.bOl;
            if (paramInt == -1) {}
            for (paramIntent = "{\"result\":0}";; paramIntent = "{\"result\":4}")
            {
              callJs((String)localObject, new String[] { paramIntent });
              return;
            }
          }
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":0}";; paramIntent = "{\"result\":4}")
          {
            callJs4OpenApiIfNeeded("shareMsg", 0, paramIntent);
            return;
          }
        }
      } while (paramByte != 4);
      localObject = this.mRuntime.getActivity();
    } while ((paramInt != -1) || (localObject == null) || (((Activity)localObject).isFinishing()) || (paramIntent == null));
    paramIntent = new Bundle(paramIntent.getExtras());
    this.c.aY(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mContext = getCurrentContext();
    aqzv localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.o))) {
      this.jdField_a_of_type_Ardm$o = ((ardm.o)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.c))) {
      this.jdField_a_of_type_Ardm$c = ((ardm.c)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.i))) {
      this.jdField_a_of_type_Ardm$i = ((ardm.i)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.l))) {
      this.jdField_a_of_type_Ardm$l = ((ardm.l)localaqzv);
    }
    localaqzv = this.mRuntime.a(this.mRuntime.getActivity());
    if ((localaqzv != null) && ((localaqzv instanceof ardm.k))) {
      this.b = ((ardm.k)localaqzv);
    }
    if (this.c == null)
    {
      this.c = skj.a();
      this.c.bzj();
    }
  }
  
  public void onDestroy()
  {
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
    }
    if (this.c != null) {
      this.c.bzk();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiju
 * JD-Core Version:    0.7.0.1
 */