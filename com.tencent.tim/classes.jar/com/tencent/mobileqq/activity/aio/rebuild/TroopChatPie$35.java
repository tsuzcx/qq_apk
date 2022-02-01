package com.tencent.mobileqq.activity.aio.rebuild;

import acms;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class TroopChatPie$35
  implements Runnable
{
  TroopChatPie$35(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if ((this.this$0.mActivity == null) || (this.this$0.mActivity.isFinishing())) {}
    do
    {
      return;
      acms localacms = (acms)this.this$0.app.getBusinessHandler(20);
      String str = this.this$0.a().aTl;
      if (!TextUtils.isEmpty(str))
      {
        localacms.Fj(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.this$0.TAG, 2, "mGetOnlineMemberTipsRunnable, getSessionInfo().curFriendUin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.35
 * JD-Core Version:    0.7.0.1
 */