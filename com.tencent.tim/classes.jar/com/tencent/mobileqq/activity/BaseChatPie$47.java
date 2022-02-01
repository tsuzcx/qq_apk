package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Build;
import arjn;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$47
  implements Runnable
{
  BaseChatPie$47(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "recorderVolumeChange " + this.val$state);
    }
    if (this.val$state == 1) {
      if (!this.this$0.isRecording()) {
        QLog.i(this.this$0.TAG, 1, "volueme state err" + Build.MANUFACTURER + Build.MODEL);
      }
    }
    while (((this.val$state != 2) && (this.val$state != 0)) || (this.this$0.b == null) || (!this.this$0.b.isShowing()) || (this.this$0.b.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.b != null) && (this.this$0.b.isShowing()));
      this.this$0.b = new arjn(this.this$0.mContext);
      this.this$0.b.setTips(this.this$0.mContext.getString(2131700684));
      this.this$0.b.show();
      return;
    }
    this.this$0.b.dismiss();
    this.this$0.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.47
 * JD-Core Version:    0.7.0.1
 */