package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$6$1
  implements Runnable
{
  BaseActivityImpl$6$1(BaseActivityImpl.6 param6, String paramString) {}
  
  public void run()
  {
    if (QMSettingManager.sharedInstance().getRemindSecApp())
    {
      QMLog.log(4, "BaseActivityImpl", "secapp. toast to user");
      if (BaseActivityImpl.access$000(this.this$1.this$0) == null) {
        QMLog.log(5, "BaseActivityImpl", "secapp mPage null");
      }
    }
    else
    {
      return;
    }
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(BaseActivityImpl.access$000(this.this$1.this$0).getActivity()).setMessage(2131719949).addAction("不再提醒", new BaseActivityImpl.6.1.2(this))).addAction("如何开启?", new BaseActivityImpl.6.1.1(this))).create();
    DataCollector.logEvent("Event_SecApp_Alert");
    localQMUIDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.6.1
 * JD-Core Version:    0.7.0.1
 */