package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqmail.InlineImage.delaystream.DelayCidInputStream;
import com.tencent.qqmail.InlineImage.delaystream.DelayHttpInputStream;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.URLRequestIntercepter;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;
import com.tencent.qqmail.utilities.richeditor.QMEditText;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;
import org.apache.http.cookie.Cookie;

public class QMComposeMailView
  extends FrameLayout
  implements ComposeMailView, QMComposeAttach.QMComposeAttachCallback, QMComposeHeader.QMComposeHeaderCallback
{
  private static final String FILE_LOCALHOST = "file://localhost";
  private static final String TAG = "QMComposeMailView";
  private boolean attachBoardShow = false;
  private ComposeViewCallback callback;
  private QMEditText contentET;
  private LinearLayout contentLoading;
  private RelativeLayout contentLoadingIcon;
  private TextView contentLoadingText;
  private QMUIRichEditor editor;
  private boolean editorFocused = true;
  private Runnable focusRunnable = new QMComposeMailView.3(this);
  private ComposeToolBar formatToolbar;
  private boolean hasRecordPosition = false;
  private boolean hasSetLineHeight = false;
  private QMComposeHeader header;
  private int headerHeight = -1;
  private HashMap<String, Integer> imgSrcAndAccountIdHashMap = new HashMap();
  private boolean isKBShown = false;
  private int keyboardHeight = -1;
  private int lastX = -1;
  private int lastY = -1;
  private int lineHeight = 0;
  private Context mContext;
  private Account mDefaultSenderAccount;
  private Mail mail;
  private String mailText = "";
  private int oriViewHeight = 0;
  private String originContent = "";
  private int screenHeight = 0;
  private int screenWidth = 0;
  private boolean scrollable;
  private ComposeCommUI.QMSendType sendType;
  
  public QMComposeMailView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public QMComposeMailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public QMComposeMailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void changeAccountSignature(Account paramAccount)
  {
    String str = QMSettingManager.sharedInstance().getAccountSignature(paramAccount.getId());
    if (this.editor != null)
    {
      QMUIRichEditor localQMUIRichEditor = this.editor;
      paramAccount = str;
      if (TextUtils.isEmpty(str)) {
        paramAccount = "";
      }
      localQMUIRichEditor.changeSign(paramAccount);
    }
  }
  
  private int getAddrNoFocusHeight()
  {
    int i = this.header.getAddrMinHeight();
    if (this.header.hasCCorBCC()) {
      return i + (this.header.getAddrMinHeight() * 2 + this.header.getSenderMinHeight());
    }
    return i + this.header.getSenderMinHeight();
  }
  
  private String getCompleteUrl(String paramString)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setUrl(paramString);
    if (this.imgSrcAndAccountIdHashMap.get(paramString) == null) {}
    for (int i = 0;; i = ((Integer)this.imgSrcAndAccountIdHashMap.get(paramString)).intValue())
    {
      int j = i;
      if (i == 0)
      {
        Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
        if (localAccount == null) {
          break;
        }
        j = localAccount.getId();
      }
      localDownloadInfo.setAccountId(j);
      localDownloadInfo.setDownloadType(2);
      localDownloadInfo.setSessionType(1);
      paramString = DownloadUtil.getRequestUrl(localDownloadInfo);
      Log.i("QMComposeMailView", "Complete after url =" + paramString);
      return paramString;
    }
    throw new IllegalStateException("url:" + paramString);
  }
  
  private int getEditTextLineHeight()
  {
    if (!this.hasSetLineHeight) {
      return this.contentET.getLineHeight();
    }
    if (this.lineHeight > 45) {
      this.lineHeight = 45;
    }
    return this.lineHeight;
  }
  
  private int getHeaderHeight()
  {
    int i = 0;
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) {
      i = getAddrNoFocusHeight() + this.header.getSubjectMinHeight();
    }
    while (this.sendType != ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
      return i;
    }
    return this.header.getHeight();
  }
  
  private String getSrc(String paramString)
  {
    if (QMUrlUtil.isViewFile(paramString)) {
      return CGIManager.removeSid(paramString);
    }
    return FileUtil.filterLocalPath(paramString);
  }
  
  private int getVisibleHeight()
  {
    return this.oriViewHeight - this.keyboardHeight;
  }
  
  private void initComposeContent()
  {
    this.contentET = ((QMEditText)findViewById(2131365153));
    this.editor = new QMUIRichEditor(getContext());
    this.editor.getSettings().setJavaScriptEnabled(true);
    this.editor.getSettings().setAppCacheEnabled(true);
    this.editor.getSettings().setDatabaseEnabled(true);
    this.editor.getSettings().setDomStorageEnabled(true);
    if (Build.VERSION.SDK_INT >= 21) {
      CookieManager.getInstance().setAcceptThirdPartyCookies(this.editor, true);
    }
    Object localObject = (LinearLayout)findViewById(2131365152);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).addView(this.editor, 0, localLayoutParams);
    this.contentLoading = ((LinearLayout)findViewById(2131365367));
    this.contentLoadingIcon = ((RelativeLayout)findViewById(2131365368));
    localObject = new QMLoading(getContext(), QMLoading.SIZE_MINI);
    this.contentLoadingIcon.addView((View)localObject);
    this.contentLoadingText = ((TextView)findViewById(2131365369));
  }
  
  private void initComposeHeader()
  {
    this.header = ((QMComposeHeader)findViewById(2131365161));
    this.header.setScreenSize(this.screenHeight, this.screenWidth);
    this.header.init(this.sendType);
    this.header.updateContactArray(new ArrayList(), new ArrayList());
    this.header.setCallback(this);
  }
  
  private void initToolBar()
  {
    this.formatToolbar = ((ComposeToolBar)findViewById(2131365154));
    this.formatToolbar.setActionListener(new QMComposeMailView.4(this));
  }
  
  private void initWebviewTitle()
  {
    this.editor.setEmbeddedTitleBarCompat(this.header);
    if (!VersionUtils.hasKitKat())
    {
      this.editor.setHeadHeight(0);
      return;
    }
    this.header.addOnLayoutChangeListener(new QMComposeMailView.5(this));
  }
  
  private void onToolBarClick(View paramView)
  {
    KvHelper.eventRichEditorMailAll(new double[0]);
    int i = paramView.getId();
    if (i == 2131366271)
    {
      KvHelper.eventRichEditorMailBold(new double[0]);
      this.editor.setBold();
    }
    for (;;)
    {
      com.tencent.qqmail.activity.compose.richeditor.DetailReporter.used_composemail_richstyle = true;
      return;
      if (i == 2131366275)
      {
        KvHelper.eventRichEditorMailMidline(new double[0]);
        this.editor.strikeThrough();
      }
      else if (i == 2131366274)
      {
        KvHelper.eventRichEditorMailList(new double[0]);
        this.editor.setUnorderedList();
      }
      else if (i == 2131366276)
      {
        KvHelper.eventRichEditorMailQuote(new double[0]);
        this.editor.setBlockquote();
      }
      else if (i == 2131366277)
      {
        KvHelper.eventRichEditorMailCenter(new double[0]);
        this.editor.setJustifyCenter();
      }
      else if (i == 2131367442)
      {
        KvHelper.eventRichEditorMailFontSizeSmall(new double[0]);
        this.editor.setSmallFontSize();
      }
      else if (i == 2131367426)
      {
        KvHelper.eventRichEditorMailFontSizeDefault(new double[0]);
        this.editor.setNormalFontSize();
      }
      else if (i == 2131367416)
      {
        KvHelper.eventRichEditorMailFontSizeBig(new double[0]);
        this.editor.setBigFontSize();
      }
      else if (i == 2131364928)
      {
        KvHelper.eventRichEditorMailFontColorBlack(new double[0]);
        this.editor.setTextColor("#000000");
      }
      else if (i == 2131364929)
      {
        KvHelper.eventRichEditorMailFontColorBlue(new double[0]);
        this.editor.setTextColor("#198dd9");
      }
      else if (i == 2131364931)
      {
        KvHelper.eventRichEditorMailFontColorRed(new double[0]);
        this.editor.setTextColor("#f64e4f");
      }
      else if (i == 2131364930)
      {
        KvHelper.eventRichEditorMailFontColorGray(new double[0]);
        this.editor.setTextColor("#A6A7AC");
      }
    }
  }
  
  private void setHtml(@NonNull String paramString)
  {
    this.editor.setHtml(paramString);
  }
  
  private void updateCookie()
  {
    if ((this.editor == null) || (!(this.mDefaultSenderAccount instanceof QQMailAccount))) {
      return;
    }
    updateCookieByQQmailAccount((QQMailAccount)this.mDefaultSenderAccount);
  }
  
  private void updateCookieByQQmailAccount(QQMailAccount paramQQMailAccount)
  {
    paramQQMailAccount = paramQQMailAccount.getCookies();
    CookieSyncManager.createInstance(getContext());
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.removeSessionCookie();
    Iterator localIterator = paramQQMailAccount.iterator();
    if (localIterator.hasNext())
    {
      paramQQMailAccount = (Cookie)localIterator.next();
      String str = paramQQMailAccount.getName() + "=" + paramQQMailAccount.getValue();
      if (paramQQMailAccount.getDomain() != null) {}
      for (paramQQMailAccount = paramQQMailAccount.getDomain();; paramQQMailAccount = "mail.qq.com")
      {
        localCookieManager.setCookie(paramQQMailAccount, str);
        break;
      }
    }
    CookieSyncManager.getInstance().sync();
  }
  
  private void updateEditorHeaderHeight(@NonNull View paramView)
  {
    int i = (int)(paramView.getHeight() / this.editor.getScale());
    QMLog.log(4, "QMComposeMailView", "header newHeaderHeight = " + i + " header height = " + paramView.getHeight() + " editor scale = " + this.editor.getScale());
    this.editor.setHeadHeight(i);
  }
  
  public void OnClickReceiverTextView()
  {
    if (this.callback != null) {
      this.callback.OnClickReceiverTextView();
    }
  }
  
  public void aaddAttachImgAtBegenning(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.startsWith("http"))) {}
    for (paramString1 = "file://localhost" + paramString1;; paramString1 = getCompleteUrl(paramString1))
    {
      this.editor.insertImageAtBegin(paramString1, "image");
      return;
    }
  }
  
  public void addAttachImg(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.startsWith("http")))
    {
      paramString2 = ImageUtil.getImageOpts(paramString1);
      int i = paramString2.outWidth;
      int j = paramString2.outHeight;
      paramString1 = "file://localhost" + paramString1;
      if ((i > 0) && (j > 0))
      {
        this.editor.insertImage(paramString1, "image", i + "", j + "");
        return;
      }
      this.editor.insertImage(paramString1, "image");
      return;
    }
    paramString1 = getCompleteUrl(paramString1);
    this.editor.insertImage(paramString1, "image");
  }
  
  public void addAttachImg(String paramString1, String paramString2, int paramInt)
  {
    setImgSrcAccountId(paramString1, paramInt);
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && ((localAccount instanceof QQMailAccount))) {
      updateCookieByQQmailAccount((QQMailAccount)localAccount);
    }
    addAttachImg(paramString1, paramString2);
  }
  
  public void addrViewScrollChanged(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.addrViewScrollChanged(this, paramQMComposeHeader, paramComposeAddrView);
    }
  }
  
  public void addrViewTextChanged(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView, String paramString)
  {
    if (this.callback != null) {
      this.callback.addrViewTextChanged(this, paramQMComposeHeader, paramComposeAddrView, paramString);
    }
  }
  
  public int adjustAutoCompleteCursor(ComposeAddrView paramComposeAddrView)
  {
    int i = paramComposeAddrView.getHeight();
    int j = paramComposeAddrView.getAutoCompleteTextViewHeight();
    int k = paramComposeAddrView.getPaddingBottom();
    k = paramComposeAddrView.getTop() + (i - j - k);
    int m = getVisibleHeight() - getEditTextLineHeight() * 2;
    j = getScrollY();
    if (k < j + m)
    {
      i = j;
      if (k > j) {}
    }
    else
    {
      j = getEditTextLineHeight() + k - m;
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
    return i;
  }
  
  public void autoScrollHeader(View paramView, int paramInt)
  {
    int k = paramView.getTop();
    if (paramView != this.header.getSubject()) {}
    for (int i = paramView.getHeight();; i = 0)
    {
      int j = getScrollY();
      int m = k + i - j;
      i = j;
      if (m > paramInt) {
        i = j + (m - paramInt);
      }
      if (i < k) {}
      setVerticalScrollBarEnabled(false);
      return;
    }
  }
  
  public void autoScrollToTop()
  {
    scrollToTop();
  }
  
  public void autoSrollContent(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void bindOnLongClickListener(ComposeMailActivity.LongClickListener paramLongClickListener)
  {
    this.header.bindLongClickListener(paramLongClickListener);
  }
  
  public void bindOnMoveListener(ComposeMailActivity.OnMoveListener paramOnMoveListener)
  {
    this.header.bindMoveListener(paramOnMoveListener);
  }
  
  public void blurEditerFocus()
  {
    if (this.editor == null) {
      return;
    }
    this.editor.blurFocus();
  }
  
  public void changeDefaultSenderAccount(Account paramAccount)
  {
    if ((this.mDefaultSenderAccount != null) && (this.mDefaultSenderAccount.getId() != paramAccount.getId())) {
      changeAccountSignature(paramAccount);
    }
    this.mDefaultSenderAccount = paramAccount;
    updateCookie();
    this.header.changeDefaultSenderAccount(paramAccount);
  }
  
  public void changeEditOriginContentMode(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clickedAddContactButton(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.clickAddContactButton(this, paramQMComposeHeader, paramComposeAddrView);
    }
  }
  
  public void clickedAddGroupContactButton(QMComposeHeader paramQMComposeHeader, ComposeAddrView paramComposeAddrView)
  {
    if (this.callback != null) {
      this.callback.clickedAddGroupContactButton(this, paramQMComposeHeader, paramComposeAddrView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.formatToolbar != null)
    {
      Rect localRect = new Rect();
      this.formatToolbar.getGlobalVisibleRect(localRect);
      if (!localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
        this.formatToolbar.packUpFontAndColorPane();
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void enterForClearFocus(QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramView.clearFocus();
    }
    do
    {
      return;
      if (paramView == paramQMComposeHeader.getReceiver())
      {
        if (paramQMComposeHeader.getCcAndBcc().getVisibility() == 0)
        {
          paramQMComposeHeader.getSubject().setFocused(true);
          return;
        }
        paramQMComposeHeader.getCC().setFocused(true);
        return;
      }
      if (paramView == paramQMComposeHeader.getCC())
      {
        paramQMComposeHeader.getBcc().setFocused(true);
        return;
      }
      if (paramView == paramQMComposeHeader.getBcc())
      {
        paramQMComposeHeader.getSubject().setFocused(true);
        return;
      }
    } while (paramView != paramQMComposeHeader.getSubject());
    focusAtEditor();
  }
  
  public void focusAtEditor()
  {
    if (this.editor == null) {
      return;
    }
    this.editor.focusEditor();
  }
  
  public ArrayList<Object> getBccContactList()
  {
    return this.header.getBccContactList();
  }
  
  public ArrayList<Object> getCCContactList()
  {
    return this.header.getCCContactList();
  }
  
  public EditText getContentET()
  {
    return this.contentET;
  }
  
  public String getContentText(boolean paramBoolean)
  {
    if (this.editor == null) {
      return this.mailText;
    }
    this.mailText = this.editor.getHtml();
    if (TextUtils.isEmpty(this.mailText)) {
      return this.originContent;
    }
    return this.mailText;
  }
  
  public void getContentTextSynchronously(@NonNull QMUIRichEditor.UpdateInnerHtmlCallback paramUpdateInnerHtmlCallback)
  {
    if (this.editor == null)
    {
      paramUpdateInnerHtmlCallback.success();
      return;
    }
    this.editor.getHtmlSynchronously(paramUpdateInnerHtmlCallback);
  }
  
  public View getFirstFocusView()
  {
    View localView = this.header.getFirstFocusView();
    Object localObject = localView;
    if (localView == null) {
      localObject = this.editor;
    }
    return localObject;
  }
  
  public QMComposeHeader getHeader()
  {
    return this.header;
  }
  
  public int getOriViewHeight()
  {
    return this.oriViewHeight;
  }
  
  public String getOriginContent()
  {
    return this.originContent;
  }
  
  public String getSignTemplate()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    String str = "";
    if (this.mDefaultSenderAccount != null) {
      str = QMSettingManager.sharedInstance().getAccountSignature(this.mDefaultSenderAccount.getId());
    }
    int i;
    if (!TextUtils.isEmpty(str))
    {
      i = 1;
      if (i == 0) {
        break label97;
      }
      localStringBuilder.append("<div><sign>" + StringExtention.textToHtml(str) + "</sign>" + "</div>");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      i = 0;
      break;
      label97:
      localStringBuilder.append("<div><sign> </sign></div>");
    }
  }
  
  public ArrayList<Object> getToContactList()
  {
    return this.header.getToContactList();
  }
  
  public int getVKBHeight()
  {
    return this.oriViewHeight - getHeight();
  }
  
  public WebView getWebView()
  {
    return this.editor;
  }
  
  public void handleSenderButton(QMComposeHeader paramQMComposeHeader)
  {
    if (this.callback != null) {
      this.callback.handleSenderButton(this, paramQMComposeHeader);
    }
  }
  
  public boolean hasFocusCursor()
  {
    return (this.contentET.isFocused()) || (this.header.hasFocusCursor());
  }
  
  public void hideContentLoading()
  {
    this.contentLoading.setVisibility(8);
  }
  
  public void hideformatToolbar(boolean paramBoolean)
  {
    if ((this.formatToolbar != null) && (this.formatToolbar.getVisibility() != 8))
    {
      if (this.callback != null) {
        this.callback.onFormatToobarChange(false);
      }
      this.formatToolbar.setVisibility(8);
      if (paramBoolean) {}
    }
    else
    {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new QMComposeMailView.8(this));
    this.formatToolbar.startAnimation(localAlphaAnimation);
  }
  
  public void initView(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    this.screenHeight = QMUIKit.getScreenHeight();
    this.screenWidth = QMUIKit.getScreenWidth();
    initComposeHeader();
    initComposeContent();
    initWebviewTitle();
    updateCookie();
    initToolBar();
    this.editor.setUrlRequestIntercepter(new URLRequestIntercepterImpl(null));
    this.editor.setOnDecorationChangeListener(this.formatToolbar);
    this.editor.setEditorFocusChangeListener(new QMComposeMailView.1(this));
    this.editor.setOnInputListener(new QMComposeMailView.2(this));
    changeDefaultSenderAccount(this.mDefaultSenderAccount);
  }
  
  public boolean isKBShown()
  {
    return this.isKBShown;
  }
  
  public boolean isScrollable()
  {
    return this.scrollable;
  }
  
  public void layoutComposeCardMail()
  {
    this.header.layoutComposeCardMail();
  }
  
  public void layoutComposeFeedBack()
  {
    this.header.layoutComposeFeedBack();
  }
  
  public void layoutComposeGroupMail()
  {
    this.header.layoutComposeGroupMail();
  }
  
  public void layoutComposeMail(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.header.layoutComposeMail(paramQMSendType);
  }
  
  public void onClickChange(QMComposeHeader paramQMComposeHeader, View paramView)
  {
    if (this.callback != null) {
      this.callback.onClickChange(this, paramQMComposeHeader, paramView, this.isKBShown);
    }
  }
  
  public void onClickItem(QMComposeAttachItem paramQMComposeAttachItem)
  {
    if (this.callback != null) {
      this.callback.onClickAttach(this, paramQMComposeAttachItem);
    }
  }
  
  public void onFocusChange(QMComposeHeader paramQMComposeHeader, View paramView, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.onFocusChange(this, paramQMComposeHeader, paramView, paramBoolean);
    }
    paramBoolean = paramQMComposeHeader.hasFocusCursor();
    if (paramBoolean) {
      this.editor.blurFocus();
    }
    if ((this.sendType == ComposeCommUI.QMSendType.t_SEND_CARD_MAIL) || (this.formatToolbar == null) || (!VersionUtils.hasKitKat()) || ((this.isKBShown) && (!paramBoolean))) {
      return;
    }
    hideformatToolbar(true);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.callback != null)
    {
      paramInt1 = this.oriViewHeight - paramInt2;
      if (paramInt2 > this.oriViewHeight) {
        this.oriViewHeight = paramInt2;
      }
      if (paramInt1 <= 0) {
        break label98;
      }
      this.isKBShown = true;
      this.keyboardHeight = paramInt1;
    }
    for (;;)
    {
      this.callback.sizeDidChange(this, paramInt1);
      if ((this.sendType != ComposeCommUI.QMSendType.t_SEND_CARD_MAIL) && (this.formatToolbar != null) && (VersionUtils.hasKitKat())) {
        post(new QMComposeMailView.7(this));
      }
      return;
      label98:
      this.isKBShown = false;
    }
  }
  
  public void release()
  {
    this.mContext = null;
    if (this.editor != null)
    {
      ((LinearLayout)findViewById(2131365152)).removeAllViews();
      this.editor.getSettings().setJavaScriptEnabled(false);
      this.editor.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.editor.setWebViewClient(null);
      this.editor.setOnClickListener(null);
      this.editor.setOnLongClickListener(null);
      this.editor.setOnTouchListener(null);
      this.editor.removeAllViews();
      this.editor.destroy();
      this.editor = null;
    }
  }
  
  public void replaceInlineImageSrc(String paramString1, String paramString2)
  {
    this.editor.changeImageSrc(paramString1, paramString2);
  }
  
  public void saveFocusCursor()
  {
    if (this.header.hasFocusCursor()) {
      this.header.saveFocusCursor();
    }
  }
  
  public void scrollAutoComplete(ComposeAddrView paramComposeAddrView, int paramInt)
  {
    int i = adjustAutoCompleteCursor(paramComposeAddrView);
    if ((paramInt == 1) && (!this.hasRecordPosition))
    {
      this.lastX = getScrollX();
      this.lastY = i;
      this.hasRecordPosition = true;
    }
    do
    {
      paramInt = paramComposeAddrView.getPaddingTop() + paramComposeAddrView.getPaddingBottom();
      i = paramComposeAddrView.getAutoCompleteTextViewHeight() + paramInt;
      paramComposeAddrView.getHeight();
      if (((paramComposeAddrView != this.header.getReceiver()) || (paramComposeAddrView.getHeight() - paramInt >= paramComposeAddrView.getAutoCompleteTextViewHeight() * 2)) || (paramComposeAddrView.getHeight() <= i)) {}
      return;
      if ((paramInt == 0) && (this.hasRecordPosition))
      {
        scrollBack();
        return;
      }
    } while (paramInt != 0);
  }
  
  public void scrollBack() {}
  
  public void scrollClickChange(View paramView, boolean paramBoolean)
  {
    int j;
    int k;
    int i;
    if (!(paramView instanceof QMTextField))
    {
      j = 1;
      k = paramView.getTop() - getScrollY();
      i = getVisibleHeight() - getEditTextLineHeight();
      int m = i;
      if (j != 0) {
        m = i - getEditTextLineHeight();
      }
      i = k;
      if (k < 0) {
        i = 0;
      }
      k = i;
      if (!paramBoolean)
      {
        k = i;
        if (i > m) {
          k = m - getEditTextLineHeight();
        }
      }
      i = getHeaderHeight();
      if (j == 0) {
        break label133;
      }
      i = this.contentET.getPaddingTop() + 0 + i;
    }
    for (;;)
    {
      j = i - k;
      i = j;
      if (j < 0) {
        i = 0;
      }
      scrollTo(0, i);
      return;
      j = 0;
      break;
      label133:
      if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) {
        i -= this.header.getSubjectMinHeight();
      }
    }
  }
  
  public void scrollToTop()
  {
    this.editor.scrollToTop();
  }
  
  public void setAttachBoardShow(boolean paramBoolean)
  {
    this.attachBoardShow = paramBoolean;
  }
  
  public void setCallback(ComposeViewCallback paramComposeViewCallback)
  {
    this.callback = paramComposeViewCallback;
  }
  
  public void setContentText(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    Log.i("QMComposeMailView", "setContentText mailText = " + str);
    setHtml(str);
  }
  
  public void setDefaultSenderAccount(Account paramAccount)
  {
    this.mDefaultSenderAccount = paramAccount;
    updateCookie();
  }
  
  public void setGroupToTitle(MailGroupContact paramMailGroupContact)
  {
    if (paramMailGroupContact == null) {
      return;
    }
    this.header.setGroupToWithContact(paramMailGroupContact);
  }
  
  public void setImgSrcAccountId(String paramString, int paramInt)
  {
    this.imgSrcAndAccountIdHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void setMail(Mail paramMail)
  {
    this.mail = paramMail;
  }
  
  public void setOriginCardContent(String paramString)
  {
    this.originContent = paramString;
    this.editor.loadDataWithBaseURL("file:///read?t=mail", paramString, "text/html", "UTF-8", null);
    if (!VersionUtils.hasKitKat())
    {
      this.editor.setCardHeadHeight(10);
      return;
    }
    this.header.addOnLayoutChangeListener(new QMComposeMailView.6(this));
  }
  
  public void setOriginContent(String paramString, float paramFloat1, float paramFloat2)
  {
    QMLog.log(4, "QMComposeMailView", "setOriginContent " + paramString);
    this.originContent = paramString;
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    setHtml(localStringBuilder.toString());
  }
  
  public void setOriginContentFromPopularize(String paramString)
  {
    this.originContent = paramString;
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    setHtml(localStringBuilder.toString());
  }
  
  public void setOriginContentWithQuickReply(String paramString1, String paramString2)
  {
    this.originContent = paramString1;
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append(paramString2 + "<br/>");
      localStringBuilder.append("<br/><br/>");
    }
    localStringBuilder.append(paramString1);
    setHtml(localStringBuilder.toString());
    this.editor.focusEditorAtBegin();
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.scrollable = paramBoolean;
  }
  
  public void setSendTitle(MailContact paramMailContact)
  {
    if (paramMailContact == null) {
      return;
    }
    this.header.setSendTitle(paramMailContact);
  }
  
  public void setSendType(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
  }
  
  public void showContentLoading()
  {
    this.contentLoadingIcon.setVisibility(0);
    this.contentLoadingText.setText(this.mContext.getString(2131692147));
    this.contentLoading.setVisibility(0);
  }
  
  public void showContentLoadingError()
  {
    this.contentLoadingIcon.setVisibility(8);
    this.contentLoadingText.setText(this.mContext.getString(2131692148));
    this.contentLoading.setVisibility(0);
  }
  
  public void showformatToolbar(boolean paramBoolean)
  {
    if ((this.formatToolbar != null) && (this.formatToolbar.getVisibility() != 0))
    {
      if (this.callback != null) {
        this.callback.onFormatToobarChange(true);
      }
      this.formatToolbar.setVisibility(0);
      if (paramBoolean) {}
    }
    else
    {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new QMComposeMailView.9(this));
    this.formatToolbar.startAnimation(localAlphaAnimation);
  }
  
  public void updateContactArray(List<MailContact> paramList1, List<MailContact> paramList2)
  {
    this.header.updateContactArray(paramList1, paramList2);
  }
  
  class URLRequestIntercepterImpl
    implements QMUIRichEditor.URLRequestIntercepter
  {
    private URLRequestIntercepterImpl() {}
    
    public WebResourceResponse intercept(String paramString)
    {
      QMLog.log(4, "QMComposeMailView", "intercept " + paramString + " thread name " + Thread.currentThread().getName());
      if (paramString.startsWith("http"))
      {
        int j = -1;
        int i = j;
        if (QMComposeMailView.this.mail != null)
        {
          i = j;
          if (QMComposeMailView.this.mail.getInformation() != null) {
            i = QMComposeMailView.this.mail.getInformation().getAccountId();
          }
        }
        return new WebResourceResponse("", "utf-8", new DelayHttpInputStream(paramString, i));
      }
      if (paramString.startsWith("cid")) {
        return new WebResourceResponse("", "utf-8", new DelayCidInputStream(paramString, QMComposeMailView.this.mail));
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView
 * JD-Core Version:    0.7.0.1
 */