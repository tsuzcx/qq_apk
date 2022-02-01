package com.tencent.qqmail.activity.readmail;

import Override;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.FullWindowHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.TitleBarWebView2;
import java.util.HashMap;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;

public class ReadVirtualAdsMailFragment
  extends MailFragment
{
  public static final String TAG = ReadVirtualAdsMailFragment.class.getSimpleName();
  private boolean ableFlingToBack = false;
  private ViewGroup body;
  private FrameLayout.LayoutParams bodyParam;
  private ImageView deleteBtn;
  private QMUnlockFolderPwdWatcher folderLockWatcher = new ReadVirtualAdsMailFragment.7(this);
  private View footerBar;
  private ImageView forwardBtn;
  private boolean hasScrollOverEighty;
  private String htmlContent;
  private String htmlSubject;
  private FolderLockDialog lockDialog;
  private ViewGroup mHeader = null;
  private Observer mSaveMailDone = new IObserver(new ReadVirtualAdsMailFragment.6(this));
  private String mShareUrl;
  private QMScaleWebViewController mWebViewController;
  private ImageView moreBtn;
  private Popularize popularize;
  private QMContentLoadingView qmContentLoadingView;
  private int screenHeight = QMUIKit.dpToPx(QMUIKit.getDisplayMetrics(QMApplicationContext.sharedInstance()).densityDpi);
  private ImageView shareBtn;
  private long startEnterTimeNew;
  private QMTopBar topbar;
  private HashMap<String, String> url_path_map = new HashMap();
  private View videoView;
  private VirtualAdWebViewChromeClient virtualAdWebViewChromeClient;
  private TitleBarWebView2 webView;
  private ViewGroup webviewContainer;
  
  public ReadVirtualAdsMailFragment(Popularize paramPopularize)
  {
    super(true);
    this.popularize = paramPopularize;
    QMLog.log(4, TAG, "ReadVirtualAdsMailFragment = " + paramPopularize.toString());
  }
  
  private void enableBtn(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramImageView.setAlpha(QMImageButton.mOpacityNormal);
    }
    for (;;)
    {
      paramImageView.setEnabled(paramBoolean);
      return;
      paramImageView.setAlpha(QMImageButton.mOpacityDisabled);
    }
  }
  
  private void forwardMail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount != null) {
      startActivity(ComposeMailActivity.createIntentForVirtualAdsMail(localAccount.getId(), getForwardOrSaveHtml(), this.popularize.getSubject()));
    }
  }
  
  private String getForwardOrSaveHtml()
  {
    return "<a href=\"" + getShareUrl() + "\"><img src=\"" + this.popularize.getSubImageUrl() + "\"></a>";
  }
  
  private String getShareUrl()
  {
    if (TextUtils.isEmpty(this.mShareUrl)) {
      this.mShareUrl = VirtualAdManager.getInstance().appendPopularizeUrlRequestParams(this.popularize);
    }
    return this.mShareUrl;
  }
  
  private void initBody(QMBaseView paramQMBaseView)
  {
    this.body = ((ViewGroup)LayoutInflater.from(getActivity()).inflate(2131559478, null));
    this.bodyParam = new FrameLayout.LayoutParams(-1, -1, 48);
    this.bodyParam.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.shareBtn = ((ImageView)this.body.findViewById(2131378169));
    this.forwardBtn = ((ImageView)this.body.findViewById(2131367524));
    this.deleteBtn = ((ImageView)this.body.findViewById(2131365698));
    this.moreBtn = ((ImageView)this.body.findViewById(2131371928));
    this.footerBar = this.body.findViewById(2131367461);
    View localView = this.footerBar;
    if (this.popularize.isCommercialConfigTool()) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.qmContentLoadingView = ((QMContentLoadingView)this.body.findViewById(2131370787));
      setBottomTouchAndCLickListener();
      if (this.popularize.isCommercialConfigHead()) {
        initHeader();
      }
      initWebView(this.body);
      initUrl();
      this.body.setLayoutParams(this.bodyParam);
      paramQMBaseView.addView(this.body);
      return;
    }
  }
  
  private void initHeader()
  {
    this.mHeader = ((ViewGroup)LayoutInflater.from(getActivity()).inflate(2131559479, null));
    ((TextView)this.mHeader.findViewById(2131378941)).setText(this.popularize.getSubject());
    ((TextView)this.mHeader.findViewById(2131378018)).setText(this.popularize.getCommercialFromNick());
    this.mHeader.measure(0, 0);
  }
  
  private void initUrl()
  {
    loadContent(this.popularize.getOpenUrl());
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void initWebView(ViewGroup paramViewGroup)
  {
    this.webviewContainer = ((ViewGroup)paramViewGroup.findViewById(2131382175));
    this.mWebViewController = new QMScaleWebViewController(getActivity(), this.webviewContainer, this.mHeader, null);
    this.mWebViewController.init();
    this.webView = this.mWebViewController.getWebView();
    this.mWebViewController.getWebView().getSettings().setLoadsImagesAutomatically(true);
    this.webView.setVerticalScrollBarEnabled(true);
    this.webView.setHorizontalScrollBarEnabled(true);
    this.webView.setZoomEnabled(true);
    this.webView.setOnScrollChanged(new ReadVirtualAdsMailFragment.8(this));
    paramViewGroup = this.mWebViewController;
    QMScaleWebViewController localQMScaleWebViewController = this.mWebViewController;
    localQMScaleWebViewController.getClass();
    paramViewGroup.setJavascriptInterface(new ReadVirtualAdsMailFragment.9(this, localQMScaleWebViewController));
    paramViewGroup = this.mWebViewController;
    localQMScaleWebViewController = this.mWebViewController;
    localQMScaleWebViewController.getClass();
    paramViewGroup.setWebViewClient(new ReadVirtualAdsMailFragment.10(this, localQMScaleWebViewController));
    this.virtualAdWebViewChromeClient = new VirtualAdWebViewChromeClient(null);
    this.webView.setWebChromeClient(this.virtualAdWebViewChromeClient);
  }
  
  private void loadContent(String paramString)
  {
    Object localObject1 = QMSharedPreferenceManager.getInstance().getPopularizeAD(paramString);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("loadContent: ").append(paramString).append(", cache: ");
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(4, (String)localObject2, bool);
      if (localObject1 == null) {
        break;
      }
      showContent(paramString, (String)localObject1);
      return;
    }
    paramString = VirtualAdManager.getInstance().appendPopularizeUrlRequestParams(this.popularize);
    localObject1 = new QMNetworkRequest(paramString, QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    localObject2 = new QMCallback();
    ((QMCallback)localObject2).setOnSuccess(new ReadVirtualAdsMailFragment.11(this, paramString));
    ((QMCallback)localObject2).setOnError(new ReadVirtualAdsMailFragment.12(this));
    ((QMNetworkRequest)localObject1).setRequestCallback((QMCallback)localObject2);
    QMHttpUtil.asyncSend((QMNetworkRequest)localObject1);
  }
  
  private void markAsUnInterested()
  {
    QMLog.log(4, TAG, "markAsUnInterested");
    VirtualAdManager.getInstance().reportDeleteOrUnLike(1, this.popularize);
    PopularizeUIHelper.handleCancel(this.popularize);
    onButtonBackClick();
  }
  
  private String purgeHtml(String paramString)
  {
    Log.i(TAG, "purgeHtml " + paramString);
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
          this.htmlSubject = str;
        }
        Log.i(TAG, "title = " + str);
      }
      paramString.appendReplacement(localStringBuffer, "");
    }
    return paramString.appendTail(localStringBuffer).toString();
  }
  
  private void saveAsNote()
  {
    QMLog.log(4, TAG, "saveAsNote");
    if (FolderLockDialog.isFolderLock(-4))
    {
      QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      if (localQQMailAccount != null)
      {
        this.lockDialog = new FolderLockDialog(getActivity(), -4, localQQMailAccount.getId(), this.folderLockWatcher);
        this.lockDialog.createDialog(1);
        this.lockDialog.showDialog();
      }
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131718967), 0).show();
    new NoteSender(0L, "1", "未分类", "folder").buildDataWithPredefinedHtmlAndTitle(getForwardOrSaveHtml(), this.popularize.getSubject());
  }
  
  private void setBottomTouchAndCLickListener()
  {
    ReadVirtualAdsMailFragment.1 local1 = new ReadVirtualAdsMailFragment.1(this);
    this.shareBtn.setOnTouchListener(local1);
    this.forwardBtn.setOnTouchListener(local1);
    this.deleteBtn.setOnTouchListener(local1);
    this.moreBtn.setOnTouchListener(local1);
    this.shareBtn.setOnClickListener(new ReadVirtualAdsMailFragment.2(this));
    this.forwardBtn.setOnClickListener(new ReadVirtualAdsMailFragment.3(this));
    this.deleteBtn.setOnClickListener(new ReadVirtualAdsMailFragment.4(this));
    this.moreBtn.setOnClickListener(new ReadVirtualAdsMailFragment.5(this));
  }
  
  private void shareToQQ()
  {
    MobileQQEntryActivity.shareLinkToQQ(getShareUrl(), this.popularize.getCommercialFromNick(), this.popularize.getSubject(), this.popularize.getImageUrl(), getActivity());
  }
  
  private void shareToWechat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (WXEntryActivity.canShareToWX(getActivity()))
    {
      paramString4 = new WXWebpageObject();
      paramString4.webpageUrl = paramString1;
      paramString1 = new WXMediaMessage(paramString4);
      paramString1.title = paramString2;
      paramString1.description = paramString3;
      paramString2 = PopularizeThumbManager.sharedInstance().getPopularizeThumb(this.popularize.getImageUrl());
      if (paramString2 != null) {
        paramString1.thumbData = WXEntryActivity.bmpToByteArray(paramString2, false);
      }
      WXEntryActivity.shareWebpage(QMApplicationContext.sharedInstance(), paramInt, paramString1, paramInt);
    }
  }
  
  private void showContent(String paramString1, String paramString2)
  {
    toggleWebview(true);
    if ((this.mHeader == null) || (Build.VERSION.SDK_INT < 19))
    {
      this.mWebViewController.loadHTML(paramString1, paramString2);
      return;
    }
    String str = String.format("<div style=\"height: %spx\";></div>", new Object[] { Integer.valueOf(QMUIKit.pxToDp(this.mHeader.getMeasuredHeight())) });
    int i = paramString2.indexOf("</head>") + "</head>".length();
    paramString2 = paramString2.substring(0, i) + str + paramString2.subSequence(i, paramString2.length());
    this.mWebViewController.loadHTML(paramString1, paramString2);
  }
  
  private void toggleWebview(boolean paramBoolean)
  {
    QMLog.log(4, TAG, "toggleWebview " + paramBoolean);
    if (paramBoolean)
    {
      this.qmContentLoadingView.showLoading(false);
      this.qmContentLoadingView.setVisibility(8);
      this.webviewContainer.setVisibility(0);
      return;
    }
    this.qmContentLoadingView.showLoading(true);
    this.qmContentLoadingView.setVisibility(0);
    this.webviewContainer.setVisibility(8);
  }
  
  public void deleteMail()
  {
    QMLog.log(4, TAG, "deleteMail");
    PopularizeUIHelper.handleCancel(this.popularize);
    VirtualAdManager.getInstance().reportDeleteOrUnLike(2, this.popularize);
    onButtonBackClick();
  }
  
  public void initDataSource()
  {
    this.popularize.setIsRead(true);
    PopularizeManager.sharedInstance().updatePopularizeIsRead(true, this.popularize);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public void initTopBar(QMBaseView paramQMBaseView)
  {
    this.topbar = paramQMBaseView.getTopBar();
    this.topbar.setButtonLeftBack();
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    if (getActivity() != null) {
      getActivity().setRequestedOrientation(1);
    }
    paramViewHolder = new QMBaseView(getActivity());
    initTopBar(paramViewHolder);
    initBody(paramViewHolder);
    return paramViewHolder;
  }
  
  public void onBackPressed()
  {
    if (this.videoView != null)
    {
      this.virtualAdWebViewChromeClient.onHideCustomView();
      return;
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    if ((this.startEnterTimeNew != 0L) && ((System.currentTimeMillis() - this.startEnterTimeNew) / 1000L > 0L)) {
      KvHelper.detaileventAdMailWatchTimeNew(new double[] { (System.currentTimeMillis() - this.startEnterTimeNew) / 1000L });
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMNotification.registNotification("save_mail_as_note_done", this.mSaveMailDone, paramBoolean);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QMLog.log(4, TAG, "onDestroyView");
    if (this.mWebViewController != null)
    {
      this.mWebViewController.destroy();
      this.mWebViewController = null;
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
      this.ableFlingToBack = bool;
      return this.ableFlingToBack;
    }
  }
  
  public void onForeground()
  {
    super.onForeground();
    this.startEnterTimeNew = System.currentTimeMillis();
  }
  
  public void onRelease()
  {
    if (getActivity() != null) {
      getActivity().setRequestedOrientation(2);
    }
    try
    {
      this.webView.loadUrl("about:blank");
      this.webviewContainer.removeAllViews();
      TitleBarWebView2 localTitleBarWebView2 = this.webView;
      this.webView = null;
      localTitleBarWebView2.setWebViewClient(null);
      localTitleBarWebView2.setWebChromeClient(null);
      localTitleBarWebView2.stopLoading();
      localTitleBarWebView2.getSettings().setJavaScriptEnabled(false);
      localTitleBarWebView2.clearHistory();
      localTitleBarWebView2.clearCache(true);
      localTitleBarWebView2.destroy();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(5, TAG, "release webview exception", localException);
    }
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
  
  class VirtualAdWebViewChromeClient
    extends WebChromeClient
    implements MediaPlayer.OnCompletionListener
  {
    private FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(-1, -1);
    private View blackView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    
    private VirtualAdWebViewChromeClient() {}
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      onHideCustomView();
    }
    
    public void onHideCustomView()
    {
      int i = 0;
      super.onHideCustomView();
      try
      {
        ReadVirtualAdsMailFragment.this.webviewContainer.removeView(ReadVirtualAdsMailFragment.this.videoView);
        ReadVirtualAdsMailFragment.access$2502(ReadVirtualAdsMailFragment.this, null);
        ReadVirtualAdsMailFragment.this.webviewContainer.removeView(this.blackView);
        this.blackView = null;
        if (this.mCustomViewCallback != null) {
          this.mCustomViewCallback.onCustomViewHidden();
        }
        FullWindowHelper.changeToNotFullScreen(ReadVirtualAdsMailFragment.this.getActivity().getWindow(), ReadVirtualAdsMailFragment.this.getActivity());
        ReadVirtualAdsMailFragment.this.getActivity().setRequestedOrientation(2);
        ReadVirtualAdsMailFragment.this.topbar.setVisibility(0);
        View localView = ReadVirtualAdsMailFragment.this.footerBar;
        if (ReadVirtualAdsMailFragment.this.popularize.isCommercialConfigTool()) {}
        for (;;)
        {
          localView.setVisibility(i);
          ReadVirtualAdsMailFragment.this.bodyParam.setMargins(0, ReadVirtualAdsMailFragment.this.getResources().getDimensionPixelSize(2131299664), 0, 0);
          ReadVirtualAdsMailFragment.this.body.setLayoutParams(ReadVirtualAdsMailFragment.this.bodyParam);
          return;
          i = 8;
        }
        return;
      }
      catch (Exception localException)
      {
        QMLog.log(6, ReadVirtualAdsMailFragment.TAG, "onHideCustom exception:" + localException.toString());
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
    
    @Override
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
    }
    
    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      super.onShowCustomView(paramView, paramCustomViewCallback);
      try
      {
        ReadVirtualAdsMailFragment.this.webviewContainer.setLayoutParams(this.LayoutParameters);
        this.blackView = new View(ReadVirtualAdsMailFragment.this.getActivity());
        this.blackView.setBackgroundColor(-16777216);
        ReadVirtualAdsMailFragment.this.webviewContainer.addView(this.blackView, this.LayoutParameters);
        paramView.setLayoutParams(this.LayoutParameters);
        ReadVirtualAdsMailFragment.access$2502(ReadVirtualAdsMailFragment.this, paramView);
        ReadVirtualAdsMailFragment.this.webviewContainer.addView(ReadVirtualAdsMailFragment.this.videoView);
        this.mCustomViewCallback = paramCustomViewCallback;
        if ((ReadVirtualAdsMailFragment.this.videoView instanceof FrameLayout))
        {
          paramView = ((FrameLayout)ReadVirtualAdsMailFragment.this.videoView).getFocusedChild();
          if ((paramView instanceof VideoView)) {
            ((VideoView)paramView).setOnCompletionListener(this);
          }
        }
        FullWindowHelper.changeToFullScreen(ReadVirtualAdsMailFragment.this.getActivity().getWindow(), ReadVirtualAdsMailFragment.this.getActivity());
        ReadVirtualAdsMailFragment.this.getActivity().setRequestedOrientation(0);
        ReadVirtualAdsMailFragment.this.topbar.setVisibility(8);
        ReadVirtualAdsMailFragment.this.footerBar.setVisibility(8);
        ReadVirtualAdsMailFragment.this.bodyParam.setMargins(0, 0, 0, 0);
        ReadVirtualAdsMailFragment.this.body.setLayoutParams(ReadVirtualAdsMailFragment.this.bodyParam);
        return;
      }
      catch (Exception paramView)
      {
        QMLog.log(6, ReadVirtualAdsMailFragment.TAG, "onShowCustomView exception:" + paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadVirtualAdsMailFragment
 * JD-Core Version:    0.7.0.1
 */