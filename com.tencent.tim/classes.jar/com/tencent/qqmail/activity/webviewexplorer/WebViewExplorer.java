package com.tencent.qqmail.activity.webviewexplorer;

import Override;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.attachment.model.QMqqBrowserInfo;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.model.PopularizeMoreOperation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.CustomDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ErrorCallbackWeakRef;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.SuccessCallbackWeakRef;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.PopupMenuAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMPopupWindow.PopupMenuItem;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.FullWindowHelper;
import com.tencent.qqmail.view.ProgressHandler;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import com.tencent.qqmail.view.SmoothScrollableWebView;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.util.EncodingUtils;

public class WebViewExplorer
  extends BaseActivityEx
{
  public static final String ARG_ACCOUNT_ID = "accountid";
  public static final String ARG_AUTO_AUTH = "authAuth";
  public static final String ARG_FROM_READMAIL = "from_readmail";
  public static final String ARG_IS_EDIT_ATTACH = "is_edit_attach";
  public static final String ARG_SAFE_CHECK_LIST = "safe_check_list";
  public static final String ARG_SHOW_TOP_BAR_MENU = "show_top_bar_menu";
  public static final String ARG_TITLE = "title";
  public static final String ARG_URL = "url";
  public static final int REQUEST_CODE_SELECT_CONTACT = 109;
  public static final String TAG = "WebViewExplorer";
  protected static final long TIP_ANIM_TIME = 1000L;
  protected static final long TIP_SHOW_TIME = 3000L;
  protected int MAX_REFRESH_SKEY_TIME = 20;
  protected int MAX_REFRESH_TOKEN_TIME = 20;
  protected int WEB_VIEW_SAFE_CHECK_RETURN_REJECTION = 2;
  protected int WEB_VIEW_SAFE_CHECK_RETURN_TIPS = 1;
  protected boolean autoAuth = false;
  protected BaseWebViewChromeClient baseWebViewChromeClient;
  protected Map<String, String> extraHeader = new HashMap();
  protected boolean firstPageFinished = true;
  private QMUnlockFolderPwdWatcher folderLockWatcher = new WebViewExplorer.1(this);
  protected boolean fromReadMail = false;
  protected long intervalTime = 1000L;
  protected boolean isInnerEditTextFocus = false;
  private boolean isLeftEdgeDrag = false;
  protected boolean isProtectedUrlHasLoad = false;
  protected boolean isRefreshReLoad;
  protected boolean isShowWebViewSafeTip = false;
  protected boolean isWebViewHasPassword = false;
  protected boolean isWebViewSafeBarCloseClick = false;
  protected boolean isWhiteList = false;
  protected long loadTime = System.currentTimeMillis();
  protected ArrayList<String> loadUrlList = new ArrayList();
  protected FolderLockDialog lockDialog;
  private AccountLoginWatcher loginWatcher = new WebViewExplorer.2(this);
  protected int mAccountId;
  protected QMPopupWindow mMoreActionWindow;
  protected ProgressBar mProgressBar;
  protected ProgressHandler mProgressBarHandler;
  private ReportTheUrlToCheckLinkErrorCallback mReportTheUrlToCheckLinkErrorCallback = new ReportTheUrlToCheckLinkErrorCallback(this);
  private ReportTheUrlToCheckLinkSuccessCallback mReportTheUrlToCheckLinkSuccessCallback = new ReportTheUrlToCheckLinkSuccessCallback(this);
  protected HashMap<String, String> mSafeCheckHashMap;
  private Observer mSaveMailDone = new IObserver(new WebViewExplorer.3(this));
  private SendUrlToSafeCheckSuccessCallback mSendUrlToSafeCheckSuccessCallback = new SendUrlToSafeCheckSuccessCallback(this);
  private SendUrlToSafeCheckSuccessCallbackErrorCallback mSendUrlToSafeCheckSuccessCallbackErrorCallback = new SendUrlToSafeCheckSuccessCallbackErrorCallback(this);
  public QMWebView mWebView;
  protected RelativeLayout mWebViewWrapper;
  protected HashMap<String, String> mWebviewImageInfo = new HashMap();
  protected ArrayList<PopularizeMoreOperation> popularizeMoreOperations;
  protected String protocol = "";
  protected String refreshSKeyCallbackId;
  protected int refreshSKeyTime;
  protected String refreshTokenCallbackId;
  protected int refreshTokenTimes;
  protected String safeCheckReportUrl;
  protected ArrayList<String> safeCheckUrls = new ArrayList();
  protected String selectContactsCallbackId;
  protected boolean showTopBarMenu = false;
  protected QMTips tips;
  protected String title = "";
  public QMTopBar topBar;
  protected String url = "";
  protected View videoView;
  protected RelativeLayout webViewSafeBar;
  protected String webViewSafeCheckUrlHost = "url.qmail.com";
  protected String webViewSafeCheckUrlPath = "/cgi-bin/readtemplate";
  protected String[] webViewSafeCheckUrlQuery = { "t=safety", "subtemplate=bad", "evil=0" };
  protected String webViewSafeJmpUrlPath = "/cgi-bin/safejmp";
  protected TextView webViewSafeTip;
  
  private void SendUrlToSafeCheck(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    Object localObject1;
    if ((this.protocol != null) && ((this.protocol.equals("http")) || (this.protocol.equals("https"))))
    {
      localObject1 = this.protocol + "://";
      localObject1 = new QMNetworkRequest((String)localObject1 + "url.qmail.com" + "/cgi-bin/" + "safejmp", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      localObject2 = "action=w_check_link&url=$url$&mailid=$mailid$&sid=$sid$&os=android&version=$version$&from=$from$&from_nick=$from_nick$&to=$to$&spam=$spam$".replace("$url$", Uri.encode(paramString));
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("mailid") == null)) {
        break label431;
      }
      paramString = (String)this.mSafeCheckHashMap.get("mailid");
      label154:
      localObject2 = ((String)localObject2).replace("$mailid$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("sid") == null)) {
        break label437;
      }
      paramString = (String)this.mSafeCheckHashMap.get("sid");
      label197:
      localObject2 = ((String)localObject2).replace("$sid$", paramString).replace("$version$", AppConfig.getCodeVersion());
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("from") == null)) {
        break label443;
      }
      paramString = (String)this.mSafeCheckHashMap.get("from");
      label249:
      localObject2 = ((String)localObject2).replace("$from$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("from_nick") == null)) {
        break label449;
      }
      paramString = (String)this.mSafeCheckHashMap.get("from_nick");
      label292:
      localObject2 = ((String)localObject2).replace("$from_nick$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("to") == null)) {
        break label455;
      }
      paramString = (String)this.mSafeCheckHashMap.get("to");
      label335:
      localObject2 = ((String)localObject2).replace("$to$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("spam") == null)) {
        break label461;
      }
    }
    label431:
    label437:
    label443:
    label449:
    label455:
    label461:
    for (paramString = (String)this.mSafeCheckHashMap.get("spam");; paramString = "")
    {
      ((QMNetworkRequest)localObject1).setRequestParams(((String)localObject2).replace("$spam$", paramString));
      paramString = new QMCallback();
      paramString.setOnSuccess(this.mSendUrlToSafeCheckSuccessCallback);
      paramString.setOnError(this.mSendUrlToSafeCheckSuccessCallbackErrorCallback);
      ((QMNetworkRequest)localObject1).setRequestCallback(paramString);
      QMHttpUtil.asyncSend((QMNetworkRequest)localObject1);
      return;
      localObject1 = "http://";
      break;
      paramString = "";
      break label154;
      paramString = "";
      break label197;
      paramString = "";
      break label249;
      paramString = "";
      break label292;
      paramString = "";
      break label335;
    }
  }
  
  @SuppressLint({"NewApi"})
  private void copy(String paramString)
  {
    CommUtils.copyText(paramString);
  }
  
  public static Intent createIntent(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    paramString2 = new StringBuilder();
    HashMap localHashMap = new HashMap();
    String str = QMSettingManager.sharedInstance().getMiscCheckLink();
    if ((str != null) && ((str.startsWith("http://")) || (str.startsWith("https://"))) && (!WebviewUtilities.isQQMailDomainLink(paramString1)))
    {
      paramString2.append(str).append(Uri.encode(paramString1)).append("&mailid=").append("").append("&sid=").append("").append("&os=android").append("&version=").append(AppConfig.getCodeVersion()).append("&from=").append("").append("&from_nick=").append("").append("&to=").append("").append("&spam=").append("");
      localHashMap.put("mailid", "");
      localHashMap.put("sid", Uri.encode(""));
      localHashMap.put("from", "");
      localHashMap.put("from_nick", "");
      localHashMap.put("to", "");
      localHashMap.put("spam", "");
      if (paramString1 != null)
      {
        paramString1 = Uri.encode(paramString1);
        localHashMap.put("src_url", paramString1);
      }
    }
    for (;;)
    {
      return createIntent(paramString2.toString(), "", paramInt, paramBoolean, true, localHashMap, false);
      paramString1 = "";
      break;
      paramString2.append(paramString1);
    }
  }
  
  public static Intent createIntent(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    return createIntent(paramString1, paramString2, paramInt, paramBoolean1, true, paramHashMap, paramBoolean2);
  }
  
  public static Intent createIntent(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), WebViewExplorer.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("accountid", paramInt);
    localIntent.putExtra("authAuth", paramBoolean1);
    localIntent.putExtra("show_top_bar_menu", paramBoolean2);
    localIntent.putExtra("from_readmail", paramBoolean3);
    paramString1 = new Bundle();
    paramString1.putSerializable("safe_check_list", paramHashMap);
    localIntent.putExtras(paramString1);
    return localIntent;
  }
  
  private String getOriginalUrl(String paramString)
  {
    return Uri.parse(paramString).getQueryParameter("url");
  }
  
  private void handleEditAttachUrl(Account paramAccount)
  {
    if ((paramAccount instanceof QQMailAccount))
    {
      Object localObject = ((QQMailAccount)paramAccount).getCookies();
      CookieSyncManager.createInstance(getActivity());
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      localCookieManager.removeSessionCookie();
      Iterator localIterator = ((ArrayList)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = (Cookie)localIterator.next();
        String str = ((Cookie)localObject).getName() + "=" + ((Cookie)localObject).getValue();
        if (((Cookie)localObject).getDomain() != null) {}
        for (localObject = ((Cookie)localObject).getDomain();; localObject = "mail.qq.com")
        {
          localCookieManager.setCookie((String)localObject, str);
          break;
        }
      }
      CookieSyncManager.getInstance().sync();
      this.url = (this.url + "&sid=" + ((QQMailAccount)paramAccount).getSid());
    }
  }
  
  private void initWebViewSafeTipBar()
  {
    this.webViewSafeBar = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131563340, null));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299743));
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131299664);
    this.webViewSafeBar.setLayoutParams(localLayoutParams);
    this.webViewSafeTip = ((TextView)this.webViewSafeBar.findViewById(2131382185));
    this.webViewSafeBar.findViewById(2131382183).setOnClickListener(new WebViewExplorer.8(this));
    this.mWebViewWrapper.addView(this.webViewSafeBar);
    this.webViewSafeBar.setVisibility(8);
  }
  
  private boolean isProtectedWebView(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      if ((paramString != null) && (paramString.getHost().equals(this.webViewSafeCheckUrlHost)) && (paramString.getPath().equals(this.webViewSafeCheckUrlPath)))
      {
        paramString = paramString.getQuery().split("&");
        ArrayList localArrayList = new ArrayList();
        Collections.addAll(localArrayList, paramString);
        if ((localArrayList.contains(this.webViewSafeCheckUrlQuery[0])) && (localArrayList.contains(this.webViewSafeCheckUrlQuery[1])) && (localArrayList.contains(this.webViewSafeCheckUrlQuery[2]))) {
          return true;
        }
      }
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return false;
  }
  
  private static boolean isQQMailDomainLink(String paramString)
  {
    return WebviewUtilities.isQQMailDomainLink(paramString);
  }
  
  private boolean isUrlWithoutCookie(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith("https://aq.qq.com")) || (paramString.startsWith("http://aq.qq.com")));
  }
  
  private void loadProtectedUrl(String paramString)
  {
    runOnMainThread(new WebViewExplorer.7(this, paramString));
  }
  
  private void reportTheUrlToCheckLink(String paramString)
  {
    Object localObject = new StringBuilder();
    String str1;
    if ((this.protocol != null) && ((this.protocol.equals("http")) || (this.protocol.equals("https"))))
    {
      str1 = this.protocol + "://";
      localObject = new QMNetworkRequest(str1 + "url.qmail.com" + "/cgi-bin/" + "reporturl", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("mailid") == null)) {
        break label479;
      }
      str1 = (String)this.mSafeCheckHashMap.get("mailid");
      label135:
      String str2 = "action=report&mailid=$mailid$&sid=$sid$&src_url=$src_url$&dest_url=$dest_url$&os=android&version=$version$&from=$from$&from_nick=$from_nick$&to=$to$&spam=$spam$".replace("$mailid$", str1);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("sid") == null)) {
        break label485;
      }
      str1 = (String)this.mSafeCheckHashMap.get("sid");
      label181:
      str2 = str2.replace("$sid$", str1);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("src_url") == null)) {
        break label491;
      }
      str1 = (String)this.mSafeCheckHashMap.get("src_url");
      label226:
      str1 = str2.replace("$src_url$", str1);
      if (paramString == null) {
        break label497;
      }
      paramString = Uri.encode(paramString);
      label245:
      str1 = str1.replace("$dest_url$", paramString).replace("$version$", AppConfig.getCodeVersion());
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("from") == null)) {
        break label503;
      }
      paramString = (String)this.mSafeCheckHashMap.get("from");
      label297:
      str1 = str1.replace("$from$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("from_nick") == null)) {
        break label509;
      }
      paramString = (String)this.mSafeCheckHashMap.get("from_nick");
      label340:
      str1 = str1.replace("$from_nick$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("to") == null)) {
        break label515;
      }
      paramString = (String)this.mSafeCheckHashMap.get("to");
      label383:
      str1 = str1.replace("$to$", paramString);
      if ((this.mSafeCheckHashMap == null) || (this.mSafeCheckHashMap.get("spam") == null)) {
        break label521;
      }
    }
    label515:
    label521:
    for (paramString = (String)this.mSafeCheckHashMap.get("spam");; paramString = "")
    {
      ((QMNetworkRequest)localObject).setRequestParams(str1.replace("$spam$", paramString));
      paramString = new QMCallback();
      paramString.setOnSuccess(this.mReportTheUrlToCheckLinkSuccessCallback);
      paramString.setOnError(this.mReportTheUrlToCheckLinkErrorCallback);
      ((QMNetworkRequest)localObject).setRequestCallback(paramString);
      QMHttpUtil.asyncSend((QMNetworkRequest)localObject);
      return;
      str1 = "http://";
      break;
      label479:
      str1 = "";
      break label135;
      label485:
      str1 = "";
      break label181;
      label491:
      str1 = "";
      break label226;
      label497:
      paramString = "";
      break label245;
      label503:
      paramString = "";
      break label297;
      label509:
      paramString = "";
      break label340;
      paramString = "";
      break label383;
    }
  }
  
  private void showTipsInfo(String paramString)
  {
    if (this.tips == null)
    {
      this.tips = new QMTips(this);
      this.tips.setCanceledOnTouchOutside(true);
    }
    this.tips.showSuccess(paramString);
  }
  
  private void showWebViewSafeTip()
  {
    if ((this.isShowWebViewSafeTip) && (!this.isWebViewSafeBarCloseClick) && (this.webViewSafeBar.getVisibility() != 0))
    {
      DataCollector.logEvent("Event_Webview_Safe_Bar_Show");
      runOnUiThread(new WebViewExplorer.9(this));
      runOnMainThread(new WebViewExplorer.10(this), 3000L);
      runOnMainThread(new WebViewExplorer.11(this), 4000L);
    }
  }
  
  public void finish()
  {
    if (this.fromReadMail) {
      if (this.safeCheckReportUrl == null) {
        break label37;
      }
    }
    label37:
    for (String str = this.safeCheckReportUrl;; str = this.url)
    {
      reportTheUrlToCheckLink(str);
      super.finish();
      overridePendingTransition(0, 2130772402);
      return;
    }
  }
  
  protected void forward()
  {
    startActivity(ComposeMailActivity.createIntentForSubscribe(this.mAccountId, getShareContent(), getShareTitle()));
  }
  
  protected int getEntrance()
  {
    return 2;
  }
  
  protected long getMailId()
  {
    return 0L;
  }
  
  protected String getShareContent()
  {
    return this.mWebView.getUrl();
  }
  
  protected String getShareDescription()
  {
    return getShareTitle() + getString(2131695202);
  }
  
  protected String getShareTitle()
  {
    if ((this.title != null) && (!this.title.equals(""))) {
      return this.title;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(").append(getString(2131718610)).append(")");
    return localStringBuilder.toString();
  }
  
  protected Bitmap getShareToWXBitmap()
  {
    return BitmapFactory.decodeResource(getResources(), 2130850725);
  }
  
  public void initDataSource()
  {
    if (getIntent().getStringExtra("url") != null)
    {
      str = getIntent().getStringExtra("url");
      this.url = str;
      this.autoAuth = getIntent().getBooleanExtra("authAuth", false);
      this.showTopBarMenu = getIntent().getBooleanExtra("show_top_bar_menu", true);
      this.mAccountId = getIntent().getIntExtra("accountid", 0);
      if (getIntent().getStringExtra("title") == null) {
        break label225;
      }
    }
    label225:
    for (String str = getIntent().getStringExtra("title");; str = "")
    {
      this.title = str;
      this.mSafeCheckHashMap = ((HashMap)getIntent().getSerializableExtra("safe_check_list"));
      this.fromReadMail = getIntent().getBooleanExtra("from_readmail", false);
      this.extraHeader = new HashMap();
      this.mProgressBarHandler = new ProgressHandler(this.mProgressBar);
      if ((this.url != null) && (CommonMatch.QQMAIL_CGI_PATTERN.matcher(this.url).find()))
      {
        this.url = StringExtention.getUrl(this.url);
        if (!CommonMatch.QQMAIL_FTN_CGI_PATTERN.matcher(this.url).find()) {
          this.extraHeader.put("Host", "i.mail.qq.com");
        }
      }
      return;
      str = "";
      break;
    }
  }
  
  public void initDom()
  {
    initTopBar();
    updateTitle(this.title);
    initWebView();
    initWebViewSafeTipBar();
    loadUrlWithToken();
  }
  
  protected void initTopBar()
  {
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.setButtonLeftOnclickListener(new WebViewExplorer.4(this));
    this.topBar.setButtonRightIcon(2130841095);
    this.topBar.getButtonRight().setOnClickListener(new WebViewExplorer.5(this));
    View localView = this.topBar.getButtonRight();
    if (this.showTopBarMenu) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      this.topBar.getButtonRight().setContentDescription(getString(2131720837));
      this.topBar.setCenterOnclickListener(new WebViewExplorer.6(this));
      return;
    }
  }
  
  public void initUI()
  {
    setContentView(2131563338);
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.mProgressBar = ((ProgressBar)findViewById(2131373700));
    this.mWebView = new QMWebView(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131299664);
    this.mWebViewWrapper = ((RelativeLayout)findViewById(2131382176));
    this.mWebViewWrapper.addView(this.mWebView, 1, localLayoutParams);
    this.mWebViewWrapper.addOnLayoutChangeListener(new WebViewExplorer.13(this));
  }
  
  protected void initWebView()
  {
    WebviewUtilities.initWebViewSetting(this.mWebView);
    WebviewUtilities.setCookies(this.url, WebviewUtilities.getCookies(this.url));
    this.mWebView.setDownloadListener(new WebViewDownloadListener(this));
    this.mWebView.addJavascriptInterface(new InJavaScriptLocalObject(), "check_password");
    this.mWebView.setWebViewClient(new BaseWebViewClient());
    this.baseWebViewChromeClient = new BaseWebViewChromeClient();
    this.mWebView.setWebChromeClient(this.baseWebViewChromeClient);
    this.mWebView.setOnLongClickListener(new BaseOnLongClickListener());
    this.mWebView.requestFocus(130);
    this.mWebView.setAutoAuth(this.autoAuth);
  }
  
  public boolean isMultiStartAllowed()
  {
    return true;
  }
  
  protected void loadUrlWithToken()
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(this.mAccountId);
    if ((localObject1 != null) && ((localObject1 instanceof QQMailAccount)) && (shouldLoadUrlWithToken()) && (((QQMailAccount)localObject1).getLoginUser() != null)) {}
    for (;;)
    {
      try
      {
        localObject2 = Aes.encode(((QQMailAccount)localObject1).getSid(), ((QQMailAccount)localObject1).getAesKey());
        this.url = this.url.replaceAll("([?&])token=[^\\&]*", "$1token=" + Uri.encode((String)localObject2));
        if (!this.url.contains("token="))
        {
          if (!this.url.contains("?")) {
            continue;
          }
          this.url = (this.url + "&token=" + Uri.encode((String)localObject2));
        }
        this.url = this.url.replaceAll("([?&])uin=[^\\&]*", "$1uin=" + Uri.encode(((Account)localObject1).getUin()));
        if (!this.url.contains("uin="))
        {
          if (!this.url.contains("?")) {
            continue;
          }
          this.url = (this.url + "&uin=" + Uri.encode(((Account)localObject1).getUin()));
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        QMLog.log(5, "WebViewExplorer", "loadUrlWithToken url : " + localException.getMessage());
        continue;
        this.url = (this.url + "?uin=" + Uri.encode(((Account)localObject1).getUin()));
        continue;
      }
      if (getIntent().getBooleanExtra("is_edit_attach", false)) {
        handleEditAttachUrl((Account)localObject1);
      }
      localObject1 = null;
      try
      {
        localObject2 = new URL(this.url);
        localObject1 = localObject2;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        String str2;
        localMalformedURLException.printStackTrace();
        continue;
        String str1 = "";
        continue;
        localObject1 = EncodingUtils.getBytes(((URL)localObject1).getQuery(), "BASE64");
        continue;
        this.mWebView.loadUrl(this.url);
        QMLog.log(4, "WebViewExplorer", "loadUrlWithToken url : " + this.url);
      }
      if (localObject1 == null) {
        break label551;
      }
      localObject2 = ((URL)localObject1).getProtocol();
      this.protocol = ((String)localObject2);
      if ((localObject1 == null) || (!((URL)localObject1).getHost().equals(this.webViewSafeCheckUrlHost)) || (!((URL)localObject1).getPath().equals(this.webViewSafeJmpUrlPath))) {
        break label571;
      }
      localObject2 = this.mWebView;
      str2 = ((URL)localObject1).getProtocol() + "://" + ((URL)localObject1).getHost() + ((URL)localObject1).getPath();
      if (!TextUtils.isEmpty(((URL)localObject1).getQuery())) {
        break label557;
      }
      localObject1 = new byte[0];
      ((QMWebView)localObject2).postUrl(str2, (byte[])localObject1);
      QMLog.log(4, "WebViewExplorer", "loadUrlWithToken url post: " + this.url);
      return;
      this.url = (this.url + "?token=" + Uri.encode((String)localObject2));
    }
    label551:
    label557:
    label571:
    return;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (this.mWebView == null));
    JSApiUitil.excuteJavaScript(this.mWebView, JSApiUitil.handleSelectContacts(paramIntent.getLongArrayExtra("result_select_contact_ids"), this.selectContactsCallbackId));
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      QMNotification.registNotification("save_mail_as_note_done", this.mSaveMailDone);
    }
    for (;;)
    {
      LoginManager.shareInstance().bindLoginListener(this.loginWatcher, paramBoolean);
      return;
      QMNotification.unregistNotification("save_mail_as_note_done", this.mSaveMailDone);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mMoreActionWindow != null) {
      this.mMoreActionWindow.dismiss();
    }
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      if (paramMotionEvent.getX() >= QMUIKit.getScreenWidth() / 10) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      this.isLeftEdgeDrag = bool;
      return this.isLeftEdgeDrag;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.videoView != null)
      {
        this.baseWebViewChromeClient.onHideCustomView();
        return true;
      }
      if (this.mWebView.canGoBack())
      {
        this.mWebView.goBack();
        return true;
      }
      if (this.loadUrlList.size() == 1)
      {
        finish();
        return true;
      }
      if (isProtectedWebView(this.mWebView.getUrl()))
      {
        if (this.mWebView.copyBackForwardList().getSize() == 2)
        {
          finish();
          return true;
        }
        if (this.mWebView.copyBackForwardList().getSize() > 2)
        {
          this.mWebView.goBackOrForward(-2);
          return true;
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    try
    {
      this.mWebView.loadUrl("about:blank");
      this.mWebViewWrapper.removeAllViews();
      QMWebView localQMWebView = this.mWebView;
      this.mWebView = null;
      localQMWebView.setWebViewClient(null);
      localQMWebView.setWebChromeClient(null);
      localQMWebView.stopLoading();
      localQMWebView.getSettings().setJavaScriptEnabled(false);
      localQMWebView.clearHistory();
      localQMWebView.clearCache(true);
      localQMWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "WebViewExplorer", "release webview exception", localException);
    }
  }
  
  protected void openBrowser()
  {
    if (DeviceUtil.isQQBrowserInstalled())
    {
      QMLog.log(4, "WebViewExplorer", "open direct by QQBrowser:" + this.url);
      DataCollector.logEvent("Event_Open_Url_By_QQbrowser");
      startActivity(QMqqBrowserInfo.createIntentForOpenUrl(this.url));
    }
    String str;
    Intent localIntent;
    ResolveInfo localResolveInfo;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          str = getSharedPreferences("spread", 0).getString("url", "");
          localIntent = new Intent();
          localIntent.setData(Uri.parse(this.url));
          localObject = getPackageManager().queryIntentActivities(localIntent, 0);
        } while (localObject == null);
        if (((List)localObject).size() == 1)
        {
          localIntent.setComponent(new ComponentName(((ResolveInfo)((List)localObject).get(0)).activityInfo.packageName, ((ResolveInfo)((List)localObject).get(0)).activityInfo.name));
          QMLog.log(4, "WebViewExplorer", "url:" + this.url + " direct open by:" + ((ResolveInfo)((List)localObject).get(0)).activityInfo.packageName);
          return;
        }
        localObject = ((List)localObject).iterator();
      }
      localResolveInfo = (ResolveInfo)((Iterator)localObject).next();
    } while ((str == null) || (!str.contains(localResolveInfo.activityInfo.packageName)));
    localIntent.setComponent(new ComponentName(localResolveInfo.activityInfo.packageName, localResolveInfo.activityInfo.name));
    QMLog.log(4, "WebViewExplorer", "url:" + this.url + " default open by:" + localResolveInfo.activityInfo.packageName);
    startActivity(localIntent);
  }
  
  public void refreshData() {}
  
  public void render() {}
  
  protected void saveToNote()
  {
    if (FolderLockDialog.isFolderLock(-4))
    {
      QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      if (localQQMailAccount != null)
      {
        this.lockDialog = new FolderLockDialog(this, -4, localQQMailAccount.getId(), this.folderLockWatcher);
        this.lockDialog.createDialog(1);
        this.lockDialog.showDialog();
      }
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131718967), 0).show();
    new NoteSender(getMailId(), "1", "未分类", "folder").buildDataWithPredefinedHtmlAndTitle(getShareContent(), getShareTitle());
  }
  
  protected void shareToMore()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", getShareTitle());
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str2 = this.mWebView.getUrl();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(getShareTitle()).append(" ");
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.endsWith(this.webViewSafeJmpUrlPath)) {
        str1 = getOriginalUrl(this.url);
      }
    }
    localStringBuilder2.append(str1).append(" ，").append(getString(2131695202));
    localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder1.toString());
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  protected void shareToWX(int paramInt)
  {
    if (WXEntryActivity.canShareToWX(this))
    {
      WXWebpageObject localWXWebpageObject = new WXWebpageObject();
      String str = this.mWebView.getUrl();
      Object localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.endsWith(this.webViewSafeJmpUrlPath)) {
          localObject = getOriginalUrl(this.url);
        }
      }
      localWXWebpageObject.webpageUrl = ((String)localObject);
      localObject = new WXMediaMessage(localWXWebpageObject);
      ((WXMediaMessage)localObject).title = getShareTitle();
      ((WXMediaMessage)localObject).description = getShareDescription();
      ((WXMediaMessage)localObject).thumbData = WXEntryActivity.bmpToByteArray(getShareToWXBitmap(), false);
      WXEntryActivity.shareWebpage(this, paramInt, (WXMediaMessage)localObject, getEntrance());
    }
  }
  
  protected boolean shouldLoadUrlWithToken()
  {
    return isQQMailDomainLink(this.url);
  }
  
  protected void showMoreDialogPopup(View paramView)
  {
    List localList = QMPopupWindow.praseShareMenuItem(2131886103, this);
    int i;
    if (DeviceUtil.isQQBrowserInstalled())
    {
      DataCollector.logEvent("Event_Show_Open_Url_By_QQbrowser");
      i = 0;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        if (((QMPopupWindow.PopupMenuItem)localList.get(i)).getButtonId() == 2131378190) {
          ((QMPopupWindow.PopupMenuItem)localList.get(i)).setTitle(getString(2131718591));
        }
      }
      else
      {
        if (!QMSettingManager.sharedInstance().getNoteDisplay()) {
          localList.remove(1);
        }
        paramView = new WebViewExplorer.12(this, this, paramView, new PopupMenuAdapter(this, localList));
        paramView.showDown();
        this.mMoreActionWindow = paramView;
        return;
      }
      i += 1;
    }
  }
  
  protected void showShareToDialog()
  {
    shareToMore();
  }
  
  protected void updateTitle(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.title = paramString;
      this.topBar.setTitle(paramString);
    }
  }
  
  public class BaseOnLongClickListener
    implements View.OnLongClickListener
  {
    protected BaseOnLongClickListener() {}
    
    public boolean onLongClick(View paramView)
    {
      paramView = ((SmoothScrollableWebView)paramView).getHitTestResult();
      int i;
      String str;
      if (paramView != null)
      {
        i = paramView.getType();
        if ((paramView != null) && (paramView.getExtra() != null) && ((i == 5) || (i == 8)))
        {
          str = paramView.getExtra();
          if (!str.startsWith("http")) {
            break label101;
          }
          WebviewUtilities.cacheWebViewInlineImage(WebViewExplorer.this.mAccountId, StringEscapeUtils.unescapeHtml4(str));
          paramView = str;
        }
      }
      for (;;)
      {
        new InlineImageSaver(paramView, WebViewExplorer.this.mWebviewImageInfo, WebViewExplorer.this, new WebViewExplorer.BaseOnLongClickListener.1(this)).show();
        return false;
        label101:
        paramView = str;
        if (str.startsWith("file://"))
        {
          str = str.replace("file://", "");
          i = str.indexOf("?");
          paramView = str;
          if (i > 0) {
            paramView = str.substring(0, i);
          }
        }
      }
    }
  }
  
  public class BaseWebViewChromeClient
    extends WebChromeClient
    implements MediaPlayer.OnCompletionListener
  {
    private View blackView;
    private FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    
    protected BaseWebViewChromeClient() {}
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      onHideCustomView();
    }
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      QMLog.log(4, "WebViewExplorer", "onConsoleMessage : " + paramConsoleMessage.message());
      return super.onConsoleMessage(paramConsoleMessage);
    }
    
    public void onHideCustomView()
    {
      super.onHideCustomView();
      try
      {
        WebViewExplorer.this.mWebViewWrapper.removeView(WebViewExplorer.this.videoView);
        WebViewExplorer.this.videoView = null;
        WebViewExplorer.this.mWebViewWrapper.removeView(this.blackView);
        this.blackView = null;
        if (this.mCustomViewCallback != null) {
          this.mCustomViewCallback.onCustomViewHidden();
        }
        FullWindowHelper.changeToNotFullScreen(WebViewExplorer.this.getWindow(), WebViewExplorer.this.getActivity());
        WebViewExplorer.this.setRequestedOrientation(2);
        return;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "WebViewExplorer", "onHideCustom exception:" + localException.toString());
      }
    }
    
    @Override
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
        return true;
      }
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
      if (paramInt > WebViewExplorer.this.mProgressBarHandler.getDstProgressIndex()) {
        WebViewExplorer.this.mProgressBarHandler.postProgressHandler(0, paramInt, 100);
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      if (WebViewExplorer.this.url.equals(QMSettingManager.sharedInstance().getMiscCheckLink() + StringExtention.encodeURI("https://aq.qq.com/cn2/findpsw/mobile_v2/mobile_web_find_input_account?find_type=1&source_id=3194&from=qq")))
      {
        WebViewExplorer.this.updateTitle(WebViewExplorer.this.getString(2131689503));
        return;
      }
      if (WebViewExplorer.this.url.equals(QMSettingManager.sharedInstance().getMiscCheckLink() + StringExtention.encodeURI("https://aq.qq.com/cn2/findpsw/mobile_v2/mobile_web_find_input_account?find_type=2&source_id=3194&from=qq")))
      {
        WebViewExplorer.this.updateTitle(WebViewExplorer.this.getString(2131689505));
        return;
      }
      WebViewExplorer.this.updateTitle(paramString);
    }
    
    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      super.onShowCustomView(paramView, paramCustomViewCallback);
      try
      {
        WebViewExplorer.this.mWebViewWrapper.setLayoutParams(this.layoutParams);
        paramView.setLayoutParams(this.layoutParams);
        this.blackView = new View(WebViewExplorer.this);
        this.blackView.setBackgroundColor(-16777216);
        WebViewExplorer.this.mWebViewWrapper.addView(this.blackView, this.layoutParams);
        WebViewExplorer.this.videoView = paramView;
        WebViewExplorer.this.mWebViewWrapper.addView(WebViewExplorer.this.videoView);
        this.mCustomViewCallback = paramCustomViewCallback;
        if ((WebViewExplorer.this.videoView instanceof FrameLayout))
        {
          paramView = ((FrameLayout)WebViewExplorer.this.videoView).getFocusedChild();
          if ((paramView instanceof VideoView)) {
            ((VideoView)paramView).setOnCompletionListener(this);
          }
        }
        FullWindowHelper.changeToFullScreen(WebViewExplorer.this.getWindow(), WebViewExplorer.this.getActivity());
        WebViewExplorer.this.setRequestedOrientation(0);
        WebViewExplorer.this.mWebViewWrapper.setPadding(0, 0, 0, 0);
        return;
      }
      catch (Exception paramView)
      {
        QMLog.log(6, "WebViewExplorer", "onShowCustomView exception:" + paramView.toString());
      }
    }
  }
  
  public class BaseWebViewClient
    extends BaseSafeWebViewClient
  {
    protected BaseWebViewClient() {}
    
    private boolean isSafeCheckUrl(WebResourceRequest paramWebResourceRequest)
    {
      return (paramWebResourceRequest.getUrl().toString().equals("http://" + WebViewExplorer.this.webViewSafeCheckUrlHost + WebViewExplorer.this.webViewSafeJmpUrlPath)) || (paramWebResourceRequest.getUrl().toString().equals("https://" + WebViewExplorer.this.webViewSafeCheckUrlHost + WebViewExplorer.this.webViewSafeJmpUrlPath));
    }
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ssl error ");
      if (paramSslError != null) {}
      for (paramWebView = paramSslError.getUrl();; paramWebView = "")
      {
        QMLog.log(4, "WebViewExplorer", paramWebView);
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(WebViewExplorer.this.getActivity()).setMessage(2131721841).addAction(2131691246, new WebViewExplorer.BaseWebViewClient.3(this, paramSslErrorHandler))).addAction(2131721842, new WebViewExplorer.BaseWebViewClient.2(this, paramSslErrorHandler))).create().show();
        return;
      }
    }
    
    protected void onSafeLoadResource(WebView paramWebView, String paramString)
    {
      super.onSafeLoadResource(paramWebView, WebviewUtilities.getUrl(paramString));
      if (FileUtil.isImageSuffix(FileUtil.getFileNameSuffix(paramString))) {
        WebviewUtilities.cacheWebViewInlineImage(WebViewExplorer.this.mAccountId, WebviewUtilities.getUrl(paramString));
      }
    }
    
    protected void onSafePageFinished(WebView paramWebView, String paramString)
    {
      if (WebViewExplorer.this.mWebView == null) {
        return;
      }
      paramWebView.loadUrl("javascript:window.check_password.passwordCheck(!!document.querySelector(\"input[type=password]\"),'" + paramString + "');");
      paramWebView.loadUrl("javascript:document.addEventListener('focus',function(){window.check_password.focusEditText();}, true)");
      if ((WebViewExplorer.this.fromReadMail) && (WebViewExplorer.this.firstPageFinished))
      {
        WebViewExplorer.this.safeCheckReportUrl = paramString;
        WebViewExplorer.this.firstPageFinished = false;
      }
      QMLog.log(4, "WebViewExplorer", "onPageFinished " + paramString);
      WebViewExplorer.this.mProgressBarHandler.postProgressHandler(1, 100, 0);
      if (WebViewExplorer.this.mWebView != null)
      {
        JSApiUitil.initJsApi(WebViewExplorer.this.mWebView);
        if (!WebViewExplorer.this.isProtectedWebView(WebViewExplorer.this.mWebView.getUrl())) {
          break label194;
        }
        if (WebViewExplorer.this.topBar.getButtonRight() != null) {
          WebViewExplorer.this.topBar.getButtonRight().setEnabled(false);
        }
      }
      for (;;)
      {
        super.onSafePageFinished(paramWebView, paramString);
        return;
        label194:
        if (WebViewExplorer.this.topBar.getButtonRight() != null) {
          WebViewExplorer.this.topBar.getButtonRight().setEnabled(true);
        }
      }
    }
    
    protected void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
      QMLog.log(4, "WebViewExplorer", "onPageStarted " + paramString);
      if (WebViewExplorer.this.mProgressBarHandler.getDstProgressIndex() == 0) {
        WebViewExplorer.this.mProgressBarHandler.postProgressHandler(0, 30, 500);
      }
      WebViewExplorer.this.isWhiteList = JSApiUitil.isWhiteList(paramString);
      QMLog.log(4, "WebViewExplorer", "isWhiteList url:" + paramString + " result:" + WebViewExplorer.this.isWhiteList);
    }
    
    protected void onSafeReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      QMLog.log(4, "WebViewExplorer", "onSafeReceivedHttpAuthRequest " + paramString1);
      paramString2 = (ViewGroup)((LayoutInflater)paramWebView.getContext().getSystemService("layout_inflater")).inflate(2131563335, null);
      TextView localTextView = (TextView)paramString2.findViewById(2131363125);
      EditText localEditText1 = (EditText)paramString2.findViewById(2131363127);
      EditText localEditText2 = (EditText)paramString2.findViewById(2131363126);
      localTextView.setText(String.format(paramWebView.getContext().getString(2131721835), new Object[] { paramString1 }));
      ((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)new QMUIDialog.CustomDialogBuilder(paramWebView.getContext()).setTitle(2131721836)).setLayout(paramString2).addAction(2131691246, new WebViewExplorer.BaseWebViewClient.5(this))).addAction(2131721842, new WebViewExplorer.BaseWebViewClient.4(this, paramHttpAuthHandler, localEditText1, localEditText2))).create().show();
      KvHelper.webviewAuthorize(new double[0]);
    }
    
    protected void onSafeReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (paramWebResourceResponse != null) {
          QMLog.log(4, "WebViewExplorer", "code:" + paramWebResourceResponse.getStatusCode() + ", url:" + WebViewExplorer.this.url);
        }
        if ((isSafeCheckUrl(paramWebResourceRequest)) && (paramWebResourceResponse.getStatusCode() >= 500) && (paramWebResourceResponse.getStatusCode() < 600))
        {
          WebViewExplorer.this.mWebView.stopLoading();
          WebViewExplorer.this.mWebView.loadUrl(WebViewExplorer.this.getOriginalUrl(WebViewExplorer.this.url));
          OssHelper.realTimeReport(new Object[] { Long.valueOf(40311L), "", Integer.valueOf(1) });
          return;
        }
      }
      super.onSafeReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    }
    
    protected boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (((WebViewExplorer.this.loadUrlList.size() == 0) || (System.currentTimeMillis() - WebViewExplorer.this.loadTime > WebViewExplorer.this.intervalTime)) && (!WebViewExplorer.this.loadUrlList.contains(paramString)))
      {
        WebViewExplorer.this.loadUrlList.add(paramString);
        WebViewExplorer.this.loadTime = System.currentTimeMillis();
      }
      for (;;)
      {
        QMLog.log(4, "WebViewExplorer", "shouldOverrideUrlLoading " + paramString);
        if (!WebViewExplorer.this.isFinishing()) {
          break;
        }
        return true;
        if (WebViewExplorer.this.loadUrlList.size() > 0) {
          WebViewExplorer.this.loadTime = System.currentTimeMillis();
        }
      }
      if (WebViewExplorer.this.isUrlWithoutCookie(paramString)) {
        return super.shouldSafeOverrideUrlLoading(paramWebView, WebviewUtilities.getUrl(paramString));
      }
      if (WebViewExplorer.isQQMailDomainLink(paramString))
      {
        QMLog.log(4, "WebViewExplorer", "set cookie isQQMailDomainLink: " + paramString);
        localObject = AccountManager.shareInstance().getAccountList().getAccountById(WebViewExplorer.this.mAccountId);
        if ((localObject == null) || (!((Account)localObject).isQQMail())) {
          break label319;
        }
      }
      label319:
      for (Object localObject = ((Account)localObject).getUin();; localObject = null)
      {
        WebviewUtilities.setCookies(paramString, StringExtention.getCookies(WebviewUtilities.getCookies(paramString), (String)localObject));
        localObject = paramWebView.getHitTestResult();
        if ((localObject == null) || (((WebView.HitTestResult)localObject).getType() != 2)) {
          break;
        }
        localObject = WebViewExplorer.this.getPackageManager();
        paramWebView = new Intent("android.intent.action.DIAL");
        localObject = ((PackageManager)localObject).queryIntentActivities(paramWebView, 65632);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          paramWebView.setAction("android.intent.action.VIEW");
        }
        paramWebView.setData(Uri.parse(paramString));
        WebViewExplorer.this.startActivity(paramWebView);
        return true;
      }
      if (FileUtil.isImageSuffix(FileUtil.getFileNameSuffix(paramString)))
      {
        paramString = WebviewUtilities.getUrl(paramString);
        WebviewUtilities.cacheWebViewInlineImage(WebViewExplorer.this.mAccountId, paramString);
        paramWebView.loadUrl(paramString);
        return true;
      }
      if ((WebViewExplorer.this.isWhiteList) && (JSApiUitil.handleJSRequest(paramString, new WebViewExplorer.BaseWebViewClient.1(this)))) {
        return true;
      }
      if ((paramString != null) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https")) && (!paramString.startsWith("www")))
      {
        localObject = paramString.split("://")[0];
        if ((localObject != null) && (!((String)localObject).equals("http")) && (!((String)localObject).equals("https")) && (!((String)localObject).equals("www"))) {
          try
          {
            QMLog.log(4, "WebViewExplorer", "handle other schema:" + paramString);
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            ((Intent)localObject).addFlags(268435456);
            WebViewExplorer.this.startActivity((Intent)localObject);
            return true;
          }
          catch (Exception localException)
          {
            QMLog.log(6, "WebViewExplorer", "error:" + localException.getMessage());
            return super.shouldSafeOverrideUrlLoading(paramWebView, WebviewUtilities.getUrl(paramString));
          }
        }
      }
      return super.shouldSafeOverrideUrlLoading(paramWebView, WebviewUtilities.getUrl(paramString));
    }
  }
  
  final class InJavaScriptLocalObject
  {
    InJavaScriptLocalObject() {}
    
    @JavascriptInterface
    public void focusEditText()
    {
      WebViewExplorer.this.showWebViewSafeTip();
    }
    
    @JavascriptInterface
    public void passwordCheck(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        QMLog.log(3, "WebViewExplorer", "passwordCheck:hasPassword:" + paramString1 + ",jumpUrl:" + paramString2);
        if (WebViewExplorer.this.fromReadMail)
        {
          if (WebViewExplorer.this.isProtectedWebView(paramString2)) {
            WebViewExplorer.this.isProtectedUrlHasLoad = true;
          }
          if (!paramString1.equals("true")) {
            break label93;
          }
          WebViewExplorer.this.isWebViewHasPassword = true;
          WebViewExplorer.this.SendUrlToSafeCheck(paramString2);
        }
      }
      return;
      label93:
      WebViewExplorer.this.isWebViewHasPassword = false;
    }
  }
  
  static class ReportTheUrlToCheckLinkErrorCallback
    extends QMCallback.ErrorCallbackWeakRef<WebViewExplorer>
  {
    public ReportTheUrlToCheckLinkErrorCallback(WebViewExplorer paramWebViewExplorer)
    {
      super();
    }
    
    public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
    {
      QMLog.log(6, "WebViewExplorer", "reportTheUrlToCheckLink onError:" + paramQMNetworkError.code);
    }
  }
  
  static class ReportTheUrlToCheckLinkSuccessCallback
    extends QMCallback.SuccessCallbackWeakRef<WebViewExplorer>
  {
    public ReportTheUrlToCheckLinkSuccessCallback(WebViewExplorer paramWebViewExplorer)
    {
      super();
    }
    
    public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
    {
      if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null)) {
        QMLog.log(3, "WebViewExplorer", "reportTheUrlToCheckLink callback success response:" + paramQMNetworkResponse.getResponseString());
      }
    }
  }
  
  static class SendUrlToSafeCheckSuccessCallback
    extends QMCallback.SuccessCallbackWeakRef<WebViewExplorer>
  {
    public SendUrlToSafeCheckSuccessCallback(WebViewExplorer paramWebViewExplorer)
    {
      super();
    }
    
    public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
    {
      WebViewExplorer localWebViewExplorer = (WebViewExplorer)get();
      if (localWebViewExplorer == null) {
        return;
      }
      if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.getResponseString() != null))
      {
        paramQMNetworkRequest = (JSONObject)JSONReader.parse(paramQMNetworkResponse.getResponseString());
        QMLog.log(4, "WebViewExplorer", "SendUrlToSafeCheck callback success:" + paramQMNetworkResponse.getResponseString() + ",isInnerEditTextFocus:" + localWebViewExplorer.isInnerEditTextFocus);
        if (!paramQMNetworkRequest.containsKey("retcode")) {
          break label352;
        }
      }
      label346:
      label352:
      for (int i = ((Integer)paramQMNetworkRequest.get("retcode")).intValue();; i = 0)
      {
        if (paramQMNetworkRequest.containsKey("msg"))
        {
          paramQMNetworkResponse = (String)paramQMNetworkRequest.get("msg");
          if ((paramQMNetworkResponse != null) && (!paramQMNetworkResponse.equals(""))) {
            localWebViewExplorer.runOnUiThread(new WebViewExplorer.SendUrlToSafeCheckSuccessCallback.1(this, localWebViewExplorer, paramQMNetworkResponse));
          }
        }
        if (paramQMNetworkRequest.containsKey("url")) {
          paramQMNetworkRequest = (String)paramQMNetworkRequest.get("url");
        }
        for (;;)
        {
          if (i == localWebViewExplorer.WEB_VIEW_SAFE_CHECK_RETURN_TIPS)
          {
            localWebViewExplorer.isShowWebViewSafeTip = true;
            if (localWebViewExplorer.isInnerEditTextFocus)
            {
              localWebViewExplorer.showWebViewSafeTip();
              return;
              if (!paramQMNetworkRequest.containsKey("gourl")) {
                break label346;
              }
              paramQMNetworkRequest = (String)paramQMNetworkRequest.get("gourl");
              continue;
            }
            if (paramQMNetworkRequest.equals("")) {
              break;
            }
            localWebViewExplorer.safeCheckUrls.add(paramQMNetworkRequest);
            return;
          }
          if (i != localWebViewExplorer.WEB_VIEW_SAFE_CHECK_RETURN_REJECTION) {
            break;
          }
          if ((!localWebViewExplorer.safeCheckUrls.contains(paramQMNetworkRequest)) && (!localWebViewExplorer.isProtectedUrlHasLoad))
          {
            localWebViewExplorer.loadProtectedUrl(paramQMNetworkRequest);
            localWebViewExplorer.safeCheckUrls.add(paramQMNetworkRequest);
            localWebViewExplorer.isProtectedUrlHasLoad = true;
            return;
          }
          QMLog.log(4, "WebViewExplorer", "retCode is 2 and safeCheckUrls contains url:" + localWebViewExplorer.safeCheckUrls.contains(paramQMNetworkRequest) + " or isProtectedUrlHasLoad:" + localWebViewExplorer.isProtectedUrlHasLoad);
          return;
          QMLog.log(5, "WebViewExplorer", "SendUrlToSafeCheck callback success but response null");
          return;
          paramQMNetworkRequest = "";
        }
      }
    }
  }
  
  static class SendUrlToSafeCheckSuccessCallbackErrorCallback
    extends QMCallback.ErrorCallbackWeakRef<WebViewExplorer>
  {
    public SendUrlToSafeCheckSuccessCallbackErrorCallback(WebViewExplorer paramWebViewExplorer)
    {
      super();
    }
    
    public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
    {
      QMLog.log(6, "WebViewExplorer", "SendUrlToSafeCheck onError:" + paramQMNetworkError.code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer
 * JD-Core Version:    0.7.0.1
 */