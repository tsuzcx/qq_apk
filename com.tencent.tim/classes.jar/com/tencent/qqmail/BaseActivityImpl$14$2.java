package com.tencent.qqmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import java.util.Date;

class BaseActivityImpl$14$2
  implements Runnable
{
  BaseActivityImpl$14$2(BaseActivityImpl.14 param14, int paramInt, String paramString) {}
  
  public void run()
  {
    QMLog.log(4, "BaseActivityImpl", "x qqwx accountid:" + this.val$accountId);
    SharedPreferenceUtil.setXQQWXShowLastTime(new Date().getTime());
    if (BaseActivityImpl.access$900(this.this$1.this$0) == null)
    {
      BaseActivityImpl.access$1000(this.this$1.this$0, this.val$accountId, this.val$tips);
      BaseActivityImpl.access$900(this.this$1.this$0).show();
      DataCollector.logEvent("Event_Only_Push_Mail_App_Window_Pop");
    }
    while (BaseActivityImpl.access$900(this.this$1.this$0).isShowing()) {
      return;
    }
    BaseActivityImpl.access$1000(this.this$1.this$0, this.val$accountId, this.val$tips);
    BaseActivityImpl.access$900(this.this$1.this$0).show();
    DataCollector.logEvent("Event_Only_Push_Mail_App_Window_Pop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.14.2
 * JD-Core Version:    0.7.0.1
 */