package com.tencent.qqmail;

import com.tencent.qqmail.pushconfig.QMPushConfigDialog;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import java.util.ArrayList;

class BaseActivityImpl$20
  implements Runnable
{
  BaseActivityImpl$20(BaseActivityImpl paramBaseActivityImpl, QMPushConfigDialog paramQMPushConfigDialog) {}
  
  public void run()
  {
    String str2 = "";
    String str1 = str2;
    if (this.val$dialog.getDespLines() != null)
    {
      str1 = str2;
      if (this.val$dialog.getDespLines().size() > 0) {
        str1 = (String)this.val$dialog.getDespLines().get(0);
      }
    }
    QMPushConfigUtil.triggerAppUpdateWatcher(QMPushConfigUtil.getNewVersion(), str1, this.val$dialog.getTitle(), QMPushConfigUtil.getNewVersionUrl(), QMPushConfigUtil.getForceType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.20
 * JD-Core Version:    0.7.0.1
 */