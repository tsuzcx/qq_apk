package com.tencent.qqmail.activity.compose.richeditor;

import Override;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.XSSTagFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.JBTitleBarWebView2;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QMUIRichEditor
  extends JBTitleBarWebView2
{
  private static final String AUDIO_SCHEME = "qmuire-audio://";
  private static final String CONTENT_SCHEME = "qmuire-content://";
  private static final String EMPTY_SCHEME = "qmuire-empty://";
  private static final String FOCUS_SCHEME = "qmuire-focus://";
  private static final String IMAGE_SCHEME = "qmuire-event://";
  private static final String INPUT_SCHEME = "qmuire-input://";
  private static final String LOG_SCHEME = "qmuire-log://";
  private static final String SETUP_HTML = "file:///android_asset/mail/qmuieditor.html";
  private static final String STATE_SCHEME = "qmuire-state://";
  private static final String TAG = "QMUIRichEditor";
  private int cardHeaderHeight = 0;
  private boolean isReady = false;
  private String mContents;
  private OnDecorationStateListener mDecorationStateListener;
  private AfterInitialLoadListener mLoadListener;
  private QMUIRichEditorLoadUrlHook mLoadUrlHook;
  private OnTextChangeListener mTextChangeListener;
  private ArrayList<QMUIRichEditorState> mTypesList = new ArrayList();
  private int mailheaderHeight = 0;
  private OnAudioClickListener onAudioClick;
  private OnContentEmptyListener onContentEmptyListener;
  private OnFocusChangeListener onFocusChangeListener;
  private OnImageClickListener onImageClick;
  private OnInputListener onInputListener;
  private UpdateInnerHtmlCallback updateInnerHtmlCallback;
  private URLRequestIntercepter urlRequestIntercepter;
  
  public QMUIRichEditor(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QMUIRichEditor(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842885);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public QMUIRichEditor(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setTextZoom(100);
    if (VersionUtils.hasHoneycomb()) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
    setWebChromeClient(new EditorWebChromeClient(null));
    setWebViewClient(new EditorWebViewClient(null));
    super.loadUrl("file:///android_asset/mail/qmuieditor.html");
    requestFocus(130);
    if (QMUIRichEditorLoadUrlHook.shouldUseHookToLoad())
    {
      this.mLoadUrlHook = new QMUIRichEditorLoadUrlHook();
      this.mLoadUrlHook.initReflection(this);
    }
  }
  
  private void checkContentEmpty(String paramString)
  {
    Log.i("QMUIRichEditor", "checkContentEmpty message = " + paramString);
    paramString = paramString.replaceFirst("qmuire-empty://", "");
    if (this.onContentEmptyListener != null)
    {
      if (!"false".equalsIgnoreCase(paramString)) {
        break label61;
      }
      this.onContentEmptyListener.empty(false);
    }
    label61:
    while (!"true".equalsIgnoreCase(paramString)) {
      return;
    }
    this.onContentEmptyListener.empty(true);
  }
  
  private void clickAudio(String paramString)
  {
    Log.i("QMUIRichEditor", "clickAudio message = " + paramString);
    paramString = paramString.replaceFirst("qmuire-audio://", "");
    if (this.onAudioClick != null) {
      this.onAudioClick.click(paramString);
    }
  }
  
  private void clickImage(String paramString)
  {
    Log.i("QMUIRichEditor", "clickImage message = " + paramString);
    paramString = paramString.replaceFirst("qmuire-event://", "");
    if (this.onImageClick != null) {
      this.onImageClick.click(paramString);
    }
  }
  
  private void contentCallback(String paramString)
  {
    this.mContents = paramString.replaceFirst("qmuire-content://", "");
    if (this.updateInnerHtmlCallback != null)
    {
      this.updateInnerHtmlCallback.success();
      this.updateInnerHtmlCallback = null;
    }
    if (this.mTextChangeListener != null) {
      this.mTextChangeListener.onTextChange(this.mContents);
    }
  }
  
  private void focusChange(String paramString)
  {
    Log.i("QMUIRichEditor", "Focus change " + paramString);
    paramString = paramString.replaceFirst("qmuire-focus://", "");
    if (this.onFocusChangeListener != null)
    {
      if (!"false".equalsIgnoreCase(paramString)) {
        break label62;
      }
      this.onFocusChangeListener.focus(false);
    }
    label62:
    while (!"true".equalsIgnoreCase(paramString)) {
      return;
    }
    this.onFocusChangeListener.focus(true);
  }
  
  private void handleJsMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.startsWith("qmuire-content://"))
    {
      contentCallback(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-state://"))
    {
      stateCallback(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-log://"))
    {
      logCallback(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-event://"))
    {
      clickImage(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-audio://"))
    {
      clickAudio(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-empty://"))
    {
      checkContentEmpty(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-focus://"))
    {
      focusChange(paramString);
      return;
    }
    if (paramString.startsWith("qmuire-input://"))
    {
      inputting(paramString);
      return;
    }
    QMLog.log(4, "QMUIRichEditor", "console: " + paramString);
  }
  
  private void inputting(String paramString)
  {
    Log.i("QMUIRichEditor", "Inputting happens " + paramString);
    if (this.onInputListener != null) {
      this.onInputListener.onInput();
    }
  }
  
  private void load(String paramString)
  {
    post(new QMUIRichEditor.2(this, paramString));
  }
  
  private void logCallback(String paramString)
  {
    paramString = paramString.replaceFirst("qmuire-log://", "");
    Log.i("QMUIRichEditor", "From JS: " + paramString);
  }
  
  private void stateCallback(String paramString)
  {
    int i = 0;
    Log.i("QMUIRichEditor", "stateCallback " + paramString);
    if (this.mDecorationStateListener == null) {
      return;
    }
    this.mTypesList.clear();
    if (TextUtils.isEmpty(paramString))
    {
      this.mDecorationStateListener.onStateChangeListener("", this.mTypesList);
      return;
    }
    String str = paramString.replaceFirst("qmuire-state://", "").toUpperCase(Locale.ENGLISH);
    String[] arrayOfString1 = TextUtils.split(str, "&");
    if (i < arrayOfString1.length) {
      if (!TextUtils.isEmpty(paramString)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      String[] arrayOfString2 = TextUtils.split(arrayOfString1[i], "=");
      if (arrayOfString2.length != 0) {
        try
        {
          QMUIRichEditorState localQMUIRichEditorState = QMUIRichEditorState.valueOf(arrayOfString2[0]);
          if (arrayOfString2.length > 1) {
            localQMUIRichEditorState.setCustomContent(arrayOfString2[1]);
          }
          for (;;)
          {
            this.mTypesList.add(localQMUIRichEditorState);
            break;
            localQMUIRichEditorState.setCustomContent(null);
          }
          this.mDecorationStateListener.onStateChangeListener(str, this.mTypesList);
          return;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void blurFocus()
  {
    exec("javascript:QMUIEditor.editor.blurfocus();");
  }
  
  public void changeImageSrc(String paramString1, String paramString2)
  {
    exec("javascript:QMUIEditor.edit.changeImgSrc('" + paramString1 + "','" + paramString2 + "');");
  }
  
  public void changeSign(String paramString)
  {
    exec("javascript:QMUIEditor.edit.changeSign('" + paramString + "');");
  }
  
  public void clearEditor()
  {
    exec("javascript:QMUIEditor.editor.clear();");
  }
  
  public void delete()
  {
    exec("javascript:QMUIEditor.edit.delete();");
  }
  
  protected void exec(String paramString)
  {
    Log.i("QMUIRichEditor", String.format("exec trigger[%s], ready[%s]", new Object[] { paramString, Boolean.valueOf(this.isReady) }));
    if (this.isReady)
    {
      load(paramString);
      return;
    }
    postDelayed(new QMUIRichEditor.1(this, paramString), 100L);
  }
  
  public void focusEditor()
  {
    requestFocus();
    exec("javascript:QMUIEditor.editor.focus();");
  }
  
  public void focusEditorAtBackupSelection()
  {
    requestFocus();
    exec("javascript:QMUIEditor.editor.focusEditorAtBackupSelection();");
  }
  
  public void focusEditorAtBegin()
  {
    exec("javascript:QMUIEditor.editor.focusEditorAtStartSelection();");
  }
  
  public String getHtml()
  {
    exec("javascript:QMUIEditor.editor.getHtml();");
    return this.mContents;
  }
  
  public void getHtmlSynchronously(UpdateInnerHtmlCallback paramUpdateInnerHtmlCallback)
  {
    QMLog.log(4, "QMUIRichEditor", "getHtmlSynchronously " + paramUpdateInnerHtmlCallback);
    this.updateInnerHtmlCallback = paramUpdateInnerHtmlCallback;
    exec("javascript:QMUIEditor.editor.getHtml();");
  }
  
  public void insertHtml(String paramString)
  {
    paramString = removeQuotes(paramString);
    exec("javascript:QMUIEditor.edit.insertHtml('" + paramString + "')");
  }
  
  public void insertImage(String paramString1, String paramString2)
  {
    insertImage(paramString1, paramString2, null, null);
  }
  
  public void insertImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      Log.d("QMUIRichEditor", "url can not be empty");
      return;
    }
    focusEditorAtBackupSelection();
    StringBuilder localStringBuilder = new StringBuilder("javascript:QMUIEditor.edit.insertImage({src:'");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("',");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("alt:'");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("',");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("width:'");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("', ");
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      localStringBuilder.append("height:'");
      localStringBuilder.append(paramString4);
      localStringBuilder.append("'");
    }
    localStringBuilder.append("});");
    exec(localStringBuilder.toString());
  }
  
  public void insertImageAtBegin(String paramString1, String paramString2)
  {
    Log.i("QMUIRichEditor", "insertImageAtBeginning " + paramString1);
    focusEditorAtBegin();
    if (TextUtils.isEmpty(paramString1))
    {
      Log.d("QMUIRichEditor", "url can not be empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("javascript:QMUIEditor.edit.insertImage({src:'");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("',");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("alt:'");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("'");
    }
    localStringBuilder.append("});");
    exec(localStringBuilder.toString());
    focusEditorAtBegin();
    insertHtml("<div><br></div><div><br></div>");
    focusEditorAtBegin();
  }
  
  public void insertText(String paramString)
  {
    exec("javascript:QMUIEditor.edit.insertText('" + paramString + "');");
  }
  
  public void loadUrl(String paramString)
  {
    if (this.mLoadUrlHook != null)
    {
      this.mLoadUrlHook.loadUrl(this, paramString);
      return;
    }
    super.loadUrl(paramString);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (super.onCreateInputConnection(paramEditorInfo) == null) {
      return null;
    }
    if ((VersionUtils.hasKitKat()) && (!VersionUtils.hasLolipop())) {
      return new CustomWebviewInputConnection(super.onCreateInputConnection(paramEditorInfo), false);
    }
    return super.onCreateInputConnection(paramEditorInfo);
  }
  
  protected String removeQuotes(String paramString)
  {
    return paramString.replaceAll("'", "\\\\'").replaceAll("\"", "\\\\\"").replaceAll("\r", "\\r").replaceAll("\n", "");
  }
  
  public void scrollToTop()
  {
    exec("javascript:window.scrollTo(0, 0);");
  }
  
  public void setBigFontSize()
  {
    exec("javascript:QMUIEditor.edit.setBigFontSize();");
  }
  
  public void setBlockquote()
  {
    exec("javascript:QMUIEditor.edit.setBlockquote();");
  }
  
  public void setBold()
  {
    exec("javascript:QMUIEditor.edit.setBold();");
  }
  
  public void setCardHeadHeight(int paramInt)
  {
    exec("javascript:CR.setHeadHeight(" + paramInt + ")");
    this.cardHeaderHeight = paramInt;
  }
  
  public void setEditorFocusChangeListener(OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.onFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setFontStyle(int paramInt) {}
  
  public void setHeadHeight(int paramInt)
  {
    exec("javascript:QMUIEditor.editor.setHeaderHeight(" + paramInt + ")");
    this.mailheaderHeight = paramInt;
  }
  
  public void setHtml(String paramString)
  {
    clearCache(false);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = XSSTagFilter.removeDataTextHtml(str);
    try
    {
      exec("javascript:QMUIEditor.editor.setHtml('" + URLEncoder.encode(paramString, "UTF-8") + "');");
      label55:
      this.mContents = paramString;
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label55;
    }
  }
  
  public void setJustifyCenter()
  {
    exec("javascript:QMUIEditor.edit.setJustifyCenter();");
  }
  
  public void setLargeFontSize()
  {
    exec("javascript:QMUIEditor.edit.setLargeFontSize();");
  }
  
  public void setLoadListener(AfterInitialLoadListener paramAfterInitialLoadListener)
  {
    this.mLoadListener = paramAfterInitialLoadListener;
  }
  
  public void setNormalFontSize()
  {
    exec("javascript:QMUIEditor.edit.setNormalFontSize();");
  }
  
  public void setOnAudioClickListener(OnAudioClickListener paramOnAudioClickListener)
  {
    this.onAudioClick = paramOnAudioClickListener;
  }
  
  public void setOnContentEmptyListener(OnContentEmptyListener paramOnContentEmptyListener)
  {
    this.onContentEmptyListener = paramOnContentEmptyListener;
  }
  
  public void setOnDecorationChangeListener(OnDecorationStateListener paramOnDecorationStateListener)
  {
    this.mDecorationStateListener = paramOnDecorationStateListener;
  }
  
  public void setOnImageClickListener(OnImageClickListener paramOnImageClickListener)
  {
    this.onImageClick = paramOnImageClickListener;
  }
  
  public void setOnInputListener(OnInputListener paramOnInputListener)
  {
    this.onInputListener = paramOnInputListener;
  }
  
  public void setPlaceholder(String paramString)
  {
    exec("javascript:QMUIEditor.editor.setPlaceholder('" + paramString + "');");
  }
  
  public void setSmallFontSize()
  {
    exec("javascript:QMUIEditor.edit.setSmallFontSize();");
  }
  
  public void setTextColor(String paramString)
  {
    exec("javascript:QMUIEditor.edit.setTextColor('" + paramString + "');");
  }
  
  public void setTitle(String paramString)
  {
    exec("javascript:QMUIEditor.edit.setTitle('" + paramString + "');");
  }
  
  public void setUnorderedList()
  {
    exec("javascript:QMUIEditor.edit.setUnorderedList();");
  }
  
  public void setUrlRequestIntercepter(URLRequestIntercepter paramURLRequestIntercepter)
  {
    this.urlRequestIntercepter = paramURLRequestIntercepter;
  }
  
  public void strikeThrough()
  {
    exec("javascript:QMUIEditor.edit.strikeThrough();");
  }
  
  public static abstract interface AfterInitialLoadListener
  {
    public abstract void onAfterInitialLoad(boolean paramBoolean);
  }
  
  class CustomWebviewInputConnection
    extends InputConnectionWrapper
  {
    CustomWebviewInputConnection(InputConnection paramInputConnection, boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent.getKeyCode() == 67)
      {
        if (paramKeyEvent.getAction() == 0) {
          QMUIRichEditor.this.post(new QMUIRichEditor.CustomWebviewInputConnection.1(this));
        }
        return true;
      }
      return super.sendKeyEvent(paramKeyEvent);
    }
  }
  
  class EditorWebChromeClient
    extends WebChromeClient
  {
    private EditorWebChromeClient() {}
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      QMUIRichEditor.this.handleJsMessage(paramConsoleMessage.message());
      return true;
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
      if (paramInt == 100)
      {
        QMUIRichEditor.access$302(QMUIRichEditor.this, true);
        if (QMUIRichEditor.this.cardHeaderHeight > 0) {
          QMUIRichEditor.this.setCardHeadHeight(QMUIRichEditor.this.cardHeaderHeight);
        }
      }
    }
  }
  
  class EditorWebViewClient
    extends WebViewClient
  {
    private EditorWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      QMUIRichEditor.access$302(QMUIRichEditor.this, paramString.equalsIgnoreCase("file:///android_asset/mail/qmuieditor.html"));
      if (QMUIRichEditor.this.mLoadListener != null) {
        QMUIRichEditor.this.mLoadListener.onAfterInitialLoad(QMUIRichEditor.this.isReady);
      }
      if (QMUIRichEditor.this.mailheaderHeight > 0) {
        QMUIRichEditor.this.setHeadHeight(QMUIRichEditor.this.mailheaderHeight);
      }
    }
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      if (QMUIRichEditor.this.urlRequestIntercepter != null) {
        return QMUIRichEditor.this.urlRequestIntercepter.intercept(paramString);
      }
      return super.shouldInterceptRequest(paramWebView, paramString);
    }
  }
  
  public static abstract interface OnAudioClickListener
  {
    public abstract void click(String paramString);
  }
  
  public static abstract interface OnContentEmptyListener
  {
    public abstract void empty(boolean paramBoolean);
  }
  
  public static abstract interface OnDecorationStateListener
  {
    public abstract void onStateChangeListener(String paramString, @NonNull List<QMUIRichEditorState> paramList);
  }
  
  public static abstract interface OnFocusChangeListener
  {
    public abstract void focus(boolean paramBoolean);
  }
  
  public static abstract interface OnImageClickListener
  {
    public abstract void click(String paramString);
  }
  
  public static abstract interface OnInputListener
  {
    public abstract void onInput();
  }
  
  public static abstract interface OnTextChangeListener
  {
    public abstract void onTextChange(String paramString);
  }
  
  public static abstract interface URLRequestIntercepter
  {
    public abstract WebResourceResponse intercept(String paramString);
  }
  
  public static abstract interface UpdateInnerHtmlCallback
  {
    public abstract void success();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor
 * JD-Core Version:    0.7.0.1
 */