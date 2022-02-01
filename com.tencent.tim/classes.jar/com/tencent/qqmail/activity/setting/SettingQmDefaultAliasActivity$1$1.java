package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.observer.ICallBack;

class SettingQmDefaultAliasActivity$1$1
  implements ICallBack
{
  SettingQmDefaultAliasActivity$1$1(SettingQmDefaultAliasActivity.1 param1) {}
  
  public void callback(Object paramObject)
  {
    paramObject = QMComposeDataManager.sharedInstance().getQMDefaultAlias(SettingQmDefaultAliasActivity.access$100(this.this$1.this$0));
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        SettingQmDefaultAliasActivity.access$202(this.this$1.this$0, QMComposeDataManager.sharedInstance().getQMAlias(SettingQmDefaultAliasActivity.access$100(this.this$1.this$0)));
      } while (SettingQmDefaultAliasActivity.access$200(this.this$1.this$0) == null);
      SettingQmDefaultAliasActivity.access$302(this.this$1.this$0, SettingQmDefaultAliasActivity.access$400(this.this$1.this$0, SettingQmDefaultAliasActivity.access$200(this.this$1.this$0), paramObject));
    } while (SettingQmDefaultAliasActivity.access$300(this.this$1.this$0) == -1);
    SettingQmDefaultAliasActivity.access$500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultAliasActivity.1.1
 * JD-Core Version:    0.7.0.1
 */