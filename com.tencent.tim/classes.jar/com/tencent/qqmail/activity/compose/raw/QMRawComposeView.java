package com.tencent.qqmail.activity.compose.raw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeAddrView;
import com.tencent.qqmail.activity.compose.ComposeCommUI.QMSendType;
import com.tencent.qqmail.activity.compose.ComposeMailActivity.LongClickListener;
import com.tencent.qqmail.activity.compose.ComposeMailActivity.OnMoveListener;
import com.tencent.qqmail.activity.compose.ComposeMailView;
import com.tencent.qqmail.activity.compose.ComposeViewCallback;
import com.tencent.qqmail.activity.compose.QMComposeAttach.QMComposeAttachCallback;
import com.tencent.qqmail.activity.compose.QMComposeAttachItem;
import com.tencent.qqmail.activity.compose.QMComposeHeader;
import com.tencent.qqmail.activity.compose.QMComposeHeader.QMComposeHeaderCallback;
import com.tencent.qqmail.activity.compose.QMTextField;
import com.tencent.qqmail.activity.compose.QQMailUILabel;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;
import com.tencent.qqmail.utilities.richeditor.HtmlToSpannedConverter;
import com.tencent.qqmail.utilities.richeditor.QMAudioSpan;
import com.tencent.qqmail.utilities.richeditor.QMEditText;
import com.tencent.qqmail.utilities.richeditor.QMEditText.QMEditTextCallback;
import com.tencent.qqmail.utilities.richeditor.QMSignSpan;
import com.tencent.qqmail.utilities.richeditor.SpannedToHtmlConverter;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.template.Template;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class QMRawComposeView
  extends ScrollView
  implements ComposeMailView, QMComposeAttach.QMComposeAttachCallback, QMComposeHeader.QMComposeHeaderCallback, QMEditText.QMEditTextCallback
{
  public static final int MINI_IMAGE_SIZE = 290;
  private static final String TAG = "QMComposeView";
  private ComposeViewCallback callback;
  private QMEditText contentET;
  private int contentETCursor = 0;
  private int contentETScrollCursor = 0;
  private LinearLayout contentLoading;
  private RelativeLayout contentLoadingIcon;
  private TextView contentLoadingText;
  private HtmlToSpannedConverter converter;
  private String focusView = "";
  private boolean hasRecordPosition = false;
  private boolean hasSetLineHeight = false;
  private QMComposeHeader header;
  private HashMap<String, Integer> imgSrcAndAccountIdHashMap = new HashMap();
  private boolean isHideWebviewFocus = true;
  private boolean isKBShown = false;
  private int keyboardHeight = -1;
  private int lastX = -1;
  private int lastY = -1;
  private int lineHeight = 0;
  private Context mContext;
  private Account mDefaultSenderAccount;
  private TextView mNoteCat;
  private TextView mNoteDate;
  private View mNoteHeader;
  private EditText mNoteSubj;
  private int mRequestAccountId = 0;
  private boolean mbIsSetText = false;
  private int oriViewHeight = 0;
  private String originContent = "";
  private int screenHeight = 0;
  private int screenWidth = 0;
  private int scrollImageHeight = 0;
  private boolean scrollable;
  private ComposeCommUI.QMSendType sendType;
  private WebView webView;
  
  public QMRawComposeView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public QMRawComposeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public QMRawComposeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void addMediaFileToContent(int paramInt, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    Object localObject3 = Pattern.compile("image:.*?;").matcher(paramString);
    boolean bool = ((Matcher)localObject3).find();
    int j;
    int i;
    Object localObject5;
    Object localObject2;
    if (bool)
    {
      Object localObject1 = ((Matcher)localObject3).group();
      j = paramInt + ((Matcher)localObject3).start();
      int k = j + ((String)localObject1).length();
      if (((ImageSpan[])localSpannableStringBuilder.getSpans(j, k, ImageSpan.class)).length == 0)
      {
        localObject1 = Pattern.compile("(?<=image:).*?(?=;)").matcher((CharSequence)localObject1);
        if (((Matcher)localObject1).find())
        {
          localObject4 = ((Matcher)localObject1).group();
          if (!((String)localObject4).startsWith("http")) {
            break label195;
          }
        }
      }
      try
      {
        i = getAccountIdBySrc((String)localObject4);
        localObject1 = Integer.valueOf(i);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject2 = null;
          continue;
          i = ((Integer)localObject2).intValue();
        }
      }
      localObject4 = MailContentLoader.transformUrl((String)localObject4);
      localObject5 = this.contentET;
      if (localObject1 == null)
      {
        i = this.mRequestAccountId;
        ((QMEditText)localObject5).addWebImgWithRequestAccountId(i, (String)localObject4, j, k, this.mbIsSetText);
      }
      for (;;)
      {
        bool = ((Matcher)localObject3).find();
        break;
        label195:
        if (((String)localObject4).startsWith("cid:")) {
          this.contentET.addProtocolInlineImg((String)localObject4, j, k);
        } else if (((String)localObject4).startsWith("file:///android_asset")) {
          this.contentET.addDefaultImg((String)localObject4, j, k);
        } else if (((String)localObject4).startsWith("file://")) {
          this.contentET.addLocalImg(((String)localObject4).replace("file://localhost", ""), j, k, this.mbIsSetText);
        } else {
          this.contentET.addDefaultImg((String)localObject4, j, k);
        }
      }
    }
    Object localObject4 = Pattern.compile("audio:.*?;").matcher(paramString);
    bool = ((Matcher)localObject4).find();
    if (bool)
    {
      localObject5 = ((Matcher)localObject4).group();
      paramString = "";
      localObject2 = Pattern.compile("(?<=src=).*?(?=;)").matcher((CharSequence)localObject5);
      if (((Matcher)localObject2).find()) {
        paramString = ((Matcher)localObject2).group();
      }
      localObject2 = "";
      localObject3 = Pattern.compile("(?<=name=).*?(?=,)").matcher((CharSequence)localObject5);
      if (((Matcher)localObject3).find()) {
        localObject2 = ((Matcher)localObject3).group();
      }
      localObject3 = Pattern.compile("(?<=size=).*?(?=,)").matcher((CharSequence)localObject5);
      if (!((Matcher)localObject3).find()) {
        break label535;
      }
    }
    label535:
    for (localObject3 = ((Matcher)localObject3).group();; localObject3 = "")
    {
      if ((!paramString.equals("")) && (!((String)localObject2).equals("")) && (!((String)localObject3).equals("")))
      {
        i = paramInt + ((Matcher)localObject4).start();
        j = i + ((String)localObject5).length();
        if (j >= localSpannableStringBuilder.length()) {
          localSpannableStringBuilder.append('\n');
        }
        this.contentET.addAudioSpan((String)localObject2, Long.parseLong((String)localObject3), paramString, i, j, this.mbIsSetText);
      }
      bool = ((Matcher)localObject4).find();
      break;
      if (this.mbIsSetText == true) {
        this.mbIsSetText = false;
      }
      return;
    }
  }
  
  private void adjustEditTextCursor()
  {
    QMEditText localQMEditText = this.contentET;
    Object localObject = localQMEditText.getLayout();
    if (localObject == null) {
      return;
    }
    int i = ((Layout)localObject).getLineForOffset(localQMEditText.getSelectionStart());
    int j = ((Layout)localObject).getLineBaseline(i);
    int k = ((Layout)localObject).getLineAscent(i);
    if ((!this.hasSetLineHeight) && (i != 0))
    {
      localObject = new Rect();
      localQMEditText.getLineBounds(i, (Rect)localObject);
      this.lineHeight = (((Rect)localObject).bottom - ((Rect)localObject).top);
      this.hasSetLineHeight = true;
    }
    scrollContentCursor(j + k, true);
  }
  
  private void adjustEditTextCursorWithPos(int paramInt)
  {
    Layout localLayout = this.contentET.getLayout();
    if (localLayout == null) {
      return;
    }
    paramInt = localLayout.getLineForOffset(paramInt);
    int i = localLayout.getLineBaseline(paramInt);
    i = localLayout.getLineAscent(paramInt) + i;
    paramInt = i;
    if (this.scrollImageHeight > 0)
    {
      paramInt = i + this.scrollImageHeight;
      this.scrollImageHeight = 0;
    }
    scrollContentCursor(paramInt, true);
  }
  
  private void changeAccountSignature(Account paramAccount)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    Object localObject = (QMSignSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), QMSignSpan.class);
    String str2 = null;
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (localObject.length > 0) {
        str1 = localObject[0];
      }
    }
    int j;
    if (str1 != null)
    {
      i = localSpannableStringBuilder.getSpanStart(str1);
      j = localSpannableStringBuilder.getSpanEnd(str1);
      str2 = QMSettingManager.sharedInstance().getAccountSignature(paramAccount.getId());
      localObject = localSpannableStringBuilder.subSequence(i, j).toString();
      paramAccount = str2;
      if (str2 == null) {
        paramAccount = "";
      }
      if ((!paramAccount.equals("")) || (!"".equals(localObject))) {}
    }
    do
    {
      return;
      localSpannableStringBuilder.replace(i, j, paramAccount);
      localSpannableStringBuilder.removeSpan(str1);
      if ((paramAccount.equals("")) && (!((String)localObject).equals("")) && (localSpannableStringBuilder.length() > 1)) {
        if (localSpannableStringBuilder.subSequence(i - 2, i).toString().equals("\n\n")) {
          localSpannableStringBuilder.replace(i - 2, i, "");
        }
      }
      for (;;)
      {
        this.contentET.setText(localSpannableStringBuilder);
        return;
        if ((!paramAccount.equals("")) && (!((String)localObject).equals(""))) {
          localSpannableStringBuilder.setSpan(new QMSignSpan(this.mContext, 2131756053), i, paramAccount.length() + i, 17);
        }
      }
      paramAccount = QMSettingManager.sharedInstance().getAccountSignature(paramAccount.getId());
    } while ((paramAccount == null) || (paramAccount.equals("")));
    localSpannableStringBuilder.insert(localSpannableStringBuilder.length(), "\n\n");
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.insert(i, paramAccount);
    localSpannableStringBuilder.setSpan(new QMSignSpan(this.mContext, 2131756053), i, paramAccount.length() + i, 17);
    this.contentET.setText(localSpannableStringBuilder);
  }
  
  private void editAfterMediaFile(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    Object localObject = localSpannableStringBuilder.getSpans(0, paramInt1, ImageSpan.class);
    ImageSpan localImageSpan;
    if ((localObject != null) && (localObject.length > 0))
    {
      localImageSpan = (ImageSpan)localObject[(localObject.length - 1)];
      localSpannableStringBuilder.getSpanStart(localImageSpan);
      if (localSpannableStringBuilder.getSpanEnd(localImageSpan) == paramInt1)
      {
        localObject = "";
        if (paramInt1 < paramCharSequence.length() - 1) {
          localObject = paramCharSequence.subSequence(paramInt1, paramInt1 + 1).toString();
        }
        if ((paramInt2 != 1) || (paramInt3 != 0)) {
          break label208;
        }
      }
    }
    label208:
    do
    {
      for (;;)
      {
        localObject = localSpannableStringBuilder.getSpans(0, paramInt1, QMAudioSpan.class);
        if ((localObject != null) && (localObject.length > 0))
        {
          localObject = (QMAudioSpan)localObject[(localObject.length - 1)];
          localSpannableStringBuilder.getSpanStart(localObject);
          if (localSpannableStringBuilder.getSpanEnd(localObject) == paramInt1)
          {
            localObject = "";
            if (paramInt1 < paramCharSequence.length() - 1) {
              localObject = paramCharSequence.subSequence(paramInt1, paramInt1 + 1).toString();
            }
            if ((paramInt2 != 1) || (paramInt3 != 0)) {
              break;
            }
          }
        }
        return;
        if (!((String)localObject).equals("\n"))
        {
          localObject = QMApplicationContext.sharedInstance();
          int i = (int)(((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getWidth() - 1 - ((Context)localObject).getResources().getDimension(2131296986) * 2.0F);
          if (localImageSpan.getDrawable().getBounds().right >= i)
          {
            localSpannableStringBuilder.insert(paramInt1, "\n");
            this.contentET.setSelection(paramInt1 + paramInt3 + 1);
          }
        }
      }
    } while (((String)localObject).equals("\n"));
    localSpannableStringBuilder.insert(paramInt1, "\n");
    this.contentET.setSelection(paramInt1 + paramInt3 + 1);
  }
  
  private void editBeforeMediaFile(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    Object localObject2 = localSpannableStringBuilder.getSpans(paramInt1, localSpannableStringBuilder.length(), ImageSpan.class);
    int i;
    Object localObject1;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      i = 0;
      if (i >= localObject2.length) {
        break label273;
      }
      localObject1 = (ImageSpan)localObject2[i];
      if (localSpannableStringBuilder.getSpanStart(localObject1) != paramInt1 + paramInt3) {
        break label228;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = QMApplicationContext.sharedInstance();
        i = (int)(((WindowManager)((QMApplicationContext)localObject2).getSystemService("window")).getDefaultDisplay().getWidth() - 1 - ((QMApplicationContext)localObject2).getResources().getDimension(2131296986) * 2.0F);
        if (((ImageSpan)localObject1).getDrawable().getBounds().width() == i)
        {
          localObject1 = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString();
          if ((paramInt2 != 1) || (paramInt3 != 0)) {
            break label237;
          }
          localObject1 = "";
          if (paramInt1 > 0) {
            localObject1 = paramCharSequence.subSequence(paramInt1 - 1, paramInt1).toString();
          }
          if ((paramInt1 > 0) && (!((String)localObject1).equals("\n")))
          {
            localSpannableStringBuilder.insert(paramInt1 + paramInt3, "\n");
            this.contentET.setSelection(paramInt1);
          }
        }
      }
      label228:
      label237:
      while (((String)localObject1).equals("\n"))
      {
        return;
        i += 1;
        break;
      }
      localSpannableStringBuilder.insert(paramInt1 + paramInt3, "\n");
      this.contentET.setSelection(paramInt1 + paramInt3);
      return;
      label273:
      localObject1 = null;
    }
  }
  
  private String filterContentByBusiness(String paramString)
  {
    String str = paramString;
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL) {
      str = paramString.replaceAll("<div>(<img src.*?>)</div>", "$1").replaceAll("(<audio src.*?</audio>)<br>", "$1");
    }
    return str;
  }
  
  private String getContentTemplate()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (this.mDefaultSenderAccount != null) {}
    for (String str = QMSettingManager.sharedInstance().getAccountSignature(this.mDefaultSenderAccount.getId());; str = "")
    {
      int i;
      if ((str != null) && (!"".equals(str)))
      {
        i = 1;
        localStringBuilder.append("$newContentNode$");
        localStringBuilder = new StringBuilder(StringExtention.textToHtml(localStringBuilder.toString()));
        if (i == 0) {
          break label117;
        }
        localStringBuilder.append("<br/><sign>" + StringExtention.textToHtml(str) + "</sign>");
      }
      for (;;)
      {
        return localStringBuilder.toString();
        i = 0;
        break;
        label117:
        localStringBuilder.append("<sign> </sign>");
      }
    }
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
  
  private String getSrc(String paramString)
  {
    if (QMUrlUtil.isViewFile(paramString)) {
      return CGIManager.removeSid(paramString);
    }
    return FileUtil.filterLocalPath(paramString);
  }
  
  private float getTextHeight(String paramString, float paramFloat1, float paramFloat2)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      return 0.0F;
    }
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat1);
    int k = paramString.length();
    int j = 0;
    paramFloat1 = 0.0F;
    int i = 1;
    char c;
    if (j < k)
    {
      c = paramString.charAt(j);
      if (c == '\n')
      {
        i += 1;
        paramFloat1 = 0.0F;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      float f = localPaint.measureText(String.valueOf(c));
      paramFloat1 += f;
      if (paramFloat1 > paramFloat2)
      {
        i += 1;
        paramFloat1 = f;
        continue;
        paramFloat1 = localPaint.descent();
        paramFloat2 = localPaint.ascent();
        return i * (paramFloat1 - paramFloat2);
      }
    }
  }
  
  private void initComposeContent()
  {
    this.contentET = ((QMEditText)findViewById(2131365153));
    this.contentET.setCallback(this);
    this.webView = new WebView(getContext());
    this.webView.setOnFocusChangeListener(new QMRawComposeView.4(this));
    this.webView.setOnLongClickListener(new QMRawComposeView.5(this));
    this.contentLoading = ((LinearLayout)findViewById(2131365367));
    this.contentLoadingIcon = ((RelativeLayout)findViewById(2131365368));
    QMLoading localQMLoading = new QMLoading(getContext(), QMLoading.SIZE_MINI);
    this.contentLoadingIcon.addView(localQMLoading);
    this.contentLoadingText = ((TextView)findViewById(2131365369));
    this.contentET.setText("");
    initWebView();
    this.contentET.setLineSpacing(QMUIKit.dpToPx(8), 1.0F);
    this.contentET.setOnTouchListener(new QMRawComposeView.6(this));
    this.contentET.setOnFocusChangeListener(new QMRawComposeView.7(this));
    this.contentET.addTextChangedListener(new QMRawComposeView.8(this));
    if ((this.sendType == ComposeCommUI.QMSendType.t_SEND_CARD_MAIL) || (this.sendType == ComposeCommUI.QMSendType.t_SEND_CLOCKED_CARD_MAIL)) {
      this.contentET.setVisibility(8);
    }
  }
  
  private void initComposeHeader()
  {
    this.header = ((QMComposeHeader)findViewById(2131365161));
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL)
    {
      this.header.setVisibility(8);
      return;
    }
    this.header.setScreenSize(this.screenHeight, this.screenWidth);
    this.header.init(this.sendType);
    this.header.updateContactArray(new ArrayList(), new ArrayList());
    this.header.setCallback(this);
  }
  
  @SuppressLint({"InlinedApi"})
  private void initWebView()
  {
    Object localObject = this.webView.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setDefaultTextEncodingName("utf-8");
    ((WebSettings)localObject).setAppCacheMaxSize(8388608L);
    if (FileUtil.hasSdcard()) {
      ((WebSettings)localObject).setAppCachePath(QMPathManager.sharedInstance().getQQMailCacheDir());
    }
    ((WebSettings)localObject).setAppCacheEnabled(true);
    ((WebSettings)localObject).setCacheMode(1);
    if (Build.VERSION.SDK_INT >= 11) {
      this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setVisibility(8);
    this.webView.setWebViewClient(new QMRawComposeView.9(this));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    if ((this.sendType == ComposeCommUI.QMSendType.t_SEND_CARD_MAIL) || (this.sendType == ComposeCommUI.QMSendType.t_SEND_CLOCKED_CARD_MAIL))
    {
      localLayoutParams.leftMargin = (getResources().getDimensionPixelSize(2131296989) - QMUIKit.dpToPx(2));
      localLayoutParams.rightMargin = (getResources().getDimensionPixelSize(2131296989) - QMUIKit.dpToPx(2));
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131296983);
      ((WebSettings)localObject).setUseWideViewPort(true);
      ((WebSettings)localObject).setLoadWithOverviewMode(true);
      this.webView.setScrollBarStyle(0);
    }
    this.webView.setLayoutParams(localLayoutParams);
    localObject = (LinearLayout)findViewById(2131365152);
    ((LinearLayout)localObject).addView(this.webView, 1);
    if ((this.sendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) || (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL) || (this.sendType == ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL)) {
      ((LinearLayout)localObject).setOnClickListener(new QMRawComposeView.10(this));
    }
  }
  
  private void scrollOnAddMediaFileToContent(int paramInt1, int paramInt2)
  {
    this.contentET.postDelayed(new QMRawComposeView.13(this), 300L);
    if (paramInt1 > this.contentETScrollCursor)
    {
      this.contentETScrollCursor = paramInt1;
      this.scrollImageHeight = paramInt2;
    }
  }
  
  private void scrollOnKeyboardShown()
  {
    String str3 = getContentET().getText().toString();
    String str1 = null;
    if (this.mDefaultSenderAccount != null) {
      str1 = QMSettingManager.sharedInstance().getAccountSignature(this.mDefaultSenderAccount.getId());
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    if (!str3.trim().equalsIgnoreCase(str2)) {
      adjustEditTextCursor();
    }
  }
  
  public void OnClickReceiverTextView()
  {
    if (this.callback != null) {
      this.callback.OnClickReceiverTextView();
    }
  }
  
  public void aaddAttachImgAtBegenning(String paramString1, String paramString2) {}
  
  public void addAttachImg(String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    if (StringUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      if ((!StringUtils.isEmpty(paramString1)) && (paramString1.startsWith("http"))) {}
      for (;;)
      {
        int i = this.contentET.getSelectionStart();
        int j = this.contentET.getSelectionEnd();
        paramString2 = "image:" + paramString1 + ";";
        int k = paramString2.length();
        paramString1 = paramString2;
        if (i > 0)
        {
          paramString1 = paramString2;
          if (i <= localSpannableStringBuilder.length()) {
            paramString1 = paramString2;
          }
        }
        try
        {
          if (!localSpannableStringBuilder.subSequence(i - 1, i).toString().equals("\n")) {
            paramString1 = "\n" + paramString2;
          }
          if (i == j) {
            if ((i >= 0) && (i < localSpannableStringBuilder.length()))
            {
              localSpannableStringBuilder.insert(i, paramString1);
              if (paramString1.length() > k) {}
              paramString1.length();
              return;
              paramString1 = "file://localhost" + paramString1;
            }
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            QMLog.log(6, "QMComposeView", "subSequence error!!!");
            paramString1 = paramString2;
            continue;
            if (i >= localSpannableStringBuilder.length()) {
              localSpannableStringBuilder.append(paramString1);
            }
          }
          localSpannableStringBuilder.replace(i, j, paramString1);
          if (paramString1.length() > k) {}
          return;
        }
      }
      paramString1 = paramString2;
    }
  }
  
  public void addAttachImg(String paramString1, String paramString2, int paramInt)
  {
    setImgSrcAccountId(paramString1, paramInt);
    addAttachImg(paramString1, paramString2);
  }
  
  public void addAudioSpan(String paramString1, long paramLong, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    paramString2 = "file://localhost" + paramString2;
    int i = this.contentET.getSelectionStart();
    int j = this.contentET.getSelectionEnd();
    if (i == j)
    {
      String str = "audio:name=" + paramString1 + ",size=" + paramLong + ",src=" + paramString2 + ";\n";
      j = str.length();
      paramString1 = "";
      if (i > 0) {
        paramString1 = localSpannableStringBuilder.subSequence(i - 1, i).toString();
      }
      paramString2 = str;
      if (i > 0)
      {
        paramString2 = str;
        if (!paramString1.equals("\n")) {
          paramString2 = "\n" + str;
        }
      }
      localSpannableStringBuilder.insert(i, paramString2);
      if (j < paramString2.length()) {}
      paramString2.length();
    }
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
      smoothScrollTo(0, i);
    }
    return i;
  }
  
  public void audioPlayComplete(QMAudioSpan paramQMAudioSpan)
  {
    paramQMAudioSpan.setPlayState(false);
    this.contentET.invalidate();
  }
  
  public void autoScrollHeader(View paramView, int paramInt)
  {
    int j = paramView.getTop();
    if (paramView != this.header.getSubject()) {}
    for (int i = paramView.getHeight();; i = 0)
    {
      int k = getScrollY();
      int m = j + i - k;
      i = k;
      if (m > paramInt) {
        i = k + (m - paramInt);
      }
      paramInt = i;
      if (i < j) {
        paramInt = j;
      }
      setVerticalScrollBarEnabled(false);
      smoothScrollTo(0, paramInt);
      return;
    }
  }
  
  public void autoScrollToTop()
  {
    smoothScrollTo(0, 0);
  }
  
  public void autoSrollContent(int paramInt) {}
  
  public void bindOnLongClickListener(ComposeMailActivity.LongClickListener paramLongClickListener)
  {
    this.header.bindLongClickListener(paramLongClickListener);
  }
  
  public void bindOnMoveListener(ComposeMailActivity.OnMoveListener paramOnMoveListener)
  {
    this.header.bindMoveListener(paramOnMoveListener);
  }
  
  public void blurEditerFocus() {}
  
  public void changeDefaultSenderAccount(Account paramAccount)
  {
    if ((this.mDefaultSenderAccount != null) && (this.mDefaultSenderAccount.getId() != paramAccount.getId())) {
      changeAccountSignature(paramAccount);
    }
    this.mDefaultSenderAccount = paramAccount;
    this.header.changeDefaultSenderAccount(paramAccount);
  }
  
  public void changeEditOriginContentMode(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      str = paramString;
      if (this.originContent != null) {
        str = this.originContent;
      }
    }
    this.converter = new HtmlToSpannedConverter("<br/>" + str);
    paramString = this.converter.looseConvert();
    this.contentET.append(paramString);
    this.contentET.postDelayed(new QMRawComposeView.11(this), 500L);
  }
  
  public void clearFocusCursor()
  {
    this.contentET.clearFocus();
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL)
    {
      this.mNoteSubj.setCursorVisible(false);
      this.mNoteSubj.clearFocus();
    }
    clearFocus();
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
  
  protected int computeScrollDeltaToGetChildRectOnScreen(Rect paramRect)
  {
    return 0;
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
    this.contentET.requestFocus();
  }
  
  public void focusAtEditor() {}
  
  public int getAccountIdBySrc(String paramString)
  {
    return ((Integer)this.imgSrcAndAccountIdHashMap.get(paramString)).intValue();
  }
  
  public int getAddrNoFocusHeight()
  {
    int i = this.header.getAddrMinHeight();
    if (this.header.hasCCorBCC()) {
      return i + (this.header.getAddrMinHeight() * 2 + this.header.getSenderMinHeight());
    }
    return i + this.header.getSenderMinHeight();
  }
  
  public ArrayList<Object> getBccContactList()
  {
    return this.header.getBccContactList();
  }
  
  public ArrayList<Object> getCCContactList()
  {
    return this.header.getCCContactList();
  }
  
  public ComposeViewCallback getCallback()
  {
    return this.callback;
  }
  
  public EditText getContentET()
  {
    return this.contentET;
  }
  
  public String getContentText(boolean paramBoolean)
  {
    Object localObject1 = "";
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject2 = SpannedToHtmlConverter.toHtml(new SpannableStringBuilder(this.contentET.getText()));
        localObject1 = localObject2;
        localObject2 = filterContentByBusiness((String)localObject2);
        localObject1 = localObject2;
        if (getOriginContent().trim().length() <= 0) {
          break label128;
        }
        localObject1 = localObject2;
        localObject2 = (String)localObject2 + "<br/>" + getOriginContent();
        localObject1 = localObject2;
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        Object localObject2;
        QMLog.log(6, "QMComposeView", localException1.getMessage());
        return localObject1;
      }
      try
      {
        if (((String)localObject1).equals("")) {
          localObject2 = "<div>&nbsp;</div>";
        }
        return localObject2;
      }
      catch (Exception localException2)
      {
        continue;
      }
      localObject2 = this.contentET.getText().toString();
      return localObject2;
      label128:
      localObject1 = localException2;
    }
  }
  
  public void getContentTextSynchronously(QMUIRichEditor.UpdateInnerHtmlCallback paramUpdateInnerHtmlCallback)
  {
    paramUpdateInnerHtmlCallback.success();
  }
  
  public int getCursorYinEditText(int paramInt)
  {
    Layout localLayout = this.contentET.getLayout();
    paramInt = localLayout.getLineForOffset(paramInt);
    int i = localLayout.getLineBaseline(paramInt);
    return localLayout.getLineAscent(paramInt) + i;
  }
  
  public View getFirstFocusView()
  {
    View localView = this.header.getFirstFocusView();
    Object localObject = localView;
    if (localView == null)
    {
      if (this.contentET.isFocusable()) {
        localObject = this.contentET;
      }
    }
    else {
      return localObject;
    }
    return null;
  }
  
  public QMComposeHeader getHeader()
  {
    return this.header;
  }
  
  public int getHeaderHeight()
  {
    int i = 0;
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) {
      i = getAddrNoFocusHeight() + this.header.getSubjectMinHeight();
    }
    do
    {
      return i;
      if (this.sendType == ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL) {
        return this.header.getHeight();
      }
    } while (this.sendType != ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL);
    return this.mNoteHeader.getHeight();
  }
  
  public String getNoteCatalogString()
  {
    return this.mNoteCat.getText().toString();
  }
  
  public TextView getNoteDate()
  {
    return this.mNoteDate;
  }
  
  public String getNoteDateString()
  {
    return this.mNoteDate.getText().toString();
  }
  
  public String getNoteSubjString()
  {
    return this.mNoteSubj.getText().toString();
  }
  
  public int getOriViewHeight()
  {
    return this.oriViewHeight;
  }
  
  public String getOriginContent()
  {
    return this.originContent;
  }
  
  public int getRequestAccountId()
  {
    return this.mRequestAccountId;
  }
  
  public String getSignTemplate()
  {
    return getContentTemplate().replace("$newContentNode$", "");
  }
  
  public ArrayList<Object> getToContactList()
  {
    return this.header.getToContactList();
  }
  
  public int getVKBHeight()
  {
    return this.oriViewHeight - getHeight();
  }
  
  public int getVisibleHeight()
  {
    return this.oriViewHeight - this.keyboardHeight;
  }
  
  public WebView getWebView()
  {
    return this.webView;
  }
  
  public void handleSenderButton(QMComposeHeader paramQMComposeHeader)
  {
    if (this.callback != null) {
      this.callback.handleSenderButton(this, paramQMComposeHeader);
    }
  }
  
  public boolean hasFocusCursor()
  {
    boolean bool = false;
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL) {
      if ((this.contentET.isFocused()) || (this.mNoteSubj.isFocused())) {
        bool = true;
      }
    }
    while ((!this.contentET.isFocused()) && (!this.header.hasFocusCursor())) {
      return bool;
    }
    return true;
  }
  
  public void hideContentLoading()
  {
    this.contentLoading.setVisibility(8);
  }
  
  public void hideNoteHeader()
  {
    this.mNoteHeader.setVisibility(8);
  }
  
  public void hideformatToolbar(boolean paramBoolean) {}
  
  public void initComposeNoteHeader()
  {
    this.mNoteHeader = findViewById(2131365181);
    this.mNoteDate = ((TextView)findViewById(2131372490));
    this.mNoteCat = ((TextView)findViewById(2131372487));
    this.mNoteSubj = ((EditText)findViewById(2131365183));
    this.mNoteSubj.setVisibility(0);
    findViewById(2131376660).setVisibility(8);
    this.mNoteSubj.setOnFocusChangeListener(new QMRawComposeView.1(this));
    this.mNoteSubj.addTextChangedListener(new QMRawComposeView.2(this));
    this.mNoteSubj.setOnTouchListener(new QMRawComposeView.3(this));
  }
  
  public void initView(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    this.scrollable = true;
    this.contentETCursor = 0;
    this.contentETScrollCursor = 0;
    paramQMSendType = (WindowManager)QMApplicationContext.sharedInstance().getSystemService("window");
    this.screenHeight = paramQMSendType.getDefaultDisplay().getHeight();
    this.screenWidth = paramQMSendType.getDefaultDisplay().getWidth();
    initComposeContent();
    initComposeHeader();
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
  
  public void layoutComposeNote()
  {
    this.header.layoutComposeNote();
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
  }
  
  public void onPasteMediaFile(int paramInt1, int paramInt2)
  {
    scrollOnAddMediaFileToContent(paramInt1, paramInt2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.scrollable)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    smoothScrollTo(0, 0);
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
        break label66;
      }
      this.isKBShown = true;
      this.keyboardHeight = paramInt1;
      scrollOnKeyboardShown();
    }
    for (;;)
    {
      this.callback.sizeDidChange(this, paramInt1);
      return;
      label66:
      this.isKBShown = false;
    }
  }
  
  public void release()
  {
    this.mContext = null;
    if (this.webView != null)
    {
      ((LinearLayout)findViewById(2131365152)).removeAllViews();
      this.webView.getSettings().setJavaScriptEnabled(false);
      this.webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.webView.setWebViewClient(null);
      this.webView.setOnClickListener(null);
      this.webView.setOnLongClickListener(null);
      this.webView.setOnTouchListener(null);
      this.webView.setOnFocusChangeListener(null);
      this.webView.removeAllViews();
      this.webView.destroy();
      this.webView = null;
    }
  }
  
  public void releaseContentImg()
  {
    Editable localEditable = this.contentET.getText();
    Threads.runInBackground(new QMRawComposeView.12(this, (ImageSpan[])localEditable.getSpans(0, localEditable.length(), ImageSpan.class)));
  }
  
  public void replaceInlineImageSrc(String paramString1, String paramString2)
  {
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)this.contentET.getText();
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), ImageSpan.class);
    int j = arrayOfImageSpan.length;
    while (i < j)
    {
      ImageSpan localImageSpan = arrayOfImageSpan[i];
      int k = localSpannableStringBuilder.getSpanStart(localImageSpan);
      int m = localSpannableStringBuilder.getSpanEnd(localImageSpan);
      if (localImageSpan.getSource().contains(paramString1))
      {
        localSpannableStringBuilder.setSpan(new ImageSpan(localImageSpan.getDrawable(), "file://localhost" + paramString2, 1), k, m, 33);
        localSpannableStringBuilder.removeSpan(localImageSpan);
      }
      i += 1;
    }
  }
  
  public void restoreFocusCursor()
  {
    if (this.focusView.equals("content"))
    {
      this.contentET.requestFocus();
      this.contentET.setSelection(this.contentETCursor);
    }
    while (!this.focusView.equals("header")) {
      return;
    }
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL)
    {
      this.mNoteSubj.setCursorVisible(true);
      this.mNoteSubj.requestFocus();
      return;
    }
    this.header.restoreFocusCursor();
  }
  
  public void saveFocusCursor()
  {
    if (this.contentET.isFocused())
    {
      this.focusView = "content";
      this.contentETCursor = this.contentET.getSelectionStart();
    }
    while ((!this.header.hasFocusCursor()) && ((this.sendType != ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL) || (!this.mNoteSubj.isFocused()))) {
      return;
    }
    this.focusView = "header";
    this.header.saveFocusCursor();
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
      paramInt = paramComposeAddrView.getPaddingTop();
      int k = paramComposeAddrView.getPaddingBottom() + paramInt;
      int j = paramComposeAddrView.getAutoCompleteTextViewHeight() + k;
      i = paramComposeAddrView.getHeight() - j + 4;
      paramInt = i;
      if (paramComposeAddrView == this.header.getReceiver())
      {
        paramInt = i;
        if (paramComposeAddrView.getHeight() - k < paramComposeAddrView.getAutoCompleteTextViewHeight() * 2) {
          paramInt = 0;
        }
      }
      if (paramComposeAddrView.getHeight() <= j) {
        paramInt = 0;
      }
      smoothScrollTo(0, paramInt + paramComposeAddrView.getTop());
      return;
      if ((paramInt == 0) && (this.hasRecordPosition))
      {
        scrollBack();
        return;
      }
    } while (paramInt != 0);
  }
  
  public void scrollBack()
  {
    if (this.hasRecordPosition)
    {
      postDelayed(new QMRawComposeView.14(this), 100L);
      this.hasRecordPosition = false;
    }
  }
  
  public void scrollClickChange(View paramView, boolean paramBoolean)
  {
    int j;
    int i;
    int m;
    int k;
    if (!(paramView instanceof QMTextField))
    {
      j = 1;
      i = paramView.getTop();
      if (j == 0) {
        break label211;
      }
      m = ((LinearLayout)findViewById(2131365152)).getTop();
      k = getCursorYinEditText(this.contentET.getSelectionStart());
      i = m + i + (this.contentET.getPaddingTop() + k);
    }
    for (;;)
    {
      m = i - getScrollY();
      i = getVisibleHeight() - getEditTextLineHeight();
      int n = i;
      if (j != 0) {
        n = i - getEditTextLineHeight();
      }
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = i;
      if (!paramBoolean)
      {
        m = i;
        if (i > n) {
          m = n - getEditTextLineHeight();
        }
      }
      i = getHeaderHeight();
      if (j != 0) {
        i = this.contentET.getPaddingTop() + k + i;
      }
      for (;;)
      {
        j = i - m;
        i = j;
        if (j < 0) {
          i = 0;
        }
        scrollTo(0, i);
        return;
        j = 0;
        break;
        if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NORMAL_MAIL) {
          i -= this.header.getSubjectMinHeight();
        }
      }
      label211:
      k = 0;
    }
  }
  
  public void scrollContentCursor(int paramInt, boolean paramBoolean)
  {
    int i = getVisibleHeight() - getEditTextLineHeight() * 2;
    paramInt = getHeaderHeight() + paramInt + this.contentET.getPaddingTop();
    int j = getScrollY();
    if (paramInt >= j + i - 2) {
      smoothScrollTo(0, paramInt + getEditTextLineHeight() - i);
    }
    while (paramInt > j) {
      return;
    }
    smoothScrollTo(0, paramInt);
  }
  
  public void scrollToTop() {}
  
  public void scrollToView(View paramView)
  {
    int i = paramView.getTop();
    if (paramView == this.contentET) {
      i = this.header.getTop() + this.header.getHeight();
    }
    setVerticalScrollBarEnabled(false);
    smoothScrollTo(0, i);
  }
  
  public void setAttachBoardShow(boolean paramBoolean) {}
  
  public void setCallback(ComposeViewCallback paramComposeViewCallback)
  {
    this.callback = paramComposeViewCallback;
  }
  
  public void setContentET(QMEditText paramQMEditText)
  {
    this.contentET = paramQMEditText;
  }
  
  public void setContentText(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mbIsSetText = true;
    if (paramBoolean)
    {
      this.converter = new HtmlToSpannedConverter(str);
      paramString = this.converter.looseConvert();
      this.contentET.setText(paramString);
      return;
    }
    this.contentET.setText(str);
  }
  
  public void setDefaultSenderAccount(Account paramAccount)
  {
    this.mDefaultSenderAccount = paramAccount;
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
  
  public void setKBShown(boolean paramBoolean)
  {
    this.isKBShown = paramBoolean;
  }
  
  public void setNoteCatalogOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mNoteCat.setOnClickListener(paramOnClickListener);
  }
  
  public void setNoteCatalogString(String paramString)
  {
    this.mNoteCat.setText(paramString);
  }
  
  public void setNoteDateString(String paramString)
  {
    this.mNoteDate.setText(paramString);
  }
  
  public void setNoteSubjString(String paramString)
  {
    this.mNoteSubj.setText(paramString);
  }
  
  public void setOriginCardContent(String paramString)
  {
    this.originContent = paramString;
    this.webView.setVisibility(0);
    this.webView.loadDataWithBaseURL("file:///read?t=mail", paramString, "text/html", "UTF-8", null);
  }
  
  public void setOriginContent(String paramString, float paramFloat1, float paramFloat2)
  {
    this.originContent = paramString;
    if ((paramString == null) || ("".equals(paramString)))
    {
      this.webView.setVisibility(8);
      return;
    }
    this.webView.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "compose_original_head"));
    localStringBuilder.append(paramString);
    localStringBuilder.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "compose_original_tail"));
    this.webView.loadDataWithBaseURL("file:///read?t=mail", localStringBuilder.toString(), "text/html", "UTF-8", null);
  }
  
  public void setOriginContentFromPopularize(String paramString)
  {
    this.originContent = paramString;
    if ((paramString == null) || ("".equals(paramString)))
    {
      this.webView.setVisibility(8);
      return;
    }
    this.webView.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "compose_original_head"));
    localStringBuilder.append(paramString);
    localStringBuilder.append(Template.getTemplateSectionWithName(QMApplicationContext.sharedInstance(), Template.CONTENT_HTML_TEMPLATE, "compose_original_tail"));
    this.webView.loadData(localStringBuilder.toString(), "text/html", "UTF-8");
  }
  
  public void setOriginContentWithQuickReply(String paramString1, String paramString2) {}
  
  public void setRequestAccountId(int paramInt)
  {
    this.mRequestAccountId = paramInt;
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
  
  public void showNoteHeader()
  {
    this.mNoteHeader.setVisibility(0);
  }
  
  public void showformatToolbar(boolean paramBoolean) {}
  
  public void updateContactArray(List<MailContact> paramList1, List<MailContact> paramList2)
  {
    this.header.updateContactArray(paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView
 * JD-Core Version:    0.7.0.1
 */