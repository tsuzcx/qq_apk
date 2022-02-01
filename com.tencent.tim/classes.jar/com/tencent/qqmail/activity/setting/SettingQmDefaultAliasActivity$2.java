package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;

class SettingQmDefaultAliasActivity$2
  implements QMRadioGroup.OnCheckedChangeListener
{
  SettingQmDefaultAliasActivity$2(SettingQmDefaultAliasActivity paramSettingQmDefaultAliasActivity) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    SettingQmDefaultAliasActivity.access$600(this.this$0).setSelectedItem(paramInt);
    QMComposeDataManager.sharedInstance().setQMDefaultAlias(SettingQmDefaultAliasActivity.access$100(this.this$0), SettingQmDefaultAliasActivity.access$200(this.this$0)[paramInt]);
    paramQMRadioGroup = new QMCallback();
    paramQMRadioGroup.setOnSuccess(new SettingQmDefaultAliasActivity.2.1(this));
    paramQMRadioGroup.setOnError(new SettingQmDefaultAliasActivity.2.2(this));
    QMAliasManager.shareInstance().syncQMAccountDefaultAlias(SettingQmDefaultAliasActivity.access$100(this.this$0), SettingQmDefaultAliasActivity.access$200(this.this$0)[paramInt], paramQMRadioGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultAliasActivity.2
 * JD-Core Version:    0.7.0.1
 */