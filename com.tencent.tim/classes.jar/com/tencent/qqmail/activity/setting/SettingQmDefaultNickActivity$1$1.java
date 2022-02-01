package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingQmDefaultNickActivity$1$1
  implements ICallBack
{
  SettingQmDefaultNickActivity$1$1(SettingQmDefaultNickActivity.1 param1) {}
  
  public void callback(Object paramObject)
  {
    paramObject = QMComposeDataManager.sharedInstance().getQMDefaultNick(SettingQmDefaultNickActivity.access$000(this.this$1.this$0).getId());
    if (paramObject == null) {
      return;
    }
    SettingQmDefaultNickActivity.access$100(this.this$1.this$0).setDetail(paramObject);
    this.this$1.this$0.refreshData();
    this.this$1.this$0.render();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity.1.1
 * JD-Core Version:    0.7.0.1
 */