package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class CommonRecordSoundPanel$10
  implements Runnable
{
  CommonRecordSoundPanel$10(CommonRecordSoundPanel paramCommonRecordSoundPanel, String paramString) {}
  
  public void run()
  {
    QQToast.a(CommonRecordSoundPanel.a(this.this$0).getApp(), 2131690277, 1).show(this.this$0.i.getTitleBarHeight());
    this.this$0.xB(this.val$path);
    this.this$0.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.10
 * JD-Core Version:    0.7.0.1
 */