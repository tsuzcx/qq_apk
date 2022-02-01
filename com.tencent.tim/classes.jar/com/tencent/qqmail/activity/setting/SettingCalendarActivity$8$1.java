package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingCalendarActivity$8$1
  implements Runnable
{
  SettingCalendarActivity$8$1(SettingCalendarActivity.8 param8, Object paramObject) {}
  
  public void run()
  {
    Object localObject = (QMNetworkError)this.val$object;
    SettingCalendarActivity.access$002(this.this$1.this$0, false);
    SettingCalendarActivity.access$200(this.this$1.this$0, null, null);
    this.this$1.val$itemView.setChecked(false);
    SettingCalendarActivity.access$300(this.this$1.this$0, false);
    if (this.this$1.val$account.isQQMail())
    {
      if (((QMNetworkError)localObject).code == 5)
      {
        SettingCalendarActivity.access$1200(this.this$1.this$0, 2131691084);
        return;
      }
      if (((QMNetworkError)localObject).code == 1)
      {
        SettingCalendarActivity.access$1200(this.this$1.this$0, 2131691082);
        return;
      }
      if (((QMNetworkError)localObject).code == 4)
      {
        SettingCalendarActivity.access$1200(this.this$1.this$0, 2131691085);
        return;
      }
      if ((((QMNetworkError)localObject).code == 6) || (((QMNetworkError)localObject).code == 7))
      {
        SettingCalendarActivity.access$1200(this.this$1.this$0, 2131691083);
        return;
      }
      if (((QMNetworkError)localObject).code == 2)
      {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity()).setTitle(2131696424)).setMessage(2131689706).addAction(2131691246, new SettingCalendarActivity.8.1.2(this))).addAction(2131720003, new SettingCalendarActivity.8.1.1(this))).create().show();
        return;
      }
      SettingCalendarActivity.access$1200(this.this$1.this$0, 2131719697);
      return;
    }
    SettingCalendarFragmentActivity.flag = SettingCalendarFragmentActivity.SERVER_SETTING;
    SettingCalendarFragmentActivity.settingAccount = this.this$1.val$account;
    localObject = SettingCalendarFragmentActivity.createIntent();
    this.this$1.this$0.startActivityForResult((Intent)localObject, this.this$1.val$iIndex + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.8.1
 * JD-Core Version:    0.7.0.1
 */