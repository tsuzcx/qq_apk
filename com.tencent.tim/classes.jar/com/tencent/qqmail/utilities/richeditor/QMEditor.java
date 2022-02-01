package com.tencent.qqmail.utilities.richeditor;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import java.io.File;
import java.util.Date;

public class QMEditor
  extends LinearLayout
{
  private Button editRichTextBtn;
  private EditText editor;
  private String originContent;
  private TextView originLabel;
  private WebView webView;
  private LinearLayout webviewLayout;
  
  public QMEditor(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMEditor(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131559278, this, true);
    init();
  }
  
  private void init()
  {
    this.editRichTextBtn = ((Button)findViewById(2131366202));
    this.editor = ((EditText)findViewById(2131374706));
    this.webView = ((WebView)findViewById(2131372733));
    this.originLabel = ((TextView)findViewById(2131372732));
    this.webviewLayout = ((LinearLayout)findViewById(2131382173));
    initEvent();
    initWebView();
    if (Build.VERSION.SDK_INT >= 11) {
      this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  private void initEvent()
  {
    this.editor.addTextChangedListener(new QMEditor.3(this));
    this.editRichTextBtn.setOnClickListener(new QMEditor.4(this));
  }
  
  private void initWebView()
  {
    WebSettings localWebSettings = this.webView.getSettings();
    localWebSettings.setAppCachePath("/data/data/com.example.richeditor/cache");
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(2);
    this.webView.setWebViewClient(new QMEditor.1(this));
  }
  
  private void organizeHeader()
  {
    SpannableString localSpannableString = new SpannableString("发件人: \"无名氏 :) \"<luciouslu@vip.qq.com>;\n发送时间: 2013年2月22日(星期五) 晚上8:51\n收件人: \"wapmail\"<wapmail@rdgz.org>;\n抄送: \"维他命x\"<htm@qq.com>;\n主题: mailapp v1.1版本计划");
    localSpannableString.setSpan(new BackgroundColorSpan(-3355444), 0, localSpannableString.length(), 33);
    this.editor.append(localSpannableString);
  }
  
  public void initialize(String paramString, File paramFile)
  {
    this.originContent = paramString;
    this.originLabel.requestFocus();
    this.webView.loadData(this.originContent, "text/html", "utf-8");
  }
  
  public void loadImage(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getText();
    Object[] arrayOfObject = localEditable.getSpans(0, localEditable.length(), ImageSpan.class);
    int i = 0;
    while (i < arrayOfObject.length)
    {
      ImageSpan localImageSpan = (ImageSpan)arrayOfObject[i];
      String str = localImageSpan.getSource();
      int j = localEditable.getSpanStart(localImageSpan);
      int k = localEditable.getSpanEnd(localImageSpan);
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setUrl(str);
      localDownloadInfo.setImageDownloadListener(new QMEditor.2(this, paramEditText, localImageSpan, str, j, k));
      ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
      i += 1;
    }
  }
  
  public String test()
  {
    return new Date().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditor
 * JD-Core Version:    0.7.0.1
 */