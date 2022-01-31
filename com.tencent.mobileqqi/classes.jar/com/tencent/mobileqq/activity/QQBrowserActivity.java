package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Ad;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPluginContainer;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.MttLoader;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import dbm;
import dbn;
import dbo;
import dbp;
import dbq;
import dbr;
import dbs;
import dbt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.apache.http.client.ClientProtocolException;

@TargetApi(7)
public class QQBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, WebViewPluginContainer
{
  protected static final int A = 64;
  public static final String A = "ba_is_login";
  protected static final int B = 1001;
  public static final String B = "hide_left_button";
  protected static final int C = 1;
  public static final String C = "show_right_close_button";
  public static int D = 0;
  public static final String D = "finish_animation_up_down";
  public static final String E = "avoidLoginWeb";
  static final String jdField_F_of_type_JavaLangString = "keyAction";
  public static final int G = 1000;
  static final String G = "actionSelectPicture";
  public static final int H = 1001;
  public static final int I = 1002;
  public static final int J = 1003;
  public static final int K = 1004;
  public static final String K = "com.tencent.mobileqq.card.modify";
  public static final int L = 1005;
  public static final String L = "com.tencent.mobileqq.view.self.album";
  public static final int M = 1006;
  public static final String M = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final int N = 1007;
  public static final String N = "broadcastAction";
  public static final String O = "key_pay_action_result";
  public static final String P = "reqType";
  public static final String Q = "http://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s";
  public static final String R = "key_isReadModeEnabled";
  public static final String V = "isShowAd";
  protected static final String X = "http://openmobile.qq.com/api/get_app_info_by_id?appid=%d";
  private static final int jdField_a_of_type_Int = 20000;
  static ValueCallback jdField_a_of_type_AndroidWebkitValueCallback;
  private static final String jdField_a_of_type_JavaLangString = "utf-8";
  private static final String jdField_b_of_type_JavaLangString = "http://p.mb.qq.com/sdk";
  private static byte[] jdField_b_of_type_ArrayOfByte = null;
  private static final String e = "Meizu_M040";
  private static final String f = "Xiaomi_MI 2";
  public static final int g = 4660;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 4;
  public static final int o = 5;
  public static final int p = 6;
  public static final int q = 16777216;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  public static final int v = 10000;
  public static final int w = 0;
  static final String y = "QQBrowser";
  protected static final int z = 34;
  static final String z = "QQBrowserOffline";
  int E;
  int jdField_F_of_type_Int;
  String H = null;
  public String I = null;
  public String J;
  protected String S;
  String T = "";
  public String U;
  protected String W = null;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected Handler a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  AbsoluteLayout jdField_a_of_type_AndroidWidgetAbsoluteLayout;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public ProgressBar a;
  public AuthorizeConfig a;
  public CustomWebView a;
  private CustomWebViewClient jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient;
  Ad jdField_a_of_type_ComTencentBizWebviewpluginAd;
  protected Share a;
  public ElasticHorScrView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQBrowserActivity.NativeChromeClient jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient;
  public QQBrowserActivity.TopBarBtnClickListener a;
  public BrowserAppInterface a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public WebViewPluginEngine a;
  protected GetAppInfoProto.GetAppinfoResponse a;
  public ActionSheet a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler;
  FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  public ImageView b;
  public ElasticHorScrView b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 50;
  public long c;
  FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout = null;
  public ImageView c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  public long d;
  protected ImageView d;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  protected long e;
  public ImageView e;
  public ImageView f;
  protected ImageView g;
  public boolean g;
  protected boolean h = false;
  protected boolean i = true;
  protected boolean j = false;
  public boolean k;
  protected boolean l;
  protected boolean m;
  boolean n;
  boolean o;
  int x = Build.VERSION.SDK_INT;
  public int y = 4;
  
  static
  {
    jdField_a_of_type_AndroidWebkitValueCallback = null;
  }
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new dbm(this);
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_AndroidWidgetImageView = null;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = null;
    this.jdField_n_of_type_Boolean = false;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString3 = "vkey=" + paramString3 + ";uin=" + paramString4;
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "<--httpRequest vookies=" + paramString3 + ",appids=" + paramString2);
    }
    paramString2 = new Bundle();
    paramString2.putString("Cookie", paramString3);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
  }
  
  private void a(Intent paramIntent)
  {
    this.o = paramIntent.getBooleanExtra("ba_is_login", true);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("reqType", -1);
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("vkey");
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramIntent.getBooleanExtra("portraitOnly", false));
    this.jdField_m_of_type_Boolean = getIntent().getBooleanExtra("isShowAd", true);
    this.I = paramIntent.getStringExtra("url");
    if (this.I == null) {
      this.I = paramIntent.getStringExtra("key_params_qq");
    }
    if (this.I == null) {
      this.I = "";
    }
    String str1;
    if ((this.I != null) && ((this.I.startsWith("http://")) || (this.I.startsWith("https://")))) {
      str1 = "en";
    }
    String str2;
    switch (LocaleUtil.a(BaseApplicationImpl.getContext()))
    {
    default: 
      if (this.I.matches("^[^#]*\\?.*(#.*)?"))
      {
        str2 = "&";
        label217:
        Object localObject = Pattern.compile("(#.*)?$").matcher(this.I);
        if (((Matcher)localObject).find())
        {
          String str3 = ((Matcher)localObject).group(1);
          localObject = str3;
          if (str3 == null) {
            localObject = "";
          }
          this.I = this.I.replaceAll("(#.*)?$", str2 + "lan=" + str1 + (String)localObject);
        }
        if ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 1) && (this.o)) {
          break label490;
        }
        this.I += "&_wv=2";
      }
      break;
    }
    for (;;)
    {
      a(paramIntent, this.I);
      if (paramIntent.getBooleanExtra("reportMsfLog", false))
      {
        if (this.jdField_b_of_type_AndroidOsHandler == null) {
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
        }
        if (this.jdField_a_of_type_JavaLangRunnable == null)
        {
          this.jdField_a_of_type_JavaLangRunnable = new dbn(this);
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        }
      }
      return;
      str1 = "en";
      break;
      str1 = "ja";
      break;
      str1 = "ko";
      break;
      str1 = "de";
      break;
      str1 = "fr";
      break;
      str1 = "es";
      break;
      str1 = "tw";
      break;
      str1 = "cn";
      break;
      str2 = "?";
      break label217;
      label490:
      if (this.jdField_b_of_type_Int == 6)
      {
        a(false);
        setRequestedOrientation(1);
      }
    }
  }
  
  public static void a(WebView paramWebView, String paramString, String... paramVarArgs)
  {
    int i1 = 0;
    paramString = new StringBuilder().append("(window.mqq&&mqq.version>20140616001&&mqq.execGlobalCallback||function(){window['").append(paramString).append("'].apply(window,[].slice.call(arguments,1))})('").append(paramString).append('\'');
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
    {
      int i2 = paramVarArgs.length;
      while (i1 < i2)
      {
        String str = paramVarArgs[i1];
        paramString.append(',').append(str);
        i1 += 1;
      }
    }
    paramString.append(");");
    c(paramWebView, paramString.toString());
  }
  
  public static void c(WebView paramWebView, String paramString)
  {
    if ((paramWebView == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      try
      {
        ((CustomWebView)paramWebView).a("javascript:" + paramString);
        return;
      }
      catch (Exception paramWebView)
      {
        paramWebView.printStackTrace();
        return;
      }
    }
    paramWebView.post(new dbt(paramWebView, paramString));
  }
  
  private void e()
  {
    this.l = false;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) && ((getAppRuntime() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      return;
    }
  }
  
  private boolean f()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())) {
      bool = false;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 12, null))) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
    return true;
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
    this.W = null;
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.b();
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient = new dbp(this, this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
  }
  
  private void r()
  {
    new dbq(this, "HttpUtils").start();
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return -1;
    }
    paramByte = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
    startActivityForResult(paramIntent, paramByte);
    return paramByte;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public CustomWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  }
  
  public Share a()
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
  }
  
  public WebViewPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
  }
  
  public String a()
  {
    return "6.0.2";
  }
  
  public String a(String paramString)
  {
    paramString = a(this, "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.jdField_c_of_type_JavaLangString, this.J);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public void a(int paramInt) {}
  
  public void a(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      Object localObject;
      if (paramString != null)
      {
        localObject = Uri.parse(paramString);
        if ((localObject != null) && (((Uri)localObject).isHierarchical()))
        {
          localObject = ((Uri)localObject).getQueryParameter("_wv");
          if (localObject == null) {}
        }
      }
      try
      {
        this.y = Integer.parseInt(((String)localObject).trim());
        if ((this.y & 0x2) != 0) {
          paramIntent.putExtra("hide_more_button", true);
        }
        if ((this.y & 0x1) != 0) {
          paramIntent.putExtra("webStyle", "noBottomBar");
        }
        if ((this.y & 0x400) != 0) {
          paramIntent.putExtra("isScreenOrientationPortrait", true);
        }
        if ((this.y & 0x4) == 0) {
          this.jdField_k_of_type_AndroidWidgetTextView.setText(getResources().getString(2131561692));
        }
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
          paramIntent.putExtra("isScreenOrientationPortrait", true);
        }
        this.T = paramIntent.getStringExtra("title");
        this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("homepage");
        this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("ishiderefresh", false);
        this.jdField_b_of_type_Boolean = paramIntent.getExtras().getBoolean("ishidebackforward", false);
        boolean bool1 = getIntent().getExtras().getBoolean("hide_more_button", false);
        if ((paramIntent.getExtras().getBoolean("hide_operation_bar", false)) || ("noBottomBar".equals(paramIntent.getStringExtra("webStyle"))))
        {
          i1 = 1;
          boolean bool2 = paramIntent.getExtras().getBoolean("isScreenOrientationPortrait", false);
          boolean bool3 = paramIntent.getExtras().getBoolean("hide_left_button", false);
          this.jdField_c_of_type_Boolean = paramIntent.getExtras().getBoolean("show_right_close_button", false);
          this.jdField_d_of_type_Boolean = paramIntent.getExtras().getBoolean("finish_animation_up_down", false);
          localObject = paramIntent.getStringExtra("key_params_qq");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i1 = 1;
            bool1 = true;
            paramString = (String)localObject;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser", 2, "QQBrowser url=" + paramString);
          }
          if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            setRequestedOrientation(1);
          }
          if ((this.T == null) || (this.T.length() <= 0)) {
            break label593;
          }
          setTitle(this.T);
          if (i1 != 0) {
            a(false);
          }
          this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131563122));
          if (!bool1)
          {
            this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130837835);
          }
          if (bool3) {
            this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(4);
          }
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_m_of_type_AndroidWidgetTextView.setText(2131561842);
            this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_m_of_type_AndroidWidgetTextView.bringToFront();
            this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(0);
            this.jdField_p_of_type_AndroidWidgetImageView.setBackgroundColor(0);
            this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (!bool2) {
            continue;
          }
          setRequestedOrientation(1);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i1;
          if (QLog.isDevelopLevel())
          {
            QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
            continue;
            i1 = 0;
            continue;
            label593:
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              if ((paramIntent.getExtras().getString("leftViewText") != null) && (paramString.startsWith("http://web.qun.qq.com/mannounce"))) {
                setTitle(getResources().getString(2131562001));
              }
            }
            else {
              setTitle("");
            }
          }
        }
      }
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(paramWebViewPlugin);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i1 * 1000 + paramByte + 10000);
    startActivity(paramIntent);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label106;
      }
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if ((paramString3 != null) && (paramString3.length() != 0)) {
        break label134;
      }
      setTitle("");
      return;
      if (paramString1.equals("RETURN")) {
        this.jdField_k_of_type_AndroidWidgetTextView.setText(getIntent().getStringExtra("leftViewText"));
      }
      for (;;)
      {
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
        this.jdField_k_of_type_AndroidWidgetTextView.setText(paramString1);
      }
      label106:
      this.jdField_m_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label134:
    setTitle(paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      b(paramString2, paramString3, paramString1);
      if (paramBoolean)
      {
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
    this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_p_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
      }
      if (TextUtils.isEmpty(paramString1)) {
        break;
      }
      this.W = paramString1;
      break;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838522);
      continue;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130839739);
      continue;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838011);
      continue;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130837835);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    boolean bool = false;
    Object localObject = null;
    int i1;
    if (paramString1.equals("left"))
    {
      localObject = this.jdField_k_of_type_AndroidWidgetTextView;
      Resources localResources = getResources();
      if (paramBoolean2)
      {
        i1 = 2130840330;
        ((View)localObject).setBackgroundDrawable(localResources.getDrawable(i1));
        i1 = 0;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        i1 = 2130840334;
        break;
        if (paramString1.equals("right"))
        {
          localObject = this.jdField_m_of_type_AndroidWidgetTextView;
          i1 = 1;
          continue;
        }
        if (!paramString1.equals("rightImgBtn")) {
          break label216;
        }
        localObject = this.jdField_p_of_type_AndroidWidgetImageView;
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130837835);
        i1 = 2;
        continue;
      }
      if ((localObject instanceof TextView)) {
        ((TextView)localObject).setText(paramString2);
      }
      if (paramBoolean1) {}
      for (int i2 = 0;; i2 = 8)
      {
        ((View)localObject).setVisibility(i2);
        paramBoolean1 = bool;
        if (!paramBoolean3) {
          paramBoolean1 = true;
        }
        ((View)localObject).setEnabled(paramBoolean1);
        ((View)localObject).setContentDescription(paramString2);
        paramString2 = new QQBrowserActivity.TopBarBtnClickListener(this, i1, paramString3);
        ((View)localObject).setOnClickListener(paramString2);
        if (!paramString1.equals("left")) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener = paramString2;
        return;
      }
      label216:
      i1 = 0;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.b(paramString).d(str).a(this, str, 2, null);
    paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramBoolean) {}
    for (int i1 = 42;; i1 = 45)
    {
      QfavReport.a(paramString, i1, 2);
      return;
    }
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, paramString, paramVarArgs);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      bool = true;
      if (bool != paramBoolean) {
        break label23;
      }
    }
    label23:
    int i1;
    FrameLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      bool = false;
      break;
      if (!paramBoolean) {
        break label77;
      }
      i1 = 0;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i1);
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.getLayoutParams();
    } while (localLayoutParams == null);
    if (paramBoolean) {}
    for (localLayoutParams.bottomMargin = this.jdField_c_of_type_Int;; localLayoutParams.bottomMargin = 0)
    {
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.setLayoutParams(localLayoutParams);
      return;
      label77:
      i1 = 8;
      break;
      this.jdField_c_of_type_Int = localLayoutParams.bottomMargin;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    int i1 = MttApi.a(this, MttLoader.a(this, paramString), localHashMap);
    if ((paramBoolean) && (!"10000512".equals(AppSetting.a(this))))
    {
      if (4 != i1) {
        break label153;
      }
      a(this, paramString, getResources().getString(2131562680), 2131561485);
    }
    for (;;)
    {
      if ("10000512".equals(AppSetting.a(this)))
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("normal", true);
      }
      try
      {
        startActivity(paramString);
        if (i1 == 0)
        {
          paramBoolean = bool;
          return paramBoolean;
          label153:
          if (5 == i1)
          {
            a(this, paramString, getResources().getString(2131562678), 2131563135);
            continue;
          }
          if (i1 == 0) {
            continue;
          }
          a(this, paramString, getResources().getString(2131562680), 2131561485);
        }
      }
      catch (ActivityNotFoundException paramString)
      {
        for (;;)
        {
          QRUtils.a(1, 2131560541);
          continue;
          paramBoolean = false;
        }
      }
    }
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.y & 0x8) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560568);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837751;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.y & 0x10) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560573);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837752;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    }
    if ((this.y & 0x200) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560572);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838482;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.y & 0x100) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131560571);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838480;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem;
    if ((this.y & 0x2000) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560581);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.k = 2130838584;
      localActionSheetItem.l = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.y & 0x20) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131560570);
      localActionSheetItem.k = 2130837750;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  @TargetApi(9)
  protected View b()
  {
    View localView = super.getLayoutInflater().inflate(2130903227, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131231677));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131231679));
    GridView localGridView2 = (GridView)localView.findViewById(2131231678);
    GridView localGridView1 = (GridView)localView.findViewById(2131231680);
    Object localObject1 = (TextView)localView.findViewById(2131231063);
    ((TextView)localObject1).setText(2131561746);
    ((TextView)localObject1).setOnClickListener(new dbr(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label383;
      }
    }
    label383:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i1 = ((List)localObject1).size();
      localGridView2.setNumColumns(i1);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i1 - 1) * 10 + i1 * 75 + 3) * this.jdField_c_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i1 = localLayoutParams.width;
      this.F = i1;
      int i2 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((i2 * 75 + (i2 - 1) * 10 + 3) * this.jdField_c_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i2);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      i2 = ((ViewGroup.LayoutParams)localObject1).width;
      this.E = i2;
      localView.post(new dbs(this, i1, i2));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public void b()
  {
    if (!this.jdField_n_of_type_Boolean)
    {
      this.jdField_n_of_type_Boolean = true;
      setContentView(2130903100);
      x();
      getWindow().setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231180));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231179));
      this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131231181));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131231187);
      String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout = ((AbsoluteLayout)findViewById(2131231182));
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((CustomWebView)findViewById(2131230905));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131230740));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231189));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231190));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231192));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231193));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
      this.f = ((ImageView)findViewById(2131231191));
      this.f.setOnClickListener(this);
      this.f.setEnabled(true);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231188));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231066));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ("1103".equals(str)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      a(getIntent());
      return;
    }
    a(getIntent());
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    int i2 = 0;
    if (!TextUtils.isEmpty(paramString1))
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_m_of_type_AndroidWidgetTextView.bringToFront();
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    int i1;
    if (paramString2 != null)
    {
      i1 = i2;
      if (paramString2.length() <= 0) {}
    }
    try
    {
      i1 = Color.parseColor(paramString2);
      this.jdField_p_of_type_AndroidWidgetImageView.setBackgroundColor(i1);
      if (!TextUtils.isEmpty(paramString3)) {
        this.W = paramString3;
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public boolean b()
  {
    if ((((this.y & 0x4) == 0) || (this.jdField_k_of_type_Boolean)) && (f())) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 12, null))) {
      return true;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient.onHideCustomView();
      return true;
    }
    if (this.I.contains("ti.qq.com/adyen/index")) {
      setResult(2002);
    }
    for (;;)
    {
      finish();
      return true;
      setResult(-1, new Intent());
    }
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString);
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
    return null;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  protected void c_()
  {
    super.c_();
    if ((this.jdField_p_of_type_Boolean) && (!TextUtils.isEmpty(this.J)) && (GesturePWDUtils.getGesturePWDState(this, this.J) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.J) == 21)) {
      B();
    }
  }
  
  public String d()
  {
    String str2 = this.I;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl())) {
        str1 = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl();
      }
    }
    else {
      return str1;
    }
    return getIntent().getStringExtra("url");
  }
  
  public void d() {}
  
  public boolean d()
  {
    return super.d();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 > 10000)
    {
      int i1 = (paramInt1 - 10000) / 1000;
      byte b1 = (byte)((paramInt1 - 10000) % 1000);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(i1);
      if (localObject != null)
      {
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, b1, paramInt2);
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 9, (Map)localObject))
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (jdField_a_of_type_AndroidWebkitValueCallback != null)
      {
        if ((paramIntent == null) || (paramInt2 != -1)) {}
        for (localObject = null;; localObject = paramIntent.getData())
        {
          ReflectionUtil.a(BaseApplication.getContext(), jdField_a_of_type_AndroidWebkitValueCallback, (Uri)localObject);
          jdField_a_of_type_AndroidWebkitValueCallback = null;
          break;
        }
        localObject = new Intent(this, ChatActivity.class);
        Bundle localBundle1 = paramIntent.getExtras();
        Bundle localBundle2 = new Bundle(localBundle1);
        localBundle1.getString("uin");
        localBundle1.getInt("uintype", 0);
        ((Intent)localObject).putExtras(localBundle2);
        startActivity((Intent)localObject);
        continue;
        QfavBuilder.a(this, paramIntent);
        continue;
        if (paramInt2 == 0)
        {
          if (jdField_a_of_type_AndroidWebkitValueCallback != null)
          {
            ReflectionUtil.a(BaseApplication.getContext(), jdField_a_of_type_AndroidWebkitValueCallback, null);
            jdField_a_of_type_AndroidWebkitValueCallback = null;
          }
        }
        else if (paramInt2 == 4660)
        {
          setResult(4660);
          finish();
        }
      }
    }
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    D += 1;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + System.currentTimeMillis());
    }
    setTheme(2131624529);
    super.doOnCreate(paramBundle);
    e();
    b();
    g();
    k();
    if (!WebIPCOperator.getInstance().isServiceClientBinded()) {
      WebIPCOperator.getInstance().getClient().doBindService(getApplicationContext());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    D -= 1;
    super.doOnDestroy();
    if (D == 0) {
      WebIPCOperator.getInstance().getClient().doUnbindService(getApplicationContext());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 4, null);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = null;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_b_of_type_AndroidOsHandler != null)) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
    }
    this.l = true;
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.c();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i1 = -1;
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getExtras().getBoolean("fromNotification", false)) {}
    int i2;
    do
    {
      return;
      if (!"actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) {
        break;
      }
      i2 = paramIntent.getIntExtra("requestCode", -1);
    } while (i2 <= 10000);
    if (paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {}
    for (;;)
    {
      int i3 = (i2 - 10000) / 1000;
      byte b1 = (byte)((i2 - 10000) % 1000);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(i3);
      if (localObject == null) {
        break;
      }
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, b1, i1);
      return;
      this.d_ = 0;
      localObject = paramIntent.getDataString();
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl((String)localObject);
        return;
      }
      a(paramIntent);
      k();
      return;
      i1 = 0;
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 6, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient.onHideCustomView();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onPause();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a())) {
      p();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    Intent localIntent = new Intent("tencent.notify.foreground");
    localIntent.putExtra("selfuin", this.J);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 5, null);
    }
    if (MyAppApi.d()) {
      MyAppApi.a().a(this);
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.putExtra("selfuin", this.J);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
  }
  
  public boolean e()
  {
    return super.e();
  }
  
  protected void e_()
  {
    super.e_();
    if (QLog.isColorLevel()) {
      QLog.d("baseactivity", 2, "QQBrowserActivity.uin=" + this.J);
    }
    if ((!q) && (this.jdField_p_of_type_Boolean) && (!TextUtils.isEmpty(this.J)) && (GesturePWDUtils.getGesturePWDState(this, this.J) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.J) == 21)) {
      B();
    }
  }
  
  public String f()
  {
    return this.U;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData("<a></a>", "text/html", "utf-8");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 7, null);
    }
    super.finish();
    if (this.jdField_d_of_type_Boolean) {
      overridePendingTransition(0, 2130968590);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 8, null);
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setOnTouchListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient = new QQBrowserActivity.NativeChromeClient(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = new WebViewPluginEngine(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setDrawingCacheEnabled(true);
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
    String str2;
    String str1;
    Object localObject2;
    Object localObject1;
    if (localWebSettings != null)
    {
      if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("enable_cache_a", Boolean.valueOf(false)).booleanValue()) {
        localWebSettings.setCacheMode(2);
      }
      str2 = a();
      str1 = localWebSettings.getUserAgentString();
      Object localObject3 = getIntent();
      localObject2 = QZoneHelper.a();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Intent)localObject3).getStringExtra("url");
        localObject1 = localObject2;
        if (localObject3 != null) {
          if ((!((String)localObject3).startsWith("http://web.qun.qq.com/mannounce")) && (!((String)localObject3).startsWith("http://admin.qun.qq.com/mcreatev2")) && (!((String)localObject3).startsWith("http://en.qq.com/qqiGroupAnnounceRedirect.php")))
          {
            localObject1 = localObject2;
            if (!((String)localObject3).startsWith("http://en.qq.com/qqiGroupCreate.php")) {}
          }
          else
          {
            localObject1 = "V1_AND_SQ_5.0.0_1_RDM_B";
          }
        }
      }
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      localObject2 = new StringBuilder((String)localObject2).append(" ").append((String)localObject1);
      if (!TextUtils.isEmpty(str2)) {
        break label631;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localWebSettings.setUserAgentString((String)localObject1 + " " + "QQ/" + "5.0.0" + "." + "6602" + "." + AppSetting.a(this));
      localWebSettings.setSaveFormData(false);
      localWebSettings.setSavePassword(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setSupportZoom(false);
      localWebSettings.setAllowFileAccessFromFileURLs(false);
      localWebSettings.setAllowUniversalAccessFromFileURLs(false);
      if (Build.VERSION.SDK_INT >= 21) {
        localWebSettings.setMixedContentMode(0);
      }
      if (this.x >= 8) {
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
      }
      localWebSettings.setPluginsEnabled(true);
      if (1 == this.jdField_b_of_type_Int)
      {
        localWebSettings.setCacheMode(2);
        label429:
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setSavePassword(false);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        str1 = MobileQQ.getMobileQQ().getProcessName();
        localObject2 = "";
        localObject1 = localObject2;
        if (str1 != null)
        {
          int i1 = str1.lastIndexOf(':');
          localObject1 = localObject2;
          if (i1 > -1) {
            localObject1 = "_" + str1.substring(i1);
          }
        }
        localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject1, 0).getPath());
        localWebSettings.setDomStorageEnabled(true);
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("searchBoxJavaBridge_");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("accessibility");
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("accessibilityTraversal");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.requestFocus();
        label607:
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setDownloadListener(new dbo(this));
        return;
        label631:
        localObject1 = " " + str2;
        continue;
        if (4 != this.jdField_b_of_type_Int) {
          break label429;
        }
        localWebSettings.setCacheMode(0);
      }
      catch (Exception localException)
      {
        break label607;
      }
    }
  }
  
  public void h()
  {
    this.f.setVisibility(8);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.d();
    }
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView = b();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.J = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    if ((this.y & 0x10000) != 0)
    {
      WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
      if (localWebSettings != null) {
        localWebSettings.setCacheMode(2);
      }
    }
    l_();
    if (this.jdField_m_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd = new Ad(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 3, null)) {}
    CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getContext());
    CookieSyncManager.getInstance().sync();
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, WebViewPlugin.EVENT_BEFORE_LOAD, null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.I);
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0))
    {
      this.S = this.jdField_d_of_type_JavaLangString;
      return;
    }
    this.S = this.I;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void l_() {}
  
  public void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void n() {}
  
  protected void o() {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.S);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
                {
                  f();
                  p();
                  return;
                }
                if (paramView != this.jdField_c_of_type_AndroidWidgetImageView) {
                  break;
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 13, null)));
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goForward();
              p();
              return;
              if (paramView != this.jdField_e_of_type_AndroidWidgetImageView) {
                break;
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl()))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.reload();
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(null);
                this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                return;
              }
              paramView = d();
            } while (TextUtils.isEmpty(paramView));
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramView);
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            return;
            if (paramView != this.f) {
              break;
            }
            r();
          } while (!a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl(), true));
          finish();
          return;
          if ((paramView == this.jdField_p_of_type_AndroidWidgetImageView) || (paramView == this.jdField_n_of_type_AndroidWidgetTextView))
          {
            if (this.W != null)
            {
              a(this.W, new String[] { "" });
              return;
            }
            j();
            return;
          }
          if (paramView != this.jdField_m_of_type_AndroidWidgetTextView) {
            break;
          }
          if (this.jdField_b_of_type_Int == 5)
          {
            paramView = this.jdField_m_of_type_AndroidWidgetTextView.getText().toString();
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
            return;
          }
          if (this.W != null)
          {
            a(this.W, new String[] { "" });
            return;
          }
        } while (!this.jdField_c_of_type_Boolean);
        onBackPressed();
        return;
        if (paramView != this.jdField_k_of_type_AndroidWidgetTextView) {
          break;
        }
      } while (((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 12, null))) || (this.jdField_b_of_type_Int != 5));
      paramView = this.jdField_k_of_type_AndroidWidgetTextView.getText().toString();
      if (paramView.equals(getIntent().getStringExtra("leftViewText")))
      {
        onBackPressed();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
      return;
      if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
      {
        a(e(), false);
        return;
      }
    } while (paramView != this.jdField_g_of_type_AndroidWidgetImageView);
    Object localObject = "";
    paramView = (View)localObject;
    if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null)
    {
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null)
      {
        paramView = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        if (!PackageUtil.a(this, paramView.packName.get())) {
          break label561;
        }
        PackageUtil.a(this, paramView.packName.get(), null);
      }
    }
    for (paramView = "run";; paramView = "setup")
    {
      Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "", "webviewsourceclick", AppShareIDUtil.b(this.jdField_e_of_type_Long), 0L, paramView);
      return;
      label561:
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.J);
      ((Bundle)localObject).putString("sid", this.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject).putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ.WEBVIEW");
      ((Bundle)localObject).putBoolean("autoDownload", true);
      ((Bundle)localObject).putString("packageName", paramView.packName.get());
      AppClient.a(this, String.valueOf(AppShareIDUtil.b(this.jdField_e_of_type_Long)), 2470, (Bundle)localObject);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      setRequestedOrientation(1);
    }
    int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a())) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.f();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView != null) && (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView != null))
    {
      if (i1 >= this.F) {
        break label99;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (i1 < this.E)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      label99:
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowser", 2, "onQQBrowserCreate() time = " + System.currentTimeMillis());
    }
    super.onCreate(paramBundle);
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if (("Xiaomi_MI 2".equals(paramBundle)) && (this.x == 16))
    {
      this.j = true;
      if (this.jdField_b_of_type_AndroidOsHandler == null) {
        this.jdField_b_of_type_AndroidOsHandler = new Handler();
      }
    }
    if ((this.x > 10) && (!"Meizu_M040".equals(paramBundle))) {
      getWindow().addFlags(16777216);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearView();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.destroy();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      super.onDetachedFromWindow();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser", 2, "onDetachedFromWindow exception : " + String.valueOf(localException));
        }
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("QQBrowser", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label58;
      }
    }
    label58:
    int i1;
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      i1 = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.l;
      paramAdapterView = e();
      if (i1 == 1)
      {
        ((ClipboardManager)getSystemService("clipboard")).setText(paramAdapterView);
        QRUtils.a(2, 2131560522);
        return;
      }
      if (i1 == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
        }
        for (;;)
        {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
        }
      }
      if (i1 == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
        paramAdapterView.putExtra("normal", true);
        try
        {
          startActivity(paramAdapterView);
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131560541);
          }
        }
      }
      if (i1 == 5)
      {
        a(paramAdapterView, true);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
        return;
      }
      if (i1 == 3)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
        }
        for (;;)
        {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
          return;
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 2, false);
        }
      }
      if (i1 == 6)
      {
        a(paramAdapterView, true);
        return;
      }
    } while ((i1 != 9) && (i1 != 10));
    paramInt = -1;
    if (!WXShareHelper.a().a()) {
      paramInt = 2131561422;
    }
    while (paramInt != -1)
    {
      QRUtils.a(0, paramInt);
      return;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131561461;
      }
    }
    if (i1 == 9)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
    for (;;)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = e();
    int i1;
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 16908332: 
      for (;;)
      {
        return super.onOptionsItemSelected(paramMenuItem);
        localObject = d();
        if ((localObject != null) && (((String)localObject).startsWith("http://en.qq.com/qqiGroupCreate.php")) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener.jdField_a_of_type_JavaLangString != ""))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$TopBarBtnClickListener.jdField_a_of_type_JavaLangString, new String[] { "" });
          return true;
        }
        if (this.I.contains("ti.qq.com/adyen/index")) {
          setResult(2002);
        }
      }
    case 2131231380: 
      this.jdField_m_of_type_AndroidWidgetTextView.performClick();
      return true;
    case 1000: 
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 1, false);
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 1, false);
      }
    case 1001: 
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 2, false);
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 2, false);
      }
    case 1002: 
      if (!WXShareHelper.a().a()) {
        i1 = 2131561422;
      }
      break;
    }
    for (;;)
    {
      if (i1 != -1)
      {
        QRUtils.a(0, i1);
        break;
        if (WXShareHelper.a().b()) {
          break label726;
        }
        i1 = 2131561461;
        continue;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 3, true);
      }
      for (;;)
      {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 3, true);
      }
      if (!WXShareHelper.a().a()) {
        i1 = 2131561422;
      }
      for (;;)
      {
        for (;;)
        {
          if (i1 != -1)
          {
            QRUtils.a(0, i1);
            break;
            if (WXShareHelper.a().b()) {
              break label721;
            }
            i1 = 2131561461;
            continue;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 4, true);
          }
          for (;;)
          {
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
            break;
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject, 4, true);
          }
          a((String)localObject, true);
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
          break;
          localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
          ((Intent)localObject).putExtra("normal", true);
          try
          {
            startActivity((Intent)localObject);
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            for (;;)
            {
              QRUtils.a(1, 2131560541);
            }
          }
        }
        a(localActivityNotFoundException, true);
        break;
        ((ClipboardManager)getSystemService("clipboard")).setText(localActivityNotFoundException);
        QRUtils.a(2, 2131560522);
        break;
        label721:
        i1 = -1;
      }
      label726:
      i1 = -1;
    }
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.I, 17, null);
    }
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    Object localObject;
    if ((this.jdField_p_of_type_AndroidWidgetImageView != null) && (this.jdField_p_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_p_of_type_AndroidWidgetImageView.getDrawable() != null))
    {
      localObject = this.jdField_p_of_type_AndroidWidgetImageView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer))) {}
      switch (((Integer)localObject).intValue())
      {
      default: 
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break;
        }
      }
    }
    for (boolean bool = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d();; bool = false)
    {
      if (bool) {
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1000, 0, getString(2131560568)), 0);
      }
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 1005, 0, getString(2131560571)), 0);
      if (bool) {
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1006, 0, getString(2131560581)), 0);
      }
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 1007, 0, getString(2131560570)), 0);
      if ((this.jdField_m_of_type_AndroidWidgetTextView != null) && (this.jdField_m_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_m_of_type_AndroidWidgetTextView.getText() != null) && (!this.jdField_m_of_type_AndroidWidgetTextView.getText().toString().equals("")))
      {
        localObject = paramMenu.findItem(this.jdField_m_of_type_AndroidWidgetTextView.getId());
        if (localObject == null) {
          break label350;
        }
        ((MenuItem)localObject).setTitle(this.jdField_m_of_type_AndroidWidgetTextView.getText());
        paramMenu = (Menu)localObject;
      }
      for (;;)
      {
        paramMenu.setEnabled(this.jdField_m_of_type_AndroidWidgetTextView.isEnabled());
        return true;
        paramMenu = paramMenu.add(0, 2131231461, 0, "");
        paramMenu.setIcon(2130838522);
        MenuItemCompat.setShowAsAction(paramMenu, 1);
        return true;
        paramMenu = paramMenu.add(0, 2131231461, 0, "");
        paramMenu.setIcon(2130839739);
        MenuItemCompat.setShowAsAction(paramMenu, 1);
        return true;
        label350:
        paramMenu = paramMenu.add(0, this.jdField_m_of_type_AndroidWidgetTextView.getId(), 0, this.jdField_m_of_type_AndroidWidgetTextView.getText());
        MenuItemCompat.setShowAsAction(paramMenu, 1);
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    getSupportActionBar().show();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public boolean showPreview()
  {
    b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */