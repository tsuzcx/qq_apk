package com.tencent.mobileqq.activity;

import afqr;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import ujt;

class BaseChatPie$55
  implements Runnable
{
  BaseChatPie$55(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ujt.b(this.this$0.app, this.this$0.sessionInfo, false);
    try
    {
      this.this$0.mContext.getResources().getDrawable(2130847982);
      this.this$0.mContext.getResources().getDrawable(2130847983);
      this.this$0.mContext.getResources().getDrawable(2130838105);
      afqr.cP(this.this$0.app);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.TAG, 2, "emo qvip_emoji_aio_face_new_default_fail, e=" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(this.this$0.TAG, 1, "emo qvip_emoji_aio_face oom, e= " + localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.55
 * JD-Core Version:    0.7.0.1
 */