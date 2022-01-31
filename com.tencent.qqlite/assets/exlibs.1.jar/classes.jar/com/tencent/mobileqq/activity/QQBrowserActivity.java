package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbq;
import bbr;
import bbs;
import bbt;
import bbv;
import bbw;
import bbx;
import bby;
import bbz;
import bca;
import bcb;
import bcc;
import bcd;
import bce;
import bcf;
import bcg;
import bch;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Ad;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPluginContainer;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mtt.spcialcall.sdk.MttApi;
import com.tencent.mtt.spcialcall.sdk.MttLoader;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.DesUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(7)
public class QQBrowserActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, WebViewPluginContainer
{
  static final String jdField_A_of_type_JavaLangString = "QQBrowserOffline";
  public static final String B = "ba_is_login";
  public static final String C = "hide_left_button";
  public static final String D = "show_right_close_button";
  public static final String E = "finish_animation_up_down";
  public static final String F = "avoidLoginWeb";
  public static final String G = "ignoreLoginWeb";
  public static final String H = "url";
  public static final String I = "keyAction";
  public static final String J = "actionSelectPicture";
  public static final String M = "com.tencent.mobileqq.card.modify";
  public static final String N = "com.tencent.mobileqq.view.self.album";
  public static final String O = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final String P = "broadcastAction";
  public static final String Q = "key_pay_action_result";
  public static final String R = "reqType";
  public static final String S = "http://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s";
  public static final String T = "fromAio";
  public static final String U = "fromPublicAccount";
  public static final String X = "isShowAd";
  private static final int jdField_a_of_type_Int = 20000;
  private static final long jdField_a_of_type_Long = 86400000L;
  static ValueCallback jdField_a_of_type_AndroidWebkitValueCallback = null;
  private static final String jdField_a_of_type_JavaLangString = "utf-8";
  private static final int jdField_b_of_type_Int = 12;
  private static final String jdField_b_of_type_JavaLangString = "http://p.mb.qq.com/sdk";
  private static final int jdField_c_of_type_Int = 100;
  private static final String jdField_c_of_type_JavaLangString = "qb_info";
  private static final int jdField_d_of_type_Int = 101;
  private static final String jdField_d_of_type_JavaLangString = "http://mqqad.html5.qq.com/adjs?p=";
  private static final String jdField_e_of_type_JavaLangString = "icon_time";
  private static final String jdField_f_of_type_JavaLangString = "icon_url";
  public static final int g = 4660;
  private static final String jdField_g_of_type_JavaLangString = "content_time";
  public static final int h = 1;
  private static final String jdField_h_of_type_JavaLangString = "content_memo";
  public static final int i = 2;
  private static final String i = "click_icon";
  public static final int j = 3;
  private static final String j = "update_time";
  public static final int k = 4;
  private static final String k = "qb_param_url";
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 16777216;
  private static final String n = "Meizu_M040";
  public static final int o = 1;
  private static final String o = "Xiaomi_MI 2";
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 10000;
  public static final int s = 0;
  public static final int t = 2;
  public static int w = 0;
  static final String jdField_y_of_type_JavaLangString = "QQBrowser";
  public static final String z = "webview";
  public int A;
  private boolean jdField_A_of_type_Boolean = false;
  private boolean B = false;
  private boolean C;
  private boolean D;
  public String K = null;
  protected String L;
  public String V;
  String W = "";
  protected String Y = null;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected Handler a;
  public DisplayMetrics a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bbs(this);
  public View a;
  protected ViewGroup a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  protected AbsoluteLayout a;
  protected FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public AuthorizeConfig a;
  public CustomWebView a;
  private CustomWebViewClient jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient;
  Ad jdField_a_of_type_ComTencentBizWebviewpluginAd;
  Hole jdField_a_of_type_ComTencentBizWebviewpluginHole;
  public OfflinePlugin a;
  protected Share a;
  public ElasticHorScrView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQBrowserActivity.NativeChromeClient jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient;
  protected QQBrowserActivity.TopBarBtnClickListener a;
  public BrowserAppInterface a;
  private Client.onRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  public WebViewPluginEngine a;
  public ActionSheet a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  public long b;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_b_of_type_AndroidOsHandler = null;
  public View b;
  protected FrameLayout b;
  public ImageView b;
  public ElasticHorScrView b;
  private boolean jdField_b_of_type_Boolean;
  public long c;
  private Handler jdField_c_of_type_AndroidOsHandler;
  View jdField_c_of_type_AndroidViewView;
  public ImageView c;
  private boolean jdField_c_of_type_Boolean = false;
  public long d;
  private View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  public long e;
  private View jdField_e_of_type_AndroidViewView;
  public ImageView e;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 50;
  private long jdField_f_of_type_Long = 0L;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private boolean jdField_f_of_type_Boolean = false;
  private View jdField_g_of_type_AndroidViewView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  protected boolean g;
  private View jdField_h_of_type_AndroidViewView;
  protected boolean h;
  protected boolean i;
  public boolean j;
  public boolean k;
  private String l;
  public boolean l;
  private String m;
  public boolean m;
  public boolean n = true;
  protected boolean o = true;
  boolean p;
  public boolean q = false;
  protected boolean r = false;
  boolean s;
  int u = Build.VERSION.SDK_INT;
  public int v;
  private boolean v;
  private boolean w;
  int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean = false;
  int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean;
  public int z;
  private boolean z;
  
  static
  {
    jdField_w_of_type_Int = 0;
  }
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new bbq(this);
    this.jdField_e_of_type_Long = 0L;
    this.jdField_v_of_type_Int = 4;
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient = new bcc(this, this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
  }
  
  private void B()
  {
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    if (MttLoader.b(this)) {}
    do
    {
      return;
      localObject = getSharedPreferences("qb_info", 0);
    } while ((localObject == null) || (((SharedPreferences)localObject).getBoolean("click_icon", false)));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("click_icon", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private void C()
  {
    new bce(this, "HttpUtils").start();
  }
  
  private Dialog a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    String str3 = paramActivity.getResources().getString(paramInt1);
    Object localObject = paramActivity.getResources().getString(paramInt2);
    String str2 = paramActivity.getResources().getString(paramInt3);
    String str1 = paramActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject, new Object[] { paramString });; paramString = (String)localObject)
    {
      paramActivity = new Dialog(paramActivity, 2131624119);
      paramActivity.setContentView(2130903135);
      localObject = (TextView)paramActivity.findViewById(2131296911);
      if (localObject != null) {
        ((TextView)localObject).setText(str3);
      }
      localObject = (TextView)paramActivity.findViewById(2131296470);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
      paramString = (TextView)paramActivity.findViewById(2131296914);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)paramActivity.findViewById(2131296915);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return paramActivity;
    }
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
  
  /* Error */
  private HttpURLConnection a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 505	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 508	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 512	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 514	java/net/HttpURLConnection
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 475
    //   19: invokevirtual 517	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: iconst_1
    //   24: invokevirtual 521	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   27: aload_1
    //   28: iconst_1
    //   29: invokevirtual 524	java/net/HttpURLConnection:setDoInput	(Z)V
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 527	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   37: aload_1
    //   38: sipush 20000
    //   41: invokevirtual 530	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   44: getstatic 260	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 13
    //   49: if_icmple +13 -> 62
    //   52: aload_1
    //   53: ldc_w 532
    //   56: ldc_w 534
    //   59: invokevirtual 537	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_1
    //   63: ldc_w 539
    //   66: ldc_w 541
    //   69: invokevirtual 537	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ifnull +32 -> 105
    //   76: aload_1
    //   77: ldc_w 543
    //   80: aload_2
    //   81: arraylength
    //   82: invokestatic 545	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 537	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_1
    //   89: invokevirtual 549	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   92: astore 4
    //   94: aload 4
    //   96: aload_2
    //   97: invokevirtual 555	java/io/OutputStream:write	([B)V
    //   100: aload 4
    //   102: invokevirtual 558	java/io/OutputStream:flush	()V
    //   105: aload_1
    //   106: invokevirtual 562	java/net/HttpURLConnection:getResponseCode	()I
    //   109: istore_3
    //   110: iload_3
    //   111: sipush 200
    //   114: if_icmpne +8 -> 122
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: areturn
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	QQBrowserActivity
    //   0	127	1	paramString	String
    //   0	127	2	paramArrayOfByte	byte[]
    //   109	6	3	i1	int
    //   92	9	4	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   0	22	119	java/lang/Exception
    //   76	105	124	java/lang/Throwable
    //   105	110	124	java/lang/Throwable
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (j(this)) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      try
      {
        new Thread(new bbr(this, paramString3)).start();
        return;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i1 = localHttpURLConnection.getResponseCode();
        if ((i1 != 301) && (i1 != 302)) {
          break label167;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          int i1;
          String str;
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
      }
      paramString = null;
      str = paramString;
    }
    for (;;)
    {
      try
      {
        localHttpURLConnection.disconnect();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 101, paramString).sendToTarget();
        return;
        label167:
        if (i1 == 200)
        {
          paramString = new Bundle();
          str = paramString;
          paramString.putLong("_filesize", localHttpURLConnection.getContentLength());
          str = paramString;
          paramString.putString("qb_param_url", localHttpURLConnection.getURL().toString());
          str = paramString;
          paramString.putString("param_content_des", "");
          str = paramString;
          paramString.putString("param_mime_type", localHttpURLConnection.getContentType());
        }
      }
      catch (Throwable paramString)
      {
        paramString = str;
        continue;
      }
      paramString = null;
    }
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.canGoBack())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goBack();
    v();
    return true;
  }
  
  private void u()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", getPathNodeID());
    localBundle = DataFactory.makeIPCRequestPacket("pathPushActivity", null, -1, localBundle);
    WebIPCOperator.getInstance().sendServiceIpcReq(localBundle);
  }
  
  private void v()
  {
    Bundle localBundle = DataFactory.makeIPCRequestPacket("pathPopFrame", null, -1, new Bundle());
    WebIPCOperator.getInstance().sendServiceIpcReq(localBundle);
  }
  
  private void x()
  {
    this.jdField_k_of_type_Boolean = false;
    if ((this.app == null) && ((getAppRuntime() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
    }
    if (this.app != null) {}
    for (Object localObject = this.app;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)localObject);
      this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      return;
    }
  }
  
  private void y()
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = getLayoutInflater().inflate(2130903577, null);
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 131112;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.jdField_x_of_type_Int = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.jdField_y_of_type_Int = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    }
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131298608)).setOnClickListener(new bca(this));
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_c_of_type_AndroidViewView);
      label168:
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (Exception localException)
    {
      break label168;
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
    this.Y = null;
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.b();
    }
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    return WebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return -1;
    }
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    paramByte = WebViewPluginEngine.a(paramWebViewPlugin) * 1000 + paramByte + 10000;
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
  
  protected String a()
  {
    return "";
  }
  
  public String a(String paramString)
  {
    paramString = a(this, "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.jdField_l_of_type_JavaLangString, this.L);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(Intent paramIntent)
  {
    boolean bool;
    if ((this.B) || (paramIntent.getExtras().getBoolean("isScreenLandscape", false)))
    {
      bool = true;
      this.B = bool;
      this.s = paramIntent.getBooleanExtra("ba_is_login", true);
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("reqType", -1);
      this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 4);
      this.jdField_l_of_type_JavaLangString = paramIntent.getStringExtra("vkey");
      if ((!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) && (!paramIntent.getBooleanExtra("portraitOnly", false)) && (!paramIntent.getExtras().getBoolean("isScreenOrientationPortrait", false))) {
        break label406;
      }
      bool = true;
      label130:
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      if ((!this.o) || (!getIntent().getBooleanExtra("isShowAd", true))) {
        break label411;
      }
      bool = true;
      label160:
      this.o = bool;
      this.jdField_z_of_type_Boolean = paramIntent.getBooleanExtra("fromAio", false);
      if (this.jdField_e_of_type_Int == 6)
      {
        a(false);
        setRequestedOrientation(1);
      }
      String str = paramIntent.getStringExtra("key_params_qq");
      if ((!paramIntent.getExtras().getBoolean("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label416;
      }
      bool = true;
      label235:
      this.C = bool;
      if (!TextUtils.isEmpty(str))
      {
        this.K = str;
        this.D = true;
        this.C = true;
      }
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label421;
      }
      setRequestedOrientation(1);
    }
    for (;;)
    {
      if ((this.C) || (this.r)) {
        a(false);
      }
      if ((this.jdField_e_of_type_Int == 3) || (this.jdField_e_of_type_Int == 1) || (!this.s)) {
        paramIntent.putExtra("hide_more_button", true);
      }
      b(paramIntent, this.K);
      if (paramIntent.getBooleanExtra("reportMsfLog", false))
      {
        if (this.jdField_c_of_type_AndroidOsHandler == null) {
          this.jdField_c_of_type_AndroidOsHandler = new Handler();
        }
        if (this.jdField_a_of_type_JavaLangRunnable == null)
        {
          this.jdField_a_of_type_JavaLangRunnable = new bbz(this);
          this.jdField_c_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
        }
      }
      return;
      bool = false;
      break;
      label406:
      bool = false;
      break label130;
      label411:
      bool = false;
      break label160;
      label416:
      bool = false;
      break label235;
      label421:
      if ((this.B) && (getRequestedOrientation() != 0)) {
        setRequestedOrientation(0);
      }
    }
  }
  
  protected void a(Intent paramIntent, String paramString)
  {
    if (paramString != null)
    {
      paramString = Uri.parse(paramString);
      if ((paramString != null) && (paramString.isHierarchical()))
      {
        paramString = paramString.getQueryParameter("_wv");
        if (paramString == null) {}
      }
    }
    try
    {
      this.jdField_v_of_type_Int = Integer.parseInt(paramString.trim());
      if ((this.jdField_v_of_type_Int & 0x2) != 0) {
        paramIntent.putExtra("hide_more_button", true);
      }
      if ((this.jdField_v_of_type_Int & 0x1) != 0) {
        paramIntent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.jdField_v_of_type_Int & 0x400) != 0) {
        paramIntent.putExtra("isScreenOrientationPortrait", true);
      }
      if ((this.jdField_v_of_type_Int & 0x20000) > 0) {
        this.r = true;
      }
      if ((this.jdField_v_of_type_Int & 0x100000) > 0) {
        paramIntent.putExtra("ignoreLoginWeb", true);
      }
      if ((this.jdField_v_of_type_Int & 0x800) > 0) {
        this.B = true;
      }
      return;
    }
    catch (NumberFormatException paramIntent)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
      return;
    }
    WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine;
    int i1 = WebViewPluginEngine.a(paramWebViewPlugin);
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
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label106;
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if ((paramString3 != null) && (paramString3.length() != 0)) {
        break label134;
      }
      setTitle("");
      return;
      if (paramString1.equals("RETURN")) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(getIntent().getStringExtra("leftViewText"));
      }
      for (;;)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
        this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString1);
      }
      label106:
      this.jdField_j_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label134:
    setTitle(paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      b(paramString2, paramString3, paramString1);
      if (paramBoolean)
      {
        this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
    switch (paramInt1)
    {
    default: 
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(8);
      label97:
      if (paramInt2 != 0)
      {
        if (this.jdField_g_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(this);
          paramString3 = (RelativeLayout)findViewById(2131296900);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131296902);
          localLayoutParams.addRule(6, 2131296902);
          localLayoutParams.setMargins(0, 0, 0, 0);
          this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
          paramString3.addView(this.jdField_g_of_type_AndroidWidgetImageView);
        }
        this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
        switch (paramInt2)
        {
        default: 
          this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
          label229:
          if (!TextUtils.isEmpty(paramString2)) {
            this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
          }
          if (paramString1 == null) {}
          break;
        }
      }
      break;
    }
    for (this.Y = paramString1.trim();; this.Y = null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      break;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838438);
      break label97;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130839151);
      break label97;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838038);
      break label97;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130837741);
      break label97;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130838441);
      ((AnimationDrawable)this.jdField_p_of_type_AndroidWidgetImageView.getDrawable()).start();
      break label97;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130838409);
      break label229;
      if (this.jdField_g_of_type_AndroidWidgetImageView == null) {
        break label229;
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
      break label229;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    paramBoolean2 = false;
    Object localObject = null;
    int i1;
    if (paramString1.equals("left"))
    {
      localObject = this.jdField_h_of_type_AndroidWidgetTextView;
      i1 = 0;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (paramString1.equals("right"))
        {
          localObject = this.jdField_j_of_type_AndroidWidgetTextView;
          i1 = 1;
          continue;
        }
        if (paramString1.equals("rightImgBtn"))
        {
          localObject = this.jdField_p_of_type_AndroidWidgetImageView;
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130837741);
          i1 = 2;
        }
      }
      else
      {
        if (((localObject instanceof TextView)) && (!paramString1.equals("left"))) {
          ((TextView)localObject).setText(paramString2);
        }
        if (paramBoolean1) {}
        for (int i2 = 0;; i2 = 8)
        {
          ((View)localObject).setVisibility(i2);
          paramBoolean1 = paramBoolean2;
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
      }
      i1 = 0;
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.a(paramString).c(str).a(this, str, 2, null);
    paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramBoolean) {}
    for (int i1 = 42;; i1 = 45)
    {
      QfavReport.a(paramString, i1, 2);
      return;
    }
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
    for (localLayoutParams.bottomMargin = this.jdField_f_of_type_Int;; localLayoutParams.bottomMargin = 0)
    {
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout.setLayoutParams(localLayoutParams);
      return;
      label77:
      i1 = 8;
      break;
      this.jdField_f_of_type_Int = localLayoutParams.bottomMargin;
    }
  }
  
  public boolean a()
  {
    Object localObject = new HashMap(1);
    ((Map)localObject).put("target", Integer.valueOf(3));
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 12, (Map)localObject))) {}
    while ((((this.jdField_v_of_type_Int & 0x4) == 0) || (this.jdField_j_of_type_Boolean)) && (f())) {
      return true;
    }
    localObject = (InputMethodManager)getSystemService("input_method");
    if ((localObject != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient.onHideCustomView();
      return true;
    }
    setResult(-1, new Intent());
    finish();
    return true;
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
  
  protected boolean a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    int i1 = MttApi.a(this, MttLoader.a(this, paramString1), localHashMap);
    if (paramBoolean)
    {
      if (4 == i1) {
        a(this, paramString1, getResources().getString(2131363752), 2131363754, paramString2);
      }
    }
    else {
      if (i1 != 0) {
        break label155;
      }
    }
    label155:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      if (5 == i1)
      {
        a(this, paramString1, getResources().getString(2131363753), 2131363755, paramString2);
        break;
      }
      if (i1 == 0) {
        break;
      }
      a(this, paramString1, getResources().getString(2131363752), 2131363754, paramString2);
      break;
    }
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_v_of_type_Int & 0x8) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362461);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837669;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_v_of_type_Int & 0x4000) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362475);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837670;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 9;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_v_of_type_Int & 0x8000) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362476);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130837668;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 10;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_v_of_type_Int & 0x200) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362466);
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838342;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((this.jdField_v_of_type_Int & 0x100) == 0)
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = super.getString(2131362465);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).k = 2130838340;
      ((PublicAccountBrowser.ActionSheetItem)localObject).l = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = new ArrayList();
    if ((this.jdField_v_of_type_Int & 0x2000) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362474);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.k = 2130838486;
      localActionSheetItem.l = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((this.jdField_v_of_type_Int & 0x20) == 0)
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362463);
      localActionSheetItem.k = 2130837667;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.l = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = super.getString(2131362464);
    localActionSheetItem.k = 2130838333;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.l = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  @TargetApi(9)
  protected View b()
  {
    View localView = super.getLayoutInflater().inflate(2130903193, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131297099));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131297101));
    GridView localGridView2 = (GridView)localView.findViewById(2131297100);
    GridView localGridView1 = (GridView)localView.findViewById(2131297102);
    Object localObject1 = (TextView)localView.findViewById(2131296507);
    ((TextView)localObject1).setText(2131362794);
    ((TextView)localObject1).setOnClickListener(new bcf(this));
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
      this.jdField_y_of_type_Int = i1;
      int i2 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((i2 * 75 + (i2 - 1) * 10 + 3) * this.jdField_c_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i2);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      i2 = ((ViewGroup.LayoutParams)localObject1).width;
      this.jdField_x_of_type_Int = i2;
      localView.post(new bcg(this, i1, i2));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public void b()
  {
    Object localObject2;
    if (!this.q)
    {
      this.q = true;
      localObject1 = getIntent();
      this.K = ((Intent)localObject1).getStringExtra("url");
      if (this.K == null) {
        this.K = ((Intent)localObject1).getStringExtra("key_params_qq");
      }
      if (this.K == null) {
        this.K = "";
      }
      this.r = ((Intent)localObject1).getExtras().getBoolean("isFullScreen", false);
      localObject2 = ((Intent)localObject1).getStringExtra("options");
      if (localObject2 == null) {}
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      this.K = ((JSONObject)localObject2).getString("url");
      if (!((Intent)localObject1).hasExtra("key_isReadModeEnabled")) {
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      }
      ((Intent)localObject1).putExtra("ba_is_login", ((JSONObject)localObject2).optBoolean("ba_is_login", true));
      ((Intent)localObject1).putExtra("isShowAd", ((JSONObject)localObject2).optBoolean("isShowAd", true));
      ((Intent)localObject1).putExtra("avoidLoginWeb", ((JSONObject)localObject2).optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          m();
          this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131296558));
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          if ("1103".equals(localObject1)) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          a(getIntent());
          return;
          a(getIntent());
          return;
          localJSONException = localJSONException;
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser", 2, localJSONException.toString());
          }
        }
        setContentView(2130903079);
        this.jdField_b_of_type_AndroidViewView = findViewById(2131296648);
        removeWebViewLayerType();
        this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      catch (Throwable localThrowable)
      {
        break label469;
      }
    }
    a((Intent)localObject1, this.K);
    if (this.r)
    {
      getWindow().setFlags(1024, 1024);
      setContentViewNoTitle(2130903079);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131296648);
      t();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296640));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131296639));
      localObject1 = ThemeUtil.getCurrentThemeInfo().getString("themeId");
      this.jdField_a_of_type_AndroidWidgetAbsoluteLayout = ((AbsoluteLayout)findViewById(2131296642));
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((CustomWebView)findViewById(2131296643));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296650));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296651));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296652));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296656));
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296657));
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131296653);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296649));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramInt, 0).sendToTarget();
  }
  
  /* Error */
  public void b(Intent paramIntent, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_1
    //   4: ifnull +17 -> 21
    //   7: aload_2
    //   8: invokestatic 921	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 287	com/tencent/mobileqq/activity/QQBrowserActivity:r	Z
    //   18: ifeq +12 -> 30
    //   21: aload_0
    //   22: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   25: iconst_0
    //   26: invokevirtual 1421	com/tencent/biz/pubaccount/CustomWebView:setVisibility	(I)V
    //   29: return
    //   30: aload_2
    //   31: ifnull +190 -> 221
    //   34: aload_2
    //   35: invokestatic 959	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   38: astore 8
    //   40: aload 8
    //   42: ldc_w 1423
    //   45: invokevirtual 967	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 7
    //   52: invokestatic 921	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +68 -> 123
    //   58: aload 7
    //   60: ldc_w 1425
    //   63: invokevirtual 1428	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +720 -> 786
    //   69: aload 7
    //   71: iconst_2
    //   72: invokevirtual 1431	java/lang/String:substring	(I)Ljava/lang/String;
    //   75: astore 7
    //   77: aload 7
    //   79: bipush 16
    //   81: invokestatic 1437	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   84: l2i
    //   85: istore 4
    //   87: iload 4
    //   89: istore_3
    //   90: aload 7
    //   92: invokevirtual 999	java/lang/String:length	()I
    //   95: bipush 6
    //   97: if_icmpgt +10 -> 107
    //   100: iload 4
    //   102: ldc_w 1438
    //   105: ior
    //   106: istore_3
    //   107: aload_0
    //   108: getfield 415	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   111: iconst_0
    //   112: invokevirtual 1441	android/view/ViewGroup:setBackgroundResource	(I)V
    //   115: aload_0
    //   116: getfield 415	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   119: iload_3
    //   120: invokevirtual 1444	android/view/ViewGroup:setBackgroundColor	(I)V
    //   123: aload_0
    //   124: getfield 279	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_v_of_type_Int	I
    //   127: iconst_4
    //   128: iand
    //   129: ifne +20 -> 149
    //   132: aload_0
    //   133: getfield 422	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_h_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   136: aload_0
    //   137: invokevirtual 1192	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   140: ldc_w 1445
    //   143: invokevirtual 365	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   146: invokevirtual 398	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   149: aload 8
    //   151: ldc_w 1447
    //   154: invokevirtual 967	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 7
    //   159: aload 7
    //   161: invokestatic 921	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +57 -> 221
    //   167: aload 7
    //   169: ldc_w 1425
    //   172: invokevirtual 1428	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   175: ifeq +608 -> 783
    //   178: aload 7
    //   180: iconst_2
    //   181: invokevirtual 1431	java/lang/String:substring	(I)Ljava/lang/String;
    //   184: astore 7
    //   186: aload 7
    //   188: bipush 16
    //   190: invokestatic 1437	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   193: l2i
    //   194: istore 4
    //   196: iload 4
    //   198: istore_3
    //   199: aload 7
    //   201: invokevirtual 999	java/lang/String:length	()I
    //   204: bipush 6
    //   206: if_icmpgt +10 -> 216
    //   209: iload 4
    //   211: ldc_w 1438
    //   214: ior
    //   215: istore_3
    //   216: aload_0
    //   217: iload_3
    //   218: invokevirtual 1449	com/tencent/mobileqq/activity/QQBrowserActivity:b	(I)V
    //   221: aload_0
    //   222: getfield 279	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_v_of_type_Int	I
    //   225: ldc_w 1450
    //   228: iand
    //   229: ifeq +513 -> 742
    //   232: aload_2
    //   233: ldc_w 1452
    //   236: invokevirtual 1428	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   239: ifeq +503 -> 742
    //   242: aload_2
    //   243: invokestatic 1456	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   246: ldc_w 1458
    //   249: invokevirtual 629	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   252: ifeq +490 -> 742
    //   255: aload_0
    //   256: iconst_1
    //   257: putfield 266	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_Boolean	Z
    //   260: aload_0
    //   261: invokevirtual 1340	com/tencent/mobileqq/activity/QQBrowserActivity:getWindow	()Landroid/view/Window;
    //   264: ldc_w 1459
    //   267: invokevirtual 1462	android/view/Window:setBackgroundDrawableResource	(I)V
    //   270: aload_0
    //   271: invokevirtual 1465	com/tencent/mobileqq/activity/QQBrowserActivity:hideTitleBar	()V
    //   274: aload_0
    //   275: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   278: invokevirtual 1468	com/tencent/biz/pubaccount/CustomWebView:getView	()Landroid/view/View;
    //   281: iconst_0
    //   282: invokevirtual 1469	android/view/View:setBackgroundColor	(I)V
    //   285: aload_0
    //   286: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   289: invokevirtual 1468	com/tencent/biz/pubaccount/CustomWebView:getView	()Landroid/view/View;
    //   292: invokevirtual 1472	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   295: iconst_0
    //   296: invokevirtual 1477	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   299: aload_0
    //   300: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   303: iconst_0
    //   304: invokevirtual 1478	com/tencent/biz/pubaccount/CustomWebView:setBackgroundColor	(I)V
    //   307: aload_0
    //   308: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   311: invokevirtual 1479	com/tencent/biz/pubaccount/CustomWebView:getBackground	()Landroid/graphics/drawable/Drawable;
    //   314: iconst_0
    //   315: invokevirtual 1477	android/graphics/drawable/Drawable:setAlpha	(I)V
    //   318: aload_0
    //   319: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   322: ifnull +11 -> 333
    //   325: aload_0
    //   326: getfield 201	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   329: iconst_0
    //   330: invokevirtual 1421	com/tencent/biz/pubaccount/CustomWebView:setVisibility	(I)V
    //   333: aload_2
    //   334: invokestatic 921	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +22 -> 359
    //   340: aload_2
    //   341: ldc_w 1481
    //   344: invokevirtual 1484	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   347: ifeq +12 -> 359
    //   350: aload_1
    //   351: ldc_w 896
    //   354: iconst_1
    //   355: invokevirtual 929	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   358: pop
    //   359: aload_0
    //   360: aload_1
    //   361: ldc_w 1486
    //   364: invokevirtual 889	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   367: putfield 225	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   370: aload_0
    //   371: aload_1
    //   372: ldc_w 1488
    //   375: invokevirtual 889	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   378: putfield 227	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   386: ldc_w 1490
    //   389: iconst_0
    //   390: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   393: putfield 237	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_d_of_type_Boolean	Z
    //   396: aload_0
    //   397: aload_1
    //   398: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   401: ldc_w 1492
    //   404: iconst_0
    //   405: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   408: putfield 239	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_e_of_type_Boolean	Z
    //   411: iload 6
    //   413: istore 5
    //   415: aload_0
    //   416: getfield 923	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   419: ifne +24 -> 443
    //   422: aload_0
    //   423: invokevirtual 900	com/tencent/mobileqq/activity/QQBrowserActivity:getIntent	()Landroid/content/Intent;
    //   426: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   429: ldc_w 925
    //   432: iconst_0
    //   433: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   436: ifeq +322 -> 758
    //   439: iload 6
    //   441: istore 5
    //   443: aload_0
    //   444: iload 5
    //   446: putfield 923	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   449: aload_1
    //   450: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   453: ldc 27
    //   455: iconst_0
    //   456: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   459: istore 5
    //   461: aload_0
    //   462: aload_1
    //   463: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   466: ldc 30
    //   468: iconst_0
    //   469: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   472: putfield 241	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_f_of_type_Boolean	Z
    //   475: aload_0
    //   476: aload_1
    //   477: invokevirtual 865	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   480: ldc 33
    //   482: iconst_0
    //   483: invokevirtual 868	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   486: putfield 243	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_v_of_type_Boolean	Z
    //   489: invokestatic 462	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +36 -> 528
    //   495: ldc 145
    //   497: iconst_2
    //   498: new 444	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 1494
    //   508: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_2
    //   512: iconst_0
    //   513: anewarray 367	java/lang/String
    //   516: invokestatic 1497	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   519: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: aload_0
    //   529: getfield 225	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   532: ifnull +232 -> 764
    //   535: aload_0
    //   536: getfield 225	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   539: invokevirtual 999	java/lang/String:length	()I
    //   542: ifle +222 -> 764
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 225	com/tencent/mobileqq/activity/QQBrowserActivity:W	Ljava/lang/String;
    //   550: invokevirtual 1005	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   553: aload_0
    //   554: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   557: aload_0
    //   558: invokevirtual 1376	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   561: aload_0
    //   562: getfield 1002	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   565: aload_0
    //   566: invokevirtual 404	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   569: aload_0
    //   570: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   573: aload_0
    //   574: invokevirtual 1192	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   577: ldc_w 1498
    //   580: invokevirtual 365	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   583: invokevirtual 1043	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   586: aload_0
    //   587: getfield 923	com/tencent/mobileqq/activity/QQBrowserActivity:D	Z
    //   590: ifne +21 -> 611
    //   593: aload_0
    //   594: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   597: iconst_0
    //   598: invokevirtual 313	android/widget/ImageView:setVisibility	(I)V
    //   601: aload_0
    //   602: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   605: ldc_w 1050
    //   608: invokevirtual 1047	android/widget/ImageView:setImageResource	(I)V
    //   611: iload 5
    //   613: ifeq +11 -> 624
    //   616: aload_0
    //   617: getfield 422	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_h_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   620: iconst_4
    //   621: invokevirtual 1000	android/widget/TextView:setVisibility	(I)V
    //   624: aload_0
    //   625: getfield 241	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_f_of_type_Boolean	Z
    //   628: ifeq -599 -> 29
    //   631: aload_0
    //   632: getfield 1002	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   635: ldc_w 1499
    //   638: invokevirtual 1256	android/widget/TextView:setText	(I)V
    //   641: aload_0
    //   642: getfield 1002	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   645: iconst_0
    //   646: invokevirtual 1000	android/widget/TextView:setVisibility	(I)V
    //   649: aload_0
    //   650: getfield 1002	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_j_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   653: invokevirtual 1502	android/widget/TextView:bringToFront	()V
    //   656: aload_0
    //   657: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   660: iconst_0
    //   661: invokevirtual 1047	android/widget/ImageView:setImageResource	(I)V
    //   664: aload_0
    //   665: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   668: iconst_0
    //   669: invokevirtual 1503	android/widget/ImageView:setBackgroundColor	(I)V
    //   672: aload_0
    //   673: getfield 418	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   676: bipush 8
    //   678: invokevirtual 313	android/widget/ImageView:setVisibility	(I)V
    //   681: return
    //   682: astore 7
    //   684: invokestatic 984	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   687: ifeq -564 -> 123
    //   690: ldc 145
    //   692: iconst_4
    //   693: ldc_w 1505
    //   696: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   699: goto -576 -> 123
    //   702: astore 7
    //   704: invokestatic 984	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   707: ifeq -486 -> 221
    //   710: ldc 145
    //   712: iconst_4
    //   713: ldc_w 1507
    //   716: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   719: goto -498 -> 221
    //   722: astore 7
    //   724: invokestatic 984	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   727: ifeq -506 -> 221
    //   730: ldc 145
    //   732: iconst_4
    //   733: ldc_w 1509
    //   736: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: goto -518 -> 221
    //   742: aload_0
    //   743: iconst_0
    //   744: putfield 266	com/tencent/mobileqq/activity/QQBrowserActivity:jdField_p_of_type_Boolean	Z
    //   747: aload_0
    //   748: invokevirtual 1340	com/tencent/mobileqq/activity/QQBrowserActivity:getWindow	()Landroid/view/Window;
    //   751: aconst_null
    //   752: invokevirtual 1512	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   755: goto -437 -> 318
    //   758: iconst_0
    //   759: istore 5
    //   761: goto -318 -> 443
    //   764: aload_0
    //   765: ldc 223
    //   767: invokevirtual 1005	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   770: goto -217 -> 553
    //   773: astore 7
    //   775: goto -457 -> 318
    //   778: astore 7
    //   780: goto -481 -> 299
    //   783: goto -597 -> 186
    //   786: goto -709 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	QQBrowserActivity
    //   0	789	1	paramIntent	Intent
    //   0	789	2	paramString	String
    //   89	129	3	i1	int
    //   85	130	4	i2	int
    //   413	347	5	bool1	boolean
    //   1	439	6	bool2	boolean
    //   48	152	7	str	String
    //   682	1	7	localNumberFormatException1	NumberFormatException
    //   702	1	7	localUnsupportedOperationException	java.lang.UnsupportedOperationException
    //   722	1	7	localNumberFormatException2	NumberFormatException
    //   773	1	7	localException1	Exception
    //   778	1	7	localException2	Exception
    //   38	112	8	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   77	87	682	java/lang/NumberFormatException
    //   90	100	682	java/lang/NumberFormatException
    //   107	123	682	java/lang/NumberFormatException
    //   34	77	702	java/lang/UnsupportedOperationException
    //   77	87	702	java/lang/UnsupportedOperationException
    //   90	100	702	java/lang/UnsupportedOperationException
    //   107	123	702	java/lang/UnsupportedOperationException
    //   123	149	702	java/lang/UnsupportedOperationException
    //   149	186	702	java/lang/UnsupportedOperationException
    //   186	196	702	java/lang/UnsupportedOperationException
    //   199	209	702	java/lang/UnsupportedOperationException
    //   216	221	702	java/lang/UnsupportedOperationException
    //   684	699	702	java/lang/UnsupportedOperationException
    //   724	739	702	java/lang/UnsupportedOperationException
    //   186	196	722	java/lang/NumberFormatException
    //   199	209	722	java/lang/NumberFormatException
    //   216	221	722	java/lang/NumberFormatException
    //   299	318	773	java/lang/Exception
    //   274	299	778	java/lang/Exception
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    int i2 = 0;
    if (!TextUtils.isEmpty(paramString1))
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetTextView.bringToFront();
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
      if (paramString3 != null)
      {
        this.Y = paramString3.trim();
        return;
      }
      this.Y = null;
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
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString);
  }
  
  protected void b_()
  {
    super.b_();
    if ((this.t) && (!TextUtils.isEmpty(this.L)) && (GesturePWDUtils.getGesturePWDState(this, this.L) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.L) == 21)) {
      w();
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
    return null;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  protected void c_()
  {
    super.c_();
    if (QLog.isColorLevel()) {
      QLog.d("baseactivity", 2, "QQBrowserActivity.uin=" + this.L);
    }
    if ((!mAppForground) && (this.t) && (!TextUtils.isEmpty(this.L)) && (GesturePWDUtils.getGesturePWDState(this, this.L) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.L) == 21)) {
      w();
    }
  }
  
  public String d()
  {
    String str2 = this.K;
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
  
  protected void d() {}
  
  public boolean d()
  {
    return super.d();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 > 10000)
    {
      int i1 = (paramInt1 - 10000) / 1000;
      byte b1 = (byte)((paramInt1 - 10000) % 1000);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(i1);
        if (localObject1 != null)
        {
          ((WebViewPlugin)localObject1).onActivityResult(paramIntent, b1, paramInt2);
          super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
          return;
        }
      }
    }
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject1).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject1).put("data", paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 9, (Map)localObject1)))
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
        for (localObject1 = null;; localObject1 = paramIntent.getData())
        {
          ReflectionUtil.a(BaseApplication.getContext(), jdField_a_of_type_AndroidWebkitValueCallback, (Uri)localObject1);
          jdField_a_of_type_AndroidWebkitValueCallback = null;
          break;
        }
        localObject1 = new Intent(this, ChatActivity.class);
        Object localObject2 = paramIntent.getExtras();
        Bundle localBundle = new Bundle((Bundle)localObject2);
        ((Bundle)localObject2).getString("uin");
        ((Bundle)localObject2).getInt("uintype", 0);
        ((Intent)localObject1).putExtras(localBundle);
        startActivity((Intent)localObject1);
        continue;
        QfavBuilder.a(this, paramIntent);
        continue;
        localObject1 = paramIntent.getStringExtra("callbackSn");
        localObject2 = paramIntent.getStringExtra("result");
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject1 + "',{'r':0,'result':" + (String)localObject2 + "});");
        try
        {
          if (new JSONObject((String)localObject2).getInt("resultCode") == 0) {
            bool = true;
          }
          this.jdField_h_of_type_Boolean = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQBrowser", 2, "onActivityResult: mPayActionSucc=" + this.jdField_h_of_type_Boolean);
        }
        catch (Exception localException) {}
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
    jdField_w_of_type_Int += 1;
    StartupTracker.a(null, "Web_qqbrowser_dooncreate");
    setTheme(2131624265);
    super.doOnCreate(paramBundle);
    e();
    StartupTracker.a("Web_qqbrowser_dooncreate", null);
    return true;
  }
  
  public void doOnDestroy()
  {
    Object localObject;
    if (!this.jdField_y_of_type_Boolean)
    {
      this.jdField_y_of_type_Boolean = true;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("id", getPathNodeID());
      ((Bundle)localObject).putLong("time", SystemClock.uptimeMillis());
      localObject = DataFactory.makeIPCRequestPacket("pathPopActivity", null, -1, (Bundle)localObject);
      WebIPCOperator.getInstance().sendServiceIpcReq((Bundle)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver != null) {
      WebIPCOperator.getInstance().unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    }
    jdField_w_of_type_Int -= 1;
    super.doOnDestroy();
    if (jdField_w_of_type_Int == 0) {
      WebIPCOperator.getInstance().getClient().doUnbindService(getApplicationContext());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 4, null);
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = null;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_AndroidOsHandler != null)) {
      this.jdField_c_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
    }
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a("about:blank");
    }
    int i3;
    String str;
    StringBuilder localStringBuilder;
    int i1;
    if (this.jdField_l_of_type_Boolean)
    {
      i3 = (int)(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      localObject = NetworkUtil.b(this) + "";
      str = this.V;
      localStringBuilder = new StringBuilder().append("");
      if (!this.jdField_w_of_type_Boolean) {
        break label338;
      }
      i1 = 1;
      if (!this.jdField_x_of_type_Boolean) {
        break label343;
      }
    }
    label338:
    label343:
    for (int i2 = 1;; i2 = 0)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_stay_in_url", 0, 1, i3, (String)localObject, str, "", i2 + (i1 << 1));
      return;
      i1 = 0;
      break;
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
        break;
      }
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
      n();
      return;
      i1 = 0;
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 6, null);
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
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.b();
    }
    if ((this.jdField_p_of_type_Boolean == true) && (this.jdField_a_of_type_AndroidViewWindowManager != null) && (this.jdField_c_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_c_of_type_AndroidViewView);
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
    }
    StartupTracker.a(null, "Web_qqbrowser_doonresume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.onResume();
    }
    Intent localIntent = new Intent("tencent.notify.foreground");
    localIntent.putExtra("selfuin", this.L);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 5, null);
    }
    if (MyAppApi.d()) {
      MyAppApi.a().a(this);
    }
    if (this.jdField_p_of_type_Boolean == true) {
      y();
    }
    StartupTracker.a("Web_qqbrowser_doonresume", null);
  }
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.putExtra("selfuin", this.L);
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
  
  public void e()
  {
    long l2 = System.currentTimeMillis();
    x();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init variable, cost = " + (l1 - l2));
    }
    b();
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init view, cost = " + (l2 - l1));
    }
    h();
    l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init browser, cost = " + (l1 - l2));
    }
    n();
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init param, cost = " + (l2 - l1));
    }
    if (!WebIPCOperator.getInstance().isServiceClientBinded())
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new bch(this);
      WebIPCOperator.getInstance().registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
      WebIPCOperator.getInstance().getClient().doBindService(getApplicationContext());
      return;
    }
    u();
  }
  
  public boolean e()
  {
    return super.e();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a();
    }
  }
  
  public void finish()
  {
    if (!this.jdField_y_of_type_Boolean)
    {
      this.jdField_y_of_type_Boolean = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", getPathNodeID());
      localBundle.putLong("time", SystemClock.uptimeMillis());
      localBundle = DataFactory.makeIPCRequestPacket("pathPopActivity", null, -1, localBundle);
      WebIPCOperator.getInstance().sendServiceIpcReq(localBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 7, null);
    }
    super.finish();
    if (this.jdField_v_of_type_Boolean) {
      overridePendingTransition(0, 2130968584);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 8, null);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.f();
    }
  }
  
  public int getPathNodeID()
  {
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getView().setOnTouchListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient = new QQBrowserActivity.NativeChromeClient(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine = new WebViewPluginEngine(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(getIntent().getExtras().getStringArray("insertPluginsArray"));
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine);
    A();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebViewClient);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity$NativeChromeClient);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setDrawingCacheEnabled(true);
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
    String str;
    Object localObject3;
    Object localObject1;
    if (localWebSettings != null)
    {
      if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("enable_cache_a", Boolean.valueOf(false)).booleanValue()) {
        localWebSettings.setCacheMode(2);
      }
      str = a();
      localObject3 = localWebSettings.getUserAgentString();
      switch (HttpUtil.a())
      {
      case 0: 
      default: 
        localObject1 = "";
      }
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject3 = new StringBuilder((String)localObject2).append(" ").append(QZoneHelper.a());
      label275:
      int i1;
      label398:
      boolean bool;
      if (TextUtils.isEmpty(str))
      {
        localObject2 = "";
        localWebSettings.setUserAgentString((String)localObject2 + " " + "QQ/" + "5.3.1" + "." + "607" + (String)localObject1);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setSavePassword(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        if (this.u >= 8)
        {
          localWebSettings.setPluginState(WebSettings.PluginState.ON);
          localObject1 = getPackageManager();
          if ((!((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch")) && (!((PackageManager)localObject1).hasSystemFeature("android.hardware.faketouch.multitouch.distinct"))) {
            break label705;
          }
          i1 = 1;
          if (i1 != 0) {
            break label710;
          }
          bool = true;
          label404:
          localWebSettings.setDisplayZoomControls(bool);
        }
        localWebSettings.setPluginsEnabled(true);
        if (1 != this.jdField_e_of_type_Int) {
          break label715;
        }
        localWebSettings.setCacheMode(2);
        label430:
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localObject3 = MobileQQ.getMobileQQ().getProcessName();
        localObject2 = "";
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          i1 = ((String)localObject3).lastIndexOf(':');
          localObject1 = localObject2;
          if (i1 > -1) {
            localObject1 = "_" + ((String)localObject3).substring(i1);
          }
        }
        localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject1, 0).getPath());
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + (String)localObject1, 0).getPath());
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.requestFocus();
        label620:
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setDownloadListener(new bcb(this));
        return;
        localObject1 = " NetType/UNKNOWN";
        continue;
        localObject1 = " NetType/WIFI";
        continue;
        localObject1 = " NetType/2G";
        continue;
        localObject1 = " NetType/3G";
        continue;
        localObject1 = " NetType/4G";
        continue;
        localObject2 = " " + str;
        break label275;
        label705:
        i1 = 0;
        break label398;
        label710:
        bool = false;
        break label404;
        label715:
        if (4 != this.jdField_e_of_type_Int) {
          break label430;
        }
        localWebSettings.setCacheMode(0);
      }
      catch (Exception localException)
      {
        break label620;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      paramMessage = (String)paramMessage.obj;
    }
    for (;;)
    {
      try
      {
        paramMessage = new JSONObject(paramMessage);
        localObject1 = paramMessage.getJSONObject("icon");
        Object localObject2 = paramMessage.getJSONObject("content");
        paramMessage = ((JSONObject)localObject1).getString("timestamp");
        localObject1 = ((JSONObject)localObject1).getString("url");
        String str = ((JSONObject)localObject2).getString("timestamp");
        localObject2 = ((JSONObject)localObject2).getString("memo");
        Object localObject3 = getSharedPreferences("qb_info", 0);
        if (localObject3 != null)
        {
          localObject3 = ((SharedPreferences)localObject3).edit();
          ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
          ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
          ((SharedPreferences.Editor)localObject3).putString("content_time", str);
          ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
          ((SharedPreferences.Editor)localObject3).commit();
        }
      }
      catch (Exception paramMessage)
      {
        Object localObject1;
        continue;
      }
      return true;
      if (paramMessage.what == 101)
      {
        if ((!isFinishing()) && (!this.jdField_k_of_type_Boolean))
        {
          paramMessage = (Bundle)paramMessage.obj;
          if (paramMessage != null)
          {
            localObject1 = getSharedPreferences("qb_info", 0);
            if (localObject1 != null)
            {
              paramMessage.putString("param_content_memo", ((SharedPreferences)localObject1).getString("content_memo", null));
              paramMessage.putString("param_icon_path", ((SharedPreferences)localObject1).getString("icon_url", null));
            }
            paramMessage.putString("param_user_agent", this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().getUserAgentString());
            paramMessage.putString("param_refer_url", this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl());
            localObject1 = paramMessage.getString("qb_param_url");
            if ((localObject1 != null) && (((String)localObject1).length() != 0))
            {
              paramMessage.remove("qb_param_url");
              UniformDownload.a(this, (String)localObject1, paramMessage);
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd.d();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
      View localView = b();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void m()
  {
    Object localObject5 = null;
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296655));
    SharedPreferences localSharedPreferences = getSharedPreferences("qb_info", 0);
    boolean bool2 = MttLoader.b(this);
    boolean bool1;
    long l1;
    if (localSharedPreferences != null)
    {
      bool1 = localSharedPreferences.getBoolean("click_icon", false);
      l1 = localSharedPreferences.getLong("update_time", 0L);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
      if ((bool2) || (bool1)) {
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        return;
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 86400000L)
        {
          Object localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putLong("update_time", l2);
          ((SharedPreferences.Editor)localObject1).commit();
          try
          {
            localObject4 = (TelephonyManager)getSystemService("phone");
            localObject1 = ((TelephonyManager)localObject4).getSubscriberId();
            try
            {
              str1 = ((TelephonyManager)localObject4).getDeviceId();
              localObject4 = localObject1;
              localObject1 = str1;
              if (localSharedPreferences == null) {
                break label397;
              }
              str2 = localSharedPreferences.getString("icon_time", null);
              str1 = localSharedPreferences.getString("content_time", null);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Object localObject2;
                Object localObject3;
                continue;
                String str1 = null;
                String str2 = null;
              }
            }
            localObject4 = "imsi=" + (String)localObject4 + "&paK=" + getApplicationContext().getPackageName() + "&imei=" + (String)localObject1 + "&itime=" + str2 + "&ctime=" + str1;
          }
          catch (Exception localException1)
          {
            try
            {
              Object localObject4;
              localObject1 = "24Xdf8j6".getBytes("utf-8");
              if (localObject1 != null)
              {
                try
                {
                  localObject4 = ((String)localObject4).getBytes("utf-8");
                  if (localObject4 == null) {
                    continue;
                  }
                  localObject1 = DesUtils.DesEncrypt((byte[])localObject1, (byte[])localObject4, 1);
                  new Thread(new bcd(this, "http://mqqad.html5.qq.com/adjs?p=" + URLEncoder.encode(Base64Util.a((byte[])localObject1, 2)))).start();
                  return;
                }
                catch (Throwable localThrowable)
                {
                  return;
                }
                localException1 = localException1;
                localObject2 = null;
                str1 = null;
                localObject4 = localObject2;
                localObject2 = str1;
              }
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                localObject3 = localObject5;
              }
            }
          }
        }
      }
      label397:
      l1 = 0L;
      bool1 = true;
    }
  }
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    this.L = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    Object localObject;
    if ((this.jdField_v_of_type_Int & 0x10000) != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setCacheMode(2);
      }
    }
    c();
    if (this.o) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginAd = new Ad(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 3, null)) {}
    CookieSyncManager.createInstance(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getContext());
    CookieSyncManager.getInstance().sync();
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 21, null))
    {
      if (this.jdField_l_of_type_Boolean)
      {
        if (this.jdField_f_of_type_Long > 0L) {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)(System.currentTimeMillis() - this.jdField_f_of_type_Long), "", "", "", "");
        }
        localObject = CookieManager.getInstance();
        ((CookieManager)localObject).setAcceptCookie(true);
        ((CookieManager)localObject).setCookie("http://xiaoqu.qq.com/", "reportData = {'time': " + this.jdField_f_of_type_Long + ", 'isFromLeba': " + this.jdField_w_of_type_Boolean + ", 'hasRedDot': " + this.jdField_x_of_type_Boolean + "}; domain=xiaoqu.qq.com; path=/");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.K);
    }
    if ((this.jdField_m_of_type_JavaLangString != null) && (this.jdField_m_of_type_JavaLangString.length() > 0)) {}
    for (this.V = this.jdField_m_of_type_JavaLangString;; this.V = this.K)
    {
      WebProcessManager.a(true);
      return;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    for (;;)
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(this.V);
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        paramView = new HashMap(1);
        paramView.put("target", Integer.valueOf(2));
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 12, paramView))) {
          continue;
        }
        f();
        z();
        return;
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetImageView)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 13, null))) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.goForward();
        z();
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetImageView)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.reload();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setOnCustomScroolChangeListener(null);
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          return;
        }
        paramView = d();
        if (TextUtils.isEmpty(paramView)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramView);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView) {}
      try
      {
        B();
        C();
        label234:
        if (!a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl(), true, "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079")) {
          continue;
        }
        finish();
        return;
        if ((paramView == this.jdField_p_of_type_AndroidWidgetImageView) || (paramView == this.jdField_k_of_type_AndroidWidgetTextView))
        {
          paramView = new Intent();
          paramView.setAction("SignInSbumited");
          sendBroadcast(paramView);
          if (!TextUtils.isEmpty(this.Y))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.Y, new String[] { "" });
            return;
          }
          l();
          return;
        }
        if (paramView == this.jdField_j_of_type_AndroidWidgetTextView)
        {
          paramView = new Intent();
          paramView.setAction("SignInSbumited");
          sendBroadcast(paramView);
          if (this.jdField_e_of_type_Int == 5)
          {
            paramView = this.jdField_j_of_type_AndroidWidgetTextView.getText().toString();
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
            return;
          }
          if (!TextUtils.isEmpty(this.Y))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.Y, new String[] { "" });
            return;
          }
          if (this.jdField_f_of_type_Boolean)
          {
            onBackPressed();
            return;
          }
          l();
          return;
        }
        if (paramView == this.jdField_h_of_type_AndroidWidgetTextView)
        {
          paramView = new HashMap(1);
          paramView.put("target", Integer.valueOf(1));
          if (((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 12, paramView))) || (this.jdField_e_of_type_Int != 5)) {
            continue;
          }
          paramView = this.jdField_h_of_type_AndroidWidgetTextView.getText().toString();
          String str1 = getIntent().getStringExtra("leftViewText");
          String str2 = getTextTitle();
          if ((paramView.equals(str1)) || ((str2 != null) && (paramView.equals(str2))))
          {
            onBackPressed();
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
          return;
        }
        if (paramView != this.jdField_d_of_type_AndroidWidgetImageView) {
          continue;
        }
        a(e(), false);
        return;
      }
      catch (Throwable paramView)
      {
        break label234;
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_z_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    this.jdField_A_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginHole == null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      paramConfiguration = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.leftMargin = ((int)(this.jdField_z_of_type_Int - 50.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      paramConfiguration.topMargin = ((int)(this.jdField_A_of_type_Int - 100.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginAd.a())) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginAd.g();
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView != null) && (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView != null))
    {
      if (this.jdField_z_of_type_Int >= this.jdField_y_of_type_Int) {
        break label181;
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.jdField_z_of_type_Int < this.jdField_x_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      label181:
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
    boolean bool;
    int i1;
    label174:
    StringBuilder localStringBuilder;
    int i2;
    if ((int)(Math.random() * 1000.0D) == 95)
    {
      bool = true;
      this.jdField_l_of_type_Boolean = bool;
      this.jdField_f_of_type_Long = getIntent().getLongExtra("plugin_start_time", 0L);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      super.onCreate(paramBundle);
      if (this.jdField_f_of_type_Long > 0L) {
        getIntent().putExtra("plugin_start_time", 0L);
      }
      this.jdField_w_of_type_Boolean = getIntent().getBooleanExtra("is_from_leba", false);
      this.jdField_x_of_type_Boolean = getIntent().getBooleanExtra("has_red_dot", false);
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_c_of_type_Long);
      }
      if (this.jdField_l_of_type_Boolean)
      {
        if (this.jdField_f_of_type_Long <= 0L) {
          break label421;
        }
        i1 = (int)(this.jdField_c_of_type_Long - this.jdField_f_of_type_Long);
        paramBundle = NetworkUtil.b(this) + "";
        localStringBuilder = new StringBuilder().append("");
        if (!this.jdField_w_of_type_Boolean) {
          break label426;
        }
        i2 = 1;
        label220:
        if (!this.jdField_x_of_type_Boolean) {
          break label431;
        }
      }
    }
    label421:
    label426:
    label431:
    for (int i3 = 1;; i3 = 0)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_create", 0, 1, i1, paramBundle, "", "", i3 + (i2 << 1));
      paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
      if (("Xiaomi_MI 2".equals(paramBundle)) && (this.u == 16))
      {
        this.jdField_i_of_type_Boolean = true;
        if (this.jdField_c_of_type_AndroidOsHandler == null) {
          this.jdField_c_of_type_AndroidOsHandler = new Handler();
        }
      }
      if ((this.u > 10) && (!"Meizu_M040".equals(paramBundle))) {
        getWindow().addFlags(16777216);
      }
      getWindow().setFormat(-3);
      paramBundle = new StatFs("/data");
      if ((int)(paramBundle.getAvailableBlocks() * paramBundle.getBlockSize() / 1048576L) < 1) {
        QRUtils.a(0, 2131363967);
      }
      return;
      bool = false;
      break;
      i1 = 0;
      break label174;
      i2 = 0;
      break label220;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent() != null)) {}
    try
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.stopLoading();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearView();
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.destroy();
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginAd != null) {
            this.jdField_a_of_type_ComTencentBizWebviewpluginAd.c();
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser", 2, "remove webview error");
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser", 2, "onDetachedFromWindow exception : " + String.valueOf(localException2));
          }
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
        QRUtils.a(2, 2131362429);
        return;
      }
      if (i1 == 11)
      {
        paramView = null;
        try
        {
          paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
          paramView = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
          paramAdapterView = "http://guanjia.qq.com/online_server/m_report.html?url=" + paramAdapterView + "&qq=" + paramView + "&_wv=7";
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView);
          startActivity(paramView);
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (UnsupportedEncodingException paramAdapterView)
        {
          for (;;)
          {
            paramAdapterView = paramView;
            if (QLog.isColorLevel())
            {
              QLog.d("QQBrowser", 2, "encode url failed, because UTF-8 is unknown");
              paramAdapterView = paramView;
            }
          }
        }
      }
      if (i1 == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 1, false);
        }
        for (;;)
        {
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
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
          ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          for (;;)
          {
            QRUtils.a(1, 2131362446);
          }
        }
      }
      if (i1 == 5)
      {
        a(paramAdapterView, true, "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367");
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
        return;
      }
      if (i1 == 6)
      {
        a(paramAdapterView, true);
        return;
      }
    } while ((i1 != 9) && (i1 != 10));
    paramInt = -1;
    if (!WXShareHelper.a().a()) {
      paramInt = 2131363697;
    }
    while (paramInt != -1)
    {
      QRUtils.a(0, paramInt);
      return;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131363698;
      }
    }
    if (i1 == 9)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 3, true);
      }
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_m_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramAdapterView, 4, true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null);
    return this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 23, null);
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.K, 17, null);
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizWebviewpluginHole != null))
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole.setHole((this.jdField_d_of_type_AndroidViewView.getLeft() + this.jdField_d_of_type_AndroidViewView.getRight()) / 2 - 1, (this.jdField_d_of_type_AndroidViewView.getTop() + this.jdField_d_of_type_AndroidViewView.getBottom()) / 2 - 1, (int)(30.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole.invalidate();
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  protected void q() {}
  
  protected void r() {}
  
  public void s()
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427462));
    this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427462));
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131427464));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_p_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public boolean showPreview()
  {
    long l1 = System.currentTimeMillis();
    b();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init view 1, cost = " + (System.currentTimeMillis() - l1));
    }
    return true;
  }
  
  protected void t()
  {
    this.jdField_z_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    this.jdField_A_of_type_Int = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    findViewById(2131296660).setVisibility(0);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131297766);
    this.jdField_f_of_type_AndroidViewView = findViewById(2131297764);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131297767);
    this.jdField_g_of_type_AndroidViewView = findViewById(2131296758);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131297768);
    Object localObject = getSharedPreferences("secondHandSharePre", 0);
    if (localObject != null) {
      if (((SharedPreferences)localObject).contains("first_float_tip"))
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        localObject = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.jdField_z_of_type_Int - 50.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
        ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_A_of_type_Int - 100.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density));
        this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new bbt(this));
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new bbv(this));
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(new bbw(this));
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(new bbx(this));
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new bby(this));
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)findViewById(2131297765));
      ((SharedPreferences)localObject).edit().putBoolean("first_float_tip", true).commit();
      continue;
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */