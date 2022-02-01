package com.tencent.qqmail;

import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class BaseActivityImpl$2$1
  implements Runnable
{
  BaseActivityImpl$2$1(BaseActivityImpl.2 param2) {}
  
  public void run()
  {
    this.this$1.this$0.getTips().showSuccess(QMApplicationContext.sharedInstance().getString(2131718941));
    if ((BaseActivityImpl.access$000(this.this$1.this$0) != null) && ((BaseActivityImpl.access$000(this.this$1.this$0).getActivity() instanceof FtnListActivity)) && (FtnManager.sharedInstance() != null))
    {
      QMLog.log(4, "BaseActivityImpl LaunchSaveToMyFtn", "wechatFtnWatcher save success. update ftnlist");
      FtnManager.sharedInstance().getList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.2.1
 * JD-Core Version:    0.7.0.1
 */