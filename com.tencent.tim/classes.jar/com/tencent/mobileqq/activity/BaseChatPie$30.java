package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class BaseChatPie$30
  implements Runnable
{
  BaseChatPie$30(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.mTitleText.setText(this.this$0.sessionInfo.aTn);
    if (AppSetting.enableTalkBack)
    {
      String str = this.this$0.mTitleText.getText().toString();
      this.this$0.mTitleText.setContentDescription(str);
      this.this$0.a().setTitle(this.this$0.mTitleText.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.30
 * JD-Core Version:    0.7.0.1
 */