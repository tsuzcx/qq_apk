package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class BaseChatPie$9
  implements Runnable
{
  BaseChatPie$9(BaseChatPie paramBaseChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (ChatActivityUtils.a(this.this$0.app, this.this$0.sessionInfo.cZ, this.val$uin, this.this$0.sessionInfo.phoneNum)) {
      this.this$0.mActivity.runOnUiThread(new BaseChatPie.9.1(this));
    }
    while (this.aTf) {
      return;
    }
    this.this$0.mActivity.runOnUiThread(new BaseChatPie.9.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.9
 * JD-Core Version:    0.7.0.1
 */