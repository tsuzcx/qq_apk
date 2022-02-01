package com.tencent.qqmail.activity.wework;

import Override;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.activity.webviewexplorer.WebViewDownloadListener;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.ProgressHandler;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.util.ArrayList;
import java.util.Iterator;

public class WeWorkAuthActivity
  extends BaseActivityEx
{
  private static final String ACC = "acc";
  private static final String EMAILS = "emails";
  private static final String ITEMS = "items";
  private static final String PARAM_ST = "st";
  private static final String PARAM_VID = "vid";
  private static final String REQUEST_DATA = "request_data";
  private static final String RESULT_DATA = "result_data";
  private static final String RET = "ret";
  private static final int STATUS_ERROR = -1;
  private static final int STATUS_SENDING = 0;
  private static final int STATUS_SUCCESS = 1;
  public static final String TAG = "LaunchWeWorkAuthActivity";
  private static final String TOKEN = "token";
  private static final String TYPE = "type";
  private static final String UIN = "uin";
  private String domain;
  private Handler handler = new Handler(Looper.getMainLooper());
  private boolean isConfirm;
  private ProgressBar progressBar;
  protected ProgressHandler progressBarHandler;
  private String st;
  private int status;
  private QMTopBar topBar;
  private String url = "https://mail.qq.com/cgi-bin/readtemplate?check=false&t=rtx_auth";
  private String vid;
  private QMWebView webView;
  private RelativeLayout wrapper;
  
  private void finishWithResult()
  {
    this.handler.postDelayed(new WeWorkAuthActivity.6(this), 500L);
  }
  
  private String getResultJson(int paramInt, String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("ret", String.valueOf(paramInt));
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Account)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("acc", ((Account)localObject2).getEmail());
      Object localObject1;
      if ((localObject2 instanceof QQMailAccount))
      {
        localObject1 = (QQMailAccount)localObject2;
        localJSONObject2.put("uin", ((QQMailAccount)localObject1).getUin());
        localJSONObject2.put("type", "RSA");
        StringBuilder localStringBuilder = new StringBuilder().append(SharedPreferenceUtil.getLoginSvrUtc()).append("\t").append(((QQMailAccount)localObject1).getUin()).append("\t").append(QMWtLoginManager.getInstance().getA2(((QQMailAccount)localObject1).getUin())).append("\t");
        if (((Account)localObject2).getSecondPassword() == null)
        {
          localObject1 = "";
          localJSONObject2.put("token", RsaEncryption.encryptInBlock((String)localObject1));
        }
      }
      for (;;)
      {
        localObject1 = new JSONArray();
        localObject2 = QMContactManager.sharedInstance().getContactEmailsByAccountAndDomain(((Account)localObject2).getId(), paramString).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).add((String)((Iterator)localObject2).next());
        }
        localObject1 = ((Account)localObject2).getSecondPassword();
        break;
        localJSONObject2.put("uin", "");
        localJSONObject2.put("type", "");
        localJSONObject2.put("token", "");
      }
      localJSONObject2.put("emails", localObject1);
      localJSONArray.add(localJSONObject2);
    }
    if (paramInt == 1) {
      localJSONObject1.put("items", localJSONArray);
    }
    return localJSONObject1.toString();
  }
  
  private void initTopBar()
  {
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new WeWorkAuthActivity.1(this));
  }
  
  private void showTisLoading()
  {
    runOnMainThread(new WeWorkAuthActivity.5(this));
  }
  
  private void verifyWeWorkAccount(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder(MailManagerDefines.PARAM_PREFIX_VERIFY_ST);
    ((StringBuilder)localObject).append(StringExtention.replaceWithEncodeURIValue("&vid=$vid$", "vid", paramString1));
    ((StringBuilder)localObject).append(StringExtention.replaceWithEncodeURIValue("&st=$st$", "st", paramString2));
    StringBuilder localStringBuilder = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (paramString2 = QMNetworkConfig.getCgiRequestHostHttps(0);; paramString2 = QMNetworkConfig.getCgiRequestHost(0))
    {
      paramString2 = new QMNetworkRequest(paramString2 + "/cgi-bin/" + "verifyst" + "?" + ((StringBuilder)localObject).toString(), QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new WeWorkAuthActivity.2(this, paramString1));
      ((QMCallback)localObject).setOnSuccess(new WeWorkAuthActivity.3(this, paramString1));
      ((QMCallback)localObject).setOnError(new WeWorkAuthActivity.4(this, paramString1));
      paramString2.setRequestCallback((QMCallback)localObject);
      QMHttpUtil.asyncSend(paramString2);
      return;
    }
  }
  
  public void initDataSource()
  {
    try
    {
      Object localObject = getIntent().getStringExtra("request_data");
      if (StringExtention.isNullOrEmpty((String)localObject))
      {
        QMLog.log(6, "LaunchWeWorkAuthActivity", "requestDataStr null");
        finish();
        return;
      }
      localObject = (JSONObject)JSONReader.parse((String)localObject);
      this.vid = ((JSONObject)localObject).getString("vid");
      if (StringExtention.isNullOrEmpty(this.vid))
      {
        QMLog.log(6, "LaunchWeWorkAuthActivity", "vid null");
        finish();
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "LaunchWeWorkAuthActivity", Log.getStackTraceString(localException));
      return;
    }
    this.st = localException.getString("st");
    if (StringExtention.isNullOrEmpty(this.st))
    {
      QMLog.log(6, "LaunchWeWorkAuthActivity", "st null");
      finish();
      return;
    }
    this.domain = localException.getString("domain");
    if (StringExtention.isNullOrEmpty(this.domain))
    {
      QMLog.log(6, "LaunchWeWorkAuthActivity", "domain null");
      finish();
      return;
    }
    if (AccountManager.shareInstance().getAccountList().size() == 0)
    {
      startActivity(AccountTypeListActivity.createIntent());
      finish();
      return;
    }
    verifyWeWorkAccount(this.vid, this.st);
  }
  
  public void initDom()
  {
    initTopBar();
    initWebView();
  }
  
  public void initUI()
  {
    setContentView(2131558524);
    this.wrapper = ((RelativeLayout)findViewById(2131382235));
    this.topBar = ((QMTopBar)findViewById(2131382233));
    this.progressBar = ((ProgressBar)findViewById(2131382232));
    this.webView = ((QMWebView)findViewById(2131382234));
    this.progressBarHandler = new ProgressHandler(this.progressBar);
  }
  
  protected void initWebView()
  {
    WebviewUtilities.initWebViewSetting(this.webView);
    WebviewUtilities.setCookies(this.url, WebviewUtilities.getCookies(this.url));
    this.webView.setWebChromeClient(new BasicWebChromeClient(null));
    this.webView.setWebViewClient(new BasicWebViewClient(null));
    this.webView.setDownloadListener(new WebViewDownloadListener(this));
    this.webView.requestFocus(130);
    this.webView.loadUrl(this.url);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.webView.canGoBack()))
    {
      this.webView.goBack();
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    this.wrapper.removeAllViews();
    try
    {
      QMWebView localQMWebView = this.webView;
      this.webView = null;
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
      QMLog.log(5, "LaunchWeWorkAuthActivity", "release webview exception", localException);
    }
  }
  
  public void refreshData() {}
  
  public void render() {}
  
  protected void updateTopbarTitle(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      this.topBar.setTitle(paramString);
    }
  }
  
  class BasicWebChromeClient
    extends WebChromeClient
  {
    private BasicWebChromeClient() {}
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      QMLog.log(4, "LaunchWeWorkAuthActivity", "onConsoleMessage : " + paramConsoleMessage.message());
      return super.onConsoleMessage(paramConsoleMessage);
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
      if (paramInt > WeWorkAuthActivity.this.progressBarHandler.getDstProgressIndex()) {
        WeWorkAuthActivity.this.progressBarHandler.postProgressHandler(0, paramInt, 100);
      }
    }
  }
  
  class BasicWebViewClient
    extends BaseSafeWebViewClient
  {
    private BasicWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      super.onSafePageFinished(paramWebView, paramString);
      QMLog.log(4, "LaunchWeWorkAuthActivity", "onPageFinished " + paramString);
      WeWorkAuthActivity.this.progressBarHandler.postProgressHandler(1, 100, 0);
      WeWorkAuthActivity.this.updateTopbarTitle(WeWorkAuthActivity.this.webView.getTitle());
    }
    
    public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
      QMLog.log(4, "LaunchWeWorkAuthActivity", "onPageStarted " + paramString);
      if (WeWorkAuthActivity.this.progressBarHandler.getDstProgressIndex() == 0) {
        WeWorkAuthActivity.this.progressBarHandler.postProgressHandler(0, 30, 500);
      }
    }
    
    public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      QMLog.log(4, "LaunchWeWorkAuthActivity", "shouldOverrideUrlLoading " + paramString);
      if ((paramString != null) && (paramString.equals("qqmail://contactconfirm")))
      {
        WeWorkAuthActivity.access$202(WeWorkAuthActivity.this, true);
        if (WeWorkAuthActivity.this.status == 0)
        {
          WeWorkAuthActivity.this.showTisLoading();
          return true;
        }
        WeWorkAuthActivity.this.finishWithResult();
        return true;
      }
      return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.wework.WeWorkAuthActivity
 * JD-Core Version:    0.7.0.1
 */