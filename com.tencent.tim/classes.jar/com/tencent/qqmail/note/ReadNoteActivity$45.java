package com.tencent.qqmail.note;

import android.webkit.JavascriptInterface;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewJavascriptInterface;

class ReadNoteActivity$45
  extends QMScaleWebViewController.QMScaleWebViewJavascriptInterface
{
  ReadNoteActivity$45(ReadNoteActivity paramReadNoteActivity, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @JavascriptInterface
  public void hideLoadingTip()
  {
    ReadNoteActivity.access$1700(this.this$0);
  }
  
  @JavascriptInterface
  public void isContainAudio(boolean paramBoolean)
  {
    ReadNoteActivity.access$4100(this.this$0, new ReadNoteActivity.45.1(this, paramBoolean));
  }
  
  @JavascriptInterface
  public void playAudio(String paramString1, String paramString2, String paramString3)
  {
    this.this$0.playAudio(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.45
 * JD-Core Version:    0.7.0.1
 */