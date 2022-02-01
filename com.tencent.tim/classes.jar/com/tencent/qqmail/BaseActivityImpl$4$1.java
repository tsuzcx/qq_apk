package com.tencent.qqmail;

import com.tencent.qqmail.activity.setting.SettingAboutActivity;
import com.tencent.qqmail.activity.setting.SettingGestureActivity;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.QMUpdateUtil;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$4$1
  implements Runnable
{
  BaseActivityImpl$4$1(BaseActivityImpl.4 param4, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    if ((BaseActivityImpl.access$000(this.this$1.this$0).isPage(SettingGestureActivity.class)) || (BaseActivityImpl.access$000(this.this$1.this$0).isPage(WelcomeActivity.class)) || (BaseActivityImpl.access$000(this.this$1.this$0).isPage(WelcomePagesActivity.class)))
    {
      QMLog.log(4, "BaseActivityImpl", "not valid page upgrade newversion. delay trigger appUpdateWatcher:" + BaseActivityImpl.access$000(this.this$1.this$0).getClass());
      return;
    }
    if ((BaseActivityImpl.access$000(this.this$1.this$0).isPage(SettingAboutActivity.class)) && (QMPushConfigUtil.showUpgradeVersion()))
    {
      QMLog.log(4, "BaseActivityImpl", "setting about page. has new version. return.");
      return;
    }
    new QMUpdateUtil().update(BaseActivityImpl.access$000(this.this$1.this$0).getActivity(), this.val$desp, this.val$title, this.val$updateUrl, this.val$version, this.val$forceType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.4.1
 * JD-Core Version:    0.7.0.1
 */