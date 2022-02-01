package com.tencent.mobileqq.webview.swift;

import acfp;
import acly;
import affz;
import afjy;
import ahwy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import anpc;
import anpo;
import anpo.a;
import aqez;
import aqij;
import aqqu;
import aqzg;
import aqzl;
import aqzw;
import aqzx;
import aqzy;
import aqzz;
import araa;
import arab;
import arac;
import arad;
import arae;
import araf;
import aran;
import arar;
import araw;
import araz;
import araz.d;
import araz.e;
import arbf;
import arbk;
import arbo;
import arbs;
import arbt;
import arbz;
import arbz.b;
import arcb;
import arcd;
import arcd.a;
import arci;
import arcj;
import arcj.b;
import arcn;
import arcn.a;
import arcp;
import arcu;
import ardk;
import ardm.b;
import ardm.c;
import ardm.f;
import ardm.i;
import ardm.k;
import ardm.l;
import ardm.n;
import ardm.o;
import arju;
import arts;
import aviz;
import avug;
import avzl;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.ui.CustomScrollView.a;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.haoliyou.JefsClass.a;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.a;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jll;
import jml;
import jnl;
import jpu;
import jqc;
import jqo;
import kdl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import ocp;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import svi;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;
import tzd;
import tzf;
import ubu;
import wis;
import wja;
import zxs;

public class WebViewFragment
  extends ReportV4Fragment
  implements View.OnClickListener, View.OnTouchListener, aqzw, aran, araz.d, araz.e, ardm.b, ardm.c, ardm.f, ardm.i, ardm.k, ardm.l, ardm.n, ardm.o, CustomScrollView.a, SwiftBrowserCookieMonster.a
{
  public static int bJl;
  View.OnTouchListener C = new arab(this);
  public boolean Fg;
  public View Js;
  public aqzl a;
  arar jdField_a_of_type_Arar;
  public final araz a;
  public arbs a;
  public arbz a;
  public arcd.a a;
  public arcd a;
  protected final arci a;
  private JefsClass.a jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a;
  protected SonicClientImpl a;
  public WebBrowserViewContainer a;
  public svi a;
  protected boolean aMT;
  boolean aMU;
  boolean aMX = false;
  public int aNf = 1;
  public String aTX = "";
  public int appId;
  protected jml authConfig;
  protected boolean avR;
  public String awT = "";
  int bQX = 0;
  public BrowserAppInterface browserApp;
  int byW;
  int byX;
  public Client.b c;
  boolean cXr = false;
  public boolean cXs;
  protected boolean cXt;
  boolean cXu = true;
  FrameLayout customContainer;
  IX5WebChromeClient.CustomViewCallback customViewCallback;
  String cyM = "";
  public String cyN = "";
  public String cyO;
  public String cyP;
  public String cyQ;
  public String cyR;
  public String cyS;
  public String cyT;
  public int edX;
  public int edY;
  public int edZ;
  protected long iJ;
  public Intent intent;
  public boolean isDestroyed;
  public TouchWebView j;
  View lr;
  public boolean mActNeedImmersive = true;
  public volatile AppInterface mApp;
  protected jpu mFileChooserHelper;
  public MiniMsgUser mMiniMsgUser;
  public boolean mNeedStatusTrans = true;
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  public String mUrl;
  public String msgid = "";
  View qI;
  protected final Object sInitEngineLock = new Object();
  public String toUin = "";
  public String uin;
  public int uinType;
  protected volatile boolean zT;
  
  public WebViewFragment()
  {
    this.jdField_a_of_type_Araz = a();
    this.jdField_a_of_type_Arci = new arci(new aqzx(this));
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new WebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
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
      paramContext = jqc.a(paramContext, paramString1, "POST", localBundle, paramString2);
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
  
  private void egL()
  {
    if (this.jdField_a_of_type_Arcd$a.a == null)
    {
      int i = this.jdField_a_of_type_Aqzl.aK.getPaddingTop();
      int k = this.jdField_a_of_type_Aqzl.aK.getPaddingBottom();
      int m = this.jdField_a_of_type_Aqzl.aK.getPaddingLeft();
      int n = this.jdField_a_of_type_Aqzl.aK.getPaddingRight();
      this.jdField_a_of_type_Aqzl.aK.setBackgroundDrawable(super.getResources().getDrawable(2130851105));
      this.jdField_a_of_type_Aqzl.aK.setPadding(m, i, n, k);
      return;
    }
    this.jdField_a_of_type_Aqzl.aK.setBackgroundColor(this.jdField_a_of_type_Arcd$a.a.wP);
    this.jdField_a_of_type_Aqzl.Yh(this.jdField_a_of_type_Arcd$a.a.titleColor);
    this.jdField_a_of_type_Aqzl.Yj(this.jdField_a_of_type_Arcd$a.a.edP);
  }
  
  private void egQ()
  {
    long l;
    int i;
    if (this.jdField_a_of_type_Arbz.isWebViewCache)
    {
      l = 2L;
      if (!(this.j instanceof SwiftReuseTouchWebView)) {
        break label159;
      }
      if (1 != ((SwiftReuseTouchWebView)this.j).flag) {
        break label154;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(arcn.a.avr) }));
      }
      System.currentTimeMillis();
      JSONObject localJSONObject = this.j.reportInitPerformance(l, i, this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, arcn.a.avr);
      this.jdField_a_of_type_Arbz.bW(localJSONObject);
      System.currentTimeMillis();
      this.jdField_a_of_type_Arbz.auN = SystemClock.elapsedRealtime();
      return;
      if (arbz.aeo) {}
      for (i = 1;; i = 0)
      {
        l = i;
        break;
      }
      label154:
      i = 0;
      continue;
      label159:
      i = 0;
    }
  }
  
  public int A(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_load_url");
    this.jdField_a_of_type_Arbz.Wg("state_load_url");
    long l1 = System.currentTimeMillis();
    jqo.le("Web_qqbrowser_init");
    aCP();
    jqo.lf("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_Arbz.initTime = (l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "init param and load url, cost = " + this.jdField_a_of_type_Arbz.initTime);
    }
    jqo.lf("Web_qqbrowser_state_machine_load_url");
    this.aNf = 64;
    return 0;
  }
  
  public int B(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_bottombar");
    this.jdField_a_of_type_Arcd.w(getIntent(), this.mUrl);
    this.jdField_a_of_type_Arcd.ehj();
    this.aNf = 1024;
    jqo.lf("Web_qqbrowser_state_machine_init_bottombar");
    if (this.j == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  public String CE()
  {
    String str2 = this.intent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.intent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public String CF()
  {
    return this.msgid;
  }
  
  public String CG()
  {
    return this.awT;
  }
  
  public String CH()
  {
    return this.aTX;
  }
  
  public String CI()
  {
    return this.mRedirect302Url;
  }
  
  public void E(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.ce = paramJSONObject;
    }
    this.jdField_a_of_type_Arcd.d(paramJSONObject, true);
  }
  
  protected boolean Nk()
  {
    if (this.j != null)
    {
      if ((this.jdField_a_of_type_Aqzl.a != null) && (this.jdField_a_of_type_Aqzl.a.cXk))
      {
        this.j.callJs4OpenApi(this.jdField_a_of_type_Aqzl.a, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aqzl.GY))
      {
        this.j.callJs(this.jdField_a_of_type_Aqzl.GY, new String[] { "" });
        return true;
      }
      if (this.jdField_a_of_type_Aqzl.h != null)
      {
        ubu.b(this.jdField_a_of_type_Aqzl.h, tzf.EMPTY);
        return true;
      }
    }
    return false;
  }
  
  public void QK() {}
  
  public void Qq()
  {
    arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
    if (localarbt != null) {
      localarbt.a(a(), this.jdField_a_of_type_Arcd$a.gK);
    }
  }
  
  public void Td(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aqzl.Td(paramBoolean);
    ((arbt)this.jdField_a_of_type_Araz.q(4)).ehb();
    this.jdField_a_of_type_Arcd.ehp();
  }
  
  public void Tk(boolean paramBoolean)
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getActivity().getWindow().addFlags(67108864);
      if (this.mActNeedImmersive) {
        if (this.Js == null)
        {
          this.Js = new View(super.getActivity());
          if (this.jdField_a_of_type_Arcd$a.a == null) {
            break label246;
          }
          this.Js.setBackgroundColor(this.jdField_a_of_type_Arcd$a.a.statusBarColor);
          anlm.a(true, this.jdField_a_of_type_Arcd$a.a.statusBarColor, getHostActivity().getWindow());
        }
      }
    }
    for (;;)
    {
      if (this.Js.getParent() == null)
      {
        if (paramBoolean)
        {
          localObject = new View(super.getActivity());
          ((View)localObject).setId(2131365391);
          ((View)localObject).setBackgroundColor(-16777216);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
          localLayoutParams.addRule(10, -1);
          this.jdField_a_of_type_Arcd.mRootView.addView((View)localObject, localLayoutParams);
        }
        Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        this.jdField_a_of_type_Arcd.mRootView.addView(this.Js, (ViewGroup.LayoutParams)localObject);
      }
      ImmersiveUtils.clearCoverForStatus(getHostActivity().getWindow(), true);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        ImmersiveUtils.setStatusTextColor(true, getHostActivity().getWindow());
      }
      return;
      label246:
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.Js.setBackgroundResource(2130851106);
      }
      else
      {
        this.Js.setBackgroundColor(getResources().getColor(2131167361));
        anlm.a(false, getResources().getColor(2131167361), getHostActivity().getWindow());
      }
    }
  }
  
  public void Tl(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_Aqzl.aK;
    if (localViewGroup == null) {}
    int k;
    do
    {
      return;
      k = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296723);
      if (paramBoolean) {
        break;
      }
      ks(k, 0);
      localViewGroup.setVisibility(8);
    } while (this.Js == null);
    this.Js.setVisibility(8);
    this.jdField_a_of_type_Arcd.mRootView.findViewById(2131365391).setVisibility(8);
    return;
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; i = 0)
    {
      if (this.jdField_a_of_type_Arcd$a.cYx) {
        k += i;
      }
      for (;;)
      {
        ks(k, i);
        localViewGroup.setVisibility(0);
        if (this.Js == null) {
          break;
        }
        this.Js.setVisibility(0);
        this.jdField_a_of_type_Arcd.mRootView.findViewById(2131365391).setVisibility(0);
        return;
        k += i * 2;
        i += BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299634);
      }
    }
  }
  
  public void Tm(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Arcd != null) && ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_Arcd.eQ).qu(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForJS enable=" + paramBoolean);
    }
  }
  
  public void Tn(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Arcd != null) && ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_Arcd.eQ).qv(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForHost enable=" + paramBoolean);
    }
  }
  
  public void To(boolean paramBoolean)
  {
    this.jdField_a_of_type_Arcd$a.cYs = paramBoolean;
  }
  
  public void Tp(boolean paramBoolean)
  {
    this.mNeedStatusTrans = paramBoolean;
  }
  
  public void Tq(boolean paramBoolean)
  {
    this.mActNeedImmersive = paramBoolean;
  }
  
  public void Yh(int paramInt)
  {
    this.jdField_a_of_type_Aqzl.Yh(paramInt);
  }
  
  public void Yj(int paramInt)
  {
    this.jdField_a_of_type_Aqzl.Yj(paramInt);
  }
  
  public int a(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_FINAL");
    jqo.le("Web_IPCSetup");
    if (!afjy.a().ajq()) {
      afjy.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    jqo.lf("Web_IPCSetup");
    if ((this.jdField_a_of_type_Arcd$a.gK & 0x400000) > 0L)
    {
      SosoInterface.a(new arae(this, 0, false, false, 600000L, false, false, "webview"));
      SosoInterface.a(new araf(this, 0, true, false, 600000L, false, false, "webview"));
    }
    ThreadManager.getUIHandler().postDelayed(new WebViewFragment.8(this), 3000L);
    ThreadManager.executeOnSubThread(new WebViewFragment.9(this));
    arcj.a().a(new aqzy(this, 2));
    jqo.lf("Web_qqbrowser_state_machine_init_FINAL");
    jqo.lf("Web_qqbrowser_state_machine_all");
    this.aNf = 1;
    egQ();
    return -1;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return switchRequestCode(paramWebViewPlugin, paramByte);
  }
  
  public Intent a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      if (getActivity() == null) {
        return null;
      }
      localIntent.setClass(getActivity(), SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("fragment_id", 1);
      if (paramBundle.containsKey("banner_activityName"))
      {
        localIntent.putExtra("banner_activityName", paramBundle.getString("banner_activityName"));
        if (paramBundle.containsKey("banner_activityFlag")) {
          localIntent.putExtra("banner_activityFlag", paramBundle.getInt("banner_activityFlag"));
        }
        if (!paramBundle.containsKey("banner_webViewUrl")) {
          break label285;
        }
        localIntent.putExtra("banner_webViewUrl", paramBundle.getString("banner_webViewUrl"));
        label144:
        if (!paramBundle.containsKey("banner_wording")) {
          break label311;
        }
        localIntent.putExtra("banner_wording", paramBundle.getString("banner_wording"));
        label170:
        if (!paramBundle.containsKey("banner_businessCategory")) {
          break label479;
        }
        localIntent.putExtra("banner_businessCategory", paramBundle.getString("banner_businessCategory"));
        label196:
        if (!paramBundle.containsKey("banner_webview_extra")) {
          break label539;
        }
      }
      label539:
      for (paramBundle = paramBundle.getBundle("banner_webview_extra");; paramBundle = new Bundle())
      {
        if ((this.j.getView() != null) && (this.j.getView().getScrollY() > 0)) {
          paramBundle.putInt("AIO_Scroll_Y", this.j.getView().getScrollY());
        }
        localIntent.putExtra("banner_webview_extra", paramBundle);
        return localIntent;
        localIntent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
        break;
        label285:
        if (TextUtils.isEmpty(this.mUrl)) {
          break label144;
        }
        localIntent.putExtra("banner_webViewUrl", this.mUrl);
        break label144;
        label311:
        Object localObject = this.j.getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).trim();
          label331:
          String str = arcp.getSchemeFromUrl((String)localObject);
          if ((!"http".equals(str)) && (!"https".equals(str)) && (!"data".equals(str)) && (!"file".equals(str)) && (!((String)localObject).startsWith("about")) && (!((String)localObject).startsWith("base64"))) {
            break label456;
          }
        }
        label456:
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (((String)localObject).length() <= 1)) {
            break label461;
          }
          localIntent.putExtra("banner_wording", String.format(acfp.m(2131716908), new Object[] { this.j.getTitle() }));
          break;
          localObject = "";
          break label331;
        }
        label461:
        localIntent.putExtra("banner_wording", acfp.m(2131716909));
        break label170;
        label479:
        if (TextUtils.isEmpty(this.mUrl)) {
          break label196;
        }
        localObject = Uri.parse(this.mUrl);
        if (!((Uri)localObject).isHierarchical()) {
          break label196;
        }
        localIntent.putExtra("banner_businessCategory", "WebView_" + ((Uri)localObject).getHost());
        break label196;
      }
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
    return null;
  }
  
  public final arar a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    boolean bool1;
    TouchWebView localTouchWebView;
    if ((this.jdField_a_of_type_Arcd$a.Ds & 0x40) != 0L)
    {
      bool1 = true;
      localTouchWebView = c();
      if (localTouchWebView != null) {
        break label201;
      }
    }
    label201:
    for (this.jdField_a_of_type_Arar = new araw(this.mApp, super.getActivity(), this, this.intent, bool1);; this.jdField_a_of_type_Arar = new araw(this.mApp, super.getActivity(), this, this.intent, localTouchWebView))
    {
      this.jdField_a_of_type_Arar.setSonicClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      localTouchWebView = this.jdField_a_of_type_Arar.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.mPluginEngine.e(localTouchWebView);
      localTouchWebView.setPluginEngine(this.mPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        arbz localarbz = this.jdField_a_of_type_Arbz;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).flag) {
          bool1 = true;
        }
        localarbz.cXY = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.aMX = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.avR) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Arar;
      bool1 = false;
      break;
    }
  }
  
  public araz a()
  {
    return new araz(this, 127, null);
  }
  
  protected MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new arac(this);
  }
  
  public WebViewFragment a()
  {
    return this;
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if ("handleImage".equals(paramString))
    {
      localObject = (arbf)this.jdField_a_of_type_Araz.q(8);
      if (localObject != null) {
        return Boolean.valueOf(((arbf)localObject).aGd());
      }
    }
    Object localObject = (arcb)this.jdField_a_of_type_Araz.q(16);
    if (localObject != null) {
      return ((arcb)localObject).a(paramString, paramBundle);
    }
    return null;
  }
  
  protected svi a()
  {
    if (this.jdField_a_of_type_Svi == null) {
      this.jdField_a_of_type_Svi = new svi(this.mApp, super.getActivity());
    }
    return this.jdField_a_of_type_Svi;
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 82: 
      dispatchPluginEvent(8589934607L, null);
      return;
    case 25: 
      dispatchPluginEvent(8589934608L, null);
      return;
    }
    dispatchPluginEvent(8589934609L, null);
  }
  
  void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(this.mUrl));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(BaseApplicationImpl.getApplication(), jnl.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    this.mApp.startServlet(paramString);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    super.startActivity(paramIntent);
  }
  
  public void a(WebView paramWebView, SslError paramSslError)
  {
    if (arbz.cYa) {
      this.jdField_a_of_type_Arbz.i("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, String.valueOf(paramSslError.getPrimaryError()));
    }
    avug.a().a(this.mUrl, 132, System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, String.valueOf(paramSslError.getPrimaryError()), this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
  }
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onSetCookieFinish ", paramString, " " + paramLong });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, tzd paramtzd)
  {
    this.jdField_a_of_type_Aqzl.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramtzd);
    ((arbt)this.jdField_a_of_type_Araz.q(4)).ehb();
    this.jdField_a_of_type_Arcd.ehp();
  }
  
  public boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (this.mFileChooserHelper == null) {
      this.mFileChooserHelper = new jpu();
    }
    return this.mFileChooserHelper.onShowFileChooser(super.getActivity(), 0, paramValueCallback, paramFileChooserParams);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    boolean bool1 = bool2;
    long l;
    if (super.getActivity().isResume()) {
      if (System.currentTimeMillis() - this.iJ >= 1000L)
      {
        bool1 = bool2;
        if (!this.authConfig.a(paramWebView.getUrl(), (String)localObject2).booleanValue()) {}
      }
      else
      {
        l = System.currentTimeMillis();
        bool1 = zxs.a().a(paramString, this);
        QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool1 + " cost:" + (System.currentTimeMillis() - l) + " ms.");
        if (!bool1) {
          break label133;
        }
        bool1 = true;
      }
    }
    return bool1;
    label133:
    localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    for (;;)
    {
      try
      {
        ((Intent)localObject2).putExtra("url", getCurrentUrl());
        ActivityInfo localActivityInfo = ((Intent)localObject2).resolveActivityInfo(getActivity().getPackageManager(), 0);
        localObject1 = "";
        if (localActivityInfo != null) {
          localObject1 = localActivityInfo.packageName;
        }
        acly.j("scheme", paramWebView.getUrl(), (String)localObject1, "1", "web", getActivity().getClass().getName());
        paramWebView = getIntent();
        bool1 = paramWebView.getBooleanExtra("h5_ark_is_from_share", false);
        l = paramWebView.getLongExtra("appShareID", -1L);
        ((Intent)localObject2).putExtra("h5_ark_is_from_share", bool1);
        ((Intent)localObject2).putExtra("appShareID", l);
        if (this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a.dqC();
        }
      }
      catch (Exception paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
        continue;
      }
      try
      {
        bool2 = getIntent().getBooleanExtra("keyForForceCloseAfterJump", false);
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a = JefsClass.getInstance().a(getActivity(), (Intent)localObject2, paramString, new WebViewFragment.15(this, (Intent)localObject2, bool2, (String)localObject1, bool1, l));
        return true;
      }
      catch (Throwable paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, paramWebView, new Object[0]);
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return a().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return a().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  protected void aBA() {}
  
  public void aBB()
  {
    if (this.j == null) {}
    for (Object localObject = null;; localObject = this.j.getPluginEngine())
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).handleEvent(this.mUrl, 8589934598L, null);
      }
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).handleEvent(this.mUrl, 8589934599L, null);
      }
      if (this.intent.getBooleanExtra("flow_key_from_guide", false))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(BaseApplicationImpl.getApplication(), SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", MainFragment.bIk);
        ((Intent)localObject).addFlags(67108864);
        super.startActivity((Intent)localObject);
      }
      return;
    }
  }
  
  public void aCP()
  {
    jqo.le("Web_readyToLoadUrl");
    if (this.j == null) {
      return;
    }
    aBA();
    if ((this.jdField_a_of_type_Arbz.cXQ) && (this.jdField_a_of_type_Arbz.auw > 0L))
    {
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Arbz.auw) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Arbz.flag);
      this.jdField_a_of_type_Arbz.auw = 0L;
    }
    this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl;
    l = this.jdField_a_of_type_Arbz.mClickTime;
    if (aqij.a().lk(this.mUrl))
    {
      this.j.loadUrl("file:///android_asset/error.html");
      QLog.d("WebLog_WebViewFragment", 1, new Object[] { "url:", this.mUrl, "in black" });
    }
    for (;;)
    {
      jqo.lf("Web_readyToLoadUrl");
      this.jdField_a_of_type_Arbz.a(this.j, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.j.loadUrl(this.mUrl);
      }
    }
  }
  
  public boolean aGa()
  {
    return this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl;
  }
  
  public boolean aGb()
  {
    return this.aMT;
  }
  
  public int b(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    jqo.le("Web_qqbrowser_state_machine_init_titlebar");
    d(this.intent, this.mUrl);
    this.jdField_a_of_type_Arcd.ehk();
    egK();
    paramBundle = this.intent.getExtras();
    if (paramBundle != null)
    {
      this.uinType = paramBundle.getInt("uin_type");
      this.awT = paramBundle.getString("puin");
      this.msgid = paramBundle.getString("msg_id");
      if (this.msgid == null) {
        this.msgid = "";
      }
      this.aTX = paramBundle.getString("source_puin");
      if (this.aTX == null) {
        this.aTX = "";
      }
      this.toUin = paramBundle.getString("friendUin");
      if (this.toUin == null) {
        this.toUin = "";
      }
      boolean bool = paramBundle.getBoolean("isOpeningQunApp");
      this.appId = paramBundle.getInt("appid");
      this.edX = paramBundle.getInt("troopid");
      String str = paramBundle.getString("extraParams");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        if (arcp.aGj()) {
          break label285;
        }
        this.jdField_a_of_type_Aqzl.leftView.setText(super.getResources().getString(2131721059));
      }
    }
    for (;;)
    {
      a(this.appId, paramBundle, new arad(this));
      this.aNf = 512;
      ((arbt)b().q(4)).ehb();
      jqo.lf("Web_qqbrowser_state_machine_init_titlebar");
      this.jdField_a_of_type_Arbz.auR = (SystemClock.elapsedRealtime() - l);
      return 1;
      label285:
      if (this.jdField_a_of_type_Aqzl.leftView.getBackground() == null) {
        this.jdField_a_of_type_Aqzl.leftView.setText(super.getResources().getString(2131721059));
      }
    }
  }
  
  public araz b()
  {
    return this.jdField_a_of_type_Araz;
  }
  
  public WebView b()
  {
    return this.j;
  }
  
  public svi b()
  {
    return a();
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.cXr) && (ocp.c(paramString, this.bQX, this.cyM))) {
      this.cXr = true;
    }
  }
  
  void bAF()
  {
    if (!this.zT)
    {
      this.zT = true;
      String str = this.intent.getStringExtra("url");
      if (ardk.rX(str)) {
        ThreadManager.postImmediately(new WebViewFragment.3(this, str), null, false);
      }
    }
  }
  
  public void bVS()
  {
    if (this.mMiniMsgUser == null)
    {
      this.mMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
      this.mMiniMsgUser.onForeground();
    }
  }
  
  public long bg()
  {
    return this.jdField_a_of_type_Arcd$a.gK;
  }
  
  public void biT()
  {
    this.jdField_a_of_type_Arbz.Wg("state_back");
    if (1 != this.aNf)
    {
      this.jdField_a_of_type_Arci.cancel();
      this.aNf = 1;
    }
    if ((TextUtils.isEmpty(this.mUrl)) && (this.j != null)) {
      this.mUrl = this.j.getUrl();
    }
    this.jdField_a_of_type_Arbz.v(getIntent(), this.mUrl);
    this.jdField_a_of_type_Arbz.d(BaseApplicationImpl.getApplication(), this.mUrl, this.intent);
    wis.cl(this.intent);
    if (this.aMU) {
      onHideCustomView();
    }
    HashMap localHashMap;
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.clearHistory();
        }
        localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
      } while (dispatchPluginEvent(8589934601L, localHashMap));
      if ((this.jdField_a_of_type_Arcd$a.cYq) || ((this.jdField_a_of_type_Arcd$a.gK & 0x4) != 0L) || (this.j == null) || (!this.j.canGoBack())) {
        break;
      }
      this.j.stopLoading();
      this.j.goBack();
      localWebViewPluginEngine = this.j.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.handleEvent(this.j.getUrl(), 8589934610L, localHashMap);
    return;
    super.getActivity().finish();
  }
  
  public boolean bw(String paramString)
  {
    return a().bw(paramString);
  }
  
  public TouchWebView c()
  {
    return null;
  }
  
  public void c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl != null)) {
      this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl.c(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public boolean c(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return true;
    }
    jqo.le("urlInterceptManager");
    paramWebView = arcp.getSchemeFromUrl(paramString);
    if ((("http".equals(paramWebView)) || ("data".equals(paramWebView))) && ((super.getActivity() instanceof QQBrowserActivity))) {
      if ((this.browserApp != null) && (this.browserApp.a != null))
      {
        paramWebView = this.browserApp.a.pR(paramString);
        if (paramWebView != null)
        {
          paramString = new Intent(super.getActivity(), JumpActivity.class);
          paramString.setData(Uri.parse(paramWebView));
          paramString.putExtra("from", "webview");
          super.startActivity(paramString);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("WebLog_WebViewFragment", 2, "URLInterceptManager = null");
      }
    }
    jqo.lf("urlInterceptManager");
    return false;
  }
  
  public void d(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_Arcd.d(paramIntent, paramString);
  }
  
  public final void dA(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Arcd$a.cYN) && (paramBundle != null))
    {
      paramBundle = a(paramBundle);
      if (paramBundle != null) {
        startActivity(paramBundle);
      }
      return;
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
  }
  
  void destroyWebView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    arbz localarbz = this.jdField_a_of_type_Arbz;
    this.isDestroyed = true;
    localarbz.isDestroyed = true;
    if (this.jdField_a_of_type_Arar != null)
    {
      this.jdField_a_of_type_Arar.destroy();
      this.jdField_a_of_type_Arar = null;
      this.j = null;
    }
    this.mApp = null;
  }
  
  public boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.j != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.j.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.handleEvent(this.j.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if ((!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        super.getActivity().setResult(-1, paramIntent);
        super.getActivity().finish();
      }
      break;
    }
    label313:
    label578:
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
                aviz.A(super.getActivity(), paramIntent);
                return;
                localObject = paramIntent.getStringExtra("DELETE_BLOG");
                if (this.j != null) {
                  this.j.loadUrl((String)localObject);
                }
                if (paramIntent == null) {
                  break;
                }
                boolean bool2 = paramIntent.getBooleanExtra("click_long_screen_shot", false);
                QLog.d("WebLog_WebViewFragment", 1, "REQUEST_TO_SCREEN_SHOT_PAGE. clickLongScreenShot is " + bool2);
                if ((!bool2) || (this.j == null)) {
                  break;
                }
                QLog.d("WebLog_WebViewFragment", 1, "start screen long shot");
                aqez.a(this.j, new araa(this));
                break;
                if (paramInt1 != 21) {
                  break label313;
                }
                localObject = wja.a(new Intent(super.getActivity(), SplashActivity.class), null);
              } while (paramIntent == null);
              ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
              super.startActivity((Intent)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
              ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
              ((Map)localObject).put("data", paramIntent);
            } while (dispatchPluginEvent(8589934600L, (Map)localObject));
            int i = paramInt1 >> 8 & 0xFF;
            if (i <= 0) {
              break label541;
            }
            if (this.j != null)
            {
              localObject = this.j.getPluginEngine();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).b("card") == null)) {
                  ((WebViewPluginEngine)localObject).aa(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(i, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
          return;
          if ((this.mFileChooserHelper == null) || (!this.mFileChooserHelper.doOnActivityResult(paramInt1, paramInt2, paramIntent))) {
            break label578;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewFragment", 2, "Activity result handled by FileChooserHelper.");
        return;
      } while ((paramInt2 != -1) || (this.j == null));
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (paramIntent == null);
    label541:
    Object localObject = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    this.j.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
    for (;;)
    {
      try
      {
        if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
          break label792;
        }
        this.aMT = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionSucc=" + this.aMT);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
      return;
      label792:
      bool1 = false;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.cXs);
    this.jdField_a_of_type_Araz.P(4, localBundle);
    if (this.j != null) {}
    for (paramConfiguration = this.j.getPluginEngine();; paramConfiguration = null)
    {
      if (paramConfiguration != null) {
        paramConfiguration.handleEvent(this.mUrl, 8589934611L, null);
      }
      return;
    }
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    wis.cj(this.intent);
    Object localObject = (arbk)this.jdField_a_of_type_Araz.q(1);
    if ((localObject != null) && (!((arbk)localObject).ae(this.intent)))
    {
      super.getActivity().finish();
      return true;
    }
    preInitData();
    if (paramBundle != null)
    {
      this.intent.removeExtra("qqBrowserActivityCreateTime");
      this.intent.putExtra("startOpenPageTime", 0L);
      QLog.e("WebLog_WebViewFragment", 1, "doOnCreate mOnCreateMilliTimeStamp = " + this.intent.getLongExtra("qqBrowserActivityCreateTime", -2L));
    }
    this.jdField_a_of_type_Arbz.Wg("state_activity_create");
    this.jdField_a_of_type_Arbz.u(this.intent, this.mUrl);
    bAF();
    if ((this.intent != null) && (!this.intent.getBooleanExtra("key_is_init_sonic_session", true))) {}
    for (boolean bool = false;; bool = rO(CE()))
    {
      this.jdField_a_of_type_Arbz.cXM = bool;
      if (!bool) {
        ThreadManager.post(new WebViewFragment.2(this), 5, null, true);
      }
      jqo.le("Web_qqbrowser_dooncreate");
      this.mActNeedImmersive = false;
      this.mNeedStatusTrans = false;
      anpc.a(BaseApplicationImpl.getApplication(), 10000L);
      this.jdField_a_of_type_Arbz.auU = System.currentTimeMillis();
      this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      this.authConfig = jml.a();
      localObject = this.jdField_a_of_type_Arbz;
      this.isDestroyed = false;
      ((arbz)localObject).isDestroyed = false;
      this.jdField_a_of_type_Arbz.auV = System.currentTimeMillis();
      jqo.le("Web_qqbrowser_state_machine_all");
      this.aNf = 2;
      if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.sPoolSize > 0)) {
        this.jdField_a_of_type_Arci.cFX();
      }
      WebAccelerateHelper.isWebViewCache = true;
      this.jdField_a_of_type_Arci.av(paramBundle);
      paramBundle = new Bundle();
      paramBundle.putString("url", this.mUrl);
      this.jdField_a_of_type_Araz.P(5, paramBundle);
      this.jdField_a_of_type_Arbz.onCreateTime = (System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp);
      jqo.lf("Web_qqbrowser_dooncreate");
      this.jdField_a_of_type_Arbz.auZ = System.currentTimeMillis();
      return true;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = -1;
    int k;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      k = paramIntent.getIntExtra("requestCode", -1);
      int m = k >> 8 & 0xFF;
      if (m > 0) {
        if (this.j != null)
        {
          localObject = this.j.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(m, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label581;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(k & 0xFF), i);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
      }
      this.uin = this.mApp.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        if (this.j == null) {
          break label576;
        }
        localObject = this.j.getPluginEngine();
        if (localObject == null) {
          break label576;
        }
        localObject = ((WebViewPluginEngine)localObject).a(120, true);
        if ((localObject == null) || (!(localObject instanceof BuscardJsPlugin))) {
          break label576;
        }
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
      }
      label576:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          BuscardHelper.a(this.uin, super.getActivity(), paramIntent);
        }
        localObject = new HashMap();
        ((Map)localObject).put("intent", paramIntent);
        dispatchPluginEvent(128L, (Map)localObject);
        if (("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) || ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("fromNotification", false))) {
          break;
        }
        if (paramIntent.getBooleanExtra("keyFromUpdateAvatar", false))
        {
          localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          if (localObject != null)
          {
            paramIntent = new Bundle();
            paramIntent.putString("path", (String)localObject);
            paramIntent = affz.a("ipc_update_avatar", "", 0, paramIntent);
            afjy.a().cr(paramIntent);
            return;
          }
        }
        localObject = paramIntent.getDataString();
        if ((localObject != null) && (this.j != null)) {
          this.j.loadUrl((String)localObject);
        }
        for (;;)
        {
          boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "doOnNewIntent, isPhotoPlusEditSend = " + bool);
          }
          if (!bool) {
            break;
          }
          paramIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break;
          }
          localObject = (String)((ArrayList)localObject).get(0);
          QLog.d("WebLog_WebViewFragment", 2, "editScreenShotBack:" + (String)localObject);
          arbo localarbo = (arbo)this.jdField_a_of_type_Araz.q(64);
          if (localarbo == null) {
            break;
          }
          localarbo.m((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
          return;
          this.intent = paramIntent;
          preInitData();
          this.jdField_a_of_type_Arci.cancel();
          if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
          {
            this.aNf = 2;
            this.jdField_a_of_type_Arci.av(paramIntent.getExtras());
          }
        }
      }
      label581:
      i = 0;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen))
    {
      egN();
      egP();
    }
  }
  
  public void ec(int paramInt, String paramString)
  {
    arcb localarcb = (arcb)this.jdField_a_of_type_Araz.q(16);
    if (localarcb != null) {
      localarcb.ec(paramInt, paramString);
    }
  }
  
  public void egB()
  {
    this.jdField_a_of_type_Aqzl.egB();
  }
  
  protected void egI()
  {
    synchronized (arcn.fE)
    {
      if (WebViewPluginEngine.e != null)
      {
        this.mPluginEngine = WebViewPluginEngine.e;
        WebViewPluginEngine.e = null;
      }
      if (this.mPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "-->web engine and plugin initialized at process preload!");
        }
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, super.getActivity());
        this.mPluginEngine.preCreatePlugin();
        WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, this);
        return;
      }
    }
    this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, super.getActivity(), null, null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, super.getActivity());
    WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, this);
  }
  
  void egJ()
  {
    String str = this.intent.getStringExtra("url");
    if (ardk.rX(str)) {
      WebSoService.Q(getActivity(), str);
    }
  }
  
  public void egK()
  {
    jqo.le("Web_qqbrowser_createtabbar");
    Activity localActivity = getHostActivity();
    if ((localActivity instanceof QQBrowserActivity))
    {
      ((QQBrowserActivity)localActivity).bSM();
      boolean bool1 = ahwy.a().aog();
      boolean bool2 = getIntent().getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      }
    }
    jqo.lf("Web_qqbrowser_createtabbar");
  }
  
  void egM()
  {
    if (1 != this.aNf)
    {
      int i = this.aNf;
      this.jdField_a_of_type_Arci.cancel();
      this.jdField_a_of_type_Arci.cFX();
      this.jdField_a_of_type_Arci.av(null);
    }
  }
  
  public void egN()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public void egO()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public void egP()
  {
    if ((Build.VERSION.SDK_INT >= 28) && (super.getActivity() != null) && (this.jdField_a_of_type_Arcd$a.isFullScreen))
    {
      Window localWindow = getActivity().getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  public void egR()
  {
    dA(arcp.a(this, this.intent));
  }
  
  public void ff(boolean paramBoolean) {}
  
  public void flingLToR()
  {
    if (this.j == null) {
      biT();
    }
    HashMap localHashMap;
    do
    {
      return;
      if (!this.j.canGoBack()) {
        break;
      }
      localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(2));
    } while (!this.j.goBack(localHashMap));
    reset();
    return;
    biT();
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.j != null)
      {
        if (TextUtils.isEmpty(this.j.getUrl())) {
          break label46;
        }
        str1 = this.j.getUrl();
      }
    }
    return str1;
    label46:
    return this.intent.getStringExtra("url");
  }
  
  public Activity getHostActivity()
  {
    return super.getActivity();
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = this.edY;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.requestCode = 200;
    if (this.jdField_a_of_type_Aqzl.cA() != null)
    {
      localMiniMsgUserParam.entryView = this.jdField_a_of_type_Aqzl.cA();
      localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_Aqzl.cA().findViewById(2131371723));
    }
    localMiniMsgUserParam.actionCallback = a();
    return localMiniMsgUserParam;
  }
  
  public String getOpenidBatch(String paramString)
  {
    paramString = b(BaseApplicationImpl.getApplication(), "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.intent.getStringExtra("vkey"), this.uin);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public String getShareUrl()
  {
    if (a() == null) {
      return "";
    }
    return a().getShareUrl();
  }
  
  public int getTitleBarHeight()
  {
    return super.getResources().getDimensionPixelSize(2131299627);
  }
  
  public View getTitleBarView()
  {
    return this.jdField_a_of_type_Aqzl.aK;
  }
  
  public Activity getTopActivity()
  {
    return BaseActivity.sTopActivity;
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.qI == null) {
      this.qI = LayoutInflater.from(super.getActivity()).inflate(2131563308, null);
    }
    return this.qI;
  }
  
  public CustomWebView getWebView()
  {
    return this.j;
  }
  
  public boolean hF(String paramString)
  {
    return ((arbt)this.jdField_a_of_type_Araz.q(4)).hF(paramString);
  }
  
  public long hY()
  {
    return this.jdField_a_of_type_Arbz.aup;
  }
  
  protected void initWebView()
  {
    int i = -1;
    int k = 0;
    long l1;
    long l2;
    if (this.j == null)
    {
      this.j = a(null).a();
      this.j.getView().setOnTouchListener(this);
      this.j.setOnLongClickListener(new a());
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x10000) == 0L) {
        break label338;
      }
      i = 2;
      if (AppSetting.aNT) {
        i = 2;
      }
      this.j.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.j.getSettings().setAllowFileAccessFromFileURLs(false);
      this.j.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Arbz.auz = (l2 - l1);
      this.jdField_a_of_type_Arbz.auY = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Arbz.auz);
      }
      l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.j.getX5WebViewExtension();
      i = k;
      if (localIX5WebViewExtension != null) {
        i = 1;
      }
      if (i == 0) {
        break label393;
      }
      Bundle localBundle = arcp.v();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      this.jdField_a_of_type_Arbz.eeh = 2;
    }
    label393:
    for (this.jdField_a_of_type_Arbz.czr = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Arbz.czr = String.valueOf(Build.VERSION.SDK_INT))
    {
      this.jdField_a_of_type_Arbz.auP = this.jdField_a_of_type_Arar.aum;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      return;
      label338:
      switch (this.intent.getIntExtra("reqType", -1))
      {
      case 2: 
      case 3: 
      default: 
        break;
      case 1: 
        i = 2;
        break;
      case 4: 
        i = 0;
        break;
        this.jdField_a_of_type_Arbz.eeh = 1;
      }
    }
  }
  
  public boolean isFullScreen()
  {
    return this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen;
  }
  
  protected void ix(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramView != null)) {
      paramView.addOnLayoutChangeListener(new aqzz(this));
    }
  }
  
  void iz(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.pY(paramString1);
      String str = SwiftBrowserCookieMonster.pY(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.cXu = false;
      }
      if (this.cXu)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, this, null, this.intent);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebLog_WebViewFragment", 1, paramString1, new Object[0]);
    }
  }
  
  public int jr()
  {
    return this.jdField_a_of_type_Arcd$a.bPY;
  }
  
  public final void k(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    QLog.d("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK " + paramString1 + "," + paramInt + "," + paramString2 + "," + paramString3);
    if (!this.intent.getBooleanExtra("from_single_task", false))
    {
      QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
      return;
    }
    Bundle localBundle1 = affz.a("ipc_qqbrowser_to_conversation", "", 0, null);
    localBundle1.putInt("banner_msg", 1134049);
    Bundle localBundle2 = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = acfp.m(2131716905);
    }
    localBundle2.putString("tips", str);
    localBundle2.putString("iconURL", paramString2);
    localBundle2.putInt("icon", paramInt);
    localBundle2.putInt("timeout", 900000);
    localBundle2.putString("url", this.mUrl);
    localBundle2.putString("activity", paramString3);
    localBundle2.putInt("flags", 335544320);
    localBundle1.putBundle("barInfo", localBundle2);
    afjy.a().cr(localBundle1);
    paramString1 = new Intent();
    paramString1.setClass(getActivity(), SplashActivity.class);
    paramString1.setFlags(335544320);
    paramString1.putExtra("tab_index", MainFragment.bIk);
    paramString1.putExtra("fragment_id", 1);
    startActivity(paramString1);
  }
  
  protected void ks(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.jdField_a_of_type_Arcd.mRootView.findViewById(2131363733);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131382187);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public boolean mc()
  {
    if (getActivity() != null) {
      return getActivity().isResume();
    }
    return false;
  }
  
  public void mg(long paramLong)
  {
    this.jdField_a_of_type_Arcd$a.gK = paramLong;
  }
  
  public int n(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("3058");
    paramBundle = this.intent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.intent.putExtra("url", paramBundle.getString("url"));
      if (!this.intent.hasExtra("key_isReadModeEnabled")) {
        this.intent.putExtra("key_isReadModeEnabled", true);
      }
      this.intent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.intent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.intent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int k;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("WebLog_WebViewFragment", 2, paramBundle.toString());
          continue;
          i = 0;
          continue;
          bool = false;
        }
      }
    }
    if (("Xiaomi_MI 2".equals(Build.MANUFACTURER + "_" + Build.MODEL)) && (Build.VERSION.SDK_INT == 16)) {
      this.cXt = true;
    }
    this.bQX = this.intent.getIntExtra("articalChannelId", 100);
    this.cyM = this.intent.getStringExtra("ARTICAL_CHANNEL_EXTRAL_INFO");
    this.Fg = this.intent.getBooleanExtra("fromQZone", false);
    bool = this.intent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    k = hashCode();
    if (bool)
    {
      i = 1;
      anpo.a(paramBundle, k, i, this.mUrl);
      if (this.intent.getBooleanExtra("vasUsePreWebview", false)) {
        break label477;
      }
      bool = true;
      this.jdField_a_of_type_Arbs.dp("web_view_long_click", bool);
      this.jdField_a_of_type_Arbz.a.eeo = this.intent.getIntExtra("individuation_url_type", -1);
      if (bJl == 1) {
        arbz.b.eeq = this.jdField_a_of_type_Arbz.a.eeo;
      }
      if ((this.jdField_a_of_type_Arbz.a.eeo == -1) && (arbz.b.eeq != -1)) {
        this.jdField_a_of_type_Arbz.a.eeo = arbz.b.eeq;
      }
      this.jdField_a_of_type_Arbz.czp = this.mUrl;
      this.cyN = this.intent.getStringExtra("title");
      this.jdField_a_of_type_Arcd.cyN = this.cyN;
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x4000000) == 0L) {
        this.jdField_a_of_type_Arbs.dp("image_long_click", true);
      }
      jqo.lf("Web_qqbrowser_state_machine_init_data");
      this.aNf = 4;
      return 0;
    }
  }
  
  public int o(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    jqo.le("Web_qqbrowser_state_machine_init_ui_main_content");
    jqo.le("Web_qqbrowser_initView");
    if (!this.cXs)
    {
      this.cXs = true;
      this.jdField_a_of_type_Arcd.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer, this.intent, this.j);
      if (this.j.isPaused) {
        this.j.onResume();
      }
      if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_Arcd.eQ).setOnFlingGesture(this);
      }
    }
    for (;;)
    {
      jqo.lf("Web_qqbrowser_initView");
      jqo.lf("Web_qqbrowser_state_machine_init_ui_main_content");
      this.jdField_a_of_type_Arbz.auS = (SystemClock.elapsedRealtime() - l);
      this.aNf = 256;
      return 1;
      if ((this.jdField_a_of_type_Arcd$a.isFullScreen) && (this.jdField_a_of_type_Arcd$a.Dr != 0L)) {
        this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.iw(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getHostActivity() != null) && (getHostActivity().isFinishing()))
    {
      QLog.e("WebLog_WebViewFragment", 1, "HostActivity " + getHostActivity() + " is finishing! Don't call WebViewFragment.doOnCreate!");
      return;
    }
    doOnCreate(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.intent = ((Intent)super.getArguments().getParcelable("intent"));
    Bundle localBundle;
    if (this.intent == null)
    {
      localBundle = null;
      if (localBundle != null)
      {
        if (localBundle.getClassLoader() != null) {
          break label82;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "No classloader for this fragment");
        }
        this.intent.setExtrasClassLoader(WebViewTitleStyle.class.getClassLoader());
      }
    }
    for (;;)
    {
      super.onAttach(paramActivity);
      return;
      localBundle = this.intent.getExtras();
      break;
      label82:
      QLog.d("WebLog_WebViewFragment", 2, "already has classloader for this fragment: " + localBundle.getClassLoader());
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.j == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.jdField_a_of_type_Aqzl.leftView) || (paramView == this.jdField_a_of_type_Aqzl.d) || (paramView == this.jdField_a_of_type_Arcd.Ju))
      {
        biT();
        if (paramView == this.jdField_a_of_type_Aqzl.d) {
          anot.c(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
        }
      }
      else
      {
        Object localObject;
        if ((paramView == this.jdField_a_of_type_Aqzl.rightViewImg) || (paramView == this.jdField_a_of_type_Aqzl.rightHighLView))
        {
          if (arbt.In != -1L) {
            arbt.In = -1L;
          }
          localObject = new Intent();
          ((Intent)localObject).setAction("SignInSbumited");
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          if (!Nk())
          {
            arts.a().a("", "", "", "1000", "100", "0", false);
            Qq();
          }
          if (this.jdField_a_of_type_Arcd.Jv != null)
          {
            localObject = this.jdField_a_of_type_Arcd.Jv.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
              ((ViewGroup)localObject).removeView(this.jdField_a_of_type_Arcd.Jv);
            }
          }
        }
        else if (paramView == this.jdField_a_of_type_Aqzl.rightViewText)
        {
          localObject = getCurrentUrl();
          if ((localObject != null) && (((String)localObject).contains("checkin/index")))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("SignInSbumited");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          if (!Nk())
          {
            if (!this.jdField_a_of_type_Arcd$a.cYv) {
              break label359;
            }
            biT();
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Arcd.Jv == null) {
              break label386;
            }
            localObject = this.jdField_a_of_type_Arcd.Jv.getParent();
            if ((localObject == null) || (!(localObject instanceof ViewGroup))) {
              break;
            }
            ((ViewGroup)localObject).removeView(this.jdField_a_of_type_Arcd.Jv);
            break;
            label359:
            arts.a().a("", "", "", "1000", "100", "0", false);
            Qq();
          }
        }
        else
        {
          label386:
          if (paramView == this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AP)
          {
            if (this.jdField_a_of_type_Arcd$a.cYP)
            {
              LpReportInfo_dc02216.reportExit();
              if (getWebView() != null)
              {
                localObject = getWebView().getPluginEngine();
                if ((localObject != null) && (((WebViewPluginEngine)localObject).handleEvent(getCurrentUrl(), 8589934615L, null)))
                {
                  this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AN.setVisibility(8);
                  this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.setFloatBtnBackground(this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AM, true);
                  this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.mask.setVisibility(8);
                  continue;
                }
              }
            }
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AN.setVisibility(8);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.setFloatBtnBackground(this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AM, true);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.mask.setVisibility(8);
            super.getActivity().finish();
            anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
          }
          else if (paramView == this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.lY)
          {
            if (arbt.In != -1L) {
              arbt.In = -1L;
            }
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AN.setVisibility(8);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.setFloatBtnBackground(this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AM, true);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.mask.setVisibility(8);
            Qq();
            arts.a().a("", "", "", "1000", "100", "0", false);
            anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
            if (this.jdField_a_of_type_Arcd$a.cYP) {
              LpReportInfo_dc02216.reportShare();
            }
          }
          else if (paramView == this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AS)
          {
            localObject = new Intent(super.getActivity(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
            ((Intent)localObject).putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            super.startActivity((Intent)localObject);
            super.getActivity().finish();
            anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            }
          }
          else if (paramView == this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AR)
          {
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AN.setVisibility(8);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.setFloatBtnBackground(this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AM, true);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.mask.setVisibility(8);
            if (!TextUtils.isEmpty(b().aHl))
            {
              this.j.callJs(b().aHl, new String[] { "" });
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "call js function getShare().mOnShareHandler");
              }
            }
            anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
            if (this.jdField_a_of_type_Arcd$a.cYP) {
              LpReportInfo_dc02216.reportExit();
            }
          }
          else if (paramView == this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AQ)
          {
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AN.setVisibility(8);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.setFloatBtnBackground(this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.AM, true);
            this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzg.mask.setVisibility(8);
            if (this.jdField_a_of_type_Arcd$a.cYO)
            {
              if (TextUtils.isEmpty(this.j.getTitle())) {}
              for (localObject = acfp.m(2131716911);; localObject = this.j.getTitle())
              {
                k(String.format(acfp.m(2131716906), new Object[] { localObject }), 2130838441, null, SingleTaskQQBrowser.class.getName());
                anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "fold", "", "", "");
                break;
              }
            }
            if (this.jdField_a_of_type_Arcd$a.cYN) {
              a().egR();
            }
          }
          else if (paramView == this.jdField_a_of_type_Arcd.abM)
          {
            localObject = new HashMap();
            ((Map)localObject).put("intent", this.intent);
            dispatchPluginEvent(8589934622L, (Map)localObject);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Arcd = ((arcd)this.jdField_a_of_type_Araz.q(2));
    this.jdField_a_of_type_Arcd.ehg();
    this.jdField_a_of_type_Arcd$a = this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a;
    this.jdField_a_of_type_Aqzl = this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl;
    this.jdField_a_of_type_Arbs = ((arbs)this.jdField_a_of_type_Araz.q(-1));
    this.jdField_a_of_type_Arbz = ((arbz)this.jdField_a_of_type_Araz.q(-2));
    this.jdField_a_of_type_Arcd.setOnClickListener(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = ((WebBrowserViewContainer)WebAccelerateHelper.preloadBrowserView);
      WebAccelerateHelper.preloadBrowserView = null;
      this.jdField_a_of_type_Arbz.cXZ = true;
    }
    for (;;)
    {
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setLayoutParams(paramLayoutInflater);
      ix(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = new WebBrowserViewContainer(super.getActivity());
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$a.dqC();
    }
    if (1 != this.aNf)
    {
      this.jdField_a_of_type_Arci.cancel();
      this.aNf = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    Object localObject = Long.valueOf(this.intent.getLongExtra("Gif_msg_uniseq_key", 0L));
    if (((Long)localObject).longValue() > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("Gif_msg_uniseq_key", ((Long)localObject).longValue());
      localObject = affz.a("close_annimate", null, -1, localBundle);
      afjy.a().cq((Bundle)localObject);
    }
    if (this.c != null) {
      afjy.a().b(this.c);
    }
    if (this.j != null) {}
    for (localObject = this.j.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).handleEvent(this.j.getUrl(), 8589934596L, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", this.mUrl);
      this.jdField_a_of_type_Araz.P(3, (Bundle)localObject);
      destroyWebView();
      if (QQBrowserActivity.bJl == 0)
      {
        afjy.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        arbz.b.eeq = -1;
      }
      if (this.jdField_a_of_type_Svi != null) {
        this.jdField_a_of_type_Svi.destroy();
      }
      localObject = anpo.a(getClass(), hashCode());
      if (localObject != null) {
        anot.a(null, "CliOper", "", "", ((anpo.a)localObject).cgi, ((anpo.a)localObject).cgi, ((anpo.a)localObject).arg1, 0, Long.toString(SystemClock.elapsedRealtime() - ((anpo.a)localObject).startTime), "", "", "");
      }
      arcj.a().removeIdleTask(2);
      this.jdField_a_of_type_Aqzl.recycle();
      wis.cm(super.getActivity().getIntent());
      avug.a().a(this.mUrl, 133, System.currentTimeMillis() - this.jdField_a_of_type_Arbz.ava, "0", this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
      super.onDestroy();
      return;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Arbz.onDetectedBlankScreen(paramString, paramInt);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.j != null)
        {
          str = paramString;
          if (this.j.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    boolean bool2 = this.authConfig.z(str, "publicAccount.getLocation");
    paramString = "";
    if (this.j != null) {
      paramString = jqo.getSpecifiedLevelDomain(this.j.getUrl(), 2);
    }
    boolean bool3 = PublicAccountJavascriptInterface.getLocationPermissionGrant(this.uin, paramString);
    if ((bool3) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.uin, " urlHost:", paramString });
      }
      paramGeolocationPermissionsCallback.invoke(str, bool1, false);
      return;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      dispatchPluginEvent(512L, null);
      return;
    }
    dispatchPluginEvent(256L, null);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "hide custom view called");
    }
    if (this.customViewCallback == null) {
      return;
    }
    this.lr.setKeepScreenOn(false);
    this.customContainer.setVisibility(8);
    this.customViewCallback.onCustomViewHidden();
    try
    {
      this.customContainer.removeAllViews();
      label57:
      if (!this.jdField_a_of_type_Arcd$a.cYJ) {
        super.getActivity().getWindow().setFlags(this.byX, 1024);
      }
      super.getActivity().setRequestedOrientation(this.byW);
      this.lr = null;
      this.customViewCallback = null;
      this.qI = null;
      this.aMU = false;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onLowMemory()
  {
    try
    {
      if ((arbz.cYa) && (this.jdField_a_of_type_Arbz != null) && (this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp > 0L)) {
        anot.a(null, "dc00899", "WV_Analysis", "", "memory_consumption", arbz.qa(this.mUrl), this.jdField_a_of_type_Arbz.eeh, 0, "", this.jdField_a_of_type_Arbz.czr, this.jdField_a_of_type_Arbz.mNetworkType, "");
      }
      label73:
      super.onLowMemory();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label73;
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return;
    }
    this.jdField_a_of_type_Arbz.Wg("state_page_finished");
    egM();
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_Arbz.a.mCurrentStep == 2))
    {
      this.jdField_a_of_type_Arbz.a.mCurrentStep = 8;
      this.jdField_a_of_type_Arbz.a.aiB = System.currentTimeMillis();
    }
    this.cXr = true;
    this.bQX = 100;
    Object localObject = (arbz)this.jdField_a_of_type_Araz.q(-2);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)) {
      ((arbz)localObject).eef = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().getFinalResultCode();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    this.jdField_a_of_type_Araz.P(7, (Bundle)localObject);
    if (this.jdField_a_of_type_Arbz.cXR)
    {
      this.jdField_a_of_type_Arbz.cXR = false;
      this.cXu = false;
      a();
      arcj.a().a(new arcj.b(1));
      if (this.intent.getBooleanExtra("banner_fromBanner", false))
      {
        localObject = this.intent.getBundleExtra("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
        {
          int i = ((Bundle)localObject).getInt("AIO_Scroll_Y");
          if ((i > 0) && (this.j.getView() != null)) {
            ThreadManager.getUIHandler().post(new WebViewFragment.14(this, i));
          }
        }
      }
      this.jdField_a_of_type_Arbz.ava = System.currentTimeMillis();
      if (arbz.cYa) {
        this.jdField_a_of_type_Arbz.i("web_loaded_url", System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0");
      }
      avug.a().a(paramString, 131, this.jdField_a_of_type_Arbz.ava - this.jdField_a_of_type_Arbz.auX, "0", this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
      avug.a().a(paramString, 129, this.jdField_a_of_type_Arbz.ava - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0", this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.pageFinish(paramString);
    }
    if ((Build.VERSION.SDK_INT >= 19) && (!this.isDestroyed) && (this.jdField_a_of_type_Arar != null) && (this.jdField_a_of_type_Arar.a() != null)) {
      onReceivedTitle(paramWebView, paramWebView.getTitle());
    }
    localObject = getHostActivity();
    if ((localObject instanceof QQBrowserActivity)) {
      ((QQBrowserActivity)localObject).onPageFinished(paramWebView, paramString);
    }
    if ((paramWebView instanceof CustomWebView)) {
      kdl.a((CustomWebView)paramWebView);
    }
    this.jdField_a_of_type_Arbz.Wg("state_final");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.isDestroyed) || (this.j == null)) {}
    do
    {
      return;
      egM();
      paramWebView = new Bundle();
      paramWebView.putString("url", paramString);
      this.jdField_a_of_type_Araz.P(6, paramWebView);
    } while (!this.jdField_a_of_type_Arbz.mIsFirstOnPageStart);
    anot.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.jdField_a_of_type_Arcd$a.Dr + "", this.mUrl, jqc.getNetWorkType() + "", this.uin);
    if (arbz.cYa) {
      this.jdField_a_of_type_Arbz.i("web_start_load_url", System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0");
    }
    this.jdField_a_of_type_Arbz.mIsFirstOnPageStart = false;
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onPause");
    }
    if (this.aMU) {
      onHideCustomView();
    }
    String str = BridgeHelper.a(super.getActivity(), this.uin).getConfig("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(super.getActivity());
    }
    this.jdField_a_of_type_Araz.P(1, null);
    dispatchPluginEvent(8589934597L, null);
    if ((this.Fg) && (anlm.ayo())) {
      avzl.a().eCO();
    }
    super.onPause();
  }
  
  public void onPostThemeChanged()
  {
    if (this.mApp != null)
    {
      this.avR = ThemeUtil.isInNightMode(this.mApp);
      dispatchPluginEvent(8589934604L, null);
    }
    if ((this.Js != null) && (!this.jdField_a_of_type_Arcd$a.cYs))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.Js.setBackgroundResource(2130851106);
      }
    }
    else {
      return;
    }
    this.Js.setBackgroundColor(getResources().getColor(2131167361));
    anlm.a(false, getResources().getColor(2131167361), getHostActivity().getWindow());
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((this.jdField_a_of_type_Arcd.mProgressBarController != null) && (this.jdField_a_of_type_Arcd.mProgressBarController.getCurStatus() == 0)) {
      this.jdField_a_of_type_Arcd.mProgressBarController.enterStatus((byte)1);
    }
    if (paramInt == 100) {
      this.jdField_a_of_type_Arcd.ar.setVisibility(8);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return;
    }
    egM();
    this.jdField_a_of_type_Arcd.ar.setVisibility(8);
    QLog.e("WebLog_WebViewFragment", 1, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + jqo.filterKeyForLog(paramString2, new String[0]));
    this.jdField_a_of_type_Arbz.a(this.j, paramInt, paramString1, paramString2);
    if (arbz.cYa) {
      this.jdField_a_of_type_Arbz.i("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, String.valueOf(paramInt));
    }
    avug.a().a(this.mUrl, 132, System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, String.valueOf(paramInt), this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {}
    while ((!TextUtils.isEmpty(this.cyN)) || ((this.jdField_a_of_type_Arcd$a.Ds & 0x8) > 0L) || (arcu.isUrl(paramString)) || (paramString == null)) {
      return;
    }
    this.jdField_a_of_type_Aqzl.a(paramWebView, paramString, this.cXt);
  }
  
  public void onResume()
  {
    jqo.le("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onResume");
    }
    if (this.j != null) {
      this.j.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.uin);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    localObject = BridgeHelper.a(super.getActivity(), this.uin).getConfig("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(super.getActivity());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", this.aNf);
    this.jdField_a_of_type_Araz.P(2, (Bundle)localObject);
    localObject = getHostActivity();
    int i;
    if ((localObject instanceof QQBrowserActivity))
    {
      WebViewFragment localWebViewFragment = ((QQBrowserActivity)localObject).c();
      if (localWebViewFragment != null) {
        if (localWebViewFragment == this) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        dispatchPluginEvent(2L, null);
      }
      ThreadManager.executeOnSubThread(new WebViewFragment.4(this, (Activity)localObject));
      if ((this.Fg) && (anlm.ayo())) {
        avzl.a().Il(1);
      }
      if (this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen)
      {
        egN();
        egP();
      }
      jqo.lf("Web_qqbrowser_doonresume");
      super.onResume();
      if (this.mMiniMsgUser != null) {
        this.mMiniMsgUser.onForeground();
      }
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public void onStop()
  {
    if ((this.jdField_a_of_type_Arcd$a.gK & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "close on hide by wv param");
      }
      super.getActivity().finish();
    }
    if (this.mMiniMsgUser != null) {
      this.mMiniMsgUser.onBackground();
    }
    super.onStop();
    arbz.ehe();
    if ((this.jdField_a_of_type_Aqzl != null) && (this.jdField_a_of_type_Aqzl.cA() != null) && (this.jdField_a_of_type_Aqzl.aFZ())) {
      MiniMsgIPCClient.getInstance().clearBusiness(this.edY);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.iJ = System.currentTimeMillis();
      if (paramView.getId() == 2131366722)
      {
        paramMotionEvent = paramView.getParent();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
          ((ViewGroup)paramMotionEvent).removeView(paramView);
        }
      }
    }
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.mRedirect302Url = paramString2;
    SwiftBrowserCookieMonster.egU();
    iz(paramString1, paramString2);
    this.jdField_a_of_type_Arbz.Wi(paramString2);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.mFileChooserHelper == null) {
      this.mFileChooserHelper = new jpu();
    }
    this.mFileChooserHelper.showFileChooser(super.getActivity(), 0, paramValueCallback, paramString1, paramString2);
  }
  
  public int p(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_Arbz.Wg("state_webview_create");
    initWebView();
    jqo.lf("Web_qqbrowser_state_machine_init_webview");
    this.aNf = 32;
    this.jdField_a_of_type_Arbz.auX = System.currentTimeMillis();
    this.jdField_a_of_type_Arbz.Gw = (this.jdField_a_of_type_Arbz.auX - this.jdField_a_of_type_Arbz.auW);
    if (arbz.cYa) {
      this.jdField_a_of_type_Arbz.i("should_start_load", this.jdField_a_of_type_Arbz.auX - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0");
    }
    avug.a().a(this.mUrl, 130, this.jdField_a_of_type_Arbz.auX - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0", this.jdField_a_of_type_Arbz.eeh, this.jdField_a_of_type_Arbz.czr);
    return 0;
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "pluginStartActivityForResult not handled");
      }
      return i;
    }
    super.startActivityForResult(paramIntent, i);
    return i;
  }
  
  void preInitData()
  {
    this.mUrl = CE();
    this.jdField_a_of_type_Arcd.xF(this.mUrl);
    if (this.jdField_a_of_type_Arcd$a.gK != 4L)
    {
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x2) != 0L) {
        this.intent.putExtra("hide_more_button", true);
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 1L) != 0L) {
        this.intent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.jdField_a_of_type_Arcd$a.gK & 0x100000) > 0L) {
        this.intent.putExtra("ignoreLoginWeb", true);
      }
    }
  }
  
  boolean rO(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        Object localObject = Uri.parse(paramString);
        if (((Uri)localObject).isHierarchical())
        {
          localObject = ((Uri)localObject).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            HashMap localHashMap = new HashMap();
            long l = Long.parseLong((String)localObject);
            if ((0x2 & l) == 0L) {
              break label336;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label342;
            }
            i = 1;
            break label324;
            label138:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label355;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine();
        if (localObject != null)
        {
          localObject = ((SonicEngine)localObject).createSession(paramString, localBuilder.build());
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
            return true;
          }
          QLog.d("WebLog_WebViewFragment", 1, "initSonicSession sonicSession = null, url = " + paramString);
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebLog_WebViewFragment", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      QLog.d("WebLog_WebViewFragment", 1, "initSonicSession sonicEngine = null, url = " + paramString);
      return false;
      for (;;)
      {
        label324:
        if (i == 0) {
          break label347;
        }
        str = "store";
        break label138;
        label336:
        bool = false;
        break;
        label342:
        i = 0;
      }
      label347:
      String str = "true";
      continue;
      label355:
      boolean bool = false;
    }
  }
  
  protected void reset()
  {
    a().reset();
  }
  
  public int s(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_ui_frame");
    if (!this.jdField_a_of_type_Arcd.cYj)
    {
      long l = SystemClock.elapsedRealtime();
      showPreview();
      this.jdField_a_of_type_Arbz.auQ = (SystemClock.elapsedRealtime() - l);
    }
    this.aNf = 128;
    jqo.lf("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void setImmersiveStatus()
  {
    Tk(false);
  }
  
  public void setTitle(String paramString)
  {
    this.jdField_a_of_type_Aqzl.setTitle(paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.j == null)) {
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      this.jdField_a_of_type_Arbz.mPerfFirstLoadTag = false;
    }
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      reset();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.mUrl = paramString;
        localObject = (arbt)this.jdField_a_of_type_Araz.q(4);
        if (localObject != null) {
          ((arbt)localObject).VY(this.mUrl);
        }
        localObject = (arbo)this.jdField_a_of_type_Araz.q(64);
        if (localObject != null) {
          ((arbo)localObject).VY(this.mUrl);
        }
      }
    }
    if (super.getActivity().isFinishing()) {
      this.jdField_a_of_type_Arcd.ar.setVisibility(8);
    }
    Object localObject = arcp.getSchemeFromUrl(paramString);
    if (("http".equals(localObject)) || ("https".equals(localObject)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebLog_WebViewFragment", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.mRedirect302Url;
        this.mRedirect302Url = paramString;
        SwiftBrowserCookieMonster.egU();
        iz(paramWebView, this.mRedirect302Url);
        this.jdField_a_of_type_Arbz.Wi(paramString);
      }
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "show custom view called");
    }
    if (this.customViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.byW = super.getActivity().getRequestedOrientation();
    this.byX = (super.getActivity().getWindow().getAttributes().flags & 0x400);
    if (this.customContainer == null)
    {
      this.customContainer = new FrameLayout(BaseApplicationImpl.getApplication());
      this.customContainer.setBackgroundColor(-16777216);
      ((ViewGroup)super.getActivity().getWindow().getDecorView()).addView(this.customContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.jdField_a_of_type_Arcd$a.cYJ) {
      super.getActivity().getWindow().setFlags(1024, 1024);
    }
    super.getActivity().setRequestedOrientation(paramInt);
    this.aMU = true;
    this.customContainer.addView(paramView);
    this.lr = paramView;
    this.customViewCallback = paramCustomViewCallback;
    this.customContainer.setVisibility(0);
  }
  
  @TargetApi(14)
  public boolean showPreview()
  {
    jqo.le("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Arcd.dU(this.intent);
    this.jdField_a_of_type_Arcd.dV(this.intent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.init(this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYM);
    egJ();
    if (this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.isFullScreen)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      egN();
      egP();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
      }
      this.jdField_a_of_type_Arcd.cYj = true;
      this.jdField_a_of_type_Arcd.ar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.aq;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce.setVisibility(8);
      this.jdField_a_of_type_Arcd.rS(this.mUrl);
      this.jdField_a_of_type_Arcd.ehi();
      jqo.lf("Web_qqbrowser_ShowPreview");
      return true;
    }
    this.jdField_a_of_type_Arcd.mRootView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
    this.jdField_a_of_type_Aqzl.a(this.intent, this);
    this.jdField_a_of_type_Aqzl.aK.setOnTouchListener(this.C);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aqzl.aK.getLayoutParams();
    float f = jll.dp2px(BaseApplicationImpl.getApplication(), 50.0F);
    int i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      f += i;
    }
    for (;;)
    {
      localLayoutParams.height = ((int)f);
      this.jdField_a_of_type_Arcd$a.cYL = true;
      int k = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296723);
      if ((this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) || (this.jdField_a_of_type_Arcd$a.cYw))
      {
        this.jdField_a_of_type_Arcd$a.cYx = true;
        this.jdField_a_of_type_Aqzl.aK.setBackgroundDrawable(super.getResources().getDrawable(2130851770));
        this.jdField_a_of_type_Aqzl.Yh(-1);
        this.jdField_a_of_type_Aqzl.Yj(-1);
        if (!this.jdField_a_of_type_Arcd$a.cYy) {
          break label574;
        }
        ks(k + i, i);
      }
      label574:
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_a_of_type_Arcd$a.cYw) {
          this.jdField_a_of_type_Aqzl.aK.setOnTouchListener(null);
        }
        for (bool2 = bool1;; bool2 = true)
        {
          for (;;)
          {
            if (ImmersiveUtils.isSupporImmersive() == 1)
            {
              this.jdField_a_of_type_Aqzl.aK.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
              super.getActivity().getWindow().addFlags(67108864);
            }
            Tk(bool2);
            if ((!this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYl) && (!this.jdField_a_of_type_Arcd$a.cYw)) {
              egL();
            }
            if (!"2105".equals(ThemeUtil.curThemeId)) {
              break;
            }
            try
            {
              this.jdField_a_of_type_Aqzl.Yj(Color.parseColor("#03081A"));
            }
            catch (Exception localException)
            {
              QLog.d("WebLog_WebViewFragment", 2, "there may be some views not be initialized, should not do this UI adjust");
            }
          }
          break;
          this.mNeedStatusTrans = true;
          this.mActNeedImmersive = true;
          ks(k + i * 2, i + BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299634));
        }
      }
      i = 0;
    }
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewFragment", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public int y(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_x5_environment");
    this.jdField_a_of_type_Arbz.auW = System.currentTimeMillis();
    this.aNf = 8;
    if (arcn.a.PN())
    {
      jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (arcn.a.init())
    {
      jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    jqo.lf("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  public void ye(boolean paramBoolean)
  {
    int i;
    View localView;
    if (this.jdField_a_of_type_Aqzl.cA() != null)
    {
      if (!paramBoolean) {
        break label87;
      }
      i = 0;
      this.jdField_a_of_type_Aqzl.cA().setVisibility(i);
      localView = this.jdField_a_of_type_Aqzl.cA().findViewById(2131371722);
      if (this.cyT != null)
      {
        if (!this.cyT.equals("white")) {
          break label93;
        }
        localView.setBackgroundResource(2130841863);
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.onForeground();
      }
      return;
      label87:
      i = 8;
      break;
      label93:
      if (this.cyT.equals("black")) {
        localView.setBackgroundResource(2130841862);
      }
    }
  }
  
  public int z(Bundle paramBundle)
  {
    jqo.le("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.mApp instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)this.mApp);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.isInited())) {
      VipWebViewReportLog.a(this.mApp.getApplication(), this.mApp);
    }
    this.uin = this.mApp.getAccount();
    if (this.mApp.getLongAccountUin() != 0L)
    {
      paramBundle = this.jdField_a_of_type_Arbz;
      if (this.mApp.getLongAccountUin() % arbz.mSampleRate != 6L) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.cXQ = bool;
      egI();
      if (this.mPluginEngine != null)
      {
        this.mPluginEngine.aa(getIntent().getStringArrayExtra("insertPluginsArray"));
        this.mPluginEngine.handleEvent(this.mUrl, 1L, null);
      }
      this.aNf = 16;
      if (arbz.cYa) {
        this.jdField_a_of_type_Arbz.i("webview_init", System.currentTimeMillis() - this.jdField_a_of_type_Arbz.mOnCreateMilliTimeStamp, "0");
      }
      jqo.lf("Web_qqbrowser_state_machine_init_app_and_webview_engine");
      return 1;
    }
  }
  
  class a
    implements View.OnLongClickListener
  {
    a() {}
    
    public boolean onLongClick(View paramView)
    {
      if (!WebViewFragment.this.jdField_a_of_type_Arbs.J("web_view_long_click", true))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
        }
        return true;
      }
      if (!WebViewFragment.this.jdField_a_of_type_Arbs.J("image_long_click", false))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
        }
        return false;
      }
      arbf localarbf = (arbf)WebViewFragment.this.jdField_a_of_type_Araz.q(8);
      if ((localarbf != null) && (localarbf.U(paramView))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */