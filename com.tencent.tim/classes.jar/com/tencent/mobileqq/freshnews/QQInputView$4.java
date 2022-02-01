package com.tencent.mobileqq.freshnews;

import acfp;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$4
  implements Runnable
{
  QQInputView$4(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(0);
    QQInputView.a(this.this$0).setImageResource(2130848766);
    if (AppSetting.enableTalkBack) {
      QQInputView.a(this.this$0).setContentDescription(acfp.m(2131711810));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.4
 * JD-Core Version:    0.7.0.1
 */