package com.tencent.qqmail.view;

import android.os.CountDownTimer;
import android.widget.ProgressBar;

class GmailAuthWebView$1
  extends CountDownTimer
{
  GmailAuthWebView$1(GmailAuthWebView paramGmailAuthWebView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    GmailAuthWebView.access$502(this.this$0, true);
    this.this$0.loadUrl("http://i.mail.qq.com/app/gmail_login_notsupport.html");
    GmailAuthWebView.access$400(this.this$0).postProgressHandler(0, 100, 500);
    if (GmailAuthWebView.access$600(this.this$0) != null) {
      GmailAuthWebView.access$600(this.this$0).cancel();
    }
  }
  
  public void onTick(long paramLong)
  {
    int i = 90;
    int j = ((25 - (int)(paramLong / 1000L)) / 5 + 3) * 10;
    if (GmailAuthWebView.access$300(this.this$0).getProgress() < j) {
      if (j < 90) {
        break label79;
      }
    }
    for (;;)
    {
      if ((GmailAuthWebView.access$300(this.this$0).getProgress() != i) && (paramLong != 1L)) {
        GmailAuthWebView.access$400(this.this$0).postProgressHandler(0, i, 500);
      }
      return;
      label79:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.GmailAuthWebView.1
 * JD-Core Version:    0.7.0.1
 */