package com.tencent.qqmail.activity.webviewexplorer;

import Override;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubscribeWebViewExplorer
  extends WebViewExplorer
{
  private static int ACTION_FORWARD = 1;
  private static int ACTION_SAVE_TO_NOTE = 2;
  private boolean ableFlingToBack;
  private Bitmap firstImgBitmap;
  private String htmlContent;
  private int lastAction;
  private long mailId;
  private String picUrl;
  private String subject;
  private String url;
  
  public static Intent createIntent(Context paramContext, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    paramContext = new Intent(paramContext, SubscribeWebViewExplorer.class);
    paramContext.putExtra("url", paramString1);
    paramContext.putExtra("mailId", paramLong);
    paramContext.putExtra("title", QMApplicationContext.sharedInstance().getString(2131721843));
    paramContext.putExtra("subject", paramString2);
    paramContext.putExtra("autoAuth", paramBoolean);
    paramContext.putExtra("bigPicUrl", paramString3);
    paramContext.putExtra("picUrl", paramString4);
    return paramContext;
  }
  
  private void hideTipsLoading()
  {
    if (this.tips == null)
    {
      this.tips = new QMTips(this);
      this.tips.setCanceledOnTouchOutside(true);
    }
    this.tips.hide();
  }
  
  private String purgeHtml(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.replaceAll("[\\r\\n\\t]*", "").replaceAll("<head>.*?</head>", "").replaceAll("<script[^>]*?>.*?</script>", "");
    paramString = Pattern.compile("<div[^>]*?class=\"(mui_tips|mh_title|mailhead)\"[^>]*?>.*?</div>").matcher(paramString);
    paramString.reset();
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find())
    {
      String str = paramString.group();
      int i = str.indexOf("<h3>");
      int j = str.indexOf("</h3>");
      if ((i != -1) && (j != -1))
      {
        str = str.substring(i + "<h3>".length(), j);
        if ((str != null) && (!str.equals(""))) {
          this.subject = str;
        }
      }
      paramString.appendReplacement(localStringBuffer, "");
    }
    return paramString.appendTail(localStringBuffer).toString();
  }
  
  private void showTipsLoading()
  {
    if (this.tips == null)
    {
      this.tips = new QMTips(this);
      this.tips.setCanceledOnTouchOutside(true);
    }
    this.tips.showLoading("");
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772421, 2130772420);
  }
  
  protected void forward()
  {
    Mail localMail = QMMailManager.sharedInstance().readMail(this.mailId, true);
    String str = getShareContent();
    if (str != null)
    {
      startActivity(ComposeMailActivity.createIntentForSubscribe(localMail.getInformation().getAccountId(), str, localMail.getInformation().getSubject()));
      return;
    }
    showTipsLoading();
    this.lastAction = ACTION_FORWARD;
  }
  
  protected int getEntrance()
  {
    return 0;
  }
  
  protected long getMailId()
  {
    return this.mailId;
  }
  
  protected String getShareContent()
  {
    return this.htmlContent;
  }
  
  protected String getShareTitle()
  {
    return this.subject;
  }
  
  protected Bitmap getShareToWXBitmap()
  {
    if (this.firstImgBitmap != null) {
      return this.firstImgBitmap;
    }
    return super.getShareToWXBitmap();
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    this.url = getIntent().getStringExtra("url");
    this.mailId = getIntent().getLongExtra("mailId", 0L);
    this.subject = getIntent().getStringExtra("subject");
    this.picUrl = getIntent().getStringExtra("picUrl");
    if ((this.picUrl != null) && (!this.picUrl.equals("")))
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setAccountId(this.mAccountId);
      localDownloadInfo.setUrl(this.picUrl);
      localDownloadInfo.setSessionType(0);
      localDownloadInfo.setImageDownloadListener(new SubscribeWebViewExplorer.1(this));
      ImageDownloadManager.shareInstance().fetchCompressImage(localDownloadInfo, 3);
    }
  }
  
  protected void initTopBar()
  {
    super.initTopBar();
    this.topBar.setButtonLeftIcon(2130841084);
    this.topBar.setButtonLeftBack().setButtonLeftOnclickListener(new SubscribeWebViewExplorer.2(this));
  }
  
  protected void initWebView()
  {
    super.initWebView();
    this.mWebView.addJavascriptInterface(new MyJavascript(null), "QQMailApp");
    this.mWebView.setWebViewClient(new SubscribeWebViewClient());
  }
  
  public boolean isMultiStartAllowed()
  {
    return true;
  }
  
  protected void onContentLoaded(String paramString)
  {
    if (this.mWebView == null) {}
    do
    {
      return;
      if (this.lastAction == ACTION_FORWARD)
      {
        hideTipsLoading();
        forward();
        return;
      }
    } while (this.lastAction != ACTION_SAVE_TO_NOTE);
    hideTipsLoading();
    saveToNote();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.ableFlingToBack = WebviewUtilities.isOnLeftEdge(this.mWebView);
    }
    return this.ableFlingToBack;
  }
  
  protected void saveToNote()
  {
    if (getShareContent() != null)
    {
      super.saveToNote();
      return;
    }
    showTipsLoading();
    this.lastAction = ACTION_SAVE_TO_NOTE;
  }
  
  class MyJavascript
  {
    private MyJavascript() {}
    
    @JavascriptInterface
    public boolean isFilterAD()
    {
      return true;
    }
    
    @JavascriptInterface
    public void setHtmlContent(String paramString)
    {
      SubscribeWebViewExplorer.access$002(SubscribeWebViewExplorer.this, SubscribeWebViewExplorer.this.purgeHtml(paramString));
      SubscribeWebViewExplorer.this.onContentLoaded(paramString);
    }
  }
  
  public class SubscribeWebViewClient
    extends WebViewExplorer.BaseWebViewClient
  {
    protected SubscribeWebViewClient()
    {
      super();
    }
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      super.onSafePageFinished(paramWebView, paramString);
      SubscribeWebViewExplorer.this.hideTipsLoading();
      if (SubscribeWebViewExplorer.this.mWebView != null)
      {
        if ((paramString.equals(paramString)) && (SubscribeWebViewExplorer.this.htmlContent != null)) {
          SubscribeWebViewExplorer.this.mWebView.clearHistory();
        }
        if ((!SubscribeWebViewExplorer.this.mWebView.canGoBack()) && (paramString.equals("about:blank")) && (SubscribeWebViewExplorer.this.htmlContent != null))
        {
          SubscribeWebViewExplorer.this.mWebView.setAutoAuth(true);
          SubscribeWebViewExplorer.this.mWebView.loadDataWithBaseURL(paramString, SubscribeWebViewExplorer.this.htmlContent, "text/html", "utf-8", null);
        }
        SubscribeWebViewExplorer.this.mWebView.loadUrl("javascript:window.QQMailApp.setHtmlContent(document.getElementsByTagName('html')[0].outerHTML);");
      }
    }
    
    public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.SubscribeWebViewExplorer
 * JD-Core Version:    0.7.0.1
 */