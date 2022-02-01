import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class adrw
  extends uaz
{
  private Dialog H;
  private adrw.a a;
  private boolean bQB;
  private String bvn;
  private String bvo;
  private ConcurrentHashMap<String, Integer> eJ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> eL = new ConcurrentHashMap();
  private tzd f;
  private tzd g;
  private String mAppName;
  private String mAppPath;
  private boolean mHasInited;
  private String mPhoneNumber;
  
  public adrw()
  {
    this.jdField_a_of_type_Adrw$a = new adrw.a(null);
  }
  
  private void GP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ArkWebModule", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
    }
    for (;;)
    {
      return;
      this.eL.clear();
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("web-view-open-app-config");
        if (paramString == null) {
          continue;
        }
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = paramString.get(str);
          if (((localObject instanceof String)) && (localObject != null)) {
            this.eL.put(str, (String)localObject);
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkWebModule", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
      }
    }
  }
  
  private arbs a(int paramInt)
  {
    if (this.jdField_a_of_type_Uaz$a != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Uaz$a.b();
      if (localWebViewFragment != null) {
        return (arbs)localWebViewFragment.b().q(paramInt);
      }
      if ((this.jdField_a_of_type_Uaz$a.getActivity() instanceof araz.e)) {
        return (arbs)((araz.e)this.jdField_a_of_type_Uaz$a.getActivity()).b().q(paramInt);
      }
    }
    return null;
  }
  
  private void cUe()
  {
    if (this.mHasInited) {}
    for (;;)
    {
      return;
      try
      {
        ArkAppCenter.setupArkEnvironment(true);
        Object localObject = this.jdField_a_of_type_Uaz$a.b();
        if (localObject == null) {
          continue;
        }
        localObject = ((WebViewFragment)localObject).getArguments();
        if (localObject == null) {
          continue;
        }
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject == null) {
          continue;
        }
        this.mAppName = ((Bundle)localObject).getString("h5_ark_app_name");
        this.mAppPath = ((Bundle)localObject).getString("h5_ark_app_path");
        this.bvn = ((Bundle)localObject).getString("h5_ark_app_des");
        GP(((Bundle)localObject).getString("h5_ark_check_config"));
        this.bvo = ((Bundle)localObject).getString("h5_ark_nation_code");
        this.mPhoneNumber = ((Bundle)localObject).getString("h5_ark_phone_number");
        this.mHasInited = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ArkWebModule", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
        }
      }
    }
  }
  
  private void cUf()
  {
    if (this.jdField_a_of_type_Uaz$a == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.jdField_a_of_type_Uaz$a.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    QQToast.a(localActivity, acfp.m(2131702857), 0).show();
  }
  
  private void g(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    String str = String.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("version", str);
      ubu.a(paramtzd, paramJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, "getArkSDKVersion error e = ", localException);
      }
    }
  }
  
  private String getCurrentUrl()
  {
    if (this.jdField_a_of_type_Uaz$a != null)
    {
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_Uaz$a.b();
      if (localWebViewFragment != null) {
        return localWebViewFragment.getCurrentUrl();
      }
    }
    return null;
  }
  
  private void h(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    this.f = paramtzd;
    if ((this.H != null) && (this.H.isShowing()))
    {
      ubu.a(this.f, -5, "other");
      return;
    }
    try
    {
      this.jdField_a_of_type_Adrw$a.appId = paramJSONObject.optString("appID");
      this.jdField_a_of_type_Adrw$a.params = paramJSONObject.optString("paramsStr");
      this.jdField_a_of_type_Adrw$a.packageName = paramJSONObject.optString("packageName");
      this.jdField_a_of_type_Adrw$a.flags = paramJSONObject.optString("flags");
      this.jdField_a_of_type_Adrw$a.url = paramJSONObject.optString("url");
      if (TextUtils.isEmpty(this.jdField_a_of_type_Adrw$a.appId))
      {
        QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
        ubu.a(this.f, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", new Object[] { paramJSONObject.getMessage() }));
      }
      if (this.eJ.containsKey(this.jdField_a_of_type_Adrw$a.appId))
      {
        paramJSONObject = (Integer)this.eJ.get(this.jdField_a_of_type_Adrw$a.appId);
        if (paramJSONObject != null)
        {
          if (paramJSONObject.intValue() == 1)
          {
            paramJSONObject = this.jdField_a_of_type_Uaz$a.getActivity();
            if (!aqiz.isAppInstalled(paramJSONObject, this.jdField_a_of_type_Adrw$a.packageName))
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Adrw$a.url))
              {
                paramtzd = new Intent(paramJSONObject, QQBrowserActivity.class);
                paramtzd.putExtra("url", this.jdField_a_of_type_Adrw$a.url);
                paramtzd.putExtra("fromArkAppDownload", true);
                paramJSONObject.startActivity(paramtzd);
              }
              ubu.a(this.f, -4, "need to download");
              return;
            }
            k(this.jdField_a_of_type_Adrw$a.appId, this.jdField_a_of_type_Adrw$a.params, this.jdField_a_of_type_Adrw$a.packageName, this.jdField_a_of_type_Adrw$a.flags, this.jdField_a_of_type_Adrw$a.type, this.jdField_a_of_type_Adrw$a.bvp);
            ubu.a(this.f, tzf.EMPTY);
            return;
          }
          if (paramJSONObject.intValue() == 0)
          {
            cUf();
            ubu.a(this.f, -3, "user canceled");
            return;
          }
        }
      }
      cUe();
      if (this.eL == null) {
        break label804;
      }
    }
    paramJSONObject = this.eL.keySet().iterator();
    do
    {
      if (!paramJSONObject.hasNext()) {
        break;
      }
      paramtzd = (String)paramJSONObject.next();
    } while ((TextUtils.isEmpty(this.mAppName)) || (!paramtzd.equals(this.mAppName)));
    label804:
    for (paramJSONObject = (String)this.eL.get(paramtzd);; paramJSONObject = "ask")
    {
      if (paramJSONObject.equals("allow"))
      {
        paramJSONObject = this.jdField_a_of_type_Uaz$a.getActivity();
        if (!aqiz.isAppInstalled(paramJSONObject, this.jdField_a_of_type_Adrw$a.packageName))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Adrw$a.url))
          {
            paramtzd = new Intent(paramJSONObject, QQBrowserActivity.class);
            paramtzd.putExtra("url", this.jdField_a_of_type_Adrw$a.url);
            paramtzd.putExtra("fromArkAppDownload", true);
            paramJSONObject.startActivity(paramtzd);
          }
          ubu.a(this.f, -4, "need to download");
          return;
        }
        k(this.jdField_a_of_type_Adrw$a.appId, this.jdField_a_of_type_Adrw$a.params, this.jdField_a_of_type_Adrw$a.packageName, this.jdField_a_of_type_Adrw$a.flags, this.jdField_a_of_type_Adrw$a.type, this.jdField_a_of_type_Adrw$a.bvp);
        ubu.a(this.f, tzf.EMPTY);
        return;
      }
      if (paramJSONObject.equals("ask"))
      {
        paramJSONObject = this.jdField_a_of_type_Uaz$a.getActivity();
        if ((paramJSONObject == null) || (paramJSONObject.isFinishing())) {
          break;
        }
        paramtzd = this.jdField_a_of_type_Uaz$a.a();
        if (paramtzd == null) {
          break;
        }
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_Adrw$a.appId);
          svi.a(paramtzd, this.jdField_a_of_type_Uaz$a.getActivity(), paramtzd.getAccount(), l, 2000L, new adrx(this, paramJSONObject));
          return;
        }
        catch (NumberFormatException paramtzd)
        {
          QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", new Object[] { paramtzd.getMessage() }));
          paramtzd = paramJSONObject.getString(2131690514);
          GO(String.format(paramJSONObject.getString(2131690515), new Object[] { paramtzd }));
          this.H.show();
          return;
        }
      }
      if (!paramJSONObject.equals("forbidden")) {
        break;
      }
      cUf();
      ubu.a(this.f, -3, "user canceled");
      return;
    }
  }
  
  private void i(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    Object localObject = this.jdField_a_of_type_Uaz$a.b();
    if (localObject == null)
    {
      ubu.a(paramtzd, -3, "other");
      return;
    }
    arbt localarbt = (arbt)((WebViewFragment)localObject).a.q(4);
    if (localarbt == null)
    {
      ubu.a(paramtzd, -3, "other");
      return;
    }
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    try
    {
      str1 = paramJSONObject.optString("appName");
      str2 = paramJSONObject.optString("appView");
      localObject = paramJSONObject.optString("appMinVersion");
      str3 = paramJSONObject.optString("appConfig");
      str4 = paramJSONObject.optString("metaData");
      str5 = paramJSONObject.optString("appDesc");
      str6 = paramJSONObject.optString("promptText");
      str7 = paramJSONObject.optString("compatibleText");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        ubu.a(this.g, -2, "param error");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      ubu.a(paramtzd, -3, "other");
      return;
    }
    cUe();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "0.0.0.1";
    }
    localObject = aqjn.a.a(str1, str2, paramJSONObject, str4, adqr.getDensity(), null, null);
    ((Bundle)localObject).putBoolean("forward_ark_app_direct", false);
    ((Bundle)localObject).putString("forward_ark_app_name", str1);
    ((Bundle)localObject).putString("forward_ark_app_view", str2);
    ((Bundle)localObject).putString("forward_ark_app_desc", str5);
    ((Bundle)localObject).putString("forward_ark_app_ver", paramJSONObject);
    ((Bundle)localObject).putString("forward_ark_app_meta", str4);
    ((Bundle)localObject).putString("forward_ark_app_prompt", str6);
    ((Bundle)localObject).putString("forward_ark_app_config", str3);
    ((Bundle)localObject).putString("forward_ark_app_compat", str7);
    ((Bundle)localObject).putBoolean("forward_ark_from_h5", true);
    paramJSONObject = new Intent();
    paramJSONObject.setClass(localarbt.s, ForwardRecentActivity.class);
    paramJSONObject.putExtra("forward_type", 27);
    paramJSONObject.putExtra("is_ark_display_share", true);
    paramJSONObject.putExtras((Bundle)localObject);
    if (paramJSONObject != null) {
      ahgq.P(localarbt.s, paramJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkWebModule", 2, "buildForwardIntent: " + localObject);
    }
    arts.a().a("", "", "", "1000", "101", "0", false);
    anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
    ubu.a(paramtzd, tzf.EMPTY);
  }
  
  private void j(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    this.g = paramtzd;
    Object localObject;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_Uaz$a.getActivity();
        paramtzd = new Intent();
        str1 = paramJSONObject.optString("appName");
        str2 = paramJSONObject.optString("toUin");
        int i = paramJSONObject.optInt("uinType", 0);
        str3 = paramJSONObject.optString("toNickName");
        if ((str2 != null) && (str2.length() >= 5))
        {
          paramtzd.setClass((Context)localObject, DirectForwardActivity.class);
          paramtzd.putExtra("toUin", str2);
          paramtzd.putExtra("uinType", i);
          paramtzd.putExtra("nickName", str3);
          paramtzd.putExtra("shareQQType", paramJSONObject.optInt("shareQQType", 13));
          paramtzd.putExtra("forward_type", 27);
          paramtzd.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          paramtzd.putExtra("k_back", paramJSONObject.optBoolean("k_back", paramJSONObject.optBoolean("back", false)));
          localObject = paramJSONObject.optString("appDesc");
          str2 = paramJSONObject.optString("appMinVersion");
          str3 = paramJSONObject.optString("appView");
          str4 = paramJSONObject.optString("appConfig");
          str5 = paramJSONObject.optString("metaData");
          str6 = paramJSONObject.optString("promptText");
          paramJSONObject = paramJSONObject.optString("compatibleText");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3))) {
            break;
          }
          ubu.a(this.g, -2, "param error");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ubu.a(this.g, -4, "other");
        QLog.e("ArkWebModule", 1, "shareArkMsg error: " + paramJSONObject.toString());
        return;
      }
      paramtzd.putExtra("isWebCompShare", true);
      paramtzd.setClass((Context)localObject, ForwardRecentActivity.class);
    }
    String str7 = getCurrentUrl();
    paramtzd.putExtra("forward_ark_app_name", str1);
    paramtzd.putExtra("forward_ark_app_view", str3);
    paramtzd.putExtra("forward_ark_app_desc", (String)localObject);
    paramtzd.putExtra("forward_ark_app_ver", str2);
    paramtzd.putExtra("forward_ark_app_prompt", str6);
    paramtzd.putExtra("forward_ark_app_meta", str5);
    paramtzd.putExtra("forward_ark_app_config", str4);
    paramtzd.putExtra("forward_ark_app_compat", paramJSONObject);
    paramtzd.putExtra("is_ark_display_share", true);
    paramtzd.putExtra("appName", str1);
    paramtzd.putExtra("appView", str3);
    paramtzd.putExtra("appMinVersion", str2);
    paramtzd.putExtra("metaData", str5);
    paramtzd.putExtra("scale", adqr.getDensity());
    if (!TextUtils.isEmpty(str7)) {
      paramtzd.putExtra("forward_ark_h5_from_js", str7);
    }
    startActivityForResult(paramtzd, (byte)0);
  }
  
  private void k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkWebModule", 2, "launchAppWithTokens " + paramString3);
    }
    anan localanan = new anan();
    AppInterface localAppInterface = this.jdField_a_of_type_Uaz$a.a();
    if (localAppInterface == null) {
      return;
    }
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
      Activity localActivity;
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
      if (localActivity == null) {
        break label428;
      }
      localanan.a(localAppInterface, localActivity, paramString1, paramString2, paramString3, i);
      return;
      QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
    }
    anot.a(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    localActivity = this.jdField_a_of_type_Uaz$a.getActivity();
    if ((localActivity != null) && ((localActivity instanceof QQBrowserActivity)) && (((QQBrowserActivity)localActivity).app == null)) {
      ((QQBrowserActivity)localActivity).updateAppRuntime();
    }
    k = 0;
    str = "tencentwtlogin" + paramString1 + "://";
    j = k;
    if ("wtlogin".equals(paramString5))
    {
      paramString4 = localActivity.getPackageManager();
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
      if (this.jdField_a_of_type_Uaz$a.getWebView() != null)
      {
        paramString2 = this.jdField_a_of_type_Uaz$a.getWebView().getUrl();
        localanan.a(str, localActivity, paramString2, localAppInterface, paramString1, paramString3, i, paramString6);
        return;
      }
    }
    label428:
  }
  
  private void k(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    boolean bool1 = true;
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    boolean bool2;
    label94:
    do
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.has("enable"))
          {
            bool2 = paramJSONObject.optBoolean("enable");
            paramJSONObject = this.jdField_a_of_type_Uaz$a.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof ardm.h))) {
              break;
            }
            paramJSONObject = (ardm.h)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.Tx(bool1);
            ubu.a(paramtzd, tzf.EMPTY);
          }
        }
        catch (Exception paramJSONObject)
        {
          ubu.a(paramtzd, -2, "param error");
          return;
        }
        bool1 = false;
      }
      paramJSONObject = a(-1);
    } while (paramJSONObject == null);
    if (!bool2) {}
    for (bool1 = true;; bool1 = false)
    {
      paramJSONObject.dp("image_long_click", bool1);
      break;
    }
  }
  
  private void l(JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    boolean bool1 = true;
    if (!this.bQB)
    {
      ubu.a(this.f, -1, "no auth");
      return;
    }
    boolean bool2;
    label94:
    do
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.has("enable"))
          {
            bool2 = paramJSONObject.optBoolean("enable");
            paramJSONObject = this.jdField_a_of_type_Uaz$a.a();
            if ((paramJSONObject == null) || (!(paramJSONObject instanceof ardm.h))) {
              break;
            }
            paramJSONObject = (ardm.h)paramJSONObject;
            if (bool2) {
              break label94;
            }
            paramJSONObject.Ty(bool1);
            ubu.a(paramtzd, tzf.EMPTY);
          }
        }
        catch (Exception paramJSONObject)
        {
          ubu.a(paramtzd, -2, "param error");
          return;
        }
        bool1 = false;
      }
      paramJSONObject = a(-1);
    } while (paramJSONObject == null);
    if (!bool2) {}
    for (bool1 = true;; bool1 = false)
    {
      paramJSONObject.dp("web_view_long_click", bool1);
      break;
    }
  }
  
  private void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_Uaz$a.b();
    if (localWebViewFragment != null) {
      localWebViewFragment.startActivityForResult(paramIntent, paramByte);
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("ArkWebModule", 4, "startActivityForResult not called, webViewFragment != null");
  }
  
  protected void GO(String paramString)
  {
    TextView localTextView1;
    if (this.H == null)
    {
      this.H = new ReportDialog(BaseActivity.sTopActivity, 2131756467);
      this.H.setContentView(2131559151);
      localTextView1 = (TextView)this.H.findViewById(2131365867);
      TextView localTextView2 = (TextView)this.H.findViewById(2131365863);
      TextView localTextView3 = (TextView)this.H.findViewById(2131365852);
      TextView localTextView4 = (TextView)this.H.findViewById(2131365858);
      localTextView1.setText(2131721103);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131721897);
      localTextView4.setOnClickListener(new adry(this));
      localTextView3.setOnClickListener(new adrz(this));
      localTextView3.setText(2131721058);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.H.findViewById(2131365863);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 13: 
      g(paramJSONObject, paramtzd);
    }
    for (;;)
    {
      return true;
      i(paramJSONObject, paramtzd);
      continue;
      j(paramJSONObject, paramtzd);
      continue;
      h(paramJSONObject, paramtzd);
      continue;
      k(paramJSONObject, paramtzd);
      continue;
      l(paramJSONObject, paramtzd);
    }
  }
  
  protected void bFe()
  {
    super.bFe();
    if ((this.jdField_a_of_type_Uaz$a.b() instanceof ArkBrowserFragment)) {
      this.bQB = true;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if ((paramByte == 0) && (this.g != null))
    {
      if (paramInt == -1) {
        ubu.a(this.g, tzf.EMPTY);
      }
    }
    else {
      return;
    }
    ubu.a(this.g, -3, "user cancel");
  }
  
  static class a
  {
    public String appId;
    public String bvp;
    public String flags;
    public String packageName;
    public String params;
    public String type;
    public String url;
    
    public void reset()
    {
      this.appId = null;
      this.params = null;
      this.packageName = null;
      this.flags = null;
      this.type = null;
      this.bvp = null;
      this.url = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrw
 * JD-Core Version:    0.7.0.1
 */