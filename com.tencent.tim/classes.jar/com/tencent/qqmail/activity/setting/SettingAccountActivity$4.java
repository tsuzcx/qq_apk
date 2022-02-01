package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import org.apache.commons.lang3.StringUtils;

class SettingAccountActivity$4
  implements Runnable
{
  SettingAccountActivity$4(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void run()
  {
    String str2 = QMComposeDataManager.sharedInstance().getQMDefaultAlias(SettingAccountActivity.access$300(this.this$0));
    if (str2 == null) {}
    do
    {
      do
      {
        return;
        SettingAccountActivity.access$402(this.this$0, QMComposeDataManager.sharedInstance().getQMDefaultNick(SettingAccountActivity.access$300(this.this$0)));
      } while (SettingAccountActivity.access$400(this.this$0) == null);
      if (QMComposeDataManager.sharedInstance().getQMAliasIndep(str2, SettingAccountActivity.access$300(this.this$0)))
      {
        str1 = QMComposeDataManager.sharedInstance().getQMAliasNick(str2, SettingAccountActivity.access$300(this.this$0));
        if (!StringUtils.isEmpty(str1)) {
          SettingAccountActivity.access$402(this.this$0, str1);
        }
      }
    } while (this.this$0.isFinishing());
    UITableItemView localUITableItemView = SettingAccountActivity.access$500(this.this$0);
    if (SettingAccountActivity.access$400(this.this$0) == null) {}
    for (String str1 = "";; str1 = SettingAccountActivity.access$400(this.this$0))
    {
      localUITableItemView.setDetail(str1);
      SettingAccountActivity.access$800(this.this$0).setDetail(str2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.4
 * JD-Core Version:    0.7.0.1
 */