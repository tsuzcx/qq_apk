package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class CommonRecordSoundPanel$5
  implements Runnable
{
  CommonRecordSoundPanel$5(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.i.getWindow().clearFlags(128);
    QQToast.a(this.this$0.i, 2131690276, 1).show(this.this$0.i.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.5
 * JD-Core Version:    0.7.0.1
 */