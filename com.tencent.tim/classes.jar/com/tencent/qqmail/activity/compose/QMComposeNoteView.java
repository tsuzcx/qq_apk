package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.OnContentEmptyListener;
import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.richeditor.QMAudioSpan;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

public class QMComposeNoteView
  extends FrameLayout
{
  private static final String TAG = "QMComposeNoteView";
  private boolean attachBoardShow = false;
  private ComposeMailViewCallback callback;
  private QMUIRichEditor editor;
  private boolean editorFocused = true;
  private Runnable focusRunnable = new QMComposeNoteView.3(this);
  private ComposeToolBar formatToolbar;
  private int headerHeight = -1;
  private boolean isKBShown = false;
  private int keyboardHeight = -1;
  private TextView mNoteCat;
  private TextView mNoteDate;
  private View mNoteHeader;
  private EditText mNoteSubj;
  private int oriViewHeight = 0;
  private String originContent = "";
  private ComposeCommUI.QMSendType sendType;
  
  public QMComposeNoteView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMComposeNoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMComposeNoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void initComposeNoteHeader()
  {
    this.mNoteHeader = findViewById(2131365181);
    this.mNoteDate = ((TextView)findViewById(2131372490));
    this.mNoteCat = ((TextView)findViewById(2131372487));
    this.mNoteSubj = ((EditText)findViewById(2131365183));
    this.mNoteSubj.setVisibility(0);
    findViewById(2131376660).setVisibility(8);
    this.mNoteSubj.setOnFocusChangeListener(new QMComposeNoteView.4(this));
    this.mNoteSubj.addTextChangedListener(new QMComposeNoteView.5(this));
  }
  
  private void initFormatToolbar()
  {
    this.formatToolbar = ((ComposeToolBar)findViewById(2131365154));
    this.editor.setOnDecorationChangeListener(this.formatToolbar);
    this.formatToolbar.setActionListener(new QMComposeNoteView.6(this));
  }
  
  private void initWebView()
  {
    this.editor = new QMUIRichEditor(getContext());
    this.editor.getSettings().setJavaScriptEnabled(true);
    this.editor.getSettings().setAppCacheEnabled(true);
    this.editor.getSettings().setDatabaseEnabled(true);
    this.editor.getSettings().setDomStorageEnabled(true);
    CookieManager.getInstance().removeAllCookie();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131365152);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.addView(this.editor, 0, localLayoutParams);
    this.editor.setOnAudioClickListener(new QMComposeNoteView.7(this));
  }
  
  private void initWebViewTitle()
  {
    this.editor.setEmbeddedTitleBarCompat(this.mNoteHeader);
    if (!VersionUtils.hasKitKat())
    {
      this.editor.setHeadHeight(0);
      return;
    }
    this.mNoteHeader.addOnLayoutChangeListener(new QMComposeNoteView.8(this));
  }
  
  private boolean isAttachBoardShow()
  {
    return this.attachBoardShow;
  }
  
  private void updateEditorHeaderHeight(@NonNull View paramView)
  {
    int i = (int)(paramView.getHeight() / this.editor.getScale());
    QMLog.log(4, "QMComposeNoteView", "header height " + paramView.getHeight() + " editor scale = " + this.editor.getScale());
    this.editor.setHeadHeight(i);
  }
  
  public void addAttachImg(String paramString1, String paramString2)
  {
    if (StringUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString1 = "file://localhost" + paramString1;
      this.editor.insertImage(paramString1, "");
      return;
      paramString1 = paramString2;
    }
  }
  
  public void addAudioSpan(String paramString1, long paramLong, String paramString2)
  {
    Log.i("QMComposeNoteView", "name = " + paramString1 + "size = " + paramLong + " filepath = " + paramString2);
    paramString2 = "file://localhost" + paramString2;
    this.editor.insertHtml(AudioUtils.generateImgHtml(paramString1, StringExtention.getHumanReadableSizeString(paramLong), paramString2));
  }
  
  public void audioPlayComplete(QMAudioSpan paramQMAudioSpan)
  {
    paramQMAudioSpan.setPlayState(false);
  }
  
  public void blurEditerFocus()
  {
    this.editor.blurFocus();
  }
  
  public void clearFocusCursor()
  {
    if (this.sendType == ComposeCommUI.QMSendType.t_SEND_NOTE_MAIL) {}
    clearFocus();
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
  
  public void focusEditor()
  {
    this.editor.focusEditor();
  }
  
  public String getContentText()
  {
    return AudioUtils.filterImgToAudio(this.editor.getHtml());
  }
  
  public void getContentTextSynchronously(QMUIRichEditor.UpdateInnerHtmlCallback paramUpdateInnerHtmlCallback)
  {
    this.editor.getHtmlSynchronously(paramUpdateInnerHtmlCallback);
  }
  
  public TextView getNoteDate()
  {
    return this.mNoteDate;
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
  
  public void hideformatToolbar(boolean paramBoolean)
  {
    if ((this.formatToolbar != null) && (this.formatToolbar.getVisibility() != 8))
    {
      if (this.callback != null) {
        this.callback.onFormatToobarChange(false);
      }
      Log.i("QMComposeNoteView", "formatToolbar.setVisibility(GONE)");
      this.formatToolbar.setVisibility(8);
      if (paramBoolean) {}
    }
    else
    {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(100L);
    localAlphaAnimation.setAnimationListener(new QMComposeNoteView.10(this));
    this.formatToolbar.startAnimation(localAlphaAnimation);
  }
  
  public void initView(ComposeCommUI.QMSendType paramQMSendType)
  {
    this.sendType = paramQMSendType;
    initComposeNoteHeader();
    initWebView();
    initWebViewTitle();
    initFormatToolbar();
    this.editor.setEditorFocusChangeListener(new QMComposeNoteView.1(this));
    this.editor.setOnInputListener(new QMComposeNoteView.2(this));
  }
  
  public boolean isKBShown()
  {
    return this.isKBShown;
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
        break label105;
      }
      this.isKBShown = true;
      this.keyboardHeight = paramInt1;
      Log.i("QMComposeNoteView", "isKBShown = " + this.isKBShown + "attachBoardShow = " + this.attachBoardShow);
      if (this.isKBShown) {
        break label113;
      }
      hideformatToolbar(false);
    }
    label105:
    label113:
    while ((this.attachBoardShow) || (this.mNoteSubj.hasFocus()))
    {
      return;
      this.isKBShown = false;
      break;
    }
    postDelayed(new QMComposeNoteView.9(this), 100L);
  }
  
  public void onToolBarClick(View paramView)
  {
    KvHelper.eventRichEditorNoteAll(new double[0]);
    com.tencent.qqmail.activity.compose.richeditor.DetailReporter.used_composenote_richstyle = true;
  }
  
  public void release()
  {
    if (this.editor != null)
    {
      ((LinearLayout)findViewById(2131365152)).removeAllViews();
      this.editor.getSettings().setJavaScriptEnabled(false);
      this.editor.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.editor.setWebViewClient(null);
      this.editor.setOnClickListener(null);
      this.editor.setOnLongClickListener(null);
      this.editor.setOnTouchListener(null);
      this.editor.setOnFocusChangeListener(null);
      this.editor.removeAllViews();
      this.editor.destroy();
      this.editor = null;
    }
  }
  
  public void setAttachBoardShow(boolean paramBoolean)
  {
    this.attachBoardShow = paramBoolean;
  }
  
  public void setCallback(ComposeMailViewCallback paramComposeMailViewCallback)
  {
    this.callback = paramComposeMailViewCallback;
  }
  
  public void setContentEmptyListener(QMUIRichEditor.OnContentEmptyListener paramOnContentEmptyListener)
  {
    this.editor.setOnContentEmptyListener(paramOnContentEmptyListener);
  }
  
  public void setContentText(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = AudioUtils.filterAudioToImg(str);
    this.editor.setHtml(paramString);
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
  
  public void setRequestAccountId(int paramInt) {}
  
  public void showNoteHeader()
  {
    this.mNoteHeader.setVisibility(0);
  }
  
  public void showformatToolbar(boolean paramBoolean)
  {
    if ((this.formatToolbar != null) && (this.formatToolbar.getVisibility() != 0))
    {
      if (this.callback != null) {
        this.callback.onFormatToobarChange(true);
      }
      Log.i("QMComposeNoteView", "formatToolbar.setVisibility(VISIBLE) ");
      this.formatToolbar.setVisibility(0);
      if (paramBoolean) {}
    }
    else
    {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    localAlphaAnimation.setAnimationListener(new QMComposeNoteView.11(this));
    this.formatToolbar.startAnimation(localAlphaAnimation);
  }
  
  public static abstract interface ComposeMailViewCallback
  {
    public abstract void contentTextChange();
    
    public abstract void onClickAudio(String paramString);
    
    public abstract void onFormatToobarChange(boolean paramBoolean);
    
    public abstract void onSubjectTextFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeNoteView
 * JD-Core Version:    0.7.0.1
 */