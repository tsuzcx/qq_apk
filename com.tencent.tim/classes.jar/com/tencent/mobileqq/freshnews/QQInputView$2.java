package com.tencent.mobileqq.freshnews;

import acfp;
import android.widget.ImageView;
import aurd;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$2
  implements Runnable
{
  QQInputView$2(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(8);
    QQInputView.a(this.this$0).setImageResource(2130848765);
    if (AppSetting.enableTalkBack) {
      QQInputView.a(this.this$0).setContentDescription(acfp.m(2131711809));
    }
    aurd.aO(QQInputView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.2
 * JD-Core Version:    0.7.0.1
 */